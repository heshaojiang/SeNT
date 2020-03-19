#clean_database_his.sh
#!/bin/sh
. /home/feelview/sqllib/db2profile
LOGFILE=/home/feel/SeNT/shell/clean_database_his.log

echo "`date` 程序运行开始 .... ">>$LOGFILE 2>&1

#1.计算90天前的日期 凌晨跑脚本需当前日期减去 91
month=`date +%m`
day=`date +%d`
year=`date +%Y`
month=`expr $month + 0`
day=`expr $day - 91`
while [ $day -le 0 ]; do
	month=`expr $month - 1`
	if [ $month -eq 0 ]; then
		month=12
		monthday=31
		year=`expr $year - 1`
	else
		case $month in
		1|3|5|7|8|10|12) monthday=31;;
		4|6|9|11) monthday=30;;
		2)
		if [ `expr $year % 4` -eq 0 ]; then
			if [ `expr $year % 400` -eq 0 ]; then
				monthday=29
			elif [ `expr $year % 100` -eq 0 ]; then
				monthday=28
			else
				monthday=29
			fi
		else
			monthday=28
		fi
		;;
		esac
	fi
	day=`expr $day + $monthday`
done
day=`echo $day|awk '{printf "%2s\n",int($1)}'|sed 's/ /0/g' `
month=`echo $month|awk '{printf "%2s\n",int($1)}'|sed 's/ /0/g' `

monday=${month}${day}
yearmonday=${year}${monday}

echo " `date` $monday $yearmonday "

USERNAME=feelview
PASSWD=feelview
HOSTNAME=feelview

echo "`date` 清除90天前数据 begin ">>$LOGFILE 2>&1
db2 "connect to ${HOSTNAME} user ${USERNAME} using ${PASSWD}"
#清分交易信息表
db2 "alter table CML_TASK_INFOS detach partition P_$monday into T_TASK_INFOS "
sleep 1
db2 "alter table CML_TASK_INFOS add partition P_$monday starting '$monday' ending '$monday' "

#ATM交易信息表
db2 "alter table ATM_TRAN_INFO detach partition P_$monday into T_TRAN_INFO "
sleep 1
db2 "alter table ATM_TRAN_INFO add partition P_$monday starting '$monday' ending '$monday' "

#柜台交易表
db2 "alter table CML_COUNTER_RECORD detach partition P_$monday into T_COUNTER_RECORD "
sleep 1
db2 "alter table CML_COUNTER_RECORD add partition P_$monday starting '$monday' ending '$monday' "

#加钞交易表
db2 "alter table CML_LOAD_NOTES_RECORD detach partition P_$monday into T_LOAD_NOTES_RECORD "
sleep 1
db2 "alter table CML_LOAD_NOTES_RECORD add partition P_$monday starting '$monday' ending '$monday' "

#冠字号码导入记录表
db2 "alter table CML_IMP_RECORDS detach partition P_$monday into T_IMP_RECORDS "
sleep 1
db2 "alter table CML_IMP_RECORDS add partition P_$monday starting '$monday' ending '$monday' "

#清空日表数据
db2 "IMPORT FROM /dev/null OF DEL REPLACE INTO CML_SENT_INFOS_HIS_$monday "

#删除临时表
db2 "drop table T_TASK_INFOS "
db2 "drop table T_TRAN_INFO "
db2 "drop table T_COUNTER_RECORD "
db2 "drop table T_LOAD_NOTES_RECORD "
db2 "drop table T_IMP_RECORDS "

#删除流转数据
db2 " DELETE FROM  CML_NOTEFLOW_INFO WHERE C_CLEARING_DATE < '$yearmonday' "
db2 " commit "
db2 " DELETE FROM  CML_NOTEFLOW_INFO WHERE C_CLEARING_DATE < '$yearmonday' "
db2 " commit "
db2 "connect reset"
echo "`date` 程序运行结束 !!!! ">>$LOGFILE 2>&1
exit 0

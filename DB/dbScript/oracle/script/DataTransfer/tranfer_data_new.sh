#!/bin/sh 
cd
. ./.bash_profile
LOGFILE=${HOME}/SeNT/tranfer_data_new.log

echo "`date` �������п�ʼ $1 .... ">>$LOGFILE 2>&1

#1.������
if [ $# -ne 1 ] ; then
	echo "�÷�: tranfer_data_new.sh ������� " >>$LOGFILE 2>&1
	echo "����: tranfer_data_new.sh 5 " >>$LOGFILE 2>&1
  exit -1
fi

procnum=`ps -ef | grep $0 | grep -v grep | wc -l`
if [ $procnum -gt 2 ] ; then
	echo "$0 is exists $procnum ">> $LOGFILE 2>&1
  exit -1
fi
	
	
#2.��ǰ������
minitue=`date +%M`
minitue=`expr $minitue + 0`

USERNAME=gzhuser
PASSWD=gzhuser123
HOSTNAME=128.160.11.69/gzhdb
/home/feel/oracle/lib/./sqlplus -s $USERNAME/$PASSWD@$HOSTNAME <<EOF >>$LOGFILE 2>&1
	EXEC SP_TRANSFER_BUSIDATE($minitue, $1);
EOF

echo "`date` �������н��� $1 !!! ">>$LOGFILE 2>&1
echo "" >>$LOGFILE 2>&1
echo "" >>$LOGFILE 2>&1

exit 0
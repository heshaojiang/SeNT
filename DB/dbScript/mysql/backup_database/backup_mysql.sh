#!/bin/sh
export DUMP=/usr/local/mysql/bin/mysqldump
export OUT_DIR=/home/feel/wncheng/database_backup
# LINUX_USER=liheyuan

export DB_NAME=feelview
export DB_USER=feelview
export DB_PASS=feelview
#How much days backup most
export DAYS=7

# Core of script
cd ${OUT_DIR}
export DATE=`date +%Y%m%d`
export OUT_SQL=${DATE}.sql
export TAR_SQL=mysql_${DATE}.tar.gz
# /usr/local/mysql/bin/mysqldump --default-character-set=utf8 --opt -ufeelview -pfeelview feelview > 1.sql
${DUMP} --default-character-set=utf8 --opt -u${DB_USER} -p${DB_PASS} ${DB_NAME} > ${OUT_SQL}
tar -czf ${TAR_SQL} ./${OUT_SQL}
rm ${OUT_SQL}
chown feel:feel ./${TAR_SQL}
find ./ -name "mysql*" -type f -mtime +${DAYS} -exec rm {} \;
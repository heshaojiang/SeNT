#!/bin/sh

export PATH_PREX=BAK
export CURR_DATE=`date '+%Y%m%d'`
echo ${CURR_DATE}
export HIS_DATE=`date -d "-7 day" +%Y%m%d`
echo ${HIS_DATE}
cd /home/oracle/database_backup
pwd
rm -rf ${PATH_PREX}_${HIS_DATE}
mkdir ${PATH_PREX}_${CURR_DATE}
cd ${PATH_PREX}_${CURR_DATE}

export FILENAME_DATETIME=`date '+%Y%m%d%H%M%S'`
exp feelview/feelview owner=feelview rows=y indexes=n compress=n buffer=65536 feedback=100000 volsize=0 file=exp_feelview_${FILENAME_DATETIME}.dmp log=exp_feelview_${FILENAME_DATETIME}.log /dev/null 2>&1
cd ..


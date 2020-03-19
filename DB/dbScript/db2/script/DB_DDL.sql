create table ATM_TRAN_INFO  (
   C_ID                 VARCHAR(32)                    not null,
   C_TRAN_CODE          VARCHAR(8),
   C_TRAN_ORGID         VARCHAR(32),
   C_TERM_ID            VARCHAR(32),
   I_STATIS_AMT         NUMERIC(20),
   C_TRAN_TIME          VARCHAR(20),
   C_TRAN_RESULT        VARCHAR(4),
   I_TRAN_COUNT         NUMERIC(22),
   I_BLACK_COUNT        NUMERIC(22),
   I_REPEAT_COUNT       NUMERIC(22),
   I_CALLBACK_COUNT     NUMERIC(22),
   C_UPLOAD_STATUS      VARCHAR(2),
   C_TRAN_DATE          VARCHAR(8),
   C_PART_MONTHDAY      VARCHAR(4),
   C_PATHCODE           VARCHAR(64),
   C_RESERVE1           VARCHAR(32),
   C_TD_ACCOUNT_NO      VARCHAR(32),
   C_TD_JOURNAL_NO      VARCHAR(32),
   I_TD_TRAN_AMT        NUMERIC(20),
   C_TD_RESERVE         VARCHAR(32),
   primary key (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create index I_ATM_TRAN_INFO_INDEX on ATM_TRAN_INFO (
   C_TERM_ID ASC,
   C_TD_ACCOUNT_NO ASC,
   C_TRAN_DATE ASC,
   C_PATHCODE ASC
);


create table RULE_BLACKLIST  (
   C_ID                 VARCHAR(32)                    not null,
   C_APPLY_ID           VARCHAR(32),
   C_APPLY_ORGID        VARCHAR(32),
   D_APPLY_DATE         TIMESTAMP,
   I_RULE_TYPE          INTEGER,
   I_RULE_STATUS        INTEGER,
   C_NOTE_TYPE          VARCHAR(4),
   C_DENOMINATION       VARCHAR(4),
   C_SERIAL_NO          VARCHAR(32),
   D_AUDIT_DATE         TIMESTAMP,
   C_AUDIT_ID           VARCHAR(32),
   C_REJECT_REASON      VARCHAR(256),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create table RULE_BLACKLIST_DELIVER  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERM_ID            VARCHAR(32),
   C_RULE_VERSION       VARCHAR(32),
   I_STATUS             INTEGER,
   D_CREATE_DATE        TIMESTAMP,
   C_OPERATOR_NO        VARCHAR(32),
   D_DELIVER_DATE       TIMESTAMP,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: BOX_INFO                                              */
/*==============================================================*/
create table BOX_INFO  (
   C_ID                 VARCHAR(32)                    not null,
   C_BOX_NUM            VARCHAR(32)                    not null,
   C_ORGID              VARCHAR(32),
   C_BOX_STATUS         VARCHAR(20),
   C_BOX_ATM            VARCHAR(64),
   C_ATM_BOXTYPE        VARCHAR(20),
   C_USAGE_STATUS       VARCHAR(5)                    default '0',
   C_TYPE               VARCHAR(2)                    default '0',
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";



/*==============================================================*/
/* Table: BRAND                                                 */
/*==============================================================*/
create table BRAND  (
   C_ID                 VARCHAR(32)                    not null,
   C_BRANDNAME          VARCHAR(64)                    not null,
   C_FACTNAME           VARCHAR(256)                   not null,
   C_FACTADDRESS        VARCHAR(512),
   C_STATUS             CHAR(1)                         not null,
   C_CODE               VARCHAR(2),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Table: CARD_INFO                                             */
/*==============================================================*/
create table CARD_INFO  (
   C_ID                 VARCHAR(32)                    not null,
   C_CARDMARK           VARCHAR(128)                   not null,
   C_CARDNAME           VARCHAR(200)                   not null,
   C_BANKCODE           VARCHAR(64)                    not null,
   C_BANKNAME           VARCHAR(200)                   not null,
   I_IDLENGTH           NUMERIC(22)                      not null,
   I_LENGTH             NUMERIC(22)                      not null,
   C_APPLYATM           CHAR(1)                         not null,
   C_APPLYPOS           CHAR(1)                         not null,
   C_CARDTYPE           VARCHAR(32)                    not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_CARD_INFO_BANKID                                  */
/*==============================================================*/
create index IDX_CARD_INFO_BANKID on CARD_INFO (
   C_BANKCODE ASC
);

/*==============================================================*/
/* Index: IDX_CARD_INFO_CARDID                                  */
/*==============================================================*/
create index IDX_CARD_INFO_CARDID on CARD_INFO (
   C_CARDMARK ASC
);


/*==============================================================*/
/* Table: CARD_TYPE                                             */
/*==============================================================*/
create table CARD_TYPE  (
   C_ID                 VARCHAR(32)                    not null,
   C_ORGID              VARCHAR(64),
   C_CARDMARK           VARCHAR(64),
   C_SELF               VARCHAR(2000)                  not null,
   C_PROVINCE           VARCHAR(2000)                  not null,
   C_LOCAL              VARCHAR(2000)                  not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_CARD_TYPE_CARDID                                  */
/*==============================================================*/
create index IDX_CARD_TYPE_CARDID on CARD_TYPE (
   C_CARDMARK ASC
);

/*==============================================================*/
/* Index: IDX_CARD_TYPE_ORGID                                   */
/*==============================================================*/
create index IDX_CARD_TYPE_ORGID on CARD_TYPE (
   C_ORGID ASC
);

/*==============================================================*/
/* Table: CML_CONNECT_INFOS                                     */
/*==============================================================*/
create table CML_CONNECT_INFOS  (
   C_ID                 VARCHAR(32)                    not null,
   C_CONN_NUM           VARCHAR(40),
   I_CONN_MONEY         INTEGER,
   C_COME_ORG           VARCHAR(32),
   C_TO_ORG             VARCHAR(32),
   C_OUT_PERSON         VARCHAR(50),
   C_IN_PERSON          VARCHAR(50),
   D_CONN_DATE          TIMESTAMP,
   D_OPERATE_DATE       TIMESTAMP,
   C_OPERATOR_ID        VARCHAR(32),
   I_MONEYBOX_COUNT     INTEGER,
   C_FLAG               VARCHAR(2),
   C_CONN_APPEAL        VARCHAR(200),
   I_NO_ALLOT_MONEY     INTEGER,
   C_CONN_MEMO          VARCHAR(200),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Table: CML_IMP_RECORDS                                       */
/*==============================================================*/
create table CML_IMP_RECORDS  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERM_ID            VARCHAR(32),
   C_JOURNO             VARCHAR(32),
   C_OPERATER_DATE      VARCHAR(16),
   C_FILE_NAME          VARCHAR(255),
   C_OPERATER_ID        VARCHAR(32),
   C_OPERATE_STATUS     VARCHAR(2),
   C_SERIAIMG_FLAG      VARCHAR(8),
   I_SERIA_NUM          INTEGER,
   I_RESOVIMP_RECORDS   INTEGER,
   C_TRAN_DATE		VARCHAR(8),
   C_PART_MONTHDAY      VARCHAR(4),
   C_PATHCODE           VARCHAR(64),
   C_OLDFILE_NAME       VARCHAR(255),
   primary key (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IND_CML_IMP_RECORDS                                   */
/*==============================================================*/
create index IND_CML_IMP_RECORDS on CML_IMP_RECORDS (
   C_TERM_ID ASC,
   C_OPERATER_DATE ASC,
   C_PATHCODE ASC
);
create index IND2_CML_IMP_RECORDS on CML_IMP_RECORDS (
   C_FILE_NAME
);

/*==============================================================*/
/* Table: CML_NOTEFLOW_DETAIL_INFO                              */
/*==============================================================*/
create table CML_NOTEFLOW_DETAIL_INFO  (
   C_ID                 VARCHAR(32)                    not null,
   C_BARCODE_FLOWNUM    VARCHAR(32),
   C_BARCODE1           VARCHAR(32),
   C_BARCODE2           VARCHAR(32),
   C_FLOW_STAGE         VARCHAR(5),
   C_STATUS             VARCHAR(2),
   C_OPERATOR           VARCHAR(32),
   C_DATE               VARCHAR(16),
   C_RECEIVE_PATHCODE   VARCHAR(64),
   C_PATHCODE           VARCHAR(64),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

--create index I1_CML_NOTEFLOW_DETAIL_INFO on CML_NOTEFLOW_DETAIL_INFO (c_date desc);

/*==============================================================*/
/* Table: CML_NOTEFLOW_INFO                                     */
/*==============================================================*/
create table CML_NOTEFLOW_INFO  (
   C_ID                     VARCHAR(32)                    not null,
   C_JOURNAL_NO             VARCHAR(32),
   C_TERM_ID                VARCHAR(32),
   C_CLEARING_DATE          VARCHAR(16),
   C_NOTE_TYPE              VARCHAR(2),
   C_BARCODE_STATUS         VARCHAR(2),
   I_NOTECOUNT              NUMERIC(8),
   I_STATIS_AMT             NUMERIC(20),
   C_FLOW_STAGE             VARCHAR(5),
   C_TRAN_DATE              VARCHAR(8),
   C_PART_MONTHDAY          VARCHAR(4),
   C_PATHCODE               VARCHAR(64),
   C_TD_BARCODE_FLOWNUM     VARCHAR(32)                    not null,
   C_TD_OPERATOR_ID	    VARCHAR(32),
   C_TD_RESERVE             VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IU_NOTEFLOW_INFO_1                                    */
/*==============================================================*/
create unique index IU_NOTEFLOW_INFO_1 on CML_NOTEFLOW_INFO (
   C_TD_BARCODE_FLOWNUM ASC
);


/*==============================================================*/
/* Table: CML_TASK_INFOS                                        */
/*==============================================================*/
create table CML_TASK_INFOS  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERM_ID            VARCHAR(32),
   I_BEFORE_AMT         NUMERIC(20),
   D_BIND_START         TIMESTAMP,
   D_BIND_END           TIMESTAMP,
   C_JOURNAL_NO         VARCHAR(32),
   I_STATIS_AMT         NUMERIC(20),
   I_TRAN_COUNT         NUMERIC(8),
   C_TRAN_RESULT        VARCHAR(2),
   C_ROTOCASH_TYPE      VARCHAR(2),
   C_UPLOAD_FLAG        VARCHAR(2),
   C_TRAN_DATE		VARCHAR(8),
   C_PART_MONTHDAY      VARCHAR(4),
   C_PATHCODE           VARCHAR(64),
   C_RESERVE1           VARCHAR(32),
   C_TD_SOURCE_ORGID	VARCHAR(32),
   C_TD_DEST_ORGID      VARCHAR(32),
   C_TD_OPERATOR_ID     VARCHAR(32),
   C_TD_RESERVE         VARCHAR(32),
   primary key (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IND_CML_TASK_INFO                                     */
/*==============================================================*/
create index IND_CML_TASK_INFO on CML_TASK_INFOS (
   C_TERM_ID ASC,
   D_BIND_START ASC,
   C_PATHCODE ASC
);

/*==============================================================*/
/* Table: MENU_BUTTON                                           */
/*==============================================================*/
create table MENU_BUTTON  (
   C_ID                 VARCHAR(32)                    not null,
   C_NOTE_EN            VARCHAR(200),
   C_BUTTONTYPE         VARCHAR(20),
   I_ORDER              NUMERIC(22),
   C_SUBSYSTEM          VARCHAR(32),
   C_ICONURL            VARCHAR(400),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_BUTTON_TYPE                                       */
/*==============================================================*/
create index IDX_BUTTON_TYPE on MENU_BUTTON (
   C_BUTTONTYPE ASC
);

/*==============================================================*/
/* Table: MENU_INFO                                             */
/*==============================================================*/
create table MENU_INFO  (
   C_ID                 VARCHAR(32)                    not null,
   C_MENUURL            VARCHAR(400),
   C_PARENTID           VARCHAR(64),
   I_ORDER              NUMERIC(22),
   C_ICONURL            VARCHAR(400),
   C_LEVEL              VARCHAR(200),
   C_ROOTURL            VARCHAR(200),
   C_NOTE               VARCHAR(400),
   C_VISIBLE            VARCHAR(1),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_MENUINFO_PARENTID                                 */
/*==============================================================*/
create index IDX_MENUINFO_PARENTID on MENU_INFO (
   C_PARENTID ASC
);



/*==============================================================*/
/* Table: ORG_AREA                                              */
/*==============================================================*/
create table ORG_AREA  (
   C_ID                 VARCHAR(64)                    not null,
   C_PARENTID           VARCHAR(64),
   C_NAME               VARCHAR(400),
   I_ORDER              NUMERIC(22),
   C_NOTE               VARCHAR(200),
   C_LEVEL              VARCHAR(200),
   C_STATUS             CHAR(1),
   F1                   VARCHAR(100),
   F2                   VARCHAR(100),
   F3                   VARCHAR(100),
   F4                   VARCHAR(500),
   F5                   VARCHAR(1000),
   C_SHORTNAME          VARCHAR(50),
   C_PATHCODE           VARCHAR(64),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_AREA_LEVEL                                        */
/*==============================================================*/
create index IDX_AREA_LEVEL on ORG_AREA (
   C_LEVEL ASC
);

/*==============================================================*/
/* Index: IDX_AREA_PARENTID                                     */
/*==============================================================*/
create index IDX_AREA_PARENTID on ORG_AREA (
   C_PARENTID ASC
);

/*==============================================================*/
/* Index: IDX_AREA_STATUS                                       */
/*==============================================================*/
create index IDX_AREA_STATUS on ORG_AREA (
   C_STATUS ASC
);


/*==============================================================*/
/* Table: ORG_INFO                                              */
/*==============================================================*/
create table ORG_INFO  (
   C_ID                 VARCHAR(64)                    not null,
   C_PARENTID           VARCHAR(64),
   C_ORGNAME            VARCHAR(200),
   C_ORGFULLNAME        VARCHAR(400),
   C_FINACIALCODE       VARCHAR(64),
   C_CONTACT            VARCHAR(128),
   C_TEL                VARCHAR(100),
   C_ADDRESS            VARCHAR(400),
   C_STATUS             CHAR(1)                         not null,
   C_LEVEL              VARCHAR(64),
   C_ORGCODE            VARCHAR(64),
   I_ORDER              NUMERIC(22),
   C_PATHCODE           VARCHAR(64),
   C_LOANPAN            VARCHAR(50),
   C_LONGPAN            VARCHAR(50),
   C_SHORTPAN           VARCHAR(50),
   C_BORROWPAN          VARCHAR(50),
   F1                   VARCHAR(100),
   F2                   VARCHAR(100),
   F3                   VARCHAR(100),
   F4                   VARCHAR(100),		--500->100
   F5                   VARCHAR(200), --1000->200
   C_NOTE               VARCHAR(400),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_ORGINFO_LEVEL                                     */
/*==============================================================*/
create index IDX_ORGINFO_LEVEL on ORG_INFO (
   C_LEVEL ASC
);

/*==============================================================*/
/* Index: IDX_ORGINFO_PARENTID                                  */
/*==============================================================*/
create index IDX_ORGINFO_PARENTID on ORG_INFO (
   C_PARENTID ASC
);

/*==============================================================*/
/* Index: IDX_ORGINFO_STATUS                                    */
/*==============================================================*/
create index IDX_ORGINFO_STATUS on ORG_INFO (
   C_STATUS ASC
);


/*==============================================================*/
/* Table: PEOPLE                                                */
/*==============================================================*/
create table PEOPLE  (
   GID                  VARCHAR(100),
   NAME                 VARCHAR(100),
   AGE                  NUMERIC(4),
   TELPHONE             NUMERIC(11),
   C_ID                 VARCHAR(32)                    not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: SYS_DATADIR                                           */
/*==============================================================*/
create table SYS_DATADIR(
   C_ID                 VARCHAR(32)                    not null,
   C_PARENTID           VARCHAR(32)                    not null,
   C_KEY                VARCHAR(64)                    not null,
   I_ORDER              NUMERIC(22)                    not null,
   C_NOTE_EN            VARCHAR(200),
   C_STATUS             VARCHAR(4)                     not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_DATADIR_PARENTID                                  */
/*==============================================================*/
create index IDX_DATADIR_PARENTID on SYS_DATADIR (
   C_PARENTID ASC
);


/*==============================================================*/
/* Table: SYS_EXTEND_PROPERTY                                   */
/*==============================================================*/
create table SYS_EXTEND_PROPERTY  (
   C_ID                 VARCHAR(32)                    not null,
   C_TABLE              VARCHAR(20),
   C_PROPERTY_NAME      VARCHAR(20),
   C_FIELD_NAME         VARCHAR(20),
   C_ENTITYCLASS_PROPERTY VARCHAR(20),
   C_INPUT_TYPE         VARCHAR(50),
   C_METHOD             VARCHAR(100),
   C_PARAM_DATATYPE     VARCHAR(200),
   C_CHECK_TYPE         VARCHAR(50),
   C_INPUT_RESTRICT     VARCHAR(100),
   C_REQUIRED           CHAR(1),
   I_MAX                NUMERIC(22),
   I_MIN                NUMERIC(22),
   C_STATUS             CHAR(1),
   I_ORDER              NUMERIC(22),
   C_NOTE               VARCHAR(200),
   C_LISTDISPLAY        CHAR(1),
   C_SERVICE            VARCHAR(100),
   C_KEY                VARCHAR(100),
   C_LABEL              VARCHAR(100),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: SYS_I18N                                              */
/*==============================================================*/
create table SYS_I18N  (
   C_ID                 VARCHAR(32)                    not null,
   C_LANGUAGE           VARCHAR(64),
   C_NAME               VARCHAR(128),
   C_REFERENCEID        VARCHAR(64),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Table: SYS_LOGIN_LOG                                         */
/*==============================================================*/
create table SYS_LOGIN_LOG  (
   C_ID                 VARCHAR(32)                    not null,
   C_USERCODE           VARCHAR(64)                    not null,
   C_USERNAME           VARCHAR(64),
   C_HOST_IP            VARCHAR(64)                    not null,
   D_LOGINTIME          TIMESTAMP                      not null,
   D_LOGOUTTIME         TIMESTAMP,
   C_NOTE               VARCHAR(512),
   C_RESULT             VARCHAR(16)                    not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Index: IDX_SYS_LOGINLOG_RESULT                               */
/*==============================================================*/
create index IDX_SYS_LOGINLOG_RESULT on SYS_LOGIN_LOG (
   C_RESULT ASC
);

/*==============================================================*/
/* Index: IDX_SYS_LOGINLOG_USERID                               */
/*==============================================================*/
create index IDX_SYS_LOGINLOG_USERID on SYS_LOGIN_LOG (
   C_USERCODE ASC
);

/*==============================================================*/
/* Table: SYS_MODULE                                            */
/*==============================================================*/
create table SYS_MODULE  (
   C_ID                 VARCHAR(32)                    not null,
   C_STATUS             CHAR(1),
   C_MENU_ID            VARCHAR(32)                    not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: SYS_MODULE_FUNCTION                                   */
/*==============================================================*/
create table SYS_MODULE_FUNCTION  (
   C_ID                 VARCHAR(32)                    not null,
   C_MODULE_ID          VARCHAR(32)                    not null,
   C_MENU_ID            VARCHAR(32)                    not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: SYS_OPER_LOG                                          */
/*==============================================================*/
create table SYS_OPER_LOG  (
   C_ID                 VARCHAR(32)                    not null,
   C_USERCODE           VARCHAR(64)                    not null,
   C_USERNAME           VARCHAR(64)                    not null,
   C_HOST_IP            VARCHAR(64)                    not null,
   D_LOGTIME            TIMESTAMP                      not null,
   C_MENUNAME           VARCHAR(64)                    not null,
   C_OPERNAME           VARCHAR(64),
   C_NOTE               VARCHAR(512),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Index: IDX_SYS_OPER_LOG_USERID                               */
/*==============================================================*/
create index IDX_SYS_OPER_LOG_USERID on SYS_OPER_LOG (
   C_USERCODE ASC
);

/*==============================================================*/
/* Table: SYS_PARAM                                             */
/*==============================================================*/
create table SYS_PARAM  (
   C_ID                 VARCHAR(32)                    not null,
   C_PARENTID           VARCHAR(32)                    not null,
   C_KEY                VARCHAR(64)                    not null,
   C_NOTE               VARCHAR(200),
   C_STATUS             CHAR(1)                         not null,
   C_VALUE              VARCHAR(256)                   not null,
   C_ENCRYPT_STATUS     CHAR(1),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Index: IDX_SYS_PARAM_KEY                                     */
/*==============================================================*/
create index IDX_SYS_PARAM_KEY on SYS_PARAM (
   C_KEY ASC
);

/*==============================================================*/
/* Index: IDX_SYS_PARAM_PARENTID                                */
/*==============================================================*/
create index IDX_SYS_PARAM_PARENTID on SYS_PARAM (
   C_PARENTID ASC
);

/*==============================================================*/
/* Table: SYS_SERVICE_LOG                                       */
/*==============================================================*/
create table SYS_SERVICE_LOG  (
   C_ID                 VARCHAR(32)                    not null,
   C_PROCESSNAME        VARCHAR(256),
   C_SERVICENAME        VARCHAR(256),
   C_PROCESSCLASS       VARCHAR(256),
   C_SERVICECLASS       VARCHAR(256),
   C_ERROR              VARCHAR(2048),
   D_MODIFYDATE         TIMESTAMP,
   C_IP                 VARCHAR(100),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: SYS_SUBSYSTEM                                         */
/*==============================================================*/
create table SYS_SUBSYSTEM  (
   C_ID                 VARCHAR(32)                    not null,
   C_SYS_CODE           VARCHAR(50),
   C_SYS_NAME           VARCHAR(200),
   C_STATUS             CHAR(1),
   C_MAIN_VERSION       VARCHAR(50),
   C_BUILD_VERSION      VARCHAR(20),
   C_NOTE               VARCHAR(200),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Table: SYS_USER_FUNCTION                                     */
/*==============================================================*/
create table SYS_USER_FUNCTION  (
   C_ID                 VARCHAR(32)                    not null,
   C_USER_MODULE_ID     VARCHAR(32)                    not null,
   C_MENU_ID            VARCHAR(32)                    not null,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: SYS_USER_MODULE                                       */
/*==============================================================*/
create table SYS_USER_MODULE  (
   C_ID                 VARCHAR(32)                    not null,
   C_MODULE_ID          VARCHAR(32)                    not null,
   C_USERID             VARCHAR(32),
   I_ORDER              NUMERIC(22),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: TML_BRAND                                             */
/*==============================================================*/
create table TML_BRAND  (
   C_ID                 VARCHAR(32)                    not null,
   C_BRANDNAME          VARCHAR(64)                    not null,
   C_FACTNAME           VARCHAR(256)                   not null,
   C_FACTADDRESS        VARCHAR(512),
   C_STATUS             CHAR(1)                         not null,
   C_CODE               VARCHAR(2),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_TML_BRAND_BRANDNAME                               */
/*==============================================================*/
create index IDX_TML_BRAND_BRANDNAME on TML_BRAND (
   C_BRANDNAME ASC
);


/*==============================================================*/
/* Table: TML_INFO                                              */
/*==============================================================*/
create table TML_INFO  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERMCODE           VARCHAR(64)                    not null,
   C_TERMSEQ            VARCHAR(100),
   C_COUNTERCODE        VARCHAR(100),
   C_TERMTYPE           VARCHAR(32),
   C_BRAND              VARCHAR(32),
   C_MODEL              VARCHAR(100),
   C_ORGID              VARCHAR(32),
   C_AREAID             VARCHAR(32),
   C_NETADDR            VARCHAR(64),
   I_NETPORT            NUMERIC(22),
   I_SAVEBOX            NUMERIC(22),
   I_CWDBOX             NUMERIC(22),
   D_INST_DATE          TIMESTAMP,
   D_ACTIVE_DATE        TIMESTAMP,
   D_SERV_STARTDATE     TIMESTAMP,
   D_SERV_ENDDATE       TIMESTAMP,
   I_SERV_YEARS         NUMERIC(22),
   C_TERMADDR           VARCHAR(400),
   C_SERVICETYPE        VARCHAR(64),
   C_INST_TYPE          VARCHAR(64),
   C_LAY_TYPE           VARCHAR(64),
   C_ISVIDEOWATCH       CHAR(1),
   C_ISUPS              CHAR(1),
   C_ISINTERATM         CHAR(1),
   C_BUSIBEGINTIME      VARCHAR(20),
   C_BUSIENDTIME        VARCHAR(20),
   C_SOFTVERSION        VARCHAR(100),
   C_SPVERSION          VARCHAR(100),
   C_TERMNAME           VARCHAR(100),
   C_CONNSERVER         VARCHAR(100),
   C_CONNPROTOCOL       VARCHAR(10),
   C_CONNLINE           VARCHAR(100),
   C_VIP                CHAR(1),
   C_INTERVENTIONLEVEL  VARCHAR(2),
   C_POST               VARCHAR(100),
   I_X                  NUMERIC(22),
   I_Y                  NUMERIC(22),
   C_STATUS             CHAR(1),
   I_CASHLACKNUM        NUMERIC(22),
   I_CASHFULLNUM        NUMERIC(22),
   C_SECONE_PORT        VARCHAR(100),
   C_F1                 VARCHAR(100),
   C_F2                 VARCHAR(100),
   C_F3                 VARCHAR(100),
   C_F4                 VARCHAR(100),
   C_F5                 VARCHAR(100),
   C_F6                 VARCHAR(100),
   C_F7                 VARCHAR(100),
   C_F8                 VARCHAR(100),
   C_F9                 VARCHAR(100), --500 -> 100
   C_F10                VARCHAR(200),--1000 -> 200
   I_COINCASHLACKNUM    NUMERIC(22),
   I_COINCASHFULLNUM    NUMERIC(22),
   C_MACHINE_TYPE       varchar(20),
   C_RUNNING_STATUS	varchar(20),
   C_STATUS_TIME	TIMESTAMP,
   C_INFO_VERSION	varchar(32),
   C_PARAMETER		varchar(1024),
   C_DEVICE		varchar(1024),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_TML_INFO_TERMCODE                                 */
/*==============================================================*/
create unique index IDX_TML_INFO_TERMCODE on TML_INFO (
   C_TERMCODE ASC
);
/*==============================================================*/
/* Index: IDX_TML_INFO_BRAND                                    */
/*==============================================================*/
create index IDX_TML_INFO_BRAND on TML_INFO (
   C_BRAND ASC
);

/*==============================================================*/
/* Index: IDX_TML_INFO_LAYTYPE                                  */
/*==============================================================*/
create index IDX_TML_INFO_LAYTYPE on TML_INFO (
   C_LAY_TYPE ASC
);

/*==============================================================*/
/* Index: IDX_TML_INFO_MODEL                                    */
/*==============================================================*/
create index IDX_TML_INFO_MODEL on TML_INFO (
   C_MODEL ASC
);

/*==============================================================*/
/* Index: IDX_TML_INFO_ORGID                                    */
/*==============================================================*/
create index IDX_TML_INFO_ORGID on TML_INFO (
   C_ORGID ASC
);

/*==============================================================*/
/* Index: IDX_TML_INFO_TERMTYPE                                 */
/*==============================================================*/
create index IDX_TML_INFO_TERMTYPE on TML_INFO (
   C_TERMTYPE ASC
);

/*==============================================================*/
/* Table: TML_MODEL                                             */
/*==============================================================*/
create table TML_MODEL  (
   C_ID                 VARCHAR(32)                    not null,
   C_MODELNAME          VARCHAR(64)                    not null,
   C_BRANDID            VARCHAR(64)                    not null,
   C_TYPEID             VARCHAR(64)                    not null,
   C_STATUS             CHAR(1)                         not null,
   C_JOURNAL_PATH       VARCHAR(200),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_TML_MODEL_BRANDID                                 */
/*==============================================================*/
create index IDX_TML_MODEL_BRANDID on TML_MODEL (
   C_BRANDID ASC
);

/*==============================================================*/
/* Index: IDX_TML_MODEL_TYPEID                                  */
/*==============================================================*/
create index IDX_TML_MODEL_TYPEID on TML_MODEL (
   C_TYPEID ASC
);

/*==============================================================*/
/* Table: TML_TYPE                                              */
/*==============================================================*/
create table TML_TYPE  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERMTYPE           VARCHAR(40)                    not null,
   C_TYPENAME           VARCHAR(100)                   not null,
   C_STATUS             CHAR(1)                         not null,
   C_CODE               VARCHAR(2),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Index: IDX_TML_TYPE_TERMTYPE                                 */
/*==============================================================*/
create index IDX_TML_TYPE_TERMTYPE on TML_TYPE (
   C_TERMTYPE ASC
);


/*==============================================================*/
/* Table: USR_GROUP                                             */
/*==============================================================*/
create table USR_GROUP  (
   C_ID                 VARCHAR(32)                    not null,
   C_GRPNAME            VARCHAR(100),
   C_GRPNOTE            VARCHAR(200),
   C_STATUS             VARCHAR(2),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: USR_GRPROLE                                           */
/*==============================================================*/
create table USR_GRPROLE  (
   C_ID                 VARCHAR(32)                    not null,
   C_GRPID              VARCHAR(32),
   C_ROLEID             VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_GRPROLE_GRPID                                     */
/*==============================================================*/
create index IDX_GRPROLE_GRPID on USR_GRPROLE (
   C_GRPID ASC
);

/*==============================================================*/
/* Index: IDX_GRPROLE_ROLEID                                    */
/*==============================================================*/
create index IDX_GRPROLE_ROLEID on USR_GRPROLE (
   C_ROLEID ASC
);


/*==============================================================*/
/* Table: USR_MENU_LOG                                          */
/*==============================================================*/
create table USR_MENU_LOG  (
   C_ID                 VARCHAR(32)                    not null,
   C_USERID             VARCHAR(32)                    not null,
   C_MENU_ID            VARCHAR(32)                    not null,
   I_CLICKED_COUNT      NUMERIC(22),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


/*==============================================================*/
/* Table: USR_PRIVILEGE                                         */
/*==============================================================*/
create table USR_PRIVILEGE  (
   C_ID                 VARCHAR(32)                    not null,
   C_MENUID             VARCHAR(32),
   C_BUTTONID           VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Table: USR_ROLE                                              */
/*==============================================================*/
create table USR_ROLE  (
   C_ID                 VARCHAR(32)                    not null,
   C_ROLENAME           VARCHAR(100),
   C_ROLELEVEL          VARCHAR(200),
   C_STATUS             VARCHAR(2),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_ROLE_STATUS                                       */
/*==============================================================*/
create index IDX_ROLE_STATUS on USR_ROLE (
   C_STATUS ASC
);


/*==============================================================*/
/* Table: USR_ROLEPRIVI                                         */
/*==============================================================*/
create table USR_ROLEPRIVI  (
   C_ID                 VARCHAR(32)                    not null,
   C_ROLEID             VARCHAR(32),
   C_PRIVIID            VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_ROLEPRIVI_PRIVIID                                 */
/*==============================================================*/
create index IDX_ROLEPRIVI_PRIVIID on USR_ROLEPRIVI (
   C_PRIVIID ASC
);

/*==============================================================*/
/* Index: IDX_ROLEPRIVI_ROLEID                                  */
/*==============================================================*/
create index IDX_ROLEPRIVI_ROLEID on USR_ROLEPRIVI (
   C_ROLEID ASC
);


/*==============================================================*/
/* Table: USR_USER                                              */
/*==============================================================*/
create table USR_USER  (
   C_ID                 VARCHAR(32)                    not null,
   C_USERCODE           VARCHAR(64)                    not null,
   C_USERNAME           VARCHAR(400),
   C_ORGID              VARCHAR(32),
   C_AREAID             VARCHAR(32),
   C_WORKCODE           VARCHAR(64),
   C_DEPARTMENT         VARCHAR(200),
   C_TEL                VARCHAR(40),
   C_MOBILE             VARCHAR(40),
   C_EMAIL              VARCHAR(200),
   C_LOGIN_PWD          VARCHAR(64),
   C_IDNO               VARCHAR(64),
   D_INVALIDDATE        TIMESTAMP,
   C_POSLEVEL           VARCHAR(64),
   C_POSTYPE            VARCHAR(64),
   C_DEFAULT_MODULE     VARCHAR(200),
   C_STATUS             VARCHAR(2),
   I_ORDER              NUMERIC(22),
   C_ADMIN_ORGID        VARCHAR(400),
   C_MULTI_ONLINE       VARCHAR(2),
   D_UPDATEDATE         TIMESTAMP,
   I_LOGINFAIL_COUNT    NUMERIC(22),
   C_LOGINED            VARCHAR(2),
   D_LASTLOGINTIME      TIMESTAMP,
   I_LOGIN_TOTAL        NUMERIC(22),
   C_IP                 VARCHAR(20),
   C_TELLER_GROUP       VARCHAR(100),
   C_TAILBOX_NO         VARCHAR(100),
   F1                   VARCHAR(100),
   F2                   VARCHAR(100),
   F3                   VARCHAR(100),
   F4                   VARCHAR(100),
   F5                   VARCHAR(100),
   F6                   VARCHAR(100), --500->100
   F7                   VARCHAR(200), --1000->200
   D_PWINVALIDDATE      TIMESTAMP,
   D_CREATETIME         TIMESTAMP,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_USER_AREAID                                       */
/*==============================================================*/
create index IDX_USER_AREAID on USR_USER (
   C_AREAID ASC
);

/*==============================================================*/
/* Index: IDX_USER_ORGID                                        */
/*==============================================================*/
create index IDX_USER_ORGID on USR_USER (
   C_ORGID ASC
);

/*==============================================================*/
/* Index: IDX_USER_USERCODE                                     */
/*==============================================================*/
create unique index IDX_USER_USERCODE on USR_USER (
   C_USERCODE ASC
);


/*==============================================================*/
/* Table: USR_USERGRP                                           */
/*==============================================================*/
create table USR_USERGRP  (
   C_ID                 VARCHAR(32)                    not null,
   C_USERID             VARCHAR(32),
   C_GRPID              VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_USERGRP_GRPID                                     */
/*==============================================================*/
create index IDX_USERGRP_GRPID on USR_USERGRP (
   C_GRPID ASC
);

/*==============================================================*/
/* Index: IDX_USERGRP_USERID                                    */
/*==============================================================*/
create index IDX_USERGRP_USERID on USR_USERGRP (
   C_USERID ASC
);


/*==============================================================*/
/* Table: USR_USERROLE                                          */
/*==============================================================*/
create table USR_USERROLE  (
   C_ID                 VARCHAR(32)                    not null,
   C_USERID             VARCHAR(32),
   C_ROLEID             VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

/*==============================================================*/
/* Index: IDX_USERROLE_ROLEID                                   */
/*==============================================================*/
create index IDX_USERROLE_ROLEID on USR_USERROLE (
   C_ROLEID ASC
);

/*==============================================================*/
/* Index: IDX_USERROLE_USERID                                   */
/*==============================================================*/
create index IDX_USERROLE_USERID on USR_USERROLE (
   C_USERID ASC
);



/*==============================================================*/
/* Table: CML_LOAD_NOTES_RECORD                                 */
/*==============================================================*/
create table CML_LOAD_NOTES_RECORD  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERM_ID		VARCHAR(32),
   C_TRAN_TIME          VARCHAR(20),
   I_TRAN_COUNT         NUMERIC(8),
   I_STATIS_AMT		NUMERIC(20),
   I_TYPE               INTEGER,
   I_OPER_TYPE          INTEGER,
   C_PATHCODE           VARCHAR(64),
   C_TRAN_DATE		VARCHAR(8),
   C_PART_MONTHDAY      VARCHAR(4),
   C_RESERVE1           VARCHAR(32),
   C_TD_ATM_ID          VARCHAR(32),
   C_TD_CASHBOX_ID      VARCHAR(32),
   C_TD_OPERATOR_ID	VARCHAR(32),
   C_TD_LOADNOTES_ID	VARCHAR(32),
   C_TD_RESERVE         VARCHAR(32),
   primary key (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create index I1_CML_LOAD_NOTES_RECORD on CML_LOAD_NOTES_RECORD (
   C_TRAN_TIME DESC
);

create index I2_CML_LOAD_NOTES_RECORD on CML_LOAD_NOTES_RECORD (
   C_PATHCODE ASC
);


/*==============================================================*/
/* Table: CML_COUNTER_RECORD                                    */
/*==============================================================*/
create table CML_COUNTER_RECORD  (
   C_ID                 VARCHAR(32)                    not null,
   C_TERM_ID	        VARCHAR(32),
   C_CARD_ID            VARCHAR(32),
   C_TRAN_TIME          VARCHAR(20),
   I_TRAN_COUNT         NUMERIC(8),
   I_STATIS_AMT         NUMERIC(20),
   I_BUSINESS_TYPE      INTEGER,
   C_PATHCODE           VARCHAR(64),
   C_TRAN_DATE		VARCHAR(8),
   C_PART_MONTHDAY      VARCHAR(4),
   C_RESERVE1           VARCHAR(32),
   C_TD_ACCOUNT_NO      VARCHAR(32),
   C_TD_JOURNAL_NO      VARCHAR(32),
   I_TD_TRAN_AMT        NUMERIC(20),
   C_TD_OPERATOR_ID	VARCHAR(32),
   C_TD_IDTYPE 		varchar(32),
   C_TD_TRANSCODE 	varchar(64),
   C_TD_IDCARD 		varchar(32), 
   C_TD_RESERVE         VARCHAR(32),
   primary key (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create index I1_CML_COUNTER_RECORD on CML_COUNTER_RECORD (
   C_TRAN_TIME DESC
);

create index I2_CML_COUNTER_RECORD on CML_COUNTER_RECORD (
   C_PATHCODE ASC
);


/*==============================*/
/* 閽炵鏉＄爜琛?                  */
/*==============================*/
create table BARCODE_IN_CASHBOX
(
  C_ID              VARCHAR(32) not null,
  C_BOX_NUM         VARCHAR(32),
  C_BARCODE_FLOWNUM VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create index I1_BARCODE_IN_CASHBOX on BARCODE_IN_CASHBOX (C_BOX_NUM);

/*==============================*/
/* 娑夊亣淇℃伅琛?                  */
/*==============================*/
create table SMS_SERIAL_DOUBT_RECORD
(
	C_ID                      VARCHAR(32) not null,
	C_ORG_CODE                VARCHAR(32),
	C_ORG_NAME                VARCHAR(50),
	C_ORG_PATHCODE            VARCHAR(64),
	C_OPERATOR_ID             VARCHAR(32),
	C_CHECK_ID		  VARCHAR(32),
	C_APPLY_NAME		  VARCHAR(32),
	C_APPLY_PHONE             VARCHAR(32),
	D_APPLY_DATE              TIMESTAMP,
	C_SERIA_NO                VARCHAR(32),
	I_SERIAL_RESULT           NUMERIC(2),
	I_SERIAL_COUNT            NUMERIC(6),
	C_NOTE_TYPE               VARCHAR(4),
	I_NOTE_PAYTYPE            NUMERIC(2),
	I_IDENT_TYPE              NUMERIC(2),
	C_IDENT_NO                VARCHAR(32),
	C_DEPOSIT_DATE		  TIMESTAMP,
	C_DEPOSIT_BANK            VARCHAR(64),
	C_COUNTER_POSITION VARCHAR(64),
	C_ADDRESS VARCHAR(64),
	I_APPLY_TYPE NUMERIC(2) DEFAULT 0,
	C_APPLY_CARDTYPE VARCHAR(64),
	C_APPLY_CARDNO VARCHAR(64),
	I_REGISTRATION_TYPE NUMERIC(2) DEFAULT 0,
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create index IDX1_SMS_SERIAL_DOUBT_RECORD on SMS_SERIAL_DOUBT_RECORD (C_ORG_PATHCODE);

-- Create table
create table SMS_SERIAL_SEARCH_RECORD
(
  C_ID              VARCHAR(32) not null,
  D_SEARCH_DATE     TIMESTAMP,
  C_OPERATOR_NAME   VARCHAR(32),
  C_SERIAL_KEEPER   VARCHAR(32),
  I_NOTE_RECORDTYPE INTEGER,
  D_RECORD_DATE     TIMESTAMP,
  C_SERIA_NO        VARCHAR(32),
  I_SERIAL_COUNT    INTEGER,
  C_NOTE_TYPE       VARCHAR(4),
  I_SERIAL_RESULT   INTEGER,
  primary key (C_ID)
);


/*==============================*/
/* 统计报表配置                   */
/*==============================*/
CREATE TABLE DATA_REPORT
(
  C_ID            VARCHAR(32) NOT NULL,
  C_REPORT_MODULE VARCHAR(64) NOT NULL,
  C_DATABASE      VARCHAR(64) NOT NULL,
  C_QUERYSTR      VARCHAR(2000),
  C_TYPE          VARCHAR(4),
  C_STATUS        VARCHAR(4) NOT NULL,
  C_REMARK        VARCHAR(256),
  primary key (C_ID)
);

/*==============================================================*/
/* Table: SMS_SERIAL_UPLOAD_CONFIG                                       */
/*==============================================================*/
create table SMS_SERIAL_UPLOAD_CONFIG  (
   C_ID                         VARCHAR(32)                    not null,
   C_NAME                       VARCHAR(256),
   C_SERVER_IP                  VARCHAR(32),
   C_SERVER_PORT                VARCHAR(6),
   C_SERVER_USERNAME            VARCHAR(32),
   C_SERVER_PASSWORD            VARCHAR(128),
   C_SERVER_PATH                VARCHAR(256),
   C_SERVER_TYPE                VARCHAR(2),
   C_CYCLE_TYPE                 VARCHAR(2),
   C_CYCLE_VALUE                NUMERIC(10),
   C_START_TIME                 VARCHAR(8),
   C_STATUS                     VARCHAR(2),
   C_UPDATE_TIME                VARCHAR(16),
   C_UPDATE_ID                  VARCHAR(32),
   primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create table TML_DATA_BACKUP
(
  C_ID				VARCHAR(32) not null,
  C_PATH			VARCHAR(100) not null,
  C_CREATE_DATE			VARCHAR(20),
  C_COMM			VARCHAR(40),
  primary key (C_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

-- CML_SENT_INFOS_HIS_0101
create table CML_SENT_INFOS_HIS_0101
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0101 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0101 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0102
create table CML_SENT_INFOS_HIS_0102
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0102 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0102 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0103
create table CML_SENT_INFOS_HIS_0103
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0103 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0103 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0104
create table CML_SENT_INFOS_HIS_0104
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0104 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0104 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0105
create table CML_SENT_INFOS_HIS_0105
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0105 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0105 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0106
create table CML_SENT_INFOS_HIS_0106
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0106 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0106 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0107
create table CML_SENT_INFOS_HIS_0107
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0107 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0107 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0108
create table CML_SENT_INFOS_HIS_0108
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0108 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0108 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0109
create table CML_SENT_INFOS_HIS_0109
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0109 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0109 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0110
create table CML_SENT_INFOS_HIS_0110
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0110 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0110 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0111
create table CML_SENT_INFOS_HIS_0111
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0111 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0111 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0112
create table CML_SENT_INFOS_HIS_0112
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0112 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0112 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0113
create table CML_SENT_INFOS_HIS_0113
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0113 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0113 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0114
create table CML_SENT_INFOS_HIS_0114
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0114 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0114 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0115
create table CML_SENT_INFOS_HIS_0115
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0115 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0115 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0116
create table CML_SENT_INFOS_HIS_0116
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0116 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0116 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0117
create table CML_SENT_INFOS_HIS_0117
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0117 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0117 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0118
create table CML_SENT_INFOS_HIS_0118
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0118 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0118 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0119
create table CML_SENT_INFOS_HIS_0119
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0119 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0119 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0120
create table CML_SENT_INFOS_HIS_0120
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0120 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0120 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0121
create table CML_SENT_INFOS_HIS_0121
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0121 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0121 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0122
create table CML_SENT_INFOS_HIS_0122
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0122 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0122 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0123
create table CML_SENT_INFOS_HIS_0123
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0123 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0123 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0124
create table CML_SENT_INFOS_HIS_0124
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0124 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0124 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0125
create table CML_SENT_INFOS_HIS_0125
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0125 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0125 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0126
create table CML_SENT_INFOS_HIS_0126
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0126 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0126 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0127
create table CML_SENT_INFOS_HIS_0127
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0127 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0127 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0128
create table CML_SENT_INFOS_HIS_0128
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0128 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0128 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0129
create table CML_SENT_INFOS_HIS_0129
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0129 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0129 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0130
create table CML_SENT_INFOS_HIS_0130
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0130 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0130 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0131
create table CML_SENT_INFOS_HIS_0131
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0131 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0131 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0201
create table CML_SENT_INFOS_HIS_0201
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0201 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0201 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0202
create table CML_SENT_INFOS_HIS_0202
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0202 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0202 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0203
create table CML_SENT_INFOS_HIS_0203
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0203 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0203 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0204
create table CML_SENT_INFOS_HIS_0204
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0204 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0204 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0205
create table CML_SENT_INFOS_HIS_0205
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0205 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0205 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0206
create table CML_SENT_INFOS_HIS_0206
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0206 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0206 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0207
create table CML_SENT_INFOS_HIS_0207
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0207 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0207 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0208
create table CML_SENT_INFOS_HIS_0208
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0208 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0208 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0209
create table CML_SENT_INFOS_HIS_0209
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0209 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0209 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0210
create table CML_SENT_INFOS_HIS_0210
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0210 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0210 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0211
create table CML_SENT_INFOS_HIS_0211
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0211 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0211 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0212
create table CML_SENT_INFOS_HIS_0212
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0212 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0212 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0213
create table CML_SENT_INFOS_HIS_0213
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0213 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0213 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0214
create table CML_SENT_INFOS_HIS_0214
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0214 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0214 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0215
create table CML_SENT_INFOS_HIS_0215
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0215 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0215 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0216
create table CML_SENT_INFOS_HIS_0216
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0216 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0216 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0217
create table CML_SENT_INFOS_HIS_0217
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0217 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0217 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0218
create table CML_SENT_INFOS_HIS_0218
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0218 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0218 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0219
create table CML_SENT_INFOS_HIS_0219
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0219 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0219 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0220
create table CML_SENT_INFOS_HIS_0220
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0220 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0220 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0221
create table CML_SENT_INFOS_HIS_0221
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0221 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0221 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0222
create table CML_SENT_INFOS_HIS_0222
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0222 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0222 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0223
create table CML_SENT_INFOS_HIS_0223
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0223 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0223 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0224
create table CML_SENT_INFOS_HIS_0224
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0224 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0224 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0225
create table CML_SENT_INFOS_HIS_0225
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0225 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0225 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0226
create table CML_SENT_INFOS_HIS_0226
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0226 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0226 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0227
create table CML_SENT_INFOS_HIS_0227
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0227 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0227 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0228
create table CML_SENT_INFOS_HIS_0228
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0228 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0228 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0229
create table CML_SENT_INFOS_HIS_0229
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0229 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0229 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0301
create table CML_SENT_INFOS_HIS_0301
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0301 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0301 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0302
create table CML_SENT_INFOS_HIS_0302
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0302 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0302 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0303
create table CML_SENT_INFOS_HIS_0303
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0303 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0303 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0304
create table CML_SENT_INFOS_HIS_0304
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0304 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0304 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0305
create table CML_SENT_INFOS_HIS_0305
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0305 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0305 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0306
create table CML_SENT_INFOS_HIS_0306
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0306 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0306 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0307
create table CML_SENT_INFOS_HIS_0307
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0307 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0307 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0308
create table CML_SENT_INFOS_HIS_0308
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0308 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0308 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0309
create table CML_SENT_INFOS_HIS_0309
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0309 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0309 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0310
create table CML_SENT_INFOS_HIS_0310
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0310 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0310 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0311
create table CML_SENT_INFOS_HIS_0311
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0311 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0311 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0312
create table CML_SENT_INFOS_HIS_0312
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0312 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0312 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0313
create table CML_SENT_INFOS_HIS_0313
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0313 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0313 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0314
create table CML_SENT_INFOS_HIS_0314
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0314 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0314 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0315
create table CML_SENT_INFOS_HIS_0315
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0315 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0315 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0316
create table CML_SENT_INFOS_HIS_0316
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0316 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0316 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0317
create table CML_SENT_INFOS_HIS_0317
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0317 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0317 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0318
create table CML_SENT_INFOS_HIS_0318
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0318 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0318 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0319
create table CML_SENT_INFOS_HIS_0319
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0319 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0319 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0320
create table CML_SENT_INFOS_HIS_0320
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0320 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0320 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0321
create table CML_SENT_INFOS_HIS_0321
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0321 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0321 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0322
create table CML_SENT_INFOS_HIS_0322
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0322 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0322 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0323
create table CML_SENT_INFOS_HIS_0323
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0323 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0323 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0324
create table CML_SENT_INFOS_HIS_0324
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0324 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0324 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0325
create table CML_SENT_INFOS_HIS_0325
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0325 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0325 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0326
create table CML_SENT_INFOS_HIS_0326
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0326 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0326 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0327
create table CML_SENT_INFOS_HIS_0327
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0327 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0327 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0328
create table CML_SENT_INFOS_HIS_0328
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0328 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0328 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0329
create table CML_SENT_INFOS_HIS_0329
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0329 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0329 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0330
create table CML_SENT_INFOS_HIS_0330
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0330 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0330 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0331
create table CML_SENT_INFOS_HIS_0331
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0331 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0331 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0401
create table CML_SENT_INFOS_HIS_0401
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0401 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0401 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0402
create table CML_SENT_INFOS_HIS_0402
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0402 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0402 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0403
create table CML_SENT_INFOS_HIS_0403
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0403 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0403 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0404
create table CML_SENT_INFOS_HIS_0404
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0404 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0404 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0405
create table CML_SENT_INFOS_HIS_0405
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0405 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0405 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0406
create table CML_SENT_INFOS_HIS_0406
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0406 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0406 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0407
create table CML_SENT_INFOS_HIS_0407
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0407 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0407 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0408
create table CML_SENT_INFOS_HIS_0408
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0408 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0408 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0409
create table CML_SENT_INFOS_HIS_0409
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0409 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0409 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0410
create table CML_SENT_INFOS_HIS_0410
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0410 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0410 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0411
create table CML_SENT_INFOS_HIS_0411
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0411 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0411 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0412
create table CML_SENT_INFOS_HIS_0412
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0412 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0412 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0413
create table CML_SENT_INFOS_HIS_0413
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0413 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0413 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0414
create table CML_SENT_INFOS_HIS_0414
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0414 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0414 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0415
create table CML_SENT_INFOS_HIS_0415
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0415 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0415 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0416
create table CML_SENT_INFOS_HIS_0416
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0416 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0416 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0417
create table CML_SENT_INFOS_HIS_0417
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0417 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0417 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0418
create table CML_SENT_INFOS_HIS_0418
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0418 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0418 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0419
create table CML_SENT_INFOS_HIS_0419
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0419 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0419 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0420
create table CML_SENT_INFOS_HIS_0420
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0420 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0420 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0421
create table CML_SENT_INFOS_HIS_0421
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0421 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0421 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0422
create table CML_SENT_INFOS_HIS_0422
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0422 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0422 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0423
create table CML_SENT_INFOS_HIS_0423
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0423 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0423 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0424
create table CML_SENT_INFOS_HIS_0424
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0424 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0424 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0425
create table CML_SENT_INFOS_HIS_0425
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0425 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0425 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0426
create table CML_SENT_INFOS_HIS_0426
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0426 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0426 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0427
create table CML_SENT_INFOS_HIS_0427
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0427 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0427 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0428
create table CML_SENT_INFOS_HIS_0428
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0428 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0428 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0429
create table CML_SENT_INFOS_HIS_0429
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0429 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0429 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0430
create table CML_SENT_INFOS_HIS_0430
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0430 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0430 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0501
create table CML_SENT_INFOS_HIS_0501
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0501 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0501 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0502
create table CML_SENT_INFOS_HIS_0502
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0502 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0502 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0503
create table CML_SENT_INFOS_HIS_0503
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0503 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0503 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0504
create table CML_SENT_INFOS_HIS_0504
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0504 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0504 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0505
create table CML_SENT_INFOS_HIS_0505
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0505 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0505 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0506
create table CML_SENT_INFOS_HIS_0506
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0506 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0506 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0507
create table CML_SENT_INFOS_HIS_0507
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0507 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0507 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0508
create table CML_SENT_INFOS_HIS_0508
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0508 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0508 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0509
create table CML_SENT_INFOS_HIS_0509
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0509 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0509 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0510
create table CML_SENT_INFOS_HIS_0510
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0510 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0510 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0511
create table CML_SENT_INFOS_HIS_0511
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0511 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0511 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0512
create table CML_SENT_INFOS_HIS_0512
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0512 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0512 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0513
create table CML_SENT_INFOS_HIS_0513
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0513 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0513 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0514
create table CML_SENT_INFOS_HIS_0514
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0514 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0514 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0515
create table CML_SENT_INFOS_HIS_0515
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0515 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0515 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0516
create table CML_SENT_INFOS_HIS_0516
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0516 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0516 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0517
create table CML_SENT_INFOS_HIS_0517
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0517 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0517 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0518
create table CML_SENT_INFOS_HIS_0518
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0518 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0518 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0519
create table CML_SENT_INFOS_HIS_0519
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0519 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0519 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0520
create table CML_SENT_INFOS_HIS_0520
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0520 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0520 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0521
create table CML_SENT_INFOS_HIS_0521
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0521 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0521 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0522
create table CML_SENT_INFOS_HIS_0522
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0522 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0522 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0523
create table CML_SENT_INFOS_HIS_0523
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0523 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0523 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0524
create table CML_SENT_INFOS_HIS_0524
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0524 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0524 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0525
create table CML_SENT_INFOS_HIS_0525
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0525 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0525 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0526
create table CML_SENT_INFOS_HIS_0526
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0526 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0526 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0527
create table CML_SENT_INFOS_HIS_0527
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0527 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0527 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0528
create table CML_SENT_INFOS_HIS_0528
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0528 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0528 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0529
create table CML_SENT_INFOS_HIS_0529
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0529 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0529 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0530
create table CML_SENT_INFOS_HIS_0530
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0530 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0530 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0531
create table CML_SENT_INFOS_HIS_0531
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0531 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0531 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0601
create table CML_SENT_INFOS_HIS_0601
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0601 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0601 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0602
create table CML_SENT_INFOS_HIS_0602
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0602 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0602 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0603
create table CML_SENT_INFOS_HIS_0603
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0603 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0603 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0604
create table CML_SENT_INFOS_HIS_0604
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0604 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0604 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0605
create table CML_SENT_INFOS_HIS_0605
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0605 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0605 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0606
create table CML_SENT_INFOS_HIS_0606
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0606 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0606 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0607
create table CML_SENT_INFOS_HIS_0607
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0607 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0607 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0608
create table CML_SENT_INFOS_HIS_0608
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0608 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0608 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0609
create table CML_SENT_INFOS_HIS_0609
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0609 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0609 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0610
create table CML_SENT_INFOS_HIS_0610
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0610 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0610 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0611
create table CML_SENT_INFOS_HIS_0611
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0611 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0611 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0612
create table CML_SENT_INFOS_HIS_0612
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0612 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0612 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0613
create table CML_SENT_INFOS_HIS_0613
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0613 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0613 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0614
create table CML_SENT_INFOS_HIS_0614
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0614 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0614 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0615
create table CML_SENT_INFOS_HIS_0615
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0615 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0615 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0616
create table CML_SENT_INFOS_HIS_0616
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0616 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0616 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0617
create table CML_SENT_INFOS_HIS_0617
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0617 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0617 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0618
create table CML_SENT_INFOS_HIS_0618
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0618 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0618 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0619
create table CML_SENT_INFOS_HIS_0619
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0619 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0619 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0620
create table CML_SENT_INFOS_HIS_0620
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0620 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0620 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0621
create table CML_SENT_INFOS_HIS_0621
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0621 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0621 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0622
create table CML_SENT_INFOS_HIS_0622
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0622 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0622 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0623
create table CML_SENT_INFOS_HIS_0623
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0623 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0623 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0624
create table CML_SENT_INFOS_HIS_0624
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0624 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0624 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0625
create table CML_SENT_INFOS_HIS_0625
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0625 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0625 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0626
create table CML_SENT_INFOS_HIS_0626
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0626 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0626 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0627
create table CML_SENT_INFOS_HIS_0627
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0627 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0627 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0628
create table CML_SENT_INFOS_HIS_0628
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0628 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0628 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0629
create table CML_SENT_INFOS_HIS_0629
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0629 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0629 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0630
create table CML_SENT_INFOS_HIS_0630
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0630 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0630 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0701
create table CML_SENT_INFOS_HIS_0701
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0701 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0701 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0702
create table CML_SENT_INFOS_HIS_0702
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0702 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0702 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0703
create table CML_SENT_INFOS_HIS_0703
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0703 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0703 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0704
create table CML_SENT_INFOS_HIS_0704
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0704 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0704 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0705
create table CML_SENT_INFOS_HIS_0705
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0705 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0705 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0706
create table CML_SENT_INFOS_HIS_0706
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0706 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0706 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0707
create table CML_SENT_INFOS_HIS_0707
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0707 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0707 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0708
create table CML_SENT_INFOS_HIS_0708
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0708 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0708 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0709
create table CML_SENT_INFOS_HIS_0709
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0709 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0709 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0710
create table CML_SENT_INFOS_HIS_0710
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0710 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0710 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0711
create table CML_SENT_INFOS_HIS_0711
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0711 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0711 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0712
create table CML_SENT_INFOS_HIS_0712
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0712 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0712 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0713
create table CML_SENT_INFOS_HIS_0713
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0713 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0713 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0714
create table CML_SENT_INFOS_HIS_0714
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0714 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0714 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0715
create table CML_SENT_INFOS_HIS_0715
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0715 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0715 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0716
create table CML_SENT_INFOS_HIS_0716
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0716 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0716 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0717
create table CML_SENT_INFOS_HIS_0717
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0717 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0717 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0718
create table CML_SENT_INFOS_HIS_0718
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0718 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0718 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0719
create table CML_SENT_INFOS_HIS_0719
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0719 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0719 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0720
create table CML_SENT_INFOS_HIS_0720
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0720 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0720 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0721
create table CML_SENT_INFOS_HIS_0721
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0721 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0721 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0722
create table CML_SENT_INFOS_HIS_0722
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0722 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0722 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0723
create table CML_SENT_INFOS_HIS_0723
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0723 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0723 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0724
create table CML_SENT_INFOS_HIS_0724
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0724 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0724 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0725
create table CML_SENT_INFOS_HIS_0725
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0725 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0725 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0726
create table CML_SENT_INFOS_HIS_0726
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0726 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0726 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0727
create table CML_SENT_INFOS_HIS_0727
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0727 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0727 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0728
create table CML_SENT_INFOS_HIS_0728
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0728 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0728 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0729
create table CML_SENT_INFOS_HIS_0729
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0729 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0729 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0730
create table CML_SENT_INFOS_HIS_0730
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0730 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0730 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0731
create table CML_SENT_INFOS_HIS_0731
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0731 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0731 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0801
create table CML_SENT_INFOS_HIS_0801
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0801 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0801 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0802
create table CML_SENT_INFOS_HIS_0802
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0802 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0802 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0803
create table CML_SENT_INFOS_HIS_0803
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0803 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0803 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0804
create table CML_SENT_INFOS_HIS_0804
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0804 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0804 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0805
create table CML_SENT_INFOS_HIS_0805
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0805 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0805 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0806
create table CML_SENT_INFOS_HIS_0806
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0806 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0806 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0807
create table CML_SENT_INFOS_HIS_0807
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0807 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0807 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0808
create table CML_SENT_INFOS_HIS_0808
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0808 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0808 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0809
create table CML_SENT_INFOS_HIS_0809
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0809 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0809 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0810
create table CML_SENT_INFOS_HIS_0810
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0810 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0810 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0811
create table CML_SENT_INFOS_HIS_0811
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0811 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0811 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0812
create table CML_SENT_INFOS_HIS_0812
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0812 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0812 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0813
create table CML_SENT_INFOS_HIS_0813
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0813 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0813 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0814
create table CML_SENT_INFOS_HIS_0814
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0814 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0814 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0815
create table CML_SENT_INFOS_HIS_0815
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0815 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0815 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0816
create table CML_SENT_INFOS_HIS_0816
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0816 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0816 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0817
create table CML_SENT_INFOS_HIS_0817
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0817 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0817 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0818
create table CML_SENT_INFOS_HIS_0818
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0818 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0818 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0819
create table CML_SENT_INFOS_HIS_0819
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0819 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0819 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0820
create table CML_SENT_INFOS_HIS_0820
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0820 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0820 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0821
create table CML_SENT_INFOS_HIS_0821
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0821 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0821 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0822
create table CML_SENT_INFOS_HIS_0822
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0822 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0822 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0823
create table CML_SENT_INFOS_HIS_0823
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0823 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0823 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0824
create table CML_SENT_INFOS_HIS_0824
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0824 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0824 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0825
create table CML_SENT_INFOS_HIS_0825
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0825 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0825 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0826
create table CML_SENT_INFOS_HIS_0826
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0826 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0826 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0827
create table CML_SENT_INFOS_HIS_0827
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0827 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0827 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0828
create table CML_SENT_INFOS_HIS_0828
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0828 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0828 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0829
create table CML_SENT_INFOS_HIS_0829
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0829 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0829 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0830
create table CML_SENT_INFOS_HIS_0830
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0830 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0830 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0831
create table CML_SENT_INFOS_HIS_0831
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0831 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0831 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0901
create table CML_SENT_INFOS_HIS_0901
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0901 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0901 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0902
create table CML_SENT_INFOS_HIS_0902
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0902 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0902 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0903
create table CML_SENT_INFOS_HIS_0903
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0903 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0903 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0904
create table CML_SENT_INFOS_HIS_0904
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0904 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0904 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0905
create table CML_SENT_INFOS_HIS_0905
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0905 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0905 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0906
create table CML_SENT_INFOS_HIS_0906
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0906 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0906 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0907
create table CML_SENT_INFOS_HIS_0907
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0907 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0907 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0908
create table CML_SENT_INFOS_HIS_0908
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0908 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0908 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0909
create table CML_SENT_INFOS_HIS_0909
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0909 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0909 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0910
create table CML_SENT_INFOS_HIS_0910
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0910 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0910 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0911
create table CML_SENT_INFOS_HIS_0911
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0911 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0911 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0912
create table CML_SENT_INFOS_HIS_0912
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0912 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0912 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0913
create table CML_SENT_INFOS_HIS_0913
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0913 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0913 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0914
create table CML_SENT_INFOS_HIS_0914
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0914 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0914 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0915
create table CML_SENT_INFOS_HIS_0915
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0915 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0915 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0916
create table CML_SENT_INFOS_HIS_0916
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0916 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0916 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0917
create table CML_SENT_INFOS_HIS_0917
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0917 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0917 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0918
create table CML_SENT_INFOS_HIS_0918
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0918 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0918 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0919
create table CML_SENT_INFOS_HIS_0919
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0919 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0919 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0920
create table CML_SENT_INFOS_HIS_0920
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0920 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0920 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0921
create table CML_SENT_INFOS_HIS_0921
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0921 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0921 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0922
create table CML_SENT_INFOS_HIS_0922
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0922 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0922 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0923
create table CML_SENT_INFOS_HIS_0923
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0923 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0923 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0924
create table CML_SENT_INFOS_HIS_0924
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0924 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0924 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0925
create table CML_SENT_INFOS_HIS_0925
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0925 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0925 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0926
create table CML_SENT_INFOS_HIS_0926
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0926 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0926 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0927
create table CML_SENT_INFOS_HIS_0927
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0927 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0927 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0928
create table CML_SENT_INFOS_HIS_0928
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0928 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0928 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0929
create table CML_SENT_INFOS_HIS_0929
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0929 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0929 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_0930
create table CML_SENT_INFOS_HIS_0930
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_0930 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_0930 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1001
create table CML_SENT_INFOS_HIS_1001
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1001 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1001 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1002
create table CML_SENT_INFOS_HIS_1002
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1002 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1002 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1003
create table CML_SENT_INFOS_HIS_1003
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1003 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1003 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1004
create table CML_SENT_INFOS_HIS_1004
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1004 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1004 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1005
create table CML_SENT_INFOS_HIS_1005
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1005 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1005 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1006
create table CML_SENT_INFOS_HIS_1006
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1006 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1006 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1007
create table CML_SENT_INFOS_HIS_1007
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1007 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1007 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1008
create table CML_SENT_INFOS_HIS_1008
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1008 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1008 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1009
create table CML_SENT_INFOS_HIS_1009
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1009 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1009 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1010
create table CML_SENT_INFOS_HIS_1010
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1010 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1010 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1011
create table CML_SENT_INFOS_HIS_1011
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1011 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1011 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1012
create table CML_SENT_INFOS_HIS_1012
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1012 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1012 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1013
create table CML_SENT_INFOS_HIS_1013
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1013 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1013 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1014
create table CML_SENT_INFOS_HIS_1014
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1014 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1014 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1015
create table CML_SENT_INFOS_HIS_1015
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1015 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1015 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1016
create table CML_SENT_INFOS_HIS_1016
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1016 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1016 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1017
create table CML_SENT_INFOS_HIS_1017
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1017 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1017 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1018
create table CML_SENT_INFOS_HIS_1018
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1018 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1018 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1019
create table CML_SENT_INFOS_HIS_1019
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1019 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1019 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1020
create table CML_SENT_INFOS_HIS_1020
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1020 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1020 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1021
create table CML_SENT_INFOS_HIS_1021
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1021 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1021 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1022
create table CML_SENT_INFOS_HIS_1022
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1022 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1022 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1023
create table CML_SENT_INFOS_HIS_1023
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1023 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1023 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1024
create table CML_SENT_INFOS_HIS_1024
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1024 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1024 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1025
create table CML_SENT_INFOS_HIS_1025
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1025 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1025 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1026
create table CML_SENT_INFOS_HIS_1026
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1026 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1026 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1027
create table CML_SENT_INFOS_HIS_1027
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1027 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1027 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1028
create table CML_SENT_INFOS_HIS_1028
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1028 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1028 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1029
create table CML_SENT_INFOS_HIS_1029
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1029 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1029 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1030
create table CML_SENT_INFOS_HIS_1030
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1030 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1030 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1031
create table CML_SENT_INFOS_HIS_1031
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1031 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1031 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1101
create table CML_SENT_INFOS_HIS_1101
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1101 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1101 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1102
create table CML_SENT_INFOS_HIS_1102
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1102 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1102 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1103
create table CML_SENT_INFOS_HIS_1103
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1103 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1103 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1104
create table CML_SENT_INFOS_HIS_1104
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1104 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1104 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1105
create table CML_SENT_INFOS_HIS_1105
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1105 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1105 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1106
create table CML_SENT_INFOS_HIS_1106
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1106 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1106 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1107
create table CML_SENT_INFOS_HIS_1107
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1107 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1107 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1108
create table CML_SENT_INFOS_HIS_1108
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1108 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1108 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1109
create table CML_SENT_INFOS_HIS_1109
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1109 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1109 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1110
create table CML_SENT_INFOS_HIS_1110
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1110 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1110 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1111
create table CML_SENT_INFOS_HIS_1111
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1111 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1111 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1112
create table CML_SENT_INFOS_HIS_1112
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1112 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1112 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1113
create table CML_SENT_INFOS_HIS_1113
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1113 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1113 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1114
create table CML_SENT_INFOS_HIS_1114
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1114 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1114 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1115
create table CML_SENT_INFOS_HIS_1115
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1115 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1115 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1116
create table CML_SENT_INFOS_HIS_1116
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1116 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1116 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1117
create table CML_SENT_INFOS_HIS_1117
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1117 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1117 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1118
create table CML_SENT_INFOS_HIS_1118
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1118 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1118 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1119
create table CML_SENT_INFOS_HIS_1119
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1119 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1119 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1120
create table CML_SENT_INFOS_HIS_1120
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1120 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1120 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1121
create table CML_SENT_INFOS_HIS_1121
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1121 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1121 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1122
create table CML_SENT_INFOS_HIS_1122
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1122 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1122 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1123
create table CML_SENT_INFOS_HIS_1123
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1123 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1123 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1124
create table CML_SENT_INFOS_HIS_1124
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1124 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1124 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1125
create table CML_SENT_INFOS_HIS_1125
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1125 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1125 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1126
create table CML_SENT_INFOS_HIS_1126
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1126 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1126 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1127
create table CML_SENT_INFOS_HIS_1127
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1127 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1127 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1128
create table CML_SENT_INFOS_HIS_1128
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1128 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1128 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1129
create table CML_SENT_INFOS_HIS_1129
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1129 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1129 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1130
create table CML_SENT_INFOS_HIS_1130
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1130 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1130 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1201
create table CML_SENT_INFOS_HIS_1201
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1201 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1201 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1202
create table CML_SENT_INFOS_HIS_1202
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1202 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1202 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1203
create table CML_SENT_INFOS_HIS_1203
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1203 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1203 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1204
create table CML_SENT_INFOS_HIS_1204
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1204 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1204 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1205
create table CML_SENT_INFOS_HIS_1205
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1205 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1205 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1206
create table CML_SENT_INFOS_HIS_1206
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1206 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1206 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1207
create table CML_SENT_INFOS_HIS_1207
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1207 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1207 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1208
create table CML_SENT_INFOS_HIS_1208
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1208 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1208 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1209
create table CML_SENT_INFOS_HIS_1209
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1209 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1209 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1210
create table CML_SENT_INFOS_HIS_1210
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1210 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1210 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1211
create table CML_SENT_INFOS_HIS_1211
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1211 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1211 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1212
create table CML_SENT_INFOS_HIS_1212
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1212 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1212 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1213
create table CML_SENT_INFOS_HIS_1213
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1213 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1213 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1214
create table CML_SENT_INFOS_HIS_1214
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1214 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1214 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1215
create table CML_SENT_INFOS_HIS_1215
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1215 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1215 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1216
create table CML_SENT_INFOS_HIS_1216
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1216 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1216 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1217
create table CML_SENT_INFOS_HIS_1217
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1217 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1217 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1218
create table CML_SENT_INFOS_HIS_1218
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1218 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1218 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1219
create table CML_SENT_INFOS_HIS_1219
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1219 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1219 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1220
create table CML_SENT_INFOS_HIS_1220
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1220 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1220 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1221
create table CML_SENT_INFOS_HIS_1221
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1221 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1221 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1222
create table CML_SENT_INFOS_HIS_1222
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1222 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1222 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1223
create table CML_SENT_INFOS_HIS_1223
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1223 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1223 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1224
create table CML_SENT_INFOS_HIS_1224
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1224 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1224 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1225
create table CML_SENT_INFOS_HIS_1225
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1225 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1225 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1226
create table CML_SENT_INFOS_HIS_1226
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1226 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1226 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1227
create table CML_SENT_INFOS_HIS_1227
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1227 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1227 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1228
create table CML_SENT_INFOS_HIS_1228
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1228 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1228 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1229
create table CML_SENT_INFOS_HIS_1229
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1229 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1229 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1230
create table CML_SENT_INFOS_HIS_1230
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1230 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1230 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_NOTE_TYPE);



-- CML_SENT_INFOS_HIS_1231
create table CML_SENT_INFOS_HIS_1231
(
  I_ID              NUMERIC(14) not null generated always as identity(start with 1,increment by 1,no cache),
  C_TRAN_ID         varchar(32),
  C_TERM_ID         varchar(32),
  C_JOURNAL_NO      varchar(32),
  C_IMAGE_TYPE      varchar(2),
  I_SEQUENCE        NUMERIC(16),
  C_BARCODE_FLOWNUM varchar(32),
  C_NOTE_FLAG       varchar(2),
  C_NOTE_TYPE       varchar(4),
  C_CURRENCY        varchar(6),
  C_DENOMINATION    varchar(8),
  C_VERSION_NUM     varchar(5),
  C_SERIA_NO        varchar(19),
  C_ERROR_CODE      varchar(32)
  C_RESERVE         varchar(16),
  C_TRAN_DATE       varchar(16),
  C_TRAN_MONTHDAY   varchar(4),
  C_TRAN_MINUTE     varchar(2),
  C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
  C_TERM_TYPE       varchar(2),
  C_PATHCODE        varchar(64),
  C_MACHINESNO      varchar(24),
  constraint P_CML_SENT_INFOS_HIS_1231 primary key (I_ID)
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX" DISTRIBUTE BY HASH (I_ID);

--CREATE SEQUENCE SEQ_CML_SENT_INFOS_HIS_1231 INCREMENT BY 1 START WITH 1 MAXVALUE 99999999999999 CYCLE CACHE 800; 

create index IDX1_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_NOTE_TYPE);;

CREATE TABLE cml_upreport_log(
   C_ID         VARCHAR(32)     not null,
  C_TRAN_TIME VARCHAR(14) DEFAULT NULL,
  C_BANK_CODE VARCHAR(14) DEFAULT NULL,
  C_FROM_CODE VARCHAR(14) DEFAULT NULL,
  C_BUSINESS_TYPE VARCHAR(3) DEFAULT NULL,
  I_COUNT NUMERIC(11) DEFAULT NULL,
  C_CASH_TYPE VARCHAR(3) DEFAULT NULL,
  I_VERSION NUMERIC(11) DEFAULT NULL,
  C_DEVICE_TYPE VARCHAR(3) DEFAULT NULL,
  C_MACHINE_TYPE VARCHAR(8) DEFAULT NULL,
  C_DEVICE_CODE VARCHAR(10) DEFAULT NULL,
  C_BUSINESS_INFORMATION VARCHAR(50) DEFAULT NULL,
  C_RESERVE VARCHAR(10) DEFAULT NULL,
  C_FILE_NAME VARCHAR(64) DEFAULT NULL,
  C_UPREPORT_TYPE VARCHAR(1) DEFAULT NULL,
  I_CRH_COUNT NUMERIC(11) DEFAULT NULL,
  C_START_TIME VARCHAR(14) DEFAULT NULL,
  C_END_TIME VARCHAR(14) DEFAULT NULL,
  C_UPLOAD_TIME VARCHAR(14) DEFAULT NULL,
  C_PART_MONTHDAY VARCHAR(4) NOT NULL,
  C_PATHCODE VARCHAR(64) DEFAULT NULL,
  C_PARENT_ID VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";
create index I1_cml_upreport_log on cml_upreport_log (
   C_BANK_CODE DESC
);
create index I2_cml_upreport_log on cml_upreport_log (
   C_FROM_CODE DESC
);
create index I3_cml_upreport_log on cml_upreport_log (
   C_MACHINE_TYPE DESC
);
create index I4_cml_upreport_log on cml_upreport_log (
   C_PATHCODE DESC
);
create index I5_cml_upreport_log on cml_upreport_log (
   C_UPLOAD_TIME DESC
);
create index I6_cml_upreport_log on cml_upreport_log (
   C_PARENT_ID DESC
);
CREATE TABLE cml_stride_transfer_record(
   C_ID         VARCHAR(32)     not null,
  C_TRAN_TIME VARCHAR(14) DEFAULT NULL,
  C_BANK_CODE VARCHAR(14) DEFAULT NULL,
  C_FROM_CODE VARCHAR(14) DEFAULT NULL,
  C_BUSINESS_TYPE VARCHAR(1) DEFAULT NULL,
  I_COUNT NUMERIC(11) DEFAULT NULL,
  C_CASH_TYPE VARCHAR(1) DEFAULT NULL,
  I_VERSION NUMERIC(11) DEFAULT NULL,
  C_BAG_CODE VARCHAR(32) DEFAULT NULL,
  C_CURRENCY VARCHAR(4) DEFAULT NULL,
  C_RESERVE VARCHAR(10) DEFAULT NULL,
  C_PATHCODE VARCHAR(64) DEFAULT NULL,
  C_TRAN_DATE VARCHAR(8) DEFAULT NULL,
  C_PART_MONTHDAY VARCHAR(4) NOT NULL,
  I_TD_TRAN_AMT NUMERIC(10,2) DEFAULT NULL,
  PRIMARY KEY (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";
create index I1_cml_stride_transfer_record on cml_stride_transfer_record (
   C_BAG_CODE DESC
);
create index I2_cml_stride_transfer_record on cml_stride_transfer_record (
   C_BANK_CODE DESC
);
create index I3_cml_stride_transfer_record on cml_stride_transfer_record (
   C_PATHCODE DESC
);
create index I4_cml_stride_transfer_record on cml_stride_transfer_record (
   C_TRAN_DATE DESC
);
CREATE TABLE cml_stride_import_records(
   C_ID         VARCHAR(32)     not null,
  C_PARENT_ID VARCHAR(32) DEFAULT NULL,
  C_BAG_CODE VARCHAR(32) DEFAULT NULL,
  C_FILE_NAME VARCHAR(128) DEFAULT NULL,
  C_UPLOAD_TIME VARCHAR(14) DEFAULT NULL,
  C_OPERATER_ID VARCHAR(32) DEFAULT NULL,
  C_OPERATE_STATUS VARCHAR(2) DEFAULT NULL,
  I_BAG_COUNT NUMERIC(11) DEFAULT NULL,
  I_FSN_COUNT NUMERIC(11) DEFAULT NULL,
  C_PART_MONTHDAY VARCHAR(4) NOT NULL,
  C_PATHCODE VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (C_ID)
)
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";

create index I1_cml_stride_import_records on cml_stride_import_records (
   C_BAG_CODE DESC
);
create index I2_cml_stride_import_records on cml_stride_import_records (
   C_PATHCODE DESC
);
create index I3_cml_stride_import_records on cml_stride_import_records (
   C_UPLOAD_TIME DESC
);
create index I4_cml_stride_import_records on cml_stride_import_records (
   C_PARENT_ID DESC
);
CREATE TABLE cml_stride_rfid_ref(
   C_ID         VARCHAR(32)     not null,
  C_BAG_CODE VARCHAR(32) NOT NULL,
  C_RFID_CODE VARCHAR(32) NOT NULL,
  PRIMARY KEY (C_ID)
);
create index I1_cml_stride_rfid_ref on cml_stride_rfid_ref (
   C_RFID_CODE DESC
);
CREATE TABLE cml_stride_bundle_ref(
   C_ID         VARCHAR(32)     not null,
  C_BAG_CODE VARCHAR(32) NOT NULL,
  C_BUNDLE_CODE VARCHAR(32) NOT NULL,
  PRIMARY KEY (C_ID)
);
create index I1_cml_stride_bundle_ref on cml_stride_bundle_ref (
   C_BAG_CODE DESC
);

-- create view
create or replace view v_usr_roleprivi_info as
(
	select up.c_id as c_priviid, up.c_menuid as c_parentid, si1.c_name as c_parentname, up.c_buttonid as c_childid,
		   si.c_name as c_childname, si.c_language, '1' as c_isbutton
	from menu_button mb, sys_i18n si,usr_privilege up, sys_i18n si1
	where mb.c_id = si.c_referenceid
		  and mb.c_id = up.c_buttonid
		  and up.c_menuid = si1.c_referenceid
		  and si.c_language = si1.c_language)
	union
	(select up.c_id as c_priviid, mi.c_parentid, si1.c_name as c_parentname, mi.c_id as c_childid,
		   si.c_name as c_childname, si.c_language, '0' as c_isbutton
	from usr_privilege up, menu_info mi left outer join sys_i18n si on mi.c_id = si.c_referenceid
		 left outer join sys_i18n si1 on mi.c_parentid = si1.c_referenceid and si.c_language = si1.c_language
	where mi.c_id = up.c_menuid
		  and up.c_buttonid is null
);

--
create or replace view v_usr_userallrole as
(
	select distinct ug.C_USERID, gr.C_ROLEID from USR_GRPROLE gr, USR_USERGRP ug
	where gr.C_GRPID = ug.C_GRPID
)
union
(
	select ur.c_userid, ur.C_ROLEID from USR_USERROLE ur
);

--
create or replace view v_usr_userinfo as
(
	select distinct ur.C_USERID, rp.c_priviid as c_priviId
	from v_usr_userallrole ur
	left outer join USR_ROLEPRIVI rp on ur.C_ROLEID = rp.C_ROLEID
);
-- 鍜屾爣鍑嗙増鏍″锛屾柊澧炶〃 from ysh
create table MULTI_DATABASE  (
   C_ID                 varchar(32)            not null,
   C_URL		        varchar(64)            not null,
   C_USERNAME           varchar(32)		       not null,
   C_PASSWORD           varchar(32)		       not null,
   C_IP                 varchar(32)		       not null,
   C_TMA_PORT           varchar(64),
   C_TMC_PORT           varchar(64),
   C_TMF_PORT           varchar(64),
   C_PATHCODES          varchar(1000),
   C_STATUS             varchar(2),
   D_OPERATE_DATE       TIMESTAMP,
   C_SERVER_PARAMETER   varchar(200),
   C_STATUS_TIME        TIMESTAMP,
   C_CPU_USAGE          varchar(64),
   C_MEMORY_USAGE       varchar(64),
   C_DISK_IO		varchar(200),
   primary key (C_ID)
);

create table CML_INFO_BYHAND  (
   C_ID         varchar(32)     not null,
   C_ORGID              VARCHAR(32),
   C_CURRENCY VARCHAR(6) DEFAULT NULL, 
   I_HUNDRED_COUNT NUMERIC(20) DEFAULT NULL, 
   I_FIFTY_COUNT NUMERIC(20) DEFAULT NULL, 
   I_TWENTY_COUNT NUMERIC(20) DEFAULT NULL, 
   I_TEN_COUNT NUMERIC(20) DEFAULT NULL, 
   I_FIVE_COUNT NUMERIC(20) DEFAULT NULL, 
   I_ONE_COUNT numeric(20) DEFAULT NULL, 
   C_TD_OPERATOR     varchar(32),
   C_PATHCODE varchar(64) DEFAULT NULL, 
   C_TRAN_TIME varchar(20) DEFAULT NULL, 
   C_TRAN_TYPE varchar(8) DEFAULT NULL, 
   primary key (C_ID)
);

CREATE TABLE cml_statistic_record ( 
 C_TRAN_ID varchar(32) NOT NULL, 
 C_CURRENCY varchar(6) DEFAULT NULL, 
 C_DENOMINATION varchar(8) DEFAULT NULL, 
 C_TERM_CODE varchar(32) DEFAULT NULL, 
 C_TERM_TYPE varchar(8) DEFAULT NULL, 
 C_TRAN_TIME varchar(20) DEFAULT NULL, 
 I_TRAN_TRUECOUNT decimal(8,0) DEFAULT NULL, 
 I_TRAN_SUSPECCOUNT decimal(8,0) DEFAULT NULL, 
 I_TRAN_OLDCOUNT decimal(8,0) DEFAULT NULL, 
 C_PATHCODE varchar(64) DEFAULT NULL, 
 C_PART_MONTHDAY varchar(4) DEFAULT NULL, 
 PRIMARY KEY (C_TRAN_ID,C_PART_MONTHDAY,C_CURRENCY,C_DENOMINATION), 
 KEY I2_CML_STATISTIC_RECORD (C_PATHCODE) 
) 
partition by RANGE (C_PART_MONTHDAY)
(
  partition P_0101 STARTING '0101' ENDING '0101',
  partition P_0102 STARTING '0102' ENDING '0102',
  partition P_0103 STARTING '0103' ENDING '0103',
  partition P_0104 STARTING '0104' ENDING '0104',
  partition P_0105 STARTING '0105' ENDING '0105',
  partition P_0106 STARTING '0106' ENDING '0106',
  partition P_0107 STARTING '0107' ENDING '0107',
  partition P_0108 STARTING '0108' ENDING '0108',
  partition P_0109 STARTING '0109' ENDING '0109',
  partition P_0110 STARTING '0110' ENDING '0110',
  partition P_0111 STARTING '0111' ENDING '0111',
  partition P_0112 STARTING '0112' ENDING '0112',
  partition P_0113 STARTING '0113' ENDING '0113',
  partition P_0114 STARTING '0114' ENDING '0114',
  partition P_0115 STARTING '0115' ENDING '0115',
  partition P_0116 STARTING '0116' ENDING '0116',
  partition P_0117 STARTING '0117' ENDING '0117',
  partition P_0118 STARTING '0118' ENDING '0118',
  partition P_0119 STARTING '0119' ENDING '0119',
  partition P_0120 STARTING '0120' ENDING '0120',
  partition P_0121 STARTING '0121' ENDING '0121',
  partition P_0122 STARTING '0122' ENDING '0122',
  partition P_0123 STARTING '0123' ENDING '0123',
  partition P_0124 STARTING '0124' ENDING '0124',
  partition P_0125 STARTING '0125' ENDING '0125',
  partition P_0126 STARTING '0126' ENDING '0126',
  partition P_0127 STARTING '0127' ENDING '0127',
  partition P_0128 STARTING '0128' ENDING '0128',
  partition P_0129 STARTING '0129' ENDING '0129',
  partition P_0130 STARTING '0130' ENDING '0130',
  partition P_0131 STARTING '0131' ENDING '0131',
  partition P_0201 STARTING '0201' ENDING '0201',
  partition P_0202 STARTING '0202' ENDING '0202',
  partition P_0203 STARTING '0203' ENDING '0203',
  partition P_0204 STARTING '0204' ENDING '0204',
  partition P_0205 STARTING '0205' ENDING '0205',
  partition P_0206 STARTING '0206' ENDING '0206',
  partition P_0207 STARTING '0207' ENDING '0207',
  partition P_0208 STARTING '0208' ENDING '0208',
  partition P_0209 STARTING '0209' ENDING '0209',
  partition P_0210 STARTING '0210' ENDING '0210',
  partition P_0211 STARTING '0211' ENDING '0211',
  partition P_0212 STARTING '0212' ENDING '0212',
  partition P_0213 STARTING '0213' ENDING '0213',
  partition P_0214 STARTING '0214' ENDING '0214',
  partition P_0215 STARTING '0215' ENDING '0215',
  partition P_0216 STARTING '0216' ENDING '0216',
  partition P_0217 STARTING '0217' ENDING '0217',
  partition P_0218 STARTING '0218' ENDING '0218',
  partition P_0219 STARTING '0219' ENDING '0219',
  partition P_0220 STARTING '0220' ENDING '0220',
  partition P_0221 STARTING '0221' ENDING '0221',
  partition P_0222 STARTING '0222' ENDING '0222',
  partition P_0223 STARTING '0223' ENDING '0223',
  partition P_0224 STARTING '0224' ENDING '0224',
  partition P_0225 STARTING '0225' ENDING '0225',
  partition P_0226 STARTING '0226' ENDING '0226',
  partition P_0227 STARTING '0227' ENDING '0227',
  partition P_0228 STARTING '0228' ENDING '0228',
  partition P_0229 STARTING '0229' ENDING '0229',
  partition P_0301 STARTING '0301' ENDING '0301',
  partition P_0302 STARTING '0302' ENDING '0302',
  partition P_0303 STARTING '0303' ENDING '0303',
  partition P_0304 STARTING '0304' ENDING '0304',
  partition P_0305 STARTING '0305' ENDING '0305',
  partition P_0306 STARTING '0306' ENDING '0306',
  partition P_0307 STARTING '0307' ENDING '0307',
  partition P_0308 STARTING '0308' ENDING '0308',
  partition P_0309 STARTING '0309' ENDING '0309',
  partition P_0310 STARTING '0310' ENDING '0310',
  partition P_0311 STARTING '0311' ENDING '0311',
  partition P_0312 STARTING '0312' ENDING '0312',
  partition P_0313 STARTING '0313' ENDING '0313',
  partition P_0314 STARTING '0314' ENDING '0314',
  partition P_0315 STARTING '0315' ENDING '0315',
  partition P_0316 STARTING '0316' ENDING '0316',
  partition P_0317 STARTING '0317' ENDING '0317',
  partition P_0318 STARTING '0318' ENDING '0318',
  partition P_0319 STARTING '0319' ENDING '0319',
  partition P_0320 STARTING '0320' ENDING '0320',
  partition P_0321 STARTING '0321' ENDING '0321',
  partition P_0322 STARTING '0322' ENDING '0322',
  partition P_0323 STARTING '0323' ENDING '0323',
  partition P_0324 STARTING '0324' ENDING '0324',
  partition P_0325 STARTING '0325' ENDING '0325',
  partition P_0326 STARTING '0326' ENDING '0326',
  partition P_0327 STARTING '0327' ENDING '0327',
  partition P_0328 STARTING '0328' ENDING '0328',
  partition P_0329 STARTING '0329' ENDING '0329',
  partition P_0330 STARTING '0330' ENDING '0330',
  partition P_0331 STARTING '0331' ENDING '0331',
  partition P_0401 STARTING '0401' ENDING '0401',
  partition P_0402 STARTING '0402' ENDING '0402',
  partition P_0403 STARTING '0403' ENDING '0403',
  partition P_0404 STARTING '0404' ENDING '0404',
  partition P_0405 STARTING '0405' ENDING '0405',
  partition P_0406 STARTING '0406' ENDING '0406',
  partition P_0407 STARTING '0407' ENDING '0407',
  partition P_0408 STARTING '0408' ENDING '0408',
  partition P_0409 STARTING '0409' ENDING '0409',
  partition P_0410 STARTING '0410' ENDING '0410',
  partition P_0411 STARTING '0411' ENDING '0411',
  partition P_0412 STARTING '0412' ENDING '0412',
  partition P_0413 STARTING '0413' ENDING '0413',
  partition P_0414 STARTING '0414' ENDING '0414',
  partition P_0415 STARTING '0415' ENDING '0415',
  partition P_0416 STARTING '0416' ENDING '0416',
  partition P_0417 STARTING '0417' ENDING '0417',
  partition P_0418 STARTING '0418' ENDING '0418',
  partition P_0419 STARTING '0419' ENDING '0419',
  partition P_0420 STARTING '0420' ENDING '0420',
  partition P_0421 STARTING '0421' ENDING '0421',
  partition P_0422 STARTING '0422' ENDING '0422',
  partition P_0423 STARTING '0423' ENDING '0423',
  partition P_0424 STARTING '0424' ENDING '0424',
  partition P_0425 STARTING '0425' ENDING '0425',
  partition P_0426 STARTING '0426' ENDING '0426',
  partition P_0427 STARTING '0427' ENDING '0427',
  partition P_0428 STARTING '0428' ENDING '0428',
  partition P_0429 STARTING '0429' ENDING '0429',
  partition P_0430 STARTING '0430' ENDING '0430',
  partition P_0501 STARTING '0501' ENDING '0501',
  partition P_0502 STARTING '0502' ENDING '0502',
  partition P_0503 STARTING '0503' ENDING '0503',
  partition P_0504 STARTING '0504' ENDING '0504',
  partition P_0505 STARTING '0505' ENDING '0505',
  partition P_0506 STARTING '0506' ENDING '0506',
  partition P_0507 STARTING '0507' ENDING '0507',
  partition P_0508 STARTING '0508' ENDING '0508',
  partition P_0509 STARTING '0509' ENDING '0509',
  partition P_0510 STARTING '0510' ENDING '0510',
  partition P_0511 STARTING '0511' ENDING '0511',
  partition P_0512 STARTING '0512' ENDING '0512',
  partition P_0513 STARTING '0513' ENDING '0513',
  partition P_0514 STARTING '0514' ENDING '0514',
  partition P_0515 STARTING '0515' ENDING '0515',
  partition P_0516 STARTING '0516' ENDING '0516',
  partition P_0517 STARTING '0517' ENDING '0517',
  partition P_0518 STARTING '0518' ENDING '0518',
  partition P_0519 STARTING '0519' ENDING '0519',
  partition P_0520 STARTING '0520' ENDING '0520',
  partition P_0521 STARTING '0521' ENDING '0521',
  partition P_0522 STARTING '0522' ENDING '0522',
  partition P_0523 STARTING '0523' ENDING '0523',
  partition P_0524 STARTING '0524' ENDING '0524',
  partition P_0525 STARTING '0525' ENDING '0525',
  partition P_0526 STARTING '0526' ENDING '0526',
  partition P_0527 STARTING '0527' ENDING '0527',
  partition P_0528 STARTING '0528' ENDING '0528',
  partition P_0529 STARTING '0529' ENDING '0529',
  partition P_0530 STARTING '0530' ENDING '0530',
  partition P_0531 STARTING '0531' ENDING '0531',
  partition P_0601 STARTING '0601' ENDING '0601',
  partition P_0602 STARTING '0602' ENDING '0602',
  partition P_0603 STARTING '0603' ENDING '0603',
  partition P_0604 STARTING '0604' ENDING '0604',
  partition P_0605 STARTING '0605' ENDING '0605',
  partition P_0606 STARTING '0606' ENDING '0606',
  partition P_0607 STARTING '0607' ENDING '0607',
  partition P_0608 STARTING '0608' ENDING '0608',
  partition P_0609 STARTING '0609' ENDING '0609',
  partition P_0610 STARTING '0610' ENDING '0610',
  partition P_0611 STARTING '0611' ENDING '0611',
  partition P_0612 STARTING '0612' ENDING '0612',
  partition P_0613 STARTING '0613' ENDING '0613',
  partition P_0614 STARTING '0614' ENDING '0614',
  partition P_0615 STARTING '0615' ENDING '0615',
  partition P_0616 STARTING '0616' ENDING '0616',
  partition P_0617 STARTING '0617' ENDING '0617',
  partition P_0618 STARTING '0618' ENDING '0618',
  partition P_0619 STARTING '0619' ENDING '0619',
  partition P_0620 STARTING '0620' ENDING '0620',
  partition P_0621 STARTING '0621' ENDING '0621',
  partition P_0622 STARTING '0622' ENDING '0622',
  partition P_0623 STARTING '0623' ENDING '0623',
  partition P_0624 STARTING '0624' ENDING '0624',
  partition P_0625 STARTING '0625' ENDING '0625',
  partition P_0626 STARTING '0626' ENDING '0626',
  partition P_0627 STARTING '0627' ENDING '0627',
  partition P_0628 STARTING '0628' ENDING '0628',
  partition P_0629 STARTING '0629' ENDING '0629',
  partition P_0630 STARTING '0630' ENDING '0630',
  partition P_0701 STARTING '0701' ENDING '0701',
  partition P_0702 STARTING '0702' ENDING '0702',
  partition P_0703 STARTING '0703' ENDING '0703',
  partition P_0704 STARTING '0704' ENDING '0704',
  partition P_0705 STARTING '0705' ENDING '0705',
  partition P_0706 STARTING '0706' ENDING '0706',
  partition P_0707 STARTING '0707' ENDING '0707',
  partition P_0708 STARTING '0708' ENDING '0708',
  partition P_0709 STARTING '0709' ENDING '0709',
  partition P_0710 STARTING '0710' ENDING '0710',
  partition P_0711 STARTING '0711' ENDING '0711',
  partition P_0712 STARTING '0712' ENDING '0712',
  partition P_0713 STARTING '0713' ENDING '0713',
  partition P_0714 STARTING '0714' ENDING '0714',
  partition P_0715 STARTING '0715' ENDING '0715',
  partition P_0716 STARTING '0716' ENDING '0716',
  partition P_0717 STARTING '0717' ENDING '0717',
  partition P_0718 STARTING '0718' ENDING '0718',
  partition P_0719 STARTING '0719' ENDING '0719',
  partition P_0720 STARTING '0720' ENDING '0720',
  partition P_0721 STARTING '0721' ENDING '0721',
  partition P_0722 STARTING '0722' ENDING '0722',
  partition P_0723 STARTING '0723' ENDING '0723',
  partition P_0724 STARTING '0724' ENDING '0724',
  partition P_0725 STARTING '0725' ENDING '0725',
  partition P_0726 STARTING '0726' ENDING '0726',
  partition P_0727 STARTING '0727' ENDING '0727',
  partition P_0728 STARTING '0728' ENDING '0728',
  partition P_0729 STARTING '0729' ENDING '0729',
  partition P_0730 STARTING '0730' ENDING '0730',
  partition P_0731 STARTING '0731' ENDING '0731',
  partition P_0801 STARTING '0801' ENDING '0801',
  partition P_0802 STARTING '0802' ENDING '0802',
  partition P_0803 STARTING '0803' ENDING '0803',
  partition P_0804 STARTING '0804' ENDING '0804',
  partition P_0805 STARTING '0805' ENDING '0805',
  partition P_0806 STARTING '0806' ENDING '0806',
  partition P_0807 STARTING '0807' ENDING '0807',
  partition P_0808 STARTING '0808' ENDING '0808',
  partition P_0809 STARTING '0809' ENDING '0809',
  partition P_0810 STARTING '0810' ENDING '0810',
  partition P_0811 STARTING '0811' ENDING '0811',
  partition P_0812 STARTING '0812' ENDING '0812',
  partition P_0813 STARTING '0813' ENDING '0813',
  partition P_0814 STARTING '0814' ENDING '0814',
  partition P_0815 STARTING '0815' ENDING '0815',
  partition P_0816 STARTING '0816' ENDING '0816',
  partition P_0817 STARTING '0817' ENDING '0817',
  partition P_0818 STARTING '0818' ENDING '0818',
  partition P_0819 STARTING '0819' ENDING '0819',
  partition P_0820 STARTING '0820' ENDING '0820',
  partition P_0821 STARTING '0821' ENDING '0821',
  partition P_0822 STARTING '0822' ENDING '0822',
  partition P_0823 STARTING '0823' ENDING '0823',
  partition P_0824 STARTING '0824' ENDING '0824',
  partition P_0825 STARTING '0825' ENDING '0825',
  partition P_0826 STARTING '0826' ENDING '0826',
  partition P_0827 STARTING '0827' ENDING '0827',
  partition P_0828 STARTING '0828' ENDING '0828',
  partition P_0829 STARTING '0829' ENDING '0829',
  partition P_0830 STARTING '0830' ENDING '0830',
  partition P_0831 STARTING '0831' ENDING '0831',
  partition P_0901 STARTING '0901' ENDING '0901',
  partition P_0902 STARTING '0902' ENDING '0902',
  partition P_0903 STARTING '0903' ENDING '0903',
  partition P_0904 STARTING '0904' ENDING '0904',
  partition P_0905 STARTING '0905' ENDING '0905',
  partition P_0906 STARTING '0906' ENDING '0906',
  partition P_0907 STARTING '0907' ENDING '0907',
  partition P_0908 STARTING '0908' ENDING '0908',
  partition P_0909 STARTING '0909' ENDING '0909',
  partition P_0910 STARTING '0910' ENDING '0910',
  partition P_0911 STARTING '0911' ENDING '0911',
  partition P_0912 STARTING '0912' ENDING '0912',
  partition P_0913 STARTING '0913' ENDING '0913',
  partition P_0914 STARTING '0914' ENDING '0914',
  partition P_0915 STARTING '0915' ENDING '0915',
  partition P_0916 STARTING '0916' ENDING '0916',
  partition P_0917 STARTING '0917' ENDING '0917',
  partition P_0918 STARTING '0918' ENDING '0918',
  partition P_0919 STARTING '0919' ENDING '0919',
  partition P_0920 STARTING '0920' ENDING '0920',
  partition P_0921 STARTING '0921' ENDING '0921',
  partition P_0922 STARTING '0922' ENDING '0922',
  partition P_0923 STARTING '0923' ENDING '0923',
  partition P_0924 STARTING '0924' ENDING '0924',
  partition P_0925 STARTING '0925' ENDING '0925',
  partition P_0926 STARTING '0926' ENDING '0926',
  partition P_0927 STARTING '0927' ENDING '0927',
  partition P_0928 STARTING '0928' ENDING '0928',
  partition P_0929 STARTING '0929' ENDING '0929',
  partition P_0930 STARTING '0930' ENDING '0930',
  partition P_1001 STARTING '1001' ENDING '1001',
  partition P_1002 STARTING '1002' ENDING '1002',
  partition P_1003 STARTING '1003' ENDING '1003',
  partition P_1004 STARTING '1004' ENDING '1004',
  partition P_1005 STARTING '1005' ENDING '1005',
  partition P_1006 STARTING '1006' ENDING '1006',
  partition P_1007 STARTING '1007' ENDING '1007',
  partition P_1008 STARTING '1008' ENDING '1008',
  partition P_1009 STARTING '1009' ENDING '1009',
  partition P_1010 STARTING '1010' ENDING '1010',
  partition P_1011 STARTING '1011' ENDING '1011',
  partition P_1012 STARTING '1012' ENDING '1012',
  partition P_1013 STARTING '1013' ENDING '1013',
  partition P_1014 STARTING '1014' ENDING '1014',
  partition P_1015 STARTING '1015' ENDING '1015',
  partition P_1016 STARTING '1016' ENDING '1016',
  partition P_1017 STARTING '1017' ENDING '1017',
  partition P_1018 STARTING '1018' ENDING '1018',
  partition P_1019 STARTING '1019' ENDING '1019',
  partition P_1020 STARTING '1020' ENDING '1020',
  partition P_1021 STARTING '1021' ENDING '1021',
  partition P_1022 STARTING '1022' ENDING '1022',
  partition P_1023 STARTING '1023' ENDING '1023',
  partition P_1024 STARTING '1024' ENDING '1024',
  partition P_1025 STARTING '1025' ENDING '1025',
  partition P_1026 STARTING '1026' ENDING '1026',
  partition P_1027 STARTING '1027' ENDING '1027',
  partition P_1028 STARTING '1028' ENDING '1028',
  partition P_1029 STARTING '1029' ENDING '1029',
  partition P_1030 STARTING '1030' ENDING '1030',
  partition P_1031 STARTING '1031' ENDING '1031',
  partition P_1101 STARTING '1101' ENDING '1101',
  partition P_1102 STARTING '1102' ENDING '1102',
  partition P_1103 STARTING '1103' ENDING '1103',
  partition P_1104 STARTING '1104' ENDING '1104',
  partition P_1105 STARTING '1105' ENDING '1105',
  partition P_1106 STARTING '1106' ENDING '1106',
  partition P_1107 STARTING '1107' ENDING '1107',
  partition P_1108 STARTING '1108' ENDING '1108',
  partition P_1109 STARTING '1109' ENDING '1109',
  partition P_1110 STARTING '1110' ENDING '1110',
  partition P_1111 STARTING '1111' ENDING '1111',
  partition P_1112 STARTING '1112' ENDING '1112',
  partition P_1113 STARTING '1113' ENDING '1113',
  partition P_1114 STARTING '1114' ENDING '1114',
  partition P_1115 STARTING '1115' ENDING '1115',
  partition P_1116 STARTING '1116' ENDING '1116',
  partition P_1117 STARTING '1117' ENDING '1117',
  partition P_1118 STARTING '1118' ENDING '1118',
  partition P_1119 STARTING '1119' ENDING '1119',
  partition P_1120 STARTING '1120' ENDING '1120',
  partition P_1121 STARTING '1121' ENDING '1121',
  partition P_1122 STARTING '1122' ENDING '1122',
  partition P_1123 STARTING '1123' ENDING '1123',
  partition P_1124 STARTING '1124' ENDING '1124',
  partition P_1125 STARTING '1125' ENDING '1125',
  partition P_1126 STARTING '1126' ENDING '1126',
  partition P_1127 STARTING '1127' ENDING '1127',
  partition P_1128 STARTING '1128' ENDING '1128',
  partition P_1129 STARTING '1129' ENDING '1129',
  partition P_1130 STARTING '1130' ENDING '1130',
  partition P_1201 STARTING '1201' ENDING '1201',
  partition P_1202 STARTING '1202' ENDING '1202',
  partition P_1203 STARTING '1203' ENDING '1203',
  partition P_1204 STARTING '1204' ENDING '1204',
  partition P_1205 STARTING '1205' ENDING '1205',
  partition P_1206 STARTING '1206' ENDING '1206',
  partition P_1207 STARTING '1207' ENDING '1207',
  partition P_1208 STARTING '1208' ENDING '1208',
  partition P_1209 STARTING '1209' ENDING '1209',
  partition P_1210 STARTING '1210' ENDING '1210',
  partition P_1211 STARTING '1211' ENDING '1211',
  partition P_1212 STARTING '1212' ENDING '1212',
  partition P_1213 STARTING '1213' ENDING '1213',
  partition P_1214 STARTING '1214' ENDING '1214',
  partition P_1215 STARTING '1215' ENDING '1215',
  partition P_1216 STARTING '1216' ENDING '1216',
  partition P_1217 STARTING '1217' ENDING '1217',
  partition P_1218 STARTING '1218' ENDING '1218',
  partition P_1219 STARTING '1219' ENDING '1219',
  partition P_1220 STARTING '1220' ENDING '1220',
  partition P_1221 STARTING '1221' ENDING '1221',
  partition P_1222 STARTING '1222' ENDING '1222',
  partition P_1223 STARTING '1223' ENDING '1223',
  partition P_1224 STARTING '1224' ENDING '1224',
  partition P_1225 STARTING '1225' ENDING '1225',
  partition P_1226 STARTING '1226' ENDING '1226',
  partition P_1227 STARTING '1227' ENDING '1227',
  partition P_1228 STARTING '1228' ENDING '1228',
  partition P_1229 STARTING '1229' ENDING '1229',
  partition P_1230 STARTING '1230' ENDING '1230',
  partition P_1231 STARTING '1231' ENDING '1231'
) in "FEELVIEW_DATA" INDEX in "FEELVIEW_INDEX";


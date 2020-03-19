use feelview;

-- CML_SENT_INFOS_HIS_0101
create table CML_SENT_INFOS_HIS_0101
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0101 on CML_SENT_INFOS_HIS_0101 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0102
create table CML_SENT_INFOS_HIS_0102
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0102 on CML_SENT_INFOS_HIS_0102 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0103
create table CML_SENT_INFOS_HIS_0103
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0103 on CML_SENT_INFOS_HIS_0103 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0104
create table CML_SENT_INFOS_HIS_0104
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0104 on CML_SENT_INFOS_HIS_0104 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0105
create table CML_SENT_INFOS_HIS_0105
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0105 on CML_SENT_INFOS_HIS_0105 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0106
create table CML_SENT_INFOS_HIS_0106
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0106 on CML_SENT_INFOS_HIS_0106 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0107
create table CML_SENT_INFOS_HIS_0107
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0107 on CML_SENT_INFOS_HIS_0107 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0108
create table CML_SENT_INFOS_HIS_0108
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0108 on CML_SENT_INFOS_HIS_0108 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0109
create table CML_SENT_INFOS_HIS_0109
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0109 on CML_SENT_INFOS_HIS_0109 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0110
create table CML_SENT_INFOS_HIS_0110
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0110 on CML_SENT_INFOS_HIS_0110 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0111
create table CML_SENT_INFOS_HIS_0111
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0111 on CML_SENT_INFOS_HIS_0111 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0112
create table CML_SENT_INFOS_HIS_0112
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0112 on CML_SENT_INFOS_HIS_0112 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0113
create table CML_SENT_INFOS_HIS_0113
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0113 on CML_SENT_INFOS_HIS_0113 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0114
create table CML_SENT_INFOS_HIS_0114
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0114 on CML_SENT_INFOS_HIS_0114 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0115
create table CML_SENT_INFOS_HIS_0115
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0115 on CML_SENT_INFOS_HIS_0115 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0116
create table CML_SENT_INFOS_HIS_0116
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0116 on CML_SENT_INFOS_HIS_0116 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0117
create table CML_SENT_INFOS_HIS_0117
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0117 on CML_SENT_INFOS_HIS_0117 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0118
create table CML_SENT_INFOS_HIS_0118
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0118 on CML_SENT_INFOS_HIS_0118 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0119
create table CML_SENT_INFOS_HIS_0119
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0119 on CML_SENT_INFOS_HIS_0119 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0120
create table CML_SENT_INFOS_HIS_0120
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0120 on CML_SENT_INFOS_HIS_0120 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0121
create table CML_SENT_INFOS_HIS_0121
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0121 on CML_SENT_INFOS_HIS_0121 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0122
create table CML_SENT_INFOS_HIS_0122
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0122 on CML_SENT_INFOS_HIS_0122 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0123
create table CML_SENT_INFOS_HIS_0123
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0123 on CML_SENT_INFOS_HIS_0123 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0124
create table CML_SENT_INFOS_HIS_0124
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0124 on CML_SENT_INFOS_HIS_0124 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0125
create table CML_SENT_INFOS_HIS_0125
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0125 on CML_SENT_INFOS_HIS_0125 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0126
create table CML_SENT_INFOS_HIS_0126
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0126 on CML_SENT_INFOS_HIS_0126 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0127
create table CML_SENT_INFOS_HIS_0127
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0127 on CML_SENT_INFOS_HIS_0127 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0128
create table CML_SENT_INFOS_HIS_0128
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0128 on CML_SENT_INFOS_HIS_0128 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0129
create table CML_SENT_INFOS_HIS_0129
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0129 on CML_SENT_INFOS_HIS_0129 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0130
create table CML_SENT_INFOS_HIS_0130
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0130 on CML_SENT_INFOS_HIS_0130 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0131
create table CML_SENT_INFOS_HIS_0131
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0131 on CML_SENT_INFOS_HIS_0131 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0201
create table CML_SENT_INFOS_HIS_0201
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0201 on CML_SENT_INFOS_HIS_0201 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0202
create table CML_SENT_INFOS_HIS_0202
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0202 on CML_SENT_INFOS_HIS_0202 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0203
create table CML_SENT_INFOS_HIS_0203
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0203 on CML_SENT_INFOS_HIS_0203 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0204
create table CML_SENT_INFOS_HIS_0204
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0204 on CML_SENT_INFOS_HIS_0204 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0205
create table CML_SENT_INFOS_HIS_0205
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0205 on CML_SENT_INFOS_HIS_0205 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0206
create table CML_SENT_INFOS_HIS_0206
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0206 on CML_SENT_INFOS_HIS_0206 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0207
create table CML_SENT_INFOS_HIS_0207
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0207 on CML_SENT_INFOS_HIS_0207 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0208
create table CML_SENT_INFOS_HIS_0208
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0208 on CML_SENT_INFOS_HIS_0208 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0209
create table CML_SENT_INFOS_HIS_0209
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0209 on CML_SENT_INFOS_HIS_0209 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0210
create table CML_SENT_INFOS_HIS_0210
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0210 on CML_SENT_INFOS_HIS_0210 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0211
create table CML_SENT_INFOS_HIS_0211
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0211 on CML_SENT_INFOS_HIS_0211 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0212
create table CML_SENT_INFOS_HIS_0212
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0212 on CML_SENT_INFOS_HIS_0212 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0213
create table CML_SENT_INFOS_HIS_0213
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0213 on CML_SENT_INFOS_HIS_0213 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0214
create table CML_SENT_INFOS_HIS_0214
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0214 on CML_SENT_INFOS_HIS_0214 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0215
create table CML_SENT_INFOS_HIS_0215
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0215 on CML_SENT_INFOS_HIS_0215 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0216
create table CML_SENT_INFOS_HIS_0216
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0216 on CML_SENT_INFOS_HIS_0216 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0217
create table CML_SENT_INFOS_HIS_0217
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0217 on CML_SENT_INFOS_HIS_0217 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0218
create table CML_SENT_INFOS_HIS_0218
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0218 on CML_SENT_INFOS_HIS_0218 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0219
create table CML_SENT_INFOS_HIS_0219
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0219 on CML_SENT_INFOS_HIS_0219 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0220
create table CML_SENT_INFOS_HIS_0220
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0220 on CML_SENT_INFOS_HIS_0220 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0221
create table CML_SENT_INFOS_HIS_0221
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0221 on CML_SENT_INFOS_HIS_0221 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0222
create table CML_SENT_INFOS_HIS_0222
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0222 on CML_SENT_INFOS_HIS_0222 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0223
create table CML_SENT_INFOS_HIS_0223
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0223 on CML_SENT_INFOS_HIS_0223 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0224
create table CML_SENT_INFOS_HIS_0224
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0224 on CML_SENT_INFOS_HIS_0224 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0225
create table CML_SENT_INFOS_HIS_0225
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0225 on CML_SENT_INFOS_HIS_0225 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0226
create table CML_SENT_INFOS_HIS_0226
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0226 on CML_SENT_INFOS_HIS_0226 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0227
create table CML_SENT_INFOS_HIS_0227
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0227 on CML_SENT_INFOS_HIS_0227 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0228
create table CML_SENT_INFOS_HIS_0228
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0228 on CML_SENT_INFOS_HIS_0228 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0229
create table CML_SENT_INFOS_HIS_0229
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0229 on CML_SENT_INFOS_HIS_0229 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0301
create table CML_SENT_INFOS_HIS_0301
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0301 on CML_SENT_INFOS_HIS_0301 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0302
create table CML_SENT_INFOS_HIS_0302
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0302 on CML_SENT_INFOS_HIS_0302 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0303
create table CML_SENT_INFOS_HIS_0303
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0303 on CML_SENT_INFOS_HIS_0303 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0304
create table CML_SENT_INFOS_HIS_0304
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0304 on CML_SENT_INFOS_HIS_0304 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0305
create table CML_SENT_INFOS_HIS_0305
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0305 on CML_SENT_INFOS_HIS_0305 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0306
create table CML_SENT_INFOS_HIS_0306
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0306 on CML_SENT_INFOS_HIS_0306 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0307
create table CML_SENT_INFOS_HIS_0307
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0307 on CML_SENT_INFOS_HIS_0307 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0308
create table CML_SENT_INFOS_HIS_0308
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0308 on CML_SENT_INFOS_HIS_0308 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0309
create table CML_SENT_INFOS_HIS_0309
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0309 on CML_SENT_INFOS_HIS_0309 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0310
create table CML_SENT_INFOS_HIS_0310
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0310 on CML_SENT_INFOS_HIS_0310 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0311
create table CML_SENT_INFOS_HIS_0311
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0311 on CML_SENT_INFOS_HIS_0311 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0312
create table CML_SENT_INFOS_HIS_0312
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0312 on CML_SENT_INFOS_HIS_0312 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0313
create table CML_SENT_INFOS_HIS_0313
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0313 on CML_SENT_INFOS_HIS_0313 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0314
create table CML_SENT_INFOS_HIS_0314
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0314 on CML_SENT_INFOS_HIS_0314 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0315
create table CML_SENT_INFOS_HIS_0315
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0315 on CML_SENT_INFOS_HIS_0315 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0316
create table CML_SENT_INFOS_HIS_0316
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0316 on CML_SENT_INFOS_HIS_0316 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0317
create table CML_SENT_INFOS_HIS_0317
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0317 on CML_SENT_INFOS_HIS_0317 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0318
create table CML_SENT_INFOS_HIS_0318
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0318 on CML_SENT_INFOS_HIS_0318 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0319
create table CML_SENT_INFOS_HIS_0319
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0319 on CML_SENT_INFOS_HIS_0319 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0320
create table CML_SENT_INFOS_HIS_0320
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0320 on CML_SENT_INFOS_HIS_0320 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0321
create table CML_SENT_INFOS_HIS_0321
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0321 on CML_SENT_INFOS_HIS_0321 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0322
create table CML_SENT_INFOS_HIS_0322
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0322 on CML_SENT_INFOS_HIS_0322 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0323
create table CML_SENT_INFOS_HIS_0323
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0323 on CML_SENT_INFOS_HIS_0323 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0324
create table CML_SENT_INFOS_HIS_0324
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0324 on CML_SENT_INFOS_HIS_0324 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0325
create table CML_SENT_INFOS_HIS_0325
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0325 on CML_SENT_INFOS_HIS_0325 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0326
create table CML_SENT_INFOS_HIS_0326
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0326 on CML_SENT_INFOS_HIS_0326 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0327
create table CML_SENT_INFOS_HIS_0327
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0327 on CML_SENT_INFOS_HIS_0327 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0328
create table CML_SENT_INFOS_HIS_0328
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0328 on CML_SENT_INFOS_HIS_0328 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0329
create table CML_SENT_INFOS_HIS_0329
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0329 on CML_SENT_INFOS_HIS_0329 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0330
create table CML_SENT_INFOS_HIS_0330
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0330 on CML_SENT_INFOS_HIS_0330 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0331
create table CML_SENT_INFOS_HIS_0331
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0331 on CML_SENT_INFOS_HIS_0331 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0401
create table CML_SENT_INFOS_HIS_0401
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0401 on CML_SENT_INFOS_HIS_0401 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0402
create table CML_SENT_INFOS_HIS_0402
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0402 on CML_SENT_INFOS_HIS_0402 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0403
create table CML_SENT_INFOS_HIS_0403
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0403 on CML_SENT_INFOS_HIS_0403 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0404
create table CML_SENT_INFOS_HIS_0404
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0404 on CML_SENT_INFOS_HIS_0404 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0405
create table CML_SENT_INFOS_HIS_0405
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0405 on CML_SENT_INFOS_HIS_0405 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0406
create table CML_SENT_INFOS_HIS_0406
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0406 on CML_SENT_INFOS_HIS_0406 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0407
create table CML_SENT_INFOS_HIS_0407
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0407 on CML_SENT_INFOS_HIS_0407 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0408
create table CML_SENT_INFOS_HIS_0408
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0408 on CML_SENT_INFOS_HIS_0408 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0409
create table CML_SENT_INFOS_HIS_0409
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0409 on CML_SENT_INFOS_HIS_0409 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0410
create table CML_SENT_INFOS_HIS_0410
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0410 on CML_SENT_INFOS_HIS_0410 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0411
create table CML_SENT_INFOS_HIS_0411
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0411 on CML_SENT_INFOS_HIS_0411 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0412
create table CML_SENT_INFOS_HIS_0412
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0412 on CML_SENT_INFOS_HIS_0412 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0413
create table CML_SENT_INFOS_HIS_0413
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0413 on CML_SENT_INFOS_HIS_0413 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0414
create table CML_SENT_INFOS_HIS_0414
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0414 on CML_SENT_INFOS_HIS_0414 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0415
create table CML_SENT_INFOS_HIS_0415
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0415 on CML_SENT_INFOS_HIS_0415 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0416
create table CML_SENT_INFOS_HIS_0416
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0416 on CML_SENT_INFOS_HIS_0416 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0417
create table CML_SENT_INFOS_HIS_0417
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0417 on CML_SENT_INFOS_HIS_0417 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0418
create table CML_SENT_INFOS_HIS_0418
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0418 on CML_SENT_INFOS_HIS_0418 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0419
create table CML_SENT_INFOS_HIS_0419
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0419 on CML_SENT_INFOS_HIS_0419 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0420
create table CML_SENT_INFOS_HIS_0420
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0420 on CML_SENT_INFOS_HIS_0420 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0421
create table CML_SENT_INFOS_HIS_0421
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0421 on CML_SENT_INFOS_HIS_0421 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0422
create table CML_SENT_INFOS_HIS_0422
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0422 on CML_SENT_INFOS_HIS_0422 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0423
create table CML_SENT_INFOS_HIS_0423
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0423 on CML_SENT_INFOS_HIS_0423 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0424
create table CML_SENT_INFOS_HIS_0424
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0424 on CML_SENT_INFOS_HIS_0424 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0425
create table CML_SENT_INFOS_HIS_0425
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0425 on CML_SENT_INFOS_HIS_0425 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0426
create table CML_SENT_INFOS_HIS_0426
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0426 on CML_SENT_INFOS_HIS_0426 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0427
create table CML_SENT_INFOS_HIS_0427
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0427 on CML_SENT_INFOS_HIS_0427 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0428
create table CML_SENT_INFOS_HIS_0428
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0428 on CML_SENT_INFOS_HIS_0428 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0429
create table CML_SENT_INFOS_HIS_0429
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0429 on CML_SENT_INFOS_HIS_0429 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0430
create table CML_SENT_INFOS_HIS_0430
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0430 on CML_SENT_INFOS_HIS_0430 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0501
create table CML_SENT_INFOS_HIS_0501
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0501 on CML_SENT_INFOS_HIS_0501 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0502
create table CML_SENT_INFOS_HIS_0502
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0502 on CML_SENT_INFOS_HIS_0502 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0503
create table CML_SENT_INFOS_HIS_0503
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0503 on CML_SENT_INFOS_HIS_0503 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0504
create table CML_SENT_INFOS_HIS_0504
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0504 on CML_SENT_INFOS_HIS_0504 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0505
create table CML_SENT_INFOS_HIS_0505
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0505 on CML_SENT_INFOS_HIS_0505 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0506
create table CML_SENT_INFOS_HIS_0506
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0506 on CML_SENT_INFOS_HIS_0506 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0507
create table CML_SENT_INFOS_HIS_0507
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0507 on CML_SENT_INFOS_HIS_0507 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0508
create table CML_SENT_INFOS_HIS_0508
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0508 on CML_SENT_INFOS_HIS_0508 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0509
create table CML_SENT_INFOS_HIS_0509
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0509 on CML_SENT_INFOS_HIS_0509 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0510
create table CML_SENT_INFOS_HIS_0510
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0510 on CML_SENT_INFOS_HIS_0510 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0511
create table CML_SENT_INFOS_HIS_0511
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0511 on CML_SENT_INFOS_HIS_0511 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0512
create table CML_SENT_INFOS_HIS_0512
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0512 on CML_SENT_INFOS_HIS_0512 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0513
create table CML_SENT_INFOS_HIS_0513
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0513 on CML_SENT_INFOS_HIS_0513 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0514
create table CML_SENT_INFOS_HIS_0514
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0514 on CML_SENT_INFOS_HIS_0514 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0515
create table CML_SENT_INFOS_HIS_0515
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0515 on CML_SENT_INFOS_HIS_0515 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0516
create table CML_SENT_INFOS_HIS_0516
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0516 on CML_SENT_INFOS_HIS_0516 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0517
create table CML_SENT_INFOS_HIS_0517
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0517 on CML_SENT_INFOS_HIS_0517 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0518
create table CML_SENT_INFOS_HIS_0518
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0518 on CML_SENT_INFOS_HIS_0518 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0519
create table CML_SENT_INFOS_HIS_0519
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0519 on CML_SENT_INFOS_HIS_0519 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0520
create table CML_SENT_INFOS_HIS_0520
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0520 on CML_SENT_INFOS_HIS_0520 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0521
create table CML_SENT_INFOS_HIS_0521
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0521 on CML_SENT_INFOS_HIS_0521 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0522
create table CML_SENT_INFOS_HIS_0522
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0522 on CML_SENT_INFOS_HIS_0522 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0523
create table CML_SENT_INFOS_HIS_0523
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0523 on CML_SENT_INFOS_HIS_0523 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0524
create table CML_SENT_INFOS_HIS_0524
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0524 on CML_SENT_INFOS_HIS_0524 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0525
create table CML_SENT_INFOS_HIS_0525
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0525 on CML_SENT_INFOS_HIS_0525 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0526
create table CML_SENT_INFOS_HIS_0526
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0526 on CML_SENT_INFOS_HIS_0526 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0527
create table CML_SENT_INFOS_HIS_0527
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0527 on CML_SENT_INFOS_HIS_0527 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0528
create table CML_SENT_INFOS_HIS_0528
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0528 on CML_SENT_INFOS_HIS_0528 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0529
create table CML_SENT_INFOS_HIS_0529
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0529 on CML_SENT_INFOS_HIS_0529 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0530
create table CML_SENT_INFOS_HIS_0530
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0530 on CML_SENT_INFOS_HIS_0530 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0531
create table CML_SENT_INFOS_HIS_0531
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0531 on CML_SENT_INFOS_HIS_0531 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0601
create table CML_SENT_INFOS_HIS_0601
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0601 on CML_SENT_INFOS_HIS_0601 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0602
create table CML_SENT_INFOS_HIS_0602
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0602 on CML_SENT_INFOS_HIS_0602 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0603
create table CML_SENT_INFOS_HIS_0603
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0603 on CML_SENT_INFOS_HIS_0603 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0604
create table CML_SENT_INFOS_HIS_0604
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0604 on CML_SENT_INFOS_HIS_0604 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0605
create table CML_SENT_INFOS_HIS_0605
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0605 on CML_SENT_INFOS_HIS_0605 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0606
create table CML_SENT_INFOS_HIS_0606
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0606 on CML_SENT_INFOS_HIS_0606 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0607
create table CML_SENT_INFOS_HIS_0607
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0607 on CML_SENT_INFOS_HIS_0607 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0608
create table CML_SENT_INFOS_HIS_0608
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0608 on CML_SENT_INFOS_HIS_0608 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0609
create table CML_SENT_INFOS_HIS_0609
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0609 on CML_SENT_INFOS_HIS_0609 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0610
create table CML_SENT_INFOS_HIS_0610
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0610 on CML_SENT_INFOS_HIS_0610 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0611
create table CML_SENT_INFOS_HIS_0611
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0611 on CML_SENT_INFOS_HIS_0611 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0612
create table CML_SENT_INFOS_HIS_0612
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0612 on CML_SENT_INFOS_HIS_0612 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0613
create table CML_SENT_INFOS_HIS_0613
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0613 on CML_SENT_INFOS_HIS_0613 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0614
create table CML_SENT_INFOS_HIS_0614
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0614 on CML_SENT_INFOS_HIS_0614 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0615
create table CML_SENT_INFOS_HIS_0615
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0615 on CML_SENT_INFOS_HIS_0615 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0616
create table CML_SENT_INFOS_HIS_0616
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0616 on CML_SENT_INFOS_HIS_0616 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0617
create table CML_SENT_INFOS_HIS_0617
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0617 on CML_SENT_INFOS_HIS_0617 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0618
create table CML_SENT_INFOS_HIS_0618
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0618 on CML_SENT_INFOS_HIS_0618 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0619
create table CML_SENT_INFOS_HIS_0619
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0619 on CML_SENT_INFOS_HIS_0619 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0620
create table CML_SENT_INFOS_HIS_0620
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0620 on CML_SENT_INFOS_HIS_0620 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0621
create table CML_SENT_INFOS_HIS_0621
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0621 on CML_SENT_INFOS_HIS_0621 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0622
create table CML_SENT_INFOS_HIS_0622
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0622 on CML_SENT_INFOS_HIS_0622 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0623
create table CML_SENT_INFOS_HIS_0623
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0623 on CML_SENT_INFOS_HIS_0623 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0624
create table CML_SENT_INFOS_HIS_0624
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0624 on CML_SENT_INFOS_HIS_0624 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0625
create table CML_SENT_INFOS_HIS_0625
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0625 on CML_SENT_INFOS_HIS_0625 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0626
create table CML_SENT_INFOS_HIS_0626
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0626 on CML_SENT_INFOS_HIS_0626 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0627
create table CML_SENT_INFOS_HIS_0627
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0627 on CML_SENT_INFOS_HIS_0627 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0628
create table CML_SENT_INFOS_HIS_0628
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0628 on CML_SENT_INFOS_HIS_0628 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0629
create table CML_SENT_INFOS_HIS_0629
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0629 on CML_SENT_INFOS_HIS_0629 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0630
create table CML_SENT_INFOS_HIS_0630
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0630 on CML_SENT_INFOS_HIS_0630 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0701
create table CML_SENT_INFOS_HIS_0701
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0701 on CML_SENT_INFOS_HIS_0701 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0702
create table CML_SENT_INFOS_HIS_0702
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0702 on CML_SENT_INFOS_HIS_0702 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0703
create table CML_SENT_INFOS_HIS_0703
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0703 on CML_SENT_INFOS_HIS_0703 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0704
create table CML_SENT_INFOS_HIS_0704
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0704 on CML_SENT_INFOS_HIS_0704 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0705
create table CML_SENT_INFOS_HIS_0705
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0705 on CML_SENT_INFOS_HIS_0705 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0706
create table CML_SENT_INFOS_HIS_0706
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0706 on CML_SENT_INFOS_HIS_0706 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0707
create table CML_SENT_INFOS_HIS_0707
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0707 on CML_SENT_INFOS_HIS_0707 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0708
create table CML_SENT_INFOS_HIS_0708
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0708 on CML_SENT_INFOS_HIS_0708 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0709
create table CML_SENT_INFOS_HIS_0709
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0709 on CML_SENT_INFOS_HIS_0709 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0710
create table CML_SENT_INFOS_HIS_0710
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0710 on CML_SENT_INFOS_HIS_0710 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0711
create table CML_SENT_INFOS_HIS_0711
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0711 on CML_SENT_INFOS_HIS_0711 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0712
create table CML_SENT_INFOS_HIS_0712
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0712 on CML_SENT_INFOS_HIS_0712 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0713
create table CML_SENT_INFOS_HIS_0713
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0713 on CML_SENT_INFOS_HIS_0713 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0714
create table CML_SENT_INFOS_HIS_0714
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0714 on CML_SENT_INFOS_HIS_0714 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0715
create table CML_SENT_INFOS_HIS_0715
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0715 on CML_SENT_INFOS_HIS_0715 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0716
create table CML_SENT_INFOS_HIS_0716
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0716 on CML_SENT_INFOS_HIS_0716 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0717
create table CML_SENT_INFOS_HIS_0717
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0717 on CML_SENT_INFOS_HIS_0717 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0718
create table CML_SENT_INFOS_HIS_0718
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0718 on CML_SENT_INFOS_HIS_0718 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0719
create table CML_SENT_INFOS_HIS_0719
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0719 on CML_SENT_INFOS_HIS_0719 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0720
create table CML_SENT_INFOS_HIS_0720
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0720 on CML_SENT_INFOS_HIS_0720 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0721
create table CML_SENT_INFOS_HIS_0721
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0721 on CML_SENT_INFOS_HIS_0721 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0722
create table CML_SENT_INFOS_HIS_0722
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0722 on CML_SENT_INFOS_HIS_0722 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0723
create table CML_SENT_INFOS_HIS_0723
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0723 on CML_SENT_INFOS_HIS_0723 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0724
create table CML_SENT_INFOS_HIS_0724
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0724 on CML_SENT_INFOS_HIS_0724 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0725
create table CML_SENT_INFOS_HIS_0725
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0725 on CML_SENT_INFOS_HIS_0725 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0726
create table CML_SENT_INFOS_HIS_0726
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0726 on CML_SENT_INFOS_HIS_0726 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0727
create table CML_SENT_INFOS_HIS_0727
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0727 on CML_SENT_INFOS_HIS_0727 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0728
create table CML_SENT_INFOS_HIS_0728
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0728 on CML_SENT_INFOS_HIS_0728 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0729
create table CML_SENT_INFOS_HIS_0729
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0729 on CML_SENT_INFOS_HIS_0729 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0730
create table CML_SENT_INFOS_HIS_0730
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0730 on CML_SENT_INFOS_HIS_0730 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0731
create table CML_SENT_INFOS_HIS_0731
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0731 on CML_SENT_INFOS_HIS_0731 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0801
create table CML_SENT_INFOS_HIS_0801
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0801 on CML_SENT_INFOS_HIS_0801 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0802
create table CML_SENT_INFOS_HIS_0802
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0802 on CML_SENT_INFOS_HIS_0802 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0803
create table CML_SENT_INFOS_HIS_0803
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0803 on CML_SENT_INFOS_HIS_0803 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0804
create table CML_SENT_INFOS_HIS_0804
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0804 on CML_SENT_INFOS_HIS_0804 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0805
create table CML_SENT_INFOS_HIS_0805
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0805 on CML_SENT_INFOS_HIS_0805 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0806
create table CML_SENT_INFOS_HIS_0806
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0806 on CML_SENT_INFOS_HIS_0806 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0807
create table CML_SENT_INFOS_HIS_0807
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0807 on CML_SENT_INFOS_HIS_0807 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0808
create table CML_SENT_INFOS_HIS_0808
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0808 on CML_SENT_INFOS_HIS_0808 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0809
create table CML_SENT_INFOS_HIS_0809
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0809 on CML_SENT_INFOS_HIS_0809 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0810
create table CML_SENT_INFOS_HIS_0810
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0810 on CML_SENT_INFOS_HIS_0810 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0811
create table CML_SENT_INFOS_HIS_0811
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0811 on CML_SENT_INFOS_HIS_0811 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0812
create table CML_SENT_INFOS_HIS_0812
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0812 on CML_SENT_INFOS_HIS_0812 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0813
create table CML_SENT_INFOS_HIS_0813
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0813 on CML_SENT_INFOS_HIS_0813 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0814
create table CML_SENT_INFOS_HIS_0814
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0814 on CML_SENT_INFOS_HIS_0814 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0815
create table CML_SENT_INFOS_HIS_0815
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0815 on CML_SENT_INFOS_HIS_0815 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0816
create table CML_SENT_INFOS_HIS_0816
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0816 on CML_SENT_INFOS_HIS_0816 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0817
create table CML_SENT_INFOS_HIS_0817
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0817 on CML_SENT_INFOS_HIS_0817 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0818
create table CML_SENT_INFOS_HIS_0818
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0818 on CML_SENT_INFOS_HIS_0818 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0819
create table CML_SENT_INFOS_HIS_0819
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0819 on CML_SENT_INFOS_HIS_0819 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0820
create table CML_SENT_INFOS_HIS_0820
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0820 on CML_SENT_INFOS_HIS_0820 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0821
create table CML_SENT_INFOS_HIS_0821
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0821 on CML_SENT_INFOS_HIS_0821 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0822
create table CML_SENT_INFOS_HIS_0822
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0822 on CML_SENT_INFOS_HIS_0822 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0823
create table CML_SENT_INFOS_HIS_0823
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0823 on CML_SENT_INFOS_HIS_0823 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0824
create table CML_SENT_INFOS_HIS_0824
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0824 on CML_SENT_INFOS_HIS_0824 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0825
create table CML_SENT_INFOS_HIS_0825
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0825 on CML_SENT_INFOS_HIS_0825 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0826
create table CML_SENT_INFOS_HIS_0826
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0826 on CML_SENT_INFOS_HIS_0826 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0827
create table CML_SENT_INFOS_HIS_0827
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0827 on CML_SENT_INFOS_HIS_0827 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0828
create table CML_SENT_INFOS_HIS_0828
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0828 on CML_SENT_INFOS_HIS_0828 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0829
create table CML_SENT_INFOS_HIS_0829
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0829 on CML_SENT_INFOS_HIS_0829 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0830
create table CML_SENT_INFOS_HIS_0830
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0830 on CML_SENT_INFOS_HIS_0830 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0831
create table CML_SENT_INFOS_HIS_0831
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0831 on CML_SENT_INFOS_HIS_0831 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0901
create table CML_SENT_INFOS_HIS_0901
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0901 on CML_SENT_INFOS_HIS_0901 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0902
create table CML_SENT_INFOS_HIS_0902
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0902 on CML_SENT_INFOS_HIS_0902 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0903
create table CML_SENT_INFOS_HIS_0903
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0903 on CML_SENT_INFOS_HIS_0903 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0904
create table CML_SENT_INFOS_HIS_0904
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0904 on CML_SENT_INFOS_HIS_0904 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0905
create table CML_SENT_INFOS_HIS_0905
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0905 on CML_SENT_INFOS_HIS_0905 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0906
create table CML_SENT_INFOS_HIS_0906
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0906 on CML_SENT_INFOS_HIS_0906 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0907
create table CML_SENT_INFOS_HIS_0907
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0907 on CML_SENT_INFOS_HIS_0907 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0908
create table CML_SENT_INFOS_HIS_0908
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0908 on CML_SENT_INFOS_HIS_0908 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0909
create table CML_SENT_INFOS_HIS_0909
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0909 on CML_SENT_INFOS_HIS_0909 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0910
create table CML_SENT_INFOS_HIS_0910
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0910 on CML_SENT_INFOS_HIS_0910 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0911
create table CML_SENT_INFOS_HIS_0911
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0911 on CML_SENT_INFOS_HIS_0911 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0912
create table CML_SENT_INFOS_HIS_0912
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0912 on CML_SENT_INFOS_HIS_0912 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0913
create table CML_SENT_INFOS_HIS_0913
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0913 on CML_SENT_INFOS_HIS_0913 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0914
create table CML_SENT_INFOS_HIS_0914
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0914 on CML_SENT_INFOS_HIS_0914 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0915
create table CML_SENT_INFOS_HIS_0915
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0915 on CML_SENT_INFOS_HIS_0915 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0916
create table CML_SENT_INFOS_HIS_0916
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0916 on CML_SENT_INFOS_HIS_0916 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0917
create table CML_SENT_INFOS_HIS_0917
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0917 on CML_SENT_INFOS_HIS_0917 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0918
create table CML_SENT_INFOS_HIS_0918
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0918 on CML_SENT_INFOS_HIS_0918 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0919
create table CML_SENT_INFOS_HIS_0919
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0919 on CML_SENT_INFOS_HIS_0919 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0920
create table CML_SENT_INFOS_HIS_0920
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0920 on CML_SENT_INFOS_HIS_0920 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0921
create table CML_SENT_INFOS_HIS_0921
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0921 on CML_SENT_INFOS_HIS_0921 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0922
create table CML_SENT_INFOS_HIS_0922
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0922 on CML_SENT_INFOS_HIS_0922 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0923
create table CML_SENT_INFOS_HIS_0923
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0923 on CML_SENT_INFOS_HIS_0923 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0924
create table CML_SENT_INFOS_HIS_0924
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0924 on CML_SENT_INFOS_HIS_0924 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0925
create table CML_SENT_INFOS_HIS_0925
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0925 on CML_SENT_INFOS_HIS_0925 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0926
create table CML_SENT_INFOS_HIS_0926
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0926 on CML_SENT_INFOS_HIS_0926 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0927
create table CML_SENT_INFOS_HIS_0927
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0927 on CML_SENT_INFOS_HIS_0927 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0928
create table CML_SENT_INFOS_HIS_0928
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0928 on CML_SENT_INFOS_HIS_0928 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0929
create table CML_SENT_INFOS_HIS_0929
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0929 on CML_SENT_INFOS_HIS_0929 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_0930
create table CML_SENT_INFOS_HIS_0930
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_0930 on CML_SENT_INFOS_HIS_0930 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1001
create table CML_SENT_INFOS_HIS_1001
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1001 on CML_SENT_INFOS_HIS_1001 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1002
create table CML_SENT_INFOS_HIS_1002
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1002 on CML_SENT_INFOS_HIS_1002 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1003
create table CML_SENT_INFOS_HIS_1003
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1003 on CML_SENT_INFOS_HIS_1003 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1004
create table CML_SENT_INFOS_HIS_1004
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1004 on CML_SENT_INFOS_HIS_1004 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1005
create table CML_SENT_INFOS_HIS_1005
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1005 on CML_SENT_INFOS_HIS_1005 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1006
create table CML_SENT_INFOS_HIS_1006
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1006 on CML_SENT_INFOS_HIS_1006 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1007
create table CML_SENT_INFOS_HIS_1007
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1007 on CML_SENT_INFOS_HIS_1007 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1008
create table CML_SENT_INFOS_HIS_1008
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1008 on CML_SENT_INFOS_HIS_1008 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1009
create table CML_SENT_INFOS_HIS_1009
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1009 on CML_SENT_INFOS_HIS_1009 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1010
create table CML_SENT_INFOS_HIS_1010
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1010 on CML_SENT_INFOS_HIS_1010 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1011
create table CML_SENT_INFOS_HIS_1011
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1011 on CML_SENT_INFOS_HIS_1011 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1012
create table CML_SENT_INFOS_HIS_1012
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1012 on CML_SENT_INFOS_HIS_1012 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1013
create table CML_SENT_INFOS_HIS_1013
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1013 on CML_SENT_INFOS_HIS_1013 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1014
create table CML_SENT_INFOS_HIS_1014
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1014 on CML_SENT_INFOS_HIS_1014 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1015
create table CML_SENT_INFOS_HIS_1015
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1015 on CML_SENT_INFOS_HIS_1015 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1016
create table CML_SENT_INFOS_HIS_1016
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1016 on CML_SENT_INFOS_HIS_1016 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1017
create table CML_SENT_INFOS_HIS_1017
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1017 on CML_SENT_INFOS_HIS_1017 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1018
create table CML_SENT_INFOS_HIS_1018
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1018 on CML_SENT_INFOS_HIS_1018 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1019
create table CML_SENT_INFOS_HIS_1019
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1019 on CML_SENT_INFOS_HIS_1019 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1020
create table CML_SENT_INFOS_HIS_1020
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1020 on CML_SENT_INFOS_HIS_1020 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1021
create table CML_SENT_INFOS_HIS_1021
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1021 on CML_SENT_INFOS_HIS_1021 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1022
create table CML_SENT_INFOS_HIS_1022
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1022 on CML_SENT_INFOS_HIS_1022 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1023
create table CML_SENT_INFOS_HIS_1023
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1023 on CML_SENT_INFOS_HIS_1023 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1024
create table CML_SENT_INFOS_HIS_1024
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1024 on CML_SENT_INFOS_HIS_1024 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1025
create table CML_SENT_INFOS_HIS_1025
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1025 on CML_SENT_INFOS_HIS_1025 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1026
create table CML_SENT_INFOS_HIS_1026
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1026 on CML_SENT_INFOS_HIS_1026 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1027
create table CML_SENT_INFOS_HIS_1027
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1027 on CML_SENT_INFOS_HIS_1027 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1028
create table CML_SENT_INFOS_HIS_1028
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1028 on CML_SENT_INFOS_HIS_1028 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1029
create table CML_SENT_INFOS_HIS_1029
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1029 on CML_SENT_INFOS_HIS_1029 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1030
create table CML_SENT_INFOS_HIS_1030
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1030 on CML_SENT_INFOS_HIS_1030 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1031
create table CML_SENT_INFOS_HIS_1031
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1031 on CML_SENT_INFOS_HIS_1031 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1101
create table CML_SENT_INFOS_HIS_1101
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1101 on CML_SENT_INFOS_HIS_1101 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1102
create table CML_SENT_INFOS_HIS_1102
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1102 on CML_SENT_INFOS_HIS_1102 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1103
create table CML_SENT_INFOS_HIS_1103
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1103 on CML_SENT_INFOS_HIS_1103 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1104
create table CML_SENT_INFOS_HIS_1104
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1104 on CML_SENT_INFOS_HIS_1104 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1105
create table CML_SENT_INFOS_HIS_1105
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1105 on CML_SENT_INFOS_HIS_1105 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1106
create table CML_SENT_INFOS_HIS_1106
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1106 on CML_SENT_INFOS_HIS_1106 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1107
create table CML_SENT_INFOS_HIS_1107
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1107 on CML_SENT_INFOS_HIS_1107 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1108
create table CML_SENT_INFOS_HIS_1108
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1108 on CML_SENT_INFOS_HIS_1108 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1109
create table CML_SENT_INFOS_HIS_1109
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1109 on CML_SENT_INFOS_HIS_1109 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1110
create table CML_SENT_INFOS_HIS_1110
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1110 on CML_SENT_INFOS_HIS_1110 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1111
create table CML_SENT_INFOS_HIS_1111
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1111 on CML_SENT_INFOS_HIS_1111 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1112
create table CML_SENT_INFOS_HIS_1112
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1112 on CML_SENT_INFOS_HIS_1112 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1113
create table CML_SENT_INFOS_HIS_1113
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1113 on CML_SENT_INFOS_HIS_1113 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1114
create table CML_SENT_INFOS_HIS_1114
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1114 on CML_SENT_INFOS_HIS_1114 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1115
create table CML_SENT_INFOS_HIS_1115
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1115 on CML_SENT_INFOS_HIS_1115 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1116
create table CML_SENT_INFOS_HIS_1116
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1116 on CML_SENT_INFOS_HIS_1116 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1117
create table CML_SENT_INFOS_HIS_1117
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1117 on CML_SENT_INFOS_HIS_1117 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1118
create table CML_SENT_INFOS_HIS_1118
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1118 on CML_SENT_INFOS_HIS_1118 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1119
create table CML_SENT_INFOS_HIS_1119
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1119 on CML_SENT_INFOS_HIS_1119 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1120
create table CML_SENT_INFOS_HIS_1120
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1120 on CML_SENT_INFOS_HIS_1120 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1121
create table CML_SENT_INFOS_HIS_1121
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1121 on CML_SENT_INFOS_HIS_1121 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1122
create table CML_SENT_INFOS_HIS_1122
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1122 on CML_SENT_INFOS_HIS_1122 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1123
create table CML_SENT_INFOS_HIS_1123
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1123 on CML_SENT_INFOS_HIS_1123 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1124
create table CML_SENT_INFOS_HIS_1124
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1124 on CML_SENT_INFOS_HIS_1124 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1125
create table CML_SENT_INFOS_HIS_1125
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1125 on CML_SENT_INFOS_HIS_1125 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1126
create table CML_SENT_INFOS_HIS_1126
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1126 on CML_SENT_INFOS_HIS_1126 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1127
create table CML_SENT_INFOS_HIS_1127
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1127 on CML_SENT_INFOS_HIS_1127 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1128
create table CML_SENT_INFOS_HIS_1128
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1128 on CML_SENT_INFOS_HIS_1128 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1129
create table CML_SENT_INFOS_HIS_1129
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1129 on CML_SENT_INFOS_HIS_1129 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1130
create table CML_SENT_INFOS_HIS_1130
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1130 on CML_SENT_INFOS_HIS_1130 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1201
create table CML_SENT_INFOS_HIS_1201
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1201 on CML_SENT_INFOS_HIS_1201 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1202
create table CML_SENT_INFOS_HIS_1202
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1202 on CML_SENT_INFOS_HIS_1202 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1203
create table CML_SENT_INFOS_HIS_1203
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1203 on CML_SENT_INFOS_HIS_1203 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1204
create table CML_SENT_INFOS_HIS_1204
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1204 on CML_SENT_INFOS_HIS_1204 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1205
create table CML_SENT_INFOS_HIS_1205
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1205 on CML_SENT_INFOS_HIS_1205 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1206
create table CML_SENT_INFOS_HIS_1206
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1206 on CML_SENT_INFOS_HIS_1206 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1207
create table CML_SENT_INFOS_HIS_1207
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1207 on CML_SENT_INFOS_HIS_1207 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1208
create table CML_SENT_INFOS_HIS_1208
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1208 on CML_SENT_INFOS_HIS_1208 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1209
create table CML_SENT_INFOS_HIS_1209
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1209 on CML_SENT_INFOS_HIS_1209 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1210
create table CML_SENT_INFOS_HIS_1210
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1210 on CML_SENT_INFOS_HIS_1210 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1211
create table CML_SENT_INFOS_HIS_1211
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1211 on CML_SENT_INFOS_HIS_1211 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1212
create table CML_SENT_INFOS_HIS_1212
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1212 on CML_SENT_INFOS_HIS_1212 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1213
create table CML_SENT_INFOS_HIS_1213
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1213 on CML_SENT_INFOS_HIS_1213 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1214
create table CML_SENT_INFOS_HIS_1214
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1214 on CML_SENT_INFOS_HIS_1214 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1215
create table CML_SENT_INFOS_HIS_1215
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1215 on CML_SENT_INFOS_HIS_1215 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1216
create table CML_SENT_INFOS_HIS_1216
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1216 on CML_SENT_INFOS_HIS_1216 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1217
create table CML_SENT_INFOS_HIS_1217
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1217 on CML_SENT_INFOS_HIS_1217 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1218
create table CML_SENT_INFOS_HIS_1218
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1218 on CML_SENT_INFOS_HIS_1218 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1219
create table CML_SENT_INFOS_HIS_1219
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1219 on CML_SENT_INFOS_HIS_1219 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1220
create table CML_SENT_INFOS_HIS_1220
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1220 on CML_SENT_INFOS_HIS_1220 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1221
create table CML_SENT_INFOS_HIS_1221
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1221 on CML_SENT_INFOS_HIS_1221 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1222
create table CML_SENT_INFOS_HIS_1222
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1222 on CML_SENT_INFOS_HIS_1222 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1223
create table CML_SENT_INFOS_HIS_1223
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1223 on CML_SENT_INFOS_HIS_1223 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1224
create table CML_SENT_INFOS_HIS_1224
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1224 on CML_SENT_INFOS_HIS_1224 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1225
create table CML_SENT_INFOS_HIS_1225
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1225 on CML_SENT_INFOS_HIS_1225 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1226
create table CML_SENT_INFOS_HIS_1226
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1226 on CML_SENT_INFOS_HIS_1226 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1227
create table CML_SENT_INFOS_HIS_1227
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1227 on CML_SENT_INFOS_HIS_1227 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1228
create table CML_SENT_INFOS_HIS_1228
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1228 on CML_SENT_INFOS_HIS_1228 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1229
create table CML_SENT_INFOS_HIS_1229
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1229 on CML_SENT_INFOS_HIS_1229 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1230
create table CML_SENT_INFOS_HIS_1230
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1230 on CML_SENT_INFOS_HIS_1230 (C_NOTE_TYPE);


-- CML_SENT_INFOS_HIS_1231
create table CML_SENT_INFOS_HIS_1231
(
 I_ID              bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 C_TRAN_ID         varchar(32),
 C_TERM_ID         varchar(32),
 C_JOURNAL_NO      varchar(32),
 C_IMAGE_TYPE      varchar(2),
 I_SEQUENCE        numeric(16),
 C_BARCODE_FLOWNUM varchar(32),
 C_NOTE_FLAG       varchar(2),
 C_NOTE_TYPE       varchar(4),
 C_CURRENCY        varchar(6),
 C_DENOMINATION    varchar(8),
 C_VERSION_NUM     varchar(5),
 C_SERIA_NO        varchar(19),
 C_ERROR_CODE      varchar(32),
 C_RESERVE         varchar(16),
 C_TRAN_DATE       varchar(16),
 C_TRAN_MONTHDAY   varchar(4),
 C_TRAN_MINUTE     varchar(2),
 C_CREATE_MONTHDAY varchar(4),	-- partition column: by create monthday 
 C_TERM_TYPE       varchar(2),
 C_PATHCODE        varchar(64),
 C_MACHINESNO      varchar(24),
 primary key (I_ID)
);
create index IDX1_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_SERIA_NO);
create index IDX2_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_TRAN_ID);
create index IDX3_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_TERM_ID);
create index IDX4_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_PATHCODE);
create index IDX5_CML_SENT_INFOS_HIS_1231 on CML_SENT_INFOS_HIS_1231 (C_NOTE_TYPE);



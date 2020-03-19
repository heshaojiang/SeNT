DB_DDL.sql文件新增部分中
从17514行开始没有验证过，其余都是按DB2环境下调整过的，应该不会有问题

dll_chage.sql
这是迁移到db2的版本，已经验证过，没有问题；
dllchage.sql(有一处语法错误) 
第99行  语法错误：alter table NODER_FILE
  add constraint IDX1_NODER_FILE unique (C_NODERID, C_FILETYPE, C_TRAN_DATA); 报错

新增表部分的数据还没有插入到 DB_DATA.sql中

我参考的脚本版本DB_RotoCash 2.0 SR1 b3_mysql

脚本修改记录和存在问题见readme.txt
dll_chage.sql 我在客户端工具调整的，还没有添加到main.sh中。
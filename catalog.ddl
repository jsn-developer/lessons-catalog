-- Project Name : Catalog App
-- Date/Time    : 2020/03/27 15:22:44
-- Author       : HISATO
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- goods
--* RestoreFromTempTable
create table goods (
  id int(11) unsigned not null comment 'id'
  , name varchar(200) not null comment 'name'
  , description varchar(4000) comment 'description'
  , price int(11) not null comment 'price'
  , photodata blob comment 'photodata'
  , photomime varchar(45) comment 'photomime'
  , constraint goods_PKC primary key (id)
) comment 'goods' ;

-- inquiry
--* RestoreFromTempTable
create table inquiry (
  id int(11) auto_increment not null comment 'id'
  , goodsid int(11) unsigned not null comment 'goodsid'
  , name varchar(200) not null comment 'name'
  , company varchar(100) comment 'company'
  , phone varchar(15) comment 'phone'
  , mail varchar(150) comment 'mail'
  , constraint inquiry_PKC primary key (id)
) comment 'inquiry' ;

create index goodsid_idx
  on inquiry(goodsid);

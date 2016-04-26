/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/4/26 14:18:06                           */
/*==============================================================*/


drop index idx_collect_uid_vid_vtype on collect;

drop table if exists collect;

drop index idx_sys_user_username on sys_user;

drop table if exists sys_user;

drop index idx_vh_type on video_hot;

drop table if exists video_hot;

drop index idx_vv_type on video_new;

drop table if exists video_new;

/*==============================================================*/
/* Table: collect                                               */
/*==============================================================*/
create table collect
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   uid                  bigint,
   vid                  bigint,
   vtype                varchar(10),
   primary key (id)
);

alter table collect comment '用户收藏功能';

/*==============================================================*/
/* Index: idx_collect_uid_vid_vtype                             */
/*==============================================================*/
create unique index idx_collect_uid_vid_vtype on collect
(
   uid,
   vid,
   vtype
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   updatetime           timestamp not null,
   username             varchar(20) not null,
   password             varchar(50) not null,
   nkname               varchar(20),
   pmac                 varchar(30),
   status               int not null default 0,
   type                 tinyint default 0,
   name                 varchar(12),
   email                varchar(50),
   telno                char(11),
   idcard               char(18),
   sex                  tinyint(1),
   birth                date,
   integral             int(11),
   address              varchar(50),
   qq                   bigint(11),
   face                 varchar(100),
   remark               varchar(400),
   openid               varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Index: idx_sys_user_username                                 */
/*==============================================================*/
create unique index idx_sys_user_username on sys_user
(
   username
);

/*==============================================================*/
/* Table: video_hot                                             */
/*==============================================================*/
create table video_hot
(
   id                   bigint not null auto_increment,
   vname                varchar(50),
   zbname               varchar(20),
   viewnum              int,
   url                  varchar(300),
   type                 varchar(10),
   img                  varchar(100),
   vkey                 varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Index: idx_vh_type                                           */
/*==============================================================*/
create index idx_vh_type on video_hot
(
   type
);

/*==============================================================*/
/* Table: video_new                                             */
/*==============================================================*/
create table video_new
(
   id                   bigint not null auto_increment,
   vname                varchar(50),
   zbname               varchar(20),
   viewnum              int,
   url                  varchar(300),
   type                 varchar(10),
   img                  varchar(100),
   vkey                 varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Index: idx_vv_type                                           */
/*==============================================================*/
create index idx_vv_type on video_new
(
   type
);


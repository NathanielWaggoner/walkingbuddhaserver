# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table prayer (
  name                      varchar(255) not null,
  desc                      varchar(255),
  english_text              varchar(255),
  prayer_text               varchar(255),
  constraint pk_prayer primary key (name))
;

create table stupa (
  stupa_name                varchar(255) not null,
  descritpion               varchar(255),
  latitude                  varchar(255),
  longitude                 varchar(255),
  stupa_image_path          varchar(255),
  stupa_video_path          varchar(255),
  constraint pk_stupa primary key (stupa_name))
;

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;

create sequence prayer_seq;

create sequence stupa_seq;

create sequence account_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists prayer;

drop table if exists stupa;

drop table if exists account;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists prayer_seq;

drop sequence if exists stupa_seq;

drop sequence if exists account_seq;


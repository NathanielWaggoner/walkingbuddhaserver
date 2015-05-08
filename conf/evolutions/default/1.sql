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
  constraint pk_stupa primary key (stupa_name))
;

create sequence prayer_seq;

create sequence stupa_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists prayer;

drop table if exists stupa;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists prayer_seq;

drop sequence if exists stupa_seq;


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     3/15/2015 10:09:51 PM                        */
/*==============================================================*/


drop table if exists ACCOUNT;

drop table if exists ASSESMENT_QUEUE;

drop table if exists ASSIGN;

drop table if exists ASSIGNMENT;

drop table if exists CONSIST_OF;

drop table if exists COURSE;

drop table if exists DEPARTMENT;

drop table if exists DILEVERY_QUEUE;

drop table if exists INSTRUCTOR;

drop table if exists LAB;

drop table if exists LABGROUP;

drop table if exists REQUEST_ASSESMENT;

drop table if exists REQUEST_DELIVERY;

drop table if exists STUDENT;

drop table if exists TEACH;

/*==============================================================*/
/* Table: ACCOUNT                                               */
/*==============================================================*/
create table ACCOUNT
(
   ACCOUNT_ID           int not null,
   FUL_NAME             varchar(200),
   USER_NAME            int not null,
   PASSWORD             varchar(100) not null,
   ACCOUNT_TYPE         bool not null,
   primary key (ACCOUNT_ID)
);

/*==============================================================*/
/* Table: ASSESMENT_QUEUE                                       */
/*==============================================================*/
create table ASSESMENT_QUEUE
(
   ASSESMENT_QUEUE_ID   int not null,
   primary key (ASSESMENT_QUEUE_ID)
);

/*==============================================================*/
/* Table: ASSIGN                                                */
/*==============================================================*/
create table ASSIGN
(
   GROUP_ID             int not null,
   ACCOUNT_ID           int not null,
   STUDENT_ID           int not null,
   primary key (GROUP_ID, ACCOUNT_ID, STUDENT_ID)
);

/*==============================================================*/
/* Table: ASSIGNMENT                                            */
/*==============================================================*/
create table ASSIGNMENT
(
   ASSIGNMENT_ID        int not null,
   LAB_ID               int not null,
   ACCOUNT_ID           int not null,
   STUDENT_ID           int not null,
   NAME                 varchar(100),
   URL                  varchar(1024),
   primary key (ASSIGNMENT_ID)
);

/*==============================================================*/
/* Table: CONSIST_OF                                            */
/*==============================================================*/
create table CONSIST_OF
(
   COURSE_ID            int not null,
   GROUP_ID             int not null,
   primary key (COURSE_ID, GROUP_ID)
);

/*==============================================================*/
/* Table: COURSE                                                */
/*==============================================================*/
create table COURSE
(
   COURSE_ID            int not null,
   NAME                 varchar(100),
   primary key (COURSE_ID)
);

/*==============================================================*/
/* Table: DEPARTMENT                                            */
/*==============================================================*/
create table DEPARTMENT
(
   DEPARTMENT_ID        int not null,
   NAME                 varchar(100),
   primary key (DEPARTMENT_ID)
);

/*==============================================================*/
/* Table: DILEVERY_QUEUE                                        */
/*==============================================================*/
create table DILEVERY_QUEUE
(
   QILEVERY_QUEUE_ID    int not null,
   primary key (QILEVERY_QUEUE_ID)
);

/*==============================================================*/
/* Table: INSTRUCTOR                                            */
/*==============================================================*/
create table INSTRUCTOR
(
   ACCOUNT_ID           int not null,
   INSTRUCTOR_ID        int not null,
   FUL_NAME             varchar(200),
   USER_NAME            int not null,
   PASSWORD             varchar(100) not null,
   ACCOUNT_TYPE         bool not null,
   primary key (ACCOUNT_ID, INSTRUCTOR_ID)
);

/*==============================================================*/
/* Table: LAB                                                   */
/*==============================================================*/
create table LAB
(
   LAB_ID               int not null,
   COURSE_ID            int not null,
   START_DATE           datetime,
   END_DATE             datetime,
   primary key (LAB_ID)
);

/*==============================================================*/
/* Table: LABGROUP                                              */
/*==============================================================*/
create table LABGROUP
(
   GROUP_ID             int not null,
   NAME                 varchar(100),
   primary key (GROUP_ID)
);

/*==============================================================*/
/* Table: REQUEST_ASSESMENT                                     */
/*==============================================================*/
create table REQUEST_ASSESMENT
(
   ACCOUNT_ID           int not null,
   STUDENT_ID           int not null,
   ASSESMENT_QUEUE_ID   int not null,
   NUMBER_OF_REQUESTS   int,
   LAB_NAME             varchar(100) not null,
   primary key (ACCOUNT_ID, STUDENT_ID, ASSESMENT_QUEUE_ID)
);

/*==============================================================*/
/* Table: REQUEST_DELIVERY                                      */
/*==============================================================*/
create table REQUEST_DELIVERY
(
   ACCOUNT_ID           int not null,
   STUDENT_ID           int not null,
   QILEVERY_QUEUE_ID    int not null,
   NUMBER_OF_REQUESTS   int,
   LAB_NAME             varchar(100) not null,
   primary key (ACCOUNT_ID, STUDENT_ID, QILEVERY_QUEUE_ID)
);

/*==============================================================*/
/* Table: STUDENT                                               */
/*==============================================================*/
create table STUDENT
(
   ACCOUNT_ID           int not null,
   STUDENT_ID           int not null,
   DEPARTMENT_ID        int not null,
   FUL_NAME             varchar(200),
   USER_NAME            int not null,
   PASSWORD             varchar(100) not null,
   ACCOUNT_TYPE         bool not null,
   primary key (ACCOUNT_ID, STUDENT_ID)
);

/*==============================================================*/
/* Table: TEACH                                                 */
/*==============================================================*/
create table TEACH
(
   LAB_ID               int not null,
   ACCOUNT_ID           int not null,
   INSTRUCTOR_ID        int not null,
   primary key (LAB_ID, ACCOUNT_ID, INSTRUCTOR_ID)
);

alter table ASSIGN add constraint FK_ASSIGN foreign key (GROUP_ID)
      references LABGROUP (GROUP_ID) on delete restrict on update restrict;

alter table ASSIGN add constraint FK_ASSIGN2 foreign key (ACCOUNT_ID, STUDENT_ID)
      references STUDENT (ACCOUNT_ID, STUDENT_ID) on delete restrict on update restrict;

alter table ASSIGNMENT add constraint FK_BELONG_TO foreign key (LAB_ID)
      references LAB (LAB_ID) on delete restrict on update restrict;

alter table ASSIGNMENT add constraint FK_UPLOAD foreign key (ACCOUNT_ID, STUDENT_ID)
      references STUDENT (ACCOUNT_ID, STUDENT_ID) on delete restrict on update restrict;

alter table CONSIST_OF add constraint FK_CONSIST_OF foreign key (COURSE_ID)
      references COURSE (COURSE_ID) on delete restrict on update restrict;

alter table CONSIST_OF add constraint FK_CONSIST_OF2 foreign key (GROUP_ID)
      references LABGROUP (GROUP_ID) on delete restrict on update restrict;

alter table INSTRUCTOR add constraint FK_INHERITANCE_1 foreign key (ACCOUNT_ID)
      references ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table LAB add constraint FK_HAS foreign key (COURSE_ID)
      references COURSE (COURSE_ID) on delete restrict on update restrict;

alter table REQUEST_ASSESMENT add constraint FK_REQUEST_ASSESMENT foreign key (ACCOUNT_ID, STUDENT_ID)
      references STUDENT (ACCOUNT_ID, STUDENT_ID) on delete restrict on update restrict;

alter table REQUEST_ASSESMENT add constraint FK_REQUEST_ASSESMENT2 foreign key (ASSESMENT_QUEUE_ID)
      references ASSESMENT_QUEUE (ASSESMENT_QUEUE_ID) on delete restrict on update restrict;

alter table REQUEST_DELIVERY add constraint FK_REQUEST_DELIVERY foreign key (ACCOUNT_ID, STUDENT_ID)
      references STUDENT (ACCOUNT_ID, STUDENT_ID) on delete restrict on update restrict;

alter table REQUEST_DELIVERY add constraint FK_REQUEST_DELIVERY2 foreign key (QILEVERY_QUEUE_ID)
      references DILEVERY_QUEUE (QILEVERY_QUEUE_ID) on delete restrict on update restrict;

alter table STUDENT add constraint FK_INHERITANCE_2 foreign key (ACCOUNT_ID)
      references ACCOUNT (ACCOUNT_ID) on delete restrict on update restrict;

alter table STUDENT add constraint FK_REGISTER foreign key (DEPARTMENT_ID)
      references DEPARTMENT (DEPARTMENT_ID) on delete restrict on update restrict;

alter table TEACH add constraint FK_TEACH foreign key (LAB_ID)
      references LAB (LAB_ID) on delete restrict on update restrict;

alter table TEACH add constraint FK_TEACH2 foreign key (ACCOUNT_ID, INSTRUCTOR_ID)
      references INSTRUCTOR (ACCOUNT_ID, INSTRUCTOR_ID) on delete restrict on update restrict;


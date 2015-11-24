create database lms;
use lms;
create table accountpo
(
_id_ int unsigned not null auto_increment primary key,
name varchar(25) not null unique,
amount double not null
);
create table arrivalpo
(
_id_ int unsigned not null auto_increment primary key,
expressNum varchar(12) not null unique,
arrivalState varchar(12) not null,
destination varchar(12) not null,
setOut varchar(12) not null,
arrivalData date not null,
transitNum varchar(12) not null
);
create table citypo(
_id_ int unsigned not null auto_increment primary key,
id varchar(10) not null unique,
name varchar(20) not null unique,
distance text not null,
businessNums text not null
);
create table departmentpo(
_id_ int unsigned not null auto_increment primary key,
departmentNum varchar(12) not null unique,
type varchar(20) not null,
location varchar(20) not null
);
create table userpo
(
_id_ int unsigned not null auto_increment primary key,
userName varchar(12) not null unique,
password varchar(12) not null,
power varchar(20) not null
);
create table paymentpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
paymentType varchar(20) not null,
payTime datetime not null,
account varchar(20) not null,
amount double not null
);
create table receiptpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
receiptDate datetime not null,
amount double not null,
courierNum varchar(12) not null,
expressNums text not null
);
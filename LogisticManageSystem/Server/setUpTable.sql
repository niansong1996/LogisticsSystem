create database lms;
use lms;
create table accountpo
(
id int unsigned not null auto_increment primary key,
name varchar(25) not null unique,
amount double not null
);
create table arrivalpo
(
id int unsigned not null auto_increment primary key,
expressNum varchar(12) not null unique,
arrivalState varchar(12) not null,
destination varchar(12) not null,
setOut varchar(12) not null,
arrivalData date not null,
transitNum varchar(12) not null
)
create table citypo(
id varchar(10) not null unique,
name varchar(20) not null unique
)
create table departmentpo(
departmentNum varchar(12) not null unique,
type varchar(20) not null,
location varchar(20) not null
)
create table userpo
(
id int unsigned not null auto_increment primary key,
userName varchar(12) not null unique,
password varchar(12) not null,
power varchar(20) not null
)
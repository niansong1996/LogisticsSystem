create database lms;
use lms;
create table accountpo
(
id int unsigned not null auto_increment primary key,
name varchar(25) not null,
amount double not null
);
create table arrivalpo
(
id int unsigned not null auto_increment primary key,
arrivalState enum('complete','broken','missing') not null,
expressNum varchar(12) not null,
destination varchar(12) not null,
setOut varchar(12) not null,
arrivalData date not null,
transitNum varchar(12) not null
)
create table userpo
(
id int unsigned not null auto_increment primary key,
userName varchar(12) not null unique,
password varchar(12) not null,
power varchar(20) not null
)
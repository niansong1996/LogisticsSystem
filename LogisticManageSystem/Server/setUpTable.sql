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
create table priceStrategypo
(
_id_ int unsigned not null auto_increment primary key,
standard double not null,
express double not null,
economic double not null,
rate1 double not null,
rate2 double not null,
rate3 double not null
);
create table salaryStrategypo
(
_id_ int unsigned not null auto_increment primary key,
type varchar(20) not null unique,
basic double not null,
perTime double not null,
bonus double not null
);	
create table personnelpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
name varchar(10) not null,
departmentNum varchar(12) not null,
duty varchar(20) not null,
salary double not null,
perTime double not null,
bonus double not null
);
create table commoditypo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
shipState varchar(20) not null,
send varchar(12) not null,
loading varchar(12) not null,
arrival varchar(12) not null,
dispatch varchar(12) not null,
checkin varchar(12) not null,
checkout varchar(12) not null,
receive varchar(12) not null
);
insert into UserPO value(NULL, "1000000037", "123456", "ADMINISTRATOR");


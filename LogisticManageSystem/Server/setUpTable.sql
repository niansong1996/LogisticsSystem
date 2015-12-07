create database lms character set utf8;
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
id varchar(12) not null unique,
expressNum varchar(12) not null unique,
arrivalState varchar(12) not null,
destination varchar(12) not null,
setOut varchar(12) not null,
arrivalData date not null,
transitNum varchar(12) not null
);

create table checkinpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
expresses text,
checkinDate datetime not null
);

create table checkoutpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
expressNums text,
checkoutDate datetime not null,
destination text not null,
loadType varchar(20) not null,
arrivalNum varchar(12) not null,
warehouseId varchar(12) not null,
motorNum varchar(12) not null
);

create table citypo(
_id_ int unsigned not null auto_increment primary key,
id varchar(10) not null unique,
name varchar(20) not null unique,
distance text not null,
businessNums text not null
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

create table departmentpo(
_id_ int unsigned not null auto_increment primary key,
departmentNum varchar(12) not null unique,
type varchar(20) not null,
location varchar(20) not null
);

create table dispatchpo 
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
dispatchPerson varchar(20) not null,
arrivalDate datetime not null,
expressNum varchar(12) not null
);

create table driverpo
(
_id_ int unsigned not null auto_increment primary key,
driverNum varchar(20) not null,
driverName varchar(20) not null,
birth datetime not null,
idNum varchar(20) not null,
phoneNum varchar(20) not null,
sex tinyint not null,
drivingLimit datetime not null,
businesshallNum varchar(20) not null
);

create table earningspo
(
_id_ int unsigned not null auto_increment primary key,
earnings double not null,
payment double not null,
profit double not null,
date datetime not null,
);

create table initialinforpo
(
_id_ int unsigned not null auto_increment primary key,
date datetime not null unique,
departments text not null,
personnel text not null,
cars text not null,
warehouses text not null,
accounts text not null
);

create table inventorypo
(
_id_ int unsigned not null auto_increment primary key,
warehouseId varchar(12) not null,
expressNum varchar(12) not null,
checkinTime datetime not null,
destination varchar(10) not null,
location varchar(20) not null
);

create table loadpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
loadType varchar(20) not null,
loadDate datetime not null,
businessHallNum varchar(12) not null,
motorNum varchar(12) not null,
destiCity varchar(12) not null,
destiBusinessHall varchar(12) not null,
vehicleNum varchar(12) not null,
driverNum varchar(12) not null,
commodityNums text not null,
freight double not null
);

create table numoccupancypo
(
_id_ int unsigned not null auto_increment primary key,
SendListNum varchar(12) not null,
ArrivalListNum varchar(12) not null,
CheckinListNum varchar(12) not null,
CheckoutListNum varchar(12) not null,
DispatchListNum varchar(12) not null,
LoadListNum varchar(12) not null,
PaymentListNum varchar(12) not null,
ReceiptListNum varchar(12) not null,
ReceiveListNum varchar(12) not null,
DriverNum varchar(12) not null,
CarNum varchar(12) not null
);

create table operationpo
(
_id_ int unsigned not null auto_increment primary key,
explanation varchar(100) not null,
timing varchar(20) not null,
username varchar(12) not null
);

create table paymentpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
paymentType varchar(20) not null,
payTime datetime not null,
account varchar(20) not null,
amount double not null
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

create table receiptpo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
receiptDate datetime not null,
amount double not null,
courierNum varchar(12) not null,
expressNums text not null
);

create table receivepo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
state varchar(20) not null,
receiverName varchar(12) not null,
receiveTime datetime not null,
expressNum varchar(12) not null
);

create table salaryStrategypo
(
_id_ int unsigned not null auto_increment primary key,
type varchar(20) not null unique,
basic double not null,
perTime double not null,
bonus double not null
);	

create table sendpo
(
_id_ int unsigned not null auto_increment primary key,
expressNum varchar(12) not null,
baseInfor text not null,
initialNum int not null,
weight double not null,
volume double not null,
goodsName varchar(20) not null,
packingType varchar(20) not null,
mode varchar(20) not null,
senderCity varchar(20) not null,
receiverCity varchar(20) not null,
price double not null,
time double not null,
createTime double not null
);

create table userpo
(
_id_ int unsigned not null auto_increment primary key,
userName varchar(12) not null unique,
password varchar(12) not null,
power varchar(20) not null
);

create table vehiclepo
(
_id_ int unsigned not null auto_increment primary key,
plateNum varchar(20) not null unique,
vehicleNum varchar(20) not null unique,
serviceYears tinyint not null,
businessHallNum varchar(20) not null
);

create table warehousepo
(
_id_ int unsigned not null auto_increment primary key,
id varchar(12) not null unique,
cordon double not null,
expressNums text not null,
checkInlists text not null,
checkOutlists text not null,
partitionInfor varchar(100) not null
);















insert into PriceStrategyPO value(NULL,18,25,35,18,25,35);
insert into NumOccupancyPO value(NULL,"0100000000","0300000000","0500000000","0600000000","0400000000","0200000000","0900000000","0800000000","0700000000","000","000");
insert into UserPO value(NULL, "1000000037", "123456", "ADMINISTRATOR");
insert into SalaryStrategyPO value("courier","200","200","300");
insert into InventoryPO value(NULL,"1234567890","2424252422","2015-10-10","Shanghai","AIRPLANE 10 1");
insert into InventoryPO value(NULL,"1234567890","9728752922","2015-11-10","Beijing","TRAIN 10 1");
insert into WarehousePO value(NULL,"1234567890",0.9,"[2424252422, 9728752922]","[]","[]","[1000 1 1000 AIRPLANE, 500 1001 1500 TRAIN, 200 1501 1700 CAR, 300 1701 2000 FLEXIBLE]");
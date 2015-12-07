-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	5.7.9

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `numoccupancypo`
--

DROP TABLE IF EXISTS `numoccupancypo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numoccupancypo` (
  `_id_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SendListNum` varchar(12) NOT NULL,
  `ArrivalListNum` varchar(12) NOT NULL,
  `CheckinListNum` varchar(12) NOT NULL,
  `CheckoutListNum` varchar(12) NOT NULL,
  `DispathcListNum` varchar(12) NOT NULL,
  `LoadListNum` varchar(12) NOT NULL,
  `PaymentListNum` varchar(12) NOT NULL,
  `ReceiptListNum` varchar(12) NOT NULL,
  `ReceiveListNum` varchar(12) NOT NULL,
  `DriverNum` varchar(12) NOT NULL,
  `CarNum` varchar(12) NOT NULL,
  PRIMARY KEY (`_id_`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numoccupancypo`
--

LOCK TABLES `numoccupancypo` WRITE;
/*!40000 ALTER TABLE `numoccupancypo` DISABLE KEYS */;
INSERT INTO `numoccupancypo` VALUES (1,'0100000000','0300000000','0500000000','0600000000','0400000000','0200000000','0900000000','0800000000','0700000000','000','000');
/*!40000 ALTER TABLE `numoccupancypo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-07 10:53:20

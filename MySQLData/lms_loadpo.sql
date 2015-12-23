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
-- Table structure for table `loadpo`
--

DROP TABLE IF EXISTS `loadpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loadpo` (
  `_id_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id` varchar(12) NOT NULL,
  `state` varchar(20) NOT NULL,
  `loadType` varchar(20) NOT NULL,
  `loadDate` datetime NOT NULL,
  `businessHallNum` varchar(12) NOT NULL,
  `motorNum` text NOT NULL,
  `destiCity` varchar(12) NOT NULL,
  `destiBusinessHall` varchar(12) NOT NULL,
  `vehicleNum` varchar(12) NOT NULL,
  `driverNum` varchar(12) NOT NULL,
  `commodityNums` text NOT NULL,
  `freight` double NOT NULL,
  PRIMARY KEY (`_id_`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loadpo`
--

LOCK TABLES `loadpo` WRITE;
/*!40000 ALTER TABLE `loadpo` DISABLE KEYS */;
INSERT INTO `loadpo` VALUES (1,'200000011','WAITING','AIRPLANE','2015-12-20 00:00:00','025001','025001201512201111','北京','025001','12345','欧巴','[0000000001]',180);
/*!40000 ALTER TABLE `loadpo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-23 19:52:09

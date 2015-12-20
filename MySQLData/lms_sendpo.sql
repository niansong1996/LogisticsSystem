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
-- Table structure for table `sendpo`
--

DROP TABLE IF EXISTS `sendpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendpo` (
  `_id_` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id` varchar(12) NOT NULL,
  `state` varchar(20) NOT NULL,
  `expressNum` varchar(12) NOT NULL,
  `baseInfor` text NOT NULL,
  `initialNum` int(11) NOT NULL,
  `weight` double NOT NULL,
  `volume` double NOT NULL,
  `goodsName` varchar(20) NOT NULL,
  `packingType` varchar(20) NOT NULL,
  `mode` varchar(20) NOT NULL,
  `senderCity` varchar(20) NOT NULL,
  `receiverCity` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `time` double NOT NULL,
  `createTime` varchar(20) NOT NULL,
  PRIMARY KEY (`_id_`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendpo`
--

LOCK TABLES `sendpo` WRITE;
/*!40000 ALTER TABLE `sendpo` DISABLE KEYS */;
INSERT INTO `sendpo` VALUES (1,'100000001','WAITING','1234567890','[欧巴, 13401271096, 仙林大道163号, 南大仙林校区, 傻狗, 13401212345, 复旦, 复旦大学]',1,1,1,'1','CARTON','CHEAP','北京','南京',37.4,2.6,'2015-12-20');
/*!40000 ALTER TABLE `sendpo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-20 10:23:36

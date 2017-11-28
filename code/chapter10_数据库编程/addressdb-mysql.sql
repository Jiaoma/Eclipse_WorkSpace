# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: java
# ------------------------------------------------------
# Server version 5.1.40-community

USE `addressdb`;

#
# Source for table person
#

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `personId` int(11) NOT NULL AUTO_INCREMENT,
  `personName` varchar(40) NOT NULL DEFAULT '',
  `nickName` varchar(40) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobilePhone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;



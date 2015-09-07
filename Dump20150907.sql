-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,90,1100001),(2,0,1100002),(3,0,1100003),(4,-1440,1100004),(5,400,1000000),(6,650,1000000),(7,0,0),(8,0,0),(9,0,1000000),(10,0,1000000),(11,0,1000000),(12,0,1000000),(13,400,1000467),(14,0,1000488),(15,0,1000930),(16,0,1300091),(17,0,1000432),(18,9900,1122334);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g0rrdklhpnrkcq4latjxskulm` (`account_id`),
  CONSTRAINT `FK_g0rrdklhpnrkcq4latjxskulm` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'medicine',1),(2,'foundation',2),(3,'talents',3),(4,'education',4);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bids`
--

DROP TABLE IF EXISTS `bids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bids` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `periodConsideration` datetime DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_quh9mmwd40rhawdlbigdvxxdd` (`project_id`),
  CONSTRAINT `FK_quh9mmwd40rhawdlbigdvxxdd` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bids`
--

LOCK TABLES `bids` WRITE;
/*!40000 ALTER TABLE `bids` DISABLE KEYS */;
INSERT INTO `bids` VALUES (1,'2036-10-08 19:14:34','ACCEPTED',2),(2,'2054-05-07 00:00:00','ACCEPTED',1),(3,'2015-09-06 07:26:50','DENIED',3),(4,'2015-09-16 07:27:11','UNDER_CONSIDERATION',4),(5,'2015-09-16 08:52:21','UNDER_CONSIDERATION',5),(6,'2015-09-06 14:52:14','DENIED',6),(7,'2015-09-16 11:26:49','UNDER_CONSIDERATION',7),(8,'2015-09-16 11:34:43','UNDER_CONSIDERATION',8),(9,'2035-03-13 15:27:32','ACCEPTED',9),(10,'2015-09-16 13:55:09','UNDER_CONSIDERATION',10),(11,'2015-09-16 14:00:07','UNDER_CONSIDERATION',11),(12,'2015-09-16 14:14:35','UNDER_CONSIDERATION',12);
/*!40000 ALTER TABLE `bids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `type` varchar(31) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `claim` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `popularity` tinyint(1) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oe3168svue76i6k4mktwxj3q3` (`project_id`),
  KEY `FK_6jf5hidmotiulto96dwp6n23g` (`user_id`),
  CONSTRAINT `FK_6jf5hidmotiulto96dwp6n23g` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_oe3168svue76i6k4mktwxj3q3` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('COMMENT',1,NULL,'bla-bla\r\n',NULL,NULL,1,3),('POPULARITY',2,NULL,NULL,NULL,0,1,3),('MARK',3,NULL,NULL,5,NULL,1,3),('MARK',4,NULL,NULL,5,NULL,1,3),('CLAIM',5,'baaad project dghrtjrtethrthrthwreh\r\n',NULL,NULL,NULL,1,3),('POPULARITY',6,NULL,NULL,NULL,0,2,2),('COMMENT',7,NULL,'uaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\r\n',NULL,NULL,2,2),('COMMENT',8,NULL,'jeeeeetcc\r\n',NULL,NULL,1,1),('POPULARITY',9,NULL,NULL,NULL,0,6,1),('POPULARITY',10,NULL,NULL,NULL,0,9,1),('MARK',11,NULL,NULL,5,NULL,9,1),('COMMENT',12,NULL,'Very good Project!!!!',NULL,NULL,9,1),('CLAIM',13,'Very bad Project!!!!!',NULL,NULL,NULL,9,1);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deadline` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `requiredAmount` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `area_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ffpvorr4p0uqsls04kj9bf5bi` (`name`),
  KEY `FK_p2b1phxi9ebg8hnkwl29neg9j` (`account_id`),
  KEY `FK_5uyqb7djaydn1l5d6dmm73e8u` (`area_id`),
  KEY `FK_8f9vj96r6wdii8iypivtrt5x0` (`user_id`),
  CONSTRAINT `FK_5uyqb7djaydn1l5d6dmm73e8u` FOREIGN KEY (`area_id`) REFERENCES `areas` (`id`),
  CONSTRAINT `FK_8f9vj96r6wdii8iypivtrt5x0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_p2b1phxi9ebg8hnkwl29neg9j` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,321,'Project description','Project',3000,0,5,3,2),(2,321,'ProPro','Pro',123,0,6,1,6),(3,123,'123','123',123,1,7,4,2),(4,123,'123','1234',1234,0,8,1,2),(5,356,'aerfksjgelkhjfl;hgj','ready',457,0,9,1,2),(6,321,'2123154264767267456735ERGT','12345',12,0,10,1,2),(7,24,'bid deccr','bid',123,0,11,2,2),(8,213,'2523rgergh','rtyu',14541,0,12,1,2),(9,324,'2523414','Proj',14,0,13,1,2),(10,123,'eeferyhryjhhg','Prrprpr',124,0,14,1,2),(11,4322,'1231234451','bid2',123,0,15,1,2),(12,133,'wtgefhrfujghetyh','mack',2562,0,17,1,2);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `type` varchar(31) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `numberCard` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numberchek` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numbertransfer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goal_account_id` int(11) DEFAULT NULL,
  `investor_account_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9ig5a48ccfwnfd373mibhlxo4` (`goal_account_id`),
  KEY `FK_skownwsbmdgay9ra1thcth306` (`investor_account_id`),
  CONSTRAINT `FK_9ig5a48ccfwnfd373mibhlxo4` FOREIGN KEY (`goal_account_id`) REFERENCES `accounts` (`id`),
  CONSTRAINT `FK_skownwsbmdgay9ra1thcth306` FOREIGN KEY (`investor_account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('TRANSFER',1,400,'2015-09-06 00:00:00',NULL,NULL,NULL,1,2,NULL),('TRANSFER',2,500,'2015-09-06 00:00:01',NULL,NULL,NULL,1,3,NULL),('TRANSFER',3,200,NULL,NULL,NULL,'123456',5,4,0),('DATACHEK',4,200,NULL,NULL,'12334',NULL,5,4,NULL),('TRANSFER',5,300,NULL,NULL,NULL,'111111',6,4,NULL),('BANKCARD',6,400,NULL,'1111222',NULL,NULL,13,4,NULL),('DATACHEK',7,120,NULL,NULL,'11223',NULL,6,4,NULL),('DATACHEK',9,110,NULL,NULL,'23232',NULL,1,4,NULL),('Transaction',10,300,NULL,NULL,NULL,NULL,6,NULL,NULL),('Transaction',11,130,NULL,NULL,NULL,NULL,6,1,NULL),('DATACHEK',12,100,NULL,NULL,'12345',NULL,6,18,0);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `role` varchar(31) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `firstName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`login`),
  KEY `FK_1yov8c5ew74vlt8qra6cewq99` (`account_id`),
  CONSTRAINT `FK_1yov8c5ew74vlt8qra6cewq99` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('DIRECTOR',1,'dir@di.d','Artem','Cherny','cher','$2a$10$..hi9dQOM2APD7jd.VBFceQ/lAalrcW1B3rAdEIQykk6Ina3a2qKu',NULL),('CREATOR',2,'anke@mail.ru','Андрей','Keduk','mack','$2a$10$Kl7CAL8CvhuyT2S2BeZ82.iAjG5ReaM.ZoZhGvwnoyurBShwBPGDe',NULL),('INVESTOR',3,'lev@le.le','Anton','Levchuk','lev','$2a$10$yjDpNEhfhQ/mz/505OZcYetzO19aZjkmpUfIeytaScZX28c7Rvt1G',18),('CREATOR',4,'','Андрей','Кедук','мак','$2a$10$3Ck0Jon5wkTFN.1mXz76/.gV.Unwseer99S.g6XkyECVp2.3xT3k6',NULL),('CREATOR',5,'','','','мама','$2a$10$p4hLrF0L6RDud2qSbdCRGuNUq/d483PPqulk6oWM5gsMMOAvx2GCC',NULL),('CREATOR',6,'aaa@a.a','ku','ka','mack2','$2a$10$MNS0IYt//e9fMSVmhfb.UO.ehsSCsd.JOhi1S3zFwYtySqBSq2b02',NULL),('INVESTOR',7,'','','','lev2','$2a$10$CWqaLwo9XG9pUraWQR64OefWL2ea.1hL6ioMKAZ//LsucvgxIUYHu',16);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-07  8:19:55

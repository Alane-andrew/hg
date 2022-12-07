-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (arm64)
--
-- Host: localhost    Database: huagao
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kcinfo`
--

DROP TABLE IF EXISTS `kcinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kcinfo` (
  `pname` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pquantity` decimal(7,0) NOT NULL,
  `position` decimal(1,0) NOT NULL,
  `picadd` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`pname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kcinfo`
--

LOCK TABLES `kcinfo` WRITE;
/*!40000 ALTER TABLE `kcinfo` DISABLE KEYS */;
INSERT INTO `kcinfo` VALUES ('98236-1',1000000,1,'image/kc_image/1.jpg'),('98236-10',1000000,1,'image/kc_image/10.jpg'),('98236-11',1000000,1,'image/kc_image/11.jpg'),('98236-12',1000000,1,'image/kc_image/12.jpg'),('98236-13',1000000,1,'image/kc_image/13.jpg'),('98236-14',1000000,1,'image/kc_image/14.jpg'),('98236-15',1000000,1,'image/kc_image/15.jpg'),('98236-16',1000000,1,'image/kc_image/16.jpg'),('98236-17',1000000,1,'image/kc_image/17.jpg'),('98236-18',1000000,1,'image/kc_image/18.jpg'),('98236-19',1000000,1,'image/kc_image/19.jpg'),('98236-2',1000000,1,'image/kc_image/2.jpg'),('98236-20',1000000,1,'image/kc_image/20.jpg'),('98236-21',1000000,1,'image/kc_image/21.jpg'),('98236-3',1000000,1,'image/kc_image/3.jpg'),('98236-4',1000000,1,'image/kc_image/4.jpg'),('98236-5',1000000,1,'image/kc_image/5.jpg'),('98236-6',1000000,1,'image/kc_image/6.jpg'),('98236-7',1000000,1,'image/kc_image/7.jpg'),('98236-8',1000000,1,'image/kc_image/8.jpg'),('98236-9',1000000,1,'image/kc_image/9.jpg');
/*!40000 ALTER TABLE `kcinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kehuinfo`
--

DROP TABLE IF EXISTS `kehuinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kehuinfo` (
  `customername` varchar(25) NOT NULL,
  `customeradd` varchar(30) DEFAULT '',
  `contactno` varchar(13) DEFAULT '0000-00000000',
  PRIMARY KEY (`customername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kehuinfo`
--

LOCK TABLES `kehuinfo` WRITE;
/*!40000 ALTER TABLE `kehuinfo` DISABLE KEYS */;
INSERT INTO `kehuinfo` VALUES ('南京某公司A','南京路23号','025-26356989'),('南京某公司B','南京路24号','025-13356989'),('南京某公司C','南京路25号','025-12156989'),('广州某公司A','黄埔路101号','020-26356989'),('广州某公司B','黄埔路102号','020-11156989'),('广州某公司C','黄埔路103号','020-11156989'),('成都某公司A','大件路300','028-26356989'),('成都某公司B','大件路301','028-11156989'),('成都某公司C','大件路302','028-22256989'),('西安某公司A','大雁路311号','029-26356989'),('西安某公司B','大雁路312号','029-11157989'),('西安某公司C','大雁路313号','029-11156990');
/*!40000 ALTER TABLE `kehuinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderxx`
--

DROP TABLE IF EXISTS `orderxx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderxx` (
  `orderno` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `orderdate` datetime DEFAULT '1900-01-01 00:00:00',
  `customername` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `orderquantity` decimal(7,0) DEFAULT NULL,
  `unitprice` decimal(5,3) DEFAULT NULL,
  `printsizewidth` decimal(3,0) DEFAULT NULL,
  `printsizehigh` decimal(3,0) DEFAULT NULL,
  `printcolors` decimal(1,0) DEFAULT NULL,
  `lamination` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '--无--',
  `uv` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '--无--',
  `cut` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '--无--',
  `oil` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '--无--',
  `glue` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '--无--',
  `laminationinfo` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '--无--',
  `paperquantity` decimal(7,0) DEFAULT NULL,
  `paperrealease` decimal(3,0) DEFAULT NULL,
  `printoutput` decimal(7,0) DEFAULT NULL,
  `pedate` datetime DEFAULT '1900-01-01 00:00:00',
  `pfdate` datetime DEFAULT '1900-01-01 00:00:00',
  `edelivery` datetime DEFAULT '1900-01-01 00:00:00',
  `delivery` datetime DEFAULT '1900-01-01 00:00:00',
  `deliveryadd` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `deliveryquantity` decimal(7,0) DEFAULT NULL,
  `tcartons` decimal(6,0) DEFAULT NULL,
  `cutmodelno` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `cfdate` datetime DEFAULT '1900-01-01 00:00:00',
  `cutoutput` decimal(7,0) DEFAULT NULL,
  `cedate` datetime DEFAULT '1900-01-01 00:00:00',
  `lamfdate` datetime DEFAULT '1900-01-01 00:00:00',
  `lamedate` datetime DEFAULT '1900-01-01 00:00:00',
  `lamoutput` decimal(7,0) DEFAULT NULL,
  `uvfdate` datetime DEFAULT '1900-01-01 00:00:00',
  `uvedate` datetime DEFAULT '1900-01-01 00:00:00',
  `uvoutput` decimal(7,0) DEFAULT NULL,
  `oilfdate` datetime DEFAULT '1900-01-01 00:00:00',
  `oiledate` datetime DEFAULT '1900-01-01 00:00:00',
  `oiloutput` decimal(7,0) DEFAULT NULL,
  `gluefdate` datetime DEFAULT '1900-01-01 00:00:00',
  `glueedate` datetime DEFAULT '1900-01-01 00:00:00',
  `glueoutput` decimal(7,0) DEFAULT NULL,
  `yspro` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '未完成',
  `ysprodate` datetime DEFAULT '1900-01-01 00:00:00',
  `hdpro` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '未完成',
  `hdprodate` datetime DEFAULT '1900-01-01 00:00:00',
  `fhpro` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '未完成',
  `fhprodate` datetime DEFAULT '1900-01-01 00:00:00',
  `cgpro` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '未完成',
  `cgprodate` datetime DEFAULT '1900-01-01 00:00:00',
  `orderpro` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '未完成',
  `orderprodate` datetime DEFAULT '1900-01-01 00:00:00',
  `customeradd` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `contactno` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `tybname` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '',
  `tybadd` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '',
  `tybcontactno` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '',
  PRIMARY KEY (`orderno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderxx`
--

LOCK TABLES `orderxx` WRITE;
/*!40000 ALTER TABLE `orderxx` DISABLE KEYS */;
INSERT INTO `orderxx` VALUES ('111','2022-12-04 12:13:30','南京某公司A',10000,1.300,80,40,4,'已完成','--无--','已完成','--无--','已完成','双面-亮-膜',10200,100,10000,'2022-12-05 00:00:00','2022-12-05 00:00:00','2022-12-09 00:00:00','2022-12-09 00:00:00',NULL,9850,10,'y-2312','2022-12-06 00:00:00',9900,'2022-12-06 00:00:00','2022-12-06 00:00:00','2022-12-06 00:00:00',9950,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'2022-12-07 00:00:00','2022-12-07 00:00:00',9850,'已完成','2022-12-04 13:42:34','已完成','2022-12-04 13:45:27','已完成','2022-12-04 13:46:53','未完成','1900-01-01 00:00:00','已完成','2022-12-04 13:46:53','南京路23号','025-26356989','韵达','上海路2号','010-11156989'),('222','2022-12-04 12:14:30','西安某公司B',9000,1.500,75,35,4,'未完成','未完成','未完成','--无--','未完成','正面-哑-膜，反面-亮-膜',9200,NULL,NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,NULL,NULL,NULL,'1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','大雁路312号','029-11157989','','',''),('333','2022-12-04 12:15:14','广州某公司A',20000,2.500,83,45,4,'未完成','--无--','未完成','未完成','未完成','正面-亮-膜',20200,NULL,NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,NULL,NULL,NULL,'1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','1900-01-01 00:00:00',NULL,'未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','未完成','1900-01-01 00:00:00','黄埔路101号','020-26356989','','','');
/*!40000 ALTER TABLE `orderxx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tybinfo`
--

DROP TABLE IF EXISTS `tybinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tybinfo` (
  `tybname` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `tybadd` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '',
  `tybcontactno` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT '0000-00000000',
  PRIMARY KEY (`tybname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tybinfo`
--

LOCK TABLES `tybinfo` WRITE;
/*!40000 ALTER TABLE `tybinfo` DISABLE KEYS */;
INSERT INTO `tybinfo` VALUES ('DHL','成都路3号','010-11156989'),('天天','南极路4号','020-26356989'),('韵达','上海路2号','010-11156989'),('顺丰','杭州路1号','010-11111111');
/*!40000 ALTER TABLE `tybinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `username` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pw` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `authority` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('101','123456','老总'),('102','123456','印刷'),('103','123456','后道'),('104','123456','发货'),('105','123456','仓管');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05 15:44:52

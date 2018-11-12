-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: galeria
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `usr_usuario`
--

DROP TABLE IF EXISTS `usr_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usr_usuario` (
  `usr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usr_nome` varchar(50) NOT NULL,
  `usr_senha` varchar(250) NOT NULL,
  `usr_usuario` varchar(25) NOT NULL,
  `usr_email` varchar(50) NOT NULL,
  `usr_id_papel` bigint(20) NOT NULL,
  PRIMARY KEY (`usr_id`),
  UNIQUE KEY `usr_usuario` (`usr_usuario`),
  UNIQUE KEY `usr_email` (`usr_email`),
  KEY `usr_id_papel` (`usr_id_papel`),
  CONSTRAINT `usr_usuario_ibfk_1` FOREIGN KEY (`usr_id_papel`) REFERENCES `pap_papel` (`pap_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_usuario`
--

LOCK TABLES `usr_usuario` WRITE;
/*!40000 ALTER TABLE `usr_usuario` DISABLE KEYS */;
INSERT INTO `usr_usuario` VALUES (1,'Administrador','{MD5}202cb962ac59075b964b07152d234b70','admin','admin@admin.com',3),(2,'Sham Vinicius','{MD5}202cb962ac59075b964b07152d234b70','sham','sham@admin.com',2),(3,'Lucao','{MD5}202cb962ac59075b964b07152d234b70','lucas','lucas@admin.com',2),(7,'Somente Login','{MD5}202cb962ac59075b964b07152d234b70','login','login@fatec.com',2);
/*!40000 ALTER TABLE `usr_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 21:30:41

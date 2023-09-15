CREATE DATABASE  IF NOT EXISTS `spring` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: spring
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `me_id` varchar(15) NOT NULL,
  `me_pw` varchar(255) NOT NULL,
  `me_email` varchar(50) NOT NULL,
  `me_role` varchar(10) NOT NULL DEFAULT 'USER',
  `me_session_id` varchar(255) DEFAULT NULL,
  `me_session_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`me_id`),
  UNIQUE KEY `me_ssesion_id_UNIQUE` (`me_session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('admin123','$2a$10$jnzip5ZAo/G6wIe214c3wumJNJlzSyg4MySmwb3sBml04UQ1JZbzy','admin@naver.com','ADMIN',NULL,'2023-09-15 09:33:21'),('an121212','$2a$10$0j5DJ6OixDvCDnOBpBzNLOrA2XfHyzCc1Ax1H6wyCbSmj629oaY9y','an@naver.com','USER',NULL,NULL),('an12121212','$2a$10$KfDVI6G8rYaQymMrjthgrOULtMzLSF9DFG4YZXYbliDfLXbVWj0z.','an@naver.com','USER',NULL,NULL),('an1234','$2a$10$3r9XqGds1398qolvrEzQ8.PjTqA3fhcsxLtQ9dghUS8RK3/s31Amm','an@naver.com','USER',NULL,'2023-09-14 16:26:35'),('an123456','$2a$10$ZAxnd.AK1aPHNT4BvW3mjOljQo9eKjFU7XrbPiEfDx692EYlD5HGi','an@naver.com','USER',NULL,NULL),('an4321','$2a$10$F0NhSWcVzpjYZI4P4G6hR.4b2OC4H5DyxsJY7rsvh/qnv/BWVxa6C','an1@naver.com','USER','8D2F56E915D391F6D26D14AED0A314C4','2023-09-20 14:42:40'),('wd1d1wd','$2a$10$GG9rGTcA.RBgWDcMJwg4hONBdpTFN6dlCoTosFnJVoGQYI81uZ5rq','an@naver.com','USER',NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-15 13:06:27

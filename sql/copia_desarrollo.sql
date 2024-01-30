-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: apirest
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(50) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `fecha_modificacion` date DEFAULT NULL,
  `nombres` varchar(50) NOT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `pais` varchar(30) DEFAULT NULL,
  `usuario_creador` varchar(50) DEFAULT NULL,
  `usuario_modificador` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `UK_trfs6xemfuo1u29blh0jw3ekl` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Carabali','66850016','3126081880','calle 54b 49d 05 piso 3',NULL,'2023-10-27','2023-11-08','Angela','Barrio cordoba reservado - SF',NULL,'maelito','blandon'),(2,'Rojas','1151949825','3229162350','cra 1e #59-163',NULL,'2023-10-27','2023-11-08','Felipe ','SF',NULL,'maelito','blandon'),(3,'Sepulveda','1144197339','3242782517','calle 35 30 27',NULL,'2023-10-27','2023-11-08','Jean','Hermano julieth patino - Fiadora - Julieth y mama de julieth',NULL,'maelito','blandon'),(4,'Botero','31528564','3172421575','calle 67 5 37',NULL,'2023-10-27','2023-11-08','Luz dary','Barrio brisas del guabito - Fiadora julieth patino - mama julieth patino',NULL,'maelito','blandon'),(5,'Gonzalez castro','1010062500','3163760956','calle 57 37 26 vallado','NN','2023-10-27',NULL,'Gaby vanessa','Amiga karen y julieth - Fiadora julieth patino','Colombia','maelito',NULL),(6,'Patino','1144159377','3164085216','calle 35 30 25 león 13','NN','2023-10-27',NULL,'Julieth','Fiadora karen gonzalez','Colombia','maelito',NULL),(7,'Nunez','29113754','3148460489','cra 1a9 73a 65','NN','2023-10-27',NULL,'Erika','Hermana lorenzo - Fiadora maría de los angeles - 1006050371 - cel 3103908434 - dir cra 1a9 73a 65','Colombia','maelito',NULL),(8,'Valencia','1107044344','3206876546','cra 26p 54 29','NN','2023-10-27',NULL,'Ronaldo','Cunado de karen gonzalez - SF','Colombia','maelito',NULL),(9,'Prueba','1','3111111111','compartir es vivir ',NULL,'2023-10-30','2023-11-22','Prueba','Prueba',NULL,'maelito','blandon'),(10,'Betancourt','1144064081','3156164561','calle 12b 40a 24','NN','2023-10-30',NULL,'Jaime','Fiadora Andrea londono-cc 1115183040 - celular 3113793867 - dir calle 14 37a 49 torre d 301 condominio san diego cristobal colon','Colombia','maelito',NULL),(11,'Osorio','29582969','3187402940','cra 36 5b1 36 apto 204','NN','2023-10-30',NULL,'Jakelin','Edif america 80 barrio san Fernando - Fiadora - leidy tatiana cuadros - cc 1007694463 - celular 3168566915 - dir cra 65 13b-125 bosques del limonar','Colombia','maelito',NULL),(12,'Viafara','67028776','3117676893','cra 93 42 93',NULL,'2023-10-30','2023-11-09','Katherine','',NULL,'maelito','blandon'),(13,'David','1085276989','3162851808','cra 22 12 95','NN','2023-10-30',NULL,'Eynar camilo','','Colombia','maelito',NULL),(14,'Valencia','94402551','3206743423','calle 61b 1hbis 40','NN','2023-10-30',NULL,'Ricardo','Esposo roselly -','Colombia','maelito',NULL),(15,'Mosquera','66960509','3104530365','vive donde la suegra','NN','2023-10-30',NULL,'Roselly','Se cambio de casa y no se sabe donde vive','Colombia','maelito',NULL),(16,'Vargas','26386421','3122070802','calle 15 22a 16','NN','2023-10-30',NULL,'Zully','Moroso reee','Colombia','maelito',NULL),(17,'Acosta','1143987657','3225981503','cra 26g 86 18','NN','2023-10-30',NULL,'Junior','','Colombia','maelito',NULL),(18,'Vallecilla','38644147','3164280120','no registra','NN','2023-10-30',NULL,'Vivian','No registra','Colombia','maelito',NULL),(19,'Gonzalez','31305143','3167564377','calle67n 1a 11-15','NN','2023-10-30',NULL,'Lisbeth','Sf','Colombia','maelito',NULL),(20,'Zambrano','1107070727','3106341121','cra 26g12 73b 59 marroco','NN','2023-10-30',NULL,'Jessica','Esposa de David salcedo','Colombia','maelito',NULL),(21,'Moreno','1143989341','3112652348','cra 26g5 86-16 san marcos','NN','2023-10-30',NULL,'Natalia','Fiador - jorge moreno - cc 1130625464 - cel 3152573349 - cra 7t bis 72 37','Colombia','maelito',NULL),(22,'Gonzalez','1111805885','3117396187','cra 26 56a 66 n floresta',NULL,'2023-10-30','2023-11-22','Wendy','Hermana de karen clinica colombia',NULL,'maelito','blandon'),(23,'Yarce','1144053206','3002083821','calle 18 44a 10','NN','2023-10-30',NULL,'Daniela','En la usa','Colombia','maelito',NULL),(24,'Hurtado','6228420','3108383025','calle 46 10 09','NN','2023-10-30',NULL,'Marcel','Sf','Colombia','maelito',NULL),(25,'Hernandez','1143936925','3158288824','cra 26 g10 73b 45 marroquí 2','NN','2023-10-30',NULL,'Lessdy','Sf','Colombia','maelito',NULL),(26,'Graterol','3857677','3128705319','cra 26 33f 71 santa fe','NN','2023-10-30',NULL,'Hector','Fiador - maría del mar','Colombia','maelito',NULL),(27,'Vivas','1006055175','3012915079','cra 1 a9 73a 65',NULL,'2023-10-30','2023-11-07','Lorenzo','Fiador - milena arismendi  - cc 6673933- cel  3229714386 dir CRA 7h #70-35',NULL,'maelito','blandon'),(28,'Salcedo','6229155','3205510345','calle 55 1 94 bloque 7 apt 404','NN','2023-10-30',NULL,'David','Sf','Colombia','maelito',NULL),(29,'Buitrago','1144157641','3164903048','cra 1d 62 04 chimi','NN','2023-10-31',NULL,'Juan david','Sf','Colombia','maelito',NULL),(30,'Vinasco','31930954','3172196114','calle 15a 74 30 brisas limonar','NN','2023-10-31',NULL,'Consuelo','','Colombia','maelito',NULL),(31,'Castillo','59675494','3043919297','cra 27 5b-10','NN','2023-11-01',NULL,'Idia','SF','Colombia','maelito',NULL),(32,'Taibel','1130642885','3137045817','calle 15 37 68 colibri','NN','2023-11-01',NULL,'Hermes','Poblado campestre - Fiador -  es el papá datos en el correo','Colombia','maelito',NULL),(33,'Flor','1107509524','3148321761','cra 26d 124-10','NN','2023-11-01',NULL,'Diana','','Colombia','maelito',NULL),(34,'Calero','1107528451','3177557782','san Antonio','NN','2023-11-01',NULL,'Aranza','Sf','Colombia','maelito',NULL),(35,'Luango','1107051725','4611232921','España','NN','2023-11-02',NULL,'Fransua','Sf','Colombia','blandon',NULL),(36,'Calero','1005706836','3182362717','san Antonio',NULL,'2023-11-02','2023-11-09','Maria del mar','Sf',NULL,'blandon','blandon'),(37,'Garcia','1144188641','1317809610','medellin','NN','2023-11-02',NULL,'Santiago','Sf','Colombia','blandon',NULL),(38,'Caicedo','31915252','3155150777','puerto tejada','NN','2023-11-09',NULL,'Ruby','Sf','Colombia','blandon',NULL),(39,'Calero','1143849576','7818347644','inglaterra','NN','2023-11-09',NULL,'Brian','Sf','Colombia','blandon',NULL),(47,'Gonzales','1148445049','3164167175','cra 27 56a 66','NN','2023-11-09',NULL,'Karen','Sf','Colombia','blandon',NULL),(48,'Enriquez','1130669503','3006722225','la isla',NULL,'2023-11-17','2023-11-23','Juan manuel','Sf ',NULL,'blandon','maelito'),(49,'Medina','1143945503','3166954761','Kra 29 # 39 - 25','NN','2023-11-29',NULL,'Fabian','Sf','Colombia','blandon',NULL),(50,'Guerrero','1144163255','3168672475','yumbo','NN','2023-12-01',NULL,'Leidy','Sf','Colombia','blandon',NULL),(51,'Gonzales','29784912','3162925815','calle 7 28-39','NN','2023-12-04',NULL,'Ana milena','Sf','Colombia','blandon',NULL),(52,'Yarpaz','1006011925','3145462609','CARRERA 1A NORTE #81- 21','NN','2023-12-04',NULL,'Diego estarlin','Fiadora vanessa Gonzalez','Colombia','blandon',NULL),(53,'Vivas','4640656','3122600524','Cra 1 a 5E #73 a 52 calimio nt',NULL,'2023-12-05','2023-12-05','Harold','Papa de lorenzo - fiador lorenzo',NULL,'blandon','blandon'),(54,'Ortegon','1130667927','1316254905','cra 45 # 18-32','NN','2023-12-16',NULL,'Claudia','Daniela yarce','Colombia','blandon',NULL),(55,'Arismendi','6673933','3229714386','carrera 22  #36 -89 santa fe','NN','2023-12-17',NULL,'Milena','Ramón segura c.c 94523830 telefono 3155149479 carrera 22  #36 -89 santa fe esposo - senora del trabajo de maría del mar','Colombia','blandon',NULL),(56,'Franco','1107075284','3162987978','Diagonal 51 oeste # 10 - 105 U','NN','2024-01-09',NULL,'Vicky yulieth','Fiadora - ruby','Colombia','blandon',NULL),(57,'Marin Ortiz','1143874050','3186926913','DIRECCION/ CRA 4 ·1-02 SAN ANT','NN','2024-01-10',NULL,'David','FIADORJUAN PABLO ORDOÑEZ PADILLA10059338753165648739CALLE 15 OE ·3-25 BELLAVISTA','Colombia','blandon',NULL),(58,'Salcedo','67005799','3238695459','av 2c norte 39-42 vipasa','NN','2024-01-22',NULL,'Luz Stella','David salcedo','Colombia','blandon',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credito`
--

DROP TABLE IF EXISTS `credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credito` (
  `id_credito` int NOT NULL AUTO_INCREMENT,
  `estado_credito` varchar(255) NOT NULL,
  `fecha_credito` date NOT NULL,
  `usuario_creador_credito` varchar(255) NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `valor_credito` double NOT NULL,
  `saldo_credito` double NOT NULL,
  `id_modalidad` int DEFAULT NULL,
  PRIMARY KEY (`id_credito`),
  KEY `FK2wsrvlr3jsdvvdqrnp1svagxj` (`id_cliente`),
  KEY `IDXo4cffmjdkkw9nq5rc5cq0u6qw` (`estado_credito`),
  KEY `estadoCredito_index` (`estado_credito`),
  KEY `FKaa13hx1lk1fqm7sxy8ohj4eqk` (`id_modalidad`),
  CONSTRAINT `FK2wsrvlr3jsdvvdqrnp1svagxj` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FKaa13hx1lk1fqm7sxy8ohj4eqk` FOREIGN KEY (`id_modalidad`) REFERENCES `modalidad` (`id_modalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credito`
--

LOCK TABLES `credito` WRITE;
/*!40000 ALTER TABLE `credito` DISABLE KEYS */;
INSERT INTO `credito` VALUES (2,'C','2023-10-24','maelito',1,600000,0,NULL),(3,'A','2023-10-09','maelito',2,1200000,840000,NULL),(4,'A','2023-10-05','maelito',3,1000000,800000,NULL),(5,'A','2023-10-04','maelito',4,600000,360000,NULL),(6,'C','2023-10-17','maelito',5,300000,0,NULL),(7,'C','2023-07-05','maelito',6,1000000,0,NULL),(10,'C','2023-09-15','maelito',8,500000,0,NULL),(21,'A','2023-07-05','maelito',21,1500000,600000,NULL),(23,'A','2023-09-01','maelito',12,1200000,550000,NULL),(25,'C','2023-09-01','maelito',13,400000,0,NULL),(26,'A','2023-08-01','maelito',26,1500000,900000,NULL),(27,'A','2023-07-01','maelito',25,1000000,600000,NULL),(28,'A','2023-06-30','maelito',34,1500000,857142,NULL),(32,'C','2023-05-01','blandon',36,1000000,0,NULL),(33,'C','2023-08-01','blandon',23,1000000,0,NULL),(34,'A','2023-10-02','blandon',7,1000000,400000,NULL),(35,'A','2023-10-03','blandon',29,600000,150000,NULL),(36,'A','2023-11-07','blandon',27,1000000,1000000,NULL),(37,'A','2023-11-04','blandon',12,400000,250000,NULL),(38,'A','2023-10-05','blandon',10,2000000,1833333,NULL),(39,'A','2023-09-05','blandon',17,300000,50000,NULL),(41,'A','2023-05-06','blandon',20,1200000,400000,NULL),(42,'A','2023-11-09','blandon',38,1000000,800000,NULL),(43,'C','2023-11-09','blandon',38,2000000,0,NULL),(46,'A','2023-09-09','blandon',28,850000,283333,NULL),(47,'A','2023-10-05','blandon',35,500000,500000,NULL),(48,'A','2023-10-05','blandon',35,1000000,1000000,NULL),(50,'A','2023-10-05','blandon',35,200000,200000,NULL),(51,'A','2023-02-10','blandon',19,1000000,375000,NULL),(52,'A','2023-10-10','blandon',31,800000,657000,NULL),(53,'C','2023-05-19','blandon',31,1000000,0,NULL),(57,'C','2023-11-11','blandon',48,200000,0,NULL),(58,'A','2023-08-15','blandon',47,1000000,600000,NULL),(63,'C','2023-10-13','blandon',47,400000,0,NULL),(64,'C','2023-07-05','blandon',39,1500000,0,NULL),(82,'A','2023-06-30','maelito',22,1000000,350000,NULL),(83,'C','2023-09-22','blandon',11,600000,0,NULL),(84,'A','2023-11-24','blandon',36,700000,525000,NULL),(86,'C','2023-11-27','blandon',37,120000,0,NULL),(87,'A','2023-11-29','blandon',8,1300000,1083333,NULL),(88,'A','2023-11-29','blandon',49,1000000,800000,NULL),(89,'A','2023-12-01','blandon',50,300000,300000,NULL),(90,'A','2023-04-01','blandon',32,1000000,100000,NULL),(91,'A','2023-12-04','blandon',52,400000,200000,NULL),(92,'A','2023-12-04','blandon',51,1000000,909090,NULL),(93,'A','2023-12-05','blandon',53,1000000,666666,NULL),(94,'A','2023-12-16','blandon',54,2000000,1666666,NULL),(95,'A','2023-12-18','blandon',55,500000,400000,NULL),(96,'A','2023-12-21','blandon',36,1000000,800000,NULL),(97,'A','2023-12-22','blandon',11,600000,400000,NULL),(98,'A','2024-01-05','blandon',24,200000,200000,NULL),(99,'A','2024-01-06','blandon',37,480000,480000,NULL),(101,'A','2024-01-07','blandon',48,200000,100000,NULL),(102,'A','2024-01-09','blandon',56,1000000,1000000,NULL),(103,'A','2024-01-10','blandon',57,500000,500000,NULL),(104,'A','2024-01-01','blandon',9,9999999,9999999,NULL),(105,'A','2024-01-11','blandon',6,1000000,1000000,NULL),(106,'A','2023-10-21','blandon',28,150000,150000,NULL),(107,'A','2024-01-22','blandon',58,400000,400000,NULL),(108,'A','2024-01-25','blandon',19,300000,300000,NULL);
/*!40000 ALTER TABLE `credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuota_credito`
--

DROP TABLE IF EXISTS `cuota_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuota_credito` (
  `id_cuota_credito` int NOT NULL AUTO_INCREMENT,
  `couta_numero` int NOT NULL,
  `fecha_abono` date DEFAULT NULL,
  `fecha_cuota` date NOT NULL,
  `interes_porcentaje` double NOT NULL,
  `numero_cuotas` int NOT NULL,
  `valor_abonado` double DEFAULT NULL,
  `valor_capital` double NOT NULL,
  `valor_cuota` double NOT NULL,
  `valor_interes` double NOT NULL,
  `id_credito` int NOT NULL,
  `tipo_abono` varchar(255) DEFAULT NULL,
  `abono_extra` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_cuota_credito`),
  KEY `FKqkddm4onlompx5m7xe3a23dq` (`id_credito`),
  KEY `multi_index` (`fecha_cuota`,`fecha_abono`),
  CONSTRAINT `FKqkddm4onlompx5m7xe3a23dq` FOREIGN KEY (`id_credito`) REFERENCES `credito` (`id_credito`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota_credito`
--

LOCK TABLES `cuota_credito` WRITE;
/*!40000 ALTER TABLE `cuota_credito` DISABLE KEYS */;
INSERT INTO `cuota_credito` VALUES (2,1,'2023-11-24','2023-11-24',7,3,243400,200000,243400,43400,2,'CN',_binary '\0'),(3,1,'2023-11-01','2023-11-01',7,10,184400,120000,184400,64400,3,'CN',NULL),(4,1,'2023-11-08','2023-11-05',7,5,272333,200000,272333,72333,4,'CN',NULL),(5,1,'2023-11-08','2023-11-04',7,5,163400,120000,163400,43400,5,'CN',NULL),(6,1,'2023-11-21','2023-11-17',7,3,121700,100000,121700,21700,6,'CN',_binary '\0'),(7,1,'2023-08-05','2023-08-05',7,7,213000,142857,215190,72333,7,NULL,NULL),(8,2,'2023-09-05','2023-09-05',7,7,213000,142857,212857,70000,7,NULL,NULL),(9,3,'2023-10-05','2023-10-05',7,7,213000,142857,212857,70000,7,NULL,NULL),(10,4,'2023-11-08','2023-11-05',7,7,212857,142857,212857,70000,7,'CN',NULL),(13,1,'2023-11-01','2023-10-15',7,2,285000,250000,285000,35000,10,NULL,NULL),(56,2,'2023-12-03','2023-12-01',7,10,204000,120000,204000,84000,3,'CN',_binary '\0'),(57,1,'2023-11-01','2023-08-05',5,10,227500,150000,227500,77500,21,NULL,NULL),(58,2,'2023-11-01','2023-09-05',5,10,225000,150000,225000,75000,21,NULL,NULL),(59,3,'2023-11-01','2023-10-05',5,10,225000,150000,225000,75000,21,NULL,NULL),(60,4,'2023-11-07','2023-11-05',5,10,225000,150000,225000,75000,21,'CN',NULL),(67,2,'2023-11-20','2023-11-15',7,2,40000,0,285000,40000,10,'SI',NULL),(68,1,'2023-11-01','2023-10-01',5,6,260000,200000,260000,60000,23,NULL,NULL),(69,2,'2023-11-02','2023-11-01',5,6,260000,200000,260000,60000,23,'CN',NULL),(71,1,'2023-11-01','2023-10-01',7,1,28000,0,428000,28000,25,NULL,NULL),(72,1,'2023-11-03','2023-11-01',7,1,28000,0,428000,28000,25,'SI',NULL),(73,1,'2023-11-01','2023-09-01',7,10,258500,150000,258500,108500,26,NULL,NULL),(74,2,'2023-11-01','2023-10-01',7,10,255000,150000,255000,105000,26,NULL,NULL),(75,3,'2023-11-03','2023-11-01',7,10,255000,150000,255000,105000,26,'CN',NULL),(76,1,'2023-11-01','2023-08-01',7,5,272333,200000,272333,72333,27,NULL,NULL),(77,2,'2023-11-01','2023-09-01',7,5,70000,0,270000,70000,27,NULL,NULL),(78,2,'2023-11-01','2023-10-01',7,5,70000,0,270000,70000,27,NULL,NULL),(79,2,'2023-11-02','2023-11-01',7,5,270000,200000,270000,70000,27,'CN',NULL),(82,1,'2023-11-01','2023-07-30',5,14,182143,107143,182143,75000,28,NULL,NULL),(83,2,'2023-11-01','2023-08-30',5,14,182142.85714285716,107142.85714285714,182142.85714285716,75000,28,NULL,NULL),(84,3,'2023-11-01','2023-09-30',5,14,182142.85714285716,107142.85714285714,182142.85714285716,75000,28,NULL,NULL),(85,4,'2023-11-03','2023-10-30',5,14,182142.85714285716,107142.85714285714,182142.85714285716,75000,28,NULL,NULL),(92,3,'2023-12-01','2023-12-01',7,5,70000,0,270000,70000,27,'SI',_binary '\0'),(94,1,'2023-11-02','2023-06-01',5,7,194524,142857,194524,51667,32,NULL,NULL),(95,2,'2023-11-02','2023-07-01',5,7,192857.14285714287,142857.14285714287,192857.14285714287,50000,32,NULL,NULL),(96,3,'2023-11-02','2023-08-01',5,7,192857.14285714287,142857.14285714287,192857.14285714287,50000,32,NULL,NULL),(97,4,'2023-11-02','2023-09-01',5,7,192857.14285714287,142857.14285714287,192857.14285714287,50000,32,NULL,NULL),(98,5,'2023-11-02','2023-10-01',5,7,50000,0,192857.14285714287,50000,32,NULL,NULL),(99,5,'2023-11-08','2023-11-01',5,7,192857.14285714287,142857.14285714287,192857.14285714287,50000,32,'CN',NULL),(100,3,'2023-12-05','2023-12-01',5,6,260000,200000,260000,60000,23,'CN',_binary '\0'),(101,1,'2023-11-02','2023-09-01',7,5,272333,200000,272333,72333,33,NULL,NULL),(102,2,'2023-11-02','2023-10-01',7,5,270000,200000,270000,70000,33,NULL,NULL),(103,3,'2023-11-02','2023-11-01',7,5,270000,200000,270000,70000,33,'CN',NULL),(104,4,'2023-12-02','2023-12-01',7,5,270000,200000,270000,70000,33,'CN',_binary '\0'),(105,5,'2023-12-16','2023-11-30',5,14,180000,107142.85714285714,182142.85714285716,72857.14285714286,28,'CN',_binary '\0'),(107,1,'2023-11-03','2023-11-02',7,5,272333,200000,272333,72333,34,'CN',NULL),(108,2,'2023-12-02','2023-12-02',7,5,270000,200000,270000,70000,34,'CN',_binary '\0'),(109,1,'2023-11-07','2023-11-03',5,4,181000,150000,181000,31000,35,'CN',NULL),(110,4,'2023-12-04','2023-12-01',7,10,110000,0,255000,110000,26,'SI',_binary '\0'),(111,1,'2023-12-01','2023-12-01',7,1,428000,400000,428000,28000,25,'CN',_binary '\0'),(112,2,'2023-12-04','2023-12-03',5,4,180000,150000,180000,30000,35,'CN',_binary '\0'),(113,5,'2023-12-05','2023-12-05',5,10,225000,150000,225000,75000,21,'CN',_binary '\0'),(114,6,'2023-12-19','2023-12-01',5,7,386000,306000,192857.14285714287,80000,32,'AC',_binary ''),(115,2,'2023-12-10','2023-12-05',7,5,75000,0,270000,75000,4,'SI',_binary '\0'),(116,5,'2023-12-07','2023-12-05',7,7,212857.14285714287,142857.14285714287,212857.14285714287,70000,7,'CN',_binary '\0'),(117,2,'2023-12-05','2023-12-04',7,5,162000,120000,162000,42000,5,'CN',_binary '\0'),(118,1,'2023-12-02','2023-12-01',7,5,56000,0,256000,56000,36,'SI',_binary '\0'),(119,1,'2023-12-05','2023-12-01',5,4,118000,100000,118000,18000,37,'CN',_binary '\0'),(120,1,'2023-11-09','2023-11-05',7,12,306667,166667,306667,140000,38,'CN',NULL),(121,1,'2023-11-08','2023-10-05',5,6,65000,50000,65000,15000,39,NULL,NULL),(122,2,'2023-11-08','2023-11-05',5,6,65000,50000,65000,15000,39,'CN',NULL),(123,3,'2023-12-07','2023-12-05',5,6,65000,50000,65000,15000,39,'CN',_binary '\0'),(125,1,'2023-11-08','2023-06-06',5,12,160000,100000,160000,60000,41,NULL,NULL),(126,2,'2023-11-08','2023-07-06',5,12,160000,100000,160000,60000,41,NULL,NULL),(127,3,'2023-11-08','2023-08-06',5,12,160000,100000,160000,60000,41,NULL,NULL),(128,4,'2023-11-08','2023-09-06',5,12,160000,100000,160000,60000,41,NULL,NULL),(129,5,'2023-11-08','2023-10-06',5,12,160000,100000,160000,60000,41,NULL,NULL),(130,6,'2023-11-10','2023-11-06',5,12,160000,100000,160000,60000,41,'CN',NULL),(131,2,'2023-12-14','2023-12-05',7,12,150000,0,306666.6666666666,150000,38,'SI',_binary '\0'),(132,1,'2023-12-12','2023-12-09',7,1,70000,0,1070000,70000,42,'SI',_binary '\0'),(133,1,'2023-12-09','2023-12-09',7,1,2140000,2000000,2140000,140000,43,'CN',_binary '\0'),(136,1,'2023-11-09','2023-10-09',5,6,184167,141667,184167,42500,46,NULL,NULL),(137,2,'2023-11-10','2023-11-09',5,6,184166.66666666666,141666.66666666666,184166.66666666666,42500,46,'CN',NULL),(138,1,'2023-11-09','2023-11-05',5,1,25000,0,525000,25000,47,'SI',NULL),(139,1,'2023-11-09','2023-11-05',7,1,70000,0,1070000,70000,48,'SI',NULL),(143,1,'2023-12-05','2023-12-05',5,1,25000,0,525000,25000,47,'SI',_binary '\0'),(144,1,'2023-12-05','2023-12-05',7,1,70000,0,1070000,70000,48,'SI',_binary '\0'),(145,1,'2023-11-09','2023-11-05',7,1,14000,0,214000,14000,50,'SI',NULL),(146,1,'2023-12-05','2023-12-05',7,1,14000,0,214000,14000,50,'SI',_binary '\0'),(151,1,'2023-11-10','2023-03-10',5,8,171667,125000,171667,46667,51,'CN',NULL),(152,2,'2023-11-10','2023-04-10',5,8,175000,125000,175000,50000,51,'CN',NULL),(153,3,'2023-11-10','2023-05-10',5,8,175000,125000,175000,50000,51,'CN',NULL),(154,4,'2023-11-10','2023-06-10',5,8,175000,125000,175000,50000,51,'CN',NULL),(155,5,'2023-11-10','2023-07-10',5,8,175000,125000,175000,50000,51,'CN',NULL),(156,6,'2023-11-10','2023-08-10',5,8,50000,0,175000,50000,51,'SI',NULL),(157,6,'2023-11-10','2023-09-10',5,8,50000,0,175000,50000,51,'SI',NULL),(158,6,'2023-11-10','2023-10-10',5,8,50000,0,175000,50000,51,'SI',NULL),(159,6,'2023-11-10','2023-11-10',5,8,50000,0,175000,50000,51,'SI',NULL),(160,6,'2023-12-14','2023-12-10',5,8,50000,0,175000,50000,51,'SI',_binary '\0'),(161,7,'2023-12-14','2023-12-06',5,12,170000,100000,160000,70000,41,'CN',_binary '\0'),(162,3,'2023-12-14','2023-12-09',5,6,190000,141666.66666666666,184166.66666666666,48333.33333333334,46,'CN',_binary '\0'),(163,1,'2023-11-30','2023-11-10',5,1,50000,0,840000,50000,52,'SI',_binary '\0'),(164,1,'2023-11-10','2023-06-19',5,8,175000,125000,175000,50000,53,'CN',NULL),(165,2,'2023-11-10','2023-07-19',5,8,175000,125000,175000,50000,53,'CN',NULL),(166,3,'2023-11-10','2023-08-19',5,8,175000,125000,175000,50000,53,'CN',NULL),(167,4,'2023-11-10','2023-09-19',5,8,175000,125000,175000,50000,53,'CN',NULL),(168,5,'2023-11-10','2023-10-19',5,8,175000,125000,175000,50000,53,'CN',NULL),(169,6,'2023-11-20','2023-11-19',5,8,175000,125000,175000,50000,53,'CN',NULL),(176,1,'2023-11-28','2023-12-11',10,1,100000,100000,220000,0,57,'AC',_binary ''),(192,1,'2023-11-17','2023-09-15',7,1,70000,0,1070000,70000,58,'SI',NULL),(193,1,'2023-11-17','2023-10-15',7,1,70000,0,1070000,70000,58,'SI',NULL),(198,1,'2023-11-17','2023-11-15',7,1,200000,200000,1070000,0,58,'AC',_binary ''),(199,1,'2023-11-20','2023-11-15',7,1,75000,0,1070000,75000,58,'SI',NULL),(206,1,'2023-11-20','2023-11-13',7,1,33000,0,428000,33000,63,'SI',NULL),(207,2,'2023-11-29','2023-12-15',7,2,250000,250000,285000,16333,10,'AC',_binary ''),(208,1,'2023-11-29','2023-12-13',7,1,400067,400067,428000,14933,63,'AC',_binary ''),(209,1,'2023-12-16','2023-12-21',7,1,200000,200000,1084000,0,58,'AC',_binary ''),(210,7,'2023-12-19','2023-12-19',5,8,175000,125000,175000,50000,53,'CN',_binary '\0'),(211,1,'2023-11-20','2023-08-05',5,10,225000,150000,225000,75000,64,'CN',NULL),(212,2,'2023-11-20','2023-09-05',5,10,225000,150000,225000,75000,64,'CN',NULL),(213,3,'2023-11-20','2023-10-05',5,10,225000,150000,225000,75000,64,'CN',NULL),(214,4,'2023-11-20','2023-11-05',5,10,225000,150000,225000,75000,64,'CN',NULL),(215,5,'2023-11-20','2023-12-05',5,10,800000,800000,225000,0,64,'AC',_binary ''),(216,5,'2023-12-05','2023-12-05',5,10,175000,100000,225000,75000,64,'AC',_binary ''),(244,2,'2023-12-19','2023-12-17',7,3,121000,100000,121000,21000,6,'CN',_binary '\0'),(280,1,'2023-11-22','2023-07-31',7,4,320000,250000,320000,70000,82,'CN',_binary '\0'),(281,2,'2023-11-22','2023-08-31',7,4,70000,0,320000,70000,82,'SI',_binary '\0'),(282,2,'2023-11-22','2023-10-01',7,4,70000,0,320000,70000,82,'SI',_binary '\0'),(283,2,'2023-11-22','2023-11-01',7,4,75000,0,320000,75000,82,'SI',_binary '\0'),(284,2,'2023-11-22','2023-12-01',7,4,400000,400000,320000,0,82,'AC',_binary ''),(285,2,'2023-11-30','2023-12-01',7,4,70000,0,320000,70000,82,'SI',_binary '\0'),(286,1,'2023-11-23','2023-10-22',7,3,242000,200000,242000,42000,83,'CN',_binary '\0'),(287,2,'2023-11-24','2023-11-22',7,3,242000,200000,242000,42000,83,'CN',_binary '\0'),(288,1,'2023-12-30','2023-12-30',5,4,217000,175000,217000,42000,84,'CN',_binary '\0'),(289,3,'2023-12-22','2023-12-22',7,3,242000,200000,242000,42000,83,'CN',_binary '\0'),(290,2,'2023-12-21','2023-12-24',7,3,242000,200000,242000,42000,2,'CN',_binary '\0'),(301,1,'2024-01-03','2024-01-03',7,1,130360,120000,130360,10360,86,'CN',_binary '\0'),(302,1,'2023-12-12','2023-12-11',10,1,120667,100000,220000,10000,57,'AC',_binary ''),(303,1,'2023-12-31','2023-12-26',7,6,303567,216666.66666666666,298567,86900.33333333334,87,'CN',_binary '\0'),(304,1,'2023-12-15','2023-12-15',7,10,137333,100000,137333,37333,88,'CN',_binary '\0'),(305,2,'2023-12-31','2024-01-01',7,4,70000,0,320000,70000,82,'SI',_binary '\0'),(306,1,'2023-12-16','2023-12-10',5,1,50000,0,840000,50000,52,'SI',_binary '\0'),(307,3,'2024-01-03','2024-01-01',7,5,70000,0,270000,70000,27,'SI',_binary '\0'),(308,1,'2024-01-02','2024-01-04',7,3,23800,0,123800,23800,89,'SI',_binary '\0'),(309,3,'2024-01-03','2024-01-02',7,5,270000,200000,270000,70000,34,'CN',_binary '\0'),(310,1,'2023-05-01','2023-05-01',5,10,505000,100000,150000,405000,90,'CN',_binary '\0'),(311,2,'2023-06-01','2023-06-01',5,10,455000,100000,150000,355000,90,'CN',_binary '\0'),(312,3,'2023-07-01','2023-07-01',5,10,405000,100000,150000,305000,90,'CN',_binary '\0'),(313,4,'2023-08-01','2023-08-01',5,10,355000,100000,150000,255000,90,'CN',_binary '\0'),(314,5,'2023-09-01','2023-09-01',5,10,300000,100000,150000,200000,90,'CN',_binary '\0'),(315,6,'2023-10-01','2023-10-01',5,10,250000,100000,150000,150000,90,'CN',_binary '\0'),(316,7,'2023-11-01','2023-11-01',5,10,150000,100000,150000,500000,90,'CN',_binary '\0'),(317,8,'2023-12-06','2023-12-01',5,10,150000,100000,150000,50000,90,'CN',_binary '\0'),(318,5,NULL,'2024-01-01',7,5,NULL,0,270000,70000,33,NULL,NULL),(319,1,'2024-01-05','2024-01-01',7,5,75000,0,270000,75000,36,'SI',_binary '\0'),(320,3,'2024-01-03','2024-01-01',7,10,204000,120000,204000,84000,3,'CN',_binary '\0'),(321,4,'2024-01-12','2024-01-01',7,10,270000,150000,255000,120000,26,'CN',_binary '\0'),(322,1,'2024-01-03','2024-01-04',7,2,228000,200000,228000,28000,91,'CN',_binary '\0'),(323,3,'2024-01-04','2024-01-03',5,4,180000,150000,180000,30000,35,'CN',_binary '\0'),(324,1,'2024-01-04','2024-01-03',7,11,160909,90909.09090909091,160909,69999.90909090909,92,'CN',_binary '\0'),(325,4,'2023-12-31','2024-01-01',5,6,60000,0,260000,60000,23,'SI',_binary '\0'),(326,2,'2023-12-31','2024-01-01',5,4,20000,0,120000,20000,37,'SI',_binary '\0'),(327,1,'2024-01-05','2024-01-05',5,1,25000,0,525000,25000,47,'SI',_binary '\0'),(328,1,'2024-01-05','2024-01-05',7,1,70000,0,1070000,70000,48,'SI',_binary '\0'),(329,1,'2024-01-05','2024-01-05',7,1,14000,0,214000,14000,50,'SI',_binary '\0'),(330,6,'2024-01-03','2024-01-05',5,10,225000,150000,225000,75000,21,'CN',_binary '\0'),(331,1,'2024-01-06','2024-01-05',7,3,403333,333333.3333333333,403333,69999.66666666669,93,'CN',_binary '\0'),(332,3,'2024-01-06','2024-01-04',7,5,42000,0,162000,42000,5,'SI',_binary '\0'),(333,9,'2024-01-10','2024-01-01',5,10,150000,100000,150000,50000,90,'CN',_binary '\0'),(334,6,'2024-01-09','2024-01-05',7,7,70000,0,212857.14285714287,70000,7,'SI',_binary '\0'),(335,4,'2024-01-04','2024-01-05',5,6,65000,50000,65000,15000,39,'CN',_binary '\0'),(336,2,'2024-01-09','2024-01-05',7,5,70000,0,270000,70000,4,'SI',_binary '\0'),(337,1,'2023-12-12','2024-01-09',7,1,100000,100000,1070000,0,42,'AC',_binary ''),(338,1,'2024-01-10','2024-01-09',7,1,70000,0,1070000,70000,42,'SI',_binary '\0'),(339,4,'2024-01-18','2024-01-15',5,6,197666.66666666666,141666.66666666666,192666.66666666666,56000,46,'CN',_binary '\0'),(340,8,'2024-01-18','2024-01-15',5,12,183000,100000,178000,83000,41,'CN',_binary '\0'),(341,2,'2024-01-11','2024-01-05',7,12,145000,0,306666.6666666666,145000,38,'SI',_binary '\0'),(342,6,'2024-01-12','2024-01-10',5,8,50000,0,175000,50000,51,'SI',_binary '\0'),(343,2,'2024-01-16','2024-01-15',7,10,170000,100000,170000,70000,88,'CN',_binary '\0'),(344,1,'2023-12-16','2023-12-21',7,1,73000,0,1070000,73000,58,'SI',_binary '\0'),(345,1,'2024-01-01','2023-12-31',3.5,12,236667,166666.66666666666,236667,70000.33333333334,94,'CN',_binary '\0'),(346,1,'2023-12-23','2024-01-10',5,1,143000,143000,840000,0,52,'AC',_binary ''),(347,6,'2024-01-16','2023-12-30',5,14,180000,107142.85714285714,182142.85714285716,72857.14285714286,28,'CN',_binary '\0'),(348,1,'2024-01-18','2024-01-18',7,5,135000,100000,135000,35000,95,'CN',_binary '\0'),(349,8,'2023-12-23','2024-01-19',5,8,132000,125333,175000,6667,53,'AC',_binary ''),(350,3,'2024-01-19','2024-01-17',7,3,121000,100000,121000,21000,6,'CN',_binary '\0'),(351,1,NULL,'2024-01-21',7,1,NULL,0,1070000,70000,58,NULL,NULL),(352,1,'2024-01-19','2024-01-15',5,5,246667,200000,241667,46667,96,'CN',_binary '\0'),(353,3,'2024-01-24','2024-01-24',7,3,242000,200000,242000,42000,2,'CN',_binary '\0'),(354,1,'2024-01-23','2024-01-22',7,3,242000,200000,242000,42000,97,'CN',_binary '\0'),(355,1,NULL,'2024-01-10',5,1,NULL,0,840000,40000,52,NULL,NULL),(356,2,NULL,'2024-01-30',5,4,NULL,0,210000,35000,84,NULL,NULL),(357,2,NULL,'2024-01-26',7,6,NULL,0,307666.6666666666,91000,87,NULL,NULL),(358,2,NULL,'2024-02-01',7,4,NULL,0,320000,70000,82,NULL,NULL),(359,2,'2023-12-31','2024-02-01',5,4,50000,50000,120000,0,37,'AC',_binary ''),(360,4,'2023-12-31','2024-02-01',5,6,50000,50000,260000,0,23,'AC',_binary ''),(361,2,NULL,'2024-02-01',5,4,NULL,0,120000,20000,37,NULL,NULL),(362,4,NULL,'2024-02-01',5,6,NULL,0,260000,60000,23,NULL,NULL),(363,2,'2024-01-16','2024-01-15',3.5,12,236666.66666666666,166666.66666666666,236666.66666666666,70000,94,'CN',_binary '\0'),(364,1,NULL,'2024-02-04',7,3,NULL,0,121000,21000,89,NULL,NULL),(365,7,NULL,'2024-02-05',5,10,NULL,0,225000,75000,21,NULL,NULL),(366,2,NULL,'2024-02-04',7,2,NULL,0,228000,28000,91,NULL,NULL),(367,4,NULL,'2024-02-01',7,10,NULL,0,204000,84000,3,NULL,NULL),(368,3,NULL,'2024-02-01',7,5,NULL,0,270000,70000,27,NULL,NULL),(369,4,NULL,'2024-02-02',7,5,NULL,0,270000,70000,34,NULL,NULL),(370,4,NULL,'2024-02-03',5,4,NULL,0,180000,30000,35,NULL,NULL),(371,2,NULL,'2024-02-03',7,11,NULL,0,160909.0909090909,70000,92,NULL,NULL),(372,5,'2024-01-04','2024-02-05',5,6,50000,50000,65000,0,39,'AC',_binary ''),(373,5,NULL,'2024-02-05',5,6,NULL,0,65000,15000,39,NULL,NULL),(374,1,NULL,'2024-02-05',5,1,NULL,0,525000,25000,47,NULL,NULL),(375,1,NULL,'2024-02-05',7,1,NULL,0,1070000,70000,48,NULL,NULL),(376,1,NULL,'2024-02-05',7,1,NULL,0,214000,14000,50,NULL,NULL),(377,1,NULL,'2024-02-15',7,2,NULL,0,119133,19133,98,NULL,NULL),(378,1,NULL,'2024-02-01',7,5,NULL,0,270000,70000,36,NULL,NULL),(379,2,NULL,'2024-02-05',7,3,NULL,0,403333.3333333333,70000,93,NULL,NULL),(380,1,NULL,'2024-02-03',7,4,NULL,0,151360,31360,99,NULL,NULL),(381,3,NULL,'2024-02-04',7,5,NULL,0,162000,42000,5,NULL,NULL),(383,1,'2024-01-23','2024-01-22',5,2,110000,100000,110000,10000,101,'CN',_binary '\0'),(384,1,NULL,'2024-02-01',7,10,NULL,0,153667,53667,102,NULL,NULL),(385,2,NULL,'2024-02-05',7,5,NULL,0,270000,70000,4,NULL,NULL),(386,6,NULL,'2024-02-05',7,7,NULL,0,212857.14285714287,70000,7,NULL,NULL),(387,1,NULL,'2024-02-05',7,3,NULL,0,197000,30333,103,NULL,NULL),(388,10,NULL,'2024-02-01',5,10,NULL,0,150000,50000,90,NULL,NULL),(389,1,'2024-01-10','2024-02-09',7,1,100000,100000,1070000,0,42,'AC',_binary ''),(390,1,NULL,'2024-02-09',7,1,NULL,0,1070000,70000,42,NULL,NULL),(391,2,NULL,'2024-02-05',7,12,NULL,0,306666.6666666666,140000,38,NULL,NULL),(392,1,'2024-01-12','2024-01-31',0,1,100000,0,9999999,100000,104,'SI',_binary ''),(393,1,NULL,'2024-02-17',7,7,NULL,0,229190,86333,105,NULL,NULL),(394,6,NULL,'2024-02-10',5,8,NULL,0,175000,50000,51,NULL,NULL),(395,5,NULL,'2024-02-01',7,10,NULL,0,255000,105000,26,NULL,NULL),(396,1,'2024-01-22','2024-01-31',0,1,100000,0,9999999,100000,104,'SI',_binary ''),(397,7,NULL,'2024-01-30',5,14,NULL,0,182142.85714285716,75000,28,NULL,NULL),(398,3,NULL,'2024-02-15',7,10,NULL,0,170000,70000,88,NULL,NULL),(399,3,NULL,'2024-01-30',3.5,12,NULL,0,236666.66666666666,70000,94,NULL,NULL),(400,2,NULL,'2024-02-18',7,5,NULL,0,135000,35000,95,NULL,NULL),(401,9,NULL,'2024-02-15',5,12,NULL,0,160000,60000,41,NULL,NULL),(402,5,NULL,'2024-02-15',5,6,NULL,0,184166.66666666666,42500,46,NULL,NULL),(403,2,NULL,'2024-02-15',5,5,NULL,0,250000,50000,96,NULL,NULL),(404,1,'2023-11-22','2023-11-21',7,1,12000,0,160500,12000,106,'SI',_binary '\0'),(405,1,'2024-01-22','2023-12-21',7,1,0,0,160500,0,106,'SI',_binary '\0'),(406,1,'2024-01-22','2024-01-21',7,1,22000,0,160500,22000,106,'SI',_binary '\0'),(407,1,NULL,'2024-02-21',7,1,NULL,0,160500,10500,106,NULL,NULL),(408,1,NULL,'2024-02-20',7,5,NULL,0,107067,27067,107,NULL,NULL),(409,1,NULL,'2024-01-31',0,1,NULL,0,9999999,0,104,NULL,NULL),(410,2,NULL,'2024-02-22',7,3,NULL,0,242000,42000,97,NULL,NULL),(411,2,NULL,'2024-02-06',5,2,NULL,0,110000,10000,101,NULL,NULL),(412,1,NULL,'2024-02-15',7,5,NULL,0,74700,14700,108,NULL,NULL);
/*!40000 ALTER TABLE `cuota_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidad`
--

DROP TABLE IF EXISTS `modalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidad` (
  `id_modalidad` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_modalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidad`
--

LOCK TABLES `modalidad` WRITE;
/*!40000 ALTER TABLE `modalidad` DISABLE KEYS */;
INSERT INTO `modalidad` VALUES (1,'mensual'),(2,'quincenal');
/*!40000 ALTER TABLE `modalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_ADMIN'),(3,'ROLE_USER'),(4,'ROLE_ADMIN'),(5,'ROLE_ADMIN'),(6,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Locombia','maelito@gmail.com','Maelito','Blandon','$2a$10$jAehpayzhvQwqEPkdHxoIemq/tMujfiTYDTs1vLv42VaDn.mVHQKi','maelito'),(3,'Locombia','blandon@gmail.com','Cristian','Blandon','$2a$10$BHCpFVvXCeVj2nCwlaF4uOAlWuzAaLYjmAaV3tlocIujVYHvyNBGq','blandon'),(11,'Locombia','quinio@gmail.com','Byron','Quinones','$2a$10$1mOoLIv3nDvRv.aXWBphE.qLVZFd8ON32WSsDRo6Vdy25mYZgy7wm','mumilon'),(13,'Locombia','qnio@gmail.com','Byron','Quinones','$2a$10$T6ycYMHcDXXw7TdHPQC0UOLJTsZf4ZG6vyCN7cBuJYdKz1FJdbCIa','mulon'),(14,'Locombia','nuevo@gmail.com','Byron','Quinones','$2a$10$jWD1.iytgWDwRjyoPaMZDO3wnahTR2YTO4RYu44USlSuGFSUhF896','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` int NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(3,2),(3,3),(11,4),(13,5),(14,6);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-30  9:25:21

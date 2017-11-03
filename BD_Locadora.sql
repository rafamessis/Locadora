CREATE DATABASE  IF NOT EXISTS `locadorafilme` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `locadorafilme`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: locadorafilme
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCat` varchar(45) NOT NULL,
  `valorLoc` double NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Lançamento',8),(2,'Semi-Lançamento',6);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(45) NOT NULL,
  `cpfCliente` int(11) NOT NULL,
  `telefoneCliente` varchar(45) NOT NULL,
  `emailCliente` varchar(45) NOT NULL,
  `enderecoCliente` varchar(45) NOT NULL,
  `numeroCliente` int(11) DEFAULT NULL,
  `cidadeCliente` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Hudson',1,'1','1','1',1,'1'),(2,'Hudson2',1,'1','1','1',1,'1'),(3,'Hudson10',1,'1','1','1',1,'1'),(4,'Hudson11',1,'1','1','1',NULL,'1'),(5,'Hudson5',1,'1','1','1',NULL,'1'),(9,'Hudson Henrique da Silva',628570465,'37 3222-2222','hudson@google.com.br','Rua Goiás, 150, Centro',NULL,'Divinópolis');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuidora`
--

DROP TABLE IF EXISTS `distribuidora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distribuidora` (
  `iddistribuidora` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`iddistribuidora`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuidora`
--

LOCK TABLES `distribuidora` WRITE;
/*!40000 ALTER TABLE `distribuidora` DISABLE KEYS */;
INSERT INTO `distribuidora` VALUES (1,'Universal Pictures'),(2,'Globo Filmes');
/*!40000 ALTER TABLE `distribuidora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filmes`
--

DROP TABLE IF EXISTS `filmes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmes` (
  `idFilmes` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFilme` varchar(45) NOT NULL,
  `qntdDiscos` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  `genero` int(11) NOT NULL,
  `tipoMidia` int(11) NOT NULL,
  `distribuidora` int(11) NOT NULL,
  `atoresPrinc` varchar(45) DEFAULT NULL,
  `sinopse` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idFilmes`),
  KEY `categoria_idx` (`categoria`),
  KEY `genero_idx` (`genero`),
  KEY `tipoMidia_idx` (`tipoMidia`),
  KEY `distribuidora_idx` (`distribuidora`),
  CONSTRAINT `categoria` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `distribuidora` FOREIGN KEY (`distribuidora`) REFERENCES `distribuidora` (`iddistribuidora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `genero` FOREIGN KEY (`genero`) REFERENCES `genero` (`idgenero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tipoMidia` FOREIGN KEY (`tipoMidia`) REFERENCES `tipomidia` (`idtipoMidia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmes`
--

LOCK TABLES `filmes` WRITE;
/*!40000 ALTER TABLE `filmes` DISABLE KEYS */;
INSERT INTO `filmes` VALUES (1,'Velozes e Furiosos',4,1,1,1,1,'Paul Walker, Vin Diesel','Desde que o ex-policial Brian O\'Conner e Mia Torretto libertaram Dom da prisão, eles viajam pelas fronteiras para fugir das autoridades. No Rio de Janeiro, eles fazem um último trabalho antes que possam ganhar sua liberdade definitiva.');
/*!40000 ALTER TABLE `filmes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` varchar(45) NOT NULL,
  `cpfFuncionario` int(11) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `cpfFuncionario_UNIQUE` (`cpfFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Maria Eduarda',526396857);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT,
  `nomeGenero` varchar(45) NOT NULL,
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Ação'),(2,'Suspense');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locacao` (
  `idLocacao` int(11) NOT NULL AUTO_INCREMENT,
  `idfilmeLocado` int(11) NOT NULL,
  `idClienteLocado` int(11) NOT NULL,
  `idFuncionarioLocado` int(11) NOT NULL,
  `datalocado` date NOT NULL,
  PRIMARY KEY (`idLocacao`),
  KEY `idFilmes_idx` (`idfilmeLocado`),
  KEY `IdClientes_idx` (`idClienteLocado`),
  KEY `IdFuncionario_idx` (`idFuncionarioLocado`),
  CONSTRAINT `Id Cliente` FOREIGN KEY (`idClienteLocado`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Id Filmes` FOREIGN KEY (`idfilmeLocado`) REFERENCES `filmes` (`idFilmes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Id Funcionario` FOREIGN KEY (`idFuncionarioLocado`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (1,1,1,1,'2017-11-02'),(2,1,9,1,'2017-11-03');
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomidia`
--

DROP TABLE IF EXISTS `tipomidia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipomidia` (
  `idtipoMidia` int(11) NOT NULL AUTO_INCREMENT,
  `nomeTipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipoMidia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomidia`
--

LOCK TABLES `tipomidia` WRITE;
/*!40000 ALTER TABLE `tipomidia` DISABLE KEYS */;
INSERT INTO `tipomidia` VALUES (1,'DVD'),(2,'VHS');
/*!40000 ALTER TABLE `tipomidia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'locadorafilme'
--

--
-- Dumping routines for database 'locadorafilme'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-03 12:03:50

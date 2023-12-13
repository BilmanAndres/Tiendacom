-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendacom
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `idCargo` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (12,'bodega',1),(13,'aministrador',1),(14,'vendedor ',1);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `idSexos` int NOT NULL,
  `fecha_nacimientos` date NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `idSexo_idx` (`idSexos`),
  CONSTRAINT `idSexo` FOREIGN KEY (`idSexos`) REFERENCES `sexo` (`idSexo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'p','66','kss@',1,'2023-11-09',1),(2,'dddf','3455','dd@kd',2,'2023-11-10',1),(233,'franco','2455','dd',1,'2000-11-10',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fact_com`
--

DROP TABLE IF EXISTS `fact_com`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fact_com` (
  `idfact_com` int NOT NULL,
  `idProvedores` int NOT NULL,
  `idUsuarios` int NOT NULL,
  `fecha` datetime NOT NULL,
  `total_compra` float NOT NULL,
  `tipo_de_pago` varchar(45) NOT NULL,
  `descuento` float NOT NULL,
  `comprovante` float NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idfact_com`),
  KEY `idProvedores_idx` (`idProvedores`),
  KEY `idUsuario_idx` (`idUsuarios`),
  CONSTRAINT `IdProvedores` FOREIGN KEY (`idProvedores`) REFERENCES `provedores` (`idProvedores`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idUsuarios` FOREIGN KEY (`idUsuarios`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fact_com`
--

LOCK TABLES `fact_com` WRITE;
/*!40000 ALTER TABLE `fact_com` DISABLE KEYS */;
INSERT INTO `fact_com` VALUES (99,333,32,'2023-11-29 12:25:17',0,'Targeta',0,0,1),(344,44,12,'2023-11-29 10:32:10',0,'tarjeta',0,0,1);
/*!40000 ALTER TABLE `fact_com` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factu_com_prod`
--

DROP TABLE IF EXISTS `factu_com_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factu_com_prod` (
  `idfactu_com_prod` int NOT NULL,
  `idfact_com` int NOT NULL,
  `idpro` int NOT NULL,
  `canti_compra` int NOT NULL,
  `precio_unitario` float NOT NULL,
  `precio_total` float NOT NULL,
  `fecha_fac_com` date NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idfactu_com_prod`),
  KEY `idfact_com_idx` (`idfact_com`),
  KEY `idproductos_idx` (`idpro`),
  CONSTRAINT `idfac_ com` FOREIGN KEY (`idfact_com`) REFERENCES `fact_com` (`idfact_com`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=ascii;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factu_com_prod`
--

LOCK TABLES `factu_com_prod` WRITE;
/*!40000 ALTER TABLE `factu_com_prod` DISABLE KEYS */;
INSERT INTO `factu_com_prod` VALUES (2211,99,1,1,0,0,'2023-12-11',1);
/*!40000 ALTER TABLE `factu_com_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int NOT NULL,
  `fecha` date NOT NULL,
  `idCliente` int NOT NULL,
  `idusuario` int NOT NULL,
  `comprovante` int NOT NULL,
  `tipo_pago` varchar(250) NOT NULL,
  `impuesto` float NOT NULL,
  `total_factura` float NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idUsuario_idx` (`idusuario`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idUsuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (899,'2023-12-11',2,23,1,'efectivo',0,0,1),(2344,'2023-12-11',1,12,4,'efectivo',0,0,1);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `mostar_tipo_persona`
--

DROP TABLE IF EXISTS `mostar_tipo_persona`;
/*!50001 DROP VIEW IF EXISTS `mostar_tipo_persona`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostar_tipo_persona` AS SELECT 
 1 AS `idtipo`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostra_producto`
--

DROP TABLE IF EXISTS `mostra_producto`;
/*!50001 DROP VIEW IF EXISTS `mostra_producto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostra_producto` AS SELECT 
 1 AS `idProducto`,
 1 AS `NombreProdcuto`,
 1 AS `descripcion`,
 1 AS `ImagenProducto`,
 1 AS `PrecioProducto`,
 1 AS `CantidadProductos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostra_proveedor`
--

DROP TABLE IF EXISTS `mostra_proveedor`;
/*!50001 DROP VIEW IF EXISTS `mostra_proveedor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostra_proveedor` AS SELECT 
 1 AS `idProvedores`,
 1 AS `DocumentoProvedor`,
 1 AS `NombreProvedor`,
 1 AS `SexoProvedor`,
 1 AS `correo`,
 1 AS `telefono`,
 1 AS `direccion`,
 1 AS `TipodePersona`,
 1 AS `fecha_nacimiento`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostra_tipo_documento`
--

DROP TABLE IF EXISTS `mostra_tipo_documento`;
/*!50001 DROP VIEW IF EXISTS `mostra_tipo_documento`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostra_tipo_documento` AS SELECT 
 1 AS `idocument`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostrar_cargo`
--

DROP TABLE IF EXISTS `mostrar_cargo`;
/*!50001 DROP VIEW IF EXISTS `mostrar_cargo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostrar_cargo` AS SELECT 
 1 AS `idCargo`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostrar_cliente`
--

DROP TABLE IF EXISTS `mostrar_cliente`;
/*!50001 DROP VIEW IF EXISTS `mostrar_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostrar_cliente` AS SELECT 
 1 AS `idClientes`,
 1 AS `Nombres_Clientes`,
 1 AS `telefono`,
 1 AS `correo`,
 1 AS `Nombre_Sexo`,
 1 AS `fecha_nacimientos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostrar_fact_com`
--

DROP TABLE IF EXISTS `mostrar_fact_com`;
/*!50001 DROP VIEW IF EXISTS `mostrar_fact_com`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostrar_fact_com` AS SELECT 
 1 AS `idfact_com`,
 1 AS `Nombre_Proveedores`,
 1 AS `Nombre_Usuarios`,
 1 AS `fecha`,
 1 AS `total_compra`,
 1 AS `tipo_de_pago`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostrar_factura`
--

DROP TABLE IF EXISTS `mostrar_factura`;
/*!50001 DROP VIEW IF EXISTS `mostrar_factura`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostrar_factura` AS SELECT 
 1 AS `ID_Factura`,
 1 AS `Fecha_Factura`,
 1 AS `IDCliente`,
 1 AS `IDusuario`,
 1 AS `Numero_Comprovante`,
 1 AS `Tipo_Pago`,
 1 AS `Impuesto`,
 1 AS `Total_Factura`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostrar_sexo`
--

DROP TABLE IF EXISTS `mostrar_sexo`;
/*!50001 DROP VIEW IF EXISTS `mostrar_sexo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostrar_sexo` AS SELECT 
 1 AS `ids`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mostrar_usuari`
--

DROP TABLE IF EXISTS `mostrar_usuari`;
/*!50001 DROP VIEW IF EXISTS `mostrar_usuari`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mostrar_usuari` AS SELECT 
 1 AS `IdUsu`,
 1 AS `NombreDeUsuario`,
 1 AS `telefono`,
 1 AS `correo`,
 1 AS `direccion`,
 1 AS `Genero`,
 1 AS `NombreCargo`,
 1 AS `login`,
 1 AS `fecha_nacimiento`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `imagen` longblob,
  `ruta` varchar(450) NOT NULL,
  `presico` float NOT NULL,
  `cantidad` int NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'teclado',' negro',NULL,'',0,0,1),(2,'impresora','blanca',NULL,'',0,0,0),(3,'Portatil','hp ',NULL,'',0,0,1),(4,'cpu','c',NULL,'',0,0,1),(5,'camara','para ejer',NULL,'',0,0,1),(345,'camara','profecional',NULL,'',0,0,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_factura`
--

DROP TABLE IF EXISTS `producto_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_factura` (
  `idProducto_factura` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `idFactura` int NOT NULL,
  `cantidad` int NOT NULL,
  `descuento` float NOT NULL,
  `total_ventas` float NOT NULL,
  PRIMARY KEY (`idProducto_factura`),
  KEY `idProducto_idx` (`idProducto`),
  KEY `idFactura_idx` (`idFactura`),
  CONSTRAINT `idFactura` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_factura`
--

LOCK TABLES `producto_factura` WRITE;
/*!40000 ALTER TABLE `producto_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provedores`
--

DROP TABLE IF EXISTS `provedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provedores` (
  `idProvedores` int NOT NULL,
  `tipo_de_documento` varchar(250) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `idsexsl` int NOT NULL,
  `correo` varchar(250) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `idtpo` varchar(250) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idProvedores`),
  KEY `idSexo_idx` (`idsexsl`),
  KEY `idocument_idx` (`tipo_de_documento`),
  KEY `idtipo_idx` (`idtpo`),
  CONSTRAINT `idsexs` FOREIGN KEY (`idsexsl`) REFERENCES `sexo` (`idSexo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provedores`
--

LOCK TABLES `provedores` WRITE;
/*!40000 ALTER TABLE `provedores` DISABLE KEYS */;
INSERT INTO `provedores` VALUES (44,'Pasaporte','ttt',2,'gg','hh','ttt','Juridica ','2023-11-02',1),(233,'Nit','ddddd',1,'ssd','2222','dddf','Juridica ','2023-11-02',1),(333,'Nit','444',1,'hhh','444','ggg','Juridica ','2023-11-02',1),(1899,'Nit','lalalalalalala',1,'ddddd','222222','qqqqq','Juridica ','2023-11-02',1),(32223,'ccc','ss',1,'dd','dd','dd','dd','1000-11-11',1),(88888,'Pasaporte','vvvvv',2,'vvvv','55555','ffff','Natural','2023-11-01',1);
/*!40000 ALTER TABLE `provedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sexo` (
  `idSexo` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idSexo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino',1),(2,'Femenino',1),(3,'Otros',1);
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
  `idocument` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idocument`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'Nit',1),(2,'Cedula',1),(3,'Otros',1);
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_persona`
--

DROP TABLE IF EXISTS `tipo_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_persona` (
  `idtipo` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `condicion` tinyint NOT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_persona`
--

LOCK TABLES `tipo_persona` WRITE;
/*!40000 ALTER TABLE `tipo_persona` DISABLE KEYS */;
INSERT INTO `tipo_persona` VALUES (1,'Natural',1),(2,'Juridica',1),(3,'Otros',1);
/*!40000 ALTER TABLE `tipo_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `idsexo` int NOT NULL,
  `idcargo` int NOT NULL,
  `login` varchar(7) NOT NULL,
  `clave` varchar(7) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `condicion` tinyint DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idCargo_idx` (`idcargo`),
  KEY `idsexo_idx` (`idsexo`),
  CONSTRAINT `idCargo` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idCargo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idsex` FOREIGN KEY (`idsexo`) REFERENCES `sexo` (`idSexo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (12,'dd','23444','lñ','gfg',2,12,'123','123','2000-11-10',0),(23,'lucho pe','244','d','dsgos',1,13,'49','kkl','2023-11-11',1),(32,'sd','33','ss','dd',3,14,'22','11','2000-11-11',0),(34,'dd','d','cc','dds',1,13,'45','123','2023-10-03',1),(123,'1212','121212','2121','1211',2,13,'iji','2121','2023-10-17',1),(467,'dfg','577','hff','dfg',1,13,'4566','','2023-11-14',1),(5776,'Etil','31233','eti@hd','sdd',2,12,'ddd','12233','2023-11-01',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tiendacom'
--
/*!50003 DROP PROCEDURE IF EXISTS `actu_cliente` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_cliente`(in idclien int, in nom varchar(250), in tel varchar(15), in corr varchar (250), in idsex int, in fech_naci date)
BEGIN
update cliente set nombre = nom, telefono = tel, correo = corr, idSexos = idsex, fecha_nacimientos =fech_naci where idCliente =  idclien;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `actu_factura` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_factura`(in fact int, in idcli int, in idusu int, in ti_pago varchar (250), in impues float, in total_falctu float)
BEGIN
update factura set idCliente = idcli, idusuario = idusu, comprovante = comprov,  tipo_pago = ti_pago, impuesto = impues, total_factura = total_falctu where idFactura = fact;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `actu_factu_com_prod` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_factu_com_prod`(in idfac_co_pro int, in idfac_co int, in idPro int, in cant_com int, in precio_uni float, in pre_tot float, descu float, fecha_ac_compru date)
BEGIN
update factu_com_prod set idfact_com = idfac_co, idProducto = idPro, canti_compra = cant_com, precio_unitario = precio_uni, precio_total = pre_tot, descuento = descu, fecha_fac_com = fecha_ac_compru where idfactu_com_prod = idfac_co_pro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `actu_fact_com` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_fact_com`(in idf_com int, in idPro int, in idUs int, in tipo_pag varchar (45))
BEGIN
update fact_com set  idProvedores= idPro, idUsuarios = idUs, tipo_de_pago= tipo_pag where idfact_com = idfact_com;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `actu_producto` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_producto`(in idpro int, in nom varchar (250), in descri varchar (250), in ima LONGBLOB , in ru varchar(450))
BEGIN
update producto set nombre = nom,  descripcion = descri, imagen = ima, ruta = ru where idProducto = idpro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `actu_provedores` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_provedores`(in idprov int, in tipo_docu int, in nom varchar (250), in idsex int, in corr varchar (250), in tele varchar (10), in direc varchar (50), in ti_perso int, fech_naci date )
BEGIN
update provedores set tipo_de_documento =tipo_docu, nombre = nom, idsexsl = idsex, correo = corr, telefono = tele, direccion = direc, idtpo=ti_perso, fecha_nacimiento =fech_naci where idProvedores = idprov;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `actu_usuarios` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actu_usuarios`(in idUsu int, in nom varchar (250), in telef varchar (15), in corr varchar (250), in direc varchar (250), in idsex int, in idcarg int, in clav varchar (7), in fech_naci date)
BEGIN
update usuarios set nombre = nom, telefono = telef, correo = corr, direccion = direc, idsexo = idsex, idcargo = idcarg, clave = clav, fecha_nacimiento = fech_naci where idUsuario = idUsu;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_clien` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_clien`(in  valor int)
BEGIN
select * from cliente where idCliente = valor ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_factura` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_factura`(in valor int)
BEGIN
 select * from factura where idFactura = valor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_factu_com_prod` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_factu_com_prod`(in valor int)
BEGIN
select * from factu_com_prod where idfac_co_pro = valor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_fact_com` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_fact_com`(in valor int)
BEGIN
select * from fact_com where idfact_com = valor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_producto` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_producto`(in valor int )
BEGIN
select * from producto where idProducto = valor; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_provee` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_provee`(in valor int)
BEGIN
select * from provedores where idProvedores = valor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_usu` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_usu`(in valor int)
BEGIN
 select * from usuarios where idUsuario = valor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_clientes` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_clientes`(in valor varchar(45))
BEGIN
SELECT * FROM mostrar_cliente where idClientes like concat('%', valor,'%')||Nombres_Clientes like concat('%', valor,'%')
||telefono like concat('%',valor,'%')||correo like concat('%', valor,'%')
||Nombre_Sexo like concat('%',valor,'%')||fecha_nacimientos like concat('%',valor,'%');

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_factura` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_factura`(in valor varchar(45))
BEGIN
SELECT * FROM mostrar_factura where ID_Factura like concat('%',valor,'%')||Fecha_Factura like concat('%',valor,'%')||
IDCliente like concat('%',valor,'%')|| IDusuario  like concat('%',valor,'%')||Numero_Comprovante like concat('%',valor,'%') ||Tipo_Pago like concat('%',valor,'%')
||Impuesto like concat('%',valor,'%')|| Total_Factura like concat('%',valor,'%') ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_factu_com_prod` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_factu_com_prod`(in valor varchar(45))
BEGIN
SELECT * FROM mostrar_factu_com_prod where ID_CO_PRO like concat('%',valor,'%')||
ID_CO_PRO like concat('%',valor,'%')|| Nombre_Productos like concat('%',valor,'%')
|| Cantiadad_Comprar like concat('%',valor,'%')|| Precio_Unitario like concat('%',valor,'%')
|| Precio_Total like concat('%', valor,'%')|| descuento like concat('%',valor,'%')||
fecha_fac_com like concat('&',valor,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_fact_com` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_fact_com`(in valor varchar(45))
BEGIN
SELECT * FROM  mostrar_fact_com where idfact_com like concat('%',valor,'%')||Nombre_Proveedores like concat('%',valor,'%')
||Nombre_Usuarios like concat('%', valor,'%')||fecha like concat('%',valor,'%')|| total_compra like concat('%',valor,'%')
|| tipo_de_pago like concat('%',valor,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_producto` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_producto`(in valor varchar(45))
BEGIN
SELECT * FROM mostra_producto where idProducto like concat('%',valor,'%')|| NombreProdcuto like concat('%',valor,'%')
||descripcion like concat('%',valor,'%')|| ImagenProducto like concat('%',valor,'%')
|| PrecioProducto like concat('%',valor,'%')|| CantidadProductos like concat('%',valor,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_provedoree` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_provedoree`(in valor varchar(45))
BEGIN
SELECT * FROM mostar_proveedor where idProvedores like concat('%',valor,'%')||
DocumentoProvedor like concat('%',valor,'%')||NombreProvedor like concat('%',valor,'%')||
SexoProvedor like concat('%',valor,'%')|| correo like concat('%',valor,'%')
|| telefono like concat('%',valor,'%') || direccion like concat('%', valor,'%')
|| TipodePersona like concat('%', valor,'&')|| fecha_nacimiento like concat('%',valor,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `consul_usuarios` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consul_usuarios`(in valor varchar(45))
BEGIN
SELECT * FROM mostrar_usuari where IdUsu like concat('%',valor,'%')||NombreDeUsuario like concat('%',valor,'%')
|| telefono like concat('%',valor,'%')|| correo like concat('%',valor,'%')
||direccion like concat('%',valor,'%')|| Genero like concat('%',valor,'%') || NombreCargo like concat('%',valor,'%')
|| login like concat('%',valor,'%')|| fecha_nacimiento like concat('%',valor,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cli` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cli`(in idclien int )
BEGIN
update cliente set condicion = '0' where idCliente = idclien;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_factura` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_factura`(in fact int)
BEGIN
update factura set condicion = '0' where idFactura = fact;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_factu_com_prod` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_factu_com_prod`(in idfac_co_pro int)
BEGIN
update factu_com_prod set condicion = '0' where idfactu_com_prod = idfac_co_pro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_fact_com` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_fact_com`(in idf_com int)
BEGIN
update fact_com set condicion = '0' where idfact_com = idf_com;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_producto` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_producto`(in idpro int )
BEGIN
update producto set condicion = '0' where idProducto = idpro; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_provee` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_provee`(in idprov int )
BEGIN
update provedores set condicion = '0' where idProvedores = idprov;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_usu` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_usu`(in idUsu int)
BEGIN
update usuarios set condicion = '0' where idUsuario = idUsu; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `fact_com_´roduc` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fact_com_´roduc`(in valor int)
BEGIN
 select factu_com_prod.idfactu_com_prod'ID_DETALLE', fact_com.idfact_com'ID_FACTURACOMPRA',
factura.idFactura'ID_FACTURA', usuarios.nombre'NOMBRE_USUARIOS', provedores.nombre'NOMBRE_PROVEDORES',
factu_com_prod.canti_compra'CATIDAD_COMPRA', factu_com_prod.precio_unitario'PRESIO_UNITARIO', factu_com_prod.precio_total'PRESIO_TOTAL', factu_com_prod.descuento'DESCUENTO',
factu_com_prod.fecha_fac_com'FECHA_COMPRA' from factu_com_prod inner join fact_com on factu_com_prod.idfactu_com_prod = fact_com.idfact_com 
inner join factura on factu_com_prod.idFactur = factura.idFactura 
inner join usuarios on factu_com_prod.idusuari = usuarios.idUsuario
inner join provedores on factu_com_prod.idprovedor = provedores.idProvedores
where factu_com_prod.condicion = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_clien` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_clien`(in idclien int, in nom varchar(250), in tel varchar(15), in corr varchar (250), in idsex int, in fech_naci date )
BEGIN
insert into cliente values (idclien, nom, tel, corr, idsex, fech_naci, '0');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_datalle_fac_compra` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_datalle_fac_compra`(in idetalle int, in idfac_com int, in idprod int, in idusu int, in canti int, in preci int, in preci_total int)
BEGIN
insert into detalle_fact_compra values (idetalle, idfac_com, idprod, idusu, canti, preci, preci_total, '1');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_factura` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_factura`(in fact int, in idcli int, in idusu int,in comprov int, in ti_pago varchar (250), in impues float, in total_falctu float)
BEGIN
insert into factura values ( fact, (current_timestamp()), idcli , idusu, comprov ,ti_pago, impues ,  total_falctu, 1 );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_factu_com_prod` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_factu_com_prod`(in idfac_co_pro int, in idfac_co int, in idPro int, in cant_com int, in precio_uni float, in pre_tot float, descu float, fecha_ac_compru date)
BEGIN
insert into factu_com_prod values(idfac_co_pro, idfac_co, idPro, cant_com, precio_uni, pre_tot, descu, fecha_ac_compru, '1');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_fact_com` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_fact_com`(in idf_com int, in idPro int, in idUs int, in tipo_pag varchar (45))
BEGIN
insert into fact_com  values (idf_com, idPro, idUs, (current_timestamp()), '0', tipo_pag, 1 );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_producto` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_producto`(in idpro int, in nom varchar (250), in descri varchar (250), in ima LONGBLOB , in ru varchar(450) )
BEGIN
insert into producto (idProducto, nombre, descripcion, imagen, ruta, condicion) values (idpro, nom, descri, ima, ru, '1');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_producto_factura` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_producto_factura`(in pro int , in fac int, in can int, in des float)
BEGIN
insert into producto_factura(idProducto, idFactura, cantidad, descuento, total_ventas) values (pro, fac,  can, des, '0');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_provedores` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_provedores`(in idprov int, in tipo_docu varchar (250), in nom varchar (250), in idsex int, in corr varchar (250), in tele varchar (10), in direc varchar (50), in ti_perso varchar (250), fech_naci date )
BEGIN
insert into provedores values (idprov, tipo_docu, nom, idsex, corr, tele, direc, ti_perso,  fech_naci, '1' );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `into_usuario` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `into_usuario`(in idUsu int, in nom varchar (250), in telef varchar (15), in corr varchar (250), in direc varchar (250), in idsex int, in idcarg int, in logi varchar (7), in clav varchar (7), in fech_naci date)
BEGIN
insert into usuarios values (idUsu, nom, telef, corr, direc, idsex, idcarg, logi, clav, fech_naci, '1');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `login` */;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`(in logi varchar (7), in clav varchar (7))
BEGIN
select login, clave from usuarios where login = logi && clave = clav = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `tiendacom` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;

--
-- Final view structure for view `mostar_tipo_persona`
--

/*!50001 DROP VIEW IF EXISTS `mostar_tipo_persona`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostar_tipo_persona` AS select `tipo_persona`.`idtipo` AS `idtipo`,`tipo_persona`.`nombre` AS `nombre` from `tipo_persona` where (`tipo_persona`.`condicion` = '1') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostra_producto`
--

/*!50001 DROP VIEW IF EXISTS `mostra_producto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostra_producto` AS select `producto`.`idProducto` AS `idProducto`,`producto`.`nombre` AS `NombreProdcuto`,`producto`.`descripcion` AS `descripcion`,`producto`.`imagen` AS `ImagenProducto`,`producto`.`presico` AS `PrecioProducto`,`producto`.`cantidad` AS `CantidadProductos` from `producto` where (`producto`.`condicion` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostra_proveedor`
--

/*!50001 DROP VIEW IF EXISTS `mostra_proveedor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostra_proveedor` AS select `provedores`.`idProvedores` AS `idProvedores`,`provedores`.`tipo_de_documento` AS `DocumentoProvedor`,`provedores`.`nombre` AS `NombreProvedor`,`sexo`.`nombre` AS `SexoProvedor`,`provedores`.`correo` AS `correo`,`provedores`.`telefono` AS `telefono`,`provedores`.`direccion` AS `direccion`,`provedores`.`idtpo` AS `TipodePersona`,`provedores`.`fecha_nacimiento` AS `fecha_nacimiento` from (`provedores` join `sexo` on((`provedores`.`idsexsl` = `sexo`.`idSexo`))) where (`provedores`.`condicion` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostra_tipo_documento`
--

/*!50001 DROP VIEW IF EXISTS `mostra_tipo_documento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostra_tipo_documento` AS select `tipo_documento`.`idocument` AS `idocument`,`tipo_documento`.`nombre` AS `nombre` from `tipo_documento` where (`tipo_documento`.`condicion` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostrar_cargo`
--

/*!50001 DROP VIEW IF EXISTS `mostrar_cargo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostrar_cargo` AS select `cargo`.`idCargo` AS `idCargo`,`cargo`.`nombre` AS `nombre` from `cargo` where (0 <> '1') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostrar_cliente`
--

/*!50001 DROP VIEW IF EXISTS `mostrar_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostrar_cliente` AS select `cliente`.`idCliente` AS `idClientes`,`cliente`.`nombre` AS `Nombres_Clientes`,`cliente`.`telefono` AS `telefono`,`cliente`.`correo` AS `correo`,`sexo`.`nombre` AS `Nombre_Sexo`,`cliente`.`fecha_nacimientos` AS `fecha_nacimientos` from (`cliente` join `sexo` on((`cliente`.`idSexos` = `sexo`.`idSexo`))) where (`cliente`.`condicion` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostrar_fact_com`
--

/*!50001 DROP VIEW IF EXISTS `mostrar_fact_com`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostrar_fact_com` AS select `fact_com`.`idfact_com` AS `idfact_com`,`provedores`.`nombre` AS `Nombre_Proveedores`,`usuarios`.`nombre` AS `Nombre_Usuarios`,`fact_com`.`fecha` AS `fecha`,`fact_com`.`total_compra` AS `total_compra`,`fact_com`.`tipo_de_pago` AS `tipo_de_pago` from ((`fact_com` join `provedores` on((`fact_com`.`idProvedores` = `provedores`.`idProvedores`))) join `usuarios` on((`fact_com`.`idUsuarios` = `usuarios`.`idUsuario`))) where (`fact_com`.`condicion` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostrar_factura`
--

/*!50001 DROP VIEW IF EXISTS `mostrar_factura`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostrar_factura` AS select `factura`.`idFactura` AS `ID_Factura`,`factura`.`fecha` AS `Fecha_Factura`,`factura`.`idCliente` AS `IDCliente`,`factura`.`idusuario` AS `IDusuario`,`factura`.`comprovante` AS `Numero_Comprovante`,`factura`.`tipo_pago` AS `Tipo_Pago`,`factura`.`impuesto` AS `Impuesto`,`factura`.`total_factura` AS `Total_Factura` from ((`factura` join `usuarios` on((`factura`.`idusuario` = `usuarios`.`idUsuario`))) join `cliente` on((`factura`.`idCliente` = `cliente`.`idCliente`))) where (`factura`.`condicion` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostrar_sexo`
--

/*!50001 DROP VIEW IF EXISTS `mostrar_sexo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostrar_sexo` AS select `sexo`.`idSexo` AS `ids`,`sexo`.`nombre` AS `nombre` from `sexo` where (`sexo`.`condicion` = '1') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mostrar_usuari`
--

/*!50001 DROP VIEW IF EXISTS `mostrar_usuari`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mostrar_usuari` AS select `usuarios`.`idUsuario` AS `IdUsu`,`usuarios`.`nombre` AS `NombreDeUsuario`,`usuarios`.`telefono` AS `telefono`,`usuarios`.`correo` AS `correo`,`usuarios`.`direccion` AS `direccion`,`sexo`.`nombre` AS `Genero`,`cargo`.`nombre` AS `NombreCargo`,`usuarios`.`login` AS `login`,`usuarios`.`fecha_nacimiento` AS `fecha_nacimiento` from ((`usuarios` join `sexo` on((`usuarios`.`idsexo` = `sexo`.`idSexo`))) join `cargo` on((`usuarios`.`idcargo` = `cargo`.`idCargo`))) where (`usuarios`.`condicion` = '1') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-13 14:00:51

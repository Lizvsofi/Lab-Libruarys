-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `fecha_nac` varchar(20) DEFAULT NULL,
  `cotrasena` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'joel','godines','5511223344','joel@gmail.com','2015-12-12','joel','jaime nuno','12141'),(2,'juan','asdad','213123123','juan@gmail.com','3123-02-21','juan','adsasdasd1','12312'),(4,'daniel','dakjdajsd','1241515155','daniel@gmail.com','2142-01-24','daniel','asgasdad','12312');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `existencia`
--

DROP TABLE IF EXISTS `existencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `existencia` (
  `id_libreria` int NOT NULL,
  `id_libro` int NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_libreria`,`id_libro`),
  KEY `fk_libreria_has_libro_libro1_idx` (`id_libro`),
  KEY `fk_libreria_has_libro_libreria_idx` (`id_libreria`),
  CONSTRAINT `fk_libreria_has_libro_libreria` FOREIGN KEY (`id_libreria`) REFERENCES `librerias` (`id_libreria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `existencia`
--

LOCK TABLES `existencia` WRITE;
/*!40000 ALTER TABLE `existencia` DISABLE KEYS */;
INSERT INTO `existencia` VALUES (133,221,'20'),(133,224,'15'),(133,227,'10'),(133,230,'25');
/*!40000 ALTER TABLE `existencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librerias`
--

DROP TABLE IF EXISTS `librerias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librerias` (
  `id_libreria` int NOT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `contacto_libreria` varchar(45) DEFAULT NULL,
  `tel_libreria` varchar(45) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `cotrasena` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_libreria`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librerias`
--

LOCK TABLES `librerias` WRITE;
/*!40000 ALTER TABLE `librerias` DISABLE KEYS */;
INSERT INTO `librerias` VALUES (133,'CDMX','Maria_Castorena','Ana_Lilia_Cruz','5522070512','ana@gmail.com','ana'),(144,'Monterrey','Hola','Raul','5511229988','raul@gmail.com','raul');
/*!40000 ALTER TABLE `librerias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `id_libro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT '0',
  `edicion` varchar(100) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (1,'El Principito','Antoine de Saint-Exupéry',150.00,'Infantil','../img/principito.jpg',3,'Edición infantil','Penguin Random'),(2,'Cien años de soledad','Gabriel García Márquez',280.00,'aventura','soledad.jpg',0,'1ra Edicion','Planeta'),(3,'Bird Box','Josh Malerman ',299.00,'terror','../img/bird_box.jpg',43,'Edición Pelicula',' Ecco'),(4,'Cementerio de animales',' Stephen King',479.00,'terror','../img/cementerio_animales.jpg',20,'1ra Edición',' Vintage Espanol'),(5,'Ángeles y Demonios','Dan Brown',500.00,'suspenso','../img/angeles_demonios.jpg',20,'1ra Edición','Planeta'),(6,'Orgullo y prejuicio','Jane Austen',350.00,'romance','../img/orgulloyprejuicio.jpg',20,'1ra Edición','Arte y letras'),(7,'Asesinato en el Orient Express','Agatha Christie ',335.00,'misterio','../img/asesinato.jpg',15,'2da edición','Booket'),(8,'Drácula',' Alberto Jiménez García',300.00,'terror','../img/drácula.jpg',30,'1ra Edición','Libsa'),(9,'Frankenstein',' Alberto Jiménez García',200.00,'terror','../img/frankenstein.jpg',45,'1ra Edición','Libsa'),(10,'1984','George Orwell',200.00,'ciencia_ficcion','../img/1984.jpg',20,'Estándar','Arte y letras'),(11,'La isla del tesoro','Robert Louis Stevenson',299.00,'aventura','../img/isla_tesoro.jpg',11,'edición española','Penguin Clásicos'),(12,'Guerra Mundial Z',' Max Brooks',389.00,'accion','../img/accion.jpg',38,'1ra Edición','De Bolsillo'),(13,'Lo que el viento se llevó','Margaret Mitchell',517.00,'romance','../img/Loqueelvientosellevó.jpg',20,'1ra Edición','Maxi'),(14,'Edenbrooke','Julianne Donaldson',290.00,'romance','../img/Edenbrooke.jpg',20,'7ma Edición ','Shadow Mountain'),(15,'El mapa de los anhelos','Alice Kellen',320.00,'romance','../img/Elmapadelosanhelos.jpg',20,'1ra Edición','Planeta'),(16,'Yo, tú y un quizás','María Martínez',320.00,'romance','../img/Yotúyunquizás.jpg',20,'1ra Edición','Planeta'),(17,'Yo antes de ti','Jojo Moyes',350.00,'romance','../img/yo_antes_de_ti.jpg',20,'1ra Edición','Suma'),(18,'Posdata:Te amo','Cecelia Ahern',440.00,'romance','../img/te_amo.jpg',20,'1ra Edición','B de Bolsillo'),(19,'A dos metros de ti ','Rachael Lippincott',250.00,'romance','../img/romance.jpg',20,'1ra Edición','Nube de tinta'),(20,'Bajo la misma estrella ','Jonh Green',350.00,'romance','../img/bajo_la_misma_estrella.jpg',20,'1ra Edición','Penguin Random'),(21,'Diario de una pasión (El cuaderno de Noah)','Nicholas Sparks',300.00,'romance','../img/cuaderno_noah.jpg',20,'1ra Edición','Roca Bolsillo'),(22,'El duque y yo ','Julia Quinn',300.00,'romance','../img/duque_y_yo.jpg',20,'1ra Edición','Ediciones Urano México'),(23,'A todos los chicos de los que me enamore','Jenny Han',300.00,'romance','../img/atodosloschicosdelosquemeenamore.jpg',20,'1ra Edición','Booket'),(24,'El verano que me enamore','Jenny Han',300.00,'romance','../img/Elveranoquemeenamore.jpg',20,'1ra Edición','Booket'),(25,'El faro de los amores dormidos','andrea Longarela',320.00,'romance','../img/Elfarodelosamoresdormidos.jpg',20,'1ra Edición','Croos Books'),(26,'Jane Eyre',' Charlotte Brontë',360.00,'romance','../img/JaneEyre.jpg',20,'1ra Edición','Austral'),(27,'La carretera','Cormac McCarthy',250.00,'ciencia_ficcion','../img/carretera.jpg',20,'1ra Edición','Random House'),(28,'The Martian (Misión Rescate)','Andy Weir',400.00,'ciencia_ficcion','../img/ciencia_ficcion.jpg',20,'1ra Edición','A Novel'),(29,'Dune','Frank Herbert',360.00,'ciencia_ficcion','../img/dune.jpg',20,'1ra Edición','De Bolsillo'),(30,'Fundación','Isaac Asimov',390.00,'ciencia_ficcion','../img/fundacion.jpg',20,'1ra Edición','De Bolsillo'),(31,'El juego de ender','Orson Scott Card',360.00,'ciencia_ficcion','../img/juego_ender.jpg',20,'1ra Edición','Penguin Random'),(32,'La máquina del tiempo','H.G. Wells',250.00,'ciencia_ficcion','../img/maquina_tiempo.jpg',20,'1ra Edición','Plutón'),(33,'Un mundo Feliz','Aldous Huxley',200.00,'ciencia_ficcion','../img/mundo_feliz.jpg',20,'1ra Edición','Biblioteca Escolar'),(34,'Neuromante','William Gibson',350.00,'ciencia_ficcion','../img/neuromante.jpg',20,'Estándar','Booket'),(35,'¿Sueñan los androides con ovejas eléctricas?',' Philip K. Dick',398.00,'ciencia_ficcion','../img/ovejas_electricas.jpg',20,'1ra Edición','Minotauro Esenciales'),(36,'Ready Player One','Ernest Cline',510.00,'ciencia_ficcion','../img/player_one.jpg',20,'1ra Edición','Nova'),(37,'Snow Crash','Neal Stephenson',490.00,'ciencia_ficcion','../img/snow_crash.jpg',20,'1ra Edición','Novel'),(38,'El día de los trífidos','John Wyndham ',3500.00,'ciencia_ficcion','../img/El-dia-de-los-trifidos.jpg',5,'1ra Edición',' EDC MINOTAURO'),(39,'La Guerra de los mundos',' Herbert George Wells',200.00,'ciencia_ficcion','../img/La-Guerra-de-los-mundos.jpg',20,'1ra Edición','Austral'),(40,'Fahrenheit 451','Ray Bradbury',315.00,'ciencia_ficcion','../img/Fahrenheit451.jpg',20,'Reissue ed.','Simon & Schuster'),(41,'Un Asesinato Brillante',' Anthony Horowitz ',435.00,'misterio','../img/asesinato_brillante.jpg',20,'Estándar','Ediciones B'),(42,'Las aventuras de Sherlock Holmes','Arthur Conan Doyle',330.00,'misterio','../img/aventura.png',20,'1ra Edición','Alma'),(43,'El canto del cuco',' Robert Galbraith',499.00,'misterio','../img/canto_cuco.jpg',20,'Estándar','Penguin Random'),(44,'El sabueso de los Baskerville','Arthur Conan Doyle',346.00,'misterio','../img/el_sabueso.jpg',20,'1ra Edición','Alma'),(45,'El halcón maltés','Dashiell Hammett',472.00,'misterio','../img/halcón maltés.jpg',25,'1ra Edición','Alianza Editorial'),(46,'El hijo olvidado','Mikel Santiago',300.00,'misterio','../img/misterio.jpg',20,'1ra Edición','Ediciones B'),(47,'Y no quedó ninguno','Agatha Christie ',300.00,'misterio','../img/no_quedo_ninguno.jpg',12,'1ra Edición','Booket'),(48,'El nombre de la rosa','Umberto Eco',425.00,'misterio','../img/nombre_de_la_rosa.jpg',20,'1ra Edición','De Bolsillo'),(49,'El silencio del bosque ','Tana Frech',629.00,'misterio','../img/silencio_bosque.jpg',20,'Estándar','Alianza Editorial'),(50,'El sueño eterno',' Raymond Chandler',477.00,'misterio','../img/sueño_eterno.jpg',20,'1ra Edición','De Bolsillo'),(51,'El jardín de las mariposas ',' Dot Hutchison',340.00,'misterio','../img/Eljardíndelasmariposas.jpg',20,'1ra Edición','Planeta'),(52,'Alguien Está Mintiendo','Karen M McManus ',280.00,'misterio','../img/Alguienestmintiendo.jpg',20,'001','Alfaguara Juvenil'),(53,'La paciente silenciosa','Alex Michaelides ',468.00,'misterio','../img/Lapacientesilenciosa.jpg',20,'1ra Edición','Penguin Random'),(54,'La verdad sobre el caso Harry Quebert','Joël Dicker ',432.00,'misterio','../img/HarryQuebert.jpg',20,'1ra Edición','Penguin Random'),(55,'Alicia en el país de las maravillas','Lewis Carroll',210.00,'Infantil','../img/alicia_maravillas.jpg',20,'1ra Edición','Alianza Editorial'),(56,'El Gato Ensombrerado ','Dr Seuss',305.00,'Infantil','../img/gato.jpg',20,'1ra Edición','Random House'),(57,'El grúfalo ','Julia Donaldson',265.00,'Infantil','../img/grufalo.jpg',26,'1ra Edición','Editorial Bruño'),(58,'Harry Potter y la piedra filosofal','J.K. Rowling',300.00,'Infantil','../img/harry_potter.jpg',23,'1ra Edición','Salamandra'),(59,'Cuentos de animales',' VARIOS AUTORES',180.00,'Infantil','../img/infantil.jpg',35,'Estándar','Advanced Marketing'),(60,'Matilda','Roal Dahl ',215.00,'Infantil','../img/matilda.jpg',34,'Edición Clásic','‎ Viking Books'),(61,'Donde viven los monstruos','Maurice Sendak',334.00,'Infantil','../img/monstruos.jpg',26,' Edición infantil','HarperCollins '),(62,'La telaraña de Carlota','E. B. White y Garth Williams',458.00,'Infantil','../img/telaraña_carlota.jpg',35,'Ilustrado','HarperCollins '),(63,'La peor señora del mundo','Francisco Hinojosa',180.00,'infantil','../img/peorseñora.jpg',35,'2da Edición',' Fondo de Cultura Económica'),(64,'Diario de Greg 1. Un Renacuajo',' Jeff Kinney',350.00,'infantil','../img/diariogref.jpg',25,'1ra Edición','Penguin Random'),(65,'Yo quiero mi sombrero',' Jon Klassen',330.00,'infantil','../img/misombrero.jpg',23,'Estándar','NubeOCHO'),(66,'El monstruo de colores ','Anna Llenas Serra ',180.00,'infantil','../img/Elmonstruodecolores.jpg',27,'1ra Edición','Flamboyant'),(67,'Las brujas',' Roald Dahl',260.00,'infantil','../img/lasbrujas.jpg',37,' Edición infantil','Penguin Random'),(68,'Los futbolísimos.',' Roberto Santiago',400.00,'infantil','../img/futbolísimos.jpg',37,'1ra Edición','Ediciones SM'),(69,'Anna Karenina','Leo Tolstoy',514.00,'drama','../img/anna.jpg',32,'1ra Edición','Alma'),(70,'El color púrpura','Alice Walker',299.00,'drama','../img/color_purpura.jpg',22,'1ra Edición','De Bolsillo'),(71,'Cometas en el cielo','Khaled Hosseini',499.00,'drama','../img/cometas_cielo.jpg',28,'Estándar','Salamandra'),(72,'Verano del 65','Mary Carrillo',2000.00,'drama','../img/drama.jpg',14,'1ra Edición','Ediciones MV'),(73,'La ladrona de libros','Zusak y Markus',543.00,'drama','../img/ladrona_libros.jpg',27,'Edición Pelicula','De Bolsillo'),(74,'Matar a un ruiseñor','Harper Lee',270.00,'drama','../img/matar_suiseñor.jpg',30,'Estándar','De Bolsillo'),(75,'Los Miserables','Victor Hugo',300.00,'drama','../img/miserables.jpg',20,'5ta Edición','‎ e-artnow'),(76,'Tan poca vida','Hanya Yanagihara',599.00,'drama','../img/poca_vida.jpg',19,'1ra Edición','Lumen'),(77,'De ratones y hombres',' Rébecca Dautremer',777.00,'drama','../img/ratones_hombres.jpg',22,'Edición Clásica','Editorial progreso'),(78,'Boulevard',' Flor M. Salvador',299.00,'drama','../img/Boulevard.jpg',33,'1ra Edición','Penguin Random'),(79,'Los siete maridos de Evelyn Hugo','Taylor Jenkins Reid ',380.00,'drama','../img/7maridos.jpg',22,'1ra Edición','Urano'),(80,'Donde habitan los ángeles','Claudia Celis ',300.00,'drama','../img/angeles.jpg',23,'11va Edición','Ediciones SM'),(81,'Cometas en el cielo',' Khaled Hosseini',349.00,'drama','../img/cometas.jpg',22,'Edición Clásica','Penguin Random'),(82,'Romeo y Julieta ','William Shakespeare ',590.00,'drama','../img/romeo.jpg',22,'Edición Clásica','EMU'),(83,'El drama del niño dotado','Alice Miller ',380.00,'drama','../img/eldramadelniño.jpg',22,'1ra Edición','Tusquets Editores S.A.'),(84,'La chica del dragón tatuado','Eric Bronson ',900.00,'suspenso','../img/chica_dragon.jpg',22,'1ra Edición','PAIDOS MEXICANA '),(85,'El código Da Vinci','Dan Brown',340.00,'suspenso','../img/codigo_vinci.jpg',22,'1ra Edición','Planeta'),(86,'La mujer en la ventana','A.J. Finn',180.00,'suspenso','../img/mujer_ventana.jpg',33,'1ra Edición','Penguin Random'),(87,'La paciente silenciosa','Alex Michaelides ',384.00,'suspenso','../img/paciente_silenciosa.jpg',23,'1ra Edición','De Bolsillo'),(88,'La pareja de al lado','Shari Lapena',335.00,'suspenso','../img/pareja_lado.jpg',13,'1ra Edición','Suma'),(89,'Perdida','Gillian Flynn',439.00,'suspenso','../img/perdida.jpg',34,'1ra Edición','De Bolsillo'),(90,'Tras la puerta',' Freida McFadden',349.00,'suspenso','../img/puerta.jpg',24,'1ra Edición','Suma'),(91,'Shutter Island','Dennis Lehane',190.00,'suspenso','../img/shutter_island.jpg',21,'Estándar','William Morrow Paperbacks'),(92,'El psicoanalista','John Katzenbach',386.00,'suspenso','../img/suspenso.jpg',19,'1ra Edición','De Bolsillo'),(93,'Sherlock Holmes. Estudio en escarlata','Arthur Conan Doyle',300.00,'suspenso','../img/Estudioescarlata_.jpg',29,'1ra Edición','Booket'),(94,'La Red Púrpura',' Carmen Mola',490.00,'suspenso','../img/redpurpura_.jpg',16,'1ra Edición','Penguin Random'),(95,'La cara norte del corazón','Dolores Redondo',240.00,'suspenso','../img/lacara.jpg',34,'1ra Edición','Planeta'),(96,'Narraciones Extraordinarias','Edgar Allan Poe',360.00,'suspenso','../img/narraciones.jpg',22,'Estándar','Editores Mexicanos Unidos'),(97,'Reina Roja',' Juan Gomez-Jurado',500.00,'suspenso','../img/reinaroja.jpg',33,'Edición Clásica','Ediciones B'),(98,'Hatchet',' Gary Paulsen',240.00,'aventura','../img/hatchet.jpg',34,'Reissue ed.','Simon & Schuster Books for Young Readers'),(99,'El Hobbit','J. R. R. Tolkien',300.00,'aventura','../img/hobbit.jpg',30,'1ra Edición','Booket'),(100,'La llamada de lo salvaje',' Jack London',200.00,'aventura','../img/llamado_salvaje.jpg',25,'1ra Edición','Austral'),(101,'Las minas del Rey Salomón','H. Rider Haggard',390.00,'aventura','../img/minas_salomon.jpg',23,'Estándar','Ediciones SM'),(102,'El mundo perdido','Michael Crichton',299.00,'aventura','../img/mundo_perdido.jpg',26,'1ra Edición','De Bolsillo'),(103,'Robinson Crusoe','Daniel Defoe',100.00,'aventura','../img/robinson.jpg',23,'1ra Edición','Porrua'),(104,'Los tres mosqueteros','Alexandre Dumas',399.00,'aventura','../img/tres_mosqueteros.jpg',22,'1ra Edición','Austral'),(105,'Viaje al centro de la Tierra','JULES VERNE',259.00,'aventura','../img/viaje_centro.jpg',34,'1ra Edición','Austral'),(106,'La vida de Pi','Yann Martel',270.00,'aventura','../img/vida_pi.jpg',34,'1ra Edición','Destino'),(107,'La vuelta al mundo en 80 días','Julio Verne',230.00,'aventura','../img/vuelta_80dias.jpg',22,'1ra Edición','Molino'),(108,'Torres de Malory 1 ','Enid Blyton',190.00,'aventura','../img/TorresdeMalory1_.jpg',34,'1ra Edición','Molino'),(109,'Segundo curso','Enid Blyton',190.00,'aventura','../img/segundocurso.jpg',34,'1ra Edición','Molino'),(110,'Tercer curso','Enid Blyton',230.00,'aventura','../img/Tercercurso.jpg',22,'1ra Edición','Molino'),(111,'Cuarto curso','Enid Blyton',190.00,'aventura','../img/Cuartocurso.jpg',22,'1ra Edición','Molino'),(112,'Gótico mexicano','Silvia Moreno-García',369.00,'terror','../img/gotico_mexicano.jpg',22,'1ra Edición','Minotauro Esenciales'),(113,'IT (Eso)','Stephen King',499.00,'terror','../img/it.jpg',32,'1ra Edición','De Bolsillo'),(114,'La maldición de Hill House','Shirley Jackson',450.00,'terror','../img/maldicion_hillhouse.jpg',22,'1ra Edición','Penguin Random'),(115,'El Exorcista',' William Peter Blatty',345.00,'terror','../img/terror.jpg',34,'1ra Edición','Booket'),(116,'La caída de la casa de Usher y otros relatos','Edgar Allan Poe',200.00,'terror','../img/lacaida.jpg',26,'1ra Edición','Fractales'),(117,'El Retrato de Dorian Gray ','Oscar Wilde',234.00,'terror','../img/elretrato.jpg',45,'Estándar','Editores Mexicanos Unidos'),(118,'Instinto ',' Ashley Audrain',1500.00,'terror','../img/Ashley Audrain_.jpg',12,'Edición Portugués','‎ Suma de Letras'),(119,'Sopa de Miso ','Ryu Murakami',4000.00,'terror','../img/sopa.jpg',12,'1ra Edición','Seix Barral'),(120,'El huésped y otros relatos siniestros ','Amparo Dávila',590.00,'terror','../img/huésped.jpg',23,'1ra Edición','Fondo de Cultura Económica'),(121,'El resplandor',' Stephen King ',499.00,'terror','../img/resplandor_.jpg',22,'1ra Edición','De Bolsillo'),(122,'Heridas abiertas ',' Gillian Flynn',258.00,'terror','../img/heridas.jpg',23,'1ra Edición','De Bolsillo'),(123,'Casino Royale','Ian Fleming',499.00,'accion','../img/casino_royale_u.jpg',34,'Edición Clásica','William Morrow Paperbacks'),(124,'First Blood','David Morrell',478.00,'accion','../img/first_blood.jpg',23,'Estándar',' ‎ Grand Central Publishing'),(125,'Los Juegos del Hambre','Suzanne Collins',356.00,'accion','../img/juegos_hambre.jpg',36,'1ra Edición','Booket'),(126,'Veinte mil leguas de viaje submarino ',' Julio Verne ',250.00,'accion','../img/20mil.jpg',23,'1ra Edición','Molino'),(127,'Ciudad Negra: La última ciudad perdida',' Fernando Gamboa ',670.00,'accion','../img/CiudadNegra_.jpg',36,'1ra Edición',' Fernando Gamboa'),(128,'El capitán Alatriste',' Arturo Pérez-Reverte',234.00,'accion','../img/ElcapitánAlatriste.jpg',45,'1ra Edición','Aleguara'),(129,'Amanecer en la cosecha',' Suzanne Collins ',390.00,'accion','../img/Amanecercosecha.jpg',36,'1ra Edición','Molino'),(130,'Balada de Pájaros ','Suzanne Collins',458.00,'accion','../img/BaladaPájaros.jpg',35,'1ra Edición','Molino'),(131,'Los Juegos del Hambre 3 - Sinsajo','Suzanne Collins',550.00,'accion','../img/Sinsajo.jpg',37,'1ra Edición','Molino'),(132,'Los Juegos del Hambre 2 - En llamas','Suzanne Collins',467.00,'accion','../img/En llamas.jpg',29,'1ra Edición','Molino'),(133,'Crepúsculo',' Stephenie Meyer ',261.00,'accion','../img/crepusculo.jpg',34,'1ra Edición','De Bolsillo'),(134,'Amanecer',' Stephenie Meyer',349.00,'accion','../img/amanecer_.jpg',37,'1ra Edición','De Bolsillo'),(135,'Correr o Morir',' James Dashner',300.00,'accion','../img/CORRERMORIR_.jpg',45,'1ra Edición','VERGARA Y RIBA EDITORAS SA DE CV'),(136,'Prueba de fuego ',' James Dashner',207.00,'accion','../img/PRUEBAFUEGO_.jpg',35,'1ra Edición','VERGARA Y RIBA EDITORAS SA DE CV');
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes` (
  `id_ordenes` int DEFAULT NULL,
  `id_libro` int NOT NULL,
  `id_cliente` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `id_libreria` int NOT NULL,
  PRIMARY KEY (`id_libro`,`id_cliente`),
  KEY `fk_libro_has_cliente_libro1_idx` (`id_libro`),
  KEY `fk_facturas_librerias1_idx` (`id_libreria`),
  KEY `fk_ordenes_clientes_idx` (`id_cliente`),
  CONSTRAINT `fk_facturas_librerias1` FOREIGN KEY (`id_libreria`) REFERENCES `librerias` (`id_libreria`),
  CONSTRAINT `fk_libro_has_cliente_libro1` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro`),
  CONSTRAINT `fk_ordenes_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-22 12:53:28


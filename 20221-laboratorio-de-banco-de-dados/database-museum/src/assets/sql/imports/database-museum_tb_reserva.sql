-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: database-museum
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `tb_reserva`
--

DROP TABLE IF EXISTS `tb_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reserva` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `CPF` varchar(255) DEFAULT NULL,
  `TELEFONE` varchar(255) DEFAULT NULL,
  `QUANTIDADE_PESSOAS` int DEFAULT NULL,
  `DATA_RESERVA` date DEFAULT NULL,
  `HORA_INICIO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reserva`
--

LOCK TABLES `tb_reserva` WRITE;
/*!40000 ALTER TABLE `tb_reserva` DISABLE KEYS */;
INSERT INTO `tb_reserva` VALUES (1,'Sergino Amaral Lucio','13851763858','14996318411',4,'2021-06-21','10:00'),(3,'Rejane Estellet Leonicio','49497148801','13984113904',9,'2021-06-21','14:00'),(4,'Jhonata Fausto Castilho','68214890845','16992538872',6,'2021-06-21','12:00'),(5,'Flavia Serravalle Barboza','15621436890','15972731130',3,'2021-06-21','16:00'),(6,'Nilza Carmanin Aguiar','00067483844','13988721876',6,'2021-06-28','12:00'),(7,'José Luiz de Arruda Rangel','35723270834','17974887064',3,'2021-06-28','10:00'),(8,'Yvan Latin Anjos','68272747804','18981519554',2,'2021-06-28','14:00'),(9,'Jander Coimbra Leal','71284743829','13993568347',7,'2021-06-28','16:00'),(10,'Eduardo Pires Bernardes','04567518829','16968893811',2,'2021-07-05','12:00'),(11,'Benedito Annunziato da Silva','71492751847','15972481261',6,'2021-07-05','16:00'),(12,'Jocilea Silveira Calixto','71458120880','11969461366',3,'2021-07-12','14:00'),(13,'Elizabetti Miranda da Silva','78536185813','11971992698',2,'2021-07-12','10:00'),(14,'Adolfo Castro Felix','96363264871','13969684947',1,'2021-07-19','16:00'),(15,'Ana Carvel Dinis','08967416806','15986428041',5,'2021-07-19','14:00'),(16,'Roberta Paixão Ximenes','57293930836','13971059288',2,'2021-07-26','10:00'),(17,'Joelma Bochimpani da Conceição','45337641859','15981283058',1,'2021-07-26','12:00'),(18,'Vilma Pina Sarmento','53243370809','18968701475',2,'2021-08-02','10:00'),(19,'Danielle Soriano Albergaria','76503818890','14986828624',3,'2021-08-02','14:00'),(20,'Lina Moura Martins','52740451890','18985819793',4,'2021-08-09','14:00'),(21,'Silvio Figueiredo Cordeiro','64739982846','11976032487',2,'2021-08-09','16:00'),(22,'Vicente Souza Linhares','82260013821','15991673464',3,'2021-08-16','10:00'),(23,'Lina Barrada Vasgestian','89227877835','13981940267',2,'2021-08-16','16:00'),(24,'José Mário Jesus Pontes','94623598810','15986664859',6,'2021-08-23','14:00'),(25,'Quezia Estellet dos Santos','12144989818','15981102354',5,'2021-08-23','12:00'),(26,'Kauê Donato Filho','89857630839','18981188416',3,'2021-09-06','10:00'),(27,'José Mário Siqueira Portugal','38497407814','11981141389',4,'2021-09-06','16:00'),(28,'Adso Batista Medeiros','42884139826','17999745267',1,'2021-09-13','12:00'),(29,'Noé Amorin Camelo','55864349895','17969736124',5,'2021-09-13','14:00'),(30,'Ana Caroline Nepomuceno Prata','14675424821','11983667213',2,'2021-09-20','10:00'),(31,'Kauã Negris Pinho','72015921818','16979963041',3,'2021-09-20','12:00'),(32,'Marlene Duarte Vieira','13535634806','18973834388',6,'2021-09-27','14:00'),(33,'Murilo Bochimpani Barreto','53612549839','18981338832',3,'2021-09-27','16:00'),(34,'Bryan Camelo Mourão','76420433843','12987141138',10,'2021-10-04','10:00'),(35,'Gian Queiroz Moraes','27588375876','15979648265',4,'2021-10-04','12:00'),(36,'Iago Marcello Goulart','31203557809','19972400861',2,'2021-10-11','14:00'),(37,'Suellem Arlia Rios','79523917803','17982345611',3,'2021-10-11','16:00'),(38,'Antonietta Bochimpani Carmoriz','97315128883','12982634389',2,'2021-10-18','10:00'),(39,'Diogo Ervano da Paixão','43228774864','18982755277',4,'2021-10-18','14:00'),(40,'Arlete Mendes Pinho','25457755843','12998125784',5,'2021-10-25','12:00'),(41,'Dayana Facre Matos','62211989845','17994606528',7,'2021-10-25','16:00'),(42,'Ian Goulart Santomauro','11453358889','14976723234',3,'2021-11-01','10:00'),(43,'Elizabeth Ribeiro Felix','78628794816','17999614571',2,'2021-11-08','10:00'),(44,'Paula de Carvalho Paulo','17692447861','14982256213',4,'2021-11-08','12:00'),(45,'Marcus Aguiar da Silva','67612686805','14988707971',5,'2021-11-15','14:00'),(46,'Mara Vargas Mendonça','40304684899','17971375518',2,'2021-11-15','16:00'),(47,'Isaque Furtado Norte','18876714804','13988686632',1,'2021-11-22','10:00'),(48,'Lucas Pinheiro Arlia','32884635807','16999286507',6,'2021-11-22','14:00'),(49,'Tarcísio da Mota Temperini','44413107810','19993092146',3,'2021-11-29','16:00'),(50,'Fatima Pimenta Lucio','40267165897','15967277214',2,'2021-12-06','10:00'),(51,'Adilson Leal Vieira','44784487875','14976217486',4,'2021-12-06','12:00'),(52,'Kauê Zava Carmoriz','31110502893','12982457022',3,'2021-12-13','14:00'),(53,'Tânia Bastos Pena','46751774842','12985854429',5,'2021-12-13','16:00'),(54,'Yago Ignacia Xavier','58797723819','17980597461',2,'2021-12-20','10:00'),(55,'Douglas Guedes Estellet','62403555851','13986411102',1,'2021-12-20','14:00'),(56,'Jucemar Dores Siqueira','38676846855','17989903713',3,'2021-12-27','12:00'),(57,'Taynara Barsosa Coimbra','18044681850','13975578564',2,'2021-12-27','16:00'),(58,'Aledio Valladares Antonio','02831305802','15974215147',1,'2022-01-03','10:00'),(59,'Lucy Portugal Prucho','91301646806','19982134246',3,'2022-01-03','12:00'),(60,'Calebe Brito Maia','81461177839','17980533664',6,'2022-01-10','14:00'),(61,'Higor Guzzo Silvino','46625586897','16996152924',2,'2022-01-10','16:00'),(62,'Jean Richa Amorim','67463151859','18986747160',2,'2022-01-17','10:00'),(63,'Adão Serravalle Valle','38105438887','11980276172',1,'2022-01-17','14:00'),(64,'Anizio Folly Limeira','99536430835','11999216769',4,'2022-01-24','12:00'),(65,'Wallace Assis Andrade','28300288805','14991263862',7,'2022-01-24','16:00'),(66,'Dilmar Navega Hall','56276484814','19985713076',3,'2022-02-07','10:00'),(67,'Hevelyn de Souza Fontes','20226082830','16988415065',4,'2022-02-07','12:00'),(68,'Abraão Rosa de Souza','61791631894','12981293333',8,'2022-02-14','14:00'),(69,'Domingos Grilo Bento','73605542840','13994718359',4,'2022-02-14','16:00'),(70,'Marco Lyrio Barboza','35657648803','15976161429',6,'2022-02-21','10:00'),(71,'Tatiane Guzzo Sampaio','87769224802','17992153513',5,'2022-02-21','14:00'),(72,'Josildo Felix Coutinho','22851493876','19972479585',4,'2022-02-28','12:00'),(73,'Grecy França Azevedo','37183533859','18982140610',2,'2022-02-28','16:00'),(74,'Rogério Eger Annunziato','76659793860','12997267214',3,'2022-03-07','10:00'),(75,'Eliezer Sampaio Sampaio','92373077809','11981273728',5,'2022-03-07','12:00'),(76,'Priscilla Folly Augusto','74071528885','19969348886',4,'2022-03-14','14:00'),(77,'Douglas Texeira Gadelha','40271179805','16996785588',7,'2022-03-14','16:00'),(78,'Stefany de Carvalho Oliveira','11856852865','17994660965',3,'2022-03-21','10:00'),(79,'Noah Cunha Antonio','53226478800','16971423548',5,'2022-03-21','14:00'),(80,'Alzira Peçanha Alfradique','31282752898','13975959636',10,'2022-03-28','12:00'),(81,'Antônia Nepomuceno Diovani','10163243832','16980315986',2,'2022-03-28','16:00'),(82,'Ozorio Zuniga Campelo','62120812802','12992772004',2,'2022-04-04','10:00'),(83,'Manuel Facre Richa','17077188817','11993517437',4,'2022-04-04','12:00'),(84,'Giselle Gripp Amancio','77852699804','13986609922',3,'2022-04-11','14:00'),(85,'Tobias Barthon Arlia','77464872894','13991588476',5,'2022-04-11','16:00'),(86,'José Milton Matta Cosme','66499918806','14988202461',7,'2022-04-18','10:00'),(87,'Alice Navega Assis','63324614899','17983241173',2,'2022-04-18','14:00'),(88,'Regina Milanez Camelo','54761001801','11991481327',4,'2022-04-25','12:00'),(89,'Diogo Abreu Negris','46566674802','18986801953',2,'2022-04-25','16:00'),(90,'Renata Frossard Giron','67328511877','13971381471',3,'2022-05-02','10:00'),(91,'Drauzio Pacheco Laporte','38826168814','15995752227',2,'2022-05-02','12:00'),(92,'Davi da Conceição Darmont','80371004802','17981339855',4,'2022-05-09','14:00'),(93,'Gutemberg Moreira da Paixão','27428214815','16980579018',5,'2022-05-09','16:00'),(94,'Pedro Henrique Castro Almeida','58017632878','16991244425',2,'2022-05-16','10:00'),(95,'Dhiego Richa Aguiar','07401657805','19988386155',4,'2022-05-16','14:00'),(96,'Margareth Felizardo Azevedo','55107818820','12989255585',7,'2022-05-23','12:00'),(97,'Rubia Guzzo Monnerat','20086769863','13997569232',4,'2022-05-23','16:00'),(98,'Bernardo Borner Pimenta','41134827806','15989154563',5,'2022-06-06','10:00'),(99,'Maycon Laporte Carino','75052534841','16993474623',7,'2022-06-06','12:00'),(100,'Eduardo Barcelos Mattos','51548273848','11971586638',2,'2022-06-13','14:00'),(101,'Nicolas Barrada Monnerat','38868019850','15972234332',4,'2022-06-13','16:00');
/*!40000 ALTER TABLE `tb_reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-19 18:55:50

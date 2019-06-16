/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - examdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `paperdetail` */

DROP TABLE IF EXISTS `paperdetail`;

CREATE TABLE `paperdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '试卷细节id',
  `name` varchar(225) NOT NULL COMMENT '试卷名字(java初级试卷，spring试卷)',
  `description` varchar(225) DEFAULT NULL COMMENT '试卷描述(...)',
  `count` int(20) DEFAULT NULL COMMENT '试卷包含题目数量(10，20)',
  `time` varchar(225) DEFAULT NULL COMMENT '试卷所用时间(1hours, 30mins, 50mins)',
  `type` varchar(225) DEFAULT NULL COMMENT '试卷类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `paperdetail` */

insert  into `paperdetail`(`id`,`name`,`description`,`count`,`time`,`type`) values (1,'Java 初级试卷','选拔初级java开发人员',2,'1 hour','J'),(2,'Spring 初级试卷','选拔spring开发人员',2,'30 mins','S'),(3,'C 语言高级试卷','选拔C语言开发人员',2,'20 mins','C'),(4,'Spring 中级试卷','选拔Spring开发人员',1,'1 hours','S');

/*Table structure for table `papersubject` */

DROP TABLE IF EXISTS `papersubject`;

CREATE TABLE `papersubject` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `pd_id` int(10) DEFAULT NULL COMMENT '试卷细节id(哪一套试卷)',
  `subject_id` int(10) DEFAULT NULL COMMENT '题目id(第几题)',
  `subject_name` varchar(225) DEFAULT NULL COMMENT '题目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `papersubject` */

insert  into `papersubject`(`id`,`pd_id`,`subject_id`,`subject_name`) values (1,1,1,'java所定义的版本中不包括：_____。'),(2,1,2,'以下哪个是不合法的标识符。'),(3,2,2,'请选出正确答案。'),(4,2,1,'下面关于IOC 的理解，正确的是___。'),(5,3,1,'C语言源程序文件后缀为什么？'),(6,3,2,'C语言中有多少个主函数？'),(7,4,1,'下面关于AOP的理解，正确的是____。(多选题)');

/*Table structure for table `papertype` */

DROP TABLE IF EXISTS `papertype`;

CREATE TABLE `papertype` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '试卷id(1,2,3)',
  `type` varchar(225) DEFAULT NULL COMMENT '试卷类型(java, spring)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `papertype` */

insert  into `papertype`(`id`,`type`) values (1,'J'),(2,'S'),(3,'C');

/*Table structure for table `subjectoption` */

DROP TABLE IF EXISTS `subjectoption`;

CREATE TABLE `subjectoption` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '题目选项表id',
  `answer_desccription` varchar(225) DEFAULT NULL COMMENT '答案描述',
  `answer_option` varchar(225) DEFAULT NULL COMMENT '答案选项',
  `ps_id` int(10) NOT NULL COMMENT '试卷题目id',
  `is_true` tinyint(1) DEFAULT NULL COMMENT '是否为正确答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `subjectoption` */

insert  into `subjectoption`(`id`,`answer_desccription`,`answer_option`,`ps_id`,`is_true`) values (1,'JAVA2 EE','A',1,0),(2,' JAVA2 Card','B',1,0),(3,' JAVA2 HE','C',1,1),(4,'STRING','A',2,0),(5,'void','B',2,1),(6,'x3x;','C',2,0),(7,'spring是一个重量级框架','A',3,1),(9,'spring是一个IOC和AOP容器','B',3,0),(10,'spring是一个入侵式框架','C',3,0),(11,'spring是一个轻量级框架','D',3,1),(12,'控制反转','A',4,1),(13,'对象被动的接受依赖类','B',4,1),(14,'一定要用接口','C',4,0),(15,'.EXE','A',5,0),(16,'.OBJ','B',5,0),(17,'.C','C',5,1),(18,'.ASM','D',5,0),(19,'2','A',6,0),(20,'1','B',6,1),(21,'无穷个','C',6,0),(22,'AOP关注的是面','A',7,1),(23,'纵向开发','B',7,0),(24,'AOP点和面都关注','C',7,0);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `count_correct` int(11) NOT NULL,
  `false_subject` varchar(255) DEFAULT NULL,
  `true_subject` varchar(255) DEFAULT NULL,
  `pd_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`name`,`email`,`age`,`count_correct`,`false_subject`,`true_subject`,`pd_id`) values (1,NULL,NULL,NULL,0,NULL,NULL,0),(2,NULL,NULL,0,0,NULL,NULL,0),(3,'2','2',2,0,NULL,NULL,0),(4,'10','10',10,0,NULL,NULL,0),(5,'1','2',1,0,NULL,NULL,0),(6,'1','1',1,0,NULL,NULL,0),(7,'12','12',12,0,NULL,NULL,0),(8,'1','1',1,0,NULL,NULL,0),(9,'1','1',1,0,NULL,NULL,0),(10,'1','1',1,0,NULL,NULL,0),(11,'1','1',1,0,NULL,NULL,0),(12,'1','1',1,0,NULL,NULL,0),(13,'1','1',1,0,NULL,NULL,0),(14,'1','1',1,0,NULL,NULL,0),(15,'1','1',1,0,NULL,NULL,0),(16,'1','1',1,0,NULL,NULL,0),(17,'1','1',1,0,NULL,NULL,0),(18,'1','1',1,0,NULL,NULL,0),(19,'w','w',1,0,NULL,NULL,0),(20,'1','1',1,0,NULL,NULL,0),(21,'1','1',1,0,NULL,NULL,0),(22,'1','1',1,0,NULL,NULL,0),(23,'1','1',1,0,NULL,NULL,0),(24,'1','1',11,0,NULL,NULL,0),(25,'1','1',11,1,'[1]','[2]',0),(26,'1','1',1,0,'[3, 4]','[]',0),(27,'1','1',1,2,'[]','[1, 2]',0),(28,'1','1',1,1,'[3]','[4]',0),(29,'12','1',1,1,'[3]','[4]',0),(30,'1','1',1,1,'[3]','[4]',0),(31,'1','11',1,1,'[3]','[4]',0),(32,'1','1',1,2,'[]','[5, 6]',0),(33,'123','11',11,1,'[3]','[4]',0),(34,'zhao','1',1,2,'[]','[1, 2]',0),(35,'11','11',11,1,'[3]','[4]',0),(36,'11','11',11,1,'[]','[7]',0),(37,'11','11',11,1,'[3]','[4]',0),(38,'111','111',111,2,'[]','[3, 4]',0),(39,'1','1',1,1,'[3]','[4]',0),(40,'123','123',123,2,'[]','[5, 6]',3),(41,'1','2',3,2,'[]','[5, 6]',3),(42,'1','1',1,0,'[3, 4]','[]',2),(43,'1','1',1,1,'[6]','[5]',3),(44,'232','23',2,2,'[]','[5, 6]',3),(45,'11','1',1,1,'[6]','[5]',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

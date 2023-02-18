/*
SQLyog Professional v12.14 (64 bit)
MySQL - 8.0.13 : Database - springboot_crud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot_crud` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springboot_crud`;

/*Table structure for table `tbl_book` */

DROP TABLE IF EXISTS `tbl_book`;

CREATE TABLE `tbl_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `tbl_book` */

insert  into `tbl_book`(`id`,`type`,`name`,`description`) values 
(1,'计算机理论','Spring实战 第5版','Spring入门经典教程，深入理解Spring原理技术内幕'),
(2,'计算机理论','Spring 5核心原理与30个类手写实战','十年沉淀之作，手写Spring精华思想'),
(3,'计算机理论','Spring 5 设计模式','深入Spring源码剖析Spring源码中蕴含的10大设计模式'),
(4,'计算机理论','Spring MVC+MyBatis开发从入门到项目实战','全方位解析面向Web应用的轻量级框架，带你成为Spring MVC开发高手'),
(5,'计算机理论','轻量级Java Web企业应用实战','源码级剖析Spring框架，适合已掌握Java基础的读者'),
(6,'计算机理论','Java核心技术 卷I 基础知识（原书第11版）','Core Java 第11版，Jolt大奖获奖作品，针对Java SE9、10、11全面更新'),
(7,'计算机理论','深入理解Java虚拟机','5个维度全面剖析JVM，大厂面试知识点全覆盖'),
(8,'计算机理论','Java编程思想（第4版）','Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉'),
(9,'计算机理论','零基础学Java（全彩版）','零基础自学编程的入门图书，由浅入深，详解Java语言的编程思想和核心技术'),
(10,'市场营销','直播就该这么做：主播高效沟通实战指南','李子柒、李佳琦、薇娅成长为网红的秘密都在书中'),
(11,'市场营销','直播销讲实战一本通','和秋叶一起学系列网络营销书籍'),
(12,'市场营销','直播带货：淘宝、天猫直播从新手到高手','一本教你如何玩转直播的书，10堂课轻松实现带货月入3W+'),
(52,'测试数据123','测试数据123','测试数据123'),
(55,'测试数据123','测试数据123','测试数据123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

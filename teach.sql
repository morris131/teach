/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.96-community-nt : Database - teach
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teach` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `teach`;

/*Table structure for table `course_intro` */

CREATE TABLE `course_intro` (
  `course_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `course_title` varchar(50) NOT NULL COMMENT '标题',
  `course_content` text NOT NULL COMMENT '内容',
  PRIMARY KEY  (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `course_intro` */

LOCK TABLES `course_intro` WRITE;

insert  into `course_intro`(`course_id`,`course_title`,`course_content`) values (2,'gg','<p>gg</p>'),(9,'hfds','<p>fsa&nbsp;<img src=\"/teach/static/upload/image/20150308/1425825374969053056.jpg\" title=\"1425825374969053056.jpg\" alt=\"mm.jpg\"/></p>');

UNLOCK TABLES;

/*Table structure for table `download_resource` */

CREATE TABLE `download_resource` (
  `down_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `down_title` varchar(50) NOT NULL COMMENT '标题',
  `down_content` text NOT NULL COMMENT '内容',
  `down_type` int(11) default NULL COMMENT '类型,外键',
  `down_date` datetime NOT NULL COMMENT '发布时间',
  `down_count` int(11) NOT NULL COMMENT '点击次数',
  PRIMARY KEY  (`down_id`),
  KEY `down_type` (`down_type`),
  CONSTRAINT `download_resource_ibfk_1` FOREIGN KEY (`down_type`) REFERENCES `download_resource_type` (`down_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `download_resource` */

LOCK TABLES `download_resource` WRITE;

UNLOCK TABLES;

/*Table structure for table `download_resource_type` */

CREATE TABLE `download_resource_type` (
  `down_type_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `down_type_name` varchar(50) NOT NULL COMMENT '编号',
  PRIMARY KEY  (`down_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `download_resource_type` */

LOCK TABLES `download_resource_type` WRITE;

UNLOCK TABLES;

/*Table structure for table `experiment_arrange` */

CREATE TABLE `experiment_arrange` (
  `exp_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `exp_title` varchar(50) NOT NULL COMMENT '标题',
  `exp_content` text NOT NULL COMMENT '内容',
  PRIMARY KEY  (`exp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `experiment_arrange` */

LOCK TABLES `experiment_arrange` WRITE;

UNLOCK TABLES;

/*Table structure for table `outstand_student` */

CREATE TABLE `outstand_student` (
  `stu_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `stu_title` varchar(50) NOT NULL COMMENT '标题',
  `stu_content` text NOT NULL COMMENT '内容',
  `stu_type` int(11) default NULL COMMENT '分类,外键',
  `stu_date` datetime NOT NULL COMMENT '发布时间',
  `stu_count` int(11) NOT NULL COMMENT '点击次数',
  PRIMARY KEY  (`stu_id`),
  KEY `stu_type` (`stu_type`),
  CONSTRAINT `outstand_student_ibfk_1` FOREIGN KEY (`stu_type`) REFERENCES `outstand_student_type` (`stu_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `outstand_student` */

LOCK TABLES `outstand_student` WRITE;

UNLOCK TABLES;

/*Table structure for table `outstand_student_type` */

CREATE TABLE `outstand_student_type` (
  `stu_type_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `stu_type_name` varchar(50) NOT NULL COMMENT '名字',
  PRIMARY KEY  (`stu_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `outstand_student_type` */

LOCK TABLES `outstand_student_type` WRITE;

UNLOCK TABLES;

/*Table structure for table `question_comment` */

CREATE TABLE `question_comment` (
  `question_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `question_name` varchar(50) NOT NULL COMMENT '名字',
  `question_class` varchar(50) NOT NULL COMMENT '班级',
  `question_tel` varchar(50) NOT NULL COMMENT '电话',
  `question_email` varchar(50) NOT NULL COMMENT '邮箱',
  `question_date` datetime NOT NULL COMMENT '提问时间',
  `question_title` varchar(50) NOT NULL COMMENT '标题',
  `question_content` text NOT NULL COMMENT '提问内容',
  `question_reply` text COMMENT '回复内容',
  PRIMARY KEY  (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `question_comment` */

LOCK TABLES `question_comment` WRITE;

UNLOCK TABLES;

/*Table structure for table `teach_arrange` */

CREATE TABLE `teach_arrange` (
  `teach_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `teach_title` varchar(50) NOT NULL COMMENT '标题',
  `teach_content` text NOT NULL COMMENT '内容',
  `teach_type` int(11) default NULL COMMENT '类型,外键',
  `teach_date` datetime NOT NULL COMMENT '发布时间',
  `teach_count` int(11) NOT NULL COMMENT '点击次数',
  PRIMARY KEY  (`teach_id`),
  KEY `teach_type` (`teach_type`),
  CONSTRAINT `teach_arrange_ibfk_1` FOREIGN KEY (`teach_type`) REFERENCES `teach_arrange_type` (`teach_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teach_arrange` */

LOCK TABLES `teach_arrange` WRITE;

UNLOCK TABLES;

/*Table structure for table `teach_arrange_type` */

CREATE TABLE `teach_arrange_type` (
  `teach_type_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `teach_type_name` varchar(50) NOT NULL COMMENT '名字',
  PRIMARY KEY  (`teach_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teach_arrange_type` */

LOCK TABLES `teach_arrange_type` WRITE;

UNLOCK TABLES;

/*Table structure for table `teach_user` */

CREATE TABLE `teach_user` (
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `user_password` varchar(50) NOT NULL COMMENT '密码',
  `user_role` char(10) NOT NULL COMMENT '角色:amin,user',
  PRIMARY KEY  (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teach_user` */

LOCK TABLES `teach_user` WRITE;

insert  into `teach_user`(`user_name`,`user_password`,`user_role`) values ('admin','21232f297a57a5a743894a0e4a801fc3','admin'),('morris','ec726fd938bbf930b86581442b18bec7','user');

UNLOCK TABLES;

/*Table structure for table `teacher_intro` */

CREATE TABLE `teacher_intro` (
  `teacher_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `teacher_title` varchar(50) NOT NULL COMMENT '标题',
  `teacher_content` text NOT NULL COMMENT '内容',
  `teacher_type` int(11) default NULL COMMENT '类型,外键',
  `teacher_date` datetime NOT NULL COMMENT '发布时间',
  `teacher_count` int(11) NOT NULL COMMENT '点击次数',
  PRIMARY KEY  (`teacher_id`),
  KEY `teacher_type` (`teacher_type`),
  CONSTRAINT `teacher_intro_ibfk_1` FOREIGN KEY (`teacher_type`) REFERENCES `teacher_intro_type` (`tea_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher_intro` */

LOCK TABLES `teacher_intro` WRITE;

UNLOCK TABLES;

/*Table structure for table `teacher_intro_type` */

CREATE TABLE `teacher_intro_type` (
  `tea_type_id` int(11) NOT NULL auto_increment COMMENT '编号',
  `tea_type_name` varchar(50) NOT NULL COMMENT '名字',
  PRIMARY KEY  (`tea_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `teacher_intro_type` */

LOCK TABLES `teacher_intro_type` WRITE;

insert  into `teacher_intro_type`(`tea_type_id`,`tea_type_name`) values (1,'主讲'),(2,'其他');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

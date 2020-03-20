/*
Navicat MySQL Data Transfer

Source Server         : Ubuntu
Source Server Version : 50729
Source Host           : 101.132.45.28:3306
Source Database       : tutorials

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-19 19:51:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cloud_payment
-- ----------------------------
DROP TABLE IF EXISTS `cloud_payment`;
CREATE TABLE `cloud_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cloud_payment
-- ----------------------------
INSERT INTO `cloud_payment` VALUES ('1', '5e908b49-6229-11ea-974c-00163e0a1128');
INSERT INTO `cloud_payment` VALUES ('2', null);
INSERT INTO `cloud_payment` VALUES ('3', 'a64f60a2-62d7-11ea-974c-00163e0a1128');
INSERT INTO `cloud_payment` VALUES ('4', null);
INSERT INTO `cloud_payment` VALUES ('5', null);
INSERT INTO `cloud_payment` VALUES ('6', '1d64e6b2-62e7-11ea-974c-00163e0a1128');

-- ----------------------------
-- Table structure for db_article
-- ----------------------------
DROP TABLE IF EXISTS `db_article`;
CREATE TABLE `db_article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `author_id` int(10) unsigned NOT NULL,
  `category_id` int(10) unsigned NOT NULL,
  `views` int(10) unsigned NOT NULL,
  `comments` int(10) unsigned NOT NULL,
  `title` varbinary(255) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_C_V` (`category_id`,`views`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_article
-- ----------------------------
INSERT INTO `db_article` VALUES ('1', '1', '1', '1', '1', 0x31, '1');
INSERT INTO `db_article` VALUES ('2', '2', '2', '2', '2', 0x32, '2');
INSERT INTO `db_article` VALUES ('3', '1', '1', '3', '3', 0x33, '3');

-- ----------------------------
-- Table structure for db_batch_dept
-- ----------------------------
DROP TABLE IF EXISTS `db_batch_dept`;
CREATE TABLE `db_batch_dept` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `deptno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `dname` varchar(20) NOT NULL DEFAULT '',
  `loc` varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_batch_dept
-- ----------------------------

-- ----------------------------
-- Table structure for db_batch_emp
-- ----------------------------
DROP TABLE IF EXISTS `db_batch_emp`;
CREATE TABLE `db_batch_emp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `empno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `ename` varchar(20) NOT NULL DEFAULT '',
  `job` varchar(9) NOT NULL DEFAULT '',
  `mgr` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `hiredate` date NOT NULL,
  `sal` decimal(7,2) NOT NULL,
  `comm` decimal(7,2) NOT NULL,
  `deptno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_batch_emp
-- ----------------------------

-- ----------------------------
-- Table structure for db_book
-- ----------------------------
DROP TABLE IF EXISTS `db_book`;
CREATE TABLE `db_book` (
  `bookid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `card` int(10) unsigned NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_book
-- ----------------------------
INSERT INTO `db_book` VALUES ('1', '12');
INSERT INTO `db_book` VALUES ('2', '19');
INSERT INTO `db_book` VALUES ('3', '17');
INSERT INTO `db_book` VALUES ('4', '7');
INSERT INTO `db_book` VALUES ('5', '4');
INSERT INTO `db_book` VALUES ('6', '20');
INSERT INTO `db_book` VALUES ('7', '5');
INSERT INTO `db_book` VALUES ('8', '4');
INSERT INTO `db_book` VALUES ('9', '3');
INSERT INTO `db_book` VALUES ('10', '5');
INSERT INTO `db_book` VALUES ('11', '16');
INSERT INTO `db_book` VALUES ('12', '2');
INSERT INTO `db_book` VALUES ('13', '3');
INSERT INTO `db_book` VALUES ('14', '9');
INSERT INTO `db_book` VALUES ('15', '15');
INSERT INTO `db_book` VALUES ('16', '9');
INSERT INTO `db_book` VALUES ('17', '17');
INSERT INTO `db_book` VALUES ('18', '18');
INSERT INTO `db_book` VALUES ('19', '20');
INSERT INTO `db_book` VALUES ('20', '5');

-- ----------------------------
-- Table structure for db_class
-- ----------------------------
DROP TABLE IF EXISTS `db_class`;
CREATE TABLE `db_class` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `card` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_class
-- ----------------------------
INSERT INTO `db_class` VALUES ('1', '16');
INSERT INTO `db_class` VALUES ('2', '15');
INSERT INTO `db_class` VALUES ('3', '8');
INSERT INTO `db_class` VALUES ('4', '13');
INSERT INTO `db_class` VALUES ('5', '20');
INSERT INTO `db_class` VALUES ('6', '3');
INSERT INTO `db_class` VALUES ('7', '13');
INSERT INTO `db_class` VALUES ('8', '17');
INSERT INTO `db_class` VALUES ('9', '5');
INSERT INTO `db_class` VALUES ('10', '15');
INSERT INTO `db_class` VALUES ('11', '18');
INSERT INTO `db_class` VALUES ('12', '4');
INSERT INTO `db_class` VALUES ('13', '5');
INSERT INTO `db_class` VALUES ('14', '11');
INSERT INTO `db_class` VALUES ('15', '16');
INSERT INTO `db_class` VALUES ('16', '9');
INSERT INTO `db_class` VALUES ('17', '16');
INSERT INTO `db_class` VALUES ('18', '14');
INSERT INTO `db_class` VALUES ('19', '2');
INSERT INTO `db_class` VALUES ('20', '6');

-- ----------------------------
-- Table structure for db_dept
-- ----------------------------
DROP TABLE IF EXISTS `db_dept`;
CREATE TABLE `db_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(30) DEFAULT NULL,
  `locAdd` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_dept
-- ----------------------------
INSERT INTO `db_dept` VALUES ('1', 'RD', '11');
INSERT INTO `db_dept` VALUES ('2', 'HR', '12');
INSERT INTO `db_dept` VALUES ('3', 'MK', '13');
INSERT INTO `db_dept` VALUES ('4', 'MIS', '14');
INSERT INTO `db_dept` VALUES ('5', 'FD', '15');

-- ----------------------------
-- Table structure for db_emp
-- ----------------------------
DROP TABLE IF EXISTS `db_emp`;
CREATE TABLE `db_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dept_id` (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_emp
-- ----------------------------
INSERT INTO `db_emp` VALUES ('1', 'z3', '1');
INSERT INTO `db_emp` VALUES ('2', 'z4', '1');
INSERT INTO `db_emp` VALUES ('3', 'z5', '1');
INSERT INTO `db_emp` VALUES ('4', 'w5', '2');
INSERT INTO `db_emp` VALUES ('5', 'w6', '2');
INSERT INTO `db_emp` VALUES ('6', 's7', '3');
INSERT INTO `db_emp` VALUES ('7', 's8', '4');
INSERT INTO `db_emp` VALUES ('8', 's9', '51');

-- ----------------------------
-- Table structure for db_innodb_lock
-- ----------------------------
DROP TABLE IF EXISTS `db_innodb_lock`;
CREATE TABLE `db_innodb_lock` (
  `a` int(11) DEFAULT NULL,
  `b` varchar(16) DEFAULT NULL,
  KEY `IDX_INNODB_LOCK_A` (`a`),
  KEY `IDX_INNODB_LOCK_B` (`b`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_innodb_lock
-- ----------------------------
INSERT INTO `db_innodb_lock` VALUES ('1', 'b2');
INSERT INTO `db_innodb_lock` VALUES ('3', '40001');
INSERT INTO `db_innodb_lock` VALUES ('4', '40001');
INSERT INTO `db_innodb_lock` VALUES ('5', '40001');
INSERT INTO `db_innodb_lock` VALUES ('6', '6000');
INSERT INTO `db_innodb_lock` VALUES ('7', '7000');
INSERT INTO `db_innodb_lock` VALUES ('8', '8000');
INSERT INTO `db_innodb_lock` VALUES ('9', '9000');
INSERT INTO `db_innodb_lock` VALUES ('1', 'b1');

-- ----------------------------
-- Table structure for db_mylock
-- ----------------------------
DROP TABLE IF EXISTS `db_mylock`;
CREATE TABLE `db_mylock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_mylock
-- ----------------------------
INSERT INTO `db_mylock` VALUES ('1', 'q');
INSERT INTO `db_mylock` VALUES ('2', 'b');
INSERT INTO `db_mylock` VALUES ('3', 'c');
INSERT INTO `db_mylock` VALUES ('4', 'd');
INSERT INTO `db_mylock` VALUES ('5', 'e');

-- ----------------------------
-- Table structure for db_phone
-- ----------------------------
DROP TABLE IF EXISTS `db_phone`;
CREATE TABLE `db_phone` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `card` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_phone
-- ----------------------------
INSERT INTO `db_phone` VALUES ('1', '3');
INSERT INTO `db_phone` VALUES ('2', '2');
INSERT INTO `db_phone` VALUES ('3', '18');
INSERT INTO `db_phone` VALUES ('4', '6');
INSERT INTO `db_phone` VALUES ('5', '16');
INSERT INTO `db_phone` VALUES ('6', '1');
INSERT INTO `db_phone` VALUES ('7', '16');
INSERT INTO `db_phone` VALUES ('8', '15');
INSERT INTO `db_phone` VALUES ('9', '6');
INSERT INTO `db_phone` VALUES ('10', '5');
INSERT INTO `db_phone` VALUES ('11', '5');
INSERT INTO `db_phone` VALUES ('12', '11');
INSERT INTO `db_phone` VALUES ('13', '18');
INSERT INTO `db_phone` VALUES ('14', '7');
INSERT INTO `db_phone` VALUES ('15', '8');
INSERT INTO `db_phone` VALUES ('16', '12');
INSERT INTO `db_phone` VALUES ('17', '14');
INSERT INTO `db_phone` VALUES ('18', '13');
INSERT INTO `db_phone` VALUES ('19', '4');
INSERT INTO `db_phone` VALUES ('20', '20');

-- ----------------------------
-- Table structure for db_staffs
-- ----------------------------
DROP TABLE IF EXISTS `db_staffs`;
CREATE TABLE `db_staffs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(24) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `pos` varchar(20) NOT NULL DEFAULT '' COMMENT '职位',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  PRIMARY KEY (`id`),
  KEY `IDX_STAFFS_NAME_AGE_POS` (`NAME`,`age`,`pos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='员工记录表';

-- ----------------------------
-- Records of db_staffs
-- ----------------------------
INSERT INTO `db_staffs` VALUES ('1', 'z3', '2', 'manager', '2020-02-02 17:20:33');
INSERT INTO `db_staffs` VALUES ('2', 'July', '23', 'dev', '2020-02-02 17:20:33');
INSERT INTO `db_staffs` VALUES ('3', '2000', '23', 'dev', '2020-02-02 17:20:33');

-- ----------------------------
-- Table structure for db_tblA
-- ----------------------------
DROP TABLE IF EXISTS `db_tblA`;
CREATE TABLE `db_tblA` (
  `age` int(11) DEFAULT NULL,
  `birth` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `IDX_TBLA_AGE_BIRTH` (`age`,`birth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_tblA
-- ----------------------------
INSERT INTO `db_tblA` VALUES ('22', '2020-02-03 12:11:13');
INSERT INTO `db_tblA` VALUES ('23', '2020-02-03 12:11:13');
INSERT INTO `db_tblA` VALUES ('24', '2020-02-03 12:11:14');

-- ----------------------------
-- Table structure for db_test03
-- ----------------------------
DROP TABLE IF EXISTS `db_test03`;
CREATE TABLE `db_test03` (
  `a` int(11) NOT NULL AUTO_INCREMENT,
  `c1` char(10) DEFAULT NULL,
  `c2` char(10) DEFAULT NULL,
  `c3` char(10) DEFAULT NULL,
  `c4` char(10) DEFAULT NULL,
  `c5` char(10) DEFAULT NULL,
  PRIMARY KEY (`a`),
  KEY `IDX_C1_C2_C3_C4` (`c1`,`c2`,`c3`,`c4`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of db_test03
-- ----------------------------
INSERT INTO `db_test03` VALUES ('1', 'a1', 'a2', 'a3', 'a4', 'a5');
INSERT INTO `db_test03` VALUES ('2', 'b1', 'b2', 'b3', 'b4', 'b5');
INSERT INTO `db_test03` VALUES ('3', 'c1', 'c2', 'c3', 'c4', 'c5');
INSERT INTO `db_test03` VALUES ('4', 'd1', 'd2', 'd3', 'd4', 'd5');
INSERT INTO `db_test03` VALUES ('5', 'e1', 'e2', 'e3', 'e4', 'e5');

-- ----------------------------
-- Procedure structure for insert_dept
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_dept`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `insert_dept`(IN start INT(10),IN max_num INT(10))
BEGIN
    DECLARE i INT DEFAULT 0;
    SET autocommit = 0;
    REPEAT
      SET i = i + 1;
      INSERT INTO BigData_dept(deptno, dname, loc)
          VALUES((start + i), rand_string(10), rand_string(8));
      UNTIL i = max_num
    END REPEAT;
    COMMIT;
  END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insert_emp
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_emp`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `insert_emp`(IN START INT(10),IN max_num INT(10))
BEGIN
    DECLARE i INT DEFAULT 0;
    # set autocommit =0把autocommit设置成0
    SET autocommit= 0;
    REPEAT
      SET i=i+ 1;
      INSERT INTO BigData_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
          VALUES((START+i), rand_string(6), 'SALESMAN', 0001, CURDATE(), 2000, 400, rand_num());
      UNTIL i= max_num
    END REPEAT;
  COMMIT;
  END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for rand_num
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_num`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `rand_num`( ) RETURNS int(5)
BEGIN
    DECLARE i INT DEFAULT 0;
    SET i= FLOOR(100 + RAND() * 10);
    RETURN i;
  END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for rand_string
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_string`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `rand_string`(n INT) RETURNS varchar(255) CHARSET utf8mb4
BEGIN
    DECLARE chars_str VARCHAR(100) DEFAULT ' abcdefghijklmnopqrstuVwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ';
    DECLARE return_str VARCHAR(255) DEFAULT '';
    DECLARE i INT DEFAULT 0;
    WHILE i < n DO
    SET return_str = CONCAT(return_str, SUBSTRING(chars_str, FLOOR(1+RAND()*52),1));
    SET i = i + 1;
  END WHILE;
RETURN return_str;
END
;;
DELIMITER ;

/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50727
Source Host           : 101.132.45.28:3306
Source Database       : taxtool

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-08-25 18:06:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for academic_education
-- ----------------------------
DROP TABLE IF EXISTS `academic_education`;
CREATE TABLE `academic_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `tax_credit` double DEFAULT NULL,
  `current_school` varchar(100) DEFAULT NULL,
  `student_roll_id` varchar(45) DEFAULT NULL,
  `education_level` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `enrollment_end_year` datetime DEFAULT NULL,
  `enrollment_start_year` datetime DEFAULT NULL,
  `tax_month` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academic_education
-- ----------------------------
INSERT INTO `academic_education` VALUES ('38', 'T0', '400', '北大', '201212312', '博士研究生', '2018-12-14 02:10:04', '2018-12-14 02:10:04', null, '2020-10-11 19:00:00', '2015-08-13 19:00:00', '2018-11-30 10:00:00');
INSERT INTO `academic_education` VALUES ('39', 'Tkayla', '0', 'fdsds', 'sfd', '博士研究生', '2018-12-14 02:46:46', '2018-12-14 02:51:57', '2018-12-14 02:51:57', '2021-12-15 18:00:00', '2018-12-13 18:00:00', '2018-11-30 10:00:00');
INSERT INTO `academic_education` VALUES ('40', 'Tkayla', '400', 'd', 'fsd', '硕士研究生', '2018-12-14 02:53:07', '2018-12-14 02:53:36', '2018-12-14 02:53:36', '2019-12-13 18:00:00', '2018-12-13 18:00:00', '2018-11-30 10:00:00');
INSERT INTO `academic_education` VALUES ('41', 'zack', '400', '北大dd', '110112', '硕士研究生', '2018-12-14 03:56:06', '2018-12-14 05:47:10', '2018-12-14 05:47:10', '2022-10-11 19:00:00', '2017-12-13 18:00:00', '2018-11-30 10:00:00');
INSERT INTO `academic_education` VALUES ('42', 'string', '400', 'string', 'string', 'string', '2018-12-14 03:59:25', '2018-12-14 03:59:25', null, '2018-12-15 03:58:42', '2018-12-14 03:58:42', '2018-11-30 10:00:00');

-- ----------------------------
-- Table structure for children_education
-- ----------------------------
DROP TABLE IF EXISTS `children_education`;
CREATE TABLE `children_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `children_number` int(11) DEFAULT NULL,
  `tax_credit` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `tax_month` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of children_education
-- ----------------------------
INSERT INTO `children_education` VALUES ('1', 'T11', '1', '1000', '2018-08-08 00:00:00', '2018-08-08 00:00:00', null, '2018-12-13 10:00:00');
INSERT INTO `children_education` VALUES ('5', 'T12', '0', '0', '2018-12-14 06:17:16', '2018-12-14 06:17:16', null, '2018-11-30 10:00:00');

-- ----------------------------
-- Table structure for configuration
-- ----------------------------
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration` (
  `config_key` varchar(45) NOT NULL,
  `config_value` varchar(2550) DEFAULT NULL,
  PRIMARY KEY (`config_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of configuration
-- ----------------------------
INSERT INTO `configuration` VALUES ('ACADEMIC_EDUCATION', '400');
INSERT INTO `configuration` VALUES ('ACADEMIC_EDUCATION_POLICY', '<p>1. 纳税人接受学历继续教育的支出，在学历教育期间按照每年4800元（每月400元）定额扣除。纳税人接受技能人员职业资格继续教育、专业技术人员职业资格继续教育支出，在取得相关证书的年度，按照每年3600元定额扣除。</p><p>2. 个人接受同一学历教育事项，符合本办法规定扣除条件的，该项教育支出可以由其父母按照子女教育支出扣除，也可以由本人按照继续教育支出扣除，但不得同时扣除。</p>');
INSERT INTO `configuration` VALUES ('CHILDREN_EDUCATION', '1000');
INSERT INTO `configuration` VALUES ('CHILDREN_EDUCATION_POLICY', '<p>1. 纳税人的子女接受学前教育和学历教育的相关支出，按照每个子女每年12000元（每月1000元）的标准定额扣除。前款所称学前教育包括年满3岁至小学入学前教育。学历教育包括义务教育（小学和初中教育）、高中阶段教育（普通高中、中等职业教育)、高等教育（大学专科、大学本科、硕士研究生、博士研究生教育）。</p><p>2. 受教育子女的父母分别按扣除标准的50%扣除；经父母约定，也可以选择由其中一方按扣除标准的100%扣除。具体扣除方式在一个纳税年度内不得变更。</p>');
INSERT INTO `configuration` VALUES ('DECLARATION_END_TIME', '27');
INSERT INTO `configuration` VALUES ('DECLARATION_START_TIME', '10');
INSERT INTO `configuration` VALUES ('HOME_LOAN', '1000');
INSERT INTO `configuration` VALUES ('HOME_LOAN_POLICY', '<p>1. 纳税人本人或配偶使用商业银行或住房公积金个人住房贷款为本人或其配偶购买住房，发生的首套住房贷款利息支出，在偿还贷款期间，可以按照每年12000元（每月1000元）标准定额扣除。非首套住房贷款利息支出，纳税人不得扣除。纳税人只能享受一套首套住房贷款利息扣除。</p><p>2. 经夫妻双方约定，可以选择由其中一方扣除，具体扣除方式在一个纳税年度内不得变更。</p><p>3. 纳税人应当留存住房贷款合同、贷款还款支出凭证。</p>');
INSERT INTO `configuration` VALUES ('HOUSING_RENT_POLICY', '<p>1. 纳税人本人及配偶在纳税人的主要工作城市没有住房，而在主要工作城市租赁住房发生的租金支出,可以按照以下标准定额扣除：</p><ul><li>承租的住房位于直辖市、省会城市、计划单列市以及国务院确定的其他城市，扣除标准为每年14400元（每月1200元）。</li><li>承租的住房位于其他城市的，市辖区户籍人口超过100万的，扣除标准为每年12000元（每月1000元）。</li><li>承租的住房位于其他城市的，市辖区户籍人口不超过100万（含）的，扣除标准为每年9600元（每月800元）。</li></ul><p>2. 主要工作城市是指纳税人任职受雇所在城市，无任职受雇单位的，为其经常居住城市。城市范围包括直辖市、计划单列市、副省级城市、地级市（地区、州、盟）全部行政区域范围。夫妻双方主要工作城市相同的，只能由一方扣除住房租金支出。夫妻双方主要工作城市不相同的，且各自在其主要工作城市都没有住房的，可以分别扣除住房租金支出。</p><p>3. 住房租金支出由签订租赁住房合同的承租人扣除。</p><p>4. 纳税人及其配偶不得同时分别享受住房贷款利息专项附加扣除和住房租金专项附加扣除。</p><p>5. 纳税人应当留存住房租赁合同。</p>');
INSERT INTO `configuration` VALUES ('HR_END_REVIEW_DAY', '25');
INSERT INTO `configuration` VALUES ('MAJOR_DISEASE_MEDICAL_POLICY', '<p>1. 一个纳税年度内，在社会医疗保险管理信息系统记录的（包括医保目录范围内的自付部分和医保目录范围外的自费部分）由个人负担超过15000元的医药费用支出部分，为大病医疗支出，可以按照每年60000元标准限额据实扣除。大病医疗专项附加扣除由纳税人办理汇算清缴时扣除。</p><p>2. 纳税人发生的大病医疗支出由纳税人本人扣除。</p><p>3. 纳税人应当留存医疗服务收费相关票据原件（或复印件）。</p>');
INSERT INTO `configuration` VALUES ('PAYMENT_DAY', '15');
INSERT INTO `configuration` VALUES ('SUPPORTING_ELDERLY', '2000');
INSERT INTO `configuration` VALUES ('SUPPORTING_ELDERLY_POLICY', '<p>1. 纳税人赡养60岁（含）以上父母以及其他法定赡养人的赡养支出，可以按照以下标准定额扣除：</p><ul><li>纳税人为独生子女的，按照每年24000元（每月2000元）的标准定额扣除；</li><li>纳税人为非独生子女的，应当与其兄弟姐妹分摊每年24000元(每月2000元)的扣除额度，分摊方式包括平均分摊、被赡养人指定分摊或者赡养人约定分摊，具体分摊方式在一个纳税年度内不得变更。采取指定分摊或约定分摊方式的，每一纳税人分摊的扣除额最高不得超过每年12000元（每月1000元），并签订书面分摊协议。指定分摊与约定分摊不一致的，以指定分摊为准。纳税人赡养2个及以上老人的，不按老人人数加倍扣除。</li></ul><p>2. 其他法定赡养人是指祖父母、外祖父母的子女已经去世，实际承担对祖父母、外祖父母赡养义务的孙子女、外孙子女。</p>');

-- ----------------------------
-- Table structure for home_loan
-- ----------------------------
DROP TABLE IF EXISTS `home_loan`;
CREATE TABLE `home_loan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `certificate_no` varchar(100) DEFAULT NULL,
  `tax_credit` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `loan_start_date` datetime DEFAULT NULL,
  `loan_end_date` datetime DEFAULT NULL,
  `tax_month` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home_loan
-- ----------------------------
INSERT INTO `home_loan` VALUES ('2', 'T11', 'rti:7409273401', '1000', '2018-08-08 00:00:01', '2018-08-08 00:00:01', null, '2017-08-08 00:00:01', '2028-08-08 00:00:01', '2018-12-13 10:00:00');
INSERT INTO `home_loan` VALUES ('3', 'T04856', '3', '0', '2018-12-16 23:00:52', '2018-12-16 23:00:52', null, '2018-12-16 20:01:30', '2018-12-17 20:01:30', '2018-11-30 10:00:00');

-- ----------------------------
-- Table structure for housing_rent
-- ----------------------------
DROP TABLE IF EXISTS `housing_rent`;
CREATE TABLE `housing_rent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `tax_credit` double DEFAULT NULL,
  `renting_city` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `contract_end_date` datetime DEFAULT NULL,
  `contract_start_date` datetime DEFAULT NULL,
  `tax_month` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of housing_rent
-- ----------------------------
INSERT INTO `housing_rent` VALUES ('1', 'T11', '1000', '扬州', '2018-10-10 00:00:00', '2018-10-10 00:00:00', null, '2018-10-10 00:00:00', '2019-10-10 00:00:00', '2018-12-13 10:00:00');
INSERT INTO `housing_rent` VALUES ('5', 'T12', '1000', 'YANGZHOU', '2018-10-10 00:00:00', '2018-10-10 00:00:00', null, '2018-10-10 00:00:00', '2019-10-10 00:00:00', '2018-12-13 10:00:00');
INSERT INTO `housing_rent` VALUES ('6', 'T13', '0', '上海', '2018-12-14 00:12:42', '2018-12-14 00:12:42', null, '2019-12-18 18:00:00', '2018-11-13 18:00:00', '2018-11-30 10:00:00');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_type` varchar(45) DEFAULT NULL,
  `material_type` varchar(45) DEFAULT NULL,
  `material_url` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('56', 'T13', '6', 'HOUSING_RENT', 'RENTAL_CONTRACT', '/evidence/T13/1544767971400_HOUSING_RENT_0', '2018-12-14 00:12:51', '2018-12-14 00:12:51', null);
INSERT INTO `material` VALUES ('57', 'T13', '6', 'HOUSING_RENT', 'RENTAL_CONTRACT', '/evidence/T13/1544767971415_HOUSING_RENT_1', '2018-12-14 00:12:51', '2018-12-14 00:12:51', null);
INSERT INTO `material` VALUES ('58', 'T00t', '0', null, null, '/evidence/T00t/1544858067673.jpg', null, null, null);
INSERT INTO `material` VALUES ('59', 'T00t', '0', null, null, '/evidence/T00t/1544858121830.jpg', null, null, null);
INSERT INTO `material` VALUES ('60', 'T00t', '0', null, null, '/evidence/T00t/1544858256577.jpeg', null, null, null);
INSERT INTO `material` VALUES ('61', 'T00t', '0', null, null, '/evidence/T00t/1544858838463.jpeg', null, null, null);
INSERT INTO `material` VALUES ('62', 'T00t', '0', null, null, '/evidence/T00t/1544859938488.jpeg', null, null, null);
INSERT INTO `material` VALUES ('63', 'T00t', '0', null, null, '/evidence/T00t/1544859961970.jpg', null, null, null);
INSERT INTO `material` VALUES ('64', 'T00t', '0', null, null, '/evidence/T00t/1544860021391.png', null, null, null);
INSERT INTO `material` VALUES ('65', 'T00t', '0', null, null, '/evidence/T00t/1544860030239.jpg', null, null, null);
INSERT INTO `material` VALUES ('66', 'T00t', '0', null, null, '/evidence/T00t/1544860246415.jpeg', null, null, null);
INSERT INTO `material` VALUES ('67', 'T00t', '0', null, null, '/evidence/T00t/1544860246453.jpeg', null, null, null);
INSERT INTO `material` VALUES ('68', 'T00t', '0', null, null, '/evidence/T00t/1544860246409.jpeg', null, null, null);
INSERT INTO `material` VALUES ('69', 'T00t', '0', null, null, '/evidence/T00t/1544860262298.png', null, null, null);
INSERT INTO `material` VALUES ('70', 'T00t', '0', null, null, '/evidence/T00t/1544860275555.jpg', null, null, null);
INSERT INTO `material` VALUES ('71', 'T00t', '0', null, null, '/evidence/T00t/1544860461267.jpg', null, null, null);
INSERT INTO `material` VALUES ('72', 'T00t', '0', null, null, '/evidence/T00t/1544860494942.jpg', null, null, null);
INSERT INTO `material` VALUES ('73', 'T00t', '0', null, null, '/evidence/T00t/1544860515220.jpeg', null, null, null);
INSERT INTO `material` VALUES ('74', 'T00t', '0', null, null, '/evidence/T00t/1544863889880.jpeg', null, null, null);
INSERT INTO `material` VALUES ('75', 'T00t', '0', null, null, '/evidence/T00t/1544863889879.jpeg', null, null, null);
INSERT INTO `material` VALUES ('76', 'T00t', '0', null, null, '/evidence/T00t/1544863934204.jpeg', null, null, null);
INSERT INTO `material` VALUES ('77', 'T00t', '0', null, null, '/evidence/T00t/1544863940793.jpeg', null, null, null);
INSERT INTO `material` VALUES ('78', 'T00t', '0', null, null, '/evidence/T00t/1544863971589.jpeg', null, null, null);
INSERT INTO `material` VALUES ('79', 'T00t', '0', null, null, '/evidence/T00t/1544863976475.jpeg', null, null, null);
INSERT INTO `material` VALUES ('80', 'T00t', '0', null, null, '/evidence/T00t/1544863979526.jpeg', null, null, null);
INSERT INTO `material` VALUES ('81', 'T00t', '0', null, null, '/evidence/T00t/1544863982190.jpeg', null, null, null);
INSERT INTO `material` VALUES ('82', 'T00t', '0', null, null, '/evidence/T00t/1544863992724.jpg', null, null, null);
INSERT INTO `material` VALUES ('83', 'T00t', '0', null, null, '/evidence/T00t/1544864001303.jpeg', null, null, null);
INSERT INTO `material` VALUES ('84', 'T00t', '0', null, null, '/evidence/T00t/1544864005853.jpeg', null, null, null);
INSERT INTO `material` VALUES ('85', 'T00t', '0', null, null, '/evidence/T00t/1544864087103.jpeg', null, null, null);
INSERT INTO `material` VALUES ('86', 'T00t', '0', null, null, '/evidence/T00t/1544864097472.jpeg', null, null, null);
INSERT INTO `material` VALUES ('87', 'T00t', '0', null, null, '/evidence/T00t/1544864264326.jpeg', null, null, null);
INSERT INTO `material` VALUES ('88', 'T00t', '0', null, null, '/evidence/T00t/1544864266779.jpeg', null, null, null);
INSERT INTO `material` VALUES ('89', 'T00t', '0', null, null, '/evidence/T00t/1544864272590.jpg', null, null, null);
INSERT INTO `material` VALUES ('90', 'T00t', '0', null, null, '/evidence/T00t/1544864272614.jpeg', null, null, null);
INSERT INTO `material` VALUES ('91', 'T00t', '0', null, null, '/evidence/T00t/1544864272686.jpg', null, null, null);
INSERT INTO `material` VALUES ('92', 'T00t', '0', null, null, '/evidence/T00t/1544864277530.jpeg', null, null, null);
INSERT INTO `material` VALUES ('93', 'T00t', '0', null, null, '/evidence/T00t/1544864277550.jpg', null, null, null);
INSERT INTO `material` VALUES ('94', 'T00t', '0', null, null, '/evidence/T00t/1544864277900.jpeg', null, null, null);

-- ----------------------------
-- Table structure for material_child_education
-- ----------------------------
DROP TABLE IF EXISTS `material_child_education`;
CREATE TABLE `material_child_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `children_education_id` int(11) NOT NULL,
  `child_name` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `current_school` varchar(100) DEFAULT NULL,
  `student_roll_id` varchar(45) DEFAULT NULL,
  `enrollment_year` datetime DEFAULT NULL,
  `education_level` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material_child_education
-- ----------------------------
INSERT INTO `material_child_education` VALUES ('5', '5', 'string', '2018-12-14', 'string', null, '2018-12-15 05:13:31', 'string', '2018-12-14 05:18:40', '2018-12-14 06:17:16', '2018-12-14 06:17:16');
INSERT INTO `material_child_education` VALUES ('6', '5', 'string', '2018-12-14', 'string', null, '2018-12-15 05:25:35', 'string', '2018-12-14 05:26:25', '2018-12-14 06:17:16', '2018-12-14 06:17:16');
INSERT INTO `material_child_education` VALUES ('7', '5', 'string', '2018-12-14', 'string', null, '2018-12-16 05:35:04', 'string', '2018-12-14 05:35:17', '2018-12-14 06:17:16', '2018-12-14 06:17:16');
INSERT INTO `material_child_education` VALUES ('8', '5', 'string', '2018-12-14', 'string', null, '2018-12-16 05:35:04', 'string', '2018-12-14 06:00:25', '2018-12-14 06:17:16', '2018-12-14 06:17:16');
INSERT INTO `material_child_education` VALUES ('9', '5', 'string', '2018-12-14', 'string', null, '2018-12-14 06:11:23', 'string', '2018-12-14 06:11:49', '2018-12-14 06:17:16', '2018-12-14 06:17:16');
INSERT INTO `material_child_education` VALUES ('10', '5', 'string', '2018-12-14', 'string', null, '2018-12-14 06:11:23', 'string', '2018-12-14 06:17:16', '2018-12-14 06:17:16', null);

-- ----------------------------
-- Table structure for operation_detail
-- ----------------------------
DROP TABLE IF EXISTS `operation_detail`;
CREATE TABLE `operation_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `item_id` int(11) NOT NULL,
  `operator_id` varchar(45) DEFAULT NULL,
  `operating_date` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `item_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation_detail
-- ----------------------------
INSERT INTO `operation_detail` VALUES ('1', 'T11', '3', 'A', '2018-09-09 00:00:00', 'DECLARED', null, '2018-11-13 04:57:04', '2018-11-14 04:57:04', '2018-11-14 04:57:04', 'HOUSING_RENT');
INSERT INTO `operation_detail` VALUES ('2', 'T11', '4', 'B', '2018-10-09 00:00:00', 'UNDER_REVIEW', null, '2018-12-13 04:57:04', '2018-12-13 04:57:04', null, 'HOUSING_RENT');
INSERT INTO `operation_detail` VALUES ('3', 'T12', '5', 'C', '2018-10-09 00:00:00', 'DECLARED', 'erhyw6uw26uw', '2018-12-13 04:57:04', '2018-12-13 04:57:04', null, 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('4', 'T12', '4', null, null, 'UNDER_REVIEW', null, '2018-12-13 04:57:04', '2018-12-13 04:57:04', null, 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('5', 'T12', '2', null, null, 'UNDER_REVIEW', null, '2018-12-13 04:57:04', '2018-12-13 04:57:04', null, 'HOME_LOAN');
INSERT INTO `operation_detail` VALUES ('56', 'T11', '2', null, null, 'UNDER_REVIEW', null, '2018-12-13 23:21:33', '2018-12-13 23:56:25', '2018-12-13 23:56:25', 'SUPPORTING_ELDERLY');
INSERT INTO `operation_detail` VALUES ('57', 'T11', '2', null, null, 'UNDER_REVIEW', null, '2018-12-13 23:56:25', '2018-12-13 23:56:25', null, 'SUPPORTING_ELDERLY');
INSERT INTO `operation_detail` VALUES ('58', 'T13', '6', null, null, 'UNDER_REVIEW', null, '2018-12-14 00:06:13', '2018-12-14 00:09:02', '2018-12-14 00:09:02', 'HOUSING_RENT');
INSERT INTO `operation_detail` VALUES ('59', 'T13', '6', null, null, 'UNDER_REVIEW', null, '2018-12-14 00:09:02', '2018-12-14 00:10:02', '2018-12-14 00:10:02', 'HOUSING_RENT');
INSERT INTO `operation_detail` VALUES ('60', 'T13', '6', null, null, 'UNDER_REVIEW', null, '2018-12-14 00:10:02', '2018-12-14 00:12:42', '2018-12-14 00:12:42', 'HOUSING_RENT');
INSERT INTO `operation_detail` VALUES ('61', 'T13', '6', null, null, 'UNDER_REVIEW', null, '2018-12-14 00:12:42', '2018-12-14 00:12:42', null, 'HOUSING_RENT');
INSERT INTO `operation_detail` VALUES ('62', 'T0', '38', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:10:04', '2018-12-14 02:10:04', null, 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('63', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:31:18', '2018-12-14 02:36:57', '2018-12-14 02:36:57', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('64', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:36:57', '2018-12-14 02:38:43', '2018-12-14 02:38:43', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('65', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:38:43', '2018-12-14 02:39:31', '2018-12-14 02:39:31', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('66', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:39:31', '2018-12-14 02:40:11', '2018-12-14 02:40:11', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('67', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:40:11', '2018-12-14 02:42:05', '2018-12-14 02:42:05', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('68', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:42:05', '2018-12-14 02:42:50', '2018-12-14 02:42:50', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('69', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:42:50', '2018-12-14 02:43:36', '2018-12-14 02:43:36', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('70', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:43:36', '2018-12-14 02:44:17', '2018-12-14 02:44:17', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('71', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:44:17', '2018-12-14 02:46:46', '2018-12-14 02:46:46', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('72', 'Tkayla', '39', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:46:46', '2018-12-14 02:51:57', '2018-12-14 02:51:57', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('73', 'Tkayla', '40', null, null, 'UNDER_REVIEW', null, '2018-12-14 02:53:07', '2018-12-14 02:53:36', '2018-12-14 02:53:36', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('74', 'zack', '41', null, null, 'UNDER_REVIEW', null, '2018-12-14 03:49:43', '2018-12-14 03:51:56', '2018-12-14 03:51:56', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('75', 'zack', '41', null, null, 'UNDER_REVIEW', null, '2018-12-14 03:51:56', '2018-12-14 03:54:17', '2018-12-14 03:54:17', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('76', 'zack', '41', null, null, 'UNDER_REVIEW', null, '2018-12-14 03:54:17', '2018-12-14 03:54:23', '2018-12-14 03:54:23', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('77', 'zack', '41', null, null, 'UNDER_REVIEW', null, '2018-12-14 03:54:23', '2018-12-14 03:56:06', '2018-12-14 03:56:06', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('78', 'zack', '41', null, null, 'UNDER_REVIEW', null, '2018-12-14 03:56:06', '2018-12-14 05:47:10', '2018-12-14 05:47:10', 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('79', 'string', '42', null, null, 'UNDER_REVIEW', null, '2018-12-14 03:59:25', '2018-12-14 03:59:25', null, 'ACADEMIC_EDUCATION');
INSERT INTO `operation_detail` VALUES ('80', 'string', '5', null, null, 'UNDER_REVIEW', null, '2018-12-14 05:18:40', '2018-12-14 05:26:25', '2018-12-14 05:26:25', 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('81', 'string', '5', null, null, 'UNDER_REVIEW', null, '2018-12-14 05:26:25', '2018-12-14 05:35:17', '2018-12-14 05:35:17', 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('82', 'string', '5', null, null, 'UNDER_REVIEW', null, '2018-12-14 05:35:17', '2018-12-14 06:00:25', '2018-12-14 06:00:25', 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('83', 'string', '5', null, null, 'UNDER_REVIEW', null, '2018-12-14 06:00:25', '2018-12-14 06:11:49', '2018-12-14 06:11:49', 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('84', 'string', '5', null, null, 'UNDER_REVIEW', null, '2018-12-14 06:11:49', '2018-12-14 06:17:16', '2018-12-14 06:17:16', 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('85', 'string', '5', null, null, 'UNDER_REVIEW', null, '2018-12-14 06:17:16', '2018-12-14 06:17:16', null, 'CHILDREN_EDUCATION');
INSERT INTO `operation_detail` VALUES ('86', 'T04856', '3', null, null, 'UNDER_REVIEW', null, '2018-12-16 22:59:13', '2018-12-16 23:00:52', '2018-12-16 23:00:52', 'HOME_LOAN');
INSERT INTO `operation_detail` VALUES ('87', 'T04856', '3', null, null, 'UNDER_REVIEW', null, '2018-12-16 23:00:52', '2018-12-16 23:00:52', null, 'HOME_LOAN');

-- ----------------------------
-- Table structure for rental_tax_credit
-- ----------------------------
DROP TABLE IF EXISTS `rental_tax_credit`;
CREATE TABLE `rental_tax_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `tax_credit` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rental_tax_credit
-- ----------------------------
INSERT INTO `rental_tax_credit` VALUES ('1', '上海', '1200');
INSERT INTO `rental_tax_credit` VALUES ('2', '武汉', '1200');
INSERT INTO `rental_tax_credit` VALUES ('3', '扬州', '1000');

-- ----------------------------
-- Table structure for special_tax_credit
-- ----------------------------
DROP TABLE IF EXISTS `special_tax_credit`;
CREATE TABLE `special_tax_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `total_tax_credit` double DEFAULT NULL,
  `apply_tax_credit` double DEFAULT NULL,
  `children_education_tax_credit` double DEFAULT NULL,
  `home_loan_tax_credit` double DEFAULT NULL,
  `supporting_elderly_tax_credit` double DEFAULT NULL,
  `housing_rent_tax_credit` double DEFAULT NULL,
  `continuing_education_tax_credit` double DEFAULT NULL,
  `major_disease_medical_tax_credit` double DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `tax_month` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of special_tax_credit
-- ----------------------------
INSERT INTO `special_tax_credit` VALUES ('1', 'T11', '0', '1000', null, null, null, '0', null, null, 'UNCONFIRMED', '2018-12-13 10:00:00', '2018-12-13 04:17:06', '2018-12-13 23:56:25', null);
INSERT INTO `special_tax_credit` VALUES ('2', 'T12', '1000', '3000', '1000', '0', null, null, null, null, 'UNCONFIRMED', '2018-12-13 10:00:00', '2018-12-13 05:17:06', '2018-12-13 05:17:06', null);
INSERT INTO `special_tax_credit` VALUES ('33', 'T13', null, '0', null, null, null, null, null, null, 'UNCONFIRMED', '2018-12-14 00:06:13', '2018-12-14 00:06:13', '2018-12-14 00:12:42', null);
INSERT INTO `special_tax_credit` VALUES ('34', 'T0', null, '400', null, null, null, null, null, null, 'UNCONFIRMED', '2018-12-14 02:10:04', '2018-12-14 02:10:04', '2018-12-14 02:10:04', null);
INSERT INTO `special_tax_credit` VALUES ('35', 'Tkayla', null, '2000', null, null, null, null, null, null, 'UNCONFIRMED', '2018-12-14 02:31:18', '2018-12-14 02:31:18', '2018-12-14 02:53:36', null);
INSERT INTO `special_tax_credit` VALUES ('36', 'zack', null, '800', null, null, null, null, null, null, 'UNCONFIRMED', '2018-12-14 03:49:43', '2018-12-14 03:49:43', '2018-12-14 05:47:10', null);
INSERT INTO `special_tax_credit` VALUES ('37', 'string', null, '1400', null, null, null, null, null, null, 'UNCONFIRMED', '2018-12-14 03:59:25', '2018-12-14 03:59:25', '2018-12-14 06:17:16', null);
INSERT INTO `special_tax_credit` VALUES ('38', 'T04856', null, '0', null, null, null, null, null, null, 'UNCONFIRMED', '2018-12-16 22:59:13', '2018-12-16 22:59:13', '2018-12-16 23:00:52', null);

-- ----------------------------
-- Table structure for supporting_elderly
-- ----------------------------
DROP TABLE IF EXISTS `supporting_elderly`;
CREATE TABLE `supporting_elderly` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `tax_credit` double DEFAULT NULL,
  `elderly_name` varchar(45) DEFAULT NULL,
  `kinship` varchar(45) DEFAULT NULL,
  `elderly_children_num` int(11) DEFAULT NULL,
  `prorate` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `tax_month` datetime DEFAULT NULL,
  `elderly_id_card_number` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supporting_elderly
-- ----------------------------
INSERT INTO `supporting_elderly` VALUES ('2', 'T11', '0', 'dsd', '父亲', '2', '50', '2018-12-13 23:56:25', '2018-12-13 23:56:25', null, '2018-11-30 10:00:00', '110101191803079077');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `alias` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `is_only_child` tinyint(4) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `department_code` varchar(45) DEFAULT NULL,
  `user_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1556 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

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
INSERT INTO `user` VALUES ('951', '700', '黄来', 'Hans.Huang', '15827027405', 'IT部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWW3FfuMUQ24uKrTY9FIFMJOmCEkS4ecq08ANAckjtqg/', null, null, null, null, '10', 'WM00038');
INSERT INTO `user` VALUES ('952', '701', '汪盼', 'Viola.Wang', '18569509515', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTRWOKZe4otrxvqjQjfR9v1z4lzZgeG98lVz7PiaC1wNdg/', null, null, null, null, '4', 'T04829');
INSERT INTO `user` VALUES ('953', '702', '林木森', 'Morison.Lin', '13199412116', '技术部门', '', null, null, null, null, '4', 'T04828');
INSERT INTO `user` VALUES ('954', '703', '陈俊帆', 'Knight.Chen', '18893702586', '技术部门', 'http://p.qlogo.cn/bizmail/yrhHicN3yiaIgnGpBBgib6rLgBljaIkTszvZmuAQg2MbJtOD8qFsmarxA/0', null, null, null, null, '4', 'T04843');
INSERT INTO `user` VALUES ('955', '704', '张智', 'Dylan.Zhang', '17805058330', '技术部门', 'http://p.qlogo.cn/bizmail/vwQZic2OUocpsvrlAaQ5hWU2icvPBfKoQkIQjTicJPNkYgyPKjckeZ2vQ/0', null, null, null, null, '4', 'T04857');
INSERT INTO `user` VALUES ('956', '705', '周逸颖', 'Sylvia.Zhou', '15317935241', '技术部门', 'https://p.qlogo.cn/bizmail/orUk3HRtPQCygl2CDkvNoRpuicbK6ADCvjy1DxmI0VFDee82GMicVQuQ/0', null, null, null, null, '4', 'T04858');
INSERT INTO `user` VALUES ('957', '706', '金玉灵清', 'Gwen.Jin', '13905520728', '技术部门', 'http://p.qlogo.cn/bizmail/aU3NG1tLeqVaOcHghWwoNX6EZDwKMkyH7ypfFxIdV5EIeKURlNJlYg/0', null, null, null, null, '4', 'T04835');
INSERT INTO `user` VALUES ('958', '707', '张壮壮', 'Zack.Zhang', '18115300769', '技术部门', 'http://p.qlogo.cn/bizmail/9UlUZia2JMLdlVKtxPjiahwaak4Zrr0REnHkQPasrnZO2NOtdaU1ux7A/0', null, null, null, null, '4', 'T04856');
INSERT INTO `user` VALUES ('959', '708', '王金一', 'Lukas.Wang', '18621310874', '技术部门', 'http://p.qlogo.cn/bizmail/p6g2GZ5bsXPvHURbYB3SCBmfA05hdc3Qq8Nzul2OkWKbtFXJmMVNuQ/0', null, null, null, null, '4', 'T04834');
INSERT INTO `user` VALUES ('960', '709', '廖丹', 'Kyra.Liao', '13541077267', '技术部门', 'http://p.qlogo.cn/bizmail/QQ86x9sd2a8pTEs97TqibjnHdqpFxLXmibia7EQSQic8rrmiccPOqB0kqkQ/0', null, null, null, null, '4', 'T04833');
INSERT INTO `user` VALUES ('961', '710', '石晋', 'Mars.Shi', '17805058411', '技术部门', 'http://p.qlogo.cn/bizmail/uPey904IciaEEFrF2bbEBrnZ7b5lvIyxzwHNiaKWmOeT626Oicm5VaPZA/0', null, null, null, null, '4', 'T04855');
INSERT INTO `user` VALUES ('962', '711', '周星火', 'Klein.Zhou', '18071256480', '技术部门', 'http://p.qlogo.cn/bizmail/4qAUmxnYU9jVHgzdUGRvuiaECkg4a18y50uE7h6iaN1tibz8eb1aZibRnQ/', null, null, null, null, '4', 'T04839');
INSERT INTO `user` VALUES ('963', '712', '任艳', 'Yvonne.Ren', '16651082336', '技术部门', 'http://p.qlogo.cn/bizmail/sMvE05QNv9ia0yaV3JYWianmMoEmOOBN8T2ZcSgLLmDLstGdic0EtsOYg/0', null, null, null, null, '4', 'T04837');
INSERT INTO `user` VALUES ('964', '713', '唐明琳', 'Timothy.Tang', '18556749724', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSibwe5RicXbSouQ3SZmX5Cv7kwcibeICicRaPdDjHqZibzqEw/', null, null, null, null, '4', 'T04850');
INSERT INTO `user` VALUES ('965', '714', '胡燕', 'Cassie.Hu', '18549916411', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSibwe5RicXbSouQ3SZmX5Cv7TcBNicshmA6xPW5TPyickjow/', null, null, null, null, '4', 'T04854');
INSERT INTO `user` VALUES ('966', '715', '颜家衡', 'Able.Yan', '18506171245', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSibwe5RicXbSouQ3SZmX5Cv7UIDSjohqEyUoVvgRegI9CQ/', null, null, null, null, '4', 'T04853');
INSERT INTO `user` VALUES ('967', '716', '祁琪', 'Kayla.Qi', '14752558213', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGROrQ8MJ98Rm4Yfkr9xYTX1N4wC28FTAMs2NrFccQKqWw/', null, null, null, null, '4', 'T04851');
INSERT INTO `user` VALUES ('968', '717', '吴佳敏', 'Yolanda.Wu', '', '技术部门', 'http://p.qlogo.cn/bizmail/wr95tXbNa9SjlkSbudmUZRBicYPdhlibIVDcuF9Xkpic0VyrR9MP52uBw/0', null, null, null, null, '4', 'T04845');
INSERT INTO `user` VALUES ('969', '718', '李晶', 'Tasha.Li', '', '技术部门', 'http://p.qlogo.cn/bizmail/WPYjJY8e8gAs4iclRfGiaBqohw5Y716v7yjxEkp5NoQyZgzGFf0R26bA/0', null, null, null, null, '4', 'T04844');
INSERT INTO `user` VALUES ('970', '719', '陈佩佩', 'Paulina.Chen', '18670330145', '技术部门', 'http://p.qlogo.cn/bizmail/Od8hmWpqJRlUq9YOZz4LaPpyiapI3SGqIqWaZCgg0VIOLT5oPFLb1qA/0', null, null, null, null, '9', 'WT01486');
INSERT INTO `user` VALUES ('971', '720', '肖静轩', 'Sean.Xiao', '', '技术部门', 'http://p.qlogo.cn/bizmail/a8NO0Ql007xzK90XAPyt3QygvtBUiccxcr6Fia3VeZ694YYHBeWkR8gA/0', null, null, null, null, '9', 'WT01482');
INSERT INTO `user` VALUES ('972', '600', '邓云峰', 'Albert.Deng', '18797573177', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicticj1MiawCK8lRibAAyyFEpJw/', null, null, null, null, '4', 'T04737');
INSERT INTO `user` VALUES ('973', '721', '陆春梦', 'Chloe.Lu', '18152734630', '技术部门', 'http://p.qlogo.cn/bizmail/KH5yR3d817BEAiafcCezkZZMMFKMDWPWDrUUicppaRJmqicbl3DfdF64Q/', null, null, null, null, '9', 'WT01484');
INSERT INTO `user` VALUES ('974', '601', '张泽旭', 'Marcus.Zhang', '15897354720', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicwYSXXlda59U8bMC3Mlf9tQ/', null, null, null, null, '4', 'T04736');
INSERT INTO `user` VALUES ('975', '722', '周赛君', 'Sharon.Zhou', '18373002441', '技术部门', 'http://p.qlogo.cn/bizmail/ccs65wWLETpFIRdMf57ibLtjsZLXN8wpJbKln9oz9a74666cSc4WkKA/', null, null, null, null, '9', 'WT01483');
INSERT INTO `user` VALUES ('976', '602', '樊艳宏', 'Fannie.Fan', '17321125506', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTibKwzSSia3o9xKjmTXRGIatdEZN2nuVL9tRxkpwvVuPAg/', null, null, null, null, '4', 'T04739');
INSERT INTO `user` VALUES ('977', '723', '吴豪', 'Winston.Wu', '', '技术部门', 'http://p.qlogo.cn/bizmail/XW3m4icNEEt9hUt0hhR1r1qZhpFz9HFnZLNDY3a7vOtMrksricQl4YGA/0', null, null, null, null, '9', 'WT01487');
INSERT INTO `user` VALUES ('978', '603', '卞瑶', 'Jennifer.Bian', '18362828726', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTWXP7na28TkCjvvzuGKOhzF3c9AgZXHD9OwZeU0rrOSA/', null, null, null, null, '6', 'M00180');
INSERT INTO `user` VALUES ('979', '724', '黄晶晶', 'Victor.Huang', '15773114189', '技术部门', 'http://p.qlogo.cn/bizmail/EmWaB2NjUibqqhRLxw4libJljA5DDnjWZfmEnBtAK621zia2iaTCxKXTGw/', null, null, null, null, '9', 'WT01488');
INSERT INTO `user` VALUES ('980', '604', '付长宽', 'Ben.Fu', '15290800501', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTj0DBGyYUFM7Ws8B3K7qB0P1yNtVFfPxXQsNVEwqnr5w/', null, null, null, null, '4', 'YT00728');
INSERT INTO `user` VALUES ('981', '725', '王鹏', 'Pierce.Wang', '18473481706', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRic1fYKlsLAFNZXxWIshVWNiacJMv8K3E9RByMKaXDYzEQ/', null, null, null, null, '9', 'WT01489');
INSERT INTO `user` VALUES ('982', '605', '向奥', 'Elmer.Xiang', '15629189451', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgJGymIE09OiaAg7k7N2pQVxg/', null, null, null, null, '9', 'WT01373');
INSERT INTO `user` VALUES ('983', '726', '曹维', 'Matt.Cao', '17671469026', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRic1fYKlsLAFNZXxWIshVWN5YS25ic9rtL01BpiaOCQN2Kg/', null, null, null, null, '9', 'WT01523');
INSERT INTO `user` VALUES ('984', '606', '项一繁', 'Gavin.Xiang', '18206296913', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHic8z45LZpuxH8xyHB4ay4jYg/', null, null, null, null, '4', 'YT00744');
INSERT INTO `user` VALUES ('985', '727', '金欢', 'Barry.Jin', '13545428730', '技术部门', 'http://p.qlogo.cn/bizmail/y32ZHkzEGdfWKibS8gVumicgwN0ia7sf0CrbtHyRgsbkOrKboeulPTYJw/', null, null, null, null, '9', 'WT01522');
INSERT INTO `user` VALUES ('986', '607', '朱伟杰', 'Bruce.Zhu', '18360939488', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicfMvn2yQ95ev4TlPv7f1sOA/', null, null, null, null, '4', 'YT00746');
INSERT INTO `user` VALUES ('987', '728', '刘青梅', 'Monica.Liu', '15773192439', '技术部门', 'http://p.qlogo.cn/bizmail/9ELMDia4DEMMlAjGAOsjHvg7Xk1hx21RoKziaZ9Woia5dpgibr0XNSiaXTw/0', null, null, null, null, '9', 'WT01481');
INSERT INTO `user` VALUES ('988', '608', '孙红卒', 'Bess.Sun', '13618629984', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicCABZKWxDgQKpOy4cS4kCGg/', null, null, null, null, '9', 'WT01374');
INSERT INTO `user` VALUES ('989', '729', '李勇', 'Bob.Li', '18827138303', '技术部门', '', null, null, null, null, '9', 'WT01493');
INSERT INTO `user` VALUES ('990', '609', '卜亚男', 'Yanina.Bu', '17865922021', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicP6m2S5AFROm5cuGfD4oh3Q/', null, null, null, null, '4', 'YT00740');
INSERT INTO `user` VALUES ('991', '730', '石雄飞', 'Gibson.Shi', '', '技术部门', 'http://p.qlogo.cn/bizmail/dmfAlhPyEH1S9DvQFUHLZdmM92LOT1WPgeqylV4cNl2txWrt16R9LA/0', null, null, null, null, '9', 'WT01496');
INSERT INTO `user` VALUES ('992', '610', '苏纯', 'Randy.Su', '17673485272', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicWDLmdXiaJdjicSglsdLEYj0w/', null, null, null, null, '9', 'WT01377');
INSERT INTO `user` VALUES ('993', '731', '何涛', 'Terence.He', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRic1fYKlsLAFNZXxWIshVWNgWzSraxrgUYQZh6KMJp2eA/', null, null, null, null, '9', 'WT01492');
INSERT INTO `user` VALUES ('994', '611', '柏健皓', 'Jonathan.Bai', '15721527875', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgLNALcg2umZ7wdXArMKu2hw/', null, null, null, null, '4', 'T04751');
INSERT INTO `user` VALUES ('995', '732', '张丹', 'Bunny.Zhang', '15927964940', '技术部门', 'http://p.qlogo.cn/bizmail/FsPicmSMZPjcVReQXpaVMnyIknkLxVQT5kxQCHJF2rL6qWOowYTCeKw/0', null, null, null, null, '9', 'WT01500');
INSERT INTO `user` VALUES ('996', '612', '徐云静', 'Lily.Xu', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTibKwzSSia3o9xKjmTXRGIatenAj4SfKD64njxRr9ibBCEQ/', null, null, null, null, '9', 'WT01414');
INSERT INTO `user` VALUES ('997', '733', '郑清顺', 'Ronald.Zheng', '15527097203', '技术部门', 'https://p.qlogo.cn/bizmail/Deq3bJorKTdOIDNULv0LP652F2RFzibia8onz98xibEMFe5UHwicWbp4QA/0', null, null, null, null, '9', 'WT01501');
INSERT INTO `user` VALUES ('998', '613', '顾家琦', 'Archy.Gu', '18351923353', '技术部门', 'http://p.qlogo.cn/bizmail/41jXo5FWNrI8CW5DUibnNWU5BeE9wwJNfNRy7ujFFFImskSyyRJGfgQ/0', null, null, null, null, '4', 'T04755');
INSERT INTO `user` VALUES ('999', '734', '李书福', 'Miles.Li', '15027008648', '技术部门', 'http://p.qlogo.cn/bizmail/JliaPCzNrNDY499zGHgHzGW5ibQ1YkiagDNEN88JlxHOZqRGiaRnb98Q2Q/', null, null, null, null, '9', 'WT01468');
INSERT INTO `user` VALUES ('1000', '614', '张齐', 'Zach.Zhang', '18710858996', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHic22AFLN1A7UCg088fSMJTicQ/', null, null, null, null, '4', 'T04747');
INSERT INTO `user` VALUES ('1001', '735', '任义', 'Kyrie.Ren', '18681523275', '技术部门', 'http://p.qlogo.cn/bizmail/R9A4UleVRENWs3JRwvAKHqHaV9cbLuQDQY8msqtXhbE2EqY6adPAAg/0', null, null, null, null, '9', 'WT01469');
INSERT INTO `user` VALUES ('1002', '615', '梁楚柠', 'James.Liang', '17601226632', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQJso4QnTQhA0x8Gpqauma20KibPyr48WcCjibMfTRjFcPg/', null, null, null, null, '4', 'T04745');
INSERT INTO `user` VALUES ('1003', '736', '欧阳文锦', 'Jim.Ouyang', '', '技术部门', 'http://p.qlogo.cn/bizmail/d5TR8sjdNEH8nZn1b16P3WEoWicqrgibwx051GT49KJ0JwX56wKROibpQ/0', null, null, null, null, '9', 'WT01502');
INSERT INTO `user` VALUES ('1004', '616', '袁梓', 'Drew.Yuan', '15397924388', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgU5NO4ictyibBkpgcOEDRk6XQ/', null, null, null, null, '4', 'YT00737');
INSERT INTO `user` VALUES ('1005', '737', '杨武军', 'Carlson.Yang', '15907193783', '技术部门', 'http://p.qlogo.cn/bizmail/ibRmADFSvGwjJ06VAg0EklHk0weD8QsE7VibJ5YYzJBVwZzU1ZO2pSqg/0', null, null, null, null, '9', 'WT01503');
INSERT INTO `user` VALUES ('1006', '617', '黄斌淦', 'Berg.Huang', '17621628969', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGT1rmZDJrfUAgqSY2q0DJC9X7e3aYXct5icUiaJH40KOg0w/', null, null, null, null, '4', 'T04746');
INSERT INTO `user` VALUES ('1007', '738', '叶聪', 'Sun.Ye', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRic1fYKlsLAFNZXxWIshVWNhNuUxWKpIZCkDx1PO3VoHQ/', null, null, null, null, '9', 'WT01505');
INSERT INTO `user` VALUES ('1008', '618', '周猛', 'George.Zhou', '18206296760', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHichz0I9GHacsEDo3YxRFic3RQ/', null, null, null, null, '4', 'YT00738');
INSERT INTO `user` VALUES ('1009', '739', '刘逸凡', 'Louis.Liu', '', '技术部门', 'http://p.qlogo.cn/bizmail/ngkZvCa8PlUCUTiaZxxycgWo2YF7f2S3d7xysnfusxQgefaQZ5H3Zmw/0', null, null, null, null, '9', 'WT01504');
INSERT INTO `user` VALUES ('1010', '619', '孙鑫', 'Sylvia.Sun', '13027722030', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQqLDibic3OeFiadBwjrX84pQdgq4aZwPkib5LSc4qBkZ4F2w/', null, null, null, null, '4', 'T04762');
INSERT INTO `user` VALUES ('1011', '740', '李贺林', 'Alex.Li', '15515745057', '技术部门', 'http://p.qlogo.cn/bizmail/vFUO1cpBBROK1GQa0MWESicfP3h90vMlm0u8Y62djXUd0NNn7QYKu2w/', null, null, null, null, '9', 'WT01507');
INSERT INTO `user` VALUES ('1012', '620', '黄迪', 'Eudora.Huang', '15938776510', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgpk7adtQibm9u8pySCJ0ic4PQ/', null, null, null, null, '4', 'T04761');
INSERT INTO `user` VALUES ('1013', '741', '刘振', 'Lester.Liu', '13129930683', '技术部门', 'https://p.qlogo.cn/bizmail/I8f3XYpUFjSEMLlLxGGhLLfTA6hX8ZkTCnwqp5Y6ibDgUmK6omto2iaA/0', null, null, null, null, '9', 'WT01506');
INSERT INTO `user` VALUES ('1014', '500', '康袁俊', 'Angelia.Kang', '15601896976', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjqd5tUHSTQhWkDISChqQibTA/', null, null, null, null, '4', 'YT00021');
INSERT INTO `user` VALUES ('1015', '621', '郑云飞', 'Dylan.Zheng', '18838988286', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQV4KPCHUY8paWbu0xxKma6zhJDxZgyo3b1wzN0lPVj8Q/', null, null, null, null, '4', 'T04760');
INSERT INTO `user` VALUES ('1016', '742', '沈佳辉', 'Stewart.Shen', '15623917841', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRom3quwNiaWQ99ziajib76dnc8jKnvgWoV3v98jDd9t7Ocg/', null, null, null, null, '9', 'WT01472');
INSERT INTO `user` VALUES ('1017', '501', '李东杰', 'Sean.Li', '13072105015', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYvlPlHDLUEialOv7fBTL6dicw/', null, null, null, null, '4', 'YT00038');
INSERT INTO `user` VALUES ('1018', '622', '许萌', 'Kitty.Xu', '17853753754', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQiambFBMest9lGH2ustQcibDicp7CiaUK8UNuUCZ1o6Ys8rA/', null, null, null, null, '4', 'T04766');
INSERT INTO `user` VALUES ('1019', '743', '耿智', 'Kevin.Geng', '13789923757', '技术部门', 'http://p.qlogo.cn/bizmail/VcfZ3N4jJexTBGDJHdbyxrjXIcV2CLUlSoichHIWiaiamDT3R44sUCzibQ/', null, null, null, null, '9', 'WT01473');
INSERT INTO `user` VALUES ('1020', '502', '李明慧', 'Nicole.Li', '13162932289', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQGP0ibLd1GNNBjGGSM8zmRkydnkaUFtALFfGUWNWCXxiaw/', null, null, null, null, '4', 'YT00040');
INSERT INTO `user` VALUES ('1021', '623', '廖惊涛', 'Kyle.Liao', '17865193992', '技术部门', 'http://p.qlogo.cn/bizmail/asX0NiabSZTc41EfJOG8ja5JKaw3O1cHeQ3xbd3SCMl4k7XOPxdAUlA/0', null, null, null, null, '4', 'T04764');
INSERT INTO `user` VALUES ('1022', '744', '刘皓', 'Glenn.Liu', '', '技术部门', 'http://p.qlogo.cn/bizmail/QGlQmibAu3D6ehLVNmSufOf6v3x6TibR7GHiaiaWarsCxib8mYAjs7iaTCAw/0', null, null, null, null, '9', 'WT01475');
INSERT INTO `user` VALUES ('1023', '503', '施薇', 'Vivian.Shi', '13917154520', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTzPCKoGMu5c1iaicmXKgicBaVP88CoiaO1EMvaOJStJjGe3Q/', null, null, null, null, '4', 'YT00041');
INSERT INTO `user` VALUES ('1024', '624', '游亚晔', 'Emma.You', '17521560244', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHiczmuOickYcM62Wyw2BVlnp6A/', null, null, null, null, '4', 'T04758');
INSERT INTO `user` VALUES ('1025', '745', '金新子', 'Harvey.Jin', '', '技术部门', 'http://p.qlogo.cn/bizmail/ZA8aiazvvh7k7b6DJQfQ77Lrl7tI1RzohlicofGTncZPy3MiaInh1sKkQ/0', null, null, null, null, '9', 'WT01476');
INSERT INTO `user` VALUES ('1026', '504', '张博昊', 'Henry.Zhang', '18516029437', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjVibU5uAbrljEjJUzGp9f9SA/', null, null, null, null, '4', 'YT00065');
INSERT INTO `user` VALUES ('1027', '625', '周旭', 'Eden.Zhou', '14782825634', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicobb79hlEaeLhQ8fMiczzJgw/', null, null, null, null, '4', 'T04770');
INSERT INTO `user` VALUES ('1028', '746', '季承祥', 'Marty.Ji', '', '技术部门', 'http://p.qlogo.cn/bizmail/DdJS5AxTcGibyU2HzcL0DgzvuPuaDbhVJiaXdpzKZ3LN2bVBS9cWytYw/0', null, null, null, null, '9', 'WT01477');
INSERT INTO `user` VALUES ('1029', '505', '卫佳成', 'Anton.Wei', '18616935935', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQbibWm1VbibopwbSmlzR4N3qkaSxSRSJctibRyy8lwvO1gA/', null, null, null, null, '4', 'YT00074');
INSERT INTO `user` VALUES ('1030', '626', '杨绍彬', 'Clark.Yang', '15027184829', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicZpMNZ4PaqpaMYOicSKqiasVQ/', null, null, null, null, '9', 'WT01393');
INSERT INTO `user` VALUES ('1031', '747', '胡向阳', 'Dave.Hu', '18538777565', '技术部门', 'http://p.qlogo.cn/bizmail/zw3HwVGDvjTSsqChse8szmxkXEibsMRBAnF3laWx0ADhpjPsolB3PrQ/0', null, null, null, null, '9', 'WT01510');
INSERT INTO `user` VALUES ('1032', '506', '李永伟', 'Joe.Li', '15527062450', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRl6qBhvBCQfvLIO57AodZ0bbrSbChbtuH5GqMBDKz50A/', null, null, null, null, '9', 'YT00080');
INSERT INTO `user` VALUES ('1033', '627', '祝燕', 'Joyce.Zhu', '18979034097', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgL7w1YausHxlSA32sU3sMEA/', null, null, null, null, '4', 'T04774');
INSERT INTO `user` VALUES ('1034', '748', '陈孟飞', 'Andy.Chen', '13253627906', '技术部门', 'http://p.qlogo.cn/bizmail/Q3dq7BCRNLgnRzwNL0r4xTPlicafC9w91Fp935MjGFicgiacrtISkyIYA/0', null, null, null, null, '9', 'WT01511');
INSERT INTO `user` VALUES ('1035', '507', '冯丽', 'Lilian.Feng', '18301783689', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQtwHoicvl5x7xvKz2QNibIrib4sJCE5kkeHtWAdwb4bMf0A/', null, null, null, null, '4', 'YT00101');
INSERT INTO `user` VALUES ('1036', '628', '杨妞妞', 'Beth.Yang', '15136413315', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgPyFmCRGbDJ6tzOGm9GYHbA/', null, null, null, null, '4', 'T04779');
INSERT INTO `user` VALUES ('1037', '749', '吕佳莹', 'Yilia.Lv', '', '技术部门', 'http://p.qlogo.cn/bizmail/pKlm7UvfStVITxBgghqAzt6cAibIq7T4k5ianeXeORR1icRBJLCf5tjdw/', null, null, null, null, '9', 'WT01512');
INSERT INTO `user` VALUES ('1038', '508', '姬俊周', 'Vergil.Ji', '15921693039', '技术部门', 'http://p.qlogo.cn/bizmail/eQD0ubiasj47xibGzeIIvIZs52WDRssjSuyPtTLBbzON6AB64yAiafAZQ/0', null, null, null, null, '4', 'YT00130');
INSERT INTO `user` VALUES ('1039', '629', '程味', 'Kimi.Cheng', '13671752082', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQv6qPkrqae4Joic2kicbiaia9MBchuIsiaA0iau9KBUQIu3wPQ/', null, null, null, null, '4', 'T04790');
INSERT INTO `user` VALUES ('1040', '509', '黄俊辉', 'Jason.Huang', '15226014783', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQGP0ibLd1GNNBjGGSM8zmRkXdsK78LsvObTzFr4KwSSwQ/', null, null, null, null, '4', 'YT00177');
INSERT INTO `user` VALUES ('1041', '750', '李东泽', 'Leon.Li', '15638518069', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRic1fYKlsLAFNZXxWIshVWNZfJse3bsyIl2WicZy4zOsdw/', null, null, null, null, '9', 'WT01514');
INSERT INTO `user` VALUES ('1042', '630', '张鸣', 'Viola.Zhang', '18271402348', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTibKwzSSia3o9xKjmTXRGIatCziaMvpDNlcrqyzaribxnb2g/', null, null, null, null, '9', 'WT01418');
INSERT INTO `user` VALUES ('1043', '751', '刘家林', 'Otto.Liu', '', '技术部门', 'http://p.qlogo.cn/bizmail/eTOYT6DqcLEnMxibOlHfbDlVgjdibbHfiaFow2vzg6h9o53r7q3ordWxA/0', null, null, null, null, '9', 'WT01515');
INSERT INTO `user` VALUES ('1044', '510', '王芸芸', 'Yvonne.Wang', '15000963049', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa182jPxicK5gfRVzchOrNPg7w/', null, null, null, null, '4', 'YT00219');
INSERT INTO `user` VALUES ('1045', '631', '王柏森', 'Sam.Wang', '17602155193', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRr4ygNq5HsziaJibuHKQCTwBSHic98bjKCZQtib5O0bCa8pQ/', null, null, null, null, '4', 'T04788');
INSERT INTO `user` VALUES ('1046', '752', '杨高凯', 'Kane.Yang', '15670368385', '技术部门', 'http://p.qlogo.cn/bizmail/zR1HB1USErmLwsCRf4iaYkWQa4pwjQ6Ldr04Pkp5OBq6qiaKbDmB19dw/0', null, null, null, null, '9', 'WT01516');
INSERT INTO `user` VALUES ('1047', '511', '闵海鑫', 'Hansen.Min', '18663600625', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRO60Gs8IIibnibO4BKzErlJXwTfLia6k6KQ8rBMCGuN7ptA/', null, null, null, null, '4', 'YT00224');
INSERT INTO `user` VALUES ('1048', '632', '王振宇', 'Edison.Wang', '13186571579', '技术部门', 'http://p.qlogo.cn/bizmail/9jLLFeLBWwkPueJLoqGE3M6rWkIic6icKHlS5x6jnf8CicK6pOumt0xeQ/0', null, null, null, null, '4', 'T04791');
INSERT INTO `user` VALUES ('1049', '753', '张小双', 'Icey.Zhang', '15717233601', '技术部门', 'https://p.qlogo.cn/bizmail/L9loxwwLJq49jsp4DMlaPd17vnzC0hgePWqPhLI1wP2P1YjIu23Xpg/0', null, null, null, null, '9', 'WT01526');
INSERT INTO `user` VALUES ('1050', '512', '王宁博', 'Jamie.Wang', '15121034389', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhK33kk5psDfn0sLIcUFnTQAA/', null, null, null, null, '4', 'YT00237');
INSERT INTO `user` VALUES ('1051', '633', '王超全', 'Luke.Wang', '17621629634', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSj3T5L9hZLCQsMUyJxkugXP0ia1aMiax4Knr6K7xXA8Ovg/', null, null, null, null, '4', 'YT00757');
INSERT INTO `user` VALUES ('1052', '754', '张朵', 'Estelle.Zhang', '18437927335', '技术部门', 'http://p.qlogo.cn/bizmail/DtgHlNj4syiaibb587fkgojCxFnic2qbkjBkh46ZAUeUvqsJUbQ1d70sw/', null, null, null, null, '9', 'WT01530');
INSERT INTO `user` VALUES ('1053', '513', '刘晓萌', 'Eileen.Liu', '13120687613', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkj18xFqW7cqHiaBiaG8HWyjpNQ/', null, null, null, null, '4', 'YT00247');
INSERT INTO `user` VALUES ('1054', '634', '吴焰峰', 'Albert.Wu', '18301738154', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQshcgQkyvDEBNxPBCiaFDm73BOxEzp6AEPU9IslCv1U2A/', null, null, null, null, '4', 'YT00770');
INSERT INTO `user` VALUES ('1055', '755', '翟瑆', 'Crane.Zhai', '18986389668', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSeib3Yfypek49iaicPfCmxkicqEWpUbasqhV3rEf27ngibFzg/', null, null, null, null, '9', 'WT01532');
INSERT INTO `user` VALUES ('1056', '514', '彭保庆', 'Oscar.Peng', '18621116863', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfOdBibMlySfKTK2KwTmGJCGw/', null, null, null, null, '4', 'YT00266');
INSERT INTO `user` VALUES ('1057', '635', '凌鉴析', 'Jesse.Ling', '', '技术部门', 'http://p.qlogo.cn/bizmail/0IHwCSSa3L0auPuh7THiaKTlunTjvzUszNaQO58u2fzSFV8AEBXesIg/0', null, null, null, null, '4', 'YT00762');
INSERT INTO `user` VALUES ('1058', '756', '渠渊惠', 'Jack.Qu', '15827171665', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRic1fYKlsLAFNZXxWIshVWNX50RYKFbYlch2A3JYuLVbA/', null, null, null, null, '9', 'WT01531');
INSERT INTO `user` VALUES ('1059', '515', '张丽琴', 'Lucy.Zhang', '13764666721', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTiaJOo4hENibUu0fuOBUPgjXnK1VTSBN1vEn0JDUbzGeHA/', null, null, null, null, '4', 'YT00328');
INSERT INTO `user` VALUES ('1060', '636', '李跃祖', 'Cooper.Li', '17521550121', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTglEn0517KxhINGAibDiczxeGu1aGS0vUWZQp3BjYTTIMQ/', null, null, null, null, '4', 'YT00769');
INSERT INTO `user` VALUES ('1061', '757', '张晨', 'Alina.Zhang', '', '技术部门', 'http://p.qlogo.cn/bizmail/6lrDKI45NjG0Aal2UhTzZ9yYuFq6k2KjShVjMAialOF0p2icm2CHcRqg/0', null, null, null, null, '9', 'WT01525');
INSERT INTO `user` VALUES ('1062', '516', '李鹏', 'Vic.Li', '18739974753', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1ZSPbSUfr0B0piacxdsddWAQ/', null, null, null, null, '4', 'YT00329');
INSERT INTO `user` VALUES ('1063', '637', '卞泽阳', 'Nestor.Bian', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQshcgQkyvDEBNxPBCiaFDm7GLO1tPTrSZ6icVe2RftiaRYw/', null, null, null, null, '4', 'YT00767');
INSERT INTO `user` VALUES ('1064', '758', '葛小伟', 'Jerome.Ge', '13681669479', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTBqXpgfzb970ohD7dXWxu2iauVwoibYkahNrc0ibA5cGePQ/', null, null, null, null, '4', 'M00127');
INSERT INTO `user` VALUES ('1065', '517', '袁治鹏', 'Bruce.Yuan', '13017533238', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTiaJOo4hENibUu0fuOBUPgjXmaIHCqLfoZFCWp7RCsHxVg/', null, null, null, null, '4', 'YT00332');
INSERT INTO `user` VALUES ('1066', '638', '李帅', 'Wade.Li', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQxGpTE04G3G1vny0jHicZpnMDwrkJLnRrj5bOiaW8d1WFA/', null, null, null, null, '4', 'YT00763');
INSERT INTO `user` VALUES ('1067', '759', '王其峰', 'Alexander.Wang', '18016049555', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS9PVicyQJjvtEOXic2VfS1WDYTw2g5kISDARvj1G1w6hCg/', null, null, null, null, '4', 'T00141');
INSERT INTO `user` VALUES ('1068', '518', '肖伟前', 'Lewis.Xiao', '13127913279', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQ17nuvAq1ibGmYK9ficyty11frHNCuia4LIJw3k6cQhtUkg/', null, null, null, null, '4', 'YT00336');
INSERT INTO `user` VALUES ('1069', '639', '栾静', 'Eunice.Luan', '18201867934', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQiambFBMest9lGH2ustQcibD9HzIx0vtPyTbrRIUrQKrTQ/', null, null, null, null, '4', 'T04795');
INSERT INTO `user` VALUES ('1070', '519', '任仲洋', 'Jimmie.Ren', '15601789348', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKWhgPmQNNh2TFDgEPlbn7zA/', null, null, null, null, '4', 'YT00361');
INSERT INTO `user` VALUES ('1071', '760', '强伟哲', 'Roger.Qiang', '13917780017', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsNwVgCBgGvfn4IGzrb5VyQpjGxfJDvT4uPcJuTGAjQA/', null, null, null, null, '4', 'T00699');
INSERT INTO `user` VALUES ('1072', '640', '冀伊林', 'Irene.Ji', '18621844350', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSlScibC40zoHibpNH5AoqNxHf9k225JgicSflKhgH0LKsow/', null, null, null, null, '4', 'T04794');
INSERT INTO `user` VALUES ('1073', '761', '俞庄谐', 'Fisher.Yu', '15901928214', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa105SVBL59sFzcRdhbW7byGw/', null, null, null, null, '4', 'T03583');
INSERT INTO `user` VALUES ('1074', '520', '张璇晨', 'Sara.Zhang', '18721051845', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKtCzOFfmLdKt2CDBSnpCb6g/', null, null, null, null, '4', 'YT00372');
INSERT INTO `user` VALUES ('1075', '641', '吴文秋', 'Camille.Wu', '17621972473', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS5ceouD9EsjYWDzcfryNE3TbjR0LVufuClhiaPV7fVvDA/', null, null, null, null, '4', 'YT00760');
INSERT INTO `user` VALUES ('1076', '762', '李娜娜', 'Selena.Li', '13162418851', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfIN8kfTfLyYpTnSRTCFnJeA/', null, null, null, null, '4', 'T04482');
INSERT INTO `user` VALUES ('1077', '400', '黄甜', 'Mandy.Huang', '13207135263', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0aEsdIq3kYcoWDCU2QeOjhA/', null, null, null, null, '9', 'WT00413');
INSERT INTO `user` VALUES ('1078', '521', '司晓阳', 'Fred.Si', '18516327086', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRO60Gs8IIibnibO4BKzErlJXkn4Z5k1ytKOq8icPMN5fcbw/', null, null, null, null, '4', 'YT00374');
INSERT INTO `user` VALUES ('1079', '642', '袁东燕', 'Yolanda.Yuan', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsw9EY0MjjR6Bu9KIHib4icXHWAF1cA4kAwh5jJ2ODlZ7Q/', null, null, null, null, '4', 'T04799');
INSERT INTO `user` VALUES ('1080', '763', '董亚璐', 'Belinda.Dong', '15753031128', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYGhC5qvFCMFw8VWC1J6ibsjA/', null, null, null, null, '4', 'T04607');
INSERT INTO `user` VALUES ('1081', '401', '蔡欢', 'Elinor.Cai', '18907111551', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XXTPcqJryvMricbKxUSMXnkA/', null, null, null, null, '9', 'WT00419');
INSERT INTO `user` VALUES ('1082', '522', '沈泽宇', 'Charles.Shen', '15397082409', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQHJQ6ib20DR6w4HwDdB50VEYTuSrDBoficaIDVLOYkIt5Q/', null, null, null, null, '4', 'YT00382');
INSERT INTO `user` VALUES ('1083', '643', '赵允梅', 'Alina.Zhao', '17521088092', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgTFJzMWWwnDibHclbjbWXOwg/', null, null, null, null, '4', 'YT00759');
INSERT INTO `user` VALUES ('1084', '764', '赵琪雯', 'Ofelia.Zhao', '13818990389', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYSLPjibtve4jibLbo3NRxjRRw/', null, null, null, null, '4', 'T04612');
INSERT INTO `user` VALUES ('1085', '402', '王同林', 'Toby.Wang', '18771120411', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMz2CrJhHfFYkFk3I3dERicUrq609Zm2Pe2fPcDIMa4qQ/', null, null, null, null, '9', 'WT00425');
INSERT INTO `user` VALUES ('1086', '523', '苏晓春', 'Edwin.Su', '13917079020', '技术部门', 'http://p.qlogo.cn/bizmail/OtLQVric3T8WKqcsoZYdJopIjh4jpygMsntMLbAJdV6vm4gZsN5Y9lw/0', null, null, null, null, '4', 'YT00406');
INSERT INTO `user` VALUES ('1087', '644', '尹英霞', 'Sheena.Yin', '13419676109', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSZbWb7lnzF0LibLPT998QYQ4OcG3xlvAoApZd8qxMTXIg/', null, null, null, null, '9', 'WT01419');
INSERT INTO `user` VALUES ('1088', '765', '李宪峰', 'Allen.Li', '18616916203', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYmwz6xFmt7m2YyvyLZncGNQ/', null, null, null, null, '4', 'T04651');
INSERT INTO `user` VALUES ('1089', '403', '陈召富', 'David.Chen', '18086066493', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOokAphnODtWfvOcaozVh4rYw/', null, null, null, null, '9', 'WT00456');
INSERT INTO `user` VALUES ('1090', '524', '高源', 'Vicky.Gao', '15900552956', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRt88CuILqvcJx998va1304iaajBaPy1czC6PXJD2xXtUw/', null, null, null, null, '4', 'YT00411');
INSERT INTO `user` VALUES ('1091', '645', '黄宏发', 'Felix.Huang', '18616808914', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jkUyumzzzjib6TJRgs1hPVwSA/', null, null, null, null, '4', 'YT00778');
INSERT INTO `user` VALUES ('1092', '766', '陈碧瑾', 'Hebe.Chen', '13517248058', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKPibNf0UnfjDRYm5QQ4IUHYA/', null, null, null, null, '11', 'WM00008');
INSERT INTO `user` VALUES ('1093', '404', '张丽妮', 'Hedy.Zhang', '18271488592', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRVmSXY4yaVvEV6TuhIk5T0aicDX5HPYE6JHVetKlqic5Dg/', null, null, null, null, '9', 'WT00463');
INSERT INTO `user` VALUES ('1094', '525', '冀立锦', 'Sherry.Ji', '18271488763', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XEEjibWUN6OkkQn3dUFlZHKw/', null, null, null, null, '9', 'YT00419');
INSERT INTO `user` VALUES ('1095', '646', '谢云鹏', 'Stanley.Xie', '17693135301', '技术部门', 'http://p.qlogo.cn/bizmail/v3vheoPbvZlQxMIOAia8ju6NO2WIYuFxZjv51K2Acuzl9bicBYK6JxIg/0', null, null, null, null, '4', 'YT00785');
INSERT INTO `user` VALUES ('1096', '767', '晏海燕', 'Demi.Yan', '17612739508', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQV4KPCHUY8paWbu0xxKma6StPOpXR3RthYyxLtdsVcdg/', null, null, null, null, '9', 'WT01372');
INSERT INTO `user` VALUES ('1097', '405', '张迎迪', 'Diana.Zhang', '18980117432', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoCk6hZZYFGWEo296Wdd6DYw/', null, null, null, null, '9', 'WT00479');
INSERT INTO `user` VALUES ('1098', '526', '张宇', 'Franklin.Zhang', '13003577080', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQpOZbcbOrmOwRYQeK17msZjv364C7PjIibDsXQA43MZyg/', null, null, null, null, '4', 'YT00425');
INSERT INTO `user` VALUES ('1099', '647', '马凯', 'Clay.Ma', '18704775976', '技术部门', 'http://p.qlogo.cn/bizmail/MngGVyCjH0DxEiaJyftzdW3BNTvJUINR0NPhfKiaaAfQ2GlQopWWQoXA/0', null, null, null, null, '4', 'YT00789');
INSERT INTO `user` VALUES ('1100', '768', '黄海啸', 'Andy.Huang', '18918813817', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTGt7dmbHkVoxZsd3QC9OldpSfFuKyMNqkgk9tqyryibAQ/', null, null, null, null, '4', 'YT00580');
INSERT INTO `user` VALUES ('1101', '406', '黄炯', 'Ada.Huang', '15172541860', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQx2zVKaPFSDxQDt5eYl20OKukPAb0yH8YdeCTmCdLQSQ/', null, null, null, null, '9', 'WT00484');
INSERT INTO `user` VALUES ('1102', '527', '贾文杰', 'Tony.Jia', '17621159136', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQtwHoicvl5x7xvKz2QNibIribOBVysHO28626zmjGTxLycg/', null, null, null, null, '4', 'YT00432');
INSERT INTO `user` VALUES ('1103', '648', '刘果', 'Daisy.Liu', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQXnwYxlMbc3iaMTBeOQWomQ1f4NTahRGKjX6cGuzKdcPw/', null, null, null, null, '4', 'YT00779');
INSERT INTO `user` VALUES ('1104', '769', '马越', 'Jimmy.Ma', '17621671389', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGREfEJExaxDdeNQzYByQuV2ygicibMe39NaRerLd9tkG80g/', null, null, null, null, '4', 'YT00730');
INSERT INTO `user` VALUES ('1105', '407', '程欢', 'Carry.Cheng', '17771885623', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKcV9DL5jrMuDZQPicayAVEaQ/', null, null, null, null, '9', 'WT00491');
INSERT INTO `user` VALUES ('1106', '528', '胡楚欢', 'Eric.Hu', '15565128753', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRz0qGxTT3c4T9FEN93bSDDC6ncRllB1MobdlQgAGW3Mw/', null, null, null, null, '4', 'YT00435');
INSERT INTO `user` VALUES ('1107', '649', '贾政协', 'Jason.Jia', '15735104179', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTPYKN8gF4Yg7TDTMsgueemNRJ7XnrHej9VKq1X2AiaKibA/', null, null, null, null, '4', 'YT00784');
INSERT INTO `user` VALUES ('1108', '408', '王燕', 'April.Wang', '13308622022', '技术部门', 'http://p.qlogo.cn/bizmail/ctO8MSGQyEibBHBl2hB4CCqoDS2vqp56eicAdvTvic3XDG4icq5oCCt4Jg/0', null, null, null, null, '9', 'WT00493');
INSERT INTO `user` VALUES ('1109', '529', '迪莎', 'Doris.Di', '18234036582', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQtwHoicvl5x7xvKz2QNibIrib156zhfdTWnx68hLiaSD01Dw/', null, null, null, null, '4', 'YT00438');
INSERT INTO `user` VALUES ('1110', '409', '曹洋', 'Adam.Cao', '18062044001', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRlA63nvS0EJCNFBXeyk3vXpfwicbyOO25R1FGsml1LIfQ/', null, null, null, null, '9', 'WT00496');
INSERT INTO `user` VALUES ('1111', '770', '刘朝铭', 'Kermit.Liu', '18624071890', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQshcgQkyvDEBNxPBCiaFDm7setfdj0TSrtVuJNPQTRfqQ/', null, null, null, null, '4', 'YT00761');
INSERT INTO `user` VALUES ('1112', '650', '陈炳辉', 'Cheney.Chen', '15079030106', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQcUJnUtXzy7rdTERRQgzib0Ywpib1eJUibolklicNdicTfwicA/', null, null, null, null, '4', 'YT00788');
INSERT INTO `user` VALUES ('1113', '771', '范天悦', 'Faye.Fan', '18621630019', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRDia1jCEibmflX4FzZtXp6Cvaficnl28fdljdia9kXcpib1Iw/', null, null, null, null, '4', 'YT00782');
INSERT INTO `user` VALUES ('1114', '530', '吴思豫', 'Vicky.Wu', '15901688045', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1tsR6yuPtwdWfqPj6JmthKg/', null, null, null, null, '4', 'YT00440');
INSERT INTO `user` VALUES ('1115', '651', '雷玉兰', 'Amber.Lei', '17521020447', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRC9q4cicPN3DzDbrmfuBwNdxR3xZmSpM69kwWmWWia6Emg/', null, null, null, null, '4', 'YT00786');
INSERT INTO `user` VALUES ('1116', '772', '苏相学', 'Justin.Su', '15073370776', '技术部门', 'http://p.qlogo.cn/bizmail/NHuLibQWbGWiaMC0SVOfdrEQ5d4oZfAmlp2R5xAwOujtN9bY5t9b3uOA/', null, null, null, null, '9', 'WT01458');
INSERT INTO `user` VALUES ('1117', '410', '孙官俊', 'Kidd.Guan', '15623097500', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0teyD1WKJZOJRgmUkmdVr1g/', null, null, null, null, '9', 'WT00499');
INSERT INTO `user` VALUES ('1118', '531', '孙要全', 'Bill.Sun', '13681902829', '技术部门', 'http://p.qlogo.cn/bizmail/icOwcETmfXh8XDMXCA4HrfhabvunR8rf3jLiak1NQLAAqn0FsYF0ckvg/0', null, null, null, null, '4', 'YT00444');
INSERT INTO `user` VALUES ('1119', '652', '王锴', 'Kyle.Wang', '13453431322', '技术部门', 'http://p.qlogo.cn/bizmail/7QLsSntbk9uhoCWATpcuBebUfk0RicNMoxTYRW8avPicNLZibmlHQRAlA/0', null, null, null, null, '4', 'YT00787');
INSERT INTO `user` VALUES ('1120', '773', '任也', 'Elijah.Ren', '18602110436', '技术部门', 'https://p.qlogo.cn/bizmail/B0PK65dZrtQ1SQjctfUiabBWzg4AWmCkBnoX0TZuJVLB5Fh7T47nicCA/0', null, null, null, null, '4', 'T04832');
INSERT INTO `user` VALUES ('1121', '411', '徐军', 'Sherman.Xu', '15997435033', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0vGc2WG4McnYXBIxtbr8zLg/', null, null, null, null, '9', 'WT00521');
INSERT INTO `user` VALUES ('1122', '532', '马永', 'Jeff.Ma', '15026904591', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS9PVicyQJjvtEOXic2VfS1WDyRUUPmY9E8ZoRuf3pVNdFA/', null, null, null, null, '4', 'YT00447');
INSERT INTO `user` VALUES ('1123', '653', '伊重阳', 'Drews.Yi', '15171234639', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jk2s9IjcPWj1RFlZycaLU0bQ/', null, null, null, null, '4', 'YT00776');
INSERT INTO `user` VALUES ('1124', '774', '王静', 'George.Wang', '17717413381', '技术部门', 'http://p.qlogo.cn/bizmail/RRTcBThlcp7tJd1FLU71fOd6sglicmp7A4VNnibU5mwGDXDXNQiaw4o1g/0', null, null, null, null, '4', 'T04830');
INSERT INTO `user` VALUES ('1125', '412', '徐路', 'Jessie.Xu', '13667141377', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR84zlgaArwbr0jP5t513eS3VPwKkGibeGyDd2hicRrtUbA/', null, null, null, null, '9', 'WT00531');
INSERT INTO `user` VALUES ('1126', '533', '黄小乐', 'Lucy.Huang', '18721921864', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSGdtwic4lEPnHZtVub5aHT7hicdw50YsuJia6TbjacBYI9Q/', null, null, null, null, '4', 'YT00468');
INSERT INTO `user` VALUES ('1127', '654', '王伟栋', 'Eric.Wang', '18709354838', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jkGeCiamFPwkHl9QrY9bibIb9Q/', null, null, null, null, '4', 'YT00791');
INSERT INTO `user` VALUES ('1128', '775', '严科健', 'Laurence.Yan', '', '技术部门', 'http://p.qlogo.cn/bizmail/bSK4Yrd142LjxSvO0ibFnlNotz941kTWPz3uibKTqCLU3OxWDNXh0ScQ/0', null, null, null, null, '9', 'WT01524');
INSERT INTO `user` VALUES ('1129', '413', '崔敏', 'Maggie.Cui', '15872410001', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR84zlgaArwbr0jP5t513eSziaAialZSEzDGsjrJxWf1CJQ/', null, null, null, null, '9', 'WT00564');
INSERT INTO `user` VALUES ('1130', '534', '赵修飞', 'Hubert.Zhao', '13023193997', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRVmSXY4yaVvEV6TuhIk5T0mwKvNLC22o5On6JGLppvibQ/', null, null, null, null, '4', 'YT00479');
INSERT INTO `user` VALUES ('1131', '655', '魏心雨', 'Warren.Wei', '13720699716', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jkfeBiavghicDnkQd97WN3yvuA/', null, null, null, null, '4', 'YT00793');
INSERT INTO `user` VALUES ('1132', '776', '高惠敏', 'Emily.Kao', '18621962287', '运营部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS8V1l3XgiaANoXICbRDay05rIEC43VkXicdGEZGdOp5zicw/', null, null, null, null, '14', 'M00001');
INSERT INTO `user` VALUES ('1133', '414', '陈光夫', 'Gabriel.Chen', '13628699669', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKdjVicnltOXkE6FzRdzqia5dA/', null, null, null, null, '9', 'WT00621');
INSERT INTO `user` VALUES ('1134', '535', '张烨', 'Yale.Zhang', '17621233129', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSGdtwic4lEPnHZtVub5aHT73STDBHQEOjEg9oPQlM0Trg/', null, null, null, null, '4', 'YT00494');
INSERT INTO `user` VALUES ('1135', '656', '胡伟豪', 'Hubert.Hu', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jkLng4K7loW3MLNMS5sHOVhw/', null, null, null, null, '4', 'YT00794');
INSERT INTO `user` VALUES ('1136', '777', '陈乐乐', 'Neil.Chen', '15021658034', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR84zlgaArwbr0jP5t513eSvPQ6WUeFkTSdMmcK2tteiaQ/', null, null, null, null, '4', 'M00160');
INSERT INTO `user` VALUES ('1137', '415', '吴林', 'Lyndon.Wu', '15071305057', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZx1qv5MoNs3H6VZNPXmc9vOg/', null, null, null, null, '9', 'WT00693');
INSERT INTO `user` VALUES ('1138', '536', '严艺蕾', 'Yolanda.Yan', '13918115490', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSGdtwic4lEPnHZtVub5aHT7jhlxeG00LN7jL0CuNibx5rw/', null, null, null, null, '4', 'YT00495');
INSERT INTO `user` VALUES ('1139', '657', '景轩', 'Lewis.Jing', '15735104296', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQv6qPkrqae4Joic2kicbiaia9MAYYvRBZ9jyr0eWKsMLhSuw/', null, null, null, null, '4', 'YT00790');
INSERT INTO `user` VALUES ('1140', '778', '郑君', 'Jade.Zheng', '13916289639', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS07Kaewmxao3ZlExcHofZXwyYZmYq76EhrTAdcZffH5A/', null, null, null, null, '6', 'T01620');
INSERT INTO `user` VALUES ('1141', '416', '李斌', 'Owen.Li', '18672199339', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxHlbV6FIjB0H3be6XKRFJUA/', null, null, null, null, '9', 'WT00701');
INSERT INTO `user` VALUES ('1142', '537', '辛本雪', 'Cathy.Xin', '15021391759', '技术部门', 'http://p.qlogo.cn/bizmail/jkd0UnV9XdN52ic1owibtkwBibFPqnZKWxgib6F7wV6icudpFsSLl60u4Kw/0', null, null, null, null, '4', 'YT00496');
INSERT INTO `user` VALUES ('1143', '658', '刘露', 'Cassie.Liu', '', '技术部门', 'http://p.qlogo.cn/bizmail/knicgrTKZ8hBGR92mp3jnBLr9EoR0NolILX4HXbS9SfBU98N3RmMW7g/0', null, null, null, null, '4', 'YT00796');
INSERT INTO `user` VALUES ('1144', '779', '龙辉', 'Blair.Long', '18572842680', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1zicFXxAdURnKFJ5lV0G10icg/', null, null, null, null, '9', 'T03132');
INSERT INTO `user` VALUES ('1145', '417', '刘银', 'Devin.Liu', '15997441502', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7X8ksAoqJNPic558lP7G6j5GQ/', null, null, null, null, '9', 'WT00702');
INSERT INTO `user` VALUES ('1146', '538', '陈子龙', 'Rod.Chen', '18715516122', '技术部门', 'http://p.qlogo.cn/bizmail/EGicvloruQzdkzXYEaKE9ic3LdSQdicbRAMc0PwBwoibcOfLuOCYpngqdw/0', null, null, null, null, '4', 'YT00511');
INSERT INTO `user` VALUES ('1147', '659', '李永康', 'Kale.Li', '13209288237', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jk1icOhC2u6icQXxoaLMxXYB7Q/', null, null, null, null, '4', 'YT00795');
INSERT INTO `user` VALUES ('1148', '418', '陈丹', 'Caspar.Chen', '18627732447', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRVmSXY4yaVvEV6TuhIk5T05uVQibFfqK5pxVLFzlYRpibg/', null, null, null, null, '9', 'WT00707');
INSERT INTO `user` VALUES ('1149', '539', '张瑜', 'Sarah.Zhang', '18234133021', '技术部门', 'http://p.qlogo.cn/bizmail/CB55M5G4VU74F3dbL2cXicQw2McqkYzzxrXygPaOvRJNjAuBNEyjGpg/0', null, null, null, null, '4', 'YT00536');
INSERT INTO `user` VALUES ('1150', '419', '徐莉', 'Lisa.Xu', '13476210820', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxpuaBUze3vNUuXiahicyapfEg/', null, null, null, null, '9', 'WT00708');
INSERT INTO `user` VALUES ('1151', '780', '余吉祥', 'Daniel.Yu', '18671165909', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR717ibPpLM1RYZrtY4fYVjb3X3fibWhA2h3u89zLQTibF9Q/', null, null, null, null, '9', 'T03493');
INSERT INTO `user` VALUES ('1152', '660', '王旺', 'Walter.Wang', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniaZQVKaQkbMdociaAALP59ZD7bJM3tYzrvKHpTCibwnOg/', null, null, null, null, '9', 'WT01423');
INSERT INTO `user` VALUES ('1153', '781', '邓秀梅', 'Tess.Deng', '15618962819', '技术部门', 'http://p.qlogo.cn/bizmail/Ndxic9Ewt1hTRbnaeKdIremDOYmzPABWp5icdFGdSaicow9eyeFLD0LTQ/0', null, null, null, null, '9', 'WT00620');
INSERT INTO `user` VALUES ('1154', '540', '周国媚', 'Cathy.Zhou', '15800629295', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1EZ6DfWmiaG5zY3LUT33e95g/', null, null, null, null, '4', 'YT00540');
INSERT INTO `user` VALUES ('1155', '661', '周伟', 'Lucas.Zhou', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jk8eXg8d8UBkhN81W6yoiciayg/', null, null, null, null, '9', 'WT01433');
INSERT INTO `user` VALUES ('1156', '782', '王晓江', 'Harris.Wang', '17521030508', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQltcHYFbKhvAo5QGoLM1Upmya1SXS9ibL46m3xDpiadOfA/', null, null, null, null, '4', 'WT01292');
INSERT INTO `user` VALUES ('1157', '420', '杨菊华', 'Victoria.Yang', '15927480971', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRSrUuaI5BCe47s92OK5SEdI6VpwAEyIg6edpkiaI4QrIg/', null, null, null, null, '9', 'WT00712');
INSERT INTO `user` VALUES ('1158', '541', '张中华', 'Byron.Zhang', '18721951341', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSGdtwic4lEPnHZtVub5aHT74HrJwrTk8sEgb4kTFLakXA/', null, null, null, null, '4', 'YT00542');
INSERT INTO `user` VALUES ('1159', '662', '严博文', 'Jax.Yan', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgI9F9uK5ooSJxpmo28c9OJQ/', null, null, null, null, '9', 'WT01430');
INSERT INTO `user` VALUES ('1160', '783', '陈勇', 'Luke.Chen', '18627117206', '技术部门', 'http://p.qlogo.cn/bizmail/uPg3558eDDHK6G9TPYv94fyNsYict4Hj3iaWCs4U0nVia8C1bJp84PmpQ/0', null, null, null, null, '9', 'YT00335');
INSERT INTO `user` VALUES ('1161', '300', '顾卫海', 'Rob.Gu', '18701793670', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsNwVgCBgGvfn4IGzrb5Vy31ZDqlLcayQuTvFiaibW7T7g/', null, null, null, null, '4', 'T04282');
INSERT INTO `user` VALUES ('1162', '421', '汪远', 'Noah.Wang', '15802784597', '技术部门', 'http://p.qlogo.cn/bizmail/602kr7rseVcIyhrlgD2wkbHNGRnm4pWGdSHnj6Q0zBNznDibcKv9MMQ/0', null, null, null, null, '9', 'WT00715');
INSERT INTO `user` VALUES ('1163', '542', '王超', 'Gerald.Wang', '15562305255', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSGdtwic4lEPnHZtVub5aHT7VsjtPtyPFIknMS7q2HX1HQ/', null, null, null, null, '4', 'YT00561');
INSERT INTO `user` VALUES ('1164', '663', '黄俊森', 'Eugene.Huang', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSuZK6y4DFBzJuEPxeeLrgYaC8mxtdtlsRw9tZlvUMO3A/', null, null, null, null, '9', 'WT01428');
INSERT INTO `user` VALUES ('1165', '784', '张利霞', 'Cassie.Zhang', '13162170816', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRwbiaH0Z4CcajkK57icLE8LKNIH7GuiccYlxdZZL4SdhgGg/', null, null, null, null, '9', 'YT00340');
INSERT INTO `user` VALUES ('1166', '301', '于闯英', 'Tina.Yu', '18516176521', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGT8A3KGre9Vqln0xE5UWv5ZSUgc1pLuDFsecvbPKIplEg/', null, null, null, null, '4', 'T04294');
INSERT INTO `user` VALUES ('1167', '422', '温永红', 'Heidi.Wen', '13164666487', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQGP0ibLd1GNNBjGGSM8zmRkbUBIJPCpbPcqknFCZTeJbA/', null, null, null, null, '9', 'WT00722');
INSERT INTO `user` VALUES ('1168', '543', '唐潇', 'Della.Tang', '17051025928', '技术部门', 'http://p.qlogo.cn/bizmail/0R7WxSrUsuZFKKwm1ia7f7F8RTib4ib39jglmJmPRoBqjVGzputcCbwVQ/0', null, null, null, null, '4', 'YT00567');
INSERT INTO `user` VALUES ('1169', '664', '张媛媛', 'Jenny.Zhang', '18871768279', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQrIcvhibdFTPHYLicJicYdI5Kbbtgvk7gVjP5ia24FHlaBOQ/', null, null, null, null, '9', 'WT01438');
INSERT INTO `user` VALUES ('1170', '785', '赵巍', 'Echo.Zhao', '18721891081', '技术部门', 'https://p.qlogo.cn/bizmail/4iaQQlNOeqIlyoX6RhUGibVyUAmHxEVJJ2TZGHxd9UBvI958UW7E7arQ/0', null, null, null, null, '4', 'T04860');
INSERT INTO `user` VALUES ('1171', '302', '栾铭泽', 'Lara.Luan', '13585774494', '技术部门', 'http://p.qlogo.cn/bizmail/TbfoE9niaQbYrgKSeO0rgJl7y2RjuUWc0VJYoDq631ib2AOzZVEiaf1Lw/0', null, null, null, null, '4', 'T04352');
INSERT INTO `user` VALUES ('1172', '423', '黄瑶', 'Joyce.Huang', '18321803586', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKEn44wDVic6Moibr2aC4d0knw/', null, null, null, null, '4', 'WT00740');
INSERT INTO `user` VALUES ('1173', '544', '冯世豪', 'Simon.Feng', '18317894179', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSaeiakWV1cWRb6ofdcbkhicCibQX8RQExIc2H8luvwXqa6A/', null, null, null, null, '4', 'YT00571');
INSERT INTO `user` VALUES ('1174', '665', '王艺', 'Angel.Wang', '13657265629', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQaGLib4PXNNIiafsb4y0qy9eLooIRUx5tSg43k5qX1fGkQ/', null, null, null, null, '9', 'WT01437');
INSERT INTO `user` VALUES ('1175', '303', '王乐鸣', 'Lemmy.Wang', '13817220931', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wY92XYLRKmEGOicpU8lKIOQew/', null, null, null, null, '4', 'T04360');
INSERT INTO `user` VALUES ('1176', '424', '徐蓉', 'Rita.Xu', '13437285110', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR84zlgaArwbr0jP5t513eSV3kVTEVgWDfEiaCKbaU0FaA/', null, null, null, null, '9', 'WT00749');
INSERT INTO `user` VALUES ('1177', '545', '那光情', 'Nick.Na', '18317857608', '技术部门', 'http://p.qlogo.cn/bizmail/1ArJTrfMfGgDzcgmSDr9B4wRSY9kYqhh3vfML2nAJcicpQUGqqKMaPw/0', null, null, null, null, '4', 'YT00573');
INSERT INTO `user` VALUES ('1178', '666', '东茹雪', 'Cathy.Dong', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgicYdRChXBBUKTsGzbax2fIg/', null, null, null, null, '4', 'T04810');
INSERT INTO `user` VALUES ('1179', '304', '袁雯婧', 'Cora.Yuan', '15618751899', '技术部门', 'http://p.qlogo.cn/bizmail/nVOrDicGkutqNmS9XZ1Ql7QkPh1xkxmibkiadvpRncA7icSL0x9COSibKSw/0', null, null, null, null, '4', 'T04363');
INSERT INTO `user` VALUES ('1180', '425', '王芳', 'Connie.Wang', '15171438941', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOobsX2eXkdIS4oSKZYSWk33g/', null, null, null, null, '9', 'WT00761');
INSERT INTO `user` VALUES ('1181', '546', '聂满党', 'Max.Nie', '17317925592', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSaeiakWV1cWRb6ofdcbkhicC9vwt2ia0QCYvD6ibd54jI7Mg/', null, null, null, null, '4', 'YT00581');
INSERT INTO `user` VALUES ('1182', '667', '范青芳', 'Nancy.Fan', '18437927255', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR0bC6Kv0YY1mofcfcKSz7lNOHsvnzvMHoQiadswchtLkA/', null, null, null, null, '4', 'T04809');
INSERT INTO `user` VALUES ('1183', '305', '马晓钦', 'Tina.Ma', '18521569852', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1AIF9BET06HQqr8MSX6cHmw/', null, null, null, null, '4', 'T04369');
INSERT INTO `user` VALUES ('1184', '426', '黄婷', 'Sherry.Huang', '15171465511', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxPTIm0MIiaSuRsibg8DyF2RmA/', null, null, null, null, '9', 'WT00762');
INSERT INTO `user` VALUES ('1185', '547', '郭笑雪', 'Sonya.Guo', '13064421479', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTGt7dmbHkVoxZsd3QC9Oldst8QhpTqWvrgkeicbjLicIYw/', null, null, null, null, '4', 'YT00596');
INSERT INTO `user` VALUES ('1186', '668', '郜瑞丽', 'Ivy.Gao', '18838964863', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXg4NuzfDyzML0dw8lRvBcWyQ/', null, null, null, null, '4', 'T04805');
INSERT INTO `user` VALUES ('1187', '306', '刘海洋', 'Leo.Liu', '17601393357', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1vU1HI5zT5ibC8PaVbkHEWibA/', null, null, null, null, '4', 'T04395');
INSERT INTO `user` VALUES ('1188', '427', '张昊', 'Ernest.Zhang', '18627121841', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR84zlgaArwbr0jP5t513eSc6pl61PiaEcPgC5dVfLhVNg/', null, null, null, null, '9', 'WT00767');
INSERT INTO `user` VALUES ('1189', '548', '庄鹏', 'Kalvin.Zhuang', '18662257617', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQltcHYFbKhvAo5QGoLM1UpqZKibkayiaSuIfVIicsAibHL5Q/', null, null, null, null, '4', 'YT00599');
INSERT INTO `user` VALUES ('1190', '669', '尹庆超', 'Will.Yin', '18016000389', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNNQ7yicrzdRcGr1icFTe3jkLRjhf2KBCBQ8794hU3AWBg/', null, null, null, null, '4', 'T04803');
INSERT INTO `user` VALUES ('1191', '307', '孙洋', 'Iris.Sun', '15900848069', '技术部门', 'http://p.qlogo.cn/bizmail/DjUnoT99zgVYT5CelSzOPvIk8ORCm04Kjenb4FG8UwkTKSnx5slTFA/0', null, null, null, null, '4', 'T04405');
INSERT INTO `user` VALUES ('1192', '428', '李盈', 'Aaliyah.Li', '15071037928', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsbjbGibS4Kyf8OR6ICZ8Dq55A/', null, null, null, null, '9', 'WT00775');
INSERT INTO `user` VALUES ('1193', '549', '肖龙', 'Allen.Xiao', '18257300550', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTJziaicRrImLA5Y77s2t7w41j2icuVnhI1Q6fbiaib4PibWUKg/', null, null, null, null, '4', 'YT00601');
INSERT INTO `user` VALUES ('1194', '308', '张建飞', 'Nicky.Zhang', '13764694049', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1M7wUgOpCqaZYwRt5OTW53Q/', null, null, null, null, '4', 'T04417');
INSERT INTO `user` VALUES ('1195', '429', '许鸿远', 'Bryan.Xu', '13554663429', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR6N99pbA6VaovOOtqTDYtSoIY4rETib5iaKU9KIl7iabWHA/', null, null, null, null, '9', 'WT00790');
INSERT INTO `user` VALUES ('1196', '309', '宋佳', 'Jasmine.Song', '13127763230', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYRhNg5MSJF0x8Zxsaccz1Zw/', null, null, null, null, '4', 'T04427');
INSERT INTO `user` VALUES ('1197', '670', '侯若漪', 'Zoe.Hou', '17717910838', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRbibnk6zAFfa4bV0icBvWiaWtLSicH02Z4dhKQVfd4w1cpeg/', null, null, null, null, '4', 'T04814');
INSERT INTO `user` VALUES ('1198', '550', '张骁', 'Quintin.Zhang', '17601368616', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSAX9rypQnEmibOdtP0lKiarKNT35HNXJlzPvU8ZG5LLBug/', null, null, null, null, '4', 'YT00604');
INSERT INTO `user` VALUES ('1199', '671', '杨爱霞', 'Amy.Yang', '13651657396', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTj0DBGyYUFM7Ws8B3K7qB04iciblDaLrUuKKjsLK3tE1hA/', null, null, null, null, '4', 'T04813');
INSERT INTO `user` VALUES ('1200', '430', '韩莎', 'Alisa.Han', '18163521936', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR79b5ZibIsYxLvjn77Xs9APNXicMjnpkpiasopfDmX25gAg/', null, null, null, null, '9', 'WT00834');
INSERT INTO `user` VALUES ('1201', '551', '黄佳慧', 'Sophia.Huang', '18091664814', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRt88CuILqvcJx998va1304GL8JIxHfKSsZfNejvsuBZg/', null, null, null, null, '4', 'YT00606');
INSERT INTO `user` VALUES ('1202', '672', '张敏', 'Brandon.Zhang', '13277060086', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSZbWb7lnzF0LibLPT998QYQt9vjL3lcFvOaKmUCxVXcicA/', null, null, null, null, '9', 'WT01439');
INSERT INTO `user` VALUES ('1203', '310', '陈昕泽', 'Crowley.Chen', '17621396067', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQHJQ6ib20DR6w4HwDdB50VEgiaBuAsYiaNv6P0mkZx9hUOg/', null, null, null, null, '4', 'T04443');
INSERT INTO `user` VALUES ('1204', '431', '李生炼', 'Corbin.Li', '18696149688', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSaeiakWV1cWRb6ofdcbkhicCsHk0T85VYFl74WlyDlPhTw/', null, null, null, null, '9', 'WT00844');
INSERT INTO `user` VALUES ('1205', '552', '张培强', 'Damon.Zhang', '17601378524', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRlf4kzIzU1pX5CbWvyb6IzD7ZM45ZKJNccpCN4fzwfzw/', null, null, null, null, '4', 'YT00610');
INSERT INTO `user` VALUES ('1206', '673', '王涛', 'Troy.Wang', '13419623046', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXg2JE0x9L3uHTHRp7L4CT7ZQ/', null, null, null, null, '9', 'WT01440');
INSERT INTO `user` VALUES ('1207', '311', '施婷杰', 'Wendy.Shi', '18516779528', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYOgxX8uToVdRZzcQYgOX45g/', null, null, null, null, '4', 'T04462');
INSERT INTO `user` VALUES ('1208', '432', '陶水英', 'Eva.Tao', '17740692510', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS0ABXJAhy0kk3p5yhnRvnaFwzic77l0r4XFVTOTwOVG6w/', null, null, null, null, '9', 'WT00847');
INSERT INTO `user` VALUES ('1209', '553', '谷国宜', 'Jaden.Gu', '18317713172', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRt88CuILqvcJx998va1304xNmhTjZSTuU0gr9eVbSUAg/', null, null, null, null, '4', 'YT00615');
INSERT INTO `user` VALUES ('1210', '674', '伦兆雪', 'Maggie.Lun', '17521633217', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMOYyNE33svoLNaQB7FyJTOm64NSWl24xF4D4wic047wQ/', null, null, null, null, '4', 'T04817');
INSERT INTO `user` VALUES ('1211', '312', '高德玲', 'Linda.Gao', '15951862768', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wY0uiaK7ra2FYKR0TIVgXZjSg/', null, null, null, null, '4', 'T04463');
INSERT INTO `user` VALUES ('1212', '433', '向阳', 'Celine.Xiang', '18627781551', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRyz8efxicx081PbEjtic77BIHO4hx1XAGU2yx65eTRibwCQ/', null, null, null, null, '9', 'WT00850');
INSERT INTO `user` VALUES ('1213', '554', '陈诚', 'Phillips.Chen', '18862172316', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRlf4kzIzU1pX5CbWvyb6IzFjof6XRUferFywVniaK2EzA/', null, null, null, null, '4', 'YT00622');
INSERT INTO `user` VALUES ('1214', '675', '牛慧田', 'April.Niu', '13661863973', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTj0DBGyYUFM7Ws8B3K7qB0G7VDf3NqK55jR2wTerdzQQ/', null, null, null, null, '4', 'T04819');
INSERT INTO `user` VALUES ('1215', '313', '王国辉', 'Darren.Wang', '15138696968', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYflmOrCkIkwNghib56VPWu6g/', null, null, null, null, '4', 'T04473');
INSERT INTO `user` VALUES ('1216', '434', '马岩', 'Roland.Ma', '15629440025', '技术部门', 'http://p.qlogo.cn/bizmail/XdZ0gplr5XQncAxibCnOAYU5WbtPIDZOPeeiahzqWcNibhlbFYcJFE3xw/0', null, null, null, null, '9', 'WT00867');
INSERT INTO `user` VALUES ('1217', '555', '卢文豪', 'Eddie.Lu', '18020220562', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfPDw7Gs01richqD5suYwbALQ/', null, null, null, null, '4', 'YT00623');
INSERT INTO `user` VALUES ('1218', '676', '酒晶晶', 'Gillian.Jiu', '18613564616', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSZbWb7lnzF0LibLPT998QYQg0U27QKo3Qd4gPUjGUCqfg/', null, null, null, null, '9', 'WT01443');
INSERT INTO `user` VALUES ('1219', '314', '王建朋', 'Elmo.Wang', '13569421009', '技术部门', 'http://p.qlogo.cn/bizmail/Nq4JbX15YN3Kfwuic7iaxfebBuoqh7rYTGwBpovvCwBwth8ArBHgwpUQ/0', null, null, null, null, '4', 'T04478');
INSERT INTO `user` VALUES ('1220', '435', '胡建军', 'Jackie.Hu', '18171518620', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxz0D8MayzqibB5VA4aLyibDqA/', null, null, null, null, '9', 'WT00874');
INSERT INTO `user` VALUES ('1221', '556', '林雄杰', 'Foster.Lin', '13681683852', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsbRomIaIiay31meepp98mIJHQ/', null, null, null, null, '4', 'YT00625');
INSERT INTO `user` VALUES ('1222', '677', '梁丽', 'Lillian.Liang', '15549328858', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR0bC6Kv0YY1mofcfcKSz7ljgzibDb8WjgAIYlWejXzZOg/', null, null, null, null, '9', 'WT01444');
INSERT INTO `user` VALUES ('1223', '315', '彭帅', 'Clark.Peng', '15021849227', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjHd2TO84cMzziaE1zNGpfALg/', null, null, null, null, '4', 'T04485');
INSERT INTO `user` VALUES ('1224', '436', '王进军', 'Jay.Wang', '13260557937', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XkY1ZQhTrdNcicnA6BZgN9ibg/', null, null, null, null, '9', 'WT00894');
INSERT INTO `user` VALUES ('1225', '557', '王梦羽', 'Alice.Wang', '13813090385', '技术部门', 'http://p.qlogo.cn/bizmail/M4pWpqIQJygZp0dc6bPFEEo1NibYjWjiaUQGf2nlIticSNCgrkG7vIfkA/0', null, null, null, null, '4', 'YT00626');
INSERT INTO `user` VALUES ('1226', '678', '曹宇', 'Cyril.Cao', '18163718554', '技术部门', 'http://p.qlogo.cn/bizmail/WYDsTiajrE8XkjlGGZMtpPRPZ5yORunVUaa9DriaNdnQwibFet9TEIl8w/0', null, null, null, null, '9', 'WT01445');
INSERT INTO `user` VALUES ('1227', '316', '莫彩月', 'Colleen.Mo', '18301728843', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQK1TMB3OMAj8rPw034z5EjNBRCkz0ibnpq7UqPqodFuiaw/', null, null, null, null, '4', 'T04488');
INSERT INTO `user` VALUES ('1228', '437', '秦玲', 'Beth.Qin', '13260640182', '技术部门', 'http://p.qlogo.cn/bizmail/pLqBGKsS8eHh82DynqxmCsL91gxH7OYiaru1DZykWLNvlBFWPMeXBiaw/0', null, null, null, null, '9', 'WT00899');
INSERT INTO `user` VALUES ('1229', '558', '马帅雷', 'Brooke.Ma', '18338897515', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSW8tMD8XOYZ8HOo8ohJM0wrzECeOowVqdia03S6fAsb1Q/', null, null, null, null, '4', 'YT00632');
INSERT INTO `user` VALUES ('1230', '679', '杨嘉志', 'Wade.Yang', '15503622641', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkRtKWTtTEMCUS5ATkW5kBNUQ/', null, null, null, null, '4', 'YT00797');
INSERT INTO `user` VALUES ('1231', '317', '石丹', 'Betty.Shi', '15900937743', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1UQw5CVNicEeL34eicP3cpDGg/', null, null, null, null, '4', 'T04495');
INSERT INTO `user` VALUES ('1232', '438', '袁小红', 'Victoria.Yuan', '15172501426', '技术部门', 'http://p.qlogo.cn/bizmail/5PjRiaa9lRsbuwibQRARiak1xevMHKDPlh6B7qNXgN8yYLCtNkQVIcuQQ/0', null, null, null, null, '9', 'WT00922');
INSERT INTO `user` VALUES ('1233', '559', '齐梦珂', 'Gillian.Qi', '18117165961', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxWdEbiaUrFJzsWP5icicia5Ubcg/', null, null, null, null, '4', 'YT00633');
INSERT INTO `user` VALUES ('1234', '318', '杨轶男', 'Mandy.Yang', '15900937741', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsNwVgCBgGvfn4IGzrb5VyObT3m9aeGY3kyxI5OP17jA/', null, null, null, null, '4', 'T04496');
INSERT INTO `user` VALUES ('1235', '439', '许嘉洲', 'Colin.Xu', '15927089231', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxhBQT7BQTRfIIzuOcahgkGQ/', null, null, null, null, '9', 'WT00932');
INSERT INTO `user` VALUES ('1236', '319', '王新慧', 'Doris.Wang', '13166063051', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYWyNVG6Tme5XiaFGERU5hic0A/', null, null, null, null, '4', 'T04497');
INSERT INTO `user` VALUES ('1237', '680', '杨柳思', 'Cindy.Yang', '18473481918', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkRhNOczWyv3fTWNEeV7ibdkNQ/', null, null, null, null, '9', 'WT01446');
INSERT INTO `user` VALUES ('1238', '560', '娄鹏举', 'Jaylon.Lou', '17621016075', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRg6S8nibpBI5icxl4iccyrxDZWHzAyqO7aib3j2QOJ22GxmQ/', null, null, null, null, '4', 'YT00635');
INSERT INTO `user` VALUES ('1239', '681', '杨向东', 'Jesus.Yang', '18964024096', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSAxUJHwnerKyYicrC1Z5OzNMbqu24obpo96MDUM8vhlGQ/', null, null, null, null, '4', 'YT00799');
INSERT INTO `user` VALUES ('1240', '440', '阮姝颖', 'Amy.Ruan', '18672790567', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoFmqz9x6XI9X66MkzlTKvtA/', null, null, null, null, '9', 'WT00966');
INSERT INTO `user` VALUES ('1241', '561', '肖娜', 'Shawna.Xiao', '18914398841', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRwbiaH0Z4CcajkK57icLE8LKjVqXibDF3HfspFljbZKAmLg/', null, null, null, null, '4', 'YT00644');
INSERT INTO `user` VALUES ('1242', '682', '闵晨', 'Winnie.Min', '15871483850', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkRQbPYdjL6qCwfhicE4qiaztGg/', null, null, null, null, '9', 'WT01448');
INSERT INTO `user` VALUES ('1243', '320', '何丽娟', 'Ivy.He', '13918475973', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmflyWQvE3ejRz3fvHTnvwmVQ/', null, null, null, null, '4', 'T04500');
INSERT INTO `user` VALUES ('1244', '441', '方莹', 'Winnie.Fang', '13995616132', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxAKTicRy7xTHaZnrAzq2CzYQ/', null, null, null, null, '9', 'WT00985');
INSERT INTO `user` VALUES ('1245', '562', '李磊', 'Malcolm.Li', '13253657835', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0SK4T2Z1QdMol5woLgsCXPw/', null, null, null, null, '4', 'YT00649');
INSERT INTO `user` VALUES ('1246', '683', '黄谦', 'Owen.Huang', '13252397110', '技术部门', 'http://p.qlogo.cn/bizmail/UtsgF9nQg2c4rJTrnV6VXzyqaZhuHdjibuffK6FKZCIbITBQmRxTF0Q/0', null, null, null, null, '4', 'YT00798');
INSERT INTO `user` VALUES ('1247', '200', '贺俊', 'Billy.He', '15821227263', '技术部门', 'http://p.qlogo.cn/bizmail/4Dic0ic9MBJicoR2ibJiaqrxLeupXRvvibXaEw7oOaZFKwFnczFKEEaCTRng/0', null, null, null, null, '4', 'T00025');
INSERT INTO `user` VALUES ('1248', '321', '牛冬梅', 'Sunny.Niu', '13761506845', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYQQibYkX5vqtjvtB2ibkXZ4lw/', null, null, null, null, '4', 'T04503');
INSERT INTO `user` VALUES ('1249', '442', '成咏梅', 'Vivian.Cheng', '18986031037', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSaeiakWV1cWRb6ofdcbkhicC08V3mQm78tuoibu4KKibdCyg/', null, null, null, null, '9', 'WT01005');
INSERT INTO `user` VALUES ('1250', '563', '李春雷', 'Damon.Li', '18237127186', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQbibWm1VbibopwbSmlzR4N3qDqwYk3LWD2kkPWBuUzt3VA/', null, null, null, null, '4', 'YT00650');
INSERT INTO `user` VALUES ('1251', '684', '沈宏', 'Chris.Shen', '17521534960', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkR09BGtwMmDnbqzdew24icibiaQ/', null, null, null, null, '4', 'YT00803');
INSERT INTO `user` VALUES ('1252', '201', '浦争艳', 'Kelly.Pu', '13250813465', '技术部门', 'http://p.qlogo.cn/bizmail/e5kQ4V7TbOoEaZy3yIYWnTrdBpqBcqDUJE4WMmWjPeWHzPfyd0Pgicw/0', null, null, null, null, '4', 'T00130');
INSERT INTO `user` VALUES ('1253', '322', '陈佳年', 'Shawn.Chen', '13764538586', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYqrbU8AawA0eVUNND8hCPtw/', null, null, null, null, '4', 'T04522');
INSERT INTO `user` VALUES ('1254', '443', '王子珍', 'Claire.Wang', '13627257170', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZx8DicibkGcfFBUaXMgkWDORQA/', null, null, null, null, '9', 'WT01039');
INSERT INTO `user` VALUES ('1255', '564', '苑洪得', 'Edgar.Yuan', '18103847053', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0ib2lLoMnibCHzIicEwzqR2OFQ/', null, null, null, null, '4', 'YT00653');
INSERT INTO `user` VALUES ('1256', '685', '王莹', 'Nora.Wang', '13160021281', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkRS3aRib2MDiciaykJ6dsA6pibRA/', null, null, null, null, '4', 'YT00804');
INSERT INTO `user` VALUES ('1257', '202', '钱丽', 'Stella.Qian', '18621909921', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjdhcicTg8F5iacgjYUcEQqnsw/', null, null, null, null, '4', 'T00162');
INSERT INTO `user` VALUES ('1258', '323', '徐韦', 'Susie.Xu', '13601863735', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYHGNcFCkAqVWerphyvbOl3A/', null, null, null, null, '4', 'T04526');
INSERT INTO `user` VALUES ('1259', '444', '汤玲燕', 'Rebecca.Tang', '13297086289', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XuRzENqnicFa0fz8IeyM5YQQ/', null, null, null, null, '9', 'WT01048');
INSERT INTO `user` VALUES ('1260', '565', '郑大勇', 'Reuben.Zheng', '17602105327', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjeibXuYHvFTZR5wM4uCWEEwQ/', null, null, null, null, '4', 'YT00658');
INSERT INTO `user` VALUES ('1261', '686', '朱海涛', 'Cole.Zhu', '18852852122', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkRnR9kdBLxv2ic2N6IWDdfyTw/', null, null, null, null, '4', 'YT00800');
INSERT INTO `user` VALUES ('1262', '203', '刘庆华', 'Colleen.Liu', '18627166105', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsbR0ia6rSTxAxUrttra3UhQkQ/', null, null, null, null, '9', 'T00237');
INSERT INTO `user` VALUES ('1263', '324', '张帅', 'Adam.Zhang', '13564101503', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQGP0ibLd1GNNBjGGSM8zmRk0dPzicgp31U7iboSFL4wWp9A/', null, null, null, null, '4', 'T04533');
INSERT INTO `user` VALUES ('1264', '445', '王雪', 'Sherry.Wang', '13476189130', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKacYPP1oSyYhQxuaPVqW8LQ/', null, null, null, null, '9', 'WT01052');
INSERT INTO `user` VALUES ('1265', '566', '刘姗', 'Nadia.Liu', '19941956526', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0UCPJjT69vt3b3Z0QUHcYVQ/', null, null, null, null, '4', 'YT00662');
INSERT INTO `user` VALUES ('1266', '687', '李悦', 'Isabella.Li', '17809269212', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRtdXqrR4QhyAqibkKWszyt2P2WN1NPtxrJcw46iaLGQSXg/', null, null, null, null, '4', 'YT00802');
INSERT INTO `user` VALUES ('1267', '204', '吴中元', 'Berton.Wu', '18018663625', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSeLic6FCUJUHDEyKichVonWibnW7iaUdiaDvicVXlYekvvuFgw/', null, null, null, null, '4', 'T00245');
INSERT INTO `user` VALUES ('1268', '325', '李艳霞', 'Lilian.Li', '18516239716', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYJ0zWZAPf8IecGlMQUJzIWw/', null, null, null, null, '4', 'T04539');
INSERT INTO `user` VALUES ('1269', '446', '陈金忠', 'Will.Chen', '15671615805', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTMGJSDsK8Q2CiaicQCSrwOIoyBgdiaTzHAxoiaHA2tv0ENjA/', null, null, null, null, '9', 'WT01054');
INSERT INTO `user` VALUES ('1270', '567', '马哲', 'Warren.Ma', '15738896847', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTQg0Jly8yvYjaRZd3KZ2W1yWaRJAX66MqfVnFtk3tHZg/', null, null, null, null, '4', 'YT00663');
INSERT INTO `user` VALUES ('1271', '688', '吴靖', 'Celina.Wu', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQN7ESaQIAMaqUJRCGWlnTeiaHibvJJbX9sv6N6VYvZsAnA/', null, null, null, null, '9', 'WT01450');
INSERT INTO `user` VALUES ('1272', '205', '车传利', 'Harrison.Che', '13816613025', '技术部门', 'http://p.qlogo.cn/bizmail/0kAE5W6jh1bRxEibfwSnP0EXxrrcbuniaaibnb9ge9EG2ubwNsshQUzJw/0', null, null, null, null, '4', 'T00259');
INSERT INTO `user` VALUES ('1273', '326', '王菁', 'Chrystal.Wang', '15216781959', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYtUcn0XEkx7XnnBRBeSb19A/', null, null, null, null, '4', 'T04543');
INSERT INTO `user` VALUES ('1274', '447', '黄哲', 'Jay.Huang', '15907140585', '技术部门', 'http://p.qlogo.cn/bizmail/JzTodf9lbOeImqibqBNDMMAfAXPbVLAmbXibicTcXGxQPU9UmTvup5qAw/0', null, null, null, null, '9', 'WT01084');
INSERT INTO `user` VALUES ('1275', '568', '邹恒', 'Kerry.Zou', '18652839743', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRVmSXY4yaVvEV6TuhIk5T0ibqP5RiaeJRxDG1UW7mvM7Kg/', null, null, null, null, '4', 'YT00667');
INSERT INTO `user` VALUES ('1276', '689', '陈武林', 'Kim.Chen', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkRwAqzsYhg2CQe1LBuibHzpOA/', null, null, null, null, '9', 'WT01453');
INSERT INTO `user` VALUES ('1277', '206', '李卫良', 'Lee.Li', '13166211621', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOobGuJOlEibzKVYbgyW4x1wqg/', null, null, null, null, '4', 'T00324');
INSERT INTO `user` VALUES ('1278', '327', '袁丹铃', 'Eileen.Yuan', '15221546857', '技术部门', 'http://p.qlogo.cn/bizmail/hOrAfB8Nic7AJEROCjwEm7IEaPiaXc7QWico4dXFekib1HfqSN7bVYDMKQ/0', null, null, null, null, '4', 'T04545');
INSERT INTO `user` VALUES ('1279', '448', '江露', 'Ailsa.Jiang', '13007105616', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRlA63nvS0EJCNFBXeyk3vXPgXCPWVF4Hyy2x9aH7ia2ag/', null, null, null, null, '9', 'WT01089');
INSERT INTO `user` VALUES ('1280', '569', '刘瑞良', 'Allen.Liu', '13298312260', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRVmSXY4yaVvEV6TuhIk5T0INACFicD84vOuT9DMrrVsVQ/', null, null, null, null, '4', 'YT00668');
INSERT INTO `user` VALUES ('1281', '207', '朱吉飞', 'Geoffrey.Zhu', '13585744337', '技术部门', 'http://p.qlogo.cn/bizmail/KLxdr2HWYVONO6KOad5MGS98e9bnk2JwczZx6lEJMpoBNJ5pGcWe5Q/0', null, null, null, null, '4', 'T00408');
INSERT INTO `user` VALUES ('1282', '328', '周彩林', 'Sara.Zhou', '13072115575', '技术部门', 'http://p.qlogo.cn/bizmail/yaq1NjMrykchiaVnBWicLw00IsNvQTEE1zfwEeRaR91UdH6tq4RunR7Q/0', null, null, null, null, '4', 'T04546');
INSERT INTO `user` VALUES ('1283', '449', '高静', 'Jenny.Gao', '13080622003', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSIwFWlRrd2KuiaREhu2ttH2Via1brYRtCaly6hbrFI4kAA/', null, null, null, null, '9', 'WT01094');
INSERT INTO `user` VALUES ('1284', '208', '陈孝军', 'Hunter.Chen', '13419557336', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOofibs1ibUjCibn83P0v9CuzIGA/', null, null, null, null, '9', 'T00646');
INSERT INTO `user` VALUES ('1285', '329', '毛艺丰', 'Mandy.Mao', '15900906473', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmf984h72nQEgc2eKwuIu0TjA/', null, null, null, null, '4', 'T04548');
INSERT INTO `user` VALUES ('1286', '209', '任铮', 'Anson.Ren', '13661441916', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjU4UWtloF5JxVQyLFyFqwmA/', null, null, null, null, '4', 'T00684');
INSERT INTO `user` VALUES ('1287', '690', '付宇威', 'Snow.Fu', '13212706638', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSl3pS2xR7b7ZGBLaBM3AkReXyqqdKSSh4Zyv4G18dSJw/', null, null, null, null, '9', 'WT01455');
INSERT INTO `user` VALUES ('1288', '570', '冯梦阳', 'Matt.Feng', '18860976727', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRO60Gs8IIibnibO4BKzErlJXx47wMbkdJo90hSyQOYAiaVw/', null, null, null, null, '4', 'YT00675');
INSERT INTO `user` VALUES ('1289', '691', '张凡', 'Jeff.Zhang', '18827511835', '技术部门', 'https://p.qlogo.cn/bizmail/beBRlo53Hug2icWLrwr8IuYt089AibnL8TIAIUhGe1QVANcPmSs8SPgQ/0', null, null, null, null, '9', 'WT01456');
INSERT INTO `user` VALUES ('1290', '450', '刘佳', 'Phil.Liu', '15527961987', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7X0TaRaMMWdWbCvZ5RC7xmyQ/', null, null, null, null, '9', 'WT01097');
INSERT INTO `user` VALUES ('1291', '571', '贾桢', 'Elliot.Jia', '13248362701', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRVmSXY4yaVvEV6TuhIk5T0VuhUVicssVlibZ45PHgFjwvg/', null, null, null, null, '4', 'YT00680');
INSERT INTO `user` VALUES ('1292', '692', '赵晓辉', 'Justin.Zhao', '18918350065', '技术部门', '', null, null, null, null, '4', 'T04821');
INSERT INTO `user` VALUES ('1293', '330', '李佳', 'Hellen.Li', '13917939482', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRO60Gs8IIibnibO4BKzErlJXhOQkWCT4RzB83PQPbUcaLQ/', null, null, null, null, '4', 'T04552');
INSERT INTO `user` VALUES ('1294', '451', '王竹', 'Anna.Wang', '13871530975', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoDCleiamkicibuRpiblBcNWIQhw/', null, null, null, null, '9', 'WT01103');
INSERT INTO `user` VALUES ('1295', '572', '韩峰', 'Iven.Han', '18835173963', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSwMLrDhkvGh4Ria7UAY2ZeP1Y79dCk0gGcqJgZ8vQ0VfQ/', null, null, null, null, '4', 'YT00691');
INSERT INTO `user` VALUES ('1296', '693', '何姮', 'Renee.He', '15151558603', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQI38FnFIJ0swib5rIfhn8GLCtl768Iicbt3kHCDnaryicWQ/', null, null, null, null, '6', 'M00182');
INSERT INTO `user` VALUES ('1297', '210', '包黎明', 'Raymond.Bao', '18616205188', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTcg9keGbiaQDiayGmcdeZ1duRkC5nHCqS3kH8czAfibxOpg/', null, null, null, null, '4', 'T00690');
INSERT INTO `user` VALUES ('1298', '331', '王蕾', 'Caroline.Wang', '17717070240', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYWe8g0iamIlP7ibchm2kF8N1w/', null, null, null, null, '4', 'T04553');
INSERT INTO `user` VALUES ('1299', '452', '李伟', 'Levi.Li', '13429887951', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XPaHE53tD8twcr7LPBUvOcg/', null, null, null, null, '9', 'WT01104');
INSERT INTO `user` VALUES ('1300', '573', '符波', 'Borg.Fu', '17758021941', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTcg9keGbiaQDiayGmcdeZ1duQtePxtcFebMoUb9dEVicRAQ/', null, null, null, null, '4', 'YT00693');
INSERT INTO `user` VALUES ('1301', '694', '王璐茜', 'Jasmine.Wang', '17301861619', '技术部门', 'http://wx.qlogo.cn/mmhead/PiajxSqBRaEIXyDh49yh2dHHFPerxnmKDGuMiatEPCF01AKOibsq1UZvw/0', null, null, null, null, '4', 'T04822');
INSERT INTO `user` VALUES ('1302', '211', '贾海涛', 'Boris.Jia', '13774376772', '技术部门', 'http://p.qlogo.cn/bizmail/SJN2VwicRtQvIcEMNRDdxI9jiaoLia9GfnIPzh3xr7xJHnibox1Nc7qnhg/0', null, null, null, null, '4', 'T00714');
INSERT INTO `user` VALUES ('1303', '332', '韩如礁', 'Ken.Han', '13023199062', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRO60Gs8IIibnibO4BKzErlJXWEBicGzl7e9FHIk20yUvFsw/', null, null, null, null, '4', 'T04559');
INSERT INTO `user` VALUES ('1304', '453', '王诗玉', 'Dana.Wang', '13971218037', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSIwFWlRrd2KuiaREhu2ttH2cZ9esXvicgvAbQ1BNxiaS4kg/', null, null, null, null, '9', 'WT01119');
INSERT INTO `user` VALUES ('1305', '574', '刘洋宏', 'Scott.Liu', '17011865800', '技术部门', 'http://p.qlogo.cn/bizmail/u1LbupMHGIrxmZ1OicV00UkSk7emYN1iaLM9WuUAtoS1MAERaXYxDlyw/0', null, null, null, null, '4', 'YT00695');
INSERT INTO `user` VALUES ('1306', '695', '李之礼', 'Ada.Li', '13472432063', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTglEn0517KxhINGAibDiczxeZe8AbyIibMweHtCjVF3Iu5g/', null, null, null, null, '4', 'T04824');
INSERT INTO `user` VALUES ('1307', '212', '王淑棉', 'Eva.Wang', '13917506544', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjetKyp4bxo68epBYI8XEWBQ/', null, null, null, null, '4', 'T00718');
INSERT INTO `user` VALUES ('1308', '333', '薛冰洁', 'Jacob.Xue', '18516533412', '技术部门', 'http://p.qlogo.cn/bizmail/0XVn8sRPhbPr91yBC9UAR5JiaAp7uEQBIbLjzydYKtn1npmzenrlECQ/0', null, null, null, null, '4', 'T04561');
INSERT INTO `user` VALUES ('1309', '454', '阮云', 'Rosa.Ruan', '18271472830', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSaeiakWV1cWRb6ofdcbkhicCnOIfic2BIb0BDQ2SuFTDUyQ/', null, null, null, null, '9', 'WT01126');
INSERT INTO `user` VALUES ('1310', '575', '李状', 'Jordon.Li', '17621590096', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQK1TMB3OMAj8rPw034z5EjFc8xq2hnkfCqtJ31G6jueg/', null, null, null, null, '4', 'YT00696');
INSERT INTO `user` VALUES ('1311', '696', '刘文东', 'Jamie.Liu', '18907226991', '技术部门', 'http://p.qlogo.cn/bizmail/lRjsGne12h725GIHRTf3B7gIvfKGsTbWtG4vRmHjpsbCKzOMwib9ibZA/', null, null, null, null, '9', 'WT01462');
INSERT INTO `user` VALUES ('1312', '213', '姚伟清', 'Tony.Yao', '18601797875', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOofQel7qU6ibc38sk1yiav59hA/', null, null, null, null, '4', 'T00719');
INSERT INTO `user` VALUES ('1313', '334', '蔡世恒', 'Robin.Cai', '17051021509', '技术部门', 'http://p.qlogo.cn/bizmail/1QFqqBdUcdhO3JIxzibOLg8FkygRWvQvKaVLmjmGjzhHWRiatZc3BZUQ/0', null, null, null, null, '4', 'T04562');
INSERT INTO `user` VALUES ('1314', '455', '余婷', 'Amanda.Yu', '13027194699', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSbJuoGKxeJ4sgAe4bhK2Lvr1mdDIgpK770XTzSqZ8xow/', null, null, null, null, '9', 'WT01141');
INSERT INTO `user` VALUES ('1315', '576', '祁生龙', 'Lorne.Qi', '18809428321', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSYhbyzrv8lj0CQ30l3lQWO4ofEfvnFxpqBgibgGOY9LYw/', null, null, null, null, '4', 'YT00699');
INSERT INTO `user` VALUES ('1316', '697', '柯旭芳', 'Cathy.Ke', '18571659668', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQwkU8s5emc4KTm9oawftfn0AK55CWqSBeZNnXTr3fuBw/', null, null, null, null, '11', 'WM00036');
INSERT INTO `user` VALUES ('1317', '214', '肖岗', 'Grayson.Xiao', '15927553462', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQFHhUicsHyYgs2maHXRJhXlEvZenTPuVicC041eiczMC58g/', null, null, null, null, '9', 'T00869');
INSERT INTO `user` VALUES ('1318', '335', '张鹏飞', 'Cooper.Zhang', '15002160943', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKowKRnoADOb2zHibRoCw1j8g/', null, null, null, null, '4', 'T04564');
INSERT INTO `user` VALUES ('1319', '456', '曹芳', 'Linda.Cao', '18672315956', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOolQialmib6bJZm5f0stOPPevQ/', null, null, null, null, '9', 'WT01153');
INSERT INTO `user` VALUES ('1320', '577', '邹子琴', 'Jean.Zou', '18829289799', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTPFbcWmhibd300ubEs9whpWYg2tMxYgtwLIwocnmcdAJA/', null, null, null, null, '4', 'YT00709');
INSERT INTO `user` VALUES ('1321', '698', '李林杰', 'Mark.Li', '13994200779', 'IT部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQqQDaRgWSJ4biaBQYUTKNJ3gT4RS9yKWEM1PzOjicicrIQA/', null, null, null, null, '5', 'M00183');
INSERT INTO `user` VALUES ('1322', '215', '钱波', 'Patrick.Qian', '13636338014', '技术部门', 'http://p.qlogo.cn/bizmail/bsJvx6qT9JlV2oWic7cD6vDxI0fEiakfbJWHK4crMMM1BdibrrjNnYIFw/0', null, null, null, null, '4', 'T00876');
INSERT INTO `user` VALUES ('1323', '336', '蔡海清', 'Dennis.Cai', '18521592870', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTiaJOo4hENibUu0fuOBUPgjXiag62mZ4CdrKX5BFFsE5a6A/', null, null, null, null, '4', 'T04565');
INSERT INTO `user` VALUES ('1324', '457', '胡云', 'Crystal.Hu', '15271861372', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhK67dYIpd4mq3nflX2g9Gv0g/', null, null, null, null, '9', 'WT01162');
INSERT INTO `user` VALUES ('1325', '578', '杨一飞', 'Nick.Yang', '15601811036', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQhwIcQd4hI4ovm9mibjAQhrwQzZrFadEUZb8I28LtXjHA/', null, null, null, null, '4', 'YT00711');
INSERT INTO `user` VALUES ('1326', '699', '何紫文', 'Kevin.He', '18086110726', 'IT部门', 'http://p.qlogo.cn/bizmail/u0VRuh6xS9FA1cKGjVkF81WgAkc45MRtLcXA0R5AByPnfycwLqdf2Q/0', null, null, null, null, '10', 'WM00037');
INSERT INTO `user` VALUES ('1327', '216', '王慧瑜', 'Greta.Wang', '13764006658', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoEBcRpKmsUcSKHuRSCINY2g/', null, null, null, null, '4', 'T00881');
INSERT INTO `user` VALUES ('1328', '337', '胡立平', 'Woody.Hu', '18516581265', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1h0iarmgkiboHoVmFiaFo7UEgw/', null, null, null, null, '4', 'T04568');
INSERT INTO `user` VALUES ('1329', '458', '焦丽', 'Alivia.Jiao', '15377558610', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoHtGf4z3QA3WoeWCRePf1Rw/', null, null, null, null, '9', 'WT01163');
INSERT INTO `user` VALUES ('1330', '579', '王登康', 'Condon.Wang', '18656464369', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQhwIcQd4hI4ovm9mibjAQhrgxchh7FnmAz2PALdBeBMxQ/', null, null, null, null, '4', 'YT00715');
INSERT INTO `user` VALUES ('1331', '217', '王锦宝', 'Irvin.Wang', '13774255564', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTMMvt6eC2pCfn2LWbD6TSmibXVBD1RIknr0HK9coX3Nlg/', null, null, null, null, '4', 'T00892');
INSERT INTO `user` VALUES ('1332', '338', '孙振宇', 'Zack.Sun', '15151825281', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wY1EwsiceeNReSUH0UyezKibUA/', null, null, null, null, '4', 'T04570');
INSERT INTO `user` VALUES ('1333', '459', '余学洲', 'Alex.Yu', '15327390215', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XgpuicmZloMlXaiarJ4Zce34w/', null, null, null, null, '9', 'WT01166');
INSERT INTO `user` VALUES ('1334', '218', '马国安', 'Clement.Ma', '13564986735', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjyMXOjPYel6j2RY5rU43coQ/', null, null, null, null, '4', 'T00909');
INSERT INTO `user` VALUES ('1335', '339', '顾晨鸣', 'Elton.Gu', '15821078068', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQNgEoj5ZTmXVicwjhicJTHoJs6vicQgCqamo0BHCe2mBofg/', null, null, null, null, '4', 'T04578');
INSERT INTO `user` VALUES ('1336', '219', '李文彬', 'Angus.Li', '13524332433', '技术部门', 'http://p.qlogo.cn/bizmail/C7lBa4k3XK4wXUaxFrHZkFEmJian2pkicDlxWriaQ2sNEUibwNrZmOBbGQ/0', null, null, null, null, '4', 'T00937');
INSERT INTO `user` VALUES ('1337', '580', '柏齐慧', 'Morris.Bai', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQhwIcQd4hI4ovm9mibjAQhr4ZribVicTThwGJ5kPAhw4Ojw/', null, null, null, null, '4', 'YT00717');
INSERT INTO `user` VALUES ('1338', '460', '吴潇', 'Fred.Wu', '15071400686', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoSF55Reib7o8R67zUO16fCMA/', null, null, null, null, '9', 'WT01167');
INSERT INTO `user` VALUES ('1339', '581', '苏贺', 'Shane.Su', '18616361024', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQJImORDDtBfox8iaSfgibbiaepmk1SEokpAbicicF7DXK4x4g/', null, null, null, null, '4', 'YT00718');
INSERT INTO `user` VALUES ('1340', '340', '于明清', 'Sam.Yu', '13636610158', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQpOZbcbOrmOwRYQeK17msZMWBwmyMMDGg5WRW238lxDQ/', null, null, null, null, '4', 'T04594');
INSERT INTO `user` VALUES ('1341', '461', '胡诗洁', 'Yolanda.Hu', '13720188652', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsbvGHcXMpIIOenx3ZudTO93A/', null, null, null, null, '9', 'WT01168');
INSERT INTO `user` VALUES ('1342', '582', '杨燕', 'Kathy.Yang', '15201869375', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQFzaLrfQibqOtBKq8FDcFibdQpnN9ZcQSfaSoXyLLVCGGw/', null, null, null, null, '4', 'T04718');
INSERT INTO `user` VALUES ('1343', '220', '赵晓霞', 'Judy.Zhao', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRjtVIk0MmoemMhia5JzwafR8DRFNLV7l7Yp43pCLcpbSA/', null, null, null, null, '4', 'T01026');
INSERT INTO `user` VALUES ('1344', '341', '张庆峰', 'Chris.Zhang', '15251327856', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfVQEPHdgibEPw2PcYpLlWz1Q/', null, null, null, null, '4', 'T04595');
INSERT INTO `user` VALUES ('1345', '462', '宋小林', 'Ivy.Song', '15927271082', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR6N99pbA6VaovOOtqTDYtS8JwGiaPhiaTVpwM5siaDquuXQ/', null, null, null, null, '9', 'WT01175');
INSERT INTO `user` VALUES ('1346', '583', '胡晏', 'Winton.Hu', '13016486010', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicxMRlwlUpFhXNdkTjgydibSg/', null, null, null, null, '9', 'WT01385');
INSERT INTO `user` VALUES ('1347', '221', '贾旻菁', 'Lynn.Jia', '13917714002', '技术部门', 'http://p.qlogo.cn/bizmail/ztLO9b4xHlRA9MpKDoicia0bVGFTuwkJT3U2SzOicfhveL0tAqF4PKXKQ/0', null, null, null, null, '4', 'T01126');
INSERT INTO `user` VALUES ('1348', '342', '李茜', 'Nina.Li', '13771517150', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfmtS1CbOrdpribPCiaDTDbmuQ/', null, null, null, null, '4', 'T04598');
INSERT INTO `user` VALUES ('1349', '463', '王尧', 'Ailsa.Wang', '13667179570', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOo3ibeUTkv4ZQZ2p4kURNVJtA/', null, null, null, null, '9', 'WT01182');
INSERT INTO `user` VALUES ('1350', '584', '周良浩', 'Colin.Zhou', '15971100273', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicpKGyicuSicU41vsXaMtODyHQ/', null, null, null, null, '9', 'WT01386');
INSERT INTO `user` VALUES ('1351', '222', '谭汀', 'Henry.Tan', '13817235955', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTAiazYskwIDQGkPmIcTcrDWywHl3jFhsEg8xg9oTUbLFg/', null, null, null, null, '4', 'T01171');
INSERT INTO `user` VALUES ('1352', '343', '姜莹', 'Tammy.Jiang', '18602139875', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYsIE88Ym8vficwibehn00afvw/', null, null, null, null, '4', 'T04599');
INSERT INTO `user` VALUES ('1353', '464', '付淼', 'Dean.Fu', '15527151644', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOodiawK756z5eKntaDUlPf12A/', null, null, null, null, '9', 'WT01198');
INSERT INTO `user` VALUES ('1354', '585', '石雅玲', 'Sarah.Shi', '13163295676', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSZbWb7lnzF0LibLPT998QYQId6ia9afiaDchsjHhHvibPXXQ/', null, null, null, null, '9', 'WT01384');
INSERT INTO `user` VALUES ('1355', '223', '沈阳城', 'Jesse.Shen', '18616298521', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS6AK6muQGicdrAHbVdN11sZI6d20rZB6KBNamuxxS2icNw/', null, null, null, null, '4', 'T01246');
INSERT INTO `user` VALUES ('1356', '344', '周浩', 'Kerwin.Zhou', '18866975594', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYYFEhSibPWo1On3HT1wDJk3A/', null, null, null, null, '4', 'T04603');
INSERT INTO `user` VALUES ('1357', '465', '彭瑶', 'Ann.Peng', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7XMBHZS0oPUTWJSEzwG7rYlg/', null, null, null, null, '9', 'WT01204');
INSERT INTO `user` VALUES ('1358', '586', '张敏', 'Kathy.Zhang', '15907187402', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSJibHPwv3QiadntMUcG14vYnAXssTe3iaibOV2iczVHeAJwMQ/', null, null, null, null, '9', 'WT01382');
INSERT INTO `user` VALUES ('1359', '224', '姜建', 'Jerry.Jiang', '18930652660', '技术部门', 'http://p.qlogo.cn/bizmail/zp6FvF17HfluL4wJCFMw7hYwrduuHFPjNZFiclYe5MK3fYeXDLGibqIw/0', null, null, null, null, '4', 'T01278');
INSERT INTO `user` VALUES ('1360', '345', '朱新平', 'Allen.Zhu', '18856038023', '技术部门', 'http://p.qlogo.cn/bizmail/yJ2X8icsIC1IWib7pEA9lIeGEJv5pCUpRwUueogLyQnukibgFmQCNOBJA/0', null, null, null, null, '4', 'T04614');
INSERT INTO `user` VALUES ('1361', '466', '陈玉珍', 'Daisy.Chen', '15972926059', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0wnACyDTrxKgwyLsRl9SQibA/', null, null, null, null, '9', 'WT01206');
INSERT INTO `user` VALUES ('1362', '587', '吴锦川', 'Andrew.Wu', '15623544015', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicA65bIeEytOB8LAuiaBlNMuQ/', null, null, null, null, '9', 'WT01398');
INSERT INTO `user` VALUES ('1363', '225', '刘金鑫', 'Jameson.Liu', '15921401029', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRC1L1xR3SfX7sTeibhNwqe2WlAvHNqCFrGibDe94SHP6Lg/', null, null, null, null, '4', 'T01404');
INSERT INTO `user` VALUES ('1364', '346', '白兰兰', 'Debbie.Bai', '18501758729', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmf5N63N4qzpyng7RherdyA6g/', null, null, null, null, '4', 'T04619');
INSERT INTO `user` VALUES ('1365', '467', '罗洪滔', 'Stan.Luo', '15071438913', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7X9uIXphicLNdB6mj1P56PH5A/', null, null, null, null, '9', 'WT01215');
INSERT INTO `user` VALUES ('1366', '588', '田浩', 'Toby.Tian', '15926438655', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicH7ibop8HaUQEvoJFgDDibJ2w/', null, null, null, null, '9', 'WT01399');
INSERT INTO `user` VALUES ('1367', '226', '谢蓉芸', 'Jasmine.Xie', '13764248200', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS9PVicyQJjvtEOXic2VfS1WDN1KZ3Qx1DAcOYicBuRJIhdA/', null, null, null, null, '4', 'T01580');
INSERT INTO `user` VALUES ('1368', '347', '宋姣', 'Grace.Song', '15737937321', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0vbrpcc2n1TRochHX1CGK3w/', null, null, null, null, '4', 'T04624');
INSERT INTO `user` VALUES ('1369', '468', '刘韦韦', 'Mary.Liu', '13016483494', '技术部门', 'http://p.qlogo.cn/bizmail/BOnTlW3PsRiawXTSnNceibu0HoDCmEHBlt8ZIJYfgibHwsRsfbB5CFd0A/0', null, null, null, null, '9', 'WT01226');
INSERT INTO `user` VALUES ('1370', '589', '杨静', 'Aimee.Yang', '17740871037', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQxTYCialm12jmvuSSWm0WMIP35FDrVKB5kbWrVz4THJLg/', null, null, null, null, '4', 'T04731');
INSERT INTO `user` VALUES ('1371', '227', '李卫东', 'Alfie.Li', '13764152666', '技术部门', 'http://p.qlogo.cn/bizmail/ibcibLZuEYPWWG5ibDMl9nPMsBWypc7yxeSF6M4pCicFNMicHLOeicQ7ibeOg/0', null, null, null, null, '4', 'T01598');
INSERT INTO `user` VALUES ('1372', '348', '江艺菲', 'Janet.Jiang', '13524787742', '技术部门', 'http://p.qlogo.cn/bizmail/42z8r1wfG9sLpicDTT2110jOJctSsV83QZ01lYy8tvklYUZ5Wp3VS0A/0', null, null, null, null, '4', 'T04626');
INSERT INTO `user` VALUES ('1373', '469', '张娜', 'Queena.Zhang', '13037179670', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRvl3RzH7HO3iarYDBvVY2R3Ck2yyozURTxZpmwk5Ga61g/', null, null, null, null, '9', 'WT01240');
INSERT INTO `user` VALUES ('1374', '228', '陆文宇', 'Van.Lu', '13817793399', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRt88CuILqvcJx998va13045k7t7n87d5JLA8LficjSFag/', null, null, null, null, '4', 'T01623');
INSERT INTO `user` VALUES ('1375', '349', '傅韵', 'Vanessa.Fu', '15921601193', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsNwVgCBgGvfn4IGzrb5VypqLfNTUC6KlzOh4RX5bkWA/', null, null, null, null, '4', 'T04627');
INSERT INTO `user` VALUES ('1376', '229', '刘苗苗', 'Michaela.Liu', '13585703268', '技术部门', 'http://p.qlogo.cn/bizmail/JZtwkLKKkhB0tFOuLJM5jFzYdfSobX93GzydquBGAycBEYToURxIVw/0', null, null, null, null, '4', 'T01760');
INSERT INTO `user` VALUES ('1377', '590', '周颖', 'Marvin.Zhou', '18621542532', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicP3vo3fTSf9shWJCCxraEeA/', null, null, null, null, '4', 'T04726');
INSERT INTO `user` VALUES ('1378', '470', '陈婷', 'Helen.Chen', '13697344158', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0dnNKH7ibyJtrYoFUGx2Uygg/', null, null, null, null, '9', 'WT01246');
INSERT INTO `user` VALUES ('1379', '591', '田申', 'William.Tian', '13482447162', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicgI4Eo21NeemiaShfN45KNiaQ/', null, null, null, null, '4', 'T04730');
INSERT INTO `user` VALUES ('1380', '350', '陈鲁雅', 'Celia.Chen', '13041637819', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsRULqtu62OMs7GZTCpsofibFz9iaNkytayLZQVS6ucgCQ/', null, null, null, null, '4', 'T04632');
INSERT INTO `user` VALUES ('1381', '471', '唐杰', 'Melissa.Tang', '13971367331', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoia4sDQmJY8sKbx9libCLfNyg/', null, null, null, null, '9', 'WT01247');
INSERT INTO `user` VALUES ('1382', '592', '曾伟', 'Glen.Zeng', '18397641397', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicPRJBVYqbw0Dc7naicnnjzZg/', null, null, null, null, '9', 'WT01390');
INSERT INTO `user` VALUES ('1383', '230', '黎张捷', 'Harrey.Li', '18616510130', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQaz6RF1EWQ7sPibTmEagVlc8YZReYibUbLNKmrAFEqEJ5g/', null, null, null, null, '4', 'T01997');
INSERT INTO `user` VALUES ('1384', '351', '邱琦', 'Jonathan.Qiu', '13122199959', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYvnIwNacfTC9Pj0Xfl8cC1Q/', null, null, null, null, '4', 'T04640');
INSERT INTO `user` VALUES ('1385', '472', '胡俊', 'Cheryl.Hu', '15827616863', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSW8tMD8XOYZ8HOo8ohJM0wLdjfLjZq3pV0fEwAtvtYtQ/', null, null, null, null, '9', 'WT01253');
INSERT INTO `user` VALUES ('1386', '593', '陈章', 'Eric.Chen', '17717508372', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHic5KjXIRYY4eaAUUaqto6NtQ/', null, null, null, null, '4', 'T04728');
INSERT INTO `user` VALUES ('1387', '231', '刘小方', 'Hermione.Liu', '13764847923', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjXibz20E1WvcbYlFXJFFtf9A/', null, null, null, null, '4', 'T02120');
INSERT INTO `user` VALUES ('1388', '352', '张青', 'Anne.Zhang', '17621987086', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRzRHM0GT4aS46uXudbD7b2GsmFtvhku6J4mlFic6OFLww/', null, null, null, null, '4', 'T04647');
INSERT INTO `user` VALUES ('1389', '473', '刘家生', 'Jesson.Liu', '13545894135', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniaZQVKaQkbMdociaAALP59phhAjokuEdl2AImABgGAAw/', null, null, null, null, '9', 'WT01262');
INSERT INTO `user` VALUES ('1390', '594', '罗志成', 'Lubin.Luo', '18702626962', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicxF9wgTbbdtaAVVibFYw9VpA/', null, null, null, null, '4', 'YT00735');
INSERT INTO `user` VALUES ('1391', '232', '罗耀秋', 'Eriksson.Luo', '13817666959', '技术部门', 'http://p.qlogo.cn/bizmail/q64Bc0m7eNEZ97NjdMvpyFk9Vs1L0W4wKBrbZwspIdgMlGI7x4WjTg/0', null, null, null, null, '4', 'T02165');
INSERT INTO `user` VALUES ('1392', '353', '李世伟', 'Sidney.Li', '15667082820', '技术部门', 'http://p.qlogo.cn/bizmail/738xic2XNUpuoAUcfib4MPlZVZUkGtIhZnpkE7FzuUjF9Hm9johmX8QA/0', null, null, null, null, '4', 'T04656');
INSERT INTO `user` VALUES ('1393', '474', '胡文凯', 'Cara.Hu', '15871779533', '技术部门', 'http://p.qlogo.cn/bizmail/iaqWjsh6vUvevUgUicOhwyqdqH1rsDf5WhhoQuLYp6N8PXn5GHxDMLeQ/0', null, null, null, null, '9', 'WT01263');
INSERT INTO `user` VALUES ('1394', '595', '尹明', 'Edison.Yin', '15779669338', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSJibHPwv3QiadntMUcG14vYnXP6P4WG8OwibE2hyPVq2ZKg/', null, null, null, null, '4', 'YT00736');
INSERT INTO `user` VALUES ('1395', '233', '林春晓', 'Rick.Lin', '15900870300', '技术部门', '', null, null, null, null, '4', 'T02198');
INSERT INTO `user` VALUES ('1396', '354', '王宇', 'Merlin.Wang', '15821705803', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYo3Z5TOBEtRtkffU0U1an8Q/', null, null, null, null, '4', 'T04658');
INSERT INTO `user` VALUES ('1397', '475', '熊丽娟', 'Laura.Xiong', '18571572467', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRt88CuILqvcJx998va1304zxmv1yE75zX8OzlmESbRJw/', null, null, null, null, '9', 'WT01266');
INSERT INTO `user` VALUES ('1398', '596', '王晓静', 'Nina.Wang', '13764773795', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHicjbf0qt3JQBCTQqMDvYxFtw/', null, null, null, null, '6', 'M00177');
INSERT INTO `user` VALUES ('1399', '234', '罗兵', 'Robin.Luo', '18930615208', '技术部门', 'http://p.qlogo.cn/bizmail/OEcjibxicNONa4JoWKV8J1cZGTabDJsgkicEkNrBiaSr1OFVK3pAu4yngA/0', null, null, null, null, '4', 'T02204');
INSERT INTO `user` VALUES ('1400', '355', '李昭颖', 'Ralph.Li', '13795365227', '技术部门', 'http://p.qlogo.cn/bizmail/BHvkCyrbFnia8HTrj8YflKf9I7TldsibWkydYibhHvs2ARucK0N6ibq5Fw/0', null, null, null, null, '4', 'T04659');
INSERT INTO `user` VALUES ('1401', '476', '刘科文', 'Curt.Liu', '13477010753', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz02Z4ab0qaJVicJBy1wkjXTJw/', null, null, null, null, '9', 'WT01269');
INSERT INTO `user` VALUES ('1402', '597', '揭剑', 'Albert.Jie', '18702507756', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHic6YwlLSwyYMjeniadZRp2knw/', null, null, null, null, '4', 'YT00732');
INSERT INTO `user` VALUES ('1403', '235', '周娅妮', 'Charlene.Zhou', '15821686173', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTcg9keGbiaQDiayGmcdeZ1dutgvIvgwXXfOKc2q2DnbA4Q/', null, null, null, null, '4', 'T02214');
INSERT INTO `user` VALUES ('1404', '356', '韦红玉', 'Carina.Wei', '15029964993', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0ga0YaHziaqv6ThhhWZr1WOA/', null, null, null, null, '4', 'T04662');
INSERT INTO `user` VALUES ('1405', '477', '张雷', 'Ron.Zhang', '18771991848', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsb11XP5KG5viaZKIGJfsl2rPw/', null, null, null, null, '9', 'WT01273');
INSERT INTO `user` VALUES ('1406', '598', '李泽', 'Denis.Li', '13100630373', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRNUJ7biaoibGARAJ5HEKcIHic29gaMxA5A3YOtrQev5kl7A/', null, null, null, null, '9', 'WT01406');
INSERT INTO `user` VALUES ('1407', '236', '朱寅', 'Julius.Zhu', '18017809970', '技术部门', 'http://p.qlogo.cn/bizmail/oYZzlCUmyDO5BjFibTPWw4cOcAUTYzNJWOIwgGlcBc0zVvlDAehrZOw/0', null, null, null, null, '4', 'T02227');
INSERT INTO `user` VALUES ('1408', '357', '信伟贺', 'Abner.Xin', '18621662948', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYUSj9rA9sXv9zw1c4IAftwA/', null, null, null, null, '4', 'T04665');
INSERT INTO `user` VALUES ('1409', '478', '周磊', 'Pearl.Zhou', '15102731928', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTqcTD0spicU5hcialnpKVzz0M5WcuN9m7icMaPPoxI7H5Fw/', null, null, null, null, '9', 'WT01280');
INSERT INTO `user` VALUES ('1410', '599', '王盼盼', 'Kitty.Wang', '15800525052', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQMpWaLqiaCnNpoOqibm7YkXgBEwBjkoQkF6dpHpvrfPk0A/', null, null, null, null, '4', 'T04741');
INSERT INTO `user` VALUES ('1411', '237', '李玉翠', 'Josie.Li', '13671705346', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfUqVjVEN6giasyUuzpbFibOrg/', null, null, null, null, '4', 'T02404');
INSERT INTO `user` VALUES ('1412', '358', '曹国辉', 'Matthew.Cao', '15021453617', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYcSfqU1iczufLywW07GR8nyA/', null, null, null, null, '4', 'T04670');
INSERT INTO `user` VALUES ('1413', '479', '陈大双', 'Eddy.Chen', '13260655960', '技术部门', 'http://p.qlogo.cn/bizmail/AvN3se7Bl6Aics6jzJTXpPtGZ80gQFAadjhDQxrr2BNDmrjqyQvcsAQ/0', null, null, null, null, '9', 'WT01295');
INSERT INTO `user` VALUES ('1414', '238', '王志峰', 'Ivan.Wang', '15618389655', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGT8A3KGre9Vqln0xE5UWv5Z6icSMZfREl6iaKqk9LBZ0OcQ/', null, null, null, null, '4', 'T02409');
INSERT INTO `user` VALUES ('1415', '359', '张徵', 'Irvin.Zhang', '13641808467', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTiaJOo4hENibUu0fuOBUPgjXl8PsLpTfaNgffkEHMws9rQ/', null, null, null, null, '4', 'T04672');
INSERT INTO `user` VALUES ('1416', '239', '周融瑛', 'Lila.Zhou', '13512107231', '技术部门', 'http://p.qlogo.cn/bizmail/BH7pLIibrMalHzEaAJc07Nnx7EjIHHRxjYichU1MmK6AiaRv5S93aHMeg/0', null, null, null, null, '4', 'T02417');
INSERT INTO `user` VALUES ('1417', '480', '胡友威', 'Anders.Hu', '13207178773', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRL8Lyic76PbAGBE7IF8c9KeicUrDEomDuKcUbj4auWFl1A/', null, null, null, null, '9', 'WT01301');
INSERT INTO `user` VALUES ('1418', '360', '吴金帅', 'Herman.Wu', '13813753702', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTuUAkxxbp9wtViaia6Eaya566ZaicalP3nFwOhPzv3HUPrw/', null, null, null, null, '4', 'T04673');
INSERT INTO `user` VALUES ('1419', '481', '周磊', 'Noah.Zhou', '15971413680', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTWHdjrOQMp0KauH9RbBt7k9icbNMznNduKUwaJKPwWDdg/', null, null, null, null, '9', 'WT01325');
INSERT INTO `user` VALUES ('1420', '240', '贾学尧', 'Charles.Jia', '13761075725', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRSrUuaI5BCe47s92OK5SEdXc1RXEtQdk7gtiah7htSdtw/', null, null, null, null, '4', 'T02498');
INSERT INTO `user` VALUES ('1421', '361', '郭威', 'Brady.Guo', '18305176013', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRlA63nvS0EJCNFBXeyk3vX9c92Zp8ibF3fQEOBaDj1vQg/', null, null, null, null, '4', 'T04677');
INSERT INTO `user` VALUES ('1422', '482', '李仁耀', 'Lawrence.Li', '15671663763', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTWHdjrOQMp0KauH9RbBt7kjaHicF8HI7JeHTpg969FQyQ/', null, null, null, null, '9', 'WT01327');
INSERT INTO `user` VALUES ('1423', '241', '盛欣义', 'Eason.Sheng', '13564460380', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYCS1WY8Vz6IrmIcIIpqEjQA/', null, null, null, null, '4', 'T02511');
INSERT INTO `user` VALUES ('1424', '362', '幸鹏', 'Stan.Xing', '18390959550', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQbibWm1VbibopwbSmlzR4N3qh5pn3eJByssIK3nQdLvJNA/', null, null, null, null, '4', 'T04678');
INSERT INTO `user` VALUES ('1425', '483', '张广群', 'Quincy.Zhang', '18120570428', '技术部门', 'http://p.qlogo.cn/bizmail/D5RsCOvmjdVfbQ5qKhLTIIMu3MDUU9gwD70iaVJ9o5OuYEM9NqKS7Lw/0', null, null, null, null, '9', 'WT01329');
INSERT INTO `user` VALUES ('1426', '242', '董强', 'Vincent.Dong', '18616890992', '技术部门', 'http://p.qlogo.cn/bizmail/cUSpvibuWDQ3xuSGGcFrFoE8jZoXj5DUDqusRM0qnCkM2jicQsPK3stw/0', null, null, null, null, '4', 'T02534');
INSERT INTO `user` VALUES ('1427', '363', '张乐萌', 'Ian.Zhang', '18366114087', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTuUAkxxbp9wtViaia6Eaya56iaDz2Qbviazn8ucBYZjhVRkg/', null, null, null, null, '4', 'T04682');
INSERT INTO `user` VALUES ('1428', '484', '何静', 'Miranda.He', '18163912056', '技术部门', 'http://p.qlogo.cn/bizmail/smaOs5IXoQh9cosribs3aoSAuadQg7h8fjVnJfEscbUhxzJ0l74CN5g/0', null, null, null, null, '9', 'WT01333');
INSERT INTO `user` VALUES ('1429', '243', '周仕彬', 'Benny.Zhou', '15821441181', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQPdSVTVjMIbEzvvV30anxhTuWKaiblUcsCgIH0QbkNYdg/', null, null, null, null, '4', 'T02623');
INSERT INTO `user` VALUES ('1430', '364', '钱梦颖', 'Mary.Qian', '18362972608', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYFKmNSiadNer06HYsdc5dFJg/', null, null, null, null, '4', 'T04684');
INSERT INTO `user` VALUES ('1431', '485', '董森琛', 'Stannis.Dong', '13554492865', '技术部门', 'http://p.qlogo.cn/bizmail/uIX7o3MvgLgMiceqKwiahHZT8SV2kibaPQRiaPyxHBQEib12zlFbe6ibnMrQ/0', null, null, null, null, '9', 'WT01335');
INSERT INTO `user` VALUES ('1432', '244', '周锋', 'Steven.Zhou', '18621796185', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfFw3ficJxoVnIjSz26NHtvnQ/', null, null, null, null, '4', 'T02836');
INSERT INTO `user` VALUES ('1433', '365', '崔亚楠', 'Nancy.Cui', '15618358305', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRslLzjEb3lf5ZiaCBEnicRKt5YwDvoGKA2ThwablnEwxJA/', null, null, null, null, '4', 'T04695');
INSERT INTO `user` VALUES ('1434', '486', '徐梦蕾', 'Jenny.Xu', '15071410475', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRI0iac1kNNlYu0h3CEFwJJWlYeG3iccNIiaAfiaj9mRn4vaQ/', null, null, null, null, '9', 'WT01336');
INSERT INTO `user` VALUES ('1435', '245', '徐麟军', 'Leo.Xu', '13585998937', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQ9ZIwGBESzbEEk6KAFcpJRbRc8wpQ6EG4a0QicDthNtbw/', null, null, null, null, '4', 'T02848');
INSERT INTO `user` VALUES ('1436', '366', '楚肖肖', 'Sharon.Chu', '18463750858', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYcesVINP5OGBwtaBXdDmK6g/', null, null, null, null, '4', 'T04700');
INSERT INTO `user` VALUES ('1437', '487', '胡文龙', 'Paul.Hu', '15171505790', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniaZQVKaQkbMdociaAALP59PpgYIWOxOeG2n1OiajUxBicQ/', null, null, null, null, '9', 'WT01342');
INSERT INTO `user` VALUES ('1438', '246', '方璐', 'Jessica.Fang', '13816655083', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQ9ZIwGBESzbEEk6KAFcpJRFoDZKTy6N9v0TicBzAibltzw/', null, null, null, null, '4', 'T02967');
INSERT INTO `user` VALUES ('1439', '367', '郝胜骏', 'Oliver.Hao', '15066229137', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYdgib0bJwR2Olt9BdyRZbbbQ/', null, null, null, null, '4', 'T04701');
INSERT INTO `user` VALUES ('1440', '488', '高峰', 'Joseph.Gao', '15007125215', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSIwFWlRrd2KuiaREhu2ttH2hL5ZbYgLUD7IcVXzzhdAibw/', null, null, null, null, '9', 'WT01346');
INSERT INTO `user` VALUES ('1441', '247', '徐成伟', 'Wiley.Xu', '15800644682', '技术部门', 'http://p.qlogo.cn/bizmail/APKIqMgxdia64PJ2u5TmuZ0USUJKkR2h5PhQY2PExWZj5qTk9icubmNA/0', null, null, null, null, '4', 'T02992');
INSERT INTO `user` VALUES ('1442', '368', '门艳妮', 'Carrie.Men', '13589136362', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYdXnawrlaXgoyMrk92aIyWA/', null, null, null, null, '4', 'T04704');
INSERT INTO `user` VALUES ('1443', '489', '潘明洋', 'Simon.Pan', '17607161039', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSIwFWlRrd2KuiaREhu2ttH2zYeZhekXXEbDr71lptNjGQ/', null, null, null, null, '9', 'WT01349');
INSERT INTO `user` VALUES ('1444', '248', '李宁宁', 'Lynn.Li', '13524781507', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRlA63nvS0EJCNFBXeyk3vX31Tb3Ziafaxa2wCPQhcZ89Q/', null, null, null, null, '4', 'T02997');
INSERT INTO `user` VALUES ('1445', '369', '张丹', 'Amelie.Zhang', '15821576993', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYb3mtvDgzsokUeXRd6wfjRw/', null, null, null, null, '4', 'T04713');
INSERT INTO `user` VALUES ('1446', '249', '王志锐', 'Ryan.Wang', '17317926673', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYOUIHe8r8mM0dM5S92IYn7Q/', null, null, null, null, '4', 'T03038');
INSERT INTO `user` VALUES ('1447', '490', '朱良洲', 'Amos.Zhu', '18825820614', '技术部门', 'http://p.qlogo.cn/bizmail/f7PqzKicciaNl1ekrqcEfWxvf7uGfIXfqTRwQicr4pcKYoVF7OcmCHYPA/0', null, null, null, null, '9', 'WT01352');
INSERT INTO `user` VALUES ('1448', '370', '蒋诗予', 'Zoe.Jiang', '15861810878', '技术部门', 'http://p.qlogo.cn/bizmail/VBpgvJTNPib8ovU6PXquSeUjrXbQfdw39nvG3GX0ykMoU7qP4QFJibWg/0', null, null, null, null, '4', 'T04715');
INSERT INTO `user` VALUES ('1449', '491', '王潇', 'Selina.Wang', '15997464413', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQRjicQZ0dZveuPW9KsSYTT0FLhvNkDJiaQQa0gD3NVgxIQ/', null, null, null, null, '9', 'WT01357');
INSERT INTO `user` VALUES ('1450', '250', '何东野', 'Richard.He', '18516053020', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKAKcDSczl6MzJvl7I0kGoNg/', null, null, null, null, '4', 'T03045');
INSERT INTO `user` VALUES ('1451', '371', '孙楠楠', 'Phil.Sun', '18516538328', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYqwoWk35t9DWJuazMCZiaFqw/', null, null, null, null, '4', 'T04716');
INSERT INTO `user` VALUES ('1452', '492', '王瑞琪', 'Jimmy.Wang', '18140671961', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQgZh0y7icm6PYjlRXaia0LK5U8ia5695ESMuM7t6icTCXM7Q/', null, null, null, null, '9', 'WT01363');
INSERT INTO `user` VALUES ('1453', '251', '姜宏艳', 'Judith.Jiang', '18516589539', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKibUTaiaOAHu3ibsIrw9dBIZjQ/', null, null, null, null, '4', 'T03061');
INSERT INTO `user` VALUES ('1454', '372', '王晶珺', 'Sophie.Wang', '15927001222', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQK1TMB3OMAj8rPw034z5EjOHHkMuT42UMJsgbvBWSWfw/', null, null, null, null, '11', 'WM00005');
INSERT INTO `user` VALUES ('1455', '493', '蔡金海', 'Cesar.Cai', '15927471480', '技术部门', 'http://p.qlogo.cn/bizmail/WvdCI5Via6vtT2W9LXuxWTlX8ySS0GAdgPq8Nm2fQW726XUUErgalnw/0', null, null, null, null, '9', 'WT01365');
INSERT INTO `user` VALUES ('1456', '252', '徐燕婷', 'Immonen.Xu', '15021642639', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKiaGRZ3E65n9VQTBdAmT1Jpg/', null, null, null, null, '4', 'T03080');
INSERT INTO `user` VALUES ('1457', '373', '刘琼', 'Bella.Liu', '13437111105', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxcicOgcTcg3GSv3dRkEQ5yIQ/', null, null, null, null, '11', 'WM00016');
INSERT INTO `user` VALUES ('1458', '494', '罗缘', 'Rudolf.Luo', '15629129718', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQV4KPCHUY8paWbu0xxKma6Yn7gQKjWZCyy2jv1icnVJgQ/', null, null, null, null, '9', 'WT01366');
INSERT INTO `user` VALUES ('1459', '253', '曾梅清', 'Michelle.Zeng', '13764925502', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsbWcHutalE4ibtTiatBUa6Ojug/', null, null, null, null, '4', 'T03090');
INSERT INTO `user` VALUES ('1460', '374', '张萌', 'Alice.Zhang', '13627232050', '行政部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGS9PVicyQJjvtEOXic2VfS1WDjY049SRxfjOU6IlUpt4pUA/', null, null, null, null, '13', 'WM00018');
INSERT INTO `user` VALUES ('1461', '495', '付磊', 'Ray.Fu', '18627854361', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRjtVIk0MmoemMhia5JzwafR4eddJTTrEzZegLmZbicjwicQ/', null, null, null, null, '9', 'WT01368');
INSERT INTO `user` VALUES ('1462', '254', '刘金海', 'Hardy.Liu', '13764577512', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTWugR0PWr5c3j1soYyTzLMo2MkL3nGYbsiayWgzVqHHdg/', null, null, null, null, '4', 'T03105');
INSERT INTO `user` VALUES ('1463', '375', '杨祎', 'Allie.Yang', '13297071892', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxSZhx4r04bpJZiamIC0q9uyQ/', null, null, null, null, '11', 'WM00031');
INSERT INTO `user` VALUES ('1464', '496', '兰巡', 'Cherry.Lan', '13207157391', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQRjicQZ0dZveuPW9KsSYTT0kTTspDFve4d6RvAblwwTAg/', null, null, null, null, '9', 'WT01370');
INSERT INTO `user` VALUES ('1465', '255', '曾庆鑫', 'Alvin.Zeng', '18621572652', '技术部门', 'http://p.qlogo.cn/bizmail/q8v69zaXTCKxsvF2FsDdaic74z2JPgbXCXDkibITGM4ficaibYbPpATwyA/0', null, null, null, null, '4', 'T03117');
INSERT INTO `user` VALUES ('1466', '376', '张聪', 'Charlie.Zhang', '13317132820', '技术部门', 'http://p.qlogo.cn/bizmail/KdmtGfdzueibX23BxfOJ7cRtglFXVIDiaA3PudCZkbv6G64qNgibVFhgQ/0', null, null, null, null, '9', 'WT00008');
INSERT INTO `user` VALUES ('1467', '497', '杨梦瑶', 'Sandy.Yang', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTNqI7MGIFiaSqJHCvDWR1gic1lR1MP7CVVQTg8zXzWWUiaA/', null, null, null, null, '9', 'WT01371');
INSERT INTO `user` VALUES ('1468', '256', '钱皆康', 'Jacky.Qian', '13817635847', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKJLibCN5eUoZm958md2rZcEw/', null, null, null, null, '4', 'T03142');
INSERT INTO `user` VALUES ('1469', '377', '任璐明', 'Lena.Ren', '17607151762', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxyJHicWH4ibWHVFUvaaNYNQgA/', null, null, null, null, '9', 'WT00034');
INSERT INTO `user` VALUES ('1470', '498', '陈福琴', 'Iris.Chen', '13665243924', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhK3icZ9RmvRAHvOnrkNFnWunA/', null, null, null, null, '7', 'YM00003');
INSERT INTO `user` VALUES ('1471', '257', '马鑫鑫', 'Emma.Ma', '13681734551', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmf2HUAIhgibJurTgtsFaqPYIQ/', null, null, null, null, '4', 'T03167');
INSERT INTO `user` VALUES ('1472', '378', '刘博', 'Alec.Liu', '15629059660', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoWRTjKylK4bybho48u51aicA/', null, null, null, null, '9', 'WT00041');
INSERT INTO `user` VALUES ('1473', '499', '藤薇', 'Vivian.Teng', '13815801520', '行政部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRvl3RzH7HO3iarYDBvVY2R3PECk4PwbQl0Tp1YDJQfW6A/', null, null, null, null, '8', 'YM00005');
INSERT INTO `user` VALUES ('1474', '258', '陈铮', 'Charles.Chen', '18817513042', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1mcfqBt4Ws0UcsLjNWFdPhQ/', null, null, null, null, '4', 'T03193');
INSERT INTO `user` VALUES ('1475', '379', '胡仕龙', 'Lonnie.Hu', '18696174216', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkjmd2xMF1Q3dT5z9jNas7ktA/', null, null, null, null, '9', 'WT00054');
INSERT INTO `user` VALUES ('1476', '259', '毛春华', 'Parker.Mao', '15021932820', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhK43kjryRicLF36UVL78vPw0A/', null, null, null, null, '4', 'T03216');
INSERT INTO `user` VALUES ('1477', '380', '丁贝', 'Betty.Ding', '13657262683', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKBaX6Gmz7BGBcvrEjwGTVUA/', null, null, null, null, '9', 'WT00061');
INSERT INTO `user` VALUES ('1478', '260', '石贞', 'Dora.Shi', '13127635551', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYmXbmpiaulThI0h9fJL7l0Sg/', null, null, null, null, '4', 'T03252');
INSERT INTO `user` VALUES ('1479', '381', '姚小伟', 'Willey.Yao', '18986085038', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhK4nAvpChYdORuicuAVicfHECw/', null, null, null, null, '9', 'WT00081');
INSERT INTO `user` VALUES ('1480', '261', '黄英', 'Sheila.Huang', '18064020203', '技术部门', 'http://p.qlogo.cn/bizmail/Qo7MF6EB1Q8J9Jsfibe1bgV8TfdxBI0icDpBbINsMqY0S6jBtwxOibyOQ/0', null, null, null, null, '9', 'T03266');
INSERT INTO `user` VALUES ('1481', '382', '冯晨', 'Chester.Feng', '18627086012', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUmenrGhNjJyb6LCQwoBZxY5BDppWj0ofQDNJ3mvBf9A/', null, null, null, null, '9', 'WT00119');
INSERT INTO `user` VALUES ('1482', '262', '沈瑜', 'Selena.Shen', '18621566791', '技术部门', 'http://p.qlogo.cn/bizmail/von7SA6BjzQ68ibCibDONDPSVRknfiay5vv9ExMWOwmxEtBpaibu7ibgysA/0', null, null, null, null, '4', 'T03306');
INSERT INTO `user` VALUES ('1483', '383', '凌舟', 'Linus.Ling', '13477058335', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhK4J5qHvKopnDYNmxlWBNHtQ/', null, null, null, null, '9', 'WT00148');
INSERT INTO `user` VALUES ('1484', '263', '黄剑', 'Ken.Huang', '13611804756', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKBapic2U8FDKkw1f4oUnYkCw/', null, null, null, null, '4', 'T03307');
INSERT INTO `user` VALUES ('1485', '384', '李艳霞', 'Ella.Li', '13297090286', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQPYYTsIqSbZv7GVZ8n0mPYB0LvcKTaahesOicwGdHpcWw/', null, null, null, null, '9', 'WT00158');
INSERT INTO `user` VALUES ('1486', '264', '宋万鹏', 'Johnny.Song', '13817704287', '技术部门', 'http://p.qlogo.cn/bizmail/U9Y3ngojsNDeq4Vp5cY42zGbmC8AVgLUcKKvIFJAAtNA1nia9lVDGfg/0', null, null, null, null, '4', 'T03317');
INSERT INTO `user` VALUES ('1487', '385', '孙明明', 'Mindy.Sun', '13554193728', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR84zlgaArwbr0jP5t513eS81AwcbJv3MaqpJwew4oHxw/', null, null, null, null, '9', 'WT00166');
INSERT INTO `user` VALUES ('1488', '265', '胡翔', 'Hugh.Hu', '13262266083', '技术部门', 'http://p.qlogo.cn/bizmail/mvHpK0MmZV73VPKK3Ch1Mm59j57tylpIFZknkvyj85tTice95Gx5u2A/0', null, null, null, null, '4', 'T03318');
INSERT INTO `user` VALUES ('1489', '386', '范超', 'Fred.Fan', '13657247875', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSW8tMD8XOYZ8HOo8ohJM0wCuPJUT4mavf03iaziblXY6zw/', null, null, null, null, '9', 'WT00178');
INSERT INTO `user` VALUES ('1490', '266', '马海平', 'Lucy.Ma', '13162673800', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYeJVyRuTMictd8kMMibQ1zJ9g/', null, null, null, null, '4', 'T03319');
INSERT INTO `user` VALUES ('1491', '387', '李成', 'Jacky.Li', '13797051500', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKLrBNbdxNBfb82Ng8oU1KNA/', null, null, null, null, '9', 'WT00185');
INSERT INTO `user` VALUES ('1492', '267', '邱言书', 'Sonia.Qiu', '15921972367', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQltcHYFbKhvAo5QGoLM1Upz9PqvZ8ZR67uTEia0Foiaxow/', null, null, null, null, '9', 'T03401');
INSERT INTO `user` VALUES ('1493', '388', '唐宏渊', 'Gary.Tang', '18186126166', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRhYSlcVPZ4za95IyoHiaNj4ZcvCjpT7cCWicjibKXtlx0hA/', null, null, null, null, '9', 'WT00191');
INSERT INTO `user` VALUES ('1494', '268', '吴迅', 'Benson.Wu', '15000397318', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTGt7dmbHkVoxZsd3QC9OldCiaWTHIDZYGKB7NOmqqT4oQ/', null, null, null, null, '4', 'T03456');
INSERT INTO `user` VALUES ('1495', '389', '邓舒婷', 'Tina.Deng', '15926411320', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKDY7VxiaL9gJlwHulBR7x8tw/', null, null, null, null, '9', 'WT00254');
INSERT INTO `user` VALUES ('1496', '269', '闫二凯', 'Korey.Yan', '18801625876', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRTaqCQDMBnbol3yTNI2hgqc7QV5p3xGkjM6eHSW3zicQg/', null, null, null, null, '4', 'T03513');
INSERT INTO `user` VALUES ('1497', '390', '邹蕾', 'Willa.Zou', '13797060210', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRL8Lyic76PbAGBE7IF8c9KeHibVVpeZY9GPQibpqBA38eqA/', null, null, null, null, '9', 'WT00265');
INSERT INTO `user` VALUES ('1498', '270', '朱成亮', 'Richie.Zhu', '18621371912', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQtwHoicvl5x7xvKz2QNibIriblic90j6hNg8BmoTm5QsovWg/', null, null, null, null, '4', 'T03515');
INSERT INTO `user` VALUES ('1499', '391', '徐飞', 'Mavis.Xu', '15102721231', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRTaqCQDMBnbol3yTNI2hgqnnyTGTjbOuibcYzu4JziccicQ/', null, null, null, null, '9', 'WT00266');
INSERT INTO `user` VALUES ('1500', '271', '洪浩', 'Hoover.Hong', '15618984696', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQPdSVTVjMIbEzvvV30anxh7ThtgzzL4Ruefed9XECHCA/', null, null, null, null, '4', 'T03529');
INSERT INTO `user` VALUES ('1501', '392', '吕成龙', 'Chester.Lv', '15071185351', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKtXBZXnrQmCLoxyrciaydg4Q/', null, null, null, null, '9', 'WT00267');
INSERT INTO `user` VALUES ('1502', '272', '孙巧飞', 'Brian.Sun', '13817598754', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQ9ZIwGBESzbEEk6KAFcpJRpshIU0guCfnicyWfKiaKzcDg/', null, null, null, null, '4', 'T03530');
INSERT INTO `user` VALUES ('1503', '393', '马安萍', 'Patty.Ma', '13297000036', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkj08DewoV1KPCXiaxE0lNWwWg/', null, null, null, null, '9', 'WT00274');
INSERT INTO `user` VALUES ('1504', '273', '成李波', 'Gilbert.Cheng', '13564621916', '技术部门', 'http://p.qlogo.cn/bizmail/jH5vy4YzxsavPTk4ibo8lYiafMlKj7XQsdzvhNiaGqt1K3iaE42BP03vDw/0', null, null, null, null, '4', 'T03611');
INSERT INTO `user` VALUES ('1505', '394', '杨越', 'Ansel.Yang', '15927396083', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSW8tMD8XOYZ8HOo8ohJM0wvx5JGuqvC2ShuoCbxOIn7A/', null, null, null, null, '9', 'WT00303');
INSERT INTO `user` VALUES ('1506', '274', '申屠超群', 'Rico.Shentu', '15801801656', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQGP0ibLd1GNNBjGGSM8zmRkVWdRqNIWt0k3SRppWUdFoQ/', null, null, null, null, '4', 'T03641');
INSERT INTO `user` VALUES ('1507', '395', '镇丽玲', 'Eileen.Zhen', '', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTpj6HT5FFqRbrNkQwujtOoGribkNP1nSj9VzEXqt1rLvQ/', null, null, null, null, '9', 'WT00313');
INSERT INTO `user` VALUES ('1508', '275', '付康', 'Keith.Fu', '13162779568', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQ9ZIwGBESzbEEk6KAFcpJRHCS4wYCT4hf70saNjAFGiaw/', null, null, null, null, '4', 'T03646');
INSERT INTO `user` VALUES ('1509', '396', '姜吉', 'Giles.Jiang', '13476122598', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQltcHYFbKhvAo5QGoLM1Upt9uk6VagLIyYriaxHwbvHdQ/', null, null, null, null, '9', 'WT00319');
INSERT INTO `user` VALUES ('1510', '276', '王永浩', 'Aaron.Wang', '13671776639', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKQiazr5icrsl2icYwb8IFth7Cg/', null, null, null, null, '4', 'T03734');
INSERT INTO `user` VALUES ('1511', '397', '蒋立华', 'Helena.Jiang', '13476215349', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKPwia9O926kMWFjH6l445w0A/', null, null, null, null, '9', 'WT00337');
INSERT INTO `user` VALUES ('1512', '277', '朱家鹏', 'Jayden.Zhu', '18516548275', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRwbiaH0Z4CcajkK57icLE8LKnP24xZn8kvULaAFSPwcqgQ/', null, null, null, null, '4', 'T03737');
INSERT INTO `user` VALUES ('1513', '398', '韦燕娜', 'Yolanda.Wei', '13607173606', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKoHiaogP4IQs1FddkuIYu1mg/', null, null, null, null, '9', 'WT00339');
INSERT INTO `user` VALUES ('1514', '278', '蔡添华', 'Vivian.Cai', '18221786124', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1LLv154VB4qM7dCUvZ5C2sQ/', null, null, null, null, '4', 'T03788');
INSERT INTO `user` VALUES ('1515', '399', '刘俊佩', 'Peter.Liu', '15271907149', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQltcHYFbKhvAo5QGoLM1UpyFwxpiafkls8clS2Rl2acrg/', null, null, null, null, '9', 'WT00376');
INSERT INTO `user` VALUES ('1516', '279', '刘国栋', 'Ritchie.Liu', '18660977518', '技术部门', 'http://p.qlogo.cn/bizmail/5ecqY5PqwnSH5qNCfLz18hSqmcp6AValgLplnSF8I5icmepz01cFFag/0', null, null, null, null, '4', 'T03807');
INSERT INTO `user` VALUES ('1517', '280', '阙小钧', 'Matthew.Que', '13122053762', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQpOZbcbOrmOwRYQeK17msZjsSVLNWYZaftJdiblub9fow/', null, null, null, null, '4', 'T03811');
INSERT INTO `user` VALUES ('1518', '281', '陈龙', 'Tristan.Chen', '13918196314', '技术部门', 'http://p.qlogo.cn/bizmail/7VGbFCicDvxRnU922uvH3OOic0V96mMjnHmu4ib3LMeSdfia6asKqS2JBA/0', null, null, null, null, '4', 'T03830');
INSERT INTO `user` VALUES ('1519', '282', '孙磊', 'Jay.Sun', '18721528771', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKIbOTic75pqUkMwdvNnHX8JQ/', null, null, null, null, '4', 'T03838');
INSERT INTO `user` VALUES ('1520', '283', '魏伟', 'Rocky.Wei', '13764665065', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRwbiaH0Z4CcajkK57icLE8LKsHQShWVaBicPjC4NWeQvgNw/', null, null, null, null, '4', 'T03840');
INSERT INTO `user` VALUES ('1521', '284', '田瑛', 'Claire.Tian', '18516585569', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKQto8nRe7GT9Yu3BXrPHPBg/', null, null, null, null, '4', 'T03857');
INSERT INTO `user` VALUES ('1522', '285', '张同宝', 'Jackie.Zhang', '18221889060', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSUhm3B0wZJwPkLSeQVneXicCDqk2gk3jSeiakFX0VSchhg/', null, null, null, null, '4', 'T03873');
INSERT INTO `user` VALUES ('1523', '286', '王路林', 'Ivy.Wang', '13621779025', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQHJQ6ib20DR6w4HwDdB50VEgUQP80VShhruWichBriaYDJw/', null, null, null, null, '4', 'T03878');
INSERT INTO `user` VALUES ('1524', '287', '朱君', 'Katherine.Zhu', '18018503430', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYb4zqhCzIVYMW9Ue2ElPJ6Q/', null, null, null, null, '4', 'T03918');
INSERT INTO `user` VALUES ('1525', '288', '程阳', 'Wesley.Cheng', '18217023066', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSVtHoSP06n9HF10fmJXKa1NeYNLTFAKjNsAsrgKrsMdQ/', null, null, null, null, '4', 'T03941');
INSERT INTO `user` VALUES ('1526', '289', '王思婷', 'Margaret.Wang', '17717679615', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYMf1wOXkdHsic42icxOv1dpMg/', null, null, null, null, '4', 'T04024');
INSERT INTO `user` VALUES ('1527', '290', '楼晓羚', 'Kelly.Lou', '13917119517', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wY3y1KDX0ppWj1RTiaM8dkcIA/', null, null, null, null, '4', 'T04031');
INSERT INTO `user` VALUES ('1528', '291', '郑金鑫', 'Tony.Zheng', '13564316367', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQsNwVgCBgGvfn4IGzrb5VylCNEhoAVWa5dsleiaUoILWw/', null, null, null, null, '4', 'T04054');
INSERT INTO `user` VALUES ('1529', '292', '张宗宏', 'Anthony.Zhang', '15294193450', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKMgHHicQg900zRibxAA6KL1rA/', null, null, null, null, '4', 'T04078');
INSERT INTO `user` VALUES ('1530', '293', '陈沛元', 'Chester.Chen', '15900676878', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wY3GbriaLDiaoGtFoPMoCpjyNw/', null, null, null, null, '4', 'T04081');
INSERT INTO `user` VALUES ('1531', '294', '周胜', 'Richard.Zhou', '15102777472', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGScnFutNDM3CafnrFZZqqqGy60tT4aJ9RXaaB8ZJermVA/', null, null, null, null, '9', 'T04130');
INSERT INTO `user` VALUES ('1532', '295', '王瑞霞', 'Shirley.Wang', '13886002187', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTGt7dmbHkVoxZsd3QC9OldzpWf6ibicSeejCcUwJdU1zSQ/', null, null, null, null, '9', 'T04191');
INSERT INTO `user` VALUES ('1533', '296', '韩笑松', 'Isaac.Han', '15721498319', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKTLGqEErIicGSUAztTicOPTXQ/', null, null, null, null, '4', 'T04194');
INSERT INTO `user` VALUES ('1534', '297', '杨阳', 'Sunny.Yang', '13248195686', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYZHFlxg4EtBtDU6icJmWlMXg/', null, null, null, null, '4', 'T04230');
INSERT INTO `user` VALUES ('1535', '298', '陶佩', 'Penny.Tao', '13167147139', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSniakAWAEUicpx6o0xUjH7wYxq1h7NoNoib6L0BzOZp6v2w/', null, null, null, null, '4', 'T04233');
INSERT INTO `user` VALUES ('1536', '299', '徐杰', 'Jesse.Xu', '15800783709', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRpYXqa6kuLCvTRRn4VpYmfNCJk5Vm7WIKKsmibiaTozXRg/', null, null, null, null, '4', 'T04257');
INSERT INTO `user` VALUES ('1537', '181', '张云燕', 'Yunyan.Zhang', '13585922185', '行政部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGTOicmSB9ZeINf5gz7CWdrDINkJK69dMQSXrmRJQAg0JWA/', null, null, null, null, '8', 'C00002');
INSERT INTO `user` VALUES ('1538', '182', '杨师军', 'Yang', '', '行政部门', '', null, null, null, null, '8', 'G00004');
INSERT INTO `user` VALUES ('1539', '183', '林春晖', 'Arlene.Lin', '15000435908', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQPYYTsIqSbZv7GVZ8n0mPYykr1ibKyP23QiaIrtHZicf1VQ/', null, null, null, null, '7', 'M00005');
INSERT INTO `user` VALUES ('1540', '184', '杨嘉微', 'Julia.Yang', '13761608845', '人力资源部', 'http://p.qlogo.cn/bizmail/amqOWUibsa3TiazsGdYyPALriaZClxtV1Rfboh0Koic2qgb043jmGM8bdA/0', null, null, null, null, '6', 'M00015');
INSERT INTO `user` VALUES ('1541', '185', '张倩倩', 'Annie.Zhang', '13818830845', '行政部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQh7st2WmKua1ddsQMpyRr2SEnUYKh877vAOzwBJLc9OQ/', null, null, null, null, '8', 'M00024');
INSERT INTO `user` VALUES ('1542', '186', '龚艳苹', 'Fiona.Gong', '13916849340', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQOcbTEzkMvzpRUdwZ9kuhKic9mTafGWSJpa7OQGQmlvww/', null, null, null, null, '7', 'M00046');
INSERT INTO `user` VALUES ('1543', '187', '徐宗敏', 'Zongmin.Xu', '13301878738', '行政部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQ95jEujrHNzXMn3p49CpgDKrkfHvPpynEuWjfmQBROSw/', null, null, null, null, '8', 'M00063');
INSERT INTO `user` VALUES ('1544', '188', '叶艮霞', 'Wendy.Ye', '18402701859', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGSiaoEWaJxfG25ricsAEAMuBQQjKibq7l5z4XD5SXSaiafTzA/', null, null, null, null, '12', 'M00084');
INSERT INTO `user` VALUES ('1545', '189', '雷璇江', 'Alfred.Lui', '13918728083', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQh7st2WmKua1ddsQMpyRr2XMiaIpxDaViaOQk6ax3aoe1w/', null, null, null, null, '7', 'M00106');
INSERT INTO `user` VALUES ('1546', '190', '舒海霞', 'Tracy.Shu', '13817254906', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRO60Gs8IIibnibO4BKzErlJX0ibp6LTqKYMZZiaTm3bzqsOA/', null, null, null, null, '7', 'M00110');
INSERT INTO `user` VALUES ('1547', '191', '杨淑芳', 'Susan.Yang', '18017727709', '人力资源部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRWtvZRGYfurIawiaVWlSw7X6l2KiaXicTQZGRh1hj4pD17A/', null, null, null, null, '6', 'M00112');
INSERT INTO `user` VALUES ('1548', '192', '李芝艳', 'Hannah.Li', '13818485190', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGT8A3KGre9Vqln0xE5UWv5Z5DlKSHo4aTzhXYvWgKrLIw/', null, null, null, null, '7', 'M00136');
INSERT INTO `user` VALUES ('1549', '193', '纪列', 'Paul.Ji', '13611794289', 'IT部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRMLgbgib98JWWmJhAtxMibsbf3cyRHibe4wlxV1GA2baRDQ/', null, null, null, null, '5', 'M00169');
INSERT INTO `user` VALUES ('1550', '194', '柴晨曦', 'Connie.Chai', '18260703398', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR6N99pbA6VaovOOtqTDYtSBEdIH8xZiaoia0nHagUkicpog/', null, null, null, null, '7', 'M00172');
INSERT INTO `user` VALUES ('1551', '195', '周明芳', 'Betty.Zhou', '15601715208', '财务部', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGRvl3RzH7HO3iarYDBvVY2R37KwBQpwjVmskMKzI5ZnZmg/', null, null, null, null, '7', 'M00174');
INSERT INTO `user` VALUES ('1552', '196', '周萍', 'Ping.Zhou', '13641839906', '技术部门', 'http://p.qlogo.cn/bizmail/d4RmGPaiac5tzsjT6mv0ibiaic2Am3WhG7UB1rqL0Z7M3icvHRWK3tbd99g/0', null, null, null, null, '4', 'T00001');
INSERT INTO `user` VALUES ('1553', '197', '邵荣', 'Roy.Shao', '13611938666', '技术部门', 'http://p.qlogo.cn/bizmail/Jb4jyIiagFgeib3uPFpjyYRZOufGibnEcMjMABarXUQRsjhOHM1Do7jgw/0', null, null, null, null, '4', 'T00002');
INSERT INTO `user` VALUES ('1554', '198', '侯保国', 'Lory.Hou', '17717589736', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGQNgEoj5ZTmXVicwjhicJTHoJUicp3qtjJ0Bpscksg6JvocA/', null, null, null, null, '4', 'T00012');
INSERT INTO `user` VALUES ('1555', '199', '奕永刚', 'Samuel.Yi', '18939918911', '技术部门', 'http://shp.qpic.cn/bizmp/fIVmibSU0WGR2srgpoaCJPrxXEzEkFfkj5icCaDYpLyyIjw570OiaHhlA/', null, null, null, null, '4', 'T00021');

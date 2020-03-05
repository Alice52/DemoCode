/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50727
Source Host           : 101.132.45.28:3306
Source Database       : zc-education

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-08-25 18:07:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_group
-- ----------------------------

-- ----------------------------
-- Table structure for auth_group_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_permissions`;
CREATE TABLE `auth_group_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissi_permission_id_84c5c92e_fk_auth_permission_id` (`permission_id`),
  CONSTRAINT `auth_group_permissi_permission_id_84c5c92e_fk_auth_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_group_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_01ab375a_uniq` (`content_type_id`,`codename`),
  CONSTRAINT `auth_permissi_content_type_id_2f476e4b_fk_django_content_type_id` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES ('1', 'Can add log entry', '1', 'add_logentry');
INSERT INTO `auth_permission` VALUES ('2', 'Can change log entry', '1', 'change_logentry');
INSERT INTO `auth_permission` VALUES ('3', 'Can delete log entry', '1', 'delete_logentry');
INSERT INTO `auth_permission` VALUES ('4', 'Can view log entry', '1', 'view_logentry');
INSERT INTO `auth_permission` VALUES ('5', 'Can add group', '2', 'add_group');
INSERT INTO `auth_permission` VALUES ('6', 'Can change group', '2', 'change_group');
INSERT INTO `auth_permission` VALUES ('7', 'Can delete group', '2', 'delete_group');
INSERT INTO `auth_permission` VALUES ('8', 'Can add permission', '3', 'add_permission');
INSERT INTO `auth_permission` VALUES ('9', 'Can change permission', '3', 'change_permission');
INSERT INTO `auth_permission` VALUES ('10', 'Can delete permission', '3', 'delete_permission');
INSERT INTO `auth_permission` VALUES ('11', 'Can view group', '2', 'view_group');
INSERT INTO `auth_permission` VALUES ('12', 'Can view permission', '3', 'view_permission');
INSERT INTO `auth_permission` VALUES ('13', 'Can add content type', '4', 'add_contenttype');
INSERT INTO `auth_permission` VALUES ('14', 'Can change content type', '4', 'change_contenttype');
INSERT INTO `auth_permission` VALUES ('15', 'Can delete content type', '4', 'delete_contenttype');
INSERT INTO `auth_permission` VALUES ('16', 'Can view content type', '4', 'view_contenttype');
INSERT INTO `auth_permission` VALUES ('17', 'Can add session', '5', 'add_session');
INSERT INTO `auth_permission` VALUES ('18', 'Can change session', '5', 'change_session');
INSERT INTO `auth_permission` VALUES ('19', 'Can delete session', '5', 'delete_session');
INSERT INTO `auth_permission` VALUES ('20', 'Can view session', '5', 'view_session');
INSERT INTO `auth_permission` VALUES ('21', 'Can add 轮播图信息', '6', 'add_bannerinfo');
INSERT INTO `auth_permission` VALUES ('22', 'Can change 轮播图信息', '6', 'change_bannerinfo');
INSERT INTO `auth_permission` VALUES ('23', 'Can delete 轮播图信息', '6', 'delete_bannerinfo');
INSERT INTO `auth_permission` VALUES ('24', 'Can add 邮箱验证码信息', '7', 'add_emailverifycode');
INSERT INTO `auth_permission` VALUES ('25', 'Can change 邮箱验证码信息', '7', 'change_emailverifycode');
INSERT INTO `auth_permission` VALUES ('26', 'Can delete 邮箱验证码信息', '7', 'delete_emailverifycode');
INSERT INTO `auth_permission` VALUES ('27', 'Can add 用户信息', '8', 'add_userprofile');
INSERT INTO `auth_permission` VALUES ('28', 'Can change 用户信息', '8', 'change_userprofile');
INSERT INTO `auth_permission` VALUES ('29', 'Can delete 用户信息', '8', 'delete_userprofile');
INSERT INTO `auth_permission` VALUES ('30', 'Can view 轮播图信息', '6', 'view_bannerinfo');
INSERT INTO `auth_permission` VALUES ('31', 'Can view 邮箱验证码信息', '7', 'view_emailverifycode');
INSERT INTO `auth_permission` VALUES ('32', 'Can view 用户信息', '8', 'view_userprofile');
INSERT INTO `auth_permission` VALUES ('33', 'Can add 课程信息', '9', 'add_courseinfo');
INSERT INTO `auth_permission` VALUES ('34', 'Can change 课程信息', '9', 'change_courseinfo');
INSERT INTO `auth_permission` VALUES ('35', 'Can delete 课程信息', '9', 'delete_courseinfo');
INSERT INTO `auth_permission` VALUES ('36', 'Can add 资源信息', '10', 'add_sourceinfo');
INSERT INTO `auth_permission` VALUES ('37', 'Can change 资源信息', '10', 'change_sourceinfo');
INSERT INTO `auth_permission` VALUES ('38', 'Can delete 资源信息', '10', 'delete_sourceinfo');
INSERT INTO `auth_permission` VALUES ('39', 'Can add 视频信息', '11', 'add_videoinfo');
INSERT INTO `auth_permission` VALUES ('40', 'Can change 视频信息', '11', 'change_videoinfo');
INSERT INTO `auth_permission` VALUES ('41', 'Can delete 视频信息', '11', 'delete_videoinfo');
INSERT INTO `auth_permission` VALUES ('42', 'Can add 章节信息', '12', 'add_lessoninfo');
INSERT INTO `auth_permission` VALUES ('43', 'Can change 章节信息', '12', 'change_lessoninfo');
INSERT INTO `auth_permission` VALUES ('44', 'Can delete 章节信息', '12', 'delete_lessoninfo');
INSERT INTO `auth_permission` VALUES ('45', 'Can view 课程信息', '9', 'view_courseinfo');
INSERT INTO `auth_permission` VALUES ('46', 'Can view 章节信息', '12', 'view_lessoninfo');
INSERT INTO `auth_permission` VALUES ('47', 'Can view 资源信息', '10', 'view_sourceinfo');
INSERT INTO `auth_permission` VALUES ('48', 'Can view 视频信息', '11', 'view_videoinfo');
INSERT INTO `auth_permission` VALUES ('49', 'Can add 机构信息', '13', 'add_orginfo');
INSERT INTO `auth_permission` VALUES ('50', 'Can change 机构信息', '13', 'change_orginfo');
INSERT INTO `auth_permission` VALUES ('51', 'Can delete 机构信息', '13', 'delete_orginfo');
INSERT INTO `auth_permission` VALUES ('52', 'Can add 城市信息', '14', 'add_cityinfo');
INSERT INTO `auth_permission` VALUES ('53', 'Can change 城市信息', '14', 'change_cityinfo');
INSERT INTO `auth_permission` VALUES ('54', 'Can delete 城市信息', '14', 'delete_cityinfo');
INSERT INTO `auth_permission` VALUES ('55', 'Can add 讲师信息', '15', 'add_teacherinfo');
INSERT INTO `auth_permission` VALUES ('56', 'Can change 讲师信息', '15', 'change_teacherinfo');
INSERT INTO `auth_permission` VALUES ('57', 'Can delete 讲师信息', '15', 'delete_teacherinfo');
INSERT INTO `auth_permission` VALUES ('58', 'Can view 城市信息', '14', 'view_cityinfo');
INSERT INTO `auth_permission` VALUES ('59', 'Can view 机构信息', '13', 'view_orginfo');
INSERT INTO `auth_permission` VALUES ('60', 'Can view 讲师信息', '15', 'view_teacherinfo');
INSERT INTO `auth_permission` VALUES ('61', 'Can add 咨询信息', '16', 'add_userask');
INSERT INTO `auth_permission` VALUES ('62', 'Can change 咨询信息', '16', 'change_userask');
INSERT INTO `auth_permission` VALUES ('63', 'Can delete 咨询信息', '16', 'delete_userask');
INSERT INTO `auth_permission` VALUES ('64', 'Can add 用户消息信息', '17', 'add_usermessage');
INSERT INTO `auth_permission` VALUES ('65', 'Can change 用户消息信息', '17', 'change_usermessage');
INSERT INTO `auth_permission` VALUES ('66', 'Can delete 用户消息信息', '17', 'delete_usermessage');
INSERT INTO `auth_permission` VALUES ('67', 'Can add 收藏信息', '18', 'add_userlove');
INSERT INTO `auth_permission` VALUES ('68', 'Can change 收藏信息', '18', 'change_userlove');
INSERT INTO `auth_permission` VALUES ('69', 'Can delete 收藏信息', '18', 'delete_userlove');
INSERT INTO `auth_permission` VALUES ('70', 'Can add 用户学习课程信息', '19', 'add_usercourse');
INSERT INTO `auth_permission` VALUES ('71', 'Can change 用户学习课程信息', '19', 'change_usercourse');
INSERT INTO `auth_permission` VALUES ('72', 'Can delete 用户学习课程信息', '19', 'delete_usercourse');
INSERT INTO `auth_permission` VALUES ('73', 'Can add 用户评论课程信息', '20', 'add_usercomment');
INSERT INTO `auth_permission` VALUES ('74', 'Can change 用户评论课程信息', '20', 'change_usercomment');
INSERT INTO `auth_permission` VALUES ('75', 'Can delete 用户评论课程信息', '20', 'delete_usercomment');
INSERT INTO `auth_permission` VALUES ('76', 'Can view 咨询信息', '16', 'view_userask');
INSERT INTO `auth_permission` VALUES ('77', 'Can view 用户评论课程信息', '20', 'view_usercomment');
INSERT INTO `auth_permission` VALUES ('78', 'Can view 用户学习课程信息', '19', 'view_usercourse');
INSERT INTO `auth_permission` VALUES ('79', 'Can view 收藏信息', '18', 'view_userlove');
INSERT INTO `auth_permission` VALUES ('80', 'Can view 用户消息信息', '17', 'view_usermessage');
INSERT INTO `auth_permission` VALUES ('81', 'Can add log entry', '21', 'add_log');
INSERT INTO `auth_permission` VALUES ('82', 'Can change log entry', '21', 'change_log');
INSERT INTO `auth_permission` VALUES ('83', 'Can delete log entry', '21', 'delete_log');
INSERT INTO `auth_permission` VALUES ('84', 'Can add User Widget', '22', 'add_userwidget');
INSERT INTO `auth_permission` VALUES ('85', 'Can change User Widget', '22', 'change_userwidget');
INSERT INTO `auth_permission` VALUES ('86', 'Can delete User Widget', '22', 'delete_userwidget');
INSERT INTO `auth_permission` VALUES ('87', 'Can add User Setting', '23', 'add_usersettings');
INSERT INTO `auth_permission` VALUES ('88', 'Can change User Setting', '23', 'change_usersettings');
INSERT INTO `auth_permission` VALUES ('89', 'Can delete User Setting', '23', 'delete_usersettings');
INSERT INTO `auth_permission` VALUES ('90', 'Can add Bookmark', '24', 'add_bookmark');
INSERT INTO `auth_permission` VALUES ('91', 'Can change Bookmark', '24', 'change_bookmark');
INSERT INTO `auth_permission` VALUES ('92', 'Can delete Bookmark', '24', 'delete_bookmark');
INSERT INTO `auth_permission` VALUES ('93', 'Can view Bookmark', '24', 'view_bookmark');
INSERT INTO `auth_permission` VALUES ('94', 'Can view log entry', '21', 'view_log');
INSERT INTO `auth_permission` VALUES ('95', 'Can view User Setting', '23', 'view_usersettings');
INSERT INTO `auth_permission` VALUES ('96', 'Can view User Widget', '22', 'view_userwidget');
INSERT INTO `auth_permission` VALUES ('97', 'Can add captcha store', '25', 'add_captchastore');
INSERT INTO `auth_permission` VALUES ('98', 'Can change captcha store', '25', 'change_captchastore');
INSERT INTO `auth_permission` VALUES ('99', 'Can delete captcha store', '25', 'delete_captchastore');
INSERT INTO `auth_permission` VALUES ('100', 'Can view captcha store', '25', 'view_captchastore');
INSERT INTO `auth_permission` VALUES ('101', 'Can add 用户行为记录信息', '26', 'add_userrecord');
INSERT INTO `auth_permission` VALUES ('102', 'Can change 用户行为记录信息', '26', 'change_userrecord');
INSERT INTO `auth_permission` VALUES ('103', 'Can delete 用户行为记录信息', '26', 'delete_userrecord');
INSERT INTO `auth_permission` VALUES ('104', 'Can view 用户行为记录信息', '26', 'view_userrecord');
INSERT INTO `auth_permission` VALUES ('105', 'Can add django job', '27', 'add_djangojob');
INSERT INTO `auth_permission` VALUES ('106', 'Can change django job', '27', 'change_djangojob');
INSERT INTO `auth_permission` VALUES ('107', 'Can delete django job', '27', 'delete_djangojob');
INSERT INTO `auth_permission` VALUES ('108', 'Can add django job execution', '28', 'add_djangojobexecution');
INSERT INTO `auth_permission` VALUES ('109', 'Can change django job execution', '28', 'change_djangojobexecution');
INSERT INTO `auth_permission` VALUES ('110', 'Can delete django job execution', '28', 'delete_djangojobexecution');
INSERT INTO `auth_permission` VALUES ('111', 'Can view django job', '27', 'view_djangojob');
INSERT INTO `auth_permission` VALUES ('112', 'Can view django job execution', '28', 'view_djangojobexecution');

-- ----------------------------
-- Table structure for captcha_captchastore
-- ----------------------------
DROP TABLE IF EXISTS `captcha_captchastore`;
CREATE TABLE `captcha_captchastore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `challenge` varchar(32) NOT NULL,
  `response` varchar(32) NOT NULL,
  `hashkey` varchar(40) NOT NULL,
  `expiration` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hashkey` (`hashkey`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of captcha_captchastore
-- ----------------------------
INSERT INTO `captcha_captchastore` VALUES ('176', 'ZAIZ', 'zaiz', 'a100451f121cd0f1a40848a3d21b1eabee32899e', '2019-05-03 23:23:09.285091');
INSERT INTO `captcha_captchastore` VALUES ('177', 'OMDJ', 'omdj', '8b03a3c9edfd1cb3377a2fc377efaf032cdb0a7c', '2019-05-03 23:23:25.522814');
INSERT INTO `captcha_captchastore` VALUES ('179', 'ISZM', 'iszm', 'ded87648c32531c560f754f1ec2ad8702700f744', '2019-05-03 23:34:24.882354');
INSERT INTO `captcha_captchastore` VALUES ('180', 'FGYZ', 'fgyz', '1e0a8001441cf4fa7d0d4aad528cb3b11866f22d', '2019-05-06 20:45:38.939867');

-- ----------------------------
-- Table structure for courses_courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `courses_courseinfo`;
CREATE TABLE `courses_courseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(200) NOT NULL,
  `name` varchar(20) NOT NULL,
  `study_time` int(11) NOT NULL,
  `study_num` int(11) NOT NULL,
  `level` varchar(5) NOT NULL,
  `love_num` int(11) NOT NULL,
  `click_num` int(11) NOT NULL,
  `desc` varchar(200) NOT NULL,
  `detail` longtext NOT NULL,
  `category` varchar(5) NOT NULL,
  `course_notice` varchar(200) NOT NULL,
  `course_need` varchar(100) NOT NULL,
  `teacher_tell` varchar(100) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `orginfo_id` int(11) NOT NULL,
  `teacherinfo_id` int(11) NOT NULL,
  `is_banner` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courses_courseinfo_orginfo_id_3d3f29c6_fk_orgs_orginfo_id` (`orginfo_id`),
  KEY `courses_courseinf_teacherinfo_id_fc77d47e_fk_orgs_teacherinfo_id` (`teacherinfo_id`),
  CONSTRAINT `courses_courseinf_teacherinfo_id_fc77d47e_fk_orgs_teacherinfo_id` FOREIGN KEY (`teacherinfo_id`) REFERENCES `orgs_teacherinfo` (`id`),
  CONSTRAINT `courses_courseinfo_orginfo_id_3d3f29c6_fk_orgs_orginfo_id` FOREIGN KEY (`orginfo_id`) REFERENCES `orgs_orginfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses_courseinfo
-- ----------------------------
INSERT INTO `courses_courseinfo` VALUES ('1', 'course/HTMLCSS基础.jpg', '前端三大宝之html', '125', '9', 'cj', '11', '421', '前端必备技能之一，最为基础', '前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础前端必备技能之一，最为基础', 'qd', '前端必备技能之一，最为基础', '自备电脑，基础都要学', '前端必备技能之一，最为基础', '2018-09-21 16:05:00.000000', '1', '1', '0');
INSERT INTO `courses_courseinfo` VALUES ('2', 'course/MySQL高级.jpg', 'mysql基础', '20', '6', 'cj', '2', '96', '数据库中的霸者，用户量最大还免费', '数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费数据库中的霸者，用户量最大还免费', 'hd', '数据库必须要学啊', '自备电脑，都要学数据库的', '数据库必须要学好啊', '2018-09-23 14:25:00.000000', '1', '2', '0');
INSERT INTO `courses_courseinfo` VALUES ('3', 'course/MySQL核心.jpg', 'MySQL高级', '30', '2', 'gj', '2', '69', '数据库的霸者', '数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者数据库的霸者', 'hd', '数据库必须要学啊', '自备电脑，都要学数据库的', '数据库必须要学好啊', '2018-09-23 14:26:00.000000', '1', '2', '0');
INSERT INTO `courses_courseinfo` VALUES ('4', 'course/15130518dbce180821.jpg', 'python全集', '20', '3', 'zj', '1', '60', 'python从入门到放弃python从入门到放弃python从入门到放弃', 'python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃python从入门到放弃', 'hd', '人生苦短，我用python', 'python比较单间容易上手', '一定要把python基础学好', '2018-09-23 14:27:00.000000', '1', '3', '0');
INSERT INTO `courses_courseinfo` VALUES ('5', 'course/140724c11606263861.jpg', 'linux全讲', '0', '2', 'cj', '3', '20', 'linux系统', 'linux系linux系统linux系统统linux系统linux系统linux系统linux系统linux系统linux系统linux系统linux系统', 'hd', '好好学', '好好学', '好好学', '2018-09-30 10:17:00.000000', '1', '1', '0');
INSERT INTO `courses_courseinfo` VALUES ('6', 'course/JavaWeb.jpg', 'javaweb从入门到高级', '0', '1', 'zj', '1', '6', '尚硅谷-老学员为你推荐，有口皆碑的Java培训、HTML5前端培训、大数据培训、Python培训、区块链培训', '尚硅谷-老学员为你推荐，有口皆碑的Java培训、HTML5前端培训、大数据培训、Python培训、区块链培训', 'hd', '好好学', '好好学', '好好学', '2018-09-30 10:18:00.000000', '1', '2', '0');
INSERT INTO `courses_courseinfo` VALUES ('7', 'course/GitHub.jpg', 'git简介', '0', '2', 'gj', '1', '30', '版本管理', '版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理版本管理', 'hd', '好好学', '好好学', '好好学', '2018-09-30 10:19:00.000000', '1', '3', '1');
INSERT INTO `courses_courseinfo` VALUES ('8', 'course/redis_iQcbOMX.jpg', 'redis数据库详解', '0', '3', 'gj', '0', '17', '数据库从删库到跑路数据库从删库到跑路', '数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路数据库从删库到跑路', 'hd', '好好学', '好好学', '好好学', '2018-09-30 10:20:00.000000', '1', '1', '1');
INSERT INTO `courses_courseinfo` VALUES ('9', 'course/jQuery_K49AB1J.jpg', 'jQuery实战', '0', '1', 'zj', '1', '13', 'js的全能框架', 'js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架js的全能框架', 'qd', '好好学', '好好学', '好好学', '2018-09-30 10:21:00.000000', '1', '3', '1');
INSERT INTO `courses_courseinfo` VALUES ('12', 'course/ajax.jpg', 'ajax', '20', '0', 'zj', '1', '10', 'ajax: 局部刷新技术', 'Ajax 即“Asynchronous Javascript And XML”（异步 JavaScript 和 XML），是指一种创建交互式网页应用的网页开发技术。\r\nAjax = 异步 JavaScript 和 XML 或者是 HTML（标准通用标记语言的子集）。\r\nAjax 是一种用于创建快速动态网页的技术。\r\nAjax 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。\r\n通过在后台与服务器进行少量数据交换，Ajax 可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。\r\n传统的网页（不使用 Ajax）如果需要更新内容，必须重载整个网页页面。', 'qd', 'ajax: 局部刷新技术', '有一定的 JavaScript 基础', '好好学习天天向上', '2019-04-16 18:02:00.000000', '2', '5', '0');
INSERT INTO `courses_courseinfo` VALUES ('13', 'course/git.jpg', 'git版本控制工具', '15', '4', 'zj', '0', '22', '优雅的版本控制工具', 'Git(读音为/gɪt/。)是一个开源的分布式版本控制系统，可以有效、高速地处理从很小到非常大的项目版本管理。 [1]  Git 是 Linus Torvalds 为了帮助管理 Linux 内核开发而开发的一个开放源码的版本控制软件。\r\nTorvalds 开始着手开发 Git 是为了作为一种过渡方案来替代 BitKe', 'hd', '优雅的版本控制', '有一定的兴趣', '让天下没有难学的技术', '2019-04-16 18:04:00.000000', '3', '6', '0');
INSERT INTO `courses_courseinfo` VALUES ('14', 'course/idea.jpg', 'idea 工具的使用', '6', '0', 'zj', '0', '1', '讲解idea 工具的使用', 'IDEA 全称IntelliJ IDEA，是用于java语言开发的集成环境（也可用于其他开发语言），IntelliJ在业界被公认为最好的java开发工具之一，尤其在智能代码助手、代码自动提示、重构、J2EE支持、Ant、JUnit、CVS整合、代码审查、 创新的GUI设计等方面的功能可以说是超常的。IDEA是JetBrains公司的产品，这家公司总部位于捷克共和国的首都布拉格，开发人员以严谨著称的东欧程序员为主。', 'hd', 'IntelliJ在业界被公认为最好的java开发工具之一', '有一定的 java 基础', '让天下没有难学的技术', '2019-04-16 18:08:00.000000', '5', '7', '0');
INSERT INTO `courses_courseinfo` VALUES ('15', 'course/java.jpg', 'java 讲解', '28', '0', 'gj', '1', '3', 'java技术的全面讲解', 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程 [1]  。\r\nJava具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点 [2]  。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等 [3]  。', 'hd', 'Java是一门面向对象编程语言', '有一定的 java 基础', '努力学习, 天天向上', '2019-04-16 18:09:00.000000', '3', '4', '0');
INSERT INTO `courses_courseinfo` VALUES ('16', 'course/java8.jpg', 'java8讲解', '20', '1', 'zj', '0', '4', 'java8 全新讲解', 'Java8是Java发布以来改动最大的一个版本，其中主要添加了函数式编程、Stream、一些日期处理类。\r\n函数式编程中中新加了一些概念：Lambda表达式、函数式接口、函数引用、默认方法、Optional类等；Stream中提供了一些流式处理集合的方法，并提供了一些归约、划分等类的方法；日期中添加了ZoneDateTime、DataFormat等线程安全的方法类；', 'hd', 'java8 全新讲解', '有一定的 java 基础', '让天下没有难学的技术', '2019-04-16 18:11:00.000000', '6', '7', '0');
INSERT INTO `courses_courseinfo` VALUES ('17', 'course/javaweb_Cwjnhnb.jpg', 'javaweb 技术讲解', '30', '0', 'zj', '0', '1', 'javaweb 技术讲解', 'Java Web，是用Java技术来解决相关web互联网领域的技术总和。web包括：web服务器和web客户端两部分。Java在客户端的应用有java applet，不过使用得很少，Java在服务器端的应用非常的丰富，比如Servlet，JSP和第三方框架等等。Java技术对Web领域的发展注入了强大的动力。', 'qd', 'javaweb 技术讲解', '有一定的 java 基础', '努力学习, 天天向上', '2019-04-16 18:12:00.000000', '7', '8', '0');
INSERT INTO `courses_courseinfo` VALUES ('18', 'course/js.jpg', 'JavaScript 简介', '20', '0', 'zj', '0', '0', 'JavaScript 简介', 'JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言，最早是在HTML（标准通用标记语言下的一个应用）网页上使用，用来给HTML网页增加动态功能。\r\n在1995年时，由Netscape公司的Brendan Eich，在网景导航者浏览器上首次设计实现而成。因为Netscape与Sun合作，Netscape管理层希望它外观看起来像Java，因此取名为JavaScript。但实际上它的语法风格与Self及Scheme较为接近。 [1] \r\n为了取得技术优势，微软推出了JScript，CEnvi推出ScriptEase，与JavaScript同样可在浏览器上运行。为了统一规格，因为JavaScript兼容于ECMA标准，因此也称为ECMAScript。', 'qd', '让天下没有难学的 javascript', '有一定的兴趣学习前段', '让天下没有难学的技术', '2019-04-16 18:13:00.000000', '9', '9', '0');
INSERT INTO `courses_courseinfo` VALUES ('19', 'course/juc.jpg', 'juc进阶', '8', '0', 'gj', '0', '0', 'juc进阶', '在 Java 5.0 提供了 java.util.concurrent(简称JUC)包,在此包中增加了在并发编程中很常用的工具类,\r\n用于定义类似于线程的自定义子系统,包括线程池,异步 IO 和轻量级任务框架;还提供了设计用于多线程上下文中\r\n的 Collection 实现等;\r\nvolatile 关键字: 当多个线程进行操作共享数据时,可以保证内存中的数据是可见的;相较于 synchronized 是一种\r\n较为轻量级的同步策略;\r\nvolatile 不具备\"互斥性\";\r\nvolatile 不能保证变量的\"原子性\";', 'hd', '海量高并发数据处理', '有一定的 java 基础', '努力学习, 天天向上', '2019-04-16 18:14:00.000000', '10', '11', '0');
INSERT INTO `courses_courseinfo` VALUES ('20', 'course/linux.jpg', 'linux 讲解', '9', '0', 'zj', '0', '1', 'linux 讲解', 'Linux是一套免费使用和自由传播的类Unix操作系统，是一个基于POSIX和UNIX的多用户、多任务、支持多线程和多CPU的操作系统。它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。\r\nLinux操作系统诞生于1991 年10 月5 日（这是第一次正式向外公布时间）。Linux存在着许多不同的Linux版本，但它们都使用了Linux内核。Linux可安装在各种计算机硬件设备中，比如手机、平板电脑、路由器、视频游戏控制台、台式计算机、大型机和超级计算机。\r\n严格来讲，Linux这个词本身只表示Linux内核，但实际上人们已经习惯了用Linux来形容整个基于Linux内核，并且使用GNU 工程各种工具和数据库的操作系统。', 'hd', 'Linux是一套免费使用和自由传播的类Unix操作系统', '有一定的兴趣学习linux', '让天下没有难学的技术', '2019-04-16 18:16:00.000000', '12', '8', '0');
INSERT INTO `courses_courseinfo` VALUES ('21', 'course/mybatisplus.jpg', 'mybatis简介', '12', '0', 'zj', '0', '0', 'mybatis简介', 'MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。\r\niBATIS一词来源于“internet”和“abatis”的组合，是一个基于Java的持久层框架。iBATIS提供的持久层框架包括SQL Maps和Data Access Objects（DAOs）\r\n当前，最新版本是MyBatis 3.5.1 ，其发布时间是2019年4月8日。', 'hd', '数据库管理', '有一定的 mysql 基础', '努力学习, 天天向上', '2019-04-16 18:17:00.000000', '12', '10', '0');
INSERT INTO `courses_courseinfo` VALUES ('22', 'course/nio.jpg', 'nio 简介', '20', '0', 'gj', '0', '0', 'nio 简介', 'nio 简介nio 简介nio 简介nio 简介nio 简介nio 简介', 'hd', '让天下没有难学的 nio', '有一定的 java 基础', '努力学习, 天天向上', '2019-04-16 18:18:00.000000', '14', '11', '0');
INSERT INTO `courses_courseinfo` VALUES ('23', 'course/react.jpg', 'react 简介', '30', '0', 'zj', '0', '4', 'react 简介', 'React 起源于 Facebook 的内部项目，因为该公司对市场上所有 JavaScript MVC 框架，都不满意，就决定自己写一套，用来架设Instagram 的网站。做出来以后，发现这套东西很好用，就在2013年5月开源了。', 'qd', '让天下没有难学的 react', '有一定的兴趣学习前段', '让天下没有难学的技术', '2019-04-16 18:19:00.000000', '14', '16', '0');
INSERT INTO `courses_courseinfo` VALUES ('24', 'course/springboot.jpg', 'springboot简介', '5', '0', 'zj', '0', '2', 'springboot简介', 'springboot简介springboot简介springboot简介springboot简介springboot简介springboot简介', 'hd', '让天下没有难学的 springboot', '有一定的 spring 基础', '让天下没有难学的技术', '2019-04-16 18:21:00.000000', '15', '17', '0');
INSERT INTO `courses_courseinfo` VALUES ('25', 'course/springcloud.jpg', 'springcloud 简介', '50', '0', 'zj', '0', '6', 'springcloud 简介', 'springcloud 简介springcloud 简介springcloud 简介springcloud 简介springcloud 简介springcloud 简介springcloud 简介', 'hd', '让天下没有难学的 springcloud', '有一定的 springcloud 基础', '努力学习, 天天向上', '2019-04-16 18:21:00.000000', '15', '18', '0');
INSERT INTO `courses_courseinfo` VALUES ('26', 'course/springmvc.jpg', 'springmvc简介', '8', '1', 'cj', '0', '2', 'springmvc简介', 'springmvc简介springmvc简介springmvc简介springmvc简介springmvc简介', 'hd', '让天下没有难学的 springmvc', '有一定的 springmvc 基础', '让天下没有难学的技术', '2019-04-16 18:22:00.000000', '14', '18', '0');
INSERT INTO `courses_courseinfo` VALUES ('27', 'course/srping.jpg', 'spring 简介', '5', '0', 'cj', '0', '0', 'spring 简介', 'spring 简介spring 简介spring 简介spring 简介spring 简介spring 简介', 'hd', '让天下没有难学的 spring', '有一定的 spring 基础', '让天下没有难学的技术', '2019-04-16 18:23:00.000000', '14', '13', '0');
INSERT INTO `courses_courseinfo` VALUES ('28', 'course/python.jpg', 'python 简介', '5', '1', 'zj', '0', '5', 'python 简介', 'python 简介python 简介python 简介python 简介python 简介python 简介python 简介', 'hd', '让天下没有难学的 python', '有一定的 python  基础', '让天下没有难学的技术', '2019-04-16 18:24:00.000000', '11', '14', '0');

-- ----------------------------
-- Table structure for courses_lessoninfo
-- ----------------------------
DROP TABLE IF EXISTS `courses_lessoninfo`;
CREATE TABLE `courses_lessoninfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `courseinfo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courses_lessonin_courseinfo_id_25919b0f_fk_courses_courseinfo_id` (`courseinfo_id`),
  CONSTRAINT `courses_lessonin_courseinfo_id_25919b0f_fk_courses_courseinfo_id` FOREIGN KEY (`courseinfo_id`) REFERENCES `courses_courseinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses_lessoninfo
-- ----------------------------
INSERT INTO `courses_lessoninfo` VALUES ('1', '第一章：html简介', '2018-09-21 16:07:00.000000', '1');
INSERT INTO `courses_lessoninfo` VALUES ('2', '第二章：认识标签', '2018-09-21 16:07:00.000000', '1');
INSERT INTO `courses_lessoninfo` VALUES ('3', '第三章：css选择器', '2018-09-21 16:08:00.000000', '1');

-- ----------------------------
-- Table structure for courses_sourceinfo
-- ----------------------------
DROP TABLE IF EXISTS `courses_sourceinfo`;
CREATE TABLE `courses_sourceinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `down_load` varchar(200) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `courseinfo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courses_sourcein_courseinfo_id_9d1b6a06_fk_courses_courseinfo_id` (`courseinfo_id`),
  CONSTRAINT `courses_sourcein_courseinfo_id_9d1b6a06_fk_courses_courseinfo_id` FOREIGN KEY (`courseinfo_id`) REFERENCES `courses_courseinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses_sourceinfo
-- ----------------------------
INSERT INTO `courses_sourceinfo` VALUES ('1', '开发流程', 'source/谷粒教育.docx', '2018-09-21 16:09:00.000000', '1');
INSERT INTO `courses_sourceinfo` VALUES ('4', '01. mysql简介', 'source/蔡旻佑-寂寞好了.mp3', '2019-04-22 23:56:00.000000', '2');

-- ----------------------------
-- Table structure for courses_videoinfo
-- ----------------------------
DROP TABLE IF EXISTS `courses_videoinfo`;
CREATE TABLE `courses_videoinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `study_time` int(11) NOT NULL,
  `url` varchar(100) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `lessoninfo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courses_videoinf_lessoninfo_id_02a97f3a_fk_courses_lessoninfo_id` (`lessoninfo_id`),
  CONSTRAINT `courses_videoinf_lessoninfo_id_02a97f3a_fk_courses_lessoninfo_id` FOREIGN KEY (`lessoninfo_id`) REFERENCES `courses_lessoninfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses_videoinfo
-- ----------------------------
INSERT INTO `courses_videoinfo` VALUES ('3', '01、hello html', '25', 'vedio/大鱼海棠.mp4', '2019-04-21 15:47:00.000000', '1');
INSERT INTO `courses_videoinfo` VALUES ('4', '02. html 初识', '15', 'vedio/李健_-_春风十里不如你.mp4', '2019-04-22 11:38:00.000000', '2');
INSERT INTO `courses_videoinfo` VALUES ('5', '第三章：css选择器', '23', 'vedio/追美赤子心.mp4', '2019-04-22 23:43:00.000000', '3');
INSERT INTO `courses_videoinfo` VALUES ('6', 'html 简介2', '20', 'vedio/追美赤子心.mp4', '2019-05-04 20:50:00.000000', '1');

-- ----------------------------
-- Table structure for django_admin_log
-- ----------------------------
DROP TABLE IF EXISTS `django_admin_log`;
CREATE TABLE `django_admin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) unsigned NOT NULL,
  `change_message` longtext NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin__content_type_id_c4bce8eb_fk_django_content_type_id` (`content_type_id`),
  KEY `django_admin_log_user_id_c564eba6_fk_users_userprofile_id` (`user_id`),
  CONSTRAINT `django_admin__content_type_id_c4bce8eb_fk_django_content_type_id` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_users_userprofile_id` FOREIGN KEY (`user_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of django_admin_log
-- ----------------------------

-- ----------------------------
-- Table structure for django_apscheduler_djangojob
-- ----------------------------
DROP TABLE IF EXISTS `django_apscheduler_djangojob`;
CREATE TABLE `django_apscheduler_djangojob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `next_run_time` datetime(6) DEFAULT NULL,
  `job_state` longblob NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `django_apscheduler_djangojob_next_run_time_2f022619` (`next_run_time`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of django_apscheduler_djangojob
-- ----------------------------
INSERT INTO `django_apscheduler_djangojob` VALUES ('1', 'users.views.my_job', '2019-06-02 15:59:33.858891', 0x800495E2010000000000007D94288C0776657273696F6E944B018C026964948C1275736572732E76696577732E6D795F6A6F62948C0466756E63948C1275736572732E76696577733A6D795F6A6F62948C0774726967676572948C1D61707363686564756C65722E74726967676572732E696E74657276616C948C0F496E74657276616C547269676765729493942981947D942868014B028C0874696D657A6F6E65948C047079747A948C025F70949394288C0D417369612F5368616E67686169944DE8714B008C034C4D5494749452948C0A73746172745F64617465948C086461746574696D65948C086461746574696D65949394430A07E306020B3B210D1B0B94680F2868104D80704B008C034353549474945294869452948C08656E645F64617465944E8C08696E74657276616C9468158C0974696D6564656C74619493944B004D2C014B00879452948C066A6974746572944E75628C086578656375746F72948C0764656661756C74948C046172677394298C066B7761726773947D948C046E616D65948C066D795F6A6F62948C126D6973666972655F67726163655F74696D65944BF08C08636F616C6573636594888C0D6D61785F696E7374616E636573944B018C0D6E6578745F72756E5F74696D65946817430A07E306020F3B210D1B0B94681B86945294752E);
INSERT INTO `django_apscheduler_djangojob` VALUES ('2', 'users.views.emial_job', '2019-07-01 07:00:00.000000', 0x8004950D040000000000007D94288C0776657273696F6E944B018C026964948C1575736572732E76696577732E656D69616C5F6A6F62948C0466756E63948C1575736572732E76696577733A656D69616C5F6A6F62948C0774726967676572948C1961707363686564756C65722E74726967676572732E63726F6E948C0B43726F6E547269676765729493942981947D942868014B028C0874696D657A6F6E65948C047079747A948C025F70949394288C0D417369612F5368616E67686169944DE8714B008C034C4D5494749452948C0A73746172745F64617465944E8C08656E645F64617465944E8C066669656C6473945D94288C2061707363686564756C65722E74726967676572732E63726F6E2E6669656C6473948C09426173654669656C649493942981947D94288C046E616D65948C0479656172948C0A69735F64656661756C7494888C0B65787072657373696F6E73945D948C2561707363686564756C65722E74726967676572732E63726F6E2E65787072657373696F6E73948C0D416C6C45787072657373696F6E9493942981947D948C0473746570944E736261756268188C0A4D6F6E74684669656C649493942981947D9428681D8C056D6F6E746894681F8968205D9468228C0F52616E676545787072657373696F6E9493942981947D942868274E8C056669727374944B018C046C617374944B0C756261756268188C0F4461794F664D6F6E74684669656C649493942981947D9428681D8C0364617994681F8968205D94682F2981947D942868274E68324B0168334B01756261756268188C095765656B4669656C649493942981947D9428681D8C047765656B94681F8868205D9468242981947D9468274E736261756268188C0E4461794F665765656B4669656C649493942981947D9428681D8C0B6461795F6F665F7765656B94681F8868205D9468242981947D9468274E7362617562681A2981947D9428681D8C04686F757294681F8968205D94682F2981947D942868274E68324B0768334B077562617562681A2981947D9428681D8C066D696E75746594681F8868205D94682F2981947D942868274E68324B0068334B007562617562681A2981947D9428681D8C067365636F6E6494681F8868205D94682F2981947D942868274E68324B0068334B007562617562658C066A6974746572944E75628C086578656375746F72948C0764656661756C74948C046172677394298C066B7761726773947D94681D8C09656D69616C5F6A6F62948C126D6973666972655F67726163655F74696D65944D40388C08636F616C6573636594888C0D6D61785F696E7374616E636573944B018C0D6E6578745F72756E5F74696D65948C086461746574696D65948C086461746574696D65949394430A07E3070107000000000094680F2868104D80704B008C03435354947494529486945294752E);

-- ----------------------------
-- Table structure for django_apscheduler_djangojobexecution
-- ----------------------------
DROP TABLE IF EXISTS `django_apscheduler_djangojobexecution`;
CREATE TABLE `django_apscheduler_djangojobexecution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL,
  `run_time` datetime(6) NOT NULL,
  `duration` decimal(15,2) DEFAULT NULL,
  `started` decimal(15,2) DEFAULT NULL,
  `finished` decimal(15,2) DEFAULT NULL,
  `exception` varchar(1000) DEFAULT NULL,
  `traceback` longtext,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_apscheduler_d_job_id_daf5090a_fk_django_ap` (`job_id`),
  KEY `django_apscheduler_djangojobexecution_run_time_16edd96b` (`run_time`),
  CONSTRAINT `django_apscheduler_d_job_id_daf5090a_fk_django_ap` FOREIGN KEY (`job_id`) REFERENCES `django_apscheduler_djangojob` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=542 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of django_apscheduler_djangojobexecution
-- ----------------------------
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('1', 'Executed', '2019-05-05 23:48:03.396151', '-1.19', '1557071286.16', '1557071284.97', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('2', 'Executed', '2019-05-05 23:48:13.396151', '-0.59', '1557071296.72', '1557071296.13', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('3', 'Executed', '2019-05-05 23:48:23.396151', '-0.56', '1557071305.55', '1557071304.99', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('4', 'Executed', '2019-05-05 23:50:45.943995', '0.30', '1557071447.18', '1557071447.48', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('5', 'Executed', '2019-05-05 23:52:45.943995', '-0.57', '1557071567.57', '1557071567.00', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('6', 'Executed', '2019-05-05 23:53:23.183457', '-1.01', '1557071605.50', '1557071604.49', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('7', 'Executed', '2019-05-05 23:53:28.183457', '-0.57', '1557071611.13', '1557071610.56', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('8', 'Executed', '2019-05-05 23:53:33.183457', '-0.54', '1557071615.28', '1557071614.74', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('9', 'Executed', '2019-05-05 23:53:38.183457', '-0.55', '1557071620.27', '1557071619.72', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('10', 'Executed', '2019-05-05 23:53:43.183457', '-0.51', '1557071625.25', '1557071624.74', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('11', 'Executed', '2019-05-05 23:53:48.183457', '-0.60', '1557071630.30', '1557071629.70', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('12', 'Executed', '2019-05-05 23:53:53.183457', '-0.60', '1557071635.52', '1557071634.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('13', 'Executed', '2019-05-05 23:53:58.183457', '-0.55', '1557071640.49', '1557071639.94', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('14', 'Executed', '2019-05-05 23:54:03.183457', '-0.53', '1557071645.33', '1557071644.80', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('15', 'Executed', '2019-05-05 23:54:08.183457', '-0.51', '1557071650.27', '1557071649.76', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('16', 'Executed', '2019-05-05 23:54:13.183457', '0.61', '1557071655.07', '1557071655.68', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('17', 'Executed', '2019-05-05 23:54:18.183457', '0.33', '1557071659.88', '1557071660.21', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('18', 'Executed', '2019-05-05 23:54:23.183457', '20.37', '1557071664.83', '1557071685.20', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('19', 'Started execution', '2019-05-05 23:54:28.183457', null, '1557071669.86', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('20', 'Started execution', '2019-05-05 23:54:33.183457', null, '1557071674.76', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('21', 'Started execution', '2019-05-05 23:54:38.183457', null, '1557071679.70', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('22', 'Started execution', '2019-05-05 23:54:43.183457', null, '1557071684.58', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('23', 'Executed', '2019-05-05 23:54:48.183457', '0.26', '1557071689.74', '1557071690.00', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('24', 'Executed', '2019-05-05 23:54:53.183457', '4.73', '1557071694.97', '1557071699.70', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('25', 'Executed', '2019-05-05 23:54:58.183457', '0.32', '1557071700.19', '1557071700.51', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('26', 'Executed', '2019-05-05 23:55:03.183457', '0.94', '1557071704.84', '1557071705.78', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('27', 'Executed', '2019-05-05 23:55:08.183457', '0.39', '1557071709.92', '1557071710.31', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('28', 'Executed', '2019-05-05 23:55:13.183457', '0.89', '1557071714.76', '1557071715.65', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('29', 'Executed', '2019-05-05 23:55:18.183457', '0.24', '1557071719.82', '1557071720.06', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('30', 'Started execution', '2019-05-05 23:55:23.183457', null, '1557071724.84', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('31', 'Executed', '2019-05-05 23:55:23.183457', '0.00', null, '1557071725.08', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('32', 'Started execution', '2019-05-05 23:55:28.183457', null, '1557071729.66', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('33', 'Started execution', '2019-05-05 23:55:33.183457', null, '1557071734.75', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('34', 'Executed', '2019-05-05 23:55:33.183457', '0.00', null, '1557071735.02', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('35', 'Started execution', '2019-05-05 23:55:38.183457', null, '1557071739.86', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('36', 'Started execution', '2019-05-05 23:55:43.183457', null, '1557071744.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('37', 'Executed', '2019-05-05 23:55:43.183457', '0.00', null, '1557071745.51', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('38', 'Started execution', '2019-05-05 23:55:48.183457', null, '1557071750.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('39', 'Executed', '2019-05-05 23:55:53.183457', '1.18', '1557071754.84', '1557071756.02', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('40', 'Started execution', '2019-05-05 23:55:58.183457', null, '1557071759.79', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('41', 'Started execution', '2019-05-05 23:56:03.183457', null, '1557071764.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('42', 'Executed', '2019-05-05 23:56:08.183457', '0.00', null, '1557071769.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('43', 'Started execution', '2019-05-05 23:56:13.183457', null, '1557071774.91', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('44', 'Started execution', '2019-05-05 23:56:18.183457', null, '1557071779.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('45', 'Started execution', '2019-05-05 23:56:23.183457', null, '1557071784.90', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('46', 'Started execution', '2019-05-05 23:56:28.183457', null, '1557071790.05', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('47', 'Executed', '2019-05-05 23:56:33.183457', '0.00', null, '1557071794.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('48', 'Started execution', '2019-05-05 23:56:38.183457', null, '1557071799.91', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('49', 'Executed', '2019-05-05 23:59:14.426187', '-0.57', '1557071956.20', '1557071955.63', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('50', 'Executed', '2019-05-05 23:59:19.426187', '-0.51', '1557071961.49', '1557071960.98', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('51', 'Executed', '2019-05-05 23:59:24.426187', '-0.53', '1557071966.43', '1557071965.90', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('52', 'Executed', '2019-05-05 23:59:29.426187', '-0.53', '1557071971.45', '1557071970.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('53', 'Executed', '2019-05-05 23:59:34.426187', '-1.15', '1557071977.35', '1557071976.20', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('54', 'Executed', '2019-05-06 00:02:52.402332', '9.31', '1557072173.65', '1557072182.96', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('55', 'Executed', '2019-05-06 00:03:42.402332', '8.12', '1557072223.54', '1557072231.66', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('56', 'Executed', '2019-05-06 00:04:32.402332', '5.78', '1557072273.51', '1557072279.29', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('57', 'Executed', '2019-05-06 00:05:22.402332', '4.07', '1557072323.53', '1557072327.60', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('58', 'Executed', '2019-05-06 00:06:12.402332', '5.38', '1557072373.57', '1557072378.95', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('59', 'Executed', '2019-05-06 00:07:02.402332', '2.39', '1557072423.55', '1557072425.94', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('60', 'Executed', '2019-05-06 00:07:52.402332', '12.56', '1557072473.52', '1557072486.08', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('61', 'Executed', '2019-05-06 00:08:42.402332', '4.56', '1557072523.54', '1557072528.10', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('62', 'Executed', '2019-05-06 00:09:32.402332', '6.36', '1557072573.56', '1557072579.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('63', 'Executed', '2019-05-06 00:10:22.402332', '29.55', '1557072623.50', '1557072653.05', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('64', 'Executed', '2019-05-06 00:11:12.402332', '25.84', '1557072673.46', '1557072699.30', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('65', 'Executed', '2019-05-06 00:12:02.402332', '4.99', '1557072723.57', '1557072728.56', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('66', 'Executed', '2019-05-06 00:12:52.402332', '9.72', '1557072773.52', '1557072783.24', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('67', 'Executed', '2019-05-06 00:13:42.402332', '3.72', '1557072823.54', '1557072827.26', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('68', 'Executed', '2019-05-06 00:14:32.402332', '0.45', '1557072873.58', '1557072874.03', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('69', 'Started execution', '2019-05-06 00:15:22.402332', null, '1557072923.55', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('70', 'Executed', '2019-05-06 00:16:12.402332', '0.42', '1557072973.53', '1557072973.95', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('71', 'Executed', '2019-05-06 00:17:02.402332', '0.00', null, '1557073023.51', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('72', 'Executed', '2019-05-06 00:19:43.846310', '0.44', '1557073185.08', '1557073185.52', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('73', 'Executed', '2019-05-06 00:20:33.846310', '17.64', '1557073235.06', '1557073252.70', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('74', 'Executed', '2019-05-06 00:21:23.846310', '21.81', '1557073285.09', '1557073306.90', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('75', 'Executed', '2019-05-06 00:22:13.846310', '54.31', '1557073335.13', '1557073389.44', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('76', 'Started execution', '2019-05-06 00:23:03.846310', null, '1557073385.16', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('77', 'Executed', '2019-05-06 00:23:53.846310', '12.78', '1557073435.11', '1557073447.89', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('78', 'Started execution', '2019-05-06 00:24:43.846310', null, '1557073485.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('79', 'Started execution', '2019-05-06 00:25:33.846310', null, '1557073535.06', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('80', 'Executed', '2019-05-06 00:28:48.423197', '0.82', '1557073730.68', '1557073731.50', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('81', 'Executed', '2019-05-06 00:29:38.423197', '48.96', '1557073780.64', '1557073829.60', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('82', 'Executed', '2019-05-06 00:30:28.423197', '0.66', '1557073830.56', '1557073831.22', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('83', 'Executed', '2019-05-06 12:25:39.849332', '0.43', '1557116741.27', '1557116741.70', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('84', 'Executed', '2019-05-06 12:59:10.894855', '0.90', '1557118752.90', '1557118753.80', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('85', 'Started execution', '2019-05-06 13:04:10.894855', null, '1557119052.66', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('86', 'Executed', '2019-05-06 13:09:10.894855', '0.68', '1557119352.17', '1557119352.85', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('87', 'Executed', '2019-05-06 15:58:19.182820', '0.34', '1557129500.46', '1557129500.80', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('88', 'Executed', '2019-05-06 16:18:32.760650', '0.76', '1557130714.97', '1557130715.73', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('89', 'Executed', '2019-05-06 16:27:06.041842', '0.47', '1557131227.32', '1557131227.79', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('90', 'Executed', '2019-05-06 16:32:46.707470', '0.44', '1557131567.96', '1557131568.40', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('91', 'Executed', '2019-05-06 16:39:14.688308', '0.51', '1557131955.99', '1557131956.50', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('92', 'Executed', '2019-05-06 16:59:26.456620', '1.09', '1557133168.23', '1557133169.32', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('93', 'Executed', '2019-05-06 17:06:00.964990', '0.44', '1557133562.15', '1557133562.59', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('94', 'Executed', '2019-05-06 17:11:00.964990', '0.00', null, '1557133862.38', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('95', 'Started execution', '2019-05-06 17:11:00.964990', null, '1557133862.30', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('96', 'Executed', '2019-05-06 17:19:16.416630', '0.56', '1557134358.56', '1557134359.12', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('97', 'Executed', '2019-05-06 17:26:59.541626', '0.46', '1557134820.69', '1557134821.15', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('98', 'Started execution', '2019-05-06 17:31:59.541626', null, '1557135148.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('99', 'Executed', '2019-05-06 17:36:59.541626', '14.09', '1557135459.42', '1557135473.51', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('100', 'Executed', '2019-05-06 17:41:59.541626', '0.00', null, '1557135743.62', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('101', 'Started execution', '2019-05-06 17:41:59.541626', null, '1557135740.55', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('102', 'Executed', '2019-05-06 17:46:59.541626', '1.04', '1557136038.65', '1557136039.69', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('103', 'Executed', '2019-05-06 17:55:56.948486', '0.33', '1557136558.38', '1557136558.71', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('104', 'Executed', '2019-05-06 18:02:55.129320', '3.55', '1557136976.32', '1557136979.87', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('105', 'Executed', '2019-05-06 18:09:48.853213', '0.46', '1557137390.13', '1557137390.59', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('106', 'Executed', '2019-05-06 18:14:48.853213', '0.00', null, '1557137690.24', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('107', 'Started execution', '2019-05-06 18:14:48.853213', null, '1557137690.14', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('108', 'Executed', '2019-05-06 18:19:48.853213', '0.56', '1557137990.16', '1557137990.72', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('109', 'Executed', '2019-05-06 18:24:48.853213', '0.00', null, '1557138290.17', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('110', 'Started execution', '2019-05-06 18:24:48.853213', null, '1557138290.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('111', 'Executed', '2019-05-06 18:29:48.853213', '0.97', '1557138590.00', '1557138590.97', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('112', 'Executed', '2019-05-07 12:46:30.042870', '0.60', '1557204391.24', '1557204391.84', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('113', 'Executed', '2019-05-07 13:19:41.775210', '0.41', '1557206383.00', '1557206383.41', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('114', 'Executed', '2019-05-07 13:24:41.775210', '0.00', null, '1557206683.03', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('115', 'Started execution', '2019-05-07 13:24:41.775210', null, '1557206682.96', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('116', 'Executed', '2019-05-07 13:29:41.775210', '0.51', '1557206982.94', '1557206983.45', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('117', 'Executed', '2019-05-07 13:34:41.775210', '0.00', null, '1557207283.03', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('118', 'Started execution', '2019-05-07 13:34:41.775210', null, '1557207282.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('119', 'Executed', '2019-05-07 13:39:41.775210', '1.00', '1557207582.94', '1557207583.94', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('120', 'Executed', '2019-05-07 20:11:44.687889', '0.51', '1557231105.98', '1557231106.49', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('121', 'Executed', '2019-05-07 20:16:44.687889', '0.00', null, '1557231406.10', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('122', 'Executed', '2019-05-07 20:21:44.687889', '0.56', '1557231706.13', '1557231706.69', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('123', 'Executed', '2019-05-09 15:04:41.717755', '0.51', '1557385483.02', '1557385483.53', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('124', 'Started execution', '2019-05-09 15:09:41.717755', null, '1557385783.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('125', 'Executed', '2019-05-09 15:09:41.717755', '0.00', null, '1557385783.36', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('126', 'Executed', '2019-05-09 15:14:41.717755', '0.60', '1557386083.40', '1557386084.00', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('127', 'Executed', '2019-05-09 15:19:41.717755', '0.00', null, '1557386383.48', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('128', 'Started execution', '2019-05-09 15:19:41.717755', null, '1557386383.33', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('129', 'Executed', '2019-05-09 15:24:41.717755', '0.88', '1557386683.36', '1557386684.24', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('130', 'Executed', '2019-05-09 15:29:41.717755', '0.00', null, '1557386983.77', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('131', 'Started execution', '2019-05-09 15:29:41.717755', null, '1557386983.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('132', 'Executed', '2019-05-09 15:34:41.717755', '0.60', '1557387283.18', '1557387283.78', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('133', 'Started execution', '2019-05-09 15:39:41.717755', null, '1557387583.51', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('134', 'Executed', '2019-05-09 15:39:41.717755', '0.00', null, '1557387584.05', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('135', 'Executed', '2019-05-13 10:11:55.985621', '0.87', '1557713518.26', '1557713519.13', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('136', 'Executed', '2019-05-13 10:16:55.985621', '0.00', null, '1557713818.21', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('137', 'Started execution', '2019-05-13 10:16:55.985621', null, '1557713818.03', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('138', 'Executed', '2019-05-13 10:21:55.985621', '0.97', '1557714118.25', '1557714119.22', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('139', 'Executed', '2019-05-13 10:26:55.985621', '0.00', null, '1557714418.38', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('140', 'Executed', '2019-05-13 10:31:55.985621', '0.80', '1557714718.12', '1557714718.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('141', 'Executed', '2019-05-13 10:36:55.985621', '0.58', '1557715018.24', '1557715018.82', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('142', 'Executed', '2019-05-13 10:41:55.985621', '0.75', '1557715318.52', '1557715319.27', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('143', 'Started execution', '2019-05-13 10:46:55.985621', null, '1557715619.32', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('144', 'Executed', '2019-05-13 10:51:55.985621', '0.75', '1557715918.90', '1557715919.65', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('145', 'Started execution', '2019-05-13 10:56:55.985621', null, '1557716217.76', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('146', 'Executed', '2019-05-13 11:01:55.985621', '0.48', '1557716517.64', '1557716518.12', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('147', 'Started execution', '2019-05-13 11:06:55.985621', null, '1557716817.86', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('148', 'Executed', '2019-05-13 11:11:55.985621', '0.95', '1557717118.12', '1557717119.07', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('149', 'Started execution', '2019-05-13 11:16:55.985621', null, '1557717417.95', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('150', 'Executed', '2019-05-13 11:21:55.985621', '0.60', '1557717717.82', '1557717718.42', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('151', 'Started execution', '2019-05-13 11:26:55.985621', null, '1557718017.40', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('152', 'Executed', '2019-05-13 11:31:55.985621', '0.55', '1557718317.17', '1557718317.72', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('153', 'Started execution', '2019-05-13 11:36:55.985621', null, '1557718617.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('154', 'Executed', '2019-05-13 11:41:55.985621', '0.64', '1557718917.29', '1557718917.93', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('155', 'Started execution', '2019-05-13 11:46:55.985621', null, '1557719217.63', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('156', 'Executed', '2019-05-13 13:54:19.278367', '0.44', '1557726860.74', '1557726861.18', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('157', 'Executed', '2019-05-13 13:59:19.278367', '0.00', null, '1557727160.95', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('158', 'Started execution', '2019-05-13 13:59:19.278367', null, '1557727160.81', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('159', 'Executed', '2019-05-13 14:04:19.278367', '0.68', '1557727460.69', '1557727461.37', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('160', 'Started execution', '2019-05-13 14:09:19.278367', null, '1557727760.66', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('161', 'Executed', '2019-05-13 14:09:19.278367', '0.00', null, '1557727760.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('162', 'Executed', '2019-05-13 14:14:19.278367', '0.56', '1557728060.65', '1557728061.21', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('163', 'Executed', '2019-05-13 14:19:19.278367', '0.00', null, '1557728360.95', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('164', 'Started execution', '2019-05-13 14:19:19.278367', null, '1557728360.73', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('165', 'Executed', '2019-05-13 14:24:19.278367', '1.62', '1557728660.80', '1557728662.42', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('166', 'Executed', '2019-05-13 14:29:19.278367', '0.00', null, '1557728960.90', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('167', 'Started execution', '2019-05-13 14:29:19.278367', null, '1557728960.79', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('168', 'Executed', '2019-05-13 14:34:19.278367', '0.59', '1557729260.73', '1557729261.32', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('169', 'Started execution', '2019-05-13 14:39:19.278367', null, '1557729560.75', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('170', 'Executed', '2019-05-13 14:44:19.278367', '0.52', '1557729860.74', '1557729861.26', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('171', 'Executed', '2019-05-19 10:52:07.756585', '0.42', '1558234329.34', '1558234329.76', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('172', 'Executed', '2019-05-19 10:57:07.756585', '0.00', null, '1558234629.37', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('173', 'Started execution', '2019-05-19 10:57:07.756585', null, '1558234629.27', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('174', 'Executed', '2019-05-19 11:02:07.756585', '0.50', '1558234929.29', '1558234929.79', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('175', 'Executed', '2019-05-19 11:07:07.756585', '0.00', null, '1558235229.27', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('176', 'Started execution', '2019-05-19 11:07:07.756585', null, '1558235229.18', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('177', 'Executed', '2019-05-19 11:12:07.756585', '0.35', '1558235529.24', '1558235529.59', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('178', 'Executed', '2019-05-19 11:17:07.756585', '0.00', null, '1558235829.35', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('179', 'Started execution', '2019-05-19 11:17:07.756585', null, '1558235829.24', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('180', 'Executed', '2019-05-19 11:22:07.756585', '0.43', '1558236129.15', '1558236129.58', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('181', 'Executed', '2019-05-19 11:27:07.756585', '0.26', '1558236429.23', '1558236429.49', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('182', 'Executed', '2019-05-19 11:32:07.756585', '0.43', '1558236729.28', '1558236729.71', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('183', 'Started execution', '2019-05-19 11:37:07.756585', null, '1558237029.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('184', 'Executed', '2019-05-19 11:42:07.756585', '0.56', '1558237329.19', '1558237329.75', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('185', 'Started execution', '2019-05-19 11:47:07.756585', null, '1558237629.21', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('186', 'Executed', '2019-05-19 11:52:07.756585', '0.40', '1558237929.22', '1558237929.62', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('187', 'Started execution', '2019-05-19 11:57:07.756585', null, '1558238229.18', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('188', 'Executed', '2019-05-19 12:02:07.756585', '0.87', '1558238529.22', '1558238530.09', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('189', 'Started execution', '2019-05-19 12:07:07.756585', null, '1558238829.21', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('190', 'Executed', '2019-05-19 12:12:07.756585', '0.48', '1558239129.09', '1558239129.57', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('191', 'Started execution', '2019-05-19 12:17:07.756585', null, '1558239429.06', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('192', 'Executed', '2019-05-19 12:22:07.756585', '0.44', '1558239729.08', '1558239729.52', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('193', 'Started execution', '2019-05-19 12:27:07.756585', null, '1558240029.17', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('194', 'Started execution', '2019-05-19 12:32:07.756585', null, '1558240329.61', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('195', 'Started execution', '2019-05-19 12:37:07.756585', null, '1558240629.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('196', 'Started execution', '2019-05-19 12:42:07.756585', null, '1558240929.08', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('197', 'Started execution', '2019-05-19 12:47:07.756585', null, '1558241229.10', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('198', 'Started execution', '2019-05-19 12:52:07.756585', null, '1558241529.10', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('199', 'Started execution', '2019-05-19 12:57:07.756585', null, '1558241829.10', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('200', 'Started execution', '2019-05-19 13:02:07.756585', null, '1558242132.10', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('201', 'Started execution', '2019-05-19 13:07:07.756585', null, '1558242432.06', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('202', 'Started execution', '2019-05-19 13:12:07.756585', null, '1558242730.05', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('203', 'Started execution', '2019-05-19 13:17:07.756585', null, '1558243030.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('204', 'Started execution', '2019-05-19 13:22:07.756585', null, '1558243329.72', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('205', 'Started execution', '2019-05-19 13:27:07.756585', null, '1558243629.35', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('206', 'Started execution', '2019-05-19 13:32:07.756585', null, '1558243930.19', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('207', 'Started execution', '2019-05-19 13:37:07.756585', null, '1558244230.62', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('208', 'Started execution', '2019-05-19 13:42:07.756585', null, '1558244530.10', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('209', 'Started execution', '2019-05-19 13:47:07.756585', null, '1558244829.08', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('210', 'Started execution', '2019-05-19 13:52:07.756585', null, '1558245129.03', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('211', 'Started execution', '2019-05-19 13:57:07.756585', null, '1558245429.05', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('212', 'Started execution', '2019-05-19 14:02:07.756585', null, '1558245729.13', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('213', 'Started execution', '2019-05-19 14:07:07.756585', null, '1558246029.05', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('214', 'Executed', '2019-05-19 14:34:17.417364', '0.60', '1558247658.64', '1558247659.24', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('215', 'Executed', '2019-05-19 14:39:17.417364', '0.00', null, '1558247958.77', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('216', 'Started execution', '2019-05-19 14:39:17.417364', null, '1558247958.66', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('217', 'Executed', '2019-05-19 14:53:00.635136', '1.09', '1558248782.67', '1558248783.76', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('218', 'Executed', '2019-05-20 13:20:51.775695', '0.49', '1558329653.09', '1558329653.58', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('219', 'Executed', '2019-05-20 13:25:51.775695', '0.00', null, '1558329953.73', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('220', 'Started execution', '2019-05-20 13:25:51.775695', null, '1558329953.55', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('221', 'Executed', '2019-05-20 13:30:51.775695', '0.57', '1558330254.19', '1558330254.76', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('222', 'Executed', '2019-05-20 13:35:51.775695', '0.00', null, '1558330554.43', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('223', 'Started execution', '2019-05-20 13:35:51.775695', null, '1558330554.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('224', 'Executed', '2019-05-20 13:40:51.775695', '1.26', '1558330853.46', '1558330854.72', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('225', 'Executed', '2019-05-20 13:45:51.775695', '0.00', null, '1558331152.98', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('226', 'Executed', '2019-05-20 13:50:51.775695', '0.40', '1558331453.01', '1558331453.41', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('227', 'Executed', '2019-05-20 13:55:51.775695', '0.00', null, '1558331753.13', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('228', 'Started execution', '2019-05-20 13:55:51.775695', null, '1558331753.03', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('229', 'Executed', '2019-05-20 14:00:51.775695', '0.44', '1558332052.94', '1558332053.38', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('230', 'Started execution', '2019-05-20 14:05:51.775695', null, '1558332354.25', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('231', 'Executed', '2019-05-20 14:10:51.775695', '0.38', '1558332654.30', '1558332654.68', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('232', 'Started execution', '2019-05-20 14:15:51.775695', null, '1558332952.96', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('233', 'Executed', '2019-05-20 14:20:51.775695', '0.42', '1558333252.91', '1558333253.33', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('234', 'Started execution', '2019-05-20 14:25:51.775695', null, '1558333553.01', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('235', 'Executed', '2019-05-20 14:30:51.775695', '0.40', '1558333853.34', '1558333853.74', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('236', 'Started execution', '2019-05-20 14:35:51.775695', null, '1558334153.73', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('237', 'Executed', '2019-05-20 14:40:51.775695', '0.82', '1558334453.83', '1558334454.65', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('238', 'Started execution', '2019-05-20 14:45:51.775695', null, '1558334753.41', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('239', 'Executed', '2019-05-20 14:50:51.775695', '0.45', '1558335052.92', '1558335053.37', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('240', 'Started execution', '2019-05-20 14:55:51.775695', null, '1558335352.90', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('241', 'Started execution', '2019-05-20 15:00:51.775695', null, '1558335652.90', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('242', 'Started execution', '2019-05-20 15:05:51.775695', null, '1558335952.98', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('243', 'Started execution', '2019-05-20 15:10:51.775695', null, '1558336253.03', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('244', 'Started execution', '2019-05-20 15:15:51.775695', null, '1558336553.43', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('245', 'Started execution', '2019-05-20 15:20:51.775695', null, '1558336854.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('246', 'Started execution', '2019-05-20 15:25:51.775695', null, '1558337153.66', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('247', 'Started execution', '2019-05-20 15:30:51.775695', null, '1558337452.93', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('248', 'Started execution', '2019-05-20 15:35:51.775695', null, '1558337752.95', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('249', 'Started execution', '2019-05-20 15:40:51.775695', null, '1558338053.34', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('250', 'Started execution', '2019-05-20 15:45:51.775695', null, '1558338353.77', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('251', 'Started execution', '2019-05-20 15:50:51.775695', null, '1558338653.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('252', 'Started execution', '2019-05-20 15:55:51.775695', null, '1558338953.30', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('253', 'Started execution', '2019-05-20 16:00:51.775695', null, '1558339258.70', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('254', 'Started execution', '2019-05-20 16:05:51.775695', null, '1558339552.83', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('255', 'Started execution', '2019-05-20 16:10:51.775695', null, '1558339852.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('256', 'Started execution', '2019-05-20 16:15:51.775695', null, '1558340153.00', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('257', 'Started execution', '2019-05-20 16:20:51.775695', null, '1558340453.68', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('258', 'Started execution', '2019-05-20 16:25:51.775695', null, '1558340754.21', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('259', 'Started execution', '2019-05-20 16:30:51.775695', null, '1558341054.23', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('260', 'Started execution', '2019-05-20 16:35:51.775695', null, '1558341354.05', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('261', 'Started execution', '2019-05-20 16:40:51.775695', null, '1558341654.08', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('262', 'Started execution', '2019-05-20 16:45:51.775695', null, '1558341954.33', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('263', 'Started execution', '2019-05-20 16:50:51.775695', null, '1558342254.13', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('264', 'Started execution', '2019-05-20 16:55:51.775695', null, '1558342553.56', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('265', 'Started execution', '2019-05-20 17:00:51.775695', null, '1558342852.95', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('266', 'Started execution', '2019-05-20 17:05:51.775695', null, '1558343152.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('267', 'Started execution', '2019-05-20 17:10:51.775695', null, '1558343452.96', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('268', 'Started execution', '2019-05-20 17:15:51.775695', null, '1558343752.96', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('269', 'Started execution', '2019-05-20 17:20:51.775695', null, '1558344052.91', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('270', 'Started execution', '2019-05-20 17:25:51.775695', null, '1558344352.93', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('271', 'Started execution', '2019-05-20 17:30:51.775695', null, '1558344652.81', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('272', 'Started execution', '2019-05-20 17:35:51.775695', null, '1558344952.85', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('273', 'Started execution', '2019-05-20 17:40:51.775695', null, '1558345252.88', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('274', 'Started execution', '2019-05-20 17:45:51.775695', null, '1558345553.22', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('275', 'Started execution', '2019-05-20 17:50:51.775695', null, '1558345853.65', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('276', 'Started execution', '2019-05-20 17:55:51.775695', null, '1558346153.85', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('277', 'Started execution', '2019-05-20 18:00:51.775695', null, '1558346453.63', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('278', 'Started execution', '2019-05-20 18:05:51.775695', null, '1558346753.14', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('279', 'Started execution', '2019-05-20 18:10:51.775695', null, '1558347052.90', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('280', 'Started execution', '2019-05-20 18:15:51.775695', null, '1558347352.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('281', 'Started execution', '2019-05-20 18:20:51.775695', null, '1558347652.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('282', 'Started execution', '2019-05-20 18:25:51.775695', null, '1558347953.23', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('283', 'Started execution', '2019-05-20 18:30:51.775695', null, '1558348252.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('284', 'Started execution', '2019-05-20 18:35:51.775695', null, '1558348552.90', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('285', 'Started execution', '2019-05-20 18:40:51.775695', null, '1558348853.15', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('286', 'Started execution', '2019-05-20 18:45:51.775695', null, '1558349153.33', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('287', 'Started execution', '2019-05-20 18:50:51.775695', null, '1558349453.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('288', 'Started execution', '2019-05-20 18:55:51.775695', null, '1558349753.01', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('289', 'Started execution', '2019-05-20 19:00:51.775695', null, '1558350053.18', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('290', 'Started execution', '2019-05-20 19:05:51.775695', null, '1558350353.74', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('291', 'Started execution', '2019-05-20 19:10:51.775695', null, '1558350654.32', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('292', 'Started execution', '2019-05-20 19:15:51.775695', null, '1558350953.65', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('293', 'Started execution', '2019-05-20 19:20:51.775695', null, '1558351254.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('294', 'Started execution', '2019-05-20 19:25:51.775695', null, '1558351553.84', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('295', 'Started execution', '2019-05-20 19:30:51.775695', null, '1558351853.13', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('296', 'Started execution', '2019-05-20 19:35:51.775695', null, '1558352153.07', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('297', 'Started execution', '2019-05-20 19:40:51.775695', null, '1558352453.43', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('298', 'Started execution', '2019-05-20 19:45:51.775695', null, '1558352753.61', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('299', 'Started execution', '2019-05-20 19:50:51.775695', null, '1558353053.79', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('300', 'Started execution', '2019-05-20 19:55:51.775695', null, '1558353354.23', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('301', 'Started execution', '2019-05-20 20:00:51.775695', null, '1558353653.56', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('302', 'Started execution', '2019-05-20 20:05:51.775695', null, '1558353952.98', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('303', 'Started execution', '2019-05-20 20:10:51.775695', null, '1558354253.01', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('304', 'Started execution', '2019-05-20 20:15:51.775695', null, '1558354553.19', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('305', 'Started execution', '2019-05-20 20:20:51.775695', null, '1558354853.55', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('306', 'Started execution', '2019-05-20 20:25:51.775695', null, '1558355154.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('307', 'Started execution', '2019-05-20 20:30:51.775695', null, '1558355454.16', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('308', 'Started execution', '2019-05-20 20:35:51.775695', null, '1558355753.46', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('309', 'Started execution', '2019-05-20 20:40:51.775695', null, '1558356052.97', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('310', 'Started execution', '2019-05-20 20:45:51.775695', null, '1558356352.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('311', 'Started execution', '2019-05-20 20:50:51.775695', null, '1558356652.89', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('312', 'Started execution', '2019-05-20 20:55:51.775695', null, '1558356952.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('313', 'Started execution', '2019-05-20 21:00:51.775695', null, '1558357252.96', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('314', 'Started execution', '2019-05-20 21:05:51.775695', null, '1558357553.03', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('315', 'Started execution', '2019-05-20 21:10:51.775695', null, '1558357853.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('316', 'Started execution', '2019-05-20 21:15:51.775695', null, '1558358153.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('317', 'Started execution', '2019-05-20 21:20:51.775695', null, '1558358452.95', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('318', 'Started execution', '2019-05-20 21:25:51.775695', null, '1558358752.95', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('319', 'Started execution', '2019-05-20 21:30:51.775695', null, '1558359053.19', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('320', 'Started execution', '2019-05-20 21:35:51.775695', null, '1558359353.65', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('321', 'Started execution', '2019-05-20 21:40:51.775695', null, '1558359653.94', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('322', 'Started execution', '2019-05-20 21:45:51.775695', null, '1558359954.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('323', 'Started execution', '2019-05-20 21:50:51.775695', null, '1558360253.86', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('324', 'Started execution', '2019-05-20 21:55:51.775695', null, '1558360553.22', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('325', 'Started execution', '2019-05-20 22:50:51.775695', null, '1558364017.81', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('326', 'Executed', '2019-05-21 14:35:59.378342', '0.50', '1558420560.63', '1558420561.13', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('327', 'Executed', '2019-05-21 14:40:59.378342', '0.00', null, '1558420860.61', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('328', 'Executed', '2019-05-21 14:45:59.378342', '0.39', '1558421160.56', '1558421160.95', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('329', 'Executed', '2019-05-21 14:50:59.378342', '0.00', null, '1558421460.54', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('330', 'Executed', '2019-05-21 14:55:59.378342', '0.45', '1558421760.50', '1558421760.95', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('331', 'Executed', '2019-05-21 15:00:59.378342', '0.00', null, '1558422060.61', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('332', 'Started execution', '2019-05-21 15:00:59.378342', null, '1558422060.55', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('333', 'Executed', '2019-05-21 15:05:59.378342', '0.42', '1558422360.57', '1558422360.99', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('334', 'Executed', '2019-05-21 15:10:59.378342', '0.00', null, '1558422660.65', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('335', 'Executed', '2019-05-21 15:15:59.378342', '0.31', '1558422960.59', '1558422960.90', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('336', 'Started execution', '2019-05-21 15:20:59.378342', null, '1558423260.51', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('337', 'Executed', '2019-05-21 15:25:59.378342', '0.36', '1558423560.58', '1558423560.94', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('338', 'Started execution', '2019-05-21 15:30:59.378342', null, '1558423860.58', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('339', 'Executed', '2019-05-21 15:35:59.378342', '0.40', '1558424160.50', '1558424160.90', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('340', 'Started execution', '2019-05-21 15:40:59.378342', null, '1558424460.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('341', 'Executed', '2019-05-21 15:45:59.378342', '0.47', '1558424760.51', '1558424760.98', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('342', 'Started execution', '2019-05-21 15:50:59.378342', null, '1558425060.45', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('343', 'Executed', '2019-05-21 15:55:59.378342', '0.51', '1558425360.73', '1558425361.24', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('344', 'Started execution', '2019-05-21 16:00:59.378342', null, '1558425660.81', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('345', 'Executed', '2019-05-21 16:05:59.378342', '0.44', '1558425960.57', '1558425961.01', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('346', 'Started execution', '2019-05-21 16:10:59.378342', null, '1558426260.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('347', 'Started execution', '2019-05-21 16:15:59.378342', null, '1558426560.50', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('348', 'Started execution', '2019-05-21 16:20:59.378342', null, '1558426860.50', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('349', 'Started execution', '2019-05-21 16:25:59.378342', null, '1558427160.54', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('350', 'Started execution', '2019-05-21 16:30:59.378342', null, '1558427460.51', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('351', 'Started execution', '2019-05-21 16:35:59.378342', null, '1558427760.46', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('352', 'Started execution', '2019-05-21 16:40:59.378342', null, '1558428060.47', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('353', 'Started execution', '2019-05-21 16:45:59.378342', null, '1558428360.44', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('354', 'Started execution', '2019-05-21 16:50:59.378342', null, '1558428660.48', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('355', 'Started execution', '2019-05-21 16:55:59.378342', null, '1558428960.49', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('356', 'Started execution', '2019-05-21 17:00:59.378342', null, '1558429260.51', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('357', 'Started execution', '2019-05-21 17:05:59.378342', null, '1558429560.50', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('358', 'Started execution', '2019-05-21 17:10:59.378342', null, '1558429860.51', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('359', 'Started execution', '2019-05-21 17:15:59.378342', null, '1558430160.58', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('360', 'Started execution', '2019-05-21 17:20:59.378342', null, '1558430460.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('361', 'Started execution', '2019-05-21 17:25:59.378342', null, '1558430760.54', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('362', 'Started execution', '2019-05-21 17:30:59.378342', null, '1558431060.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('363', 'Started execution', '2019-05-21 17:35:59.378342', null, '1558431360.48', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('364', 'Started execution', '2019-05-21 17:40:59.378342', null, '1558431660.43', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('365', 'Started execution', '2019-05-21 17:45:59.378342', null, '1558431960.50', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('366', 'Started execution', '2019-05-21 17:50:59.378342', null, '1558432260.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('367', 'Started execution', '2019-05-21 17:55:59.378342', null, '1558432560.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('368', 'Started execution', '2019-05-21 18:00:59.378342', null, '1558432860.92', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('369', 'Started execution', '2019-05-21 18:05:59.378342', null, '1558433160.59', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('370', 'Started execution', '2019-05-21 18:10:59.378342', null, '1558433460.62', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('371', 'Started execution', '2019-05-21 18:15:59.378342', null, '1558433760.66', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('372', 'Started execution', '2019-05-21 18:20:59.378342', null, '1558434060.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('373', 'Started execution', '2019-05-21 18:25:59.378342', null, '1558434360.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('374', 'Started execution', '2019-05-21 18:30:59.378342', null, '1558434660.73', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('375', 'Started execution', '2019-05-21 18:35:59.378342', null, '1558434960.65', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('376', 'Started execution', '2019-05-21 18:40:59.378342', null, '1558435260.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('377', 'Started execution', '2019-05-21 18:45:59.378342', null, '1558435560.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('378', 'Started execution', '2019-05-21 18:50:59.378342', null, '1558435860.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('379', 'Started execution', '2019-05-21 18:55:59.378342', null, '1558436160.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('380', 'Started execution', '2019-05-21 19:00:59.378342', null, '1558436460.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('381', 'Started execution', '2019-05-21 19:05:59.378342', null, '1558436760.59', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('382', 'Started execution', '2019-05-21 19:10:59.378342', null, '1558437060.57', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('383', 'Started execution', '2019-05-21 19:15:59.378342', null, '1558437360.63', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('384', 'Started execution', '2019-05-21 19:20:59.378342', null, '1558437660.60', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('385', 'Started execution', '2019-05-21 19:25:59.378342', null, '1558437960.79', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('386', 'Started execution', '2019-05-21 19:30:59.378342', null, '1558438260.80', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('387', 'Started execution', '2019-05-21 19:35:59.378342', null, '1558438560.59', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('388', 'Started execution', '2019-05-21 19:40:59.378342', null, '1558438860.62', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('389', 'Started execution', '2019-05-21 19:45:59.378342', null, '1558439160.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('390', 'Started execution', '2019-05-21 19:50:59.378342', null, '1558439460.62', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('391', 'Started execution', '2019-05-21 19:55:59.378342', null, '1558439760.61', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('392', 'Started execution', '2019-05-21 20:00:59.378342', null, '1558440060.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('393', 'Started execution', '2019-05-21 20:05:59.378342', null, '1558440360.67', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('394', 'Started execution', '2019-05-21 20:10:59.378342', null, '1558440660.59', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('395', 'Started execution', '2019-05-21 20:15:59.378342', null, '1558440960.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('396', 'Started execution', '2019-05-21 20:20:59.378342', null, '1558441260.56', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('397', 'Started execution', '2019-05-21 20:25:59.378342', null, '1558441560.56', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('398', 'Started execution', '2019-05-21 20:30:59.378342', null, '1558441860.58', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('399', 'Started execution', '2019-05-21 20:35:59.378342', null, '1558442160.52', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('400', 'Started execution', '2019-05-21 20:40:59.378342', null, '1558442460.50', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('401', 'Started execution', '2019-05-21 20:45:59.378342', null, '1558442760.43', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('402', 'Started execution', '2019-05-21 20:50:59.378342', null, '1558443060.49', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('403', 'Started execution', '2019-05-21 20:55:59.378342', null, '1558443360.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('404', 'Started execution', '2019-05-21 21:00:59.378342', null, '1558443660.59', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('405', 'Started execution', '2019-05-21 21:05:59.378342', null, '1558443960.82', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('406', 'Started execution', '2019-05-21 21:10:59.378342', null, '1558444260.82', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('407', 'Started execution', '2019-05-21 21:15:59.378342', null, '1558444560.55', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('408', 'Started execution', '2019-05-21 21:20:59.378342', null, '1558444860.53', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('409', 'Started execution', '2019-05-21 21:25:59.378342', null, '1558445160.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('410', 'Started execution', '2019-05-21 21:30:59.378342', null, '1558445460.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('411', 'Executed', '2019-05-21 21:37:06.458228', '0.66', '1558445827.74', '1558445828.40', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('412', 'Executed', '2019-05-21 21:42:06.458228', '0.00', null, '1558446127.75', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('413', 'Started execution', '2019-05-21 21:42:06.458228', null, '1558446127.68', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('414', 'Executed', '2019-05-21 21:47:06.458228', '1.28', '1558446427.65', '1558446428.93', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('415', 'Started execution', '2019-05-21 21:52:06.458228', null, '1558446727.69', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('416', 'Executed', '2019-05-21 21:57:06.458228', '0.46', '1558447027.76', '1558447028.22', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('417', 'Started execution', '2019-05-21 22:02:06.458228', null, '1558447327.74', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('418', 'Executed', '2019-05-21 22:07:06.458228', '0.39', '1558447627.76', '1558447628.15', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('419', 'Started execution', '2019-05-21 22:12:06.458228', null, '1558447927.69', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('420', 'Executed', '2019-05-21 22:17:06.458228', '0.36', '1558448227.73', '1558448228.09', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('421', 'Started execution', '2019-05-21 22:22:06.458228', null, '1558448527.71', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('422', 'Executed', '2019-05-21 22:27:06.458228', '0.46', '1558448827.70', '1558448828.16', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('423', 'Started execution', '2019-05-21 22:32:06.458228', null, '1558449127.73', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('424', 'Executed', '2019-05-21 22:37:06.458228', '0.34', '1558449427.68', '1558449428.02', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('425', 'Started execution', '2019-05-21 22:42:06.458228', null, '1558449729.02', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('426', 'Executed', '2019-05-21 22:47:06.458228', '0.35', '1558450029.16', '1558450029.51', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('427', 'Started execution', '2019-05-21 22:52:06.458228', null, '1558450327.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('428', 'Executed', '2019-05-21 22:57:06.458228', '2.75', '1558450628.10', '1558450630.85', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('429', 'Executed', '2019-05-23 09:01:54.684468', '0.79', '1558573315.97', '1558573316.76', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('430', 'Executed', '2019-05-23 09:06:54.684468', '0.00', null, '1558573616.18', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('431', 'Started execution', '2019-05-23 09:06:54.684468', null, '1558573616.02', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('432', 'Executed', '2019-05-23 09:11:54.684468', '0.64', '1558573915.96', '1558573916.60', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('433', 'Started execution', '2019-05-23 09:16:54.684468', null, '1558574215.91', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('434', 'Executed', '2019-05-23 09:16:54.684468', '0.00', null, '1558574216.28', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('435', 'Executed', '2019-05-23 09:21:54.684468', '1.33', '1558574516.31', '1558574517.64', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('436', 'Executed', '2019-05-23 09:26:54.684468', '1.43', '1558574816.95', '1558574818.38', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('437', 'Executed', '2019-05-23 09:31:54.684468', '1.17', '1558575116.98', '1558575118.15', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('438', 'Executed', '2019-05-23 09:36:54.684468', '0.00', null, '1558575417.21', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('439', 'Started execution', '2019-05-23 09:36:54.684468', null, '1558575416.95', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('440', 'Executed', '2019-05-23 09:41:54.684468', '1.15', '1558575717.05', '1558575718.20', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('441', 'Started execution', '2019-05-23 09:46:54.684468', null, '1558576016.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('442', 'Executed', '2019-05-23 09:51:54.684468', '0.70', '1558576315.99', '1558576316.69', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('443', 'Started execution', '2019-05-23 09:56:54.684468', null, '1558576615.99', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('444', 'Executed', '2019-05-23 10:01:54.684468', '0.66', '1558576915.98', '1558576916.64', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('445', 'Started execution', '2019-05-23 10:06:54.684468', null, '1558577215.98', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('446', 'Executed', '2019-05-23 10:11:54.684468', '1.79', '1558577515.91', '1558577517.70', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('447', 'Started execution', '2019-05-23 10:16:54.684468', null, '1558577816.01', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('448', 'Executed', '2019-05-23 10:21:54.684468', '0.56', '1558578116.11', '1558578116.67', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('449', 'Started execution', '2019-05-23 10:26:54.684468', null, '1558578416.29', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('450', 'Executed', '2019-05-23 10:31:54.684468', '1.42', '1558578716.50', '1558578717.92', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('451', 'Started execution', '2019-05-23 10:36:54.684468', null, '1558579138.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('452', 'Executed', '2019-05-24 07:59:41.521670', '0.44', '1558655983.02', '1558655983.46', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('453', 'Executed', '2019-05-24 08:04:41.521670', '0.00', null, '1558656283.02', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('454', 'Executed', '2019-05-24 08:09:41.521670', '0.38', '1558656582.74', '1558656583.12', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('455', 'Executed', '2019-05-24 08:14:41.521670', '0.00', null, '1558656882.75', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('456', 'Started execution', '2019-05-24 08:14:41.521670', null, '1558656882.69', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('457', 'Executed', '2019-05-24 08:19:41.521670', '0.35', '1558657182.75', '1558657183.10', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('458', 'Executed', '2019-05-24 08:24:41.521670', '0.00', null, '1558657482.77', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('459', 'Started execution', '2019-05-24 08:24:41.521670', null, '1558657482.71', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('460', 'Executed', '2019-05-24 08:29:41.521670', '0.48', '1558657782.73', '1558657783.21', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('461', 'Executed', '2019-05-24 08:34:41.521670', '0.00', null, '1558658083.03', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('462', 'Started execution', '2019-05-24 08:34:41.521670', null, '1558658082.90', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('463', 'Executed', '2019-05-24 08:39:41.521670', '0.53', '1558658382.84', '1558658383.37', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('464', 'Started execution', '2019-05-24 08:44:41.521670', null, '1558658682.74', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('465', 'Executed', '2019-05-24 08:49:41.521670', '1.25', '1558658982.78', '1558658984.03', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('466', 'Started execution', '2019-05-24 08:54:41.521670', null, '1558659282.87', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('467', 'Executed', '2019-06-01 15:58:31.416910', '0.42', '1559375912.66', '1559375913.08', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('468', 'Started execution', '2019-06-01 16:03:31.416910', null, '1559376212.70', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('469', 'Error!', '2019-06-01 16:08:31.416910', '0.52', '1559376513.06', '1559376513.58', 'Error while reading from socket: (10054, \'远程主机强迫关闭了一个现有的连接。\', None, 10054, None)', '  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\apscheduler\\executors\\base.py\", line 125, in run_job\n    retval = job.func(*job.args, **job.kwargs)\n  File \"F:\\graduation-design\\graduation-design\\zcEducation\\apps\\users\\views.py\", line 358, in my_job\n    job_session_invalid()\n  File \"F:\\graduation-design\\graduation-design\\zcEducation\\apps\\users\\jobs.py\", line 13, in job_session_invalid\n    for cache_key in all_cache_key_in_cache:\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\django_redis\\client\\default.py\", line 490, in iter_keys\n    for item in client.scan_iter(match=pattern, count=itersize):\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\client.py\", line 1767, in scan_iter\n    cursor, data = self.scan(cursor=cursor, match=match, count=count)\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\client.py\", line 1754, in scan\n    return self.execute_command(\'SCAN\', *pieces)\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\client.py\", line 775, in execute_command\n    return self.parse_response(connection, command_name, **options)\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\client.py\", line 789, in parse_response\n    response = connection.read_response()\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\connection.py\", line 637, in read_response\n    response = self._parser.read_response()\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\connection.py\", line 290, in read_response\n    response = self._buffer.readline()\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\connection.py\", line 224, in readline\n    self._read_from_socket()\n  File \"E:\\dev\\Python\\Python36\\lib\\site-packages\\redis\\connection.py\", line 199, in _read_from_socket\n    (e.args,))\n', '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('470', 'Started execution', '2019-06-01 16:13:31.416910', null, '1559376813.03', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('471', 'Executed', '2019-06-01 16:18:31.416910', '0.49', '1559377112.63', '1559377113.12', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('472', 'Started execution', '2019-06-01 16:23:31.416910', null, '1559377412.82', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('473', 'Executed', '2019-06-01 16:28:31.416910', '0.48', '1559377712.70', '1559377713.18', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('474', 'Started execution', '2019-06-01 16:33:31.416910', null, '1559378012.77', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('475', 'Executed', '2019-06-01 16:38:31.416910', '0.37', '1559378312.69', '1559378313.06', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('476', 'Started execution', '2019-06-01 16:43:31.416910', null, '1559378612.67', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('477', 'Executed', '2019-06-01 16:48:31.416910', '0.43', '1559378912.83', '1559378913.26', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('478', 'Started execution', '2019-06-01 16:53:31.416910', null, '1559379212.81', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('479', 'Executed', '2019-06-01 16:58:31.416910', '0.53', '1559379512.75', '1559379513.28', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('480', 'Started execution', '2019-06-01 17:03:31.416910', null, '1559379812.80', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('481', 'Executed', '2019-06-01 17:08:31.416910', '0.38', '1559380112.81', '1559380113.19', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('482', 'Started execution', '2019-06-01 17:13:31.416910', null, '1559380412.73', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('483', 'Executed', '2019-06-01 17:18:31.416910', '0.38', '1559380712.64', '1559380713.02', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('484', 'Started execution', '2019-06-01 17:23:31.416910', null, '1559381012.73', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('485', 'Executed', '2019-06-01 17:28:31.416910', '0.48', '1559381312.66', '1559381313.14', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('486', 'Started execution', '2019-06-01 17:33:31.416910', null, '1559381612.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('487', 'Started execution', '2019-06-01 17:38:31.416910', null, '1559381912.86', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('488', 'Started execution', '2019-06-01 17:43:31.416910', null, '1559382212.84', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('489', 'Started execution', '2019-06-01 17:48:31.416910', null, '1559382512.64', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('490', 'Executed', '2019-06-02 11:59:33.858891', '0.56', '1559447975.09', '1559447975.65', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('491', 'Executed', '2019-06-02 12:04:33.858891', '0.00', null, '1559448275.25', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('492', 'Started execution', '2019-06-02 12:04:33.858891', null, '1559448275.10', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('493', 'Executed', '2019-06-02 12:09:33.858891', '0.62', '1559448575.09', '1559448575.71', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('494', 'Executed', '2019-06-02 12:14:33.858891', '0.00', null, '1559448875.23', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('495', 'Started execution', '2019-06-02 12:14:33.858891', null, '1559448875.07', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('496', 'Executed', '2019-06-02 12:19:33.858891', '0.57', '1559449175.03', '1559449175.60', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('497', 'Started execution', '2019-06-02 12:24:33.858891', null, '1559449475.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('498', 'Executed', '2019-06-02 12:24:33.858891', '0.00', null, '1559449475.35', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('499', 'Executed', '2019-06-02 12:29:33.858891', '0.70', '1559449775.18', '1559449775.88', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('500', 'Started execution', '2019-06-02 12:34:33.858891', null, '1559450075.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('501', 'Executed', '2019-06-02 12:34:33.858891', '0.00', null, '1559450075.34', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('502', 'Executed', '2019-06-02 12:39:33.858891', '0.64', '1559450375.05', '1559450375.69', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('503', 'Started execution', '2019-06-02 12:44:33.858891', null, '1559450675.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('504', 'Executed', '2019-06-02 12:49:33.858891', '0.52', '1559450975.08', '1559450975.60', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('505', 'Started execution', '2019-06-02 12:54:33.858891', null, '1559451275.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('506', 'Executed', '2019-06-02 12:59:33.858891', '0.50', '1559451575.10', '1559451575.60', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('507', 'Started execution', '2019-06-02 13:04:33.858891', null, '1559451875.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('508', 'Executed', '2019-06-02 13:09:33.858891', '0.57', '1559452175.06', '1559452175.63', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('509', 'Started execution', '2019-06-02 13:14:33.858891', null, '1559452475.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('510', 'Executed', '2019-06-02 13:19:33.858891', '0.86', '1559452775.16', '1559452776.02', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('511', 'Started execution', '2019-06-02 13:24:33.858891', null, '1559453075.37', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('512', 'Executed', '2019-06-02 13:29:33.858891', '0.52', '1559453375.14', '1559453375.66', null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('513', 'Started execution', '2019-06-02 13:34:33.858891', null, '1559453675.01', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('514', 'Started execution', '2019-06-02 13:39:33.858891', null, '1559453975.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('515', 'Started execution', '2019-06-02 13:44:33.858891', null, '1559454275.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('516', 'Started execution', '2019-06-02 13:49:33.858891', null, '1559454575.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('517', 'Started execution', '2019-06-02 13:54:33.858891', null, '1559454875.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('518', 'Started execution', '2019-06-02 13:59:33.858891', null, '1559455175.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('519', 'Started execution', '2019-06-02 14:04:33.858891', null, '1559455475.07', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('520', 'Started execution', '2019-06-02 14:09:33.858891', null, '1559455775.20', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('521', 'Started execution', '2019-06-02 14:14:33.858891', null, '1559456075.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('522', 'Started execution', '2019-06-02 14:19:33.858891', null, '1559456375.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('523', 'Started execution', '2019-06-02 14:24:33.858891', null, '1559456675.12', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('524', 'Started execution', '2019-06-02 14:29:33.858891', null, '1559456975.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('525', 'Started execution', '2019-06-02 14:34:33.858891', null, '1559457275.13', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('526', 'Started execution', '2019-06-02 14:39:33.858891', null, '1559457575.18', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('527', 'Started execution', '2019-06-02 14:44:33.858891', null, '1559457875.34', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('528', 'Started execution', '2019-06-02 14:49:33.858891', null, '1559458175.38', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('529', 'Started execution', '2019-06-02 14:54:33.858891', null, '1559458475.14', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('530', 'Started execution', '2019-06-02 14:59:33.858891', null, '1559458775.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('531', 'Started execution', '2019-06-02 15:04:33.858891', null, '1559459075.11', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('532', 'Started execution', '2019-06-02 15:09:33.858891', null, '1559459375.04', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('533', 'Started execution', '2019-06-02 15:14:33.858891', null, '1559459675.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('534', 'Started execution', '2019-06-02 15:19:33.858891', null, '1559459975.15', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('535', 'Started execution', '2019-06-02 15:24:33.858891', null, '1559460275.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('536', 'Started execution', '2019-06-02 15:29:33.858891', null, '1559460575.14', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('537', 'Started execution', '2019-06-02 15:34:33.858891', null, '1559460875.18', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('538', 'Started execution', '2019-06-02 15:39:33.858891', null, '1559461175.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('539', 'Started execution', '2019-06-02 15:44:33.858891', null, '1559461475.09', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('540', 'Started execution', '2019-06-02 15:49:33.858891', null, '1559461775.18', null, null, null, '1');
INSERT INTO `django_apscheduler_djangojobexecution` VALUES ('541', 'Started execution', '2019-06-02 15:54:33.858891', null, '1559462075.22', null, null, null, '1');

-- ----------------------------
-- Table structure for django_content_type
-- ----------------------------
DROP TABLE IF EXISTS `django_content_type`;
CREATE TABLE `django_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of django_content_type
-- ----------------------------
INSERT INTO `django_content_type` VALUES ('1', 'admin', 'logentry');
INSERT INTO `django_content_type` VALUES ('2', 'auth', 'group');
INSERT INTO `django_content_type` VALUES ('3', 'auth', 'permission');
INSERT INTO `django_content_type` VALUES ('25', 'captcha', 'captchastore');
INSERT INTO `django_content_type` VALUES ('4', 'contenttypes', 'contenttype');
INSERT INTO `django_content_type` VALUES ('9', 'courses', 'courseinfo');
INSERT INTO `django_content_type` VALUES ('12', 'courses', 'lessoninfo');
INSERT INTO `django_content_type` VALUES ('10', 'courses', 'sourceinfo');
INSERT INTO `django_content_type` VALUES ('11', 'courses', 'videoinfo');
INSERT INTO `django_content_type` VALUES ('27', 'django_apscheduler', 'djangojob');
INSERT INTO `django_content_type` VALUES ('28', 'django_apscheduler', 'djangojobexecution');
INSERT INTO `django_content_type` VALUES ('26', 'online_status', 'userrecord');
INSERT INTO `django_content_type` VALUES ('16', 'operations', 'userask');
INSERT INTO `django_content_type` VALUES ('20', 'operations', 'usercomment');
INSERT INTO `django_content_type` VALUES ('19', 'operations', 'usercourse');
INSERT INTO `django_content_type` VALUES ('18', 'operations', 'userlove');
INSERT INTO `django_content_type` VALUES ('17', 'operations', 'usermessage');
INSERT INTO `django_content_type` VALUES ('14', 'orgs', 'cityinfo');
INSERT INTO `django_content_type` VALUES ('13', 'orgs', 'orginfo');
INSERT INTO `django_content_type` VALUES ('15', 'orgs', 'teacherinfo');
INSERT INTO `django_content_type` VALUES ('5', 'sessions', 'session');
INSERT INTO `django_content_type` VALUES ('6', 'users', 'bannerinfo');
INSERT INTO `django_content_type` VALUES ('7', 'users', 'emailverifycode');
INSERT INTO `django_content_type` VALUES ('8', 'users', 'userprofile');
INSERT INTO `django_content_type` VALUES ('24', 'xadmin', 'bookmark');
INSERT INTO `django_content_type` VALUES ('21', 'xadmin', 'log');
INSERT INTO `django_content_type` VALUES ('23', 'xadmin', 'usersettings');
INSERT INTO `django_content_type` VALUES ('22', 'xadmin', 'userwidget');

-- ----------------------------
-- Table structure for django_migrations
-- ----------------------------
DROP TABLE IF EXISTS `django_migrations`;
CREATE TABLE `django_migrations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of django_migrations
-- ----------------------------
INSERT INTO `django_migrations` VALUES ('1', 'contenttypes', '0001_initial', '2019-03-29 12:33:40.134433');
INSERT INTO `django_migrations` VALUES ('2', 'contenttypes', '0002_remove_content_type_name', '2019-03-29 12:33:40.397726');
INSERT INTO `django_migrations` VALUES ('3', 'auth', '0001_initial', '2019-03-29 12:33:41.223539');
INSERT INTO `django_migrations` VALUES ('4', 'auth', '0002_alter_permission_name_max_length', '2019-03-29 12:33:41.411098');
INSERT INTO `django_migrations` VALUES ('5', 'auth', '0003_alter_user_email_max_length', '2019-03-29 12:33:41.560615');
INSERT INTO `django_migrations` VALUES ('6', 'auth', '0004_alter_user_username_opts', '2019-03-29 12:33:41.672325');
INSERT INTO `django_migrations` VALUES ('7', 'auth', '0005_alter_user_last_login_null', '2019-03-29 12:33:41.789011');
INSERT INTO `django_migrations` VALUES ('8', 'auth', '0006_require_contenttypes_0002', '2019-03-29 12:33:41.882796');
INSERT INTO `django_migrations` VALUES ('9', 'auth', '0007_alter_validators_add_error_messages', '2019-03-29 12:33:41.993464');
INSERT INTO `django_migrations` VALUES ('10', 'auth', '0008_alter_user_username_max_length', '2019-03-29 12:33:42.104169');
INSERT INTO `django_migrations` VALUES ('11', 'users', '0001_initial', '2019-03-29 12:33:43.429616');
INSERT INTO `django_migrations` VALUES ('12', 'admin', '0001_initial', '2019-03-29 12:33:43.837527');
INSERT INTO `django_migrations` VALUES ('13', 'admin', '0002_logentry_remove_auto_add', '2019-03-29 12:33:43.964253');
INSERT INTO `django_migrations` VALUES ('14', 'captcha', '0001_initial', '2019-03-29 12:33:44.216514');
INSERT INTO `django_migrations` VALUES ('15', 'orgs', '0001_initial', '2019-03-29 12:33:45.170073');
INSERT INTO `django_migrations` VALUES ('16', 'courses', '0001_initial', '2019-03-29 12:33:46.432671');
INSERT INTO `django_migrations` VALUES ('17', 'operations', '0001_initial', '2019-03-29 12:33:47.118922');
INSERT INTO `django_migrations` VALUES ('18', 'operations', '0002_auto_20190329_1233', '2019-03-29 12:33:48.189185');
INSERT INTO `django_migrations` VALUES ('19', 'sessions', '0001_initial', '2019-03-29 12:33:48.424562');
INSERT INTO `django_migrations` VALUES ('20', 'xadmin', '0001_initial', '2019-03-29 12:33:49.302217');
INSERT INTO `django_migrations` VALUES ('21', 'xadmin', '0002_log', '2019-03-29 12:33:49.785964');
INSERT INTO `django_migrations` VALUES ('22', 'xadmin', '0003_auto_20160715_0100', '2019-03-29 12:33:50.006490');
INSERT INTO `django_migrations` VALUES ('23', 'courses', '0002_auto_20190421_1543', '2019-04-21 15:44:24.187986');
INSERT INTO `django_migrations` VALUES ('24', 'courses', '0003_auto_20190505_1418', '2019-05-05 14:18:48.875947');
INSERT INTO `django_migrations` VALUES ('25', 'online_status', '0001_initial', '2019-05-05 14:18:49.727131');
INSERT INTO `django_migrations` VALUES ('26', 'online_status', '0002_auto_20190505_1428', '2019-05-05 14:28:15.500745');
INSERT INTO `django_migrations` VALUES ('27', 'online_status', '0003_auto_20190505_1433', '2019-05-05 14:33:28.355924');
INSERT INTO `django_migrations` VALUES ('28', 'online_status', '0004_auto_20190505_1440', '2019-05-05 14:40:27.529931');
INSERT INTO `django_migrations` VALUES ('29', 'online_status', '0005_auto_20190505_1447', '2019-05-05 14:47:09.485481');
INSERT INTO `django_migrations` VALUES ('32', 'django_apscheduler', '0001_initial', '2019-05-05 23:39:15.048648');
INSERT INTO `django_migrations` VALUES ('33', 'django_apscheduler', '0002_auto_20180412_0758', '2019-05-05 23:39:15.358835');
INSERT INTO `django_migrations` VALUES ('34', 'online_status', '0006_auto_20190506_1037', '2019-05-06 10:37:28.814989');
INSERT INTO `django_migrations` VALUES ('35', 'online_status', '0007_auto_20190506_1038', '2019-05-06 10:38:39.169967');
INSERT INTO `django_migrations` VALUES ('36', 'online_status', '0008_auto_20190506_1219', '2019-05-06 12:19:37.766075');
INSERT INTO `django_migrations` VALUES ('37', 'operations', '0003_auto_20190519_1425', '2019-05-19 14:25:38.275168');
INSERT INTO `django_migrations` VALUES ('38', 'online_status', '0009_auto_20190519_1446', '2019-05-19 14:46:38.469886');

-- ----------------------------
-- Table structure for django_session
-- ----------------------------
DROP TABLE IF EXISTS `django_session`;
CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_de54fa62` (`expire_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of django_session
-- ----------------------------
INSERT INTO `django_session` VALUES ('2qkpr9acx72u00hj9y0s107p4roh3kkv', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-05 15:58:21.969151');
INSERT INTO `django_session` VALUES ('3rc0orhzkcdpbjjtnygql2d7pzek1if3', 'NWYxYWEyZDMzMTVjY2UzYjYwNTI4NTU3MDcxOTQwZWNhZDliOWNmYjp7Il9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9pZCI6IjI1IiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-16 20:54:04.724322');
INSERT INTO `django_session` VALUES ('7m09jad2qngeewb1f043cu3j8i1jyzsg', 'ZTViMzJiZjRmZTE1MGY5YzMyN2MxODkzYTkyMGMwNWE2NGRkMDQwMTp7Il9hdXRoX3VzZXJfaWQiOiIyMiIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiZTY3MmEwZjkzNGUxZGYwMWM4ZGJjOWM3MmM1N2U1NWFlYjliYTJlOSJ9', '2019-05-06 19:57:09.591886');
INSERT INTO `django_session` VALUES ('8uqdbbzlo7thaxypk4af7jfugvye8h3z', 'NjkzN2RmMzhkZWJmN2MxZGE0ZjdiZTMzM2JjMjA2YjI3Yjc4MzUwMDp7Il9hdXRoX3VzZXJfaWQiOiIyMSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiZjJkYmEyOTc4N2RiYjhhNGRiNGMzY2E0NmIxNGRhNzE2OWQ0N2YwMyJ9', '2019-05-14 23:40:25.726638');
INSERT INTO `django_session` VALUES ('c3deuvoymakd74xgkcyjrh7wxzvojzf7', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-05 15:59:03.223156');
INSERT INTO `django_session` VALUES ('ch9xr5imnwirg9q84imf8nx61yar2lv1', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-19 01:04:35.010371');
INSERT INTO `django_session` VALUES ('cq8w0b9v4xm4zity7yvwabam0zgqnlya', 'YjA3ODljM2EwNjMwMDY5MmUwNDliMzcxMzQwZTY5ZjgxZDRkZmMzOTp7Il9hdXRoX3VzZXJfaWQiOiIxOCIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiNTBlNzEzOGE0M2U0Y2M4YjNhODdmMmQ1NmRmNWQ2OGEwZDY2YTY4NSIsIkxJU1RfUVVFUlkiOltbImNvdXJzZXMiLCJ2aWRlb2luZm8iXSwiIl19', '2019-04-28 16:37:31.886058');
INSERT INTO `django_session` VALUES ('hig8hygl3lpoacv0wxo55wybbjmbv616', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-05 16:06:22.086442');
INSERT INTO `django_session` VALUES ('ijkd4vr9emequasaw88g39da8xiqavrh', 'MzE3YjM4MzUwMzU2YzRmOWEzM2MxNjhhYWNmMWExYjdlZTc0ZThhMzp7Il9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9pZCI6IjI2IiwiX2F1dGhfdXNlcl9oYXNoIjoiNzVlOGJiMWIyZmYyNWExZWMxOGY0MDBjYWM5OWQwZjc4NDViNGM0MSJ9', '2019-05-18 13:00:20.205806');
INSERT INTO `django_session` VALUES ('ixgtukjju5pbfardyv96wna4jyjo35z6', 'NDc5NWUxZDQxYjI3MWQ0ZjI3YmRiNjk3NjI3ZDhlZWY0NGVkM2VlZjp7Il9hdXRoX3VzZXJfaWQiOiIxOCIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiNTBlNzEzOGE0M2U0Y2M4YjNhODdmMmQ1NmRmNWQ2OGEwZDY2YTY4NSIsIkxJU1RfUVVFUlkiOltbImNvdXJzZXMiLCJjb3Vyc2VpbmZvIl0sIiJdfQ==', '2019-04-29 22:42:14.669435');
INSERT INTO `django_session` VALUES ('n894jaunodptc9me9x0sjqai43240x21', 'NzBiZjc4MjViODgyZTJkZTMyZWY3MmE0ZGIxNGI2NzYyMTE2Mjg2Yzp7Il9hdXRoX3VzZXJfaWQiOiIyMSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiYzM0MjE1NmMyNzY4MjdjMzVmMzlhYzA5NTgwYzUxOTJiMDYyNGUyYiJ9', '2019-05-07 17:05:39.547026');
INSERT INTO `django_session` VALUES ('rjuuumssq862j4ruapzaqy1l274zr173', 'MzE3YjM4MzUwMzU2YzRmOWEzM2MxNjhhYWNmMWExYjdlZTc0ZThhMzp7Il9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9pZCI6IjI2IiwiX2F1dGhfdXNlcl9oYXNoIjoiNzVlOGJiMWIyZmYyNWExZWMxOGY0MDBjYWM5OWQwZjc4NDViNGM0MSJ9', '2019-05-17 23:19:47.360433');
INSERT INTO `django_session` VALUES ('u63bhs32sz0wuf5c3pdhdelkdnj35ekn', 'YjA3ODljM2EwNjMwMDY5MmUwNDliMzcxMzQwZTY5ZjgxZDRkZmMzOTp7Il9hdXRoX3VzZXJfaWQiOiIxOCIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiNTBlNzEzOGE0M2U0Y2M4YjNhODdmMmQ1NmRmNWQ2OGEwZDY2YTY4NSIsIkxJU1RfUVVFUlkiOltbImNvdXJzZXMiLCJ2aWRlb2luZm8iXSwiIl19', '2019-05-05 15:57:31.744458');
INSERT INTO `django_session` VALUES ('va9tq0g022q8ttkg5gftg5f5x3covm6w', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-15 20:21:10.969145');
INSERT INTO `django_session` VALUES ('wn326p9qqzqckapvfkj182j5e7faclm8', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-19 01:19:34.621962');
INSERT INTO `django_session` VALUES ('wvezpebxsgk0m3lmbu2dxp7c8f62rt49', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-05 16:11:35.785634');
INSERT INTO `django_session` VALUES ('x9uny7s7y06hb643y7m8f81m0w1gcyte', 'YWM5ODI4Y2Y4ODZlYmUyN2I4Zjk0Nzk1YTBlNjA3MjE5OTUxZThjMzp7Il9hdXRoX3VzZXJfaWQiOiIyNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiMjlmN2U4ODg1NmIxNDEzNzhiNDczZjhkZTYzNmRjYTMyZWYzYTRkYSJ9', '2019-05-05 16:14:27.944381');
INSERT INTO `django_session` VALUES ('zqlqp3laqfyohc0etjk09n1q4wh4bxmr', 'YTc0NDQyNDIzOGRmZmExNmEyYzJlYTU5ODdhYzAyMmRhZmJlN2U1YTp7Il9hdXRoX3VzZXJfaWQiOiIxNSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiNmY2ZjIzMWFkM2I3Nzk0NzE5NzUwZmU4OGY4ZjdiZGExN2ViN2JiYSJ9', '2019-04-14 16:47:51.836171');

-- ----------------------------
-- Table structure for online_status_userrecord
-- ----------------------------
DROP TABLE IF EXISTS `online_status_userrecord`;
CREATE TABLE `online_status_userrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` datetime(6) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `data_id` int(11) DEFAULT NULL,
  `data_detail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `online_status_userre_user_id_4f133936_fk_users_use` (`user_id`),
  CONSTRAINT `online_status_userre_user_id_4f133936_fk_users_use` FOREIGN KEY (`user_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=296 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of online_status_userrecord
-- ----------------------------
INSERT INTO `online_status_userrecord` VALUES ('107', '2019-05-06 17:14:58.047722', '2019-05-06 17:47:19.333222', '5', '1', '27', null, null);
INSERT INTO `online_status_userrecord` VALUES ('108', '2019-05-06 17:15:01.768801', '2019-05-06 17:15:32.616181', '5', '2', '27', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('111', '2019-05-06 17:19:45.508619', '2019-05-06 17:19:51.876853', '5', '3', '27', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('112', '2019-05-06 17:19:51.876853', '2019-05-06 17:20:09.084280', '5', '3', '27', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('113', '2019-05-06 17:20:09.084280', '2019-05-06 17:20:13.363821', '5', '3', '27', '1', '/orgs/org_detail_course/1/');
INSERT INTO `online_status_userrecord` VALUES ('114', '2019-05-06 17:20:13.363821', '2019-05-06 17:20:20.078586', '5', '3', '27', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('115', '2019-05-06 17:20:20.078586', '2019-05-06 17:20:32.764474', '5', '3', '27', '1', '/orgs/org_detail_course/1/');
INSERT INTO `online_status_userrecord` VALUES ('116', '2019-05-06 17:20:32.764474', '2019-05-06 17:22:24.702088', '5', '4', '27', '1', '/orgs/org_detail_teacher/1/');
INSERT INTO `online_status_userrecord` VALUES ('117', '2019-05-06 17:22:24.702088', '2019-05-06 17:22:47.121358', '5', '3', '27', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('118', '2019-05-06 17:22:47.121358', '2019-05-06 17:22:50.500655', '5', '3', '27', '2', '/orgs/org_header/2/');
INSERT INTO `online_status_userrecord` VALUES ('119', '2019-05-06 17:22:50.500655', '2019-05-06 17:23:07.720466', '5', '3', '27', '2', '/orgs/org_detail/2/');
INSERT INTO `online_status_userrecord` VALUES ('120', '2019-05-06 17:23:07.720466', '2019-05-06 17:24:02.548421', '5', '2', '27', '12', '/courses/course_detail/12/');
INSERT INTO `online_status_userrecord` VALUES ('121', '2019-05-06 17:24:02.548421', '2019-05-06 17:24:37.959618', '5', '2', '27', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('122', '2019-05-06 17:24:37.959618', '2019-05-06 17:25:00.861330', '5', '2', '27', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('123', '2019-05-06 17:25:00.861330', '2019-05-06 17:25:04.599765', '5', '2', '27', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('124', '2019-05-06 17:25:04.599765', '2019-05-06 17:25:08.680513', '5', '2', '27', '12', '/courses/course_detail/12/');
INSERT INTO `online_status_userrecord` VALUES ('125', '2019-05-06 17:25:08.680513', '2019-05-06 17:25:11.259149', '5', '3', '27', '2', '/orgs/org_header/2/');
INSERT INTO `online_status_userrecord` VALUES ('126', '2019-05-06 17:25:11.259149', '2019-05-06 17:57:07.691669', '5', '2', '27', '12', '/courses/course_detail/12/');
INSERT INTO `online_status_userrecord` VALUES ('127', '2019-05-06 18:06:38.637567', '2019-05-06 18:29:50.624045', '5', '1', '27', null, null);
INSERT INTO `online_status_userrecord` VALUES ('128', '2019-05-06 18:06:54.597244', '2019-05-06 18:07:00.606170', '5', '2', '27', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('129', '2019-05-06 18:07:00.606170', '2019-05-06 18:07:07.364045', '5', '2', '27', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('130', '2019-05-06 18:07:07.364045', '2019-05-06 18:07:08.875783', '5', '2', '27', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('131', '2019-05-06 18:07:10.356691', '2019-05-06 18:07:12.396151', '5', '2', '27', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('133', '2019-05-07 13:14:58.995511', '2019-05-07 13:39:43.623543', '5', '1', '27', null, null);
INSERT INTO `online_status_userrecord` VALUES ('135', '2019-05-09 13:03:18.742379', '2019-05-09 13:10:08.282465', '5', '1', '27', null, null);
INSERT INTO `online_status_userrecord` VALUES ('136', '2019-05-09 13:03:24.273546', '2019-05-09 13:04:21.679146', '5', '2', '27', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('137', '2019-05-09 13:04:21.679146', '2019-05-09 13:05:39.582409', '5', '2', '27', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('138', '2019-05-09 13:05:43.398256', '2019-05-09 13:06:01.718710', '5', '4', '27', '2', '/orgs/teacher_detail/2/');
INSERT INTO `online_status_userrecord` VALUES ('139', '2019-05-09 13:06:01.718710', '2019-05-09 13:09:50.042802', '5', '4', '27', '2', '/orgs/teacher_detail/2/');
INSERT INTO `online_status_userrecord` VALUES ('141', '2019-05-09 13:11:57.063645', '2019-05-09 13:12:10.253111', '5', '2', '28', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('142', '2019-05-09 13:13:42.313764', '2019-05-09 13:14:46.818823', '5', '2', '28', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('143', '2019-05-09 13:14:46.818823', '2019-05-09 13:15:05.967500', '5', '2', '28', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('146', '2019-05-09 15:39:52.851856', '2019-05-09 15:40:05.513392', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('147', '2019-05-09 15:40:05.513392', '2019-05-09 15:41:52.896712', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('148', '2019-05-09 15:42:08.051687', '2019-05-09 15:42:24.083185', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('150', '2019-05-13 10:09:00.094047', '2019-05-13 10:36:58.333108', '5', '1', '18', null, null);
INSERT INTO `online_status_userrecord` VALUES ('151', '2019-05-13 10:09:48.004990', '2019-05-13 10:10:14.177361', '5', '2', '18', '2', '/xadmin/courses/courseinfo/2/detail/');
INSERT INTO `online_status_userrecord` VALUES ('152', '2019-05-13 13:55:32.286628', '2019-05-13 14:24:22.054476', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('153', '2019-05-13 13:55:47.122814', '2019-05-13 13:55:51.524034', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('154', '2019-05-13 13:55:51.524034', '2019-05-13 13:57:46.242415', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('155', '2019-05-13 13:57:46.242415', '2019-05-13 13:57:48.764063', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('156', '2019-05-13 13:57:48.764063', '2019-05-13 13:57:54.553248', '5', '3', '29', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('157', '2019-05-13 13:57:54.553248', '2019-05-13 13:58:03.604144', '5', '3', '29', '1', '/orgs/org_detail_course/1/');
INSERT INTO `online_status_userrecord` VALUES ('158', '2019-05-13 13:58:03.604144', '2019-05-13 13:58:27.202603', '5', '4', '29', '1', '/orgs/org_detail_teacher/1/');
INSERT INTO `online_status_userrecord` VALUES ('159', '2019-05-13 13:58:27.202603', '2019-05-13 13:58:56.401566', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('160', '2019-05-13 13:58:56.401566', '2019-05-13 13:59:16.951295', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('161', '2019-05-13 13:59:16.951295', '2019-05-13 13:59:21.460205', '5', '2', '29', '5', '/courses/course_detail/5/');
INSERT INTO `online_status_userrecord` VALUES ('162', '2019-05-13 13:59:21.460205', '2019-05-13 13:59:22.202573', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('163', '2019-05-13 13:59:22.202573', '2019-05-13 13:59:24.442850', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('164', '2019-05-13 13:59:24.442850', '2019-05-13 13:59:25.512060', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('165', '2019-05-13 13:59:25.512060', '2019-05-13 13:59:30.522835', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('166', '2019-05-13 13:59:30.522835', '2019-05-13 13:59:31.091782', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('167', '2019-05-13 13:59:31.091782', '2019-05-13 13:59:33.590762', '5', '2', '29', '5', '/courses/course_detail/5/');
INSERT INTO `online_status_userrecord` VALUES ('168', '2019-05-13 13:59:33.590762', '2019-05-13 13:59:34.293884', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('169', '2019-05-13 13:59:34.293884', '2019-05-13 13:59:38.601926', '5', '2', '29', '5', '/courses/course_detail/5/');
INSERT INTO `online_status_userrecord` VALUES ('170', '2019-05-13 13:59:38.601926', '2019-05-13 13:59:39.519948', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('171', '2019-05-13 13:59:39.519948', '2019-05-13 13:59:41.571613', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('172', '2019-05-13 13:59:41.571613', '2019-05-13 13:59:42.900325', '5', '4', '29', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('173', '2019-05-13 13:59:42.900325', '2019-05-13 13:59:52.000578', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('174', '2019-05-13 14:00:06.470766', '2019-05-13 14:01:00.630115', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('175', '2019-05-13 14:01:00.630115', '2019-05-13 14:01:03.160606', '5', '3', '29', '3', '/orgs/org_header/3/');
INSERT INTO `online_status_userrecord` VALUES ('176', '2019-05-13 14:01:03.160606', '2019-05-13 14:01:08.041260', '5', '3', '29', '3', '/orgs/org_detail/3/');
INSERT INTO `online_status_userrecord` VALUES ('177', '2019-05-13 14:01:08.041260', '2019-05-13 14:01:09.704638', '5', '3', '29', '3', '/orgs/org_detail_course/3/');
INSERT INTO `online_status_userrecord` VALUES ('178', '2019-05-13 14:01:09.704638', '2019-05-13 14:01:20.681021', '5', '4', '29', '3', '/orgs/org_detail_teacher/3/');
INSERT INTO `online_status_userrecord` VALUES ('179', '2019-05-13 14:01:20.681021', '2019-05-13 14:01:25.279376', '5', '2', '29', '13', '/courses/course_detail/13/');
INSERT INTO `online_status_userrecord` VALUES ('180', '2019-05-13 14:01:25.279376', '2019-05-13 14:01:34.689531', '5', '2', '29', '13', '/courses/course_video/13/');
INSERT INTO `online_status_userrecord` VALUES ('181', '2019-05-13 14:01:34.689531', '2019-05-13 14:01:37.139029', '5', '2', '29', '13', '/courses/course_comment/13/');
INSERT INTO `online_status_userrecord` VALUES ('182', '2019-05-13 14:01:37.139029', '2019-05-13 14:01:39.569891', '5', '2', '29', '13', '/courses/course_comment/13/');
INSERT INTO `online_status_userrecord` VALUES ('183', '2019-05-13 14:01:39.569891', '2019-05-13 14:24:21.857973', '5', '2', '29', '13', '/courses/course_comment/13/');
INSERT INTO `online_status_userrecord` VALUES ('185', '2019-05-19 12:10:25.055601', '2019-05-19 12:13:01.674721', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('186', '2019-05-19 13:47:45.364090', '2019-05-19 13:47:47.370803', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('187', '2019-05-19 13:47:47.370803', '2019-05-19 13:50:23.020000', '5', '3', '29', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('188', '2019-05-19 13:50:23.020000', '2019-05-19 13:50:30.059115', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('189', '2019-05-19 13:50:30.059115', '2019-05-19 13:50:32.481831', '5', '3', '29', '3', '/orgs/org_header/3/');
INSERT INTO `online_status_userrecord` VALUES ('190', '2019-05-19 13:50:32.481831', '2019-05-19 13:50:33.851369', '5', '3', '29', '3', '/orgs/org_detail/3/');
INSERT INTO `online_status_userrecord` VALUES ('191', '2019-05-19 13:50:33.851369', '2019-05-19 13:51:05.455521', '5', '3', '29', '3', '/orgs/org_detail_course/3/');
INSERT INTO `online_status_userrecord` VALUES ('192', '2019-05-19 13:51:05.455521', '2019-05-19 13:51:07.860082', '5', '3', '29', '3', '/orgs/org_header/3/');
INSERT INTO `online_status_userrecord` VALUES ('195', '2019-05-19 16:28:50.610729', '2019-05-19 16:29:04.360183', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('196', '2019-05-19 16:29:04.360183', '2019-05-19 16:29:32.865753', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('197', '2019-05-19 16:29:32.865753', '2019-05-19 16:29:38.514408', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('198', '2019-05-19 16:29:38.514408', '2019-05-19 16:29:41.345059', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('199', '2019-05-19 16:29:41.345059', '2019-05-19 16:29:43.959487', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('200', '2019-05-19 16:29:43.959487', '2019-05-19 16:31:34.630273', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('201', '2019-05-19 16:31:34.630273', '2019-05-19 16:31:38.064306', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('202', '2019-05-19 16:31:38.064306', '2019-05-19 16:31:42.837165', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('203', '2019-05-19 16:31:42.837165', '2019-05-19 16:31:45.618051', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('204', '2019-05-19 16:31:45.618051', '2019-05-19 16:31:48.998411', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('205', '2019-05-19 16:31:48.998411', '2019-05-19 16:31:59.477556', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('208', '2019-05-21 15:54:22.076231', '2019-05-21 15:54:28.469914', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('209', '2019-05-21 15:56:42.075520', '2019-05-21 15:57:41.404704', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('210', '2019-05-21 15:57:41.404704', '2019-05-21 15:59:20.744216', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('212', '2019-05-21 21:25:56.937591', '2019-05-21 21:47:08.573157', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('213', '2019-05-21 21:26:57.126491', '2019-05-21 21:47:08.364715', '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('214', '2019-05-23 08:58:19.537293', '2019-05-23 09:03:16.080933', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('215', '2019-05-23 08:58:21.317221', '2019-05-23 08:58:27.926890', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('216', '2019-05-23 08:58:27.926890', '2019-05-23 08:58:50.926754', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('217', '2019-05-23 08:59:04.966595', '2019-05-23 08:59:06.907330', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('218', '2019-05-23 08:59:06.907330', '2019-05-23 08:59:13.706845', '5', '3', '29', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('219', '2019-05-23 08:59:13.706845', '2019-05-23 08:59:17.886618', '5', '3', '29', '1', '/orgs/org_detail_course/1/');
INSERT INTO `online_status_userrecord` VALUES ('220', '2019-05-23 08:59:17.886618', '2019-05-23 08:59:55.546114', '5', '4', '29', '1', '/orgs/org_detail_teacher/1/');
INSERT INTO `online_status_userrecord` VALUES ('221', '2019-05-23 09:00:01.726858', '2019-05-23 09:00:13.746128', '5', '4', '29', '2', '/orgs/teacher_detail/2/');
INSERT INTO `online_status_userrecord` VALUES ('222', '2019-05-23 09:00:13.746128', '2019-05-23 09:00:27.825799', '5', '4', '29', '4', '/orgs/teacher_detail/4/');
INSERT INTO `online_status_userrecord` VALUES ('223', '2019-05-23 09:25:20.630722', '2019-05-23 09:25:46.029798', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('224', '2019-05-23 09:25:22.539934', '2019-05-23 09:25:29.360301', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('225', '2019-05-23 09:25:29.360301', null, '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('226', '2019-05-23 10:00:52.501883', '2019-05-23 10:01:26.008989', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('227', '2019-05-23 10:00:54.089179', '2019-05-23 10:24:14.353285', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('228', '2019-05-23 10:23:48.405161', '2019-05-23 10:23:51.091654', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('229', '2019-05-23 10:23:51.091654', '2019-05-23 10:23:59.311413', '5', '2', '29', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('230', '2019-05-23 10:23:59.311413', '2019-05-23 10:24:08.616668', '5', '2', '29', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('231', '2019-05-23 10:24:18.571147', '2019-05-23 10:24:20.535780', '5', '3', '29', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('232', '2019-05-23 10:24:20.535780', '2019-05-23 10:24:25.407890', '5', '3', '29', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('233', '2019-05-23 10:24:25.407890', null, '5', '3', '29', '1', '/orgs/org_detail_course/1/');
INSERT INTO `online_status_userrecord` VALUES ('234', '2019-05-23 10:25:01.870597', '2019-05-23 10:25:03.610065', '5', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('235', '2019-05-23 10:25:03.610065', null, '5', '2', '29', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('236', '2019-05-24 08:08:26.693669', '2019-05-24 08:49:43.645602', '5', '1', '18', null, null);
INSERT INTO `online_status_userrecord` VALUES ('237', '2019-05-24 08:16:06.508761', '2019-05-24 08:16:10.328079', '5', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('238', '2019-05-24 08:16:10.328079', '2019-05-24 08:16:26.563005', '5', '2', '18', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('239', '2019-05-24 08:16:26.563005', '2019-05-24 08:17:29.712244', '5', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('240', '2019-05-24 08:17:29.712244', '2019-05-24 08:17:37.533773', '5', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('241', '2019-05-24 08:17:37.533773', '2019-05-24 08:18:25.696392', '5', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('242', '2019-05-24 08:18:25.601637', '2019-05-24 08:18:37.981058', '5', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('243', '2019-05-24 08:18:37.981058', '2019-05-24 08:24:51.001900', '5', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('244', '2019-05-24 08:18:38.336112', '2019-05-24 08:24:44.782160', '5', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('245', '2019-05-24 08:24:54.341965', '2019-05-24 08:24:56.192021', '5', '3', '18', '2', '/orgs/org_header/2/');
INSERT INTO `online_status_userrecord` VALUES ('246', '2019-05-24 08:24:56.192021', '2019-05-24 08:25:01.322768', '5', '3', '18', '2', '/orgs/org_detail/2/');
INSERT INTO `online_status_userrecord` VALUES ('247', '2019-05-24 08:25:01.322768', '2019-05-24 08:49:43.467052', '5', '3', '18', '2', '/orgs/org_header/2/');
INSERT INTO `online_status_userrecord` VALUES ('248', '2019-06-01 22:08:15.361585', null, '6', '1', '18', null, null);
INSERT INTO `online_status_userrecord` VALUES ('249', '2019-06-01 22:09:37.426893', '2019-06-01 22:12:47.444141', '6', '4', '18', '6', '/orgs/teacher_detail/6/');
INSERT INTO `online_status_userrecord` VALUES ('250', '2019-06-01 22:13:19.424290', '2019-06-01 22:13:21.463637', '6', '3', '18', '2', '/orgs/org_header/2/');
INSERT INTO `online_status_userrecord` VALUES ('251', '2019-06-01 22:13:21.463637', '2019-06-01 22:16:57.482129', '6', '3', '18', '2', '/orgs/org_detail/2/');
INSERT INTO `online_status_userrecord` VALUES ('252', '2019-06-01 22:16:57.482129', '2019-06-01 22:16:59.701179', '6', '3', '18', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('253', '2019-06-01 22:16:59.701179', '2019-06-01 22:17:02.281750', '6', '3', '18', '1', '/orgs/org_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('254', '2019-06-01 22:17:02.281750', '2019-06-01 22:17:05.632863', '6', '3', '18', '1', '/orgs/org_detail_course/1/');
INSERT INTO `online_status_userrecord` VALUES ('255', '2019-06-01 22:17:05.632863', '2019-06-01 22:17:43.753441', '6', '4', '18', '1', '/orgs/org_detail_teacher/1/');
INSERT INTO `online_status_userrecord` VALUES ('256', '2019-06-01 22:17:43.753441', '2019-06-01 22:18:23.614237', '6', '4', '18', '1', '/orgs/teacher_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('257', '2019-06-01 22:18:23.614237', '2019-06-01 22:18:30.112962', '6', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('258', '2019-06-01 22:18:30.112962', '2019-06-01 22:19:20.552134', '6', '2', '18', '1', '/courses/course_video/1/');
INSERT INTO `online_status_userrecord` VALUES ('259', '2019-06-01 22:19:20.552134', '2019-06-01 22:19:25.881607', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('260', '2019-06-01 22:19:25.881607', '2019-06-01 22:19:28.743665', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('261', '2019-06-01 22:19:28.743665', '2019-06-01 22:19:31.528802', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('262', '2019-06-01 22:19:31.528802', '2019-06-01 22:19:34.260163', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('263', '2019-06-01 22:19:34.260163', '2019-06-01 22:19:37.121358', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('264', '2019-06-01 22:19:37.121358', '2019-06-01 22:19:40.129957', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('265', '2019-06-01 22:19:40.129957', '2019-06-01 22:19:42.809364', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('266', '2019-06-01 22:19:42.809364', '2019-06-01 22:19:45.801090', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('267', '2019-06-01 22:19:45.801090', '2019-06-01 22:19:48.569812', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('268', '2019-06-01 22:19:48.569812', '2019-06-01 22:19:51.230254', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('269', '2019-06-01 22:19:51.230254', '2019-06-01 22:19:52.637795', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('270', '2019-06-01 22:19:52.637795', '2019-06-01 22:19:54.314691', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('271', '2019-06-01 22:19:54.314691', '2019-06-01 22:19:56.519063', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('272', '2019-06-01 22:19:56.519063', '2019-06-01 22:19:58.285642', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('273', '2019-06-01 22:19:58.285642', '2019-06-01 22:19:59.603321', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('274', '2019-06-01 22:19:59.603321', '2019-06-01 22:20:00.921066', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('275', '2019-06-01 22:20:00.921066', '2019-06-01 22:20:02.198650', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('276', '2019-06-01 22:20:02.198650', '2019-06-01 22:20:03.494488', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('277', '2019-06-01 22:20:03.494488', '2019-06-01 22:22:16.968597', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('278', '2019-06-01 22:22:16.968597', '2019-06-01 22:24:44.366113', '6', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('279', '2019-06-01 22:24:44.366113', '2019-06-01 22:24:55.064875', '6', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('280', '2019-06-01 22:24:55.064875', '2019-06-01 22:25:05.015537', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('281', '2019-06-01 22:25:05.015537', '2019-06-01 22:25:07.909162', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('282', '2019-06-01 22:25:07.909162', '2019-06-01 22:25:10.649183', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('283', '2019-06-01 22:25:10.649183', '2019-06-01 22:25:22.365640', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('284', '2019-06-01 22:25:22.365640', '2019-06-01 22:25:25.096735', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('285', '2019-06-01 22:25:25.096735', '2019-06-01 22:35:39.893343', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('286', '2019-06-01 22:47:03.211689', '2019-06-01 22:47:21.650631', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('287', '2019-06-01 22:47:21.650631', '2019-06-01 22:47:55.480658', '6', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('288', '2019-06-01 22:47:55.480658', '2019-06-01 22:51:04.191315', '6', '2', '18', '1', '/courses/course_comment/1/');
INSERT INTO `online_status_userrecord` VALUES ('289', '2019-06-01 22:51:04.191315', '2019-06-01 22:53:47.443041', '6', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('290', '2019-06-01 22:53:47.443041', '2019-06-01 22:59:44.632572', '6', '3', '18', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('291', '2019-06-01 22:59:44.632572', '2019-06-01 23:02:50.644337', '6', '3', '18', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('292', '2019-06-01 23:02:50.644337', '2019-06-01 23:04:02.996116', '6', '2', '18', '1', '/courses/course_detail/1/');
INSERT INTO `online_status_userrecord` VALUES ('293', '2019-06-01 23:04:02.996116', null, '6', '3', '18', '1', '/orgs/org_header/1/');
INSERT INTO `online_status_userrecord` VALUES ('294', '2019-06-02 12:19:46.762560', '2019-06-02 12:19:48.472629', '6', '1', '29', null, null);
INSERT INTO `online_status_userrecord` VALUES ('295', '2019-06-02 12:19:48.472629', null, '6', '2', '29', '1', '/courses/course_video/1/');

-- ----------------------------
-- Table structure for operations_usercomment
-- ----------------------------
DROP TABLE IF EXISTS `operations_usercomment`;
CREATE TABLE `operations_usercomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(300) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `comment_course_id` int(11) NOT NULL,
  `comment_man_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `operations_usercomment_ad012e59` (`comment_course_id`),
  KEY `operations_usercomment_5dfc3666` (`comment_man_id`),
  CONSTRAINT `operations_u_comment_course_id_39dc5cdf_fk_courses_courseinfo_id` FOREIGN KEY (`comment_course_id`) REFERENCES `courses_courseinfo` (`id`),
  CONSTRAINT `operations_userc_comment_man_id_c4c79f25_fk_users_userprofile_id` FOREIGN KEY (`comment_man_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operations_usercomment
-- ----------------------------
INSERT INTO `operations_usercomment` VALUES ('10', '但是大是大非', '2019-04-21 15:26:23.296147', '7', '20');
INSERT INTO `operations_usercomment` VALUES ('11', 'fvfc', '2019-04-24 14:35:45.146777', '13', '18');
INSERT INTO `operations_usercomment` VALUES ('12', 'edvb', '2019-04-24 14:36:09.345755', '13', '18');
INSERT INTO `operations_usercomment` VALUES ('13', 'dscx', '2019-04-24 16:57:43.741009', '1', '21');
INSERT INTO `operations_usercomment` VALUES ('14', 'dv c', '2019-04-24 17:08:12.620585', '1', '21');
INSERT INTO `operations_usercomment` VALUES ('15', 'sdcx', '2019-05-04 14:29:09.295368', '8', '25');
INSERT INTO `operations_usercomment` VALUES ('16', 'dscdcsdc', '2019-05-04 15:27:43.935917', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('17', 'sddfs', '2019-05-04 15:32:25.017419', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('18', 'dsdsv', '2019-05-04 15:32:28.875416', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('19', 'dasddfcd', '2019-05-04 15:32:31.900545', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('20', 'fdsfds', '2019-05-05 16:09:01.389361', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('21', 'fdsfds', '2019-05-05 16:09:05.205078', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('22', 'dfssdf', '2019-05-05 16:09:08.649604', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('23', 'sdfdsdf', '2019-05-05 16:09:11.626017', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('24', 'fsdfsdfds', '2019-05-05 16:09:14.912038', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('25', 'sffsfsdsfd', '2019-05-05 16:09:17.827081', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('26', 'fsddsffdsfd', '2019-05-05 16:09:21.214421', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('27', 'sdfsdfdsfds', '2019-05-05 16:09:24.364522', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('28', 'fsdfsfsfds', '2019-05-05 16:09:28.183966', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('29', 'fsdfsdfdsfs', '2019-05-05 16:09:31.185613', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('30', 'fssdfds', '2019-05-05 16:09:36.165129', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('31', 'fsdfssdfdsf', '2019-05-05 16:09:41.547527', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('32', 'fdsfsfsfsdfsafs', '2019-05-05 16:09:45.803884', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('33', 'fsdfdsfdsfds', '2019-05-05 16:09:52.738742', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('34', 'fsdcxfdscx', '2019-05-05 16:09:56.104304', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('35', 'xcfdscx', '2019-05-05 16:09:59.733290', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('36', 'fdsfesdds', '2019-05-05 16:10:04.066373', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('37', 'dsdsdcfdc', '2019-05-05 16:10:11.964599', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('38', 'dcdscxdsc', '2019-05-05 16:10:16.404629', '1', '25');
INSERT INTO `operations_usercomment` VALUES ('39', 'dsafdsdsfsd', '2019-05-06 16:31:07.851049', '1', '27');
INSERT INTO `operations_usercomment` VALUES ('40', 'dasdasdasdas', '2019-05-06 16:34:33.507266', '1', '27');
INSERT INTO `operations_usercomment` VALUES ('41', '以愉快', '2019-05-23 09:25:36.682296', '1', '29');
INSERT INTO `operations_usercomment` VALUES ('42', 'dsfcd', '2019-05-23 10:24:05.260504', '1', '29');
INSERT INTO `operations_usercomment` VALUES ('43', '这个课程讲的很好', '2019-06-01 22:48:28.007654', '1', '18');

-- ----------------------------
-- Table structure for operations_usercourse
-- ----------------------------
DROP TABLE IF EXISTS `operations_usercourse`;
CREATE TABLE `operations_usercourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `add_time` datetime(6) NOT NULL,
  `study_course_id` int(11) NOT NULL,
  `study_man_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `operations_usercourse_study_man_id_ca233d28_uniq` (`study_man_id`,`study_course_id`),
  KEY `operations_usercourse_2c9863aa` (`study_course_id`),
  KEY `operations_usercourse_b4cc9642` (`study_man_id`),
  CONSTRAINT `operations_use_study_course_id_ad6771e9_fk_courses_courseinfo_id` FOREIGN KEY (`study_course_id`) REFERENCES `courses_courseinfo` (`id`),
  CONSTRAINT `operations_usercou_study_man_id_a1251afb_fk_users_userprofile_id` FOREIGN KEY (`study_man_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operations_usercourse
-- ----------------------------
INSERT INTO `operations_usercourse` VALUES ('20', '2019-04-17 13:02:22.184945', '26', '18');
INSERT INTO `operations_usercourse` VALUES ('21', '2019-04-19 22:29:11.831741', '1', '18');
INSERT INTO `operations_usercourse` VALUES ('22', '2019-04-19 22:29:57.184650', '2', '18');
INSERT INTO `operations_usercourse` VALUES ('23', '2019-04-19 22:36:49.244765', '16', '18');
INSERT INTO `operations_usercourse` VALUES ('24', '2019-04-21 13:52:41.382718', '13', '20');
INSERT INTO `operations_usercourse` VALUES ('25', '2019-04-21 14:32:00.876111', '2', '21');
INSERT INTO `operations_usercourse` VALUES ('26', '2019-04-21 14:43:28.885576', '8', '20');
INSERT INTO `operations_usercourse` VALUES ('27', '2019-04-21 14:54:42.937517', '7', '20');
INSERT INTO `operations_usercourse` VALUES ('28', '2019-04-21 15:16:57.816177', '1', '20');
INSERT INTO `operations_usercourse` VALUES ('29', '2019-04-21 15:22:16.992669', '5', '20');
INSERT INTO `operations_usercourse` VALUES ('30', '2019-04-21 15:45:20.137294', '7', '18');
INSERT INTO `operations_usercourse` VALUES ('31', '2019-04-22 19:57:22.030780', '1', '22');
INSERT INTO `operations_usercourse` VALUES ('32', '2019-04-22 20:25:53.664344', '13', '22');
INSERT INTO `operations_usercourse` VALUES ('33', '2019-04-23 22:10:12.372679', '1', '21');
INSERT INTO `operations_usercourse` VALUES ('34', '2019-04-24 14:29:04.170704', '13', '18');
INSERT INTO `operations_usercourse` VALUES ('35', '2019-04-24 16:25:21.630550', '5', '21');
INSERT INTO `operations_usercourse` VALUES ('36', '2019-05-02 13:34:23.330551', '1', '25');
INSERT INTO `operations_usercourse` VALUES ('37', '2019-05-02 15:56:12.628571', '2', '25');
INSERT INTO `operations_usercourse` VALUES ('38', '2019-05-02 23:43:52.548706', '28', '25');
INSERT INTO `operations_usercourse` VALUES ('39', '2019-05-04 14:28:21.989575', '8', '25');
INSERT INTO `operations_usercourse` VALUES ('40', '2019-05-04 21:18:19.742549', '3', '25');
INSERT INTO `operations_usercourse` VALUES ('41', '2019-05-06 16:14:44.942310', '1', '27');
INSERT INTO `operations_usercourse` VALUES ('42', '2019-05-06 17:02:00.392038', '2', '27');
INSERT INTO `operations_usercourse` VALUES ('43', '2019-05-06 17:06:15.411201', '4', '27');
INSERT INTO `operations_usercourse` VALUES ('44', '2019-05-09 13:14:48.261187', '1', '28');
INSERT INTO `operations_usercourse` VALUES ('45', '2019-05-13 13:55:52.808003', '1', '29');
INSERT INTO `operations_usercourse` VALUES ('46', '2019-05-13 14:01:26.803710', '13', '29');

-- ----------------------------
-- Table structure for operations_userlove
-- ----------------------------
DROP TABLE IF EXISTS `operations_userlove`;
CREATE TABLE `operations_userlove` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `love_id` int(11) NOT NULL,
  `love_type` int(11) NOT NULL,
  `love_status` tinyint(1) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `love_man_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `operations_userlove_bf012eab` (`love_man_id`),
  CONSTRAINT `operations_userlove_love_man_id_7fb97ad4_fk_users_userprofile_id` FOREIGN KEY (`love_man_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operations_userlove
-- ----------------------------
INSERT INTO `operations_userlove` VALUES ('24', '3', '1', '1', '2019-04-16 18:28:30.379223', '18');
INSERT INTO `operations_userlove` VALUES ('25', '7', '1', '0', '2019-04-18 12:43:56.148019', '18');
INSERT INTO `operations_userlove` VALUES ('26', '7', '3', '1', '2019-04-19 22:34:37.934160', '18');
INSERT INTO `operations_userlove` VALUES ('27', '3', '1', '1', '2019-04-21 13:52:59.044287', '20');
INSERT INTO `operations_userlove` VALUES ('28', '1', '1', '0', '2019-04-21 13:56:11.301535', '20');
INSERT INTO `operations_userlove` VALUES ('29', '5', '2', '1', '2019-04-24 13:48:46.862572', '18');
INSERT INTO `operations_userlove` VALUES ('30', '1', '2', '1', '2019-04-24 14:05:30.247504', '18');
INSERT INTO `operations_userlove` VALUES ('31', '1', '1', '1', '2019-04-24 15:50:06.106514', '21');
INSERT INTO `operations_userlove` VALUES ('32', '1', '2', '1', '2019-04-30 19:07:38.602455', '21');
INSERT INTO `operations_userlove` VALUES ('33', '1', '3', '0', '2019-05-02 14:35:51.526806', '25');
INSERT INTO `operations_userlove` VALUES ('34', '3', '3', '0', '2019-05-02 14:41:32.730045', '25');
INSERT INTO `operations_userlove` VALUES ('35', '5', '2', '0', '2019-05-02 14:51:28.285993', '25');
INSERT INTO `operations_userlove` VALUES ('36', '1', '2', '0', '2019-05-02 15:31:19.772909', '25');
INSERT INTO `operations_userlove` VALUES ('37', '2', '2', '1', '2019-05-02 15:56:11.193299', '25');
INSERT INTO `operations_userlove` VALUES ('38', '2', '3', '0', '2019-05-02 15:56:16.770592', '25');
INSERT INTO `operations_userlove` VALUES ('39', '6', '2', '0', '2019-05-02 15:56:21.090449', '25');
INSERT INTO `operations_userlove` VALUES ('40', '1', '1', '0', '2019-05-02 15:56:24.494437', '25');
INSERT INTO `operations_userlove` VALUES ('41', '3', '1', '0', '2019-05-02 15:56:42.493627', '25');
INSERT INTO `operations_userlove` VALUES ('42', '15', '2', '1', '2019-05-02 15:56:43.685909', '25');
INSERT INTO `operations_userlove` VALUES ('43', '4', '3', '1', '2019-05-02 15:57:01.408611', '25');
INSERT INTO `operations_userlove` VALUES ('44', '1', '1', '1', '2019-05-06 16:32:38.914723', '27');
INSERT INTO `operations_userlove` VALUES ('45', '5', '2', '1', '2019-05-06 16:32:49.870899', '27');
INSERT INTO `operations_userlove` VALUES ('46', '7', '2', '1', '2019-05-06 16:35:26.869173', '27');
INSERT INTO `operations_userlove` VALUES ('47', '3', '2', '1', '2019-05-06 16:52:55.281970', '27');
INSERT INTO `operations_userlove` VALUES ('48', '12', '2', '0', '2019-05-06 17:23:43.072808', '27');
INSERT INTO `operations_userlove` VALUES ('49', '2', '1', '0', '2019-05-06 17:23:53.250143', '27');
INSERT INTO `operations_userlove` VALUES ('50', '1', '2', '1', '2019-05-09 13:03:33.422918', '27');
INSERT INTO `operations_userlove` VALUES ('51', '2', '3', '1', '2019-05-09 13:05:49.012501', '27');
INSERT INTO `operations_userlove` VALUES ('52', '1', '2', '1', '2019-05-09 13:12:03.340980', '28');
INSERT INTO `operations_userlove` VALUES ('53', '1', '1', '1', '2019-05-09 13:12:06.687391', '28');
INSERT INTO `operations_userlove` VALUES ('54', '1', '1', '1', '2019-05-13 13:58:39.230006', '29');
INSERT INTO `operations_userlove` VALUES ('55', '1', '2', '1', '2019-05-19 12:10:31.617237', '29');
INSERT INTO `operations_userlove` VALUES ('56', '2', '3', '0', '2019-05-23 09:00:06.612764', '29');
INSERT INTO `operations_userlove` VALUES ('57', '4', '3', '1', '2019-05-23 09:00:18.237130', '29');

-- ----------------------------
-- Table structure for orgs_cityinfo
-- ----------------------------
DROP TABLE IF EXISTS `orgs_cityinfo`;
CREATE TABLE `orgs_cityinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgs_cityinfo
-- ----------------------------
INSERT INTO `orgs_cityinfo` VALUES ('1', '北京', '2018-09-21 15:51:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('2', '上海', '2018-09-21 15:52:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('3', '深圳', '2018-09-21 15:52:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('4', '杭州', '2018-09-21 15:52:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('5', '南京', '2019-04-16 17:28:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('6', '湖南省', '2019-04-16 17:33:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('7', '南通', '2019-04-16 17:38:00.000000');
INSERT INTO `orgs_cityinfo` VALUES ('8', '厦门', '2019-04-16 17:40:00.000000');

-- ----------------------------
-- Table structure for orgs_orginfo
-- ----------------------------
DROP TABLE IF EXISTS `orgs_orginfo`;
CREATE TABLE `orgs_orginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(200) NOT NULL,
  `name` varchar(20) NOT NULL,
  `course_num` int(11) NOT NULL,
  `study_num` int(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  `desc` varchar(200) NOT NULL,
  `detail` longtext NOT NULL,
  `love_num` int(11) NOT NULL,
  `click_num` int(11) NOT NULL,
  `category` varchar(10) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `cityinfo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orgs_orginfo_cityinfo_id_b30bafbf_fk_orgs_cityinfo_id` (`cityinfo_id`),
  CONSTRAINT `orgs_orginfo_cityinfo_id_b30bafbf_fk_orgs_cityinfo_id` FOREIGN KEY (`cityinfo_id`) REFERENCES `orgs_cityinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgs_orginfo
-- ----------------------------
INSERT INTO `orgs_orginfo` VALUES ('1', 'org/尚学堂.jpg', '尚学堂', '0', '8', '北京', 'IT培训机构', '<p><span style=\"color: rgb(51, 51, 51); font-family: arial, 宋体, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;北京尚学堂科技有限公司是一家从事JAVA、IOS、android、hadoop大数据云计算技术开发、培训、咨询为一体的软件公司。公司由海外留学人员和国内IT精英人士创建，主要成员均拥有硕士以上学位，毕业于国内著名大学如：清华大学，北京航空航天大学等。</span></p>', '5', '94', 'pxjg', '2018-09-21 15:52:00.000000', '1');
INSERT INTO `orgs_orginfo` VALUES ('2', 'org/上海交通大学.jpg', '上海交通大学', '0', '0', '上海', '上海交通大学', '<p>&nbsp;&nbsp;&nbsp;&nbsp;上海交通大学（Shanghai Jiao Tong University），简称“上海交大”，位于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E5%B8%82/127743\" data-lemmaid=\"127743\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">上海市</a>，是由<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD%E6%95%99%E8%82%B2%E9%83%A8\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中华人民共和国教育部</a>直属、中央直管副部级建制的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E5%A4%A7%E5%AD%A6/2154589\" data-lemmaid=\"2154589\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点大学</a>，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E5%8E%86%E5%8F%B2/152769\" data-lemmaid=\"152769\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国历史</a>最悠久、享誉海内外的著名高等学府之一，位列“<a target=\"_blank\" href=\"https://baike.baidu.com/item/985%E5%B7%A5%E7%A8%8B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">985工程</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/211%E5%B7%A5%E7%A8%8B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">211工程</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%96%E7%95%8C%E4%B8%80%E6%B5%81%E5%A4%A7%E5%AD%A6%E5%BB%BA%E8%AE%BE%E9%AB%98%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">世界一流大学建设高校</a>”，入选“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%8F%A0%E5%B3%B0%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">珠峰计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/111%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">111计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/2011%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">2011计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%8C%BB%E7%94%9F%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越医生教育培养计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E6%B3%95%E5%BE%8B%E4%BA%BA%E6%89%8D%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越法律人才教育培养计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%B7%A5%E7%A8%8B%E5%B8%88%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越工程师教育培养计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%86%9C%E6%9E%97%E4%BA%BA%E6%89%8D%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越农林人才教育培养计划</a>”，为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B9%9D%E6%A0%A1%E8%81%94%E7%9B%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">九校联盟</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E5%A4%A7%E5%AD%A6%E6%A0%A1%E9%95%BF%E8%81%94%E8%B0%8A%E4%BC%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国大学校长联谊会</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/Universitas%2021\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">Universitas 21</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/21%E4%B8%96%E7%BA%AA%E5%AD%A6%E6%9C%AF%E8%81%94%E7%9B%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">21世纪学术联盟</a>的重要成员。<span class=\"sup--normal\" data-sup=\"1-3\" data-ctrmap=\":1,:2,:3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1-3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1-3]_2784\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;学校创建于1896年，原名<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E6%B4%8B%E5%85%AC%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南洋公学</a>，是中国高等教育的多个源头之一；1911年更名为“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E6%B4%8B%E5%A4%A7%E5%AD%A6%E5%A0%82\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南洋大学堂</a>”，1929年更名为“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立交通大学</a>”，1949年更名为“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">交通大学</a>”；1955年，学校迁往<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%A5%BF%E5%AE%89/121614\" data-lemmaid=\"121614\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">西安</a>，分为交通大学上海部分和西安部分；1959年两部分独立建制，上海部分启用“上海交通大学”校名；1999年，原<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E5%86%9C%E5%AD%A6%E9%99%A2\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">上海农学院</a>并入学校；2005年，学校与原<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E7%AC%AC%E4%BA%8C%E5%8C%BB%E7%A7%91%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">上海第二医科大学</a>合并为新的上海交通大学。<span class=\"sup--normal\" data-sup=\"1-2\" data-ctrmap=\":1,:2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1-2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1-2]_2784\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;截至2017年12月，学校有徐汇、闵行、黄浦、长宁、七宝、浦东等6个校区，占地面积300余万平方米；共有29个学院/直属系，24个研究院，13家附属医院，2个附属医学研究所，12个直属单位；全日制本科生（国内）16221人、研究生（国内）30895人，学位留学生2722人；专任教师3014名，其中教授989名，两院院士45名；本科专业64个，一级学科硕士点56个，专业学位硕士点23个，一级学科博士点38个，专业学位博士点3个。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_2784\"></a>&nbsp;</p><p><br/></p>', '1', '28', 'gx', '2018-09-23 14:11:00.000000', '2');
INSERT INTO `orgs_orginfo` VALUES ('3', 'org/厦门大学.jpg', '厦门大学', '0', '4', '厦门', '国内一流高校', '<p>&nbsp;&nbsp;&nbsp;&nbsp;厦门大学（<em>Xiamen University</em>），简称厦大（XMU），由著名爱国华侨领袖<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%99%88%E5%98%89%E5%BA%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">陈嘉庚</a>先生于1921年创办，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E8%BF%91%E4%BB%A3%E6%95%99%E8%82%B2%E5%8F%B2\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国近代教育史</a>上第一所<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%8E%E4%BE%A8\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">华侨</a>创办的大学，是国内最早招收研究生的大学之一，中国首个在海外建设独立校园的大学，被誉为“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E6%96%B9%E4%B9%8B%E5%BC%BA\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南方之强</a>”。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;学校直属<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%95%99%E8%82%B2%E9%83%A8\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">教育部</a>，中央直管副部级建制，是综合性研究型<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E5%A4%A7%E5%AD%A6/2154589\" data-lemmaid=\"2154589\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点大学</a>。教育部、国家国防科技工业局、福建省和厦门市重点共建，是国家“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8F%8C%E4%B8%80%E6%B5%81/19394525\" data-lemmaid=\"19394525\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">双一流</a>”<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%96%E7%95%8C%E4%B8%80%E6%B5%81%E5%A4%A7%E5%AD%A6%E5%BB%BA%E8%AE%BE%E9%AB%98%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">世界一流大学建设高校</a>，国家“<a target=\"_blank\" href=\"https://baike.baidu.com/item/2011%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">2011计划</a>”牵头高校，国家“<a target=\"_blank\" href=\"https://baike.baidu.com/item/211%E5%B7%A5%E7%A8%8B/203547\" data-lemmaid=\"203547\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">211工程</a>“和“<a target=\"_blank\" href=\"https://baike.baidu.com/item/985%E5%B7%A5%E7%A8%8B/1077915\" data-lemmaid=\"1077915\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">985工程</a>”重点建设高校，首批20所学位自主审核高校，入选<a target=\"_blank\" href=\"https://baike.baidu.com/item/111%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">111计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%8F%A0%E5%B3%B0%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">珠峰计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%B7%A5%E7%A8%8B%E5%B8%88%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越工程师教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E6%B3%95%E5%BE%8B%E4%BA%BA%E6%89%8D%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越法律人才教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%8C%BB%E7%94%9F%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越医生教育培养计划</a>、国家级<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%96%B0%E5%B7%A5%E7%A7%91%E7%A0%94%E7%A9%B6%E4%B8%8E%E5%AE%9E%E8%B7%B5%E9%A1%B9%E7%9B%AE/22833448\" data-lemmaid=\"22833448\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">新工科研究与实践项目</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E5%BB%BA%E8%AE%BE%E9%AB%98%E6%B0%B4%E5%B9%B3%E5%A4%A7%E5%AD%A6%E5%85%AC%E6%B4%BE%E7%A0%94%E7%A9%B6%E7%94%9F%E9%A1%B9%E7%9B%AE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家建设高水平大学公派研究生项目</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E6%94%BF%E5%BA%9C%E5%A5%96%E5%AD%A6%E9%87%91%E6%9D%A5%E5%8D%8E%E7%95%99%E5%AD%A6%E7%94%9F%E6%8E%A5%E6%94%B6%E9%99%A2%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国政府奖学金来华留学生接收院校</a>。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;厦门大学被誉为“中国最美大学”<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_6408\"></a>&nbsp;&nbsp;，校园衔山含湖、面朝大海，背靠<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%87%E7%9F%B3%E6%A4%8D%E7%89%A9%E5%9B%AD/6683028\" data-lemmaid=\"6683028\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">万石植物园</a>，一侧是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E6%99%AE%E9%99%80%E5%AF%BA\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南普陀寺</a>，一侧是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%99%BD%E5%9F%8E%E6%B2%99%E6%BB%A9/4803299\" data-lemmaid=\"4803299\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">白城沙滩</a>，与世界文化遗产<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%BC%93%E6%B5%AA%E5%B1%BF/483700\" data-lemmaid=\"483700\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">鼓浪屿</a>隔海相望，包括群贤楼群、建南楼群、芙蓉楼群以及<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8E%A6%E9%97%A8%E5%A4%A7%E5%AD%A6%E4%BA%BA%E7%B1%BB%E5%AD%A6%E5%8D%9A%E7%89%A9%E9%A6%86/2035821\" data-lemmaid=\"2035821\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">厦门大学人类学博物馆</a>在内的学校早期建筑为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E6%96%87%E7%89%A9%E4%BF%9D%E6%8A%A4%E5%8D%95%E4%BD%8D\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点文物保护单位</a>、入选“首批<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD20%E4%B8%96%E7%BA%AA%E5%BB%BA%E7%AD%91%E9%81%97%E4%BA%A7\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国20世纪建筑遗产</a>”名录。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;厦门大学有在校生近40000人<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_6408\"></a>&nbsp;&nbsp;，下设6个学部、28个学院和14个研究院；拥有10家附属医院<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_6408\"></a>&nbsp;&nbsp;；占地9000多亩；共有16个学科进入<a target=\"_blank\" href=\"https://baike.baidu.com/item/ESI/3812216\" data-lemmaid=\"3812216\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">ESI</a>全球前1%，列中国大陆高校第11位<span class=\"sup--normal\" data-sup=\"4\" data-ctrmap=\":4,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[4]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[4]_6408\"></a>&nbsp;&nbsp;；CWUR世界大学排名（中国内地）第10位<span class=\"sup--normal\" data-sup=\"5\" data-ctrmap=\":5,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[5]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[5]_6408\"></a>&nbsp;&nbsp;；<a target=\"_blank\" href=\"https://baike.baidu.com/item/USNews%E4%B8%96%E7%95%8C%E5%A4%A7%E5%AD%A6%E6%8E%92%E5%90%8D/15979499\" data-lemmaid=\"15979499\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">USNews世界大学排名</a>（中国内地）第12位<span class=\"sup--normal\" data-sup=\"6\" data-ctrmap=\":6,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[6]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[6]_6408\"></a>&nbsp;&nbsp;；自然指数列内地高校第9位<span class=\"sup--normal\" data-sup=\"7\" data-ctrmap=\":7,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[7]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[7]_6408\"></a>&nbsp;&nbsp;；居中国大学社会捐赠收入第3位<span class=\"sup--normal\" data-sup=\"8\" data-ctrmap=\":8,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[8]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[8]_6408\"></a>&nbsp;&nbsp;。</p><p><br/></p>', '3', '14', 'gx', '2018-09-23 14:13:00.000000', '8');
INSERT INTO `orgs_orginfo` VALUES ('4', 'org/千峰教育.jpg', '千峰教育', '0', '0', '北京', '千锋教育一直秉承“用良心做教育”的理念', '<p>&nbsp;&nbsp;&nbsp;&nbsp;千锋教育一直秉承“用良心做教育”的理念，中国移动互联网研发人才一体化服务的领导品牌，全力打造移动互联网高端研发人才服务平台。拥有全国权威的移动互联网教学就业保障团队，毕业学员占据了全国移动互联网培训人才一半以上的份额，做到了毕业学员业内高薪水，成为学员信赖的IT培训机构。拥有上百所合作高校，上千家移动互联网方向合作企业。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;公司总部位于北京，目前已在深圳、上海、郑州、广州、大连、武汉、成都、西安、杭州、青岛、重庆、长沙、哈尔滨、南京、太原建立分公司。<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_11873840\"></a>&nbsp;&nbsp;<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%83%E9%94%8B/5726118\" data-lemmaid=\"5726118\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">千锋</a>用微薄之力改变着中国的IT教育培训事业。每年有数十万学员受益于千锋教育组织的技术研讨会、技术<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9F%B9%E8%AE%AD/248163\" data-lemmaid=\"248163\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">培训</a>课、网络公开课以及免费教学视频。</p><p><br/></p>', '0', '3', 'pxjg', '2018-09-23 14:13:00.000000', '1');
INSERT INTO `orgs_orginfo` VALUES ('5', 'org/南通大学.jpg', '南通大学', '0', '0', '南通', '南通大学', '<p>&nbsp; &nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;南通大学（Nantong University），简称“通大”，位于江苏省<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E9%80%9A%E5%B8%82/2208115\" data-lemmaid=\"2208115\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南通市</a>，学校是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%9F%E8%8B%8F%E7%9C%81%E4%BA%BA%E6%B0%91%E6%94%BF%E5%BA%9C/8842152\" data-lemmaid=\"8842152\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">江苏省人民政府</a>和<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%A4%E9%80%9A%E8%BF%90%E8%BE%93%E9%83%A8/835235\" data-lemmaid=\"835235\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">交通运输部</a>共建的综合性大学，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%9F%E8%8B%8F%E7%9C%81/320938\" data-lemmaid=\"320938\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">江苏省</a>十五所重点建设大学成员，国家“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%8C%BB%E7%94%9F%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/3805307\" data-lemmaid=\"3805307\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越医生教育培养计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E6%95%99%E5%B8%88%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/15877912\" data-lemmaid=\"15877912\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越教师培养计划</a>”试点高校，教育部本科教学工作水平评估优秀学校，首批江苏高水平大学建设培育支持高校，国家首批具有学士和硕士学位授予权的单位，博士学位授予单位，全国普通高等学校毕业生就业工作先进集体，全国高等学校创业教育研究与实践先进单位，江苏省首批创新创业示范高校，江苏省首批教学工作先进高校，全国精神文明建设先进单位，全国精神文明建设典型“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%8E%AB%E6%96%87%E9%9A%8B/7963165\" data-lemmaid=\"7963165\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">莫文隋</a>”精神的发源地。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;学校的办学历史最早可追溯到近代著名实业家、教育家<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%BC%A0%E8%AC%87/1129763\" data-lemmaid=\"1129763\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">张謇</a>先生于1912年创办的私立南通医学专门学校和南通纺织专门学校。2004年5月经教育部批准，原<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E9%80%9A%E5%8C%BB%E5%AD%A6%E9%99%A2/771166\" data-lemmaid=\"771166\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南通医学院</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E9%80%9A%E5%B7%A5%E5%AD%A6%E9%99%A2/1107089\" data-lemmaid=\"1107089\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南通工学院</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E9%80%9A%E5%B8%88%E8%8C%83%E5%AD%A6%E9%99%A2/1356206\" data-lemmaid=\"1356206\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南通师范学院</a>三所省属公办本科院校合并组建新的南通大学。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;截至2019年1月，学校有4个校区，占地面积3700余亩，建筑面积近100万平方米；设有22个学院、1个独立学院、1家直属大型综合三级甲等医院；拥有2个博士后流动站，3个一级学科博士点，22个一级学科硕士点，10个硕士专业学位点；3个学科进入<a target=\"_blank\" href=\"https://baike.baidu.com/item/ESI/3812216\" data-lemmaid=\"3812216\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">ESI</a>全球排名前1%；开设104个本科专业（2018年招生专业85个），涵盖文学、理学、工学、医学、艺术学、经济学、法学、教育学、历史学、管理学等10个学科门类；有全日制在校本科生38000余人（含独立学院11000余人），研究生2700余人，留学生750余人。<span class=\"sup--normal\" data-sup=\"1-3\" data-ctrmap=\":1,:2,:3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1-3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1-3]_17160\"></a>&nbsp;</p><p><br/></p>', '0', '3', 'gx', '2018-09-23 14:14:00.000000', '7');
INSERT INTO `orgs_orginfo` VALUES ('6', 'org/南京农业大学.jpg', '南京农业大学', '0', '1', '南京', '南京高校', '<p>&nbsp;&nbsp;&nbsp;&nbsp;南京农业大学（Nanjing Agricultural University）坐落于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%99%8E%E8%B8%9E%E9%BE%99%E8%9F%A0/7813210\" data-lemmaid=\"7813210\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">虎踞龙蟠</a>的古都<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC/23952\" data-lemmaid=\"23952\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京</a>，是一所以<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%86%9C%E4%B8%9A%E7%A7%91%E5%AD%A6/1298289\" data-lemmaid=\"1298289\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">农业科学</a>与<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%94%9F%E5%91%BD%E7%A7%91%E5%AD%A6/80506\" data-lemmaid=\"80506\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">生命科学</a>为优势和特色，农、理、经、管、工、文、法学多学科协调发展的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%95%99%E8%82%B2%E9%83%A8\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">教育部</a>直属<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点大学</a>，是国家“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8F%8C%E4%B8%80%E6%B5%81\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">双一流</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/211%E5%B7%A5%E7%A8%8B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">211工程</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/985%E5%B7%A5%E7%A8%8B%E4%BC%98%E5%8A%BF%E5%AD%A6%E7%A7%91%E5%88%9B%E6%96%B0%E5%B9%B3%E5%8F%B0\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">985工程优势学科创新平台</a>”重点建设高校，入选<a target=\"_blank\" href=\"https://baike.baidu.com/item/111%E8%AE%A1%E5%88%92/10958807\" data-lemmaid=\"10958807\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">111计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/2011%E8%AE%A1%E5%88%92/2913309\" data-lemmaid=\"2913309\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">2011计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/863%E8%AE%A1%E5%88%92/114257\" data-lemmaid=\"114257\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">863计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/973%E8%AE%A1%E5%88%92/3055993\" data-lemmaid=\"3055993\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">973计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%86%9C%E6%9E%97%E4%BA%BA%E6%89%8D%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/15906214\" data-lemmaid=\"15906214\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越农林人才教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%83%E4%BA%BA%E8%AE%A1%E5%88%92/3421303\" data-lemmaid=\"3421303\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">千人计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E5%BB%BA%E8%AE%BE%E9%AB%98%E6%B0%B4%E5%B9%B3%E5%A4%A7%E5%AD%A6%E5%85%AC%E6%B4%BE%E7%A0%94%E7%A9%B6%E7%94%9F%E9%A1%B9%E7%9B%AE/819876\" data-lemmaid=\"819876\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家建设高水平大学公派研究生项目</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E6%94%BF%E5%BA%9C%E5%A5%96%E5%AD%A6%E9%87%91%E6%9D%A5%E5%8D%8E%E7%95%99%E5%AD%A6%E7%94%9F%E6%8E%A5%E6%94%B6%E9%99%A2%E6%A0%A1/15447730\" data-lemmaid=\"15447730\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国政府奖学金来华留学生接收院校</a>，设有<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A0%94%E7%A9%B6%E7%94%9F%E9%99%A2/9335524\" data-lemmaid=\"9335524\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">研究生院</a>，是“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8F%8C%E4%B8%80%E6%B5%81/19394525\" data-lemmaid=\"19394525\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">双一流</a>”农科联盟和<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%AB%98%E6%B0%B4%E5%B9%B3%E8%A1%8C%E4%B8%9A%E7%89%B9%E8%89%B2%E5%A4%A7%E5%AD%A6%E4%BC%98%E8%B4%A8%E8%B5%84%E6%BA%90%E5%85%B1%E4%BA%AB%E8%81%94%E7%9B%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">高水平行业特色大学优质资源共享联盟</a>成员高校。<span class=\"sup--normal\" data-sup=\"1-2\" data-ctrmap=\":1,:2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1-2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1-2]_5954\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;南京农业大学前身可溯源至1902年<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%89%E6%B1%9F%E5%B8%88%E8%8C%83%E5%AD%A6%E5%A0%82/5683215\" data-lemmaid=\"5683215\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">三江师范学堂</a>和1914年<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%87%91%E9%99%B5%E5%A4%A7%E5%AD%A6/1128404\" data-lemmaid=\"1128404\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">金陵大学</a>。1952年全国高校院系调整，以<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%87%91%E9%99%B5%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">金陵大学</a>和原<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%A4%A7%E5%AD%A6/5303368\" data-lemmaid=\"5303368\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立中央大学</a>的农学院系为主体，以及<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B5%99%E6%B1%9F%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">浙江大学</a>部分系科，合并成立<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E5%86%9C%E5%AD%A6%E9%99%A2/5108153\" data-lemmaid=\"5108153\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京农学院</a>。1963年被确定为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E5%A4%A7%E5%AD%A6/2154589\" data-lemmaid=\"2154589\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点大学</a>。1984年更名为南京农业大学。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_5954\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;截至2018年3月，学校设有19个学院（部）、62个本科专业、31个一级学科硕士学位授权点、17个一级学科博士学位授权点和15个<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%9A%E5%A3%AB%E5%90%8E%E7%A7%91%E7%A0%94%E6%B5%81%E5%8A%A8%E7%AB%99/7310663\" data-lemmaid=\"7310663\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">博士后科研流动站</a>，拥有4个<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%80%E7%BA%A7%E5%AD%A6%E7%A7%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">一级学科</a><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E9%87%8D%E7%82%B9%E5%AD%A6%E7%A7%91/7871690\" data-lemmaid=\"7871690\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家重点学科</a>、3个二级学科<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E9%87%8D%E7%82%B9%E5%AD%A6%E7%A7%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家重点学科</a>和1个<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E9%87%8D%E7%82%B9%EF%BC%88%E5%9F%B9%E8%82%B2%EF%BC%89%E5%AD%A6%E7%A7%91/7221699\" data-lemmaid=\"7221699\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家重点（培育）学科</a>。现有全日制本科生17000余人，研究生8500余人。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_5954\"></a>&nbsp;&nbsp;校区总面积9平方公里，建筑面积74万平方米，资产总值35亿元，图书资料收藏量超过235万册，拥有<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%94%B5%E5%AD%90%E5%9B%BE%E4%B9%A6/1239490\" data-lemmaid=\"1239490\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">电子图书</a>1500余万册。<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_5954\"></a>&nbsp;&nbsp;有7个学科在第四轮<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%AB%98%E6%A0%A1%E5%AD%A6%E7%A7%91%E8%AF%84%E4%BC%B0/5595750\" data-lemmaid=\"5595750\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国高校学科评估</a>中进入A类，其中<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BD%9C%E7%89%A9%E5%AD%A6/1071842\" data-lemmaid=\"1071842\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">作物学</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%86%9C%E4%B8%9A%E8%B5%84%E6%BA%90%E4%B8%8E%E7%8E%AF%E5%A2%83/5004315\" data-lemmaid=\"5004315\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">农业资源与环境</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%A4%8D%E7%89%A9%E4%BF%9D%E6%8A%A4/2402281\" data-lemmaid=\"2402281\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">植物保护</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%86%9C%E6%9E%97%E7%BB%8F%E6%B5%8E%E7%AE%A1%E7%90%86/4682632\" data-lemmaid=\"4682632\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">农林经济管理</a>4个学科获评A+，A+学科数并列全国高校第11位。<span class=\"sup--normal\" data-sup=\"4-5\" data-ctrmap=\":4,:5,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[4-5]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[4-5]_5954\"></a>&nbsp;</p><p><br/></p>', '0', '3', 'gx', '2018-09-23 14:14:00.000000', '5');
INSERT INTO `orgs_orginfo` VALUES ('7', 'org/南京大学.jpg', '南京大学', '0', '0', '南京', '南京著名高校', '<p>&nbsp;&nbsp;&nbsp;&nbsp;南京大学（Nanjing University），简称“南大”，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD%E6%95%99%E8%82%B2%E9%83%A8/3507526\" data-lemmaid=\"3507526\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中华人民共和国教育部</a>直属、中央直管<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%89%AF%E9%83%A8%E7%BA%A7\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">副部级</a>建制的综合性<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E5%A4%A7%E5%AD%A6/2154589\" data-lemmaid=\"2154589\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点大学</a>，是历史悠久、声誉卓著的百年名校。位列首批国家“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8F%8C%E4%B8%80%E6%B5%81/19394525\" data-lemmaid=\"19394525\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">双一流</a>“世界一流大学A类建设高校、”<a target=\"_blank\" href=\"https://baike.baidu.com/item/211%E5%B7%A5%E7%A8%8B/203547\" data-lemmaid=\"203547\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">211工程</a>“、”<a target=\"_blank\" href=\"https://baike.baidu.com/item/985%E5%B7%A5%E7%A8%8B/1077915\" data-lemmaid=\"1077915\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">985工程</a>”，入选“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%8F%A0%E5%B3%B0%E8%AE%A1%E5%88%92/4156302\" data-lemmaid=\"4156302\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">珠峰计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/111%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">111计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/2011%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">2011计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%B7%A5%E7%A8%8B%E5%B8%88%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越工程师教育培养计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%8C%BB%E7%94%9F%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/3805307\" data-lemmaid=\"3805307\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越医生教育培养计划</a>”、“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E6%B3%95%E5%BE%8B%E4%BA%BA%E6%89%8D%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/9781317\" data-lemmaid=\"9781317\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越法律人才教育培养计划</a>”，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B9%9D%E6%A0%A1%E8%81%94%E7%9B%9F/2059866\" data-lemmaid=\"2059866\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">九校联盟</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E5%A4%A7%E5%AD%A6%E6%A0%A1%E9%95%BF%E8%81%94%E8%B0%8A%E4%BC%9A/9327515\" data-lemmaid=\"9327515\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国大学校长联谊会</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%8E%AF%E5%A4%AA%E5%B9%B3%E6%B4%8B%E5%A4%A7%E5%AD%A6%E8%81%94%E7%9B%9F/4603258\" data-lemmaid=\"4603258\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">环太平洋大学联盟</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/21%E4%B8%96%E7%BA%AA%E5%AD%A6%E6%9C%AF%E8%81%94%E7%9B%9F/7773858\" data-lemmaid=\"7773858\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">21世纪学术联盟</a>和<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%9C%E4%BA%9A%E7%A0%94%E7%A9%B6%E5%9E%8B%E5%A4%A7%E5%AD%A6%E5%8D%8F%E4%BC%9A/7175291\" data-lemmaid=\"7175291\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">东亚研究型大学协会</a>成员。<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_3143\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;南京大学其学脉可追溯自孙吴永安元年（258年）的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E5%A4%AA%E5%AD%A6/2964094\" data-lemmaid=\"2964094\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京太学</a>，近代校史肇始于1902年创建的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%89%E6%B1%9F%E5%B8%88%E8%8C%83%E5%AD%A6%E5%A0%82/5683215\" data-lemmaid=\"5683215\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">三江师范学堂</a>，此后历经<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%A4%E6%B1%9F%E5%B8%88%E8%8C%83%E5%AD%A6%E5%A0%82/2722765\" data-lemmaid=\"2722765\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">两江师范学堂</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E9%AB%98%E7%AD%89%E5%B8%88%E8%8C%83%E5%AD%A6%E6%A0%A1/9884301\" data-lemmaid=\"9884301\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京高等师范学校</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E4%B8%9C%E5%8D%97%E5%A4%A7%E5%AD%A6/6105694\" data-lemmaid=\"6105694\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立东南大学</a>等历史时期，1949年由民国时期中国最高学府“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%A4%A7%E5%AD%A6/5303368\" data-lemmaid=\"5303368\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立中央大学</a>”易名“国立南京大学”，1950年径称“南京大学”并沿用至今。1920年在中国国立高等学府中首开“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A5%B3%E7%A6%81\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">女禁</a>”，引领男女同校之风。最早在中国开展现代学术研究，建立中国最早的现代科学研究实验室，成为中国第一所以大学自治、学术自由、文理为基本兼有农工商等专门应用科、集教学和研究于一体的现代大学，被国际上誉为“东方教育的中心”。<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_3143\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;南京大学是中国现代科学的发祥地之一，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%93%88%E4%BD%9B%E5%A4%A7%E5%AD%A6/261536\" data-lemmaid=\"261536\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">哈佛大学</a>白碧德主义影响下的中国“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%AD%A6%E8%A1%A1%E6%B4%BE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">学衡派</a>”的雅集地，被誉为“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E7%A7%91%E5%AD%A6%E7%A4%BE/7189186\" data-lemmaid=\"7189186\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国科学社</a>的大本营和科学发展的主要基地”，是“<a target=\"_blank\" href=\"https://baike.baidu.com/item/985%E5%B7%A5%E7%A8%8B/1077915\" data-lemmaid=\"1077915\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">985工程</a>”首批九所高水平大学中唯一未合并其他院校的高校，坚持“内涵发展”，赢得社会“中国最温和的大学”之美誉。<span class=\"sup--normal\" data-sup=\"1-8\" data-ctrmap=\":2,:3,:1,:4,:5,:6,:7,:8,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1-8]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1-8]_3143\"></a>&nbsp;</p><p><br/></p>', '0', '2', 'gx', '2018-09-23 14:15:00.000000', '5');
INSERT INTO `orgs_orginfo` VALUES ('8', 'org/南华大学_ZgSrEOq.jpg', '南华大学', '0', '0', '湖南省', '湖南省高校', '<p>&nbsp;&nbsp;&nbsp;&nbsp;南华大学位于湖南省衡阳市，是国家<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B7%A5%E4%B8%9A%E5%92%8C%E4%BF%A1%E6%81%AF%E5%8C%96%E9%83%A8/835197\" data-lemmaid=\"835197\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">工业和信息化部</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E9%98%B2%E7%A7%91%E6%8A%80%E5%B7%A5%E4%B8%9A%E5%B1%80/3903472\" data-lemmaid=\"3903472\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国防科技工业局</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E6%A0%B8%E5%B7%A5%E4%B8%9A%E9%9B%86%E5%9B%A2%E5%85%AC%E5%8F%B8/10596284\" data-lemmaid=\"10596284\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国核工业集团公司</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E6%A0%B8%E5%B7%A5%E4%B8%9A%E5%BB%BA%E8%AE%BE%E9%9B%86%E5%9B%A2%E5%85%AC%E5%8F%B8/10596174\" data-lemmaid=\"10596174\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国核工业建设集团公司</a>与<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B9%96%E5%8D%97%E7%9C%81%E4%BA%BA%E6%B0%91%E6%94%BF%E5%BA%9C/8264517\" data-lemmaid=\"8264517\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">湖南省人民政府</a>共建的综合性大学，是国家<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E8%A5%BF%E9%83%A8%E9%AB%98%E6%A0%A1%E5%9F%BA%E7%A1%80%E8%83%BD%E5%8A%9B%E5%BB%BA%E8%AE%BE%E5%B7%A5%E7%A8%8B/6590386\" data-lemmaid=\"6590386\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中西部高校基础能力建设工程</a>支持建设高校，入选<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%B7%A5%E7%A8%8B%E5%B8%88%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/4942299\" data-lemmaid=\"4942299\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越工程师教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%8C%BB%E7%94%9F%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/3805307\" data-lemmaid=\"3805307\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越医生教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E7%8E%AF%E5%A2%83%E4%BF%9D%E6%8A%A4%E5%9F%B9%E8%AE%AD%E5%9F%BA%E5%9C%B0/22346489\" data-lemmaid=\"22346489\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家环境保护培训基地</a>、教育部首批“新工科”研究与实践项目、国家核应急宣传和培训基地及国家核应急医学救援分队<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_11243730\"></a>&nbsp;&nbsp;。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;学校由原隶属国家核工业部的中南工学院与原隶属湖南省的衡阳医学院于2000年5月合并组建的多科性大学。2002年10月，原隶属国家核工业部的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%A0%B8%E5%B7%A5%E4%B8%9A%E7%AC%AC%E5%85%AD%E7%A0%94%E7%A9%B6%E6%89%80/5224169\" data-lemmaid=\"5224169\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">核工业第六研究所</a>并入南华大学。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_11243730\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;截至2018年9月，学校有红湘和雨母两个校区，设置教学学院18个，拥有直属型附属医院4所、协作型附属医院11所、研究生协作培养单位25个；开办本科专业73个，拥有博士后科研流动工作站3个、学术学位一级学科博士点5个、学术学位二级学科博士点33个、学术学位一级学科硕士点24个、学术学位二级学科硕士点127个、硕士专业学位授权类别13种、工程硕士专业学位授权领域11个；共有学生5万余人，其中全日制本科生近3万余人，博士、硕士研究生近4000余人，国际学生400余人，成人教育本专科生近1万8千人。<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_11243730\"></a>&nbsp;</p><p><br/> </p>', '0', '2', 'gx', '2018-09-23 14:16:00.000000', '6');
INSERT INTO `orgs_orginfo` VALUES ('9', 'org/慕课网.jpg', '慕课网', '0', '0', '北京', '慕课网是垂直的互联网IT技能免费学习网站', '<p>&nbsp; &nbsp;慕课网是垂直的互联网IT技能免费学习网站。以独家<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%A7%86%E9%A2%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">视频</a>教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;慕课网课程涵盖<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%89%8D%E7%AB%AF%E5%BC%80%E5%8F%91/10009024\" data-lemmaid=\"10009024\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">前端开发</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/PHP/9337\" data-lemmaid=\"9337\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">PHP</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/Html5\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">Html5</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/Android/60243\" data-lemmaid=\"60243\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">Android</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/iOS/45705\" data-lemmaid=\"45705\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">iOS</a>、Swift等IT前沿技术语言，包括基础<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%AF%BE%E7%A8%8B/3314872\" data-lemmaid=\"3314872\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">课程</a>、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_11286966\"></a>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;4月2日，国内首个IT技能学习类应用——慕课网3.1.0版本在应用宝首发。据了解，在此次上线的版本中，慕课网新增了课程历史记录、相关课程推荐等四大功能，为用户营造更加丰富的移动端IT学习体验。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_11286966\"></a>&nbsp;</p><p><br/></p>', '0', '1', 'pxjg', '2018-09-23 14:17:00.000000', '1');
INSERT INTO `orgs_orginfo` VALUES ('10', 'org/麦子学院.jpg', '麦子学院', '0', '0', '杭州', '麦子学院: IT 培训机构', '<p>&nbsp;&nbsp;&nbsp;&nbsp;麦子学院，国内第一家在美国建立<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%95%86%E5%8A%A1%E4%B8%AD%E5%BF%83/10580667\" data-lemmaid=\"10580667\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">商务中心</a>的IT在线教育机构，目前已与美国知名教育公司取得合作，未来将源源不断向国内输出大量高质量教育资源</p><p>&nbsp;&nbsp;&nbsp;&nbsp;前身<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%BA%A6%E5%8F%AF%E7%BD%91/2132225\" data-lemmaid=\"2132225\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">麦可网</a>，2014年，麦可网完成千万级A轮融资，并更名为”麦子学院“，同时通过“麦子圈”IT职业实名<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A4%BE%E4%BA%A4%E5%9C%88\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">社交圈</a>——提供包括企业招聘对接，猎头，项目外包，经验分享，职业交友等一系列增值服务。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;做在线<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%81%8C%E4%B8%9A/2133531\" data-lemmaid=\"2133531\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">职业</a>教育示范学院，将<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%95%99%E8%82%B2/143397\" data-lemmaid=\"143397\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">教育</a>和课程做到极致。除了提供高质量的课程学习之外，也提供包括就业推荐，职业交友，项目外包，创业服务等全面的增值服务，并且线上线下结合，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A7%BB%E5%8A%A8%E8%AE%BE%E5%A4%87/9157757\" data-lemmaid=\"9157757\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">移动设备</a>和传统网络相结合，打造IT职业教育的一个完整生态链。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;以高端IT技术型人才培养及服务为核心，探索及<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%80%A1%E5%AF%BC/3661688\" data-lemmaid=\"3661688\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">倡导</a>技术交流创新模式。提供的不仅仅是技能<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9F%B9%E5%85%BB/8667234\" data-lemmaid=\"8667234\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">培养</a>，而是务实的职业导向。</p><p><br/></p>', '0', '3', 'gr', '2018-09-23 14:17:00.000000', '4');
INSERT INTO `orgs_orginfo` VALUES ('11', 'org/极客学院.jpg', '极客学院', '0', '1', '北京', '极客学院IT培训机构', '<p>&nbsp;&nbsp;&nbsp;&nbsp;极客学院<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_12447205\"></a>&nbsp;&nbsp;是中国<a target=\"_blank\" href=\"https://baike.baidu.com/item/android/60243\" data-lemmaid=\"60243\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">android</a>开发在线学习<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B9%B3%E5%8F%B0/1064049\" data-lemmaid=\"1064049\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">平台</a>，汇集了几十名国内顶尖的有多年项目和实战经验的Android开发授课大师，精心制作了上千个高质量视频教程，涵盖了Android开发学习的基础入门、中级进阶，高级提升、项目实战开发等专业的android开发课程。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;极客学院<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_12447205\"></a>&nbsp;&nbsp;背后是一支疯狂喜欢编程，狂热开发移动app的超有活力团队。他们希望通过最新的，高质量的，专业实战的在线开发课程打破传统的编程学习模式，以新一代的编程学习模式帮助开发者更快更好的学习<a target=\"_blank\" href=\"https://baike.baidu.com/item/Android%E5%BC%80%E5%8F%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">Android开发</a>，帮助开发者通过技术实现自己的理想。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;作为国内最大IT职业在线教育平台，极客学院一直致力于“让学习更有效”，帮助IT从业者在最短的时间内获得最多的知识，技能得到最快的提升。目前，极客学院已拥有60多万IT从业者用户。</p><p><br/></p>', '0', '1', 'pxjg', '2018-09-23 14:18:00.000000', '1');
INSERT INTO `orgs_orginfo` VALUES ('12', 'org/东南大学_EWWjLI8.jpg', '东南大学', '0', '0', '南京', '国内双一流高校', '<p><span style=\"font-weight: 700;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;东南大学</span>（<em>Southeast University</em>），简称“东大”，位于江苏省会<span style=\"font-weight: 700;\"></span><span style=\"font-weight: 700;\"><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC/23952\" data-lemmaid=\"23952\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京</a></span>，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD%E6%95%99%E8%82%B2%E9%83%A8/3507526\" data-lemmaid=\"3507526\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中华人民共和国教育部</a>直属、中央直管<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%89%AF%E9%83%A8%E7%BA%A7/6817383\" data-lemmaid=\"6817383\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">副部级</a>建制的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E5%A4%A7%E5%AD%A6/2154589\" data-lemmaid=\"2154589\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国重点大学</a>，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%BB%BA%E7%AD%91%E8%80%81%E5%85%AB%E6%A0%A1/8008054\" data-lemmaid=\"8008054\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">建筑老八校</a>及原<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%9B%E5%A4%A7%E5%B7%A5%E5%AD%A6%E9%99%A2/7020520\" data-lemmaid=\"7020520\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">四大工学院</a>之一，国家首批<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8F%8C%E4%B8%80%E6%B5%81/19394525\" data-lemmaid=\"19394525\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">双一流</a>（A类）、<a target=\"_blank\" href=\"https://baike.baidu.com/item/211%E5%B7%A5%E7%A8%8B/203547\" data-lemmaid=\"203547\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">211工程</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/985%E5%B7%A5%E7%A8%8B/1077915\" data-lemmaid=\"1077915\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">985工程</a>重点建设高校，入选<a target=\"_blank\" href=\"https://baike.baidu.com/item/2011%E8%AE%A1%E5%88%92/2913309\" data-lemmaid=\"2913309\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">2011计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/111%E8%AE%A1%E5%88%92/10958807\" data-lemmaid=\"10958807\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">111计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%B7%A5%E7%A8%8B%E5%B8%88%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越工程师教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%8C%BB%E7%94%9F%E6%95%99%E8%82%B2%E5%9F%B9%E5%85%BB%E8%AE%A1%E5%88%92/3805307\" data-lemmaid=\"3805307\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越医生教育培养计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E7%BA%A7%E5%A4%A7%E5%AD%A6%E7%94%9F%E5%88%9B%E6%96%B0%E5%88%9B%E4%B8%9A%E8%AE%AD%E7%BB%83%E8%AE%A1%E5%88%92/8962344\" data-lemmaid=\"8962344\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家级大学生创新创业训练计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E5%A4%A7%E5%AD%A6%E7%94%9F%E5%88%9B%E6%96%B0%E6%80%A7%E5%AE%9E%E9%AA%8C%E8%AE%A1%E5%88%92/5326077\" data-lemmaid=\"5326077\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家大学生创新性实验计划</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E5%BB%BA%E8%AE%BE%E9%AB%98%E6%B0%B4%E5%B9%B3%E5%A4%A7%E5%AD%A6%E5%85%AC%E6%B4%BE%E7%A0%94%E7%A9%B6%E7%94%9F%E9%A1%B9%E7%9B%AE/819876\" data-lemmaid=\"819876\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家建设高水平大学公派研究生项目</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E6%B7%B1%E5%8C%96%E5%88%9B%E6%96%B0%E5%88%9B%E4%B8%9A%E6%95%99%E8%82%B2%E6%94%B9%E9%9D%A9%E7%A4%BA%E8%8C%83%E9%AB%98%E6%A0%A1/22051296\" data-lemmaid=\"22051296\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全国深化创新创业教育改革示范高校</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD%E6%94%BF%E5%BA%9C%E5%A5%96%E5%AD%A6%E9%87%91%E6%9D%A5%E5%8D%8E%E7%95%99%E5%AD%A6%E7%94%9F%E6%8E%A5%E6%94%B6%E9%99%A2%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国政府奖学金来华留学生接收院校</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%95%99%E8%82%B2%E9%83%A8%E6%9D%A5%E5%8D%8E%E7%95%99%E5%AD%A6%E7%A4%BA%E8%8C%83%E5%9F%BA%E5%9C%B0/19650396\" data-lemmaid=\"19650396\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">教育部来华留学示范基地</a>，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%93%E8%B6%8A%E5%A4%A7%E5%AD%A6%E8%81%94%E7%9B%9F/8296583\" data-lemmaid=\"8296583\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">卓越大学联盟</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E4%BF%84%E5%B7%A5%E7%A7%91%E5%A4%A7%E5%AD%A6%E8%81%94%E7%9B%9F/7527224\" data-lemmaid=\"7527224\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中俄工科大学联盟</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E6%AC%A7%E5%B7%A5%E7%A8%8B%E6%95%99%E8%82%B2%E5%B9%B3%E5%8F%B0/790746\" data-lemmaid=\"790746\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中欧工程教育平台</a>”、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%95%BF%E4%B8%89%E8%A7%92%E9%AB%98%E6%A0%A1%E5%90%88%E4%BD%9C%E8%81%94%E7%9B%9F/10675435\" data-lemmaid=\"10675435\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">长三角高校合作联盟</a>主要成员，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B6%E5%9B%BD%E9%98%B2%E7%A7%91%E6%8A%80%E5%B7%A5%E4%B8%9A%E5%B1%80/4696487\" data-lemmaid=\"4696487\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国家国防科技工业局</a>与教育部共建。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;东南大学前身是创建于1902年的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%89%E6%B1%9F%E5%B8%88%E8%8C%83%E5%AD%A6%E5%A0%82\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">三江师范学堂</a>。1921年经<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%83%AD%E7%A7%89%E6%96%87\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">郭秉文</a>先生倡导，以<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E9%AB%98%E7%AD%89%E5%B8%88%E8%8C%83%E5%AD%A6%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京高等师范学校</a>为基础建立<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E4%B8%9C%E5%8D%97%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立东南大学</a>，下设工科，其后工科又经历<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E7%AC%AC%E5%9B%9B%E4%B8%AD%E5%B1%B1%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立第四中山大学</a>工学院、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立中央大学</a>工学院、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E7%AB%8B%E5%8D%97%E4%BA%AC%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">国立南京大学</a>工学院等历史时期；1952年全国院系调整，以原南京大学工学院为主体，并入<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%8D%E6%97%A6%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">复旦大学</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">交通大学</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B5%99%E6%B1%9F%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">浙江大学</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%87%91%E9%99%B5%E5%A4%A7%E5%AD%A6\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">金陵大学</a>等学校的有关系科，在中央大学本部原址建立<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E5%B7%A5%E5%AD%A6%E9%99%A2\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京工学院</a>；1988年5月，学校复更名为东南大学；2000年4月，原东南大学、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E9%93%81%E9%81%93%E5%8C%BB%E5%AD%A6%E9%99%A2\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京铁道医学院</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E4%BA%A4%E9%80%9A%E9%AB%98%E7%AD%89%E4%B8%93%E7%A7%91%E5%AD%A6%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京交通高等专科学校</a>合并，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8D%97%E4%BA%AC%E5%9C%B0%E8%B4%A8%E5%AD%A6%E6%A0%A1\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">南京地质学校</a>并入，组建新的东南大学。<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_3154\"></a>&nbsp;</p><p>截至2019年3月，学校占地面积5888亩，建有四牌楼、九龙湖、丁家桥等校区；设有33个院（系），全日制在校生30664人，其中研究生14536人；专任教师2899人。<span class=\"sup--normal\" data-sup=\"2-4\" data-ctrmap=\":2,:3,:4,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2-4]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2-4]_3154\"></a>&nbsp;</p><p><br/> </p>', '0', '3', 'gx', '2018-09-23 14:20:00.000000', '5');
INSERT INTO `orgs_orginfo` VALUES ('13', 'org/黑马程序员.jpg', '黑马程序员', '0', '0', '北京昌平', '国内知名IT培训机构', '<p><span style=\"color: rgb(86, 86, 86); font-family: arial, 微软雅黑, &quot;Microsoft Yahei&quot;, &quot;Hiragino Sans GB&quot;, 宋体, 宋体, Tahoma, Arial, Helvetica, STHeiti; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黑马程序员是传智播客旗下的高端IT教育品牌， 2010年，黑马程序员在中关村软件园开设第一个Android培训学科，现已开设JavaEE、PHP+H5全栈工程师、产品经理、前端与移动开发、C/C++、新媒体+短视频运营、Python+人工智能、大数据、UI/UE设计、软件测试、Linux云计算+运维开发、Go语言与区块链、影视制作、智能机器人软件开发等培训学科，直营分校遍布北京、上海、广州、深圳、武汉、郑州、西安、长沙、济南、重庆、南京、杭州、成都、石家庄、合肥、太原、厦门、沈阳等城市。</span></p><p style=\"padding: 0px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; line-height: 28px; color: rgb(86, 86, 86); text-indent: 2em; font-family: arial, 微软雅黑, &quot;Microsoft Yahei&quot;, &quot;Hiragino Sans GB&quot;, 宋体, 宋体, Tahoma, Arial, Helvetica, STHeiti; white-space: normal;\">黑马程序员是传智播客旗下高端IT教育品牌，以责任、务实、创新、育人为核心的文化价值观，致力于服务各大软件企业，解决当前软件开发技术飞速发展，而企业招不到优秀人才的困扰。 目前，“中关村黑马程序员训练营”已成长为行业“学员质量好、课程内容深、企业满意”的移动开发高端训练基地，并被评为中关村软件园重点扶持人才企业。</p><p style=\"padding: 0px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; line-height: 28px; color: rgb(86, 86, 86); text-indent: 2em; font-family: arial, 微软雅黑, &quot;Microsoft Yahei&quot;, &quot;Hiragino Sans GB&quot;, 宋体, 宋体, Tahoma, Arial, Helvetica, STHeiti; white-space: normal;\">黑马程序员不仅着重培养学员的基础理论知识，更注重培养项目实施管理能力，并密切关注技术革新，不断引入先进的技术，研发更新技术课程，确保学员进入企业后不仅能独立从事开发工作，更能给企业带来新的技术体系和理念。</p><p><br/></p>', '0', '2', 'pxjg', '2018-09-23 14:20:00.000000', '1');
INSERT INTO `orgs_orginfo` VALUES ('14', 'org/阿里巴巴.jpg', '阿里巴巴', '0', '1', '杭州', '国内一线互联网公司', '<p><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4%E7%BD%91%E7%BB%9C%E6%8A%80%E6%9C%AF%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8/4918650\" data-lemmaid=\"4918650\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">阿里巴巴网络技术有限公司</a><em>（简称：</em><em>阿里巴巴集团</em><em>）</em>是以曾担任英语教师的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%A9%AC%E4%BA%91/6252\" data-lemmaid=\"6252\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">马云</a>为首的18人于1999年在<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B5%99%E6%B1%9F/154399\" data-lemmaid=\"154399\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">浙江</a><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9D%AD%E5%B7%9E/147639\" data-lemmaid=\"147639\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">杭州</a>创立的公司。<span class=\"sup--normal\" data-sup=\"1-2\" data-ctrmap=\":1,:2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1-2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1-2]_1247049\"></a>&nbsp;</p><p>阿里巴巴集团经营多项业务，另外也从关联公司的业务和服务中取得经营商业生态系统上的支援。业务和关联公司的业务包括：<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B7%98%E5%AE%9D%E7%BD%91/112187\" data-lemmaid=\"112187\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">淘宝网</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%A9%E7%8C%AB/2551565\" data-lemmaid=\"2551565\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">天猫</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%81%9A%E5%88%92%E7%AE%97/1969338\" data-lemmaid=\"1969338\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">聚划算</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E7%90%83%E9%80%9F%E5%8D%96%E9%80%9A/5466027\" data-lemmaid=\"5466027\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">全球速卖通</a>、阿里巴巴国际交易市场、<a target=\"_blank\" href=\"https://baike.baidu.com/item/1688\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">1688</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%98%BF%E9%87%8C%E5%A6%88%E5%A6%88/2733121\" data-lemmaid=\"2733121\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">阿里妈妈</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%98%BF%E9%87%8C%E4%BA%91/297128\" data-lemmaid=\"297128\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">阿里云</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%9A%82%E8%9A%81%E9%87%91%E6%9C%8D/15897076\" data-lemmaid=\"15897076\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">蚂蚁金服</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%8F%9C%E9%B8%9F%E7%BD%91%E7%BB%9C/7630892\" data-lemmaid=\"7630892\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">菜鸟网络</a>等。<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_1247049\"></a>&nbsp;</p><p>2014年9月19日，阿里巴巴集团在<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%BA%BD%E7%BA%A6%E8%AF%81%E5%88%B8%E4%BA%A4%E6%98%93%E6%89%80/271637\" data-lemmaid=\"271637\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">纽约证券交易所</a>正式挂牌上市，股票代码“BABA”，创始人和董事局主席为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%A9%AC%E4%BA%91/6252\" data-lemmaid=\"6252\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">马云</a>。</p><p>2018年7月19日，全球同步《财富》世界500强排行榜发布，阿里巴巴集团排名300位。<span class=\"sup--normal\" data-sup=\"4\" data-ctrmap=\":4,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[4]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[4]_1247049\"></a>&nbsp;&nbsp;2018年12月，阿里巴巴入围2018世界品牌500强。<span class=\"sup--normal\" data-sup=\"5\" data-ctrmap=\":5,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[5]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[5]_1247049\"></a>&nbsp;</p><p><br/></p>', '0', '3', 'gr', '2018-09-23 14:21:00.000000', '4');
INSERT INTO `orgs_orginfo` VALUES ('15', 'org/腾讯jpg.jpg', '腾讯', '0', '0', '深圳', '国内一线互联网公司', '<p><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B7%B1%E5%9C%B3%E5%B8%82%E8%85%BE%E8%AE%AF%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%B3%BB%E7%BB%9F%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">深圳市腾讯计算机系统有限公司</a>成立于1998年11月<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_1591\"></a>&nbsp;&nbsp;，由<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%A9%AC%E5%8C%96%E8%85%BE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">马化腾</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%BC%A0%E5%BF%97%E4%B8%9C/12113\" data-lemmaid=\"12113\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">张志东</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%AE%B8%E6%99%A8%E6%99%94\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">许晨晔</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%99%88%E4%B8%80%E4%B8%B9\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">陈一丹</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9B%BE%E6%9D%8E%E9%9D%92\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">曾李青</a>五位创始人共同创立。<span class=\"sup--normal\" data-sup=\"1\" data-ctrmap=\":1,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[1]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[1]_1591\"></a>&nbsp;&nbsp;是中国最大的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%92%E8%81%94%E7%BD%91/199186\" data-lemmaid=\"199186\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">互联网</a>综合服务提供商之一，也是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%9B%BD/1122445\" data-lemmaid=\"1122445\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">中国</a>服务用户最多的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%92%E8%81%94%E7%BD%91%E4%BC%81%E4%B8%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">互联网企业</a>之一。<span class=\"sup--normal\" data-sup=\"2\" data-ctrmap=\":2,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[2]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[2]_1591\"></a>&nbsp;</p><p>腾讯多元化的服务包括：<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A4%BE%E4%BA%A4/2089809\" data-lemmaid=\"2089809\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">社交</a>和<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%80%9A%E4%BF%A1/300982\" data-lemmaid=\"300982\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">通信</a>服务<a target=\"_blank\" href=\"https://baike.baidu.com/item/QQ\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">QQ</a>及<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%BE%AE%E4%BF%A1/3905974\" data-lemmaid=\"3905974\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">微信</a>/<a target=\"_blank\" href=\"https://baike.baidu.com/item/WeChat\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">WeChat</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%BB%9C/420\" data-lemmaid=\"420\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">社交网络</a>平台<a target=\"_blank\" href=\"https://baike.baidu.com/item/QQ%E7%A9%BA%E9%97%B4\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">QQ空间</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%85%BE%E8%AE%AF%E6%B8%B8%E6%88%8F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">腾讯游戏</a>旗下<a target=\"_blank\" href=\"https://baike.baidu.com/item/QQ%E6%B8%B8%E6%88%8F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">QQ游戏</a>平台、门户网站<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%85%BE%E8%AE%AF%E7%BD%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">腾讯网</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%85%BE%E8%AE%AF%E6%96%B0%E9%97%BB%E5%AE%A2%E6%88%B7%E7%AB%AF\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">腾讯新闻客户端</a>和网络视频服务<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%85%BE%E8%AE%AF%E8%A7%86%E9%A2%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">腾讯视频</a>等。<span class=\"sup--normal\" data-sup=\"3\" data-ctrmap=\":3,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[3]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[3]_1591\"></a>&nbsp;</p><p>2004年腾讯公司在<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%A6%99%E6%B8%AF%E8%81%94%E4%BA%A4%E6%89%80\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">香港联交所</a>主板公开上市（股票代号00700），<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%91%A3%E4%BA%8B%E4%BC%9A%E4%B8%BB%E5%B8%AD\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">董事会主席</a>兼<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%A6%96%E5%B8%AD%E6%89%A7%E8%A1%8C%E5%AE%98/26567\" data-lemmaid=\"26567\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">首席执行官</a>是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%A9%AC%E5%8C%96%E8%85%BE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">马化腾</a>。</p><p>2018年3月7日，腾讯和<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%81%94%E5%8F%91%E7%A7%91\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">联发科</a>共同成立创新实验室，围绕手机游戏及其他互娱产品的开发与优化达成战略合作，共同探索AI在终端侧的应用。2018 年6月20日，世界品牌实验室(World Brand Lab)在北京发布了2018年《中国500最具价值品牌》分析报告。腾讯(4028.45亿元)居第二位。2018年9月15日，QQ宠物正式停运。<span class=\"sup--normal\" data-sup=\"4-5\" data-ctrmap=\":4,:5,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[4-5]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[4-5]_1591\"></a>&nbsp;</p><p>2018年12月，世界品牌实验室编制的《2018世界品牌500强》揭晓，排名第39。<span class=\"sup--normal\" data-sup=\"6\" data-ctrmap=\":6,\" style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">&nbsp;[6]</span><a style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\" name=\"ref_[6]_1591\"></a>&nbsp;</p><p><br/></p>', '0', '2', 'gr', '2018-09-23 14:21:00.000000', '3');

-- ----------------------------
-- Table structure for orgs_teacherinfo
-- ----------------------------
DROP TABLE IF EXISTS `orgs_teacherinfo`;
CREATE TABLE `orgs_teacherinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(200) NOT NULL,
  `name` varchar(20) NOT NULL,
  `work_year` int(11) NOT NULL,
  `work_position` varchar(20) NOT NULL,
  `work_style` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `love_num` int(11) NOT NULL,
  `click_num` int(11) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  `work_company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orgs_teacherinfo_work_company_id_b897a136_fk_orgs_orginfo_id` (`work_company_id`),
  CONSTRAINT `orgs_teacherinfo_work_company_id_b897a136_fk_orgs_orginfo_id` FOREIGN KEY (`work_company_id`) REFERENCES `orgs_orginfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgs_teacherinfo
-- ----------------------------
INSERT INTO `orgs_teacherinfo` VALUES ('1', 'teacher/17.jpg', '孙老师', '10', '高级讲师', '牛逼666', '18', 'girl', '4', '90', '2018-09-21 15:56:00.000000', '1');
INSERT INTO `orgs_teacherinfo` VALUES ('2', 'teacher/17_QaSaqTi.jpg', 'weesmile', '3', '高级讲师', '闷骚有激情', '30', 'boy', '4', '9', '2018-09-23 14:23:00.000000', '1');
INSERT INTO `orgs_teacherinfo` VALUES ('3', 'teacher/9.jpeg', '超哥', '3', '高级讲师', '激情四射', '30', 'boy', '3', '14', '2018-09-23 14:24:00.000000', '1');
INSERT INTO `orgs_teacherinfo` VALUES ('4', 'teacher/java.jpg', '詹姆斯·高斯林', '30', '高级讲师', '教学诙谐幽默, 讲解通俗易懂', '50', 'boy', '2', '5', '2019-04-16 17:51:00.000000', '2');
INSERT INTO `orgs_teacherinfo` VALUES ('5', 'teacher/毕向东.jpg', '毕向东', '10', '初级讲师', '教学严谨认知', '40', 'boy', '0', '4', '2019-04-16 17:52:00.000000', '1');
INSERT INTO `orgs_teacherinfo` VALUES ('6', 'teacher/池泽彩野花.jpg', '池泽彩野花', '5', '初级讲师', '教学诙谐幽默, 讲解通俗易懂', '30', 'girl', '0', '2', '2019-04-16 17:53:00.000000', '3');
INSERT INTO `orgs_teacherinfo` VALUES ('7', 'teacher/方立勋.jpg', '方立勋', '20', '初级讲师', '教学诙谐幽默, 讲解通俗易懂', '30', 'boy', '1', '3', '2019-04-16 17:53:00.000000', '4');
INSERT INTO `orgs_teacherinfo` VALUES ('8', 'teacher/韩顺平.jpg', '韩顺平', '8', '高级讲师', '教学诙谐幽默, 讲解通俗易懂', '28', 'boy', '0', '0', '2019-04-16 17:54:00.000000', '5');
INSERT INTO `orgs_teacherinfo` VALUES ('9', 'teacher/金恩荣.jpg', '金恩荣', '5', '初级讲师', '教学诙谐幽默, 讲解通俗易懂', '10', 'boy', '0', '0', '2019-04-16 17:54:00.000000', '6');
INSERT INTO `orgs_teacherinfo` VALUES ('10', 'teacher/刘苍松.jpg', '刘苍松', '2', '初级讲师', '教学诙谐幽默, 讲解通俗易懂', '32', 'boy', '0', '0', '2019-04-16 17:55:00.000000', '7');
INSERT INTO `orgs_teacherinfo` VALUES ('11', 'teacher/内田真礼.jpg', '内田真礼', '8', '高级讲师', '教学诙谐幽默, 讲解通俗易懂', '30', 'boy', '0', '0', '2019-04-16 17:55:00.000000', '8');
INSERT INTO `orgs_teacherinfo` VALUES ('12', 'teacher/神谷浩史.jpg', '神谷浩史', '5', '初级讲师', '教学严谨认真', '30', 'boy', '0', '0', '2019-04-16 17:56:00.000000', '9');
INSERT INTO `orgs_teacherinfo` VALUES ('13', 'teacher/水濑祈.jpg', '水濑祈', '8', '高级讲师', '教学严谨认真', '38', 'girl', '0', '0', '2019-04-16 17:56:00.000000', '10');
INSERT INTO `orgs_teacherinfo` VALUES ('14', 'teacher/许式伟.jpg', '许式伟', '31', '高级讲师', '教学严谨认真', '30', 'boy', '0', '0', '2019-04-16 17:57:00.000000', '11');
INSERT INTO `orgs_teacherinfo` VALUES ('15', 'teacher/张立猛.jpg', '张立猛', '6', '高级讲师', '教学严谨认真', '30', 'boy', '0', '1', '2019-04-16 17:57:00.000000', '12');
INSERT INTO `orgs_teacherinfo` VALUES ('16', 'teacher/赵洁琼.jpg', '赵洁琼', '6', '高级讲师', '教学严谨认真', '18', 'girl', '0', '0', '2019-04-16 17:58:00.000000', '14');
INSERT INTO `orgs_teacherinfo` VALUES ('17', 'teacher/种田梨沙.jpg', '种田梨沙', '5', '高级讲师', '教学诙谐幽默, 讲解通俗易懂', '30', 'girl', '0', '0', '2019-04-16 17:58:00.000000', '13');
INSERT INTO `orgs_teacherinfo` VALUES ('18', 'teacher/佐仓绫音.jpg', '佐仓绫音', '7', '高级讲师', '教学严谨认真', '18', 'girl', '0', '0', '2019-04-16 17:58:00.000000', '15');

-- ----------------------------
-- Table structure for users_bannerinfo
-- ----------------------------
DROP TABLE IF EXISTS `users_bannerinfo`;
CREATE TABLE `users_bannerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(200) NOT NULL,
  `url` varchar(200) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_bannerinfo
-- ----------------------------
INSERT INTO `users_bannerinfo` VALUES ('1', 'banner/banner1.jpg', 'http://127.0.0.1:8000/courses/course_detail/13/', '2018-09-30 10:11:00.000000');
INSERT INTO `users_bannerinfo` VALUES ('2', 'banner/banner2.jpg', 'http://127.0.0.1:8000/courses/course_detail/25/', '2018-09-30 10:11:00.000000');
INSERT INTO `users_bannerinfo` VALUES ('4', 'banner/banner4.jpg', 'http://127.0.0.1:8000/courses/course_detail/23/', '2018-09-30 10:11:00.000000');
INSERT INTO `users_bannerinfo` VALUES ('5', 'banner/banner5.jpg', 'http://127.0.0.1:8000/courses/course_detail/24/', '2018-09-30 10:11:00.000000');
INSERT INTO `users_bannerinfo` VALUES ('6', 'banner/感言.jpg', '', '2018-09-30 10:11:00.000000');

-- ----------------------------
-- Table structure for users_emailverifycode
-- ----------------------------
DROP TABLE IF EXISTS `users_emailverifycode`;
CREATE TABLE `users_emailverifycode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `send_type` int(11) NOT NULL,
  `add_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_emailverifycode
-- ----------------------------
INSERT INTO `users_emailverifycode` VALUES ('11', '2iS2W5en', 'ly03171629@163.com', '3', '2018-09-29 14:31:29.726523');
INSERT INTO `users_emailverifycode` VALUES ('12', 'P0nGXTRY', 'zzhang_xz@163.com', '1', '2019-03-29 17:57:08.465074');
INSERT INTO `users_emailverifycode` VALUES ('13', 'u85q5rqxOgx0EwvOvtIU', 'zzhang_xz@163.com', '1', '2019-03-29 17:59:29.743528');
INSERT INTO `users_emailverifycode` VALUES ('14', '8z3MS0Ln', 'zzhang_xz@163.com', '1', '2019-03-29 18:03:39.995119');
INSERT INTO `users_emailverifycode` VALUES ('15', 'MrK8KnI7amZ2xYa4nIGB', 'zzhang_xz@163.com', '1', '2019-03-29 18:06:32.408780');
INSERT INTO `users_emailverifycode` VALUES ('16', 'VUBVJXT9dLNWPpNTmriJ', '1252068782@qq.com', '1', '2019-03-29 18:10:12.528873');
INSERT INTO `users_emailverifycode` VALUES ('17', 'q1zIP5YJWpxiqMXHc4Kv', 'zzhang_xz@163.com', '1', '2019-03-29 18:26:15.737973');
INSERT INTO `users_emailverifycode` VALUES ('18', 'DaGS95jbuR7U03rQdPxE', 'zzhang_xz@163.com', '2', '2019-03-29 19:34:59.210936');
INSERT INTO `users_emailverifycode` VALUES ('19', 'r0OgzFp7gvIZq62owQtC', 'zzhang_xz@163.com', '2', '2019-03-29 19:38:52.818540');
INSERT INTO `users_emailverifycode` VALUES ('20', 'e7EqFDoqgjtiuFWQzQgO', 'zzhang_xz@163.com', '2', '2019-03-31 13:50:10.321827');
INSERT INTO `users_emailverifycode` VALUES ('21', 'bqBr935cFELwVw2koATQ', 'zzhang_xz@163.com', '2', '2019-03-31 14:03:02.302332');
INSERT INTO `users_emailverifycode` VALUES ('22', 'bpFKk6lr2T60Cx1Pz8oc', '125206782@qq.com', '1', '2019-03-31 16:41:22.985175');
INSERT INTO `users_emailverifycode` VALUES ('23', 'G9FPOHeuCyDoviZol5Wv', 'zzhang_xz@163.com', '1', '2019-03-31 16:45:55.324645');
INSERT INTO `users_emailverifycode` VALUES ('24', '9rnJk1UKx2a8XCfdIE3L', '1252068782@qq.com', '1', '2019-04-21 13:34:01.004420');
INSERT INTO `users_emailverifycode` VALUES ('25', '0WXtgeeCENlyCcZWsdWA', '1252068782@qq.com', '1', '2019-04-21 13:48:37.419023');
INSERT INTO `users_emailverifycode` VALUES ('26', 'Tz8Fal3BJp8jAjWeLdQq', '1252068782@qq.com', '2', '2019-04-21 13:50:33.265699');
INSERT INTO `users_emailverifycode` VALUES ('27', '5Mewwqh5J7PXqZbHewdO', '1252068782@qq.com', '1', '2019-04-21 14:10:20.948872');
INSERT INTO `users_emailverifycode` VALUES ('28', 'Jn48XZsat8e557hSQ0zg', '1035950489@qq.com', '1', '2019-04-22 19:56:00.107152');
INSERT INTO `users_emailverifycode` VALUES ('29', 'mrfSXDC6nayn0w2RGWMf', '1252068782@qq.com', '2', '2019-04-30 13:23:24.610067');
INSERT INTO `users_emailverifycode` VALUES ('30', 'UB3luW9lNvuoJp2wuU8Y', '1252068782@qq.com', '2', '2019-04-30 13:38:28.062275');
INSERT INTO `users_emailverifycode` VALUES ('31', 'rbEKNHtE32Fq7hINkDcf', '1252068782@qq.com', '2', '2019-04-30 13:41:32.267213');
INSERT INTO `users_emailverifycode` VALUES ('32', 'Ft2YDHAhJ9p3OE8XGMPP', '1252068782@qq.com', '1', '2019-05-01 15:02:04.632009');
INSERT INTO `users_emailverifycode` VALUES ('33', 'DK9tlAtmWzvR1EuZ452U', '1252068782@qq.com', '1', '2019-05-01 15:09:55.892894');
INSERT INTO `users_emailverifycode` VALUES ('34', 'tacB2YlafldzFkKK9QhJ', '1252068782@qq.com', '2', '2019-05-01 16:42:34.193549');
INSERT INTO `users_emailverifycode` VALUES ('35', 'fVamMqqB3yGYG1WRkDNc', '1252068782@qq.com', '2', '2019-05-01 17:19:49.848584');
INSERT INTO `users_emailverifycode` VALUES ('36', 'ehfOROg8tVRs30zyQrgy', '1252068782@qq.com', '2', '2019-05-01 17:20:08.445601');
INSERT INTO `users_emailverifycode` VALUES ('37', 'hJlxpda4con9yVt0vdUC', '1252068782@qq.com', '2', '2019-05-01 17:21:30.884211');
INSERT INTO `users_emailverifycode` VALUES ('38', '5rIM24BANzbSHSuSZLj6', '1252068782@qq.com', '1', '2019-05-01 17:37:45.784216');
INSERT INTO `users_emailverifycode` VALUES ('39', 'kr87e2zRE8kevxSzzEzW', '1419719259@qq.com', '1', '2019-05-02 19:13:15.813313');
INSERT INTO `users_emailverifycode` VALUES ('40', 'QMck88f5gHNitfF4F5Mp', '12520687282@qq.com', '3', '2019-05-02 23:03:42.626317');
INSERT INTO `users_emailverifycode` VALUES ('41', 'c6BxOY2H3tY0ieDRVvEc', '1419719259@qq.com', '2', '2019-05-03 23:19:02.331426');
INSERT INTO `users_emailverifycode` VALUES ('42', '8wlGEqFutMFKgguAo8wn', '1252068782@qq.com', '1', '2019-05-06 16:02:39.621664');
INSERT INTO `users_emailverifycode` VALUES ('43', 'Fnkt007MZ96shGUAYrBK', '1252068782@qq.com', '1', '2019-05-09 13:10:59.028710');
INSERT INTO `users_emailverifycode` VALUES ('44', 'rvheNe144MwFGYvjUnuK', '1252068782@qq.com', '1', '2019-05-09 15:39:04.455214');

-- ----------------------------
-- Table structure for users_userprofile
-- ----------------------------
DROP TABLE IF EXISTS `users_userprofile`;
CREATE TABLE `users_userprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(254) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `add_time` datetime(6) NOT NULL,
  `is_start` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_userprofile
-- ----------------------------
INSERT INTO `users_userprofile` VALUES ('1', 'pbkdf2_sha256$36000$uO07jmnCpftf$LD9jaOUz9iImTD1MYA89MiTSV/n4Ti6+jGQ2sq25iG0=', '2018-09-30 14:21:31.435886', '1', 'admin', '', '', '', '1', '1', '2018-09-21 15:30:43.156739', '', null, null, 'girl', null, null, '2018-09-21 15:30:43.156739', '1');
INSERT INTO `users_userprofile` VALUES ('18', 'pbkdf2_sha256$36000$8HHxsTOM2PN4$QB/VcxG2EjwmwudIoL9hrRqhYUHtuQV4LZ6kt/wHyBU=', '2019-06-01 21:53:42.616797', '1', 'zack', '', '', 'zzhang_xz@163.com', '1', '1', '2019-04-14 16:33:48.149562', 'user/git.jpg', 'zhang', '2019-03-31', 'boy', '江苏', '18115300769', '2019-04-14 16:33:48.149562', '0');
INSERT INTO `users_userprofile` VALUES ('20', 'pbkdf2_sha256$36000$510Gsh8qE0ug$q9fojTMUGnFMf2qOWfwzcGmZbG7W6Nx1mxtOYlsnfN8=', '2019-04-21 13:52:07.077824', '0', '12520687822@qq.com', '', '', '12520687822@qq.com', '0', '1', '2019-04-21 13:48:37.205354', 'user/default.jpg', null, null, 'girl', null, null, '2019-04-21 13:48:37.205354', '1');
INSERT INTO `users_userprofile` VALUES ('21', 'pbkdf2_sha256$36000$H7nqmQVpprtC$tBzZAil/3xOZnSFfDSJAEZokUx4nZeXMpySS/gjtvlo=', '2019-05-01 02:21:02.207946', '0', '125206878222@qq.com', '', '', '125206878226@qq.com', '0', '1', '2019-04-21 14:10:20.898230', 'user/default.jpg', 'zack', '2019-04-02', 'boy', 'scedc', 'dscdsc', '2019-04-21 14:10:20.898261', '1');
INSERT INTO `users_userprofile` VALUES ('22', 'pbkdf2_sha256$36000$dhcZySSy0kXe$ovzsMkEH9Wd3S0B0SOufdCfYItayvFm3q/G0NoVapGo=', '2019-04-22 19:57:09.200843', '0', '1035950489@qq.com', '', '', '1035950489@qq.com', '0', '1', '2019-04-22 19:55:59.757087', 'user/default.jpg', null, null, 'girl', null, null, '2019-04-22 19:55:59.757087', '1');
INSERT INTO `users_userprofile` VALUES ('25', 'pbkdf2_sha256$36000$ePu5TUwFkisB$3npBikA/1kAFhjBPHa2RvdFZ5A4wfdUSVskH5wk3HrE=', '2019-05-06 16:00:58.203291', '0', '125206878252@qq.com', '', '', '1252068782@qq2.com', '0', '1', '2019-05-01 17:37:45.572651', 'user/banner5.jpg', 'zack', '2019-05-03', 'boy', 'dcdccd', '14156', '2019-05-01 17:37:45.572651', '1');
INSERT INTO `users_userprofile` VALUES ('26', 'pbkdf2_sha256$36000$5bZ7eQkrhJSq$21iptYtsI8NMBZk77INa8jvotF+jjgKuC8W2ysqHeIM=', '2019-05-04 13:00:20.191943', '0', '1419719259@qq.com', '', '', '1419719259@qq.com', '0', '1', '2019-05-02 19:13:15.766018', 'user/default.jpg', null, null, 'girl', null, null, '2019-05-02 19:13:15.766050', '1');
INSERT INTO `users_userprofile` VALUES ('27', 'pbkdf2_sha256$36000$tIVHGFX5OTTL$Oh30CP4/MgBDAVNpa994vD6HvWYBtiuHLUvBQ583T0k=', '2019-05-09 13:03:17.567041', '0', '12520687sa82@qq.com', '', '', '1252068782sa@qq.com', '0', '1', '2019-05-06 16:02:39.027526', 'user/default.jpg', 'zack', '2019-05-09', 'girl', null, null, '2019-05-06 16:02:39.028020', '1');
INSERT INTO `users_userprofile` VALUES ('28', 'pbkdf2_sha256$36000$Pl6Q22PO7Nca$Rw52kDEfe0xDUwnsGbyJ7bsHzXK41oNajVTue0PYg9A=', '2019-05-09 13:11:21.624003', '0', '125206875182@qq.com', '', '', '125201568782@qq.com', '0', '1', '2019-05-09 13:10:58.687658', 'user/default.jpg', null, null, 'girl', null, null, '2019-05-09 13:10:58.687658', '1');
INSERT INTO `users_userprofile` VALUES ('29', 'pbkdf2_sha256$36000$WzEGAsFRmgfc$XKUAJdDq6Nt/RvPzmgTfDL1G0DOAYGUtQnZEgFp2mo4=', '2019-06-02 12:19:45.670860', '0', '1252068782@qq.com', '', '', '1252068782@qq.com', '0', '1', '2019-05-09 15:39:04.186900', 'user/default.jpg', 'zack', '2019-05-16', 'boy', '江苏徐州', '18115300769', '2019-05-09 15:39:04.186900', '1');

-- ----------------------------
-- Table structure for users_userprofile_groups
-- ----------------------------
DROP TABLE IF EXISTS `users_userprofile_groups`;
CREATE TABLE `users_userprofile_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userprofile_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_userprofile_groups_userprofile_id_823cf2fc_uniq` (`userprofile_id`,`group_id`),
  KEY `users_userprofile_groups_group_id_3de53dbf_fk_auth_group_id` (`group_id`),
  CONSTRAINT `users_userprofil_userprofile_id_a4496a80_fk_users_userprofile_id` FOREIGN KEY (`userprofile_id`) REFERENCES `users_userprofile` (`id`),
  CONSTRAINT `users_userprofile_groups_group_id_3de53dbf_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_userprofile_groups
-- ----------------------------

-- ----------------------------
-- Table structure for users_userprofile_user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `users_userprofile_user_permissions`;
CREATE TABLE `users_userprofile_user_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userprofile_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_userprofile_user_permissions_userprofile_id_d0215190_uniq` (`userprofile_id`,`permission_id`),
  KEY `users_userprofile_u_permission_id_393136b6_fk_auth_permission_id` (`permission_id`),
  CONSTRAINT `users_userprofil_userprofile_id_34544737_fk_users_userprofile_id` FOREIGN KEY (`userprofile_id`) REFERENCES `users_userprofile` (`id`),
  CONSTRAINT `users_userprofile_u_permission_id_393136b6_fk_auth_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_userprofile_user_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for xadmin_bookmark
-- ----------------------------
DROP TABLE IF EXISTS `xadmin_bookmark`;
CREATE TABLE `xadmin_bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `url_name` varchar(64) NOT NULL,
  `query` varchar(1000) NOT NULL,
  `is_share` tinyint(1) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `xadmin_bookma_content_type_id_60941679_fk_django_content_type_id` (`content_type_id`),
  KEY `xadmin_bookmark_user_id_42d307fc_fk_users_userprofile_id` (`user_id`),
  CONSTRAINT `xadmin_bookma_content_type_id_60941679_fk_django_content_type_id` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  CONSTRAINT `xadmin_bookmark_user_id_42d307fc_fk_users_userprofile_id` FOREIGN KEY (`user_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xadmin_bookmark
-- ----------------------------

-- ----------------------------
-- Table structure for xadmin_log
-- ----------------------------
DROP TABLE IF EXISTS `xadmin_log`;
CREATE TABLE `xadmin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `ip_addr` char(39) DEFAULT NULL,
  `object_id` longtext,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` varchar(32) NOT NULL,
  `message` longtext NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `xadmin_log_content_type_id_2a6cb852_fk_django_content_type_id` (`content_type_id`),
  KEY `xadmin_log_user_id_bb16a176_fk_users_userprofile_id` (`user_id`),
  CONSTRAINT `xadmin_log_content_type_id_2a6cb852_fk_django_content_type_id` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  CONSTRAINT `xadmin_log_user_id_bb16a176_fk_users_userprofile_id` FOREIGN KEY (`user_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xadmin_log
-- ----------------------------
INSERT INTO `xadmin_log` VALUES ('50', '2019-04-15 22:42:12.335658', '127.0.0.1', '10', 'asdsaDSA', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('52', '2019-04-16 17:24:08.920775', '127.0.0.1', '15', '腾讯', 'change', '修改 image，desc，detail 和 click_num', '13', '18');
INSERT INTO `xadmin_log` VALUES ('53', '2019-04-16 17:25:21.286086', '127.0.0.1', '14', '阿里巴巴', 'change', '修改 image，name，address，desc，detail，category 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('54', '2019-04-16 17:26:59.860069', '127.0.0.1', '13', '黑马程序员', 'change', '修改 image，name，desc 和 detail', '13', '18');
INSERT INTO `xadmin_log` VALUES ('55', '2019-04-16 17:28:17.265991', '127.0.0.1', '12', '东南大学', 'change', '修改 image，name，address，desc，detail 和 category', '13', '18');
INSERT INTO `xadmin_log` VALUES ('56', '2019-04-16 17:28:36.775665', '127.0.0.1', '5', '南京', 'create', '已添加。', '14', '18');
INSERT INTO `xadmin_log` VALUES ('57', '2019-04-16 17:29:01.098351', '127.0.0.1', '12', '东南大学', 'change', '修改 image，detail 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('58', '2019-04-16 17:30:10.090552', '127.0.0.1', '11', '极客学院', 'change', '修改 image，name，address，desc 和 detail', '13', '18');
INSERT INTO `xadmin_log` VALUES ('59', '2019-04-16 17:31:12.340648', '127.0.0.1', '10', '麦子学院', 'change', '修改 image，name，desc 和 detail', '13', '18');
INSERT INTO `xadmin_log` VALUES ('60', '2019-04-16 17:32:26.062773', '127.0.0.1', '9', '慕课网', 'change', '修改 image，name，address，desc，detail 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('61', '2019-04-16 17:33:34.554250', '127.0.0.1', '6', '湖南省', 'create', '已添加。', '14', '18');
INSERT INTO `xadmin_log` VALUES ('62', '2019-04-16 17:34:50.596774', '127.0.0.1', '8', '南华大学', 'change', '修改 image，name，address，desc，detail，love_num 和 click_num', '13', '18');
INSERT INTO `xadmin_log` VALUES ('63', '2019-04-16 17:35:18.261535', '127.0.0.1', '8', '南华大学', 'change', '修改 image，detail 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('64', '2019-04-16 17:36:51.436229', '127.0.0.1', '7', '南京大学', 'change', '修改 image，name，course_num，study_num，address，desc，detail，love_num，click_num 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('65', '2019-04-16 17:37:59.128961', '127.0.0.1', '6', '南京农业大学', 'change', '修改 image，name，course_num，study_num，address，desc，detail，click_num 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('66', '2019-04-16 17:38:36.019323', '127.0.0.1', '7', '南通', 'create', '已添加。', '14', '18');
INSERT INTO `xadmin_log` VALUES ('67', '2019-04-16 17:39:30.843466', '127.0.0.1', '5', '南通大学', 'change', '修改 image，name，address，desc，detail，category 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('68', '2019-04-16 17:40:15.557016', '127.0.0.1', '4', '千峰教育', 'change', '修改 image，name，address，desc 和 detail', '13', '18');
INSERT INTO `xadmin_log` VALUES ('69', '2019-04-16 17:40:54.248794', '127.0.0.1', '8', '厦门', 'create', '已添加。', '14', '18');
INSERT INTO `xadmin_log` VALUES ('70', '2019-04-16 17:42:06.204835', '127.0.0.1', '3', '厦门大学', 'change', '修改 image，name，address，desc，detail，love_num，click_num，category 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('71', '2019-04-16 17:42:58.087107', '127.0.0.1', '2', '上海交通大学', 'change', '修改 image，name，address，desc，detail，category 和 cityinfo', '13', '18');
INSERT INTO `xadmin_log` VALUES ('72', '2019-04-16 17:44:01.652171', '127.0.0.1', '1', '尚学堂', 'change', '修改 image，name，study_num，address，desc，detail，love_num 和 click_num', '13', '18');
INSERT INTO `xadmin_log` VALUES ('73', '2019-04-16 17:52:20.990845', '127.0.0.1', '4', '詹姆斯·高斯林', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('74', '2019-04-16 17:53:08.506613', '127.0.0.1', '5', '毕向东', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('75', '2019-04-16 17:53:33.326437', '127.0.0.1', '6', '池泽彩野花', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('76', '2019-04-16 17:54:01.943471', '127.0.0.1', '7', '方立勋', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('77', '2019-04-16 17:54:39.903350', '127.0.0.1', '8', '韩顺平', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('78', '2019-04-16 17:55:05.102856', '127.0.0.1', '9', '金恩荣', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('79', '2019-04-16 17:55:29.524255', '127.0.0.1', '10', '刘苍松', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('80', '2019-04-16 17:56:04.126636', '127.0.0.1', '11', '内田真礼', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('81', '2019-04-16 17:56:40.566463', '127.0.0.1', '12', '神谷浩史', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('82', '2019-04-16 17:57:10.421085', '127.0.0.1', '13', '水濑祈', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('83', '2019-04-16 17:57:37.721172', '127.0.0.1', '14', '许式伟', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('84', '2019-04-16 17:58:03.720690', '127.0.0.1', '15', '张立猛', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('85', '2019-04-16 17:58:30.442493', '127.0.0.1', '16', '赵洁琼', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('86', '2019-04-16 17:58:53.582284', '127.0.0.1', '17', '种田梨沙', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('87', '2019-04-16 17:59:19.640642', '127.0.0.1', '18', '佐仓绫音', 'create', '已添加。', '15', '18');
INSERT INTO `xadmin_log` VALUES ('88', '2019-04-16 17:59:59.452753', '127.0.0.1', null, '', 'delete', '批量删除 7 个 咨询信息', null, '18');
INSERT INTO `xadmin_log` VALUES ('89', '2019-04-16 18:00:59.858180', '127.0.0.1', null, '', 'delete', '批量删除 10 个 用户信息', null, '18');
INSERT INTO `xadmin_log` VALUES ('90', '2019-04-16 18:02:25.102295', '127.0.0.1', null, '', 'delete', '批量删除 2 个 课程信息', null, '18');
INSERT INTO `xadmin_log` VALUES ('91', '2019-04-16 18:04:52.397498', '127.0.0.1', '12', 'ajax', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('92', '2019-04-16 18:08:00.394358', '127.0.0.1', '13', 'git版本控制工具', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('93', '2019-04-16 18:09:45.453463', '127.0.0.1', '14', 'idea 工具的使用', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('94', '2019-04-16 18:11:13.430871', '127.0.0.1', '15', 'java 讲解', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('95', '2019-04-16 18:12:27.410846', '127.0.0.1', '16', 'java8讲解', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('96', '2019-04-16 18:13:28.429538', '127.0.0.1', '17', 'javaweb 技术讲解', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('97', '2019-04-16 18:14:55.289636', '127.0.0.1', '18', 'JavaScript 简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('98', '2019-04-16 18:16:08.472276', '127.0.0.1', '19', 'juc进阶', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('99', '2019-04-16 18:17:21.449296', '127.0.0.1', '20', 'linux 讲解', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('100', '2019-04-16 18:18:38.568390', '127.0.0.1', '21', 'mybatis简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('101', '2019-04-16 18:19:53.026261', '127.0.0.1', '22', 'nio 简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('102', '2019-04-16 18:21:03.070890', '127.0.0.1', '23', 'react 简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('103', '2019-04-16 18:21:57.223853', '127.0.0.1', '24', 'springboot简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('104', '2019-04-16 18:22:42.580970', '127.0.0.1', '25', 'springcloud 简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('105', '2019-04-16 18:23:29.111142', '127.0.0.1', '26', 'springmvc简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('106', '2019-04-16 18:24:16.002331', '127.0.0.1', '27', 'spring 简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('107', '2019-04-16 18:25:04.146882', '127.0.0.1', '28', 'python 简介', 'create', '已添加。', '9', '18');
INSERT INTO `xadmin_log` VALUES ('108', '2019-04-21 15:47:41.079234', '127.0.0.1', '3', '01、hello html', 'create', '已添加。', '11', '18');
INSERT INTO `xadmin_log` VALUES ('109', '2019-04-21 15:48:12.072405', '127.0.0.1', null, '', 'delete', '批量删除 2 个 视频信息', null, '18');
INSERT INTO `xadmin_log` VALUES ('110', '2019-04-22 11:40:48.978062', '183.209.74.94', '4', '02. html 初识', 'create', '已添加。', '11', '18');
INSERT INTO `xadmin_log` VALUES ('111', '2019-04-22 23:43:53.017197', '127.0.0.1', '5', '第三章：css选择器', 'create', '已添加。', '11', '18');
INSERT INTO `xadmin_log` VALUES ('112', '2019-04-22 23:47:04.398230', '127.0.0.1', '5', '第三章：css选择器', 'change', '修改 url', '11', '18');
INSERT INTO `xadmin_log` VALUES ('113', '2019-04-22 23:50:56.139698', '127.0.0.1', '2', '2', 'create', '已添加。', '10', '18');
INSERT INTO `xadmin_log` VALUES ('114', '2019-04-22 23:52:42.535448', '127.0.0.1', '3', 'fd', 'create', '已添加。', '10', '18');
INSERT INTO `xadmin_log` VALUES ('115', '2019-04-22 23:53:38.048992', '127.0.0.1', null, '', 'delete', '批量删除 2 个 资源信息', null, '18');
INSERT INTO `xadmin_log` VALUES ('116', '2019-04-22 23:56:30.827732', '127.0.0.1', '4', '01. mysql简介', 'create', '已添加。', '10', '18');
INSERT INTO `xadmin_log` VALUES ('117', '2019-04-24 11:18:45.434926', '117.136.66.8', '5', '第三章：css选择器', 'change', '修改 url', '11', '18');
INSERT INTO `xadmin_log` VALUES ('118', '2019-04-24 11:26:20.141080', '117.136.66.8', '4', '02. html 初识', 'change', '修改 url', '11', '18');
INSERT INTO `xadmin_log` VALUES ('119', '2019-04-24 14:41:03.923298', '223.104.4.158', null, '', 'delete', '批量删除 50 个 日志记录', null, '18');
INSERT INTO `xadmin_log` VALUES ('120', '2019-04-24 14:41:34.688766', '223.104.4.158', '1', '吃饭饭', 'create', '已添加。', '2', '18');
INSERT INTO `xadmin_log` VALUES ('121', '2019-04-24 14:41:54.019179', '223.104.4.158', null, '', 'delete', '批量删除 1 个 组', null, '18');
INSERT INTO `xadmin_log` VALUES ('122', '2019-05-04 20:51:34.727562', '127.0.0.1', '6', 'html 简介2', 'create', '已添加。', '11', '18');

-- ----------------------------
-- Table structure for xadmin_usersettings
-- ----------------------------
DROP TABLE IF EXISTS `xadmin_usersettings`;
CREATE TABLE `xadmin_usersettings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(256) NOT NULL,
  `value` longtext NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `xadmin_usersettings_user_id_edeabe4a_fk_users_userprofile_id` (`user_id`),
  CONSTRAINT `xadmin_usersettings_user_id_edeabe4a_fk_users_userprofile_id` FOREIGN KEY (`user_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xadmin_usersettings
-- ----------------------------
INSERT INTO `xadmin_usersettings` VALUES ('1', 'dashboard:home:pos', '', '1');
INSERT INTO `xadmin_usersettings` VALUES ('2', 'site-theme', '/static/xadmin/css/themes/bootstrap-xadmin.css', '1');
INSERT INTO `xadmin_usersettings` VALUES ('3', 'dashboard:home:pos', '', '18');
INSERT INTO `xadmin_usersettings` VALUES ('4', 'site-theme', 'https://bootswatch.com/3/cerulean/bootstrap.min.css', '18');

-- ----------------------------
-- Table structure for xadmin_userwidget
-- ----------------------------
DROP TABLE IF EXISTS `xadmin_userwidget`;
CREATE TABLE `xadmin_userwidget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` varchar(256) NOT NULL,
  `widget_type` varchar(50) NOT NULL,
  `value` longtext NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `xadmin_userwidget_user_id_c159233a_fk_users_userprofile_id` (`user_id`),
  CONSTRAINT `xadmin_userwidget_user_id_c159233a_fk_users_userprofile_id` FOREIGN KEY (`user_id`) REFERENCES `users_userprofile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xadmin_userwidget
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-27 20:41:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `device_basic_info`;
CREATE TABLE `device_basic_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_name` varchar(255) NOT NULL COMMENT '设备名称',
  `uuid` varchar(255) NOT NULL COMMENT 'UUID.生成二维码的凭据',
  `is_scraped` int NOT NULL DEFAULT '0' COMMENT '是否废弃。0-未废弃，1-已废弃',
  `principal_user_id` int NOT NULL COMMENT '负责人用户ID',
  `is_maintain` int NOT NULL DEFAULT '0' COMMENT '是否正在维护。0-未维护，1-正在维护',
  `detail` longtext COMMENT '设备详情介绍',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `is_lended` int NOT NULL DEFAULT '0' COMMENT '是否借出',
  `is_reverse` int NOT NULL DEFAULT '0' COMMENT '是否被预定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_basic_info
-- ----------------------------
INSERT INTO `device_basic_info` VALUES ('2', 'zk', 'adsfsd', '1', '1', '1', null, '2021-03-16 13:43:33', '2021-03-31 09:36:15', '1', '0');
INSERT INTO `device_basic_info` VALUES ('3', '手机', 'f5e0033e-2c59-4b67-9ce7-bad29e3db264', '1', '1', '0', 'ceshi', '2021-03-16 18:40:21', '2021-04-03 11:59:32', '1', '0');
INSERT INTO `device_basic_info` VALUES ('4', '电脑', 'e62a5b95-b7e8-4549-8f1f-14962ec86fdd', '1', '2', '0', '测试用', '2021-03-17 09:55:04', '2021-04-03 11:59:33', '0', '0');
INSERT INTO `device_basic_info` VALUES ('5', '平板', '05a01bcd-00eb-4f23-a20b-439d02d58860', '1', '1', '0', 'aaa', '2021-03-17 18:24:53', '2021-04-03 11:59:35', '0', '0');

-- ----------------------------
-- Table structure for device_lend
-- ----------------------------
DROP TABLE IF EXISTS `device_lend`;
CREATE TABLE `device_lend` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` int NOT NULL COMMENT '设备ID',
  `lend_user_id` int NOT NULL COMMENT '借出人',
  `lend_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借出时间',
  `expect_return_time` timestamp NULL DEFAULT NULL COMMENT '预计归还时间',
  `return_time` timestamp NULL DEFAULT NULL COMMENT '实际归还时间',
  `detail` longtext NOT NULL COMMENT '借出详情',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `is_deleted` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_lend
-- ----------------------------
INSERT INTO `device_lend` VALUES ('1', '3', '2', '2021-03-17 12:27:10', '2021-03-17 12:27:13', '2021-03-17 12:27:15', '无', '2021-03-17 12:27:20', '2021-04-27 19:02:26', '1');
INSERT INTO `device_lend` VALUES ('2', '3', '2', '2021-03-29 21:25:31', null, null, 'a', '2021-03-29 21:25:31', '2021-04-27 19:02:27', '1');
INSERT INTO `device_lend` VALUES ('7', '2', '1', '2021-03-31 09:49:03', null, null, '', '2021-03-31 09:49:03', '2021-04-27 19:02:31', '1');
INSERT INTO `device_lend` VALUES ('8', '3', '1', '2021-03-31 09:49:56', null, null, '', '2021-03-31 09:49:56', '2021-04-27 19:02:32', '1');
INSERT INTO `device_lend` VALUES ('9', '4', '1', '2021-03-31 09:54:09', null, null, '', '2021-03-31 09:54:09', '2021-03-31 09:54:09', '1');
INSERT INTO `device_lend` VALUES ('10', '3', '1', '2021-04-01 14:45:08', null, null, '', '2021-04-01 14:45:08', '2021-04-27 19:02:34', '1');
INSERT INTO `device_lend` VALUES ('11', '3', '1', '2021-04-01 15:27:09', null, null, '', '2021-04-01 15:27:09', '2021-04-27 19:02:35', '1');
INSERT INTO `device_lend` VALUES ('12', '5', '1', '2021-04-01 15:28:12', null, null, '', '2021-04-01 15:28:12', '2021-04-27 19:02:36', '1');
INSERT INTO `device_lend` VALUES ('13', '3', '1', '2021-04-02 09:34:50', null, null, '', '2021-04-02 09:34:50', '2021-04-27 19:02:37', '1');
INSERT INTO `device_lend` VALUES ('14', '2', '1', '2021-04-27 18:57:55', null, null, '', '2021-04-27 18:57:55', '2021-04-27 19:02:43', '0');
INSERT INTO `device_lend` VALUES ('15', '3', '1', '2021-04-27 19:06:07', null, null, '', '2021-04-27 19:06:07', '2021-04-27 19:06:07', '1');
INSERT INTO `device_lend` VALUES ('16', '3', '1', '2021-04-27 19:06:09', null, null, '', '2021-04-27 19:06:09', '2021-04-27 19:06:09', '1');
INSERT INTO `device_lend` VALUES ('17', '3', '1', '2021-04-27 19:06:10', null, null, '', '2021-04-27 19:06:10', '2021-04-27 19:06:10', '1');
INSERT INTO `device_lend` VALUES ('18', '3', '1', '2021-04-27 19:06:10', null, null, '', '2021-04-27 19:06:10', '2021-04-27 19:06:10', '0');

-- ----------------------------
-- Table structure for device_maintain
-- ----------------------------
DROP TABLE IF EXISTS `device_maintain`;
CREATE TABLE `device_maintain` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` int NOT NULL COMMENT '设备ID',
  `maintain_user_id` int NOT NULL COMMENT '维护人用户ID',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始维护时间',
  `finish_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预计完成时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `status` varchar(255) NOT NULL COMMENT '当前维护状态。',
  `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除。0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_maintain
-- ----------------------------
INSERT INTO `device_maintain` VALUES ('1', '2', '1', '2021-03-16 20:41:55', '2021-03-16 20:41:58', '2021-03-16 20:42:08', '2021-03-16 20:42:08', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('12', '5', '1', '2021-04-03 12:00:18', '2021-04-03 12:00:18', '2021-04-03 12:00:18', '2021-04-03 12:00:18', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('13', '3', '1', '2021-04-03 16:37:16', '2021-04-03 16:37:16', '2021-04-03 16:37:16', '2021-04-03 16:37:16', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('14', '4', '1', '2021-04-03 16:37:21', '2021-04-03 16:37:21', '2021-04-03 16:37:21', '2021-04-03 16:37:21', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('15', '2', '1', '2021-04-03 16:37:49', '2021-04-03 16:37:49', '2021-04-03 16:37:49', '2021-04-03 16:37:49', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('16', '2', '1', '2021-04-05 14:07:26', '2021-04-05 14:07:26', '2021-04-05 14:07:26', '2021-04-05 14:07:26', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('17', '2', '1', '2021-04-05 14:07:28', '2021-04-05 14:07:28', '2021-04-05 14:07:28', '2021-04-05 14:07:28', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('18', '3', '1', '2021-04-15 11:55:56', '2021-04-15 11:55:56', '2021-04-15 11:55:56', '2021-04-15 11:55:56', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('19', '2', '1', '2021-04-27 16:31:10', '2021-04-27 16:31:10', '2021-04-27 16:31:10', '2021-04-27 16:31:10', '已结束', '1');
INSERT INTO `device_maintain` VALUES ('20', '2', '1', '2021-04-27 16:42:03', '2021-04-27 16:42:03', '2021-04-27 16:42:03', '2021-04-27 16:42:03', '维护中', '0');
INSERT INTO `device_maintain` VALUES ('21', '3', '1', '2021-04-27 16:42:04', '2021-04-27 16:42:04', '2021-04-27 16:42:04', '2021-04-27 16:42:04', '已结束', '1');

-- ----------------------------
-- Table structure for device_reserve
-- ----------------------------
DROP TABLE IF EXISTS `device_reserve`;
CREATE TABLE `device_reserve` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` int NOT NULL COMMENT '设备ID',
  `reserve_user_id` int NOT NULL COMMENT '预约用户ID',
  `reserve_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预定时间',
  `expect_return_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预计归还时间',
  `detail` longtext NOT NULL COMMENT '预定详情',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_reserve
-- ----------------------------

-- ----------------------------
-- Table structure for device_scrap
-- ----------------------------
DROP TABLE IF EXISTS `device_scrap`;
CREATE TABLE `device_scrap` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` int NOT NULL COMMENT '设备ID',
  `scrap_user_id` int NOT NULL COMMENT '执行报废操作的用户ID',
  `scrap_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报废的时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '报废的理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_scrap
-- ----------------------------
INSERT INTO `device_scrap` VALUES ('1', '3', '2', '2021-03-17 10:50:37', '2021-03-17 10:50:40', '2021-03-17 10:50:40', '无');
INSERT INTO `device_scrap` VALUES ('2', '5', '1', '2021-04-03 11:51:02', '2021-04-03 11:51:02', '2021-04-03 11:51:02', null);
INSERT INTO `device_scrap` VALUES ('3', '4', '1', '2021-04-03 16:54:04', '2021-04-03 16:54:04', '2021-04-03 16:54:04', null);
INSERT INTO `device_scrap` VALUES ('4', '2', '1', '2021-04-27 16:31:14', '2021-04-27 16:31:14', '2021-04-27 16:31:14', null);
INSERT INTO `device_scrap` VALUES ('5', '4', '1', '2021-04-27 16:57:30', '2021-04-27 16:57:30', '2021-04-27 16:57:30', null);

-- ----------------------------
-- Table structure for laboratory_info
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_info`;
CREATE TABLE `laboratory_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `lab_name` varchar(255) NOT NULL DEFAULT '' COMMENT '实验室名称',
  `principal_user_id` int NOT NULL COMMENT '实验室负责人的用户ID',
  `region` varchar(255) NOT NULL DEFAULT '' COMMENT '实验室所属区域',
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验室详情',
  `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否删除。0-未删除，1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laboratory_info
-- ----------------------------
INSERT INTO `laboratory_info` VALUES ('1', '实验室一', '2', '21B', '无', '0', '2021-03-17 15:27:40', '2021-03-17 15:27:40');

-- ----------------------------
-- Table structure for laboratory_location
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_location`;
CREATE TABLE `laboratory_location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lab_id` int NOT NULL COMMENT '实验室ID',
  `longitude` double NOT NULL COMMENT '经度',
  `latitude` double NOT NULL COMMENT '纬度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laboratory_location
-- ----------------------------
INSERT INTO `laboratory_location` VALUES ('1', '1', '100.365', '57.963');

-- ----------------------------
-- Table structure for permission_info
-- ----------------------------
DROP TABLE IF EXISTS `permission_info`;
CREATE TABLE `permission_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `permission_name` varchar(255) NOT NULL COMMENT '权限名称',
  `path` varchar(255) NOT NULL COMMENT '路径',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_info
-- ----------------------------
INSERT INTO `permission_info` VALUES ('1', 'admin', '/device', '2021-03-17 16:25:47', '2021-03-18 17:15:15');
INSERT INTO `permission_info` VALUES ('2', 'admin', '/user', '2021-03-18 17:16:38', '2021-03-18 17:16:38');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', 'admin', '2021-03-17 16:12:04', '2021-03-17 16:12:04');
INSERT INTO `role_info` VALUES ('2', 'aa', '2021-03-17 18:29:28', '2021-03-17 18:29:28');
INSERT INTO `role_info` VALUES ('3', '学生', '2021-03-17 19:18:37', '2021-03-17 19:18:37');
INSERT INTO `role_info` VALUES ('4', '访客', '2021-04-25 16:25:27', '2021-04-25 16:25:27');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int NOT NULL COMMENT '角色ID',
  `permission_id` int NOT NULL COMMENT '权限名',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_token`;
CREATE TABLE `sys_token` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `expire_time` datetime NOT NULL COMMENT '过期时间',
  `token` varchar(255) NOT NULL COMMENT 'token',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_token
-- ----------------------------
INSERT INTO `sys_token` VALUES ('1', '1', '2021-04-26 04:53:25', 'c96ea41cbc7f0c9e77e47a880803134d', '2021-04-25 16:53:25');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_alias` varchar(255) DEFAULT '' COMMENT '用户昵称',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '用户身份',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `pic` varchar(255) DEFAULT NULL COMMENT '用户头像ID',
  `is_deleted` int NOT NULL DEFAULT '0' COMMENT '用户是否删除。0-未删除， 1-已删除',
  `is_banned` int NOT NULL DEFAULT '0' COMMENT '用户是否被禁用。0-未禁用， 1-已禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `qq` varchar(255) DEFAULT '' COMMENT 'qq号',
  `wechat` varchar(255) DEFAULT '' COMMENT '微信号',
  `sex` int NOT NULL COMMENT '性别。0-男， 1-女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '管理员', 'admin', '123456', null, '0', '0', '2021-03-16 17:28:09', '2021-03-16 17:28:09', '', '', '', '0');
INSERT INTO `user` VALUES ('2', 'zk', '张凯', 'admin', '123456', null, '0', '0', '2021-03-17 09:54:57', '2021-03-17 09:54:57', '', '', '', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户ID',
  `role_id` int NOT NULL COMMENT '角色ID',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1', '2021-03-18 17:16:58');

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-08 17:10:59
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

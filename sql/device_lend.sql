/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-08 17:11:05
*/

SET FOREIGN_KEY_CHECKS=0;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

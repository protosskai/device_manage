/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-03-12 13:29:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device_reserve
-- ----------------------------
DROP TABLE IF EXISTS `device_reserve`;
CREATE TABLE `device_reserve` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` int NOT NULL COMMENT '设备ID',
  `reserve_user_id` int NOT NULL COMMENT '预约用户ID',
  `reserve_time` timestamp NOT NULL COMMENT '预定时间',
  `expect_return_time` timestamp NOT NULL COMMENT '预计归还时间',
  `detail` longtext NOT NULL COMMENT '预定详情',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

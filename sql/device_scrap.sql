/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-08 17:11:55
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

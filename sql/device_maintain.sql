/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-03-11 12:14:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for device_maintain
-- ----------------------------
DROP TABLE IF EXISTS `device_maintain`;
CREATE TABLE `device_maintain` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `device_id` int NOT NULL COMMENT '设备ID',
  `maintain_user_id` int NOT NULL COMMENT '维护人用户ID',
  `start_time` timestamp NOT NULL  COMMENT '开始维护时间',
  `finish_time` timestamp NOT NULL COMMENT '预计完成时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `status` varchar(255) NOT NULL COMMENT '当前维护状态。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

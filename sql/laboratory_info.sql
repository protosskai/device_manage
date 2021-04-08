/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-08 17:12:01
*/

SET FOREIGN_KEY_CHECKS=0;

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

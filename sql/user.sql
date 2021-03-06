/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-08 17:12:35
*/

SET FOREIGN_KEY_CHECKS=0;

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

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : device

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-04-08 17:12:29
*/

SET FOREIGN_KEY_CHECKS=0;

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

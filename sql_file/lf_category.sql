/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lostandfound

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-26 21:31:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lf_category`
-- ----------------------------
DROP TABLE IF EXISTS `lf_category`;
CREATE TABLE `lf_category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lf_category
-- ----------------------------
INSERT INTO `lf_category` VALUES ('1', '书籍');
INSERT INTO `lf_category` VALUES ('2', '服饰');

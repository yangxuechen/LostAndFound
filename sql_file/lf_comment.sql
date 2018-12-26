/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lostandfound

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-26 21:31:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lf_comment`
-- ----------------------------
DROP TABLE IF EXISTS `lf_comment`;
CREATE TABLE `lf_comment` (
  `comment_id` int(11) NOT NULL,
  `comment_content` varchar(500) NOT NULL,
  `comment_userId` varchar(255) NOT NULL,
  `comment_messageId` int(11) NOT NULL,
  `comment_date` date NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lf_comment
-- ----------------------------
INSERT INTO `lf_comment` VALUES ('1', '哈哈哈', '6', '6', '2018-12-13');
INSERT INTO `lf_comment` VALUES ('2', '哈哈哈', '6', '6', '2018-12-13');
INSERT INTO `lf_comment` VALUES ('3', '联盟第一人', '16', '6', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('4', '联盟第一人', '16', '6', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('5', '天马行空', '16', '7', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('6', '咔咔咔咔咔咔', '16', '9', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('7', '卡卡', '16', '7', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('8', '123', '16', '16', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('9', '111', '16', '8', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('10', '联盟第一人', '19', '12', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('11', '大国崛起', '19', '6', '2018-12-26');
INSERT INTO `lf_comment` VALUES ('12', 'aaa', '22', '7', '2018-12-26');

/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lostandfound

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-26 21:30:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lf_user`
-- ----------------------------
DROP TABLE IF EXISTS `lf_user`;
CREATE TABLE `lf_user` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_email` varchar(20) DEFAULT NULL,
  `user_photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lf_user
-- ----------------------------
INSERT INTO `lf_user` VALUES ('1', 'love', '111', 'nnnn', null);
INSERT INTO `lf_user` VALUES ('3', 'yxc', '123456,123456', '1', null);
INSERT INTO `lf_user` VALUES ('4', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('5', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('6', 'tt', '123456', null, null);
INSERT INTO `lf_user` VALUES ('7', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('8', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('9', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('10', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('11', '哈哈哈', '123456', null, null);
INSERT INTO `lf_user` VALUES ('12', '鍝堝搱鍝�', '123456', null, null);
INSERT INTO `lf_user` VALUES ('13', '鍝堝搱鍝�', '123456', null, null);
INSERT INTO `lf_user` VALUES ('14', 'James', '123456', null, null);
INSERT INTO `lf_user` VALUES ('15', 'kk', '123456', null, null);
INSERT INTO `lf_user` VALUES ('16', 'yxc', '123456', null, null);
INSERT INTO `lf_user` VALUES ('17', '', '', null, null);
INSERT INTO `lf_user` VALUES ('18', '', '', null, null);
INSERT INTO `lf_user` VALUES ('19', '李四', '123456', null, null);
INSERT INTO `lf_user` VALUES ('20', 'zzz', '1', null, null);
INSERT INTO `lf_user` VALUES ('21', 'yxc', '123456', null, null);
INSERT INTO `lf_user` VALUES ('22', 'aaa', '1', null, null);

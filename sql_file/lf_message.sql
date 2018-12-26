/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lostandfound

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-26 21:30:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `lf_message`
-- ----------------------------
DROP TABLE IF EXISTS `lf_message`;
CREATE TABLE `lf_message` (
  `message_id` int(11) NOT NULL,
  `message_description` varchar(500) DEFAULT NULL,
  `message_userId` varchar(255) DEFAULT NULL,
  `message_categotyId` int(11) DEFAULT NULL,
  `message_date` date DEFAULT NULL,
  `message_photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lf_message
-- ----------------------------
INSERT INTO `lf_message` VALUES ('6', '联盟第一人', '16', '1', '2018-12-18', 'images/9i5yt.jpg');
INSERT INTO `lf_message` VALUES ('7', '联盟第一人James', '16', '1', '2018-12-18', 'images\\anFFt.jpg');
INSERT INTO `lf_message` VALUES ('8', 'how ord are you', '16', '1', '2018-12-18', 'images\\ai9Vy.jpg');
INSERT INTO `lf_message` VALUES ('9', '天马行空', '16', '1', '2018-12-18', 'images/uf2MR.jpg');
INSERT INTO `lf_message` VALUES ('10', '大国崛起', '16', '1', '2018-12-18', 'images/NMJff.jpg');
INSERT INTO `lf_message` VALUES ('11', 'send it', '1', '1', '2018-12-18', 'images/MtnRu.jpg');
INSERT INTO `lf_message` VALUES ('12', '亦余心之所善兮，虽九死其犹未悔', '16', '1', '2018-12-18', 'images/vesvb.jpg');
INSERT INTO `lf_message` VALUES ('13', 'ssh框架整合', '19', '1', '2018-12-18', 'images/eGk9N.jpg');
INSERT INTO `lf_message` VALUES ('14', '1111111111', '16', '1', '2018-12-20', 'images/dhgdF.jpg');
INSERT INTO `lf_message` VALUES ('15', '222222222', '16', '1', '2018-12-20', 'images/wc9yf.jpg');
INSERT INTO `lf_message` VALUES ('16', '爆炒江湖自己可·', '16', '1', '2018-12-21', 'images/fi9xx.jpg');
INSERT INTO `lf_message` VALUES ('17', '111111', '16', '1', '2018-12-22', 'images/CB5rw.jpg');
INSERT INTO `lf_message` VALUES ('18', 'this is for you', '16', '1', '2018-12-26', 'images/b2ZNe.jpg');
INSERT INTO `lf_message` VALUES ('19', 'dddd', '22', '1', '2018-12-26', 'images/Gjie9.jpg');

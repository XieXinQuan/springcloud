/*
Navicat MySQL Data Transfer

Source Server         : 222
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : springcloud

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2020-11-10 21:45:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('8');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(5) DEFAULT NULL,
  `SHORE_NAME` varchar(2) DEFAULT NULL,
  `ENGLISH_NAME` varchar(20) DEFAULT NULL,
  `SEX` tinyint(4) DEFAULT NULL,
  `IPHONE` char(11) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `BALANCE` decimal(10,2) DEFAULT NULL,
  `PASSWORD` varchar(18) DEFAULT NULL,
  `ENCRYPT_PASSWORD` varchar(50) DEFAULT NULL,
  `IS_MERCHANT` tinyint(4) DEFAULT NULL,
  `IS_VIP` tinyint(4) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a', null, null, '1', null, '1', '0.00', 'aaaaaa', null, '1', '0', null);
INSERT INTO `user` VALUES ('2', 'a1', null, null, '1', null, '1', '0.00', 'aaaaaa', null, '0', '0', null);
INSERT INTO `user` VALUES ('3', 'aa', null, null, '1', null, '1', '0.00', 'aaaaaa', null, '0', '0', '1372862842@qq.com');
INSERT INTO `user` VALUES ('4', '137', null, null, '1', null, '1', '0.00', 'aaaaaa', null, '0', '0', '1372862842@qq.com');
INSERT INTO `user` VALUES ('5', '协助', null, null, '1', null, '1', '0.00', '123456', null, '0', '0', '2326639130@qq.com');
INSERT INTO `user` VALUES ('6', 'quan', null, null, '1', null, '1', '0.00', 'aaaaaa', null, '0', '0', '1372862842@qq.com');
INSERT INTO `user` VALUES ('7', 'simon', null, null, '1', null, '1', '0.00', 'aaaaaa', null, '0', '1', '1074315849@qq.com');

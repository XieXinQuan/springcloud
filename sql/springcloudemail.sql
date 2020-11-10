/*
Navicat MySQL Data Transfer

Source Server         : 222
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : springcloudemail

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2020-11-10 21:44:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `failure_email`
-- ----------------------------
DROP TABLE IF EXISTS `failure_email`;
CREATE TABLE `failure_email` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(1000) DEFAULT '',
  `EXCEPTION_TYPE` varchar(100) DEFAULT '',
  `EXCEPTION_REASON` varchar(1000) DEFAULT '',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of failure_email
-- ----------------------------
INSERT INTO `failure_email` VALUES ('1', '{\"id\":18,\"message\":\"您在2020-06-04 11:05消费1999.00元\"}', 'java.lang.NullPointerException', null, '2020-06-04 11:56:53');
INSERT INTO `failure_email` VALUES ('2', '{\"id\":19,\"message\":\"您在2020-06-04 11:05消费2599.00元\"}', 'java.lang.NullPointerException', null, '2020-06-04 11:56:53');

-- ----------------------------
-- Table structure for `send_message`
-- ----------------------------
DROP TABLE IF EXISTS `send_message`;
CREATE TABLE `send_message` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '邮件自增ID',
  `RECEIVE_USER_ID` bigint(20) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(32) DEFAULT '' COMMENT '收件人邮箱',
  `MESSAGE` varchar(50) DEFAULT '',
  `MESSAGE_ID` bigint(20) DEFAULT '0' COMMENT '消息ID',
  `STATUS` tinyint(4) DEFAULT '0' COMMENT '发送状态',
  `TYPE` tinyint(4) DEFAULT '0' COMMENT '消息类型',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of send_message
-- ----------------------------
INSERT INTO `send_message` VALUES ('1', '3', '1372862842@qq.com', '您在2020-06-04 11:58消费88.00元', '20', '1', '1', '2020-06-04 11:58:54');
INSERT INTO `send_message` VALUES ('2', '3', '1372862842@qq.com', '您在2020-06-04 12:01消费88.00元', '21', '1', '1', '2020-06-04 12:01:24');

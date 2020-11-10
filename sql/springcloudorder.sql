/*
Navicat MySQL Data Transfer

Source Server         : 222
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : springcloudorder

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2020-11-10 21:45:39
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
INSERT INTO `hibernate_sequence` VALUES ('2');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `money` decimal(11,0) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '25', '1', '1999', null);
INSERT INTO `t_order` VALUES ('15', '1', '1', '5', '50', '1');
INSERT INTO `t_order` VALUES ('16', '1', '1', '5', '50', '1');
INSERT INTO `t_order` VALUES ('17', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('18', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('19', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('20', '1', '1', '5', '20', '0');
INSERT INTO `t_order` VALUES ('21', '1', '1', '5', '20', '0');
INSERT INTO `t_order` VALUES ('22', '1', '1', '5', '20', '0');
INSERT INTO `t_order` VALUES ('23', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('24', '1', '1', '5', '20', '0');
INSERT INTO `t_order` VALUES ('25', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('26', '1', '1', '5', '20', '0');
INSERT INTO `t_order` VALUES ('27', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('28', '1', '1', '5', '20', '1');
INSERT INTO `t_order` VALUES ('30', '1', '1', '5', '20', '0');

-- ----------------------------
-- Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

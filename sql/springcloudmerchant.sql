/*
Navicat MySQL Data Transfer

Source Server         : 222
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : springcloudmerchant

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2020-11-10 21:44:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `SHOP_ID` bigint(20) DEFAULT NULL,
  `TITLE` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  `category` tinyint(4) NOT NULL DEFAULT '1',
  `STOCK` int(11) NOT NULL DEFAULT '1',
  `PRICE` decimal(6,2) NOT NULL DEFAULT '0.00',
  `STATUS` tinyint(4) DEFAULT NULL,
  `SELL_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(5) DEFAULT '',
  `UPDATE_USER` varchar(5) DEFAULT '',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `image_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_7` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('25', '3', '1', 'xiaomi', 'xiaomi8SE', '7', '1', '1999.00', '1', '2020-05-23 14:26:11', '3', '3', '2020-05-23 14:13:55', '2020-05-23 14:29:32', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.oWDNlQNg6qMS90c9d497139509fa6d501987d3f0079e.jpg');
INSERT INTO `commodity` VALUES ('26', '3', '1', '华为', '华为荣耀10', '7', '2', '1899.00', '1', '2020-05-23 14:28:06', '3', '3', '2020-05-23 14:27:24', '2020-05-23 14:37:55', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.FnB30jlLhp3k5470514ee6bc9c27c3081f9f32e246b0.jpg');
INSERT INTO `commodity` VALUES ('28', '3', '1', '小米', '小米8SE', '7', '20', '1999.00', '1', '2020-05-23 14:33:18', '3', '3', '2020-05-23 14:32:51', '2020-05-23 14:33:18', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.KgmPzdcHz6pAefcd01c24765f151750199ab2a94b460.jpg');
INSERT INTO `commodity` VALUES ('29', '3', '1', '篮球', '篮球', '8', '20', '88.00', '1', '2020-05-23 14:34:34', '3', '3', '2020-05-23 14:34:02', '2020-05-23 14:34:34', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.IzwKgRnMLUxz8bd1ccbaf26b3f1af7cb10d8df2aa82a.jpg');
INSERT INTO `commodity` VALUES ('30', '3', '1', '华为', '华为P40', '7', '2', '2599.00', '1', '2020-05-23 14:35:20', '3', '3', '2020-05-23 14:34:51', '2020-05-23 14:35:20', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.FnB30jlLhp3k5470514ee6bc9c27c3081f9f32e246b0.jpg');
INSERT INTO `commodity` VALUES ('31', '3', '1', '三只松鼠', '三只松鼠', '1', '100', '88.00', '1', '2020-05-23 14:36:29', '3', '3', '2020-05-23 14:35:49', '2020-05-23 14:36:29', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.LGOzAHu1moBo9e18971055620fcdbcb99aa5b9de1638.jpg');
INSERT INTO `commodity` VALUES ('33', '3', '1', '小米', '小米9SE', '1', '1', '0.00', '2', null, '3', '3', '2020-05-24 17:47:49', '2020-06-08 10:50:59', null);

-- ----------------------------
-- Table structure for `commodity_image`
-- ----------------------------
DROP TABLE IF EXISTS `commodity_image`;
CREATE TABLE `commodity_image` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMODITY_ID` bigint(20) DEFAULT NULL,
  `FILE_NAME` varchar(500) DEFAULT NULL,
  `SIZE` int(11) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `IMAGE_URL` varchar(500) DEFAULT NULL,
  `CREATE_USER` varchar(5) DEFAULT NULL,
  `UPDATE_USER` varchar(5) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_6` (`COMMODITY_ID`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`COMMODITY_ID`) REFERENCES `commodity` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of commodity_image
-- ----------------------------
INSERT INTO `commodity_image` VALUES ('35', '25', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.oWDNlQNg6qMS90c9d497139509fa6d501987d3f0079e.jpg', null, '1', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.oWDNlQNg6qMS90c9d497139509fa6d501987d3f0079e.jpg', null, null, null, '2020-05-23 14:25:38');
INSERT INTO `commodity_image` VALUES ('36', '26', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.1ttHUPu6aoBu036304df529b377f08e31a724e89aba9.jpg', null, '1', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.FnB30jlLhp3k5470514ee6bc9c27c3081f9f32e246b0.jpg', null, null, null, '2020-05-23 14:38:08');
INSERT INTO `commodity_image` VALUES ('38', '28', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.KgmPzdcHz6pAefcd01c24765f151750199ab2a94b460.jpg', null, '1', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.KgmPzdcHz6pAefcd01c24765f151750199ab2a94b460.jpg', null, null, null, '2020-05-23 14:33:17');
INSERT INTO `commodity_image` VALUES ('39', '29', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.IzwKgRnMLUxz8bd1ccbaf26b3f1af7cb10d8df2aa82a.jpg', null, '1', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.IzwKgRnMLUxz8bd1ccbaf26b3f1af7cb10d8df2aa82a.jpg', null, null, null, '2020-05-23 14:34:29');
INSERT INTO `commodity_image` VALUES ('40', '30', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.FnB30jlLhp3k5470514ee6bc9c27c3081f9f32e246b0.jpg', null, '1', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.FnB30jlLhp3k5470514ee6bc9c27c3081f9f32e246b0.jpg', null, null, null, '2020-05-23 14:35:19');
INSERT INTO `commodity_image` VALUES ('41', '31', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.LGOzAHu1moBo9e18971055620fcdbcb99aa5b9de1638.jpg', null, '1', 'http://118.89.133.157/images/2020/05/23/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.LGOzAHu1moBo9e18971055620fcdbcb99aa5b9de1638.jpg', null, null, null, '2020-05-23 14:36:27');
INSERT INTO `commodity_image` VALUES ('45', '33', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.DlGzXgnUNUnp9e18971055620fcdbcb99aa5b9de1638.jpg', null, '1', 'http://118.89.133.157/images/2020/05/24/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.DlGzXgnUNUnp9e18971055620fcdbcb99aa5b9de1638.jpg', null, null, null, '2020-05-24 17:48:06');
INSERT INTO `commodity_image` VALUES ('70', '33', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.bvsUi887eNP79e18971055620fcdbcb99aa5b9de1638.jpg', null, '1', 'http://118.89.133.157/images/2020/06/07/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.bvsUi887eNP79e18971055620fcdbcb99aa5b9de1638.jpg', null, null, null, '2020-06-07 21:04:00');
INSERT INTO `commodity_image` VALUES ('71', '33', 'file', null, '1', 'http://169.254.95.209:server.port/webimages/file', null, null, null, '2020-08-10 21:35:23');
INSERT INTO `commodity_image` VALUES ('72', '33', 'wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.3vJ811pUc8pDe7878c7a7ef2e2762ce644e0a51e075b.jpg', null, '1', 'http://169.254.95.209:server.port/webimages/wxc072d61dd8e168b9.o6zAJs2QeakTLT0S2379tKe6hSAg.3vJ811pUc8pDe7878c7a7ef2e2762ce644e0a51e075b.jpg', null, null, null, '2020-08-10 21:40:37');

-- ----------------------------
-- Table structure for `shipping_address`
-- ----------------------------
DROP TABLE IF EXISTS `shipping_address`;
CREATE TABLE `shipping_address` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `RECIPIENT_NAME` varchar(5) NOT NULL DEFAULT '',
  `ADDRESS` varchar(30) NOT NULL DEFAULT '',
  `SEX` tinyint(4) NOT NULL DEFAULT '1',
  `IPHONE` char(11) NOT NULL DEFAULT '',
  `STATUS` tinyint(4) NOT NULL DEFAULT '1',
  `IS_DEFAULT` tinyint(4) NOT NULL DEFAULT '1',
  `CREATE_USER` varchar(5) DEFAULT NULL,
  `UPDATE_USER` varchar(5) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shipping_address
-- ----------------------------
INSERT INTO `shipping_address` VALUES ('1', '3', '', '', '1', '', '1', '1', null, null, null, '2020-05-23 23:43:15');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SHOP_NAME` varchar(20) DEFAULT NULL,
  `CREATE_USER` bigint(20) DEFAULT '0',
  `UPDATE_USER` bigint(20) DEFAULT '0',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '小米官方旗舰店', '0', '0', '2020-05-03 15:32:01', '2020-06-04 12:44:24');

-- ----------------------------
-- Table structure for `shop_car`
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMODITY_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  `NUM` int(5) NOT NULL DEFAULT '1',
  `STATUS` tinyint(4) DEFAULT '1',
  `CREATE_USER` bigint(20) DEFAULT NULL,
  `UPDATE_USER` bigint(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SHOP_CAR_COMMODITY_ID_REF_COMMODITY_ID` (`COMMODITY_ID`),
  KEY `SHOP_CAR_USER_REF_USER_ID` (`USER_ID`),
  CONSTRAINT `SHOP_CAR_COMMODITY_ID_REF_COMMODITY_ID` FOREIGN KEY (`COMMODITY_ID`) REFERENCES `commodity` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of shop_car
-- ----------------------------
INSERT INTO `shop_car` VALUES ('1', '28', '3', '1', '3', '3', '3', '2020-05-23 17:42:46', '2020-05-23 23:47:48');
INSERT INTO `shop_car` VALUES ('2', '26', '3', '1', '3', '3', '3', '2020-05-23 17:48:36', '2020-05-23 23:47:48');
INSERT INTO `shop_car` VALUES ('3', '30', '3', '1', '3', '3', '3', '2020-05-23 17:50:53', '2020-05-23 23:47:48');
INSERT INTO `shop_car` VALUES ('4', '26', '3', '1', '3', '3', '3', '2020-05-24 12:23:02', '2020-05-24 13:08:02');
INSERT INTO `shop_car` VALUES ('5', '31', '3', '1', '3', '3', '3', '2020-05-24 17:38:37', '2020-05-24 17:40:50');
INSERT INTO `shop_car` VALUES ('6', '31', '3', '1', '1', '3', '3', '2020-06-04 20:26:07', '2020-06-04 20:26:07');
INSERT INTO `shop_car` VALUES ('7', '30', '3', '1', '1', '3', '3', '2020-06-04 20:26:17', '2020-06-04 20:26:17');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SERIAL_NUMBER` varchar(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `COMMODITY_ID` bigint(20) DEFAULT NULL,
  `PRICE` decimal(6,2) DEFAULT NULL,
  `AMOUNT` int(11) DEFAULT NULL,
  `TOTAL_PRICE` decimal(10,2) DEFAULT NULL,
  `SHIPPING_ADDRESS_ID` bigint(20) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  `CREATE_USER` bigint(20) DEFAULT NULL,
  `UPDATE_USER` bigint(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `FK_COMMDITY_ID_REF_ORDER_COMMODITY_ID` (`COMMODITY_ID`),
  KEY `FK_SHIPPING_ADDRESS_ID_REF_ORDER_SHIPPING_ADDRESS_ID` (`SHIPPING_ADDRESS_ID`),
  KEY `FK_USER_ID_REF_ORDER_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_COMMDITY_ID_REF_ORDER_COMMODITY_ID` FOREIGN KEY (`COMMODITY_ID`) REFERENCES `commodity` (`ID`),
  CONSTRAINT `FK_SHIPPING_ADDRESS_ID_REF_ORDER_SHIPPING_ADDRESS_ID` FOREIGN KEY (`SHIPPING_ADDRESS_ID`) REFERENCES `shipping_address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('8', '1264221500748206080', '3', '28', '1999.00', '1', '1999.00', '1', '1', '3', '3', '2020-05-23 23:47:48', '2020-05-23 23:47:48');
INSERT INTO `t_order` VALUES ('9', '1264221500752400384', '3', '26', '1899.00', '1', '1899.00', '1', '1', '3', '3', '2020-05-23 23:47:48', '2020-05-23 23:47:48');
INSERT INTO `t_order` VALUES ('10', '1264221500752400385', '3', '30', '2599.00', '1', '2599.00', '1', '1', '3', '3', '2020-05-23 23:47:48', '2020-05-23 23:47:48');
INSERT INTO `t_order` VALUES ('11', '1264417718501773312', '3', '31', '88.00', '1', '88.00', '1', '1', '3', '3', '2020-05-24 12:47:30', '2020-05-24 12:47:30');
INSERT INTO `t_order` VALUES ('12', '1264422885674586112', '3', '26', '1899.00', '1', '1899.00', '1', '1', '3', '3', '2020-05-24 13:08:02', '2020-05-24 13:08:02');
INSERT INTO `t_order` VALUES ('13', '1264491510611709952', '3', '31', '88.00', '1', '88.00', '1', '1', '3', '3', '2020-05-24 17:40:43', '2020-05-24 17:40:43');
INSERT INTO `t_order` VALUES ('14', '1264491515800064000', '3', '31', '88.00', '1', '88.00', '1', '1', '3', '3', '2020-05-24 17:40:45', '2020-05-24 17:40:45');
INSERT INTO `t_order` VALUES ('15', '1264491537484615680', '3', '31', '88.00', '1', '88.00', '1', '1', '3', '3', '2020-05-24 17:40:50', '2020-05-24 17:40:50');
INSERT INTO `t_order` VALUES ('16', '1268375528545587200', '3', '28', '1999.00', '1', '1999.00', '1', '1', '3', '3', '2020-06-04 10:54:25', '2020-06-04 10:54:25');
INSERT INTO `t_order` VALUES ('17', '1268375547801636864', '3', '28', '1999.00', '1', '1999.00', '1', '1', '3', '3', '2020-06-04 10:54:30', '2020-06-04 10:54:30');
INSERT INTO `t_order` VALUES ('18', '1268378322841243648', '3', '28', '1999.00', '1', '1999.00', '1', '1', '3', '3', '2020-06-04 11:05:32', '2020-06-04 11:05:32');
INSERT INTO `t_order` VALUES ('19', '1268378408354713600', '3', '30', '2599.00', '1', '2599.00', '1', '1', '3', '3', '2020-06-04 11:05:52', '2020-06-04 11:05:52');
INSERT INTO `t_order` VALUES ('20', '1268391753501773824', '3', '29', '88.00', '1', '88.00', '1', '1', '3', '3', '2020-06-04 11:58:54', '2020-06-04 11:58:54');
INSERT INTO `t_order` VALUES ('21', '1268392383087775744', '3', '29', '88.00', '1', '88.00', '1', '1', '3', '3', '2020-06-04 12:01:24', '2020-06-04 12:01:24');
INSERT INTO `t_order` VALUES ('27', '1269562589747220480', '3', '28', '1999.00', '1', '1999.00', '1', '1', '3', '3', '2020-06-07 17:31:23', '2020-06-07 17:31:23');

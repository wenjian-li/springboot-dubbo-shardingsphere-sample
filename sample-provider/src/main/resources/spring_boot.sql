/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50734
Source Host           : localhost:3306
Source Database       : spring_boot

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2021-08-05 15:55:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202101
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202101`;
CREATE TABLE `t_order_202101` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202101
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202102
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202102`;
CREATE TABLE `t_order_202102` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202102
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202103
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202103`;
CREATE TABLE `t_order_202103` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202103
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202104
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202104`;
CREATE TABLE `t_order_202104` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202104
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202105
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202105`;
CREATE TABLE `t_order_202105` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202105
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202106
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202106`;
CREATE TABLE `t_order_202106` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202106
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202107
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202107`;
CREATE TABLE `t_order_202107` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202107
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202108
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202108`;
CREATE TABLE `t_order_202108` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202108
-- ----------------------------
INSERT INTO `t_order_202108` VALUES ('1', '630068780068220928', '1', '2021-08-05 15:48:23', '2021-08-05 15:48:23');
INSERT INTO `t_order_202108` VALUES ('2', '630068814851584001', '1', '2021-08-05 15:48:32', '2021-08-05 15:48:32');
INSERT INTO `t_order_202108` VALUES ('3', '630068815522672642', '1', '2021-08-05 15:48:32', '2021-08-05 15:48:32');
INSERT INTO `t_order_202108` VALUES ('4', '630068816093097987', '1', '2021-08-05 15:48:32', '2021-08-05 15:48:32');
INSERT INTO `t_order_202108` VALUES ('5', '630068817686933508', '1', '2021-08-05 15:48:32', '2021-08-05 15:48:32');
INSERT INTO `t_order_202108` VALUES ('6', '630068818802618373', '1', '2021-08-05 15:48:33', '2021-08-05 15:48:33');
INSERT INTO `t_order_202108` VALUES ('7', '630068819414986758', '1', '2021-08-05 15:48:33', '2021-08-05 15:48:33');
INSERT INTO `t_order_202108` VALUES ('8', '630068819964440583', '1', '2021-08-05 15:48:33', '2021-08-05 15:48:33');
INSERT INTO `t_order_202108` VALUES ('9', '630068820555837448', '1', '2021-08-05 15:48:33', '2021-08-05 15:48:33');
INSERT INTO `t_order_202108` VALUES ('10', '630068859227320329', '1', '2021-08-05 15:48:42', '2021-08-05 15:48:42');
INSERT INTO `t_order_202108` VALUES ('11', '630068859877437450', '1', '2021-08-05 15:48:42', '2021-08-05 15:48:42');
INSERT INTO `t_order_202108` VALUES ('12', '630068860485611531', '1', '2021-08-05 15:48:42', '2021-08-05 15:48:42');
INSERT INTO `t_order_202108` VALUES ('13', '630068860988928012', '1', '2021-08-05 15:48:43', '2021-08-05 15:48:43');
INSERT INTO `t_order_202108` VALUES ('14', '630068861471272973', '1', '2021-08-05 15:48:43', '2021-08-05 15:48:43');
INSERT INTO `t_order_202108` VALUES ('15', '630068862029115406', '1', '2021-08-05 15:48:43', '2021-08-05 15:48:43');
INSERT INTO `t_order_202108` VALUES ('16', '630068862930890767', '1', '2021-08-05 15:48:43', '2021-08-05 15:48:43');
INSERT INTO `t_order_202108` VALUES ('17', '630068863438401552', '1', '2021-08-05 15:48:43', '2021-08-05 15:48:43');
INSERT INTO `t_order_202108` VALUES ('18', '630068863975272465', '1', '2021-08-05 15:48:43', '2021-08-05 15:48:43');
INSERT INTO `t_order_202108` VALUES ('19', '630068868589006866', '1', '2021-08-05 15:48:44', '2021-08-05 15:48:44');
INSERT INTO `t_order_202108` VALUES ('20', '630068869109100563', '1', '2021-08-05 15:48:45', '2021-08-05 15:48:45');
INSERT INTO `t_order_202108` VALUES ('21', '630068869612417044', '1', '2021-08-05 15:48:45', '2021-08-05 15:48:45');
INSERT INTO `t_order_202108` VALUES ('22', '630068870044430357', '1', '2021-08-05 15:48:45', '2021-08-05 15:48:45');
INSERT INTO `t_order_202108` VALUES ('23', '630068870656798742', '1', '2021-08-05 15:48:45', '2021-08-05 15:48:45');
INSERT INTO `t_order_202108` VALUES ('24', '630068872112222231', '1', '2021-08-05 15:48:45', '2021-08-05 15:48:45');
INSERT INTO `t_order_202108` VALUES ('25', '630068872728784920', '1', '2021-08-05 15:48:45', '2021-08-05 15:48:45');
INSERT INTO `t_order_202108` VALUES ('26', '630068873303404569', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');
INSERT INTO `t_order_202108` VALUES ('27', '630068873806721050', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');
INSERT INTO `t_order_202108` VALUES ('28', '630068874343591963', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');
INSERT INTO `t_order_202108` VALUES ('29', '630068875299893276', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');
INSERT INTO `t_order_202108` VALUES ('30', '630068875924844573', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');
INSERT INTO `t_order_202108` VALUES ('31', '630068876390412318', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');
INSERT INTO `t_order_202108` VALUES ('32', '630068876897923103', '1', '2021-08-05 15:48:46', '2021-08-05 15:48:46');

-- ----------------------------
-- Table structure for t_order_202109
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202109`;
CREATE TABLE `t_order_202109` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202109
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202110
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202110`;
CREATE TABLE `t_order_202110` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202110
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202111
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202111`;
CREATE TABLE `t_order_202111` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202111
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202112
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202112`;
CREATE TABLE `t_order_202112` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202112
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202201
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202201`;
CREATE TABLE `t_order_202201` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202201
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202202
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202202`;
CREATE TABLE `t_order_202202` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202202
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202203
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202203`;
CREATE TABLE `t_order_202203` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202203
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202204
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202204`;
CREATE TABLE `t_order_202204` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202204
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202205
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202205`;
CREATE TABLE `t_order_202205` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202205
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202206
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202206`;
CREATE TABLE `t_order_202206` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202206
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202207
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202207`;
CREATE TABLE `t_order_202207` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202207
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202208
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202208`;
CREATE TABLE `t_order_202208` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202208
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202209
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202209`;
CREATE TABLE `t_order_202209` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202209
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202210
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202210`;
CREATE TABLE `t_order_202210` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202210
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202211
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202211`;
CREATE TABLE `t_order_202211` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202211
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_202212
-- ----------------------------
DROP TABLE IF EXISTS `t_order_202212`;
CREATE TABLE `t_order_202212` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL COMMENT '订单号',
  `status` int(2) DEFAULT NULL COMMENT '0:失败，1：成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_202212
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

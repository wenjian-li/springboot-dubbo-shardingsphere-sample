/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50734
Source Host           : localhost:3306
Source Database       : spring_boot

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2021-08-13 10:36:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父ID，一级菜单为0',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(255) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `permission` varchar(255) NOT NULL DEFAULT '' COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '类型   0：目录   1：菜单   2：按钮',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '用户管理', '', '', '1', '0', '2021-08-10 15:43:51', '2021-08-10 18:11:47');
INSERT INTO `t_menu` VALUES ('2', '0', '查看', '', 'user:list,user:info', '1', '1', '2021-08-10 15:44:10', '2021-08-10 18:11:50');
INSERT INTO `t_menu` VALUES ('3', '0', '新增', '', 'user:add', '1', '2', '2021-08-10 16:24:18', '2021-08-10 16:24:18');
INSERT INTO `t_menu` VALUES ('4', '0', '修改', '', 'user:update', '1', '3', '2021-08-10 16:24:38', '2021-08-10 16:24:38');
INSERT INTO `t_menu` VALUES ('5', '0', '删除', '', 'user:delete', '1', '4', '2021-08-10 16:24:55', '2021-08-10 16:24:55');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT '' COMMENT '角色名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '2021-08-10 16:21:18', '2021-08-10 16:21:18');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色ID',
  `menu_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1', '1');
INSERT INTO `t_role_menu` VALUES ('2', '1', '2');
INSERT INTO `t_role_menu` VALUES ('3', '1', '3');
INSERT INTO `t_role_menu` VALUES ('4', '1', '4');
INSERT INTO `t_role_menu` VALUES ('5', '1', '5');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `role_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建日期',
  `update_time` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('4', '张三', 'e10adc3949ba59abbe56e057f20f883e', '1', '2021-08-06 17:46:17', '2021-08-06 17:46:17');
INSERT INTO `t_user` VALUES ('5', '李四', 'e10adc3949ba59abbe56e057f20f883e', '1', '2021-08-06 17:49:54', '2021-08-06 17:49:54');
INSERT INTO `t_user` VALUES ('6', '王五', 'e10adc3949ba59abbe56e057f20f883e', '1', '2021-08-06 17:50:03', '2021-08-06 17:50:03');

-- 定时任务
CREATE TABLE `t_schedule_job` (
    `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
    `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
    `params` varchar(2000) DEFAULT NULL COMMENT '参数',
    `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
    `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- 定时任务日志
CREATE TABLE `t_schedule_job_log` (
    `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
    `job_id` bigint(20) NOT NULL COMMENT '任务id',
    `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
    `params` varchar(2000) DEFAULT NULL COMMENT '参数',
    `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
    `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
    `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`log_id`),
    KEY `job_id` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务日志';


INSERT INTO `t_schedule_job` VALUES ('1', 'myTask', 'myTask', '0/10 * * * * ?', '0', '我的定时任务', '2021-09-01 15:48:57');










--  quartz自带表结构
CREATE TABLE QRTZ_JOB_DETAILS(
     SCHED_NAME VARCHAR(120) NOT NULL,
     JOB_NAME VARCHAR(200) NOT NULL,
     JOB_GROUP VARCHAR(200) NOT NULL,
     DESCRIPTION VARCHAR(250) NULL,
     JOB_CLASS_NAME VARCHAR(250) NOT NULL,
     IS_DURABLE VARCHAR(1) NOT NULL,
     IS_NONCONCURRENT VARCHAR(1) NOT NULL,
     IS_UPDATE_DATA VARCHAR(1) NOT NULL,
     REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
     JOB_DATA BLOB NULL,
     PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_TRIGGERS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    JOB_NAME VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    NEXT_FIRE_TIME BIGINT(13) NULL,
    PREV_FIRE_TIME BIGINT(13) NULL,
    PRIORITY INTEGER NULL,
    TRIGGER_STATE VARCHAR(16) NOT NULL,
    TRIGGER_TYPE VARCHAR(8) NOT NULL,
    START_TIME BIGINT(13) NOT NULL,
    END_TIME BIGINT(13) NULL,
    CALENDAR_NAME VARCHAR(200) NULL,
    MISFIRE_INSTR SMALLINT(2) NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
    REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    REPEAT_COUNT BIGINT(7) NOT NULL,
    REPEAT_INTERVAL BIGINT(12) NOT NULL,
    TIMES_TRIGGERED BIGINT(10) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_CRON_TRIGGERS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    CRON_EXPRESSION VARCHAR(120) NOT NULL,
    TIME_ZONE_ID VARCHAR(80),
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
(
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_BLOB_TRIGGERS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    BLOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    INDEX (SCHED_NAME,TRIGGER_NAME, TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_CALENDARS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    CALENDAR_NAME VARCHAR(200) NOT NULL,
    CALENDAR BLOB NOT NULL,
    PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
  SCHED_NAME VARCHAR(120) NOT NULL,
  TRIGGER_GROUP VARCHAR(200) NOT NULL,
  PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_FIRED_TRIGGERS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    ENTRY_ID VARCHAR(95) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    FIRED_TIME BIGINT(13) NOT NULL,
    SCHED_TIME BIGINT(13) NOT NULL,
    PRIORITY INTEGER NOT NULL,
    STATE VARCHAR(16) NOT NULL,
    JOB_NAME VARCHAR(200) NULL,
    JOB_GROUP VARCHAR(200) NULL,
    IS_NONCONCURRENT VARCHAR(1) NULL,
    REQUESTS_RECOVERY VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,ENTRY_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_SCHEDULER_STATE (
  SCHED_NAME VARCHAR(120) NOT NULL,
  INSTANCE_NAME VARCHAR(200) NOT NULL,
  LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
  CHECKIN_INTERVAL BIGINT(13) NOT NULL,
  PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QRTZ_LOCKS (
    SCHED_NAME VARCHAR(120) NOT NULL,
    LOCK_NAME VARCHAR(40) NOT NULL,
    PRIMARY KEY (SCHED_NAME,LOCK_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS(SCHED_NAME,JOB_GROUP);

CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS(SCHED_NAME,CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS(SCHED_NAME,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : db_zd

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-06-18 10:06:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_sys
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys`;
CREATE TABLE `tb_sys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` char(32) DEFAULT NULL,
  `photourl` varchar(100) DEFAULT NULL,
  `mobile` varchar(40) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` tinyint(1) DEFAULT '1' COMMENT '0_超级管理员，1_管理员',
  `state` tinyint(1) DEFAULT '0' COMMENT '0_启用 1_禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys
-- ----------------------------
INSERT INTO `tb_sys` VALUES ('1', 'admin', '289dff07669d7a23de0ef88d2f7129e7', null, null, null, '1', '0');
INSERT INTO `tb_sys` VALUES ('2', 'ad', '123', null, '1234567890', null, '1', '1');
INSERT INTO `tb_sys` VALUES ('3', 'ad', '123', null, '1234567890', null, '1', '1');
INSERT INTO `tb_sys` VALUES ('4', 'ad', '123', null, '1234567890', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('5', 'ad', '123', null, '1234567890', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('6', 'ad', '123', null, '1234567890', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('7', 'admin', '21232f297a57a5a743894a0e4a801fc3', null, '2342222222', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('8', '789', 'cdaeb1282d614772beb1e74c192bebda', null, '12345678', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('9', 'bobo', '4297f44b13955235245b2497399d7a93', null, null, null, '0', '0');
INSERT INTO `tb_sys` VALUES ('10', '676', 'dc6a70712a252123c40d2adba6a11d84', null, '789', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('11', 'koko', '37f525e2b6fc3cb4abd882f708ab80eb', null, 'lolo', null, '1', '0');
INSERT INTO `tb_sys` VALUES ('12', 'ddd', '77963b7a931377ad4ab5ad6a9cd718aa', null, '1234567', null, '1', '1');

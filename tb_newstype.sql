/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : db_zd

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-06-18 10:05:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_newstype
-- ----------------------------
DROP TABLE IF EXISTS `tb_newstype`;
CREATE TABLE `tb_newstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_newstype
-- ----------------------------
INSERT INTO `tb_newstype` VALUES ('1', '娱乐');
INSERT INTO `tb_newstype` VALUES ('2', '体育');
INSERT INTO `tb_newstype` VALUES ('3', '时事');
INSERT INTO `tb_newstype` VALUES ('7', '你好');
INSERT INTO `tb_newstype` VALUES ('10', 'ddddd');

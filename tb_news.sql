/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : db_zd

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-06-18 10:06:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `publishdt` datetime DEFAULT NULL,
  `comefrom` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES ('3', '1', '派大星你好', '我们都要前进去大海了', '2021-06-11 02:43:13', 'koko');
INSERT INTO `tb_news` VALUES ('13', '1', '蟹老板你好', '蟹老板最爱( $ _ $ )是的没错', '2021-06-16 02:02:56', '比奇堡');
INSERT INTO `tb_news` VALUES ('14', '1', '珊妮早上好1', '松鼠珊妮要成为飞往宇宙的第一只松鼠！！', '2021-06-16 02:21:44', '比奇堡');
INSERT INTO `tb_news` VALUES ('21', null, '章鱼哥你好', '我想邀请你去参加今晚的竖笛演奏表演', '2021-06-18 01:44:33', 'okok');
INSERT INTO `tb_news` VALUES ('22', null, 'klolo', 'dddd', '2021-06-18 01:45:26', 'sssss');

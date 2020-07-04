/*
Navicat MySQL Data Transfer

Source Server         : springboot
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : reserve

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-03-27 16:57:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '2018-03-24');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `start_station` varchar(32) DEFAULT NULL,
  `end_station` varchar(32) DEFAULT NULL,
  `car_trips` varchar(32) DEFAULT NULL,
  `num` int(16) DEFAULT NULL,
  `start_time` varchar(32) DEFAULT NULL,
  `price` double(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '北京', '上海', 'k101', '987', '2018-03-25 09:47:15', '100.00');
INSERT INTO `car` VALUES ('2', '上海', '天津', 'k102', '100', '2018-03-29 10:05:13', '79.50');
INSERT INTO `car` VALUES ('4', '黄山', '香港', 'k121', '40', '2018-03-25 10:45:20', '213.00');
INSERT INTO `car` VALUES ('8', '北京', '香港', 'k121', '40', '2018-03-27 13:54:45', '213.00');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `admin_id` int(32) DEFAULT NULL,
  `admin_name` varchar(32) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `answerDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('5', '231312', '1', 'gaoc', '2018-03-27', '1', 'admin', '23131231', '2018-03-27');
INSERT INTO `message` VALUES ('7', 'mmp', '1', 'gaoc', '2018-03-27', '1', 'admin', 'mmp', '2018-03-27');
INSERT INTO `message` VALUES ('10', '爱编程', '1', 'gaoc', '2018-03-27', '1', 'admin', '牛逼', '2018-03-27');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `admin_id` int(32) DEFAULT NULL,
  `admin_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '停用通知公告', '555555', '2018-03-24', '1', 'admin');
INSERT INTO `notice` VALUES ('4', '交通规则', '213123132131312312313', '2018-03-24', '1', 'admin');
INSERT INTO `notice` VALUES ('7', '北京直通车', '2313123萨达萨达是 爱的阿斯顿阿斯顿阿斯顿撒大苏打收到的', '2018-03-29', '1', 'admin');
INSERT INTO `notice` VALUES ('8', '高速封路', '啊实打实安德森是大神大神大大撒的啊收到阿三是', '2018-03-13', '1', 'admin');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) DEFAULT NULL,
  `car_id` int(32) DEFAULT NULL,
  `num` int(32) DEFAULT NULL,
  `total` double(16,2) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('15', '1', '1', '1', '170.40', '2018-03-27', '99bf3b9a-317f-11e8-9531-047d7b48770f');
INSERT INTO `orders` VALUES ('16', '1', '1', '1', '170.40', '2018-03-27', 'dc0e5dde-317f-11e8-9531-047d7b48770f');
INSERT INTO `orders` VALUES ('17', '1', '1', '1', '170.40', '2018-03-27', '51a8aaf6-3180-11e8-9531-047d7b48770f');
INSERT INTO `orders` VALUES ('18', '1', '7', '1', '170.40', '2018-03-27', '996f24e8-3180-11e8-9531-047d7b48770f');
INSERT INTO `orders` VALUES ('19', '1', '1', '1', '80.00', '2018-03-27', '34d76109-3182-11e8-9531-047d7b48770f');
INSERT INTO `orders` VALUES ('20', '1', '1', '1', '80.00', '2018-03-27', 'f507f981-3182-11e8-9531-047d7b48770f');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `stauts` int(2) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `point` int(32) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'gaoc', '123123', '13111111111', '123@qq.tr', '0', '2018-03-24', '420');
INSERT INTO `user` VALUES ('2', 'zs', '123456', '12313', '123131', '0', '2018-03-22', '40');
INSERT INTO `user` VALUES ('3', 'ls', '123456', '213131', '2131231', '0', '2018-03-28', '60');
INSERT INTO `user` VALUES ('4', 'jw', '11111', '13111111111', '758919089@qq.com', '0', '2018-03-26', '200');
INSERT INTO `user` VALUES ('7', 'qwer', '111111', '13111111111', '123@qq.tr', '0', '2018-03-27', '0');

/*
Navicat MySQL Data Transfer

Source Server         : springboot
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : reserve

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-05 15:02:11
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '2018-03-24');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('5', '231312', '1', 'gaoc', '2018-03-27', '1', 'admin', '23131231', '2018-03-27');
INSERT INTO `message` VALUES ('7', 'mmp', '1', 'gaoc', '2018-03-27', '1', 'admin', 'mmp', '2018-03-27');
INSERT INTO `message` VALUES ('10', '爱编程', '1', 'gaoc', '2018-03-27', '1', 'admin', '牛逼', '2018-03-27');
INSERT INTO `message` VALUES ('11', '能不能便宜点', '8', 'hasak', '2018-04-05', null, null, null, null);
INSERT INTO `message` VALUES ('12', '天气真好', '9', '张三', '2018-04-05', '1', 'admin', '好', '2018-04-05');
INSERT INTO `message` VALUES ('13', '大师傅大师傅士大夫', '10', '李四', '2018-04-05', '1', 'admin', '3333', '2018-04-05');

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
INSERT INTO `notice` VALUES ('7', '北京直通车', '2313123萨达萨达是 爱的阿斯顿阿斯顿阿斯顿撒大苏打收到的', '2018-03-29', '1', 'admin');
INSERT INTO `notice` VALUES ('8', '高速封路', '啊实打实安德森是大神大神大大撒的啊收到阿三是', '2018-03-13', '1', 'admin');
INSERT INTO `notice` VALUES ('9', '车位暂停使用666', '通知u撒谎都系啊好的今属安徽觉得是吧记得把数据库的把就是看', '2018-04-05', '1', 'admin');
INSERT INTO `notice` VALUES ('10', '555', '4444', '2018-04-05', '1', 'admin');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `park_id` int(32) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `status` int(16) DEFAULT NULL,
  `total` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('21', '7188de7f-386b-11e8-9125-047d7b48770f', '8', '1', '2018-04-05', '1', '80');
INSERT INTO `orders` VALUES ('22', '23407dc4-386c-11e8-9125-047d7b48770f', '8', '4', '2018-04-05', '0', '170');
INSERT INTO `orders` VALUES ('24', '17b89a46-386f-11e8-9125-047d7b48770f', '8', '9', '2018-04-05', '0', '70');
INSERT INTO `orders` VALUES ('25', 'd43ec8d3-3879-11e8-9125-047d7b48770f', '9', '10', '2018-04-05', '1', '0');
INSERT INTO `orders` VALUES ('26', '3d1203c6-389c-11e8-9125-047d7b48770f', '10', '1', '2018-04-05', '1', '0');

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `price` double(8,2) DEFAULT NULL,
  `status` int(16) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('1', '车位一', '100.00', '0');
INSERT INTO `park` VALUES ('2', '车位二', '79.50', '0');
INSERT INTO `park` VALUES ('4', '车位三', '213.00', '1');
INSERT INTO `park` VALUES ('8', '车位四', '112.00', '1');
INSERT INTO `park` VALUES ('9', '车位五', '88.00', '1');
INSERT INTO `park` VALUES ('10', '车位六', '998.00', '0');
INSERT INTO `park` VALUES ('11', '车位七', '100.00', '1');
INSERT INTO `park` VALUES ('12', '车位八', '100.00', '0');
INSERT INTO `park` VALUES ('13', '车位九', '90.00', '0');
INSERT INTO `park` VALUES ('14', '车位十', '77.00', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `plate_num` varchar(32) DEFAULT NULL,
  `stauts` int(2) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `point` int(32) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', 'hasak', '12345', '13199889098', '蒙K98981', '1', '2018-04-05', '420');
INSERT INTO `user` VALUES ('9', '张三', '11111', '13111111111', '蒙A11020', '0', '2018-04-05', '10');
INSERT INTO `user` VALUES ('10', '李四', '12345', '13111112222', '蒙A90922', '0', '2018-04-05', '10');

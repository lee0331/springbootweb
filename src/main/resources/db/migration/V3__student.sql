/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 127.0.0.1
 Source Database       : ssm

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 09/30/2017 13:21:23 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `sex` char(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'zxw1', '10', '男'), ('2', 'zxw2', '12', '男'), ('3', 'zxw3', '12', '女'), ('4', 'zxw4', '12', '-'), ('5', 'zxw5', '12', '-');
COMMIT;

-- ----------------------------
--  Table structure for `student_card`
-- ----------------------------
DROP TABLE IF EXISTS `student_card`;
CREATE TABLE `student_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `note` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student_card`
-- ----------------------------
BEGIN;
INSERT INTO `student_card` VALUES ('1', '1', '2012'), ('2', '2', '2013');
COMMIT;

-- ----------------------------
--  Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) NOT NULL,
  `note` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student_course`
-- ----------------------------
BEGIN;
INSERT INTO `student_course` VALUES ('1', '数学', 'maths'), ('2', '语文', 'chinese'), ('3', '英语', 'english');
COMMIT;

-- ----------------------------
--  Table structure for `student_score`
-- ----------------------------
DROP TABLE IF EXISTS `student_score`;
CREATE TABLE `student_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `course_id` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student_score`
-- ----------------------------
BEGIN;
INSERT INTO `student_score` VALUES ('1', '1', '100', '1'), ('2', '1', '98', '2'), ('3', '1', '95', '3'),('4', '2', '98', '1'), ('5', '2', '93', '2'), ('6', '2', '90', '3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

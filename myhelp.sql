/*
Navicat MySQL Data Transfer

Source Server         : dd
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : myhelp

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-11-29 20:45:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `ID` int(20) NOT NULL DEFAULT '0',
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'Tao', 'Zhong', null);
INSERT INTO `employee` VALUES ('2', 'aaa', 'bbb', null);

-- ----------------------------
-- Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `TICKET_ID` int(20) DEFAULT NULL,
  `CREATE_ID` int(20) DEFAULT NULL,
  `RESOLVE_ID` int(20) DEFAULT NULL,
  `CREATE_TIME` date DEFAULT NULL,
  `RESOLVE_TIME` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `history_ibfk_1` (`TICKET_ID`),
  KEY `history_ibfk_2` (`CREATE_ID`),
  KEY `history_ibfk_3` (`RESOLVE_ID`),
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`TICKET_ID`) REFERENCES `ticket` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`CREATE_ID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `history_ibfk_3` FOREIGN KEY (`RESOLVE_ID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('1', '1', '1', '2', '2014-11-04', '2014-11-18');
INSERT INTO `history` VALUES ('2', '2', '1', '2', '2014-11-11', '2014-11-12');
INSERT INTO `history` VALUES ('3', '3', '1', '2', '2014-11-13', '2014-11-14');
INSERT INTO `history` VALUES ('4', '4', '1', '2', '2014-11-18', '2014-11-19');
INSERT INTO `history` VALUES ('5', '5', '1', '2', '2014-11-23', '2014-11-24');
INSERT INTO `history` VALUES ('6', '6', '1', '2', '2014-11-24', '2014-11-25');
INSERT INTO `history` VALUES ('7', '7', '1', '2', '2014-11-24', '2014-11-24');
INSERT INTO `history` VALUES ('8', '8', '1', '2', '2014-11-24', '2014-11-26');
INSERT INTO `history` VALUES ('9', '9', '1', '2', '2014-11-25', '2014-11-25');

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `QUESTION` varchar(255) DEFAULT NULL,
  `ANSWER` varchar(255) DEFAULT NULL,
  `MAX_REPONSE_TIME` int(20) DEFAULT NULL,
  `STATE` bit(1) DEFAULT b'1',
  `CATEGORY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('1', 'aaa', 'bbb', '2', '', 'closed');
INSERT INTO `ticket` VALUES ('2', 'bbb', 'ccc', '2', '', 'closed');
INSERT INTO `ticket` VALUES ('3', 'eeee', 'rrr', '2', '', 'closed');
INSERT INTO `ticket` VALUES ('4', 'e', 'ee', '1', '', 'closed');
INSERT INTO `ticket` VALUES ('5', 'eeeeeee', 'eeedd', '1', '', 'closed');
INSERT INTO `ticket` VALUES ('6', 'test', 'ed', '3', '', 'closed');
INSERT INTO `ticket` VALUES ('7', '333', 'fffff', '1', '', 'processing');
INSERT INTO `ticket` VALUES ('8', 'testquestion', 'ffff', '1', '', 'processing');
INSERT INTO `ticket` VALUES ('9', 'opentest', 'processing', '5', '', 'open');

-- ----------------------------
-- Table structure for `ticketcategory`
-- ----------------------------
DROP TABLE IF EXISTS `ticketcategory`;
CREATE TABLE `ticketcategory` (
  `TICKET_CATEGORY_ID` int(20) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `DESCRIBE` varchar(255) DEFAULT NULL,
  KEY `ticket_category_ibfk_1` (`TICKET_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ticketcategory
-- ----------------------------
INSERT INTO `ticketcategory` VALUES ('1', 'closed', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `ACCOUNTLOCKED` bit(1) DEFAULT NULL,
  `ROLE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a', 'b', '', 'employee');
INSERT INTO `user` VALUES ('2', 'b', 'c', '', 'support');

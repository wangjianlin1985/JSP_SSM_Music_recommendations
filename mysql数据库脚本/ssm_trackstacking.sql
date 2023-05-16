/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : ssm_trackstacking

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2020-01-14 19:08:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collectionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  PRIMARY KEY (`collectionId`),
  KEY `fk_collection_1_idx` (`userId`),
  KEY `fk_collection_2_idx` (`songId`),
  CONSTRAINT `fk_collection_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_collection_2` FOREIGN KEY (`songId`) REFERENCES `song` (`songId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('176', '2', '3');
INSERT INTO `collection` VALUES ('180', '5', '207');
INSERT INTO `collection` VALUES ('181', '5', '192');
INSERT INTO `collection` VALUES ('182', '5', '230');
INSERT INTO `collection` VALUES ('183', '5', '224');
INSERT INTO `collection` VALUES ('184', '5', '1');
INSERT INTO `collection` VALUES ('185', '5', '239');
INSERT INTO `collection` VALUES ('186', '5', '234');
INSERT INTO `collection` VALUES ('187', '5', '228');
INSERT INTO `collection` VALUES ('188', '5', '220');
INSERT INTO `collection` VALUES ('189', '5', '198');
INSERT INTO `collection` VALUES ('190', '5', '212');
INSERT INTO `collection` VALUES ('193', '7', '1');
INSERT INTO `collection` VALUES ('194', '7', '198');
INSERT INTO `collection` VALUES ('195', '7', '239');
INSERT INTO `collection` VALUES ('203', '1', '2');
INSERT INTO `collection` VALUES ('204', '2011228', '239');

-- ----------------------------
-- Table structure for `download`
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download` (
  `downloadId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  `downloadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`downloadId`),
  KEY `fk_download_1_idx` (`userId`),
  KEY `fk_download_2_idx` (`songId`),
  CONSTRAINT `fk_download_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_download_2` FOREIGN KEY (`songId`) REFERENCES `song` (`songId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of download
-- ----------------------------
INSERT INTO `download` VALUES ('1', '1', '3', '2018-04-30 20:50:13');
INSERT INTO `download` VALUES ('2', '1', '1', '2018-04-30 21:28:21');
INSERT INTO `download` VALUES ('3', '1', '1', '2018-04-30 21:28:21');
INSERT INTO `download` VALUES ('4', '1', '3', '2018-05-01 09:32:18');
INSERT INTO `download` VALUES ('5', '1', '3', '2018-05-02 18:04:47');
INSERT INTO `download` VALUES ('6', '5', '207', '2018-05-03 23:18:40');
INSERT INTO `download` VALUES ('7', '5', '207', '2018-05-03 23:18:44');
INSERT INTO `download` VALUES ('8', '5', '207', '2018-05-03 23:18:59');
INSERT INTO `download` VALUES ('10', '1', '1', '2018-05-06 18:08:54');
INSERT INTO `download` VALUES ('11', '1', '3', '2018-05-06 19:09:12');
INSERT INTO `download` VALUES ('12', '1', '1', '2018-05-06 19:09:18');
INSERT INTO `download` VALUES ('13', '1', '3', '2018-05-29 11:52:51');
INSERT INTO `download` VALUES ('14', '1', '2', '2018-05-29 11:53:03');
INSERT INTO `download` VALUES ('15', '2011228', '1', '2019-08-01 17:29:38');

-- ----------------------------
-- Table structure for `liking`
-- ----------------------------
DROP TABLE IF EXISTS `liking`;
CREATE TABLE `liking` (
  `likeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `reviewId` int(11) NOT NULL,
  PRIMARY KEY (`likeId`),
  KEY `fk_like_1_idx` (`userId`),
  KEY `fk_like_2_idx` (`reviewId`),
  CONSTRAINT `fk_like_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_2` FOREIGN KEY (`reviewId`) REFERENCES `review` (`reviewId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=224 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of liking
-- ----------------------------
INSERT INTO `liking` VALUES ('170', '1', '3');
INSERT INTO `liking` VALUES ('171', '15', '3');
INSERT INTO `liking` VALUES ('222', '15', '6');
INSERT INTO `liking` VALUES ('223', '2011228', '16');

-- ----------------------------
-- Table structure for `play`
-- ----------------------------
DROP TABLE IF EXISTS `play`;
CREATE TABLE `play` (
  `playId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  `playTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`playId`),
  KEY `fk_play_1_idx` (`userId`),
  KEY `fk_play_2_idx` (`songId`),
  CONSTRAINT `fk_play_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_play_2` FOREIGN KEY (`songId`) REFERENCES `song` (`songId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of play
-- ----------------------------
INSERT INTO `play` VALUES ('1', '1', '1', '2018-04-29 20:50:27');
INSERT INTO `play` VALUES ('2', '1', '3', '2018-04-29 20:51:31');
INSERT INTO `play` VALUES ('3', '2', '3', '2018-04-29 23:58:03');
INSERT INTO `play` VALUES ('4', '1', '3', '2018-04-30 19:39:32');
INSERT INTO `play` VALUES ('5', '1', '3', '2018-04-30 19:40:24');
INSERT INTO `play` VALUES ('6', '1', '3', '2018-04-30 19:43:50');
INSERT INTO `play` VALUES ('7', '1', '3', '2018-04-30 19:46:00');
INSERT INTO `play` VALUES ('8', '1', '3', '2018-04-30 19:46:16');
INSERT INTO `play` VALUES ('9', '1', '3', '2018-04-30 19:46:25');
INSERT INTO `play` VALUES ('10', '1', '3', '2018-04-30 19:46:57');
INSERT INTO `play` VALUES ('11', '1', '1', '2018-04-30 19:50:37');
INSERT INTO `play` VALUES ('12', '1', '3', '2018-04-30 19:54:51');
INSERT INTO `play` VALUES ('13', '1', '3', '2018-04-30 19:54:57');
INSERT INTO `play` VALUES ('14', '1', '3', '2018-04-30 19:55:01');
INSERT INTO `play` VALUES ('15', '1', '3', '2018-04-30 19:55:10');
INSERT INTO `play` VALUES ('16', '1', '1', '2018-04-30 20:59:35');
INSERT INTO `play` VALUES ('17', '1', '3', '2018-04-30 21:05:38');
INSERT INTO `play` VALUES ('18', '1', '3', '2018-05-01 09:32:15');
INSERT INTO `play` VALUES ('19', '1', '1', '2018-05-02 15:06:10');
INSERT INTO `play` VALUES ('20', '1', '3', '2018-05-02 15:06:12');
INSERT INTO `play` VALUES ('21', '1', '3', '2018-05-02 15:06:16');
INSERT INTO `play` VALUES ('22', '1', '1', '2018-05-02 15:06:19');
INSERT INTO `play` VALUES ('23', '1', '3', '2018-05-02 15:06:20');
INSERT INTO `play` VALUES ('24', '1', '3', '2018-05-02 18:04:44');
INSERT INTO `play` VALUES ('25', '2', '3', '2018-05-02 19:10:33');
INSERT INTO `play` VALUES ('26', '2', '3', '2018-05-02 19:11:08');
INSERT INTO `play` VALUES ('27', '1', '3', '2018-05-03 10:45:43');
INSERT INTO `play` VALUES ('28', '1', '239', '2018-05-03 10:47:52');
INSERT INTO `play` VALUES ('29', '1', '3', '2018-05-03 10:48:10');
INSERT INTO `play` VALUES ('30', '1', '239', '2018-05-03 10:49:17');
INSERT INTO `play` VALUES ('31', '1', '240', '2018-05-03 10:50:36');
INSERT INTO `play` VALUES ('32', '4', '229', '2018-05-03 17:53:27');
INSERT INTO `play` VALUES ('33', '5', '207', '2018-05-03 23:18:19');
INSERT INTO `play` VALUES ('34', '5', '192', '2018-05-03 23:20:05');
INSERT INTO `play` VALUES ('35', '5', '1', '2018-05-03 23:21:38');
INSERT INTO `play` VALUES ('36', '5', '239', '2018-05-03 23:21:51');
INSERT INTO `play` VALUES ('37', '5', '234', '2018-05-03 23:21:58');
INSERT INTO `play` VALUES ('38', '5', '228', '2018-05-03 23:22:13');
INSERT INTO `play` VALUES ('39', '5', '220', '2018-05-03 23:22:25');
INSERT INTO `play` VALUES ('40', '5', '209', '2018-05-03 23:22:33');
INSERT INTO `play` VALUES ('41', '5', '198', '2018-05-03 23:22:44');
INSERT INTO `play` VALUES ('42', '5', '193', '2018-05-03 23:23:58');
INSERT INTO `play` VALUES ('43', '1', '1', '2018-05-03 23:32:24');
INSERT INTO `play` VALUES ('44', '1', '1', '2018-05-03 23:41:21');
INSERT INTO `play` VALUES ('45', '1', '209', '2018-05-03 23:41:35');
INSERT INTO `play` VALUES ('46', '6', '3', '2018-05-03 23:49:31');
INSERT INTO `play` VALUES ('47', '1', '198', '2018-05-03 23:50:38');
INSERT INTO `play` VALUES ('48', '1', '1', '2018-05-03 23:53:19');
INSERT INTO `play` VALUES ('49', '7', '3', '2018-05-04 00:23:45');
INSERT INTO `play` VALUES ('50', '7', '239', '2018-05-04 00:24:44');
INSERT INTO `play` VALUES ('51', '7', '239', '2018-05-04 00:25:12');
INSERT INTO `play` VALUES ('52', '7', '3', '2018-05-04 00:25:31');
INSERT INTO `play` VALUES ('53', '7', '1', '2018-05-04 00:25:34');
INSERT INTO `play` VALUES ('54', '7', '1', '2018-05-04 00:28:23');
INSERT INTO `play` VALUES ('55', '1', '198', '2018-05-04 00:30:41');
INSERT INTO `play` VALUES ('56', '1', '239', '2018-05-04 00:32:41');
INSERT INTO `play` VALUES ('57', '1', '229', '2018-05-04 00:33:00');
INSERT INTO `play` VALUES ('58', '8', '220', '2018-05-04 08:21:39');
INSERT INTO `play` VALUES ('59', '8', '239', '2018-05-04 08:34:39');
INSERT INTO `play` VALUES ('60', '8', '240', '2018-05-04 08:34:40');
INSERT INTO `play` VALUES ('61', '1', '207', '2018-05-06 11:49:13');
INSERT INTO `play` VALUES ('62', '1', '2', '2018-05-06 14:51:43');
INSERT INTO `play` VALUES ('128', '1', '220', '2018-05-06 17:50:17');
INSERT INTO `play` VALUES ('129', '1', '1', '2018-05-06 17:50:20');
INSERT INTO `play` VALUES ('130', '1', '1', '2018-05-06 17:50:25');
INSERT INTO `play` VALUES ('131', '1', '3', '2018-05-06 17:53:25');
INSERT INTO `play` VALUES ('132', '1', '193', '2018-05-06 17:53:28');
INSERT INTO `play` VALUES ('133', '1', '233', '2018-05-06 17:53:31');
INSERT INTO `play` VALUES ('134', '1', '198', '2018-05-06 17:53:55');
INSERT INTO `play` VALUES ('135', '1', '220', '2018-05-06 17:54:03');
INSERT INTO `play` VALUES ('136', '1', '3', '2018-05-06 17:54:17');
INSERT INTO `play` VALUES ('137', '1', '240', '2018-05-06 17:54:28');
INSERT INTO `play` VALUES ('138', '1', '193', '2018-05-06 17:54:37');
INSERT INTO `play` VALUES ('139', '1', '193', '2018-05-06 17:55:03');
INSERT INTO `play` VALUES ('140', '1', '193', '2018-05-06 17:55:03');
INSERT INTO `play` VALUES ('141', '1', '193', '2018-05-06 17:55:04');
INSERT INTO `play` VALUES ('142', '1', '228', '2018-05-06 17:55:06');
INSERT INTO `play` VALUES ('143', '1', '220', '2018-05-06 17:55:23');
INSERT INTO `play` VALUES ('144', '1', '193', '2018-05-06 17:56:07');
INSERT INTO `play` VALUES ('145', '1', '3', '2018-05-06 17:56:11');
INSERT INTO `play` VALUES ('146', '1', '240', '2018-05-06 17:57:10');
INSERT INTO `play` VALUES ('147', '1', '228', '2018-05-06 17:57:13');
INSERT INTO `play` VALUES ('148', '1', '220', '2018-05-06 17:57:59');
INSERT INTO `play` VALUES ('149', '1', '239', '2018-05-06 17:58:03');
INSERT INTO `play` VALUES ('150', '1', '1', '2018-05-06 17:58:22');
INSERT INTO `play` VALUES ('151', '1', '239', '2018-05-06 17:59:15');
INSERT INTO `play` VALUES ('152', '1', '3', '2018-05-06 17:59:18');
INSERT INTO `play` VALUES ('153', '1', '193', '2018-05-06 17:59:22');
INSERT INTO `play` VALUES ('154', '1', '3', '2018-05-06 18:00:58');
INSERT INTO `play` VALUES ('155', '1', '228', '2018-05-06 18:01:02');
INSERT INTO `play` VALUES ('156', '1', '233', '2018-05-06 18:05:42');
INSERT INTO `play` VALUES ('157', '1', '239', '2018-05-06 18:07:15');
INSERT INTO `play` VALUES ('158', '1', '220', '2018-05-06 18:14:53');
INSERT INTO `play` VALUES ('159', '1', '3', '2018-05-06 18:15:38');
INSERT INTO `play` VALUES ('160', '1', '3', '2018-05-06 18:17:43');
INSERT INTO `play` VALUES ('161', '1', '3', '2018-05-06 18:18:48');
INSERT INTO `play` VALUES ('162', '1', '3', '2018-05-06 18:20:13');
INSERT INTO `play` VALUES ('163', '1', '3', '2018-05-06 18:21:37');
INSERT INTO `play` VALUES ('164', '1', '2', '2018-05-06 18:23:28');
INSERT INTO `play` VALUES ('165', '1', '2', '2018-05-06 18:24:07');
INSERT INTO `play` VALUES ('166', '1', '3', '2018-05-06 18:33:26');
INSERT INTO `play` VALUES ('167', '1', '3', '2018-05-06 18:36:31');
INSERT INTO `play` VALUES ('168', '1', '2', '2018-05-06 18:39:13');
INSERT INTO `play` VALUES ('169', '1', '2', '2018-05-06 18:39:30');
INSERT INTO `play` VALUES ('170', '1', '2', '2018-05-06 18:39:48');
INSERT INTO `play` VALUES ('171', '1', '2', '2018-05-06 18:45:50');
INSERT INTO `play` VALUES ('172', '1', '2', '2018-05-06 18:46:39');
INSERT INTO `play` VALUES ('173', '1', '2', '2018-05-06 18:48:35');
INSERT INTO `play` VALUES ('174', '1', '1', '2018-05-06 18:50:38');
INSERT INTO `play` VALUES ('175', '1', '2', '2018-05-06 18:52:46');
INSERT INTO `play` VALUES ('176', '1', '193', '2018-05-06 18:52:49');
INSERT INTO `play` VALUES ('177', '1', '2', '2018-05-06 18:53:01');
INSERT INTO `play` VALUES ('178', '1', '3', '2018-05-06 18:55:28');
INSERT INTO `play` VALUES ('179', '1', '193', '2018-05-06 18:55:38');
INSERT INTO `play` VALUES ('180', '1', '1', '2018-05-06 18:55:43');
INSERT INTO `play` VALUES ('181', '1', '2', '2018-05-06 18:55:46');
INSERT INTO `play` VALUES ('182', '1', '240', '2018-05-06 18:56:42');
INSERT INTO `play` VALUES ('183', '1', '3', '2018-05-06 19:00:24');
INSERT INTO `play` VALUES ('184', '1', '1', '2018-05-06 19:00:37');
INSERT INTO `play` VALUES ('185', '1', '3', '2018-05-06 19:09:10');
INSERT INTO `play` VALUES ('186', '1', '234', '2018-05-06 19:09:43');
INSERT INTO `play` VALUES ('187', '1', '3', '2018-05-06 19:09:56');
INSERT INTO `play` VALUES ('188', '1', '1', '2018-05-06 19:09:59');
INSERT INTO `play` VALUES ('189', '1', '1', '2018-05-06 19:10:16');
INSERT INTO `play` VALUES ('190', '1', '1', '2018-05-06 19:10:51');
INSERT INTO `play` VALUES ('191', '1', '193', '2018-05-06 19:22:51');
INSERT INTO `play` VALUES ('192', '1', '1', '2018-05-06 19:22:53');
INSERT INTO `play` VALUES ('193', '1', '240', '2018-05-06 19:26:45');
INSERT INTO `play` VALUES ('194', '1', '239', '2018-05-06 19:26:46');
INSERT INTO `play` VALUES ('195', '1', '2', '2018-05-06 19:26:58');
INSERT INTO `play` VALUES ('196', '1', '1', '2018-05-06 19:27:19');
INSERT INTO `play` VALUES ('197', '1', '2', '2018-05-06 19:27:33');
INSERT INTO `play` VALUES ('198', '1', '3', '2018-05-06 19:27:43');
INSERT INTO `play` VALUES ('199', '1', '1', '2018-05-06 19:43:59');
INSERT INTO `play` VALUES ('200', '1', '3', '2018-05-06 19:44:17');
INSERT INTO `play` VALUES ('201', '1', '2', '2018-05-06 19:44:22');
INSERT INTO `play` VALUES ('202', '1', '2', '2018-05-06 19:45:56');
INSERT INTO `play` VALUES ('203', '1', '2', '2018-05-06 20:20:27');
INSERT INTO `play` VALUES ('204', '1', '2', '2018-05-06 20:29:18');
INSERT INTO `play` VALUES ('205', '1', '3', '2018-05-07 11:55:44');
INSERT INTO `play` VALUES ('206', '1', '3', '2018-05-28 14:46:46');
INSERT INTO `play` VALUES ('207', '1', '2', '2018-05-28 14:46:49');
INSERT INTO `play` VALUES ('208', '1', '1', '2018-05-28 14:46:51');
INSERT INTO `play` VALUES ('209', '1', '1', '2018-05-28 15:16:23');
INSERT INTO `play` VALUES ('210', '1', '1', '2018-05-28 16:06:09');
INSERT INTO `play` VALUES ('211', '1', '1', '2018-05-28 16:11:39');
INSERT INTO `play` VALUES ('212', '1', '1', '2018-05-28 17:11:10');
INSERT INTO `play` VALUES ('213', '1', '2', '2018-05-29 11:52:41');
INSERT INTO `play` VALUES ('214', '1', '2', '2018-05-29 11:53:00');
INSERT INTO `play` VALUES ('215', '1', '3', '2018-05-30 21:48:47');
INSERT INTO `play` VALUES ('216', '1', '2', '2018-06-07 21:37:26');
INSERT INTO `play` VALUES ('217', '1', '1', '2018-06-07 21:38:06');
INSERT INTO `play` VALUES ('219', '2011227', '245', '2020-01-07 21:41:53');
INSERT INTO `play` VALUES ('220', '2011227', '245', '2020-01-14 17:30:14');
INSERT INTO `play` VALUES ('221', '2011227', '245', '2020-01-14 18:52:00');

-- ----------------------------
-- Table structure for `reca`
-- ----------------------------
DROP TABLE IF EXISTS `reca`;
CREATE TABLE `reca` (
  `recId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  PRIMARY KEY (`recId`),
  KEY `fk_reca_1_idx` (`userId`),
  KEY `fk_reca_2_idx` (`songId`),
  CONSTRAINT `fk_reca_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_reca_2` FOREIGN KEY (`songId`) REFERENCES `song` (`songId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18781 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reca
-- ----------------------------
INSERT INTO `reca` VALUES ('18671', '1', '5');
INSERT INTO `reca` VALUES ('18672', '1', '7');
INSERT INTO `reca` VALUES ('18673', '1', '6');
INSERT INTO `reca` VALUES ('18674', '1', '11');
INSERT INTO `reca` VALUES ('18675', '1', '8');
INSERT INTO `reca` VALUES ('18676', '1', '9');
INSERT INTO `reca` VALUES ('18677', '1', '10');
INSERT INTO `reca` VALUES ('18678', '1', '245');
INSERT INTO `reca` VALUES ('18679', '1', '12');
INSERT INTO `reca` VALUES ('18680', '1', '13');
INSERT INTO `reca` VALUES ('18681', '2011228', '207');
INSERT INTO `reca` VALUES ('18682', '2011228', '233');
INSERT INTO `reca` VALUES ('18683', '2011228', '229');
INSERT INTO `reca` VALUES ('18684', '2011228', '193');
INSERT INTO `reca` VALUES ('18685', '2011228', '240');
INSERT INTO `reca` VALUES ('18686', '2011228', '220');
INSERT INTO `reca` VALUES ('18687', '2011228', '228');
INSERT INTO `reca` VALUES ('18688', '2011228', '3');
INSERT INTO `reca` VALUES ('18689', '2011228', '2');
INSERT INTO `reca` VALUES ('18690', '2011228', '198');
INSERT INTO `reca` VALUES ('18691', '2', '233');
INSERT INTO `reca` VALUES ('18692', '2', '240');
INSERT INTO `reca` VALUES ('18693', '2', '228');
INSERT INTO `reca` VALUES ('18694', '2', '1');
INSERT INTO `reca` VALUES ('18695', '2', '198');
INSERT INTO `reca` VALUES ('18696', '2', '220');
INSERT INTO `reca` VALUES ('18697', '2', '229');
INSERT INTO `reca` VALUES ('18698', '2', '2');
INSERT INTO `reca` VALUES ('18699', '2', '193');
INSERT INTO `reca` VALUES ('18700', '2', '239');
INSERT INTO `reca` VALUES ('18701', '4', '4');
INSERT INTO `reca` VALUES ('18702', '4', '8');
INSERT INTO `reca` VALUES ('18703', '4', '6');
INSERT INTO `reca` VALUES ('18704', '4', '9');
INSERT INTO `reca` VALUES ('18705', '4', '5');
INSERT INTO `reca` VALUES ('18706', '4', '3');
INSERT INTO `reca` VALUES ('18707', '4', '7');
INSERT INTO `reca` VALUES ('18708', '4', '1');
INSERT INTO `reca` VALUES ('18709', '4', '239');
INSERT INTO `reca` VALUES ('18710', '4', '10');
INSERT INTO `reca` VALUES ('18711', '2011227', '233');
INSERT INTO `reca` VALUES ('18712', '2011227', '198');
INSERT INTO `reca` VALUES ('18713', '2011227', '228');
INSERT INTO `reca` VALUES ('18714', '2011227', '193');
INSERT INTO `reca` VALUES ('18715', '2011227', '240');
INSERT INTO `reca` VALUES ('18716', '2011227', '3');
INSERT INTO `reca` VALUES ('18717', '2011227', '220');
INSERT INTO `reca` VALUES ('18718', '2011227', '2');
INSERT INTO `reca` VALUES ('18719', '2011227', '1');
INSERT INTO `reca` VALUES ('18720', '2011227', '239');
INSERT INTO `reca` VALUES ('18721', '5', '5');
INSERT INTO `reca` VALUES ('18722', '5', '9');
INSERT INTO `reca` VALUES ('18723', '5', '4');
INSERT INTO `reca` VALUES ('18724', '5', '10');
INSERT INTO `reca` VALUES ('18725', '5', '6');
INSERT INTO `reca` VALUES ('18726', '5', '7');
INSERT INTO `reca` VALUES ('18727', '5', '8');
INSERT INTO `reca` VALUES ('18728', '5', '3');
INSERT INTO `reca` VALUES ('18729', '5', '229');
INSERT INTO `reca` VALUES ('18730', '5', '11');
INSERT INTO `reca` VALUES ('18731', '6', '229');
INSERT INTO `reca` VALUES ('18732', '6', '233');
INSERT INTO `reca` VALUES ('18733', '6', '228');
INSERT INTO `reca` VALUES ('18734', '6', '193');
INSERT INTO `reca` VALUES ('18735', '6', '198');
INSERT INTO `reca` VALUES ('18736', '6', '220');
INSERT INTO `reca` VALUES ('18737', '6', '240');
INSERT INTO `reca` VALUES ('18738', '6', '2');
INSERT INTO `reca` VALUES ('18739', '6', '1');
INSERT INTO `reca` VALUES ('18740', '6', '239');
INSERT INTO `reca` VALUES ('18741', '7', '4');
INSERT INTO `reca` VALUES ('18742', '7', '6');
INSERT INTO `reca` VALUES ('18743', '7', '5');
INSERT INTO `reca` VALUES ('18744', '7', '10');
INSERT INTO `reca` VALUES ('18745', '7', '7');
INSERT INTO `reca` VALUES ('18746', '7', '8');
INSERT INTO `reca` VALUES ('18747', '7', '9');
INSERT INTO `reca` VALUES ('18748', '7', '229');
INSERT INTO `reca` VALUES ('18749', '7', '11');
INSERT INTO `reca` VALUES ('18750', '7', '12');
INSERT INTO `reca` VALUES ('18751', '8', '212');
INSERT INTO `reca` VALUES ('18752', '8', '192');
INSERT INTO `reca` VALUES ('18753', '8', '234');
INSERT INTO `reca` VALUES ('18754', '8', '2');
INSERT INTO `reca` VALUES ('18755', '8', '198');
INSERT INTO `reca` VALUES ('18756', '8', '3');
INSERT INTO `reca` VALUES ('18757', '8', '228');
INSERT INTO `reca` VALUES ('18758', '8', '207');
INSERT INTO `reca` VALUES ('18759', '8', '1');
INSERT INTO `reca` VALUES ('18760', '8', '193');
INSERT INTO `reca` VALUES ('18761', '9', '233');
INSERT INTO `reca` VALUES ('18762', '9', '198');
INSERT INTO `reca` VALUES ('18763', '9', '228');
INSERT INTO `reca` VALUES ('18764', '9', '1');
INSERT INTO `reca` VALUES ('18765', '9', '240');
INSERT INTO `reca` VALUES ('18766', '9', '3');
INSERT INTO `reca` VALUES ('18767', '9', '220');
INSERT INTO `reca` VALUES ('18768', '9', '2');
INSERT INTO `reca` VALUES ('18769', '9', '193');
INSERT INTO `reca` VALUES ('18770', '9', '239');
INSERT INTO `reca` VALUES ('18771', '15', '233');
INSERT INTO `reca` VALUES ('18772', '15', '198');
INSERT INTO `reca` VALUES ('18773', '15', '228');
INSERT INTO `reca` VALUES ('18774', '15', '1');
INSERT INTO `reca` VALUES ('18775', '15', '240');
INSERT INTO `reca` VALUES ('18776', '15', '3');
INSERT INTO `reca` VALUES ('18777', '15', '220');
INSERT INTO `reca` VALUES ('18778', '15', '2');
INSERT INTO `reca` VALUES ('18779', '15', '193');
INSERT INTO `reca` VALUES ('18780', '15', '239');

-- ----------------------------
-- Table structure for `recb`
-- ----------------------------
DROP TABLE IF EXISTS `recb`;
CREATE TABLE `recb` (
  `recId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  PRIMARY KEY (`recId`),
  KEY `fk_recb_1_idx` (`userId`),
  KEY `fk_recb_2_idx` (`songId`),
  CONSTRAINT `fk_recb_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_recb_2` FOREIGN KEY (`songId`) REFERENCES `song` (`songId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6731 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recb
-- ----------------------------
INSERT INTO `recb` VALUES ('6611', '1', '4');
INSERT INTO `recb` VALUES ('6612', '1', '5');
INSERT INTO `recb` VALUES ('6613', '1', '6');
INSERT INTO `recb` VALUES ('6614', '1', '7');
INSERT INTO `recb` VALUES ('6615', '1', '8');
INSERT INTO `recb` VALUES ('6616', '1', '9');
INSERT INTO `recb` VALUES ('6617', '1', '10');
INSERT INTO `recb` VALUES ('6618', '1', '11');
INSERT INTO `recb` VALUES ('6619', '1', '12');
INSERT INTO `recb` VALUES ('6620', '1', '13');
INSERT INTO `recb` VALUES ('6621', '2', '224');
INSERT INTO `recb` VALUES ('6622', '2', '234');
INSERT INTO `recb` VALUES ('6623', '2', '212');
INSERT INTO `recb` VALUES ('6624', '2', '228');
INSERT INTO `recb` VALUES ('6625', '2', '198');
INSERT INTO `recb` VALUES ('6626', '2', '239');
INSERT INTO `recb` VALUES ('6627', '2', '220');
INSERT INTO `recb` VALUES ('6628', '2', '1');
INSERT INTO `recb` VALUES ('6629', '2', '192');
INSERT INTO `recb` VALUES ('6630', '2', '207');
INSERT INTO `recb` VALUES ('6631', '4', '212');
INSERT INTO `recb` VALUES ('6632', '4', '234');
INSERT INTO `recb` VALUES ('6633', '4', '239');
INSERT INTO `recb` VALUES ('6634', '4', '228');
INSERT INTO `recb` VALUES ('6635', '4', '198');
INSERT INTO `recb` VALUES ('6636', '4', '3');
INSERT INTO `recb` VALUES ('6637', '4', '220');
INSERT INTO `recb` VALUES ('6638', '4', '1');
INSERT INTO `recb` VALUES ('6639', '4', '192');
INSERT INTO `recb` VALUES ('6640', '4', '207');
INSERT INTO `recb` VALUES ('6641', '5', '5');
INSERT INTO `recb` VALUES ('6642', '5', '9');
INSERT INTO `recb` VALUES ('6643', '5', '4');
INSERT INTO `recb` VALUES ('6644', '5', '10');
INSERT INTO `recb` VALUES ('6645', '5', '6');
INSERT INTO `recb` VALUES ('6646', '5', '7');
INSERT INTO `recb` VALUES ('6647', '5', '8');
INSERT INTO `recb` VALUES ('6648', '5', '3');
INSERT INTO `recb` VALUES ('6649', '5', '229');
INSERT INTO `recb` VALUES ('6650', '5', '11');
INSERT INTO `recb` VALUES ('6651', '2011227', '233');
INSERT INTO `recb` VALUES ('6652', '2011227', '198');
INSERT INTO `recb` VALUES ('6653', '2011227', '228');
INSERT INTO `recb` VALUES ('6654', '2011227', '193');
INSERT INTO `recb` VALUES ('6655', '2011227', '240');
INSERT INTO `recb` VALUES ('6656', '2011227', '3');
INSERT INTO `recb` VALUES ('6657', '2011227', '220');
INSERT INTO `recb` VALUES ('6658', '2011227', '2');
INSERT INTO `recb` VALUES ('6659', '2011227', '1');
INSERT INTO `recb` VALUES ('6660', '2011227', '239');
INSERT INTO `recb` VALUES ('6661', '6', '240');
INSERT INTO `recb` VALUES ('6662', '6', '207');
INSERT INTO `recb` VALUES ('6663', '6', '234');
INSERT INTO `recb` VALUES ('6664', '6', '2');
INSERT INTO `recb` VALUES ('6665', '6', '198');
INSERT INTO `recb` VALUES ('6666', '6', '220');
INSERT INTO `recb` VALUES ('6667', '6', '228');
INSERT INTO `recb` VALUES ('6668', '6', '239');
INSERT INTO `recb` VALUES ('6669', '6', '1');
INSERT INTO `recb` VALUES ('6670', '6', '193');
INSERT INTO `recb` VALUES ('6671', '7', '209');
INSERT INTO `recb` VALUES ('6672', '7', '230');
INSERT INTO `recb` VALUES ('6673', '7', '229');
INSERT INTO `recb` VALUES ('6674', '7', '220');
INSERT INTO `recb` VALUES ('6675', '7', '212');
INSERT INTO `recb` VALUES ('6676', '7', '224');
INSERT INTO `recb` VALUES ('6677', '7', '228');
INSERT INTO `recb` VALUES ('6678', '7', '192');
INSERT INTO `recb` VALUES ('6679', '7', '207');
INSERT INTO `recb` VALUES ('6680', '7', '234');
INSERT INTO `recb` VALUES ('6681', '8', '212');
INSERT INTO `recb` VALUES ('6682', '8', '192');
INSERT INTO `recb` VALUES ('6683', '8', '234');
INSERT INTO `recb` VALUES ('6684', '8', '2');
INSERT INTO `recb` VALUES ('6685', '8', '198');
INSERT INTO `recb` VALUES ('6686', '8', '3');
INSERT INTO `recb` VALUES ('6687', '8', '228');
INSERT INTO `recb` VALUES ('6688', '8', '207');
INSERT INTO `recb` VALUES ('6689', '8', '1');
INSERT INTO `recb` VALUES ('6690', '8', '193');
INSERT INTO `recb` VALUES ('6691', '9', '233');
INSERT INTO `recb` VALUES ('6692', '9', '198');
INSERT INTO `recb` VALUES ('6693', '9', '228');
INSERT INTO `recb` VALUES ('6694', '9', '193');
INSERT INTO `recb` VALUES ('6695', '9', '240');
INSERT INTO `recb` VALUES ('6696', '9', '3');
INSERT INTO `recb` VALUES ('6697', '9', '220');
INSERT INTO `recb` VALUES ('6698', '9', '2');
INSERT INTO `recb` VALUES ('6699', '9', '1');
INSERT INTO `recb` VALUES ('6700', '9', '239');
INSERT INTO `recb` VALUES ('6701', '15', '233');
INSERT INTO `recb` VALUES ('6702', '15', '198');
INSERT INTO `recb` VALUES ('6703', '15', '228');
INSERT INTO `recb` VALUES ('6704', '15', '193');
INSERT INTO `recb` VALUES ('6705', '15', '240');
INSERT INTO `recb` VALUES ('6706', '15', '3');
INSERT INTO `recb` VALUES ('6707', '15', '220');
INSERT INTO `recb` VALUES ('6708', '15', '2');
INSERT INTO `recb` VALUES ('6709', '15', '1');
INSERT INTO `recb` VALUES ('6710', '15', '239');
INSERT INTO `recb` VALUES ('6721', '2011228', '202');
INSERT INTO `recb` VALUES ('6722', '2011228', '201');
INSERT INTO `recb` VALUES ('6723', '2011228', '235');
INSERT INTO `recb` VALUES ('6724', '2011228', '240');
INSERT INTO `recb` VALUES ('6725', '2011228', '229');
INSERT INTO `recb` VALUES ('6726', '2011228', '200');
INSERT INTO `recb` VALUES ('6727', '2011228', '228');
INSERT INTO `recb` VALUES ('6728', '2011228', '227');
INSERT INTO `recb` VALUES ('6729', '2011228', '198');
INSERT INTO `recb` VALUES ('6730', '2011228', '205');

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `reviewId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `songId` int(11) NOT NULL,
  `review` varchar(140) NOT NULL,
  `reviewTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reviewId`),
  KEY `fk_review_1_idx` (`userId`),
  KEY `fk_review_2_idx` (`songId`),
  CONSTRAINT `fk_review_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_2` FOREIGN KEY (`songId`) REFERENCES `song` (`songId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('1', '1', '3', '呵呵，楼上的真搞笑，这个评论模板的插件好丑陋，简直丑爆了，我简单做的都比这个好，信不信，我分分钟肥腻做出来一个，吓屎你们这群都比', '2018-05-30 11:44:40');
INSERT INTO `review` VALUES ('2', '2', '3', '这才是真正的冷门好歌', '2018-05-30 11:48:33');
INSERT INTO `review` VALUES ('3', '4', '3', '人生百年，谁不曾大闹天宫，谁不曾头上紧箍，谁不曾爱上层楼，谁不曾孤单上路。', '2018-05-30 11:50:20');
INSERT INTO `review` VALUES ('4', '15', '3', '有时候，你选择与某人保持距离，不是因为不在乎，而是因为你清楚的知道，她不属于你。人生遇到的每个人，出场顺序真的很重要，很多人如果换一个时间认识，就会有不同的结局。或许，有些爱，只能止于唇齿，掩于岁月！', '2018-05-30 11:53:11');
INSERT INTO `review` VALUES ('5', '1', '1', '紫棋自己的味道，很好听。欣赏她的才华与实力，加油！', '2018-05-30 23:40:05');
INSERT INTO `review` VALUES ('6', '15', '1', '还记得曾经有个人对我唱，“喜欢你”，当时，我并不知道。', '2018-05-30 23:41:54');
INSERT INTO `review` VALUES ('12', '1', '3', '精彩精彩精彩精彩精彩精彩精彩精彩', '2018-06-01 21:25:25');
INSERT INTO `review` VALUES ('14', '1', '3', '精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩精彩', '2018-06-01 21:25:36');
INSERT INTO `review` VALUES ('15', '1', '3', '精彩', '2018-06-01 21:25:40');
INSERT INTO `review` VALUES ('16', '2011228', '2', '好听好听好听好听好听', '2019-08-01 17:30:33');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for `song`
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `songId` int(11) NOT NULL AUTO_INCREMENT,
  `songName` varchar(45) NOT NULL,
  `songAddress` varchar(255) NOT NULL,
  `songCoverAddress` varchar(255) DEFAULT NULL,
  `songType` varchar(45) DEFAULT NULL,
  `songLength` int(11) NOT NULL DEFAULT '0',
  `lyricName` varchar(120) DEFAULT NULL,
  `lyricAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`songId`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', '喜欢你', 'http://www.wangruns.top/wp-content/uploads/2017/03/%E5%96%9C%E6%AC%A2%E4%BD%A0.mp3', null, null, '1', null, null);
INSERT INTO `song` VALUES ('2', '绝世', 'http://www.wangruns.top/wp-content/uploads/2017/03/%E7%BB%9D%E4%B8%96.mp3', null, null, '1', null, null);
INSERT INTO `song` VALUES ('3', '冷漠 - 这条街', 'track/song/冷漠 - 这条街.mp3', null, null, '1', null, 'track/song/冷漠 - 这条街.lrc');
INSERT INTO `song` VALUES ('4', '天涯', 'track/song/天涯.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('5', '沉默是金', 'track/song/沉默是金.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('6', '哭砂', 'track/song/哭砂.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('7', '飘雪', 'track/song/飘雪.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('8', '千年等一回', 'track/song/千年等一回.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('9', '你那么爱她', 'track/song/你那么爱她.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('10', '太阳星辰', 'track/song/太阳星辰.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('11', '月亮代表我的心', 'track/song/月亮代表我的心.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('12', '雪见—仙凡之旅-麦振鸿', 'track/song/雪见—仙凡之旅-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('13', '月亮惹的祸', 'track/song/月亮惹的祸.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('14', 'The Mass', 'track/song/The Mass.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('15', '醉赤壁', 'track/song/醉赤壁.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('16', '涛声依旧', 'track/song/涛声依旧.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('17', '千千阙歌', 'track/song/千千阙歌.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('18', '仙剑奇缘-麦振鸿', 'track/song/仙剑奇缘-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('19', '遇见', 'track/song/遇见.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('20', '心之焰', 'track/song/心之焰.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('21', '烧酒话', 'track/song/烧酒话.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('22', '一剪梅', 'track/song/一剪梅.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('23', '黑街', 'track/song/黑街.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('24', '懂你', 'track/song/懂你.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('25', '有多少爱可以重来', 'track/song/有多少爱可以重来.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('26', '约定', 'track/song/约定.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('27', 'Main Titles', 'track/song/Main Titles.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('28', 'Panama', 'track/song/Panama.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('29', '酒干倘卖无', 'track/song/酒干倘卖无.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('30', '矜持', 'track/song/矜持.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('31', 'The Day You Went Away', 'track/song/The Day You Went Away.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('32', 'I Just Wanna Run', 'track/song/I Just Wanna Run.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('33', '往事只能回味', 'track/song/往事只能回味.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('34', '知心爱人', 'track/song/知心爱人.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('35', '三万英尺', 'track/song/三万英尺.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('36', '有一个姑娘', 'track/song/有一个姑娘.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('37', '手放开', 'track/song/手放开.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('38', 'tokyo hot', 'track/song/tokyo hot.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('39', '平凡之路', 'track/song/平凡之路.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('40', '美酒加咖啡', 'track/song/美酒加咖啡.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('41', '九九女儿红', 'track/song/九九女儿红.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('42', '「名探偵コナン」~メインテーマ(バラード・ヴァージョン)', 'track/song/「名探偵コナン」~メインテーマ(バラード・ヴァージョン).mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('43', '如果这都不算爱', 'track/song/如果这都不算爱.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('44', 'Something Just Like This', 'track/song/Something Just Like This.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('45', '我从崖边跌落', 'track/song/我从崖边跌落.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('46', 'Toca Toca', 'track/song/Toca Toca.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('47', '月光の雲海', 'track/song/月光の雲海.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('48', '宿敌', 'track/song/宿敌.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('49', '叹十声', 'track/song/叹十声.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('50', '어떤 욕심', 'track/song/어떤 욕심.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('51', '又见炊烟', 'track/song/又见炊烟.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('52', '一生何求', 'track/song/一生何求.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('53', '#Lov3 #Ngẫu Hứng', 'track/song/#Lov3 #Ngẫu Hứng.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('54', '万水千山总是情', 'track/song/万水千山总是情.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('55', '小雨', 'track/song/小雨.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('56', '吻别', 'track/song/吻别.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('57', '站在高岗上', 'track/song/站在高岗上.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('58', '拜月-麦振鸿', 'track/song/拜月-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('59', '你是风儿我是沙', 'track/song/你是风儿我是沙.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('60', '容易受伤的女人', 'track/song/容易受伤的女人.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('61', '相见不如怀念', 'track/song/相见不如怀念.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('62', '月半小夜曲', 'track/song/月半小夜曲.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('63', '空空如也', 'track/song/空空如也.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('64', '外婆的澎湖湾', 'track/song/外婆的澎湖湾.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('65', '偏偏喜欢你', 'track/song/偏偏喜欢你.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('66', '花好月圆', 'track/song/花好月圆.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('67', 'Hey Oh', 'track/song/Hey Oh.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('68', '兰花草', 'track/song/兰花草.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('69', '敖包相会', 'track/song/敖包相会.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('70', '红日', 'track/song/红日.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('71', '你的眼神', 'track/song/你的眼神.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('72', '比翼鸟-麦振鸿', 'track/song/比翼鸟-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('73', '相思风雨中', 'track/song/相思风雨中.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('74', 'Unity', 'track/song/Unity.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('75', '花太香', 'track/song/花太香.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('76', '花香', 'track/song/花香.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('77', '真的爱你', 'track/song/真的爱你.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('78', '相见恨晚', 'track/song/相见恨晚.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('79', 'We Will Rock You', 'track/song/We Will Rock You.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('80', '牵绊一生 (不可说)-麦振鸿', 'track/song/牵绊一生 (不可说)-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('81', '越夜越有机', 'track/song/越夜越有机.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('82', '旧欢如梦', 'track/song/旧欢如梦.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('83', '突然的自我', 'track/song/突然的自我.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('84', '记事本', 'track/song/记事本.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('85', '谁明浪子心', 'track/song/谁明浪子心.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('86', 'I Want My Tears Back', 'track/song/I Want My Tears Back.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('87', '有没有一首歌会让你想起我', 'track/song/有没有一首歌会让你想起我.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('88', '天下第一-麦振鸿', 'track/song/天下第一-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('89', '映山红', 'track/song/映山红.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('90', 'Samsara', 'track/song/Samsara.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('91', '蜗牛与黄鹂鸟', 'track/song/蜗牛与黄鹂鸟.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('92', '笑脸', 'track/song/笑脸.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('93', '舞女', 'track/song/舞女.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('94', '取一念', 'track/song/取一念.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('95', '挪威的森林', 'track/song/挪威的森林.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('96', '痴心绝对', 'track/song/痴心绝对.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('97', 'Wicked Wonderland', 'track/song/Wicked Wonderland.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('98', '一人有一个梦想', 'track/song/一人有一个梦想.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('99', '天涯歌女', 'track/song/天涯歌女.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('100', '走过咖啡屋', 'track/song/走过咖啡屋.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('101', '连锁反应', 'track/song/连锁反应.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('102', '野鸟', 'track/song/野鸟.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('103', 'Epic Sax Guy', 'track/song/Epic Sax Guy.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('104', '泡沫', 'track/song/泡沫.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('105', '只爱西经', 'track/song/只爱西经.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('106', 'Time', 'track/song/Time.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('107', '星星点灯', 'track/song/星星点灯.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('108', '高高在下', 'track/song/高高在下.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('109', '月亮光光', 'track/song/月亮光光.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('110', 'Es rappelt im Karton', 'track/song/Es rappelt im Karton.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('111', 'Silver Scrapes', 'track/song/Silver Scrapes.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('112', 'Bailemen Swing Feat. Zhang Le', 'track/song/Bailemen Swing Feat. Zhang Le.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('113', 'Bom Bom', 'track/song/Bom Bom.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('114', '我在那一角落患过伤风', 'track/song/我在那一角落患过伤风.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('115', '问情', 'track/song/问情.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('116', '你究竟有几个好妹妹', 'track/song/你究竟有几个好妹妹.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('117', '友情岁月', 'track/song/友情岁月.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('118', 'Victory', 'track/song/Victory.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('119', '青青河边草', 'track/song/青青河边草.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('120', 'Loves Me Not', 'track/song/Loves Me Not.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('121', '月满西楼', 'track/song/月满西楼.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('122', '降魔剑-麦振鸿', 'track/song/降魔剑-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('123', '继续奋战(杀破狼 演奏曲)-麦振鸿', 'track/song/继续奋战(杀破狼 演奏曲)-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('124', '大地之母-麦振鸿', 'track/song/大地之母-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('125', '张三的歌', 'track/song/张三的歌.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('126', '心雨', 'track/song/心雨.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('127', '让一切随风', 'track/song/让一切随风.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('128', '将冰山劈开(Live)', 'track/song/将冰山劈开(Live).mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('129', 'Bomba', 'track/song/Bomba.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('130', '浪花一朵朵(任贤齐&Friends演唱会版) - live', 'track/song/浪花一朵朵(任贤齐&Friends演唱会版) - live.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('131', '我很快乐', 'track/song/我很快乐.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('132', '当你', 'track/song/当你.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('133', '九月九的酒', 'track/song/九月九的酒.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('134', 'Breath and Life', 'track/song/Breath and Life.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('135', '不再说永远', 'track/song/不再说永远.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('136', '讲不出再见', 'track/song/讲不出再见.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('137', '梦驼铃', 'track/song/梦驼铃.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('138', 'Go Time', 'track/song/Go Time.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('139', '水手', 'track/song/水手.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('140', '花开花落', 'track/song/花开花落.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('141', '雨一直下', 'track/song/雨一直下.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('142', '狂风卷奔云飙', 'track/song/狂风卷奔云飙.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('143', '分飞燕', 'track/song/分飞燕.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('144', '沧海一声笑', 'track/song/沧海一声笑.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('145', '温柔乡', 'track/song/温柔乡.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('146', '知音梦里寻', 'track/song/知音梦里寻.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('147', 'Jar Of Love', 'track/song/Jar Of Love.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('148', 'Lonely', 'track/song/Lonely.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('149', '顺流逆流', 'track/song/顺流逆流.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('150', '247', 'track/song/247.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('151', '萍聚', 'track/song/萍聚.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('152', '梦醒时分', 'track/song/梦醒时分.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('153', 'Primetime-sexcrime', 'track/song/Primetime-sexcrime.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('154', '酒杯敲钢琴', 'track/song/酒杯敲钢琴.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('155', 'Axel F', 'track/song/Axel F.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('156', '「名探偵コナン」~メインテーマ', 'track/song/「名探偵コナン」~メインテーマ.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('157', '男儿当自强', 'track/song/男儿当自强.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('158', '阿嬷的话', 'track/song/阿嬷的话.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('159', '单身情歌', 'track/song/单身情歌.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('160', 'Yeah', 'track/song/Yeah.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('161', '祝你平安', 'track/song/祝你平安.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('162', 'The Next Episode', 'track/song/The Next Episode.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('163', '运动员进行曲', 'track/song/运动员进行曲.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('164', '慢慢', 'track/song/慢慢.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('165', '賭神', 'track/song/賭神.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('166', 'BOOM', 'track/song/BOOM.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('167', '明月千里寄相思', 'track/song/明月千里寄相思.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('168', 'Hello', 'track/song/Hello.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('169', '独家试唱', 'track/song/独家试唱.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('170', '中华民谣', 'track/song/中华民谣.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('171', 'Turn Down for What', 'track/song/Turn Down for What.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('172', '长相依', 'track/song/长相依.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('173', 'The Discovery', 'track/song/The Discovery.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('174', '帝女芳魂', 'track/song/帝女芳魂.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('175', '爱一点', 'track/song/爱一点.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('176', '情债', 'track/song/情债.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('177', '九百九十九朵玫瑰', 'track/song/九百九十九朵玫瑰.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('178', 'attraction', 'track/song/attraction.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('179', '游子吟', 'track/song/游子吟.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('180', '大海', 'track/song/大海.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('181', '我悄悄蒙上你的眼睛', 'track/song/我悄悄蒙上你的眼睛.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('182', '天外有天', 'track/song/天外有天.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('183', '皆大欢喜', 'track/song/皆大欢喜.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('184', 'Here We Are Again', 'track/song/Here We Are Again.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('185', '落雨大', 'track/song/落雨大.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('186', '家后', 'track/song/家后.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('187', '恨爱交加-麦振鸿', 'track/song/恨爱交加-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('188', 'Freaks', 'track/song/Freaks.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('189', '真真假假', 'track/song/真真假假.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('190', '蝶儿蝶儿满天飞', 'track/song/蝶儿蝶儿满天飞.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('191', '不要说话', 'track/song/不要说话.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('192', '梦里水乡', 'track/song/梦里水乡.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('193', '潇洒走一回', 'track/song/潇洒走一回.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('194', '寻词', 'track/song/寻词.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('195', '我的1997', 'track/song/我的1997.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('196', '重逢', 'track/song/重逢.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('197', '漫步人生路', 'track/song/漫步人生路.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('198', '光辉岁月', 'track/song/光辉岁月.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('199', '爱你一万年', 'track/song/爱你一万年.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('200', '月半弯', 'track/song/月半弯.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('201', '一路上有你', 'track/song/一路上有你.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('202', '狐狸', 'track/song/狐狸.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('203', '风的季节', 'track/song/风的季节.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('204', '月牙湾', 'track/song/月牙湾.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('205', '致姗姗来迟的你', 'track/song/致姗姗来迟的你.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('206', '潮湿的心', 'track/song/潮湿的心.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('207', 'Me Too', 'track/song/Me Too.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('208', '靠近', 'track/song/靠近.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('209', '阿郎', 'track/song/阿郎.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('210', '感恩的心', 'track/song/感恩的心.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('211', 'We Are Electric', 'track/song/We Are Electric.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('212', '新不了情', 'track/song/新不了情.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('213', '铁血丹心', 'track/song/铁血丹心.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('214', '桃花岛-麦振鸿', 'track/song/桃花岛-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('215', '丁香花', 'track/song/丁香花.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('216', '踏浪', 'track/song/踏浪.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('217', '风中有朵雨做的云', 'track/song/风中有朵雨做的云.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('218', '相思', 'track/song/相思.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('219', 'Stronger', 'track/song/Stronger.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('220', 'Faded', 'track/song/Faded.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('221', '林中鸟', 'track/song/林中鸟.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('222', '曾经心痛', 'track/song/曾经心痛.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('223', '太傻', 'track/song/太傻.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('224', '雪花', 'track/song/雪花.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('225', '难得有情人', 'track/song/难得有情人.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('226', '来生缘', 'track/song/来生缘.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('227', '珍重', 'track/song/珍重.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('228', 'Because of You', 'track/song/Because of You.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('229', '倩女幽魂', 'track/song/倩女幽魂.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('230', '羞答答的玫瑰静悄悄地开', 'track/song/羞答答的玫瑰静悄悄地开.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('231', '坐在巷口的那对男女', 'track/song/坐在巷口的那对男女.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('232', '爸爸的汽水', 'track/song/爸爸的汽水.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('233', '窗外', 'track/song/窗外.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('234', 'Mi Mi Mi', 'track/song/Mi Mi Mi.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('235', '甜蜜蜜', 'track/song/甜蜜蜜.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('236', 'Seve', 'track/song/Seve.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('237', '独角戏', 'track/song/独角戏.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('238', '恰似你的温柔', 'track/song/恰似你的温柔.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('239', '江湖笑', 'track/song/江湖笑.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('240', '时空之钥-麦振鸿', 'track/song/时空之钥-麦振鸿.mp3', null, null, '0', null, null);
INSERT INTO `song` VALUES ('242', 'Beat It (12\' Mix) - Michael Jackson', 'track/song/Beat It (12\' Mix) - Michael Jackson.mp3', null, null, '0', 'Beat It (12\' Mix) - Michael Jackson.lrc', 'track/lyric/Beat It (12\' Mix) - Michael Jackson.lrc');
INSERT INTO `song` VALUES ('244', 'You Are Not Alone (live) - Michael Jackson', 'track/song/You Are Not Alone (live) - Michael Jackson.mp3', null, null, '0', 'You Are Not Alone (live) - Michael Jackson.lrc', 'track/lyric/You Are Not Alone (live) - Michael Jackson.lrc');
INSERT INTO `song` VALUES ('245', '城市里的素描', 'track/song/城市里的素描.mp3', null, null, '0', null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL DEFAULT '菜鸡一枚我不哭',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2011229 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123456@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '菜鸡一枚我不哭');
INSERT INTO `user` VALUES ('2', 'dyb1296@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '一人之下');
INSERT INTO `user` VALUES ('4', '1344986@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'Donald J. Trump');
INSERT INTO `user` VALUES ('5', '2504208@qq.com', 'd9f4e4bb710357210fa9fe30c178fc42', '菜鸡一枚我不哭');
INSERT INTO `user` VALUES ('6', '265991@163.com', 'bf08b01ead83cbd62a9839ca1cf35ada', '菜鸡一枚我不哭');
INSERT INTO `user` VALUES ('7', '5878433@qq.com', '5fc70f8b935595586dbbae4cda7cae3f', '菜鸡一枚我不哭');
INSERT INTO `user` VALUES ('8', '19962007@126.com', '3fde6bb0541387e4ebdadf7c2ff31123', '菜鸡一枚我不哭');
INSERT INTO `user` VALUES ('9', '2145930654@qq.com', 'c943feee03ccd9aa8b842e7efdf4664f', '菜鸡一枚我不哭');
INSERT INTO `user` VALUES ('15', '212582493@qq.com', 'c4ca4238a0b923820dcc509a6f75849b', '东方姑凉');
INSERT INTO `user` VALUES ('2011227', '1347845688@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'ROOT');
INSERT INTO `user` VALUES ('2011228', '1357845688@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '菜鸡一枚我不哭');

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `userroleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userroleId`),
  KEY `fk_userrole_1_idx` (`userId`),
  KEY `fk_userrole_2_idx` (`roleId`),
  CONSTRAINT `fk_userrole_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_userrole_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('1', '2011227', '1');

-- ----------------------------
-- View structure for `monthranking`
-- ----------------------------
DROP VIEW IF EXISTS `monthranking`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `monthranking` AS select `play`.`songId` AS `songId`,count(`play`.`songId`) AS `trendingCoefficient` from `play` where (month(`play`.`playTime`) >= (month(now()) - 1)) group by `play`.`songId` limit 50 ;

-- ----------------------------
-- View structure for `trending`
-- ----------------------------
DROP VIEW IF EXISTS `trending`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `trending` AS select `play`.`songId` AS `songId`,count(`play`.`songId`) AS `trendingCoefficient` from `play` group by `play`.`songId` limit 50 ;

-- ----------------------------
-- View structure for `weekranking`
-- ----------------------------
DROP VIEW IF EXISTS `weekranking`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `weekranking` AS select `play`.`songId` AS `songId`,count(`play`.`songId`) AS `trendingCoefficient` from `play` where (week(`play`.`playTime`,0) >= (week(now(),0) - 1)) group by `play`.`songId` limit 50 ;

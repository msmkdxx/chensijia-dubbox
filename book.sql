/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2020-04-14 20:27:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `publish` varchar(255) default NULL,
  `publishdate` date default NULL,
  `page` int(11) default NULL,
  `price` double default NULL,
  `content` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '三国演义', '罗贯中', '北大出版', '1970-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('17', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('18', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('19', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('20', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('21', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('22', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('23', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('24', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('25', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('26', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('27', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('28', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('29', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('30', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('31', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('32', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('33', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('34', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('35', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('36', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('37', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('38', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('39', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('40', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('41', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('42', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('43', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('44', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('45', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('47', '456789', '456789', '456789', '2019-06-12', '200', '250', '456789');
INSERT INTO `book` VALUES ('48', '三国演义', '马伯庸', '不知道', '2018-01-01', '400', '31', '死囚犯的撩妹之旅');
INSERT INTO `book` VALUES ('51', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('52', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('53', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('54', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('55', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('56', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('57', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('58', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('59', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('60', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('61', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('62', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('63', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('64', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('65', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('66', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('67', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('68', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('69', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('70', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('71', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('72', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('73', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('74', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('75', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('76', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('77', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('78', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('79', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('80', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('81', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('82', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('83', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('84', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('85', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('86', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('87', '456789', '456789', '456789', '2019-06-12', '200', '250', '456789');
INSERT INTO `book` VALUES ('88', '长安十二时辰', '马伯庸', '不知道', '2018-01-01', '400', '31', '死囚犯的撩妹之旅');
INSERT INTO `book` VALUES ('89', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('90', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('91', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('92', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('93', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('94', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('95', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('96', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('97', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('98', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('99', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('100', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('101', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('102', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('103', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('104', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('105', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('106', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('107', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('108', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('109', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('110', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('111', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('112', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('113', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('114', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('115', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('116', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('117', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('118', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('119', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('120', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('121', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('122', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('123', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('124', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('125', '456789', '456789', '456789', '2019-06-12', '200', '250', '456789');
INSERT INTO `book` VALUES ('126', '三国演义', '马伯庸', '不知道', '2018-01-01', '400', '31', '死囚犯的撩妹之旅');
INSERT INTO `book` VALUES ('127', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('128', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('129', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('130', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('131', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('132', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('133', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('134', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('135', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('136', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('137', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('138', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('139', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('140', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('141', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('142', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('143', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('144', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('145', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('146', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('147', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('148', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('149', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('150', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('151', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('152', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('153', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('154', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('155', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('156', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('157', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('158', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('159', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('160', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('161', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('162', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('163', '456789', '456789', '456789', '2019-06-12', '200', '250', '456789');
INSERT INTO `book` VALUES ('164', '长安十二时辰', '马伯庸', '不知道', '2018-01-01', '400', '31', '死囚犯的撩妹之旅');
INSERT INTO `book` VALUES ('165', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('166', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('167', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('168', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('169', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('170', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('171', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('172', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('173', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('174', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('175', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('176', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('177', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('178', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('179', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('180', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('181', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('182', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('183', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('184', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('185', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('186', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('187', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('188', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('189', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('190', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('191', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('192', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('193', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('194', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('195', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('196', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('197', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('198', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('199', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('200', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('202', '三国演义', '马伯庸', '不知道', '2018-01-01', '400', '31', '死囚犯的撩妹之旅');
INSERT INTO `book` VALUES ('203', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('204', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('205', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('206', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('207', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('208', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('209', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('210', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('211', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('212', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('213', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('214', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('215', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('216', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('217', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('218', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('219', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('220', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('221', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('222', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('223', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('224', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('225', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('226', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('227', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('228', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('229', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('230', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('231', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('232', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('233', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('234', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('235', '西游记', '吴承恩', '南天门出版', '2019-05-16', '81', '108', '一个王者猴子带四个青铜的升级打怪历程');
INSERT INTO `book` VALUES ('236', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('237', '红楼梦', '曹雪芹', '大观园出版', '1939-05-16', '250', '250', '两块石头的爱恨情仇');
INSERT INTO `book` VALUES ('238', '三国演义', '罗贯中', '北大出版', '1790-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('239', '456789', '456789', '456789', '2019-06-12', '200', '250', '456789');
INSERT INTO `book` VALUES ('241', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('242', '水浒传', '施耐庵', '梁山出版', '1695-07-13', '108', '108', '105个大汉和3个女人的故事');
INSERT INTO `book` VALUES ('244', '三顾茅庐', 'aaaa', 'aaaa', '2019-11-17', '20', '200', 'aaaaaaaaaaaaaaaa');
INSERT INTO `book` VALUES ('246', '三国演义', '罗贯中', '北大出版', '1970-06-23', '200', '200', '天下大势，分久必合，合久必分');
INSERT INTO `book` VALUES ('247', 'cc', 'cc', 'cc', '2020-01-08', '12', '12', 'cccc');
INSERT INTO `book` VALUES ('249', 'aa', 'aa', 'aa', '2020-01-08', '12', '12', 'aa');
INSERT INTO `book` VALUES ('250', 'bb', 'bb', 'bb', '2020-01-10', '12', '12', 'bbbbb');
INSERT INTO `book` VALUES ('251', '像狗一样奔跑', '里则林', null, null, null, '480', null);
INSERT INTO `book` VALUES ('253', 'dd', 'dd', null, null, null, null, 'dd');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `good_id` varchar(11) NOT NULL COMMENT '商品编号',
  `name` varchar(50) default NULL COMMENT '商品名',
  `price` double default NULL COMMENT '商品价格',
  `content` varchar(100) default NULL COMMENT '商品描述',
  `count` int(11) default NULL,
  PRIMARY KEY  (`good_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'Advanced SystemCare 12 Ultimate 清理杀毒软件', '129', '全新的反病毒引擎，超敏感的检测和删除最新的病毒，木马软件，间谍软件', '10');
INSERT INTO `goods` VALUES ('10', '手机', '6000', '手机的描述', '12');
INSERT INTO `goods` VALUES ('11', '华为手机', '6000', '手机的描述', '4');
INSERT INTO `goods` VALUES ('2', 'Advanced SystemCare 13 Pro 清理优化工具', '149', '一键清理优化和修复、深度您的PC，清理Windows注册表、自动在线反浏览器跟踪保护隐私，提升电脑速度高达200％。', '10');
INSERT INTO `goods` VALUES ('3', 'AMC Security 手机管家- 清理', '99', '加速、安全', '10');
INSERT INTO `goods` VALUES ('4', 'Ashampoo Burning Studio 20 刻录软件 许可证', '50', '许可证', '11');
INSERT INTO `goods` VALUES ('5', 'Avast Business Antivirus Pro Plus 商业专业增强版 企业全面保护', '379', '防护软件', '11');
INSERT INTO `goods` VALUES ('6', 'Avast Business Antivirus Pro Plus 商业专业增强版 企业全面保护', '254', '许可证', '11');
INSERT INTO `goods` VALUES ('7', 'Avast Business Antivirus Pro 商业专业版 企业杀毒软件', '216', '许可证', '11');
INSERT INTO `goods` VALUES ('8', 'Avast Business Antivirus 商业版 小型企业防病毒软件', '230', '许可证', '12');
INSERT INTO `goods` VALUES ('9', 'Avast Premier 杀毒软件 高级版 激活码', '99', '许可证', '11');

-- ----------------------------
-- Table structure for goods_like
-- ----------------------------
DROP TABLE IF EXISTS `goods_like`;
CREATE TABLE `goods_like` (
  `id` bigint(11) NOT NULL auto_increment,
  `good_id` varchar(11) NOT NULL COMMENT '商品id',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `status` int(1) default '0' COMMENT '点赞状态(0：取消点赞，1：点赞)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_like
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` bigint(8) NOT NULL auto_increment,
  `title` varchar(20) NOT NULL COMMENT '通知标题',
  `content` varchar(50) NOT NULL COMMENT '通知内容',
  `u_id` bigint(11) NOT NULL,
  `current_time` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '作业', '写代码', '1', '2020-04-10 11:44:54');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(40) NOT NULL COMMENT '订单号',
  `num` double default NULL COMMENT '商品总价',
  `phone` varchar(11) NOT NULL,
  `good_id` varchar(8) NOT NULL,
  `state` int(1) NOT NULL default '0' COMMENT '订单状态',
  `is_pay` int(1) default NULL,
  `createdDate` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('10af3c1c-d6cf-477f-a773-104885865149', null, '18852072789', '9', '0', null, null);
INSERT INTO `orders` VALUES ('1296b6832-8e2a-492c-ac6c-4053ec77b076', null, '18852072789', '10', '0', null, null);
INSERT INTO `orders` VALUES ('152cfcaea-3962-41c2-b353-6ab617169799', null, '18852072789', '1', '0', null, null);
INSERT INTO `orders` VALUES ('15faf6c69-a55e-4114-a314-d9dd02a36eb2', null, '18852072789', '11', '0', null, null);
INSERT INTO `orders` VALUES ('16eaa27d4-9d5e-449e-81dd-3d2225a2d4c5', null, '18852072789', '7', '0', null, null);
INSERT INTO `orders` VALUES ('1c89916d9-7746-4152-b883-f5b25f601f9c', null, '18852072789', '5', '0', null, null);
INSERT INTO `orders` VALUES ('1f06322ed-58ed-41b9-b8d9-7b9ec0cc6908', null, '18852072789', '2', '0', null, null);
INSERT INTO `orders` VALUES ('519f72f9-960f-4193-a153-c49701a37af1', null, '18852072789', '4', '0', null, null);
INSERT INTO `orders` VALUES ('96a27159-0969-439d-95ec-76aae3da390d', null, '18852072789', '3', '0', null, null);
INSERT INTO `orders` VALUES ('b81a7638-6215-4c52-a641-df3b52b3c51e', null, '18852072789', '6', '0', null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '最强王者');
INSERT INTO `role` VALUES ('2', '傲视宗师');
INSERT INTO `role` VALUES ('3', '超凡大师');
INSERT INTO `role` VALUES ('4', '璀璨钻石');
INSERT INTO `role` VALUES ('5', '华贵铂金');
INSERT INTO `role` VALUES ('6', '荣耀黄金');
INSERT INTO `role` VALUES ('7', '不屈白银');
INSERT INTO `role` VALUES ('8', '英勇黄铜');
INSERT INTO `role` VALUES ('9', '坚韧黑铁');

-- ----------------------------
-- Table structure for tusers
-- ----------------------------
DROP TABLE IF EXISTS `tusers`;
CREATE TABLE `tusers` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `age` int(11) default NULL,
  `sex` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `usertype` varchar(255) default NULL,
  `roleid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tusers
-- ----------------------------
INSERT INTO `tusers` VALUES ('1', 'admin', '123456', null, null, null, '1', '1');
INSERT INTO `tusers` VALUES ('2', '张三', '123456', '100', '1', null, null, '1');
INSERT INTO `tusers` VALUES ('3', 'aa', '123', '22', '1', null, null, '1');
INSERT INTO `tusers` VALUES ('4', '李四', '123456', null, null, null, null, '1');
INSERT INTO `tusers` VALUES ('5', '王五', '123456', null, null, null, null, '1');
INSERT INTO `tusers` VALUES ('6', '赵六', '123456', '22', '1', null, null, '1');
INSERT INTO `tusers` VALUES ('12', '王五', '123456', null, null, null, '2', '2');
INSERT INTO `tusers` VALUES ('13', 'cc', '11111', '0', '0', null, null, '2');
INSERT INTO `tusers` VALUES ('15', 'cc', '11111', null, null, null, null, '2');
INSERT INTO `tusers` VALUES ('16', 'cc', '11111', null, null, null, null, '2');
INSERT INTO `tusers` VALUES ('17', 'bb', '147258', null, null, null, null, '2');
INSERT INTO `tusers` VALUES ('18', 'dd', '11111', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('19', '李四四', '654321', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('20', 'ee', '11111', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('21', '李四四1', '654321', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('22', 'ff', '11111', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('23', 'ab', '123', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('25', 'aaaaa', 'bbbbb', '18', '女', null, null, null);
INSERT INTO `tusers` VALUES ('26', '王五', '147258', null, null, null, null, null);
INSERT INTO `tusers` VALUES ('27', '嘻哈', '牛屁', null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL auto_increment,
  `phone` varchar(11) NOT NULL,
  `password` varchar(50) NOT NULL COMMENT '密码',
  `name` varchar(12) default NULL COMMENT '用户名',
  `sex` int(1) default NULL,
  `score` bigint(50) default NULL,
  `createtime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18852072789', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'admin', null, null, null);
INSERT INTO `user` VALUES ('4', '18852072799', '7c4a8d09ca3762af61e59520943dc26494f8941b', '张三', null, null, null);
INSERT INTO `user` VALUES ('5', '18852072779', '7c4a8d09ca3762af61e59520943dc26494f8941b', '李四', null, null, null);

-- ----------------------------
-- Table structure for wx
-- ----------------------------
DROP TABLE IF EXISTS `wx`;
CREATE TABLE `wx` (
  `id` bigint(11) NOT NULL auto_increment,
  `openid` varchar(50) NOT NULL,
  `nickname` varchar(8) default NULL,
  `city` varchar(11) default NULL,
  `province` varchar(11) default NULL,
  `country` varchar(11) default NULL,
  `headimgurl` varchar(255) default NULL,
  `wtime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx
-- ----------------------------
INSERT INTO `wx` VALUES ('1', 'o-Q1swswfemle_bRsCSCzxY791cs', null, null, null, null, null, null);
INSERT INTO `wx` VALUES ('2', 'o-Q1swgYfNFHwFXskDqsCsihfRPg', '陈瑞祥', '南京', '江苏', '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIRyVkkRj6lZA3iaicpoZ8iaCWw3fT8RhWbrdwjeTJ4hQeaKcyd40TAUwXwVQ6doSny9rlhdkcfbCIKQ/132', null);

-- ----------------------------
-- Table structure for wx_and_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_and_user`;
CREATE TABLE `wx_and_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `openid` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_and_user
-- ----------------------------

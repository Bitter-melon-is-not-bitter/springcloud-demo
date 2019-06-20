/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : cloudservice3

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 20/06/2019 10:40:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `d_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名字',
  `d_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '开发部', 'cloudservice3');
INSERT INTO `dept` VALUES (2, '人事部', 'cloudservice3');
INSERT INTO `dept` VALUES (3, '财务部', 'cloudservice3');
INSERT INTO `dept` VALUES (4, '市场部', 'cloudservice3');
INSERT INTO `dept` VALUES (5, '运维部', 'cloudservice3');
INSERT INTO `dept` VALUES (6, '研发部', 'cloudservice3');
INSERT INTO `dept` VALUES (7, 'hph部门', 'cloudservice3');

SET FOREIGN_KEY_CHECKS = 1;

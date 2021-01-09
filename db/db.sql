/*
 Navicat Premium Data Transfer

 Source Server         : itranlin
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Schema         : basic

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 09/01/2021 17:38:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`        varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
    `username`  varchar(255) COLLATE utf8mb4_general_ci                       DEFAULT NULL,
    `password`  varchar(255) COLLATE utf8mb4_general_ci                       DEFAULT NULL,
    `avatar`    varchar(255) COLLATE utf8mb4_general_ci                       DEFAULT NULL,
    `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
    `type`      varchar(255) COLLATE utf8mb4_general_ci                       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user`
VALUES ('1', 'admin', 'b9d11b3be25f5a1a7dc8ca04cd310b28', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

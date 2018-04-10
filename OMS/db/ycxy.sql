/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : ycxy

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-02-12 14:50:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_tb
-- ----------------------------
DROP TABLE IF EXISTS `customer_tb`;
CREATE TABLE `customer_tb` (
  `id` int(11) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_type` tinyint(4) DEFAULT NULL,
  `customer_level` tinyint(4) DEFAULT NULL,
  `customer_nick` varchar(50) DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `zip` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_tb
-- ----------------------------

-- ----------------------------
-- Table structure for trade_customer_tb
-- ----------------------------
DROP TABLE IF EXISTS `trade_customer_tb`;
CREATE TABLE `trade_customer_tb` (
  `id` int(11) NOT NULL,
  `trade_id` bigint(20) DEFAULT NULL,
  `trade_no` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_nick` varchar(50) DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `customer_type` tinyint(4) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `buyer_memo` varchar(255) DEFAULT NULL,
  `customer_level` tinyint(4) DEFAULT NULL,
  `customer_discount` decimal(10,0) DEFAULT NULL,
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_customer_tb
-- ----------------------------

-- ----------------------------
-- Table structure for trade_goods_tb
-- ----------------------------
DROP TABLE IF EXISTS `trade_goods_tb`;
CREATE TABLE `trade_goods_tb` (
  `id` int(11) NOT NULL,
  `trade_id` bigint(20) DEFAULT NULL,
  `sub_trade_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `goods_no` bigint(20) DEFAULT NULL,
  `goods_name` varchar(100) DEFAULT NULL,
  `spec_id` bigint(20) DEFAULT NULL,
  `spec_name` varchar(255) DEFAULT NULL,
  `barcode` varchar(255) DEFAULT NULL,
  `sell_count` int(11) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `sell_price` decimal(10,0) DEFAULT NULL,
  `sell_total` decimal(10,0) DEFAULT NULL,
  `tax_fee` decimal(10,0) DEFAULT NULL,
  `goods_memo` varchar(255) DEFAULT NULL,
  `is_fit` tinyint(4) DEFAULT NULL,
  `is_gift` tinyint(4) DEFAULT NULL,
  `sub_trade_status` tinyint(4) DEFAULT NULL,
  `refund_status` tinyint(4) DEFAULT NULL,
  `trade_goods_no` bigint(20) DEFAULT NULL,
  `trade_goods_name` varchar(100) DEFAULT NULL,
  `trade_goods_spec` varchar(100) DEFAULT NULL,
  `trade_goods_unit` varchar(10) DEFAULT NULL,
  `source_trade_no` bigint(20) DEFAULT NULL,
  `source_subtrade_no` bigint(20) DEFAULT NULL,
  `souce_trade_status` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_goods_tb
-- ----------------------------

-- ----------------------------
-- Table structure for trade_receiver_tb
-- ----------------------------
DROP TABLE IF EXISTS `trade_receiver_tb`;
CREATE TABLE `trade_receiver_tb` (
  `id` int(11) NOT NULL,
  `receiver_name` varchar(100) DEFAULT NULL,
  `receiver_phone` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `identity_card_type` tinyint(4) DEFAULT NULL,
  `identity_card_no` varchar(50) DEFAULT NULL,
  `gmt_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_receiver_tb
-- ----------------------------

-- ----------------------------
-- Table structure for trade_tb
-- ----------------------------
DROP TABLE IF EXISTS `trade_tb`;
CREATE TABLE `trade_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_id` bigint(20) DEFAULT NULL,
  `trade_no` bigint(20) DEFAULT NULL,
  `source_trade_id` bigint(20) DEFAULT NULL,
  `source_trade_no` bigint(20) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `seller` varchar(20) DEFAULT NULL,
  `trade_type` tinyint(4) DEFAULT NULL,
  `total_money` decimal(10,0) DEFAULT NULL,
  `seller_memo` varchar(255) DEFAULT NULL,
  `buyer_memo` varchar(255) DEFAULT NULL,
  `append_memo` varchar(255) DEFAULT NULL,
  `payment` decimal(10,0) DEFAULT NULL,
  `tax_fee` decimal(10,0) DEFAULT NULL,
  `post_fee` decimal(10,0) DEFAULT NULL,
  `register` varchar(20) DEFAULT NULL,
  `auditor` varchar(20) DEFAULT NULL,
  `reviewer` varchar(20) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `trade_status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_tb
-- ----------------------------

/**
  Plum DB definition.

  Server Type     :   MYSQL
  File Encoding   :   UTF-8
  Date            :   2017-08-09
 */


/**
  Create DataBase.
  DataBase Name     :   plum
  Character         :   utf8
  Collate           :   utf8_general_ci
  Storage Engine    :   INNODB
*/
CREATE DATABASE plum
  CHARSET SET = utf8 COLLATE = utf8_general_ci;

/**
  User Table Structure.
*/
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `login_name` varchar(64) NOT NULL COMMENT '账户名',
  `password` varchar(64) NOT NULL COMMENT '账户密码',
  `real_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) NOT NULL DEFAULT '0' COMMENT '性别，0-未知，1-男，2-女',
  `birthday` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `age` varchar(4) DEFAULT '0' COMMENT '年龄',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(16) DEFAULT NULL COMMENT '电话',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆ip',
  `last_login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登陆时间',
  `status` varchar(2) NOT NULL DEFAULT '0' COMMENT '账户状态，0-初始状态，1-正常，2-锁定，3-过期',
  `create_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '账户创建时间',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '账户更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除标志，0-未删除，1-已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_login_name_unique` (`login_name`) COMMENT '用户账户名称唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户表';




DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`       BIGINT AUTO_INCREMENT NOT NULL COMMENT '主键',
    `username` VARCHAR(255) COMMENT '账号',
    `password` VARCHAR(255) COMMENT '密码',
    `email`    VARCHAR(255) COMMENT '邮箱地址',
    `status`   VARCHAR(16) COMMENT '状态',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`           IDENTITY COMMENT '主键',
    `username`     VARCHAR(64) NOT NULL DEFAULT '' COMMENT '账号',
    `userpass`     VARCHAR(256)         DEFAULT '' COMMENT '密码',
    `nickname`     VARCHAR(32)          DEFAULT '' COMMENT '昵称',
    `realname`     VARCHAR(32)          DEFAULT '' COMMENT '真实姓名',
    `phone_number` VARCHAR(16)          DEFAULT '' COMMENT '手机号码',
    `email`        VARCHAR(64)          DEFAULT '' COMMENT '邮箱地址',
    `type`         VARCHAR(16)          DEFAULT 'common' COMMENT '账户类型',
    `avatar`       VARCHAR(256)         DEFAULT '' COMMENT '账户头像',
    `status`       TINYINT              DEFAULT 0 COMMENT '账户状态',
    `created_at`   DATETIME             DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `accountmeta`;
CREATE TABLE `accountmeta`
(
    `id`         IDENTITY COMMENT '主键',
    `account_id` BIGINT       NOT NULL COMMENT '账户ID',
    `key`        VARCHAR(512) NOT NULL DEFAULT '' COMMENT '元数据 key',
    `value`      LONGTEXT     NOT NULL DEFAULT '' COMMENT '元数据 value',
    PRIMARY KEY (`id`)
);

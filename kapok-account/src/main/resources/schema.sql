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

INSERT INTO `t_user`
    (`username`, `password`, `email`, `status`)
VALUES
    ('zhangsan', '123456', 'zhangsan@abc.com', 'NORMAL'),
    ('lisi', '123456', 'lisi@abc.com', 'NORMAL'),
    ('wangwu', '123456', 'wangwu@abc.com', 'NORMAL'),
    ('zhaoliu', '123456', 'zhaoliu@abc.com', 'NORMAL'),
    ('hongqi', '123456', 'hongqi@abc.com', 'NORMAL');
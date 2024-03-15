

CREATE TABLE `user`
(
    `id` VARCHAR(32) NOT NULL COMMENT '主键ID',
    `name` VARCHAR(32) NULL DEFAULT NULL COMMENT '用户名',
    `nickname` VARCHAR(32) NULL DEFAULT NULL COMMENT '昵称',
    `password` VARCHAR(256) NULL DEFAULT NULL COMMENT '密码',
    `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    `status` VARCHAR(30) DEFAULT 'INACTIVE' COMMENT '状态: INACTIVE|ACTIVE|LOCKED',
    `role` VARCHAR(30) DEFAULT 'USER' COMMENT '角色: USER|ADMIN|SUPER_ADMIN',
    `created_at` datetime     NOT NULL,
    `updated_at` datetime     NOT NULL,
     PRIMARY KEY (`id`)
);
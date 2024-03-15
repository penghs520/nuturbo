CREATE TABLE `organization`
(
    `id`         varchar(32)  NOT NULL,
    `name`       varchar(255) NOT NULL,
    `address`    varchar(255) NULL,
    `phone`      varchar(255) NOT NULL,
    `email`      varchar(255) NULL,
    `logo`       varchar(255) NOT NULL,
    `create_by`  varchar(255) NOT NULL,
    `created_at` datetime     NOT NULL,
    `updated_at` datetime     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
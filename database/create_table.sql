
ALTER TABLE `spring_r2dbc_samples`.`Student` DROP INDEX `idx_main`;

DROP TABLE `spring_r2dbc_samples`.`Student`;

CREATE TABLE `spring_r2dbc_samples`.`Student`  (
    `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    `code` varchar(50) NOT NULL,
    `name` varchar(50) NOT NULL,
    `gender` char(1) NOT NULL,
    `birthday` date NOT NULL,
    `address` varchar(300) NULL,
    `remark` varchar(1000) NULL,
    `active` tinyint NOT NULL DEFAULT 1,
    `createdAt` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
    `createdBy` varchar(50) NOT NULL,
    `updatedAt` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
    `updatedBy` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `idx_main`(`code`)
);

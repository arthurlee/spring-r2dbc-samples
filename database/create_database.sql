CREATE DATABASE `spring_r2dbc_samples` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE USER `spring_r2dbc_samples_user`@`%` IDENTIFIED WITH mysql_native_password BY 'B55!3Ufhj';
CREATE USER `spring_r2dbc_samples_user`@`localhost` IDENTIFIED WITH mysql_native_password BY 'B55!3Ufhj';

GRANT all privileges ON `spring_r2dbc_samples`.* TO `spring_r2dbc_samples_user`@`%`;
GRANT all privileges ON `spring_r2dbc_samples`.* TO `spring_r2dbc_samples_user`@`localhost`;

flush privileges;
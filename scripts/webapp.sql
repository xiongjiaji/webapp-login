DROP SCHEMA IF EXISTS `webapp`;

CREATE SCHEMA IF NOT EXISTS `webapp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
 
USE `webapp`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `gender` enum("F", "M", "S") DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `active` bool DEFAULT 1,
  `status` varchar(20) DEFAULT NULL,
  `registration_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `last_login_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `identity`;

CREATE TABLE `identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `identity_type` varchar(20) NOT NULL,
  `identifier` varchar(20) NOT NULL,
  `credential`varchar(4000) NOT NULL,
  
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES user(`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

SHOW WARNINGS;
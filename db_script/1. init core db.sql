CREATE DATABASE journey_java;

use journey_java;

CREATE TABLE support (login VARCHAR(20) NOT NULL UNIQUE, password_id VARCHAR(20) NOT NULL,
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT);

CREATE TABLE user_data (user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, login VARCHAR(20) NOT NULL UNIQUE,
user_password VARCHAR(20) NOT NULL, email VARCHAR(40) NOT NULL UNIQUE, full_name VARCHAR(20) NOT NULL, age DATE);

CREATE TABLE level_data (user_id INT NOT NULL, exp INT NOT NULL PRIMARY KEY);

CREATE TABLE path_data (path_id INT NOT NULL PRIMARY KEY, path_name VARCHAR(45) NOT NULL, path_exp INT NOT NULL,
path_level INT NOT NULL, path_km FLOAT NOT NULL, path_duration FLOAT NOT NULL);

CREATE TABLE path_diff (path_id INT NOT NULL, path_level INT NOT NULL PRIMARY KEY);

CREATE TABLE rating_data (rate_id INT NOT NULL PRIMARY KEY, login VARCHAR(20) NOT NULL,
exp INT NOT NULL);

CREATE TABLE event_data (event_id INT NOT NULL PRIMARY KEY, path_id INT NOT NULL, path_level INT NOT NULL,
event_date DATE NOT NULL);

CREATE TABLE event_list (user_id INT NOT NULL, event_id INT NOT NULL);

ALTER TABLE event_list ADD FOREIGN KEY (user_id) REFERENCES user_data(user_id),
ADD FOREIGN KEY (event_id) REFERENCES event_data(event_id);

ALTER TABLE event_data ADD FOREIGN KEY (path_id) REFERENCES path_data(path_id),
ADD FOREIGN KEY (path_level) REFERENCES path_diff(path_level);

ALTER TABLE rating_data ADD FOREIGN KEY (login) REFERENCES user_data(login),
ADD FOREIGN KEY (exp) REFERENCES level_data(exp);

ALTER TABLE level_data ADD FOREIGN KEY (user_id) REFERENCES user_data(user_id);

ALTER TABLE path_diff ADD FOREIGN KEY (path_id) REFERENCES path_data(path_id);

/*support, user_data, level_data, rating_data, path_data, path_diff, event_data, event_list, */
INSERT INTO path_data VALUES(1, 'Mura', 15, 2, 2, 2);
INSERT INTO path_diff VALUES(1, 2);




-- --------------------------------------------------------
-- Хост:                         localhost
-- Версия сервера:               5.7.21-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных phobos_journey_core
DROP DATABASE IF EXISTS `phobos_journey_core`;
CREATE DATABASE IF NOT EXISTS `phobos_journey_core` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `phobos_journey_core`;

-- Дамп структуры для таблица phobos_journey_core.route_level
DROP TABLE IF EXISTS `route_level`;
CREATE TABLE IF NOT EXISTS `route_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `route_level_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `route_id` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `route_id_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `level_id` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `racebook_b_id` int(11) NOT NULL,
  `insta_b_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `route_id_uindex` (`id`),
  FOREIGN KEY (`level_id`) REFERENCES `route_level`(`id`),
  FOREIGN KEY (`status_id`) REFERENCES `route_id`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `rate_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rate_value_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `event_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_status_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `first_name` varchar(256) NOT NULL,
  `last_name` varchar(256) NOT NULL,
  `b_date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `owner_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `route_id` int(11) NOT NULL,
  `max_participants` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_id_uindex` (`id`),
  FOREIGN KEY (`owner_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`route_id`) REFERENCES `route`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `event_user_rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `user_comment` text NOT NULL,
  `rate_value_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_user_rate_id_uindex` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`event_id`) REFERENCES `event`(`id`),
  FOREIGN KEY (`rate_value_id`) REFERENCES `rate_value`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `event_user_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_user_map_id_uindex` (`id`),
  FOREIGN KEY (`event_id`) REFERENCES event(`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Дамп данных таблицы phobos_journey_core.route_level: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `route_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_level` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


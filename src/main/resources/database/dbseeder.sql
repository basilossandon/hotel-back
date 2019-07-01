-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 01-07-2019 a las 21:46:19
-- Versión del servidor: 5.6.44
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `service_string` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bill`
--

INSERT INTO `bill` (`id`, `room_id`, `service_string`) VALUES
(5, 3, '30'),
(4, 1, '1;1;30;30;2;5;5;29;28'),
(6, 5, '30;1;1'),
(7, 26, NULL),
(8, 43, '1;1;30;30'),
(9, 1, '30;15;15;2;2'),
(10, 1, '1;1'),
(11, 2, NULL),
(12, 2, NULL),
(13, 6, NULL),
(14, 6, NULL),
(15, 6, NULL),
(16, 1, '30;30;30;30;30;30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill_service`
--

DROP TABLE IF EXISTS `bill_service`;
CREATE TABLE IF NOT EXISTS `bill_service` (
  `service_id` int(11) NOT NULL,
  `bill_id` int(11) NOT NULL,
  PRIMARY KEY (`service_id`,`bill_id`),
  KEY `FK2fl3xufw7xy6jrymk1ygwvhwv` (`bill_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `document_number` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmn5wmdw1q3crtlr9alcosfmqd` (`reservation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `member`
--

INSERT INTO `member` (`id`, `age`, `code`, `country`, `document_number`, `name`, `reservation_id`) VALUES
(1, 22, '7YWJOV18', 'Albania', '19124', 'Leandro', 1),
(2, 21, 'T7WRSUHE', 'Chile', '19.753.546-6', 'Gabriel', 2),
(3, 22, 'ZSU2UUTY', 'Afganistán', '123', 'Test1', 3),
(11, 23, '94IVT8VR', 'Afganistán', '123', '123', 12),
(12, 23, '4DP1K22Y', 'Afganistán', '23', '23', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` int(11) DEFAULT NULL,
  `checkin_name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `document_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `end` datetime NOT NULL,
  `room_id` int(11) NOT NULL,
  `start` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reservation`
--

INSERT INTO `reservation` (`id`, `bill_id`, `checkin_name`, `code`, `document_number`, `email`, `end`, `room_id`, `start`) VALUES
(12, 12, 'asd', 'KTHAQ58E', '123', 'mailNoIngresado@reservadirecta.checkin', '2019-07-02 04:00:00', 2, '2019-07-01 04:00:00'),
(15, NULL, 'Gabriel Gaete', '67KRZ72I', '197535466', 'gabriel.gaete.l@usach.cl', '2019-07-03 04:00:00', 3, '2019-07-01 04:00:00'),
(8, NULL, 'Leandro', 'LOKQ8FB2', '192642264', 'mailNoIngresado@reservadirecta.checkin', '2019-07-06 04:00:00', 9, '2019-07-02 04:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation_room`
--

DROP TABLE IF EXISTS `reservation_room`;
CREATE TABLE IF NOT EXISTS `reservation_room` (
  `reservation_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  PRIMARY KEY (`reservation_id`,`room_id`),
  KEY `FKe368pj2d58a8xx37fk8p6k1jl` (`room_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`id`, `capacity`, `price`, `type`) VALUES
(1, 3, 10000, 'Simple'),
(2, 2, 20000, 'Doble'),
(3, 1, 10000, 'Simple'),
(4, 2, 20000, 'Doble'),
(5, 1, 10000, 'Simple'),
(6, 3, 35000, 'Triple'),
(7, 4, 45000, 'Matrimonial'),
(8, 4, 45000, 'Matrimonial'),
(9, 1, 10000, 'Simple'),
(10, 1, 10000, 'Simple'),
(11, 1, 10000, 'Simple'),
(12, 2, 20000, 'Doble'),
(13, 3, 35000, 'Triple'),
(14, 2, 20000, 'Doble'),
(15, 4, 45000, 'Matrimonial'),
(16, 1, 10000, 'Simple'),
(17, 4, 45000, 'Matrimonial'),
(18, 2, 20000, 'Doble'),
(19, 4, 45000, 'Matrimonial'),
(20, 3, 35000, 'Triple'),
(21, 4, 45000, 'Matrimonial'),
(22, 3, 35000, 'Triple'),
(23, 2, 20000, 'Doble'),
(24, 3, 35000, 'Triple'),
(25, 1, 10000, 'Simple'),
(26, 1, 10000, 'Simple'),
(27, 3, 35000, 'Triple'),
(28, 1, 10000, 'Simple'),
(29, 2, 20000, 'Doble'),
(30, 2, 20000, 'Doble'),
(31, 2, 20000, 'Doble'),
(32, 4, 45000, 'Matrimonial'),
(33, 2, 20000, 'Doble'),
(34, 2, 20000, 'Doble'),
(35, 3, 35000, 'Triple'),
(36, 2, 20000, 'Doble'),
(37, 3, 35000, 'Triple'),
(38, 2, 20000, 'Doble'),
(39, 3, 35000, 'Triple'),
(40, 2, 20000, 'Doble'),
(41, 4, 45000, 'Matrimonial'),
(42, 3, 35000, 'Triple'),
(43, 1, 10000, 'Simple'),
(44, 1, 10000, 'Simple'),
(45, 1, 10000, 'Simple'),
(46, 2, 20000, 'Doble'),
(47, 3, 35000, 'Triple'),
(48, 4, 45000, 'Matrimonial'),
(49, 1, 10000, 'Simple'),
(50, 2, 20000, 'Doble');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room_service`
--

DROP TABLE IF EXISTS `room_service`;
CREATE TABLE IF NOT EXISTS `room_service` (
  `room_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  PRIMARY KEY (`room_id`,`service_id`),
  KEY `FKcusrgukg8xtfj4u8x96473m6d` (`service_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room_type`
--

DROP TABLE IF EXISTS `room_type`;
CREATE TABLE IF NOT EXISTS `room_type` (
  `room_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`room_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `service`
--

INSERT INTO `service` (`id`, `category`, `name`, `price`) VALUES
(2, 'Sopas y cremas', 'Sopa de verduras frescas', 63),
(3, 'Entradas', 'Láminas de lomo', 89),
(4, 'Entradas', 'Empanadas marineras', 58),
(5, 'Entradas', 'Tabla de quesos', 148),
(6, 'Especialidades saludables', 'Ensalada de frutos frescos', 63),
(7, 'Especialidades saludables', 'Ensalada portuguesa', 130),
(8, 'Especialidades saludables', 'Ensalada veraniega', 110),
(9, 'Pescados y mariscos', 'Salmón atlántico', 172),
(1, 'Sopas y cremas', 'Crema de tomate Benevento', 58),
(10, 'Pescados y mariscos', 'Pesca en altamar', 204),
(11, 'Pastas y arroces', 'Arroz mandarín', 113),
(12, 'Pastas y arroces', ' Penne rigate', 110),
(13, 'Pastas y arroces', 'Espaguetti pomodoro', 110),
(14, 'Pastas y arroces', 'Raviolis de queso y espinaca', 110),
(15, 'Pastas y arroces', 'Risotto de calabaza', 115),
(16, 'Carnes', 'Beef de la pampa argentina', 145),
(17, 'Carnes', 'Lomo de res Portobello', 131),
(18, 'Carnes', 'Milanesa a la napolitana', 115),
(19, 'Carnes', 'Pollo Madeira', 128),
(20, 'Sándwich y hamburguesas', 'Hamburguesa de la casa', 118),
(21, 'Sándwich y hamburguesas', 'Hamburguesa vegetariana', 113),
(22, 'Sándwich y hamburguesas', 'Panini Milano', 114),
(23, 'Sándwich y hamburguesas', 'Sándwich Victoria ', 110),
(24, 'Menú Infantil', 'Pequeño Nemo', 72),
(25, 'Menú Infantil', 'Mini hambuguesa', 92),
(26, 'Menú Infantil', 'Papas francesas', 77),
(27, 'Bebestibles', 'Jugo de fruta', 27),
(28, 'Bebestibles', 'Vino Blanco', 272),
(29, 'Bebestibles', 'Vino Rosado', 272),
(30, 'Bebestibles', 'Espumante', 300);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

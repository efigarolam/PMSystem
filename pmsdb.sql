-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 13-11-2011 a las 00:53:20
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de datos: `pmsdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pms_messages`
--

DROP TABLE IF EXISTS `pms_messages`;
CREATE TABLE IF NOT EXISTS `pms_messages` (
  `ID` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `Sender` mediumint(8) unsigned NOT NULL,
  `Receiver` mediumint(8) unsigned NOT NULL,
  `Subject` varchar(150) NOT NULL,
  `Message` text NOT NULL,
  `Date` datetime NOT NULL,
  `State` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Sender` (`Sender`),
  KEY `Receiver` (`Receiver`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Volcar la base de datos para la tabla `pms_messages`
--

INSERT INTO `pms_messages` (`ID`, `Sender`, `Receiver`, `Subject`, `Message`, `Date`, `State`) VALUES
(1, 1, 2, 'Te quiero mucho', '2011-11-11 07:45:16', '2011-11-11 07:45:16', 'Read'),
(2, 1, 2, 'dasdasdsada', 'dasdsadasdasdsad', '2011-11-11 07:46:40', 'Inactive'),
(3, 2, 1, 'Mensaje de Prueba 1', 'Mensaje de Prueba 1', '2011-11-11 09:51:05', 'Read'),
(5, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsg', '2011-11-11 11:59:10', 'Read'),
(6, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsg', '2011-11-11 11:59:11', 'Read'),
(8, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsg', '2011-11-11 11:59:13', 'Read'),
(9, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsg', '2011-11-11 11:59:13', 'Read'),
(10, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsg', '2011-11-11 11:59:14', 'Read'),
(11, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsgkljlkjlk', '2011-11-11 11:59:16', 'Read'),
(13, 2, 1, 'dgafdg agsfg', 'sfg sdfgdsgkljlkjlk', '2011-11-11 11:59:18', 'Read'),
(14, 2, 1, 'dgafdg agsfgjiokj', 'sfg sdfgdsgkljlkjlk', '2011-11-11 11:59:20', 'Read'),
(15, 2, 1, 'dgafdg agsfgjiokj', 'sfg sdfgdsgkljlkjlk', '2011-11-11 11:59:21', 'Read'),
(16, 2, 1, 'dgafdg agsfgjiokj', 'sfg sdfgdsgkljlkjlk', '2011-11-11 11:59:21', 'Read'),
(17, 1, 2, 'teasdcasd ca', 'sdasdasdadsa', '2011-11-12 12:09:11', 'Inactive'),
(18, 1, 2, 'Re: Mensaje de Prueba 1', 'dsfsdfsdfsdfsdfs', '2011-11-12 03:21:12', 'Inactive'),
(19, 3, 1, 'Hola que tal como estas kalalalalalñaldñald ñslaksañlckh skh ', 'Hola que tal como estas kalalalalalñaldñald ñslaksañlckh skh ', '2011-11-12 03:25:18', 'Read'),
(20, 1, 2, 'Re: dasdasdsada', 'hrfghfdhbfgb', '2011-11-12 03:44:08', 'Inactive'),
(21, 1, 2, 'Re: dasdasdsada', 'xDDDD', '2011-11-12 15:46:18', 'Inactive'),
(22, 2, 1, 'Hola te quiero', 'Mandado desde PMSystem', '2011-11-12 17:15:11', 'Unread'),
(23, 2, 1, 'fdasfsdg fsdgsd', 'vadsgfdasgd', '2011-11-12 17:17:02', 'Unread'),
(24, 1, 2, 'Hola niña', 'Te quiero :)', '2011-11-12 17:28:55', 'Unread'),
(25, 1, 2, 'Correo de prueba', ':************', '2011-11-12 17:39:37', 'Unread');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pms_projects`
--

DROP TABLE IF EXISTS `pms_projects`;
CREATE TABLE IF NOT EXISTS `pms_projects` (
  `ID` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ID_User` mediumint(8) unsigned NOT NULL,
  `Name` varchar(120) NOT NULL,
  `Description` text NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `State` varchar(15) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`ID`),
  KEY `ID_User` (`ID_User`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `pms_projects`
--

INSERT INTO `pms_projects` (`ID`, `ID_User`, `Name`, `Description`, `Start_Date`, `End_Date`, `State`) VALUES
(1, 1, 'Proyecto Integrador', 'El proyecto integrador de quinto semestre.', '2011-08-15', '2011-12-10', 'Active'),
(3, 4, 'reg srtghrthrtdhdr', 'hdhnghjnnmgg', '2011-01-01', '2011-01-01', 'Active'),
(6, 4, 'vaciokakakaka', 'sdfdsfvdsagfvdsv', '2004-01-01', '2004-01-01', 'Active');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pms_tasks`
--

DROP TABLE IF EXISTS `pms_tasks`;
CREATE TABLE IF NOT EXISTS `pms_tasks` (
  `ID` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ID_Project` mediumint(8) unsigned NOT NULL,
  `Title` varchar(120) NOT NULL,
  `Description` text NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `Progress` tinyint(3) NOT NULL,
  `Priority` varchar(6) NOT NULL,
  `Notes` text,
  `State` varchar(15) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`ID`),
  KEY `ID_Project` (`ID_Project`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcar la base de datos para la tabla `pms_tasks`
--

INSERT INTO `pms_tasks` (`ID`, `ID_Project`, `Title`, `Description`, `Start_Date`, `End_Date`, `Progress`, `Priority`, `Notes`, `State`) VALUES
(1, 1, 'Obtención de requerimientos', 'Obtener los requisitos de software', '2011-08-15', '2011-08-20', 100, 'High', '', 'Started'),
(2, 1, 'Arquitectura del Sistema', 'Diseñar el sistema', '2011-08-20', '2011-08-30', 90, 'High', '08/11/11 \nLa tarea lleva el siguiente avance: daldkaslñdksañvfjdsov dsjvidp\n\n\n\n--------\n09/12/11\nEl avance a sido satisfactorio', 'Started'),
(3, 1, 'Diseño de la Interfaz', 'Diseña las gráficas de la interfaz', '2000-01-01', '2000-01-01', 80, 'Urgent', 'Ya saque las PNGS', 'Paused'),
(4, 3, 'ggt gagaga', 'agaggaagag', '2011-01-01', '2011-01-01', 0, 'Urgent', NULL, 'Started'),
(5, 3, 'ggt gagagadsada', 'agaggaagag', '2011-01-01', '2011-01-01', 0, 'Urgent', NULL, 'Started'),
(6, 3, 'ggt gagagadsada2', 'agaggaagag', '2011-01-01', '2011-01-01', 0, 'Urgent', NULL, 'Started'),
(7, 6, 'delvacioalalala', 'csadcsdac2004-01-01', '2004-01-01', '2004-01-01', 0, 'Urgent', NULL, 'Started');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pms_users`
--

DROP TABLE IF EXISTS `pms_users`;
CREATE TABLE IF NOT EXISTS `pms_users` (
  `ID` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(40) NOT NULL,
  `Privilege` varchar(15) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Birthday` date NOT NULL,
  `Location` varchar(60) NOT NULL,
  `State` varchar(15) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `pms_users`
--

INSERT INTO `pms_users` (`ID`, `Username`, `Password`, `Privilege`, `Name`, `Email`, `Gender`, `Birthday`, `Location`, `State`) VALUES
(1, 'Diabulux', '32c1c70c58c74afc470578b92f21db506d6b7db4', 'Administrator', 'Eduardo Figarola Mota', 'lalo.diabulux@gmail.com', 'Male', '1991-09-11', 'Colima', 'Active'),
(2, 'Amaidiz', 'f607ca9e1067d1c437d1bfd6c1a9c7038e5d55cf', 'Administrator', 'Eneida Sánchez', 'eneida430@gmail.com', 'Female', '1991-12-18', 'Colima', 'Active'),
(3, 'Ana Alicia', 'ac5b030992e73c6c9122243a5625380c2ffef28f', 'Administrator', 'Ana Alicia González Mendieta', 'anaglezmta@gmail.com', 'Female', '1991-03-22', 'Colima', 'Active'),
(4, 'Joeluyo', '32c1c70c58c74afc470578b92f21db506d6b7db4', 'User', 'Joel Hernández Gutiérrez', 'joel.hernandezg@gmail.com', 'Male', '1991-02-23', 'Colima', 'Active');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pms_usersonline`
--

DROP TABLE IF EXISTS `pms_usersonline`;
CREATE TABLE IF NOT EXISTS `pms_usersonline` (
  `ID` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ID_User` mediumint(8) unsigned NOT NULL,
  `Start_Date` datetime DEFAULT NULL,
  `End_Date` datetime DEFAULT NULL,
  `State` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_User` (`ID_User`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=111 ;

--
-- Volcar la base de datos para la tabla `pms_usersonline`
--

INSERT INTO `pms_usersonline` (`ID`, `ID_User`, `Start_Date`, `End_Date`, `State`) VALUES
(1, 1, '2011-11-11 03:49:00', '2011-11-11 03:49:00', 'Inactive'),
(2, 1, '2011-11-11 03:50:00', '2011-11-11 03:51:00', 'Inactive'),
(3, 1, '2011-11-11 03:52:07', '2011-11-11 04:00:41', 'Inactive'),
(4, 1, '2011-11-11 03:59:22', '2011-11-11 04:00:41', 'Inactive'),
(5, 1, '2011-11-11 04:00:39', '2011-11-11 04:00:41', 'Inactive'),
(6, 1, '2011-11-11 04:01:17', '2011-11-11 04:01:45', 'Inactive'),
(7, 1, '2011-11-11 07:29:06', '2011-11-11 07:29:56', 'Inactive'),
(8, 1, '2011-11-11 07:30:22', '2011-11-11 07:30:49', 'Inactive'),
(9, 1, '2011-11-11 07:54:27', '2011-11-11 07:56:37', 'Inactive'),
(10, 1, '2011-11-11 09:10:49', '2011-11-11 09:13:03', 'Inactive'),
(11, 1, '2011-11-11 10:21:54', '2011-11-11 10:22:44', 'Inactive'),
(12, 1, '2011-11-11 10:27:03', '2011-11-11 10:27:40', 'Inactive'),
(13, 1, '2011-11-11 10:31:20', '2011-11-11 10:33:11', 'Inactive'),
(14, 1, '2011-11-11 10:34:19', '2011-11-11 10:35:26', 'Inactive'),
(16, 1, '2011-11-11 11:43:29', '2011-11-11 11:45:11', 'Inactive'),
(17, 1, '2011-11-11 05:30:52', '2011-11-11 05:31:01', 'Inactive'),
(18, 1, '2011-11-11 05:32:12', '2011-11-11 05:34:32', 'Inactive'),
(19, 1, '2011-11-11 05:53:22', '2011-11-11 05:54:16', 'Inactive'),
(20, 1, '2011-11-11 07:36:57', '2011-11-11 07:37:10', 'Inactive'),
(21, 1, '2011-11-11 07:40:37', '2011-11-11 07:45:49', 'Inactive'),
(22, 1, '2011-11-11 07:45:03', '2011-11-11 07:45:49', 'Inactive'),
(23, 1, '2011-11-11 07:46:32', '2011-11-11 07:48:08', 'Inactive'),
(24, 1, '2011-11-11 07:56:15', '2011-11-11 07:56:44', 'Inactive'),
(25, 1, '2011-11-11 07:58:03', '2011-11-11 07:58:12', 'Inactive'),
(26, 1, '2011-11-11 08:00:32', '2011-11-11 08:00:51', 'Inactive'),
(27, 1, '2011-11-11 08:02:58', '2011-11-11 08:03:31', 'Inactive'),
(28, 1, '2011-11-11 08:03:51', '2011-11-11 08:04:42', 'Inactive'),
(29, 1, '2011-11-11 08:10:29', '2011-11-11 08:11:25', 'Inactive'),
(30, 1, '2011-11-11 08:12:31', '2011-11-11 08:13:21', 'Inactive'),
(31, 1, '2011-11-11 08:15:08', '2011-11-11 08:16:50', 'Inactive'),
(32, 1, '2011-11-11 08:18:53', '2011-11-11 08:19:32', 'Inactive'),
(33, 1, '2011-11-11 08:24:19', '2011-11-11 08:24:44', 'Inactive'),
(34, 1, '2011-11-11 08:25:37', '2011-11-11 08:25:54', 'Inactive'),
(35, 1, '2011-11-11 08:30:14', '2011-11-11 08:30:55', 'Inactive'),
(36, 1, '2011-11-11 08:32:17', '2011-11-11 08:33:44', 'Inactive'),
(37, 1, '2011-11-11 08:37:56', '2011-11-11 08:39:00', 'Inactive'),
(38, 1, '2011-11-11 08:43:52', '2011-11-11 08:47:30', 'Inactive'),
(39, 1, '2011-11-11 09:04:53', '2011-11-11 09:23:50', 'Inactive'),
(40, 1, '2011-11-11 09:10:09', '2011-11-11 09:23:50', 'Inactive'),
(41, 1, '2011-11-11 09:13:37', '2011-11-11 09:23:50', 'Inactive'),
(42, 1, '2011-11-11 09:17:21', '2011-11-11 09:23:50', 'Inactive'),
(43, 1, '2011-11-11 09:25:30', '2011-11-11 09:27:04', 'Inactive'),
(44, 1, '2011-11-11 09:28:55', '2011-11-11 09:29:27', 'Inactive'),
(45, 2, '2011-11-11 09:50:49', '2011-11-11 09:51:16', 'Inactive'),
(46, 1, '2011-11-11 09:51:19', '2011-11-11 09:52:32', 'Inactive'),
(47, 1, '2011-11-11 09:52:43', '2011-11-11 09:55:26', 'Inactive'),
(48, 1, '2011-11-11 09:55:37', '2011-11-11 09:55:52', 'Inactive'),
(49, 1, '2011-11-11 09:56:23', '2011-11-11 09:57:57', 'Inactive'),
(50, 1, '2011-11-11 09:57:26', '2011-11-11 09:57:57', 'Inactive'),
(51, 1, '2011-11-11 09:58:07', '2011-11-11 09:59:20', 'Inactive'),
(52, 1, '2011-11-11 09:59:31', '2011-11-11 09:59:45', 'Inactive'),
(53, 1, '2011-11-11 10:00:40', '2011-11-11 10:02:00', 'Inactive'),
(54, 1, '2011-11-11 10:01:48', '2011-11-11 10:02:00', 'Inactive'),
(55, 1, '2011-11-11 10:05:24', '2011-11-11 10:05:35', 'Inactive'),
(56, 1, '2011-11-11 10:06:45', '2011-11-11 10:22:51', 'Inactive'),
(57, 1, '2011-11-11 10:08:01', '2011-11-11 10:22:51', 'Inactive'),
(58, 1, '2011-11-11 10:23:26', '2011-11-11 10:27:54', 'Inactive'),
(59, 1, '2011-11-11 10:29:39', '2011-11-11 10:31:06', 'Inactive'),
(60, 1, '2011-11-11 11:19:55', '2011-11-11 11:21:53', 'Inactive'),
(61, 1, '2011-11-11 11:22:14', '2011-11-11 11:29:03', 'Inactive'),
(62, 1, '2011-11-11 11:29:12', '2011-11-11 11:29:27', 'Inactive'),
(63, 1, '2011-11-11 11:39:36', '2011-11-11 11:39:58', 'Inactive'),
(64, 1, '2011-11-11 11:44:23', '2011-11-11 11:45:29', 'Inactive'),
(65, 1, '2011-11-11 11:46:04', '2011-11-11 11:50:03', 'Inactive'),
(66, 1, '2011-11-11 11:50:29', '2011-11-11 11:51:31', 'Inactive'),
(67, 1, '2011-11-11 11:51:52', '2011-11-11 11:52:43', 'Inactive'),
(68, 2, '2011-11-11 11:59:01', '2011-11-11 11:59:51', 'Inactive'),
(69, 1, '2011-11-11 11:59:56', '2011-11-12 12:04:52', 'Inactive'),
(70, 1, '2011-11-12 12:08:57', '2011-11-12 12:09:25', 'Inactive'),
(71, 1, '2011-11-12 12:11:30', '2011-11-12 12:11:39', 'Inactive'),
(72, 1, '2011-11-12 12:12:41', '2011-11-12 12:14:42', 'Inactive'),
(73, 1, '2011-11-12 12:13:51', '2011-11-12 12:14:42', 'Inactive'),
(74, 1, '2011-11-12 12:19:26', '2011-11-12 12:21:12', 'Inactive'),
(75, 1, '2011-11-12 12:31:42', '2011-11-12 12:32:19', 'Inactive'),
(76, 1, '2011-11-12 12:32:25', '2011-11-12 12:33:00', 'Inactive'),
(77, 1, '2011-11-12 12:33:12', '2011-11-12 12:33:43', 'Inactive'),
(78, 1, '2011-11-12 12:34:14', '2011-11-12 12:34:48', 'Inactive'),
(79, 1, '2011-11-12 12:37:00', '2011-11-12 12:37:35', 'Inactive'),
(80, 1, '2011-11-12 12:38:03', '2011-11-12 12:38:31', 'Inactive'),
(81, 1, '2011-11-12 02:52:33', '2011-11-12 02:52:49', 'Inactive'),
(82, 1, '2011-11-12 02:56:54', '2011-11-12 02:58:23', 'Inactive'),
(83, 1, '2011-11-12 03:02:37', '2011-11-12 03:02:59', 'Inactive'),
(84, 1, '2011-11-12 03:12:38', '2011-11-12 03:13:14', 'Inactive'),
(85, 1, '2011-11-12 03:13:55', '2011-11-12 03:14:20', 'Inactive'),
(86, 1, '2011-11-12 03:15:55', '2011-11-12 03:16:54', 'Inactive'),
(87, 1, '2011-11-12 03:20:31', '2011-11-12 03:22:07', 'Inactive'),
(88, 1, '2011-11-12 03:23:31', '2011-11-12 03:24:11', 'Inactive'),
(89, 3, '2011-11-12 03:24:56', '2011-11-12 03:25:31', 'Inactive'),
(90, 1, '2011-11-12 03:25:37', '2011-11-12 03:26:07', 'Inactive'),
(91, 1, '2011-11-12 03:26:42', '2011-11-12 03:27:08', 'Inactive'),
(92, 1, '2011-11-12 03:29:20', '2011-11-12 03:29:41', 'Inactive'),
(93, 1, '2011-11-12 03:32:00', '2011-11-12 03:32:38', 'Inactive'),
(94, 1, '2011-11-12 03:33:21', '2011-11-12 03:33:48', 'Inactive'),
(95, 1, '2011-11-12 03:35:54', '2011-11-12 03:36:08', 'Inactive'),
(96, 1, '2011-11-12 03:36:44', '2011-11-12 03:37:42', 'Inactive'),
(97, 1, '2011-11-12 03:37:54', '2011-11-12 03:38:33', 'Inactive'),
(98, 1, '2011-11-12 03:39:03', '2011-11-12 03:39:31', 'Inactive'),
(99, 1, '2011-11-12 03:40:06', '2011-11-12 03:43:17', 'Inactive'),
(100, 1, '2011-11-12 03:42:40', '2011-11-12 03:43:17', 'Inactive'),
(101, 1, '2011-11-12 03:43:51', '2011-11-12 03:45:13', 'Inactive'),
(102, 1, '2011-11-12 15:46:05', '2011-11-12 15:46:54', 'Inactive'),
(103, 1, '2011-11-12 15:48:03', '2011-11-12 15:48:46', 'Inactive'),
(104, 1, '2011-11-12 17:14:38', '2011-11-12 17:14:42', 'Inactive'),
(105, 2, '2011-11-12 17:14:49', '2011-11-12 17:17:07', 'Inactive'),
(106, 2, '2011-11-12 17:16:52', '2011-11-12 17:17:07', 'Inactive'),
(107, 1, '2011-11-12 17:17:10', '2011-11-12 17:17:21', 'Inactive'),
(108, 1, '2011-11-12 17:28:37', '2011-11-12 17:29:12', 'Inactive'),
(109, 2, '2011-11-12 17:29:18', '2011-11-12 17:30:02', 'Inactive'),
(110, 1, '2011-11-12 17:39:21', '2011-11-12 17:41:47', 'Inactive');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pms_userstasks`
--

DROP TABLE IF EXISTS `pms_userstasks`;
CREATE TABLE IF NOT EXISTS `pms_userstasks` (
  `ID` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ID_User` mediumint(8) unsigned NOT NULL,
  `ID_Task` mediumint(8) unsigned NOT NULL,
  `ID_Project` mediumint(8) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_User` (`ID_User`),
  KEY `ID_Task` (`ID_Task`),
  KEY `ID_Project` (`ID_Project`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Volcar la base de datos para la tabla `pms_userstasks`
--

INSERT INTO `pms_userstasks` (`ID`, `ID_User`, `ID_Task`, `ID_Project`) VALUES
(8, 3, 1, 1),
(15, 1, 2, 1),
(16, 4, 3, 1),
(17, 1, 4, 3),
(18, 1, 5, 3),
(19, 1, 6, 3),
(20, 4, 7, 6);

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `pms_messages`
--
ALTER TABLE `pms_messages`
  ADD CONSTRAINT `pms_messages_ibfk_2` FOREIGN KEY (`Receiver`) REFERENCES `pms_users` (`ID`),
  ADD CONSTRAINT `pms_messages_ibfk_1` FOREIGN KEY (`Sender`) REFERENCES `pms_users` (`ID`);

--
-- Filtros para la tabla `pms_projects`
--
ALTER TABLE `pms_projects`
  ADD CONSTRAINT `pms_projects_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `pms_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pms_tasks`
--
ALTER TABLE `pms_tasks`
  ADD CONSTRAINT `pms_tasks_ibfk_1` FOREIGN KEY (`ID_Project`) REFERENCES `pms_projects` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pms_usersonline`
--
ALTER TABLE `pms_usersonline`
  ADD CONSTRAINT `pms_usersonline_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `pms_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pms_userstasks`
--
ALTER TABLE `pms_userstasks`
  ADD CONSTRAINT `pms_userstasks_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `pms_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pms_userstasks_ibfk_2` FOREIGN KEY (`ID_Task`) REFERENCES `pms_tasks` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pms_userstasks_ibfk_3` FOREIGN KEY (`ID_Project`) REFERENCES `pms_projects` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `autentify`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `autentify`(
_Username VARCHAR(30),
_Password VARCHAR(40)
)
BEGIN
	IF(EXISTS(SELECT ID FROM pms_users WHERE Username = _Username AND Password = _Password)) THEN
		SELECT TRUE as Successful;
	ELSE
		SELECT FALSE as Sucessful;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `setProject`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `setProject`(
_ID_User MEDIUMINT(8),
_Name VARCHAR(120),
_Description TEXT,
_Start_Date DATE,
_End_Date DATE,
_State VARCHAR(15)
)
BEGIN
	DECLARE _Last_ID MEDIUMINT(8);

	IF(EXISTS(SELECT ID FROM pms_projects WHERE Name = _Name)) THEN
		SELECT TRUE as Project_Exists;
	ELSE
		INSERT INTO pms_projects (ID_User, Name, Description, Start_Date, End_Date, State) VALUES (_ID_User, _Name, _Description, _Start_Date, _End_Date, _State);
		SET _LAST_ID = LAST_INSERT_ID();
		SELECT _LAST_ID as ID;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `setTask`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `setTask`(
_ID_Project MEDIUMINT(8),
_Title VARCHAR(120),
_Description TEXT,
_Start_Date DATE,
_End_Date DATE,
_Progress TEXT,
_Priority VARCHAR(6),
_State VARCHAR(15)
)
BEGIN
	DECLARE _Last_ID MEDIUMINT(8);

	IF(EXISTS(SELECT ID FROM pms_tasks WHERE Title = _Title AND ID_Project = _ID_Project)) THEN
		SELECT TRUE as Task_Exists;
	ELSE
		INSERT INTO pms_tasks (ID_Project, Title, Description, Start_Date, End_Date, Progress, Priority, State) VALUES (_ID_Project, _Title, _Description, _Start_Date, _End_Date, _Progress, _Priority, _State);
		SET _LAST_ID = LAST_INSERT_ID();
		SELECT _LAST_ID as ID;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `setUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `setUser`(
_Username VARCHAR(30),
_Password VARCHAR(40),
_Privilege VARCHAR(15),
_Name VARCHAR(60),
_Email VARCHAR(60),
_Gender VARCHAR(10),
_Birthday DATE,
_Location VARCHAR(60),
_State VARCHAR(15)
)
BEGIN
	DECLARE _Last_ID MEDIUMINT(8);

	IF(EXISTS(SELECT ID FROM pms_users WHERE Email = _Email)) THEN
		SELECT TRUE as Email_Exists;
	ELSEIF(EXISTS(SELECT ID FROM pms_users WHERE Username = _Username)) THEN
		SELECT TRUE as Username_Exists;
	ELSE
		INSERT INTO pms_users (Username, Password, Privilege, Name, Email, Gender, Birthday, Location, State) VALUES (_Username, _Password, _Privilege, _Name, _Email, _Gender, _Birthday, _Location, _State);
		SET _LAST_ID = LAST_INSERT_ID();
		SELECT _LAST_ID as ID;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `setUserTask`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `setUserTask`(
_ID_User MEDIUMINT(8),
_ID_Task MEDIUMINT(8),
_ID_Project MEDIUMINT(8)
)
BEGIN
	DECLARE _Last_ID MEDIUMINT(8);

	INSERT INTO pms_userstasks (ID_User, ID_Task, ID_Project) VALUES (_ID_User, _ID_Task, _ID_Project);
	SET _LAST_ID = LAST_INSERT_ID();
	SELECT _LAST_ID as ID;
END$$

DROP PROCEDURE IF EXISTS `updateProgressTask`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProgressTask`(
_ID MEDIUMINT(8),
_Progress TINYINT(3),
_Notes TEXT,
_State VARCHAR(15)
)
BEGIN
	IF(EXISTS(SELECT ID FROM pms_tasks WHERE ID = _ID)) THEN
		UPDATE pms_tasks SET Progress = _Progress, Notes = _Notes, State = _State WHERE ID = _ID;
		SELECT _ID as ID;
	ELSE
		SELECT TRUE as Task_Not_Exists;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `updateProject`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProject`(
_ID MEDIUMINT(8),
_ID_User VARCHAR(30),
_Name VARCHAR(120),
_Description TEXT,
_Start_Date DATE,
_End_Date DATE,
_State VARCHAR(15)
)
BEGIN
	IF(EXISTS(SELECT ID FROM pms_projects WHERE ID = _ID)) THEN
		IF(NOT EXISTS(SELECT ID FROM pms_projects WHERE Name = _Name AND ID <> _ID)) THEN
			UPDATE pms_projects SET ID_User = _ID_User, Name = _Name, Description = _Description, Start_Date = _Start_Date, End_Date = _End_Date, State = _State WHERE ID = _ID;
			SELECT _ID as ID;
		ELSE
			SELECT TRUE as Project_Exists;
		END IF;
	ELSE
		SELECT TRUE as Project_Not_Exists;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `updateTask`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateTask`(
_ID MEDIUMINT(8),
_ID_Project MEDIUMINT(8),
_Title VARCHAR(120),
_Description TEXT,
_Start_Date DATE,
_End_Date DATE,
_Progress TINYINT(3),
_Priority VARCHAR(6),
_State VARCHAR(15)
)
BEGIN
	IF(EXISTS(SELECT ID FROM pms_tasks WHERE ID = _ID)) THEN
		IF(NOT EXISTS(SELECT ID FROM pms_tasks WHERE Title = _Title AND ID <> _ID)) THEN
			UPDATE pms_tasks SET ID_Project = _ID_Project, Title = _Title, Description = _Description, Start_Date = _Start_Date, End_Date = _End_Date, Progress = _Progress, Priority = _Priority, State = _State WHERE ID = _ID;
			SELECT _ID as ID;
		ELSE
			SELECT TRUE as Task_Exists;
		END IF;
	ELSE
		SELECT TRUE as Task_Not_Exists;
	END IF;
END$$

DROP PROCEDURE IF EXISTS `updateUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser`(
_ID MEDIUMINT(8),
_Username VARCHAR(30),
_Password VARCHAR(40),
_Privilege VARCHAR(15),
_Name VARCHAR(60),
_Email VARCHAR(60),
_Gender VARCHAR(10),
_Birthday VARCHAR(30),
_Location VARCHAR(60),
_State VARCHAR(15)
)
BEGIN
	IF(EXISTS(SELECT ID FROM pms_users WHERE ID = _ID)) THEN
		IF(NOT EXISTS(SELECT ID FROM pms_users WHERE Username = _Username AND ID <> _ID)) THEN
			IF(NOT EXISTS(SELECT ID FROM pms_users WHERE Email = _Email AND ID <> _ID)) THEN				
				IF(_Password <> "") THEN
					UPDATE pms_users SET Username = _Username, Password = _Password, Name = _Name, Email = _Email, Gender = _Gender, Birthday = _Birthday, Location = _Location, State = _State WHERE ID = _ID;
				ELSE
					UPDATE pms_users SET Username = _Username, Name = _Name, Email = _Email, Gender = _Gender, Birthday = _Birthday, Location = _Location, State = _State WHERE ID = _ID;
				END IF;

				SELECT _ID as ID;
			ELSE
				SELECT TRUE as Email_Exists;
			END IF;
		ELSE
			SELECT TRUE as Username_Exists;
		END IF;
	ELSE
		SELECT TRUE as User_Not_Exists;
	END IF;
END$$

DELIMITER ;


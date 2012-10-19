-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-11-2011 a las 11:08:13
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

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
  KEY `Sender` (`Sender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `pms_messages`
--


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `pms_projects`
--


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `pms_tasks`
--


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
  `Birthday` date DEFAULT NULL,
  `Location` varchar(60) NOT NULL,
  `State` varchar(15) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `pms_users`
--

INSERT INTO `pms_users` (`ID`, `Username`, `Password`, `Privilege`, `Name`, `Email`, `Gender`, `Birthday`, `Location`, `State`) VALUES
(1, 'Diabulux', '32c1c70c58c74afc470578b92f21db506d6b7db4', 'Administrator', 'Eduardo Figarola Mota', 'lalo.diabulux@gmail.com', 'Male', '1991-09-11', 'Colima', 'Active');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `pms_usersonline`
--


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `pms_userstasks`
--


--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `pms_messages`
--
ALTER TABLE `pms_messages`
  ADD CONSTRAINT `pms_messages_ibfk_3` FOREIGN KEY (`Sender`) REFERENCES `pms_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

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
					UPDATE pms_users SET Username = _Username, Password = _Password, Privilege = _Privilege, Name = _Name, Email = _Email, Gender = _Gender, Birthday = _Birthday, Location = _Location, State = _State WHERE ID = _ID;
				ELSE
					UPDATE pms_users SET Username = _Username, Privilege = _Privilege, Name = _Name, Email = _Email, Gender = _Gender, Birthday = _Birthday, Location = _Location, State = _State WHERE ID = _ID;
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

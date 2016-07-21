-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2014 at 05:07 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `prustaging`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `my_proc`()
BEGIN
  DECLARE cnt INT;
CREATE TEMPORARY TABLE tbl (NumofEmpAvail INT null,DateAvail DATE null);
SET cnt := 0;
While cnt <= 60
Do
INSERT tbl select 
(
    select count(*) from
    (
  select `EmployeeId` from `employeeavailability` where DATEDIFF(DATE_ADD(CURDATE(),INTERVAL cnt DAY),`DateFrom`) >= 0 and DATEDIFF(DATE_ADD(CURDATE(),INTERVAL cnt DAY),`DateTo`) <= 0 group by `EmployeeId` 
) as count),   DATE_ADD(CURDATE(),INTERVAL cnt DAY);

set cnt := cnt + 1;
end while;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `MiddleName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `AddressLine1` varchar(50) NOT NULL,
  `AddressLine2` varchar(50) DEFAULT NULL,
  `AddressLine3` varchar(50) DEFAULT NULL,
  `AddressLine4` varchar(50) DEFAULT NULL,
  `EmailId` varchar(50) NOT NULL,
  `MobileNumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `CustomerId`, `FirstName`, `MiddleName`, `LastName`, `AddressLine1`, `AddressLine2`, `AddressLine3`, `AddressLine4`, `EmailId`, `MobileNumber`) VALUES
(1, 'pru_c1', 'Joy', 'D', 'Abraham', '1700 E13th Street', 'Apt 16k', 'Cleveland', 'USA', 'joy@yahoo.com', '2168779878'),
(2, 'pru_c2', 'Danieal', 'M', 'Addison', '45-euclid', 'Apt 35', 'Cleveland', 'USA', 'danieal@hotmail.com', '2167892587'),
(3, 'pru_c3', 'Marry', 'C', 'Adam', '1900 Superior', 'Apt 6a', 'Chicago', 'USA', 'marry@gmail.com', '2249878987'),
(4, 'pru_c4', 'Katy', 'Candubhai', 'ALEXANDER', '1200 Memphis', 'Apt 12F', 'Cleveland', 'USA', 'katy@gmail.com', '2167973987'),
(5, 'pru_c5', 'Sandy', 'H', 'ALFSON', 'Fulton', 'Apt 89H', 'Boston', 'USA', 'sandy@gmail.com', '2167440675');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `EmployeeId` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `MiddleName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `AddressLine1` varchar(50) DEFAULT NULL,
  `AddressLine2` varchar(50) DEFAULT NULL,
  `AddressLine3` varchar(50) DEFAULT NULL,
  `AddressLine4` varchar(50) DEFAULT NULL,
  `MobileNumber` varchar(10) DEFAULT NULL,
  `EmaildId` varchar(50) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `EmployeeType` varchar(20) NOT NULL,
  `Salary` int(11) NOT NULL,
  `CreationDate` date NOT NULL,
  `IpAddress` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `EmployeeId` (`EmployeeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Id`, `EmployeeId`, `FirstName`, `MiddleName`, `LastName`, `AddressLine1`, `AddressLine2`, `AddressLine3`, `AddressLine4`, `MobileNumber`, `EmaildId`, `DOB`, `EmployeeType`, `Salary`, `CreationDate`, `IpAddress`) VALUES
(1, 'pru1', 'Jaykrushna', 'H', 'Patel', '1700 E13th Street', 'Apt 18H', 'Cleveland', 'USA', '2168553141', 'jk@gmail.com', '1992-01-08', 'Full Time', 5000, '2014-06-28', 'Jaykrushna-PC/174.188.108.21'),
(2, 'pru2', 'Prashant', 'C', 'Patel', '1700 E13th Street', 'Apt 18H', 'Cleveland', 'USA', '2168977896', 'pc@gmail.com', '1990-04-05', 'Full Time', 2500, '2014-06-28', 'Prashant-PC/192.168.124.12'),
(3, 'pru3', 'Ankur', 'M', 'Mantry', '1702 E12th Street', 'Apt 709', 'Cleveland', 'USA', '2168741213', 'ankur@gmail.com', '1992-12-05', 'Full Time', 2500, '2014-07-06', 'Ankur-PC/127.0.0.1'),
(4, 'pru4', 'Monika', 'P', 'ANDREWS', '1200 Memphis', 'Fulton road', 'Cleveland', 'USA', '2167894561', 'monika@hotmail.com', '1992-08-22', 'Full Time', 2000, '2014-07-01', 'Monika -PC/192.168.122.01'),
(5, 'pru5', 'John', 'K', 'ANSON ', '1200 E19th street', 'euclid avenue', 'Cleveland', 'USA', '2164569874', 'john@hotmail.com', '1986-07-17', 'Full Time', 1800, '2014-07-06', 'bhargavi/192.168.0.16'),
(6, 'pru6', 'Emma', 'G', 'ARCHER', 'E 79th street', 'fulton', 'Cleveland', 'USA', '2167891465', 'emma@ymail.com', '1991-06-26', 'Full Time', 2000, '2014-07-06', 'bhargavi/192.168.0.16'),
(7, 'pru12', 'danny', 'd', 'ARNOLD', '1200 E19th street', 'fulton', 'Cleveland', 'USA', '2167440675', 'danny@yahoo.com', '1982-02-28', 'Full Time', 2100, '2014-07-06', 'bhargavi/192.168.0.16');

-- --------------------------------------------------------

--
-- Table structure for table `employeeavailability`
--

CREATE TABLE IF NOT EXISTS `employeeavailability` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `EmployeeId` varchar(50) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
  `Month` varchar(10) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
  `DateFrom` date NOT NULL,
  `DateTo` date NOT NULL,
  `OtherComment` varchar(500) NOT NULL,
  `PostedOn` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `employeeavailability`
--

INSERT INTO `employeeavailability` (`Id`, `EmployeeId`, `Month`, `DateFrom`, `DateTo`, `OtherComment`, `PostedOn`) VALUES
(1, 'pru1', 'August', '1917-12-01', '1911-04-06', 'Avbl', '1910-03-06'),
(2, 'pru1', 'June', '1917-12-01', '1911-04-06', 'swfr5tt', '1910-03-06'),
(3, 'pru1', 'July', '2014-06-17', '2014-06-19', 'gghh', '2014-06-29'),
(4, 'pru4', 'September', '2014-06-10', '2014-06-13', 'servaewrer', '2014-06-29'),
(5, 'pru4', 'January', '2014-07-02', '2014-07-11', '', '2014-07-06'),
(6, 'pru4', 'January', '2014-07-02', '2014-07-11', '', '2014-07-06'),
(7, 'pru4', 'January', '2014-07-02', '2014-07-11', '', '2014-07-06');

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

CREATE TABLE IF NOT EXISTS `ingredient` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `PerUnitPrice` int(11) NOT NULL,
  `UnitOfMeasureId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `ingredient`
--

INSERT INTO `ingredient` (`Id`, `Name`, `Description`, `PerUnitPrice`, `UnitOfMeasureId`) VALUES
(3, 'Salt', 'For test', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `itemingredients`
--

CREATE TABLE IF NOT EXISTS `itemingredients` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ItemId` int(11) NOT NULL,
  `IngredientId` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `LoginType` int(11) DEFAULT NULL,
  `EmployeeId` varchar(50) NOT NULL,
  `IsActive` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Id`, `UserName`, `Password`, `LoginType`, `EmployeeId`, `IsActive`) VALUES
(1, 'jk@gmail.com', 'jk', 1, 'pru1', 1),
(2, 'pc@gmail.com', 'pc', 2, 'pru2', 1),
(3, 'ankur@gmail.com', 'ankur', 2, 'pru3', 1),
(4, 'joy@yahoo.com', 'joy', 3, 'pru_c1', 1),
(5, 'danieal@hotmail.com', 'danieal', 3, 'pru_c2', 1),
(6, 'marry@gmail.com', 'marry', 3, 'pru_c3', 1),
(7, 'monika@hotmail.com', 'monika', 2, 'pru4', 1),
(8, 'katy@gmail.com', 'katy', 3, 'pru_c4', 1),
(9, 'sandy@gmail.com', 'sandy', 3, 'pru_c5', 1),
(10, 'john@hotmail.com', 'john', 2, 'pru5', 1),
(11, 'emma@ymail.com', 'emma', 2, 'pru6', 1),
(12, 'danny@yahoo.com', 'danny', 2, 'pru12', 1);

-- --------------------------------------------------------

--
-- Table structure for table `mainorder`
--

CREATE TABLE IF NOT EXISTS `mainorder` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` varchar(50) NOT NULL,
  `NumOfPerson` int(11) NOT NULL,
  `PicnicDate` date NOT NULL,
  `PicnicPlace` varchar(150) NOT NULL,
  `TotalAmount` int(11) NOT NULL,
  `IsApproved` tinyint(1) NOT NULL,
  `IsPayed` tinyint(1) NOT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `mainorder`
--

INSERT INTO `mainorder` (`OrderId`, `CustomerId`, `NumOfPerson`, `PicnicDate`, `PicnicPlace`, `TotalAmount`, `IsApproved`, `IsPayed`) VALUES
(1, 'pru_c1', 5, '2014-07-10', 'Cleveland', 250, 1, 1),
(2, 'pru_c1', 5, '2014-02-08', 'Cleveland', 250, 1, 1),
(3, 'pru_c1', 8, '2014-07-08', 'Chicago', 430, 1, 1),
(4, 'pru_c3', 8, '2014-12-08', 'Newyork', 440, 0, 0),
(5, 'pru_c5', 10, '2014-08-14', 'Boston', 660, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `manu`
--

CREATE TABLE IF NOT EXISTS `manu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `PerHeadCost` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `manu`
--

INSERT INTO `manu` (`Id`, `Name`, `Description`, `PerHeadCost`) VALUES
(1, 'Maxican', 'Maxican Food', 65),
(2, 'Italian', 'Italian Food', 60),
(3, 'French', 'French Test', 70),
(4, 'Indian', 'Indian test', 90),
(5, 'Chinese', 'Chinese Food', 100),
(6, 'Thai', 'Thai Food', 60),
(7, 'Japanese', 'Japanese Food', 70);

-- --------------------------------------------------------

--
-- Table structure for table `manuitem`
--

CREATE TABLE IF NOT EXISTS `manuitem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `MenuId` int(11) NOT NULL,
  `MenuItemType` varchar(50) DEFAULT NULL,
  `PerHeadCost` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `manuitem`
--

INSERT INTO `manuitem` (`Id`, `Name`, `Description`, `MenuId`, `MenuItemType`, `PerHeadCost`) VALUES
(1, 'Chinese noodles', 'Plain noodles', 5, 'Main Dish', 12),
(4, 'Chow mein', 'Chinese Food', 5, 'Main Dish', 15),
(5, 'Curtido', 'Mexican Food', 1, 'Side Dish', 10),
(6, 'Taco', 'Mexican Food', 1, 'Main Dish', 16),
(7, 'Malai kofata', 'Indian Food', 4, 'Main Dish', 17),
(8, 'Khoya kaju', 'Indian Food', 4, 'Main Dish', 18),
(9, 'Sweet Corn Soup', 'Indian Food', 4, 'Beverages', 10);

-- --------------------------------------------------------

--
-- Table structure for table `manuitems`
--

CREATE TABLE IF NOT EXISTS `manuitems` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MenuId` int(11) NOT NULL,
  `MenuItemId` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE IF NOT EXISTS `orderdetails` (
  `DetailId` int(11) NOT NULL AUTO_INCREMENT,
  `OrderId` int(11) NOT NULL,
  `MenuId` int(11) NOT NULL,
  `Cost` int(11) NOT NULL,
  `NumberofOrder` int(11) NOT NULL,
  PRIMARY KEY (`DetailId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`DetailId`, `OrderId`, `MenuId`, `Cost`, `NumberofOrder`) VALUES
(1, 1, 1, 250, 5),
(2, 2, 1, 250, 5),
(3, 3, 1, 250, 5),
(4, 3, 3, 180, 3),
(5, 4, 1, 200, 4),
(6, 4, 3, 240, 4),
(7, 5, 1, 150, 3),
(8, 5, 3, 120, 2),
(9, 5, 4, 70, 1),
(10, 5, 5, 320, 4);

-- --------------------------------------------------------

--
-- Table structure for table `unitofmeasure`
--

CREATE TABLE IF NOT EXISTS `unitofmeasure` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `Icon` varchar(10) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `unitofmeasure`
--

INSERT INTO `unitofmeasure` (`Id`, `Name`, `Description`, `Icon`) VALUES
(1, 'KG', 'Killo grams', 'Kg'),
(2, 'Packate', 'Packate', 'Pkt');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

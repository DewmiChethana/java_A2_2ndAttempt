-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 06, 2020 at 05:31 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trial_calculation`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Cus_id` int(50) NOT NULL AUTO_INCREMENT,
  `Cus_name` varchar(100) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  PRIMARY KEY (`Cus_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cus_id`, `Cus_name`, `NIC`) VALUES
(1, 'Dewmi', '998754211V'),
(2, 'Sewmi', '954874562V'),
(3, 'Eshini', '024512879V');

-- --------------------------------------------------------

--
-- Table structure for table `trial_calculation`
--

DROP TABLE IF EXISTS `trial_calculation`;
CREATE TABLE IF NOT EXISTS `trial_calculation` (
  `Trial_id` int(11) NOT NULL AUTO_INCREMENT,
  `Cus_id` int(50) NOT NULL,
  `Date` date DEFAULT NULL,
  `Loan_Amount` double NOT NULL,
  `No_Of_Months` int(5) NOT NULL,
  `Interest_Rate` double NOT NULL,
  `Rental_Amount` double NOT NULL,
  PRIMARY KEY (`Trial_id`),
  KEY `User_id` (`Cus_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trial_calculation`
--

INSERT INTO `trial_calculation` (`Trial_id`, `Cus_id`, `Date`, `Loan_Amount`, `No_Of_Months`, `Interest_Rate`, `Rental_Amount`) VALUES
(1, 1, '2020-11-06', 100000, 12, 12, 8884.88),
(2, 2, '2020-11-06', 200000, 24, 15.5, 9744.91),
(3, 3, '2020-11-06', 150000, 12, 8.5, 13082.97);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

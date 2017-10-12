-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2017 at 06:22 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itponline`
--

-- --------------------------------------------------------

--
-- Table structure for table `appliances`
--

CREATE TABLE `appliances` (
  `Serial_No` int(11) NOT NULL,
  `Man_Id` int(11) NOT NULL,
  `Appliance_Type` varchar(500) NOT NULL,
  `Date_Added` date NOT NULL,
  `Waranty` varchar(500) NOT NULL,
  `Price` varchar(500) NOT NULL,
  `Qty` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appliances`
--

INSERT INTO `appliances` (`Serial_No`, `Man_Id`, `Appliance_Type`, `Date_Added`, `Waranty`, `Price`, `Qty`) VALUES
(1, 1, 'Mobile', '2015-06-14', '2 years', '35000', 5);

-- --------------------------------------------------------

--
-- Table structure for table `appliance_manufacturers`
--

CREATE TABLE `appliance_manufacturers` (
  `Man_Id` int(11) NOT NULL,
  `Manufacturer` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appliance_manufacturers`
--

INSERT INTO `appliance_manufacturers` (`Man_Id`, `Manufacturer`) VALUES
(1, 'Sony'),
(2, 'Abans'),
(3, 'Samsung'),
(4, 'Panasonic'),
(5, 'LG'),
(6, 'SINGER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appliances`
--
ALTER TABLE `appliances`
  ADD PRIMARY KEY (`Serial_No`),
  ADD KEY `fk_1` (`Man_Id`);

--
-- Indexes for table `appliance_manufacturers`
--
ALTER TABLE `appliance_manufacturers`
  ADD PRIMARY KEY (`Man_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appliances`
--
ALTER TABLE `appliances`
  MODIFY `Serial_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `appliance_manufacturers`
--
ALTER TABLE `appliance_manufacturers`
  MODIFY `Man_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

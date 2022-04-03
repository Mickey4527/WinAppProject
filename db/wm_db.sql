-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2022 at 05:36 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wm_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `info_product`
--

CREATE TABLE `info_product` (
  `ID` int(11) NOT NULL,
  `Date` text NOT NULL,
  `Name` text NOT NULL,
  `Company` text NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Counter` varchar(100) NOT NULL,
  `Price` double NOT NULL,
  `Qua` int(11) NOT NULL,
  `More` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `info_product`
--

INSERT INTO `info_product` (`ID`, `Date`, `Name`, `Company`, `Type`, `Counter`, `Price`, `Qua`, `More`) VALUES
(13, 'Sun Apr 03 22:08:54 ICT 2022', 'Lenovo ideapad flex 5', 'Lenovo', 'อุปกรณ์อิเล็กทรอนิกส์', 'เครื่อง', 25000, 2, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `info_product`
--
ALTER TABLE `info_product`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `info_product`
--
ALTER TABLE `info_product`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

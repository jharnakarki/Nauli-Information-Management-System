-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2019 at 06:48 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Project`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'jharna', 'jharna'),
(3, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `DateDemo`
--

CREATE TABLE `DateDemo` (
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DateDemo`
--

INSERT INTO `DateDemo` (`date`) VALUES
('2019-06-10');

-- --------------------------------------------------------

--
-- Table structure for table `tckInfo`
--

CREATE TABLE `tckInfo` (
  `InfoID` int(11) NOT NULL,
  `vehNumber` double NOT NULL,
  `brand` varchar(15) NOT NULL,
  `model` double NOT NULL,
  `capacity` int(11) NOT NULL,
  `tyres` int(11) NOT NULL,
  `year` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tckInfo`
--

INSERT INTO `tckInfo` (`InfoID`, `vehNumber`, `brand`, `model`, `capacity`, `tyres`, `year`) VALUES
(1, 12, 'tata', 456, 456, 133, 0000),
(2, 344, 'tata', 132435, 12324, 133, 2075),
(3, 4453, 'art', 23124, 324, 132, 2077),
(4, 1313, 'tata', 242, 34, 23, 2093),
(5, 6879, 'tata', 687, 687, 12, 2076),
(6, 1234, 'tata', 123, 6768, 24, 2075),
(7, 12345, 'tata', 213, 1234, 13, 2075);

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `tripID` int(11) NOT NULL,
  `vehNum` int(11) NOT NULL,
  `dtStart` date NOT NULL,
  `dtEnd` date NOT NULL,
  `maStart` double NOT NULL,
  `maEng` double NOT NULL,
  `origin` varchar(20) NOT NULL,
  `mulDes` text NOT NULL,
  `rev` double NOT NULL,
  `dName` varchar(20) NOT NULL,
  `remarks` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`tripID`, `vehNum`, `dtStart`, `dtEnd`, `maStart`, `maEng`, `origin`, `mulDes`, `rev`, `dName`, `remarks`) VALUES
(1, 7889, '2019-05-08', '2019-05-17', 345687, 5768, 'dhandadhi', 'ktm,brt,dhangadhi', 68798090, 'ram', 'sugar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tckInfo`
--
ALTER TABLE `tckInfo`
  ADD PRIMARY KEY (`InfoID`);

--
-- Indexes for table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`tripID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tckInfo`
--
ALTER TABLE `tckInfo`
  MODIFY `InfoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `trip`
--
ALTER TABLE `trip`
  MODIFY `tripID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

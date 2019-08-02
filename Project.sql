-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 02, 2019 at 08:39 PM
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
  `adminId` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`adminId`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'jharna', 'jharna'),
(4, 'jharna', 'jharna123');

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `brandId` int(11) NOT NULL,
  `brandName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `empId` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `position` varchar(15) NOT NULL,
  `phoneNumber` bigint(10) NOT NULL,
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`empId`, `name`, `position`, `phoneNumber`, `salary`) VALUES
(11, 'jharna karki', 'sales', 9848487442, 123),
(12, 'jharna karki', 'asdfghj', 9848487, 1050000),
(17, 'jkahs', 'ask', 6984, 32),
(18, 'frank', 'shah', 1234567890678, 123),
(28, 'asdfghj', 'Driver Helper', 1234567890, 12),
(29, 'add', 'Accountant', -976, 988),
(30, 'asdfgh', 'Accountant', -9887, 12345),
(32, 'dosa', 'proprietor', 12345678909876543, 567),
(33, 'jharna karki', 'proprietor', 9814610942, 12345),
(34, 'jharna', 'proprietor', 9811223344, 123467),
(35, 'jharna karki', 'proprietor', 9814610941, 1223),
(37, 'jharna', 'Accountant', 9848487441, 123),
(38, 'jharna', 'Accounta', 9804600039, 12345),
(39, 'jharna karki', 'proprietor', 1234567899, 123),
(40, 'jharna karki', 'proprietor', 1234567898, 123);

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `expenseId` int(11) NOT NULL,
  `vehNum` varchar(15) NOT NULL,
  `dates` date NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`expenseId`, `vehNum`, `dates`, `amount`, `remarks`) VALUES
(1, 'na.1.kha.1234', '2019-09-08', 267863, 'gskd'),
(2, 'Na.1.kha.2908', '2019-07-08', 13456, 'maintanance'),
(3, 'na.1.kha1234', '2019-07-02', 123, 'maintenance'),
(4, 'na.1.kha1234', '2019-07-02', 123344, 'maintenance'),
(5, 'na1.kha.6789', '2018-02-12', 2345, 'tyre'),
(6, 'na.1.kha134', '2014-09-09', 1234, 'asdf'),
(7, 'nklsad', '2012-09-08', 233, 'skas'),
(8, 'xxcv', '2012-09-09', 12345, 'sdfg'),
(9, 'Na.1.kha.1235', '2018-09-09', -1213, 'sdfcd'),
(10, 'Dhh134', '2019-08-01', 21, '21'),
(11, 'Na.1.kha.1235', '2019-08-01', 1234567, 'maintanance');

-- --------------------------------------------------------

--
-- Table structure for table `profit/loss`
--

CREATE TABLE `profit/loss` (
  `PLId` int(11) NOT NULL,
  `vehNum` varchar(15) NOT NULL,
  `income` double NOT NULL,
  `expenses` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tckInfo`
--

CREATE TABLE `tckInfo` (
  `vehNumber` varchar(15) NOT NULL,
  `brand` varchar(15) NOT NULL,
  `model` int(7) NOT NULL,
  `capacity` int(11) NOT NULL,
  `tyres` int(11) NOT NULL,
  `year` year(4) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tckInfo`
--

INSERT INTO `tckInfo` (`vehNumber`, `brand`, `model`, `capacity`, `tyres`, `year`, `status`) VALUES
('Dhh134', 'Tata ', 134, 1000, 22, 2017, 'Active'),
('Na.1.kha.1234', 'Tata', 3440, 123667, 18, 2019, ''),
('Na.1.kha.1235', 'Tata', 1234, 100000, 20, 2010, 'Active'),
('Na.1.kha.2345', 'TATA', 2515, 1234, 14, 2071, 'Active'),
('na.1.kha.2907', 'Tata', 123, 34325, 12, 2011, 'Active'),
('Na.1.kha.3456', 'Tata', 2309, 100000, 14, 2016, 'InActive'),
('Na.1.kha.3676', 'TATA', 3245, 1000, 14, 2070, 'Active'),
('Na.1.kha.3678', 'TATA', 3245, 1000, 14, 2071, 'Sold'),
('Na.1.kha.4268', 'tata', 1613, 1198, 12, 2071, ''),
('na.1.kha2345', 'tata', 1234, 100000, 14, 2010, ''),
('na.1.kha4268', 'Tata', 3256, 10000, 12, 2018, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `tripID` int(11) NOT NULL,
  `vehNumber` varchar(15) NOT NULL,
  `dtStart` date NOT NULL,
  `dtEnd` date NOT NULL,
  `maStart` double NOT NULL,
  `maEnd` double NOT NULL,
  `origin` varchar(20) NOT NULL,
  `mulDes` text NOT NULL,
  `rev` double NOT NULL,
  `dName` varchar(20) NOT NULL,
  `remarks` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`tripID`, `vehNumber`, `dtStart`, `dtEnd`, `maStart`, `maEnd`, `origin`, `mulDes`, `rev`, `dName`, `remarks`) VALUES
(5, 'na.1.kha.2345', '2019-07-04', '2019-07-07', 1234, 1241, 'ktm', 'dhn,gandaki', 1234, 'ram', '																														sdf\r\n	jhgkhj				\r\n		'),
(6, 'na.1.kha.2345', '2019-07-02', '2019-07-03', 1234, 12345, 'ktm', 'dhn,gandaki', 134, 'ram', '						sugar\r\n					xdfgh'),
(7, 'na.1.kha.2345', '2019-07-02', '2019-07-03', 123, 1234, 'ktm', 'dhn,gandaki', 134, 'ram', '						wheat\r\n					'),
(8, 'Na.1.kha.1234', '2019-07-04', '2019-07-09', 1234, 12345, 'ktm', 'dhn,gandaki', 12, 'vgh', 'vggj'),
(9, 'Na.1.kha.2345', '2016-02-09', '2016-02-12', 1234, 12309, 'ugh', 'fight', 2300, 'ram', 'sdfg'),
(10, 'Na.1.kha.1235', '2018-09-12', '2018-09-14', 12320, 123456, 'ktm', 'ktm', 1234, 'ram', 'gaskdhks'),
(11, 'Na.1.kha.1235', '2018-01-01', '2018-01-02', 12123, 21324, 'hxjkasd', 'ashok', 27391, 'kasjhd', 'ashkd'),
(12, 'Na.1.kha.1235', '2018-01-01', '2018-01-02', 12123, 21324, 'hxjkasd', 'ashok', 27391, 'kasjhd', 'ashkd'),
(13, 'Na.1.kha.1235', '2018-01-01', '2018-01-02', 12123, 21324, 'hxjkasd', 'ashok', 27391, 'kasjhd', 'ashkd'),
(14, 'Na.1.kha.1235', '2018-01-01', '2018-01-02', 12123, 21324, 'hxjkasd', 'ashok', 27391, 'kasjhd', 'ashkd'),
(15, 'na.1.kha4268', '2019-07-03', '2019-07-16', 123, 12432, 'ktm', 'dhn,gandaki', 22, 'ram', 'sdxs');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`brandId`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`empId`),
  ADD UNIQUE KEY `phoneNumber` (`phoneNumber`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`expenseId`);

--
-- Indexes for table `profit/loss`
--
ALTER TABLE `profit/loss`
  ADD PRIMARY KEY (`PLId`);

--
-- Indexes for table `tckInfo`
--
ALTER TABLE `tckInfo`
  ADD UNIQUE KEY `vehNumber` (`vehNumber`);

--
-- Indexes for table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`tripID`),
  ADD KEY `FK_vehNumber` (`vehNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `brandId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Employee`
--
ALTER TABLE `Employee`
  MODIFY `empId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `expenseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `profit/loss`
--
ALTER TABLE `profit/loss`
  MODIFY `PLId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `trip`
--
ALTER TABLE `trip`
  MODIFY `tripID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `FK_vehNumber` FOREIGN KEY (`vehNumber`) REFERENCES `tckInfo` (`vehNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

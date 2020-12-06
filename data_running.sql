-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2020 at 11:33 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_running`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_event`
--

CREATE TABLE `add_event` (
  `id_add` int(20) NOT NULL,
  `name_event` varchar(100) DEFAULT NULL,
  `name_producer` varchar(100) DEFAULT NULL,
  `date_reg_start` varchar(20) DEFAULT NULL,
  `objective` varchar(2000) DEFAULT NULL,
  `detail` varchar(5000) DEFAULT NULL,
  `date_reg_end` varchar(20) DEFAULT NULL,
  `type` int(1) NOT NULL,
  `pic_event` varchar(200) DEFAULT NULL,
  `name_organizer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `add_event`
--

INSERT INTO `add_event` (`id_add`, `name_event`, `name_producer`, `date_reg_start`, `objective`, `detail`, `date_reg_end`, `type`, `pic_event`, `name_organizer`) VALUES
(1, 'Khonkean Marathon', 'เทศบาลขอนแก่น', '2/2/2020', 'เพื่อให้ประชาชนได้ออกกำลังกายด้วยการเดินและวิ่ง', 'เป็นการจัดวิ่งครั้งยิ่งใหญ่ของขอนแก่น เพื่อดึงดูดนักท่องเที่ยวที่ชอบการวิ่งมาเที่ยวและร่วมกิจกรรมร่วมกัน', '13/2/2020', 1, '0', ''),
(15, 'ก้าวคนละก้าว', 'มูลนิธิก้าวคนละก้าว', '10/03/2561', 'จัดเพื่อช่วยเหลืออุปกรณ์ทางการแพทย์', 'ร่วมวิ่งกับพี่ตูนในระยะกิโลสุดท้ายก่อนเข้าเส้นชัย', '20/03/2561', 1, '0', ''),
(118, 'ก้าวคนละก้าว', 'มูลนิธิก้าวคนละก้าว', '24/9/2020', 'dasdsadsad', 'dsadsada', '26/9/2020', 1, NULL, 'กิตินันท์ คนสอน'),
(119, 'ก้าวคนละก้าว', 'ก้าวคนละก้าว', '24/9/2020', 'sadsad', 'dsadsad', '26/9/2020', 1, NULL, 'gun');

-- --------------------------------------------------------

--
-- Table structure for table `detail_distance`
--

CREATE TABLE `detail_distance` (
  `Detail_id` int(11) NOT NULL,
  `id_add` int(11) NOT NULL,
  `name_event` varchar(40) NOT NULL,
  `Distance_id` varchar(40) NOT NULL,
  `price` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_distance`
--

INSERT INTO `detail_distance` (`Detail_id`, `id_add`, `name_event`, `Distance_id`, `price`) VALUES
(1, 9, 'Khonkean Marathon', '1', '100'),
(2, 9, 'Khonkean Marathon', '2', '200'),
(3, 9, 'Khonkean Marathon', '3', '300'),
(5, 14, 'RUNKKU', '1', '250'),
(6, 14, 'RUNKKU', '2', '400'),
(7, 0, 'aw', 'FUN RUN 4KG', '100'),
(8, 0, 'awwwww', 'MINI MARATHON 11KG', '200');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `image` varchar(500) NOT NULL,
  `tags` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `price_distance`
--

CREATE TABLE `price_distance` (
  `id_price` int(11) NOT NULL,
  `price` varchar(10) NOT NULL,
  `id_distance` int(11) NOT NULL,
  `id_add` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `price_distance`
--

INSERT INTO `price_distance` (`id_price`, `price`, `id_distance`, `id_add`) VALUES
(1, '500', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `reg_address`
--

CREATE TABLE `reg_address` (
  `id_address` int(11) NOT NULL,
  `Address` varchar(500) DEFAULT NULL,
  `District` varchar(100) NOT NULL,
  `MueangDistrict` varchar(100) NOT NULL,
  `Country` varchar(100) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `LName` varchar(20) NOT NULL,
  `Tel` varchar(20) NOT NULL,
  `province` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reg_address`
--

INSERT INTO `reg_address` (`id_address`, `Address`, `District`, `MueangDistrict`, `Country`, `FName`, `LName`, `Tel`, `province`) VALUES
(1, 'aaaaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaa', 'aaaaaaaaaaa'),
(2, 's', 's', 's', 's', 's', 's', 's', 's'),
(3, '113/21', 'nai mung', 'mung', 'Thailand', 'Kitinun ', 'Khonson', '0923956498', 'khonkean'),
(0, 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'd'),
(0, 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z'),
(0, 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'),
(0, 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q'),
(0, 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e'),
(0, 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f');

-- --------------------------------------------------------

--
-- Table structure for table `reg_event`
--

CREATE TABLE `reg_event` (
  `id_event` int(11) NOT NULL,
  `Tel` varchar(20) NOT NULL,
  `id_card` varchar(50) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `blood` varchar(5) NOT NULL,
  `distance` varchar(20) NOT NULL,
  `emergency_contact` varchar(20) NOT NULL,
  `relationship` varchar(10) NOT NULL,
  `tel_emergency` varchar(20) NOT NULL,
  `name_user` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reg_event`
--

INSERT INTO `reg_event` (`id_event`, `Tel`, `id_card`, `nationality`, `blood`, `distance`, `emergency_contact`, `relationship`, `tel_emergency`, `name_user`) VALUES
(1, 'aaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaa', '', ' ', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaa'),
(2, 'aaaaaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaaa', '', ' ', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaaaaa'),
(3, 'aaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaa', '', ' ', 'AAAAAAAAAAAAAAAAA', 'AAAAAAAAAA', 'aaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaa'),
(4, '09233956498', '1300101186415', 'Thai', '', ' ', 'Beer', 'friend', '1150', 'kitinun khonson'),
(5, '', '', '', '', ' ', '', '', '', ''),
(0, 'a', 'a', 'a', '', ' ', 's', 's', 's', 'a'),
(0, 'a', 'a', 'a', '', ' ', 'a', 'a', 'a', 'a'),
(0, 'a', 'a', 'a', '', ' ', 'a', 'a', 'a', 'a'),
(0, 'a', 'a', 'a', '', ' ', 'a', 'a', 'a', 'a'),
(0, 'a', 'a', 'a', '', ' ', 'a', 'a', 'a', 'a'),
(0, 'a', 'a', 'a', '', ' ', 'a', 'a', 'a', 'a'),
(0, 'a', 'a', 'a', '', ' ', 'a', 'a', 'a', 'a'),
(0, 's', 's', 's', '', ' ', 's', 's', 's', 's'),
(0, 'd', 'd', 'd', '', ' ', 'd', 'd', 'd', 'd'),
(0, 'z', 'z', 'z', '', ' ', 'z', 'z', 'z', 'z'),
(0, 'x', 'x', 'x', '', ' ', 'x', 'x', 'x', 'x'),
(0, 'q', 'q', 'q', '', ' ', 'q', 'q', 'q', 'q'),
(0, 'e', 'e', 'e', 'AB', 'HALF MARATHON 21KG', 'e', 'e', 'e', 'e'),
(0, 'f', 'f', 'f', 'B', 'MARATHON 42KG', 'f', 'f', 'ff', 'f');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(4) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `bd_date` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `Status` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `first_name`, `last_name`, `email`, `password`, `gender`, `bd_date`, `type`, `Status`) VALUES
(39, 'kitinun', 'khonson', 'kitinun@kkumail.com', '1234', 'ชาย', '24/9/2020', 'นักวิ่ง', ''),
(41, 'satamp', 'satamp', 'satamp@kkumail.com', '1234', 'ชาย', '24/9/2020', 'ผู้จัดกิจกรรม', ''),
(42, 'kitinun', 'khonson', 'a', 'a', 'ชาย', '24/9/2020', 'ผู้จัดกิจกรรม', ''),
(46, 'kitinun', 'khonson', 'kitinun@kkumail.com', '1998', 'ชาย', '24/9/2020', 'ผู้จัดกิจกรรม', ''),
(47, 'dasd', 'sadas', 'b', 'b', 'ชาย', '5/10/2020', 'นักวิ่ง', '');

-- --------------------------------------------------------

--
-- Table structure for table `user_admin`
--

CREATE TABLE `user_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_admin`
--

INSERT INTO `user_admin` (`id`, `username`, `password`) VALUES
(0, 'admin2', '1234'),
(1, 'admin1', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_event`
--
ALTER TABLE `add_event`
  ADD PRIMARY KEY (`id_add`);

--
-- Indexes for table `detail_distance`
--
ALTER TABLE `detail_distance`
  ADD PRIMARY KEY (`Detail_id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `price_distance`
--
ALTER TABLE `price_distance`
  ADD PRIMARY KEY (`id_price`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_admin`
--
ALTER TABLE `user_admin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_event`
--
ALTER TABLE `add_event`
  MODIFY `id_add` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT for table `detail_distance`
--
ALTER TABLE `detail_distance`
  MODIFY `Detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

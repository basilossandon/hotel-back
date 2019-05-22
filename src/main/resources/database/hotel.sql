-- phpMyAdmin SQL Dump
-- Host: mysql
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `hotel`
--
--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(20) NOT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `final_price` float DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `document_number` varchar(255) DEFAULT NULL,
  `checkin_name` varchar(255) DEFAULT NULL,
  `room_id` int(20) NOT NULL DEFAULT '0',
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_id` int(20) NOT NULL,
  `type` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `capacity` int(20) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`,`room_id`);

-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`);

-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `room_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(20) NOT NULL AUTO_INCREMENT;
COMMIT;

INSERT INTO `hotel`.`roomtype` (`type`,`price` )
  VALUES
  ('Simple', '60000'),
  ('Doble', '80000'),
  ('Matrimonial', '95000');

INSERT INTO `hotel`.`room` (`roomtype_id` )
  VALUES
  ('1'),
  ('2'),
  ('1'),
  ('2'),
  ('2'),
  ('3');
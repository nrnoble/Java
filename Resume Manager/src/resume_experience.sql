-- phpMyAdmin SQL Dump
-- version 4.3.8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 05, 2016 at 07:28 PM
-- Server version: 5.5.42-37.1
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nnoble_301`
--

-- --------------------------------------------------------

--
-- Table structure for table `resume_experience`
--

CREATE TABLE IF NOT EXISTS `resume_experience` (
  `primary` int(11) NOT NULL,
  `fkey` int(11) NOT NULL,
  `job` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `resume_title` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year_started` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year_ended` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `position` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `resume_experience`
--
ALTER TABLE `resume_experience`
  ADD PRIMARY KEY (`primary`), ADD KEY `pkey` (`fkey`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `resume_experience`
--
ALTER TABLE `resume_experience`
  MODIFY `primary` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

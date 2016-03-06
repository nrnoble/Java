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
-- Table structure for table `resume_skill`
--

CREATE TABLE IF NOT EXISTS `resume_skill` (
  `primary` int(11) NOT NULL,
  `fkey` int(11) NOT NULL,
  `skill` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `resume_title` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `resume_skill`
--

INSERT INTO `resume_skill` (`primary`, `fkey`, `skill`, `resume_title`, `description`) VALUES
(1, 45, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(2, 46, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(3, 47, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(4, 48, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(5, 48, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(6, 48, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(7, 48, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(8, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(9, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(10, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(11, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(12, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(13, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(14, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(15, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(16, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(17, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(18, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(19, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(20, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(21, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(22, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(23, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(24, 49, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(25, 51, 'SQL', 'Resume2', 'Creating and Managing SQL databases'),
(26, 53, 'adsf', 'resume-sql', 'asadf'),
(27, 53, 'sql', 'resume-sql', 'creating and managing SQL DBs'),
(28, 54, 'java', 'someresume', 'java programming'),
(29, 54, 'sql', 'someresume', 'sql programming'),
(30, 55, '', '', ''),
(31, 55, '', '', ''),
(32, 56, 'asd', 'asd', 'asd'),
(33, 56, 'asdasdasd', 'asd', 'asdasdasdasdsa'),
(34, 57, 'asd', 'asd', 'asd'),
(35, 57, 'asdasdasd', 'asd', 'asdasdasd'),
(36, 58, 'sql', 'Resume99', 'creating and managing DBs'),
(37, 58, 'java', 'Resume99', 'Java programming'),
(38, 59, 'sql', 'another resume', ''),
(39, 59, 'java', 'another resume', 'Java programming'),
(40, 59, 'C#', 'another resume', 'C# programming asd asd asfd asdf adf asdfasdf adsf'),
(41, 60, 'asdf', 'asd', 'asdf'),
(42, 61, 'sdf', 'sdf', 'sdf'),
(43, 62, 'sql', 'asdasda', ''),
(44, 63, '', '', ''),
(45, 64, 'sql', 'My Resume #1', ''),
(46, 64, 'C#', 'My Resume #1', 'C# programming'),
(47, 64, 'python', 'My Resume #1', 'Python programming'),
(48, 65, 'sql', 'Joe Resume', 'Creating and maintaining SQL databases'),
(49, 65, 'C#', 'Joe Resume', 'C# programming'),
(50, 65, 'C++', 'Joe Resume', 'C++ programming'),
(51, 66, 'sdf', 'asdf', 'asdf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `resume_skill`
--
ALTER TABLE `resume_skill`
  ADD PRIMARY KEY (`primary`), ADD KEY `pkey` (`fkey`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `resume_skill`
--
ALTER TABLE `resume_skill`
  MODIFY `primary` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=52;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

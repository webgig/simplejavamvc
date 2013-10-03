-- phpMyAdmin SQL Dump
-- version 3.5.8.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 03, 2013 at 03:04 AM
-- Server version: 5.6.11
-- PHP Version: 5.4.20

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `itc557assignment2`
--

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `subject` text NOT NULL,
  `message` text NOT NULL,
  `created` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `user_id`, `subject`, `message`, `created`) VALUES
(1, 11, 'Test', 'asass', '2013-10-03'),
(2, 11, 'Test', 'asass', '2013-10-03'),
(3, 11, 'Test', 'asass', '2013-10-03'),
(4, 11, 'Test', 'asass', '2013-10-03'),
(5, 11, 'Test', 'asass', '2013-10-03'),
(6, 11, 'Test', 'asass', '2013-10-03'),
(7, 11, 'Test', 'asass', '2013-10-03'),
(8, 11, 'Test', 'asass', '2013-10-03');

-- --------------------------------------------------------

--
-- Table structure for table `messages_receipients`
--

CREATE TABLE IF NOT EXISTS `messages_receipients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg_id` int(11) NOT NULL,
  `msg_to` int(11) DEFAULT NULL,
  `msg_cc` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `messages_receipients`
--

INSERT INTO `messages_receipients` (`id`, `msg_id`, `msg_to`, `msg_cc`, `status`) VALUES
(1, 8, 13, 0, 1),
(2, 8, 0, 12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `created` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fname`, `lname`, `email`, `phone`, `address`, `username`, `password`, `dob`, `created`) VALUES
(11, 'Sagar', 'Bhandari', 'webgig.sagar@gmail.com', '0431324954', 'ssss', 'webgig', 'abc', '1984-03-17', '2013-09-30'),
(12, 'Sagar', 'Bhandari', 'webgig.sagar@gmail.com', '0431324954', 'asas', 'admin1', '', '1984-03-17', '2013-09-30'),
(13, 'Sagar', 'Bhandari', 'sagar@webmarketers.com.au', '0431324954', 'test', 'sagar', 'abc', '1984-03-17', '2013-09-30');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

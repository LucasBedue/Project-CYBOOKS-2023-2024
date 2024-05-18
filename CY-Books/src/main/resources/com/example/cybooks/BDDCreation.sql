-- Create the database
CREATE DATABASE IF NOT EXISTS `Cy_Books_Database`;

-- Use this database
USE `Cy_Books_Database`;

-- Creating tables with book's id
CREATE TABLE IF NOT EXISTS `books` (
  `id` int8 NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) NOT NULL,
  `cote` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);

-- Creating tables with users
CREATE TABLE IF NOT EXISTS `user` (
  `id` int8 NOT NULL AUTO_INCREMENT,
  `firstName` varchar(40) NOT NULL,
  `lastName` varchar(40) NOT NULL,
  `mail` varchar(50),
  `phone` varchar(20),
  `address` varchar(50) NOT NULL,
  `dob` date,
  PRIMARY KEY (`id`)
);

-- Creating tables with borrows
CREATE TABLE IF NOT EXISTS `borrows` (
  `id` int,
  `borrowingDate` varchar(50) NOT NULL,
  `dateToBeReturnedBy` varchar(50) NOT NULL,
  `dateReturn` varchar(50) NOT NULL,
  `id_client` int references user(id),
  `id_book` int references books(id),
  PRIMARY KEY (`id`)
);
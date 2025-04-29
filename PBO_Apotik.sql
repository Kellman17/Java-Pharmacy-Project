-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2022 at 09:39 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_31210016`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblinput`
--

CREATE TABLE `tblinput` (
  `Kode` varchar(50) NOT NULL,
  `Nama_Obat` varchar(50) NOT NULL,
  `Kd_kategori` varchar(50) NOT NULL,
  `Kategori` varchar(50) NOT NULL,
  `Kadaluarsa` date NOT NULL,
  `Keterangan` varchar(50) NOT NULL,
  `HargaBeli` int(50) NOT NULL,
  `Harga_Jual` int(50) NOT NULL,
  `Kuantitas` int(50) NOT NULL,
  `Total_harga_beli` int(50) NOT NULL,
  `Total_harga_jual` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblinput`
--

INSERT INTO `tblinput` (`Kode`, `Nama_Obat`, `Kd_kategori`, `Kategori`, `Kadaluarsa`, `Keterangan`, `HargaBeli`, `Harga_Jual`, `Kuantitas`, `Total_harga_beli`, `Total_harga_jual`) VALUES
('1', 'obat1', 'Narkotika', 'N', '2022-06-09', 'Belum kadaluarsa', 100, 120, 2, 200, 240),
('2', 'obat2', 'Narkotika', 'N', '2022-06-14', 'Belum kadaluarsa', 100, 120, 3, 300, 360),
('3', 'obat3', 'Psikotropika', 'P', '2022-06-08', 'Kadaluarsa', 150, 180, 2, 300, 360),
('4', 'obat4', 'Psikotropika', 'P', '2022-06-06', 'Kadaluarsa', 100, 120, 1, 100, 120);

-- --------------------------------------------------------

--
-- Table structure for table `tblogin`
--

CREATE TABLE `tblogin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tblsignup`
--

CREATE TABLE `tblsignup` (
  `username` varchar(50) NOT NULL,
  `password` varchar(35) NOT NULL,
  `re-password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblinput`
--
ALTER TABLE `tblinput`
  ADD PRIMARY KEY (`Kode`);

--
-- Indexes for table `tblsignup`
--
ALTER TABLE `tblsignup`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

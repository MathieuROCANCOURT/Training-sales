-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 28 sep. 2026 à 11:37
-- Version du serveur : 11.7.1-MariaDB
-- Version de PHP : 8.5.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `training_sales`
--
CREATE DATABASE IF NOT EXISTS `training_sales` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;
USE `training_sales`;

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `ad_id_address` int(11) NOT NULL,
  `ad_street` varchar(50) NOT NULL,
  `ad_city` varchar(50) NOT NULL,
  PRIMARY KEY (`ad_id_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `basket`
--

DROP TABLE IF EXISTS `basket`;
CREATE TABLE IF NOT EXISTS `basket` (
  `ba_id_basket` int(11) NOT NULL,
  `ba_total_price` decimal(6,2) DEFAULT NULL,
  `ba_buy` tinyint(1) NOT NULL,
  PRIMARY KEY (`ba_id_basket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `contains`
--

DROP TABLE IF EXISTS `contains`;
CREATE TABLE IF NOT EXISTS `contains` (
  `co_id_basket` int(11) NOT NULL,
  `co_id_training` int(11) NOT NULL,
  KEY `co_id_training` (`co_id_training`),
  KEY `co_id_basket` (`co_id_basket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `history`
--

DROP TABLE IF EXISTS `history`;
CREATE TABLE IF NOT EXISTS `history` (
  `hi_id_user` int(11) NOT NULL,
  `hi_id_basket` int(11) NOT NULL,
  KEY `hi_id_basket` (`hi_id_basket`),
  KEY `hi_id_user` (`hi_id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `training`
--

DROP TABLE IF EXISTS `training`;
CREATE TABLE IF NOT EXISTS `training` (
  `tr_id_training` int(11) NOT NULL,
  `tr_name` varchar(50) NOT NULL,
  `tr_description` text NOT NULL,
  `tr_duration` int(11) NOT NULL,
  `tr_inperson` tinyint(1) NOT NULL,
  `tr_price` decimal(5,2) NOT NULL,
  PRIMARY KEY (`tr_id_training`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `us_id_user` int(11) NOT NULL,
  `us_lastname` varchar(50) NOT NULL,
  `us_firstname` varchar(50) NOT NULL,
  `us_email` varchar(50) NOT NULL,
  `us_id_address` int(11) NOT NULL,
  `us_phonenumber` varchar(20) NOT NULL,
  `us_id_basket` int(11) NOT NULL,
  PRIMARY KEY (`us_id_user`),
  UNIQUE KEY `us_email` (`us_email`),
  UNIQUE KEY `us_phonenumber` (`us_phonenumber`),
  KEY `us_id_address` (`us_id_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contains`
--
ALTER TABLE `contains`
  ADD CONSTRAINT `contains_ibfk_1` FOREIGN KEY (`co_id_training`) REFERENCES `training` (`tr_id_training`),
  ADD CONSTRAINT `contains_ibfk_2` FOREIGN KEY (`co_id_basket`) REFERENCES `basket` (`ba_id_basket`);

--
-- Contraintes pour la table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`hi_id_basket`) REFERENCES `basket` (`ba_id_basket`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`hi_id_user`) REFERENCES `user` (`us_id_user`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`us_id_address`) REFERENCES `address` (`ad_id_address`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

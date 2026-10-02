-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 02 oct. 2026 à 09:16
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
-- Drop table if exist
--

DROP TABLE IF EXISTS `contains`;
DROP TABLE IF EXISTS `training`;
DROP TABLE IF EXISTS `basket`;
DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `address`;

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `ad_id_address` int(11) NOT NULL AUTO_INCREMENT,
  `ad_street` varchar(50) NOT NULL,
  `ad_city` varchar(50) NOT NULL,
  PRIMARY KEY (`ad_id_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `basket`
--

CREATE TABLE IF NOT EXISTS `basket` (
  `ba_id_basket` int(11) NOT NULL AUTO_INCREMENT,
  `ba_total_price` decimal(6,2) DEFAULT NULL,
  `ba_buy` tinyint(1) NOT NULL,
  `ba_id_user` int(11) NOT NULL,
  `ba_id_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`ba_id_basket`),
  KEY `ba_id_client` (`ba_id_client`),
  KEY `ba_id_user` (`ba_id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `cl_id_client` int(11) NOT NULL AUTO_INCREMENT,
  `ci_id_person` int(11) NOT NULL,
  PRIMARY KEY (`cl_id_client`),
  UNIQUE KEY `ci_id_person` (`ci_id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `contains`
--

CREATE TABLE IF NOT EXISTS `contains` (
  `co_id_basket` int(11) NOT NULL,
  `co_id_training` int(11) NOT NULL,
  KEY `co_id_training` (`co_id_training`),
  KEY `co_id_basket` (`co_id_basket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `pe_id_person` int(11) NOT NULL AUTO_INCREMENT,
  `pe_lastname` varchar(50) NOT NULL,
  `pe_firstname` varchar(50) NOT NULL,
  `pr_email` varchar(50) NOT NULL,
  `pe_phonenumber` char(10) NOT NULL,
  `pe_id_address` int(11) NOT NULL,
  PRIMARY KEY (`pe_id_person`),
  UNIQUE KEY `pr_email` (`pr_email`),
  KEY `pe_id_address` (`pe_id_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `training`
--

CREATE TABLE IF NOT EXISTS `training` (
  `tr_id_training` int(11) NOT NULL AUTO_INCREMENT,
  `tr_name` varchar(50) NOT NULL,
  `tr_description` text NOT NULL,
  `tr_duration` int(11) NOT NULL,
  `tr_inperson` tinyint(1) NOT NULL,
  `tr_price` decimal(5,2) NOT NULL,
  PRIMARY KEY (`tr_id_training`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Déchargement des données de la table `training`
--

INSERT INTO `training` (`tr_id_training`, `tr_name`, `tr_description`, `tr_duration`, `tr_inperson`, `tr_price`) VALUES
(1, 'Java', 'Java SE 8: Syntaxe et POO', 6, 1, 15.00),
(2, 'Java avancé', 'Exceptions, fichiers, JDBC, thread, Multiprocess and sync.', 5, 1, 16.23),
(3, 'Spring', 'Spring Core/MVC/Security', 20, 0, 70.00),
(4, 'PHP Frameworks', 'Symphony (Dorémi)', 12, 0, 33.00),
(5, 'C#', 'Dotnet Core', 20, 1, 26.99),
(6, 'Python', 'Introduction Python14 et Syntaxe', 10, 1, 16.45),
(7, 'C', 'Introduction C, syntaxe et typage', 18, 1, 34.12),
(8, 'Haskell', 'Introduction aux paradigmes', 30, 0, 54.82),
(9, 'R', 'Prise en main et mise en pratique en affichant la loi normale', 2, 1, 10.42);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `us_id_user` int(11) NOT NULL AUTO_INCREMENT,
  `us_id_person` int(11) NOT NULL,
  PRIMARY KEY (`us_id_user`),
  UNIQUE KEY `us_id_person` (`us_id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `basket`
--
ALTER TABLE `basket`
  ADD CONSTRAINT `basket_ibfk_1` FOREIGN KEY (`ba_id_client`) REFERENCES `client` (`cl_id_client`),
  ADD CONSTRAINT `basket_ibfk_2` FOREIGN KEY (`ba_id_user`) REFERENCES `user` (`us_id_user`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`ci_id_person`) REFERENCES `person` (`pe_id_person`);

--
-- Contraintes pour la table `contains`
--
ALTER TABLE `contains`
  ADD CONSTRAINT `contains_ibfk_1` FOREIGN KEY (`co_id_training`) REFERENCES `training` (`tr_id_training`),
  ADD CONSTRAINT `contains_ibfk_2` FOREIGN KEY (`co_id_basket`) REFERENCES `basket` (`ba_id_basket`);

--
-- Contraintes pour la table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`pe_id_address`) REFERENCES `address` (`ad_id_address`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`us_id_person`) REFERENCES `person` (`pe_id_person`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 12 oct. 2024 à 17:10
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tp1-java`
--

-- --------------------------------------------------------

--
-- Structure de la table `avion`
--

DROP TABLE IF EXISTS `avion`;
CREATE TABLE IF NOT EXISTS `avion` (
  `id_avion` int NOT NULL AUTO_INCREMENT,
  `marque_avion` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `modele_avion` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `vitesse_avion` int NOT NULL,
  `vitesse_max_avion` int NOT NULL,
  `altitude_avion` double NOT NULL,
  `altitude_max_avion` double NOT NULL,
  `portee_avion` double NOT NULL,
  PRIMARY KEY (`id_avion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `avion`
--

INSERT INTO `avion` (`id_avion`, `marque_avion`, `modele_avion`, `vitesse_avion`, `vitesse_max_avion`, `altitude_avion`, `altitude_max_avion`, `portee_avion`) VALUES
(1, 'Boeing', '737', 840, 945, 10000, 12500, 6570),
(2, 'Boeing', '737', 840, 945, 10000, 12500, 6570),
(3, 'Boeing', '737', 840, 945, 10000, 12500, 6570),
(4, 'Boeing', '737', 840, 945, 10000, 12500, 6570);

-- --------------------------------------------------------

--
-- Structure de la table `bateau`
--

DROP TABLE IF EXISTS `bateau`;
CREATE TABLE IF NOT EXISTS `bateau` (
  `id_bateau` int NOT NULL AUTO_INCREMENT,
  `marque_bateau` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `modele_bateau` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `vitesse_bateau` int NOT NULL,
  `vitesse_max_bateau` int NOT NULL,
  `tirant_deau_bateau` double(10,0) NOT NULL,
  `nbre_voiles_bateau` int NOT NULL,
  PRIMARY KEY (`id_bateau`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bateau`
--

INSERT INTO `bateau` (`id_bateau`, `marque_bateau`, `modele_bateau`, `vitesse_bateau`, `vitesse_max_bateau`, `tirant_deau_bateau`, `nbre_voiles_bateau`) VALUES
(1, NULL, 'Belem', 20, 28, 5, 20),
(2, NULL, 'Belem', 20, 28, 5, 20),
(3, NULL, 'Belem', 20, 28, 5, 20);

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `id_voiture` int NOT NULL AUTO_INCREMENT,
  `marque_voiture` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `modele_voiture` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `vitesse_voiture` int NOT NULL,
  `vitesse_max_voiture` int NOT NULL,
  `num_immat_voiture` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `cylindree_voiture` double NOT NULL,
  PRIMARY KEY (`id_voiture`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`id_voiture`, `marque_voiture`, `modele_voiture`, `vitesse_voiture`, `vitesse_max_voiture`, `num_immat_voiture`, `cylindree_voiture`) VALUES
(1, 'Renault', 'Captur', 100, 200, 'AA-123-BB', 1333),
(2, 'Toyota', 'Corolla', 120, 180, 'BB-456-CC', 2),
(3, 'Peugeot', '208', 120, 240, 'SS-045-EZ', 1.5),
(4, 'Citroën', 'C3', 100, 180, 'DD-111-EE', 2),
(5, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(6, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(7, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(8, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(9, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(10, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(11, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(12, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(13, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(14, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(15, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12),
(16, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
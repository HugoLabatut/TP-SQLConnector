-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : ven. 11 oct. 2024 à 12:56
-- Version du serveur : 10.7.8-MariaDB-1:10.7.8+maria~ubu2004
-- Version de PHP : 8.2.8

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

CREATE TABLE `avion` (
  `id_avion` int(11) NOT NULL,
  `marque_avion` varchar(255) NOT NULL,
  `modele_avion` varchar(255) NOT NULL,
  `vitesse_avion` int(11) NOT NULL,
  `vitesse_max_avion` int(11) NOT NULL,
  `altitude_avion` double NOT NULL,
  `altitude_max_avion` double NOT NULL,
  `portee_avion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `bateau`
--

CREATE TABLE `bateau` (
  `id_bateau` int(11) NOT NULL,
  `marque_bateau` varchar(255) NOT NULL,
  `modele_bateau` varchar(255) NOT NULL,
  `vitesse_bateau` int(11) NOT NULL,
  `vitesse_max_bateau` int(11) NOT NULL,
  `tirant_deau_bateau` double(10,0) NOT NULL,
  `nbre_voiles_bateau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE `voiture` (
  `id_voiture` int(11) NOT NULL,
  `marque_voiture` varchar(255) NOT NULL,
  `modele_voiture` varchar(255) NOT NULL,
  `vitesse_voiture` int(11) NOT NULL,
  `vitesse_max_voiture` int(11) NOT NULL,
  `num_immat_voiture` varchar(255) NOT NULL,
  `cylindree_voiture` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(12, 'Pagani', 'Huayra', 250, 380, 'HD-069-PH', 12);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id_avion`);

--
-- Index pour la table `bateau`
--
ALTER TABLE `bateau`
  ADD PRIMARY KEY (`id_bateau`);

--
-- Index pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id_voiture`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `avion`
--
ALTER TABLE `avion`
  MODIFY `id_avion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `bateau`
--
ALTER TABLE `bateau`
  MODIFY `id_bateau` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `id_voiture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

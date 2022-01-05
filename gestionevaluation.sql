-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 05 jan. 2022 à 01:00
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionevaluation`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `Identifiant` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`Identifiant`, `password`) VALUES
('Admin', 'ensate@2000');

-- --------------------------------------------------------

--
-- Structure de la table `ajouter_affectation`
--

CREATE TABLE `ajouter_affectation` (
  `Module` varchar(255) NOT NULL,
  `Prof` varchar(255) NOT NULL,
  `Surveillant1` varchar(255) NOT NULL,
  `Surveillant2` varchar(255) NOT NULL,
  `Date_exam` date DEFAULT NULL,
  `heure_debut` int(11) NOT NULL,
  `heure_fin` int(11) NOT NULL,
  `nb_salles` int(11) NOT NULL DEFAULT 0,
  `Salles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ajouter_affectation`
--

INSERT INTO `ajouter_affectation` (`Module`, `Prof`, `Surveillant1`, `Surveillant2`, `Date_exam`, `heure_debut`, `heure_fin`, `nb_salles`, `Salles`) VALUES
('Genie logiciel', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', 'Cherkaoui Mohammed', '2021-12-14', 7, 4, 3, 'Salle 002|Salle 004|Salle 006|'),
('Algèbre 1', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', 'Cherkaoui Mohammed', '2021-12-01', 5, 3, 4, 'Salle 003|Salle 101|Salle 103|'),
('Genie logiciel', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', 'Cherkaoui Mohammed', '2022-01-06', 12, 10, 3, 'Salle 002|Salle 004|Salle 006|'),
('Analyse3', 'Cherkaoui Mohammed', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', '2022-01-05', 10, 8, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Genie logiciel', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', 'Benbouker Mohammed', '2022-01-12', 0, 0, 3, 'Salle 002|Salle 004|Salle 006|'),
('Analyse3', 'Cherkaoui Mohammed', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', '2022-01-21', 11, 9, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Analyse3', 'Cherkaoui Mohammed', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', '2022-01-19', 9, 11, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Analyse3', 'Cherkaoui Mohammed', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', '2022-01-19', 9, 11, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Analyse3', 'Cherkaoui Mohammed', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', '2022-01-06', 9, 11, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Analyse3', 'Cherkaoui Mohammed', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', '2022-01-14', 1, 3, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Analyse3', 'Cherkaoui Mohammed', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', '2022-01-12', 9, 11, 4, 'Salle 002|Salle 004|Salle 006|Salle 101|'),
('Genie logiciel', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', 'Cherkaoui Mohammed', '2022-01-13', 9, 11, 3, 'Salle 002|Salle 004|Salle 006|'),
('Algèbre 1', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', 'Cherkaoui Mohammed', '2022-01-01', 2, 4, 4, 'Salle 003|Salle 101|Salle 103|'),
('Genie logiciel', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', 'Cherkaoui Mohammed', '2022-01-06', 9, 11, 3, 'Salle 002|Salle 004|Salle 006|'),
('Algèbre 1', 'Benbouker Mohammed', 'Chkouri Mohammed Yassin', 'Cherkaoui Mohammed', '2022-01-15', 9, 12, 4, 'Salle 003|Salle 101|Salle 103|'),
('Genie logiciel', 'Chkouri Mohammed Yassin', 'Benbouker Mohammed', 'Cherkaoui Mohammed', '2022-01-08', 9, 11, 3, 'Salle 002|Salle 004|Salle 006|');

-- --------------------------------------------------------

--
-- Structure de la table `demandesconsultationcopie`
--

CREATE TABLE `demandesconsultationcopie` (
  `Module` text NOT NULL,
  `Apoge` text NOT NULL,
  `EmailEtudiant` text NOT NULL,
  `Message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `demandesconsultationcopie`
--

INSERT INTO `demandesconsultationcopie` (`Module`, `Apoge`, `EmailEtudiant`, `Message`) VALUES
('RI2', '18036089', 'ali.akil@etu.uae.ac.ma', 'Bonjour, ...'),
('Modélisation et POO', '18036094', 'moad.merroun@etu.uae.ac.ma\r\n', 'Bonjour, ..');

-- --------------------------------------------------------

--
-- Structure de la table `descriptiondujour`
--

CREATE TABLE `descriptiondujour` (
  `NbrEtudiants` text NOT NULL,
  `NbrCopies` text NOT NULL,
  `Anomalies` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `CIN` varchar(255) NOT NULL,
  `Identifiant` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`CIN`, `Identifiant`, `Password`) VALUES
('L35638', 'Benbouker Mohammed', '123456'),
('L76986', 'Chkouri Mohammed Yassin', '123456'),
('L79695', 'Cherkaoui Mohammed', '123456');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant2`
--

CREATE TABLE `etudiant2` (
  `Identifiant` text NOT NULL,
  `Password` text NOT NULL,
  `Filiere` text NOT NULL,
  `EmailInstitutionnel` text NOT NULL,
  `Prenom` text NOT NULL,
  `Nom` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant2`
--

INSERT INTO `etudiant2` (`Identifiant`, `Password`, `Filiere`, `EmailInstitutionnel`, `Prenom`, `Nom`) VALUES
('18036090', 'password2', 'GI2', 'rachid.ahidar@etu.uae.ac.ma', 'Rachid', 'Ahidar'),
('18036092', 'password4', 'GI2', 'moad.merroun@etu.uae.ac.ma', 'Moad', 'Merroun'),
('18036093', 'password5', 'GI2', 'wail.bellabas@etu.uae.ac.ma', 'Wail', 'Bellabas'),
('18036089', 'password1', 'GI2', 'ali.akil@etu.uae.ac.ma', 'Ali', 'Akil'),
('18036094', 'password9', 'GI2', 'hamza.aymane@etu.uae.ac.ma', 'Hamza', 'Aymane'),
('189735', '123456', 'GI2', 'merroun2000@gmail.com', 'Moad', 'MERROUN');

-- --------------------------------------------------------

--
-- Structure de la table `filieres`
--

CREATE TABLE `filieres` (
  `ID_filiere` varchar(255) NOT NULL,
  `nb_etudiants` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `filieres`
--

INSERT INTO `filieres` (`ID_filiere`, `nb_etudiants`) VALUES
('GC2', 40),
('GI2', 47),
('GM2', 40),
('GSTR2', 37),
('SCM2', 45);

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `nom_module` varchar(255) NOT NULL,
  `CIN_enseignant` varchar(255) NOT NULL,
  `nb_etudiants` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`nom_module`, `CIN_enseignant`, `nb_etudiants`, `ID`) VALUES
('Algèbre 1', 'L35638', 400, 1),
('Analyse3', 'L79695', 300, 2),
('Genie logiciel', 'L76986', 47, 3);

-- --------------------------------------------------------

--
-- Structure de la table `planning_gi2`
--

CREATE TABLE `planning_gi2` (
  `COD_ETU` text DEFAULT NULL,
  `CNE` text DEFAULT NULL,
  `Nom` text DEFAULT NULL,
  `Prenom` text DEFAULT NULL,
  `Mod_POO` text DEFAULT NULL,
  `Adm_BD` text DEFAULT NULL,
  `Magt_Chai` text DEFAULT NULL,
  `Meth_Gen` text DEFAULT NULL,
  `Vision_ar` text DEFAULT NULL,
  `Lg_Com2` text DEFAULT NULL,
  `Salle_controle` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `planning_gi2`
--

INSERT INTO `planning_gi2` (`COD_ETU`, `CNE`, `Nom`, `Prenom`, `Mod_POO`, `Adm_BD`, `Magt_Chai`, `Meth_Gen`, `Vision_ar`, `Lg_Com2`, `Salle_controle`) VALUES
('1802457', 'p93576', 'Merroun', 'Moad', 'I', 'I', 'I', 'I', 'I', 'I', 'STPI6'),
('1846554', 'p53667', 'Hamza', 'Aymane', 'I', 'I', 'I', 'I', 'I', 'I', 'STPI6'),
('1800958', 'p76865', 'Akil', 'Ali', 'I', 'I', 'I', 'I', 'I', 'I', 'STPI4');

-- --------------------------------------------------------

--
-- Structure de la table `prevenirexamen`
--

CREATE TABLE `prevenirexamen` (
  `Module` text DEFAULT NULL,
  `Mode` text DEFAULT NULL,
  `Presentiel` text DEFAULT NULL,
  `SalleTP` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `profiletudiant`
--

CREATE TABLE `profiletudiant` (
  `Nom` text NOT NULL,
  `Prenom` text NOT NULL,
  `Adresse` text NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `pvevaluation`
--

CREATE TABLE `pvevaluation` (
  `Module` text DEFAULT NULL,
  `SalleEvaluation` text DEFAULT NULL,
  `JourEvaluation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `pv_annuel_2021`
--

CREATE TABLE `pv_annuel_2021` (
  `Numero_apoge` int(11) DEFAULT NULL,
  `Nom` text DEFAULT NULL,
  `Prenom` text DEFAULT NULL,
  `Resultat_final` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pv_annuel_2021`
--

INSERT INTO `pv_annuel_2021` (`Numero_apoge`, `Nom`, `Prenom`, `Resultat_final`) VALUES
(186467, 'MERROUN', 'Moad', 15.73),
(185668, 'HAMZA', 'Aymane', 15.5);

-- --------------------------------------------------------

--
-- Structure de la table `salles`
--

CREATE TABLE `salles` (
  `Id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `salles`
--

INSERT INTO `salles` (`Id`) VALUES
('Salle 001'),
('Salle 002'),
('Salle 003'),
('Salle 004'),
('Salle 005'),
('Salle 006'),
('Salle 101'),
('Salle 102'),
('Salle 103'),
('Salle 104'),
('Salle 105'),
('Salle 106'),
('Salle 201'),
('Salle 202'),
('Salle 203'),
('Salle 204'),
('Salle 205'),
('Salle 206');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Identifiant`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`CIN`);

--
-- Index pour la table `filieres`
--
ALTER TABLE `filieres`
  ADD PRIMARY KEY (`ID_filiere`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CIN_enseignant` (`CIN_enseignant`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`CIN_enseignant`) REFERENCES `enseignant` (`CIN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

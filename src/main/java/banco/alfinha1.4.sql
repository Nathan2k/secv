-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 26-Out-2018 às 15:48
-- Versão do servidor: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alfa`
--
CREATE DATABASE IF NOT EXISTS `alfa` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `alfa`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `NIF` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`id`, `NIF`, `email`, `nome`, `senha`, `telefone`) VALUES
(1, '123456', 'adm@gmail.com', 'admin', '123', '123455432');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` int(11) NOT NULL,
  `nomeCidade` varchar(50) DEFAULT NULL,
  `idEstado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nomeCidade`, `idEstado`) VALUES
(7, 'cidadde1', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curriculo`
--

CREATE TABLE `curriculo` (
  `id` int(11) NOT NULL,
  `nome_aluno` varchar(100) DEFAULT NULL,
  `idade` varchar(50) DEFAULT NULL,
  `nivelIngles` int(11) DEFAULT NULL,
  `nivelEspanhol` int(11) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `curso` varchar(50) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `sexo` varchar(50) DEFAULT NULL,
  `deficiencia` varchar(50) DEFAULT NULL,
  `idExperiencia` int(11) DEFAULT NULL,
  `idFormaçao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `CNPJ` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `rua` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `representante` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`id`, `senha`, `nome`, `CNPJ`, `cidade`, `bairro`, `rua`, `email`, `telefone`, `representante`) VALUES
(1, '123', 'mahalo', '123456', 'Jaguariuna', 'flores', 'lulu', 'mahalo@gmail.com', '123455432', 'Rafael Leme'),
(2, '123', 'senai', '654321', 'Jaguariuna', 'flores', 'lulu', 'senai@gmail.com', '123455432', 'Para Guasu');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `nomeEstado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id`, `nomeEstado`) VALUES
(1, 'estado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `experiencia`
--

CREATE TABLE `experiencia` (
  `id` int(11) NOT NULL,
  `nomeDaEmpresa` varchar(300) DEFAULT NULL,
  `data_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_fim` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `funçao` varchar(300) DEFAULT NULL,
  `cargo` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `filtro`
--

CREATE TABLE `filtro` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `experiencia` tinyint(1) DEFAULT NULL,
  `sexo` varchar(50) DEFAULT NULL,
  `deficiencia` tinyint(1) DEFAULT NULL,
  `idEmpresa` int(11) DEFAULT NULL,
  `idADM` int(11) DEFAULT NULL,
  `idCidade` int(11) DEFAULT NULL,
  `idEstado` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `filtro`
--

INSERT INTO `filtro` (`id`, `nome`, `experiencia`, `sexo`, `deficiencia`, `idEmpresa`, `idADM`, `idCidade`, `idEstado`, `data`) VALUES
(7, 'eletricista', 1, 'masculino', 0, 1, 1, 7, 1, '2018-10-26 02:00:00'),
(8, 'arquiteto', 1, 'masculino', 0, 1, 1, 7, 1, '2018-10-25 02:00:00'),
(9, 'treinador', 1, 'masculino', 0, 1, 1, 7, 1, '2018-11-26 02:00:00'),
(10, 'piloto', 1, 'masculono', 0, 1, 1, 7, 1, '2018-12-26 02:00:00'),
(11, 'xelelista', 1, 'masculono', 0, 1, 1, 7, 1, '2018-12-26 02:00:00'),
(12, 'xeskedele', 1, 'masculono', 0, 1, 1, 7, 1, '2019-01-26 02:00:00'),
(13, 'xazam', 1, 'masculono', 0, 1, 1, 7, 1, '2018-12-26 02:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `formacao`
--

CREATE TABLE `formacao` (
  `id` int(11) NOT NULL,
  `nomeDoCurso` varchar(300) DEFAULT NULL,
  `data_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_fim` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `escola` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `recuperarsenha`
--

CREATE TABLE `recuperarsenha` (
  `id` int(11) NOT NULL,
  `emailUsuario` varchar(50) DEFAULT NULL,
  `codigo` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `NIF` (`NIF`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEstado` (`idEstado`);

--
-- Indexes for table `curriculo`
--
ALTER TABLE `curriculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idExperiencia` (`idExperiencia`),
  ADD KEY `idFormaçao` (`idFormaçao`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `CNPJ` (`CNPJ`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `filtro`
--
ALTER TABLE `filtro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEmpresa` (`idEmpresa`),
  ADD KEY `idADM` (`idADM`),
  ADD KEY `idCidade` (`idCidade`),
  ADD KEY `idEstado` (`idEstado`);

--
-- Indexes for table `formacao`
--
ALTER TABLE `formacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recuperarsenha`
--
ALTER TABLE `recuperarsenha`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `curriculo`
--
ALTER TABLE `curriculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `filtro`
--
ALTER TABLE `filtro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `formacao`
--
ALTER TABLE `formacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `recuperarsenha`
--
ALTER TABLE `recuperarsenha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`id`);

--
-- Limitadores para a tabela `curriculo`
--
ALTER TABLE `curriculo`
  ADD CONSTRAINT `curriculo_ibfk_1` FOREIGN KEY (`idExperiencia`) REFERENCES `experiencia` (`id`),
  ADD CONSTRAINT `curriculo_ibfk_2` FOREIGN KEY (`idFormaçao`) REFERENCES `formacao` (`id`);

--
-- Limitadores para a tabela `filtro`
--
ALTER TABLE `filtro`
  ADD CONSTRAINT `filtro_ibfk_1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`id`),
  ADD CONSTRAINT `filtro_ibfk_2` FOREIGN KEY (`idADM`) REFERENCES `administrador` (`id`),
  ADD CONSTRAINT `filtro_ibfk_3` FOREIGN KEY (`idCidade`) REFERENCES `cidade` (`id`),
  ADD CONSTRAINT `filtro_ibfk_4` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

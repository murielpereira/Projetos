-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28-Ago-2021 às 15:25
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `estoque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `metais`
--

CREATE TABLE `metais` (
  `idMetal` varchar(30) NOT NULL,
  `corMetal` varchar(30) NOT NULL,
  `fornecedorMetal` varchar(50) NOT NULL,
  `qtdMetal` int(11) NOT NULL,
  `obsMetal` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `metais`
--

INSERT INTO `metais` (`idMetal`, `corMetal`, `fornecedorMetal`, `qtdMetal`, `obsMetal`) VALUES
('745321 / 16', 'Ouro', 'Reuter', 1500, 'Fivela'),
('78945', 'Niquel', 'Altero', 20, 'Rebite'),
('7876 / 20', 'Niquel', 'Denilson Metais', 781, 'Fivela'),
('3346.1', 'Rose', 'Altero', 2123, 'Argola');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `idProduto` int(11) NOT NULL,
  `metalProduto` varchar(30) NOT NULL,
  `qtdMetalProduto` int(11) NOT NULL,
  `obsProduto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`idProduto`, `metalProduto`, `qtdMetalProduto`, `obsProduto`) VALUES
(1, '78945', 5, 'Bolsa'),
(2, '78945', 10, 'Cinto');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`idProduto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2022 a las 20:37:44
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdfederacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `id` int(11) NOT NULL,
  `definitivo` tinyint(1) NOT NULL DEFAULT 0,
  `fechahora` datetime DEFAULT NULL,
  `idoro` int(11) DEFAULT NULL,
  `idplata` int(11) DEFAULT NULL,
  `idbronce` int(11) DEFAULT NULL,
  `idpuesto1` int(11) DEFAULT NULL,
  `idpuesto2` int(11) DEFAULT NULL,
  `idpuesto3` int(11) DEFAULT NULL,
  `tiempo1` time NOT NULL,
  `tiempo2` time NOT NULL,
  `tiempo3` time NOT NULL,
  `nombreAtleta1` varchar(50) NOT NULL,
  `nombreAtleta2` varchar(50) NOT NULL,
  `nombreAtleta3` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_puesto1` (`idpuesto1`),
  ADD KEY `FK_puesto2` (`idpuesto2`),
  ADD KEY `FK_puesto3` (`idpuesto3`),
  ADD KEY `FK_oro` (`idoro`),
  ADD KEY `FK_plata` (`idplata`),
  ADD KEY `FK_bronce` (`idbronce`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD CONSTRAINT `FK_bronce` FOREIGN KEY (`idbronce`) REFERENCES `metales` (`id`),
  ADD CONSTRAINT `FK_oro` FOREIGN KEY (`idoro`) REFERENCES `metales` (`id`),
  ADD CONSTRAINT `FK_plata` FOREIGN KEY (`idplata`) REFERENCES `metales` (`id`),
  ADD CONSTRAINT `FK_puesto1` FOREIGN KEY (`idpuesto1`) REFERENCES `participantes` (`id`),
  ADD CONSTRAINT `FK_puesto2` FOREIGN KEY (`idpuesto2`) REFERENCES `participantes` (`id`),
  ADD CONSTRAINT `FK_puesto3` FOREIGN KEY (`idpuesto3`) REFERENCES `participantes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

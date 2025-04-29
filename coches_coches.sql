-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2025 a las 00:47:28
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coches_coches`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cedula` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `apellido`, `cedula`) VALUES
(1, '', '', '10005001'),
(2, 'johan', 'zambrano', '1005001'),
(4, 'sebastian', 'carrrillo', '1005001069'),
(5, 'jo', 'zam', '1006001'),
(6, 'JOHA', 'ZAMBRAN', '1005003'),
(7, 'joh', 'zambra', '1005004'),
(8, 'sebastia', 'carrill', '1005005'),
(9, 'sebasti', 'carril', '1005006'),
(10, 'sebast', 'carril', '1005007'),
(11, 'sebas', 'carri', '1005008'),
(13, 'seba', 'carr', '10050010'),
(15, 'sebaaa', 'carbbb', '1005012'),
(16, 'seb', 'ca', '10050013'),
(17, 'johan', 'zambrano', '1005014'),
(18, 'bruno', 'diaz', '1005015'),
(19, 'bru', 'di', '1005016'),
(20, 'lukas', 'fabianki', '13421022'),
(21, 'nicola', 'leali', '1595428'),
(22, 'aron', 'mejiers', '1498495'),
(23, 'AUDOLAYE', 'BAMBA', '191212'),
(24, 'willy', 'boly', '1330466'),
(25, 'dan', 'buern', '1371424'),
(26, 'luis', 'advincula', '1121499'),
(27, 'lewis', 'dunk', '940609'),
(28, 'ademola', 'lookman', '1669445'),
(29, 'ederson', 'olsenrobin', '1136362'),
(30, 'nombre', 'apellido', '1234501234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `id_vehiculo` int(11) NOT NULL,
  `placa` varchar(20) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `numero_puertas` int(2) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `tipo_combustible` varchar(20) NOT NULL,
  `aire_acondicionado` tinyint(1) DEFAULT NULL,
  `vidrios_electricos` tinyint(1) DEFAULT NULL,
  `año` varchar(20) DEFAULT NULL,
  `id_cliente_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`id_vehiculo`, `placa`, `modelo`, `numero_puertas`, `marca`, `tipo_combustible`, `aire_acondicionado`, `vidrios_electricos`, `año`, `id_cliente_fk`) VALUES
(1, '7', '1997', 7, 'Nissan', 'GASOLINA', 0, 1, '1996', NULL),
(2, '10', '2000', 8, 'Nissan', 'GASOLINA', 1, 0, '1997', NULL),
(7, '15', '2005', 16, 'Nissan', 'Gasolina', 1, 0, '2007', 2),
(8, '16', '2006', 17, 'Toyota', 'Gasolina', 0, 1, '2008', 29),
(9, '29', '1930', 31, 'Ford', 'Diesel', 0, 1, '2004', 30);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `cedula` (`cedula`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`id_vehiculo`),
  ADD UNIQUE KEY `placa` (`placa`),
  ADD KEY `id_cliente_fk` (`id_cliente_fk`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `fk_vehiculo_cliente` FOREIGN KEY (`id_cliente_fk`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

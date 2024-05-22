-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2024 a las 00:42:30
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `f1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `circuito`
--

CREATE TABLE `circuito` (
  `nombreCircuito` varchar(50) NOT NULL,
  `paisCircuito` varchar(20) NOT NULL,
  `numeroCircuito` int(2) UNSIGNED NOT NULL,
  `numeroVueltas` int(2) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `circuito`
--

INSERT INTO `circuito` (`nombreCircuito`, `paisCircuito`, `numeroCircuito`, `numeroVueltas`) VALUES
('Circuito Internacional de Bahrein', 'Bahrein', 1, 57),
('Jeddah Corniche Circuit', 'Arabia Saudi', 2, 50),
('Circuito Albert Park', 'Australia', 3, 58),
('Circuito Internacional de Suzuka', 'Japon', 4, 53),
('Circuito Internacional de Shangai', 'China', 5, 56),
('Miami International Autodrome', 'EEUU', 6, 57),
('Autodromo Enzo e Dino Ferrari', 'Italia', 7, 63),
('Circuito de Monaco', 'Monaco', 8, 78),
('Circuito Gilles Villeneuve', 'Canada', 9, 70),
('Circuit Barcelona-Catalunya', 'España', 10, 66),
('Red Bull Ring', 'Austria', 11, 71),
('Circuito de Silverstone', 'Inglaterra', 12, 52),
('Hungaroring', 'Hungria', 13, 70),
('Spa-Francorchamps', 'Belgica', 14, 44),
('Circuit Zandvoort', 'Holanda', 15, 72),
('Autodromo Nacional de Monza', 'Italia', 16, 53),
('Circuito Urbano de Baku', 'Azerbaiyan', 17, 51),
('Circuito Urbano de Marina Bay', 'Singapur', 18, 62),
('Circuito de las Americas', 'EEUU', 19, 56),
('Autodromo Hermanos Rodriguez', 'Mexico', 20, 71),
('Autodromo Jose Carlos Pace (Interlagos)', 'Brasil', 21, 71),
('Las Vegas Street Circuit', 'EEUU', 22, 50),
('Losail International Circuit', 'Qatar', 23, 57),
('Circuito de Yas Marina', 'Abu-Dhabi', 24, 58);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuderia`
--

CREATE TABLE `escuderia` (
  `nombreEscuderia` varchar(50) NOT NULL,
  `motor` varchar(30) NOT NULL,
  `puntosEscuderia` int(3) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escuderia`
--

INSERT INTO `escuderia` (`nombreEscuderia`, `motor`, `puntosEscuderia`) VALUES
('Aston Martin Aramco Formula One Team', 'Mercedes', 0),
('BWT Alpine F1 Team', 'Renault', 0),
('McLaren Formula 1 Team', 'Mercedes', 0),
('Mercedes-AMG Petronas Formula One Team', 'Mercedes', 0),
('MoneyGram Hass F1 Team', 'Ferrari', 0),
('Oracle Red Bull Racing', 'Honda RBPT', 0),
('Scuderia Ferrari', 'Ferrari', 0),
('Sin escuderia', '(NULL)', 0),
('Stake F1 Team Kick Sauber', 'Ferrari', 0),
('Visa Cash App RB Formula One Team', 'Honda RBPT', 0),
('Williams Racing', 'Mercedes', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piloto`
--

CREATE TABLE `piloto` (
  `nombrePiloto` varchar(30) NOT NULL,
  `escuderia` varchar(50) DEFAULT NULL,
  `puntos` int(3) UNSIGNED NOT NULL DEFAULT 0,
  `dorsal` int(2) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `piloto`
--

INSERT INTO `piloto` (`nombrePiloto`, `escuderia`, `puntos`, `dorsal`) VALUES
('Max Verstappen', 'Oracle Red Bull Racing', 0, 1),
('Logan Sargeant', 'Williams Racing', 0, 2),
('Daniel Ricciardo', 'Visa Cash App RB Formula One Team', 0, 3),
('Lando Norris', 'McLaren Formula 1 Team', 0, 4),
('Pierre Gasly', 'BWT Alpine F1 Team', 0, 10),
('Sergio Perez', 'Oracle Red Bull Racing', 0, 11),
('Fernando Alonso', 'Aston Martin Aramco Formula One Team', 0, 14),
('Charles Leclerc', 'Scuderia Ferrari', 0, 16),
('Lance Stroll', 'Aston Martin Aramco Formula One Team', 0, 18),
('Kevin Magnussen', 'MoneyGram Hass F1 Team', 0, 20),
('Yuki Tsunoda', 'Visa Cash App RB Formula One Team', 0, 22),
('Alexander Albon', 'Williams Racing', 0, 23),
('Guanyu Zhou', 'Stake F1 Team Kick Sauber', 0, 24),
('Nico Hulkenberg', 'MoneyGram Hass F1 Team', 0, 27),
('Esteban Ocon', 'BWT Alpine F1 Team', 0, 31),
('Javier Moreno', NULL, 0, 33),
('Lewis Hamilton', 'Mercedes-AMG Petronas Formula One Team', 0, 44),
('Carlos Sainz', 'Scuderia Ferrari', 0, 55),
('George Russel', 'Mercedes-AMG Petronas Formula One Team', 0, 63),
('Valteri Bottas', 'Stake F1 Team Kick Sauber', 0, 77),
('Oscar Piastri', 'McLaren Formula 1 Team', 0, 81);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `circuito`
--
ALTER TABLE `circuito`
  ADD PRIMARY KEY (`numeroCircuito`);

--
-- Indices de la tabla `escuderia`
--
ALTER TABLE `escuderia`
  ADD PRIMARY KEY (`nombreEscuderia`);

--
-- Indices de la tabla `piloto`
--
ALTER TABLE `piloto`
  ADD PRIMARY KEY (`dorsal`),
  ADD KEY `FK_piloto_escuderia` (`escuderia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `circuito`
--
ALTER TABLE `circuito`
  MODIFY `numeroCircuito` int(2) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `piloto`
--
ALTER TABLE `piloto`
  ADD CONSTRAINT `FK_piloto_escuderia` FOREIGN KEY (`escuderia`) REFERENCES `escuderia` (`nombreEscuderia`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

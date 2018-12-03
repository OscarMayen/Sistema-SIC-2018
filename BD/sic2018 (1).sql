-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2018 a las 08:27:31
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sic2018`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `idComprobante` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `fechaContable` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comprobante`
--

INSERT INTO `comprobante` (`idComprobante`, `fecha`, `usuario`, `descripcion`, `fechaContable`) VALUES
(1, '2018-11-12', 'Oscar Mayen', 'Compra de Mobiliario', '2018-01-02'),
(2, '2018-11-02', 'Nestor Mayen', 'AAAAAAAAAAA', '2018-11-03'),
(3, '2018-11-10', 'OscarE', 'RRRRR', '2018-11-03'),
(4, '2018-11-17', 'aaaa', 'aaa', '2018-11-03'),
(5, '2018-11-02', 'cccc', 'cccc', '2018-11-10'),
(6, '2018-11-03', 'rrrr', 'rrrr', '2018-11-03'),
(7, '2018-11-10', 'QQQ', 'QQQQ', '2018-11-03'),
(8, '2018-11-10', 'WWWW', 'WWWWW', '2018-11-17'),
(9, '2018-11-15', 'tttttt', 'ttttttttt', '2018-11-08'),
(10, '2018-11-10', 'sdsad', 'asdsad', '2018-11-10'),
(11, '2018-11-10', 'sdsad', 'asdsad', '2018-11-10'),
(12, '2018-11-23', 'sadas', 'asdsad', '2018-11-10'),
(13, '2018-12-06', 'll', 'lll', '2018-12-06'),
(14, '2018-12-07', 'sss', 'ssss', '2018-12-20'),
(15, '2018-12-15', 'eeee', 'eee', '2018-12-08'),
(16, '2018-12-13', 'NNN', 'KKK', '2018-12-08'),
(17, '2018-12-06', 'qqq', 'qqqq', '2018-12-07'),
(18, '2018-12-14', 'ttt', 'tttt', '2018-12-02'),
(19, '2018-12-14', 'kkk', 'kkk', '2018-12-13'),
(20, '2018-12-15', 'm', 'm', '2018-12-22'),
(21, '2018-12-14', 'uuu', 'uuu', '2018-12-05'),
(22, '2018-12-28', 'bbbbb', 'bbbbb', '2018-12-28'),
(23, '2018-12-27', 'uuu', 'uuu', '2018-12-28'),
(24, '2018-12-07', 'vv', 'vv', '2018-12-08'),
(25, '2018-12-12', 'ttt', 'tttt', '2018-12-14'),
(26, '2018-12-21', 'nnn', 'nnn', '2018-12-22'),
(27, '2018-12-07', 'ww', 'www', '2018-12-08'),
(28, '2018-12-14', 'aaa', 'aaaa', '2018-12-22'),
(29, '2018-12-06', 'ggg', 'ggg', '2018-12-14'),
(30, '2018-12-04', 'adsads', 'asdasdas', '2018-12-03'),
(31, '2018-12-17', 'asasa', 'asasasa', '2018-12-03'),
(32, '2018-12-01', 'aaaa', 'aaaaa', '2018-12-01'),
(33, '2018-12-01', 'asdasd', 'asdas', '2018-12-01'),
(34, '2018-12-01', 'asdasd', 'asdasdas', '2018-12-01'),
(35, '2018-12-01', 'asdasd', 'asdasd', '2018-12-01'),
(36, '2018-12-01', 'asdas', 'dasdas', '2018-12-01'),
(37, '2018-12-01', 'asdsad', 'sadsaasd', '2018-12-01'),
(38, '2018-12-06', 'asdas', 'asas', '2018-12-03'),
(39, '2018-12-01', 'asdasdas', 'asdasd', '2018-12-01'),
(40, '2018-12-01', 'wqeqw', 'qweqwew', '2018-12-01'),
(41, '2018-12-01', 'sadsa', 'asdsada', '2018-12-01'),
(42, '2018-12-01', 'asdasd', 'asdasd', '2018-12-01'),
(43, '2018-12-08', 'vvv', 'vvv', '2018-12-13'),
(44, '2018-12-07', 'ttt', 'ttt', '2018-12-20'),
(45, '2018-12-15', 'Oscar Mayen', 'Compra de materiales', '2018-12-11'),
(46, '2018-12-21', 'Oscar', 'Mayen', '2018-12-13'),
(47, '2018-12-13', 'qqq', 'qqqqq', '2018-12-15'),
(48, '2018-12-14', 'gh', 'gfhfgh', '2018-12-14'),
(49, '2018-12-13', 'EEE', 'EEEE', '2018-12-07'),
(50, '2018-12-06', 'aa', 'aaa', '2018-12-08'),
(51, '2018-12-13', 'llll', 'qqqqq', '2018-12-15'),
(52, '2018-12-12', 'wwww', 'www', '2018-12-19'),
(53, '2018-12-27', 'bbb', 'bbbb', '2018-12-28'),
(54, '2018-12-13', 'aa', 'aa', '2018-12-15'),
(55, '2018-12-20', 'nnn', 'nnn', '2018-12-21'),
(56, '2018-12-14', 'vvv', 'vvv', '2018-12-28'),
(57, '2018-12-18', 'lll', 'lll', '2018-12-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobantedetalle`
--

CREATE TABLE `comprobantedetalle` (
  `idComprobanteDetalle` int(11) NOT NULL,
  `monto` double NOT NULL,
  `accion` varchar(25) NOT NULL,
  `idComprobante` int(11) NOT NULL,
  `idCuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comprobantedetalle`
--

INSERT INTO `comprobantedetalle` (`idComprobanteDetalle`, `monto`, `accion`, `idComprobante`, `idCuenta`) VALUES
(1, 200, 'Debe', 1, 4),
(2, 100, 'Debe', 4, 2),
(4, 250, 'Debe', 5, 2),
(5, 100, 'Debe', 6, 1),
(6, 300, 'Debe', 7, 2),
(7, 100, 'Debe', 12, 1),
(8, 1000, 'Debe', 13, 2),
(9, 2000, 'Debe', 14, 2),
(10, 300, '', 15, 2),
(11, 0.02, 'Haber', 16, 3),
(12, 0.05, 'Debe', 17, 2),
(13, 0.07, 'Debe', 18, 2),
(15, 0.08, 'Debe', 20, 2),
(16, 0.09, 'Debe', 21, 5),
(17, 0.01, 'Debe', 22, 5),
(19, 0.06, 'Debe', 23, 4),
(20, 0.01, 'Debe', 24, 3),
(21, 0.04, 'Debe', 25, 3),
(22, 0.02, 'Debe', 26, 3),
(24, 0.01, 'Debe', 27, 3),
(26, 0.02, 'Debe', 28, 3),
(27, 0.07, 'Haber', 29, 3),
(28, 100, 'Debe', 30, 3),
(30, 110, 'Debe', 31, 3),
(31, 110, 'Haber', 31, 3),
(32, 110, 'Haber', 31, 3),
(33, 100, 'Debe', 32, 3),
(34, 100, 'Debe', 32, 3),
(35, 100, 'Haber', 32, 3),
(36, 100, 'Haber', 32, 3),
(38, 100, 'Debe', 33, 3),
(39, 100, 'Debe', 33, 3),
(40, 100, 'Debe', 33, 3),
(42, 100, 'Debe', 34, 3),
(43, 100, 'Debe', 34, 3),
(44, 100, 'Debe', 34, 3),
(45, 100, 'Debe', 34, 3),
(46, 100, 'Debe', 35, 3),
(47, 100, 'Debe', 35, 3),
(48, 100, 'Haber', 35, 3),
(49, 100, 'Debe', 36, 3),
(50, 100, 'Haber', 36, 3),
(51, 100, 'Haber', 36, 3),
(52, 0, 'Debe', 37, 3),
(54, 100, 'Debe', 38, 3),
(55, 100, 'Haber', 38, 3),
(56, 100, 'Haber', 38, 3),
(57, 100, 'Debe', 40, 3),
(58, 300, 'Haber', 40, 3),
(59, 100, 'Debe', 41, 3),
(60, 100, 'Haber', 41, 3),
(61, 100, 'Debe', 42, 1),
(62, 200, 'Haber', 42, 2),
(63, 20, 'Debe', 42, 3),
(64, 80, 'Debe', 42, 4),
(65, 0.03, 'Debe', 43, 2),
(66, 0.02, 'Debe', 44, 2),
(67, 0.02, 'Haber', 44, 2),
(68, 2000, 'Haber', 45, 4),
(69, 2000, 'Debe', 45, 4),
(70, 1000, 'Debe', 46, 4),
(71, 1000, 'Haber', 46, 7),
(72, 100, 'Debe', 47, 5),
(73, 100, 'Haber', 47, 5),
(74, 10, 'Debe', 48, 5),
(75, 100, 'Debe', 49, 4),
(76, 100, 'Haber', 49, 5),
(77, 50, 'Debe', 50, 4),
(78, 100, 'Debe', 51, 5),
(79, 100, 'Debe', 52, 5),
(80, 50, 'Debe', 53, 5),
(81, 50, 'Debe', 54, 5),
(82, 50, '', 55, 5),
(83, 50, 'Debe', 56, 5),
(84, 50, 'Haber', 56, 7),
(85, 50, 'Debe', 57, 5),
(86, 50, 'Haber', 57, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `idCuenta` int(11) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `cuentaPadre` int(11) DEFAULT NULL,
  `tipoCuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`idCuenta`, `codigo`, `descripcion`, `cuentaPadre`, `tipoCuenta`) VALUES
(1, '1', 'Activos', NULL, 1),
(2, '11', 'Activos Circulantes', 1, 1),
(3, '111', 'Caja', 2, 1),
(4, '1111', 'Caja General', 3, 1),
(5, '1112', 'Caja Chica', 3, 1),
(6, '2', 'Pasivos', NULL, 2),
(7, '21', 'Cuentas por pagar', 6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `idDetalle` int(11) NOT NULL,
  `monto` double NOT NULL,
  `accion` int(11) NOT NULL,
  `idCuenta` int(11) NOT NULL,
  `idComprobanteDetalle` int(11) NOT NULL,
  `idComprobante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `idPeriodo` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`idPeriodo`, `fechaInicio`, `fechaFin`) VALUES
(1, '2018-01-02', '2018-12-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saldo`
--

CREATE TABLE `saldo` (
  `idSaldo` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `totalDebe` double NOT NULL,
  `totalHaber` double NOT NULL,
  `saldoFinal` double NOT NULL,
  `idCuenta` int(11) NOT NULL,
  `idPeriodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `saldo`
--

INSERT INTO `saldo` (`idSaldo`, `anio`, `totalDebe`, `totalHaber`, `saldoFinal`, `idCuenta`, `idPeriodo`) VALUES
(2, 2018, 200, 200, 100, 5, 1),
(3, 2018, 300, 300, 100, 4, 1),
(4, 2018, 0, 0, 100, 7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocuenta`
--

CREATE TABLE `tipocuenta` (
  `idTipoCuenta` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipocuenta`
--

INSERT INTO `tipocuenta` (`idTipoCuenta`, `nombre`) VALUES
(1, 'Activos'),
(2, 'Pasivos'),
(3, 'Capital');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `usuario` varchar(40) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`idComprobante`);

--
-- Indices de la tabla `comprobantedetalle`
--
ALTER TABLE `comprobantedetalle`
  ADD PRIMARY KEY (`idComprobanteDetalle`,`idComprobante`),
  ADD KEY `fk_ComprobanteDetalle_Comprobante1_idx` (`idComprobante`),
  ADD KEY `fk_ComprobanteDetalle_Cuenta1_idx` (`idCuenta`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`idCuenta`),
  ADD KEY `fk_Cuenta_Cuenta_idx` (`cuentaPadre`),
  ADD KEY `fk_Cuenta_TipoCuenta1_idx` (`tipoCuenta`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `fk_Detalle_Cuenta1_idx` (`idCuenta`),
  ADD KEY `fk_Detalle_ComprobanteDetalle1_idx` (`idComprobanteDetalle`,`idComprobante`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`idPeriodo`);

--
-- Indices de la tabla `saldo`
--
ALTER TABLE `saldo`
  ADD PRIMARY KEY (`idSaldo`,`idCuenta`,`idPeriodo`),
  ADD KEY `fk_Saldo_Cuenta1_idx` (`idCuenta`),
  ADD KEY `fk_Saldo_Periodo1_idx` (`idPeriodo`);

--
-- Indices de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  ADD PRIMARY KEY (`idTipoCuenta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `idComprobante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT de la tabla `comprobantedetalle`
--
ALTER TABLE `comprobantedetalle`
  MODIFY `idComprobanteDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;
--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `idCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `periodo`
--
ALTER TABLE `periodo`
  MODIFY `idPeriodo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `saldo`
--
ALTER TABLE `saldo`
  MODIFY `idSaldo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  MODIFY `idTipoCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comprobantedetalle`
--
ALTER TABLE `comprobantedetalle`
  ADD CONSTRAINT `fk_ComprobanteDetalle_Comprobante1` FOREIGN KEY (`idComprobante`) REFERENCES `comprobante` (`idComprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ComprobanteDetalle_Cuenta1` FOREIGN KEY (`idCuenta`) REFERENCES `cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `fk_Cuenta_Cuenta` FOREIGN KEY (`cuentaPadre`) REFERENCES `cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cuenta_TipoCuenta1` FOREIGN KEY (`tipoCuenta`) REFERENCES `tipocuenta` (`idTipoCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `fk_Detalle_ComprobanteDetalle1` FOREIGN KEY (`idComprobanteDetalle`,`idComprobante`) REFERENCES `comprobantedetalle` (`idComprobanteDetalle`, `idComprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detalle_Cuenta1` FOREIGN KEY (`idCuenta`) REFERENCES `cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `saldo`
--
ALTER TABLE `saldo`
  ADD CONSTRAINT `fk_Saldo_Cuenta1` FOREIGN KEY (`idCuenta`) REFERENCES `cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Saldo_Periodo1` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

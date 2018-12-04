-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2018 a las 09:17:49
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
(17, '2018-12-03', 'Oscar Mayen', 'Inicializar Cuentas', '2018-12-03'),
(18, '2018-12-03', 'Oscar', 'Compra de Seguro', '2018-12-03'),
(19, '2018-12-03', 'Edwin Diaz', 'Compra de Mobiliario', '2018-12-03'),
(20, '2018-12-03', 'Edwin Diaz', 'Servicios de Remodelacion a banco', '2018-12-03'),
(21, '2018-12-03', 'Elias Sorto', 'Pago mitad de Mobiliario', '2018-12-03'),
(22, '2018-12-03', 'Elias Sorto', 'Prestamo Bancario', '2018-12-03'),
(23, '2018-12-03', 'Tobias Santamaria', 'Compra de Vehiculo', '2018-12-03'),
(24, '2018-12-03', 'Tobias Santamaria', 'Servicios de Remodelacion', '2018-12-03'),
(25, '2018-12-03', 'Francisco Orellana', 'Servicios Basicos', '2018-12-03'),
(26, '2018-12-03', 'Francisco Orellana', 'Cancelar Mobiliario', '2018-12-03'),
(27, '2018-12-03', 'Oscar Mayen', 'Pago de Salarios', '2018-12-03');

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
(47, 50000, 'Debe', 17, 18),
(48, 10000, 'Debe', 17, 19),
(49, 15000, 'Debe', 17, 20),
(50, 75000, 'Haber', 17, 3),
(51, 7000, 'Debe', 18, 22),
(52, 7000, 'Haber', 18, 18),
(53, 18000, 'Debe', 19, 21),
(54, 9000, 'Haber', 19, 18),
(55, 9000, 'Haber', 19, 25),
(56, 10000, 'Debe', 20, 18),
(57, 10000, 'Haber', 20, 28),
(58, 4500, 'Debe', 21, 25),
(59, 4500, 'Haber', 21, 18),
(60, 10000, 'Debe', 22, 18),
(61, 10000, 'Haber', 22, 25),
(62, 15000, 'Debe', 23, 23),
(63, 15000, 'Haber', 23, 25),
(64, 3000, 'Debe', 24, 18),
(65, 3000, 'Haber', 24, 19),
(66, 6000, 'Debe', 24, 24),
(67, 6000, 'Haber', 24, 28),
(68, 80, 'Debe', 25, 27),
(69, 80, 'Haber', 25, 25),
(70, 4500, 'Haber', 26, 18),
(71, 4500, 'Debe', 26, 25),
(72, 3500, 'Debe', 27, 26),
(73, 3500, 'Haber', 27, 18);

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
(2, '2', 'Pasivos', NULL, 2),
(3, '3', 'Capital', NULL, 2),
(18, '11', 'Efectivo', 1, 1),
(19, '12', 'Inventario', 1, 1),
(20, '13', 'Gasto por Tramites', 1, 1),
(21, '14', 'Mobiliario', 1, 1),
(22, '15', 'Seguro', 1, 1),
(23, '16', 'Vehiculo', 1, 1),
(24, '17', 'Cuentas por Cobrar', 1, 1),
(25, '21', 'Cuentas por Pagar', 2, 2),
(26, '4', 'Salario Pactado', NULL, 4),
(27, '5', 'Gasto Sevicios Basicos', NULL, 4),
(28, '6', 'Ingresos por Servicios', NULL, 3);

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
(6, 2018, 73000, 28500, 44500, 18, 1),
(7, 2018, 10000, 3000, 7000, 19, 1),
(8, 2018, 15000, 0, 15000, 20, 1),
(9, 2018, 0, 75000, 75000, 3, 1),
(10, 2018, 18000, 0, 18000, 21, 1),
(11, 2018, 7000, 0, 7000, 22, 1),
(12, 2018, 15000, 0, 15000, 23, 1),
(13, 2018, 6000, 0, 6000, 24, 1),
(14, 2018, 9000, 34080, 25080, 25, 1),
(15, 2018, 3500, 0, 3500, 26, 1),
(16, 2018, 80, 0, 80, 27, 1),
(17, 2018, 0, 16000, 16000, 28, 1);

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
(1, 'Deudora'),
(2, 'Acreedora'),
(3, 'Acreedora R'),
(4, 'Deudora R');

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
  MODIFY `idComprobante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de la tabla `comprobantedetalle`
--
ALTER TABLE `comprobantedetalle`
  MODIFY `idComprobanteDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `idCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
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
  MODIFY `idSaldo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `tipocuenta`
--
ALTER TABLE `tipocuenta`
  MODIFY `idTipoCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
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

-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2015 a las 23:57:58
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `beta11`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acciones`
--

CREATE TABLE IF NOT EXISTS `acciones` (
  `id_acciones` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `fecha` varchar(8) NOT NULL,
  `hora` varchar(7) NOT NULL,
  `id_elementoModif` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_acciones`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;

--
-- Volcado de datos para la tabla `acciones`
--

INSERT INTO `acciones` (`id_acciones`, `descripcion`, `usuario`, `fecha`, `hora`, `id_elementoModif`) VALUES
(1, 'Usuario agregado: temoc, Permisos: 2', 'lara', '12/09/14', '19:29', 'temoc'),
(2, 'Usuario Modificado: temoc, Permisos: 2', 'lara', '12/09/14', '20:12', 'temoc'),
(3, 'Reporte de prestarios moroso', 'lara', '12/09/14', '20:31', NULL),
(4, 'Reporte de prestarios moroso', 'lara', '12/09/14', '20:32', NULL),
(5, 'Reporte de materiales existentes', 'lara', '12/09/14', '20:32', NULL),
(6, 'Reporte de usuarios del servicio social', 'lara', '12/09/14', '20:33', NULL),
(7, 'Reporte de prestarios moroso', 'lara', '12/11/14', '12:28', NULL),
(8, 'Reporte de materiales existentes', 'lara', '12/11/14', '12:28', NULL),
(9, 'Reporte de materiales existentes', 'lara', '12/11/14', '12:28', NULL),
(10, 'Reporte de materiales existentes', 'lara', '12/11/14', '12:28', NULL),
(11, 'Reporte de materiales existentes', 'lara', '12/11/14', '12:28', NULL),
(12, 'Material agregado: proyector, cantidad: 3', 'lara', '01/17/15', '19:19', 'ABC123'),
(13, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/17/15', '21:34', 'ABC123'),
(14, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/17/15', '21:43', 'ABC123'),
(15, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/17/15', '21:49', 'ABC123'),
(16, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/17/15', '21:59', 'ABC123'),
(17, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/17/15', '22:16', 'ABC123'),
(18, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/17/15', '22:29', 'ABC123'),
(19, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/17/15', '22:51', 'ABC123'),
(20, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/18/15', '22:06', 'ABC123'),
(21, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/18/15', '22:09', 'ABC123'),
(22, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/18/15', '22:14', 'ABC123'),
(23, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/18/15', '22:19', 'ABC123'),
(24, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/18/15', '22:33', 'ABC123'),
(25, 'Material Modificado: proyector, cantidad: 3', 'lara', '01/18/15', '22:34', 'ABC123'),
(26, 'Material Modificado: proyector, cantidad: 2', 'lara', '01/18/15', '22:40', 'ABC123'),
(27, 'Material Modificado: proyector, cantidad: 4', 'lara', '01/18/15', '22:45', 'ABC123'),
(28, 'Material Modificado: proyector, cantidad: 3', 'lara', '01/18/15', '22:51', 'ABC123'),
(29, 'Material Modificado: proyector, cantidad: 2', 'lara', '01/18/15', '22:54', 'ABC123'),
(30, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/18/15', '22:55', 'ABC123'),
(31, 'Material Modificado: proyector, cantidad: 15', 'lara', '01/18/15', '22:58', 'ABC123'),
(32, 'Material Modificado: proyector, cantidad: 14', 'lara', '01/18/15', '22:58', 'ABC123'),
(33, 'Material Modificado: proyector, cantidad: 13', 'lara', '01/18/15', '22:59', 'ABC123'),
(34, 'Material Modificado: proyector, cantidad: 12', 'lara', '01/18/15', '23:00', 'ABC123'),
(35, 'Material Modificado: proyector, cantidad: 11', 'lara', '01/18/15', '23:02', 'ABC123'),
(36, 'Material Modificado: proyector, cantidad: 10', 'lara', '01/18/15', '23:03', 'ABC123'),
(37, 'Material Modificado: proyector, cantidad: 9', 'lara', '01/18/15', '23:04', 'ABC123'),
(38, 'Material Modificado: proyector, cantidad: 8', 'lara', '01/18/15', '23:06', 'ABC123'),
(39, 'Material Modificado: proyector, cantidad: 7', 'lara', '01/18/15', '23:08', 'ABC123'),
(40, 'Material Modificado: proyector, cantidad: 6', 'lara', '01/18/15', '23:09', 'ABC123'),
(41, 'Material Modificado: proyector, cantidad: 5', 'lara', '01/18/15', '23:44', 'ABC123'),
(42, 'Material Modificado: proyector, cantidad: 4', 'lara', '01/18/15', '23:50', 'ABC123'),
(43, 'Material Modificado: proyector, cantidad: 3', 'lara', '01/18/15', '23:52', 'ABC123'),
(44, 'Material Modificado: proyector, cantidad: 2', 'lara', '01/19/15', '00:02', 'ABC123'),
(45, 'Material Modificado: proyector, cantidad: 1', 'lara', '01/19/15', '00:04', 'ABC123'),
(46, 'Material Modificado: proyector, cantidad: 15', 'lara', '01/19/15', '00:05', 'ABC123'),
(47, 'Material Modificado: proyector, cantidad: 14', 'lara', '01/19/15', '00:05', 'ABC123'),
(48, 'Material Modificado: proyector, cantidad: 13', 'lara', '01/19/15', '00:06', 'ABC123'),
(49, 'Material Modificado: proyector, cantidad: 12', 'lara', '01/19/15', '00:07', 'ABC123'),
(50, 'Material Modificado: proyector, cantidad: 11', 'lara', '01/19/15', '13:27', 'ABC123'),
(51, 'Material Modificado: proyector, cantidad: 12', 'lara', '01/19/15', '14:58', 'ABC123'),
(52, 'Material Modificado: proyector, cantidad: 11', 'lara', '01/19/15', '14:58', 'ABC123'),
(53, 'Material Modificado: proyector, cantidad: 10', 'lara', '01/19/15', '15:06', 'ABC123'),
(54, 'Material Modificado: proyector, cantidad: 9', 'lara', '01/19/15', '16:13', 'ABC123'),
(55, 'Material Modificado: proyector, cantidad: 8', 'lara', '01/19/15', '16:26', 'ABC123'),
(56, 'Material Modificado: proyector, cantidad: 7', 'lara', '01/20/15', '20:52', 'ABC123'),
(57, 'Material agregado: tablet galaxy, cantidad: 15', 'lara', '01/26/15', '11:28', '213QWEWQ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE IF NOT EXISTS `almacen` (
  `idalmacen` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idalmacen`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`idalmacen`, `descripcion`) VALUES
(1, 'electronica'),
(2, 'quimica'),
(3, 'dsdsd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `map`
--

CREATE TABLE IF NOT EXISTS `map` (
  `id_map` int(11) NOT NULL AUTO_INCREMENT,
  `subFamilias_id_subFam` int(11) NOT NULL,
  `tbl_tipomaterial_id_tipomaterial` int(11) NOT NULL,
  PRIMARY KEY (`id_map`,`subFamilias_id_subFam`),
  KEY `fk_table1_subFamilias1_idx` (`subFamilias_id_subFam`),
  KEY `fk_map_tbl_tipomaterial1_idx` (`tbl_tipomaterial_id_tipomaterial`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `map`
--

INSERT INTO `map` (`id_map`, `subFamilias_id_subFam`, `tbl_tipomaterial_id_tipomaterial`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(5, 5, 2),
(4, 4, 3),
(6, 6, 5),
(8, 8, 5),
(7, 7, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subfamilias`
--

CREATE TABLE IF NOT EXISTS `subfamilias` (
  `id_subFam` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_subFam`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `subfamilias`
--

INSERT INTO `subfamilias` (`id_subFam`, `nombre`, `descripcion`) VALUES
(1, 'resistencias', 'varios tipos de resistencias, carbon, alambre,'),
(2, 'transistores', 'npn, pnp, potencia y baja potencia'),
(3, 'laboratorio quimica', 'probeta,balanza'),
(4, 'pistones', 'varios vistones'),
(5, 'qqqqqqqq', 'dsfsdfs'),
(6, 'proyectores', 'proyectores varios'),
(7, 'laptops', 'varias laptops'),
(8, 'tablets', 'todas las tablets que existan.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpiezas`
--

CREATE TABLE IF NOT EXISTS `tblpiezas` (
  `idtblpiezas` int(11) NOT NULL AUTO_INCREMENT,
  `serie` varchar(80) DEFAULT NULL,
  `inventario_uabc` varchar(80) DEFAULT NULL,
  `clave2` varchar(80) DEFAULT NULL,
  `noParte_modelo` varchar(80) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `comentario` varchar(80) DEFAULT NULL,
  `estatus` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idtblpiezas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Volcado de datos para la tabla `tblpiezas`
--

INSERT INTO `tblpiezas` (`idtblpiezas`, `serie`, `inventario_uabc`, `clave2`, `noParte_modelo`, `nombre`, `comentario`, `estatus`) VALUES
(2, 'abcdefghijk', '123456', NULL, 'ABC123', 'proyector', NULL, 0),
(7, '', 'marco', NULL, 'wqe32432e32', 'laptop  samsung', NULL, 1),
(8, '', '21312321312312312321312312', NULL, 'wqe32432e32', 'laptop  samsung', NULL, 0),
(10, 'ymir', '', NULL, 'wqe32432e32', 'laptop  samsung', NULL, 1),
(11, NULL, NULL, NULL, 'wqe32432e32', 'laptop  samsung', NULL, 0),
(12, NULL, NULL, NULL, 'wqe32432e32', 'laptop  samsung', NULL, 0),
(13, 'thanathos', 'neith', NULL, '213QWEWQ', 'tablet galaxy', NULL, 1),
(14, '1231gfd43242cc', 'DGH1278', NULL, '213QWEWQ', 'tablet galaxy', NULL, 1),
(15, 'azula', 'asami', NULL, '213QWEWQ', 'tablet galaxy', NULL, 0),
(16, 'sokka', 'mako', NULL, '213QWEWQ', 'tablet galaxy', NULL, 1),
(17, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(18, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(19, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(20, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(21, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(22, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(23, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(24, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(25, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(26, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL),
(27, NULL, NULL, NULL, '213QWEWQ', 'tablet galaxy', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_area`
--

CREATE TABLE IF NOT EXISTS `tbl_area` (
  `id_area` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=20 ;

--
-- Volcado de datos para la tabla `tbl_area`
--

INSERT INTO `tbl_area` (`id_area`, `descripcion`) VALUES
(1, 'consumibles'),
(2, 'materiales'),
(3, 'sdkjjkdf'),
(4, 'prueba'),
(5, 'automatizacion'),
(6, 'prueba5'),
(7, 'prueba10'),
(8, 'prueba20'),
(9, 'prueba30'),
(10, 'prueba50'),
(11, 'prueba70'),
(12, 'prueba90'),
(13, 'prueba110'),
(14, 'prueba130'),
(15, 'prueba150'),
(16, 'prueba170'),
(17, 'prueba190'),
(18, 'computacion'),
(19, 'compu2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_detalleprestamo`
--

CREATE TABLE IF NOT EXISTS `tbl_detalleprestamo` (
  `id_detalleprestamo` int(11) NOT NULL AUTO_INCREMENT,
  `id_prestamo` int(11) NOT NULL,
  `id_material` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecharetorno` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horaretorno` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
  `regresados` int(11) NOT NULL,
  `infroPres` varchar(800) COLLATE utf8_spanish_ci DEFAULT NULL,
  `invi` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_detalleprestamo`),
  KEY `fk_tbl_detalleprestamo_tbl_prestamo1_idx` (`id_prestamo`),
  KEY `fk_tbl_detalleprestamo_tbl_material1_idx` (`id_material`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=223 ;

--
-- Volcado de datos para la tabla `tbl_detalleprestamo`
--

INSERT INTO `tbl_detalleprestamo` (`id_detalleprestamo`, `id_prestamo`, `id_material`, `cantidad`, `fecharetorno`, `horaretorno`, `regresados`, `infroPres`, `invi`) VALUES
(66, 55, 1, 5, '2014/06/20', '23:36', 5, NULL, NULL),
(69, 56, 1, 3, '2014/06/23', '18:09', 3, NULL, NULL),
(70, 57, 1, 1, '2014/06/23', '15:47', 1, NULL, NULL),
(71, 58, 1, 1, '2014/06/23', '19:24', 1, NULL, NULL),
(72, 59, 1, 2, '2014/06/23', '19:24', 2, NULL, NULL),
(73, 60, 1, 3, '2014/06/23', '19:23', 3, NULL, NULL),
(74, 59, 1, 2, '2014/06/23', '19:24', 2, NULL, NULL),
(75, 61, 1, 1, '2014/06/23', '19:23', 1, NULL, NULL),
(76, 62, 1, 7, '2014/06/23', '19:35', 7, NULL, NULL),
(77, 63, 1, 5, NULL, NULL, 0, NULL, NULL),
(78, 64, 1, 11, '2014/08/19', '09:28', 11, NULL, NULL),
(79, 63, 1, 5, NULL, NULL, 0, NULL, NULL),
(80, 65, 2, 1, '2014/08/11', '14:41', 1, NULL, NULL),
(81, 66, 2, 1, '2014/08/11', '14:46', 1, NULL, NULL),
(82, 65, 2, 1, NULL, NULL, 0, NULL, NULL),
(83, 67, 2, 4, '2014/08/11', '14:55', 4, NULL, NULL),
(84, 68, 2, 17, '2014/08/14', '12:49', 17, NULL, NULL),
(85, 67, 2, 4, NULL, NULL, 0, NULL, NULL),
(86, 69, 3, 6, '2014/08/14', '12:47', 6, NULL, NULL),
(87, 70, 1, 7, '2014/08/14', '19:41', 7, NULL, NULL),
(88, 71, 1, 7, '2014/08/14', '20:18', 7, NULL, NULL),
(89, 71, 3, 9, '2014/08/14', '20:20', 9, NULL, NULL),
(90, 72, 2, 3, '2014/08/19', '09:00', 3, NULL, NULL),
(91, 71, 3, 5, NULL, NULL, 0, NULL, NULL),
(92, 71, 1, 3, NULL, NULL, 0, NULL, NULL),
(94, 73, 3, 2, NULL, NULL, 0, NULL, NULL),
(95, 74, 1, 2, NULL, NULL, 0, NULL, NULL),
(96, 74, 3, 1, NULL, NULL, 0, NULL, NULL),
(98, 75, 2, 3, NULL, NULL, 0, NULL, NULL),
(100, 76, 2, 4, NULL, NULL, 0, NULL, NULL),
(102, 77, 3, 7, '', '', 0, NULL, NULL),
(103, 78, 3, 3, NULL, NULL, 0, NULL, NULL),
(104, 79, 2, 1, '2014/08/18', '23:08', 1, NULL, NULL),
(105, 78, 3, 3, NULL, NULL, 0, NULL, NULL),
(106, 80, 1, 1, '2015/01/22', '14:19', 1, NULL, NULL),
(107, 81, 2, 1, '2015/01/22', '13:42', 1, NULL, NULL),
(108, 82, 2, 2, '2015/01/22', '13:30', 2, NULL, NULL),
(109, 83, 2, 10, '2015/01/22', '13:04', 10, NULL, NULL),
(111, 84, 3, 2, '2015/01/22', '12:46', 2, NULL, NULL),
(112, 85, 2, 2, '2015/01/22', '12:14', 2, NULL, NULL),
(113, 63, 1, 5, '2014/08/19', '09:37', 5, NULL, NULL),
(114, 63, 1, 5, '2014/08/19', '09:37', 5, NULL, NULL),
(115, 75, 2, 3, '2014/08/19', '09:54', 3, NULL, NULL),
(116, 86, 1, 5, NULL, NULL, 0, NULL, NULL),
(117, 76, 2, 4, '2014/08/19', '10:26', 4, NULL, NULL),
(118, 87, 3, 2, NULL, NULL, 0, NULL, NULL),
(119, 87, 3, 2, '2014/08/19', '11:11', 2, NULL, NULL),
(120, 73, 3, 2, '2014/08/19', '11:22', 2, NULL, NULL),
(121, 88, 1, 2, NULL, NULL, 0, NULL, NULL),
(122, 88, 2, 5, NULL, NULL, 0, NULL, NULL),
(123, 88, 3, 3, NULL, NULL, 0, NULL, NULL),
(124, 89, 3, 2, '', '', 0, NULL, NULL),
(125, 88, 3, 3, '2014/08/19', '11:58', 3, NULL, NULL),
(126, 88, 1, 2, '2014/08/19', '11:58', 2, NULL, NULL),
(127, 88, 2, 5, '2014/08/19', '11:58', 5, NULL, NULL),
(128, 90, 3, 15, NULL, NULL, 0, NULL, NULL),
(129, 91, 2, 2, NULL, NULL, 0, NULL, NULL),
(130, 91, 1, 2, NULL, NULL, 0, NULL, NULL),
(132, 92, 1, 6, NULL, NULL, 0, NULL, NULL),
(133, 92, 2, 3, NULL, NULL, 0, NULL, NULL),
(134, 93, 1, 10, '', '', 0, NULL, NULL),
(135, 93, 3, 4, NULL, NULL, 0, NULL, NULL),
(136, 91, 3, 2, NULL, NULL, 0, NULL, NULL),
(137, 91, 2, 2, NULL, NULL, 0, NULL, NULL),
(138, 91, 1, 2, NULL, NULL, 0, NULL, NULL),
(139, 93, 1, 10, '2014/08/19', '16:19', 10, NULL, NULL),
(140, 93, 3, 4, '2014/08/19', '16:19', 4, NULL, NULL),
(141, 94, 3, 2, NULL, NULL, 0, NULL, NULL),
(142, 94, 1, 2, NULL, NULL, 0, NULL, NULL),
(143, 95, 2, 7, NULL, NULL, 0, NULL, NULL),
(144, 92, 1, 6, '2014/08/19', '17:40', 6, NULL, NULL),
(145, 92, 2, 3, '2014/08/19', '17:40', 3, NULL, NULL),
(146, 96, 1, 8, NULL, NULL, 0, NULL, NULL),
(147, 96, 3, 8, NULL, NULL, 0, NULL, NULL),
(148, 96, 2, 8, NULL, NULL, 0, NULL, NULL),
(149, 90, 3, 15, '2014/08/19', '21:37', 15, NULL, NULL),
(150, 95, 2, 7, '2014/08/19', '21:39', 7, NULL, NULL),
(151, 91, 3, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(152, 91, 2, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(153, 91, 2, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(154, 91, 1, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(155, 91, 1, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(156, 94, 3, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(157, 94, 1, 2, '2014/08/19', '21:40', 2, NULL, NULL),
(158, 89, 3, 2, '2014/08/19', '21:41', 2, NULL, NULL),
(159, 74, 1, 2, '2014/08/19', '21:41', 2, NULL, NULL),
(160, 74, 3, 1, '2014/08/19', '21:41', 1, NULL, NULL),
(161, 96, 2, 8, '2014/08/19', '21:51', 8, NULL, NULL),
(162, 96, 3, 8, '2014/08/19', '21:51', 8, NULL, NULL),
(163, 96, 1, 8, '2014/08/19', '21:51', 8, NULL, NULL),
(164, 86, 1, 5, '2014/08/19', '21:51', 5, NULL, NULL),
(167, 97, 1, 3, '2015/01/12', '20:09', 3, NULL, NULL),
(168, 98, 2, 9, NULL, NULL, 0, NULL, NULL),
(169, 98, 3, 5, NULL, NULL, 0, NULL, NULL),
(170, 99, 2, 1, NULL, NULL, 0, NULL, NULL),
(172, 100, 3, 11, NULL, NULL, 0, NULL, NULL),
(173, 101, 1, 13, '', '', 0, NULL, NULL),
(174, 102, 1, 2, NULL, NULL, 0, NULL, NULL),
(175, 103, 2, 3, NULL, NULL, 0, NULL, NULL),
(176, 101, 1, 13, '2014/12/09', '08:17', 3, NULL, NULL),
(177, 101, 1, 13, '2015/01/12', '19:30', 3, NULL, NULL),
(178, 101, 1, 13, '2014/12/09', '08:17', 3, NULL, NULL),
(179, 101, 1, 13, '2015/01/12', '19:39', 3, NULL, NULL),
(180, 101, 1, 13, '2014/12/09', '08:17', 3, NULL, NULL),
(181, 101, 1, 13, '2014/12/09', '08:17', 3, NULL, NULL),
(182, 101, 1, 13, '2015/01/12', '19:30', 3, NULL, NULL),
(183, 104, 2, 5, '2015/01/12', '20:34', 5, '[{"clave1":"123","clave2":"456","responsable":"marco isaac","comentario":"piezas muy especiales","nombreObjeto":"pieza ewq","serie":"WL123ER"}]', NULL),
(184, 104, 3, 3, '2015/01/12', '20:30', 3, NULL, NULL),
(185, 105, 4, 3, '2015/01/13', '14:10', 3, '[{"clave1":"1234","clave2":"5677","responsable":"marco","comentario":"DASDASDSADAS","nombreObjeto":"kjdkjfk","serie":"QWEWQ3432"}]', NULL),
(187, 106, 2, 3, NULL, NULL, 0, NULL, NULL),
(188, 107, 1, 3, NULL, NULL, 0, NULL, NULL),
(189, 108, 3, 3, NULL, NULL, 0, NULL, NULL),
(190, 109, 3, 1, NULL, NULL, 0, NULL, NULL),
(191, 109, 3, 1, NULL, NULL, 0, NULL, NULL),
(192, 110, 3, 2, NULL, NULL, 0, NULL, NULL),
(193, 109, 3, 1, NULL, NULL, 0, NULL, NULL),
(194, 111, 3, 2, NULL, NULL, 0, NULL, NULL),
(196, 112, 2, 2, NULL, NULL, 0, NULL, NULL),
(197, 109, 3, 1, NULL, NULL, 0, NULL, NULL),
(198, 110, 3, 2, NULL, NULL, 0, NULL, NULL),
(199, 111, 3, 2, NULL, NULL, 0, NULL, NULL),
(200, 113, 3, 1, '', '', 0, NULL, NULL),
(201, 114, 4, 4, NULL, NULL, 0, NULL, NULL),
(202, 115, 1, 2, NULL, NULL, 0, NULL, NULL),
(203, 116, 2, 2, NULL, NULL, 0, NULL, NULL),
(204, 117, 4, 2, NULL, NULL, 0, NULL, NULL),
(205, 118, 14, 1, NULL, NULL, 0, NULL, NULL),
(206, 119, 14, 4, '2015/01/25', '21:05', 4, 'null', NULL),
(207, 120, 14, 4, '2015/01/25', '22:26', 4, '[{"id":7,"clave1":"marco","responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung","serie":""},{"id":8,"clave1":"21312321312312312321312312","responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung","serie":""},{"id":10,"clave1":"","responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung","serie":"ymir"},{"id":11,"responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung"}]', NULL),
(208, 121, 14, 2, '2015/01/26', '00:24', 2, '[{"id":7,"clave1":"marco","responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung","serie":""},{"id":10,"clave1":"","responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung","serie":"ymir"}]', NULL),
(209, 122, 14, 1, '2015/01/26', '00:26', 1, '[{"id":8,"clave1":"21312321312312312321312312","responsable":"marco vazquez gutierrez","nombreObjeto":"laptop  samsung","serie":""}]', 1),
(210, 123, 15, 1, '', '', 0, '[{"id":13,"clave1":"neith","responsable":"marco vazquez gutierrez","nombreObjeto":"tablet galaxy","serie":"thanathos"}]', 1),
(211, 124, 2, 3, '', '', 0, NULL, 0),
(213, 125, 15, 1, '2015/01/26', '14:04', 1, '[{"id":14,"clave1":"DGH1278","responsable":"berenice gonzales mendez","nombreObjeto":"tablet galaxy","serie":"1231gfd43242cc"}]', 1),
(215, 126, 15, 1, NULL, NULL, 0, '[{"id":14,"clave1":"DGH1278","responsable":"berenice gonzales mendez","nombreObjeto":"tablet galaxy","serie":"1231gfd43242cc"}]', 1),
(216, 125, 15, 1, NULL, NULL, 0, NULL, 1),
(217, 126, 3, 1, NULL, NULL, 0, NULL, 0),
(218, 127, 15, 1, NULL, NULL, 0, NULL, 1),
(219, 126, 15, 1, NULL, NULL, 0, NULL, 1),
(220, 125, 15, 1, NULL, NULL, 0, NULL, 1),
(221, 128, 2, 2, NULL, NULL, 0, NULL, 0),
(222, 128, 15, 1, NULL, NULL, 0, '[{"id":14,"clave1":"DGH1278","responsable":"berenice gonzales mendez","nombreObjeto":"tablet galaxy","serie":"1231gfd43242cc"}]', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_material`
--

CREATE TABLE IF NOT EXISTS `tbl_material` (
  `idtbl_material` int(11) NOT NULL AUTO_INCREMENT,
  `noParte` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `id_area` int(11) NOT NULL,
  `id_tipomaterial` int(11) NOT NULL,
  `costo` decimal(10,0) DEFAULT NULL,
  `imagen` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `subFamilias_id_subFam` int(11) NOT NULL,
  `unidad_medida` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `marca` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `serie` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  `ubicacion_actual` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `responsable` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `proveedor` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numero_factura` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `orden_compra` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigo_sip` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `financiamiento` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo_compra` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_recepcion` date DEFAULT NULL,
  `idUabc` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `almacen_idalmacen` int(11) DEFAULT NULL,
  `showInQuery` tinyint(1) DEFAULT NULL,
  `inventariable` tinyint(1) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtbl_material`),
  UNIQUE KEY `noParte_UNIQUE` (`noParte`),
  KEY `fk_tbl_material_tbl_area1_idx` (`id_area`),
  KEY `fk_tbl_material_tbl_tipomaterial1_idx` (`id_tipomaterial`),
  KEY `fk_tbl_material_subFamilias1_idx` (`subFamilias_id_subFam`),
  KEY `fk_tbl_material_almacen1_idx` (`almacen_idalmacen`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `tbl_material`
--

INSERT INTO `tbl_material` (`idtbl_material`, `noParte`, `nombre`, `descripcion`, `stock`, `id_area`, `id_tipomaterial`, `costo`, `imagen`, `subFamilias_id_subFam`, `unidad_medida`, `marca`, `serie`, `estado`, `ubicacion_actual`, `responsable`, `proveedor`, `numero_factura`, `orden_compra`, `codigo_sip`, `financiamiento`, `tipo_compra`, `fecha_recepcion`, `idUabc`, `almacen_idalmacen`, `showInQuery`, `inventariable`, `total`) VALUES
(1, '2n2222', 'transistor', 'npn ', 84, 1, 1, '15', 'selyR.jpg', 2, 'pz', 'hallmakr', '34234', 'nuevo', 'b1', 'victor', 'steren', '432424332', '342423', '423423', 'uabc', 'dasdas', '2014-06-08', '0', 1, 0, NULL, NULL),
(2, '42634', 'capacitor', 'capacitor electrolitico', 45, 1, 1, '25', 'selyR.jpg', 1, 'pz', 'steren', NULL, 'nuevo', 'b1', 'victor', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL),
(3, '2n225533', 'transote', 'adasdasdas', 37, 2, 2, '89', 'selyR.jpg', 3, 'pz', 'asdasd', '21312321', 'nuevo', 'l2b', 'asdasdasdas', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL),
(4, 'kjjk', 'kjdkjfk', 'kjjjjk', 99, 1, 1, '99', 'img.jpg', 1, 'kj', 'kjjkjk', '990', 'jkjkj', 'kj', 'jkkf', 'kjjkk', 'jk', 'jk', '2234', 'kj', 'kj', '2014-08-21', 'kjjk', 1, 1, NULL, NULL),
(13, 'ABC123', 'proyector', 'qwewqewq', 7, 18, 5, '4500', 'selyR.jpg', 6, 'pz', 'toshiba', '', 'nuevo', 'nd', 'ewqewq', '', '', '', '', '', '', '2015-01-20', '', NULL, 1, 1, 7),
(14, 'wqe32432e32', 'laptop  samsung', 'double core , 64 bits', 5, 19, 6, '12700', 'selyR.jpg', 7, 'pz', 'samsung', '', 'nuevo', 'lb', 'roberth baratheon', '', '', '', '', '', '', '2015-01-22', '', NULL, 0, 1, 5),
(15, '213QWEWQ', 'tablet galaxy', 'tablet samsung galaxy', 12, 18, 5, '2500', 'selyR.jpg', 8, 'pz', 'samsung', '', 'nuevo', 'lb', 'robb ', '', '', '', '', '', '', '2015-01-26', '', NULL, 0, 1, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_pendientes`
--

CREATE TABLE IF NOT EXISTS `tbl_pendientes` (
  `idTbl_Pendientes` int(11) NOT NULL AUTO_INCREMENT,
  `objeto` varchar(60) NOT NULL,
  `razon` varchar(45) NOT NULL,
  `concepto` varchar(45) NOT NULL,
  `comentario` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`idTbl_Pendientes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_prestamo`
--

CREATE TABLE IF NOT EXISTS `tbl_prestamo` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuarios` int(11) DEFAULT NULL,
  `id_prestario` int(11) NOT NULL,
  `fechaprestamo` date DEFAULT NULL,
  `fecharetorno` date DEFAULT NULL,
  `statusprestamo` int(11) NOT NULL,
  `horaprestamo` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_solicitud` date DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  PRIMARY KEY (`id_prestamo`),
  KEY `fk_tbl_prestamo_tbl_usuarios1_idx` (`id_usuarios`),
  KEY `fk_tbl_prestamo_tbl_prestarios1_idx` (`id_prestario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=129 ;

--
-- Volcado de datos para la tabla `tbl_prestamo`
--

INSERT INTO `tbl_prestamo` (`id_prestamo`, `id_usuarios`, `id_prestario`, `fechaprestamo`, `fecharetorno`, `statusprestamo`, `horaprestamo`, `fecha_solicitud`, `fecha_vencimiento`) VALUES
(55, 1, 1, '2014-06-20', '2014-06-20', 3, '23:32', NULL, '2014-06-22'),
(56, 1, 1, '2014-06-22', '2014-06-23', 3, '17:25', NULL, '2014-06-21'),
(57, 1, 1, '2014-06-22', '2014-06-23', 3, '17:54', NULL, '2014-06-30'),
(58, 1, 1, '2014-06-23', '2014-06-23', 3, '18:15', NULL, '2014-06-21'),
(59, 1, 1, '2014-06-23', '2014-06-23', 3, '18:20', NULL, '2014-06-11'),
(60, 1, 1, '2014-06-23', '2014-06-23', 3, '18:38', NULL, '2014-06-01'),
(61, 1, 1, '2014-06-23', '2014-06-23', 3, '19:21', NULL, '2014-06-10'),
(62, 1, 1, '2014-06-23', '2014-06-23', 3, '19:28', NULL, '2014-06-20'),
(63, 1, 1, '2014-08-11', '2014-08-19', 3, '14:23', NULL, '2014-08-11'),
(64, 1, 1, '2014-08-11', '2014-08-19', 3, '14:29', NULL, '2014-08-12'),
(65, 1, 1, '2014-08-11', '2014-08-11', 3, '14:41', NULL, '2014-08-13'),
(66, 1, 1, '2014-08-11', '2014-08-11', 3, '14:43', NULL, '2014-08-11'),
(67, 1, 1, '2014-08-11', '2014-08-11', 3, '14:52', NULL, '2014-08-11'),
(68, 1, 1, '2014-08-11', '2014-08-14', 3, '14:57', NULL, '2014-08-11'),
(69, 1, 1, '2014-08-14', '2014-08-14', 3, '12:33', NULL, '2014-08-14'),
(70, 1, 1, '2014-08-14', '2014-08-14', 3, '19:38', NULL, '2014-08-14'),
(71, 1, 1, '2014-08-14', '2014-08-14', 3, '20:18', NULL, '2014-08-14'),
(72, 1, 1, '2014-08-14', '2014-08-19', 3, '20:23', NULL, '2014-08-14'),
(73, 1, 1, '2014-08-19', '2014-08-19', 3, '09:57', '2014-08-18', '2014-08-19'),
(74, 1, 1, '2014-08-19', '2014-08-19', 3, '21:41', '2014-08-18', '2014-08-20'),
(75, 1, 1, '2014-08-19', '2014-08-19', 3, '09:52', '2014-08-18', '2014-08-20'),
(76, 1, 1, '2014-08-19', '2014-08-19', 3, '09:57', '2014-08-18', '2014-08-19'),
(77, NULL, 3, '2014-08-18', NULL, 4, '22:20', NULL, '2014-08-19'),
(78, NULL, 3, '2014-08-18', NULL, 4, '22:59', '2014-08-18', '2014-08-19'),
(79, 1, 3, '2014-08-18', '2014-08-18', 3, '23:03', '2014-08-18', '2014-08-19'),
(80, 1, 3, '2014-08-19', '2015-01-22', 3, '21:48', '2014-08-19', '2014-08-20'),
(81, 1, 3, '2014-08-19', '2015-01-22', 3, '21:48', '2014-08-19', '2014-08-20'),
(82, 1, 3, '2014-08-19', '2015-01-22', 3, '21:49', '2014-08-19', '2014-08-20'),
(83, 1, 3, '2014-08-19', '2015-01-22', 3, '21:49', '2014-08-19', '2014-08-20'),
(84, 1, 3, '2014-08-19', '2015-01-22', 3, '21:49', '2014-08-19', '2014-08-20'),
(85, 1, 3, '2014-08-19', '2015-01-22', 3, '21:49', '2014-08-19', '2014-08-20'),
(86, 1, 4, '2014-08-19', '2014-08-19', 3, '10:08', '2014-08-19', '2014-08-20'),
(87, 1, 1, '2014-08-19', '2014-08-19', 3, '10:28', '2014-08-19', '2014-08-19'),
(88, 1, 2, '2014-08-19', '2014-08-19', 3, '11:39', '2014-08-19', '2014-08-19'),
(89, 1, 2, '2014-08-19', '2014-08-19', 3, '21:38', '2014-08-19', '2014-08-20'),
(90, 1, 2, '2014-08-19', '2014-08-19', 3, '13:20', '2014-08-19', '2014-08-19'),
(91, 1, 1, '2014-08-19', '2014-08-19', 3, '15:22', '2014-08-19', '2014-08-19'),
(92, 1, 4, '2014-08-19', '2014-08-19', 3, '15:33', '2014-08-19', '2014-08-19'),
(93, 1, 1, '2014-08-19', '2014-08-19', 3, '15:50', '2014-08-19', '2014-08-19'),
(94, 1, 1, '2014-08-19', '2014-08-19', 3, '16:37', '2014-08-19', '2014-08-20'),
(95, 1, 1, '2014-08-19', '2014-08-19', 3, '16:39', '2014-08-19', '2014-08-19'),
(96, 1, 4, '2014-08-19', '2014-08-19', 3, '21:50', '2014-08-19', '2014-08-20'),
(97, 1, 1, '2015-01-12', '2015-01-12', 3, '20:09', '2014-08-19', '2015-01-13'),
(98, NULL, 2, NULL, NULL, 0, NULL, '2014-08-19', NULL),
(99, 1, 3, '2015-01-22', NULL, 4, '13:06', '2014-08-19', '2015-01-23'),
(100, NULL, 4, NULL, NULL, 0, NULL, '2014-08-19', NULL),
(101, 1, 1, '2014-08-19', NULL, 4, '22:34', '2014-08-19', '2014-08-20'),
(102, NULL, 2, NULL, NULL, 0, NULL, '2014-08-20', NULL),
(103, NULL, 2, NULL, NULL, 0, NULL, '2014-12-07', NULL),
(104, 1, 1, '2015-01-12', '2015-01-12', 3, '20:29', '2015-01-12', '2015-01-13'),
(105, 1, 1, '2015-01-13', '2015-01-13', 3, '13:12', '2015-01-12', '2015-01-13'),
(106, NULL, 1, NULL, NULL, 0, NULL, '2015-01-13', NULL),
(107, NULL, 1, NULL, NULL, 0, NULL, '2015-01-14', NULL),
(108, 1, 1, NULL, NULL, 0, NULL, '2015-01-16', NULL),
(109, 1, 3, '2015-01-22', NULL, 4, '13:12', '2015-01-22', '2015-01-23'),
(110, 1, 3, '2015-01-22', NULL, 4, '13:15', '2015-01-22', '2015-01-23'),
(111, 1, 3, '2015-01-22', NULL, 4, '13:15', '2015-01-22', '2015-01-23'),
(112, 1, 3, '2015-01-22', NULL, 4, '13:31', '2015-01-22', '2015-01-23'),
(113, 1, 3, '2015-01-22', NULL, 4, '13:43', '2015-01-22', '2015-01-23'),
(114, 1, 3, NULL, NULL, 0, NULL, '2015-01-22', NULL),
(115, NULL, 3, NULL, NULL, 0, NULL, '2015-01-22', NULL),
(116, NULL, 3, NULL, NULL, 0, NULL, '2015-01-22', NULL),
(117, NULL, 3, NULL, NULL, 0, NULL, '2015-01-22', NULL),
(118, 1, 1, NULL, NULL, 0, NULL, '2015-01-22', NULL),
(119, 1, 1, '2015-01-25', '2015-01-25', 3, '18:46', '2015-01-22', '2015-01-26'),
(120, 1, 1, '2015-01-25', '2015-01-25', 3, '22:10', '2015-01-25', '2015-01-26'),
(121, 1, 1, '2015-01-25', '2015-01-26', 3, '22:43', '2015-01-25', '2015-01-26'),
(122, 1, 1, '2015-01-26', '2015-01-26', 3, '00:25', '2015-01-25', '2015-01-27'),
(123, 1, 1, '2015-01-26', NULL, 1, '12:02', '2015-01-26', '2015-01-27'),
(124, 1, 4, '2015-01-26', NULL, 1, '14:00', '2015-01-26', '2015-01-27'),
(125, 1, 4, '2015-01-26', '2015-01-26', 3, '14:04', '2015-01-26', '2015-01-27'),
(126, 1, 4, '2015-01-26', NULL, 1, '14:06', '2015-01-26', '2015-01-27'),
(127, 1, 1, NULL, NULL, 0, NULL, '2015-01-26', NULL),
(128, 1, 4, '2015-01-26', NULL, 1, '14:29', '2015-01-26', '2015-01-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_prestarios`
--

CREATE TABLE IF NOT EXISTS `tbl_prestarios` (
  `id_prestario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_tipoprestarios` int(11) NOT NULL,
  `apaterno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `amaterno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tel` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `carrera` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `activo` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_prestario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_tbl_prestarios_tbl_tipoprestarios1_idx` (`id_tipoprestarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `tbl_prestarios`
--

INSERT INTO `tbl_prestarios` (`id_prestario`, `nombre`, `id_tipoprestarios`, `apaterno`, `amaterno`, `tel`, `email`, `usuario`, `carrera`, `activo`) VALUES
(1, 'marco', 1, 'vazquez', 'gutierrez', '4234234', 'marco@hotmail.com', '281174', 'mecatronica', 1),
(2, 'dasdas', 1, 'dasdas', 'dasdas', 'dsadas', 'isaac.vazquez@uabc.edu.mx', '281172', NULL, 1),
(3, 'ximena', 1, 'xariñana', 'argote', '6334423', 'marco_417_@hotmail.com', '211349', 'administracion', 2),
(4, 'berenice', 1, 'gonzales', 'mendez', '6663411231', 'marco_417_@hotmail.com', '211581', 'arquitectura', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_rastreo`
--

CREATE TABLE IF NOT EXISTS `tbl_rastreo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_serie` varchar(100) NOT NULL,
  `responsable` varchar(100) NOT NULL,
  `financiamiento` varchar(100) NOT NULL,
  `numParte` varchar(80) NOT NULL,
  `estatus` int(1) NOT NULL,
  `idUabc` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `num_serie` (`num_serie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipomaterial`
--

CREATE TABLE IF NOT EXISTS `tbl_tipomaterial` (
  `id_tipomaterial` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tbl_area_id_area` int(11) NOT NULL,
  PRIMARY KEY (`id_tipomaterial`),
  KEY `fk_tbl_tipomaterial_tbl_area1_idx` (`tbl_area_id_area`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tbl_tipomaterial`
--

INSERT INTO `tbl_tipomaterial` (`id_tipomaterial`, `descripcion`, `tbl_area_id_area`) VALUES
(1, 'electronicos', 1),
(2, 'laboratorios', 2),
(3, 'mecatronica', 5),
(4, 'tipoPrueba1', 7),
(5, 'electronic', 18),
(6, 'computo', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipoprestarios`
--

CREATE TABLE IF NOT EXISTS `tbl_tipoprestarios` (
  `id_tipoprestarios` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_tipoprestarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tbl_tipoprestarios`
--

INSERT INTO `tbl_tipoprestarios` (`id_tipoprestarios`, `descripcion`) VALUES
(1, 'alumnos'),
(2, 'empleados');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipousuarios`
--

CREATE TABLE IF NOT EXISTS `tbl_tipousuarios` (
  `id_tipousuarios` int(1) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_tipousuarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tbl_tipousuarios`
--

INSERT INTO `tbl_tipousuarios` (`id_tipousuarios`, `descripcion`) VALUES
(1, 'servicio social'),
(2, 'administradores');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE IF NOT EXISTS `tbl_usuarios` (
  `id_usuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `apellidop` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `apellidom` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `id_tipousuarios` int(5) NOT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tel` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_usuarios`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_tbl_usuarios_tbl_tipousuarios1_idx` (`id_tipousuarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`id_usuarios`, `nombre`, `contraseña`, `apellidop`, `apellidom`, `id_tipousuarios`, `email`, `tel`, `usuario`) VALUES
(1, 'nelva', 'croft', 'camacho', 'obeso', 2, 'lara@stark.com', '423423', 'lara'),
(2, 'temoc dsdsdsds', '12345', 'dasdasd', 'eqewqe', 2, 'asdas@dads.com', '3242343242', 'temoc');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `map`
--
ALTER TABLE `map`
  ADD CONSTRAINT `fk_map_tbl_tipomaterial1` FOREIGN KEY (`tbl_tipomaterial_id_tipomaterial`) REFERENCES `tbl_tipomaterial` (`id_tipomaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_table1_subFamilias1` FOREIGN KEY (`subFamilias_id_subFam`) REFERENCES `subfamilias` (`id_subFam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_detalleprestamo`
--
ALTER TABLE `tbl_detalleprestamo`
  ADD CONSTRAINT `fk_id_material` FOREIGN KEY (`id_material`) REFERENCES `tbl_material` (`idtbl_material`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_id_prestamo` FOREIGN KEY (`id_prestamo`) REFERENCES `tbl_prestamo` (`id_prestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_material`
--
ALTER TABLE `tbl_material`
  ADD CONSTRAINT `fk_tbl_material_almacen1` FOREIGN KEY (`almacen_idalmacen`) REFERENCES `almacen` (`idalmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_material_subFamilias1` FOREIGN KEY (`subFamilias_id_subFam`) REFERENCES `subfamilias` (`id_subFam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_material_tbl_area1` FOREIGN KEY (`id_area`) REFERENCES `tbl_area` (`id_area`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tbl_material_tbl_tipomaterial1` FOREIGN KEY (`id_tipomaterial`) REFERENCES `tbl_tipomaterial` (`id_tipomaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_prestamo`
--
ALTER TABLE `tbl_prestamo`
  ADD CONSTRAINT `fk_id_usuarios` FOREIGN KEY (`id_usuarios`) REFERENCES `tbl_usuarios` (`id_usuarios`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tbl_prestamo_tbl_prestarios1` FOREIGN KEY (`id_prestario`) REFERENCES `tbl_prestarios` (`id_prestario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_prestarios`
--
ALTER TABLE `tbl_prestarios`
  ADD CONSTRAINT `fk_id_tipoprestarios` FOREIGN KEY (`id_tipoprestarios`) REFERENCES `tbl_tipoprestarios` (`id_tipoprestarios`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tbl_tipomaterial`
--
ALTER TABLE `tbl_tipomaterial`
  ADD CONSTRAINT `fk_tbl_tipomaterial_tbl_area1` FOREIGN KEY (`tbl_area_id_area`) REFERENCES `tbl_area` (`id_area`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD CONSTRAINT `fk_id_tipousuarios1` FOREIGN KEY (`id_tipousuarios`) REFERENCES `tbl_tipousuarios` (`id_tipousuarios`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

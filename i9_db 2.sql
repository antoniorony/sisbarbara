-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 14-Dez-2018 às 11:23
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `i9_db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `apelido` varchar(30) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `logradouro` text NOT NULL,
  `numero` int(11) NOT NULL,
  `bairro` varchar(75) NOT NULL,
  `cidade` varchar(75) NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nome`, `apelido`, `cpf`, `telefone`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`) VALUES
(3, 'RODRIGO MARCELINO ANDRADE', 'RODRIGO', '057.702.063-30', '(88)9.9290-6016', 'SITIO XCAND', 57, 'DANTRO', 'BARRO', 'CEARA'),
(4, 'Antonio Rony', 'rony', '057.702.063-30', '(88)9.9210-0782', 'vila palmeira', 57, 'buritizinho', 'MAURITI', 'CEARA'),
(5, 'BARBARA DA COSTA OOO', 'BARBARA INOVE', '222.222.222-22', '(88)9.9999-9999', 'PALESTINA DO CARIRI', 57, 'PALESTINA', 'MAURITI', 'CEARA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `controleparcela`
--

CREATE TABLE `controleparcela` (
  `IDCONTROLE` int(11) NOT NULL,
  `IDCLIENTE` int(11) NOT NULL,
  `VLTOTAL` float NOT NULL,
  `CONTROLE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `idEstoque` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `quantidade` float NOT NULL,
  `quantCaixa` float NOT NULL,
  `quantVenda` float DEFAULT NULL,
  `custo` float NOT NULL,
  `porcentagem` float NOT NULL,
  `venda` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`idEstoque`, `idProduto`, `quantidade`, `quantCaixa`, `quantVenda`, `custo`, `porcentagem`, `venda`) VALUES
(4, 1, 5, 2, 23, 2.5, 20, 3),
(7, 2, 55, 1, 7, 25, 20, 30),
(8, 6, 120, 1, 113, 10, 20, 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `idForn` int(11) NOT NULL,
  `nomeForn` varchar(60) NOT NULL,
  `cnpjCpf` varchar(20) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `endereco` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`idForn`, `nomeForn`, `cnpjCpf`, `telefone`, `email`, `endereco`) VALUES
(2, 'ANTONIO RONY MARCELINO ANDRADE', '08594925000110', '8835521662', 'ANTONIORONY@HOTMAIL.COM', 'VILA PALMEIRA'),
(4, 'CONTEUDO ADULTO MORAES', '00.000.000/0000-00', '000-0000', 'KAASKKKK@XXX.COM', 'XXXXXXXXXXX');

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL,
  `nomeMarca` varchar(30) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `Modelo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`idMarca`, `nomeMarca`, `idFornecedor`, `Modelo`) VALUES
(4, 'MODEL SEX', 2, 'asd'),
(5, 'BORR P. T18.1', 4, 'ROCHO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcela`
--

CREATE TABLE `parcela` (
  `idparcela` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `numparcela` int(11) NOT NULL,
  `valorparcela` int(11) NOT NULL,
  `pago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL,
  `descricao` text NOT NULL,
  `unidadeCompra` varchar(3) NOT NULL,
  `unidadeVenda` varchar(3) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `IdMarca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id_produto`, `descricao`, `unidadeCompra`, `unidadeVenda`, `idFornecedor`, `IdMarca`) VALUES
(1, 'SUTIAM 01', 'CX', 'un', 1, 1),
(2, 'CALCINHAS LINHA SEX', 'CX', 'CX', 2, 1),
(3, 'LANGERUE INTIMO', 'CX', 'CX', 2, 1),
(4, 'SHORT CAMP pou', 'CX', 'CX', 2, 1),
(6, 'CUECA XBOX 12', 'CX', 'CX', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `saidas`
--

CREATE TABLE `saidas` (
  `idSaidas` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `quantidade` float NOT NULL,
  `preco` float NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `data` varchar(20) NOT NULL,
  `pagamento` varchar(15) NOT NULL,
  `observacao` varchar(100) DEFAULT NULL,
  `pg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `saidas`
--

INSERT INTO `saidas` (`idSaidas`, `idProduto`, `quantidade`, `preco`, `idCliente`, `data`, `pagamento`, `observacao`, `pg`) VALUES
(1, 2, 10, 22.44, 4, '1543159585580', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(2, 2, 10, 22.44, 4, '1543162612836', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(3, 2, 5, 22.44, 4, '1543168844581', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(4, 2, 10, 18, 4, '1543170817038', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(5, 0, 10, 1.83, 4, '1543886121255', 'A VISTA', 'SHORT CAMP pou', 0),
(6, 0, 2, 30, 4, '1543886123697', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(7, 1, 2, 3, 4, '1543886463608', 'A VISTA', 'SUTIAM 01', 0),
(8, 2, 2, 42.7, 4, '1543887328842', 'A VISTA', 'LANGERUE INTIMO', 0),
(9, 2, 2, 30, 4, '1543887331461', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(10, 2, 10, 30, 4, '1543973462666', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(11, 1, 2, 3, 4, '1543973465259', 'A VISTA', 'SUTIAM 01', 0),
(12, 2, 3, 30, 4, '1544301613343', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(13, 1, 2, 3, 4, '1544301640854', 'A VISTA', 'SUTIAM 01', 0),
(14, 1, 2, 3, 4, '1544400248885', 'A VISTA', 'SUTIAM 01', 0),
(15, 2, 20, 30, 4, '1544401482383', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(16, 2, 20, 30, 3, '1544401523359', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(17, 1, 10, 3, 3, '1544401525946', 'A VISTA', 'SUTIAM 01', 0),
(18, 2, 2, 30, 3, '1544401697213', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(19, 1, 4, 3, 3, '1544401699603', 'A VISTA', 'SUTIAM 01', 0),
(20, 1, 2, 3, 4, '1544403286644', 'A VISTA', 'SUTIAM 01', 0),
(21, 2, 1, 30, 4, '1544403288646', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(22, 6, 2, 12, 5, '1544407564301', 'A VISTA', 'CUECA XBOX 12', 0),
(23, 2, 1, 30, 5, '1544407567008', 'A VISTA', 'CALCINHAS LINHA SEX', 0),
(24, 1, 5, 3, 5, '1544407568246', 'A VISTA', 'SUTIAM 01', 0),
(25, 6, 5, 12, 3, '1544481417941', 'A VISTA', 'CUECA XBOX 12', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `usuario`, `senha`) VALUES
(1, 'rony', 'rony');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `controleparcela`
--
ALTER TABLE `controleparcela`
  ADD PRIMARY KEY (`IDCONTROLE`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idEstoque`);

--
-- Indexes for table `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`idForn`);

--
-- Indexes for table `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indexes for table `parcela`
--
ALTER TABLE `parcela`
  ADD PRIMARY KEY (`idparcela`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id_produto`);

--
-- Indexes for table `saidas`
--
ALTER TABLE `saidas`
  ADD PRIMARY KEY (`idSaidas`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `controleparcela`
--
ALTER TABLE `controleparcela`
  MODIFY `IDCONTROLE` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idEstoque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `idForn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `marca`
--
ALTER TABLE `marca`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `parcela`
--
ALTER TABLE `parcela`
  MODIFY `idparcela` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `saidas`
--
ALTER TABLE `saidas`
  MODIFY `idSaidas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

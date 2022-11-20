
CREATE DATABASE `SoulBank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `conta_bancaria` (
  `id_conta` bigint NOT NULL,
  `agencia` varchar(255) DEFAULT NULL,
  `chave_pix` varchar(255) DEFAULT NULL,
  `cheque_especial` bit(1) NOT NULL,
  `conta` varchar(255) DEFAULT NULL,
  `limite` double NOT NULL,
  `saldo` double NOT NULL,
  `status_conta` bit(1) NOT NULL,
  `tipo_chave_pix` int NOT NULL,
  PRIMARY KEY (`id_conta`),
  UNIQUE KEY `UK_61rxd7bev54edql6ntkhieph4` (`chave_pix`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `endereco` (
  `id_endereco` bigint NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pessoa_fisica` (
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status_cliente` bit(1) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rg` varchar(255) DEFAULT NULL,
  `conta_bancaria_id_conta` bigint DEFAULT NULL,
  `id_endereco` bigint DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `UK_d70aayxv20yf3y8kofcx7fhbg` (`email`),
  UNIQUE KEY `UK_g3ce8301m7h9hv5rfjtvv3kcy` (`rg`),
  KEY `FK5vh5cyu3v102fxwpke5iyfpf8` (`conta_bancaria_id_conta`),
  KEY `FKiogpl1djta1w93sb92yqmi8lh` (`id_endereco`),
  CONSTRAINT `FK5vh5cyu3v102fxwpke5iyfpf8` FOREIGN KEY (`conta_bancaria_id_conta`) REFERENCES `conta_bancaria` (`id_conta`),
  CONSTRAINT `FKiogpl1djta1w93sb92yqmi8lh` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pessoa_juridica` (
  `cnpj` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status_cliente` bit(1) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `razao_social` varchar(255) DEFAULT NULL,
  `conta_bancaria_id_conta` bigint DEFAULT NULL,
  `id_endereco` bigint DEFAULT NULL,
  PRIMARY KEY (`cnpj`),
  UNIQUE KEY `UK_6f8dnvy9aakthuofgyrj66lyf` (`email`),
  KEY `FKoknoab2i2ita7k3khhjhvn132` (`conta_bancaria_id_conta`),
  KEY `FKei20hfwf7cd45lfdeb6krohpu` (`id_endereco`),
  CONSTRAINT `FKei20hfwf7cd45lfdeb6krohpu` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`),
  CONSTRAINT `FKoknoab2i2ita7k3khhjhvn132` FOREIGN KEY (`conta_bancaria_id_conta`) REFERENCES `conta_bancaria` (`id_conta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `transacao` (
  `id_transacao` bigint NOT NULL,
  `data_transacao` datetime(6) DEFAULT NULL,
  `tipo_transacao` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `id_destino` bigint DEFAULT NULL,
  `id_origem` bigint DEFAULT NULL,
  PRIMARY KEY (`id_transacao`),
  KEY `FKdgai16wtll96hb6ak6han3469` (`id_destino`),
  KEY `FKax9gra1uddo30afdw35tbmdgu` (`id_origem`),
  CONSTRAINT `FKax9gra1uddo30afdw35tbmdgu` FOREIGN KEY (`id_origem`) REFERENCES `conta_bancaria` (`id_conta`),
  CONSTRAINT `FKdgai16wtll96hb6ak6han3469` FOREIGN KEY (`id_destino`) REFERENCES `conta_bancaria` (`id_conta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

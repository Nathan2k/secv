

CREATE DATABASE alfa;

USE alfa;


CREATE TABLE empresa(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	senha VARCHAR(50),
	nome VARCHAR(50),
    CNPJ VARCHAR(50) UNIQUE,
    cidade VARCHAR(50),
    bairro VARCHAR(50),
    rua VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    telefone VARCHAR(50),
    representante VARCHAR(50)

);

CREATE TABLE estado(
	
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeEstado VARCHAR(50)

);

CREATE TABLE cidade(
	
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeCidade VARCHAR(50),
    idEstado INTEGER NOT NULL,
    
    FOREIGN KEY (idEstado) REFERENCES estado(id)
);



CREATE TABLE administrador(
	
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NIF VARCHAR(50) UNIQUE,
	email VARCHAR(50) UNIQUE,
	nome VARCHAR(50),
	senha VARCHAR(50),
	telefone VARCHAR(50)
    
);

CREATE TABLE filtro(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    experiencia BOOLEAN,
    sexo VARCHAR(50),
	deficiencia BOOLEAN,
	idEmpresa INTEGER,
	idADM INTEGER,
    idCidade INTEGER,
    idEstado INTEGER NOT NULL,
    data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    area VARCHAR(50),
    
    FOREIGN KEY (idEmpresa) REFERENCES empresa(id),
    FOREIGN KEY (idADM) REFERENCES administrador(id),
    FOREIGN KEY (idCidade) REFERENCES cidade(id),
    FOREIGN KEY (idEstado) REFERENCES estado(id)
);

CREATE TABLE curriculo(
	
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idFiltro INTEGER NOT NULL,
    email VARCHAR(50),
    nome_aluno VARCHAR(100),
    idade VARCHAR(50),
    nivelIngles INTEGER,
    nivelEspanhol INTEGER,
 	cidade VARCHAR(50),
 	estado VARCHAR(50),
    curso VARCHAR(50),
    semestre INTEGER,
	sexo VARCHAR(50),    
	deficiencia VARCHAR(50),
	
	FOREIGN KEY (idFiltro) REFERENCES filtro(id)

);
-- COLOCA CHAVE ESTRANGEIRA PRA FILTRO




CREATE TABLE formacao(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idCurriculo INTEGER NOT NULL,
	nomeDoCurso VARCHAR(300),
	data_inicio TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    data_fim TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
	escola VARCHAR(50),
	
	FOREIGN KEY (idCurriculo) REFERENCES curriculo(id)
);


CREATE TABLE experiencia(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idCurriculo INTEGER NOT NULL,
	nomeDaEmpresa VARCHAR(300),
	data_inicio timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    data_fim timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
	funçao VARCHAR(300),
	cargo VARCHAR(300),
	
	FOREIGN KEY (idCurriculo) REFERENCES curriculo(id)
);


CREATE TABLE recuperarSenha(
	
	 id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	 emailUsuario VARCHAR(50),
	 codigo VARCHAR(4) NOT NULL
);



INSERT INTO empresa VALUES (0,'123','mahalo','12345678910111','Jaguariuna','flores','lulu','mahalo@gmail.com','123455432','Rafael Leme');

INSERT INTO empresa VALUES (0,'123','senai','123456789101112','Jaguariuna','flores','lulu','senai@gmail.com','123455432','Para Guasu');

INSERT INTO administrador VALUES (0,'123456','adm@gmail.com','admin','123','123455432');

INSERT INTO `estado` (`id`, `nomeEstado`) VALUES
(1, 'estado');

INSERT INTO `cidade` (`id`, `nomeCidade`, `idEstado`) VALUES
(7, 'cidadde1', 1);



INSERT INTO `filtro` (`id`, `nome`, `experiencia`, `sexo`, `deficiencia`, `idEmpresa`, `idADM`, `idCidade`, `idEstado`, `data`) VALUES
(7, 'eletricista', 1, 'masculino', 0, 1, 1, 7, 1, '2018-10-26 02:00:00'),
(8, 'arquiteto', 1, 'masculino', 0, 1, 1, 7, 1, '2018-10-25 02:00:00'),
(9, 'treinador', 1, 'masculino', 0, 1, 1, 7, 1, '2018-11-26 02:00:00'),
(10, 'piloto', 1, 'masculono', 0, 1, 1, 7, 1, '2018-12-26 02:00:00'),
(11, 'xelelista', 1, 'masculono', 0, 1, 1, 7, 1, '2018-12-26 02:00:00'),
(12, 'xeskedele', 1, 'masculono', 0, 1, 1, 7, 1, '2019-01-26 02:00:00'),
(13, 'xazam', 1, 'masculono', 0, 1, 1, 7, 1, '2018-12-26 02:00:00');


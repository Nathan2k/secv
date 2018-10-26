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

CREATE TABLE administrador(
	
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NIF VARCHAR(50) UNIQUE,
	email VARCHAR(50) UNIQUE,
	nome VARCHAR(50),
	senha VARCHAR(50),
	telefone VARCHAR(50)
    
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
    
    FOREIGN KEY (idEmpresa) REFERENCES empresa(id),
    FOREIGN KEY (idADM) REFERENCES administrador(id),
    FOREIGN KEY (idCidade) REFERENCES cidade(id),
    FOREIGN KEY (idEstado) REFERENCES estado(id)
);

CREATE TABLE formacao(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeDoCurso VARCHAR(300),
	data_inicio TIMESTAMP,
	data_fim TIMESTAMP,
	escola VARCHAR(50)
	
);


CREATE TABLE experiencia(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeDaEmpresa VARCHAR(300),
	data_inicio TIMESTAMP,
	data_fim TIMESTAMP,
	funçao VARCHAR(300),
	cargo VARCHAR(300)
	
);


CREATE TABLE curriculo(
	
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
    idExperiencia INTEGER,
   	idFormaçao INTEGER,
    
	FOREIGN KEY (idExperiencia) REFERENCES experiencia(id),
	FOREIGN KEY (idFormaçao) REFERENCES formacao(id)

);

CREATE TABLE recuperarSenha(
	
	 id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	 emailUsuario VARCHAR(50),
	 codigo VARCHAR(4) NOT NULL
);



-- INSERT INTO table_name
-- VALUES (value1, value2, value3, ...);

INSERT INTO empresa VALUES (0,'123','mahalo','123456','Jaguariuna','flores','lulu','mahalo@gmail.com','123455432','Rafael Leme');

INSERT INTO empresa VALUES (0,'123','senai','654321','Jaguariuna','flores','lulu','senai@gmail.com','123455432','Para Guasu');

INSERT INTO administrador VALUES (0,'123456','adm@gmail.com','admin','123','123455432');




















CREATE DATABASE alfa;

USE alfa;


--  FOREIGN KEY (id_paciente) REFERENCES paciente(id),


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

CREATE TABLE areaa(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeArea VARCHAR(50)

);

CREATE TABLE curso(

    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    area INTEGER NOT NULL,
	nomeCurso VARCHAR(50),
    
	FOREIGN KEY (area) REFERENCES areaa(id)

);

CREATE TABLE semestre(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeSemestre VARCHAR(50),
    curso INTEGER NOT NULL,
    
    FOREIGN KEY (curso) REFERENCES curso(id)

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

CREATE TABLE faixaEtaria(
	
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	faixaEI VARCHAR(50),
	faixaEF VARCHAR(50)
	
);

CREATE TABLE idioma(
	
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeIdioma VARCHAR(50)
    
);



CREATE TABLE aluno(
	
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT
    
);



CREATE TABLE filtro(

	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    experiencia BOOLEAN,
    sexo VARCHAR(50),
	deficiencia BOOLEAN,
	idEmpresa INTEGER,
	idADM INTEGER,
    idIdioma INTEGER,
	idFEtaria INTEGER,
    idCidade INTEGER,
    idEstado INTEGER NOT NULL,
    idArea INTEGER NOT NULL,
    idCurso INTEGER,
	idSemestre INTEGER,
    
    FOREIGN KEY (idEmpresa) REFERENCES empresa(id),
    FOREIGN KEY (idADM) REFERENCES administrador(id),
    FOREIGN KEY (idIdioma) REFERENCES idioma(id),
    FOREIGN KEY (idFEtaria) REFERENCES faixaEtaria(id),
    FOREIGN KEY (idCidade) REFERENCES cidade(id),
    FOREIGN KEY (idEstado) REFERENCES estado(id),
    FOREIGN KEY (idArea) REFERENCES areaa(id),
    FOREIGN KEY (idCurso) REFERENCES curso(id),
    FOREIGN KEY (idSemestre) REFERENCES semestre(id)

);


CREATE TABLE curriculo(
	
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idade VARCHAR(50),
    idIdioma INTEGER,
	idFEtaria INTEGER,
    idCidade INTEGER,
    idEstado INTEGER NOT NULL,
    idArea INTEGER NOT NULL,
    idCurso INTEGER,
	idSemestre INTEGER,
    idAluno INTEGER,
    
    FOREIGN KEY (idIdioma) REFERENCES idioma(id),
    FOREIGN KEY (idFEtaria) REFERENCES faixaEtaria(id),
    FOREIGN KEY (idCidade) REFERENCES cidade(id),
    FOREIGN KEY (idEstado) REFERENCES estado(id),
    FOREIGN KEY (idArea) REFERENCES areaa(id),
    FOREIGN KEY (idCurso) REFERENCES curso(id),
    FOREIGN KEY (idSemestre) REFERENCES semestre(id),
    FOREIGN KEY (idAluno) REFERENCES aluno(id)

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




















CREATE DATABASE AgenciaHorizonteAberto;

CREATE TABLE Usuarios (
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nome varchar (50) NOT NULL,
endereco VARCHAR(50) NOT NULL,
email VARCHAR(30) UNIQUE,
senha varchar(15) NOT NULL
);

CREATE TABLE Pacotes (
idPacote INT PRIMARY KEY AUTO_INCREMENT,
destino VARCHAR(30) NOT NULL,
preco DECIMAL(10,1) NOT NULL,
promocao VARCHAR(20)
);

CREATE TABLE Compra (
    idCompra INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT,
    idPacote INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuarios (idUsuario),
    FOREIGN KEY (idPacote) REFERENCES Pacotes (idPacote)
);

/*Verificando o C de CRUD para a tabela Usuários*/
select * from usuarios; 

/*Verificando o C de CRUD para a tabela Pacotes*/
select * from pacotes;

/*Verificando o C de CRUD para a tabela Compra*/
select * from compra;
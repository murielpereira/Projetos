CREATE DATABASE Locadora;

CREATE TABLE Cliente
(id_cliente int not null auto_increment primary key,
nome varchar(45),
email varchar(45),
senha varchar(255)
);

CREATE TABLE Marcas
(id_marca int not null auto_increment primary key,
descrição varchar(45)
);

CREATE TABLE Modelos
(id_modelo int not null auto_increment primary key,
descrição varchar(45),
fk_marca int,
FOREIGN KEY (fk_marca) REFERENCES Marcas (id_marca)
);

CREATE TABLE Carros
(id_carro int not null auto_increment primary key,
fk_modelo int,
fk_marca int,
ano int,
cor varchar(45),
descricao Varchar(45),
observacoes varchar(45),
FOREIGN key (fk_modelo) REFERENCES Modelos(id_modelo),
FOREIGN KEY (fk_marca) REFERENCES Marcas (id_marca)
);

CREATE TABLE Locacao
(id_locacao int not null auto_increment primary key,
fk_carro int,
fk_cliente int,
data_retirada date,
data_devolucao date,
valor float, 
observacoes varchar(45),
FOREIGN KEY (fk_carro) REFERENCES carros(id_carro),
FOREIGN KEY (fk_cliente) REFERENCES Cliente(id_cliente)
);

INSERT INTO Cliente (nome, email, senha) VALUES ('Anna', 'anna@hotmail.com', 'annaS2');

INSERT INTO Cliente (nome, email, senha) VALUES ('Muriel', 'murielpereirabr@gmail.com', '123456');

INSERT INTO Marcas (Descrição) VALUES ('Mercedes');

INSERT INTO Marcas (Descrição) VALUES ('Fiat');

INSERT INTO Modelos (Descrição,fk_marca) VALUES ('A 200', '1');

INSERT INTO Carros (fk_marca,fk_modelo,Ano,Cor,Descricao,Observacoes) VALUES ('1','1','2020','verde','', '');

INSERT INTO Locacao (fk_carro,fk_cliente,data_retirada,data_devolucao,valor,observacoes) VALUES ('1','2','2020-11-21','2020-11-30','509.90', '');

INSERT INTO Locacao (fk_carro,fk_cliente,data_retirada,data_devolucao,valor,observacoes) VALUES ('1','1','2020-11-21','2020-11-30','509.90', '');

UPDATE Cliente SET nome = 'Joao' WHERE nome = 'anna' ;

UPDATE Marcas SET Descrição = 'BMW' WHERE id_marca = 1;

UPDATE Locacao SET valor = '5000.00' WHERE id_locacao = 2;

UPDATE Carros SET Ano = 2022 WHERE id_carro = 1;

UPDATE Modelos SET fk_marca = 2 WHERE fk_marca = 1;

UPDATE Carros SET fk_marca = 2 WHERE fk_marca = 1;

DELETE FROM Locacao WHERE id_locacao = 1;

DELETE FROM Cliente WHERE id_cliente = 2;

DELETE FROM Marcas WHERE descrição = 'BMW';

DELETE FROM Locacao WHERE valor = 500.00;

SELECT * FROM Cliente;

SELECT descrição FROM Marcas;

SELECT email
FROM Cliente
INNER JOIN Locacao
ON id_cliente = Locacao.fk_cliente;

SELECT Cor
FROM Carros
INNER JOIN Modelos
ON fk_modelo = Modelos.id_modelo;

-- TRIGGER
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Carros_BEFORE_INSERT` BEFORE INSERT ON `Carros` FOR EACH ROW
BEGIN
 UPDATE Carros SET obs = S/obs
END;

CREATE TRIGGER Locadora.trg_Cliente
	ON cliente
	AFTER INSERT
	AS
    BEGIN
    SET NOCOUNT ON
    INSERT INTO Cliente
        Id,
        Nome,
        Email,
        Senha
        GETDATE(),
        'INS'
    FROM
        inserted i
END
;
	

CREATE PROCEDURE SelectAllLocation @Id_Carro nvarchar(30), @Id_Cliente nvarchar(10)
AS
SELECT * FROM Locacao WHERE Id_Carro = @Id_Carro AND Id_Cliente = @Id_Cliente
GO;

EXEC SelectAllLocation @Id_Carro = '3', @Id_Cliente = '4';


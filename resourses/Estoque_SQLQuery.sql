CREATE DATABASE ESTOQUE

CREATE TABLE PRODUTO(
Codigo_Produto INT PRIMARY KEY,
Nm_Produto VARCHAR NOT NULL,
Quantidade INT NOT NULL,
Valor NUMERIC(8,2) NOT NULL,
Ativo BIT NOT NULL,
Data_Inclusao VARCHAR NOT NULL
);


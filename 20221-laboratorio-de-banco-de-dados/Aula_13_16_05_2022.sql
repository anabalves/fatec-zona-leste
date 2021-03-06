/* 
Criar um script descrevendo os passos para simular uma possível situação de DeadLock, com os respectivos comandos das DISTINTAS sessões (1 e 2).
*/
DROP DATABASE IF EXISTS AULA_13_16_05_2022;

CREATE DATABASE AULA_13_16_05_2022;

USE AULA_13_16_05_2022;

CREATE TABLE TB_CADASTRO (ID INT NOT NULL AUTO_INCREMENT, NOME VARCHAR(255) NOT NULL, SALARIO DOUBLE NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;

INSERT INTO TB_CADASTRO (ID, NOME, SALARIO) VALUES (1, "Roberta Lopez", 10642.33);

INSERT INTO TB_CADASTRO (ID, NOME, SALARIO) VALUES (2, "Thales Maia", 8742.46);
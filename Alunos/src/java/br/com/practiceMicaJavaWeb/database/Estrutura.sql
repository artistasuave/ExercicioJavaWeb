DROP DATABASE IF EXISTS francisgod;
CREATE DATABASE IF NOT EXISTS francisgod;
USE francisgod;

CREATE TABLE alunos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR (100),
	cod_matricula VARCHAR (50),
	nota1 DOUBLE,
	nota2 DOUBLE,
	nota3 DOUBLE,
	frequencia SMALLINT
);

INSERT INTO alunos(nome, cod_matricula, nota1, nota2, nota3, frequencia) VALUES
("Carlos", "777", 5,6.5,9, 75),
("Matheus", "81213", 10, 7, 9.5,99),
("Michelle", "10174213", 10, 9.5, 9,83);

CREATE DATABASE biblioteca;

CREATE TABLE aluno (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    matricula INT NOT NULL,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE publicacao (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    codigoPub INT NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL
);

CREATE TABLE emprestimo (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    dataDevolucao DATE NOT NULL,
    dataEmprestimo DATE NOT NUL,
    aluno_id BIGINT,
    publicacao_id BIGINT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id)
);

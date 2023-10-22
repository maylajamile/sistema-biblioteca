CREATE TABLE Aluno (
    id BIGINT PRIMARY KEY,
    matricula INTEGER,
    nome VARCHAR(255)
);

CREATE TABLE Publicacao (
    id BIGINT PRIMARY KEY,
    ano INTEGER,
    autor VARCHAR(255),
    codigoPub INTEGER,
    tipo VARCHAR(255),
    titulo VARCHAR(255)
);

CREATE TABLE Emprestimo (
    id BIGINT PRIMARY KEY,
    dataDevolucao TIMESTAMP,
    dataEmprestimo TIMESTAMP,
    aluno_id BIGINT,
    publicacao_id BIGINT,
    CONSTRAINT FK_aluno_id FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
    CONSTRAINT FK_publicacao_id FOREIGN KEY (publicacao_id) REFERENCES Publicacao(id)
);

INSERT INTO Aluno(id, matricula, nome) VALUES (1, 2023010101,'JOAO MENDES');
INSERT INTO Aluno(id, matricula, nome) VALUES (2, 2023020202,'ALBERTO SA');
INSERT INTO Aluno(id, matricula, nome) VALUES (3, 2023030303,'LUCAS SILVA');

INSERT INTO Publicacao(id, codigoPub, titulo, ano, autor, tipo) VALUES (1, 1001,'Desbravando SOLID', '2022', 'Alexandre Aquiles', 'Programação');
INSERT INTO Publicacao(id, codigoPub, titulo, ano, autor, tipo) VALUES (2, 1002,'Estruturas de Dados', '2023', 'Thiago Leite e Carvalho', 'Programação');
INSERT INTO Publicacao(id, codigoPub, titulo, ano, autor, tipo) VALUES (3, 1003,'Teoria dos Grafos', '2020', 'João Paulo Maida', 'Programação');
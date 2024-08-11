CREATE TABLE exame (rowid bigint auto_increment primary key, nm_exame VARCHAR(255));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');

CREATE TABLE funcionario (rowid bigint auto_increment primary key, nm_funcionario VARCHAR(255));
INSERT INTO funcionario (nm_funcionario) VALUES ('Banguelao'), ('Yummi'), ('Nida'), ('Gnar');

CREATE TABLE exame_funcionario (rowid bigint auto_increment primary key, exame_id bigint, funcionario_id bigint, data date,
    FOREIGN KEY (exame_id) references exame(rowid),
    FOREIGN KEY (funcionario_id) references funcionario(rowid)
);
INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (1, 1, '2024-08-05');
INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (1, 2, '2024-08-06');
INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (1, 3, '2024-08-07');
INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (4, 1, '2024-08-08');
INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (2, 4, '2024-08-09');
INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (3, 2, '2024-08-10');

CREATE VIEW v_exames_do_funcionario
AS
    SELECT ef.rowid interno_id, e.rowid exame_id, e.nm_exame exame_nome, ef.data, f.rowid funcionario_id, f.nm_funcionario funcionario_nome FROM exame_funcionario ef
        INNER JOIN funcionario f ON f.rowid = ef.funcionario_id
        INNER JOIN exame e ON e.rowid = ef.exame_id;

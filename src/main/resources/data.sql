INSERT INTO tb_autor ( nome, email, data_criacao, descricao) VALUES ('Jean Santos', 'jeancbsan@gmail.com', ' 2021-02-24', 'Tecnologias e Inovação');
INSERT INTO tb_autor ( nome, email, data_criacao, descricao) VALUES ('Camilla Santos', 'camilladsan@gmail.com', ' 2021-02-24', 'Artes e Inovação');
INSERT INTO tb_autor ( nome, email, data_criacao, descricao) VALUES ('Jean Charles Duarte Santos', 'jeandsan@gmail.com', ' 2021-02-24', 'Tecnologias e Games');
INSERT INTO tb_autor ( nome, email, data_criacao, descricao) VALUES ('Melissa Santos', 'melissinhadsan@gmail.com', ' 2021-02-24', 'Jogos e Musicas');
INSERT INTO tb_autor ( nome, email, data_criacao, descricao) VALUES ('Pedro Marinho', 'pedro@gmail.com', ' 2021-02-24', 'Mestre da Aventura');

INSERT INTO tb_categoria ( nome ) VALUES ('AVENTURA');
INSERT INTO tb_categoria ( nome ) VALUES ('SUSPENSE');
INSERT INTO tb_categoria ( nome ) VALUES ('ROMANCE');
INSERT INTO tb_categoria ( nome ) VALUES ('DRAMA');
INSERT INTO tb_categoria ( nome ) VALUES ('FICÇÃO CIENTIFICA');
INSERT INTO tb_categoria ( nome ) VALUES ('TÉCNICO');

INSERT INTO tb_livro(data_publicacao, isbn, numero_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id) VALUES ('2023-02-24', '8551101633', 120, 200, 'On the Beat is a new dynamic four-level series for teenage learners in the 21st century.', 'sleek and modern design that surely guarantees learning for all students', 'NEXT BEAT', 1, 2);
INSERT INTO tb_livro(data_publicacao, isbn, numero_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id) VALUES ('2022-02-24', '855110--1633', 200, 230.00, 'On the Beat is a new dynamic four-level series for teenage learners in the 21st century.', 'sleek and modern design that surely guarantees learning for all students', 'NEXT BEAT II', 2, 1);
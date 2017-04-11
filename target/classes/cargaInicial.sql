-- PESSOA
--INSERT INTO Pessoa (nome, descricao, foto) values('Bolos da Flávia', 'Deliciosos bolos no pote feitos com carinho. Entrega em Águas Claras e Taguatinga', 'bolosFlavia.png');

--PRODUTOS
--INSERT INTO Produto (titulo, descricao, imagem, entrega, credito, debito, idFornecedor) values('Bolo no pote', 'Um bolo maravilhoso. Escolha entre nossos diversos sabores.', 'bolopote.png', true, false, false, 1);

--CONTATOS PRODUTOS
--INSERT INTO CONTATO (texto,tipo, idPessoa, idProduto) values('6199222299', 'whatsapp', null, 1); 
--AVALIAÇÕES
--INSERT INTO Avaliacao (texto, avaliacao, idAutor, idProduto) values('Gostei muito. Entrega rápida.', 4, 2, 1);

--Dominio Cargo
INSERT INTO dominiocargo(nome) values('Diretor(a)');
INSERT INTO dominiocargo(nome) values('Assessor(a)');
INSERT INTO dominiocargo(nome) values('Assistente da Diretoria');
INSERT INTO dominiocargo(nome) values('Coordenador(a) Geral');
INSERT INTO dominiocargo(nome) values('Coordenador(a) Técnico');
INSERT INTO dominiocargo(nome) values('Chefe de Serviço');

--Dominio Lotacao
INSERT INTO dominiolotacao(nome) values('DCOI');
INSERT INTO dominiolotacao(nome) values('DEHS');
INSERT INTO dominiolotacao(nome) values('DABS');
INSERT INTO dominiolotacao(nome) values('GTI');
INSERT INTO dominiolotacao(nome) values('PRESIDÊNCIA');


--Grupos (Projetos Transversais, )
INSERT INTO grupo(nome) values('Projetos Transversais');


--Questao 
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T1',  1, 'Criar e implementar sistemática de Monitoramento e Avaliação do Plano. Estratégico, subsidiando a DEX na condução das Reuniões de Análise da Estratégia.',  'Consolidar a cultura do planejamento estratégico e da avaliação continuada das atividades do CNPq, considerado um valioso instrumento de gestão da alta administração. \nO monitoramento e a avaliação da estratégia fazem parte do ciclo da Gestão. Essa sistemática permitirá que as ações planejadas aconteçam de fato, com ajustes e correções de rumos sempre que necessário, agregando valor e dando visibilidade aos resultados institucionais.', 1);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T2',  2, 'Criar e implementar novo Modelo de Monitoramento, Avaliação e disponibilização de resultados de Bolsas, no País e no exterior, de Auxílios Individuais, de Chamadas e Encomendas, e de Projetos de Pesquisa.',  'Há uma demanda crescente por transparência e feedback por parte da sociedade civil para legitimar o financiamento de projetos de quaisquer natureza, com a exigência de retorno efetivo e impacto positivo voltado ao bem estar individual, coletivo e ambiental. Dessa forma, o desenvolvimento de monitoramento e avaliação, bem divulgação de resultados e impactos são e para a manutenção do CNPq como entidade de fomento a pesquisa com uso de recursos do erário e de outras fontes de recurso cabíveis dentro da devida oportunidade e conveniências',  1);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T3',  3, 'T3',  'DESCRICAO DO T3',  1);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T4',  4, 'T4',  'DESCRICAO DO T4',  1);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T5',  5, 'T5',  'DESCRICAO DO T5',  1);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T6',  6, 'T6',  'DESCRICAO DO T6',  1);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projeto Transversal T7',  7, 'T7',  'DESCRICAO DO T7',  1);
--INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('', '', '', 0, 1);




























--INSERT INTO grupo(nome) values('Projetos Específicos - 
--');

--INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - 
--', ORDEM, '
--',  '
--',  GRUPOID);




INSERT INTO grupo(nome) values('Projetos Específicos - DCOI');

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E9', 1, 'Reavaliar e propor adequação da PICC, de forma a melhor atender a gestão dos programas.',  'A proposta visa adequar e aprimorar a PICC às necessidades de gestão dos programas da COPAD. ',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E10', 2, 'Realizar reunião nacional de trabalho para obter subsídios para reformulação do programa PIBIC-EM.',  'O objetivo deste projeto é obter subsídios para aprimoramento do PIBIC-EM por meio de reunião com os representantes institucionais e coordenadores do PIBIC-EM.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E11', 3, 'Avaliar os programas de bolsas PIBIC, PIBITI e PIBIC-Af.',  'O objetivo deste projeto é promover a avaliação dos programas PIBIC, PIBIC-Af e PIBITI. Com este objetivo contratamos a consultoria externa do Centro de Gestão e Estudos Estratégicos (CGEE). A partir dos resultados desta avaliação, planejamos aprimorar os instrumentos de gestão e acompanhamento dos programas.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E12', 4, 'Propor nova sistemática de concessão e Gestão de bolsas de Mestrado e Doutorado por cotas, no País.',  'O objetivo deste projeto é rever a atual sistemática e propor reestruturação na forma de concessão de bolsas com vistas a propiciar o aprimoramento do programa. A proposta a ser implementada deverá criar mecanismos de concessão que tornem o processo mais transparente e justo, propiciando a ampla concorrência por meio de chamada pública.',  2);


INSERT INTO grupo(nome) values('Projetos Específicos - DGTI');

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.1', 1, 'Desenvolver e implementar novo modelo de Avaliação de Desempenho.',  'Em cumprimento ao Decreto 7.133/10 que regulamenta os critérios e procedimentos gerais a serem observados para a realização das avaliações de desempenho individual, institucional e o pagamento da GDACT, desenvolver sistema informatizado de Avaliação de Desempenho alinhado a competências organizacionais já mapeadas.',  3);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.2', 2, 'Reformular o Mapeamento de Competências. ',  'O mapeamento de competências se constitui em estratégia no tocante à tomada de decisão referente à provisão de vagas, planos de capacitação, gestão do desempenho e movimentação na carreira no CNPq.',  3);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.3', 3, 'Realizar Dimensionamento da Força de trabalho do CNPq.',  'A iniciativa do planejamento da força de trabalho com base nas competências, se constitui em estratégia para o desenvolvimento gerencial no tocante à tomada de decisão referente à movimentação na carreira, planos de capacitação e provisão de vagas, para que o CNPq tenha garantido seu pleno funcionamento, bem como a otimização do desempenho das funções desenvolvidas pelos servidores. É muito importante equilibrar a força de trabalho disponível, a carga de trabalho e otimizar a mão de obra disponível, como também diagnosticar a necessidade adicional ou de servidores. Por meio do equilíbrio quantitativo e qualitativo das equipes que compõem as áreas, otimizar gradativamente a produtividade, promovendo o bem-estar no trabalho.',  3);



--Grupos (Outras Necessidades )
INSERT INTO grupo(nome) values('Outras Necessidades');


--Questao 
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Outras necessidades',  1, 'Outras Necessidades', 'Necessidade não mapeadas para projetos Transversais ou Específicos', 4);




--INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('
--');');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.01', 'Aumentar a capacidade institucional de articulaçao, integração e participação na formulação das políticas de CT&I');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.02', 'Definir modelo de fomento flexível e adequado às diferentes realiadades');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.03', 'Aprimorar e racionalizar os processos de trabalho');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.04', 'Estimular a competitividade internacional das empresas');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.05', 'Capacitar gestores de cooperação internacional');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.06', 'Capacitar pesquisadores e estudantes brasileiros no exterior');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.07', 'Definir novos modelos de integração ');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.08', 'Fazer parcerias aderentes à Estratégia Nacional de CT&I');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.09', 'Atuar no aperfeiçoamento do Marco Legal e Regulatório e desburocratização dos processos');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.10', 'Ampliar o papel do CNPq no ambiente de inovação');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.11', 'Apoiar o processo inovativo');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.12', 'Formar, capacitar e valorizar pessoas para inovação');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.13', 'Ampliar os mecanismos de apoio para pesquisa inter/multi/transdisciplinares e interinstitucionais');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.14', 'Criar sistema dinâmico e integrado de monitoramento e avaliação');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.15', 'Promover o debate público, a divulgação e a educação em CT&I');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('CNPq', 'CNPq.16', 'Fortalecer a relação entre compromisso social e excelência científica');

--INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('
--');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.01', 'Fomentar a disponibilização e o uso de dados abertos. ');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.02', 'Ampliar o uso de TIC para promover a transparência e dar publicidade à aplicação dos recursos públicos.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.03', 'Garantir a segurança da informação e comunicação do Estado e o sigilo das informações do cidadão.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.04', 'Expandir e inovar a prestação de serviços digitais.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.05', 'Melhorar a governança e a gestão por meio do uso da tecnologia');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.06', 'Facilitar e universalizar o uso e o acesso aos serviços digitais.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.07', 'Compartilhar e integrar dados, processos, sistemas, serviços e infraestrutura.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.08', 'Fomentar a colaboração no ciclo de políticas públicas.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.09', 'Ampliar e incentivar a participação social na criação e melhoria dos serviços públicos.');
INSERT INTO ObjetivoEstrategico(tipo, titulo, nome) values('EGD', 'EGD.10', 'Aprimorar a interação direta entre governo e sociedade.');

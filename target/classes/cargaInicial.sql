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
INSERT INTO grupo(nome, titulo) values('Projetos Transversais', 'Projetos Transversais');

INSERT INTO grupo(nome, titulo) values('Projetos Específicos - DGTI E1', 'DGTI_E1');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - DGTI OUTROS', 'DGTI_outros');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - DCOI', 'DCOI');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - APA', 'APA');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - APL', 'APL');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - COEST', 'COEST');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - COCOM', 'COCOM');
INSERT INTO grupo(nome, titulo) values('Projetos Específicos - Ouvidoria', 'Ouvidoria');
INSERT INTO grupo(nome, titulo) values('Outras Necessidades', 'Outras Necessidades');


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





--CGTI E1
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.1', 1, 'Desenvolver e implementar novo modelo de Avaliação de Desempenho.',  'Em cumprimento ao Decreto 7.133/10 que regulamenta os critérios e procedimentos gerais a serem observados para a realização das avaliações de desempenho individual, institucional e o pagamento da GDACT, desenvolver sistema informatizado de Avaliação de Desempenho alinhado a competências organizacionais já mapeadas.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.2', 2, 'Reformular o Mapeamento de Competências. ',  'O mapeamento de competências se constitui em estratégia no tocante à tomada de decisão referente à provisão de vagas, planos de capacitação, gestão do desempenho e movimentação na carreira no CNPq.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.3', 3, 'Realizar Dimensionamento da Força de trabalho do CNPq.',  'A iniciativa do planejamento da força de trabalho com base nas competências, se constitui em estratégia para o desenvolvimento gerencial no tocante à tomada de decisão referente à movimentação na carreira, planos de capacitação e provisão de vagas, para que o CNPq tenha garantido seu pleno funcionamento, bem como a otimização do desempenho das funções desenvolvidas pelos servidores. É muito importante equilibrar a força de trabalho disponível, a carga de trabalho e otimizar a mão de obra disponível, como também diagnosticar a necessidade adicional ou de servidores. Por meio do equilíbrio quantitativo e qualitativo das equipes que compõem as áreas, otimizar gradativamente a produtividade, promovendo o bem-estar no trabalho.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.4', 4, 'Implementar pesquisa de Qualidade de Vida no Trabalho – 2ª edição. ', 'Verificar os aspectos que tecem o conceito de Qualidade de Vida no Trabalho sob a ótica dos servidores, bem como conhecer como os servidores caracterizam no CNPq as condições, a organização e as relações socioprofissionais de trabalho; as possibilidades de reconhecimento/crescimento profissional e mapear as fontes de mal-estar e bem-estar no trabalho no CNPq.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.5', 5, 'Elaborar e implementar Plano de Capacitação e Desenvolvimento de pessoas com base em competências.', 'Implementar programa continuado de desenvolvimento dos servidores com foco na melhoria dos conhecimentos, habilidades e atitudes (gestão por competência) necessárias ao desempenho das funções conforme determinado pela Política Nacional de Desenvolvimento de Pessoal da administração pública federal.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.6', 6, 'Implementar nova sistemática de Movimentação de Pessoal com base em Competências. ','Desenvolver sistemática de movimentação de pessoal com base em competências, objetivando a transferência de conhecimento tácito para preservar a cultura organizacional, garantindo um melhor clima organizacional e melhor qualidade de vida aos servidores.',  2);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E1.7', 7, 'Criar Banco de Talentos por Competências. ', 'Criação e implantação de Banco de Talentos por meio de sistema gerencial que permita identificar e tratar os conhecimentos e competências pessoais e institucionais disponíveis no CNPq',  2);


--CGTI - OUTROS
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E2', 1, 'Elaborar Proposta para Reestruturação da Carreira de C&T.', 'A estrutura atual do Plano de Carreiras aplicado aos servidores integrantes da carreira de Gestão, Planejamento e Infra-Estrutura em Ciência e Tecnologia do Governo Federal, fundamentada na Lei 8.691/93, tem causado grandes entraves para a área de Recursos Humanos do Conselho Nacional de Desenvolvimento Científico e Tecnológico – CNPq, pois cria dificuldades para a manutenção de servidores capacitados para o exercício das atividades administrativas e, portanto, carece de uma remodelação legal no intuito de se adequar às novas demandas do mercado de trabalho do setor público.',  3);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E3', 2, 'Elaborar e lançar Edital de Concurso Público. ', 'Suprir todas as áreas com pessoal qualificado objetivando atender à missão do CNPq.',  3);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E4', 3, 'Aprimorar o projeto: "Construindo o Amanhã".  ', 'Criar espaço e oportunidade para que o servidor reflita e discuta a questão da aposentadoria.',  3);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E5', 4, 'Integrar os Sistemas Corporativos do CNPq, partindo de análise para identificar quais sistemas podem e devem ser integrados (pendente de detalhamento - SIRH, SIGEPE, SIAS, SIAPE, SIAFI, DI com Receita Federal, eGAD com SEI, do DI com o Lattes). Unificar as funcionalidades da PICC, do CNPq Sistemas, do Confio e do DI.', 'O objetivo é integrar as bases de consultas necessárias à implementação e acompanhamento dos processos das bolsas e auxílios e dos processos administrativos do CNPq, de forma confiável e eficaz, evitando o acesso a diversos sistemas e garantindo a agilidade nas respostas para as consultas realizadas.',  3);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E6', 5, 'Desenvolver, aperfeiçoar e implementar o sistema eletrônico de processos, integrando documentos administrativos, de fomento e de gestão de pessoas (eGAD).', 'Controlar a produção, o recebimento, a tramitação e o arquivamento de documentos internos/externos ao CNPq.',  3);

--DCOI
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E9', 1, 'Reavaliar e propor adequação da PICC, de forma a melhor atender a gestão dos programas.',  'A proposta visa adequar e aprimorar a PICC às necessidades de gestão dos programas da COPAD. ',  4);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E10', 2, 'Realizar reunião nacional de trabalho para obter subsídios para reformulação do programa PIBIC-EM.',  'O objetivo deste projeto é obter subsídios para aprimoramento do PIBIC-EM por meio de reunião com os representantes institucionais e coordenadores do PIBIC-EM.',  4);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E11', 3, 'Avaliar os programas de bolsas PIBIC, PIBITI e PIBIC-Af.',  'O objetivo deste projeto é promover a avaliação dos programas PIBIC, PIBIC-Af e PIBITI. Com este objetivo contratamos a consultoria externa do Centro de Gestão e Estudos Estratégicos (CGEE). A partir dos resultados desta avaliação, planejamos aprimorar os instrumentos de gestão e acompanhamento dos programas.',  4);
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E12', 4, 'Propor nova sistemática de concessão e Gestão de bolsas de Mestrado e Doutorado por cotas, no País.',  'O objetivo deste projeto é rever a atual sistemática e propor reestruturação na forma de concessão de bolsas com vistas a propiciar o aprimoramento do programa. A proposta a ser implementada deverá criar mecanismos de concessão que tornem o processo mais transparente e justo, propiciando a ampla concorrência por meio de chamada pública.',  4);



--APA

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E13', 1, 'Formalizar sistemática de acompanhamento de emendas parlamentares ao orçamento do CNPq ou a este repassado para execução por convênio.', 'O objetivo é aprimorar os processos internos voltados para o atendimento às demandas parlamentares externas, possibilitando maior efetividade, por meio de mecanismos transparentes de controle e de acompanhamento das demandas.',  5);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E14', 2, 'Criar sistemática de recepção e acompanhamento do atendimento de demandas parlamentares ao CNPq.', 'O objetivo é aprimorar os processos internos voltados para o atendimento às demandas parlamentares junto ao CNPq, possibilitando maior efetividade, por meio de mecanismos transparentes de controle e de acompanhamento.',  5);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E15', 3, 'Criar sistemática de acompanhamento de proposições e pautas legislativas de interesse do CNPq.', 'Propiciar o acompanhamento de ocorrências e tendências legislativas. Subsidiar a atuação da APA na tomada de decisão junto aos setores envolvidos. Facultar as demais áreas identificar oportunidades, conveniências ou necessidades de atuação.',  5);


--APL

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E17', 1, 'Coordenar o Desdobramento do Plano Estratégico do CNPq em planos táticos e planos operacionais.', 'O desdobramento da estratégia organizacional tem se tornado um pressuposto do êxito na implementação dos Objetivos Estratégicos, logo, realizar o desdobramento para os níveis tático e operacional da organização é um determinante para que se possa executar, monitorar e avaliar as ações do dia a dia dos servidores, de maneira alinhada com o que foi estabelecido na estratégia corporativa (Mapa Estratégico).',  6);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E18', 2, 'Construir, em articulação com as demais áreas do CNPq, o PPA para o período de 2016 a 2019.', 'O projeto de formulação do Plano Plurianual, conforme já informado acima, decorre de exigência legal. \nO Programa em questão atende à atividade finalística do CNPq.',  6);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E19', 3, 'Criar sistemática de avaliação e incorporação de melhores práticas advindas de demandas da Ouvidoria no sentido de incrementar a gestão institucional.', 'Implementar a cultura de incremento constante da gestão organizacional a partir de diferentes sugestões, seja do público interno ou do externo.',  6);


--COEST

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E20', 1, 'Modernizar o atual Diretório de Instituições - DI quanto aos requisitos, funcionalidades e conteúdos necessários para atender seus objetivos.', 'O objetivo é modernizar e integrar o DI com outras bases de dados internas e externas ao CNPq e gerar interface com serviços correlatos.',  7);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E21', 2, 'Calcular e monitorar os indicadores relacionados aos objetivos estratégicos e de contribuição do plano estratégico do CNPq.', 'Atendimento às demandas externas, bem como, à demanda interna no sentido de avaliar o trabalho desenvolvido pelo CNPq.',  7);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E22', 2, 'Definir o novo Diretório dos Grupos de Pesquisa no Brasil – DGP.', 'Melhorias no sistema a fim de satisfazer demandas interna e externa dos usuários.O novo DGP se propôs a refletir de forma mais fidedigna o mapeamento da pesquisa no país.',  7);


--COCOM

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E23', 1, 'Elaborar e implementar Plano de Comunicação Social do CNPq.', 'A Comunicação Social constitui-se, em primeiro lugar, um dever legal de prestar contas à sociedade no sentido de demonstrar o resultado dos investimentos e programas, além reflete interesse do Órgão em divulgar suas ações. Para tanto, ações de comunicação dependem de iniciativas da COCOM, por diversos canais. Um Plano de Comunicação Social organiza o fluxo de informações, fomenta a cultura do CNPq em torno de gerar subsídios à Comunicação e organiza a própria Unidade quanto às prioridades e estratégias para se concretizar as iniciativas previstas.',  8);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E24', 2, 'Elaborar novo Manual de Identidade Visual.', 'A marca do CNPq é utilizada em diversos documentos e materiais de divulgação produzidos não só pela própria agência, como também, por pesquisadores, institutos e universidades apoiadas. Dessa forma, o detalhamento de normas técnicas para elaboração e aplicação da marca faz-se necessário a fim de que se mantenha a identidade visual com fidelidade de cor, tamanho, fonte, além de garantir a aplicação de acordo com normas estabelecidas pela Secretaria de Comunicação da Presidência da República.',  8);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E25', 3, 'Implementar Núcleo Audiovisual para modernizar as ferramentas de comunicação por meio da mídia eletrônica.', 'A implementação do Núcleo de Produção Audiovisual do CNPq é necessária para adequação das ações de Comunicação do CNPq ao cenário atual, aonde as produções audiovisuais vêm ganhando cada vez mais espaço como formato preferencial de comunicação institucional. Vários órgãos do governo vêm utilizando essa ferramenta como forma de ampliar seu o público e dar mais agilidade para a difusão de informações. O próprio MCTI possui uma WEBTV. O CNPq é um órgão que interage diretamente com centenas de pesquisadores diariamente. A ampla divulgação de suas chamadas públicas e o consequente aumento do número de propostas apresentadas, traz mais transparência e qualidade para o processo. Além disso, a divulgação dos resultados de suas ações é importante, não apenas a título de prestação de contas, mas também como forma de difundir o relevante papel do CNPq na sociedade.',  8);

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E26', 4, 'Implementar Política de Atendimento de Imprensa.', 'A relação com a imprensa é importante no propósito de dialogar com a sociedade. Nesse sentido, é imprescindível que esteja garantido o repasse de informações corretas e bem fundamentadas. Além disso, o bom relacionamento com os jornalistas possibilita a conquista de espaços nos jornais para informações de interesse institucional. Para isso, é importante que toda a instituição esteja comprometida em subsidiar a COCOM sempre que necessário, no ritmo imposto pela dinâmica do nosso jornalismo.',  8);


--Ouvidoria

INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Projetos Específicos - E27', 1, 'Implantar sistema informatizado de recebimento e gestão de demandas recebidas pela Ouvidoria, fornecido pela CGU (e-Ouvidoria).', 'Aumentar o controle sobre as demandas que chegam à Ouvidoria e seu acompanhamento no âmbito do CNPq, facilitando o trabalho de gestão e o encaminhamento de soluções ao cidadão ou a outros órgãos.',  9);








--Questao 
INSERT INTO questao(nome, ordem, descricao, justificativa, grupo) values ('Outras necessidades',  1, 'Outras Necessidades', 'Necessidade não mapeadas para projetos Transversais ou Específicos', 10);




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

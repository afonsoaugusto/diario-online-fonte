  /*
  plataforma panic
  Fluxos passados
    UF -> OK
    Municipio -> OK
    SituaÃ§Ã£o -> OK
    ParametrizaÃ§Ã£o -> ok
    Turno -> ok
    Escola -> Sem mascaras
        <!-- mask="99.999.999/9999-99"/-->
        <!-- mask="99.999-999"/-->
        <!-- mask="(99) 9999-9999"/-->
         <!-- mask="99.999-999"/-->
         <!-- mask="99.999.999/9999-99"/-->
         <!-- mask="(99) 9999-9999"/-->\	
  
  AdministraÃ§Ã£o
      AtuaÃ§Ã£o do Professor
  Cadastro
      Professor -> Sem mascaras
      Ano -> ok
      Aluno -> Falta mascaras
      InclusÃ£o de Alunos na Turma -> falta atualizar as turmas caso o usuario for incluido em nova turma
      Turma -> ok
      Disciplina -> ok
      Disciplina Ano -> ok
      Disciplina Professor -> ok
  SeguranÃ§a
      Usuario -> OK
      AÃ§Ã£o -> ok
      Funcionalidade -> OK
      Funcionalidade Acao -> OK
      Perfil -> ok
      Perfil Funcionalidade Acao -> ok
      Usuario Perfil -> ok
  DiÃ¡rio
      Atividades
      Notas
      Plano Ensino -> sem anexo
      PresenÃ§a
  Fechamento
      Fechamento
      Fechamento Aluno
  */		
  DELETE FROM tbl_presenca;
  DELETE FROM TBL_ATIVIDADE;
  delete from TBL_ALUNO_TURMA;
  delete from tbl_situacao;
  delete from TBL_ALUNO;
  delete from tbl_turma;
  delete from TBL_TURNO;
  delete from TBL_DISCIPLINA_PROFESSOR;
  delete from TBL_PERFIL_FUNCIONALIDADE_ACAO;
  delete from TBL_DISCIPLINA_ANO;
  delete from TBL_DISCIPLINA;
  delete from TBL_ESCOLA;
  delete from tbl_ano;
  delete from tbl_usuario_perfil;
  delete from tbl_perfil;
  delete from tbl_funcionalidade_acao;
  delete from tbl_funcionalidade ;
  delete from tbl_acao ;
  delete from tbl_usuario ;
  delete from tbl_pessoa ;
  delete from tbl_parametrizacao where seq_parametrizacao_pai is not null ;
  delete from tbl_parametrizacao;
  delete from municipio ;
  delete from uf ;
  
  
  insert into uf values (100, null, 'Minas', 'Minas Gerais', 'MG', 'N');
  insert into municipio values (100, null, null, 'BH', 'BH', NULL,NULL,NULL,'N',100);
  insert into tbl_pessoa (SEQ_PESSOA,DES_NOME,FLG_ATIVO,SEQ_CIDADE) values (100,'José ..','S',100);
  insert into tbl_usuario values (100,'Dica','Login','Senha',100);
  insert into tbl_acao values (100,'CRIAR','Criar');
  insert into tbl_acao values (101,'EDITAR','Editar');
  insert into tbl_acao values (102,'VISUALIZAR','Visualizar');
  insert into tbl_acao values (103,'DELETAR','Deletar');
  
  insert into tbl_funcionalidade values (100,'UF','UF');
  insert into tbl_funcionalidade values (101,'MUNICIPIO','Municipio');
  insert into tbl_funcionalidade values (102,'SITUACAO','Situação');
  insert into tbl_funcionalidade values (103,'PARAMETRIZACAO','Parametrização');
  insert into tbl_funcionalidade values (104,'TURNO','Turno');
  insert into tbl_funcionalidade values (105,'ESCOLA','Escola');
  insert into tbl_funcionalidade values (106,'ATUACAO_PROFESSOR','Atuação Professor');
  insert into tbl_funcionalidade values (107,'PROFESSOR','Professor');
  insert into tbl_funcionalidade values (108,'ANO','Ano');
  insert into tbl_funcionalidade values (109,'ALUNO','Aluno');
  insert into tbl_funcionalidade values (110,'ALUNOS_TURMA','Alunos Turma');
  insert into tbl_funcionalidade values (111,'TURMA','Turma');
  insert into tbl_funcionalidade values (112,'DISCIPLINA','Disciplina');
  insert into tbl_funcionalidade values (113,'DISCIPLINA_ANO','Disciplina Ano');
  insert into tbl_funcionalidade values (114,'DISCIPLINA_PROFESSOR','Disciplina Professor');
  insert into tbl_funcionalidade values (115,'USUARIO','Usuario');
  insert into tbl_funcionalidade values (116,'ACAO','Ação');
  insert into tbl_funcionalidade values (117,'FUNCIONALIDADE','Funcionalidade');
  insert into tbl_funcionalidade values (118,'FUNCIONALIDADE_ACAO','Funcionalidade Ação');
  insert into tbl_funcionalidade values (119,'PERFIL','Perfil');
  insert into tbl_funcionalidade values (120,'PERFIL_FUNCIONALIDADE_ACAO','Perfil Funcionalidade Ação');
  insert into tbl_funcionalidade values (121,'USUARIO_PERFIL','Usuario Perfil');
  insert into tbl_funcionalidade values (122,'ATIVIDADES','Atividades');
  insert into tbl_funcionalidade values (123,'NOTAS','Notas');
  insert into tbl_funcionalidade values (124,'PLANO_ENSINO','Plano Ensino');
  insert into tbl_funcionalidade values (125,'PRESENCA','Presença');
  insert into tbl_funcionalidade values (126,'FECHAMENTO','Fechamento');
  insert into tbl_funcionalidade values (127,'FECHAMENTO_ALUNO','Fechamento Aluno');
  
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (100,100,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (101,100,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (102,100,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (103,100,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (104,101,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (105,101,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (106,101,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (107,101,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (108,102,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (109,102,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (110,102,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (111,102,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (112,103,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (113,103,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (114,103,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (115,103,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (116,104,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (117,104,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (118,104,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (119,104,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (120,105,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (121,105,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (122,105,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (123,105,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (124,106,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (125,106,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (126,106,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (127,106,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (128,107,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (129,107,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (130,107,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (131,107,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (132,108,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (133,108,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (134,108,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (135,108,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (136,109,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (137,109,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (138,109,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (139,109,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (140,110,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (141,110,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (142,110,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (143,110,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (144,111,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (145,111,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (212,111,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (146,111,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (147,112,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (148,112,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (149,112,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (150,112,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (151,113,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (152,113,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (153,113,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (154,113,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (155,114,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (156,114,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (157,114,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (158,114,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (159,115,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (161,115,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (162,115,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (163,115,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (164,116,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (165,116,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (166,116,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (167,116,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (168,117,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (169,117,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (170,117,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (171,117,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (172,118,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (173,118,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (174,118,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (175,118,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (176,119,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (177,119,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (178,119,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (179,119,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (180,120,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (181,120,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (182,120,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (183,120,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (184,121,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (185,121,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (186,121,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (187,121,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (188,122,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (189,122,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (190,122,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (191,122,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (192,123,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (193,123,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (194,123,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (195,123,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (196,124,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (197,124,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (198,124,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (199,124,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (200,125,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (201,125,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (202,125,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (203,125,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (204,126,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (205,126,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (206,126,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (207,126,103);
                                     
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (208,127,100);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (209,127,101);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (210,127,102);
  insert into tbl_funcionalidade_acao(SEQ_FUNCIONALIDADE_ACAO,SEQ_FUNCIONALIDADE,SEQ_ACAO) values (211,127,103);
  
  insert into tbl_perfil values (100,'Administrador','Admin');
  insert into tbl_perfil values (101,'Professor','Professor');
  
  insert into tbl_usuario_perfil values (100,101,100);
  
  insert into tbl_parametrizacao values (100,'ANO_VIGENTE',null,null, null);
  insert into tbl_parametrizacao values (101,'ANO_VIGENTE','7º Serie','7', 100);
  insert into tbl_parametrizacao values (102,'ANO_VIGENTE','5º Serie','5', 100);
  insert into tbl_parametrizacao values (103,'ANO_VIGENTE','6º Serie','6', 100);
  insert into tbl_parametrizacao values (105,'ANO_VIGENTE','8º Serie','8', 100);
  insert into tbl_parametrizacao values (106,'ALEATORIO',null,null, null);
  insert into tbl_parametrizacao values (107,'ALEATORIO','X','0', 106);
  insert into tbl_parametrizacao values (108,'TIPO_ATIVIDADE',null,null, null);
  insert into tbl_parametrizacao values (109,'TIPO_ATIVIDADE','Avaliação Bimestral','10', 108);
  insert into tbl_parametrizacao values (110,'TIPO_ATIVIDADE','Avaliação Trimestral','10', 108);
  insert into tbl_parametrizacao values (111,'TIPO_ATIVIDADE','Avaliação em Sala','10', 108);
  insert into tbl_parametrizacao values (112,'TIPO_ATIVIDADE','Ponto-Extra','10', 108);
  insert into tbl_parametrizacao values (113,'TIPO_NOTA',null,null, null);
  insert into tbl_parametrizacao values (114,'TIPO_NOTA','Nota simples','10', 113);
  insert into tbl_parametrizacao values (115,'TIPO_NOTA','Nota composta','10', 113);
  insert into tbl_parametrizacao values (116,'TIPO_NOTA','Nota substitutiva','10', 113);
    
  INSERT INTO TBL_ESCOLA (SEQ_ESCOLA, DES_BAIRRO, DES_NOME, DES_RUA, DES_SIGLA, NUM_CEP, NUM_CNPJ, NUM_ESCOLA, NUM_TEL, SEQ_CIDADE) VALUES (100, 'Bairro', 'Calos', 'Rua', 'CDA', 987, 987, 987, 100, 100);
  insert into tbl_ano values (100,2015,2015,102);
  INSERT INTO TBL_DISCIPLINA (SEQ_DISCIPLINA, DES_CONTEUDO, DES_NOME_DISCIPLINA) VALUES (100, 'Disciplina de teste', 'Matematica');
  INSERT INTO TBL_DISCIPLINA_ANO (SEQ_DISCIPLINA_ANO, TBL_ANO_SEQ_ANO, TBL_DISCIPLINA_SEQ_DISCIPLINA) VALUES (100,100,100);
  --select * from sequence;
  INSERT INTO TBL_PERFIL_FUNCIONALIDADE_ACAO (SEQ_PERFIL_FUNCIONALIDADE_ACAO, SEQ_FUNCIONALIDADE_ACAO, SEQ_PERFIL) VALUES (100, 107, 100);
  INSERT INTO TBL_DISCIPLINA_PROFESSOR (SEQ_DISCIPLINA_PROFESSOR, SEQ_DISCIPLINA_ANO, SEQ_PESSOA) VALUES (100, 100, 100);
  INSERT INTO TBL_TURNO (SEQ_TURNO, DES_TURNO) VALUES (100, 'Noite');
  INSERT INTO TBL_TURMA (SEQ_TURMA, FLG_TURMA_FECHADA, NUM_TUMRA, SEQ_ANO, SEQ_ESCOLA, SEQ_PESSOA, SEQ_TURNO) VALUES (100, 'N', 501, 100, 100, 100, 100);
  INSERT INTO TBL_ALUNO (SEQ_ALUNO, DAT_NASCIMENTO, DES_OBSERVACAO, FLG_ATIVO, NOM_ALUNO, NOM_CONTATO, NUM_CEL, NUM_TEL, NUM_TEL_CONTATO) VALUES (100, null, 'Observação', 'S', 'Jose´ Real', 'Rweter Real', '32', '23', '23');
  INSERT INTO TBL_SITUACAO (SEQ_SITUACAO, DES_SITUACAO) VALUES (100, 'Normal');
  INSERT INTO TBL_SITUACAO (SEQ_SITUACAO, DES_SITUACAO) VALUES (101, 'Transferido');
  INSERT INTO TBL_SITUACAO (SEQ_SITUACAO, DES_SITUACAO) VALUES (102, 'Cursando parcialmente');
  INSERT INTO TBL_ALUNO_TURMA (SEQ_ALUNO_TURMA, FLG_TURMA_ATUAL, SEQ_ALUNO, SEQ_SITUACAO, SEQ_TURMA) VALUES (100, 'S', 100, 100, 100);
  INSERT INTO TBL_ATIVIDADE (SEQ_ATIVIDADE, DAT_APLICACAO, NOM_ATIVIDADE, NUM_VALOR, SEQ_DISCIPLINA_ANO, SEQ_PARAME_TIPO) VALUES (100, NOW(), 'Atividade para Casa', 2, 100, 111);
  
  --select * from TBL_PLANO_ENSINO
--SELECT SEQ_ALUNO_TURMA, FLG_TURMA_ATUAL, SEQ_ALUNO, SEQ_SITUACAO, SEQ_TURMA FROM TBL_ALUNO_TURMA WHERE ((SEQ_TURMA IN (100)) AND (FLG_TURMA_ATUAL IN ('S')));
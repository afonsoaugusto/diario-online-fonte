/*
Create table Menu
*/

CREATE TABLE TBL_MENU 
   (	SEQ_MENU INT  NOT NULL AUTO_INCREMENT COMMENT 'Código sequencial da tabela.', 
	SEQ_MENU_PAI INT COMMENT 'Código do menu pai.', 
	NUM_ORDEM INT NOT NULL COMMENT 'Ordem em que o item irá aparecer', 
	TXT_TITULO VARCHAR(80) NOT NULL COMMENT 'Título do item do menu', 
	TXT_ACESSO VARCHAR(255) COMMENT 'Acesso ao menu', 
	TXT_VISAO VARCHAR(80) COMMENT 'Classe de visão', 
	SIT_ATIVO CHAR(1) DEFAULT 'S' NOT NULL COMMENT 'Indica se o menu está ativo.', 
	TXT_URL VARCHAR(255) COMMENT 'Armazena o endereço das funcionalidades dos sistemas', 
	 CONSTRAINT PK_MENU PRIMARY KEY (SEQ_MENU) , 
	 CONSTRAINT CK_LOATIVO_MENU CHECK (LO_ATIVO IN ('S','N')) , 
	 CONSTRAINT FK_MENU_MENUPAI FOREIGN KEY (SEQ_MENU_PAI)
	  REFERENCES TBL_MENU (SEQ_MENU) 
   );
--
-- AGENDA_OCT  (Table) 
--
CREATE TABLE AGENDA_OCT
(
  ID_AGENDA            NUMBER                   NOT NULL,
  AGENDAARQUIVO        VARCHAR2(200 BYTE),
  AGENDATIPOARQUIVO    CHAR(1 BYTE),
  AGENDAINICIOCONSUMO  DATE,
  AGENDAFIMCONSUMO     DATE,
  AGENDAINICIOPROC     DATE,
  AGENDAFIMPROC        DATE,
  AGENDACHKSUMLOTE     NUMBER,
  AGENDAORDEMPROC      NUMBER,
  ROBO_NOME            VARCHAR2(50 BYTE),
  AGENDASTATUS         NUMBER,
  AGENDAQTLINHAS       NUMBER
)
TABLESPACE TSDSVA01
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;

COMMENT ON TABLE AGENDA_OCT IS 'Tabela de Agendamento do Rob� de Leitura dos Arquivos TXT';

COMMENT ON COLUMN AGENDA_OCT.ID_AGENDA IS 'Chave da Tabela Agenda OCT';

COMMENT ON COLUMN AGENDA_OCT.AGENDAARQUIVO IS 'Nome do Arquivo do Agendamento';

COMMENT ON COLUMN AGENDA_OCT.AGENDATIPOARQUIVO IS 'Tipo do Arquivo do Agendamento: M-Movimento C-Cadastro I-Inativa��o';

COMMENT ON COLUMN AGENDA_OCT.AGENDAINICIOCONSUMO IS 'Data/Hora Inicial do Consumo';

COMMENT ON COLUMN AGENDA_OCT.AGENDAFIMCONSUMO IS 'Data/Hora Final do Consumo';

COMMENT ON COLUMN AGENDA_OCT.AGENDAINICIOPROC IS 'Data/Hora Inicial do Processamento';

COMMENT ON COLUMN AGENDA_OCT.AGENDAFIMPROC IS 'Data/Hora Final do Processamento';

COMMENT ON COLUMN AGENDA_OCT.AGENDACHKSUMLOTE IS 'Check Sum do Lote de Arquivos';

COMMENT ON COLUMN AGENDA_OCT.AGENDAORDEMPROC IS 'Ordem do Processamento';

COMMENT ON COLUMN AGENDA_OCT.ROBO_NOME IS 'Nome do Rob�';

COMMENT ON COLUMN AGENDA_OCT.AGENDASTATUS IS 'Status (0-Pendente - 1-Em Consumo - 2-Consumido - 3-Em  Processamento - 4-Processado)';

COMMENT ON COLUMN AGENDA_OCT.AGENDAQTLINHAS IS 'N�mero de Linhas do Arquivo do Agendamento';

--
-- APP_AGENDANX1  (Index) 
--
CREATE INDEX APP_AGENDANX1 ON AGENDA_OCT
(AGENDASTATUS, AGENDACHKSUMLOTE, AGENDAFIMPROC)
LOGGING
TABLESPACE TSISVA01
NOPARALLEL;

--
-- AGENDANX2  (Index) 
--
CREATE INDEX AGENDANX2_OCT ON AGENDA_OCT
(AGENDAINICIOPROC, AGENDASTATUS, AGENDACHKSUMLOTE)
LOGGING
TABLESPACE TSISVA01
NOPARALLEL;


--
-- AGENDANX3  (Index) 
--
CREATE INDEX AGENDANX3_OCT ON AGENDA_OCT
(AGENDACHKSUMLOTE)
LOGGING
TABLESPACE TSISVA01
NOPARALLEL;


--
-- AGENDA_PK  (Index) 
--
CREATE UNIQUE INDEX AGENDA_OCT_PK ON AGENDA_OCT
(ID_AGENDA)
LOGGING
TABLESPACE TSISVA01
NOPARALLEL;


--
-- AGENDA_U01  (Index) 
--
CREATE UNIQUE INDEX AGENDA_OCT_U01 ON AGENDA_OCT
(AGENDAARQUIVO)
LOGGING
TABLESPACE TSDSVA01
NOPARALLEL;


-- 
-- Non Foreign Key Constraints for Table AGENDA_OCT 
-- 
ALTER TABLE AGENDA_OCT ADD (
  CONSTRAINT AGENDA_OCT_PK
 PRIMARY KEY
 (ID_AGENDA)
    USING INDEX 
    TABLESPACE TSISVA01,
  CONSTRAINT AGENDA_OCT_U01
 UNIQUE (AGENDAARQUIVO)
    USING INDEX 
    TABLESPACE TSDSVA01);

GRANT DELETE, INSERT, SELECT, UPDATE ON AGENDA_OCT TO APP_BFFOWN;

GRANT DELETE, INSERT, SELECT, UPDATE ON TEMP_CONSUMO_CADASTRO TO APP_BFFOWN;
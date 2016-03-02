--
-- INTERFACECRM_OCTPROCESSO  (Table) 
--
CREATE TABLE INTERFACECRM_OCTPROCESSO
(
  ID_ARQUIVOIMPORTACAO            NUMBER        NOT NULL,
  INTERFACECRM_PROCESSOSTATUS     NUMBER        NOT NULL,
  INTERFACECRM_PROCESSOHEADER     VARCHAR2(4000 BYTE),
  INTERFACECRM_PROCESSOTRAILER    VARCHAR2(4000 BYTE),
  ID_INTERFACECRM_PROCESSO        NUMBER        NOT NULL,
  INTERFACECRM_PROCESSOSESSIONID  NUMBER
)
TABLESPACE TSDSVA01
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;

COMMENT ON COLUMN INTERFACECRM_OCTPROCESSO.ID_INTERFACECRM_PROCESSO IS 'Utilizado pelo Rob�';

COMMENT ON COLUMN INTERFACECRM_OCTPROCESSO.INTERFACECRM_PROCESSOSESSIONID IS 'Utilizado pelo Rob�';


GRANT DELETE, INSERT, SELECT, UPDATE ON INTERFACECRM_OCTPROCESSO TO APP_BFFOWN;


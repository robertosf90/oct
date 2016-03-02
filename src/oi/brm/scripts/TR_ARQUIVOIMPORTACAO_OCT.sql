--
-- TR_ARQUIVOIMPORTACAO_OCT  (Trigger) 
--
CREATE OR REPLACE TRIGGER "TR_ARQUIVOIMPORTACAO_OCT"
BEFORE INSERT
ON ARQUIVOIMPORTACAO_OCT
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
BEGIN
  if pc_adn_sva.desativa_arquivoimportacao then
    return;
  end if;
  --
    select Seq_ArquivoImportacao.nextval into :new.ID_ARQUIVOIMPORTACAO  from dual;
  --
  select max(ID_LayOut) into :new.ID_LAYOUT
  from LayOut L1
  where (L1.LayOutDataFinal is null or L1.LayOutDataFinal > sysdate)
    and  L1.LayOutDataInicial <= sysdate
    and  L1.LayOutTipo = :new.ArquivoImportacaoTipo;
  --

END TR_ARQUIVOIMPORTACAO_OCT;
/



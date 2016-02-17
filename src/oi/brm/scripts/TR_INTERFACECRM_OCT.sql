--
-- TR_INTERFACECRM_OCT  (Trigger) 
--
CREATE OR REPLACE TRIGGER TR_INTERFACECRM_OCT
BEFORE INSERT ON INTERFACECRM_OCT REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
BEGIN
  --
  if pc_adn_sva.desativa_interfacecrm_oct then
    return;
  end if;

  select to_number(to_char(sysdate,'yyyy')||to_char(Seq_Interfacecrm.nextval)) into :new.ID_INTERFACECRM from dual;

  :new.STATUS_SVA := XMLTYPE(:new.INTERFACECRMXML).extract('/LINHA/STATUS_SVA/text()').getStringVal(); 
  :new.CATEGORIA  := XMLTYPE(:new.INTERFACECRMXML).extract('/LINHA/CATEGORIA/text()').getStringVal();

END;
/



--
-- TR_AGENDA  (Trigger) 
--
CREATE OR REPLACE TRIGGER "TR_AGENDA_OCT"
BEFORE INSERT
ON AGENDA_OCT REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
BEGIN
  if pc_adn_sva.desativa_agenda then
    return;
  end if;
  --
  select to_number(to_char(sysdate,'yyyy')||to_char(Seq_Agenda.nextval)) into :new.ID_Agenda from dual;
END TR_AGENDA_OCT;
/


--
-- PC_ADN_SVA  (Package) 
--
CREATE OR REPLACE PACKAGE            pc_adn_sva
 IS
   desativa_agentecobrador         BOOLEAN := FALSE;
   desativa_evento                 BOOLEAN := FALSE;
   desativa_arquivoimportacao      BOOLEAN := FALSE;
   desativa_temparquivoimportacao  BOOLEAN := FALSE;
   desativa_categoriaservico       BOOLEAN := FALSE;
   desativa_evento_negocio         BOOLEAN := FALSE;
   desativa_empresa                BOOLEAN := FALSE;
   desativa_eventodepara           BOOLEAN := FALSE;
   desativa_modalidadepagamento    BOOLEAN := FALSE;
   desativa_eventomovimento        BOOLEAN := FALSE;
   desativa_fatura                 BOOLEAN := FALSE;
   desativa_logimportacao          BOOLEAN := FALSE;
   desativa_temp_logimportacao     BOOLEAN := FALSE;
   desativa_logimportacaoerro      BOOLEAN := FALSE;
   desativa_parametroempresa       BOOLEAN := FALSE;
   desativa_pessoa                 BOOLEAN := FALSE;
   desativa_pessoaterminal         BOOLEAN := FALSE;
   desativa_razao                  BOOLEAN := FALSE;
   desativa_servico                BOOLEAN := FALSE;
   desativa_servicoimposto         BOOLEAN := FALSE;
   desativa_status                 BOOLEAN := FALSE;
   desativa_terminal               BOOLEAN := FALSE;
   desativa_perfil                 BOOLEAN := FALSE;
   desativa_funcionalidade         BOOLEAN := FALSE;
   desativa_funcionalidade_objeto  BOOLEAN := FALSE;
   desativa_LayOut                 BOOLEAN := FALSE;
   desativa_Layoutcampo            BOOLEAN := FALSE;
   desativa_LogAlteracao           BOOLEAN := FALSE;
   desativa_arquivo                BOOLEAN := FALSE;
   desativa_agenda                 BOOLEAN := FALSE;
   desativa_parametro              BOOLEAN := FALSE;
   desativa_perfil_objeto          BOOLEAN := FALSE;
   desativa_sva_robo               BOOLEAN := FALSE;
   desativa_tab_fun                BOOLEAN := FALSE;
   desativa_tab_fun_perfil         BOOLEAN := FALSE;
   desativa_tab_job                BOOLEAN := FALSE;
   desativa_uf                     BOOLEAN := FALSE;
   desativa_ufddd                  BOOLEAN := FALSE;
   desativa_nr_fatura              BOOLEAN := FALSE;
   desativa_audit                  BOOLEAN := FALSE;
   desativa_evento_negocio_proc    BOOLEAN := FALSE;
   desativa_fornecedor             BOOLEAN := FALSE;
   desativa_siglaos                BOOLEAN := FALSE;
   desativa_situacaoos             BOOLEAN := FALSE;
   desativa_statussva              BOOLEAN := FALSE;
   desativa_campanha               BOOLEAN := FALSE;
   desativa_interfacecrm_oct       BOOLEAN := FALSE;
   desativa_crmdepara              BOOLEAN := FALSE;
   desativa_logretornoarquivo      BOOLEAN := FALSE;
   desativa_logretornolinha        BOOLEAN := FALSE;
   desativa_statussvadepara        BOOLEAN := FALSE;
   desativa_logerrocrm             BOOLEAN := FALSE;


   -- CURSOR DINAMICO
   TYPE
        EmpCurTyp IS REF CURSOR;

  --  ESTRUTURA DOS DADOS
  type t_tab_LayOutCampoOrdem       is table of LayOutCampo.LayOutCampoOrdem%type       index by pls_integer;
  type t_tab_LayOutCampoDescricao   is table of LayOutCampo.LayOutCampoDescricao%type   index by pls_integer;
  type t_tab_LayOutCampoPosInicial  is table of LayOutCampo.LayOutCampoPosInicial%type  index by pls_integer;
  type t_tab_LayOutCampoPosFinal    is table of LayOutCampo.LayOutCampoPosFinal%type    index by pls_integer;
  type t_tab_LayOutCampotipo        is table of LayOutCampo.LayOutCampotipo%type        index by pls_integer;
  --
  type t_tab_Id_Empresa               is table of Empresa.Id_Empresa%type               index by pls_integer;
  type t_tab_EmpresaCodigo            is table of Empresa.EmpresaCodigo%type            index by pls_integer;
  type t_tab_EmpresaDescricao         is table of Empresa.EmpresaDescricao%type         index by pls_integer;
  type t_tab_EmpresaMatriz            is table of Empresa.EmpresaMatriz%type            index by pls_integer;
  type t_tab_Id_Pessoa                is table of Empresa.Id_Pessoa%type                index by pls_integer;
  type t_tab_EmpresaDescricaoResumida is table of Empresa.EmpresaDescricaoResumida%type index by pls_integer;
  --
  type t_tab_ES_EmpresaCodigo         is table of Empresa.EmpresaCodigo%type            index by pls_integer;
  type t_tab_ES_ServicoCodigo         is table of Servico.ServicoCodigo%type            index by pls_integer;
  --
  --  HEADER DE MOVIMENTO
  v_MH_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_MH_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_MH_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_MH_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_MH_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- DETALHE DE MOVIMENTO
  v_MD_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_MD_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_MD_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_MD_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_MD_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- TRAILER DE MOVIMENTO
  v_MT_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_MT_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_MT_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_MT_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_MT_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- CADASTRO
  v_CA_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_CA_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_CA_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_CA_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_CA_LayOutCampotipo                t_tab_LayOutCampotipo;

  --  HEADER DE CADASTRO BF (A)
  v_AH_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_AH_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_AH_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_AH_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_AH_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- DETALHE DE CADASTRO BF (A)
  v_AD_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_AD_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_AD_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_AD_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_AD_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- TRAILER DE CADASTRO BF (A)
  v_AT_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_AT_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_AT_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_AT_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_AT_LayOutCampotipo                t_tab_LayOutCampotipo;


  --  HEADER DE MOVIMENTO BF - R1 (N)
  v_NH_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_NH_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_NH_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_NH_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_NH_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- DETALHE DE MOVIMENTO BF - R1 (N)
  v_ND_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_ND_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_ND_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_ND_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_ND_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- TRAILER DE MOVIMENTO BF - R1 (N)
  v_NT_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_NT_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_NT_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_NT_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_NT_LayOutCampotipo                t_tab_LayOutCampotipo;

  --  HEADER DE MOVIMENTO BF - R2 (O)
  v_OH_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_OH_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_OH_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_OH_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_OH_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- DETALHE DE MOVIMENTO BF - R2 (O)
  v_OD_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_OD_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_OD_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_OD_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_OD_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- TRAILER DE MOVIMENTO BF - R2 (O)
  v_OT_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_OT_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_OT_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_OT_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_OT_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- INVALIDOS
  v_IN_LayOutCampoOrdem               t_tab_LayOutCampoOrdem;
  v_IN_LayOutCampoDescricao           t_tab_LayOutCampoDescricao;
  v_IN_LayOutCampoPosInicial          t_tab_LayOutCampoPosInicial;
  v_IN_LayOutCampoPosFinal            t_tab_LayOutCampoPosFinal;
  v_IN_LayOutCampotipo                t_tab_LayOutCampotipo;

  -- EMPRESA
  v_tab_Id_Empresa                    t_tab_Id_Empresa;
  v_tab_EmpresaCodigo                 t_tab_EmpresaCodigo;
  v_tab_EmpresaDescricao              t_tab_EmpresaDescricao;
  v_tab_EmpresaMatriz                 t_tab_EmpresaMatriz;
  v_tab_Id_Pessoa                     t_tab_Id_Pessoa;
  v_tab_EmpresaDescricaoResumida      t_tab_EmpresaDescricaoResumida;

  -- EMPRESAS x SERVICOS
  v_tab_ES_EmpresaCodigo              t_tab_ES_EmpresaCodigo;
  v_tab_ES_ServicoCodigo              t_tab_ES_ServicoCodigo;
  --
  --
  -- PROCEDURE DE INICIALIZAÇÃO DE VARIAVEIS DE MEMORIA
  PROCEDURE up_inicializa_variaveis;

END pc_adn_sva;
/



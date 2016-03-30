package oi.brm.console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import oi.brm.utils.UtilsOCT;
import oi.brm.wsm.service.BeneficioFiscalCancelFlistIn;
import oi.brm.wsm.service.BeneficioFiscalCancelFlistOut;
import oi.brm.wsm.service.BeneficioFiscalCancelServiceImplPortBindingStub;
import oi.brm.wsm.service.BeneficioFiscalCancelServiceLocator;
import oi.brm.wsm.service.BeneficioFiscalPurchaseFlistIn;
import oi.brm.wsm.service.BeneficioFiscalPurchaseServiceImplPortBindingStub;
import oi.brm.wsm.service.BeneficioFiscalPurchaseServiceLocator;
import oi.brm.wsm.service.BeneficioFiscaloPurchaseFlistOut;
import oi.brm.wsm.service.IG_FLD_CUST_PROFILE_ARRAY;
import oi.brm.wsm.service.NAMEINFO_ARRAY;
import oi.brm.wsm.service.PAYINFOIGCOBILLINGARRAY;

import org.apache.axis.types.NonNegativeInteger;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class AtualizaCRM implements Runnable {
	

	
	private static final int ERRO = 9;
	private Connection con;
	private BigDecimal id_arquivoimportacao;
	private String header;
	private String footer;
	private String path_destino;
	private static Logger logger = Logger.getLogger(AtualizaCRM.class.getName());

	
	@Override
	public void run() {
		
		String branch = "";
		List<Fila> listaretorno = resgataFila(getId_arquivoimportacao());
		if (listaretorno.size() == 0) {
			try {
				LogDAO.inseriLogSucesso(con, null, "A FILA ESTÁ VAZIA.", "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				try {
					LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
		// Cria arquivo
		BufferedWriter out = null;
		BufferedWriter outMD5 = null;
		SimpleDateFormat format = null;
		SimpleDateFormat format2 = null;
		String nome_arquivo = null;
		String nome_arquivoMD5 = null;
		try {
			
			resgataDadosArquivo(getId_arquivoimportacao());
			branch = getHeader().substring(0, 3);
			
			format = new SimpleDateFormat("yyyyMMdd");
			format2 = new SimpleDateFormat("HHmmss");
			nome_arquivo 	= branch+ "_SVA_ENVIO_PARCEIRO_OI_" + format.format(new Date()) + "_" + format2.format(new Date()) + ".TXT";
			nome_arquivoMD5 	= nome_arquivo.replace(".TXT", ".MD5");
			
			atualizaArquivoImportacao(nome_arquivo, id_arquivoimportacao);
			
			out 	= new BufferedWriter(new FileWriter(getPath_destino() + "/" + nome_arquivo));
			outMD5 	= new BufferedWriter(new FileWriter(getPath_destino() + "/" + nome_arquivoMD5));
			resgataDadosArquivo(getId_arquivoimportacao());
			try {
				outMD5.write(nome_arquivo + " ");
				out.write(getHeader()+"\n");
			} catch (IOException e) {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			}
		}catch (IOException e1) {
			LogDAO.inseriLogErro(con, null, e1.getMessage(), "SISTEMA");
		}
		
		int i = 0;
		
		int status = 0;
		int quantidade = 0;
		
		UtilsOCT.iniciaVariaveisOracle(getCon(), logger, con);
		desativaAudit();
		
		String msg = "";
		
		for (i = 0; i < listaretorno.size(); i++) {
			msg = "";
			logger.warn("INTEGRANDO O " + i + 1 + " de " + listaretorno.size());
			this.updateRegistroFila(listaretorno.get(i), 2, msg);
			// Conecta no Web Service
			try {
			        
				if (listaretorno.get(i).getInterfacecrmmetodo() == 1){
					BeneficioFiscalPurchaseServiceLocator locator = new BeneficioFiscalPurchaseServiceLocator();
					BeneficioFiscalPurchaseServiceImplPortBindingStub cliente = (BeneficioFiscalPurchaseServiceImplPortBindingStub) locator
							.getBeneficioFiscalPurchaseServiceImplPort();
					BeneficioFiscalPurchaseFlistIn beneficiofiscalpurchaseflistin = new BeneficioFiscalPurchaseFlistIn();
					
					beneficiofiscalpurchaseflistin.setPOID("0.0.0.1");
					
					IG_FLD_CUST_PROFILE_ARRAY ig_fld_cust_profile_array = new IG_FLD_CUST_PROFILE_ARRAY();
					ig_fld_cust_profile_array.setIG_FLD_SEGMENT("CLIENTE");
					ig_fld_cust_profile_array.setIG_FLD_CPF_CNPJ(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NRO_DOCUMENTO",con));
					ig_fld_cust_profile_array.setIG_FLD_CITY_CODE(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "COD_IBGE_CID",con));
					ig_fld_cust_profile_array.setIG_FLD_ADDRESS_NUMBER(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NUMERO_LOGRADOURO",con));
					ig_fld_cust_profile_array.setIG_FLD_ADDRESS_COMPLEMENT(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "COMPLEMENTO",con));
					ig_fld_cust_profile_array.setIG_FLD_NEIGHBORHOOD(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "BAIRRO",con));
					ig_fld_cust_profile_array.setIG_FLD_COUNTRY_CODE("01058");
					
					String systemSource = UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "SERVICO_SVA", con);
					
					
					
                                        String ddd = systemSource.toUpperCase().equals("3GOCT") ? UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "DDD_MOVEL", con) : UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "DDD_FIXO", con);
					
					
					String phone =  systemSource.toUpperCase().equals("3GOCT") ? UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "PHONE_MOVEL", con) : UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "PHONE_FIXO", con);
					
					
					ig_fld_cust_profile_array.setIG_FLD_SYSTEM_SOURCE(systemSource.toUpperCase().contains("MULT") ? "MULT" : "OCT");
					
                                        String dateBirthdayString = UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(),
                                                "DATA_NASCIMENTO", con);
                                        Date parseDate = null;
                                        if (dateBirthdayString != null && !dateBirthdayString.trim().isEmpty()) {
                                            parseDate  = new Date(dateBirthdayString);
                                        }else{
                                            parseDate = new Date("31/12/1969 21:00:00");
                                        }
                                        
                                        
                                        ig_fld_cust_profile_array.setIG_FLD_BIRTHDAY_T(UtilsOCT.dateToStringTimestamp(parseDate));
					
					
					if (UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "SEXO",con).equalsIgnoreCase("F")){
						ig_fld_cust_profile_array.setIG_FLD_GENDER(1);
					}else if (UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "SEXO",con).equalsIgnoreCase("M")){
						ig_fld_cust_profile_array.setIG_FLD_GENDER(2);
					}else{
						ig_fld_cust_profile_array.setIG_FLD_GENDER(0);
					}
					
					
					if (UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_DOCUMENTO",con).equalsIgnoreCase("2") || UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_DOCUMENTO",con).equalsIgnoreCase("5") || UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_DOCUMENTO",con).equalsIgnoreCase("7")){
						ig_fld_cust_profile_array.setIG_FLD_COMPANY_NAME(retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "FIRST") + " " + retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "LAST"));
					}
					
					beneficiofiscalpurchaseflistin.setIG_FLD_CUST_PROFILE(ig_fld_cust_profile_array);
					
					NAMEINFO_ARRAY nameinfo_array = new NAMEINFO_ARRAY();
					
					nameinfo_array.setFIRST_NAME(retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "FIRST"));
					nameinfo_array.setLAST_NAME(retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "LAST"));
					
					
					if (UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "CATEGORIA",con).equals("")){
						if (UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_DOCUMENTO",con).equalsIgnoreCase("2") || UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_DOCUMENTO",con).equalsIgnoreCase("5") || UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_DOCUMENTO",con).equalsIgnoreCase("7")){
							nameinfo_array.setCONTACT_TYPE("COMERCIAL");
							nameinfo_array.setCOMPANY(retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "FIRST") + " " + retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "LAST"));
						}else{
							nameinfo_array.setCONTACT_TYPE("RESIDENCIAL");
						}
					}else{
						if (UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "CATEGORIA",con).equalsIgnoreCase("NRES")){
							nameinfo_array.setCONTACT_TYPE("COMERCIAL");
							nameinfo_array.setCOMPANY(retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "FIRST") + " " + retornaNome(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_CLIENTE",con), "LAST"));
						}else{
							nameinfo_array.setCONTACT_TYPE("RESIDENCIAL");
						}
					}
					
					
					
					nameinfo_array.setZIP(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "CEP",con));
					nameinfo_array.setADDRESS(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "TIPO_LOGRADOURO",con) + " " + UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NOME_LOGRADOURO",con));
					nameinfo_array.setSTATE(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "COD_IBGE_UF",con));
					oi.brm.wsm.service.PHONES_ARRAY PHONES  = new oi.brm.wsm.service.PHONES_ARRAY();
					PHONES.setElem(new NonNegativeInteger("0"));
					PHONES.setTYPE(new BigInteger("1"));
					PHONES.setPHONE("55" + ddd.substring(1,3) + phone);
					
					
					
					oi.brm.wsm.service.PHONES_ARRAY[] PHONES_ARRAY = { PHONES };
					
					nameinfo_array.setPHONES(PHONES_ARRAY);
					beneficiofiscalpurchaseflistin.setNAMEINFO(nameinfo_array);
										
					oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY ig_fld_emails_array =  new oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY();
					ig_fld_emails_array.setElem(new NonNegativeInteger("0"));
					ig_fld_emails_array.setIG_FLD_EMAIL_TYPE("Primary");
					String email = UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "EMAIL",con).trim();
					
					ig_fld_emails_array.setIG_FLD_EMAIL( email );
					
					
					oi.brm.wsm.service.IG_FLD_EMAILS_ARRAY[] EMAIL_ARRAY = { ig_fld_emails_array };
					
					beneficiofiscalpurchaseflistin.setIG_FLD_EMAILS(EMAIL_ARRAY);
					
					PAYINFOIGCOBILLINGARRAY payinfoigcobbilingarray = new PAYINFOIGCOBILLINGARRAY();
					
					if (branch.equalsIgnoreCase("STC")){
						payinfoigcobbilingarray.setIG_FLD_BRANCH("10");
					}else{
						payinfoigcobbilingarray.setIG_FLD_BRANCH("9");
					}
					
					payinfoigcobbilingarray.setIG_FLD_CONTRACT_NO(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "CONTRATO",con));
					payinfoigcobbilingarray.setIG_FLD_CPF_CNPJ(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NRO_DOCUMENTO",con));
					payinfoigcobbilingarray.setSERVICE_ID("55" + ddd.substring(1,3) + phone);
					payinfoigcobbilingarray.setIG_FLD_SERVICE_PROVIDER("Telemar");
					payinfoigcobbilingarray.setIG_FLD_TERMINAL_HOLDER("1");
					payinfoigcobbilingarray.setIG_FLD_RELATIONSHIP("Próprio");
					
					beneficiofiscalpurchaseflistin.setIG_FLD_COBILLING_INFO(payinfoigcobbilingarray);
					
					beneficiofiscalpurchaseflistin.setIG_FLD_SERVICE1(new BigInteger(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "SERVICO_SVA_NUM",con)));
					beneficiofiscalpurchaseflistin.setIG_FLD_SERVICE2(new BigInteger(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "SERVICO_SVA_NUM",con)));
					
					
                                        JAXBContext jaxbContext;
                                        try {
                                            jaxbContext = JAXBContext.newInstance(BeneficioFiscalPurchaseFlistIn.class);
                                            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                                            jaxbMarshaller.marshal(beneficiofiscalpurchaseflistin, System.out);
                                            logger.warn(System.out);
                                        } catch (JAXBException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }

					
					BeneficioFiscaloPurchaseFlistOut retorno =  cliente.IG_OP_SCM_BENEFICIO_FISCAL_PURCHASE(beneficiofiscalpurchaseflistin);
					
					msg = retorno.getSTATUS_MSG();
					int statusFlag = retorno.getSTATUS_FLAGS().intValue();
					
					if( statusFlag == 0)
					{
						
						atualizaPOID(retorno.getPOID(), UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NRO_DOCUMENTO",con));
						status = 1;
						quantidade++;
						LogDAO.inseriLogSucesso(con, null, msg, "SISTEMA");						
					}
					else
					{	
						LogDAO.inseriLogErro(con, null, msg, "SISTEMA");
						status = 9;												
					}
					
				}else{
					
					BeneficioFiscalCancelServiceLocator locator = new BeneficioFiscalCancelServiceLocator();
					BeneficioFiscalCancelServiceImplPortBindingStub cliente = (BeneficioFiscalCancelServiceImplPortBindingStub) locator
							.getBeneficioFiscalCancelServiceImplPort();
					
					BeneficioFiscalCancelFlistIn beneficiofiscalcancelflistin = new BeneficioFiscalCancelFlistIn();
					beneficiofiscalcancelflistin.setPOID(retornaPOID(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NRO_DOCUMENTO",con)));
					beneficiofiscalcancelflistin.setIG_FLD_CPF_CNPJ(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NRO_DOCUMENTO",con));
					
					PAYINFOIGCOBILLINGARRAY payinfoigcobillingarray = new PAYINFOIGCOBILLINGARRAY();
					if (branch.equalsIgnoreCase("STC")){
						payinfoigcobillingarray.setIG_FLD_BRANCH("10");
					}else{
						payinfoigcobillingarray.setIG_FLD_BRANCH("9");
					}
					String systemSource = UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "SERVICO_SVA", con);
					
					
					String ddd = systemSource.toUpperCase().equals("3GOCT") ? UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "DDD_MOVEL", con) : UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "DDD_FIXO", con);
                                        
                                        
                                        String phone =  systemSource.toUpperCase().equals("3GOCT") ? UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "PHONE_MOVEL", con) : UtilsOCT.retornaValorXML(listaretorno
                                                .get(i).getInterfacecrmxml(), "PHONE_FIXO", con);
					
					
					payinfoigcobillingarray.setIG_FLD_CPF_CNPJ(UtilsOCT.retornaValorXML(listaretorno.get(i).getInterfacecrmxml(), "NRO_DOCUMENTO",con));
					payinfoigcobillingarray.setSERVICE_ID("55" + ddd.substring(1,3) + phone);
					payinfoigcobillingarray.setIG_FLD_SERVICE_PROVIDER("TELEMAR");
					payinfoigcobillingarray.setIG_FLD_TERMINAL_HOLDER("1");
					payinfoigcobillingarray.setIG_FLD_RELATIONSHIP("Próprio");
					beneficiofiscalcancelflistin.setIG_FLD_COBILLING_INFO(payinfoigcobillingarray);
					
					BeneficioFiscalCancelFlistOut retorno = cliente.IG_OP_SCM_BENEFICIO_FISCAL_CANCEL(beneficiofiscalcancelflistin); 
					
					msg = retorno.getSTATUS_MSG(); 
					
					logger.warn("Cancel - "
							+ msg
							+ " - "
							+ UtilsOCT.retornaValorXML(listaretorno.get(i)
									.getInterfacecrmxml(), "CPF_CNPJ", con)
							+ " - "
							+ "55"
							+ddd.substring(1,3)
							+ phone);
					
					if (retorno.getSTATUS_FLAGS().intValue() == 0){
						status = 1;
						quantidade++;
					}else{
						status = 9;
					}

					
					
				}

				// retornou: Erro na recepção do XML : The root element is
			} catch (Exception e) {
				msg = e.getMessage();
				status = ERRO;
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
				logger.warn(e.getMessage());
			}
			
			
			this.updateRegistroFila(listaretorno.get(i), status, msg);
			
			try {
				if (status == 1) {
					out.write(listaretorno
							.get(i)
							.getInterfacecrmlinha()
							.replace(
									"@SERVICO",
									StringUtils.rightPad(
											UtilsOCT.retornaValorXML(
													listaretorno
															.get(i)
															.getInterfacecrmxml(),
													"SERVICO_SVA_ORIGINAL", con),
											9, " "))
							+ "\n");
				}
			} catch (IOException e) {
				try {
					LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
		// Fechar o arquivo
		try {
			out.write(getFooter().replace("@QTDE_REGISTROS",
					StringUtils.leftPad(String.valueOf(quantidade), 15, "0")));
			out.close();
			outMD5.write(MD5Hashing.retornaMD5(getPath_destino() + "/",
					nome_arquivo));
			outMD5.close();

		} catch (IOException e) {
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		}

		if (getCon() != null){
			try {
				getCon().close();
			} catch (SQLException e) {
				logger.debug(e.getMessage());
			}
			
		}
		
		
	}
	
	public String retornaPOID(String pessoacnpjcpf){
		String sql = "select nvl(pessoapoid, '0.0.0.1 /account -1 0') as pessoapoid from pessoa where lpad(pessoacnpjcpf, 14, '0') = lpad('" + pessoacnpjcpf + "', 14, '0')";
		logger.warn(" ----------------- ADN TECNOLOGIA SQL [ " + sql + " ]-----------------");
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				String _poid = rs.getString("pessoapoid");
				logger.warn(" -----------------   POID CANCELAMENTO [ " + _poid + " ]-----------------");
				return _poid;
			}
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			try {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					try {
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
					} catch (Exception e) {
						LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
					}
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					try {
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
					} catch (Exception e) {
						LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
					}
				}
			}
		}
		return null;
	}
	
	
	public void atualizaPOID(String poid, String pessoacnpjcpf){
		
		String sql = "update pessoa set pessoapoid = ? where pessoacnpjcpf = ?";
		PreparedStatement pstm = null;

		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1, poid);
			pstm.setString(2, pessoacnpjcpf);
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			try {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					try {
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
					} catch (Exception e) {
						LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
					}
				}
			}
		}
	}
	
	public String retornaNome(String nome, String posicao){
		if (posicao.equalsIgnoreCase("FIRST")){
			for (int i = 0; i < nome.length(); i++) {
				if (nome.substring(i, i + 1).equals(" ")){
					return nome.substring(0, i);
				}
			}
		}else{
			int ultimo_espaco = 0;
			for (int i = 0; i < nome.length(); i++) {
				if (nome.substring(i, i + 1).equalsIgnoreCase(" ")){
					return nome.substring(i+ 1, nome.length());
				}
			}
			return nome.substring(ultimo_espaco, nome.length());
		}		
		return nome;
	}
	public void updateRegistroFila(Fila fila, int status, String msg) {
		String sql = "update interfacecrm_oct intcrm set intcrm.INTERFACECRMSTATUS = ?, intcrm.INTERFACECRMDATAENVIO = sysdate, intcrm.interfacecrmmsg = ? where  intcrm.id_interfacecrm = ?";
		PreparedStatement pstm = null;

		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setInt(1, status);
			pstm.setString(2, msg);
			pstm.setBigDecimal(3, fila.getId_interfacecrm());
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			try {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			UtilsOCT.closePreparedStatement(pstm, con, logger);
		}
	}
	
	public void desativaAudit() {
		CallableStatement cs = null;
		try {
			cs = getCon().prepareCall(
					"{call pc_adn_sva.desativa_audit:=TRUE}");
			cs.execute();
			cs.close();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(),
							"SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(),
							"SISTEMA");
				}
			}
		}

	}
	
	public void atualizaArquivoImportacao(String arquivo_nome, BigDecimal id_arquivoimportacao) {
		String sql = "update arquivoimportacao_oct set arquivoimportacaoretorno  = ? where  id_arquivoimportacao = ?";
		
		PreparedStatement pstm = null;

		try {
			pstm = getCon().prepareStatement(sql);
			pstm.setString(1, arquivo_nome);
			pstm.setBigDecimal(2, id_arquivoimportacao);
			pstm.execute();
			pstm.close();
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			try {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			UtilsOCT.closePreparedStatement(pstm, con, logger);
		}
	}
	
	public void resgataDadosArquivo(BigDecimal id) {
		String sql = "select interfacecrm_processoheader, interfacecrm_processotrailer from interfacecrm_octprocesso where id_arquivoimportacao = " + id;
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				setHeader(rs.getString("interfacecrm_processoheader"));
				setFooter(rs.getString("interfacecrm_processotrailer"));
			}
			
			
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			try {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				}
			}
		}
	}

	    
	public List<Fila> resgataFila(BigDecimal id) {
		String sql = "select interfacecrmxml, id_interfacecrm, interfacecrmlinha, interfacecrmmetodo from interfacecrm_oct where interfacecrmstatus = 0 and id_arquivoimportacao = "
				+ id;
		ResultSet rs = null;
		Statement stm = null;
		List<Fila> lista = new ArrayList<Fila>();
		try {
			stm = getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Fila fila = new Fila();
				fila.setInterfacecrmlinha(rs.getString("interfacecrmlinha"));
				fila.setInterfacecrmxml(rs.getString("interfacecrmxml"));
				fila.setId_interfacecrm(rs.getBigDecimal("id_interfacecrm"));
				fila.setInterfacecrmmetodo(rs.getInt("interfacecrmmetodo"));
				lista.add(fila);
			}
			getCon().commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			try {
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					try {
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
					} catch (Exception e) {
						LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
					}
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception sqe) {
					logger.warn(sqe.getMessage());
					try {
						LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
					} catch (Exception e) {
						LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
					}
				}
			}
		}
		return lista;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public BigDecimal getId_arquivoimportacao() {
		return id_arquivoimportacao;
	}

	public void setId_arquivoimportacao(BigDecimal id_arquivoimportacao) {
		this.id_arquivoimportacao = id_arquivoimportacao;
	}

	public String getPath_destino() {
		return path_destino;
	}

	public void setPath_destino(String path_destino) {
		this.path_destino = path_destino;
	}
	
	
	

}

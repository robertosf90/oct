package oi.brm.console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Principal implements Runnable {

//	private static final String MESSAGES_PROPERTIES = "C:/robooct.properties";
	private static final String MESSAGES_PROPERTIES = "/etc/octrobo/robooct.properties";  

	public static String tipo;
	public static String login;
	public static String senha;
	public static String sid;
	public static String porta;
	public static String host;
	public static String porta2;
	public static String host2;
	public static String path;
	public static String path_destino;
	public static String path_retorno;
	public static String arquivo;
	public static Integer limite_thread;
	public static Connection con;
	private static Logger logger = Logger.getLogger(Principal.class.getName());

	@Override
	public void run() {
		try {
			Properties props = new Properties();
			logger.warn("CARREGANDO DADOS DO ARQUIVO:" + MESSAGES_PROPERTIES);
			FileInputStream file;

			file = new FileInputStream(MESSAGES_PROPERTIES);
			logger.warn("ARQUIVO CARREGADO.");
			props.load(file);

			getParametersFromProperties(props);

			logger.warn("ESTABELECENDO CONEXAO.");
			con = Conexao.getConnectionParametrizada(tipo, login, senha, host,
					sid, porta, host2, porta2);

			isConnectionActive();
			
			logger.warn("CONEXAO ESTABELECIDA");

		} catch (Exception e) {
			logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
			logger.warn("[ERRO ROBO OCT] - SAINDO DA APLICAÇÃO");
			System.exit(0);
		}
		
		
		

		desmarcaInterfaceCRM();
                desmarcaInterfaceCRMProcesso(); 
		
		
		LerArquivoCadastro v_LerArquivoCadastro = new LerArquivoCadastro();
		Thread threadCadastro = new Thread(v_LerArquivoCadastro);

		fillLerArquivoCadastro(v_LerArquivoCadastro);

		threadCadastro.start();

		LerArquivoCRM v_LerArquivoCRM = new LerArquivoCRM();
		Thread threadCRM = new Thread(v_LerArquivoCRM);

		fillLerArquivoCRM(v_LerArquivoCRM);
		
		threadCRM.start();

		while (true) {

			logger.warn(Thread.activeCount() + " de " + limite_thread);

			if (Thread.activeCount() > limite_thread) {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}

			if (retornaQtdPendete() == 0) {
				if (!populaAgendaArquivo()) {
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						logger.warn(e.getMessage());
					}
					continue;
				}
			}

			LerArquivo v_LerArquivo = new LerArquivo();
			Thread thread = new Thread(v_LerArquivo);

			if (retornaQtdPendete() > 0) {
				try {
					v_LerArquivo.setCon(Conexao
							.getConnectionParametrizada(tipo, login, senha,
									host, sid, porta, host2, porta2));
				} catch (Exception e) {
					logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
				}

				if (populaAgendaSec(v_LerArquivo)) {
					fillLerArquivo(v_LerArquivo);
					thread.start();
				}

			} else {
				thread = null;
				v_LerArquivo = null;
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					LogDAO.inseriLogErro(con, null,
							"[ERRO ROBO OCT] - " + e.getMessage(), "SISTEMA");
				}
			}

		}

	}

	private void fillLerArquivo(LerArquivo v_LerArquivo) {
		try {
			if (v_LerArquivo.getCon() == null) {
				logger.warn("[ERRO ROBO OCT] - PARAMETRIZAÇÃO INCORRETA.");
				LogDAO.inseriLogErro(
						con,
						null,
						"[ERRO ROBO OCT] - PARAMETRIZAÇÃO INCORRETA.",
						"SISTEMA");
			} else if (v_LerArquivo.getCon().isClosed()) {
				logger.warn("[ERRO ROBO OCT] - PARAMETRIZAÇÃO INCORRETA.");
				LogDAO.inseriLogErro(
						con,
						null,
						"[ERRO ROBO OCT] - PARAMETRIZAÇÃO INCORRETA.",
						"SISTEMA");
			}
		} catch (Exception e) {
			logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
			LogDAO.inseriLogErro(con, null, "[ERRO ROBO OCT] - "
					+ e.getMessage(), "SISTEMA");
		}

		v_LerArquivo.setHost(host);
		v_LerArquivo.setHost2(host2);
		v_LerArquivo.setLogin(login);
		v_LerArquivo.setPorta(porta);
		v_LerArquivo.setPorta2(porta2);
		v_LerArquivo.setSenha(senha);
		v_LerArquivo.setSid(sid);
		v_LerArquivo.setTipo(tipo);
		v_LerArquivo.setPath(path);
		v_LerArquivo.setPath_destino(path_destino);
	}

	private void fillLerArquivoCRM(LerArquivoCRM v_LerArquivoCRM) {
		try {
			v_LerArquivoCRM.setCon(Conexao.getConnectionParametrizada(tipo,
					login, senha, host, sid, porta, host2, porta2));
		} catch (Exception e1) {
			logger.warn(e1);
		}
		v_LerArquivoCRM.setHost(host);
		v_LerArquivoCRM.setHost2(host2);
		v_LerArquivoCRM.setLogin(login);
		v_LerArquivoCRM.setPorta(porta);
		v_LerArquivoCRM.setPorta2(porta2);
		v_LerArquivoCRM.setSenha(senha);
		v_LerArquivoCRM.setSid(sid);
		v_LerArquivoCRM.setTipo(tipo);
		v_LerArquivoCRM.setPath(path);
		v_LerArquivoCRM.setPath_destino(path_retorno);
	}

	private void fillLerArquivoCadastro(LerArquivoCadastro v_LerArquivoCadastro) {
		try {
			v_LerArquivoCadastro.setCon(Conexao.getConnectionParametrizada(
					tipo, login, senha, host, sid, porta, host2, porta2));
		} catch (Exception e1) {
			logger.warn(e1);
		}
		v_LerArquivoCadastro.setHost(host);
		v_LerArquivoCadastro.setHost2(host2);
		v_LerArquivoCadastro.setLogin(login);
		v_LerArquivoCadastro.setPorta(porta);
		v_LerArquivoCadastro.setPorta2(porta2);
		v_LerArquivoCadastro.setSenha(senha);
		v_LerArquivoCadastro.setSid(sid);
		v_LerArquivoCadastro.setTipo(tipo);
		v_LerArquivoCadastro.setArquivo(arquivo);
		v_LerArquivoCadastro.setPath(path);
		v_LerArquivoCadastro.setPath_destino(path_destino);
	}

	private void isConnectionActive() throws SQLException {
		if (con == null) {
			logger.warn("CONEXAO NAO ESTABELECIDA");
			System.exit(0);
		} else if (con.isClosed()) {
			logger.warn("CONEXAO NAO ESTABELECIDA");
			System.exit(0);
		}
	}

	private void getParametersFromProperties(Properties props) {
		tipo = props.getProperty("robooct.tipoBanco");
		login = props.getProperty("robooct.login");
		senha = props.getProperty("robooct.senha");
		sid = props.getProperty("robooct.SID");
		host = props.getProperty("robooct.host");
		porta = props.getProperty("robooct.porta");
		host2 = props.getProperty("robooct.host2");
		porta2 = props.getProperty("robooct.porta2");
		path = props.getProperty("robooct.path");
		path_destino = props.getProperty("robooct.path_destino");
		path_retorno = props.getProperty("robooct.path_retorno");
		try {
			limite_thread = Integer.parseInt(props
					.getProperty("robooct.limite_thread"));
		} catch (Exception e) {
			limite_thread = 100;
		}
	}

	public static boolean populaAgendaSec(LerArquivo _lerarquivo) {
		PreparedStatement pstm = null;
		// Pra saber aquele arquivo ainda esta processando, associa a sessäo
		String sql = "update agenda_arquivo set sessionid = (select userenv('sessionid') id from dual) where agenda_arquivo.agendaarquivo = (select max(agendaarquivo) from agenda_arquivo where sessionid is null)";

		try {
			pstm = _lerarquivo.getCon().prepareStatement(sql);
			pstm.execute();
			pstm.close();
			_lerarquivo.getCon().commit();

			// pega o arquivo que vai ser processo
			sql = "select agendaarquivo from agenda_arquivo WHERE sessionid = (select userenv('sessionid') id from dual) ";
			ResultSet rs = null;
			Statement stm = null;
			stm = _lerarquivo.getCon().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				_lerarquivo.setArquivo(rs.getString("agendaarquivo"));
			}

			if (_lerarquivo.getArquivo() == null) {
				return false;
			}

			//insere o arquivo na agenda
			sql = "INSERT INTO agenda_oct (AGENDAARQUIVO, AGENDATIPOARQUIVO, AGENDAORDEMPROC, AGENDASTATUS) VALUES (?, ?, (SELECT NVL(MAX(ARQUIVOORDEM), 99) FROM ARQUIVO WHERE ARQUIVONOME = ?), 0) ";
			pstm = _lerarquivo.getCon().prepareStatement(sql);
			pstm.setString(1, _lerarquivo.getArquivo());
			pstm.setString(2, retornaTipoArquivo(_lerarquivo.getArquivo()));
			pstm.setString(3, _lerarquivo.getArquivo());
			pstm.execute();
			pstm.close();
			_lerarquivo.getCon().commit();

		} catch (Exception e) {
			logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
			LogDAO.inseriLogErro(con, null,
					"[ERRO ROBO OCT] - " + e.getMessage(), "SISTEMA");
			if (e.getMessage().contains("00001")) {
				try {
					if (_lerarquivo.getArquivo() != null) {
						Principal
								.copy(new File(
										(_lerarquivo.getPath() + "/" + _lerarquivo
												.getArquivo().toUpperCase())
												.replace(".TXT", ".PROC")),
										new File(
												(_lerarquivo.getPath() + "/" + _lerarquivo
														.getArquivo()
														.toUpperCase())
														.replace(".TXT",
																".PROC")), true);
						Principal
								.copy(new File(
										(_lerarquivo.getPath() + "/" + _lerarquivo
												.getArquivo().toUpperCase())
												.replace(".TXT", ".MD5")),
										new File(
												(_lerarquivo.getPath() + "/" + _lerarquivo
														.getArquivo()
														.toUpperCase())
														.replace(".TXT", ".MD5")),
										true);
					}
				} catch (Exception e2) {
					logger.warn("[ERRO ROBO OCT] - " + e.getMessage());
					LogDAO.inseriLogErro(con, null,
							"[ERRO ROBO OCT] - " + e.getMessage(), "SISTEMA");
				}
			}
			return false;
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn("[ERRO ROBO OCT] - " + sqe.getMessage());
					LogDAO.inseriLogErro(con, null,
							"[ERRO ROBO OCT] - " + sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn("[ERRO ROBO OCT] - " + re.getMessage());
					LogDAO.inseriLogErro(con, null,
							"[ERRO ROBO OCT] - " + re.getMessage(), "SISTEMA");
				}
			}
		}

		if (_lerarquivo.getArquivo() != null) {
			return true;
		}

		return false;
	}

	public static String retornaTipoArquivo(String arquivo_nome) {
		String sql = "select arquivotipo, arquivonome from arquivo";
		ResultSet rs = null;
		Statement stm = null;

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				if (arquivo_nome.contains(rs.getString("arquivonome"))) {
					return rs.getString("arquivotipo");
				}
			}
			con.commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());

				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					;
				}
			}
		}

		return null;
	}

	// TODO: ADICIONAR A EXTESÃO DO ARQUIVO QUE REPRESENTA O OCT
	// Pendencia o nome do arquivo de movimentos (falta o douglas definir)
	public static List<String> retornaListaArquivosMovimento() {
		String sql = "select ARQUIVONOME from arquivo WHERE arquivotipo in ('M', 'N', 'O') ";
		ResultSet rs = null;
		Statement stm = null;
		List<String> lista = new ArrayList<String>();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				lista.add(rs.getString("ARQUIVONOME"));
			}
			con.commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
		}

		return lista;
	}

	//Verificar se precisa duplicar a agenda_arquivo  e agenda
	public static boolean populaAgendaArquivo() {
		PreparedStatement pstm = null;
		File dir = new File(path);
		File nome = null;
		String sql = "INSERT INTO agenda_arquivo (AGENDAARQUIVO) VALUES (?)";
		List<String> lista = Principal.retornaListaArquivosMovimento();
		boolean achou = false;
		boolean retorno = false;

		try {
			if (dir.isDirectory()) {
				String[] filhos = dir.list();
				int g = filhos.length;
				logger.warn("QUANTIDADE G:" + g);
				for (int i = 0; i < filhos.length; i++) {
					if (!filhos[i].toUpperCase().endsWith(".TXT")) {
						continue;
					} else {
						for (String arq : lista) {

							if (filhos[i].toUpperCase().contains(
									arq.toUpperCase())) {
								if (MD5CheckSum.ValidaMD5(path, filhos[i], con)) {
									nome = new File(dir, filhos[i]);
									achou = nome.renameTo(new File(nome
											.getAbsolutePath()
											.replace(".txt", ".PROC")
											.replace(".TXT", ".PROC")));
									break;
								}
							}
						}
					}
					if (achou) {
						retorno = true;
						achou = false;
						try {
							pstm = con.prepareStatement(sql);
							pstm.setString(1, nome.getName().toUpperCase());
							pstm.execute();
							con.commit();

						} catch (Exception e) {
							if (e.getMessage().contains("00001")) {
								if (nome.getAbsolutePath().contains("FIM")) {
									if (nome.isFile()) {
										nome.delete();
									}
								} else {
									logger.warn("[ERRO ROBO OCT] - "
											+ nome.getName()
											+ " JÁ PROCESSADO.");
								}

							} else {
								logger.warn("[ERRO ROBO OCT] - "
										+ e.getMessage());
								LogDAO.inseriLogLote(con, nome.getName(),
										e.getMessage());
							}
							return false;
						} finally {
							if (pstm != null) {
								try {
									pstm.close();
								} catch (SQLException sqe) {
									logger.warn("[ERRO ROBO OCT] - "
											+ sqe.getMessage());
									LogDAO.inseriLogErro(con, null,
											sqe.getMessage(), "SISTEMA");
									LogDAO.inseriLogLote(con, nome.getName(),
											sqe.getMessage());
								} catch (RuntimeException re) {
									logger.warn("[ERRO ROBO OCT] - "
											+ re.getMessage());
									LogDAO.inseriLogErro(
											con,
											null,
											"[ERRO ROBO OCT] - "
													+ re.getMessage(),
											"SISTEMA");
									LogDAO.inseriLogLote(con, nome.getName(),
											re.getMessage());
								}
							}
						}
					}
				}

				return retorno;

			}
		} catch (Exception e) {
			if (!e.getMessage().contains("00001")) {
				logger.warn("[ERRO ROBO OCT] - " + nome.getName()
						+ " JÁ PROCESSADO.");
				LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
				return false;
			}
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException sqe) {
					logger.warn("[ERRO ROBO OCT] - " + sqe.getMessage());
					LogDAO.inseriLogErro(con, null,
							"[ERRO ROBO OCT] - " + sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn("[ERRO ROBO OCT] - " + re.getMessage());
					LogDAO.inseriLogErro(con, null,
							"[ERRO ROBO OCT] - " + re.getMessage(), "SISTEMA");
				}
			}
			if (nome != null) {
				nome = null;
			}
		}
		return false;
	}

	public int retornaQtdPendete() {
		String sql = "select count(1) as qtd from agenda_arquivo where sessionid is null ";
		ResultSet rs = null;
		Statement stm = null;
		int qtd = 0;

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				qtd = rs.getInt("qtd");
			}
			con.commit();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
		}

		return qtd;
	}

	public static List<String> retornaListaArquivosCadastro() {
	        
	        //Adiciona um novo tipo em arquivoTipo do tipo Cadastro OCT = C
	        // Precisamos saber os nomes dos arquivos do tipo OCT (Falta ser passado pro Douglas- OI)
		String sql = "select ARQUIVONOME from arquivo WHERE arquivotipo in ('T') ";
		ResultSet rs = null;
		Statement stm = null;
		List<String> lista = new ArrayList<String>();

		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				lista.add(rs.getString("ARQUIVONOME"));
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					logger.warn(sqe.getMessage());
					LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
				} catch (RuntimeException re) {
					logger.warn(re.getMessage());
					LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
				}
			}
		}

		return lista;
	}

	public static void copy(File origem, File destino, boolean overwrite)
			throws IOException {
		if (destino.exists() && !overwrite) {
			LogDAO.inseriLogErro(con, null, destino.getName()
					+ " já existe, ignorando...", "SISTEMA");
			return;
		}
		FileInputStream fisOrigem = new FileInputStream(origem);
		FileOutputStream fisDestino = new FileOutputStream(destino);
		FileChannel fcOrigem = fisOrigem.getChannel();
		FileChannel fcDestino = fisDestino.getChannel();
		fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
		fisOrigem.close();
		fisDestino.close();
		origem.delete();
	}
	
	
	public void desmarcaInterfaceCRM(){
            PreparedStatement pstm = null;
            String sql = "update interfacecrm_oct set interfacecrmstatus = 0 where interfacecrmstatus = 2";

            try{
                    pstm = con.prepareStatement(sql);
                    pstm.execute();
                    pstm.close();
                    con.commit();
            }catch (Exception e) {
                    logger.warn(e.getMessage());
                    LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
            }finally{
                    if (pstm != null) {
                          try {
                              pstm.close();
                          } catch (SQLException sqe) {
                                            logger.warn(sqe.getMessage());
                                            LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
                          } catch (RuntimeException re) {
                                            logger.warn(re.getMessage());
                                            LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
                          }
                       }
            }
            
    }
    

    public void desmarcaInterfaceCRMProcesso(){
            PreparedStatement pstm = null;
            String sql = "update interfacecrm_octprocesso set interfacecrm_processostatus = 0, interfacecrm_processosessionid = null where id_arquivoimportacao in ( select distinct id_arquivoimportacao from interfacecrm_oct where interfacecrmstatus = 0 )";

            try{
                    pstm = con.prepareStatement(sql);
                    pstm.execute();
                    pstm.close();
                    con.commit();
            }catch (Exception e) {
                    logger.warn(e.getMessage());
                    LogDAO.inseriLogErro(con, null, e.getMessage(), "SISTEMA");
            }finally{
                    if (pstm != null) {
                          try {
                              pstm.close();
                          } catch (SQLException sqe) {
                                            logger.warn(sqe.getMessage());
                                            LogDAO.inseriLogErro(con, null, sqe.getMessage(), "SISTEMA");
                          } catch (RuntimeException re) {
                                            logger.warn(re.getMessage());
                                            LogDAO.inseriLogErro(con, null, re.getMessage(), "SISTEMA");
                          }
                       }
            }
            
    }

}

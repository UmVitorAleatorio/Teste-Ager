package br.com.soc.sistema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.soc.sistema.exception.TechnicalException;

public abstract class Dao implements AutoCloseable{

	private static boolean primeiraInicializacao = true;
	private Connection con = null;
	
	public Dao() {
		conectar();
	}
	
	private void conectar() {
		StringBuilder urlBuilder = new StringBuilder("jdbc:h2:mem:avaliacao;")
										.append("DB_CLOSE_DELAY=-1;")
										.append("DATABASE_TO_UPPER=false;");
		
		if(primeiraInicializacao) {
			urlBuilder.append("INIT=runscript from 'classpath:CRIA_TABELAS_E_INSERE_REGISTROS_INICIAIS.sql';");
			primeiraInicializacao = false;
		}		
		
		 try {	 
			 Class.forName("org.h2.Driver");
			 con = DriverManager.getConnection(urlBuilder.toString());
        } catch (SQLException ex) {
        	ex.printStackTrace();
            throw new TechnicalException("Ocorreu um problema na tentativa de conexao", ex);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	private void fechar() throws SQLException {
		if(con == null)
			throw new TechnicalException("Conexao nao foi criada");
		
		if(con.isClosed())
			throw new TechnicalException("Conexao ja foi encerrada");
		
		con.close();
	}

	@Override
	public void close() throws Exception {
		try{
			fechar();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * retorna uma conexao
	 * @return
	 * @throws SQLException 
	 */
	protected Connection getConexao() throws SQLException {
		if(con == null || con.isClosed())
			conectar();
		return con;
	}	
}

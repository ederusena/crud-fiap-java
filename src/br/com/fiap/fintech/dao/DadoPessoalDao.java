package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.interfaces.ConnectionInterface;
import br.com.fiap.fintech.model.DadoPessoalModel;

public class DadoPessoalDao implements ConnectionInterface {
	
	public DadoPessoalModel findById(int id) {
		DadoPessoalModel dadoPessoalModel = null;
		
		try {
			Class.forName(myDriver);
			
			Connection conn = DriverManager.getConnection(myUrl, user, password);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT pessoa_id, registro_dt, login_id, nome_sobrenome_nm, nascimento_dt, cpf_nu, registro_geral_nu FROM TF_DADO_PESSOAL WHERE pessoa_id = " + id);
			
			if ( rs.next() ) {
				dadoPessoalModel = new DadoPessoalModel();
				dadoPessoalModel.setData_registro( rs.getDate("REGISTRO_DT"));
				dadoPessoalModel.setNomecompleto( rs.getString("NOME_SOBRENOME_NM"));
				dadoPessoalModel.setData_nascimento( rs.getDate("NASCIMENTO_DT"));
				dadoPessoalModel.setCpf( rs.getLong("CPF_NU"));
				dadoPessoalModel.setRegistro_geral( rs.getLong("REGISTRO_GERAL_NU"));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return dadoPessoalModel;
	}
	
	public List<DadoPessoalModel> getAll() throws SQLException {
		List<DadoPessoalModel> listaDadoPessoal = new ArrayList<DadoPessoalModel>();
		Connection con = null;
		try {
			final String query = "SELECT LOGIN_ID,REGISTRO_DT,USUARIO_NM,EMAIL_NM,SENHA_NM FROM TF_DADO_PESSOAL";
			
		    Class.forName(myDriver);
		    
			con = DriverManager.getConnection(myUrl, user, password);
			
			// create the java statement
			Statement st = con.createStatement();
			
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
		    {
				DadoPessoalModel dadoPessoalModel = new DadoPessoalModel();
				
				dadoPessoalModel.setId( rs.getInt("PESSOA_ID"));
				dadoPessoalModel.setData_registro( rs.getDate("REGISTRO_DT"));
				dadoPessoalModel.setLogin_id( rs.getInt("LOGIN_ID"));
				dadoPessoalModel.setNomecompleto( rs.getString("NOME_SOBRENOME_NM"));
				dadoPessoalModel.setData_nascimento( rs.getDate("NASCIMENTO_DT"));
				dadoPessoalModel.setCpf( rs.getLong("CPF_NU"));
				dadoPessoalModel.setRegistro_geral( rs.getLong("REGISTRO_GERAL_NU"));
				
                listaDadoPessoal.add(dadoPessoalModel);
		    }

			con.close();

		} catch (SQLException e) {
			System.err.println("Erro na query");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("O Driver jdbc nao foi encontrado");
			e.printStackTrace();
		} finally {
			con = null;
		}
		
		return listaDadoPessoal;
	}
	
	public void insert(DadoPessoalModel dadosPessoalModel) throws SQLException {
		String SQL1 = 
			" INSERT INTO TF_DADO_PESSOAL(PESSOA_ID, REGISTRO_DT, LOGIN_ID, NOME_SOBRENOME_NM, NASCIMENTO_DT, CPF_NU, REGISTRO_GERAL_NU)"
			+ " VALUES (SEQ_DADO_PESSOAL_PESSOA_ID.NEXTVAL,CURRENT_DATE,?,?,?,?,?)";

		
		Connection con = null;
		
		try {
			Class.forName(myDriver);
		    
			con = DriverManager.getConnection(myUrl, user, password);
			
			PreparedStatement ptmt = con.prepareStatement(SQL1);
	
			ptmt.setInt(1, dadosPessoalModel.getId());
			ptmt.setString(2, dadosPessoalModel.getNomecompleto());
			ptmt.setDate(3, dadosPessoalModel.getData_nascimento());
			ptmt.setLong(4, dadosPessoalModel.getCpf());
			ptmt.setLong(5, dadosPessoalModel.getRegistro_geral());
			
			ptmt.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			con = null;
		}
		
	}

	public void update(DadoPessoalModel dadosPessoalModel) throws SQLException {
		
		String SQL1 = 
				" UPDATE TF_DADO_PESSOAL SET NOME_SOBRENOME_NM = ? , NASCIMENTO_DT  = ? , CPF_NU  = ? , REGISTRO_GERAL_NU = ?  WHERE pessoa_id = ? ";
		
		Connection con = null;
		
		try {
			Class.forName(myDriver);
		    
			con = DriverManager.getConnection(myUrl, user, password);
			PreparedStatement ptmt = con.prepareStatement(SQL1);

			ptmt.setString(1, dadosPessoalModel.getNomecompleto());
			ptmt.setDate(2, dadosPessoalModel.getData_nascimento());
			ptmt.setLong(3, dadosPessoalModel.getCpf());
			ptmt.setLong(4, dadosPessoalModel.getRegistro_geral());
			ptmt.setInt(5, dadosPessoalModel.getId());
			
			ptmt.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			con = null;
		}
	}

//public void delete(int id) {}
	
}
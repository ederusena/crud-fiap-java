package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.DadoPessoalModel;

public class DadoPessoalDao {
	List<DadoPessoalModel> listaDadoPessoal = new ArrayList<DadoPessoalModel>();
	Connection con = null;
	
	public List<DadoPessoalModel> getAll() throws SQLException {
		try {
			final String myDriver = "oracle.jdbc.driver.OracleDriver";
			final String myUrl = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
			final String query = "SELECT * FROM TF_DADO_PESSOAL";
			final String user = "sys as sysdba";
			final String password = "9766";
			
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
}

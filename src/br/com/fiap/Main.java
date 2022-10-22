package br.com.fiap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static void main(String [] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "sys as sysdba", "9766");
			
			System.out.print("Conectado!");
			
			con.close();
			
		} catch (SQLException e) {
			System.err.println("Nao foi possivel conectar");
		} catch (ClassNotFoundException e) {
			System.err.println("O Driver jdbc nao foi encontrado");
		}
	}
}

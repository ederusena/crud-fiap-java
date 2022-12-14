package br.com.fiap.fintech.view.dadopessoal;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fiap.fintech.dao.DadoPessoalDao;
import br.com.fiap.fintech.model.DadoPessoalModel;

public class InsertDadoPessoalView {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		try {
			DadoPessoalModel model = new DadoPessoalModel();
			
			String strDate = "24/05/2000";
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			
			Date dataProducao = (Date) sdf.parse(strDate);
			
			model.setNomecompleto("Eder Manchovinhas");
			model.setData_nascimento(dataProducao);
			model.setCpf(34424424424L);
			model.setRegistro_geral(414141414);
			
			DadoPessoalDao dao = new DadoPessoalDao();
			dao.insert(model);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}

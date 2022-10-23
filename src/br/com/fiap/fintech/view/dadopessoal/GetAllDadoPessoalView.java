package br.com.fiap.fintech.view.dadopessoal;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.dao.DadoPessoalDao;
import br.com.fiap.fintech.model.DadoPessoalModel;

public class GetAllDadoPessoalView {

	public static void main(String[] args) {

		try {
			
			DadoPessoalDao dao = new DadoPessoalDao();
			List<DadoPessoalModel> listaDadoPessoal = dao.getAll();

			for (DadoPessoalModel dadoPessoalModel : listaDadoPessoal) {
				System.out.println(dadoPessoalModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

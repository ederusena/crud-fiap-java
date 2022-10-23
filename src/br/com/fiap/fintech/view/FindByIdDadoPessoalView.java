package br.com.fiap.fintech.view;

import java.util.List;

import br.com.fiap.fintech.dao.DadoPessoalDao;
import br.com.fiap.fintech.model.DadoPessoalModel;

public class FindByIdDadoPessoalView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int id;

			DadoPessoalDao dao = new DadoPessoalDao();

			id = 6;
			DadoPessoalModel model = dao.findById(id);
			
			System.out.println(model.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

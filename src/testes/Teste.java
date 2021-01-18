package testes;

import model.dao.AnimalDAO;
import model.dao.ResponsavelDAO;
import model.vo.AnimalVO;
import model.vo.ResponsavelVO;

public class Teste {
	public static void main(String[] args) {

		ResponsavelDAO respDAO = new ResponsavelDAO();

		ResponsavelVO respVO = new ResponsavelVO("Joao", "654.123.123-03", "rua de pedra", "recife", "pe");
		//respDAO.inserir(respVO);
		
		
		AnimalDAO aniDAO = new AnimalDAO();

		AnimalVO aniVO = new AnimalVO("Bixano4", "persa", 3, "gato", 1);
		//aniDAO.inserir(aniVO);
		
		// aniDAO.atualizar(aniVO);
		// aniDAO.excluir(aniVO);

		for (AnimalVO a : aniDAO.listarTodos()) {
			System.out.println(a.getNome());
		}


	}
}

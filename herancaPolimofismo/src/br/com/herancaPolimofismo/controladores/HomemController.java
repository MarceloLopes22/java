package br.com.herancaPolimofismo.controladores;

import java.util.List;

import br.com.herancaPolimofismo.basicas.Homem;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.repositorios.HomemDAO;

public class HomemController extends AbstractController {

	private static  HomemController controller;
	
	public static synchronized HomemController get() {
		if (controller == null) {
			controller = new HomemController();
		}
		return controller;
	}

	public boolean salvarAlterar(Mamifero homem) {
		boolean salvarAlterar = HomemDAO.get().salvarAlterar(homem);
		return salvarAlterar ? true : false;
	}

	public boolean remover(Mamifero homem) {
		boolean remover = HomemDAO.get().remover(homem);
		return remover ? true : false;
	}

	public Homem getHomem(Mamifero homem) throws Exception {
		validarTipoObjeto(homem);
		return HomemDAO.get().getHomem(homem);
	}

	public List<Homem> getHomens() {
		return HomemDAO.get().getHomens();
	}

	@Override
	public void validarTipoObjeto(Mamifero mamifero) throws Exception {
		if (!(mamifero instanceof Homem)) {
			throw new Exception("Tipo de objeto informado não é homem.");
		}
	}

}

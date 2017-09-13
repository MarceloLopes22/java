package br.com.herancaPolimofismo.controladores;

import java.util.List;

import br.com.herancaPolimofismo.basicas.Homem;
import br.com.herancaPolimofismo.basicas.Macaco;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.repositorios.MacacoDAO;
import br.com.herancaPolimofismo.repositorios.MacacoDAO;

public class MacacoController extends AbstractController {

	private static MacacoController controller;
	
	public static synchronized MacacoController get() {
		if (controller == null) {
			controller = new MacacoController();
		}
		return controller;
	}

	public boolean salvarAlterar(Mamifero macaco) {
		boolean salvarAlterar = MacacoDAO.get().salvarAlterar(macaco);
		return salvarAlterar ? true : false;
	}

	public boolean remover(Mamifero macaco) {
		boolean remover = MacacoDAO.get().remover(macaco);
		return remover ? true : false;
	}

	public Macaco getMacaco(Mamifero macaco) throws Exception {
		validarTipoObjeto(macaco);
		return MacacoDAO.get().getMacaco(macaco);
	}

	public List<Macaco> getMacacos() {
		return MacacoDAO.get().getMacacos();
	}

	@Override
	public void validarTipoObjeto(Mamifero macaco) throws Exception {
		if (!(macaco instanceof Macaco)) {
			throw new Exception("Tipo de objeto informado não é macaco.");
		}
	}

}

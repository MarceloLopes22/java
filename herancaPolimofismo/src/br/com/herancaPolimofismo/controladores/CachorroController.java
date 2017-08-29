package br.com.herancaPolimofismo.controladores;

import java.util.List;

import br.com.herancaPolimofismo.basicas.Cachorro;
import br.com.herancaPolimofismo.basicas.Mamifero;
import br.com.herancaPolimofismo.repositorios.CachorroDAO;

public class CachorroController {
	
	private static CachorroController controller;
	
	public static synchronized CachorroController get(){
		if (controller == null) {
			controller = new CachorroController();
		}
		return controller;
	}
	
	public boolean salvarAlterar(Mamifero cachorro) throws Exception {
		validarTipoObjeto(cachorro);
		boolean isSalvo = CachorroDAO.get().salvarAlterar(cachorro);
		return isSalvo == true ? true : false;
	}

	private void validarTipoObjeto(Mamifero cachorro) throws Exception {
		if (!(cachorro instanceof Cachorro)) {
			throw new Exception("O objeto informador não é um cachorro!");
		}
	}
	
	public boolean remover(Mamifero cachorro) throws Exception {
		validarTipoObjeto(cachorro);
		boolean isExcluido = CachorroDAO.get().remover(cachorro);
		return isExcluido == true ? true : false;
	}
	
	public Mamifero getCachorro(Mamifero cachorro) throws Exception {
		validarTipoObjeto(cachorro);
		return CachorroDAO.get().getCachorro(cachorro);
	}
	
	public List<Cachorro> getCachorros() {
		return CachorroDAO.get().getCachorros();
	}
	
}

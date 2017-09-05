package br.com.herancaPolimofismo.controladores;

import br.com.herancaPolimofismo.basicas.Mamifero;

public abstract class AbstractController {

	public abstract void validarTipoObjeto(Mamifero mamifero) throws Exception;
}

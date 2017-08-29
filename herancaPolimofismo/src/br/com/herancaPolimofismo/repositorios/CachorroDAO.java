package br.com.herancaPolimofismo.repositorios;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.herancaPolimofismo.basicas.Cachorro;
import br.com.herancaPolimofismo.basicas.Mamifero;

public class CachorroDAO {

	private static CachorroDAO dao;
	private Map<Integer, Cachorro> cachorros;
	private int size;
	
	public static synchronized CachorroDAO get() {
		if (dao == null) {
			dao = new CachorroDAO();
		}
		return dao;
	}
	
	public CachorroDAO() {
		size = 0;
		cachorros = new HashMap<Integer, Cachorro>();
	}
	
	public boolean salvarAlterar(Mamifero cachorro) {
		cachorros.put(cachorro.getPelos(), Cachorro.class.cast(cachorro));
		if (cachorros.size() > size) {
			size = cachorros.size(); 
			return true;
		}
		return false;
	}
	
	public boolean remover(Mamifero cachorro) {
		if (cachorros.containsKey(cachorro)) {
			cachorros.remove(cachorro);
			return true;
		}
		return false;
	}
	
	public Mamifero getCachorro(Mamifero cachorro) {
		return cachorros.get(cachorro);
	}
	
	public List<Cachorro> getCachorros() {
		return Collections.list(Collections.enumeration(cachorros.values()));
	}
}

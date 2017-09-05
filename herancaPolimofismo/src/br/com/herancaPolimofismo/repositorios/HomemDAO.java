package br.com.herancaPolimofismo.repositorios;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.herancaPolimofismo.basicas.Homem;
import br.com.herancaPolimofismo.basicas.Mamifero;

public class HomemDAO {

	private static HomemDAO dao;
	private Map<String, Homem> map;
	private int size;
	
	public static synchronized HomemDAO get() {
		if (dao == null) {
			dao = new HomemDAO();
		}
		return dao;
	}
	
	public HomemDAO() {
		map = new HashMap<String, Homem>();
		size = 0;
	}

	public boolean salvarAlterar(Mamifero homem) {
		
		map.put(homem.recuperarNome(), Homem.class.cast(homem));
		if (map.size() > size) {
			size = map.size();
			return true;
		}
		return false;
	}

	public boolean remover(Mamifero homem) {
		
		if (map.containsValue(homem)) {
			map.remove(homem);
			return true;
		}
		
		return false;
	}

	public Homem getHomem(Mamifero homem) {
		
		if (map.containsValue(homem)) {
			return map.get(homem);
		}
		return null;
	}

	public List<Homem> getHomens() {
		return Collections.list(Collections.enumeration(map.values()));
	}
}

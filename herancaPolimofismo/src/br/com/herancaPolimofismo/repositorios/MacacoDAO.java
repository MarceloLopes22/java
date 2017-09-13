package br.com.herancaPolimofismo.repositorios;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.herancaPolimofismo.basicas.Macaco;
import br.com.herancaPolimofismo.basicas.Mamifero;

public class MacacoDAO {

	private static MacacoDAO dao;
	private Map<String, Macaco> map;
	private int size;
	
	public static synchronized MacacoDAO get() {
		if (dao == null) {
			dao = new MacacoDAO();
		}
		return dao;
	}
	
	public MacacoDAO() {
		map = new HashMap<String, Macaco>();
		size = 0;
	}

	public boolean salvarAlterar(Mamifero macaco) {
		
		map.put(macaco.recuperarNome(), Macaco.class.cast(macaco));
		if (map.size() > size) {
			size = map.size();
			return true;
		}
		return false;
	}

	public boolean remover(Mamifero macaco) {
		
		if (map.containsValue(macaco)) {
			map.remove(macaco);
			return true;
		}
		
		return false;
	}

	public Macaco getMacaco(Mamifero macaco) {
		
		if (map.containsValue(macaco)) {
			return map.get(macaco);
		}
		return null;
	}

	public List<Macaco> getMacacos() {
		return Collections.list(Collections.enumeration(map.values()));
	}
}

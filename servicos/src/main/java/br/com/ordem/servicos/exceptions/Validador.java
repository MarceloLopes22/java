package br.com.ordem.servicos.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Validador {

	private List<String> erros;
	
	public Validador() {
		this.erros = new ArrayList<String>();
	}
	
	public Validador validarNuloOuVazio (Object valor, String nomeCampo) {
		boolean contemErro = false;
		if (valor instanceof String) {
			contemErro = StringUtils.isBlank(String.valueOf(valor));
		} else {
			contemErro = valor == null;
		}
		
		if (contemErro)
			addErro(getMensagemCampoObrigatorio(nomeCampo));
		return this; 
	}
	
	public void addErro (String mgs) {
		erros.add(mgs);
	}
	
	private String getMensagemCampoObrigatorio (final String nomeCampo) {
		return String.format("O campo %s é obrigatório", nomeCampo);
	}

	public void validar () throws NegocioException {
		if (!erros.isEmpty()) {
			throw new NegocioException(erros);
		}
	}

}

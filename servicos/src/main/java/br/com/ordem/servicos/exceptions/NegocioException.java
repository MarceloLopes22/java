package br.com.ordem.servicos.exceptions;

import java.util.List;

// classe para guardar os erros de negocio
public class NegocioException extends Exception {
	
	private static final long serialVersionUID = 1820607028107331587L;
	
	private List<String> erros;
	
	public NegocioException(List<String> erros) {
		this.erros = erros;
	}

	public List<String> getErros () {
		return this.erros;
	}
}

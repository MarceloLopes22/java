package br.com.ordem.servicos.mediator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordem.servicos.classesbasicas.Endereco;
import br.com.ordem.servicos.exceptions.NegocioException;
import br.com.ordem.servicos.exceptions.Validador;
import br.com.ordem.servicos.repositorio.IEnderecoRepositorio;

@Service
public class EnderecoMediator {

	@Autowired
	private IEnderecoRepositorio repositorio;

	@Transactional
	public Endereco pesquisarEndereco(int id) throws NegocioException {
		Validador validador = new Validador();
		validador.validarNuloOuVazio(id, "Endereco");
		validador.validar();
		return repositorio.pesquisarEndereco(id);
	}

	@Transactional (readOnly = true)
	public List<Endereco> pegarTodosEnderecos() {
		return repositorio.pegarTodosEnderecos();
	}
	
	@Transactional
	public Integer salvarOuAtuaslizar(Endereco endereco) throws NegocioException {
		Validador validador = new Validador();
		validador.validarNuloOuVazio(endereco, "Endereco");
		validador.validar();
		validador.validarNuloOuVazio(endereco.getEndereco(), "endereco");
		validador.validarNuloOuVazio(endereco.getCep(), "cep");
		validador.validarNuloOuVazio(endereco.getNumero(), "numero");
		validador.validarNuloOuVazio(endereco.getBairro(), "bairro");
		validador.validarNuloOuVazio(endereco.getCidade(), "cidade");
		validador.validarNuloOuVazio(endereco.getEstado(), "estado");
		validador.validar();
		
		return repositorio.salvarOuAtualizar(endereco);
	}
	
	private void validarAtributos(Endereco endereco) throws NegocioException {
		
	}
}

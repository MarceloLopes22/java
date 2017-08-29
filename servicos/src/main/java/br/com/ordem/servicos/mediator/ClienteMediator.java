package br.com.ordem.servicos.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordem.servicos.classesbasicas.Cliente;
import br.com.ordem.servicos.classesbasicas.Endereco;
import br.com.ordem.servicos.exceptions.NegocioException;
import br.com.ordem.servicos.exceptions.Validador;
import br.com.ordem.servicos.repositorio.IClienteRepositorio;

@Service
public class ClienteMediator {

	@Autowired
	private IClienteRepositorio repositorio;
	@Autowired
	private EnderecoMediator enderecoMediator;
	
	@Transactional(readOnly = true)
	public boolean isUsuarioExistente(Cliente cliente) throws NegocioException {
		Validador validador = new Validador();
		
		validador.validarNuloOuVazio(cliente, "Cliente");
		validador.validar();
		
		validador.validarNuloOuVazio(cliente.getLogin(), "login");
		validador.validarNuloOuVazio(cliente.getSenha(), "senha");
		validador.validar();
		
		return repositorio.isUsuarioExistente(cliente);
	}

	@Transactional
	public void salvarCliente(Cliente cliente) throws NegocioException {
		validar(cliente);		
		repositorio.salvarOuAtualizar(cliente);
	}

	@Transactional(readOnly = true)
	public Endereco pesquisarEndereco(int enderecoId) throws NegocioException {
		return enderecoMediator.pesquisarEndereco(enderecoId);
	}
	
	public void validar(Cliente cliente) throws NegocioException {
		Validador validador = new Validador();
		
		validador.validarNuloOuVazio(cliente, "cliente");
		validador.validar();
		
		validador.validarNuloOuVazio(cliente.getNome(), "nome");
		validador.validarNuloOuVazio(cliente.getCPF(), "CPF");
		validador.validarNuloOuVazio(cliente.getLogin(), "login");
		validador.validarNuloOuVazio(cliente.getSenha(), "senha");
		validador.validar();
		
		validador.validarNuloOuVazio(cliente.getEndereco(), "Endereço");
		validador.validarNuloOuVazio(cliente.getEndereco().getEndereco(), "Endereço");
		validador.validarNuloOuVazio(cliente.getEndereco().getCep(), "Cep");
		validador.validarNuloOuVazio(cliente.getEndereco().getNumero(), "Numero");
		validador.validarNuloOuVazio(cliente.getEndereco().getBairro(), "Bairro");
		validador.validarNuloOuVazio(cliente.getEndereco().getCidade(), "Cidade");
		validador.validarNuloOuVazio(cliente.getEndereco().getEstado(), "Estado");
		validador.validar();
	}
}

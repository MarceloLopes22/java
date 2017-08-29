package br.com.ordem.servicos.repositorio;

import java.util.List;

import br.com.ordem.servicos.classesbasicas.Cliente;

public interface IClienteRepositorio {
	
	Cliente pesquisarCliente(int id);
	
	List<Cliente> pegarTodosClientes();
	
	void salvarOuAtualizar(Cliente cliente);
	
	void remover(Cliente cliente);

	boolean isUsuarioExistente(Cliente cliente);
}

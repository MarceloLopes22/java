package br.com.ordem.servicos.repositorio;

import java.util.List;

import br.com.ordem.servicos.classesbasicas.Endereco;

public interface IEnderecoRepositorio {
	
	Endereco pesquisarEndereco(int id);

	List<Endereco> pegarTodosEnderecos();

	Integer salvarOuAtualizar(Endereco endereco);

	void remover(Endereco endereco);
}

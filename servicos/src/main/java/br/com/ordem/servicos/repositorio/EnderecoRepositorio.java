package br.com.ordem.servicos.repositorio;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ordem.servicos.classesbasicas.Endereco;

@Service
public class EnderecoRepositorio implements IEnderecoRepositorio {
	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	public Endereco pesquisarEndereco(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Endereco.class);
		criteria.add(Restrictions.eq("id", id));
		return Endereco.class.cast(criteria.uniqueResult());
	}

	@Override
	public List<Endereco> pegarTodosEnderecos() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Endereco.class);
		return (List<Endereco>)criteria.list();
	}

	@Override
	public Integer salvarOuAtualizar(Endereco endereco) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(endereco);
		session.flush();
		return endereco.getId();
	}

	@Override
	public void remover(Endereco endereco) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(endereco);
		session.flush();
	}
}

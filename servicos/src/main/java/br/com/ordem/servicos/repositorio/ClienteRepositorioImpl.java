package br.com.ordem.servicos.repositorio;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.ordem.servicos.classesbasicas.Cliente;
import br.com.ordem.servicos.helpers.ServicosHelper;

@Repository
public class ClienteRepositorioImpl implements IClienteRepositorio {
	
	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	public Cliente pesquisarCliente(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.idEq(id));
		return Cliente.class.cast(criteria.uniqueResult());
	}

	@Override
	public List<Cliente> pegarTodosClientes() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		return (List<Cliente>) criteria.list();
	}

	@Override
	public void salvarOuAtualizar(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cliente);
		session.flush();
	}

	@Override
	public void remover(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cliente);
		session.flush();
	}

	@Override
	public boolean isUsuarioExistente(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cliente.class);
		Criterion login = Restrictions.eq("login", cliente.getLogin());
		Criterion senha = Restrictions.eq("senha", cliente.getSenha());
		criteria.add(Restrictions.and(login, senha));
		return criteria.uniqueResult() != null;
	}
}

package br.com.ordem.servicos.pages;

import org.apache.wicket.model.IModel;

import br.com.ordem.servicos.classesbasicas.Cliente;

public class PaginaPrincipal extends HomePage {

	private static final long serialVersionUID = -6451482059663934434L;
	
	private IModel<Cliente> modelCliente;
	
	public PaginaPrincipal(IModel<Cliente> model) {
		modelCliente = model;
	}
	
	public PaginaPrincipal() {
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		success("Bem Vindo, " + modelCliente.getObject().getLogin());
		addComponentes();
	}
	
	private void addComponentes() {
		Menu menu = new Menu("menuinterno");
		menu.setMarkupId("componentemenu");
		configureId(menu);
		this.add(menu);
	}
}

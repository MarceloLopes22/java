package br.com.ordem.servicos.pages;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class Menu extends Panel {

	public Menu(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 5591415824284062661L;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		addComponentes();
	}
	
	private void addComponentes() {
		
		BookmarkablePageLink<PaginaPrincipal> principalPage = new BookmarkablePageLink<PaginaPrincipal>("principalPage", PaginaPrincipal.class);
		principalPage.setOutputMarkupId(true);
		
		BookmarkablePageLink<CadastrarCliente> clientePage = new BookmarkablePageLink<CadastrarCliente>("clientePage", CadastrarCliente.class);
		clientePage.setOutputMarkupId(true);
		
		add(principalPage);
		add(clientePage);
	}
}

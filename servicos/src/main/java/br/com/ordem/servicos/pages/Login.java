package br.com.ordem.servicos.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import br.com.ordem.servicos.classesbasicas.Cliente;
import br.com.ordem.servicos.exceptions.NegocioException;
import br.com.ordem.servicos.mediator.ClienteMediator;

public class Login extends HomePage {

	private static final long serialVersionUID = -1675840248841447264L;
	private Cliente cliente;

	@SpringBean
	private ClienteMediator mediator;

	public Login() {
		cliente = new Cliente();
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		addComponentes();
	}

	private void addComponentes() {
		final Form<Cliente> form = new Form<Cliente>("formulario");
		configureId(form);
		form.setDefaultModel(new CompoundPropertyModel<Cliente>(cliente));
		
		TextField<Cliente> login = new TextField<Cliente>("login");
		configureId(login);
		form.add(login);
		
		PasswordTextField senha = new PasswordTextField("senha");
		senha.setRequired(false);
		configureId(senha);
		form.add(senha);

		Button btnLogar = new Button("logar") {
			private static final long serialVersionUID = -8449743677503221059L;
			@Override
			public void onSubmit() {
				try {
					boolean isUsuario = mediator.isUsuarioExistente(cliente);
					if (isUsuario) {
						setResponsePage(new PaginaPrincipal(form.getModel()));
					} else {
						error("Usuario Não Encontrado!");
					}
				} catch (NegocioException e) {
					for (String msg : e.getErros()) {
						error(msg);
					}
				}
			}
		};
		configureId(btnLogar);
		form.add(btnLogar);

		AjaxButton btnCancelar = new AjaxButton("cancelar") {
			private static final long serialVersionUID = 2957368426867218115L;
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(true);
			}
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				form.setDefaultModelObject(Model.of(new Cliente()));
				target.add(form);
			}
		};
		configureId(btnCancelar);
		form.add(btnCancelar);

		Link<Cliente> cadastrarUsuario = new Link<Cliente>("cadastrarUsuario") {
			private static final long serialVersionUID = 4945901277303477812L;
			@Override
			public void onClick() {
				setResponsePage(new CadastrarCliente());
			}
		};
		configureId(cadastrarUsuario);
		form.add(cadastrarUsuario);
		this.add(form);
	}
}

package br.com.ordem.servicos.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import br.com.ordem.servicos.classesbasicas.Cliente;
import br.com.ordem.servicos.classesbasicas.Endereco;
import br.com.ordem.servicos.exceptions.NegocioException;
import br.com.ordem.servicos.mediator.ClienteMediator;

public class CadastrarCliente extends HomePage {

	private static final long serialVersionUID = 7368405029715842622L;
	private Cliente cliente;
	private Form<Cliente> form;
	private static final List<String> ESTADOS = Arrays.asList(new String[]{ "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
			"Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul",
			"Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
			"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" });
	@SpringBean
	private ClienteMediator mediator;
	private CompoundPropertyModel<Cliente> clienteModel;

	public CadastrarCliente() {
			cliente = new Cliente();
			cliente.setEndereco(new Endereco());
			clienteModel = new CompoundPropertyModel<Cliente>(cliente);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		addComponentes();
	}

	private void addComponentes() {
		form = new Form<Cliente>("formCliente", clienteModel);
		configureId(form);
		form.setMarkupId(form.getId());

		TextField<String> nome = new TextField<String>("nome");
		configureId(nome);
		form.add(nome);

		TextField<String> cpf = new TextField<String>("cpf");
		configureId(cpf);
		cpf.setMarkupId(cpf.getId());
		form.add(cpf);

		TextField<String> login = new TextField<String>("login");
		configureId(login);
		form.add(login);

		PasswordTextField senha = new PasswordTextField("senha");
		configureId(senha);
		form.add(senha);
		
		TextField<String> endereco = new TextField<String>("endereco.endereco");
		configureId(endereco);
		form.add(endereco);
		
		TextField<String> cep = new TextField<String>("endereco.cep");
		configureId(cep);
		form.add(cep);
		
		NumberTextField<Integer> numero = new NumberTextField<Integer>("endereco.numero");
		configureId(numero);
		form.add(numero);
		
		TextField<String> bairro = new TextField<String>("endereco.bairro");
		configureId(bairro);
		form.add(bairro);
		
		TextField<String> cidade = new TextField<String>("endereco.cidade");
		configureId(cidade);
		form.add(cidade);

		DropDownChoice<String> estado = new DropDownChoice<String>("endereco.estado", ESTADOS);
		configureId(estado);
		form.add(estado);

		Button salvar = new Button("salvar") {
			private static final long serialVersionUID = -7284979897237777441L;
			@Override
			public void onSubmit() {
				try {
					clienteModel.setObject(removerMascaras(clienteModel.getObject()));
					mediator.salvarCliente(clienteModel.getObject());
					success("Usuario Cadastraod com Sucesso!");
					setResponsePage(new Login());
				} catch (NegocioException e) {
					for (String msg : e.getErros()) {
						error(msg);
					}
				}
			}
			private Cliente removerMascaras(Cliente cliente) {
				if (StringUtils.isNotEmpty(cliente.getCPF())) {
					cliente.setCPF(cliente.getCPF().replace(".", "").replace("-", ""));
				}
				if (StringUtils.isNotEmpty(cliente.getEndereco().getCep())) {
					cliente.getEndereco().setCep(cliente.getEndereco().getCep().replace("-", ""));
				}
				return cliente;
			}
		};
		configureId(salvar);
		form.add(salvar);

		AjaxLink<Cliente> limpar = new AjaxLink<Cliente>("limpar") {
			private static final long serialVersionUID = 3447041179566130961L;
			@Override 
			public void onClick(AjaxRequestTarget target) {
				cliente = new Cliente();
				cliente.setEndereco(new Endereco());
				form.setDefaultModelObject(cliente);
				target.add(form);
			}
		};
		configureId(limpar);
		form.add(limpar);

		Link<Cliente> voltar = new Link<Cliente>("voltar") {
			private static final long serialVersionUID = -6308746036537746009L;
			@Override
			public void onClick() {
				setResponsePage(new Login());
			}
		};
		configureId(voltar);
		form.add(voltar);
		this.add(form);
	}
}

package br.com.ordem.servicos.pages;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see br.com.ordem.servicos.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * Constructor
	 */
	public WicketApplication() {
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<Login> getHomePage() {
		return Login.class;
	}

	public void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}
}

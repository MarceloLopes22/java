package br.com.ordem.servicos.pages;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 * Homepage
 */

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
    
    @Override
    protected void onInitialize() {
    	super.onInitialize();
    	addComponentes();
    }

	private void addComponentes() {
		
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		configureId(feedbackPanel);
		this.add(feedbackPanel);
	}
	
	public Component configureId(Component component) {
		component.setOutputMarkupId(true);
		component.setMarkupId(component.getId());
		return component;
	}
}

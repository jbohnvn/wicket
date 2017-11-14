package com.jbohn.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;


public class TemplatePage extends WebPage {
	private static final long serialVersionUID = 5218374612129395403L;
	public static final String CONTENT_ID = "contentComponent";

	public TemplatePage() {
		add(new HeaderPanel("headerPanel"));
		add(new EmptyPanel(CONTENT_ID));
	}

}

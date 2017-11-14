package com.jbohn.wicket;

public class HomePage extends TemplatePage {
	private static final long serialVersionUID = -7465108755276912649L;

	public HomePage() {
		super();
		replace(new ContentPanel(CONTENT_ID));
	}
}

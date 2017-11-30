package com.jbohn.wicket;

import lombok.Getter;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;

import com.jbohn.auth.Roles;


public class TemplatePage extends WebPage {
	private static final long serialVersionUID = 5218374612129395403L;
	public static final String CONTENT_ID = "contentComponent";

	@Getter
	private String selectedRole = Roles.ROLE_1_ADMIN_KEY;

	protected  WebMarkupContainer webMarkupContainer;

	public TemplatePage() {

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new HeaderPanel("headerPanel"){
			@Override
			public void onChange(AjaxRequestTarget target, String role) {
				super.onChange(target, role);
				selectedRole = role;
				onRoleChange(target, role);
				target.add(TemplatePage.this);
			}
		});
		webMarkupContainer = new WebMarkupContainer("contentComponentContainer") {
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupPlaceholderTag(true);
				add(new EmptyPanel(CONTENT_ID));
			}
		};
		add(webMarkupContainer);

		add(new FooterPanel("footerPanel"));
	}

	public void onRoleChange(AjaxRequestTarget target, String role){

	}

	protected void replaceContentPanel(Component panel){
		webMarkupContainer.replace(panel);
	}

	protected void replaceContentPanel(Component panel, AjaxRequestTarget target){
		webMarkupContainer.replace(panel);
		target.add(webMarkupContainer);
	}

}

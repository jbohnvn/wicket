package com.jbohn.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;

import com.jbohn.auth.Roles;
import com.jbohn.wicket.common.ContentPanelEnum;
import com.jbohn.wicket.dashboard.DashboardReportPanel;
import com.jbohn.wicket.report.ReportDialog;

public class HomePage extends TemplatePage {

	private ReportDialog reportDialog;

	private Component content;

	public HomePage() {
		super();
	}


	@Override
	protected void onInitialize() {
		super.onInitialize();
		content = new HomeContentPanel(CONTENT_ID);
		replaceContentPanel(content);


		add(createMenuLink("homePage", null, ContentPanelEnum.HOME));

		add(createMenuLink("openChartDashboardPanel", Roles.ROLE_1_ADMIN_KEY, ContentPanelEnum.DASHBOARD));
		add(createMenuLink("link2", Roles.ROLE_2_ADMIN_KEY, ContentPanelEnum.DASHBOARD));
		add(createMenuLink("link3", Roles.ROLE_1_ADMIN_KEY, ContentPanelEnum.DASHBOARD));

		addLookupDialog();
		add(createReportLink("openReportDialogButton"));
		add(createProcessLink("openProcessDialogButton"));
	}


	@Override
	protected void onConfigure() {
		super.onConfigure();
		reportDialog.show(false);
	}

	private void addLookupDialog() {
		reportDialog = new ReportDialog("reportDialog");
		reportDialog.show(false);
		reportDialog.addCloseButton();
		add(reportDialog);
	}

	private Component createProcessLink(String id) {
		return new AjaxLink<Void>(id) {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
			}
		};
	}

	private Component createReportLink(String id) {

		return new AjaxLink<Void>(id) {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				reportDialog.show(true);
				ajaxRequestTarget.add(reportDialog);
			}
		};
	}

	private AjaxLink<Void> createMenuLink(String id, String role, ContentPanelEnum contentPanelEnum) {
		return new AjaxLink<Void>(id) {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				switch (contentPanelEnum) {
					case DASHBOARD:
						content = new DashboardReportPanel(CONTENT_ID);
						break;
					case HOME:
						content = new HomeContentPanel(CONTENT_ID);
						break;
				}
				replaceContentPanel(content, ajaxRequestTarget);
			}

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(role == null || getSelectedRole().equals(role));
			}
		};

	}

	@Override
	public void onRoleChange(AjaxRequestTarget target, String role) {
		super.onRoleChange(target, role);
		content = new HomeContentPanel(CONTENT_ID);
		replaceContentPanel(content, target);
	}
}

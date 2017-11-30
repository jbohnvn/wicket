package com.jbohn.wicket.dashboard;

import org.apache.wicket.markup.html.panel.Panel;

public class DashboardReportPanel extends Panel {
	public DashboardReportPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setOutputMarkupId(true);
	}
}

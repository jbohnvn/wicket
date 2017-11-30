package com.jbohn.wicket.report;

import org.apache.wicket.markup.html.panel.Panel;

class ReportDetailPanel extends Panel
{

	public ReportDetailPanel(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setOutputMarkupId(true);
	}
}
package com.jbohn.wicket.report;

import org.apache.wicket.markup.html.panel.Panel;

class ReportSubmitPanel extends Panel
{

	public ReportSubmitPanel(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setOutputMarkupId(true);
	}
}
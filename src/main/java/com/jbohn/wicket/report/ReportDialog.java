package com.jbohn.wicket.report;

import de.agilecoders.wicket.core.markup.html.bootstrap.dialog.Modal;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;

public class ReportDialog extends Modal<Void>{

	private Component reportTabPanel;
	public ReportDialog(String markupId) {
		super(markupId);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		reportTabPanel = new ReportSubmitPanel("reportTabPanel");
		add(reportTabPanel);

		add(new AjaxLink<Void>("submit") {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				reportTabPanel = new ReportSubmitPanel("reportTabPanel");
				ReportDialog.this.replace(reportTabPanel);
				ajaxRequestTarget.add(reportTabPanel);
			}
		});

		add(new AjaxLink<Void>("detail") {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				reportTabPanel = new ReportDetailPanel("reportTabPanel");
				ReportDialog.this.replace(reportTabPanel);
				ajaxRequestTarget.add(reportTabPanel);
			}
		});
	}
}

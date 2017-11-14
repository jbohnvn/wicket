package com.jbohn.wicket.lookup;

import de.agilecoders.wicket.core.markup.html.bootstrap.dialog.Modal;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import com.jbohn.model.CountryLookupModel;

public class SimpleLookupDialog extends Modal<CountryLookupModel> {

	public SimpleLookupDialog(String id, IModel model) {
		super(id, model);

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setFooterVisible(true);
		add(new SimpleLookupTable("simpleLookupTable", getDefaultModel()));
	}

	@Override
	protected Component createHeaderLabel(String id, String label) {
		return super.createHeaderLabel("header-label", "Lookup Dialog");
	}
}

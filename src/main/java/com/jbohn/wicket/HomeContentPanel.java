package com.jbohn.wicket;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.jbohn.model.Country;
import com.jbohn.model.CountryLookupModel;
import com.jbohn.wicket.lookup.SimpleLookupDialog;

public class HomeContentPanel extends Panel {

	private SimpleLookupDialog lookupModal;

	HomeContentPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		setOutputMarkupId(true);
//		addLookupDialog();
//		add(createOpenLookupButton("openLookup"));
//		add(createCreateLeadBtn("openCreateLeadBtn"));
//		add(createOpenLeadDetailBtn("openLeadDetail"));
	}

	private void addLookupDialog() {
		CompoundPropertyModel<CountryLookupModel> lookupModel = new CompoundPropertyModel<>(dummyLookupModel());
		lookupModal = new SimpleLookupDialog("lookupModal", lookupModel);
		lookupModal.show(false);
		lookupModal.addCloseButton();
		add(lookupModal);
	}

	private AjaxLink<Void> createOpenLookupButton(String id) {
		return new AjaxLink<Void>(id) {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				lookupModal.show(true);
				ajaxRequestTarget.add(lookupModal);
			}
		};
	}

	private AjaxLink<Void> createOpenLeadDetailBtn(String openLeadDetail) {
		return new AjaxLink<Void>(openLeadDetail) {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {

			}
		};
	}

	private AjaxLink<Void> createCreateLeadBtn(String openLeadDetail) {
		return new AjaxLink<Void>(openLeadDetail) {
			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {

			}
		};
	}

	private CountryLookupModel dummyLookupModel() {
		List<Country> countries = getCountries();
		CountryLookupModel model = new CountryLookupModel();
		model.setLookups(countries);
		return model;
	}

	private List<Country> getCountries() {
		List<Country> list = new ArrayList<>();
		list.add(new Country(1L, "Vietnam"));
		list.add(new Country(2L, "India"));
		return list;
	}
}

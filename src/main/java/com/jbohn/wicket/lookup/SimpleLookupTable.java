package com.jbohn.wicket.lookup;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.jbohn.model.Country;
import com.jbohn.model.CountryLookupModel;

public class SimpleLookupTable extends Panel {

	public SimpleLookupTable(String id, IModel model) {
		super(id, model);

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(createLookupContainer(getDefaultModel()));
	}

	private MarkupContainer createLookupContainer(IModel model) {
		return new MarkupContainer("dataViewContainer", model) {

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupPlaceholderTag(true);
				CountryLookupModel defaultModelObject = (CountryLookupModel) this.getDefaultModelObject();
				add(createLookupView(defaultModelObject.getLookups(), this));
			}

		};
	}

	private DataView<Country> createLookupView(List<Country> countries, MarkupContainer parent) {
		return new DataView<Country>("dataView", new ListDataProvider<>(countries)) {
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}

			@Override
			protected void populateItem(Item<Country> item) {
				Country defaultModelObject = (Country) item.getDefaultModelObject();
				item.add(new TextField<>("code", new PropertyModel<Long>(defaultModelObject, "code")));
				item.add(new TextField<>("name", new PropertyModel<String>(defaultModelObject, "name")));
				item.add(new AjaxLink<Void>("addRowButton") {
					@Override
					public void onClick(AjaxRequestTarget ajaxRequestTarget) {
						countries.add(item.getIndex() + 1, new Country(0L, ""));
						ajaxRequestTarget.add(parent);
					}
				});
				item.add(new AjaxLink<Void>("removeRowButton") {
					@Override
					public void onClick(AjaxRequestTarget ajaxRequestTarget) {
						countries.remove(item.getIndex());
						ajaxRequestTarget.add(parent);
					}
				});
			}
		};
	}
}

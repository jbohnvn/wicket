package com.jbohn;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;

import org.apache.wicket.protocol.http.WebApplication;

import com.jbohn.wicket.HomePage;

public class WicketApplication extends WebApplication {

	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class; // return default page
	}
	
	@Override
	protected void init() {
		super.init();
		BootstrapSettings settings = new BootstrapSettings();
		Bootstrap.install(this, settings);
	}

}

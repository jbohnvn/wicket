package com.jbohn.wicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.ButtonList;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.DropDownButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuDivider;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuHeader;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarAjaxLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarDropDownButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarText;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.ITheme;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.jbohn.auth.Roles;
import com.jbohn.model.RoleDto;

public class HeaderPanel extends Panel {

	private List<RoleDto> roles = getRoleDtos();

	private List<RoleDto> getRoleDtos() {
		RoleDto role1 = new RoleDto();
		role1.setRoleKey(Roles.ROLE_1_ADMIN_KEY);
		RoleDto role2 = new RoleDto();
		role2.setRoleKey(Roles.ROLE_2_ADMIN_KEY);
		return Arrays.asList(role1, role2);
	}

	private RoleDto selectedRole = new RoleDto();

	public HeaderPanel(String id) {
		super(id);
		selectedRole.setRoleKey(Roles.ROLE_1_ADMIN_KEY);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(newNavbar("navbar"));

	}

	protected Navbar newNavbar(String markupId) {
		Navbar navbar = new Navbar(markupId);
		navbar.setBrandName(Model.of("Wicket"));
		navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT,
				newAddonsDropDownButton())
		);
		return navbar;
	}


	private Component newAddonsDropDownButton() {
		return new NavbarDropDownButton(Model.of("Roles")) {
			@Override
			public boolean isActive(Component item) {
				return false;
			}

			@Override
			protected List<AbstractLink> newSubMenuButtons(final String buttonMarkupId) {
				final List<AbstractLink> subMenu = new ArrayList<>();
				for (final RoleDto role : roles) {
					subMenu.add(new NavbarAjaxLink<Void>(ButtonList.getButtonMarkupId(), Model.of(role.getRoleKey())) {
						@Override
						public void onClick(AjaxRequestTarget ajaxRequestTarget) {
							onChange(ajaxRequestTarget, role.getRoleKey());
						}
					});
				}

				return subMenu;
			}
		}.setIconType(GlyphIconType.book);

	}

	public void onChange(AjaxRequestTarget target, String role){

	}

}

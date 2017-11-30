package com.jbohn.auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RolePermissionMap {
	private static final Map<String, List<String>> role2PermissionMap = new HashMap<>();
	private static final List<String> ROLE_1_PERMISSION = Arrays.asList("Menu_1", "Menu_2");
	private static final List<String> ROLE_2_PERMISSION = Arrays.asList("Menu_1");

	static {
		role2PermissionMap.put(Roles.ROLE_1_ADMIN_KEY, ROLE_1_PERMISSION);
		role2PermissionMap.put(Roles.ROLE_2_ADMIN_KEY, ROLE_2_PERMISSION);
	}

	public static List<String> getPermissionListForRole(final String key) {
		return role2PermissionMap.get(key);
	}

	public static Set<String> getPermissionSetForRole(final String key) {
		return new HashSet<>(role2PermissionMap.get(key));
	}
}

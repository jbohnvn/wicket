package com.jbohn.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.jbohn.auth.RolePermissionMap;

@Getter
@Setter
public class RoleDto implements Serializable {

	private static final long serialVersionUID = 857137104259626835L;

	private String roleKey;

	private Set<String> permissions;

	public RoleDto() {
		super();
		this.roleKey = "";
		this.permissions = new HashSet<>();
	}

	public RoleDto(final String key) {
		super();
		this.roleKey = key;
		this.permissions = RolePermissionMap.getPermissionSetForRole(key);
	}

	public boolean hasPermission(final String permission) {
		return RolePermissionMap.getPermissionListForRole(roleKey).contains(permission);
	}
}

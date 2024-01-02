package com.users.userservice.service;

import java.util.List;
import java.util.Optional;

import com.users.userservice.dto.RoleDto;
import com.users.userservice.entity.Role;

public interface RoleService {
	public int addRole(RoleDto roleDto);
	public Optional<RoleDto> fetchRoleByName(String rolename);
	public List<Role> fetchAllRole();
}

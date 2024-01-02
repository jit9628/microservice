package com.users.userservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.userservice.dto.RoleDto;
import com.users.userservice.entity.Role;
import com.users.userservice.repository.RoleRepository;
import com.users.userservice.service.RoleService;

@Service
public class RoleServiceImplementation implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public int addRole(RoleDto roleDto) {

		return (this.roleRepository.existsByRolename(roleDto.getRolename())) ? -1
				: (this.roleRepository.save(this.mapper.map(roleDto, Role.class)) instanceof Role) ? 1 : 0;

	}

	@Override
	public Optional<RoleDto> fetchRoleByName(String rolename) {
		// TODO Auto-generated method stub
		
		return Optional.empty();
	}

	@Override
	public List<Role> fetchAllRole() {
		// TODO Auto-generated method stub
		List<Role> findAll = this.roleRepository.findAll();
		
		return findAll;
	}

}

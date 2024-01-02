package com.users.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.userservice.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	boolean existsByRolename(String rolename);
	

}

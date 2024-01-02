package com.users.userservice.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.userservice.dto.RoleDto;
import com.users.userservice.entity.Role;
import com.users.userservice.service.RoleService;
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@PostMapping("/addrole")
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto) {
		int addRole = this.roleService.addRole(roleDto);
		return (this.roleService.addRole(roleDto) == 1)
				? new ResponseEntity<>(Map.of("success", true, "status", "SUCCESS", "message", "Role Added",
						"statusCode", 200, "data", addRole), HttpStatus.OK)
				: (this.roleService.addRole(roleDto) == -1) ?
						new ResponseEntity<>(Map.of("success", false, "status", "FAILLED", "message", "Role Exists ",
								"statusCode", 409, "data", addRole), HttpStatus.CONFLICT)
						: new ResponseEntity<>(Map.of("Failed", false, "status", "FAILLED", "message",
								"INTERNAL SERVER ERROR ", "statusCode", 500, "data", addRole), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@GetMapping("/fetchAll")
	public ResponseEntity<?> findAllRole(){
		List<Role> fetchAllRole = this.roleService.fetchAllRole();
	return	new ResponseEntity<>(Map.of("success", true, "status", "SUCCESS", 
				"statusCode", 200, "data", fetchAllRole), HttpStatus.OK);
	}
}

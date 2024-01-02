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

import com.users.userservice.entity.UserLogin;
import com.users.userservice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getalluser")
    public ResponseEntity<?> getAllUsers() {
    	
        try {
            List<UserLogin> users = userService.findAll();
            if (users.isEmpty()) {
                return new ResponseEntity<>(Map.of("success", true, "message", "User not found", "status",
                        "NOTFOUND", "statusCode", 404), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(Map.of("success", true, "status", "SUCCESS", "message",
                        "User list", "statusCode", 200, "data", users),
                        HttpStatus.OK);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("success", false, "status", "message", e.getMessage(),
                    "INTERNAL_SERVER_ERROR", "statusCode", 501), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserLogin userLogin){
    	int register = this.userService.register(userLogin);
    	  return new ResponseEntity<>(Map.of("success", true, "status", "SUCCESS", "message",
    			  register, "statusCode", 200, "data", "Users"),
                  HttpStatus.OK);
    	
    }

    
}

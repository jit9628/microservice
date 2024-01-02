package com.users.userservice.service;

import java.util.List;

import com.users.userservice.entity.UserLogin;

public interface UserService {

    public int register(UserLogin userLogin);
    public UserLogin findByUserName(String username);
    public List<UserLogin> findAll();


}

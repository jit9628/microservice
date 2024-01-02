package com.example.createuser.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.createuser.entity.UserLogin;
import com.example.createuser.repostery.UserRepo;
import com.example.createuser.service.UserService;
import com.example.createuser.utility.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
    //private UserRepository userRepository;
    private UserRepo userRepo;
    
    @Autowired
    public void setUserRepository(UserRepo userRepo) {
              this.userRepo =userRepo;
    }

    @Override
    public int register(UserLogin userLogin) {
System.out.println("User Service Executed ... ");
        userLogin.setPassword(PasswordEncoder.hashPassword(userLogin.getPassword()));
         this.userRepo.save(userLogin);
         return 1;
       // return userRepository.register(userLogin);
        
    }

    @Override
    public UserLogin findByUserName(String username) {
       // return userRepository.findByUserName(username);
    	return this.userRepo.findByUsername(username);
    
    	
    }

    @Override
    public List<UserLogin> findAll() {

     //   return userRepository.findAll();
    	return null;
    }


}

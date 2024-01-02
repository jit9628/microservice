package com.users.userservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.users.userservice.entity.UserLogin;
@Repository
public interface UserRepo extends JpaRepository<UserLogin, Integer>{
	UserLogin findByUsername(String username);
	boolean existsByUsername(String username);
	//public UserLogin findByUserName(String username);
}

package com.users.userservice.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.users.userservice.entity.UserLogin;
import com.users.userservice.service.UserService;
import com.users.userservice.util.JwtUtility;
import com.users.userservice.util.PasswordEncoder;
@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = {"http://127.0.0.1:5500","http://192.168.1.31:5500","*"},originPatterns ={"http://127.0.0.1:5500","http://192.168.1.31:5500","*"})
@CrossOrigin(origins = "*")
public class AuthicationController {
 @Autowired
    private UserService userService;
@PostMapping (value="/register",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.ALL_VALUE,MediaType.TEXT_PLAIN_VALUE})
//@CrossOrigin(origins = {"http://127.0.0.1:5500","http://192.168.1.31:5500","*"},originPatterns ={"http://127.0.0.1:5500","http://192.168.1.31:5500","*"})
 public ResponseEntity<?>register(@ModelAttribute UserLogin userLogin)
 {
     try {
         UserLogin exitingUser = userService.findByUserName(userLogin.getUsername());
         if(exitingUser!=null)
         {
             return new ResponseEntity<>(Map.of("success", false, "status", "message", "User already register",
                     "CONFLICT", "statusCode", 409), HttpStatus.CONFLICT);
         }
         else
         {
             userService.register(userLogin);
             return new ResponseEntity<>(Map.of("success", true, "status", "CREATED", "message",
                     "User has been register successfully", "statusCode", 201),
                     HttpStatus.CREATED);

         }
     }
     catch (Exception e)
     {
         return new ResponseEntity<>(Map.of("success", false, "status", "message",e.getMessage(),
                 "INTERNAL_SERVER_ERROR", "statusCode", 501), HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }

    @PostMapping ("/login")
   // @CrossOrigin(origins = {"http://127.0.0.1:5500","http://192.168.1.31:5500"},originPatterns ={"http://127.0.0.1:5500","http://192.168.1.31:5500"})

    public ResponseEntity<?>login(@RequestBody UserLogin userLogin)
    {
        try {
        	// existing user 
            UserLogin exitingUser = userService.findByUserName(userLogin.getUsername());
            if(exitingUser!=null)
            {
                if (PasswordEncoder.isMatchPassword(userLogin.getPassword(), exitingUser.getPassword())) {
                    String token = JwtUtility.createToken(exitingUser);

                    return new ResponseEntity<>(Map.of("success", true, "status", "OK", "statusCode", 200, "message",
                            "User has been login successfully", "token", token), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(Map.of("success", false, "status", "FORBIDDEN", "statusCode", 401,
                            "message", "Password does not match!!"), HttpStatus.FORBIDDEN);
                }
            }
            else
            {
                return new ResponseEntity<>(Map.of("success", false, "status", "NOT_FOUND", "statusCode", 404,
                        "message", "User Not Found!!"), HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(Map.of("success", false, "status", "message",e.getMessage(),
                    "INTERNAL_SERVER_ERROR", "statusCode", 501), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
    @GetMapping("/admin")
    public ResponseEntity<?> adminPannerl(){
    	  return new ResponseEntity<>(Map.of("success", false, "status","200","message","You Have Access This Pannel ."
                  , "statusCode", 501), HttpStatus.OK);
    }
}

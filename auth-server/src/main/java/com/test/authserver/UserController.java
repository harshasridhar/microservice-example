package com.test.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder bcryptEncoder;
//    @Autowired
    private BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    @GetMapping("/auth/register")
    public String test(){
        return "test string";
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> re(@RequestBody UserEntity userEntity){
        String password = bcryptEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        return ResponseEntity.ok(userRepository.save(userEntity));
    }

//    @Bean
//    private BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }
}

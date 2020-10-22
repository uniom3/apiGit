package com.example.mendonca.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.mendonca.entity.User;
import com.example.mendonca.web.dto.UserRegistrationDto;

 

public interface UserService extends UserDetailsService {	
	

    User findByEmail(String email);

   
    User save(UserRegistrationDto registration);
}
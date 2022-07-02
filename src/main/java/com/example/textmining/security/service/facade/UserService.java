package com.example.textmining.security.service.facade;


import com.example.textmining.security.bean.User;
import com.example.textmining.security.jwt.JwtResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUsername(String email);

    User save(User user);

    List<User> findAll();

    //    sign Up user
    JwtResponse signIn(User user);
}

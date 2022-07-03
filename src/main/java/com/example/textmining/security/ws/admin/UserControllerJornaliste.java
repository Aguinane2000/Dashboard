package com.example.textmining.security.ws.admin;


import com.example.textmining.security.bean.User;
import com.example.textmining.security.jwt.JwtResponse;
import com.example.textmining.security.service.facade.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userControllerAdmin")
@RequestMapping("/api/v1/admin/user")
public class UserControllerJornaliste {

    @PostMapping("/")
    public User save(@RequestBody User user) {

        return userService.save(user);
    }

    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody User user) {
        return userService.signIn(user);
    }





    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }


    private UserService userService;
    public UserControllerJornaliste(UserService userService) {
        this.userService = userService;
    }
}
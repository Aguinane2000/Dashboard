package com.example.textmining.security.service.impl;

import com.example.textmining.security.bean.Role;
import com.example.textmining.security.bean.User;
import com.example.textmining.security.dao.UserDao;
import com.example.textmining.security.jwt.JwtResponse;
import com.example.textmining.security.jwt.JwtUtil;
import com.example.textmining.security.service.facade.RoleService;
import com.example.textmining.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public JwtResponse signIn(User user) {
        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User loadUserByUsername = loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(loadUserByUsername);
        JwtResponse response = new JwtResponse(token);
        return response;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

       @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    @Override
    public User save(User user) {
        User loadedUser = userDao.findByUsername(user.getUsername());
        Role role = roleService.findByAuthority("ROLE_JOURNALISTE");
        Collection<Role> roles = new ArrayList<>();
        roles.add(role);
        if (loadedUser != null)
            return null;
        else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAuthorities(roles);
            userDao.save(user);
            return user;
        }
    }

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

}

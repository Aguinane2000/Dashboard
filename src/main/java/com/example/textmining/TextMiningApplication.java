package com.example.textmining;

import com.example.textmining.security.bean.Role;
import com.example.textmining.security.bean.User;
import com.example.textmining.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TextMiningApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextMiningApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        if(true){
//            User jr = new User("LE MATIN","matin");
//            jr.setAuthorities(Arrays.asList(new Role("ROLE_JOURNALISTE")));
//            userService.save(jr);
//            User jr1 = new User("Brahim MOKHLISS","mokhliss");
//            jr1.setAuthorities(Arrays.asList(new Role("ROLE_JOURNALISTE")));
//            userService.save(jr1);
//
//        }
//    }
    @Autowired
    private UserService userService ;
}

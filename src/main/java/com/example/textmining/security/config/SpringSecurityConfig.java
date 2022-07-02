package com.example.textmining.security.config;


import com.example.textmining.security.jwt.JwtAuthenticationFilter;
import com.example.textmining.security.jwt.JwtAutorisationFilter;
import com.example.textmining.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/v1/api/authentification/").permitAll()
                .antMatchers("/api/v1/admin/user/sign-in").permitAll()
                .antMatchers("/api/v1/article/titre/**").hasAnyAuthority("ROLE_JOURNALISTE")
                .antMatchers("/api/v1/article/calculer-pourcentage-signe").permitAll()
                .antMatchers("/api/v1/article/**").permitAll()
                .antMatchers("/api/v1/motcle/**").permitAll()
                .antMatchers("/api/v1/motcleitem/**").permitAll()
                .antMatchers("/api/v1/paragraphe/**").permitAll()
                .antMatchers("/api/v1/frequence/findbymotclelibelleandarticletitre/**").permitAll()
                .antMatchers("/api/v1/frequence/**").permitAll()
                .antMatchers("/api/v1/admin/user/**").permitAll()
                .antMatchers("/api/v1/admin/user/**/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/v1/api/chef/**").permitAll()
                .anyRequest().authenticated();

        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(jwtAutorisationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserService userService;
    @Autowired
    private JwtAutorisationFilter jwtAutorisationFilter;

    private final String[] PUBLIC_ENDPOINTS = {

    };
    private final String[] journaliste = {
            "/api/v1/admin/**",

    };
    private final String[] adherent = {
            "/api/v1/adherent/**"
    };
}

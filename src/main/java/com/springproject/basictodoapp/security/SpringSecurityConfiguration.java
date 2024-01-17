package com.springproject.basictodoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    //in memory user details manager


    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        UserDetails userAbrar = createUser("Abrar", "dummy");
        UserDetails userRifat = createUser("Rifat", "dummy_two");
        return new InMemoryUserDetailsManager(userAbrar,userRifat);
    }

    private UserDetails createUser(String userName, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails =
                User.builder()
                        .passwordEncoder(passwordEncoder)
                        .username(userName)
                        .password(password)
                        .roles("USER","ADMIN")
                        .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());
        //httpSecurity.headers(Customizer.withDefaults());
        httpSecurity.headers((headers) ->
                headers.frameOptions((frameOptions) -> frameOptions.disable())
        );

        return httpSecurity.build();
    }


}

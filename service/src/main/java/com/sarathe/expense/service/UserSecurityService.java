package com.sarathe.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("siddharth")){
            return User.withUsername("siddharth")
                    .password(passwordEncoder.encode("sid"))
                    .accountExpired(false)
                    .accountLocked(false)
                    .disabled(false)
                    .authorities("ROLE_ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("User not found --- " + username);
    }
}

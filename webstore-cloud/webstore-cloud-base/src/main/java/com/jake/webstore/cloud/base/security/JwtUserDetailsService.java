package com.jake.webstore.cloud.base.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        /*
          TODO
          1. create a custom UserDetails
          2. decode jwt token
          3. get authorities
          4. validation
         */
        return User.withUsername("test").password(token).authorities(token).build();
    }
}

package com.paglima.auth.configuration.security.provider;

import com.paglima.auth.domain.exception.UnauthenticatedException;
import com.paglima.auth.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class LocalAuthenticationProvider implements AuthenticationProvider {

    private static final String ROLE_PREFIX = "ROLE_";
    private static final List<User> authDataBase = userDataBase();

    @Override
    public Authentication authenticate(Authentication authentication) {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> userOptional = authDataBase.stream().filter(u -> u.getUsername().equals(name) && u.getPassword().equals(password)).findFirst();

        if(!userOptional.isPresent()) {
            throw new BadCredentialsException("Nao foi possivel autenticar 401!");
        }

        User user = userOptional.get();
        Set<GrantedAuthority> authorities = user.getRoles().stream().map(r -> new SimpleGrantedAuthority(ROLE_PREFIX + r)).collect(Collectors.toSet());

        return new UsernamePasswordAuthenticationToken(name, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private static List<User> userDataBase() {
        User user1 = User.builder().userId(1).username("paulo.lima").password("paulo.lima.123").email("paulo.lima@anydomain.com").roles(Collections.singletonList("ADMIN")).build();
        User user2 = User.builder().userId(1).username("paula.santo").password("paula.santo.123").email("paula.santo@anydomain.com").roles(Collections.singletonList("USER")).build();
        return Arrays.asList(user1, user2);
    }

    public static void main(String[] args) {
    }
}

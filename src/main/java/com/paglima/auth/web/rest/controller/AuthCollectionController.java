package com.paglima.auth.web.rest.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.paglima.auth.web.rest.model.response.TokenDto;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(AuthCollectionController.ENDPOINT)
public class AuthCollectionController {

    public static final String ENDPOINT = "/token";

//    @ResponseStatus(HttpStatus.CREATED)
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public TokenDto create() throws Exception {
//        return TokenDto.builder().build();
//    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public TokenDto get() throws Exception {
        return generateToken();
    }

    private TokenDto generateToken() throws UnsupportedEncodingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Map<String, String> data = new HashMap<>();
        data.put("username", name);

        Date expiresAt = new DateTime().plusMinutes(15).toDate();
        com.auth0.jwt.JWTCreator.Builder builder = JWT.create().withExpiresAt(expiresAt);
        for(Map.Entry<String, String> entry : data.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

            builder = builder.withClaim(key, value);
        }

        return TokenDto.builder().expiresAt(expiresAt).token(builder.sign(Algorithm.HMAC256("paglima"))).build();
    }
}

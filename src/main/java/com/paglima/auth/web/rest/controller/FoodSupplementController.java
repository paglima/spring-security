package com.paglima.auth.web.rest.controller;

import com.paglima.auth.web.rest.model.request.FoodSupplementRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(FoodSupplementController.ENDPOINT)
public class FoodSupplementController {

    public static final String ENDPOINT = "/food-sup";

    private static final String TOKEN_HEADER_PARAM = "X-Pricing-Token";
    private static final String AUTHENTICATED = "isAuthenticated()";

    private static final String POST_INFO_MESSAGE = "Recebida requisicao para criar token para o usuario [:username].";

    @Autowired
    public FoodSupplementController() {
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String create(FoodSupplementRequest request) throws Exception {
        return "OK";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public FoodSupplementRequest get(@PathVariable String sku) throws Exception {
        return FoodSupplementRequest.builder().sku("12345").carbohydrate(10D).protein(30D).fat(1D).build();
    }
}

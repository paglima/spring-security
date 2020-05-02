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

    @Autowired
    public FoodSupplementController() {
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public String create(FoodSupplementRequest request) throws Exception {
        return "OK";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{sku}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FoodSupplementRequest get(@PathVariable String sku) throws Exception {
        return FoodSupplementRequest.builder().sku("12345").carbohydrate(10D).protein(30D).fat(1D).build();
    }
}

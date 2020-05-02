package com.paglima.auth.web.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
@Order(-600)
public class AuthControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AccessDeniedException.class })
    public void handleAccessDeniedException(Exception exc, HttpServletResponse response) {
        //response.setStatus(401);
    }

}

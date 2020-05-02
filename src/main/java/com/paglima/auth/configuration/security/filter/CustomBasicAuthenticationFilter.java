package com.paglima.auth.configuration.security.filter;

import com.paglima.auth.web.rest.controller.AuthCollectionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {

    public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        /*if (request.getMethod().equals(HttpMethod.POST.toString()) &&
                request.getRequestURI().equals(AuthCollectionController.ENDPOINT)) {
            super.doFilterInternal(request, response, chain);
        } else {
            chain.doFilter(request, response);
        }*/

        super.doFilterInternal(request, response, chain);
    }

}

package com.bpag.apigateway.security.filters;

import com.bpag.apigateway.security.credentials.AuthenticationCredential;
import com.bpag.apigateway.security.credentials.CredentialDetailsImpl;
import com.bpag.apigateway.utilities.GatewayTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class CredentialAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        AuthenticationCredential authCredentials = new AuthenticationCredential();
        try{
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthenticationCredential.class);
        }catch (Exception ignored){}
        UsernamePasswordAuthenticationToken userNamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );
        return getAuthenticationManager().authenticate(userNamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        CredentialDetailsImpl userDetails = (CredentialDetailsImpl) authResult.getPrincipal();
        String token = GatewayTokenUtil.createToken(userDetails.getName(), userDetails.getUsername());

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
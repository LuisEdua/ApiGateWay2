package com.bpag.apigateway.security.credentials;

import com.bpag.apigateway.persistances.entities.Credential;
import com.bpag.apigateway.services.interfaces.ICredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CredentialDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ICredentialService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = service.getToken(username);
        return new CredentialDetailsImpl(credential);
    }

}
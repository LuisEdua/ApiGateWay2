package com.bpag.apigateway.services;

import com.bpag.apigateway.persistances.entities.Credential;
import com.bpag.apigateway.persistances.repositories.ICredentialRepository;
import com.bpag.apigateway.services.interfaces.ICredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class CredentialServiceImpl {//implements ICredentialService {

    /*@Autowired
    private ICredentialRepository repository;

    @Override
    public Credential getToken() {
        Credential credential = repository.findAll().stream().findFirst().orElseThrow(RuntimeException::new);
        Credential credential1 = repository.findByCredentialEmail(credential.getCredentialEmail()).orElseThrow(RuntimeException::new);
        return credential1;
    }*/

}
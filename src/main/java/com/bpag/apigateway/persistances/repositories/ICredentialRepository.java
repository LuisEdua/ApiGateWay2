package com.bpag.apigateway.persistances.repositories;

import com.bpag.apigateway.persistances.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface ICredentialRepository {//extends JpaRepository<Credential, Long>{
   // Optional<Credential> findByCredentialEmail(String email);
}
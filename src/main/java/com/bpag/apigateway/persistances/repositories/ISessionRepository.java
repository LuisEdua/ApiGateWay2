package com.bpag.apigateway.persistances.repositories;

import com.bpag.apigateway.persistances.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends JpaRepository<Session, Long> { }
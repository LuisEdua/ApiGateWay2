package com.bpag.apigateway.persistances.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credetentials")
@Getter @Setter
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String credentialName;

    @Column(unique = true, nullable = false, length = 100)
    private String credentialEmail;

    @Column(unique = true, nullable = false, length = 100)
    private String credentialPassword;

}
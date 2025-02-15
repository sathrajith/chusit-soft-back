package com.example.sft.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_providers")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Email
    @NotBlank
    private String email;

    // Constructors
    public ServiceProvider() {}

    public ServiceProvider(String email){
        this.email=email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }



    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


}

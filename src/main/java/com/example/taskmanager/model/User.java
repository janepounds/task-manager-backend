package com.example.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    
    private String role = "USER"; // default role

    // Getters and setters

     public Long getId() {
         return id;
     }

     public String getUsername() {
         return username;
     }

     public String getPassword() {
         return password;
     }

     public void setUsername(String username){
        this.username = username;
     }
     public void setPassword(String password) {
         this.password = password;
     }

     public String getRole() {
         return role;
     }

     public void setRole(String role) {
         this.role = role;
     }
}

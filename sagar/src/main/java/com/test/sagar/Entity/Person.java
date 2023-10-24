package com.test.sagar.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.Email;
// import jakarta.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
        
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z]+\\.com$", message = "Please provide a valid email address")
    private String email;

    // Constructors, getters, and setters
}

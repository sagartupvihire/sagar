package com.test.sagar.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    private String internship;
        
    @NotEmpty(message = "Email is required")
    // @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com$", message = "Invalid Gmail email format")
    @Size(min = 10,max = 25, message = "invalid Email")
    private String email;

}

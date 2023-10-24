package com.test.sagar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.sagar.Entity.*;
import com.test.sagar.PersonRepo.PersonRepository;

@Controller
public class PersonController { 
    @Autowired
    private PersonRepository personRepository;
       
    @GetMapping("/")
    public String showPersonForm() {
        // model.addAttribute("person", new Person());
        System.out.println("inside");
        return "addData";
    }

    @PostMapping("/savePerson")
    public String savePerson(@Valid  @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Invalid email address. Please provide a valid email.");
            return "addData"; // Return to the form with validation errors
        }
        personRepository.save(person);
        model.addAttribute("message", "Data saved successfully!"); 

        // return "redirect:/error";
        return "addData";
    }

    
}

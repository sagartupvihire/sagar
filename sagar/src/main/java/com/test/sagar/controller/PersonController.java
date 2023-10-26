package com.test.sagar.controller;

import javax.management.StringValueExp;
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
    public String showPersonForm(Model model) {
        // model.addAttribute("person", new Person());
        System.out.println("inside");
        model.addAttribute("person", new Person());
        return "addData";
    }

    @PostMapping("/savePerson")
    public String savePerson(@Valid  @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        
        System.out.println("bindingResult" +bindingResult);
        if (bindingResult.hasErrors()) {
            
            model.addAttribute("error", "Invalid email address. Please provide a valid email.");
            System.out.println("email invalid");
            return "addData"; // Return to the form with validation errors
        }

        personRepository.save(person);
        model.addAttribute("message", "Data saved successfully!"); 

        // return "redirect:/error";
        return "addData";
    }


    
}

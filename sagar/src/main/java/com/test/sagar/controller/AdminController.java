package com.test.sagar.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.sagar.Entity.Person;
import com.test.sagar.PersonRepo.PersonRepository;

@Controller
public class AdminController {

    @Autowired
    private PersonRepository personRepository;
    
    // @GetMapping("/admin")
    // public String adminPanel(Model model) {
    //     System.out.println("inside admin panel  ");
    //     Iterable<Person> people = personRepository.findAll();
    //     model.addAttribute("people", people);
    //     return "form.html";
    // }

    @GetMapping("/admin/panel")
    public String adminPanel(Model model) {
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        System.out.println("Number of people retrieved: " + ((List<Person>) people).size());
        return "people";
    }

    @GetMapping("/search")
    public String searchPeople(@RequestParam("query") String query, Model model) {
        List<Person> allPeople = personRepository.findAll();
        List<Person> filteredPeople = allPeople.stream()
                .filter(person -> person.getName().contains(query) || person.getEmail().contains(query)  || person.getInternship().contains(query) || person.getMobile().contains(query) || String.valueOf(person.getId()).contains(query))
                .collect(Collectors.toList());
        model.addAttribute("people", filteredPeople);
        System.out.println("filteredPeople" +filteredPeople);
        return "people"; // Update with the name of your HTML template.
    }

}


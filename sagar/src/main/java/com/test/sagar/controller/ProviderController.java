package com.test.sagar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.sagar.Entity.Person;
import com.test.sagar.PersonRepo.PersonRepository;
@Controller
public class ProviderController {
    // Your other controller methods
    @Autowired
    PersonRepository personRepository;
    @GetMapping("/deleteProvider")
    @ResponseBody
    public String updateProvider(@ModelAttribute("people") List<Person> people) {
        // Implement the update logic here using the list of people
        // You can use a service or repository to update the data in the database
        return "update";
    }

     @PostMapping("/delete/{id}")
    public String deleteProvider(@PathVariable Long id) {
        // Perform the delete operation using your service
        personRepository.deleteById(id);
        
        return "redirect:/admin/panel"; // Redirect to the list of providers or the appropriate page
    }

    @GetMapping("/edit/{id}")
    public String editProvider(@PathVariable Long id, Model model) {
        // Retrieve the provider for editing from your service
        Optional<Person> person = personRepository.findById(id);
        
        // Add the provider to the model
        model.addAttribute("person", person);
        
        return "edit-provider"; // Redirect to the edit form or the appropriate page
    }

    @PostMapping("/update/{id}")
    public String updateProvider(@PathVariable Long id, @ModelAttribute Person updatedPerson) {
        // Perform the update operation using your service
      // Retrieve the existing person from the repository
      Person existingPerson = personRepository.findById(id).orElse(null);
        
      if (existingPerson == null) {
          // Handle the case when the person is not found
          // You can return an error page or handle it as needed
      }
      
      // Update the existing person's attributes with the updatedPerson's attributes
      existingPerson.setName(updatedPerson.getName());
      existingPerson.setMobile(updatedPerson.getMobile());
      existingPerson.setEmail(updatedPerson.getEmail());
      
      // Save the updated person back to the repository
      personRepository.save(existingPerson);

        return "redirect:/admin/panel"; // Redirect to the list of providers or the appropriate page
    }
}


package com.test.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.sagar.AdminRepo.AdminRepository;
import com.test.sagar.Entity.Admin;

@Controller 
public class AdminLoginController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "signUp";
    }
    
    
    
    @PostMapping("/admin/admin/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Admin admin = adminRepository.findByUsername(username);

        // if (admin != null && admin.getPassword().equals(password)) {
        //     // Admin is authenticated, redirect to admin panel
        //     System.out.println(admin.getUsername());

        //     return "redirect:/admin";
        // } else {
        //     // Authentication failed, show an error message
        //     model.addAttribute("error", "Invalid username or password.");
        //     return "admin";
        // }

        


        Admin admin = adminRepository.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            // Admin is authenticated, redirect to admin panel
            System.out.println("in admin login panel");
            System.out.println(admin);
            return "redirect:/admin/panel";
        } else {
            // Authentication failed
            model.addAttribute("error", "Invalid username or password.");

            // If the admin database is empty, display a specific error message
            if (adminRepository.count() == 0) {
                model.addAttribute("error", "No admin accounts exist.");
                
            }

            return "sigUp"; 
        }
    }
}


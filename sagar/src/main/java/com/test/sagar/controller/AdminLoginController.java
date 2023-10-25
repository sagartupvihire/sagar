package com.test.sagar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return "admin-login";
    }
    
    

    @PostMapping("/admin/admin/login")
    public String adminLogin(@Valid Admin admin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }

        Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());

        if (existingAdmin != null && existingAdmin.getPassword().equals(admin.getPassword())) {
            System.out.println("in admin login panel");
            System.out.println(existingAdmin);
            return "redirect:/admin/panel";
        } else {
            model.addAttribute("error", "Invalid username or password.");

            if (adminRepository.count() == 0) {
                model.addAttribute("error", "No admin accounts exist.");
            }

            return "signUp";
        }
    }
    
}       
//     @PostMapping("/admin/admin/login")
//     public String adminLogin(@Valid Admin admin1,@RequestParam String username,BindingResult bindingResult, @RequestParam String password, Model model) {
//         // Admin admin = adminRepository.findByUsername(username);

//         if (bindingResult.hasErrors()) {
//             // Validation errors occurred
//             System.out.println("error in email");
//             return "signUp";
//         }


//         Admin admin = adminRepository.findByUsername(username);

//         if (admin != null && admin.getPassword().equals(password)) {
//             // Admin is authenticated, redirect to admin panel
//             System.out.println("in admin login panel");
//             System.out.println(admin);
            
            
//             return "redirect:/admin/panel";
//         } else {
//             // Authentication failed
//             model.addAttribute("error", "Invalid username or password.");

//             // If the admin database is empty, display a specific error message
//             if (adminRepository.count() == 0) {
//                 model.addAttribute("error", "No admin accounts exist.");
                
//             }

//             return "sigUp"; 
//         }
//     }
// }



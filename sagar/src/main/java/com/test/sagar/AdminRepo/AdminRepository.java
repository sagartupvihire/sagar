package com.test.sagar.AdminRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sagar.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}


package com.test.sagar.PersonRepo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sagar.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {


}

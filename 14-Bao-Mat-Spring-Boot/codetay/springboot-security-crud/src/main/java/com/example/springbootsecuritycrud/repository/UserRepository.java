package com.example.springbootsecuritycrud.repository;

import com.example.springbootsecuritycrud.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}

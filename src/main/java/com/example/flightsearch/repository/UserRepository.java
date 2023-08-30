package com.example.flightsearch.repository;

import com.example.flightsearch.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Long> {
}


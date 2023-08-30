package com.example.flightsearch.repository;

import com.example.flightsearch.entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights,Long> {
}

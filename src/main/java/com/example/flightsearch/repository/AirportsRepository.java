package com.example.flightsearch.repository;

import com.example.flightsearch.entities.Airports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportsRepository extends JpaRepository<Airports,Long> {
}

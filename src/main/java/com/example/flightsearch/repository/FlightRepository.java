package com.example.flightsearch.repository;

import com.example.flightsearch.entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FlightRepository extends JpaRepository<Flights,Long> {
    Flights findByOriginAirport(String originAirport);

    void deleteByOriginAirport(String originAirport);
}

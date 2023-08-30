package com.example.flightsearch.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "flights")
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String originAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private int price;
}

package com.example.flightsearch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDetails {

    private String originAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private int price;
}

package com.example.flightsearch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightsRequest {
    private String originAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;



}

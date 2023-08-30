package com.example.flightsearch.model.airports;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AirportsResponse {

    private List<AirportDetails> airportDetails;
}

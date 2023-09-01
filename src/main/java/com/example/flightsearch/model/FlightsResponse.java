package com.example.flightsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlightsResponse {
   private List<FlightDetails> flightDetails;
}

package com.example.flightsearch.controller;

import com.example.flightsearch.model.FlightsResponse;
import com.example.flightsearch.model.FlightsRequest;
import com.example.flightsearch.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private FlightsService flightsService;

    // Response Body içerisine tüm uçuş bilgileri girilerek uçuş arama gerçekleştirilir. Eğer varış tarihinide girerseniz çift yönlü uçuşlar karşınıza çıkar.
    // Eğer varış tarihi belirtmezseniz sadece tek yönlü uçuşlar çıkar
    @PostMapping("/flightList")
    public ResponseEntity<FlightsResponse> listele(@RequestBody FlightsRequest request) {
        FlightsResponse response = flightsService.checkFlights(request);
        return ResponseEntity.ok(response);

    }

    // Kalkış Havalimanı bilgisine göre uçuşları listeleme
    @GetMapping("/flightSearch")
    public ResponseEntity<FlightsResponse> searchFlight(@RequestParam String originAirport) {
        FlightsResponse response = flightsService.searchFlight(originAirport);

        return ResponseEntity.ok(response);


    }


}










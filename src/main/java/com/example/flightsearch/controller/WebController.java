package com.example.flightsearch.controller;

import com.example.flightsearch.model.flight.FlightsResponse;
import com.example.flightsearch.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private FlightsService flightsService;


    @GetMapping("/Ucuslar")
    public String listAllFlights(Model model){
        FlightsResponse response = flightsService.getAllFlights();
        model.addAttribute("flightDetailsList",response.getFlightDetails());
        return "ucuslar";
    }

    @GetMapping("/Anasayfa")
    public String mainPage(){
        return "MainPage";
    }
    @GetMapping("/UcusAra")
    public String flightSearch(){
        return "flightSearch";
    }
}

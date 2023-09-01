package com.example.flightsearch.controller;

import com.example.flightsearch.entities.Flights;
import com.example.flightsearch.model.FlightsResponse;
import com.example.flightsearch.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private FlightsService flightsService;


    @GetMapping("/Ucuslar")
    public String listAllFlights(Model model){
        FlightsResponse response = flightsService.getAllFlights();
        model.addAttribute("flightDetailsList",response.getFlightDetails());
        return "flights";
    }

    @GetMapping("/Anasayfa")
    public String mainPage(){
        return "MainPage";
    }
    @GetMapping("/UcusAra")
    public String flightSearch(){
        return "flightSearch";
    }

    @GetMapping("/AdminPanel")
    public String adminPanel(Model model){
        FlightsResponse response = flightsService.getAllFlights();
        model.addAttribute("flightList",response.getFlightDetails());

        return "adminpanel";
    }

    @GetMapping("/adminLogin")
    public String login(){
        return "adminLogin";
    }

    @PostMapping("/ekleUcus")
    public String addFlight(@RequestParam String originAirport, @RequestParam String arrivalAirport,
                            @RequestParam String departureTime, @RequestParam String arrivalTime,
                            @RequestParam int price) {

        // Burada Flight nesnesini oluşturup verileri set edebilirsiniz
        Flights flight = new Flights();
        flight.setOriginAirport(originAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setPrice(price);
        flightsService.addFlight(flight);

        // Burada uçuş ekleme işlemini gerçekleştirebilirsiniz
        // Örnek: flightService.addFlight(flight);

        // Ekleme işlemi tamamlandıktan sonra yönlendirme yapabilirsiniz
        return "redirect:/AdminPanel"; // Admin paneline geri yönlendir
    }


    @GetMapping("/silUcus/{airport}")
    public String deleteFlight(@PathVariable String airport) {
        flightsService.deleteFlightByAirport(airport);
        return "redirect:/AdminPanel"; // Admin paneline geri yönlendir
    }
    @GetMapping("/tumUcuslariSil")
    public String deleteAllFlights() {
        flightsService.deleteAllFlights();
        return "redirect:/AdminPanel"; // Admin paneline geri yönlendir
    }


}

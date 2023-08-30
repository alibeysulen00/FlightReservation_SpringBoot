package com.example.flightsearch.services;

import com.example.flightsearch.entities.Flights;
import com.example.flightsearch.model.flight.FlightDetails;
import com.example.flightsearch.model.flight.FlightsRequest;
import com.example.flightsearch.model.flight.FlightsResponse;
import com.example.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightsService {

    @Autowired
    private FlightRepository flightRepository;


    public FlightsResponse getAllFlights() {
        FlightsResponse response = new FlightsResponse();
        List<FlightDetails> flightDetailsList = new ArrayList<>();

        List<Flights> allFlights = flightRepository.findAll();

        for (Flights flight : allFlights) {
            FlightDetails flightDetails = new FlightDetails();
            flightDetails.setOriginAirport(flight.getOriginAirport());
            flightDetails.setArrivalAirport(flight.getArrivalAirport());
            flightDetails.setDepartureTime(flight.getDepartureTime());
            flightDetails.setArrivalTime(flight.getArrivalTime());
            flightDetails.setPrice(flight.getPrice());

            flightDetailsList.add(flightDetails);
        }

        response.setFlightDetails(flightDetailsList);

        return response;
    }

    public FlightsResponse checkFlights(FlightsRequest request){
        FlightsResponse response = new FlightsResponse();
        Flights flights = new Flights();
        List<Flights> allFlights = flightRepository.findAll();
        List<FlightDetails> flightDetailsList = new ArrayList<>();
        //başlangıçta ilk uçuşu listeye ekle

        if(request.getArrivalTime().equals("")){
            //tekrardan bir nesne oluşturmamın nedeni iki farklı Flight details oluşturmam gerekmesi optimize edilebilir. Döngü kullanılabilir ?
            for (Flights flight:allFlights){

                if(request.getOriginAirport().equals(flight.getOriginAirport()) && request.getArrivalAirport().equals(flight.getArrivalAirport()) ){
                    FlightDetails flightDetails = new FlightDetails();
                    flightDetails.setOriginAirport(request.getOriginAirport());
                    flightDetails.setArrivalAirport(request.getArrivalAirport());
                    flightDetails.setDepartureTime(request.getDepartureTime());
                    flightDetails.setArrivalTime(request.getArrivalTime());
                    flightDetails.setPrice(flight.getPrice());
                    flightDetailsList.add(flightDetails);
                }
            }
            response.setFlightDetails(flightDetailsList);
        }
        else {
            for(Flights flight: allFlights){//
                // tüm uçuşlar için döngü
                if(request.getOriginAirport().equals(flight.getOriginAirport()) && request.getArrivalAirport().equals(flight.getArrivalAirport()) && request.getDepartureTime().equals(flight.getDepartureTime()) && request.getArrivalTime().equals(flight.getArrivalTime()) && flightDetailsList.isEmpty()){
                    //buradaki if koşulunda genel olarak yapmak istediğim eğer aynı request e sahip birden fazla uçuş varsa ilk uçuşu seçsin ve listeye eklesin mantık olarak hatalı en ucuzu seçmesi daha mantıklı olabilir
                    FlightDetails flightDetails = new FlightDetails();
                    flightDetails.setOriginAirport(request.getOriginAirport());
                    flightDetails.setArrivalAirport(request.getArrivalAirport());
                    flightDetails.setDepartureTime(request.getDepartureTime());
                    flightDetails.setArrivalTime(request.getArrivalTime());
                    flightDetails.setPrice(flight.getPrice());
                    flightDetailsList.add(flightDetails);
                }
                 if(request.getArrivalAirport().equals(flight.getOriginAirport())){
                    FlightDetails flightDetails1 = new FlightDetails();

//eğer uçağın kalktığı havalimanı db de başka bir uçuşta varış yeri ise gidiş dönüş için uygundur listeye ekle ardından FlightDetails e ekleyip response olarak dön
                    flightDetails1.setOriginAirport(flight.getOriginAirport());
                    flightDetails1.setArrivalAirport(flight.getArrivalAirport());
                    flightDetails1.setDepartureTime(flight.getDepartureTime());
                    flightDetails1.setArrivalTime(flight.getArrivalTime());
                    flightDetails1.setPrice(flight.getPrice());
                    flightDetailsList.add(flightDetails1);

                }
            }
            response.setFlightDetails(flightDetailsList);
        }
        return response;
    }

    public FlightsResponse searchFlight(String originAirport){
        FlightsResponse response = new FlightsResponse();
        List<FlightDetails> flightDetailsList = new ArrayList<>();
        Iterable<Flights> allFlights = flightRepository.findAll();
        for(Flights flights: allFlights){
            if(originAirport.equals(flights.getOriginAirport())){
                FlightDetails flightDetails = new FlightDetails();
                flightDetails.setOriginAirport(flights.getOriginAirport());
                flightDetails.setArrivalAirport(flights.getArrivalAirport());
                flightDetails.setDepartureTime(flights.getDepartureTime());
                flightDetails.setArrivalTime(flights.getArrivalTime());
                flightDetails.setPrice(flights.getPrice());

                flightDetailsList.add(flightDetails);
                response.setFlightDetails(flightDetailsList);
            }
        }


        return response;
    }










}

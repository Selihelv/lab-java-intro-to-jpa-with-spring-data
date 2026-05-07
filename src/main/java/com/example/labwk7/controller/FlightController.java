package com.example.labwk7.controller;


import com.example.labwk7.model.Flight;
import com.example.labwk7.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights(){
        return flightService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Flight> getById(@PathVariable Long id){
        return flightService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight saveFlight(@RequestBody Flight flight){
        return flightService.save(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight (@PathVariable Long id, @RequestBody Flight flight){
        return flightService.update(id, flight);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable Long id){
        flightService.delete(id);
    }
}

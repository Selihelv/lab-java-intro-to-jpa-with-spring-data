package com.example.labwk7.controller;

import com.example.labwk7.model.FlightBooking;
import com.example.labwk7.service.FlightBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class FlightBookingConstroller {
    private final FlightBookingService flightBookingService;

    @GetMapping
    public List<FlightBooking> getAllFlightBookings(){
        return flightBookingService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<FlightBooking> getById(@PathVariable Long id){
        return flightBookingService.getById(id);
    }

    @GetMapping("/{customerId}")
    public List<FlightBooking> findAllByCustomerId(@PathVariable Long customerId){
        return flightBookingService.findAllByCustomerId(customerId);
    }

    @GetMapping("/{flightId}")
    public FlightBooking findBookingByFlightId(@PathVariable int flightId){
        return flightBookingService.findBookingById(flightId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightBooking saveFlightBooking(@RequestBody FlightBooking flightBooking){
        return flightBookingService.save(flightBooking);
    }

    @PutMapping("/{id}")
    public FlightBooking updateFlightBooking (@PathVariable Long id, @RequestBody FlightBooking flightBooking){
        return flightBookingService.update(id, flightBooking);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlightBooking (@PathVariable Long id){
        flightBookingService.delete(id);
    }
}

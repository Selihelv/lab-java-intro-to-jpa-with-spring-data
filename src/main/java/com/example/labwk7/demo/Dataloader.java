package com.example.labwk7.demo;

import com.example.labwk7.enums.CustomerStatus;
import com.example.labwk7.model.Customer;
import com.example.labwk7.model.Flight;
import com.example.labwk7.model.FlightBooking;
import com.example.labwk7.repository.CustomerRepository;
import com.example.labwk7.repository.FlightBookingRepository;
import com.example.labwk7.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final FlightBookingRepository flightBookingRepository;
    private final FlightRepository flightRepository;

    @Override
    public void run(String... args){
        Customer alice = customerRepository.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
        Flight flight= flightRepository.save((new Flight("AB123", "Boeing 747", 300, 400));
        flightBookingRepository.save(new FlightBooking(alice.getId(), flight.getId()));

    }
}

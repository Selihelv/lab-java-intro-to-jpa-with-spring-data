package com.example.labwk7.service;

import com.example.labwk7.model.Flight;
import com.example.labwk7.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public List<Flight> getAll(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getById(Long id){
        return flightRepository.findById(id);
    }

    public Flight save(Flight flight){
        return flightRepository.save(flight);
    }

    public Flight update(Long id, Flight flight){
        Flight flightToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Customer with id: " + id + " not found!"));
        flightToUpdate.setFlightNumber(flight.getFlightNumber());
        flightToUpdate.setAircraft(flight.getAircraft());
        flightToUpdate.setTotalNumberOfSeats(flight.getTotalNumberOfSeats());

        return flightRepository.save(flightToUpdate);
    }

    public void delete(Long id){
        flightRepository.deleteById(id);
    }
}

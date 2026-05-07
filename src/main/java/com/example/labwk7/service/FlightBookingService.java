package com.example.labwk7.service;

import com.example.labwk7.model.Flight;
import com.example.labwk7.model.FlightBooking;
import com.example.labwk7.repository.FlightBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;

    public List<FlightBooking> getAll(){
        return flightBookingRepository.findAll();
    }

    public Optional<FlightBooking> getById(Long id){
        return flightBookingRepository.findById(id);
    }

    public List<FlightBooking> findAllByCustomerId(Long customerId){
        return flightBookingRepository.findAllByCustomerId(customerId);
    }

    public FlightBooking findBookingById (int flightId){
        return flightBookingRepository.findByFlightId(flightId);
    }

    public FlightBooking save(FlightBooking flightBooking){
        return flightBookingRepository.save(flightBooking);
    }

    public FlightBooking update(Long id, FlightBooking flightBooking){
        FlightBooking flightBookingToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Customer with id: " + id + " not found!"));
        flightBooking.setCustomerId(flightBooking.getCustomerId());
        flightBooking.setFlightId(flightBooking.getFlightId());

        return flightBookingRepository.save(flightBooking);
    }

    public void delete(Long id){
        flightBookingRepository.deleteById(id);
    }
}

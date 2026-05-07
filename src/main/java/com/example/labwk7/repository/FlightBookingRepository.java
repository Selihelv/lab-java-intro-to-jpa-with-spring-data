package com.example.labwk7.repository;

import com.example.labwk7.enums.CustomerStatus;
import com.example.labwk7.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

    List<FlightBooking> findAllByCustomerId(Long customerId);

   List<FlightBooking> findByFlightId(Long flightId);
}

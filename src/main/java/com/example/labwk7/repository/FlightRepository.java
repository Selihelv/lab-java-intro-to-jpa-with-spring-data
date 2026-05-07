package com.example.labwk7.repository;

import com.example.labwk7.enums.CustomerStatus;
import com.example.labwk7.model.Customer;
import com.example.labwk7.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


}

package com.example.labwk7.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table( name = "flight_booking")
public class FlightBooking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column( name = "flight_id")
    private Long flightId;

    public FlightBooking(Long customerId, Long flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }
}
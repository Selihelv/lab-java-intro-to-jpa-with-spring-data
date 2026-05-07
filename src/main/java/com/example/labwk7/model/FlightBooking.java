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
    private int customerId;

    @Column( name = "flight_id")
    private int flightId;

    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }
}
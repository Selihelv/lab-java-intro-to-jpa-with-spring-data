package com.example.labwk7.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table( name = "flight")
public class Flight {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "id")
    private Long id;

    @Column( name = "flight_number")
    private String flightNumber;

    @Column( name = "aircraft")
    private String aircraft;

    @Column( name = "total_number_of_seats")
    private int totalNumberOfSeats;

    @Column(name = "mileage")
    private Integer milegae;

    public Flight(String flightNumber, String aircraft,
                  int totalNumberOfSeats, Integer milegae) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.milegae = milegae;
    }
}
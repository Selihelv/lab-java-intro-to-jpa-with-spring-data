package com.example.labwk7.model;

import com.example.labwk7.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@Entity
@Table( name = "customer")
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "id")
    private Long id;

    @Column( name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column( name = "status")
    private CustomerStatus status;

    @Column( name = "total_miles_flown")
    private int totalMilesFlown;

    public Customer(String name, CustomerStatus status, int totalMilesFlown) {
        this.name = name;
        this.status = status;
        this.totalMilesFlown = totalMilesFlown;
    }
}

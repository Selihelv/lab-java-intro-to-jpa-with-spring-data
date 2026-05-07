package com.example.labwk7.repository;

import com.example.labwk7.enums.CustomerStatus;
import com.example.labwk7.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByStatus(CustomerStatus status);

    List<Customer> findAllByTotalMilesFlownGreaterThan(int mileage);

}

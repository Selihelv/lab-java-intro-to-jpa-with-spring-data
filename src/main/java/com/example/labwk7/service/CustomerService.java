package com.example.labwk7.service;

import com.example.labwk7.enums.CustomerStatus;
import com.example.labwk7.model.Customer;
import com.example.labwk7.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Long id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAllByStatus(CustomerStatus status){
        return customerRepository.findAllByStatus(status);
    }

    public List<Customer> findAllByTotalMilesFlownGreaterThan( int totalMilesFlownIsGreaterThan){
        return customerRepository.findAllByTotalMilesFlownGreaterThan(totalMilesFlownIsGreaterThan);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Long id, Customer customer){
        Customer customerToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Customer with id: " + id + " not found!"));
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setStatus(customer.getStatus());
        customerToUpdate.setTotalMilesFlown(customer.getTotalMilesFlown());

        return customerRepository.save(customerToUpdate);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}

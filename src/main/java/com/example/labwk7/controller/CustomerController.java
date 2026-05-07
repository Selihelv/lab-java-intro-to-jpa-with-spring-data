package com.example.labwk7.controller;

import com.example.labwk7.enums.CustomerStatus;
import com.example.labwk7.model.Customer;
import com.example.labwk7.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable Long id){
        return customerService.getById(id);
    }

    @GetMapping("/status/{status}")
    public List<Customer> getCustomerByStatus(@PathVariable CustomerStatus status){
        return customerService.findAllByStatus(status);
    }

    @GetMapping("flownmileage/{mileage}")
    public List<Customer> getCustomerByMileage(@PathVariable int mileage){
        return customerService.findAllByTotalMilesFlownGreaterThan(mileage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer (@PathVariable Long id, @RequestBody Customer customer){
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
    }
}

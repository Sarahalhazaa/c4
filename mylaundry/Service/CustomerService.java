package com.example.mylaundry.Service;

import com.example.mylaundry.Api.ApiException;
import com.example.mylaundry.Model.Customer;
import com.example.mylaundry.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    // Get All Customers
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }


    //• Add new Customer
    public void addCustomer(Customer customers) {

        customerRepository.save(customers);
    }


    //• Update Customer
    public void updateCustomer(Integer id,Customer customers) {
        Customer c=customerRepository.findCustomersById(id);

        if (c == null) {
            throw new ApiException("Wrong id");
        }
        c.setName(customers.getName());
         c.setProfile(customers.getProfile());

        customerRepository.save(c);

    }

    //• Delete Customer
    public void deleteCustomer(Integer id) {
        Customer c=customerRepository.findCustomersById(id);
        if (c == null) {
            throw new ApiException("Wrong id");
        }
        customerRepository.delete(c);
    }





}
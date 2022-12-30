package com.example.mongoPc1.service;

import com.example.mongoPc1.domain.Customer;
import com.example.mongoPc1.exception.CustomerAlreadyExistException;
import com.example.mongoPc1.exception.CustomerNotFoundException;
import com.example.mongoPc1.repositary.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{
    CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if(customerRepository.findById(customer.getCustomerId()).isEmpty()){
            return customerRepository.save(customer);
        }
        throw new CustomerAlreadyExistException();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(int customerId) throws CustomerNotFoundException {
        if(customerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }
        customerRepository.deleteById(customerId);
        return "customer deleted succfully";
    }

    @Override
    public List<Customer> getCustomerByName(String customerName) {
        return customerRepository.findBycustomerName(customerName);
    }

    @Override
    public List<Customer> getCustomerByProductName(String customerProduct) {
        return customerRepository.findByCustomerProduct(customerProduct);
    }
}

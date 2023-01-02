package org.niit.Course13_S3_PC_1.service;


import org.niit.Course13_S3_PC_1.domain.Customer;
import org.niit.Course13_S3_PC_1.exception.CustomerAlreadyExistException;
import org.niit.Course13_S3_PC_1.exception.CustomerNotFoundException;
import org.niit.Course13_S3_PC_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if(customerRepository.findById(customer.getCustomerId()).isEmpty())
        {
            return customerRepository.save(customer);
        }
        throw new CustomerAlreadyExistException();
    }
    @Override
    public List<Customer> getAllCustomer() {
       return customerRepository.findAll();
    }
    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        if(customerRepository.findById(customerId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        customerRepository.deleteById(customerId);
        return true;
    }
    @Override
    public List<Customer> getCustomerBySamsungMobileName(String samsung) {
        return customerRepository.findAllCustomerByProduct(samsung);
    }
}

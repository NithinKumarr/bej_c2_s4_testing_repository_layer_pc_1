package org.niit.Course13_S3_PC_1.service;

import org.niit.Course13_S3_PC_1.domain.Customer;
import org.niit.Course13_S3_PC_1.exception.CustomerAlreadyExistException;
import org.niit.Course13_S3_PC_1.exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException;
    public List<Customer> getAllCustomer();
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
    public List<Customer>getCustomerBySamsungMobileName(String samsung);
}

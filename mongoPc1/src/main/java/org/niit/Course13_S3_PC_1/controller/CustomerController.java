package org.niit.Course13_S3_PC_1.controller;

import org.niit.Course13_S3_PC_1.domain.Customer;
import org.niit.Course13_S3_PC_1.exception.CustomerAlreadyExistException;
import org.niit.Course13_S3_PC_1.exception.CustomerNotFoundException;
import org.niit.Course13_S3_PC_1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/c1")
public class CustomerController {
    ICustomerService iCustomerService;
    @Autowired
    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }
    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistException
    {
        return new ResponseEntity<>(iCustomerService.addCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomers()
    {
        return new ResponseEntity<>(iCustomerService.getAllCustomer(),HttpStatus.OK);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) throws CustomerNotFoundException
    {
        return new ResponseEntity<>(iCustomerService.deleteCustomer(id),HttpStatus.OK);
    }
    @GetMapping("/customer/{samsung}")
    public ResponseEntity<?> getAllCustomerByProductName(@PathVariable String samsung)
    {
        return new ResponseEntity<>(iCustomerService.getCustomerBySamsungMobileName(samsung),HttpStatus.OK);
    }
}

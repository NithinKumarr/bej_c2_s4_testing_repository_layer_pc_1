package com.example.mongoPc1;

import com.example.mongoPc1.domain.Customer;
import com.example.mongoPc1.domain.Product;
import com.example.mongoPc1.repositary.CustomerRepository;
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Product product;
    @BeforeEach
    public void setUp(){
        this.product=new Product(109,"TV","fully advanced");
        this.customer=new Customer(145,"Sam",876544329,this.product);
    }
    @Test
    @DisplayName("Test case for saving customer object")
    public void givenCustomerToSaveShouldReturnSavedCustomer() {
        //save customer data in database by using save method of repo
        customerRepository.save(customer);
        //fetch record by using findByid and store it in temp variable
        Customer c1 = customerRepository.findById(customer.getCustomerId()).get();
        // assertEquals(customer.getCust_id(),c1.getCust_id());
        assertEquals(customer, c1);
    }
    @Test
    @DisplayName("Test case for deleting customer object")
    public void GivenCustomerToDeleteShouldDeleteCustomer(){
        customerRepository.insert(customer);
        Customer c1=customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(c1);
        assertEquals(Optional.empty(),customerRepository.findById(c1.getCustomerId()));
    }
    @Test
    @DisplayName("Test case for get all record")
    public void givenCustomerReturnAllCustomer(){
        customerRepository.deleteAll();
        customerRepository.insert(customer);
        this.product=new Product(200,"mobile","fully advanced");
        this.customer=new Customer(10011,"rosy",987884329,this.product);
        customerRepository.insert(customer);
        List<Customer> allCustomers=customerRepository.findAll();
        assertEquals(2,allCustomers.size());
    }
    @AfterEach
    public void clear(){
        this.product=null;
        this.customer=null;
    }
}


package org.niit.Course13_S3_PC_1.repositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.niit.Course13_S3_PC_1.domain.Customer;
import org.niit.Course13_S3_PC_1.domain.Product;
import org.niit.Course13_S3_PC_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    CustomerRepository customerRepository;
    @Autowired
    public CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    private Customer customer;
    private Product product;
    private String productDescription;
    @BeforeEach
    public void setUp()
    {
        this.customer = new Customer(99,"sayam",87637868L,this.product) ;
        this.product = new Product(34,"I phone 14 Pro ","Electronic");
    }
    @Test
    @DisplayName("Test Case for Saving Customer")
    public void givenCustomerToSaveReturnSaveTrack()
    {
        customerRepository.save(customer);
        Customer c =  customerRepository.findById(customer.getCustomerId()).get();
        assertEquals(customer,c);
    }
    @Test
    @DisplayName("Test Case for Deleting Customer")
    public void deleteTrack()
    {
        Customer c = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(c);
        assertEquals(Optional.empty(),customerRepository.findById(c.getCustomerId()));
    }
    @Test
    @DisplayName("Test Case for getting Customer")
    public void displayTrackList()
    {    customerRepository.deleteAll();
        customerRepository.insert(customer);
        this.product = new Product(2,"Hyundai Creta","Automobile");
        this.customer = new Customer(102,"Alex Legend",97233456L,this.product);
        customerRepository.insert(customer);
        List<Customer> customerList  = customerRepository.findAll();
        assertEquals(2,customerList.size());
    }
}

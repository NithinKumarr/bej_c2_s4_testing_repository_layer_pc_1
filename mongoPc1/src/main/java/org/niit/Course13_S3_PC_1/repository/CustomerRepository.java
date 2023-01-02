package org.niit.Course13_S3_PC_1.repository;

import org.niit.Course13_S3_PC_1.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    @Query("{'customerProduct.ProductName':{$in:[?0]}}")
    public List<Customer> findAllCustomerByProduct(String productName);
}


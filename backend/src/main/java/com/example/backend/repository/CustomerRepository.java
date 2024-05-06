package com.example.backend.repository;

import com.example.backend.entity.Customer;
import com.example.backend.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByCustomerGroup(String customerGroup);

    List<Customer> findCustomerByUser(User user);
}

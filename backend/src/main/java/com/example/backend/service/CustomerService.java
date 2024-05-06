package com.example.backend.service;

import com.example.backend.api.response.CustomerResponse;
import com.example.backend.entity.Customer;
import com.example.backend.entity.User;
import com.example.backend.repository.CustomerRepository;
import com.example.backend.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public List<CustomerResponse> findAll() {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        convertedToDto(customerResponses, customers);
        return customerResponses;
    }


    public List<CustomerResponse> findByUsername(String username) {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        User user = userRepository.findByName(username);
        List<Customer> customers = customerRepository.findCustomerByUser(user);
        convertedToDto(customerResponses, customers);
        return customerResponses;
    }

    public List<CustomerResponse> findByCustomerGroup(String customerGroup) {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        List<Customer> customers = customerRepository.findByCustomerGroup(customerGroup);
        convertedToDto(customerResponses, customers);
        return customerResponses;
    }

    private static void convertedToDto(List<CustomerResponse> customerResponses,
            List<Customer> customers) {
        for (Customer customer : customers) {
            CustomerResponse customerResponse = CustomerResponse.builder()
                    .name(customer.getName())
                    .phone(customer.getPhone())
                    .customerGroup(customer.getCustomerGroup())
                    .username(customer.getUser().getName())
                    .memo(customer.getMemo())
                    .gender(customer.getGender())
                    .address(customer.getAddress())
                    .birth(customer.getBirth())
                    .build();
            customerResponses.add(customerResponse);
        }
    }
}

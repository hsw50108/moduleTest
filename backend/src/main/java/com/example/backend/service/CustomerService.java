package com.example.backend.service;

import com.example.backend.api.request.UpdateCustomerDetailRequest;
import com.example.backend.api.response.customer.CustomerResponse;
import com.example.backend.entity.Customer;
import com.example.backend.entity.User;
import com.example.backend.exception.customer.CustomerNotFoundException;
import com.example.backend.exception.user.UserNotFoundException;
import com.example.backend.repository.CustomerRepository;
import com.example.backend.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if (user == null) {
            throw new UserNotFoundException("찾는 담당자가 없습니다.");
        }

        List<Customer> customers = customerRepository.findCustomerByUser(user);

        convertedToDto(customerResponses, customers);

        return customerResponses;
    }

    public List<CustomerResponse> findByCustomerGroup(String customerGroup) {
        List<CustomerResponse> customerResponses = new ArrayList<>();
        List<Customer> customers = customerRepository.findByCustomerGroup(customerGroup);

        if (customers.isEmpty()) {
            throw new CustomerNotFoundException("찾는 고객등급이 없습니다.");
        }

        convertedToDto(customerResponses, customers);
        return customerResponses;
    }

    @Transactional
    public void updateCustomerDetail(Long customerId,
            UpdateCustomerDetailRequest updateCustomerDetailRequest) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("회원이 존재하지 않습니다."));

        customer.updateCustomerDetail(updateCustomerDetailRequest);

        customerRepository.save(customer);
    }

    private static void convertedToDto(List<CustomerResponse> customerResponses,
            List<Customer> customers) {
        for (Customer customer : customers) {
            CustomerResponse customerResponse = CustomerResponse.builder()
                    .id(customer.getId())
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

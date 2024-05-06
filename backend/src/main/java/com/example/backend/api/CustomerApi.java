package com.example.backend.api;

import com.example.backend.api.request.UpdateCustomerDetailRequest;
import com.example.backend.api.response.CustomerResponse;
import com.example.backend.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerApi {

    private final CustomerService customerService;

    // 고객 전체 조회
    @GetMapping()
    public List<CustomerResponse> customerResponse() {
        return customerService.findAll();
    }

    // 고객 조회 by 담당자
    @GetMapping("/username/{username}")
    public List<CustomerResponse> customerResponseByUsername(@PathVariable String username) {
        return customerService.findByUsername(username);
    }

    // 고객 조회 by 그룹별
    @GetMapping("/group/{customerGroup}")
    public List<CustomerResponse> customerResponseByCustomerGroup(
            @PathVariable String customerGroup) {
        return customerService.findByCustomerGroup(customerGroup);
    }

    // 고객 정보 수정 api
    @PatchMapping("/{customerId}")
    public void editCustomer(@PathVariable Long customerId,
           @RequestBody UpdateCustomerDetailRequest updateCustomerDetailRequest) {
        customerService.updateCustomerDetail(customerId, updateCustomerDetailRequest);
    }


}

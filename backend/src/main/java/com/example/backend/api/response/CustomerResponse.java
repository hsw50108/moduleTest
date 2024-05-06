package com.example.backend.api.response;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CustomerResponse {

    private final Long id;
    private final String name;
    private final String customerGroup;
    private final String phone;
    private final String address;
    private final String user;
    private final String memo;
    private final String gender;
    private final LocalDate birth;

    @Builder
    public CustomerResponse(Long id, String name, String customerGroup, String phone, String address,
            String username,
            String memo, String gender, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.customerGroup = customerGroup;
        this.phone = phone;
        this.address = address;
        this.user = username;
        this.memo = memo;
        this.gender = gender;
        this.birth = birth;
    }

}

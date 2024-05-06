package com.example.backend.api.request;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class UpdateCustomerDetailRequest {

    private String name;
    private String customerGroup;
    private String phone;
    private String address;
    private String memo;
    private String gender;
    private LocalDate birth;

}

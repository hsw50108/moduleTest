package com.example.backend.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.example.backend.api.request.UpdateCustomerDetailRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Customer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String customerGroup;
    private String phone;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String memo;
    private String gender;
    private LocalDate birth;

    public void updateCustomerDetail(UpdateCustomerDetailRequest updateCustomerDetailRequest) {

        this.name = updateCustomerDetailRequest.getName();
        this.customerGroup = updateCustomerDetailRequest.getCustomerGroup();
        this.phone = updateCustomerDetailRequest.getPhone();
        this.address = updateCustomerDetailRequest.getAddress();
//        this.user = customerDetailEditRequest.getUser()
        this.memo = updateCustomerDetailRequest.getMemo();
        this.gender = updateCustomerDetailRequest.getGender();
        this.birth = updateCustomerDetailRequest.getBirth();
    }
}

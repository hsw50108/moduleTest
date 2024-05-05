package com.example.backend.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String authority;
    private Boolean deletedYn;

    @Builder
    public User(String name, String email, String password, String authority, Boolean deletedYn) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.deletedYn = deletedYn;
    }
}

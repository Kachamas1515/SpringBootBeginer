package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//JPA
@EqualsAndHashCode
@Data
@Entity(name = "m_user")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, length = 120) //hash
    private String password;

    @Column(nullable = false, length = 120)
    private String name;
}

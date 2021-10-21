package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id //Primary Key
    @GenericGenerator(name = "uuid2", strategy = "uuid2") //Version2 (release v.4)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2") //is identity
    @Column(length = 36, nullable = false, updatable = false) //setting col id
    private String id;

}

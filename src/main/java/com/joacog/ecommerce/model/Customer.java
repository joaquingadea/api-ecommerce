package com.joacog.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String lastName;
    private String dni;
    private String phone;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "customer")
    Sale sale;



    public Customer(String name, String lastName, String dni, String phone, Long id, User user) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.id = id;
        this.user = user;
    }
}

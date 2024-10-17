package com.joacog.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Customer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Long id;
    @OneToOne
    private User user;

    public Customer(String name, String lastName, String dni, String phone, Long id, User user) {
        super(name, lastName, dni, phone);
        this.id = id;
        this.user = user;
    }
}

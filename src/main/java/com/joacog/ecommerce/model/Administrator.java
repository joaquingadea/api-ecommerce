package com.joacog.ecommerce.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Administrator extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private User user;

    public Administrator(String name, String lastName, String dni, String phone, Long id, User user) {
        super(name, lastName, dni, phone);
        this.id = id;
        this.user = user;
    }
}

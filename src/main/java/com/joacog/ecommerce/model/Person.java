package com.joacog.ecommerce.model;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
    private String name;
    private String lastName;
    private String dni;
    private String phone;


    public Person(String name, String lastName, String dni, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
    }
}

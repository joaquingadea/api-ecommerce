package com.joacog.ecommerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate saleDate;

    @ManyToOne
    Customer customer;



    @OneToMany(mappedBy = "sale")
    private Set<SaleProduct> productList = new HashSet<>();


    public Sale() {
    }

    public Sale(Long id, LocalDate saleDate, Set<SaleProduct> productList) {
        this.id = id;
        this.saleDate = saleDate;
        this.productList = productList;
    }
}

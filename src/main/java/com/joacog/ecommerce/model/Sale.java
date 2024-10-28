package com.joacog.ecommerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate saleDate;

    @ManyToOne
    Customer customer;

    private Set<Product> products;


    @OneToMany(mappedBy = "sale")
    private Set<SaleProduct> productList = new HashSet<>();


    public Sale() {
    }

    public Sale(Long id, LocalDate saleDate, Customer customer, Set<Product> products, Set<SaleProduct> productList) {
        this.id = id;
        this.saleDate = saleDate;
        this.customer = customer;
        this.products = products;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<SaleProduct> getProductList() {
        return productList;
    }

    public void setProductList(Set<SaleProduct> productList) {
        this.productList = productList;
    }
}

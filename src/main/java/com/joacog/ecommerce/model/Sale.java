package com.joacog.ecommerce.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate saleDate;
    private Double totalSale;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "saleSP")
    private List<SaleProduct> productList;


    public Sale() {
    }

    public Sale(Long id, LocalDate saleDate, Double totalSale, Customer customer, List<SaleProduct> productList) {
        this.id = id;
        this.saleDate = saleDate;
        this.totalSale = totalSale;
        this.customer = customer;
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

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SaleProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<SaleProduct> productList) {
        this.productList = productList;
    }
}

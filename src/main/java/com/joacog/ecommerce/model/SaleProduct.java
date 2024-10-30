package com.joacog.ecommerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale saleSP;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productSP;

    private Integer quantity;

    public SaleProduct() {
    }

    public SaleProduct(Long id, Sale saleSP, Product productSP, Integer quantity) {
        this.id = id;
        this.saleSP = saleSP;
        this.productSP = productSP;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSaleSP() {
        return saleSP;
    }

    public void setSaleSP(Sale saleSP) {
        this.saleSP = saleSP;
    }

    public Product getProductSP() {
        return productSP;
    }

    public void setProductSP(Product productSP) {
        this.productSP = productSP;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

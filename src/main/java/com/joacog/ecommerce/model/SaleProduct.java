package com.joacog.ecommerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double totalSale;

    public SaleProduct() {
    }

    public SaleProduct(Sale sale, Product product, double totalSale) {
        this.sale = sale;
        this.product = product;
        this.totalSale = totalSale;
    }
}

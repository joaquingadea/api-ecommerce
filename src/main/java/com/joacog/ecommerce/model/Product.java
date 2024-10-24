package com.joacog.ecommerce.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic
    private String name;
    private Double price;
    private Integer stock;
    private String category;
    private String productInformation;

    private List<String> productTags;

    @OneToMany(mappedBy = "product")
    private Set<SaleProduct> productList = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, Double price, Integer stock, String category, String productInformation, List<String> productTags, Set<SaleProduct> productList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.productInformation = productInformation;
        this.productTags = productTags;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public List<String> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<String> productTags) {
        this.productTags = productTags;
    }

    public Set<SaleProduct> getProductList() {
        return productList;
    }

    public void setProductList(Set<SaleProduct> productList) {
        this.productList = productList;
    }
}

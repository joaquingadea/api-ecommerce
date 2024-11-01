package com.joacog.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<SaleProduct> items = new ArrayList<>();
    private Double totalSale;

    public Cart() {
    }

    public Cart(List<SaleProduct> items, Double totalSale) {
        this.items = items;
        this.totalSale = totalSale;
    }

    //Añadir un producto a la vez

    public void addProduct(Product product, Integer quantity){
        SaleProduct saleProduct = new SaleProduct();
        saleProduct.setProductSP(product);
        saleProduct.setQuantity(quantity);
        items.add(saleProduct);
    }



    public List<SaleProduct> getItems() {
        return items;
    }

    public void setItems(List<SaleProduct> items) {
        this.items = items;
    }

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }
}

package com.joacog.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<SaleProduct> items = new ArrayList<>();

    public Cart() {
    }

    public Cart(List<SaleProduct> items) {
        this.items = items;
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
}

package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    //BASIC CRUD

    @GetMapping("/get/products")
    public List<Product> getProducts (){
        return productService.getProducts();
    }
    @PostMapping("/create/product")
    public void postProduct(@RequestBody Product product){
        productService.postProduct(product);
    }



    //SPECIFIC
    @GetMapping("/get/products/hardware")
    public List<Product> getProductsHardware(){
        List<Product> list;
        List<Product> listAux = null;
        list = this.getProducts();
        for (Product prod : list){
            if (prod.getCategory().equalsIgnoreCase("hardware")){
                listAux.add(prod);
            }
        }
        return listAux;
    }
}

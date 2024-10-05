package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    private final IProductService productService;
    /*Inyección de dependencias a través del constructor (constructor injection)
      se utiliza la annotation @Autowired ya que de esta manera se especifica
      el constructor que se va a utilizar para la inyeccion de dependencias*/
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    //CRUD BÁSICO

    @GetMapping("/get/product-by-id/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/get/products")
    public List<Product> getProducts (){
        return productService.getProducts();
    }
    @PostMapping("/create/product")
    public void postProduct(@RequestBody Product product){
        productService.postProduct(product);
    }
    @DeleteMapping("/delete/product-by-id/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PutMapping("/update-complete/product")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    //Probando respuesta personalizada con ResponseEntity
    public ResponseEntity<Void> error(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //ENDPOINTS ESPECÍFICOS
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

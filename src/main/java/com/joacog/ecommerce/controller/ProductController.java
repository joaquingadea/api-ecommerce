package com.joacog.ecommerce.controller;
import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
//Annotation para unificar URLS
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;
    /*Inyección de dependencias a través del constructor (constructor injection)
      se utiliza la annotation @Autowired ya que de esta manera se específica
      el constructor que se va a utilizar para la inyección de dependencias*/
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    //CRUD BÁSICO

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/get")
    public List<Product> getProducts (){
        return productService.getProducts();
    }
    @PostMapping("/create")
    public void postProduct(@RequestBody Product product){
        productService.postProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PutMapping("/update-complete/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(product);
    }

    //Probando respuesta personalizada con ResponseEntity
    public ResponseEntity<Void> error(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //ENDPOINTS ESPECÍFICOS
    @GetMapping("/get/hardware")
    public List<Product> getProductsHardware(){
        List<Product> list;
        List<Product> listAux = new ArrayList<>();
        list = this.getProducts();
        for (Product prod : list){
            if (prod.getCategory().equalsIgnoreCase("hardware")){
                listAux.add(prod);
            }
        }
        return listAux;
    }

    //edición de algunos aspectos particulares de la entidad
    //de esta forma se permite actualizar campos específicos
    @PatchMapping("/{id}")
    public Product updateProductFields(@PathVariable Long id,@RequestBody Product productUpdates){
        return productService.updateProductByFields(id,productUpdates);
    }
}

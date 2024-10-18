package com.joacog.ecommerce.service;
import com.joacog.ecommerce.model.Product;
import com.joacog.ecommerce.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void postProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProductByFields(Long id, Product productUpdates) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()){
            if (productUpdates.getName() != null){
                product.get().setName(productUpdates.getName()) ;
            }
            if (productUpdates.getPrice() != null){
                product.get().setPrice(productUpdates.getPrice()) ;
            }
            if (productUpdates.getStock() != null){
                product.get().setStock(productUpdates.getStock()); ;
            }
            if (productUpdates.getCategory() != null){
                product.get().setCategory(productUpdates.getCategory()); ;
            }
            if (productUpdates.getProductInformation() != null){
                product.get().setProductInformation(productUpdates.getProductInformation()); ;
            }
            if (productUpdates.getProductTags() != null){
                product.get().setProductTags(productUpdates.getProductTags()); ;
            }
            productRepository.save(product.get());
            return product.get();
        }
        return null;
    }
}
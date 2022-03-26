package com.example.shoppingsite.Service;

import com.example.shoppingsite.Model.Product;
import com.example.shoppingsite.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * The type Product service.
 */
@Service
public class ProductService {
    /**
     * The Log.
     */
    Logger log = LoggerFactory.getLogger("Name......................");
    /**
     * The Product repository.
     */
    @Autowired
    ProductRepository productRepository;

    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    /**
     * Get all products under one category list.
     *
     * @param category_id the category id
     * @return the list
     */
    public List<Product> getAllProductsUnderOneCategory(String category_id){
        return productRepository.findProductByCategory(category_id);
    }

    /**
     * Update products product.
     *
     * @param product the product
     * @return the product
     * @throws Exception the exception
     */
    public Product updateProducts(Product product) throws Exception{
        if(product == null || product.getId()==null){
            throw new Exception("Product cannot be null");
        }
        Optional<Product> optionalCategory = productRepository.findById(product.getId());
        if(!optionalCategory.isPresent()){
            throw new Exception("Product id does not exist");
        }
        Product existingProduct = optionalCategory.get();
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setProduct_img(product.getProduct_img());
        return productRepository.save(product);
    }

    /**
     * Delete products.
     *
     * @param id the id
     */
    public void deleteProducts(String id) throws Exception{
        if(!productRepository.findById(id).isPresent()){
            throw new Exception("Category does not exist");
        }
        productRepository.deleteById(id);
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Find product by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Product> findProductById(String id) throws Exception{
        return productRepository.findById(id);
    }
}
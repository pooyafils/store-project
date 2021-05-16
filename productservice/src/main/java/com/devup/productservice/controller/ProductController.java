package com.devup.productservice.controller;

import com.devup.productservice.ProductserviceApplication;
import com.devup.productservice.model.Category;
import com.devup.productservice.model.Product;
import com.devup.productservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <List<Product>> getAllProduct() {
        return ResponseEntity.ok(productRepository.findAll());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> PostProduct(@RequestBody Product product){
Product postProduct=new Product();
postProduct.setCategories(product.getCategories());
postProduct.setName(product.getName());
postProduct.setProviders(product.getProviders());
productRepository.save(postProduct);
return ResponseEntity.ok("");

    }

}

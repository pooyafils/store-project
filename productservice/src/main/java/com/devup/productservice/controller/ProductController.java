package com.devup.productservice.controller;

import com.devup.productservice.ProductserviceApplication;
import com.devup.productservice.model.Category;
import com.devup.productservice.model.Product;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductRepository productRepository;
    ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity PostProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("saved");

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {

        return ResponseEntity.ok(productService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(productService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(productService.editProduct(id, product)));

    }

    @GetMapping("/findbyname/{name}")
    public List<Product> getProivderProduct(@PathVariable String name) {

        return productRepository.findByName(name);
    }
}

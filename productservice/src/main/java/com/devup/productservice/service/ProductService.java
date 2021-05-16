package com.devup.productservice.service;

import com.devup.productservice.model.Product;
import com.devup.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        Product postProduct=new Product();
        postProduct.setCategories(product.getCategories());
        postProduct.setName(product.getName());
        postProduct.setProviders(product.getProviders());
        productRepository.save(postProduct);
        return postProduct;

    }
}

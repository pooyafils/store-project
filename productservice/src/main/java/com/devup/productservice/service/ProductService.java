package com.devup.productservice.service;

import com.devup.productservice.model.Product;
import com.devup.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Product getById(int id){
    Product p=    productRepository.findById(id);
       return p;
    }
    public Product deleteById(int id){
        Product product=productRepository.findById(id);
        productRepository.delete(product);
        return product;
    }
    public Product editProduct(int id,Product product){
        Product editProduct   =  productRepository.findById(id);
        editProduct.setProviders(product.getProviders());
        editProduct.setName(product.getName());
        editProduct.setCategories(product.getCategories());
        return editProduct;
    }
}

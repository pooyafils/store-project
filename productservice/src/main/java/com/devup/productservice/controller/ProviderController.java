package com.devup.productservice.controller;

import com.devup.productservice.model.Product;
import com.devup.productservice.model.Provider;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.repository.ProviderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("provider")
public class ProviderController {
    ProviderRepository providerRepository;
    ProductRepository productRepository;

    public ProviderController(ProviderRepository providerRepository, ProductRepository productRepository) {
        this.providerRepository = providerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Set<Product> getProvider(@PathVariable int id){

        return productRepository.findByProviders(id);
    }

}

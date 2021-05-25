package com.devup.productservice.controller;

import com.devup.productservice.model.Product;
import com.devup.productservice.model.Provider;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.repository.ProviderRepository;
import com.devup.productservice.service.ProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("provider")
public class ProviderController {
ProviderService providerService;
    ProviderRepository providerRepository;
    ProductRepository productRepository;

    public ProviderController(ProviderService providerService, ProviderRepository providerRepository, ProductRepository productRepository) {
        this.providerService = providerService;
        this.providerRepository = providerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity< List<Product>> getProvider(@PathVariable int id){

        return ResponseEntity.ok(providerService.getProviderService(id));
    }

    @GetMapping
    public ResponseEntity< List<Provider>> getAllProviders(){

        return ResponseEntity.ok(providerService.getAllProviderService());
    }

    @PostMapping
    public ResponseEntity postProvider(@RequestBody Provider provider){
        providerService.postProviderService(provider);
        return ResponseEntity.ok("saved");
    }
    @PutMapping("/{id}")
    public ResponseEntity editProvider(@PathVariable int id,@RequestBody Provider provider){

        providerService.editProviderService(provider,id);
        return ResponseEntity.ok("edit has been done!");
    }
/*    @GetMapping("/a/{id}")
    public Set<Product> getProviderf(@PathVariable int id){

        return productRepository.findByProviders(id);
    }*/

}

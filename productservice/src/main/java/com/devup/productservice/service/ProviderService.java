package com.devup.productservice.service;

import com.devup.productservice.model.Product;
import com.devup.productservice.model.Provider;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProviderService {
    ProviderRepository providerRepository;
    ProductRepository productRepository;

    public ProviderService(ProviderRepository providerRepository, ProductRepository productRepository) {
        this.providerRepository = providerRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getProviderService(String name){
Provider p=providerRepository.findByName(name);
     return   productRepository.findByProviders(p.getId());
    }

    public List<Provider> getAllProviderService(){
        return providerRepository.findAll();
    }
    public void postProviderService(Provider provider){

        providerRepository.save(provider);
    }
    public void editProviderService(Provider provider,int id){
        Provider editProvider=providerRepository.findById(id);
        editProvider.setName(provider.getName());
        providerRepository.save(editProvider);
    }
}

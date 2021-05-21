package com.devup.productservice.repository;

import com.devup.productservice.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Integer> {
    Provider findByName(String name);
    Provider findById(int id);
}

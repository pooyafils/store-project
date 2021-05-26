package com.devup.productservice.repository;

import com.devup.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findById(int id);

    List<Product> findByName(String name);
   @Query( value = " select * from  PRODUCT_PROVIDERS a  inner join   product b on  PROVIDERS_ID=? and a.PRODUCT_ID=b.id  ",
    nativeQuery = true)
   List<Product> findByProviders(int id);


    @Query( value = " select * from  PRODUCT_CATEGORIES  a  inner join   product b on  CATEGORIES_ID=? and a.PRODUCTS_ID=b.id  ",
            nativeQuery = true)
    List<Product> findByCategories(int id);
   
}
//SELECT
//PRODUCT_PROVIDERS.PRODUCT_ID FROM PRODUCT_PROVIDERS  inner join product on  product.id=PRODUCT_ID
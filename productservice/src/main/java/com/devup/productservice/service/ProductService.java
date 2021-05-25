package com.devup.productservice.service;

import com.devup.productservice.model.Product;
import com.devup.productservice.model.Provider;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    ProductRepository productRepository;
    ProviderRepository providerRepository;

    public ProductService(ProductRepository productRepository,
                          ProviderRepository providerRepository) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
    }

    public void saveProduct(Product product){
        Product postProduct=new Product();
        postProduct.setCategories(product.getCategories());
        postProduct.setName(product.getName());
      /*  Set<Provider> object=new HashSet<>();
           object=     product.getProviders();
        List<Provider> database=     providerRepository.findAll();
        Set<Provider> resultList = new ArrayList<Provider>();
        for(Provider user1 : database) {
            for(Provider user2 : object) {
                if(user1.getName().equals(user2.getName())) {
                    resultList.add(user2);
                }
                //   System.out.println(resultList);

            }

        }
        resultList.stream().map(x->x.getName()).distinct().forEach(System.out::println);


postProduct.setProviders(resultList);*/

/* other way
               List<Provider> object=product.getProviders();
        List<Provider> resultList = new ArrayList<Provider>();
              Provider providerInstans=new Provider();
               for(Provider p: object){

                  providerInstans.setName(p.getName());

               }

    resultList.add(providerInstans);
    postProduct.setProviders(resultList);
*/
       List<Provider> tempo= product.getProviders();
        Provider providerInstans=new Provider();
        for(Provider p: tempo){

            providerInstans.setName(p.getName());
            providerInstans.setId(p.getId());
               Provider po=providerRepository.findByName(providerInstans.getName());
             postProduct.addCategory(po);
        }

     //   Provider p=providerRepository.findByName(providerInstans.getName());
       // postProduct.addCategory(p);



       // resultList.removeAll(resultList);
       // database.removeAll(database);
       // object.removeAll(object);
       // System.out.println(resultList.size());
        //return postProduct;
        productRepository.save(postProduct);

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

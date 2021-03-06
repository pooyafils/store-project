package com.devup.productservice.service;

import com.devup.productservice.model.Category;
import com.devup.productservice.model.Product;
import com.devup.productservice.model.Provider;
import com.devup.productservice.repository.CategoryRepository;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Stream;

@Service
public class ProductService {

    ProductRepository productRepository;
    ProviderRepository providerRepository;
    CategoryRepository categoryRepository;
    CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProviderRepository providerRepository,
                          CategoryRepository categoryRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    public void saveProduct(Product product) {
        Product postProduct = new Product();
        postProduct.setCategories(product.getCategories());
        postProduct.setName(product.getName());

        List<Provider> tempProvider = product.getProviders();
        Provider providerInstants = new Provider();
        for (Provider p : tempProvider) {

            providerInstants.setName(p.getName());
            providerInstants.setId(p.getId());
            Provider po = providerRepository.findByName(providerInstants.getName());
            postProduct.addProvider(po);

        }

        List<Category> tempCategory = new ArrayList();
        tempCategory = product.getCategories();
        Category categoryInstance = new Category();
/*        for(Category i:temp) {
            categoryInstance.setName(i.getName());

            categoryInstance.setId(i.getId());

            // Category a=categoryRepository.findByName("phone");
            String name = categoryInstance.getName();
            System.out.println(name);
            System.out.println("value" + categoryRepository.findById(1));
            Category a = categoryRepository.findById(1);
           postProduct.addCategory(a);

        }*/
        tempCategory.stream().map(x -> {
            categoryInstance.setName(x.getName());
            categoryInstance.setId(x.getId());
            String name = categoryInstance.getName();
            System.out.println(name);
            System.out.println("value" + categoryRepository.findById(1));
            //  Category a = categoryRepository.findById(1);
            Category findById = categoryRepository.findById(categoryInstance.getId());
            postProduct.addCategory(findById);

            return x.getName();
        });

        productRepository.save(postProduct);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();

    }

    public Product getById(int id) {
        Product p = productRepository.findById(id);
        return p;
    }

    public Product deleteById(int id) {
        Product product = productRepository.findById(id);
        productRepository.delete(product);
        return product;
    }

    public Product editProduct(int id, Product product) {
        Product editProduct = productRepository.findById(id);
        List<Provider> tempEditProvider = product.getProviders();
        List<Provider> staticProviderList = new ArrayList<>();
        Provider providerInstanceEdit = new Provider();
        for (Provider p : tempEditProvider) {
            providerInstanceEdit.setName(p.getName());
            providerInstanceEdit.setId(p.getId());

            Provider po = providerRepository.findByName(providerInstanceEdit.getName());
            staticProviderList.add(po);
        }
        editProduct.setProviders(staticProviderList);
        editProduct.setName(product.getName());
        List<Category> tempEditCategory = new ArrayList();
        tempEditCategory = product.getCategories();
        List<Category> editCategoryList = new ArrayList<>();
        Category categoryInstanceEdit = new Category();
        for (Category f : tempEditCategory) {
            categoryInstanceEdit.setName(f.getName());
            categoryInstanceEdit.setId(f.getId());
            Category d = categoryRepository.findById(categoryInstanceEdit.getId());
            editCategoryList.add(d);
        }
        editProduct.setCategories(editCategoryList);
        return editProduct;
    }


}

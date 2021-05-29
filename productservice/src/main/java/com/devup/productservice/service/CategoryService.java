package com.devup.productservice.service;

import com.devup.productservice.model.Category;
import com.devup.productservice.model.Product;
import com.devup.productservice.repository.CategoryRepository;
import com.devup.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public CategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategoryService() {
        return categoryRepository.findAll();
    }

    public void postCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Product> findByCategoryService(int id) {
        return productRepository.findByCategories(id);
    }

    public Category addMethod(List<Category> temp) {
        Category a = new Category();
        Category categoryInstances = new Category();
        for (Category io : temp) {
            categoryInstances.setName(io.getName());
            categoryInstances.setId(io.getId());
            String name = categoryInstances.getName();
            System.out.println(name);
            System.out.println("value" + categoryRepository.findById(1));

            a = categoryRepository.findById(1);

        }
        return a;
    }

}

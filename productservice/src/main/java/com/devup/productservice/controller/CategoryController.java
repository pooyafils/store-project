package com.devup.productservice.controller;

import com.devup.productservice.model.Category;
import com.devup.productservice.model.Product;
import com.devup.productservice.repository.CategoryRepository;
import com.devup.productservice.repository.ProviderRepository;
import com.devup.productservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryRepository categoryRepository;
    ProviderRepository providerRepository;
CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository, ProviderRepository providerRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.providerRepository = providerRepository;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategoryService());
    }
    @PostMapping
    ResponseEntity postCategory(@RequestBody Category category){
        categoryService.postCategory(category);
        return ResponseEntity.ok("saved");
    }
@GetMapping("/{id}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable int id){
        return ResponseEntity.ok(categoryService.findByCategoryService(id));
}
}

package com.devup.productservice.controller;

import com.devup.productservice.ProductserviceApplication;
import com.devup.productservice.model.Category;
import com.devup.productservice.model.Product;
import com.devup.productservice.repository.ProductRepository;
import com.devup.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductRepository productRepository;
    ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> PostProduct(@RequestBody Product product){

/*Product postProduct=new Product();
postProduct.setCategories(product.getCategories());
postProduct.setName(product.getName());
postProduct.setProviders(product.getProviders());
productRepository.save(postProduct);*/
return ResponseEntity.ok(productService.saveProduct(product));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){

        return ResponseEntity.ok(productService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id){
      //  Product product=productRepository.findById(id);
    //    productRepository.delete(product);
       return ResponseEntity.ok(productService.deleteById(id));
    }
@PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable int id,@RequestBody Product product){
/*   Product editProduct   =  productRepository.findById(id);
   editProduct.setProviders(product.getProviders());
   editProduct.setName(product.getName());
   editProduct.setCategories(product.getCategories());*/
   return ResponseEntity.ok(productRepository.save(productService.editProduct(id,product)));

}
}

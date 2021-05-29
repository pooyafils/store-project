package com.devup.productservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    // @JsonBackReference //it can work with one side only dont put it in product
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "PRODUCT_CATEGORIES",
            joinColumns = {@JoinColumn(name = "PRODUCTS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORIES_ID")})

    private List<Category> categories;
    //@JsonBackReference //it can work with one side only  dont put it in product
    //@ManyToMany(targetEntity = Provider.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PRODUCT_PROVIDERS",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROVIDERS_ID")})
    private List<Provider> providers;

    public void addProvider(Provider p) {
        if (providers == null) {
            providers = new ArrayList<>();
        }
        providers.add(p);
    }

    public void addCategory(Category cat) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(cat);

    }

}

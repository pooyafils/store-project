package com.devup.productservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
   // @JsonBackReference //it can work with one side only dont put it in product
    @ManyToMany(targetEntity = Category.class,cascade = CascadeType.ALL )
    private List<Category> categories;
    //@JsonBackReference //it can work with one side only  dont put it in product
    @ManyToMany(targetEntity = Provider.class,cascade = CascadeType.ALL)
    private List<Provider> providers;


}

package com.devup.productservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Provider {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    @JsonBackReference //it can work with one side only dont put it in product
    @ManyToMany(mappedBy = "providers" ,cascade = CascadeType.ALL)
    private List<Product> product;

}

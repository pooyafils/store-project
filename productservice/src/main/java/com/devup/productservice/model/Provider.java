package com.devup.productservice.model;

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
    @ManyToMany(mappedBy = "providers" ,cascade = CascadeType.ALL)
    private List<Product> product;

}

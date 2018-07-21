package com.szczudlinski.dawid.product.product.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    private String code;

    private String name;

    private String description;

    @Column(name = "base_product")
    private String baseProduct;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_associate",
            joinColumns = @JoinColumn (name = "main_product_id"),
            inverseJoinColumns = @JoinColumn (name = "associate_product_id")
    )
    List<Product> associatedProductList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    List<ProductParameter> productParameterList;
}

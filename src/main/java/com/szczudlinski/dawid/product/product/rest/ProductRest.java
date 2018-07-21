package com.szczudlinski.dawid.product.product.rest;

import com.szczudlinski.dawid.product.product.domain.Product;
import com.szczudlinski.dawid.product.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRest {

    private ProductRepository productRepository;

    @Autowired
    public ProductRest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addProduct(@RequestBody Product product){
        productRepository.save(product);
        return "OK";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    @ResponseBody
    public String saveProduct(@RequestBody Product product, @PathVariable String productId){
        productRepository.save(product);
        return "OK";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.get();
    }
}

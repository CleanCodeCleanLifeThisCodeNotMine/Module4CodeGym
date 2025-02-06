package com.example.cruddemo.controller;

import lombok.AllArgsConstructor;
import com.example.cruddemo.model.Product;
import com.example.cruddemo.service.product.IProductService;
import com.example.cruddemo.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getProduct() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
//        return ResponseEntity.ok(products);
    }
}

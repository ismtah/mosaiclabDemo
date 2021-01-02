package com.mosaiclab.demo.controller;

import com.mosaiclab.demo.model.entities.Product;
import com.mosaiclab.demo.model.pojo.ProductRequest;
import com.mosaiclab.demo.repository.ProductRepository;
import com.mosaiclab.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "/getProducts")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        List products = productService.getProducts(pageNumber, pageSize);
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest){
        Product savedProduct = productRepository.save(productRequest.toProduct());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "getDataTableCount")
    public ResponseEntity getDataTableCount(){
        Map<String, Long> response = new HashMap<>();
        response.put("totalItems", productService.productCount());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}

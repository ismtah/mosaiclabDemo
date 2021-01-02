package com.mosaiclab.demo.service;

import com.mosaiclab.demo.model.entities.Product;
import com.mosaiclab.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;

    public long productCount(){
        return productRepository.count();
    }

    public List<Product> getProducts(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> pageResult = productRepository.findAll(pageable);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}

package com.mosaiclab.demo.repository;

import com.mosaiclab.demo.model.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


}

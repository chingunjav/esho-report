package edu.miu.shop.eshopreport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.miu.shop.eshopreport.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}

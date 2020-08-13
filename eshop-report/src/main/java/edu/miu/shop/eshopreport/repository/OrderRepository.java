package edu.miu.shop.eshopreport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.miu.shop.eshopreport.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	//int findById();
}

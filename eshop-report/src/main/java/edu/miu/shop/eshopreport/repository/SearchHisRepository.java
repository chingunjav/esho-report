package edu.miu.shop.eshopreport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.miu.shop.eshopreport.domain.Order;
import edu.miu.shop.eshopreport.domain.SearchHistory;

public interface SearchHisRepository extends MongoRepository<SearchHistory, String>{

}

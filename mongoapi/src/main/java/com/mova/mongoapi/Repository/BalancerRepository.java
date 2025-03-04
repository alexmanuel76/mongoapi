package com.mova.mongoapi.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mova.mongoapi.model.Balancer;

public interface BalancerRepository extends MongoRepository<Balancer,Integer> {

    
}
package com.jms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jms.documents.OrderTransaction;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {}

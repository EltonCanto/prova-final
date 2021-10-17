package com.tech4me.vendasms.repository;

import com.tech4me.vendasms.model.Venda;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {
    
}

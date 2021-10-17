package com.tech4me.produtosms.repository;

import com.tech4me.produtosms.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

}

package com.tech4me.vendasms.service;

import com.tech4me.vendasms.shared.Produtos;

import org.springframework.stereotype.Component;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produtos-ms", fallback = ProdutoFeignCleintFallBack.class )
public interface ProdutosFeignClient {

    @GetMapping(path = "/api/produtos/{id}")
    Produtos produtoId (@PathVariable String id);
    
}

@Component
class ProdutoFeignCleintFallBack implements ProdutosFeignClient{

    @Override
    public Produtos produtoId(String id) {
        return null;
    }
}



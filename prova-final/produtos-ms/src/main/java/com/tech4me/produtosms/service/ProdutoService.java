package com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.produtosms.shared.ProdutoDto;

public interface ProdutoService {
    ProdutoDto criaProdutoDto(ProdutoDto produto);
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorId(String id);
    void excluirProduto(String id);
    void AdicionarEstoque(String id, int quantidade);
    void baixaEstoque(String id, int quantidade);
    ProdutoDto atualizarProduto(String id, ProdutoDto produto);
}

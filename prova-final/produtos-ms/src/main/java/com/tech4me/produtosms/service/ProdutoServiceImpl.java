package com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.produtosms.model.Produto;
import com.tech4me.produtosms.repository.ProdutoRepository;
import com.tech4me.produtosms.shared.ProdutoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repo;

    @Override
    public void AdicionarEstoque(String id, int quantidade) {
        Optional<Produto> produto = repo.findById(id);
        if(produto.isPresent()){
            produto.get().setEstoque(produto.get().getEstoque() + quantidade);
            repo.save(produto.get());
        }
    }

    @Override
    public void baixaEstoque(String id, int quantidade) {
        Optional<Produto> produto = repo.findById(id);
        if(produto.isPresent()){
            produto.get().setEstoque(produto.get().getEstoque() - quantidade);
            repo.save(produto.get());
        } 
    }

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produto) {
        produto.setId(id);
        return salvarProduto(produto);
    }

    @Override
    public ProdutoDto criaProdutoDto(ProdutoDto produto) {
        return salvarProduto(produto);
    }

    @Override
    public void excluirProduto(String id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repo.findById(id);

        if (produto.isPresent()){
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }

        return Optional.empty();
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repo.findAll();

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
            .collect(Collectors.toList());
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
       ModelMapper mapper = new ModelMapper();
       Produto produtoEntidade = mapper.map(produto, Produto.class);
       produtoEntidade = repo.save(produtoEntidade);

       return mapper.map(produtoEntidade, ProdutoDto.class);
    }
    
}

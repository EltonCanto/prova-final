package com.tech4me.vendasms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.vendasms.model.Venda;
import com.tech4me.vendasms.repository.VendaRepository;
import com.tech4me.vendasms.shared.Produtos;
import com.tech4me.vendasms.shared.VendaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository repo;

    @Autowired
    private ProdutosFeignClient produtoMsCliente;

    @Override
    public VendaDto alterarVenda(String id, VendaDto venda) {
        venda.setId(id);
        return salvarVenda(venda);
    }

    @Override
    public VendaDto criarVendaDto(VendaDto venda) {

        Produtos produto = produtoMsCliente.produtoId(venda.getIdProduto());

        if (produto.getEstoque() >= venda.getQuantidadeVendida()){
            venda.setPrecoProduto(produto.getValor());
            venda.setNomeProduto(produto.getNome());
            venda.setValorTotal(venda.getQuantidadeVendida() * produto.getValor());

            return salvarVenda(venda);
        }

        return null;
    }

    @Override
    public void excluirVenda(String id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> venda = repo.findById(id);

        if (venda.isPresent()){
            return Optional.of(new ModelMapper().map(venda.get(), VendaDto.class));
        }

        return Optional.empty();
    }

    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = repo.findAll();

        return vendas.stream()
            .map(venda -> new ModelMapper().map(venda, VendaDto.class))
            .collect(Collectors.toList());
    }

    private VendaDto salvarVenda(VendaDto venda){
        ModelMapper mapper = new ModelMapper();
        Venda vendaEntidade = mapper.map(venda, Venda.class);
        vendaEntidade = repo.save(vendaEntidade);

        return mapper.map(vendaEntidade, VendaDto.class);
    }

}

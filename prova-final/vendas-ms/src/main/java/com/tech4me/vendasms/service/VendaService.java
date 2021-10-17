package com.tech4me.vendasms.service;

import java.util.List;
import java.util.Optional;

//import com.tech4me.vendasms.shared.Produtos;
import com.tech4me.vendasms.shared.VendaDto;

public interface VendaService {
    VendaDto criarVendaDto(VendaDto venda);
    List<VendaDto> obterTodos();
    Optional<VendaDto> obterPorId(String id);
    void excluirVenda(String id);
    VendaDto alterarVenda(String id, VendaDto venda);
}

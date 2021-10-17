package com.tech4me.vendasms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tech4me.vendasms.service.VendaService;
//import com.tech4me.vendasms.shared.Produtos;
import com.tech4me.vendasms.shared.VendaDto;
import com.tech4me.vendasms.view.model.VendaModelAlteracao;
import com.tech4me.vendasms.view.model.VendaModelInclusao;
import com.tech4me.vendasms.view.model.VendaModelReponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @GetMapping(value = "status")
    public String statusServico(@Value("${local.server.port}") String porta){
        return String.format("Serviço ativo", porta);
    }

    @PostMapping
    public ResponseEntity<VendaModelReponse> novaVenda(@RequestBody @Valid VendaModelInclusao venda) {

        ModelMapper mapper = new ModelMapper();
        VendaDto dto = mapper.map(venda, VendaDto.class);
        dto = service.criarVendaDto(dto);
        return new ResponseEntity<>(mapper.map(dto,VendaModelReponse.class), HttpStatus.CREATED);
        
    }

    @GetMapping
    public ResponseEntity<List<VendaModelReponse>> obterTodos(){
        List<VendaDto> dtos = service.obterTodos();

        if (dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VendaModelReponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, VendaModelReponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaModelReponse> obterPorId(@PathVariable String id){
        Optional<VendaDto> venda = service.obterPorId(id);

        if(venda.isPresent()){
            return new ResponseEntity<>(
                new ModelMapper().map(venda.get(), VendaModelReponse.class),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<VendaModelReponse> atualizarProduto(@PathVariable String id,
        @RequestBody @Valid VendaModelAlteracao venda) {
        ModelMapper mapper = new ModelMapper();
        VendaDto dto = mapper.map(venda, VendaDto.class);
        dto = service.alterarVenda(id, dto);
        
        return new ResponseEntity<>(mapper.map(dto, VendaModelReponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirVenda(@PathVariable String id){
        service.excluirVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.tech4me.produtosms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tech4me.produtosms.service.ProdutoService;
import com.tech4me.produtosms.shared.ProdutoDto;
import com.tech4me.produtosms.view.model.ProdutoModelAltercao;
import com.tech4me.produtosms.view.model.ProdutoModelInclusao;
import com.tech4me.produtosms.view.model.ProdutoModelResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/status")
    public String statusServico(@Value("${local.server.port}") String porta){
        return String.format("Serviço ativo", porta);
    }

    @PostMapping
    public ResponseEntity<ProdutoModelResponse> criarProduto(@RequestBody @Valid ProdutoModelInclusao produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.criaProdutoDto(dto);
        return new ResponseEntity<>(mapper.map(dto,ProdutoModelResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModelResponse>> obterTodos(){
        List<ProdutoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ProdutoModelResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, ProdutoModelResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoModelResponse> obterPorId(@PathVariable String id){
        Optional<ProdutoDto> produto = service.obterPorId(id);

        if(produto.isPresent()){
            return new ResponseEntity<>(
                new ModelMapper().map(produto.get(), ProdutoModelResponse.class),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoModelResponse> atualizarProduto(@PathVariable String id,
        @RequestBody @Valid ProdutoModelAltercao produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.atualizarProduto(id, dto);
        
        return new ResponseEntity<>(mapper.map(dto, ProdutoModelResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable String id){
        service.excluirProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}/adiciona/{quantidade}")
    public ResponseEntity<Void> adionarEstoque (@PathVariable String id, @PathVariable int quantidade ){
        service.AdicionarEstoque(id, quantidade);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping(value = "/{id}/baixa/{quantidade}")
    public ResponseEntity<Void> baixaEstoque (@PathVariable String id, @PathVariable int quantidade ){
        service.baixaEstoque(id, quantidade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

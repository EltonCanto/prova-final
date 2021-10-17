package com.tech4me.produtosms.view.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProdutoModelAltercao {
    
    private String id;
    
    @NotBlank(message = "O nome deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 3, message = "O nome deve ter, no mínimo, 3 caracteres")
    private String nome;

    @Min(value = 1, message = "O código deve ser maior do que zero")
    private int codigo;

    @DecimalMin(value = "0.01", message = "O valor do produto deve ser maior do que zero")
    private double valor;

    @Min(value = 1, message = "O estoque deve ser maior do que zero")
    private int estoque;
    
    @NotBlank(message = "A data deve possuir caracteres não brancos")
    @NotEmpty(message = "A data deve ser preenchido")
    @Size(min = 10, max = 10, message = "A data deve possuir 10 caracteres(dd/mm/yyyy)")
    private String dataCadastro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}

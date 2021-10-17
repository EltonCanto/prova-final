package com.tech4me.produtosms.shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoDto {

    private String id;

    private String nome;

    private int codigo;

    private double valor;

    private int estoque;
    
    private String dataCadastro;

    public ProdutoDto(){
        String novaData;
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        novaData = dtf2.format(LocalDate.now());
        setDataCadastro(novaData);
    }

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

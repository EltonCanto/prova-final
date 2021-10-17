package com.tech4me.vendasms.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class VendaModelAlteracao {
    
    private String id;

    @NotBlank(message = "A data deve possuir caracteres não brancos")
    @NotEmpty(message = "A data deve ser preenchido")
    @Size(min = 10, max = 10, message = "A data deve possuir 10 caracteres(dd/mm/yyyy)")
    private String dataVenda;

    @NotEmpty(message = "O id do produto deve ser preenchico")
    private String idProduto;

    @NotEmpty(message  = "O nome do produto deve ser preenchico")
    private String nomeProduto;

    @Min(value = 1, message = "A quantidade de venda deve ser maior do que zero")
    private int quantidadeVendida;

    private double precoProduto;

    private double valorTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }    
}

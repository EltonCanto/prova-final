package com.tech4me.vendasms.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class VendaModelInclusao {
    private String id;

    @NotEmpty(message = "O id do produto deve ser preenchico")
    private String idProduto;

    private String nomeProduto;

    @Min(value = 1, message = "O quantidade deve ser maior do que zero")
    private int quantidadeVendida;

    private double precoProduto;

    private double valorTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.GerarID;
import com.nicetech.optimus.utils.jTable.Tabela;
import static java.lang.Math.floor;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class ModelVenda {

    private int id;
    public String Guid;
    private int idProduto;
    private List<ModelProduto> produto;
    private String CPFCliente;
    private GerarID idEmpresa;
    private GerarID idVendedor;
    private double preco;
    private double precoFinal;
    private double desconto;
    private Date dataDaVenda;
    private String data;
    private int mes;
    private int ano;
    private int hora;
    private int totalDeVendas;
    
    public GerarID getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(GerarID idVendedor) {
        this.idVendedor = idVendedor;
    }



    @Tabela(Coluna = "ID", Indice = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    @Tabela(Coluna = "ID Produto", Indice = 3)
    public int getIdProduto() {
        return idProduto;
    }

    @Tabela(Coluna = "Comprador", Indice = 2)
    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    @Tabela(Coluna = "Preço", Indice = 4)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0.0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço para o produto deve ser maior ou igual a zero.");
        }

    }

    @Tabela(Coluna = "Total", Indice = 6)
    public double getPrecoFinal() {
        return this.precoFinal = (floor((this.getPreco() * this.getDesconto()) / 100));
    }

    public void setPrecoFinal(double precoFinal) {
        if (precoFinal >= 0) {
            this.precoFinal = precoFinal;
        } else {
            throw new IllegalArgumentException("O preço para o produto deve ser maior ou igual a zero.");
        }
    }

    @Tabela(Coluna = "Desconto", Indice = 5)
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if (desconto >= 0) {
            this.desconto = desconto;
        } else {
            throw new IllegalArgumentException("O Id deve ser maior ou igual a zero.");
        }
    }

    @Tabela(Coluna = "Data da venda", Indice = 1)
    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!data.isEmpty()) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("Data invalida.");
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 || hora <= 24) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora invalida!");
        }
    }

    public int getMes() {

        return mes;
    }

    public void setMes(int mes) {
        if (mes > 0 || mes <= 12) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mês invalido!");
        }

    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("O Id deve ser maior ou igual a zero.");
        }
    }

    public int getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setTotalDeVendas(int totalDeVendas) {
        if (totalDeVendas >= 0) {
            this.totalDeVendas = totalDeVendas;
        } else {
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero.");
        }
    }
    private static final Logger LOG = getLogger(ModelVenda.class.getName());
}

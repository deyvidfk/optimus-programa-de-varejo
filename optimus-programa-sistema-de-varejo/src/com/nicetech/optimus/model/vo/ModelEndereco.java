package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.jTable.Tabela;

public class ModelEndereco {

    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    
    
        @Tabela(Coluna = "Bairro", Indice = 8)
    
    public String getBairro() {
        return this.bairro;
        //
    }

    @Tabela(Coluna = "CEP", Indice = 12)
    
    public String getCep() {
        return this.cep;
        //
    }

    @Tabela(Coluna = "Cidade", Indice = 5)
    
    public String getCidade() {

        return this.cidade;
        //
    }

    @Tabela(Coluna = "Complemento", Indice = 11)
    
    public String getComplemento() {
        return this.complemento;
        //
    }

    @Tabela(Coluna = "Estado", Indice = 6)
    
    public String getEstado() {
        return this.estado;
        //
    }

    @Tabela(Coluna = "Numero", Indice = 10)
    
    public String getNumero() {
        return this.numero;

    }

    @Tabela(Coluna = "Pais", Indice = 7)
    
    public String getPais() {
        return this.pais;

    }

    @Tabela(Coluna = "Rua", Indice = 9)
    
    public String getRua() {
        return this.rua;

    }

    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    public void setCep(String cep) {
        this.cep = cep;
    }

    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    public void setRua(String rua) {
        this.rua = rua;
    }
}

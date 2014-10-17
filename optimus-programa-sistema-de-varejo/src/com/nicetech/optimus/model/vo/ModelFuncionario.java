package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.Cargo;
import com.nicetech.optimus.utils.jTable.Tabela;

public class ModelFuncionario extends ModelPessoaFisica {

    
    
    private Cargo cargo;

    @Tabela(Coluna = "Cargo", Indice = 0)
    public Cargo getCargo() {
        return cargo;
    }
    @Tabela(Coluna = "CPF", Indice = 2)
    @Override
   
    public String getCpf() {
        return cpf;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


}

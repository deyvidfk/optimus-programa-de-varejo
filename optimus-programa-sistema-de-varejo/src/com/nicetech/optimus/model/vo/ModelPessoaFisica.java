package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.GerarID;
import com.nicetech.optimus.utils.Regex;
import com.nicetech.optimus.utils.anotacao.RegularExpressionValidator;
import com.nicetech.optimus.utils.anotacao.RequiredValidation;
import com.nicetech.optimus.utils.jTable.Tabela;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class ModelPessoaFisica {

    public ModelPessoaFisica() {
        this.id = new GerarID().getId();
    }

    private String id;
    private String apelido;
    private String cpf;
    private String rg;
    private String nome;
    private Integer idade;
    private ModelEndereco endereco;
    private ModelContato contato;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        if (!apelido.isEmpty()) {
            this.apelido = apelido;
        }
    }

    @RequiredValidation(Required = true, label = "CPF", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.CPF, Label = "CPF", RegexErrorMessage = "CPF Inválido")
    @Tabela(Coluna = "CPF", Indice = 2)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.isEmpty()) {
            this.cpf = cpf;
        }
    }

    @RequiredValidation(Required = true, label = "RG", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.RG, Label = "RG", RegexErrorMessage = "RG Inválido")
    @Tabela(Coluna = "RG", Indice = 1)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {

        this.rg = rg;

    }

    /**
     * @return the Coluna
     */
    @RequiredValidation(Required = true, label = "Nome", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.NOME_E_SOBRENOME, Label = "Nome", RegexErrorMessage = "Nome Inválido")
    @Tabela(Coluna = "Nome", Indice = 0)
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) {

        this.nome = nome;

    }

    /**
     * @return the idade
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(Integer idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    @RequiredValidation(Required = true, label = "ID", MaximumValue = 50, MinimumValue = 1)
    @Tabela(Coluna = "ID", Indice = 13)
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private static final Logger LOG = getLogger(ModelPessoaFisica.class.getName());

    public ModelEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(ModelEndereco endereco) {
        this.endereco = endereco;
    }

    public ModelContato getContato() {
        return contato;
    }

    public void setContato(ModelContato contato) {
        this.contato = contato;
    }
}

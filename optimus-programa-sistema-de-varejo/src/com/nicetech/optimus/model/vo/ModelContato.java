package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.Regex;
import com.nicetech.optimus.utils.anotacao.RegularExpressionValidator;
import com.nicetech.optimus.utils.anotacao.RequiredValidation;
import com.nicetech.optimus.utils.jTable.Tabela;

public class ModelContato {

    private String telefone;
    private String email;
    private String site;

    @RequiredValidation(Required = true, label = "E-MAIL", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.EMAIL, Label = "E-mail", RegexErrorMessage = "E-mail Inválido")
    @Tabela(Coluna = "E-Mail", Indice = 4)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return this.site;
        //
    }

    @RequiredValidation(Required = true, label = "Telefone", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = Regex.TELEFONE, Label = "Telefone", RegexErrorMessage = "Telefone Inválido")
    @Tabela(Coluna = "Telefone", Indice = 3)

    public String getTelefone() {
        return this.telefone;
        //
    }

    public void setSite(String site) {
        this.site = site;
        //
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;

    }
}

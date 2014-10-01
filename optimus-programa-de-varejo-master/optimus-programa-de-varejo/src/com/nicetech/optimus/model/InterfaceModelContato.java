package com.nicetech.optimus.model;

import com.nicetech.optimus.utils.Regex;
import com.nicetech.optimus.utils.anotacao.RegularExpressionValidator;
import com.nicetech.optimus.utils.anotacao.RequiredValidation;
import com.nicetech.optimus.utils.jTable.Tabela;

public interface InterfaceModelContato {
    
     @RequiredValidation(Required = true, label = "E-MAIL", MaximumValue = 50, MinimumValue = 1)
    @RegularExpressionValidator(ValidationExpression = Regex.EMAIL, Label = "E-mail", RegexErrorMessage = "E-mail Inválido")
    @Tabela(Coluna = "E-Mail", Indice = 4)
    
    String getEmail();

    String getSite();

    String getTelefone();

    void setEmail(String email);

    void setSite(String site);

    void setTelefone(String telefone);

}

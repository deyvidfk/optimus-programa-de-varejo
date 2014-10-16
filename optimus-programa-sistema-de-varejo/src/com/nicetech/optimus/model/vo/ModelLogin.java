package com.nicetech.optimus.model.vo;

import static com.nicetech.optimus.utils.EncriptString.decrypt;
import static com.nicetech.optimus.utils.EncriptString.encrypt;
import com.nicetech.optimus.utils.Regex;
import com.nicetech.optimus.utils.anotacao.RegularExpressionValidator;
import com.nicetech.optimus.utils.anotacao.RequiredValidation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;


public class ModelLogin {

    private String id;
    private String username;
    private String pass;
    private List<ModelModuloAcesso> modulo;

    /**
     * @return the username
     * @throws java.security.GeneralSecurityException
     * @throws java.io.UnsupportedEncodingException
     */
    @RequiredValidation(Required = true, label = "Login", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = Regex.LOGIN_ADM, Label = "Login", RegexErrorMessage = "Login Inválido", EnableErrorMessage = true)
    public String getUsername() throws GeneralSecurityException, UnsupportedEncodingException, IOException {
        return decrypt(this.username);
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        try {
            if (username.length() < 20) {

                this.username = encrypt(username);
            } else {
                throw new IllegalArgumentException("Nome de usuário invalido.");
            }
        } catch (GeneralSecurityException | UnsupportedEncodingException | IllegalArgumentException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * @return the pass
     * @throws java.security.GeneralSecurityException
     * @throws java.io.UnsupportedEncodingException
     */
    @RequiredValidation(Required = true, label = "Senha", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = Regex.LOGIN_ADM, Label = "Senha", RegexErrorMessage = "Senha Inválido", EnableErrorMessage = true)
    public String getPass() throws GeneralSecurityException, UnsupportedEncodingException, IOException {
        return decrypt(this.pass);
    }

    /**
     * @param pass the pass to set
     * @throws java.security.GeneralSecurityException
     * @throws java.io.UnsupportedEncodingException
     */
    public void setPass(String pass) throws GeneralSecurityException, UnsupportedEncodingException {
        this.pass = encrypt(pass);
    }


    /**
     * @return the modulo
     */
    public List<ModelModuloAcesso> getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(List<ModelModuloAcesso> modulo) {
        this.modulo = modulo;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    private static final Logger LOG = getLogger(ModelLogin.class.getName());

}

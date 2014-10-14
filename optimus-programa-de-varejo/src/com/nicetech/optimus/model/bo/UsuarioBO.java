/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicetech.optimus.model.bo;

import com.nicetech.optimus.model.dao.DaoLogin;
import com.nicetech.optimus.model.dao.DaoPessoaFisica;
import com.nicetech.optimus.model.vo.ModelLogin;
import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import static com.nicetech.optimus.utils.ValidaForm.isValid;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author Deyvid
 */
public class UsuarioBO {

    public boolean cadastrarLogin(ModelPessoaFisica user) {
        DaoPessoaFisica userDAO = new DaoPessoaFisica();
        if (isValid(user)) {
            DaoPessoaFisica.getUsuario().add(user);
            userDAO.createXml(DaoPessoaFisica.getUsuario());
            return true;
        }
        return false;
    }

    private static final Logger LOG = getLogger(LoginBO.class.getName());

}

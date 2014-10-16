package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.ModuloAcesso;
import com.nicetech.optimus.model.bo.LoginBO;
import com.nicetech.optimus.model.vo.ModelLogin;
import com.nicetech.optimus.view.CadastroLoginView;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.swing.JOptionPane;

public class CadastroLoginController {

    private final CadastroLoginView frmCadastroLogin;

    public CadastroLoginController(CadastroLoginView frmCadastroLogin) {
        this.frmCadastroLogin = frmCadastroLogin;
    }

    public void cadastrarLogin() throws GeneralSecurityException, UnsupportedEncodingException {
        ModelLogin loginModel = new ModelLogin();
        loginModel.setUsername(frmCadastroLogin.getTxtUserName().getText());
        loginModel.setPass(frmCadastroLogin.getTxtPass().getText());
        loginModel.setModulo(new ModuloAcesso().getModuloAcessoDefault());
        LoginBO lbo = new LoginBO();
        boolean ok = lbo.cadastrarLogin(loginModel);
        if (ok) {
            JOptionPane.showMessageDialog(frmCadastroLogin, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(frmCadastroLogin, "Erro ao cadastrar Login.");
        }
    }
}

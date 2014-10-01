package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.Sessao;
import com.nicetech.optimus.model.bo.ModuloAcesso;
import com.nicetech.optimus.model.dao.DaoLogin;
import com.nicetech.optimus.model.vo.ModelLogin;
import com.nicetech.optimus.view.LoginView;
import com.nicetech.optimus.view.MDIView;
import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginController {

    private final LoginView frmLogin;


    public LoginController(LoginView frmLogin) {
        this.frmLogin = frmLogin;
    }

    public ModelLogin checkLogin(String username, String pass) {

        try {
            for (int i = 0; i < DaoLogin.getLogin().size(); i++) {
                if (DaoLogin.getLogin().get(i).getUsername().equals(username) && DaoLogin.getLogin().get(i).getPass().equals(pass)) {
                    return DaoLogin.getLogin().get(i);
                }
            }
        } catch (IOException | GeneralSecurityException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    public void autenticaLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        ModelLogin loginCallBack;
        loginCallBack = checkLogin(this.frmLogin.getTxtUserName().getText(), this.frmLogin.getTxtPass().getText());

        if (loginCallBack != null) {
            Sessao sessao = new Sessao(loginCallBack);
            sessao.newSessao();
            ModuloAcesso acesso = new ModuloAcesso();
            MDIView frmMdi = new MDIView(acesso.getModuloAcesso(loginCallBack.getId()));
            frmMdi.pack();
            frmMdi.setVisible(true);
            frmMdi.setLocationRelativeTo(null);
        } else {
            this.frmLogin.getLblLogin().setForeground(Color.red);
            this.frmLogin.getLblPass().setForeground(Color.red);
            this.frmLogin.getLblLogin().setText(null);
            this.frmLogin.getLblPass().setText(null);
        }
    }
}

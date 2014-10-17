/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.UsuarioBO;
import com.nicetech.optimus.view.CadastroUsuarioView;
import javax.swing.JOptionPane;

/**
 *
 * @author Deyvid Franklin
 */
public class UsuarioController {

    CadastroUsuarioView frmUsuarioView;

    public UsuarioController(CadastroUsuarioView aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cadastrarUsuario() {
        UsuarioBO bo = new UsuarioBO();
        boolean ok = bo.cadastrarUsuario("idFuncionario", frmUsuarioView.getTxtLogin(), frmUsuarioView.getTxtSenha(), "Privilegio");
        if (ok) {
            JOptionPane.showMessageDialog(frmUsuarioView, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(frmUsuarioView, "Erro ao cadastrar Login.");
        }
    }

}

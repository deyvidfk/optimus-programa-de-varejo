package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.FuncionarioBO;
import com.nicetech.optimus.view.CadastroFuncionarioView;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.swing.JOptionPane;

public class FuncionarioController {

    private final CadastroFuncionarioView frmFuncionario;

    public FuncionarioController(CadastroFuncionarioView frmFuncionario) {
        this.frmFuncionario = frmFuncionario;
    }

    public void cadastrar() throws GeneralSecurityException, UnsupportedEncodingException {
        FuncionarioBO instanceFuncBO = new FuncionarioBO();
        boolean ok = instanceFuncBO.cadastrar(this.frmFuncionario.getTxtNome().getText(), this.frmFuncionario.getTxtRg().getText(), this.frmFuncionario.getTxtCpf().getText(), this.frmFuncionario.getTxtTelefone().getText(), this.frmFuncionario.getTxtEmail().getText(), this.frmFuncionario.getTxtSite().getText(), this.frmFuncionario.getTxtPais().getText(), this.frmFuncionario.getTxtEstado().getText(), this.frmFuncionario.getTxtCidade().getText(), this.frmFuncionario.getTxtCep().getText(), this.frmFuncionario.getTxtBairro().getText(), this.frmFuncionario.getTxtRua().getText(), this.frmFuncionario.getTxtNumero().getText(), this.frmFuncionario.getTxtComplemento().getText());
        if (ok) {
            JOptionPane.showMessageDialog(frmFuncionario, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(frmFuncionario, "Erro ao cadastrar Login.");
        }
    }

    public void delete(int linha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(String id, String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String text12) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean creat(String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String text12) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int numeroDeRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}

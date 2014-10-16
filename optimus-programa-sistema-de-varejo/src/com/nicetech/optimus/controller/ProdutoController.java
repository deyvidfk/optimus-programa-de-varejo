package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.ProdutoBO;
import com.nicetech.optimus.view.CadastroProdutoView;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.swing.JOptionPane;

public class ProdutoController {
    
  private CadastroProdutoView frmProduto;

    public ProdutoController(CadastroProdutoView frmProduto) {
        this.frmProduto = frmProduto;
    }
  
    
    
    public void cadastrar() throws GeneralSecurityException, UnsupportedEncodingException {
        ProdutoBO instanceProdutoBO = new ProdutoBO();
        boolean ok = instanceProdutoBO.cadastrar(this.frmProduto.getTxtNome().getText(), this.frmProduto.getTxtMarca().getText(), this.frmProduto.getTxtModelo().getText(), this.frmProduto.getTxtTipo().getText(), this.frmProduto.getTxtCor().getText(), this.frmProduto.getTxtDescricao().getText(), this.frmProduto.getTxtPreco().getText(), this.frmProduto.getTxtDesc().getText(), this.frmProduto.getTxtGarantia().getText());
        if (ok) {
            JOptionPane.showMessageDialog(frmProduto, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(frmProduto, "Erro ao cadastrar Login.");
        }
    }
}

package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.ProdutoBO;
import com.nicetech.optimus.model.dao.DaoProduto;
import com.nicetech.optimus.model.vo.ModelJTable;
import com.nicetech.optimus.model.vo.ModelProduto;
import com.nicetech.optimus.utils.jTable.CellRenderer;
import com.nicetech.optimus.view.CadastroProdutoView;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;

public class JtableProduto {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _modelJtable;
    private static CadastroProdutoView _viewFrmProduto;

    /**
     * GETTERS E SETTERS *
     */
    public static ModelJTable getModelJtable() {
        return _modelJtable;
    }

    public static void setModelJtable(ModelJTable aModelJtable) {
        _modelJtable = aModelJtable;
    }

    public static void setViewFrm(CadastroProdutoView aViewFrmProduto) {
        _viewFrmProduto = aViewFrmProduto;
    }

    /**
     * CONSTRUTOR DA CLASSE
     */
    public JtableProduto(CadastroProdutoView ViewProduto) {
        setViewFrm(ViewProduto);
        DaoProduto d = new DaoProduto();
    }

    /**
     * MÉTODOS *
     */
    public void updateRow(int i, String txtCnpj, String txtRazaoS, String txtSetorDeAtuacao, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        this.getViewFrm().getjTableProduto().getModel().setValueAt(txtCnpj, i, 0);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(txtRazaoS, i, 1);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(txtSetorDeAtuacao, i, 2);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(telefone, i, 3);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(email, i, 4);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(site, i, 5);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(cidade, i, 6);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(estado, i, 7);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(pais, i, 8);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(bairro, i, 9);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(rua, i, 10);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(numero, i, 11);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(complemento, i, 12);
        this.getViewFrm().getjTableProduto().getModel().setValueAt(cep, i, 13);
    }

    public int getRowCount() {
        return this.getViewFrm().getjTableProduto().getModel().getRowCount();
    }

    public void popularJtable() {
       // ordenarPorNome();
        try {
            
            ModelJTable tabela = new ModelJTable(ProdutoBO.getProdutos());
            this.getViewFrm().getjTableProduto().setModel(tabela);
            this.getViewFrm().getjTableProduto().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ATUALIZA A TABELA "JTable"
     */
    public void updateJtable() {
//        ((ModelJTable) this.getViewFrm().getjTableProduto().getModel()).addRow();
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        sort(ProdutoBO.getProdutos(), new Comparator<ModelProduto>() {
            @Override
            public int compare(ModelProduto o1, ModelProduto o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

    }

    public void searchRecord(String Output, String idFornecedor) {
        try {
            if (!Output.isEmpty()) {
                 ProdutoBO produto = new ProdutoBO();
                setModelJtable(new ModelJTable(produto.searchRecord(Output, idFornecedor)));
                this.getViewFrm().getjTableProduto().setModel(getModelJtable());
            }
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void searchRecordFiltro(String Output, String idFornecedor) {
        ProdutoBO produto = new ProdutoBO();
        try {
            if (!Output.isEmpty()) {
                setModelJtable(new ModelJTable(produto.searchRecordFiltro(Output, idFornecedor)));
                this.getViewFrm().getjTableProduto().setModel(getModelJtable());
            }
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void searchRecord(String idFornecedor) {
       ProdutoBO produto = new ProdutoBO();
        try {
            ModelJTable tabela = new ModelJTable(produto.searchRecord(idFornecedor));
            this.getViewFrm().getjTableProduto().setModel(tabela);
            this.getViewFrm().getjTableProduto().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public CadastroProdutoView getViewFrm() {
        return _viewFrmProduto;
    }
    private static final Logger LOG = getLogger(JtableProduto.class.getName());
}

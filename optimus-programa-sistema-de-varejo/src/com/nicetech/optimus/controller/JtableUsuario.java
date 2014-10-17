package com.nicetech.optimus.controller;

import static com.nicetech.optimus.model.dao.DaoFuncionario.getFuncionarios;
import com.nicetech.optimus.model.dao.DaoPessoaFisica;
import static com.nicetech.optimus.model.dao.DaoPessoaFisica.getUsuario;
import com.nicetech.optimus.model.vo.ModelJTable;
import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import com.nicetech.optimus.utils.jTable.CellRenderer;
import com.nicetech.optimus.view.CadastroUsuarioView;
import java.awt.Color;
import java.util.ArrayList;
import static java.util.Collections.sort;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.AbstractTableModel;


public class JtableUsuario {

    /**
     * PROPRIEDADES
     */
    private static ModelJTable _modelJtable;
    private static CadastroUsuarioView _viewForm;

    /**
     * CONSTRUTOR DA CLASSE
     */
    public JtableUsuario(CadastroUsuarioView ViewUsuario) {
        setViewFrm(ViewUsuario);
    }

    /**
     * MÉTODOS *
     */
    /**
     * POPULA A TABELA "JTable" COM OS DADOS
     */
    public void popularJtable() {
//        ordenarPorNome();
        try {
            ModelJTable tabela = new ModelJTable(getUsuario());
            this.getViewForm().getjTableLoadUsers().setModel(tabela);
            this.getViewForm().getjTableLoadUsers().setDefaultRenderer(Object.class, new CellRenderer());
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * ATUALIZA A TABELA "JTable"
     */
    public void updateJtable() {
        ((AbstractTableModel) this.getViewForm().getjTableLoadUsers().getModel()).fireTableDataChanged();
    }

    /**
     * ATUALIZA REGISTRO NA LINHA ALTERADA INDICADA PELO ID
     */
    public void updateRow(int i, String nome, String rg, String cpf, String telefone, String email, String site, String cidade, String estado, String pais, String bairro, String rua, String numero, String complemento, String cep) {
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(nome, i, 0);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(rg, i, 1);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(cpf, i, 2);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(telefone, i, 3);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(email, i, 4);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(site, i, 5);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(cidade, i, 6);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(estado, i, 7);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(pais, i, 8);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(bairro, i, 9);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(rua, i, 10);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(numero, i, 11);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(complemento, i, 12);
        this.getViewForm().getjTableLoadUsers().getModel().setValueAt(cep, i, 13);
    }

    /**
     * ORDENA OS REGISTROS DA TABELA POR NOME EM ORDEM ALFABETICA
     */
    public void ordenarPorNome() {
        //ordena pelo nome
        sort(getFuncionarios(), new Comparator<ModelPessoaFisica>() {
            @Override
            public int compare(ModelPessoaFisica o1, ModelPessoaFisica o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    public void moveRecord(int i) {
        this.getViewForm().getTxtLogin().setText(getFuncionarios().get(i).getNome());
 
    }

    /**
     * O METODO PESQUISA O REGISTRO POR NOME. OBS: O METODO FAZ A BUSCA DIRETO
     * NA LISTA ESTATICA JÁ CARREGADA NA MEMORIA, E NÃO NA TABELA “JTable”. APÓS
     * SE O REGISTRO É ENCONTRADO NA LISTA A TABELA É ATUALIZADA.
     */
    public void searchRecord(String Output) {
        if (!Output.isEmpty()) {
            String txtOutput = Output.toUpperCase(Locale.ROOT);
            ArrayList<ModelPessoaFisica> ListaAuxiliar = new ArrayList<>(DaoPessoaFisica.getUsuario());
            ListaAuxiliar.clear();
            for (int index = 0; index < getFuncionarios().size(); index++) {
                if (getFuncionarios().get(index).getRg().toUpperCase(Locale.ROOT).contains(txtOutput) || getFuncionarios().get(index).getCpf().toUpperCase(Locale.ROOT).contains(txtOutput) || getFuncionarios().get(index).getNome().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    if (getFuncionarios().size() > 0) {
                        ListaAuxiliar.add(getFuncionarios().get(index));
                    }
                }
            }

            setModelJtable(new ModelJTable(ListaAuxiliar));
            this.getViewForm().getjTableLoadUsers().setModel(getModelJtable());
            this.getViewForm().getjTableLoadUsers().setBackground(Color.yellow);
        }
    }

    /**
     * GETTERS E SETTERS *
     */
    private CadastroUsuarioView getViewForm() {
        return _viewForm;
    }

    private void setViewFrm(CadastroUsuarioView ViewFrmFornecedor) {
        JtableUsuario._viewForm = ViewFrmFornecedor;
    }

    private ModelJTable getModelJtable() {
        return _modelJtable;
    }

    private void setModelJtable(ModelJTable ModelJtable) {
        JtableUsuario._modelJtable = ModelJtable;
    }
    private static final Logger LOG = getLogger(JtableUsuario.class.getName());
}

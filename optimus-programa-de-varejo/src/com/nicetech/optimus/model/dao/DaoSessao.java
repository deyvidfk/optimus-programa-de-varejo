package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelSessao;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;


public final class DaoSessao implements DaoInterface {

    private static List<ModelSessao> _sessao;

    private final Source CONEXAO_DB;


    public DaoSessao() {

       this.CONEXAO_DB = new Source("db-sessao.xml");
        _sessao = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.escreverXml(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelSessao> readXml() {
        return (List<ModelSessao>) this.CONEXAO_DB.getDados();
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final Logger LOG = getLogger(DaoSessao.class.getName());
}

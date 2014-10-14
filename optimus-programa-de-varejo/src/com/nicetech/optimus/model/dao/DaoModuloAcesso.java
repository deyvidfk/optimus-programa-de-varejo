package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelModuloAcesso;
import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;


public final class DaoModuloAcesso implements CRUDStrategy {

    private static List<ModelModuloAcesso> _moduloAcesso;
    private final Source CONEXAO_DB;
    
    public DaoModuloAcesso() {
        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_MODULO_ACESSO);
        _moduloAcesso = (List<ModelModuloAcesso>) readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.escreverXml(data);
    }

    @Override
    public List<?> readXml() {
        return (List<ModelPessoaFisica>) this.CONEXAO_DB.getDados();
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final Logger LOG = getLogger(DaoModuloAcesso.class.getName());
}

package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelProduto;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public final class DaoProduto implements CRUDStrategy {

    public static List<ModelProduto> _produto;

    public static List<ModelProduto> getProdutos() {
        return DaoProduto._produto;
    }

    private final Source CONEXAO_DB;

    public DaoProduto() {
        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_PRODUTO);
        _produto = readXml();
    }

    @Override
    public void deleteXml(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.escreverXml(data);
    }

    @Override
    public List<ModelProduto> readXml() {
        return (List<ModelProduto>) this.CONEXAO_DB.getDados();
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    private static final Logger LOG = getLogger(DaoProduto.class.getName());
}

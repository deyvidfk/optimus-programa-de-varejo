package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;


public final class DaoPessoaFisica implements CRUDStrategy {

    public static List<ModelPessoaFisica> _pf;

    public static List<ModelPessoaFisica> getUsuario() {
        return DaoPessoaFisica._pf;
    }

    private final Source CONEXAO_DB;

    public DaoPessoaFisica() {

        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_USUARIO);
        DaoPessoaFisica._pf = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.escreverXml(data);
    }

    @Override
    public void updateXml(List<?> data) {
        createXml(data);
    }

    public String getNomePeloId(int id) {
        return _pf.get(id).getNome();
    }

    public ModelPessoaFisica getUserPeloId(int id) {
        return _pf.get(id);
    }

    @Override
    public void deleteXml(int id) {
        _pf.remove(id);
        updateXml(_pf);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelPessoaFisica> readXml() {
        return (List<ModelPessoaFisica>) this.CONEXAO_DB.getDados();
    }
    private static final Logger LOG = getLogger(DaoPessoaFisica.class.getName());
}

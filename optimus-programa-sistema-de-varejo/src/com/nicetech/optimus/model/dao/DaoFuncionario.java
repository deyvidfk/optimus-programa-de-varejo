package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelFuncionario;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;


public final class DaoFuncionario implements CRUDStrategy {

    private static List<ModelFuncionario> _pessoaJuridica;

    public static List<ModelFuncionario> getFuncionarios() {
        return DaoFuncionario._pessoaJuridica;
    }

    private final Source CONEXAO_DB;

    public DaoFuncionario() {

        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_FUNCIONARIO);
        DaoFuncionario._pessoaJuridica = readXml();
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
        return _pessoaJuridica.get(id).getNome();
    }

    public ModelFuncionario getUserPeloId(int id) {
        return _pessoaJuridica.get(id);
    }

    @Override
    public void deleteXml(int id) {
        _pessoaJuridica.remove(id);
        updateXml(_pessoaJuridica);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelFuncionario> readXml() {
        return (List<ModelFuncionario>) this.CONEXAO_DB.getDados();
    }
    private static final Logger LOG = getLogger(DaoFuncionario.class.getName());
}

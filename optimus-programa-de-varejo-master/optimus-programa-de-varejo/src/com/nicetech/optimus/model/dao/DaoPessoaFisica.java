package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;


public final class DaoPessoaFisica implements CRUDStrategy {

    private static List<ModelPessoaFisica> _pessoaJuridica;

    public static List<ModelPessoaFisica> getUsuario() {
        return DaoPessoaFisica._pessoaJuridica;
    }

    private final Source CONEXAO_DB;

    public DaoPessoaFisica() {

        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_USUARIO);
        DaoPessoaFisica._pessoaJuridica = readXml();
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

    public ModelPessoaFisica getUserPeloId(int id) {
        return _pessoaJuridica.get(id);
    }

    @Override
    public void deleteXml(int id) {
        _pessoaJuridica.remove(id);
        updateXml(_pessoaJuridica);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelPessoaFisica> readXml() {
        return (List<ModelPessoaFisica>) this.CONEXAO_DB.getDados();
    }
    private static final Logger LOG = getLogger(DaoPessoaFisica.class.getName());
}

package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelPessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public final class DaoPessoaJuridica implements CRUDStrategy {

    private static List<ModelPessoaJuridica> _pessoaJuridica;

    /**
     * Buscar registro por nome ou cnpj.
     *
     *
     * @param Output
     * @return
     */
    public static List<ModelPessoaJuridica> searchRecord(String Output) {
        ArrayList<ModelPessoaJuridica> ListaAuxiliar = new ArrayList<>(getFornecedor());
        if (!Output.isEmpty()) {
            String txtOutput = Output.toUpperCase(Locale.ROOT);

            ListaAuxiliar.clear();
            for (int index = 0; index < getFornecedor().size(); index++) {
                if (getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput) || getFornecedor().get(index).getCnpj().toUpperCase(Locale.ROOT).contains(txtOutput)) {
                    if (getFornecedor().size() > 0) {
                        ListaAuxiliar.add(getFornecedor().get(index));
                    }
                }
            }
        }
        return ListaAuxiliar;
    }

    public static List<ModelPessoaJuridica> getFornecedor() {
        return (DaoPessoaJuridica._pessoaJuridica);
    }

    private final Source CONEXAO_DB;


    public DaoPessoaJuridica() {

        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_EMPRESA);
        DaoPessoaJuridica._pessoaJuridica = readXml();
    }

    @Override
    public void createXml(List<?> data) {
        CONEXAO_DB.escreverXml(data);
    }

    @Override
    public void updateXml(List<?> data) {
        createXml(data);
    }

    @Override
    public void deleteXml(int id) {
        _pessoaJuridica.remove(id);
        createXml(_pessoaJuridica);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ModelPessoaJuridica> readXml() {
        return (List<ModelPessoaJuridica>) this.CONEXAO_DB.getDados();
    }
    private static final Logger LOG = getLogger(DaoPessoaJuridica.class.getName());
}

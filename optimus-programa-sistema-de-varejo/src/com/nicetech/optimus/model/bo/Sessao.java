package com.nicetech.optimus.model.bo;

import com.nicetech.optimus.model.dao.DaoSessao;
import com.nicetech.optimus.model.vo.ModelLogin;
import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import com.nicetech.optimus.model.vo.ModelSessao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class Sessao {

    private ModelPessoaFisica user;
    private ModelSessao sessao;
    private static DaoSessao dao;
    private final List<ModelSessao> list;
    private final ModelLogin dataLogin;

    public Sessao(ModelLogin login) {
        list = new ArrayList<>();
        dataLogin = login;
    }

    public void newSessao() {
        sessao = new ModelSessao(dataLogin.getId());
        list.add(sessao);
        dao = new DaoSessao();
        dao.createXml(list);
    }

    public static List<ModelSessao> getSessao() {
        dao = new DaoSessao();
        return dao.readXml();
    }
    private static final Logger LOG = getLogger(Sessao.class.getName());
}

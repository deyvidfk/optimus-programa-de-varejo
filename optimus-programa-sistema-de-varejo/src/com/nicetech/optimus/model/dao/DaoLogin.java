package com.nicetech.optimus.model.dao;

import com.nicetech.optimus.model.vo.ModelLogin;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public final class DaoLogin implements CRUDStrategy {

    public static List<ModelLogin> _login;

    public static List<ModelLogin> getLogin() {
        return DaoLogin._login;
    }

    private final Source CONEXAO_DB;

    public DaoLogin() {
        this.CONEXAO_DB = new Source(XMLSource.OPTMUSDB_LOGIN);
        _login = readXml();
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
    public List<ModelLogin> readXml() {
        return (List<ModelLogin>) this.CONEXAO_DB.getDados();
    }

    @Override
    public void updateXml(List<?> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<ModelLogin> getLogins() {
        return (DaoLogin._login);
    }
    private static final Logger LOG = getLogger(DaoLogin.class.getName());
}

package com.nicetech.optimus.model.bo;

import com.nicetech.optimus.model.dao.CRUDStrategy;
import com.nicetech.optimus.model.dao.DaoLogin;
import com.nicetech.optimus.model.vo.ModelLogin;
import static com.nicetech.optimus.utils.ValidaForm.isValid;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class LoginBO {

    public boolean cadastrarLogin(ModelLogin login) {
        CRUDStrategy loginDAO = new DaoLogin();
        if (isValid(login)) {
            DaoLogin.getLogin().add(login);
            loginDAO.createXml(DaoLogin.getLogin());
            return true;
        }
        return false;
    }

    private static final Logger LOG = getLogger(LoginBO.class.getName());
}

package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.GerarID;
import java.util.Date;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class ModelSessao {

    private final String idSessao;
    private final String iduser;
    private final Date hora;

    public ModelSessao(String iduser) {
        this.idSessao = new GerarID().getId();
        this.iduser = iduser;
        this.hora = new Date();
    }

    /**
     * @return the idSessao
     */
    public String getIdSessao() {
        return idSessao;
    }

    /**
     * @return the hora
     */
    public Date getHora() {
        return hora;
    }

    public String getIduser() {
        return iduser;
    }

    private static Logger LOG = getLogger(ModelSessao.class.getName());

}

package com.nicetech.optimus.model.vo;

import com.nicetech.optimus.utils.GerarID;

/**
 *
 * @author Deyvid
 */
public class ModelNotaFiscal {
   
    String idNotaFiscal;
    ModelVenda idVenda;

    public ModelNotaFiscal(String idNotaFiscal) {
        this.idNotaFiscal = new GerarID().getId();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicetech.optimus.model.dao;

/**
 *
 * @author Deyvid
 */
public enum XMLSource {

    OPTMUSDB_USUARIO("optimos-source-usuario.xml"), OPTMUSDB_MODULO_ACESSO("optimos-source-moduloacesso.xml"), OPTMUSDB_SESSAO("optimos-source-sessao.xml"), OPTMUSDB_LOGIN("optimos-source-login.xml"), OPTMUSDB_EMPRESA("optimos-source-empresa.xml");

    private final String fileName;

    private XMLSource(String filename) {
        fileName = filename;
    }

    public String getFileName() {
        return fileName;
    }

}

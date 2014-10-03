package com.nicetech.optimus.controller;

import com.nicetech.optimus.model.bo.Menu;
import com.nicetech.optimus.view.MDIView;
import java.util.List;

public class MDIController {

    private final MDIView frmMdi;

    public MDIController(MDIView frmMdi) {
        this.frmMdi = frmMdi;
    }

    public void checarAcessoAosMenus(List<Menu> m) {
        frmMdi.getjMenuConsulta().setVisible(false);
        frmMdi.getjMenuSistema().setVisible(false);
        frmMdi.getjMenuCadastro().setVisible(false);
        frmMdi.getjMenuRelatorio().setVisible(false);
        frmMdi.getjMenuSistema().setVisible(false);
        for (Menu m1 : m) {
            switch (m1) {
                case CONSULTA:
                    frmMdi.getjMenuConsulta().setVisible(true);
                    break;
                case SISTEMA:
                    frmMdi.getjMenuSistema().setVisible(true);
                    break;
                case CADASTRO:
                    frmMdi.getjMenuCadastro().setVisible(true);
                    break;
                case RELATORIO:
                    frmMdi.getjMenuRelatorio().setVisible(true);
                    break;
                case SOBRE:
                    frmMdi.getjMenuSistema().setVisible(true);
                    break;
                default:
                //frmMdi.fileMenu.setVisible(true);
            }
        }
    }

}

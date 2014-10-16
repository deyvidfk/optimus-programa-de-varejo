package com.nicetech.optimus.model.bo;

import com.nicetech.optimus.model.dao.CRUDStrategy;
import com.nicetech.optimus.model.dao.DaoFuncionario;
import com.nicetech.optimus.model.vo.ModelContato;
import com.nicetech.optimus.model.vo.ModelEndereco;
import com.nicetech.optimus.model.vo.ModelFuncionario;
import static com.nicetech.optimus.utils.ValidaForm.isValid;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class FuncionarioBO {

    private final CRUDStrategy dao;

    public FuncionarioBO() {
        this.dao = new DaoFuncionario();
    }

    public List<ModelFuncionario> getFuncionarios() {
        return DaoFuncionario.getFuncionarios();
    }

    public boolean cadastrar(String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String txtComplemento) {

        ModelFuncionario func = new ModelFuncionario();
        func.setNome(text);
        func.setRg(text);
        func.setCpf(text);
        ModelContato cont = new ModelContato();
        cont.setTelefone(text11);
        cont.setEmail(text11);
        cont.setSite(text9);

        ModelEndereco end = new ModelEndereco();
        end.setPais(text);
        end.setEstado(text11);
        end.setCidade(text11);
        end.setCep(text);
        end.setBairro(text11);
        end.setRua(text);
        end.setNumero(text);
        end.setComplemento(txtComplemento);

        func.setContato(cont);
        func.setEndereco(end);

        if (isValid(func)) {
            DaoFuncionario.getFuncionarios().add(func);
            this.dao.createXml(DaoFuncionario.getFuncionarios());
            return true;
        }
        return false;
    }

    private static final Logger LOG = getLogger(LoginBO.class.getName());
}

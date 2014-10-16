package com.nicetech.optimus.model.bo;

import com.nicetech.optimus.model.bo.Menu;
import com.nicetech.optimus.controller.LoginController;
import com.nicetech.optimus.model.bo.ModuloAcesso;
import com.nicetech.optimus.model.bo.LoginBO;
import com.nicetech.optimus.model.bo.MensagensDoSistema;
import com.nicetech.optimus.model.bo.UsuarioBO;
import com.nicetech.optimus.model.dao.DaoPessoaFisica;
import com.nicetech.optimus.model.vo.ModelLogin;
import com.nicetech.optimus.model.vo.ModelPessoaFisica;
import com.nicetech.optimus.utils.GerarID;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;

public class UserDefault1 {

    private static final Logger LOG = getLogger(UserDefault1.class.getName());
    private final String USER_LOGIN_DEFAULT = "adm";
    private final String USER_SENHA_DEFAULT = "adm";
    private final String USER_ID_DEFAULT = new GerarID().getId();

    static {
        System.out.println(LOG.getName());
    }

    public UserDefault1() {
    }

    public boolean getStatusSistema() {

        DaoPessoaFisica pf = new DaoPessoaFisica();

        return !pf.getUsuario().isEmpty();
    }

    public void criaDadosDoUsuarioDefault() {
        try {
            ModelPessoaFisica user = new ModelPessoaFisica();
            user.setNome("ADM");
            user.setRg("12.123.123-1");
            user.setCpf("000.000.000-00");
            user.setTelefone("(11) 0000-0000");
            user.setEmail("exemplo@exemplo.com");
            user.setSite("exemplo.com.br");
            user.setCidade("São Paulo");
            user.setEstado("SP");
            user.setPais("Brasil");
            user.setBairro("JD");
            user.setRua("Rua");
            user.setNumero("0");
            user.setComplemento("complem.");
            user.setCep("04872-290");

            ModelLogin loginModel = new ModelLogin();
            loginModel.setId(user.getId());
            loginModel.setUsername(USER_LOGIN_DEFAULT);
            loginModel.setPass(USER_SENHA_DEFAULT);

            UsuarioBO userBO = new UsuarioBO();
            userBO.cadastrarLogin(user);

            LoginBO loginBO = new LoginBO();
            loginBO.cadastrarLogin(loginModel);

            List menu = new ArrayList<>();
            menu.add(Menu.SISTEMA);
            menu.add(Menu.CADASTRO_GERAL);
            menu.add(Menu.CADASTRO);
            menu.add(Menu.RELATORIO_GERAL);
            menu.add(Menu.RELATORIO);
            menu.add(Menu.CONSULTA);
            ModuloAcesso moduloAcesso = new ModuloAcesso();
            moduloAcesso.addModuloAcesso(user.getId(), menu);
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
        }
    }

    public ModelLogin criaUsuarioDefault() {
        criaDadosDoUsuarioDefault();
        LoginController loginController = new LoginController(null);
        ModelLogin loginCallBack = loginController.checkLogin(USER_LOGIN_DEFAULT, USER_SENHA_DEFAULT);
        if (loginCallBack != null) {

            showMessageDialog(null, MensagensDoSistema.SISTEMA.MSG_000_0.getCodigo() + "\n" + MensagensDoSistema.SISTEMA.MSG_000_0.getMenssagem());
            return loginCallBack;
        }
       return null;
    }
}

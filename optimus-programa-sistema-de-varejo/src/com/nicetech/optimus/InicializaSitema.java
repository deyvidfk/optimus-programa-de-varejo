package com.nicetech.optimus;

import com.nicetech.optimus.model.bo.ModuloAcesso;
import com.nicetech.optimus.model.bo.Sessao;
import com.nicetech.optimus.model.bo.UserDefault1;
import com.nicetech.optimus.model.vo.ModelLogin;
import com.nicetech.optimus.view.LoginView;
import com.nicetech.optimus.view.MDIView;
import java.awt.Color;
import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public final class InicializaSitema {

    /**
     * @param args the commancreatConfigDefault line arguments
     */
    public static void main(String[] args) {
        InicializaSitema start = new InicializaSitema();
        Sistema sistema = start.new Sistema();
    }
    
    @SuppressWarnings("serial")
    public class Sistema extends JWindow {
        
        private final AbsoluteLayout absoluto;
        private final AbsoluteConstraints absimage;
        private AbsoluteConstraints absbarra;
        private final ImageIcon image;
        private final JLabel jLabel;
        private final JProgressBar barra;
        private final String LOGOTIPO_DSELL = "logo-5.png";
        
        public Sistema() {
            
            absoluto = new AbsoluteLayout();
            absimage = new AbsoluteConstraints(0, 0);
            absbarra = new AbsoluteConstraints(0, 309);
            absbarra = new AbsoluteConstraints(0, 280);
            jLabel = new JLabel();
            image = new ImageIcon(this.getClass().getResource(LOGOTIPO_DSELL));
            jLabel.setIcon(image);
            barra = new JProgressBar();
            barra.setPreferredSize(new Dimension(1300, 5));
            
            this.getContentPane().setLayout(absoluto);
            this.getContentPane().add(jLabel, absimage);
            this.getContentPane().add(barra, absbarra);
            this.getContentPane().setBackground(Color.WHITE);
            this.setOpacity(0.5f);
  
            
            new Thread() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 101) {
                        getBarra().setValue(i);
                        i++;
                        try {
                            sleep(20);
                        } catch (InterruptedException ex) {
                            getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    UserDefault1 us = new UserDefault1();
                    //Verifica se já existe algum usuário cadastrado
                    if (us.getStatusSistema()) {
                        LoginView frmLogin = new LoginView();
                        frmLogin.pack();
                        frmLogin.setVisible(true);
                        frmLogin.setLocationRelativeTo(null);
                        dispose();
                        
                    } else {
                        
                        ModelLogin loginCallBack = us.criaUsuarioDefault();
                        if (loginCallBack != null) {
                            Sessao sessao = new Sessao(loginCallBack);
                            sessao.newSessao();
                            ModuloAcesso moduloAcessoBO = new ModuloAcesso();
                            MDIView frmMDIView = new MDIView(moduloAcessoBO.getModuloAcesso(loginCallBack.getId()));
                            frmMDIView.pack();
                            frmMDIView.setVisible(true);
                            frmMDIView.setLocationRelativeTo(null);
                        }                        
                    }
                }
            }.start();
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        }
        
        private JProgressBar getBarra() {
            return barra;
        }
    }
    
    private static final Logger LOG = getLogger(InicializaSitema.class.getName());
}

package com.nicetech.optimus.view;

import com.nicetech.optimus.controller.MDIController;
import com.nicetech.optimus.model.bo.ConfigLayout;
import java.awt.Color;
import static java.lang.System.exit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;

public final class MDIView extends javax.swing.JFrame {

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger aLOG) {
        LOG = aLOG;
    }

    private ImageIcon image;
    private SobreView formSobre;
    private String menu;

    /**
     * Creates new form FrmMDI
     */
    public MDIView(List listaMenu) {
        initComponents();
        try {
            setLookAndFeel(ConfigLayout.LookAndFeelDefault.getLookAndFeel());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MDIView.class.getName()).log(Level.SEVERE, null, ex);
        }
        SobreView formSobre = new SobreView();
        getDesktopPane().add(formSobre);
        new MDIController(this).checarAcessoAosMenus(listaMenu);
        //lblDadosSessao.setText("Olá " + getSessao().get(0).getUser().getNome());
        formSobre.setVisible(true);
    }

    public MDIView() {
        super();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        desktopPane = new javax.swing.JDesktopPane();
        lblDadosSessao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuCadastro = new javax.swing.JMenu();
        menuPj = new javax.swing.JMenuItem();
        menuPf = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuConsulta = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuSistema = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        subMenuModuloAcesso = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDadosSessao.setText("Dados da Sessao");
        desktopPane.add(lblDadosSessao);
        lblDadosSessao.setBounds(1050, 10, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nicetech/optimus/logo-2.png"))); // NOI18N
        desktopPane.add(jLabel1);
        jLabel1.setBounds(10, -10, 510, 220);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1.setLayer(desktopPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        fileMenu.setMnemonic('f');
        fileMenu.setText("...");

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem6.setText("Sobre");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem6);

        menuBar.add(fileMenu);

        jMenuCadastro.setText("Cadastro");

        menuPj.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuPj.setText("Fornecedor/Produto");
        menuPj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPjActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuPj);

        menuPf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuPf.setText("Usuário");
        menuPf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPfActionPerformed(evt);
            }
        });
        jMenuCadastro.add(menuPf);

        jMenuItem7.setText("Login");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem7);

        jMenuItem8.setText("Cliente");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem8);

        jMenuItem10.setText("Funcionario");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem10);

        jMenuItem11.setText("Produto");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem11);

        menuBar.add(jMenuCadastro);

        jMenuRelatorio.setText("Relatório");

        jMenuItem4.setText("Fornecedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem4);

        jMenuItem5.setText("Vendas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem5);

        menuBar.add(jMenuRelatorio);

        jMenuConsulta.setText("Consultar");

        jMenuItem3.setText("Venda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItem3);

        menuBar.add(jMenuConsulta);

        jMenuSistema.setText("Sistema");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Ajuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuSistema.add(jMenuItem1);

        subMenuModuloAcesso.setText("Modulo Acesso");
        subMenuModuloAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuModuloAcessoActionPerformed(evt);
            }
        });
        jMenuSistema.add(subMenuModuloAcesso);

        menuBar.add(jMenuSistema);

        jMenu1.setText("Estoque");

        jMenuItem9.setText("Entrada");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void menuPjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPjActionPerformed
        CadastroFornecedorView cadastroFornecedorView = new CadastroFornecedorView();
        getDesktopPane().add(cadastroFornecedorView);
        cadastroFornecedorView.setVisible(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuPjActionPerformed

    private void menuPfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPfActionPerformed
        CadastroUsuarioView cadastroUsuarioViewView = new CadastroUsuarioView();
        getDesktopPane().add(cadastroUsuarioViewView);
        cadastroUsuarioViewView.setVisible(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);

    }//GEN-LAST:event_menuPfActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed


    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void subMenuModuloAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuModuloAcessoActionPerformed

    }//GEN-LAST:event_subMenuModuloAcessoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        setFormSobre(new SobreView());
        if (!formSobre.isVisible()) {
            getDesktopPane().add(getFormSobre());
            getFormSobre().setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        CadastroLoginView instaceFrmLoginCadastroView = new CadastroLoginView();
        if (!instaceFrmLoginCadastroView.isVisible()) {
            getDesktopPane().add(instaceFrmLoginCadastroView);
            instaceFrmLoginCadastroView.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        CadastroClienteView cadastroClienteView = new CadastroClienteView();
        getDesktopPane().add(cadastroClienteView);
        cadastroClienteView.setVisible(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        CadastroEntradaEstoqueView cadastroEntradaEstoqueView = new CadastroEntradaEstoqueView();
        getDesktopPane().add(cadastroEntradaEstoqueView);
        cadastroEntradaEstoqueView.setVisible(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        CadastroFuncionarioView cadastroFuncionarioView = new CadastroFuncionarioView();
        getDesktopPane().add(cadastroFuncionarioView);
        cadastroFuncionarioView.setVisible(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        CadastroProdutoView cadastroProdutoView  = new CadastroProdutoView();
        getDesktopPane().add(cadastroProdutoView);
        cadastroProdutoView.setVisible(rootPaneCheckingEnabled);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuConsulta;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenu jMenuSistema;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDadosSessao;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuPf;
    private javax.swing.JMenuItem menuPj;
    private javax.swing.JMenuItem subMenuModuloAcesso;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(javax.swing.JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    /**
     * @return the jMenuItem1
     */
    public javax.swing.JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    /**
     * @param jMenuItem1 the jMenuItem1 to set
     */
    public void setjMenuItem1(javax.swing.JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }
    private static Logger LOG = getLogger(MDIView.class.getName());

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public SobreView getFormSobre() {
        return formSobre;
    }

    public void setFormSobre(SobreView formSobre) {
        this.formSobre = formSobre;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public javax.swing.JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public void setExitMenuItem(javax.swing.JMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    public javax.swing.JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(javax.swing.JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public javax.swing.JMenu getjMenuCadastro() {
        return jMenuCadastro;
    }

    public void setjMenuCadastro(javax.swing.JMenu jMenuCadastro) {
        this.jMenuCadastro = jMenuCadastro;
    }

    public javax.swing.JMenu getjMenuConsulta() {
        return jMenuConsulta;
    }

    public void setjMenuConsulta(javax.swing.JMenu jMenuConsulta) {
        this.jMenuConsulta = jMenuConsulta;
    }

    public javax.swing.JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public void setjMenuItem2(javax.swing.JMenuItem jMenuItem2) {
        this.jMenuItem2 = jMenuItem2;
    }

    public javax.swing.JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public void setjMenuItem3(javax.swing.JMenuItem jMenuItem3) {
        this.jMenuItem3 = jMenuItem3;
    }

    public javax.swing.JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public void setjMenuItem4(javax.swing.JMenuItem jMenuItem4) {
        this.jMenuItem4 = jMenuItem4;
    }

    public javax.swing.JMenuItem getjMenuItem5() {
        return jMenuItem5;
    }

    public void setjMenuItem5(javax.swing.JMenuItem jMenuItem5) {
        this.jMenuItem5 = jMenuItem5;
    }

    public javax.swing.JMenuItem getjMenuItem6() {
        return jMenuItem6;
    }

    public void setjMenuItem6(javax.swing.JMenuItem jMenuItem6) {
        this.jMenuItem6 = jMenuItem6;
    }

    public javax.swing.JMenu getjMenuRelatorio() {
        return jMenuRelatorio;
    }

    public void setjMenuRelatorio(javax.swing.JMenu jMenuRelatorio) {
        this.jMenuRelatorio = jMenuRelatorio;
    }

    public javax.swing.JMenu getjMenuSistema() {
        return jMenuSistema;
    }

    public void setjMenuSistema(javax.swing.JMenu jMenuSistema) {
        this.jMenuSistema = jMenuSistema;
    }

    public javax.swing.JLabel getLblDadosSessao() {
        return lblDadosSessao;
    }

    public void setLblDadosSessao(javax.swing.JLabel lblDadosSessao) {
        this.lblDadosSessao = lblDadosSessao;
    }

    public void setMenuBar(javax.swing.JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public javax.swing.JMenuItem getMenuPf() {
        return menuPf;
    }

    public void setMenuPf(javax.swing.JMenuItem menuPf) {
        this.menuPf = menuPf;
    }

    public javax.swing.JMenuItem getMenuPj() {
        return menuPj;
    }

    public void setMenuPj(javax.swing.JMenuItem menuPj) {
        this.menuPj = menuPj;
    }

    public javax.swing.JMenuItem getSubMenuModuloAcesso() {
        return subMenuModuloAcesso;
    }

    public void setSubMenuModuloAcesso(javax.swing.JMenuItem subMenuModuloAcesso) {
        this.subMenuModuloAcesso = subMenuModuloAcesso;
    }
}

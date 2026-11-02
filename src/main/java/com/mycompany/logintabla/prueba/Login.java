package com.mycompany.logintabla.prueba;

import com.mycompany.logintabla.dao.LoginDAO;
import com.mycompany.logintabla.modelo.LoginModel;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private int intentosRestantes = 3;
    private final LoginDAO loginDAO = new LoginDAO();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        lblMensaje.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        txtIngresar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("User:");
        jLabel2.setText("Password:");
        jLabel3.setText("Enter your details");

        txtIngresar.setText("Get into");
        txtIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresarActionPerformed(evt);
            }
        });

        lblMensaje.setForeground(new java.awt.Color(204, 0, 0));
        lblMensaje.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario)
                            .addComponent(txtPassword))))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(txtIngresar)
                .addGap(15, 15, 15)
                .addComponent(lblMensaje)
                .addGap(30, 30, 30))
        );

        pack();
    }
    // </editor-fold>

    private void txtIngresarActionPerformed(java.awt.event.ActionEvent evt) {

        String name     = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (name.isEmpty() || password.isEmpty()) {
            lblMensaje.setText("Completá usuario y contraseña.");
            return;
        }

        LoginModel usuario = loginDAO.autenticar(name, password);

        if (usuario != null) {
            JOptionPane.showMessageDialog(
                this,
                "¡Bienvenido, " + usuario.getName() + "!",
                "Acceso concedido",
                JOptionPane.INFORMATION_MESSAGE
            );
            new MenuPrincipal().setVisible(true);
            this.dispose();

        } else {
            intentosRestantes--;

            if (intentosRestantes > 0) {
                lblMensaje.setText(
                    "Usuario o contraseña incorrectos. Le quedan "
                    + intentosRestantes + " intento(s)."
                );
            } else {
                lblMensaje.setText(
                    "Usuario bloqueado por exceder el número máximo de intentos."
                );
                txtIngresar.setEnabled(false);
                txtUsuario.setEnabled(false);
                txtPassword.setEnabled(false);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JButton txtIngresar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration
}
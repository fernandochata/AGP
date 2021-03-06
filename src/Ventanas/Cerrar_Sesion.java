/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javax.swing.ImageIcon; //PARA ASIGNAR ICONO A LA VENTANA
import javax.swing.JFrame; //LIBRERIA JFRAME

/**
 *
 * @author Angelo
 */
public class Cerrar_Sesion extends javax.swing.JDialog {

    /**
     * Creates new form Cerrar_Sesion
     */
    
    static JFrame formulario_s; //FORMULARIO QUE ABRIO CERRAR_SESION
    
    public Cerrar_Sesion(java.awt.Frame parent, boolean modal,JFrame formulario)  { //RECIBE EL FORMULARIO
        super(parent, modal);
        initComponents();
        this.setResizable(false); //No Agrandar Formulario
        setLocationRelativeTo(null); //CENTRADO
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/LogoSGP.PNG")).getImage()); //ASIGNAMOS ICONO
        formulario_s = formulario; //RESCATAMOS EL FORMULARIO
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administración Gestión Permisos");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/LogoSGP.PNG"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("¿Cerrar la Sesión?");

        btnSi.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnSi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ok-16.png"))); // NOI18N
        btnSi.setText("Si");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        btnSi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSiKeyPressed(evt);
            }
        });

        btnNo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/cancel-16.png"))); // NOI18N
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        btnNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNo))
                    .addComponent(jLabel2))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSi)
                            .addComponent(btnNo))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
    formulario_s.dispose(); //DESTRUIMOS LA VENTANA QUE ABRIO CERRAR_SESION
    Cerrar_Sesion.this.dispose(); //DESTRUIMOS LA VENTANA CERRAR_SESION
    Iniciar_Sesion is = new Iniciar_Sesion();  //Inicia la aplicacion
    is.setLocationRelativeTo(null);  //Centra la pantalla
    is.setVisible(true); //Deja visible la pantalla
    is.setSize(500,220);  //Define el tamaño de la pantalla
    is.setResizable(false);  //Deshabilita modificar el tamaño de la pantalla
                
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
    dispose(); //DESTRUYE LA VENTANA CERRAR_SESION
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnSiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSiKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnSiActionPerformed(null);
        }    
    }//GEN-LAST:event_btnSiKeyPressed

    private void btnNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNoKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnNoActionPerformed(null);
        }    
    }//GEN-LAST:event_btnNoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cerrar_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cerrar_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cerrar_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cerrar_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cerrar_Sesion dialog = new Cerrar_Sesion(new javax.swing.JFrame(), true,formulario_s);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

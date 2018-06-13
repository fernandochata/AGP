/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Modelo.DAO.UsuarioDAO;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFRow; //LIBRERIA PARA GENERAR EL EXCEL
import org.apache.poi.xssf.usermodel.XSSFSheet; //LIBRERIA PARA GENERAR EL EXCEL
import org.apache.poi.xssf.usermodel.XSSFWorkbook; //LIBRERIA PARA GENERAR EL EXCEL

/**
 *
 * @author Angelo
 */
public class Mostrar_Usuario extends javax.swing.JDialog {

    /**
     * Creates new form Mostrar_Usuario
     */
    static JFrame formulario_usuario;
    private final String ruta = System.getProperties().getProperty("user.dir"); //LA VARIABLE RUTA DEL PEOYECTO
    
    public Mostrar_Usuario(java.awt.Frame parent, boolean modal,JFrame Usuario) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); //CENTRADO
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/LogoSGP.PNG")).getImage()); //ASIGNAMOS ICONO
        formulario_usuario = Usuario; //RESCATAMOS EL FORMULARIO
        mostrar_registros(); //Mostramos los registros de la tabla usuario
 
    }

    public void mostrar_registros()
    {
        try
        {
            DefaultTableModel dtm = new DefaultTableModel();
            tUsuario.setModel(dtm);
            dtm.setColumnIdentifiers(new Object[]{"R.U.N","Verificador","Nombre","Paterno","Materno",
                                                  "Direccion","Comuna",
                                                  "Telefono","Email","Dias Legales","Dias Administrativo",
                                                  "Fecha Contrato","Perfil","Cargo","Departamento"});
            UsuarioDAO dao = new UsuarioDAO();
            ArrayList<Modelo.DTO.Usuario> dato;
            dato = dao.obtener_usuarios();
            for(int i=0; i<dato.size(); i++)
            {
                dtm.addRow(new Object[]{dato.get(i).getRut(),
                                        dato.get(i).getCodigo_verificado(),
                                        dato.get(i).getNombre(),
                                        dato.get(i).getApellido_paterno(),
                                        dato.get(i).getApellido_materno(),
                                        dato.get(i).getDireccion(),
                                        dato.get(i).getComuna(),
                                        dato.get(i).getTelefono(),
                                        dato.get(i).getEmail(),
                                        dato.get(i).getDias_legales(),
                                        dato.get(i).getDias_administrativos(),
                                        dato.get(i).getFecha_contrado(),
                                        dato.get(i).getPerfil(),
                                        dato.get(i).getCargo(),
                                        dato.get(i).getDepartamento()
                                        });
            }
        }catch(Exception ex)
        {
            
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tUsuario = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        barra_progreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administración Gestión Permiso (AGP)");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        tUsuario.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        tUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tUsuario);

        btnExportar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/excel-16.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        btnExportar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExportarKeyPressed(evt);
            }
        });

        barra_progreso.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1648, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExportar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(barra_progreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barra_progreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
    try
    {
        //EL ARCHIVO A GENERAR TENDRA EXTENCION .xlsx
        //NO BORRAR LAS RUTAS DE LOS JAR
        Thread t = new Thread(){
          public void run()
          {
              XSSFWorkbook workbook = new XSSFWorkbook(); //LIBRO EXCEL
              XSSFSheet hoja = workbook.createSheet(); //LA HOJA DEL EXCEL
              
              
              XSSFRow fila = hoja.createRow(0); //CREAMOS LA PRIMERA FILA DE LA HOJA, EL TITULO
              //COLUMNAS DEL EXCEL
              fila.createCell(0).setCellValue("Rut"); //CREAMOS UNA CELDA, LE ASIGNAMOS UN NOMBRE
              fila.createCell(1).setCellValue("Codifo Verificador");
              fila.createCell(2).setCellValue("Nombre");
              fila.createCell(3).setCellValue("Apellido Paterno");
              fila.createCell(4).setCellValue("Apellido Materno");
              fila.createCell(5).setCellValue("Direccion");
              fila.createCell(6).setCellValue("Comuna");
              fila.createCell(7).setCellValue("Telefono");
              fila.createCell(8).setCellValue("Email");
              fila.createCell(9).setCellValue("Dias Legales");
              fila.createCell(10).setCellValue("Dias Administrativos");
              fila.createCell(11).setCellValue("Fecha Contrato");
              fila.createCell(12).setCellValue("Perfil");
              fila.createCell(13).setCellValue("Cargo");
              fila.createCell(14).setCellValue("Departamento");
              
              barra_progreso.setMaximum(tUsuario.getRowCount()); //LE ASIGNAMOS UN VALOR MAXIMO A LA BARRA DE PROGRESOM , QUE ES LA CANTIDAD DE FILAS DE LA TABLA
              XSSFRow filas; //SE CARGAN LOS DATOS DEL JTABLE
              Rectangle rect; //VISUALIZAR DONDE VA LA FILA QUE E RECOGIDO LA TABLA
              for(int i=0; i<tUsuario.getRowCount(); i++) //RECORREMOS LA CANTIDAD DE FILAS
              {
                  rect = tUsuario.getCellRect(i, 0, true); //OBTENEMOS EL RECTANGULO DEL JTABLE
                  try
                  {
                      tUsuario.scrollRectToVisible(rect); //LE ASIGNAMOS UN SCROLL VISIBLE
                      
                  }catch(java.lang.ClassCastException e)
                  {
                      
                  }
                  tUsuario.setRowSelectionInterval(i, i); //MARCA LAS FILAS QUE SE VAN RECORRIENDO EN EL JTABLE
                  barra_progreso.setValue((i+1)); //LE ASIGNAMOS EL VALOR DE I + 1 POR QUE EMPIEXA DE 0
                  
                  filas = hoja.createRow((i+1)); //CREAMOS UNA FILA DESPUES DE LA PRIMERA FILA
                  //VALIDAMOS SI LAS CELDAS ESTAN VACIAS
                  if(tUsuario.getValueAt(i, 0)==null) //VALIDA SI ESTA VACIO //CREMAOS UNA SELDA EN LA POSICION 0, 
                  {
                      filas.createCell(0).setCellValue("NO HAY DATOS"); //SI ESTA VACIO MUESTRA ESTO
                  }else
                  {
                      filas.createCell(0).setCellValue(tUsuario.getValueAt(i, 0).toString()); //CASO CONTRARIO AGREGA LO QUE YA EXISTE
                  }  
                  if(tUsuario.getValueAt(i, 1)==null)
                  {
                      filas.createCell(1).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(1).setCellValue(tUsuario.getValueAt(i, 1).toString());
                  }
                  if(tUsuario.getValueAt(i, 2)==null)
                  {
                      filas.createCell(2).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(2).setCellValue(tUsuario.getValueAt(i, 2).toString());
                  }
                  if(tUsuario.getValueAt(i, 3)==null)
                  {
                      filas.createCell(3).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(3).setCellValue(tUsuario.getValueAt(i, 3).toString());
                  }
                  if(tUsuario.getValueAt(i, 4)==null)
                  {
                      filas.createCell(4).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(4).setCellValue(tUsuario.getValueAt(i, 4).toString());
                  }
                  if(tUsuario.getValueAt(i, 5)==null)
                  {
                      filas.createCell(5).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(5).setCellValue(tUsuario.getValueAt(i, 5).toString());
                  }
                  if(tUsuario.getValueAt(i, 6)==null)
                  {
                      filas.createCell(6).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(6).setCellValue(tUsuario.getValueAt(i, 6).toString());
                  }
                  if(tUsuario.getValueAt(i, 7)==null)
                  {
                      filas.createCell(7).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(7).setCellValue(tUsuario.getValueAt(i, 7).toString());
                  }
                  if(tUsuario.getValueAt(i, 8)==null)
                  {
                      filas.createCell(8).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(8).setCellValue(tUsuario.getValueAt(i, 8).toString());
                  }
                  if(tUsuario.getValueAt(i, 9)==null)
                  {
                      filas.createCell(9).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(9).setCellValue(tUsuario.getValueAt(i, 9).toString());
                  }
                  if(tUsuario.getValueAt(i, 10)==null)
                  {
                      filas.createCell(10).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(10).setCellValue(tUsuario.getValueAt(i, 10).toString());
                  }
                  if(tUsuario.getValueAt(i, 11)==null)
                  {
                      filas.createCell(11).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(11).setCellValue(tUsuario.getValueAt(i, 11).toString());
                  }
                  if(tUsuario.getValueAt(i, 12)==null)
                  {
                      filas.createCell(12).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(12).setCellValue(tUsuario.getValueAt(i, 12).toString());
                  }
                  if(tUsuario.getValueAt(i, 13)==null)
                  {
                      filas.createCell(13).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(13).setCellValue(tUsuario.getValueAt(i, 13).toString());
                  }
                  if(tUsuario.getValueAt(i, 14)==null)
                  {
                      filas.createCell(14).setCellValue("NO HAY DATOS");
                  }else
                  {
                      filas.createCell(14).setCellValue(tUsuario.getValueAt(i, 14).toString());
                  }
                  //OJO LAS COLUMNAS NO DEBEN IR VACIAS
                  try
                  {
                      Thread.sleep(20);
                  }catch(InterruptedException ex)
                  {
                      Logger.getLogger(Mostrar_Usuario.class.getName()).log(Level.SEVERE,null,ex);
                  }
                  
              }
              barra_progreso.setValue(0); //LE QUITAMOS LA ANIMACION A LA BARRA
              barra_progreso.setString("Abriendo Excel..."); //MENSAJE DE LA BARRA
              
              try
              {
                  workbook.write(new FileOutputStream(new File(ruta+"//log_usuarios.xlsx")));//ESCRIBIMOS UN NUEVO ARCHIVO Y SE GUARDAN EN UNA RUTA
                  Desktop.getDesktop().open(new File(ruta+"//log_usuarios.xlsx")); //ABRIR EL NUEVO ARCHIVO
                  barra_progreso.setString("");
              }catch(Exception ex)
              {
                  JOptionPane.showMessageDialog(null,"Cierre Excel Para Actualizar!!");
              }
              
          }
        };
        t.start();
    }catch(Exception ex)
    {
        Logger.getLogger(Mostrar_Usuario.class.getName()).log(Level.SEVERE,null,ex); //MENSAJE DE ERROR
    }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnExportarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExportarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnExportarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }
    }//GEN-LAST:event_btnExportarKeyPressed

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
            java.util.logging.Logger.getLogger(Mostrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mostrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mostrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mostrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mostrar_Usuario dialog = new Mostrar_Usuario(new javax.swing.JFrame(), true,formulario_usuario);
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
    private javax.swing.JProgressBar barra_progreso;
    private javax.swing.JButton btnExportar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tUsuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Modelo.DAO.TipoDAO;
import Modelo.DTO.Cerrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon; //PAQUETE PARA USAR LAS IMAGENES
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Angelo
 */
public class Tipo extends javax.swing.JFrame {

    /**
     * Creates new form Tipo
     */
    JPopupMenu popup = new JPopupMenu(); //VENTANA PARA HACER CLIC DERECHO A UNA FILA DE LA TABLA
    JMenuItem JMItem = new JMenuItem("Llenar A Formulario"); //TEXTO DE LA VENTANA
    
    public Tipo() {
        initComponents();
        txtId.setEditable(false); //PARA BLOQUEAR LA MODIFICACION DEL TEXTO
        txtId.setVisible(false); //PARA DEVER INVISIBLE EL TXTID
        //llenar_tabla();
        popup.add(JMItem); //Agregar el MenuItem al Popup
        tTipo.setComponentPopupMenu(popup); //AGREGAMOE EL MENU ITEM A LA TABLA
        mostrar_registros();
        taDescripcion.setLineWrap(true); // Para que haga el salto de línea en cualquier parte de la palabra: 
        taDescripcion.setWrapStyleWord(true); // Para que haga el salto de línea buscando espacios entre las palabras  
        setLocationRelativeTo(null);  //CENTRAMOS LA PANTALA
        setVisible(true); //HACEMOS VISIBLE LA VENTANA MOTIVO
        setResizable(false);  //Deshabilita modificar el tamaño de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/LogoSGP.PNG")).getImage()); //ESTABLECER ICONO DEL SW
        editar_forma_tabla(); //PARA EDITAR LA TABLA
        JMItem.addActionListener((new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            llenar_tabla(); //LLAMO EL METODO PARA QUE ME RETORNE EL REGISTRO
        }
        }));
        
    }
    public void mostrar_registros()
    {
        try
        {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.setColumnIdentifiers(new Object[]{"Id Tipo","Tipo","Dias","Estado","Descripcion"});
            tTipo.setModel(dtm);
            editar_forma_tabla();
            TipoDAO dao = new TipoDAO();
            ArrayList<Modelo.DTO.Tipo> dato;
            dato = dao.obtener_tipo_permisos();
            for(int i=0; i<dato.size(); i++)
            {
                dtm.addRow(new Object[]{dato.get(i).get_id_tipo(), //LLENAMOS LA TABLA, ID
                                        dato.get(i).get_tipo(), //TIPO
                                        dato.get(i).get_dias(), //DIAS
                                        dato.get(i).get_estado_tipo(), //ESTADO TIPO
                                        dato.get(i).get_descripcion()}); //DESCRIPCION
            }
        }catch(Exception ex)
        {
            
        }
    }
    
    public void llenar_tabla() //PARA LLENAR EL FORMULARIO A PARTIR DE LA TABLA
    {
        try
        {
            int indice = tTipo.getSelectedRow(); //LA FILA QUE SELECCIONAMOS
            int id_tipo = (int) tTipo.getValueAt(indice,0); //OBTENEMOS EL ID DEL REGISTRO
            TipoDAO dao = new TipoDAO(); //OBJETO TIPO DAO
            ArrayList<Modelo.DTO.Tipo> lista = dao.buscar_tipo(id_tipo); //ARRAT DE TIPO
            txtId.setText(lista.get(0).get_id_tipo()+""); //NO OLVIDAR QUE DEBEMOS RESCATAR EL ID
            txtTipo.setText(lista.get(0).get_tipo()); //CARGAMOS EL TXT TIPO
            txtDias.setText(lista.get(0).get_dias()+""); //CARGAMOS EL  TXT DIAS
            taDescripcion.setText(lista.get(0).get_descripcion()); //CARGAMOS EL TXT DESCRIPCION
            if(lista.get(0).get_estado_tipo()==1) //VALIDAMOS EL TIPO OBTENIDO
            {
                rbHabilitado.setSelected(true); 
            }else if(lista.get(0).get_estado_tipo()==0)
            {
                rbDeshabilitado.setSelected(true);
            }
        }catch(Exception ex)
        {
            
        }
    }
    
    //SERIA INTERESANTE MODIFICAR TAMBIEN LAS DEMAS COLUMNAS DE LA TABLA
    public void editar_forma_tabla() //PARA OCULTAR LA COLUMNA ID DE LA TABLA
    {
        tTipo.getColumnModel().getColumn(0).setMaxWidth(0); //LARGO MAXIMO
        tTipo.getColumnModel().getColumn(0).setMinWidth(0); //MINIMO DE LARGO
        tTipo.getColumnModel().getColumn(0).setPreferredWidth(0); //PARA BLOQUEAR EL MODIFICAR EL LARGO DE LA TABLA
        tTipo.getColumnModel().getColumn(1).setMaxWidth(150); // 1 = SEGUNDA COLUMNA
        tTipo.getColumnModel().getColumn(1).setMinWidth(150);
        tTipo.getColumnModel().getColumn(1).setPreferredWidth(0);
        tTipo.getColumnModel().getColumn(2).setMaxWidth(50);
        tTipo.getColumnModel().getColumn(2).setMinWidth(50);
        tTipo.getColumnModel().getColumn(2).setPreferredWidth(0);
        tTipo.getColumnModel().getColumn(3).setMaxWidth(70);
        tTipo.getColumnModel().getColumn(3).setMinWidth(70);
        tTipo.getColumnModel().getColumn(3).setPreferredWidth(0);
        tTipo.getColumnModel().getColumn(4).setPreferredWidth(0);
    }
    
    public void limpiar()
    {
        txtDias.setText("");
        txtTipo.setText("");
        taDescripcion.setText("");
        rbHabilitado.setSelected(true); //EL BOTON SE SELECCIONA SOLO
        txtId.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoEstado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtDias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbHabilitado = new javax.swing.JRadioButton();
        rbDeshabilitado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTipo = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        jmMenu = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmInicio = new javax.swing.JMenuItem();
        jmCerrarSesion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmMotivo = new javax.swing.JMenuItem();
        jmTipo = new javax.swing.JMenuItem();
        jmUnidad = new javax.swing.JMenuItem();
        jmUsuario = new javax.swing.JMenuItem();
        jmFeriado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Administración Gestión Permisos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Tipo:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Dias:");

        txtDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasKeyTyped(evt);
            }
        });

        jLabel3.setText("*");

        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Estado:");

        grupoEstado.add(rbHabilitado);
        rbHabilitado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbHabilitado.setText("Habilitado");

        grupoEstado.add(rbDeshabilitado);
        rbDeshabilitado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbDeshabilitado.setText("Deshabilitado");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Descripción:");

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        taDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(taDescripcion);

        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/save-16.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/available-updates-16.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarKeyPressed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/undo-16.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        btnLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimpiarKeyPressed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/search-3-16.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        btnMostrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/pages-3-16.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        btnMostrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnMostrarKeyPressed(evt);
            }
        });

        tTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Tipo", "Tipo", "Dias", "Estado", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tTipo);

        jMenu3.setText("Sistema");

        jmInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/day-view-16.png"))); // NOI18N
        jmInicio.setText("Inicio");
        jmInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInicioActionPerformed(evt);
            }
        });
        jMenu3.add(jmInicio);

        jmCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/close-window-16.png"))); // NOI18N
        jmCerrarSesion.setText("Cerrar Sesión");
        jmCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarSesionActionPerformed(evt);
            }
        });
        jMenu3.add(jmCerrarSesion);

        jmMenu.add(jMenu3);

        jMenu4.setText("Servicio");

        jmMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/day-view-16.png"))); // NOI18N
        jmMotivo.setText("Motivo");
        jmMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMotivoActionPerformed(evt);
            }
        });
        jMenu4.add(jmMotivo);

        jmTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/day-view-16.png"))); // NOI18N
        jmTipo.setText("Tipo");
        jmTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTipoActionPerformed(evt);
            }
        });
        jMenu4.add(jmTipo);

        jmUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/day-view-16.png"))); // NOI18N
        jmUnidad.setText("Departamento");
        jmUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUnidadActionPerformed(evt);
            }
        });
        jMenu4.add(jmUnidad);

        jmUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/day-view-16.png"))); // NOI18N
        jmUsuario.setText("Usuario");
        jmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(jmUsuario);

        jmFeriado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/day-view-16.png"))); // NOI18N
        jmFeriado.setText("Feriado");
        jmFeriado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFeriadoActionPerformed(evt);
            }
        });
        jMenu4.add(jmFeriado);

        jmMenu.add(jMenu4);

        setJMenuBar(jmMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(22, 22, 22)
                                            .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbHabilitado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbDeshabilitado)))
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbHabilitado)
                            .addComponent(rbDeshabilitado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInicioActionPerformed
        dispose(); //DESTRUYE LA VENTANA QUE ESTA ABIERTA
        Menu m = new Menu(); //ABRIMOS LA VENTANA MENU
        m.setLocationRelativeTo(null);  //CENTRAMOS LA PANTALA
        m.setVisible(true); //HACEMOS VISIBLE LA VENTANA MENU
        m.setResizable(false);  //Deshabilita modificar el tamaño de la pantalla
    }//GEN-LAST:event_jmInicioActionPerformed

    private void jmCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarSesionActionPerformed
        Cerrar_Sesion cs = new Cerrar_Sesion(this,true,Tipo.this); //LLAMO AL JDIALOG CERRAR_SESION
        cs.setVisible(true); //LA HAGO VISIBLE
    }//GEN-LAST:event_jmCerrarSesionActionPerformed

    private void jmMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMotivoActionPerformed
        this.dispose(); //DESTRUYO LA VENTANA MENU
        Motivo m = new Motivo(); //CREO UNA INSTANCIA DE MOTIVO
        m.setVisible(true); //LA HAGO VISIBLE
    }//GEN-LAST:event_jmMotivoActionPerformed
    
    private void jmTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTipoActionPerformed
        this.dispose(); //DESTRUYO LA VENTANA MENU
        Tipo t = new Tipo(); //CREO UNA INSTANCIA DE TIPO
        t.setVisible(true); //LA HAGO VISIBLE
    }//GEN-LAST:event_jmTipoActionPerformed

    private void jmUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUnidadActionPerformed
        dispose(); //DESTRUYO LA VENTANA MENU
        Departamento u = new Departamento(); //CREO UNA INSTANCIA UNIDAD
        u.setVisible(true); //LA HAGO VISIBLE
    }//GEN-LAST:event_jmUnidadActionPerformed

    private void jmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUsuarioActionPerformed
        dispose(); //DESTRUYO LA VENTANA MENU
        Usuario u = new Usuario(); //CREO UNA INSTANCIA USUARIO
        u.setVisible(true); //LA HAGO VISIBLE
    }//GEN-LAST:event_jmUsuarioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar c = new Cerrar();
        c.cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnBuscarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }    
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnRegistrarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }    
    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnEditarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }    
    }//GEN-LAST:event_btnEditarKeyPressed

    private void btnMostrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMostrarKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnMostrarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }    
    }//GEN-LAST:event_btnMostrarKeyPressed

    private void btnLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimpiarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnLimpiarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }    
    }//GEN-LAST:event_btnLimpiarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try
    {
        try
        {
            if(txtTipo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Ingrese Un Tipo Para Buscar"); //GATILLA MENSAJE DE ERROR
                txtTipo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
                throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
            }else
            {
                String tipo = txtTipo.getText();
                TipoDAO dao = new TipoDAO();
                ArrayList<Modelo.DTO.Tipo> lista = dao.buscar_tipo_tipo(tipo);
                String mensaje = lista.get(0).get_resultado();
                String dias = lista.get(0).get_dias()+"";
                String descripcion = lista.get(0).get_descripcion();
                int id = lista.get(0).get_id_tipo();
                txtDias.setText(dias);
                taDescripcion.setText(descripcion);
                if(lista.get(0).get_estado_tipo()==1)
                {
                    rbHabilitado.setSelected(true);
                }else if(lista.get(0).get_estado_tipo()==0)
                {
                    rbDeshabilitado.setSelected(true);
                }
                txtId.setText(id+"");
                if(id>0)
                {
                    JOptionPane.showMessageDialog(null,mensaje);
                }else
                {
                     JOptionPane.showMessageDialog(null,"No se encontraron datos");
                }
            }
        }catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(null,ex.getCause()+ex.getMessage());
        }
    }catch(Exception ex)
    {
        ex.getMessage();
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    try
    {
        int estado;
        if(txtTipo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un Tipo de Permiso"); //GATILLA MENSAJE DE ERROR
            txtTipo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtTipo.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"No Puede sobrepasar los 100 Caracteres"); //GATILLA MENSAJE DE ERROR
            txtTipo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDias.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Numero de Dias"); //GATILLA MENSAJE DE ERROR
            txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        int dias = 0;
            try
            {
                dias = Integer.parseInt(txtDias.getText());
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Ingrese un entero valido (0-30)"); //GATILLA MENSAJE DE ERROR
                txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
                throw new Exception();
            }
            if(dias>=30 || dias<=0)
            {
                JOptionPane.showMessageDialog(null,"Dias no puede pasar los 30 ni ser menor a 0"); //GATILLA MENSAJE DE ERROR
                txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
                throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
            }
        if(rbHabilitado.isSelected())
        {
            estado = 1;
        }else if(rbDeshabilitado.isSelected())
        {
            estado = 0;
        }else
        {
            JOptionPane.showMessageDialog(null,"Seleccione un Estado"); //GATILLA MENSAJE DE ERROR
            txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception();
        }
        if(taDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese descripción"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception();
        }
        if(taDescripcion.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"Descripcion maximo 100 caracteres"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception();
        }
        String tipo = txtTipo.getText().toString();
        String descripcion = taDescripcion.getText();
        Modelo.DTO.Tipo t = new Modelo.DTO.Tipo(tipo,dias,descripcion,estado);
        TipoDAO dao = new TipoDAO();
        JOptionPane.showMessageDialog(null,dao.registrar_tipo_permiso(t));
        mostrar_registros();
        limpiar();
        txtTipo.requestFocus();
    }catch(Exception ex)
    {
        //JOptionPane.showMessageDialog(null,ex.getCause()+ex.getMessage());
    }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    try
    {
        int estado;
        if(txtId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Antes de Editar Realize acción 'Buscar' o 'Llenar'"); //GATILLA MENSAJE DE ERROR
            txtTipo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        int id = Integer.parseInt(txtId.getText());
        if(txtTipo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un Tipo de Permiso"); //GATILLA MENSAJE DE ERROR
            txtTipo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtTipo.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"No Puede sobrepasar los 100 Caracteres"); //GATILLA MENSAJE DE ERROR
            txtTipo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDias.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Numero de Dias"); //GATILLA MENSAJE DE ERROR
            txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        int dias = 0;
            try
            {
                dias = Integer.parseInt(txtDias.getText());
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Ingrese un entero valido (0-30)"); //GATILLA MENSAJE DE ERROR
                txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
                throw new Exception();
            }
            if(dias>=30 || dias<=0)
            {
                JOptionPane.showMessageDialog(null,"Dias no puede pasar los 30 ni ser menor a 0"); //GATILLA MENSAJE DE ERROR
                txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
                throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
            }
        if(rbHabilitado.isSelected())
        {
            estado = 1;
        }else if(rbDeshabilitado.isSelected())
        {
            estado = 0;
        }else
        {
            JOptionPane.showMessageDialog(null,"Seleccione un Estado"); //GATILLA MENSAJE DE ERROR
            txtDias.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception();
        }
        if(taDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese descripción"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception();
        }
        if(taDescripcion.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"Descripcion maximo 100 caracteres"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception();
        }
        String tipo = txtTipo.getText().toString();
        String descripcion = taDescripcion.getText();
        Modelo.DTO.Tipo t = new Modelo.DTO.Tipo(tipo,dias,descripcion,estado);
        t.set_id_tipo(id);
        TipoDAO dao = new TipoDAO();
        JOptionPane.showMessageDialog(null,dao.editar_tipo(t));
        mostrar_registros();
        limpiar();
        txtTipo.requestFocus();
    }catch(Exception ex)
    {
        //JOptionPane.showMessageDialog(null,ex.getCause()+ex.getMessage());
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
    mostrar_registros(); //MUESTRA TODOS LOS DATOS DE LA TABLA TIPO DE PERMISOS
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasKeyTyped
    char car = evt.getKeyChar(); 
        if((car<'0' || car>'9') && (car<',' || car>'.')) //para validar solo numeros en txtUsua
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
        if (txtDias.getText().length()>=2) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_txtDiasKeyTyped

    private void taDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taDescripcionKeyTyped
     char car = evt.getKeyChar(); 
        if (taDescripcion.getText().length()>=101) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_taDescripcionKeyTyped

    private void jmFeriadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFeriadoActionPerformed
    dispose(); 
    Feriado f = new Feriado(); 
    f.setVisible(true);
    }//GEN-LAST:event_jmFeriadoActionPerformed

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
            java.util.logging.Logger.getLogger(Tipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup grupoEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmCerrarSesion;
    private javax.swing.JMenuItem jmFeriado;
    private javax.swing.JMenuItem jmInicio;
    private javax.swing.JMenuBar jmMenu;
    private javax.swing.JMenuItem jmMotivo;
    private javax.swing.JMenuItem jmTipo;
    private javax.swing.JMenuItem jmUnidad;
    private javax.swing.JMenuItem jmUsuario;
    private javax.swing.JRadioButton rbDeshabilitado;
    private javax.swing.JRadioButton rbHabilitado;
    private javax.swing.JTable tTipo;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

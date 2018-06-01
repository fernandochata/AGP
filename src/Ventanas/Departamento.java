/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Modelo.DAO.DepartamentoDAO;
import Modelo.DTO.Cerrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angelo
 */
public class Departamento extends javax.swing.JFrame {

    /**
     * Creates new form Departamento
     */
    JPopupMenu popup = new JPopupMenu(); //VENTANA PARA HACER CLIC DERECHO A UNA FILA DE LA TABLA
    JMenuItem JMItem = new JMenuItem("Llenar A Formulario"); //TEXTO DE LA VENTANA
    
    public Departamento() {
        initComponents();
        txtId.setEditable(false); //PARA BLOQUEAR LA MODIFICACION DEL TEXTO
        txtId.setVisible(false); //PARA DEVER INVISIBLE EL TXTID
        //llenar_tabla(); //PARA LLENAR FORMULARIO DESDE LA TABLA
        popup.add(JMItem); //Agregar el MenuItem al Popup
        tUnidad.setComponentPopupMenu(popup); //AGREGAMOE EL MENU ITEM A LA TABLA
        taDescripcion.setLineWrap(true); // Para que haga el salto de línea en cualquier parte de la palabra: 
        taDescripcion.setWrapStyleWord(true); // Para que haga el salto de línea buscando espacios entre las palabras 
        btnRegistrar.requestFocusInWindow(); //FOCUS AL BOTON REGISTRAR
        setLocationRelativeTo(null);  //CENTRAMOS LA PANTALA
        setVisible(true); //HACEMOS VISIBLE LA VENTANA MOTIVO
        setResizable(false);  //Deshabilita modificar el tamaño de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Imagen/LogoSGP.PNG")).getImage()); //ESTABLECER ICONO DEL SW
        //editar_forma_tabla(); //PARA EDITAR LA TABLA
        JMItem.addActionListener((new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
          llenar_tabla(); //LLAMO EL METODO PARA QUE ME RETORNE EL REGISTRO
        }
        }));

    }
    
    public void llenar_tabla() //PARA LLENAR EL FORMULARIO A PARTIR DE LA TABLA
    {
        try
        {
            int indice = tUnidad.getSelectedRow(); //LA FILA QUE SELECCIONAMOS
            int id_departamento = Integer.parseInt(tUnidad.getValueAt(indice,0).toString()); //OBTENEMOS EL ID DEL REGISTRO
            DepartamentoDAO dao = new DepartamentoDAO(); //OBJETO TIPO DAO
            ArrayList<Modelo.DTO.Departamento> lista = dao.buscar_Departamento(id_departamento); //ARRAT DE TIPO
            txtId.setText(lista.get(0).getId_departamento()+""); //NO OLVIDAR QUE DEBEMOS RESCATAR EL ID
            txtDepartamento.setText(lista.get(0).getDepartamento()); //CARGAMOS EL TXT TIPO
            taDescripcion.setText(lista.get(0).getDescripcion()); //CARGAMOS EL TXT DESCRIPCION
        }catch(Exception ex)
        {
            
        }
    }
    
    public void mostrar_registros()
    {
        try
        {
            DefaultTableModel dtm = new DefaultTableModel();
            tUnidad.setModel(dtm);
            dtm.setColumnIdentifiers(new Object[]{"Id Departamento","Departamento","Descripcion"});
            editar_forma_tabla();
            DepartamentoDAO dao = new DepartamentoDAO();
            ArrayList<Modelo.DTO.Departamento> dato;
            dato = dao.obtener_usuario_departamento();
            for(int i=0; i<dato.size(); i++)
            {
                dtm.addRow(new Object[]{dato.get(i).getId_departamento()+"", //LLENAMOS LA TABLA, ID
                                        dato.get(i).getDepartamento(),
                                        dato.get(i).getDescripcion() //DESCRIPCION
                                        });
            }
        }catch(Exception ex)
        {
            
        }
    }
    
    public void editar_forma_tabla() //PARA OCULTAR LA COLUMNA ID DE LA TABLA
    {
        tUnidad.getColumnModel().getColumn(0).setMaxWidth(0); //LARGO MAXIMO
        tUnidad.getColumnModel().getColumn(0).setMinWidth(0); //MINIMO DE LARGO
        tUnidad.getColumnModel().getColumn(0).setPreferredWidth(0); //PARA BLOQUEAR EL MODIFICAR EL LARGO DE LA TABLA
        //tUnidad.getColumnModel().getColumn(1).setMaxWidth(150); // 1 = SEGUNDA COLUMNA
        //tUnidad.getColumnModel().getColumn(1).setMinWidth(150);
        //tUnidad.getColumnModel().getColumn(1).setPreferredWidth(0);
        //tUnidad.getColumnModel().getColumn(2).setMaxWidth(50);
        //tUnidad.getColumnModel().getColumn(2).setMinWidth(50);
        //tUnidad.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    public void Limpiar()
    {
        txtDepartamento.setText("");
        taDescripcion.setText("");
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

        estado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tUnidad = new javax.swing.JTable();
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
        jLabel1.setText("Departamento:");

        jLabel2.setText("*");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        taDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(taDescripcion);

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

        tUnidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Unidad", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tUnidad);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Cerrar_Sesion cs = new Cerrar_Sesion(this,true,Departamento.this); //LLAMO AL JDIALOG CERRAR_SESION
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
        if(txtDepartamento.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un departamento Para Buscar"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDepartamento.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"Departamento no puede superar los 100 caracteres"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        String departamento = txtDepartamento.getText();
        DepartamentoDAO d = new DepartamentoDAO();
        ArrayList<Modelo.DTO.Departamento> lista = d.buscar_departamento_departamento(departamento);
        if(lista.get(0).getId_departamento()>0)
        {
            taDescripcion.setText(lista.get(0).getDescripcion());
            txtId.setText(lista.get(0).getId_departamento()+""); //LAS "" SIGNIFICA QUE LO CONVIERTO A STRING
            JOptionPane.showMessageDialog(null,lista.get(0).getResultado());
        }else
        {
            JOptionPane.showMessageDialog(null,"No se encontro departamento"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        
    }catch(Exception ex)
    {
        
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    try
    {
        if(txtDepartamento.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un departamento"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDepartamento.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"Departamento no puede superar los 100 caracteres"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(taDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese descripción"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(taDescripcion.getText().length()>300)
        {
            JOptionPane.showMessageDialog(null,"Descripcion no puede superar los 300 caracteres"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        String departamento = txtDepartamento.getText(); //RESCATO LOS ESCRITO EN TXT DEPARTAMENTO
        String descripcion = taDescripcion.getText(); //RESCATO LO ESCRITO EN TXT DESCRIPCION
        Modelo.DTO.Departamento d = new Modelo.DTO.Departamento(); //CREO UN OBJETO DTO DE DEPARTAMENTO
        d.setDepartamento(departamento); //LE ASIGNO EL VALOR DE DEPARTAMENTO QUE RESCATE
        d.setDescripcion(descripcion); //LE ASIGNO EL VALOR DE DESCRIPCION QUE RESCATE
        DepartamentoDAO dao = new DepartamentoDAO(); //CREO UN OBJETO DAO
        JOptionPane.showMessageDialog(null,dao.registrar_usuario_Departamento(d)); //MUESTRO EL RESULTADO OBTENIDO AL LLAMAR AL METODO REGISTRAR
        mostrar_registros(); //LLAMO AL METODO MOSTRAR REGISTRO
        Limpiar(); //LIMPIO EL FORMULARIO
        txtDepartamento.requestFocus(); //HAGO UN FOCUS AL TXT DEPARTAMENTO
    }catch(Exception ex)
    {
        
    }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    try
    {
        if(txtId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Realize acciones de 'Llenar' o 'Buscar' primero"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDepartamento.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un departamento"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDepartamento.getText().length()>100)
        {
            JOptionPane.showMessageDialog(null,"Departamento no puede superar los 100 caracteres"); //GATILLA MENSAJE DE ERROR
            txtDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(taDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese descripción"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(taDescripcion.getText().length()>300)
        {
            JOptionPane.showMessageDialog(null,"Descripcion no puede superar los 300 caracteres"); //GATILLA MENSAJE DE ERROR
            taDescripcion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        String departamento = txtDepartamento.getText();
        String descripcion = taDescripcion.getText();
        int id = Integer.parseInt(txtId.getText());
        Modelo.DTO.Departamento d = new Modelo.DTO.Departamento(id,departamento,descripcion,"");
        DepartamentoDAO dao = new DepartamentoDAO();
        JOptionPane.showMessageDialog(null,dao.editar_departamento(d));
        mostrar_registros();
        Limpiar();
    }catch(Exception ex)
    {
        
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
    mostrar_registros(); //LLAMA AL METODO MOSTRAR_REGISTROS()
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    Limpiar(); //LLAMA AL METODO LIMPIAR();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void taDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taDescripcionKeyTyped
    char car = evt.getKeyChar(); 
        if (taDescripcion.getText().length()>=301) //Valida largo de un campo
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
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Departamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTable tUnidad;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}

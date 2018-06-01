/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Modelo.DAO.UsuarioDAO;
import Modelo.DTO.Cerrar;
import com.placeholder.PlaceHolder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author Angelo
 */
public class Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Usuario
     */
    public Usuario() {
        try
        {
            initComponents();
            txtDiasAdministrativos.setEnabled(false);
            txtDiasAdministrativos.setText("6");
            llenar_texto();
            carga_drops();
            btnBuscar.requestFocusInWindow();
            setLocationRelativeTo(null);  //CENTRAMOS LA PANTALA
            setVisible(true); //HACEMOS VISIBLE LA VENTANA MOTIVO
            setResizable(false);  //Deshabilita modificar el tamaño de la pantalla
            setIconImage(new ImageIcon(getClass().getResource("/Imagen/LogoSGP.PNG")).getImage()); //ESTABLECER ICONO DEL SW
        
        }catch(Exception ex)
        {
                
        }
    }

    //PARA GENERAR EL CODIGO VERIFICADOR
    private static String getDV(int rut) {
        int digito,suma,resto,resultado,factor;
        for(factor = 2, suma = 0; rut > 0; factor++){
            digito = rut % 10;
            rut /= 10;
            suma += digito * factor;
            if(factor >= 7) factor = 1;
        } 
        resto = suma % 11;
        resultado = 11 - resto;
        
        String dv = "";
        switch (resultado) {
            case 0: dv = "0";
                break;
            case 1: dv = "1";
                break;
            case 2: dv = "2";
                break;
            case 3: dv = "3";
                break;
            case 4: dv = "4";
                break;
            case 5: dv = "5";
                break;
            case 6: dv = "6";
                break;
            case 7: dv = "7";
                break;
            case 8: dv = "8";
                break;
            case 9: dv = "9";
                break;
            case 10: dv = "K";
                break;
        }
        return dv;
    }
    
    public static boolean validarRut(int rut , char dv)
    {
        int m = 0 , s = 1;
        for(; rut !=0; rut/=10)
        {
            s = (s + rut % 10 * (9 - m++ %6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47:75);
    }
    
    public void llenar_texto()
    {
        /*
        PlaceHolder holder = new PlaceHolder(txtRut, "EJ: 11111111");
        PlaceHolder mail = new PlaceHolder(txtEmail, "EJ: ejemplo@gmail.com");
        PlaceHolder telefono = new PlaceHolder(txtTelefono, "Solo numeros");
        PlaceHolder legales = new PlaceHolder(txtDiasLegales, "0");
        PlaceHolder administrativo = new PlaceHolder(txtDiasAdministrativos, "0");
        */
    }
    
    public void carga_drops()
    {
        try
        {
            actualizarJComboBoxCargo();
            actualizarJComboBoxDepartamento();
            actualizarJComboBoxPerfil();
        }catch(Exception ex)
        {
            
        }
    }
    
    public void actualizarJComboBoxCargo() throws Exception
    {
        ArrayList<String> resul = new ArrayList<String>(); 
        UsuarioDAO dao = new UsuarioDAO();
        resul = dao.obtener_cargos();
        cbCargo.removeAllItems();
        cbCargo.addItem("-Seleccione-");
        for(int i=0; i<resul.size(); i++)
        {
            cbCargo.addItem(resul.get(i));
        }
    }
    
    public void actualizarJComboBoxDepartamento() throws Exception
    {
        ArrayList<String> resul = new ArrayList<String>(); 
        UsuarioDAO dao = new UsuarioDAO();
        resul = dao.obtener_departamentos();
        cbDepartamento.removeAllItems();
        cbDepartamento.addItem("-Seleccione-");
        for(int i=0; i<resul.size(); i++)
        {
            cbDepartamento.addItem(resul.get(i));
        }
    }
    
    public void actualizarJComboBoxPerfil() throws Exception
    {
        ArrayList<Modelo.DTO.Usuario> resul = new ArrayList<Modelo.DTO.Usuario>(); 
        UsuarioDAO dao = new UsuarioDAO();
        resul = dao.obtener_perfiles();
        cbPerfil.removeAllItems();
        cbPerfil.addItem("-Seleccione-");
        for(int i=0; i<resul.size(); i++)
        {
            cbPerfil.addItem(resul.get(i).getPerfil());
        }
    }  
    
    public void limpiar()
    {
        txtRut.setText("");
        txtVerificador.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtDireccion.setText("");
        txtComuna.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        dcFechaContrato.setDate(null);
        txtDiasLegales.setText("");
        txtDiasAdministrativos.setText("6");
        cbCargo.setSelectedIndex(0);
        cbDepartamento.setSelectedIndex(0);
        cbPerfil.setSelectedIndex(0);
        llenar_texto();
             
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
        txtRut = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtVerificador = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dcFechaContrato = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtDiasLegales = new javax.swing.JTextField();
        txtDiasAdministrativos = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbDepartamento = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtComuna = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
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
        setTitle("Administración Gestión Permiso");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Rut:");

        txtRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutKeyTyped(evt);
            }
        });

        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Verificador:");

        txtVerificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVerificadorKeyTyped(evt);
            }
        });

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

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Apellido Paterno:");

        jLabel6.setText("*");

        jLabel7.setText("*");

        jLabel8.setText("*");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Apellido Materno:");

        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Dirección:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Comuna:");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Teléfono:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel16.setText("*");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Email:");

        jLabel18.setText("*");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Fecha Contrato:");

        jLabel20.setText("*");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Días Legales:");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Días Administrativos:");

        txtDiasLegales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasLegalesKeyTyped(evt);
            }
        });

        txtDiasAdministrativos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasAdministrativosKeyTyped(evt);
            }
        });

        jLabel23.setText("*");

        jLabel24.setText("*");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Cargo:");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Perfil:");

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText("*");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Departamento:");

        cbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel31.setText("*");

        jLabel14.setText("*");

        jLabel32.setText("*");

        jLabel12.setText("*");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiasLegales, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel13))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel17))
                                    .addComponent(jLabel19)))
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel32)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar)))
                        .addGap(218, 218, 218))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(txtDiasAdministrativos))
                                            .addComponent(txtEmail)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(dcFechaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMaterno)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtPaterno)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8))))
                                    .addComponent(btnMostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel31)
                    .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(dcFechaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(txtDiasLegales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiasAdministrativos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEditar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnMostrar))
                .addContainerGap())
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
        Cerrar_Sesion cs = new Cerrar_Sesion(this,true,Usuario.this); //LLAMO AL JDIALOG CERRAR_SESION
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
        Cerrar c = new Cerrar(); //CIERRE LA APLICAICON
        c.cerrar(); //CIERA LA APLICACION
    }//GEN-LAST:event_formWindowClosing

    private void txtRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutKeyTyped
    char car = evt.getKeyChar(); 
        if((car<'0' || car>'9') && (car<',' || car>'.')) //para validar solo numeros en txtUsua
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
        if (txtRut.getText().length()>=9) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_txtRutKeyTyped

    private void txtVerificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVerificadorKeyTyped
    char car = evt.getKeyChar(); 
        if((car<'0' || car>'9') && (car<',' || car>'.') &&(car<'K' || car<'K')) //para validar solo numeros en txtUsua
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
        if (txtVerificador.getText().length()>=2) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_txtVerificadorKeyTyped

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

    private void btnLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimpiarKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnLimpiarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }  
    }//GEN-LAST:event_btnLimpiarKeyPressed

    private void btnMostrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMostrarKeyPressed
    if (evt.getKeyCode() == evt.VK_ENTER) { //HABILITA CLIC AL BOTON INGRESAR CON LA TECLA "ENTER"
            btnMostrarActionPerformed(null); //PERMITE HACER CLIC CON TECLA INTRO EN EL BOTON
        }  
    }//GEN-LAST:event_btnMostrarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try
    {
        if(txtRut.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un rut Para Buscar"); //GATILLA MENSAJE DE ERROR
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtRut.getText().length()>15)
        {
            JOptionPane.showMessageDialog(null,"Ingrese un rut valido"); //GATILLA MENSAJE DE ERROR
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        int rut = Integer.parseInt(txtRut.getText());
        UsuarioDAO u = new UsuarioDAO();
        ArrayList<Modelo.DTO.Usuario> lista = u.buscar_Usuario(rut);
        if(lista.get(0).getId_departamento()>0)
        {
            txtVerificador.setText(lista.get(0).getCodigo_verificado());
            txtNombre.setText(lista.get(0).getNombre());
            txtPaterno.setText(lista.get(0).getApellido_paterno());
            txtMaterno.setText(lista.get(0).getApellido_materno());
            txtComuna.setText(lista.get(0).getComuna());
            txtDireccion.setText(lista.get(0).getDireccion());
            txtTelefono.setText(lista.get(0).getTelefono()+"");
            txtEmail.setText(lista.get(0).getEmail());
            dcFechaContrato.setDate(lista.get(0).getFecha_contrado());
            txtDiasLegales.setText(lista.get(0).getDias_legales()+"");
            txtDiasAdministrativos.setText(lista.get(0).getDias_administrativos()+"");
            cbCargo.setSelectedItem(lista.get(0).getCargo());
            cbPerfil.setSelectedItem(lista.get(0).getPerfil());
            cbDepartamento.setSelectedItem(lista.get(0).getDepartamento());
            
            JOptionPane.showMessageDialog(null,lista.get(0).getResultado());
        }else
        {
            JOptionPane.showMessageDialog(null,"No se encontro  Usuario"); //GATILLA MENSAJE DE ERROR
            limpiar();
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new Exception(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        
    }catch(Exception ex)
    {
        
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    try
    {
        //VALIDACIONES
        if(txtRut.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un Rut"); //GATILLA MENSAJE DE ERROR
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtRut.getText().length()>=15)
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un Rut Valido"); //GATILLA MENSAJE DE ERROR
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtVerificador.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Codigo verificado"); //GATILLA MENSAJE DE ERROR
            txtVerificador.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtVerificador.getText().length()>=2)
        {
            JOptionPane.showMessageDialog(null,"Ingrese Solo (0-9 o K)"); //GATILLA MENSAJE DE ERROR
            txtVerificador.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un nombre"); //GATILLA MENSAJE DE ERROR
            txtNombre.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtNombre.getText().length()>=30)
        {
            JOptionPane.showMessageDialog(null,"Nombre no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtNombre.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtPaterno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese apellido paterno"); //GATILLA MENSAJE DE ERROR
            txtPaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtPaterno.getText().length()>=30)
        {
            JOptionPane.showMessageDialog(null,"Apellido Patenro no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtPaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtMaterno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese apellido materno"); //GATILLA MENSAJE DE ERROR
            txtMaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtMaterno.getText().length()>=30)
        {
            JOptionPane.showMessageDialog(null,"Apellido Materno no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtMaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtComuna.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese una comuna"); //GATILLA MENSAJE DE ERROR
            txtComuna.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtComuna.getText().length()>=100)
        {
            JOptionPane.showMessageDialog(null,"Comuna no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtComuna.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDireccion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese una direccion"); //GATILLA MENSAJE DE ERROR
            txtDireccion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDireccion.getText().length()>=100)
        {
            JOptionPane.showMessageDialog(null,"Direccion no puede superar los 100 caracteres"); //GATILLA MENSAJE DE ERROR
            txtDireccion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtTelefono.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un telefono"); //GATILLA MENSAJE DE ERROR
            txtTelefono.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtTelefono.getText().length()>=15)
        {
            JOptionPane.showMessageDialog(null,"El telefono no puede superar los 15 numeros"); //GATILLA MENSAJE DE ERROR
            txtTelefono.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtEmail.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un correo electronico"); //GATILLA MENSAJE DE ERROR
            txtEmail.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        //CODIGO PARA VALIDAR UN CORREO ELECTRONICO
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ 
                                          "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email = txtEmail.getText();
        Matcher mather = pattern.matcher(email);
        if (mather.find() == false) {
            JOptionPane.showMessageDialog(null,"El email ingresado no es valido"); //GATILLA MENSAJE DE ERROR
            txtEmail.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
            
        } else {
            //System.out.println("El email ingresado es válido.");
        }
        if(dcFechaContrato.getDate()==null)
        {
            JOptionPane.showMessageDialog(null,"Ingrese fecha contrato"); //GATILLA MENSAJE DE ERROR
            dcFechaContrato.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDiasLegales.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null,"Ingrese Dias legales"); //GATILLA MENSAJE DE ERROR
           txtDiasLegales.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
           throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO 
        }
        if(txtDiasLegales.getText().length()>=3)
        {
            JOptionPane.showMessageDialog(null,"Ingrese solo numero 2 digitos"); //GATILLA MENSAJE DE ERROR
            txtDiasLegales.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDiasAdministrativos.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese dias administrativos"); //GATILLA MENSAJE DE ERROR
            txtDiasAdministrativos.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDiasAdministrativos.getText().length()>=3)
        {
            JOptionPane.showMessageDialog(null,"Ingrese solo numero 2 digitos"); //GATILLA MENSAJE DE ERROR
            txtDiasAdministrativos.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(cbCargo.getSelectedItem().toString().equals("-Seleccione-"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione un cargo"); //GATILLA MENSAJE DE ERROR
            cbCargo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(cbPerfil.getSelectedItem().toString().equals("-Seleccione-"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione un perfil"); //GATILLA MENSAJE DE ERROR
            cbPerfil.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(cbDepartamento.getSelectedItem().toString().equals("-Seleccione-"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione Departamento"); //GATILLA MENSAJE DE ERROR
            cbDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        
        UsuarioDAO dao = new UsuarioDAO();
        
        //Buscamos los id de CARGO , PERFIL Y DEPARTAMENTO
        String cargo = cbCargo.getSelectedItem().toString(); //RESCATAMOS LO SELECICONADO EN EL COMBO BOX
        String perfil = cbPerfil.getSelectedItem().toString();
        String departamento = cbDepartamento.getSelectedItem().toString();
        int id_cargo = dao.obtener_id_cargo(cargo);
        int id_perfil = dao.obtener_id_perfil(perfil);
        int id_departamento = dao.obtener_id_departamento(departamento);
        
        //GENERAMOS LA CLAVE ALEATORIA
        int clave = dao.generar_clave();
        
        //GENERAMOS EL DV
        int rut = Integer.parseInt(txtRut.getText());
        String digito_verificador = getDV(rut);
        
        //VALIDAMOS QUE EL RUT SEA VALIDO
        char dv = digito_verificador.charAt(0);
        if(validarRut(rut,dv))
        {
            JOptionPane.showMessageDialog(null, "Rut correcto");
        }else
        {
            JOptionPane.showMessageDialog(null, "Rut incorrecto");
            txtRut.requestFocus();
            throw new Exception();
        }
        
        //CARGAMOS TODOS LOS DATOS A LA CLASE USUARIO
        Modelo.DTO.Usuario u = new Modelo.DTO.Usuario();
        u.setRut(Integer.parseInt(txtRut.getText()));
        u.setCodigo_verificado(digito_verificador);
        u.setClave(clave+"");
        u.setNombre(txtNombre.getText());
        u.setApellido_paterno(txtPaterno.getText());
        u.setApellido_materno(txtMaterno.getText());
        u.setComuna(txtComuna.getText());
        u.setDireccion(txtDireccion.getText());
        u.setTelefono(Integer.parseInt(txtTelefono.getText()));
        u.setEmail(txtEmail.getText());
        u.setFecha_contrado( new java.sql.Date(dcFechaContrato.getDate().getTime())); //POSIBLEMENTE NO ME FUNCIONE OJO
        u.setDias_administrativos(Integer.parseInt(txtDiasAdministrativos.getText()));
        u.setDias_legales(Integer.parseInt(txtDiasLegales.getText()));
        u.setId_cargo(id_cargo);
        u.setId_perfil(id_perfil);
        u.setId_departamento(id_departamento);
        
        //REGISTRAMOS EL NUEVO USUARIO
        JOptionPane.showMessageDialog(null,dao.registrar_usuario(u));
        
        //LIMPIAR EL FORMULARIO
        limpiar();
        txtRut.requestFocus();
        
        
    }catch(Exception ex)
    {
        
    }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    try
    {
        //VALIDACIONES
        if(txtRut.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un Rut"); //GATILLA MENSAJE DE ERROR
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtRut.getText().length()>=15)
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un Rut Valido"); //GATILLA MENSAJE DE ERROR
            txtRut.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtVerificador.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Codigo verificado"); //GATILLA MENSAJE DE ERROR
            txtVerificador.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtVerificador.getText().length()>=2)
        {
            JOptionPane.showMessageDialog(null,"Ingrese Solo (0-9 o K)"); //GATILLA MENSAJE DE ERROR
            txtVerificador.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese Un nombre"); //GATILLA MENSAJE DE ERROR
            txtNombre.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtNombre.getText().length()>=30)
        {
            JOptionPane.showMessageDialog(null,"Nombre no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtNombre.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtPaterno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese apellido paterno"); //GATILLA MENSAJE DE ERROR
            txtPaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtPaterno.getText().length()>=30)
        {
            JOptionPane.showMessageDialog(null,"Apellido Patenro no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtPaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtMaterno.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese apellido materno"); //GATILLA MENSAJE DE ERROR
            txtMaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtMaterno.getText().length()>=30)
        {
            JOptionPane.showMessageDialog(null,"Apellido Materno no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtMaterno.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtComuna.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese una comuna"); //GATILLA MENSAJE DE ERROR
            txtComuna.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtComuna.getText().length()>=100)
        {
            JOptionPane.showMessageDialog(null,"Comuna no puede superar los 30 caracteres"); //GATILLA MENSAJE DE ERROR
            txtComuna.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDireccion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese una direccion"); //GATILLA MENSAJE DE ERROR
            txtDireccion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDireccion.getText().length()>=100)
        {
            JOptionPane.showMessageDialog(null,"Direccion no puede superar los 100 caracteres"); //GATILLA MENSAJE DE ERROR
            txtDireccion.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtTelefono.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un telefono"); //GATILLA MENSAJE DE ERROR
            txtTelefono.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtTelefono.getText().length()>=15)
        {
            JOptionPane.showMessageDialog(null,"El telefono no puede superar los 15 numeros"); //GATILLA MENSAJE DE ERROR
            txtTelefono.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtEmail.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese un correo electronico"); //GATILLA MENSAJE DE ERROR
            txtEmail.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        //CODIGO PARA VALIDAR UN CORREO ELECTRONICO
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ 
                                          "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email = txtEmail.getText();
        Matcher mather = pattern.matcher(email);
        if (mather.find() == false) {
            JOptionPane.showMessageDialog(null,"El email ingresado no es valido"); //GATILLA MENSAJE DE ERROR
            txtEmail.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
            
        } else {
            //System.out.println("El email ingresado es válido.");
        }
        if(dcFechaContrato.getDate()==null)
        {
            JOptionPane.showMessageDialog(null,"Ingrese fecha contrato"); //GATILLA MENSAJE DE ERROR
            dcFechaContrato.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDiasLegales.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null,"Ingrese Dias legales"); //GATILLA MENSAJE DE ERROR
           txtDiasLegales.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
           throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO 
        }
        if(txtDiasLegales.getText().length()>=3)
        {
            JOptionPane.showMessageDialog(null,"Ingrese solo numero 2 digitos"); //GATILLA MENSAJE DE ERROR
            txtDiasLegales.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDiasAdministrativos.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese dias administrativos"); //GATILLA MENSAJE DE ERROR
            txtDiasAdministrativos.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(txtDiasAdministrativos.getText().length()>=3)
        {
            JOptionPane.showMessageDialog(null,"Ingrese solo numero 2 digitos"); //GATILLA MENSAJE DE ERROR
            txtDiasAdministrativos.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(cbCargo.getSelectedItem().toString().equals("-Seleccione-"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione un cargo"); //GATILLA MENSAJE DE ERROR
            cbCargo.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(cbPerfil.getSelectedItem().toString().equals("-Seleccione-"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione un perfil"); //GATILLA MENSAJE DE ERROR
            cbPerfil.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        if(cbDepartamento.getSelectedItem().toString().equals("-Seleccione-"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione Departamento"); //GATILLA MENSAJE DE ERROR
            cbDepartamento.requestFocus(); //LA APLICACION FOCUSEA EL CAMPO DE ENTRADA
            throw new SQLException(); //SE EJECUTA UNA EXCEPCION, POR ENDE SE DETIENE EN ESTE PUNTO
        }
        UsuarioDAO dao = new UsuarioDAO();
        
        //Buscamos los id de CARGO , PERFIL Y DEPARTAMENTO
        String cargo = cbCargo.getSelectedItem().toString(); //RESCATAMOS LO SELECICONADO EN EL COMBO BOX
        String perfil = cbPerfil.getSelectedItem().toString();
        String departamento = cbDepartamento.getSelectedItem().toString();
        int id_cargo = dao.obtener_id_cargo(cargo);
        int id_perfil = dao.obtener_id_perfil(perfil);
        int id_departamento = dao.obtener_id_departamento(departamento);
        
         //CARGAMOS TODOS LOS DATOS A LA CLASE USUARIO
        Modelo.DTO.Usuario u = new Modelo.DTO.Usuario();
        u.setRut(Integer.parseInt(txtRut.getText()));
        u.setCodigo_verificado(txtVerificador.getText());
        u.setNombre(txtNombre.getText());
        u.setApellido_paterno(txtPaterno.getText());
        u.setApellido_materno(txtMaterno.getText());
        u.setComuna(txtComuna.getText());
        u.setDireccion(txtDireccion.getText());
        u.setTelefono(Integer.parseInt(txtTelefono.getText()));
        u.setEmail(txtEmail.getText());
        u.setFecha_contrado( new java.sql.Date(dcFechaContrato.getDate().getTime())); //POSIBLEMENTE NO ME FUNCIONE OJO
        u.setDias_administrativos(Integer.parseInt(txtDiasAdministrativos.getText()));
        u.setDias_legales(Integer.parseInt(txtDiasLegales.getText()));
        u.setId_cargo(id_cargo);
        u.setId_perfil(id_perfil);
        u.setId_departamento(id_departamento);
        
        //REGISTRAMOS EL NUEVO USUARIO
        JOptionPane.showMessageDialog(null,dao.editar_usuario(u));
        
        //LIMPIAR EL FORMULARIO
        limpiar();
        txtRut.requestFocus();
        
        
    }catch(Exception ex)
    {
        
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
     Mostrar_Usuario mu = new  Mostrar_Usuario(this,true,Usuario.this); //LLAMO AL JDIALOG CERRAR_SESION
     mu.setVisible(true); //LA HAGO VISIBLE
    }//GEN-LAST:event_btnMostrarActionPerformed
  
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
    char car = evt.getKeyChar(); 
        if((car<'0' || car>'9')) //para validar solo numeros en txtUsua
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
        if (txtTelefono.getText().length()>=15) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDiasLegalesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasLegalesKeyTyped
    char car = evt.getKeyChar(); 
        if((car<'0' || car>'9')) //para validar solo numeros en txtUsua
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
        if (txtDiasLegales.getText().length()>=2) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_txtDiasLegalesKeyTyped

    private void txtDiasAdministrativosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasAdministrativosKeyTyped
    char car = evt.getKeyChar(); 
        if((car<'0' || car>'9')) //para validar solo numeros en txtUsua
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
        if (txtDiasAdministrativos.getText().length()>=2) //Valida largo de un campo
        {
            evt.consume(); //evita ingresar lo NO DESEADO
        }
    }//GEN-LAST:event_txtDiasAdministrativosKeyTyped

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JComboBox<String> cbPerfil;
    private com.toedter.calendar.JDateChooser dcFechaContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jmCerrarSesion;
    private javax.swing.JMenuItem jmFeriado;
    private javax.swing.JMenuItem jmInicio;
    private javax.swing.JMenuBar jmMenu;
    private javax.swing.JMenuItem jmMotivo;
    private javax.swing.JMenuItem jmTipo;
    private javax.swing.JMenuItem jmUnidad;
    private javax.swing.JMenuItem jmUsuario;
    private javax.swing.JTextField txtComuna;
    private javax.swing.JTextField txtDiasAdministrativos;
    private javax.swing.JTextField txtDiasLegales;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtVerificador;
    // End of variables declaration//GEN-END:variables
}

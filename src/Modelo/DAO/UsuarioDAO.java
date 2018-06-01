/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DTO.Usuario; //PAQUETE Modelo.DTO
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet; //PAQUETE PARA GUARDAR RESULTADO DE LAS SENTENCIAS SQL
import java.sql.SQLException; //PAQUETE DE EXCEPCIONES DE TIPO SQL
import java.sql.Statement; // PAQUETE INSTRUCCIONES SQL
import java.sql.Types;
import java.util.ArrayList; //PAQUETE ARRAY
import oracle.jdbc.OracleTypes;



/**
 *
 * @author Angelo
 * version 1
 */
public class UsuarioDAO{
    
    private Statement instru; //VARIABLE PARA EJECUTAR INSTRUCCIONES
    Conexion c;
    
    public UsuarioDAO() throws Exception
    {
        c = new Conexion(); //LLAMAMOS LA CLASE CONEXION
        instru = c.crearInstruccion(); //EJECUTAMOS INSTRUCCION CREAR INSTRUCCION DE LA CLASE CONEXION
    }
    
    public int generar_clave()
    {
        int numero;
        numero = (int) (Math.random()*1000 +1);
        return numero;
    }
    
    public ArrayList iniciar_sesion(int rut,String clave) throws Exception
    {
        ResultSet dato; 
        String cargo = "ADMINISTRADOR"; //VARIABLE PARA VERIFICAR QUE EL USUARIO ES ADMINISTRADOR
        String sql = ""; //VARIABLE PARA SENTENCIA SQL
        ArrayList<Usuario> lista = new ArrayList<Usuario>(); //ARRAY LIST DE TIPO Usuario
        
        try
        {
            sql = "SELECT CONCAT(CONCAT(NOMBRES,' '),APELLIDO_PATERNO||' '||APELLIDO_MATERNO) AS NOMBRES , RUT"+
                  " FROM USUARIOS U"+
                  " JOIN USUARIO_PERFILES UP"+
                  " ON(U.PERFIL = UP.ID_PERFIL)"+
                  " WHERE RUT LIKE "+rut+" AND CLAVE LIKE '"+clave+"' AND UP.PERFIL LIKE '"+cargo+"'"; //CADENA SQL
            dato = instru.executeQuery(sql); //EJECUTAMOS EL SQL
            while(dato.next()) //RECORRIMOS LO OBTENIDO
            {
                int r_rut = Integer.parseInt(dato.getString("rut")); //GUARDAMOS EL RUT
                String r_nombres = dato.getString("nombres"); //GUARDAMOS EL NOMBRE COMPLETO
                Usuario u = new Usuario(r_rut,clave,r_nombres); //CREAMOS UNA INSTANCIA DE USUARIO
                lista.add(u); //AGREGAMOS LO OBTENIDO AL ARRAY 
            }
            return lista; //RETORNA LA LISTA
                    
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage()); //GATILLA EXCEPCION SI OCURRE UN ERROR
        }
    }
    
    public String registrar_usuario(Usuario u) //PARA REGISTRAR
    {
        String resultado = null;
        try
        {
           //PARA LLAMAR AL PROCEDIMIENTO ALMACENADO
           // LOS ? SON LOS PARAMETROS TANTO DE ENTRADA COMO DE SALIDA
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_REGISTRAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
            
            //CARGAR LOS PARAMETROS DE ENTRADA
            proc.setInt("p_rut",u.getRut()); //PRIMER ARGUMENTO DE TIPO STRING
            proc.setString("p_dv",u.getCodigo_verificado()); //SEGUNDO ARGUMENTO DE TIPO INT
            proc.setString("p_clave",u.getClave()); //TERCER ARGUMENTO DE TIPO STRING
            proc.setString("p_nombres",u.getNombre());
            proc.setString("p_apellido_paterno",u.getApellido_paterno());
            proc.setString("p_apellido_materno",u.getApellido_materno());
            proc.setString("p_direccion",u.getDireccion());
            proc.setString("p_comuna",u.getComuna());
            proc.setInt("p_telefono",u.getTelefono());
            proc.setString("p_email",u.getEmail());
            proc.setInt("p_dd_legales",u.getDias_legales());
            proc.setInt("p_dd_administrativos",u.getDias_administrativos());
            proc.setDate("p_fecha_contrato",u.getFecha_contrado()); //TODO OK EN DAO
            proc.setInt("p_perfil",u.getId_perfil());
            proc.setInt("p_cargo",u.getId_cargo());
            proc.setInt("p_departamento",u.getId_departamento());
            //CARGAR PARAMETROS DE SALIDA
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            
            //EJECUTAR PROCEDIMIENTO ALMACENADO
            proc.execute();
            
            //DEVUELVE EL VALOR DEL PARAMETRO DE SALIDA DEL PROCEDIMIENTO
            resultado = proc.getString("p_resultado");
            
        }catch(SQLException ex)
        {
            ex.getMessage(); //MENSAJE DE ERROR SI SE GATILLA UNA EXCEPCION
        }
        return resultado;
    }
    
    public String editar_usuario(Usuario u) //PARA REGISTRAR
    {
        String resultado = null;
        try
        {
           //PARA LLAMAR AL PROCEDIMIENTO ALMACENADO
           // LOS ? SON LOS PARAMETROS TANTO DE ENTRADA COMO DE SALIDA
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_EDITAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
            
            //CARGAR LOS PARAMETROS DE ENTRADA
            proc.setInt("p_rut",u.getRut()); //PRIMER ARGUMENTO DE TIPO STRING
            //proc.setString("p_digito_verificador",u.getCodigo_verificado()); NO APLICA
            //proc.setString("p_clave",u.getClave()); NO APLICA
            proc.setString("p_nombres",u.getNombre());
            proc.setString("p_apellido_paterno",u.getApellido_paterno());
            proc.setString("p_apellido_materno",u.getApellido_materno());
            proc.setString("p_direccion",u.getDireccion());
            proc.setString("p_comuna",u.getComuna());
            proc.setInt("p_telefono",u.getTelefono());
            proc.setString("p_email",u.getEmail());
            proc.setInt("p_dd_legales",u.getDias_legales());
            proc.setInt("p_dd_administrativos",u.getDias_administrativos());
            proc.setDate("p_fecha_contrato",u.getFecha_contrado()); //TODO OK EN DAO
             proc.setInt("p_perfil",u.getId_perfil());
            proc.setInt("p_cargo",u.getId_cargo());
            proc.setInt("p_departamento",u.getId_departamento());
            //CARGAR PARAMETROS DE SALIDA
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            
            //EJECUTAR PROCEDIMIENTO ALMACENADO
            proc.execute();
            
            //DEVUELVE EL VALOR DEL PARAMETRO DE SALIDA DEL PROCEDIMIENTO
            resultado = proc.getString("p_resultado");
            
        }catch(SQLException ex)
        {
            ex.getMessage(); //MENSAJE DE ERROR SI SE GATILLA UNA EXCEPCION
        }
        return resultado;
    }
    
    public ArrayList buscar_Usuario(int rut) throws Exception //SIN TESTEAR AUN
    {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            proc.setInt("p_rut" ,rut);
            
            proc.registerOutParameter("p_dv",Types.VARCHAR);
            proc.registerOutParameter("p_clave",Types.VARCHAR);
            proc.registerOutParameter("p_nombres",Types.VARCHAR);
            proc.registerOutParameter("p_apellido_paterno",Types.VARCHAR);
            proc.registerOutParameter("p_apellido_materno",Types.VARCHAR);
            proc.registerOutParameter("p_direccion",Types.VARCHAR);
            proc.registerOutParameter("p_comuna",Types.VARCHAR);
            proc.registerOutParameter("p_telefono",Types.NUMERIC);
            proc.registerOutParameter("p_email",Types.VARCHAR);
            proc.registerOutParameter("p_dd_legales",Types.NUMERIC);
            proc.registerOutParameter("p_dd_administrativos",Types.NUMERIC);
            proc.registerOutParameter("p_fecha_contrato",Types.DATE);
            proc.registerOutParameter("p_perfil",Types.NUMERIC);
            proc.registerOutParameter("p_cargo",Types.NUMERIC);
            proc.registerOutParameter("p_departamento",Types.NUMERIC);
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            
            proc.execute();
            
            String codigo_verificador = proc.getString("p_dv");
            String clave = proc.getString("p_clave");
            String nombre = proc.getString("p_nombres");
            String apellido_paterno = proc.getString("p_apellido_paterno");
            String apellido_materno = proc.getString("p_apellido_materno");
            String direccion = proc.getString("p_direccion");
            String comuna = proc.getString("p_comuna");
            int telefono = proc.getInt("p_telefono");
            String email = proc.getString("p_email");
            int dias_legales = proc.getInt("p_dd_legales");
            int dias_administrativos = proc.getInt("p_dd_administrativos");
            Date fecha_contrato = proc.getDate("p_fecha_contrato");
            int id_perfil = proc.getInt("p_perfil");
            int id_cargo = proc.getInt("p_cargo");
            int id_departamento = proc.getInt("p_departamento");
            String mensaje = proc.getString("p_resultado");
            
            String perfil = obtener_perfil_por_id(id_perfil) ;
            String cargo = obtener_cargo_por_id(id_cargo);
            String departamento = obtener_departamento_por_id(id_departamento);
            
            
            Usuario u = new Usuario();
            u.setRut(rut);
            u.setCodigo_verificado(codigo_verificador);
            u.setClave(clave);
            u.setNombre(nombre);
            u.setApellido_paterno(apellido_paterno);
            u.setApellido_materno(apellido_materno);
            u.setDireccion(direccion);
            u.setComuna(comuna);
            u.setTelefono(telefono);
            u.setEmail(email);
            u.setDias_legales(dias_legales);
            u.setDias_administrativos(dias_administrativos);
            u.setFecha_contrado(fecha_contrato);
            u.setId_perfil(id_perfil);
            u.setId_cargo(id_cargo);
            u.setId_departamento(id_departamento);
            u.setResultado(mensaje);
            u.setPerfil(perfil);
            u.setCargo(cargo);
            u.setDepartamento(departamento);
            
            lista.add(u);
            
        }catch(SQLException ex)
        {
                throw new Exception(ex.getMessage());
        }
        return lista;
    }
    
    public String obtener_cargo_por_id(int id_cargo) throws Exception
    {
        String cargo ="";
        try
        {
            CallableStatement cs = c.getConexion().prepareCall("CALL PR_OBTENER_CARGO_POR_ID (?,?) ");
            cs.setInt("p_id_cargo" ,id_cargo);
            cs.registerOutParameter("p_cargo",Types.VARCHAR);
            cs.execute();
            cargo = cs.getString("p_cargo");
            
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return cargo;
    }
    
    public String obtener_perfil_por_id(int id_perfil) throws Exception
    {
        String perfil ="";
        try
        {
            CallableStatement cs = c.getConexion().prepareCall("CALL PR_OBTENER_PERFIL_POR_ID (?,?) ");
            cs.setInt("p_id_perfil" ,id_perfil);
            cs.registerOutParameter("p_perfil",Types.VARCHAR);
            cs.execute();
            perfil = cs.getString("p_perfil");
            
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return perfil;
    }
    
    public String obtener_departamento_por_id(int id_departamento) throws Exception
    {
        String departamento ="";
        try
        {
            CallableStatement cs = c.getConexion().prepareCall("CALL PR_OBTENER_DEP_POR_ID (?,?) ");
            cs.setInt("p_id_departamento" ,id_departamento);
            cs.registerOutParameter("p_departamento",Types.VARCHAR);
            cs.execute();
            departamento = cs.getString("p_departamento");
            
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return departamento;
    }
    
    public ArrayList obtener_cargos() throws Exception //PARA CARGAR EL DROP DOWN LIST DE CARGOS, CON LOS CARGOS DE LA BD
    {
        ArrayList<String> cargos = new ArrayList<String>();
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_USUARIO_CARGO.PR_MOSTRAR_USUARIO_CARGO (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                int contador = 0;
                cargos.add(contador,resul.getString("cargo"));
            }
            return cargos;
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
    
    public ArrayList obtener_departamentos() throws Exception //PARA CARGAR EL DROP DOWN LIST DE DEPARTMANTOS, CON LOS CARGOS DE LA BD
    {
        ArrayList<String> departamentos = new ArrayList<String>();
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_USUARIO_DEP.PR_MOSTRAR_USUARIO_DEP (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                int contador = 0;
                departamentos.add(contador,resul.getString("departamento"));
            }
            return departamentos;
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
    
    public ArrayList obtener_perfiles() throws Exception //PARA CARGAR EL DROP DOWN LIST DE DEPARTMANTOS, CON LOS CARGOS DE LA BD
    {
        ArrayList<Usuario> perfiles = new ArrayList<Usuario>();
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_USUARIO_PERFIL.PR_MOSTRAR_USUARIO_PERFIL (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                int contador = 0;
                Usuario u = new Usuario();
                u.setPerfil(resul.getString("perfil"));
                perfiles.add(contador, u);
                contador++;
            }
            return perfiles;
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
    
    public int obtener_id_cargo(String cargo) throws Exception
    {
        int id = 0;
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_OBTENER_ID_CARGO(?,?)");
            proc.setString("p_cargo",cargo);
            proc.registerOutParameter("p_id_cargo",Types.NUMERIC);
            proc.execute();
            id = proc.getInt("p_id_cargo");
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
        return id;
    }
    
    public int obtener_id_perfil(String perfil) throws Exception
    {
        int id = 0;
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_OBTENER_ID_PERFIL(?,?)");
            proc.setString("p_perfil",perfil);
            proc.registerOutParameter("p_id_perfil",Types.NUMERIC);
            proc.execute();
            id = proc.getInt("p_id_perfil");
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
        return id;
    }
    
    public int obtener_id_departamento(String departamento) throws Exception
    {
        int id = 0;
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_OBTENER_ID_DEP(?,?)");
            proc.setString("p_departamento",departamento);
            proc.registerOutParameter("p_id_departamento",Types.NUMERIC);
            proc.execute();
            id = proc.getInt("p_id_departamento");
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
        return id;
    }
    
    public ArrayList obtener_usuarios()
    {
        ArrayList<Usuario> lista = new ArrayList<Usuario>(); //ARRAY LIST DE TIPO Usuario
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_USUARIO.PR_MOSTRAR_USUARIO (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                Usuario u = new Usuario(); //CLASE TIPO, !!NO MOVER!!
                int contador  = 0 ;
                u.setRut(resul.getInt("rut"));
                u.setClave(resul.getString("clave"));
                u.setCodigo_verificado(resul.getString("dv"));
                u.setNombre(resul.getString("nombres"));
                u.setApellido_paterno(resul.getString("apellido_paterno"));
                u.setApellido_materno(resul.getString("apellido_materno"));
                u.setDireccion(resul.getString("direccion"));
                u.setComuna(resul.getString("comuna"));
                u.setTelefono(resul.getInt("telefono"));
                u.setEmail(resul.getString("email"));
                u.setDias_legales(resul.getInt("dd_legales"));
                u.setDias_administrativos(resul.getInt("dd_administrativos"));
                u.setFecha_contrado(resul.getDate("fecha_contrato"));
                //ID DE LA TABLA USUARIO
                /*u.setId_cargo(resul.getInt("id_cargo"));
                u.setId_departamento(resul.getInt("id_departamento"));
                u.setId_direccion(resul.getInt("id_direccion"));
                u.setId_perfil(resul.getInt("id_perfil"));*/
                u.setCargo(resul.getString("cargo"));
                u.setDepartamento(resul.getString("departamento"));
                u.setPerfil(resul.getString("perfil"));
                lista.add(contador,u);
                contador ++;
            }
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return lista;
        
    }
    
   /*public static void main(String[]args) throws Exception
    {
        try
        {
            UsuarioDAO dao = new UsuarioDAO();
            int rut = 999;
            ArrayList<Usuario> u = dao.buscar_Usuario(rut);
            System.out.println(u.get(0).getApellido_materno());
            System.out.println(u.get(0).getApellido_paterno());
            System.out.println(u.get(0).getCargo());
            System.out.println(u.get(0).getCodigo_verificado());
            System.out.println(u.get(0).getComuna());
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage());
        }
    }*/
}

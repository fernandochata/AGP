/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DTO.Tipo;
import java.sql.CallableStatement; //LIBRERIA PARA EJECUTAR PROCEDIMIENTOS ALMACENADOS
import java.sql.Connection; //LIBRERIA CONEXION A LA BASE DE DATOS
import java.sql.ResultSet;
import java.sql.SQLException; //LIBRERIA EXCEPCIONES SQL
import java.sql.Statement; //PARA EJECUTAR LOS SQL
import java.sql.Types;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Angelo
 */
public class TipoDAO {
    
    Statement instru; //VARIABLE DE INSTRUCCIONES SQL
    Conexion c; //VARIABLE PARA RESCATAR LA CLASE CONEXION PARA MAS TARTE
    
    public TipoDAO()  throws Exception
    {
        c = new Conexion(); //ASIGNAMOS LA CLASE CONEXION A LA VARIABLE C
        instru = c.crearInstruccion(); //CREAMOS LA INSTRUCCION USANDO LA CLASE CONEXION
        
    }
    
    
    public String registrar_tipo_permiso(Tipo t) //PARA REGISTRAR
    {
        String resultado = null;
        try
        {
           //PARA LLAMAR AL PROCEDIMIENTO ALMACENADO
           // LOS ? SON LOS PARAMETROS TANTO DE ENTRADA COMO DE SALIDA
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_REGISTRAR_TIPO_PERMISO(?,?,?,?,?)"); 
            
            //CARGAR LOS PARAMETROS DE ENTRADA
            proc.setString("p_tipo",t.get_tipo()); //PRIMER ARGUMENTO DE TIPO STRING
            proc.setInt("p_dias",t.get_dias()); //SEGUNDO ARGUMENTO DE TIPO INT
            proc.setString("p_descripcion",t.get_descripcion()); //TERCER ARGUMENTO DE TIPO STRING
            proc.setInt("p_estado_tipo",t.get_estado_tipo()); //CUARTO ARGUMENTO DE TIPO INT
            
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
    
    public String editar_tipo(Tipo t)
    {
        String resultado = null;
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_EDITAR_TIPO_PERMISO(?,?,?,?,?,?)");
            proc.setInt("p_id_tipo",t.get_id_tipo());
            proc.setString("p_tipo",t.get_tipo()); //PRIMER ARGUMENTO DE TIPO STRING
            proc.setInt("p_dias",t.get_dias()); //SEGUNDO ARGUMENTO DE TIPO INT
            proc.setString("p_descripcion",t.get_descripcion()); //TERCER ARGUMENTO DE TIPO STRING
            proc.setInt("p_estado_tipo",t.get_estado_tipo()); //CUARTO ARGUMENTO DE TIPO INT
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            proc.execute();
            resultado = proc.getString("p_resultado");
        }catch(SQLException ex)
        {
            ex.getErrorCode();
        }
        return resultado;
    }
    
    public ArrayList buscar_tipo(int id_tipo)
    {
        ArrayList<Tipo> lista = new ArrayList<Tipo>();
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_TIPO_PERMISO(?,?,?,?,?,?)");
            proc.setInt("p_id_tipo" , id_tipo);
            proc.registerOutParameter("p_tipo",Types.VARCHAR);
            proc.registerOutParameter("p_dias",Types.INTEGER);
            proc.registerOutParameter("p_descripcion",Types.VARCHAR);
            proc.registerOutParameter("p_estado_tipo",Types.NUMERIC);
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            proc.execute();
            String tipo = proc.getString("p_tipo");
            int dias = proc.getInt("p_dias");
            String descripcion = proc.getString("p_descripcion");
            int estado = proc.getInt("p_estado_tipo");
            Tipo t = new Tipo(tipo,dias,descripcion,estado);
            t.set_id_tipo(id_tipo);
            lista.add(t);
        }catch(Exception ex)
        {
                
        }
        return lista;
    }
    
    public ArrayList buscar_tipo_tipo(String tipo)
    {
        ArrayList<Tipo> lista = new ArrayList<Tipo>();
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_TIPO_TIPO(?,?,?,?,?,?)");
            proc.setString("p_tipo" ,tipo);
            proc.registerOutParameter("p_id_tipo",Types.INTEGER);
            proc.registerOutParameter("p_dias",Types.INTEGER);
            proc.registerOutParameter("p_descripcion",Types.VARCHAR);
            proc.registerOutParameter("p_estado_tipo",Types.NUMERIC);
            proc.registerOutParameter("p_mensaje",Types.VARCHAR);
            proc.execute();
            int id = proc.getInt("p_id_tipo");
            int dias = proc.getInt("p_dias");
            String descripcion = proc.getString("p_descripcion");
            int estado = proc.getInt("p_estado_tipo");
            Tipo t = new Tipo(tipo,dias,descripcion,estado);
            String resultado = proc.getString("p_mensaje");
            t.set_id_tipo(id);
            t.setResultado(resultado);
            lista.add(t);
        }catch(Exception ex)
        {
                
        }
        return lista;
    }
    
    public ArrayList obtener_tipo_permisos()
    {
        ArrayList<Tipo> lista = new ArrayList<Tipo>(); //ARRAY LIST DE TIPO Usuario
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_TIPO_PERMISOS.PR_MOSTRAR_TIPO_PERMISOS (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                Tipo t = new Tipo(); //CLASE TIPO, !!NO MOVER!!
                int contador  = 0 ;
                t.set_id_tipo(resul.getInt("id_tipo"));
                t.set_tipo(resul.getString("tipo"));
                t.set_dias(resul.getByte("dias")); 
                t.set_descripcion(resul.getString("descripcion"));
                t.set_estado_tipo(resul.getByte("estado_tipo"));
                lista.add(contador,t);
                contador ++;
            }
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return lista;
        
    }
    
    
    //TESTE DE LOS PROCEDIMIENTOS
    /*public static void main(String args[]) throws Exception
    {
        byte dias = 2;
        byte disponible = 1;
        Tipo t = new Tipo("Prueba desde PHP",dias,"Ojalas funcione",disponible);
        TipoDAO d = new TipoDAO();
        //System.out.println(d.registrar_tipo_permiso(t));
        ArrayList<Tipo> lista = d.buscar_tipo_tipo("u");
        for(int i=0;i<lista.size();i++)
        {
            System.out.println(lista.get(i).get_descripcion());
        }
    }*/
}

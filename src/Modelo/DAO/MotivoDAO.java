/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DTO.Motivo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Angelo
 */
public class MotivoDAO {
    
    Statement instru;
    Conexion c;
    
    public MotivoDAO() throws Exception
    {
        c = new Conexion();
        instru = c.crearInstruccion();
        
    }
    
    public String registrar_permiso_motivo(Motivo m) //PARA REGISTRAR
    {
        String resultado = null;
        try
        {
           //PARA LLAMAR AL PROCEDIMIENTO ALMACENADO
           // LOS ? SON LOS PARAMETROS TANTO DE ENTRADA COMO DE SALIDA
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_REGISTRAR_MOTIVO_PERMISO(?,?)"); 
            
            //CARGAR LOS PARAMETROS DE ENTRADA
            proc.setString("p_motivo",m.getMotivo()); //PRIMER ARGUMENTO DE TIPO STRING

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
    
    public String editar_motivo(Motivo m)
    {
        String resultado = null;
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_EDITAR_PERMISO_MOTIVO(?,?,?)");
            proc.setInt("p_id_motivo",m.getId());
            proc.setString("p_motivo",m.getMotivo()); 
            
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            proc.execute();
            resultado = proc.getString("p_resultado");
        }catch(SQLException ex)
        {
            ex.getErrorCode();
        }
        return resultado;
    }
    
    public ArrayList buscar_Motivo(int id_motivo)
    {
        ArrayList<Motivo> lista = new ArrayList<Motivo>();
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_PERMISO_MOTIVO(?,?,?)");
            proc.setInt("p_id_motivo" , id_motivo);
            
            proc.registerOutParameter("p_motivo",Types.VARCHAR);
            proc.registerOutParameter("p_resultado",Types.VARCHAR);

            proc.execute();
            String motivo = proc.getString("p_motivo");
            String resultado = proc.getString("p_resultado");
            Motivo u = new Motivo(motivo,resultado,id_motivo);
            lista.add(u);
        }catch(Exception ex)
        {
                
        }
        return lista;
    }
    
    public ArrayList obtener_permiso_motivo()
    {
        ArrayList<Motivo> lista = new ArrayList<Motivo>(); //ARRAY LIST DE TIPO Usuario
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_PERMISO_MOTIVO.PR_MOSTRAR_PERMISO_MOTIVO (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                Motivo m = new Motivo(); //CLASE TIPO, !!NO MOVER!!
                int contador  = 0 ;
                m.setId(resul.getInt("id_motivo"));
                m.setMotivo(resul.getString("motivo"));
                lista.add(contador,m);
                contador ++;
            }
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return lista;
        
    }
    
}

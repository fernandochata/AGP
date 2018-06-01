/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import Modelo.DTO.Feriado;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Angelo
 */
public class FeriadoDAO {
    private Statement instru; //VARIABLE PARA EJECUTAR INSTRUCCIONES
    Conexion c;
    
    public FeriadoDAO() throws Exception
    {
        c = new Conexion(); //LLAMAMOS LA CLASE CONEXION
        instru = c.crearInstruccion(); //EJECUTAMOS INSTRUCCION CREAR INSTRUCCION DE LA CLASE CONEXION
    }
    
    public String registrar_feriado(Feriado f) //PARA REGISTRAR
    {
        String resultado = null;
        try
        {
           //PARA LLAMAR AL PROCEDIMIENTO ALMACENADO
           // LOS ? SON LOS PARAMETROS TANTO DE ENTRADA COMO DE SALIDA
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_REGISTRAR_FERIADO(?,?,?)"); 
            
            //CARGAR LOS PARAMETROS DE ENTRADA
            proc.setDate("p_feriado",f.getFeriado()); //PRIMER ARGUMENTO DE TIPO STRING
            proc.setString("p_descripcion",f.getDescripcion()); //SEGUNDO ARGUMENTO DE TIPO INT

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
    
    public String editar_feriado(Feriado f)
    {
        String resultado = null;
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_EDITAR_FERIADO(?,?,?,?)");
            proc.setInt("p_id",f.getIdFeriado());
            proc.setDate("p_feriado",f.getFeriado()); //PRIMER ARGUMENTO DE TIPO STRING
            proc.setString("p_descripcion",f.getDescripcion()); //SEGUNDO ARGUMENTO DE TIPO INT
            
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            proc.execute();
            resultado = proc.getString("p_resultado");
        }catch(SQLException ex)
        {
            ex.getErrorCode();
        }
        return resultado;
    }
    
    public ArrayList buscar_feriado(int id_feriado)
    {
        ArrayList<Feriado> lista = new ArrayList<Feriado>();
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_FERIADO_ID(?,?,?,?)");
            proc.setInt("p_id" ,id_feriado);
            proc.registerOutParameter("p_feriado",Types.DATE);
            proc.registerOutParameter("p_descripcion",Types.VARCHAR);
            proc.registerOutParameter("p_resultado",Types.VARCHAR);
            proc.execute();
            Date feriado = proc.getDate("p_feriado");
            String descripcion = proc.getString("p_descripcion");
            String resultado = proc.getString("p_descripcion");
            Feriado f = new Feriado(id_feriado,feriado,descripcion);
            f.setResultado(resultado);
            lista.add(f);
        }catch(Exception ex)
        {
                
        }
        return lista;
    }public ArrayList obtener_feriados()
    {
        ArrayList<Feriado> lista = new ArrayList<Feriado>(); //ARRAY LIST DE TIPO Usuario
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_FERIADO.PR_MOSTRAR_FERIADO (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                Feriado f = new Feriado(); //CLASE TIPO, !!NO MOVER!!
                int contador  = 0 ;
                f.setIdFeriado(resul.getInt("id_feriados"));
                f.setFeriado(resul.getDate("feriados"));
                f.setDescripcion(resul.getString("descripcion")); 
                lista.add(contador,f);
                contador ++;
            }
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return lista;
        
    }
    
}

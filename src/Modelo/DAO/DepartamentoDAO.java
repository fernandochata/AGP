/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;


import Modelo.DTO.Departamento; //CLASE DEPARTAMENTO DTO
import java.sql.CallableStatement; //PARA EJECUTAR LOS PROCEDIMIENTOS ALMACENADOS
import java.sql.ResultSet; //PARA EJECUTAR INSTRUCCIONES SQL
import java.sql.SQLException; //PARA GATILLAR ERRORES DE BASE DE DATOS
import java.sql.Statement; //PARA REALIZAR INSTRUCCIONES
import java.sql.Types; //PARA RETORNAR CURSORES, VARCHAR, INTEGER , ETC
import java.util.ArrayList; //LIBRERIA PARA LOS ARREGLOS
import javax.swing.JOptionPane; //MENSAJE DE ALERTA
import oracle.jdbc.OracleTypes; // CADENA DE CONEXION

/**
 *
 * @author Angelo
 * version = 2
 */
public class DepartamentoDAO {
    
    Statement instru; //VARIABLE DE INSTRUCCIONES SQL
    Conexion c; //VARIABLE PARA RESCATAR LA CLASE CONEXION PARA MAS TARTE
    
    public DepartamentoDAO() //METODO CONTRUCTOR
    {
        try
        {
            c = new Conexion(); //ASIGNAMOS LA CLASE CONEXION A LA VARIABLE C
            instru = c.crearInstruccion(); //CREAMOS LA INSTRUCCION USANDO LA CLASE CONEXION

        }catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(null,"Error al conectar");
        }
    }
    
    public String registrar_usuario_Departamento(Departamento u) //PARA REGISTRAR
    {
        String resultado = null; //MENSAJE QUE RETORNA
        try
        {
           //PARA LLAMAR AL PROCEDIMIENTO ALMACENADO
           // LOS ? SON LOS PARAMETROS TANTO DE ENTRADA COMO DE SALIDA
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_REGISTRAR_USUARIO_DEP(?,?,?)"); 
            
            //CARGAR LOS PARAMETROS DE ENTRADA
            proc.setString("p_departamento",u.getDepartamento()); //PRIMER ARGUMENTO DE TIPO STRING
            proc.setString("p_descripcion",u.getDescripcion()); //SEGUNDO ARGUMENTO DE TIPO INT

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
        return resultado; //RETORNAMOS EL MENSAJE OBTENIDO
    }
    
    public String editar_departamento(Departamento u ) //PARA EDITAR DEPARTAMENTO
    {
        String resultado = null; //MENSAJE DEL RESULTADO
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_EDITAR_USUARIO_DEP(?,?,?,?)"); //LLAMAMOS EL PROCEDIMIENTO
            proc.setInt("p_id_departamento",u.getId_departamento()); //CARGAMOS PARAMETROS DE ENTRADA
            proc.setString("p_departamento",u.getDepartamento());  //ENTRADA
            proc.setString("p_descripcion",u.getDescripcion());  //ENTRADA
            
            proc.registerOutParameter("p_resultado",Types.VARCHAR); //CARGAMOS PARAMETROS DE SALIDA
            proc.execute(); //EJECUTAMOS EL PROCEDIMIENTO
            resultado = proc.getString("p_resultado"); //RESCATAMOS EL RESULTADO
        }catch(SQLException ex)
        {
            ex.getErrorCode(); //GATILLA MENSAJE DE ERROR , SI APLICA
        }
        return resultado; //RETORNA EL RESULTADO
    }
    
    public ArrayList buscar_Departamento(int id_departamento) //PARA BUSCAR DEPARTAMENTO POR ID
    {
        ArrayList<Departamento> lista = new ArrayList<Departamento>(); //ARRAY LIST DE TIPO DEPARTAMENO DTO
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_USUARIO_DEP(?,?,?,?)"); //LLAMAMOS EL PROCEDIMIENTO
            proc.setInt("p_id_departamento" , id_departamento); //CARGAMOS DATOS DE ENTRADA
            
            proc.registerOutParameter("p_departamento",Types.VARCHAR); //CARGAMOS DATOS DE SALIDA
            proc.registerOutParameter("p_descripcion",Types.VARCHAR); //CARGAMOS DATOS DE SALIDA
            proc.registerOutParameter("p_resultado",Types.VARCHAR); //CARGAMOS DARTOS DE SALIDA

            proc.execute(); //EJECUTAMOS EL PROCEDIMIENTO
            String departamento = proc.getString("p_departamento"); //RESCATAMOS PARAMETROS DE SALIDA
            String descripcion = proc.getString("p_descripcion"); //RESCATAMOS PARAMETROS DE SALIDA
            String resultado = proc.getString("p_resultado"); //RESCATAMOS PARAMETROS DE SALIDA
            Departamento u = new Departamento(id_departamento,departamento,descripcion,resultado); //CREAMOS UN NUEVO OBJETO DEPARTAMENTO
            lista.add(u); //LO AGREGAMOS AL ARRAY LIST LISTA
        }catch(Exception ex)
        {
                
        }
        return lista; //RETORNAMOS LA LISTA
    }
    
    public ArrayList buscar_departamento_departamento(String departamento)
    {
        ArrayList<Departamento> lista = new ArrayList<Departamento>();
        try
        {
            CallableStatement proc = c.getConexion().prepareCall("CALL PR_BUSCAR_UNIDAD_POR_DEP(?,?,?,?)");
            proc.setString("p_departamento" ,departamento);
            
            proc.registerOutParameter("p_id_departamento",Types.INTEGER);
            proc.registerOutParameter("p_descripcion",Types.VARCHAR);
            proc.registerOutParameter("p_mensaje",Types.VARCHAR);
            
            proc.execute();
            int id = proc.getInt("p_id_departamento");
            String descripcion = proc.getString("p_descripcion");
            String mensaje = proc.getString("p_mensaje");
            Departamento u = new Departamento(id,"",descripcion,mensaje);
            lista.add(u);
        }catch(Exception ex)
        {
                
        }
        return lista;
    }
    
    public ArrayList obtener_usuario_departamento()
    {
        ArrayList<Departamento> lista = new ArrayList<Departamento>(); //ARRAY LIST DE TIPO Usuario
        try
        {
            ResultSet resul = null;
            CallableStatement cs = c.getConexion().prepareCall("CALL MOSTRAR_USUARIO_DEP.PR_MOSTRAR_USUARIO_DEP (?)");
            cs.registerOutParameter("v_cursor",OracleTypes.CURSOR);
            cs.execute();
            resul = (ResultSet) cs.getObject("v_cursor");
            while(resul.next())
            {
                Departamento u = new Departamento(); //CLASE TIPO, !!NO MOVER!!
                //int contador  = 0 ;
                u.setId_departamento(resul.getInt("id_departamento")); //ESTA LINEA TIENDE A FALLAR
                
                u.setDepartamento(resul.getString("departamento"));
                u.setDescripcion(resul.getString("descripcion")); //ESTA LINEA TIENDE A FALLAR
                lista.add(u);
                //contador ++;
                //PARA SOLUCIONAR EL PROBLEMA DE MOSTRAR DEPARTAMENTO, TUVE QUE VOLVER A EJECUTAR EL PROCEDIMIENTO ALMACENADO
            }
        }catch(SQLException ex)
        {
            ex.getMessage();
        }
        return lista;
        
    }
    
    //public static void main(String[]args)
    //{
        //DepartamentoDAO dao = new DepartamentoDAO();
        /*Departamento u = new Departamento(0,"Finanzas","Money","");
        String mensaje = dao.registrar_usuario_Departamento(u);
        System.out.println(mensaje);
        Departamento u2 = new Departamento(22,"Finanzas++","Fue modificado","");
        mensaje = dao.editar_departamento(u2);
        System.out.println(mensaje);
        ArrayList<Departamento>lista = dao.buscar_Departamento(1);
        for(int i=0; i<lista.size();i++)
        {
            System.out.println("Departamento:"+lista.get(i).getDepartamento());
            System.out.println("Descripcion:"+lista.get(i).getDescripcion());
            System.out.println("Mensaje:"+lista.get(i).getResultado());
        }
        lista= dao.buscar_departamento_departamento("RR.HH");
        for(int i=0; i<lista.size();i++)
        {
            System.out.println("Departamento:"+lista.get(i).getDepartamento());
            System.out.println("Descripcion:"+lista.get(i).getDescripcion());
            System.out.println("Mensaje:"+lista.get(i).getResultado());
        }
        System.out.println("*********************************************");
        */
        /*ArrayList<Departamento>lista2= dao.obtener_usuario_departamento();
        for(int i=0; i<lista2.size(); i++)
        {
            System.out.println("ID:"+lista2.get(i).getId_departamento());
            System.out.println("Departamento:"+lista2.get(i).getDepartamento());
            System.out.println("Descripcion:"+lista2.get(i).getDescripcion());
        }        
        
    }*/
}

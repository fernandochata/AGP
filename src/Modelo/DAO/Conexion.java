/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import java.sql.Connection; //libreria para hacer la variable conexion
import java.sql.DriverManager; //libreria para conectarse
import java.sql.SQLException; //libreria para errores de tipo sql
import java.sql.Statement; //libreria para ejecutar query

/**
 *
 * @author Angelo
 * version = 1
 * 
 */
public class Conexion {
    
    //importar libreria ojdbc7 al proyecto
    
    private String cadena;  //cadena de conexion
    private String usuario; //usuario de la base de datos
    private String pass; //contraseña de la base de datos
    private Connection conexion; //variable para conectar a la bd
    private Statement instru; //variable para ejecutar instrucciones
    
    
    public Conexion() throws Exception //metodo constructor
    {
        this.cadena = "jdbc:oracle:thin:@localhost:1521:XE"; //la cadena obtenida previamente
        this.usuario = "SGP"; //nombre de la base de datos
        this.pass = "sgp"; //contraseña base de datos
        conectar(); // llamamos al metodo conectar()
    }
    
    public Connection getConexion() //para obtener la conexion
    {
        return conexion; //retorna la conexion
    }
    
    public void setConexion(Connection conexion) //metodo para modificar la conexion
    {
        this.conexion = conexion; //modifica la variable conexion
    }
    
    public void conectar() throws Exception //metodo para conectarse a la base de datos
    {
        try //etiqueta de la exception
        {
            Class.forName("oracle.jdbc.OracleDriver");  //conectarse a la base de datos
            setConexion(DriverManager.getConnection(cadena,usuario,pass)); //ingresar variable conexion
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage()); //gatilla error en caso de
        }
    }
    
    public Statement crearInstruccion() throws Exception //ejecuta las instrucciones sql
    {
        try
        {
            
            instru = getConexion().createStatement(); //creamos las instrucciones
            
        }catch(SQLException ex)
        {
            throw new Exception(ex.getMessage()); //mensaje del error
        }
        
        return instru; //retorna las instrucciones
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

/**
 *
 * @author Angelo
 */
public class Tipo {
    
    private int id_tipo;
    private String tipo;
    private int dias;
    private String descripcion;
    private int estado_tipo;
    private String resultado;
    
    //CONSTRUCTOR SIN PARAMETROS
    public Tipo()
    {
        
    }
    
    //CONSTRUCTOR CON PARAMETROS
    public Tipo( String tipo , int dias , String descripcion , int estado_tipo)
    {
        this.tipo = tipo;
        this.dias = dias;
        this.descripcion = descripcion;
        this.estado_tipo = estado_tipo;
    }
    
    //METODOS SETTERS
    public void setResultado(String resultado)
    {
        this.resultado = resultado;
    }
    
    public void set_id_tipo(int id_tipo)
    {
        this.id_tipo = id_tipo;
    }
    
    public void set_tipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    public void set_dias(int dias)
    {
        this.dias = dias;
    }
    
    public void set_descripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    
    public void set_estado_tipo(int estado_tipo)
    {
        this.estado_tipo = estado_tipo;
    }
    
    //GETTERS
    public String get_resultado()
    {
        return this.resultado;
    }
    
    public String get_descripcion()
    {
        return this.descripcion;
    }
    
    public int get_dias()
    {
        return this.dias;
    }
    
    public int get_estado_tipo()
    {
        return this.estado_tipo;
    }
    
    public int get_id_tipo()
    {
        return this.id_tipo;
    }
    
    public String get_tipo()
    {
        return this.tipo;
    }
}
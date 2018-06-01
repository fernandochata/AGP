/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.sql.Date;

/**
 *
 * @author Angelo
 */
public class Feriado {
 
    private int idFeriado;
    private Date feriado;
    private String descripcion;
    private String resultado;
            
    public Feriado()
    {
        
    }

    public Feriado(int idFeriado, Date feriado, String descripcion) {
        this.idFeriado = idFeriado;
        this.feriado = feriado;
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
    
    public int getIdFeriado() {
        return idFeriado;
    }

    public void setIdFeriado(int idFeriado) {
        this.idFeriado = idFeriado;
    }

    public Date getFeriado() {
        return feriado;
    }

    public void setFeriado(Date feriado) {
        this.feriado = feriado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
            
}

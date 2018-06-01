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
public class Departamento {
    
    private int id_departamento = 0;
    private String departamento;
    private String descripcion;
    private String resultado="";
    
    public Departamento()
    {
        
    }

    public Departamento(int id_departamento, String departamento, String descripcion, String resultado) {
        this.id_departamento = id_departamento;
        this.departamento = departamento ;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
    
}

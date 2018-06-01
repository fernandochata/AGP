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
 * version : 1
 */
public class Usuario { //CREAMOS LAS CLASES
    
    private int rut; //DEFINO VARIABLES
    private String codigo_verificado;
    private String clave;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;
    private String comuna;
    private int telefono;
    private String email;
    private int dias_legales;
    private int dias_administrativos;
    private Date fecha_contrado;
    private String perfil;
    private String cargo;
    private String departamento;
    private int id_perfil;
    private int id_cargo;
    private int id_departamento;
    private String resultado;
   
    public Usuario() //METODO SIN PARAMETROS
    {
        
    }
    
    public Usuario(int rut,String clave,String nombre) //METODO CON PARAMENTROS
    {
       this.clave = clave;
       this.rut = rut;
       this.nombre = nombre;
    }
    
    public int getRut()
    {
        return this.rut;
    }
    
    public void setRut(int rut)
    {
        this.rut = rut;
    }
    
    public String getNombre() //METODO GETTER DE nombre
    {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getCodigo_verificado() {
        return codigo_verificado;
    }

    public void setCodigo_verificado(String codigo_verificado) {
        this.codigo_verificado = codigo_verificado;
    }
    
    public String getClave()
    {
        return this.clave;
    }
    
    public void setClave(String clave)
    {
        this.clave=clave;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDias_legales() {
        return dias_legales;
    }

    public void setDias_legales(int dias_legales) {
        this.dias_legales = dias_legales;
    }

    public int getDias_administrativos() {
        return dias_administrativos;
    }

    public void setDias_administrativos(int dias_administrativos) {
        this.dias_administrativos = dias_administrativos;
    }

    public Date getFecha_contrado() {
        return fecha_contrado;
    }

    public void setFecha_contrado(Date fecha_contrado) {
        this.fecha_contrado = fecha_contrado;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

 

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
    
    
}

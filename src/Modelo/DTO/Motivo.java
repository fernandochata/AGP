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
public class Motivo {
    
    private String motivo;
    private String resultado;
    private int id = 0;
    
    public Motivo()
    {
        
    }

    public Motivo(String motivo, String resultado, int id) {
        this.motivo = motivo;
        this.resultado = resultado;
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}

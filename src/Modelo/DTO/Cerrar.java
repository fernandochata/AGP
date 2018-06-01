/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelo
 */
public class Cerrar {
    
    
    
    public void cerrar(){ //METODO CERRAR
        Component rootPane = null; //ATRIBUTO DE TIPO COMPONENT INICIADO
        Object [] opciones ={"Aceptar","Cancelar"}; //OBJETOS, LAS OPCIONES DEL JPANEL
        int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea cerrar la aplicacion","Mensaje de Confirmacion", //MENSAJES DE LA VENTANA Y EL COMPONENTE VENTANA
        JOptionPane.YES_NO_OPTION, //SOLO SE PUEDE SALIR CON UNA OPCION
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar"); //RECOJE LO SELECCIONADO
        if (eleccion == JOptionPane.YES_OPTION) //VALIDA SI ELEJIMOS ACEPTAR
        {
            System.exit(0); //CIERRA TODO EL SISTEMA
        }else{
            
        }
    }
}

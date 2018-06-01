/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.joda.time.LocalDate;
import org.joda.time.Years;



/**
 *
 * @author Angelo
 */
public class restarFecha  {
    public static void main(String[]args)
    {
        try
        {
            LocalDate fecha_contrado = new LocalDate(2011,1,30);
            LocalDate now = new LocalDate();
            Years años = Years.yearsBetween(fecha_contrado,now);
            System.out.println(años);
            
        }catch(Exception e)
        {
            
        }
    }
}

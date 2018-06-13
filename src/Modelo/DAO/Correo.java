/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Angelo
 */
public class Correo {
 
    private static String dt = "tanufuki@gmail.com",
            usuarioMail = "tanufuki@gmail.com" ,
            mensajeMail = "Que pasooo";
    
    public static boolean sendMessage(String mensaje , String subject , String correo)
    {
        boolean rpta = false;
        dt = "tanufuki@gmail.com";
        
        Properties props = new Properties();
        //Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host","smtp.gmail.com");
        //TLS Si esta disponible
        props.setProperty("mail.smtp.starttls.enable", "true");
        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port", "587");
        // Cuenta de correo en gmail
        props.setProperty("mail.smtp.user", dt);
        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        //Verficiar el envio
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try {
        message.setSubject(subject);
        message.setText(mensaje);
        Address address;
        try {
        address = new InternetAddress(dt,subject);
        message.setFrom(address);
        } catch (UnsupportedEncodingException ex) {
        //Logger.getLogger(form1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //La direccion de la persona a enviar
        Address address2 = new InternetAddress(correo,false);
        message.addRecipient(Message.RecipientType.TO,address2);
        Transport t = session.getTransport("smtp");
        t.connect(dt,"angelo25.");
        t.sendMessage(message,message.getAllRecipients());
        t.close();
        rpta=true;
        } catch (MessagingException ex) {
        return rpta;
        }
        return rpta;
        
    }
    
    public static void main(String[]args) throws Exception
    {
        Correo c = new Correo();
        c.sendMessage("Hola","hola","tanufuki@gmail.com");
        //System.out.println(operation(2, 2));
        System.out.println("**************************");
        System.out.println(antiguedad("2000-06-30"));
        

    }

    /*private static Integer operation(int numero1, int numero2) {
        paqueteServicio.Antiguedad_Service service = new paqueteServicio.Antiguedad_Service();
        paqueteServicio.Antiguedad port = service.getAntiguedadPort();
        return port.operation(numero1, numero2);
    }¨*/

    private static Integer antiguedad(java.lang.String fechaContrato) {
        paqueteServicio.Antiguedad_Service service = new paqueteServicio.Antiguedad_Service();
        paqueteServicio.Antiguedad port = service.getAntiguedadPort();
        return port.antiguedad(fechaContrato);
    }

   
                    
}

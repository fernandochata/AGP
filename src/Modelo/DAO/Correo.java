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
 
    private static String remitente;
    private static String clave;
    
    public static void enviarConGmail(String destinatario, String asunto, String cuerpo, String clave)
    {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        remitente = "sistemagestionpermisos@gmail.com"; // Esto es mi correo, puede que funcione al quitar el 'gmail.com'
        clave = "sgpadmin";
        
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "sgpadmin");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            //message.setText(cuerpo);
            message.setContent(cuerpo, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
    
    /*
    public static void main(String[] args) {
        Correo c = new Correo();
        String destinatario =  "tanufuki@gmail.com"; //A quien le quieres escribir.
        String asunto = "Su usuario para acceder a SGP";
        String cuerpo = "Esta es una prueba de correo... desde la aplicacion de escritorio";
        String clave = "1234";
        enviarConGmail(destinatario, asunto, cuerpo,clave);
    } 
    */
}

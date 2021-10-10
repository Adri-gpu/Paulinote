package src.main;

/**
 *
 * @author louis
 */    
    

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static src.main.Main.PathApp;
public class SendMail {
    
    
    public SendMail(String cas, int id_reu) throws IOException {
        Bdd bdd = new Bdd();
        
        System.out.println(id_reu);
        
        ArrayList<Utilisateur> infos_uti = new ArrayList<Utilisateur>();
        
        infos_uti = bdd.getIdentUser();
        
        String from = infos_uti.get(0).getMail();
        
        String password = infos_uti.get(0).getMdp();
        
        System.out.println(password);
        
        System.out.println(from);
        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
        String host = "smtp.office365.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            

            ArrayList<String> liste_pers = bdd.liste_adr_mail(id_reu);
            
            InternetAddress[] address = new InternetAddress[liste_pers.size()];
            
            if(liste_pers.size()==1){
                address[0] = new InternetAddress(liste_pers.get(0));
                message.addRecipient(Message.RecipientType.TO, address[0]);
            }
            else if(liste_pers.size()>1){
                 for(int i =0; i< liste_pers.size(); i++)
                {
                    address[i] = new InternetAddress(liste_pers.get(i));
                }
                
                for( int i = 0; i < address.length; i++) {
                    message.addRecipient(Message.RecipientType.TO, address[i]);
                }
            }
            
            ArrayList<Reunions> infos_reu = bdd.getOneReu(id_reu);
            BodyPart messageBodyPart = new MimeBodyPart(); 
            MimeBodyPart attachmentPart = new MimeBodyPart();
            
            if(cas.equals("Compte-rendu")){
                message.setSubject("Compte-rendu de la réunion du " + infos_reu.get(0).getDate());
                messageBodyPart.setText("Bonjour, veuillez trouver ci-joint le compte-rendu  pour la réunion du " + infos_reu.get(0).getDate() + "à " + infos_reu.get(0).getHeure());
                String attachFile = PathApp+"\\Pdf\\CompteRendu_" + infos_reu.get(0).getNom() + ".pdf";
                attachmentPart.attachFile(attachFile);
            }
            else if(cas.equals("Ordre-du-jour")){
                 message.setSubject("Réunion du " + infos_reu.get(0).getDate());
                 messageBodyPart.setText("Bonjour, veuillez trouver ci-joint la convocation pour la réunion du " + infos_reu.get(0).getDate() + "à " + infos_reu.get(0).getHeure());
                 
                String attachFile = PathApp+"\\Pdf\\Convocation_" + infos_reu.get(0).getNom() + ".pdf";
                attachmentPart.attachFile(attachFile);
            }
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            
            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

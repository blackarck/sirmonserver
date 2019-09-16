/*
 * send email using this class will 
 * be used for sending notificaiton
 */
package serversirmon;
 
 
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

 

public class jmailUtil {
        
    Properties p1 = new Properties();
    String accmail="";
    String accpwd="";
   
    jmailUtil(){
        p1.put("mail.smtp.auth","true");
        p1.put("mail.smtp.starttls.enable","true");
        p1.put("mail.smtp.host","smtp.gmail.com");
        p1.put("mail.smtp.port","587");
        
        accmail ="sirmondatawriter@gmail.com";
        accpwd  ="Copper@00";      
        
       // System.out.println("Constructor done");
    }
    
    
    public void  sendMail(String recp,String mailcont) {
          
        try{
             
        Session session  = Session.getInstance(p1,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(accmail,accpwd);
            }
        });
        Message message = prepareMessage(session,accmail,recp,mailcont);
        
        Transport.send(message);
        System.out.println("Email to " + recp + " sent out.");
        }catch(Exception e){
             System.out.println("Error prepmessage-" + e);
        }
    }
    
    private static Message prepareMessage(Session session, String accmail1, String recp, String mailcont){
         Message message= new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(accmail1));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recp ));
            message.setSubject("Server not reachable");
            message.setText("Server might not be reachable plz look into same " + mailcont);
        } catch (Exception ex) {
             System.out.println("Error prepmessage-" + ex);
        }
            return message;
    }
   
}

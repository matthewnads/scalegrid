import play.*;
import play.jobs.*;
import play.test.*;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.time.DateUtils;

import controllers.Secure;
import controllers.Security;
import models.*;
import play.mvc.*;

@OnApplicationStart
@Every("1hr")
public class Bootstrap extends Job {
 
    public void doJob() {
        // Check if the database is empty
    	
        if(User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
        
        //This was the code I used to try and send email reminders, but I was not able to finish debugging before the deadline. uncommenting breaks the site at the moment.
//        
//        User user = User.find("byEmail", Security.connected()).first();
//    	
//        //sending reminders 
//        String email = user.email; 
//        String from = "snadar5@uwo.ca"; 
//        String host = "localhost";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.setProperty("mail.smtp.host", host);
//        properties.setProperty("mail.smtp.port", "8080");
//        Session session = Session.getDefaultInstance(properties);
//        List<Contact> contacts = Contact.find("owner",user).fetch();
//        int hours = user.reminder; 
//        for(Contact contact : contacts) {
//        	Date birthday = contact.birthday; 
//        	Date newDate = DateUtils.addHours(new java.util.Date(), hours);
//        	if(newDate.after(birthday)) {
//        		 try {
//        	         // Create a default MimeMessage object.
//        	         MimeMessage message = new MimeMessage(session);
//
//        	         // Set From: header field of the header.
//        	         message.setFrom(new InternetAddress(from));
//
//        	         // Set To: header field of the header.
//        	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//
//        	         // Set Subject: header field
//        	         message.setSubject("Upcoming Birthday!");
//
//        	         // Now set the actual message
//        	         message.setText(contact.name+"'s birthday is coming up soon! On "+contact.birthday.toString());
//
//        	         // Send message
//        	         Transport.send(message);
//        	         System.out.println("Sent message successfully....");
//        	      } catch (MessagingException mex) {
//        	         mex.printStackTrace();
//        	      }
//        	}
//        }
    }
 
}
import play.jobs.*; 
import models.*;

import java.util.Calendar;
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
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import play.libs.Mail; 
import controllers.*;

//can change the param here for testing purposes
@Every("1h")
public class EmailJob extends Job {
	
	public void doJob() {
		  //This job is used to send email reminders
//     
		
		//setting up host and login info for gmail 
      String from = "dondatester@gmail.com"; 
      String host = "smtp.googlemail.com";
      String pass = "Secret1020";

 

      //get list of contacts from database 
      List<Contact> contacts = Contact.all().fetch();
   
      
      for(Contact contact : contacts) {
    	  
    	  //essentially just comparing the days and month of the birthday to today and to the "new" date (current date + reminder hours set by user)
    	int hours = contact.owner.reminder; 
      	Date birthday = contact.birthday; 
      	Calendar cal = Calendar.getInstance();
      	cal.setTime(birthday);
      	int month = cal.get(Calendar.MONTH); 
      	int day = cal.get(Calendar.DAY_OF_MONTH);
      	
      	Date curr = new java.util.Date(); 
      	Calendar currCal = Calendar.getInstance();
      	currCal.setTime(curr);
      	int currMonth = currCal.get(Calendar.MONTH); 
      	int currDay = currCal.get(Calendar.DAY_OF_MONTH);
      	
      	Date newDate = DateUtils.addHours(new java.util.Date(), hours);
    	Calendar newCal = Calendar.getInstance();
      	newCal.setTime(newDate);
      	int newMonth = newCal.get(Calendar.MONTH); 
      	int newDay = newCal.get(Calendar.DAY_OF_MONTH);
      	if(newMonth>=month && newDay >= day && month<=currMonth && day<=currDay && !contact.reminder) {
      		 try {
      			 	contact.reminder = true; //i use this boolean to make sure the user doesn't get multiple emails. 
//      			There should be another job that resets this each year, but i left it out since it seemed trivial for our usage 
      			 	contact.save(); //updating the db 
      			 	
      			 	//creating and sending email 
      			 	SimpleEmail email = new SimpleEmail(); 
      			 	email.setHostName(host);
      			 	email.setSmtpPort(587);
      			 	email.setAuthenticator(new DefaultAuthenticator(from, pass));
      			 	email.setSSL(true);
      			 	email.setFrom(from); 
      			 	email.addTo(contact.owner.email); 
      			 	email.setSubject("Upcoming Birthday!");
      			 	email.setMsg(contact.name+"'s birthday is coming up in "+hours+" hours!"); 
      			 	email.send();
     
      	         System.out.println("Sent message successfully....");
      	      } catch (Exception mex) {
      	         mex.printStackTrace();
      	      }
      	}
      }
	}
}

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
public class Bootstrap extends Job {
 
    public void doJob() {
        // Check if the database is empty
    	
        if(User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
        
      
    }
 
}
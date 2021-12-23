package controllers;
 
import play.*;
import play.mvc.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    
	//This function allows us to greet the current user 
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.fullname);
        }
    }
 
    //Using this to render a list of the contacts for a user 
    public static void index() {
    	String user = Security.connected();
        List<Contact> contacts = Contact.find("owner.email", user).fetch();
        render(contacts);
    }
    
    public static void form() {
        render();
    }
     
    //Saving the contact here (info recieved from form.html)
    public static void save(String name, String birthday) throws ParseException {
        // Create post
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  

    	Date converted = formatter.parse(birthday); 
        User owner = User.find("byEmail", Security.connected()).first();
        Contact contact = new Contact(owner, name, converted);
       
        
        // Validate
        validation.valid(contact);
        if(validation.hasErrors()) {
            render("@form", contact);
        }
        // Save
        contact.save();
        index();
    }
    
}
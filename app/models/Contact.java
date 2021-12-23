package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import play.db.jpa.*;
//Contact model which holds the contacts for a user (1:M relationship) 
@Entity
public class Contact extends Model {
	
	@Required 
	public String name; 
	
	@Required
	public Date birthday; 
	
	@Required
	@ManyToOne 
	public User owner; 
	
	public boolean reminder; 
	
	public Contact(User owner, String name, Date birthday) {
		this.owner = owner; 
		this.name = name; 
		this.birthday = birthday; 
		this.reminder = false; 
	}
	
	public String toString() {
	    return name;
	}
}

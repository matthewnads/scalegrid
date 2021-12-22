package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import play.db.jpa.*;

@Entity
public class Contact extends Model {
	
	@Required 
	public String name; 
	
	@Required
	public Date birthday; 
	
	@Required
	@ManyToOne 
	public User owner; 
	
	public Contact(User owner, String name, Date birthday) {
		this.owner = owner; 
		this.name = name; 
		this.birthday = birthday; 
	}
	
	public String toString() {
	    return name;
	}
}

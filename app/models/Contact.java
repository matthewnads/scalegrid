package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Contact extends Model {
	public String name; 
	public Date birthday; 
	
	@ManyToOne 
	public User owner; 
	
	public Contact(User owner, String name, Date birthday) {
		this.owner = owner; 
		this.name = name; 
		this.birthday = birthday; 
	}
}

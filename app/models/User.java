package models;
import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class User extends Model {
	
	@Email
	@Required 
	public String email;
	
	@Required
    public String password;
    public String fullname;
    
    @Required 
    public int reminder; 
    
    public User(String email, String password, String fullname, int reminder) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.reminder = reminder; 
    }
    
    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }
    
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    public List<Contact> contacts;
    
    public String toString() {
        return email;
    }
}

import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;
import controllers.*; 

public class BasicTest extends UnitTest {
	
	@Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new User("bob@gmail.com", "secret", "Bob", 3).save();
        
        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find("byEmail", "bob@gmail.com").first();
        
        // Test 
        assertNotNull(bob);
        assertEquals("Bob", bob.fullname);
    }
    
    @Test
    public void tryConnectAsUser() {
        // Create a new user and save it
        new User("bob@gmail.com", "secret", "Bob", 3).save();
        
        // Test 
        assertNotNull(User.connect("bob@gmail.com", "secret"));
        assertNull(User.connect("bob@gmail.com", "badpassword"));
        assertNull(User.connect("tom@gmail.com", "secret"));
    }
    
    @Test
    public void createPost() {
        // Create a new user and save it
        User bob = new User("bob@gmail.com", "secret", "Bob", 3).save();
        
        // Create a new post
        new Contact(bob, "sam", new Date()).save();
        
        // Test that the post has been created
        assertEquals(1, Contact.count());
        
        // Retrieve all posts created by Bob
        List<Contact> bobPosts = Contact.find("byOwner", bob).fetch();
        
        // Tests
        assertEquals(1, bobPosts.size());
        Contact firstPost = bobPosts.get(0);
        assertNotNull(firstPost);
        assertEquals(bob, firstPost.owner);
        assertNotNull(firstPost.birthday);
    }

}

package controllers;

import models.*;

//Security class which overwrites some methods in the Secure library so it works for our usecase
public class Security extends Secure.Security{
	 static boolean authenticate(String username, String password) {
		 return User.connect(username, password) != null;
	    }
	 
	 static void onDisconnected() {
		    Application.index();
		}
	 
	 static void onAuthenticated() {
		    Admin.index();
		}
	 static boolean check(String profile) {
		 //not the best way to do it...making all users admin to make sure they have all permissions.
		 //This allowed me to differentiate between logged in users and not logged in users
		 return true;
		}
}

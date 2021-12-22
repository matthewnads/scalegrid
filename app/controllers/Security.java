package controllers;

import models.*;

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
		 //not the best way to do it...making all users admin to make sure they have all permissions   
		 return true;
		}
}

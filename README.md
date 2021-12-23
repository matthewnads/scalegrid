# ScaleGrid.io Take-Home Assignment

## Authored by Matthew Nadarajah Dec 22/2022

## Contact @ snadar5@uwo.ca

This submission uses Java 1.6 and Play 1.2.4. (There were some compatibility issues with 1.7)
I ran the submission in Eclipse, but running using ```play run ./scalegrid``` from project parent folder works as well. 
If running from Eclipse, please run the command ```play eclipsify ./scalegrid/``` from the project parent folder and then import the project into Eclipse. 
Then ```> /eclipse/scalegrid.launch > Run As > scalegrid```

To use: 
1. Navigate to localhost:9000 in your browser 
2. Click "Add a user" and fill out the form and hit "Save".
3. Navigate back to localhost:9000 and click "Log in". Log in with the credentials created in the previous step. 
4. Add a contact by clicking "add new contact" and filling out the form. 
Note: if you are getting Null exceptions when trying to login or add a user, click "logout" which will clear the previous credentials


### Highlights:

#### app/models Package 

This package contains the different models used in the H2 in memory database (Contact and User)

#### app/Bootstrap.java  

Contains initial scripts that run to initialize database with dummy data for testing (from conf/initial-data.yml)

#### app/EmailJob.java

This class runs a scheduled job using the @Every annotation to periodically check the contact lists for upcoming birthdays, and sends reminder emails if the birthday is within the reminder window.
This job is scheduled to run each hour, but can be changed to a shorter time interval for testing purposes (eg. change to @Every("1mn") for every minute). 

#### controllers Package

Contains all the controllers for the models and also Admin class, which allowed me to have fine control over what the user sees before/after logging in 

#### views
Contains all the different html files used to populate different views based on user inputs  

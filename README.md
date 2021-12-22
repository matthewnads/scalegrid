# ScaleGrid.io Take-Home Assignment

## Authored by Matthew Nadarajah Dec 22/2022

## Contact @ snadar5@uwo.ca

This submission uses Java 1.6 and Play 1.2.4. (There were some compatibility issues with 1.7)
I ran the submission in Eclipse, but running using ```play run ./scalegrid``` from project parent folder works as well. 
If running from Eclipse, please run the command ```play eclipsify ./scalegrid/``` and then import the project into Eclipse. 

Then ```> /eclipse/scalegrid.launch > Run As > scalegrid```

Then go to ```http://localhost:9000/``` > click "Add a user" and follow on screen instructions. 

### Highlights:

#### app/models Package 

This package contains the different models used in the H2 in memory database (Contact and User)

#### app/Bootstrap.java  

Contains initial scripts that run to initialize database with dummy data for testing (from conf/initial-data.yml), and (a buggy) email reminder function 

#### controllers Package

Contains all the controllers for the models and also Admin class, which allowed me to have fine control over what the user sees before/after logging in 

#### views
Contains all the different html files used to populate different views based on user inputs  

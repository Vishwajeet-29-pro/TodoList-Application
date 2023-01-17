# Simple To Do List Web App using Spring Boot and MySQL.
___
This is simple Todo List application using Spring Boot with use following Technologies: 

    * Thymeleaf For Creating Graphical User Interface with use of BootStrap CSS.
    * MySQL for Database to Store the To Do items.
    
 ---
 Requirement for This project:
 
    * MySQL For Database
    * Any IDE (Eclipse prefered) 
    * Any Web Browser 
    
 Setup in the MySQL:
  
  1) Create new user (if you want) with Global Access.
  2) Create Database in MySQL which will then connect to project.
      Database name should be same as `datasource` url from the application.properties file.
  3) Update the application.properties file from `src/main/resources` folder add your username, password and the Datasource url. 
 
  Download the Repository and unzip it. 
  From Eclipse import -> import existing maven project -> select project from location.
  With internet connection it download all the required dependencies.
  
  Run Main App after successfully connecting to the database.
  Open Browser and enter the URL: `http://localhost:8080/list/getall` 
  
  
  

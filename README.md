# CRUD

Example CRUD application using Spring boot, hibernate, jquery, bootstrap.

### To run in Intellij:
0. Start postgres database and use src/main/resources/schema1.sql to create database. 
1. Open project in Intellij
2. Run main method from src/main/java/org/blah/Application.java (this starts build in server and application)
3. Open src/static/index.html in any web browser.

### To run with maven:

1. Build project with maven - from project home directory execute command mvn clean package to build project. It will
   create jar file in catalog <base project catalog>/target
2. Run jar file with the command java -jar <path to jar file>
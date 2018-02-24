# Week #2: Course Materials

The objective of week #2 is to get the cli working with showing employee details - name, department, leave_available etc. From this week onwards, we will be doing sprint planning and sprint review/retrospective every week.

## Java (Will be continued in Week#3 as well)

## Junit (Will be continued in Week#3 as well)

## Maven

## JDBI

# Week #2: Workshop Day #1 - Create the development database, table and populate it
  * Create JIRAs for all the work to be done in Week #2 
    * Create a JIRA for changing the database design
       * A "Task" type ticket w/ 
          * Summary: "Create a database design for the leave management application", and 
          * Description: " As per the requirements in https://github.com/HexaInnovLab/ftp-fork-me/blob/master/REQUIREMENTS.md"
          * Note down the ticket number
       * A "Task" type ticket w/ 
          * Summary: "Change the model/Employee java class for the columns identified", and 
          * Description: " As per the requirements in https://github.com/HexaInnovLab/ftp-fork-me/blob/master/REQUIREMENTS.md"
          * Linked Issues: "Is Blocked By"
          * Issue: the ticket number for the database design ticket
       * A "Task" type ticket w/ 
          * Summary: "Change the persistence/Employee DAO/mapper java classes for the new attributes", and 
          * Linked Issues: "Is Blocked By"
          * Issue: the ticket number for the Employee model change ticket
       * A "Task" type ticket w/ 
          * Summary: "Change the Util.CliMain java class for the new attributes", and 
          * Linked Issues: "Is Blocked By"
          * Issue: the ticket number for the Employee model change ticket          
  * Start the sprint after pulling all the tickets to the sprint backlog
  * Database Design
     * Edit Database.ddl for two tables: EMPLOYEE and LEAVE_DETAILS
        * Use the "STANDARDS_AND_GUIDELINES.md" file for the naming conventions to be followed.
     * Edit Database.dml to insert data into the EMPLOYEE table; The LEAVE_DETAILS table can be blank to start with.
     * Run the ddls and dmls against your local mysql server
     * Push the changes to remote branch
     * Now, the other team members can pull from branch and run the ddl/dml against their local databases
     * Follow the process for completing the review. and merging & cleanup
  * Re-run the Cli, the Curl and the Browser UI to see the changed data in all three interfaces

# Week #2: Workshop Day #2-5

  * Complete the other tickets
  * At the end, the cli should show all the new attributes added.
    * At this point, you must be able to compile ```mvn compile``` and run the cli ```mvn exec ...```, but other command i.e., ```mvn package``` etc will fail because of lack of code coverage etc.
  * You should have added some unit tests as well.
     
# Reading material

## Must-Read

### Java
  * https://docs.oracle.com/javase/tutorial/getStarted/index.html
  * https://docs.oracle.com/javase/tutorial/java/index.html
   
### JDBI
  * http://jdbi.org/#_declarative_api
  * http://jdbi.org/#_sql_objects
  
### Junit/Jmockit
  * https://github.com/junit-team/junit4/wiki/Getting-started
  * https://github.com/junit-team/junit4/wiki/Assertions
  * http://jmockit.org/
  * http://jmockit.org/gettingStarted.html
  
### Maven
  * https://javapapers.com/jee/maven-in-10-minutes/

## Nice-To-Read

### Java
  * https://docs.oracle.com/javase/tutorial/essential/index.html
  * https://docs.oracle.com/javase/tutorial/collections/index.html
  
### Junit/Jmockit
  * http://jmockit.org/tutorial/Mocking.html
  * http://jmockit.org/tutorial/Faking.html
  
## Go-Deep

### Java
  * https://www.udemy.com/java-tutorial/
  * https://www.javatpoint.com/java-tutorial

  

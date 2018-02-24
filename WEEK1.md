# Classroom material

## Structure of the program
  * Team
  * Product E2E
  * Agile/DevOps
  * Full stack
  * Cloud (little bit)

## Goals of the program
  * "Learning to learn"
    * Git, Jira, Jenkins, MySQL, SQL, JDBI, Java, Junit, Jmockit, Jersey, Maven, REST, Json, RestAssured, Javascript, HTML, CSS, Angular 4, Karma/Jasmine, Selenium
  * Productivity hacks
    * google
    * command line (+ simple IDE)
    * cheat sheets
    * bookmarks
    * check lists
    * REPL
    * tutorials
    * ...
  * Communication, teamwork, ...

## Multi-tier systems
  * Presentation, Business Logic, Persistence
    * Web, Mobile, Cli, Thick Client, ...
      * Web
        * Hybrid MVC vs Browser-side MVC
      * Mobile
        * Native vs Cross-Platform
    * Containers, REST API, EJB, ...
    * File system, RDBMS, NoSQL, BigData, DW, ...

 ## Software Development
   * Tools : source code control, ticket, IDE, build, test, execute
   * Iteration:
     * Assign to yourself
     * Checkout
     * branch
     * change
     * test
     * deploy/test
     * checkin
     * review
     * pipeline
     * close
     * delete branch   

## Unix command line basics
  * pwd
  * ls
  * cd
  * mkdir
  * Curl
  
## Source code control systems

## Git
  * workspace, staging, local, remote

## Editors, Build systems vs IDE

## Databases: concepts

## Databases: SQL/DML

## Agile basics
  * Sprint, Kanban
  * Product Backlog, Sprint Backlog
    * Epics, User Stories, Tasks, Bug
    * To Do, In Progress, Resolved, Accepted
  * Sprint Rituals
    * Planning
    * Standup
    * Review
    * Retrospective
  
# Workshop material - Day #1 - Git/VS Code
  * Setting up git
    * Open "https://github.com/HexaInnovLab" in your browser; bookmark this page in your browser
    * Click the signup on the top-right
    * In the following instructions, {hexawareid} is the part preceding @hexaware.com in your email address
    * your username is {hexawareid}-Hexaware, e.g., krishnakumar-Hexaware
    * Use hexaware email address as the email address
    * Select your own password
    * Tell the facilitator the username just created
    * You will get mail to verify your mail address; click the link to complete the verification
    * The facilitator will add you to the hexaware github organization and also give you access to the team's repository
    * You will get a mail inviting you to the HexaInnovLab organization. Please join the organization.
    * Open https://github.com/HexaInnovLab/ftp12, and look at the WEEK1.md
    * Follow the instructions as in https://help.github.com/articles/connecting-to-github-with-ssh/
      * Skip "Checking for existing SSH keys" as this is a fresh installation
      * Run the ssh-keygen command and save the private key in C:\users\Hvuser\.ssh\id_rsa. *Do not* use a passphrase in step #4 - just press enter twice.
      * Skip "Adding your SSH key to the ssh-agent" section as we do not use ssh-agent
      * Follow the instructions as in "https://help.github.com/articles/adding-a-new-ssh-key-to-your-github-account/" and "https://help.github.com/articles/testing-your-ssh-connection/" and test the setup

  * Command Line/Gitbash --  Open Gitbash
    
    * `pwd` -- Check and verify that the current working directory is C:\users\Hvuser
    * `cd workspace` -- change current working to workspace
    * `pwd` -- Check and verify that the current working directory is C:\users\Hvuser/workspace
        
  * Git (setup/checkout/clone/pull/push)
    * `git --version` // should be atleast 2.14+
    * `git config --global -l` // should throw an error
    * `git config --global user.name "<your name>"`
    * `git config --global user.email <your email>`
    * `git config --global -l`
    * Open https://github.com/HexaInnovLab/ftp12
      * look at source code organization
    * Go back to gitbash and clone the project
    * `pwd` -- Check and verify that the current working directory is C:\users\Hvuser/workspace
    * `git clone git@github.com:HexaInnovLab/ftp12.git`
    * `cd ftp12`
    * `git status`
  * open Visual Studio Code
    * Open folder c:\users\Hvuser\workspace\ftp12
    * Browse the directories to understand the repository structure

# Workshop material - Day #2 - MySQL Workbench/Cli/Curl/Browser to interact w/ application

  * Open MySQL Workbench
  * Open the localhost connection
    * Mac OS: `export PATH=$PATH:/Applications/MySQLWorkbench.app/Contents/MacOS` and then you can use the command line `mysql -u root -phexawareftpdev`
  * `CREATE DATABASE FTP12;` and click the lightning button
  * `CREATE USER 'FTP12'@'localhost' IDENTIFIED BY 'FTP12';`
  * `GRANT ALL ON FTP12.* TO 'FTP12'@'localhost';`
  * Open database/database.ddl in VS code
  * Copy the entire contents to MySQL Workbench
  * Execute the ddl 
  * Click the table icon against the EMPLOYEE table in the right-hand side schemas section
  * Open database/database.dml in VS code
  * Copy the contents to MySQL Workbench
  * Execute the dml 
  * Click the table icon against the EMPLOYEE table in the right-hand side schemas section. You should see the data just inserted.
  * Play around with
    * SELECT with predicates
    * UPDATE statements with predicates
    * DELETE statements with predicates
    * At the end of all the playing around, leave the database with 5 records with ids (1000, 2001
    
  * Next, we will build and run the java code
  * go to gitbash, ensure you are in workspace/ftp12
  * `cd restservice/leavemanager`
  * `mvn compile`
  * `mvn exec:java -Dexec.mainClass=com.hexaware.ftp12.util.CliMain`
    * As expected, the cli displays only the employee id for the employee; we need to do some code changes before the other attributes such as name will start appearing in the cli. But before that we will test the application as a REST service.
    * Due to a bug in the database connection code, after exiting, there will be an error with a stack trace. Ignore this error.
  * Build the war file as follows:
    * `mvn package` -- This build a war (java web archive with the code for the REST service)
    * `cp target/ftp12-0.0.1-SNAPSHOT.war /D/FTP/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16/webapps/ftp12.war`
    * start tomcat and tail its logs
      * `cd D/FTP/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16`
      * `rm -rf logs/*`
      * `./bin/startup.sh`
      * `tail -f logs/*`
      * `curl -vvv http://localhost:8080/ftp12/api/employees | python -m json.tool`
      * `curl -vvv http://localhost:8080/ftp12/api/employees/2000 | python -m json.tool`
   * `cd ../../webui/lm-app/`
   * `npm install`
   * `ng build`
   * `cp ../../restservice/leavemanager/target/ftp12-0.0.1-SNAPSHOT.war ./ftp12.war`
   * `cd dist`
   * `jar -uvf ../ftp12.war *`
   * `cd ..`
   * `jar -tvf ftp12.war`
   * `cp ftp12.war /D/FTP/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16/webapps/ftp12.war`
   * Notice that the tail terminal shows that the new version of the web application archive is now getting deployed
   * Open Chrome browser and navigate to http://localhost:8080/ftp12/
   * You should be able to see the employee ids as you have entered them in the local mysql database

# Workshop material - Day #3 - Git workflow

In this workshop, we will get familiar with

  * The git development cycle - see CHEATSHEET.md, git/development cycle
  * Branching, Reviewing, Merging
  * Resolving conflicts
  
We will learn to this by playing tic-tac-toe within each group. Play as many rounds as needed to get the hang of how we use git for branching and merging, by letting different members play different roles in each round.

In this, let's use TTT-99 for the Jira Ticket number which is needed for branch naming.

## Playing without conflicts

Split the group into two teams of two each and one reviewer, say team-X and team-O. Choose who goes first, perhaps by coin toss.

In this, team-X use one desktop in a shared manner and play 'X's while team-O share another desktop and play 'O's.

The team that goes first follows the git process to checkout and change tictactoe.html to add 'X' or 'O' in a cell. The reviewer
merges the change - after verifying that the game is not over and the team has added only one cell.

Then the second team plays in a similar manner. This continues until the reviewer decides that the game has been won, or is a draw.

The reviewer then cleans up tictactoe.html. One of the others review and merge this change.

Play as many rounds as needed till everyone is comfortable with git operations. The git commands should become 'muscle' memory - the ability to run these commands without referring to the cheatsheet.

## Playing with conflicts

Here, the team members play their turns individually on their desktops; say team-X has two members X1 and X2. Both start their turns simultaneously, by pulling master and checking out branches.

The reviewer will merge one, but the second pull request can not be auto-merged. So the player who goes second needs to resolve the conflict. S/he looks at the change as made by the first player and her own change and chooses the better of the two. If hers is better, this is another pull request for the reviewer to merge.

Play as many rounds as needed till everyone is comfortable with git conflict resolution.

# Workshop material - Day #4 - Setup Jira, use it to run a complete sprint

  * Login to Jira and select your project FTP12.
  * [Team member #1] Create an epic, with name: "Demonstrate team familiarity with git workflow" and Summary: "This epic demonstrates to the course facilitators that each member of the team knows the git workflow, both as a developer and as a reviewer".
  * [Team member #2] Use the "Create issue in epic" link to create the following stories
     * Summary: "Clean up tictactoe.html before the demonstrations"
     * Summary: "Delete tictactoe.html after the demonstrations"
  * [All team members] Use the "Create issue in epic" link to create two stories each
     * Summary: "As a git user, I, [full name], will demo my ability to use git as a developer by making one move on the tictactoe board"
     * Summary: "As a git user, I, [full name], will demo my ability to use git as a review by reviewing and merging another team member's pull request of a tictactoe board change"
     * Open your 'demo' stories and assign them to yourself
  * [Team member #3]
     * Create sprint "FTP12 Sprint 1"
     * Drag all stories into the sprint
     * Start sprint
       * Duration: Custom, with both start date being today and end date being tomorrow
       * Sprint goal: Demo git familiarity
  * [Team member #4]
     * Drag the "Clean up tictactoe.html before the demonstrations" story to "IN PROGRESS" swimlane
     * Assign the user story to yourself using the Assignee field, "Assign to me" link
     * With a facilitator overlooking your work, follow the git development cycle workflow to clean up the tictactoe.html to produce a clean fresh board
       * Self-merge the pull request
     * Drag the story to "DONE"
  * [Team members, one-by-one]      
     * Drag the "develop demo" story to IN PROGRESS
     * With a facilitator overlooking your work, follow the git development cycle workflow to make one move on the tictactoe.html 
       * Use your left neighbour in the team as the reviewer. S/he will drag the "reviewer demo" story to IN PROGRESS to do your review and then move that story to DONE.
     * Drag the story to "DONE" after review/merge done, and local git cleaned up
  * [Team member #5]
     * Drag the "Delete tictactoe.html after the demonstrations" story to "IN PROGRESS" swimlane
     * Assign the user story to yourself using the Assignee field, "Assign to me" link
     * With a facilitator overlooking your work, follow the git development cycle workflow to delete the tictactoe.html file
       * Self-merge the pull request
     * Drag the story to "DONE"
     * Click the "Complete Sprint" button on top right    
     * "Mark as Done" the jira epic
     
# Workshop material - Day #5

   * Exercises
      * Unix Command line
        * Given a file, say employee.csv, containing data in the following format
```
empid,initials,department,leave_available        
1000,KK,CTO_OFFICE,12
2001,MA,HEXAVARSIT,8
1001,IK,CTO_OFFICE,9
2002,UM,HEXAVARSIT,7
1002,SK,CTO_OFFICE,13
2003,VR,HEXAVARSIT,6
2004,JK,HEXAVARSIT,6
```
           * Give an unix command which returns the record with the maximum leave_available
              * In the above case, the output should be
```
1002,SK,CTO_OFFICE,13
```
           * Give an unix command which returns one row per department - department, sum of leave_available of all employees in that department
              * In the above case, the output should be
```
CTO_OFFICE,34
HEXAVARSIT,27
```
        * In our codebase, search and print all lines in java code (files w/ .java suffix), where there is a "FTP" or a "ftp" string
      * Database Queries via SQL
         * Given that the same data as in employee.csv is there in a mysql table EMP, give an SQL query
            * id and the initials of the employee with the maximum leave_available
            * each department and sum of leave_available of all employees in that department            
      * Git Commands
         * Create a T.txt file whose version history looks like this
            * In 'master', there is a version whose contents are "Version 0"
            * In a branch, say TT-Branch off masters' "Version 0" , there is one version where the contents are "Version 1"
            * In the same branch, there is a subsequent version where the contents are "Version 2"
            * In the staging area, there is a version where the contents are "Version 3"
            * In the workspace, there is a version where the contents are "Version 4"
            * In 'master', there is another version - child of "Version 0" - whose contents are "Version 0a"         
         * #1. What is the command to compare the workspace version to the staging version
            * expected output
```
...
-Version 3
+Version 4
```
         * #2. What is the command to compare the staging version to the committed version
            * expected output
```
...
-Version 2
+Version 3
```
         * #3. What is the command to compare the committed version to the branching point
            * expected output
```
...
-Version 0
+Version 2
```
         * #4. What is the command to compare the workspace version to the committed version
         
           * expected output
```
...
-Version 2
+Version 4
```
         * #5. What is the command to compare the workspace version to the branching point
            * expected output
```
...
-Version 0
+Version 4
```
         * #6. What is the command to compare the staging version to the branching point
            * expected output
```
...
-Version 0
+Version 3
```
         * #7. What is the command to compare the workspace version to the latest version in master
            * expected output
```
...
-Version 0a
+Version 4          
```
         
   * Feedback
      * Ideas on what we should start doing
      * Opinions on what we should stop doing
      * Opinions on what we should continue doing
   * Suggestions for improvements
      * classroom material
      * workshop material
   * *MANDATORY*
      * Each trainee to suggest one online material for the Must-Read, Nice-To-Read and Go-Deep for any topics covered in the classroom sessions or workshop sessions     

# Reading material

## Must-Read

### Multi-Tier
  * https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture
  
### Unix commandline
  * http://oliverelliott.org/article/computing/ref_unix/
  
### Agile
  * https://www.mountaingoatsoftware.com/agile/scrum
  * https://www.atlassian.com/agile/developer
  * https://www.atlassian.com/agile/scrum
  * https://www.atlassian.com/agile/ceremonies

### Git
  * https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow (We use this, w/ the rebase variant)
  
### Database
  * https://www.lucidchart.com/pages/database-diagram/database-design
  * https://www.w3schools.com/sql/sql_intro.asp

## Nice-To-Read
  * https://git-scm.com/docs

## Go-Deep
  * https://git-scm.com/book/en/v2

# git

## repository actions

### clone
  * ```git clone git@github.com:HexaInnovLab/ftp12.git```

### reset

### fetch

  * `git fetch` -- update remote branches
  * `git fetch -p` -- update remote branches pruning branches deleted in server

## checkout/branch
   * `git branch` -- list local branches
   * `git branch -a` -- list local and remote branches
   * `git checkout [BranchName]` -- change to BranchName

## stash

   * `git stash list` -- list all stashes
   * `git stash push` -- push local workspace changes to stash
   * `git stash pop` -- pop local workspace changes from stash
   * `git stash drop` -- drop the latest stash

## file actions

  * Checkout a previous version
    * `git checkout <commit> <filename>`
  * Undo changes in staging
    * `git reset HEAD <filename>`
  * Discard changes in workspace
    * `git checkout -- <filename>`

## development cycle

### Clean up before starting

   * `git status` -- you should be on 'master' branch; and it should not show any files changed/staged etc
>       On branch master
>       Your branch is up-to-date with 'origin/master'.
>       nothing to commit, working tree clean
   * `git branch` -- it should not show any local branches
   * `git stash list` -- no stashes should be there
   * `git pull` -- get the latest master
     
### Create a branch

   * `git checkout -b [BranchName]`
      * See STANDARDS_AND_GUIDELINES.md for branch naming guidelines

### EDIT: Edit files as needed

### Periodically, add the file to staging area

   * `git status`
   * `git add -i` and 2/4 options to add changed/new files to staging area
      * Enter the number against the file to add the file to the staging area in the submenu
   * `git status`
   * go to EDIT, if there are more changes

### Commit it to the branch
   
   * `git commit -m [message]`
   * `git status`

### Absorb any changes that has been done to master since we branched

   * `git checkout master`
   * `git pull`
   * `git checkout [BranchName]`
   * `git rebase -i master`
      * If there are any conflicts between your changes and changes done in master, they will appear now. You need to go through the changes one by one, and resolve the conflicts.
      * Typically
         * pick all the changes i.e., `:wq` in the vi editor
         * If there is a conflict
            * For all files in conflict
               * Merge the conflicts highlighted with `<<<` and `>>>` markers
               * 'git add [FileInConflict]`
            * git rebase --continue

### Push it to origin

   * `git status` -- and check if you are on branch and not on 'master'
   * `git push -u origin HEAD`
      * At times, this fails with 'non-fast-forward' message. In that case
         * `git pull` and then try pushing
         * if confident, `git push --force origin HEAD` to force push the changes

### Create a pull request and get it merged

   * In your browser, go to "https://github.com/HexaInnovLab/ftp12"
   * You may see a yellow box with your branch name, and with a button for creating a pull request.
       * If you don't see it, drop down the "Branch" dropdown, select your branch. Then click the "New Pull Request" button next to it.
   * Review your changes in the next screen. Lookout for typos, trailing whitespace etc. and fix them.
   * if there are any changes, go back to EDIT
   * Once happy, click the "Create pull request" button after correcting the description, comment etc.
   * Ask a reviewer to review the pull request.
   * The reviewer will and review your changes
       * If there are any comments needing changes to the files, go back to EDIT
   * The reviewer will merge the pull request and delete the branch

### Clean up
   
   * `git checkout master`
   * `git fetch -p` -- if the reviewer has deleted the branch as s/he should, then you should see that your tracking branch also gets deleted by this command
   * `git pull`
   * `git branch` -- list all branches; the local branch will be there
   * `git branch -d [BranchName]`
   * `git branch` -- list all branches; the local branch will not be there

# maven

## check style
  * ```mvn -Dcheckstyle.consoleOutput=true checkstyle:check```
  * ```mvn checkstyle:checkstyle```
  * ```open target/site/checkstyle.html```

## run cli
  * ```mvn exec:java -Dexec.mainClass=com.hexaware.ftp12.util.CliMain```

## running a single test
  * ```mvn -Dtest=[TestClass#testname] test```

## Package
  * ```mvn package```

# tomcat

## Start/monitor logs

  * ```cd /path/to/apache-tomcat-9.0.0.M22```
  * ```rm -rf logs/*```
  * ```./bin/startup.sh```
  * ```tail -f logs/*```

## Deploy

  * Copy the war file to the webapps folder
    * ```cp target/<some>.war /path/to/apache-tomcat-9.0.0.M22/webapps/ftp12.war```

## Curl
  * `curl http://localhost:8080/ftp12/api/employees`
  * `curl http://localhost:8080/ftp12/api/employees/1000`

# angular

  * To serve from the working directory
    * ng serve --open
  * Build
    * ng build
  * Unit Test
    * ng test
    * npm test
  * Lint/Style check
    * ng lint --type-check
  * Generate new component
    * ng g component components/{name}
  * Generate new service
    * ng g service services/{name}


# Angular/Augury

  * ng is the angular instance
  * ng.probe($0).componentInstance where $0 is the selected component in the Elements tab

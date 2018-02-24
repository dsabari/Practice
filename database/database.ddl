-- change this to your team id
use FTP12;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the table
 CREATE TABLE EMPLOYEE
    (
     EMP_ID INT PRIMARY KEY,
    EMP_NAME VARCHAR(45) NOT NULL,
     EMP_PHONE BIGINT(15) UNIQUE,
     EMP_EMAIL VARCHAR(45) NOT NULL UNIQUE,
     EMP_DEPT VARCHAR(45),
     EMP_MANAGER_ID INT REFERENCES EMPLOYEE(EMP_ID),
     EMP_LEAVE_BALANCE INT,
     EMP_DOJ DATE NOT NULL
    );


 CREATE TABLE LEAVE_HISTORY
     (
     LEAVE_ID INT PRIMARY KEY AUTO_INCREMENT,
     LEAVE_TYPE ENUM('EL'),
     START_DATE DATE NOT NULL,
     END_DATE DATE NOT NULL,
     NO_OF_DAYS INT,
     LEAVE_STATUS ENUM('PENDING','APPROVED','DENIED'),
     LEAVE_REASON TEXT(100),
     LEAVE_APPLIED_ON DATE NOT NULL,
    MANAGER_COMMENTS TEXT(100),
    EMP_ID INT NOT NULL REFERENCES EMPLOYEE(EMP_ID)
     );
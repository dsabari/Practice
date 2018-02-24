package com.hexaware.ftp12.util;
import java.util.Scanner;

import com.hexaware.ftp12.model.Employee;
import com.hexaware.ftp12.model.LeaveDetails;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Display My Leave Details");
    System.out.println("5. List All Pending Leaves");
    System.out.println("6. Approve or Deny Leave");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        listLeaveHistory();
        break;
      case 5:
        listPendingLeaveDetails();
        break;
      case 6:
        approveOrDenyLeave();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2, 3, 4, 5, 6, or 7");
    }
    mainMenu();
  }

  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(" ");
      System.out.println("Id : " + e.getEmpId() + " Name : "
          + e.getEmpName() + " Phone No : "
          + e.getEmpPhone() + " Email ID : " + e.getEmpEmail()
          + " Department : " + e.getEmpDept()
          + " Manager Id : " + e.getEmpManagerId()
          + " Leave Balance : " + e.getEmpLeaveBalance()
          + " Date of Joining : " + e.getEmpDoj());
      System.out.println(" ");
    }
  }

  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println(" ");
      System.out.println("Sorry, No such employee");
      System.out.println(" ");
    } else {
      System.out.println(" ");
      System.out.println("Id : " + employee.getEmpId() + " Name : "
          + employee.getEmpName() + " Phone No : "
          + employee.getEmpPhone() + " Email Id : " + employee.getEmpEmail()
          + " Department : " + employee.getEmpDept()
          + " Manager Id : " + employee.getEmpManagerId()
          + " Leave Balance : " + employee.getEmpLeaveBalance()
          + " Date of Joining : " + employee.getEmpDoj());
      System.out.println(" ");
    }
  }

  private void applyLeave() {
    String startDate;
    String endDate;
    String leaveReason;
    int empId;

    System.out.println("Enter the empId: ");
    empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println(" ");
      System.out.println("Enter valid employee id");
      System.out.println(" ");
    } else {
      System.out.println("Enter start date as yyyy-MM-dd");
      startDate = option.next();
      System.out.println("Enter end date as yyyy-MM-dd");
      endDate = option.next();
      System.out.println("Enter Leave Reason");
      leaveReason = option.next();

      String result = LeaveDetails.leaveApply(empId, startDate, endDate, leaveReason);
      System.out.println(" ");
      System.out.println(result);
      System.out.println(" ");
    }
  }

  private void listLeaveHistory() {
    System.out.println("Enter your Employee Id");
    int empId = option.nextInt();
    LeaveDetails[] leaveDetails = LeaveDetails.listById(empId);
    if (leaveDetails.length == 0) {
      Employee employee = Employee.listById(empId);
      if (employee == null) {
        System.out.println(" ");
        System.out.println("Enter valid employee id");
        System.out.println(" ");
      } else {
        System.out.println(" ");
        System.out.println("Sorry, Leave has not been applied");
        System.out.println(" ");
      }
    } else {
      for (LeaveDetails ld : leaveDetails) {
        System.out.println(" ");
        System.out.println("LeaveId : " + ld.getLeaveId() + " LeaveType : " + ld.getLeaveType() + " StartDate : "
            + ld.getStartDate() + " EndDate : " + ld.getEndDate() + " NoOfDays : "
            + ld.getNoOfDays() + " LeaveStatus : " + ld.getLeaveStatus() + " LeaveReason : "
            + ld.getLeaveReason() + " LeaveAppliedOn : " + ld.getLeaveAppliedOn() + " ManagerComments : "
            + ld.getManagerComments() + " Emp Id : " + ld.getEmpId());
        System.out.println(" ");
      }
    }
  }

  private int listPendingLeaveDetails() {
    int flag = 0;
    System.out.println("Enter Employee Id as a manager");
    int mngrId = option.nextInt();
    Employee[] employee = LeaveDetails.listByMngrId(mngrId);
    if (employee.length == 0) {
      Employee emp = Employee.listById(mngrId);
      if (emp == null) {
        System.out.println(" ");
        System.out.println("Enter valid Manager id");
        System.out.println(" ");
      } else {
        System.out.println(" ");
        System.out.println("Your'e not a Manager");
        System.out.println(" ");
      }
      return 0;
    } else {
      for (Employee ee : employee) {
        LeaveDetails[] leavedetails = LeaveDetails.listByEmpId(ee.getEmpId());
        if (leavedetails.length == 0) {
          System.out.println(" ");
          System.out.println("No pending records available for " + ee.getEmpId());
          System.out.println(" ");
        } else {
          System.out.println(" ");
          System.out.println("Pending Records for " + ee.getEmpId());
          for (LeaveDetails leave : leavedetails) {
            System.out.println(" ");
            System.out.println("LeaveID : " + leave.getLeaveId() + " EmpId : " + leave.getEmpId()
                + " LeaveType : " + leave.getLeaveType()
                + " StartDate : " + leave.getStartDate() + " EndDate : " + leave.getEndDate()
                + " NoOfDays : " + leave.getNoOfDays() + " LeaveReason : " + leave.getLeaveReason()
                + " LeaveAppliedOn : " + leave.getLeaveAppliedOn() + " ManagerComments : " + leave.getManagerComments()
                + " LeaveStatus : " + leave.getLeaveStatus() + " Employee Name : " + ee.getEmpName()
                + " Employee Leave Balance : " + ee.getEmpLeaveBalance());
            System.out.println(" ");
            flag = 1;
          }
        }
      }
    }
    return flag;
  }

  private void approveOrDenyLeave() {
    int res = listPendingLeaveDetails();
    if (res == 1) {
      System.out.println("Enter LeaveId ");
      int id = option.nextInt();
      System.out.println("Enter the Status (APPROVED OR DENIED) ");
      String status = option.next();
      System.out.println("Enter comments ");
      option.nextLine();
      String mgrcmts = option.nextLine();
      String statusChange = LeaveDetails.changeStatus(id, status, mgrcmts);
      System.out.println(" ");
      System.out.println("Your Leave Application is " + status.toUpperCase() + " Manager Comments: " + mgrcmts);
      System.out.println("Status: " + statusChange);
      System.out.println(" ");
    }
  }


  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}

package com.hexaware.ftp12.model;

import com.hexaware.ftp12.persistence.LeaveDetailsDAO;
import com.hexaware.ftp12.persistence.DbConnection;
import java.text.SimpleDateFormat;

import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * LeaveDetails class to store employee leave details.
 * @author hexware
 */
public class LeaveDetails {

  /**
   * leaveId to store leave id.
   * startDate to store start date.
   * endDate to store end date.
   * noOfDays to store number of leave days.
   * leaveStatus to store status of leave.
   * leaveType to store type of leave.
   * leaveReason to store Reason for applying leave.
   * leaveAppliedOn to store leave applied date.
   * managerComments to store Comments given by the manager.
   * empId to store employee id.
   */
  private int leaveId;
  private Date startDate;
  private Date endDate;
  private int noOfDays;
  private LeaveStatus leaveStatus;
  private LeaveType leaveType;
  private String leaveReason;
  private Date leaveAppliedOn;
  private String managerComments;
  private int empId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ldetails = (LeaveDetails) obj;
    if (Objects.equals(leaveId, ldetails.leaveId)
        && Objects.equals(leaveType, ldetails.leaveType)
        && Objects.equals(startDate, ldetails.startDate)
        && Objects.equals(endDate, ldetails.endDate)
        && Objects.equals(noOfDays, ldetails.noOfDays)
        && Objects.equals(leaveStatus, ldetails.leaveStatus)
        && Objects.equals(leaveReason, ldetails.leaveReason)
        && Objects.equals(leaveAppliedOn, ldetails.leaveAppliedOn)
        && Objects.equals(managerComments, ldetails.managerComments)
        && Objects.equals(empId, ldetails.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveId, leaveType, startDate, endDate, noOfDays, leaveStatus, leaveReason, leaveAppliedOn,
      managerComments, empId);
  }

  /**
   */
  public LeaveDetails() {
  }

  /**
   * @param argEmpId to initialize leave id.
  */
  public LeaveDetails(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argLeaveId to initialize leave id.
   * @param argEmpId to initialize employee id.
   * @param argLeaveStatus to initialize employee status.
  */
  public LeaveDetails(final int argLeaveId, final LeaveStatus argLeaveStatus, final int argEmpId) {
    this.leaveId = argLeaveId;
    this.leaveStatus = argLeaveStatus;
    this.empId = argEmpId;
  }

  /**
   * @param argLeaveId to initialize leave id.
   * @param argStartDate to initialize start date.
   * @param argEndDate to initialize end date.
   * @param argNoOfDays to initialize no of days.
   * @param argLeaveStatus to initialize no of days.
   * @param argLeaveReason to initialize leave reason.
   * @param argLeaveAppliedOn to initialize leave applied on.
   * @param argManagerComments to initialize manager comments.
   * @param argEmpId to initialize employee id.
   * @param argLeaveType to initialize employee id.
   */
  public LeaveDetails(final int argLeaveId, final LeaveType argLeaveType, final Date argStartDate,
      final Date argEndDate, final int argNoOfDays, final LeaveStatus argLeaveStatus, final String argLeaveReason,
      final Date argLeaveAppliedOn, final String argManagerComments, final int argEmpId) {
    this.leaveId = argLeaveId;
    this.leaveType = argLeaveType;
    this.startDate = argStartDate;
    this.endDate = argEndDate;
    this.noOfDays = argNoOfDays;
    this.leaveStatus = argLeaveStatus;
    this.leaveReason = argLeaveReason;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.managerComments = argManagerComments;
    this.empId = argEmpId;
  }

  /**
   * The dao for leavedetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * Gets the LeaveId.
   * @return this leaveId.
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   * Gets the StartDate.
   * @return this StartDate .
   */
  public final Date getStartDate() {
    return startDate;
  }

  /**
   * Gets the endDate.
   * @return this endDate.
   */
  public final Date getEndDate() {
    return endDate;
  }

  /**
   * Gets the no of days.
   * @return this no of days.
   */
  public final int getNoOfDays() {
    return noOfDays;
  }

  /**
   * Gets the leave status.
   * @return this leave status.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }

  /**
   * Gets the leavereason.
   * @return this LeaveReason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }

  /**
   * Gets the leaveAppliedon.
   * @return this leaveappliedon.
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

  /**
   * Gets the managercomments.
   * @return this managercomments.
   */
  public final String getManagerComments() {
    return managerComments;
  }

  /**
   * Gets the EmployeeDOJ.
   * @return this Employee's Date of Joining.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the leave type.
   * @return this leave type.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }

  /**
   *
   * @param argLeaveId to set leaveid.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   *
   * @param argLeaveType to set leaveType.
   */
  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }

  /**
   *
   * @param argStartDate to set startdate.
   */
  public final void setStartDate(final Date argStartDate) {
    this.startDate = argStartDate;
  }

  /**
   *
   * @param argEndDate to set enddate.
   */
  public final void setEndDate(final Date argEndDate) {
    this.endDate = argEndDate;
  }

  /**
   *
   * @param argNoOfDays to set no of days.
   */
  public final void setNoOfDays(final int argNoOfDays) {
    this.noOfDays = argNoOfDays;
  }

  /**
   *
   * @param argLeaveReason to set leavereason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

  /**
   *
   * @param argLeaveAppliedOn to set leave applied on.
   */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }

  /**
   *
   * @param argManagerComments to set employee leave balance.
   */
  public final void setManagerComments(final String argManagerComments) {
    this.managerComments = argManagerComments;
  }
  /**
   *
   * @param argLeaveStatus to set leavereason.
   */
  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  @Override
  public final String toString() {
    return "Leave_Id: " + leaveId + " Leave_Type: " + leaveType + " Start_Date: " + startDate + " End_Date: "
      + endDate + " No_Of_Days: " + noOfDays + " Leave_Status: " + leaveStatus + " Leave_Reason: "
      + leaveReason + " Leave_Applied_On: " + leaveAppliedOn + " Manager_Comments: " + managerComments + " Emp_Id: "
      + empId;
  }

  /**
    * Method to apply leave.
    * @return the string
    * @param argEmpId to initialize leave id.
    * @param argStartDate to initialize leave id.
    * @param argEndDate to initialize leave id.
    * @param argLeaveReason to initialize leave id.
  **/
  public static String leaveApply(final int argEmpId, final String argStartDate, final String argEndDate,
      final String argLeaveReason) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date todayDate = new Date();
    String leaveApplied = sdf.format(todayDate);
    Date stDate = null;
    Date edDate = null;
    Date laDate = null;
    LeaveType lt = LeaveType.EL;
    LeaveStatus ls = LeaveStatus.PENDING;

    try {
      stDate = (Date) sdf.parse(argStartDate);
      edDate = (Date) sdf.parse(argEndDate);
      laDate = (Date) sdf.parse(leaveApplied);
    } catch (Exception e) {
      System.out.println(e);
    }

    int numOfDays = (int) ((edDate.getTime() - stDate.getTime()) / 86400000) + 1;

    if (compareDate(stDate, edDate, laDate) == 1) {
      if (decLeave(numOfDays, argEmpId) == 1) {
        int res = dao().insertRecord(lt, stDate, edDate, numOfDays, ls, argLeaveReason, laDate, argEmpId);

        if (res > 0) {
          return "Leave applied successfully";
        } else {
          return "Leave not applied";
        }
      } else {
        return "Insufficient Leave balance";
      }
    } else {
      return "Failed to apply leave";
    }
  }

  /**
   * Compare two dates.
   * @param argStartDate Start date of leave.
   * @param argEndDate end date of leave.
   * @param argLeaveAppliedOn current date while appplying.
   * @return interger
  **/
  public static int compareDate(final Date argStartDate, final Date argEndDate, final Date argLeaveAppliedOn) {
    if (argEndDate.compareTo(argLeaveAppliedOn) >= 0 && argStartDate.compareTo(argLeaveAppliedOn) >= 0) {
      if (argEndDate.compareTo(argStartDate) >= 0) {
        return 1;
      } else {
        System.out.println("Sorry! End date must be greater than or equal to Start date");
        return 0;
      }
    } else {
      System.out.println("Sorry! Start date and End date must be greater than or equal to today date");
      return 0;
    }
  }

  /**
   * Decrement Leave Balance.
   * @param argNoOfDays no of days leave applied.
   * @param argEmpId employee id.
   * @return interger
  **/
  public static int decLeave(final int argNoOfDays, final int argEmpId) {
    Employee emp = dao().getLeaveBal(argEmpId);
    int leaveBalance = emp.getEmpLeaveBalance();

    if (leaveBalance >= argNoOfDays) {
      leaveBalance = leaveBalance - argNoOfDays;
      int dec = dao().decLeaveBal(argEmpId, leaveBalance);

      if (dec > 0) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }

  /**
   * list Leave details by employee id.
   * @param argEmpID id to get Leave details.
   * @return LeaveDetails
   */
  public static LeaveDetails[] listById(final int argEmpID) {
    List<LeaveDetails> ld = dao().findEmpId(argEmpID);
    return ld.toArray(new LeaveDetails[ld.size()]);
  }

  /**
   * list employee details under particular manager Id.
   * @param mngrId id to get employee details.
   * @return Employee
   */
  public static Employee[] listByMngrId(final int mngrId) {
    List<Employee> ls = dao().find(mngrId);
    return ls.toArray(new Employee[ls.size()]);
  }

  /**
   * list leave details of employee who's status is pending.
   * @param argEmpID id to get employee details.
   * @return Employee
   */
  public static LeaveDetails[] listByEmpId(final int argEmpID) {
    List<LeaveDetails> ld = dao().list(argEmpID);
    return ld.toArray(new LeaveDetails[ld.size()]);
  }

  /**
   * Method to change status.
   * @param id to set id.
   * @param status to set status.
   * @param mgrcmts for manager comments.
   * @return status
  **/
  public static String changeStatus(final int id, final String status, final String mgrcmts) {
    String updateStatus;

    if (status.equalsIgnoreCase("APPROVED")) {
      LeaveStatus ls = LeaveStatus.APPROVED;
      updateStatus = LeaveDetails.approveOrDeny(id, ls, mgrcmts);
      return updateStatus;
    } else if (status.equalsIgnoreCase("DENIED")) {
      LeaveStatus ls = LeaveStatus.DENIED;
      updateStatus = LeaveDetails.approveOrDeny(id, ls, mgrcmts);

      int res = dao().incLeaveBalance(id);
      if (res > 0) {
        System.out.println(" ");
        System.out.println("Incremented the leave balance in employee");
      } else {
        System.out.println(" ");
        System.out.println("Increment is not done");
      }

      return updateStatus;
    } else {
      return "Enter correct status";
    }
  }

  /**
   * The method to approve or deny leave.
   * @param id to set leaveId
   * @param status to set status
   * @param mgrcmts to set manager comments
   * @return status
  */
  public static String approveOrDeny(final int id, final LeaveStatus status, final String mgrcmts) {
    int res = dao().leaveApproveDeny(id, status, mgrcmts);
    if (res > 0) {
      return "Updated the status successfully";
    } else {
      return "Failed to update the status";
    }
  }
}

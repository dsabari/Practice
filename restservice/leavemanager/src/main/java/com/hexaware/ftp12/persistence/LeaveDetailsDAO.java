package com.hexaware.ftp12.persistence;

import com.hexaware.ftp12.model.LeaveDetails;
import com.hexaware.ftp12.model.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.hexaware.ftp12.model.LeaveStatus;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.ftp12.model.LeaveType;
import java.util.Date;


/**
 * The DAO class for leave details.
 */
public interface LeaveDetailsDAO {

  /**
   * Inserting Leave Details Info.
   * @param startDate the start date of leave
   * @param endDate the end date of leave
   * @param noOfDays number of days of leave
   * @param leaveStatus status of the leave
   * @param leaveReason reason of the leave
   * @param leaveType type of leave
   * @param leaveAppliedOn leave applied on
   * @param empId the id of the employee
   * @return int value
   */
  @SqlUpdate("insert into LEAVE_DETAILS(LEAVE_TYPE,"
      + "START_DATE,END_DATE,NO_OF_DAYS,LEAVE_STATUS,LEAVE_REASON,LEAVE_APPLIED_ON,EMP_ID)"
      + " values(:leaveType, :startDate, :endDate,:noOfDays, :leaveStatus,"
      + ":leaveReason, :leaveAppliedOn, :empId)")
  int insertRecord(@Bind("leaveType") LeaveType leaveType, @Bind("startDate") Date startDate,
      @Bind ("endDate") Date endDate, @Bind ("noOfDays") int noOfDays, @Bind ("leaveStatus") LeaveStatus leaveStatus,
      @Bind ("leaveReason") String leaveReason, @Bind ("leaveAppliedOn") Date leaveAppliedOn,
      @Bind("empId") int empId);

   /**
   * return leave balance of a employee.
   * @param empID the id of the LeaveDetails
   * @return Employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee getLeaveBal(@Bind("empID") int empID);

  /**
   * Decrement the leave balance after applying.
   * @param leaveBalance to set leaveID.
   * @param empId to set status.
   * @return int noOfRows affected.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVE_BALANCE = :leaveBalance WHERE EMP_ID = :empId")
   int decLeaveBal(@Bind("empId") int empId, @Bind("leaveBalance") int leaveBalance);

  /**
   * return all the leave details of the selected employee.
   * @param empID the id of the LeaveDetails
   * @return the LeaveDetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> findEmpId(@Bind("empID") int empID);

  /**
   * return pending status of employee.
   * @param empId the id of the employee
   * @return the list of leavedetails
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_STATUS = 'PENDING' AND EMP_ID = :empId ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list(@Bind("empId") int empId);

  /**
   * return all the details employee under a manager.
   * @param mngrId the id of the employee
   * @return the list of employee
   */
  @SqlQuery("SELECT * FROM EMPLOYEE  WHERE EMP_MANAGER_ID = :mngrID")
  @Mapper(EmployeeMapper.class)
  List<Employee> find(@Bind("mngrID") int mngrId);

  /**
   * Update the status and manager comments.
   * @param leaveId to set leaveID.
   * @param status to set status.
   * @param mgrcmts to set manager comments.
   * @return number of rows updated
   */

  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS = :status, MANAGER_COMMENTS = :mgrcmts WHERE LEAVE_ID = :leaveId")
   int leaveApproveDeny(@Bind("leaveId") int leaveId, @Bind("status") LeaveStatus status,
      @Bind("mgrcmts") String mgrcmts);

  /**
   * Increment the leave balance in employee after denied.
   * @param leaveId to set leaveID.
   * @return number of rows updated
   */

  @SqlUpdate("UPDATE EMPLOYEE, LEAVE_DETAILS SET EMPLOYEE.EMP_LEAVE_BALANCE ="
      + "EMPLOYEE.EMP_LEAVE_BALANCE + LEAVE_DETAILS.NO_OF_DAYS WHERE EMPLOYEE.EMP_ID"
      + "= LEAVE_DETAILS.EMP_ID AND LEAVE_DETAILS.LEAVE_ID = :leaveId")
   int incLeaveBalance(@Bind("leaveId") int leaveId);

  /**
  * close with no args is used to close the connection.
  */

  void close();
}

package com.hexaware.ftp12.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;
import java.io.*;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp12-0.0.1-SNAPSHOT");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee implements Serializable{
    public int empId;
    private String empName;
    private long empPhone;
    private String empEmail;
    private String empDept;
    private int empManagerId;
    private int empLeaveBalance;
    private Date empDoj;

    public Employee() {
    }

    public Employee(final int empId) {
      this.empId = empId;
    }

    public Employee(final int argEmpId, final String argEmpName,
        final long argEmpPhone, final String argEmpEmail,
        final String argEmpDept, final int argEmpManagerId,
        final int argEmpLeaveBalance, final Date argEmpDoj) {
      this.empId = argEmpId;
      this.empName = argEmpName;
      this.empPhone = argEmpPhone;
      this.empEmail = argEmpEmail;
      this.empDept = argEmpDept;
      this.empManagerId = argEmpManagerId;
      this.empLeaveBalance = argEmpLeaveBalance;
      this.empDoj = argEmpDoj;
    }

    public final boolean equals(final Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Employee emp = (Employee) obj;
      if (Objects.equals(empId, emp.empId)
          && Objects.equals(empName, emp.empName)
          && Objects.equals(empPhone, emp.empPhone)
          && Objects.equals(empEmail, emp.empEmail)
          && Objects.equals(empDept, emp.empDept)
          && Objects.equals(empManagerId, emp.empManagerId)
          && Objects.equals(empLeaveBalance, emp.empLeaveBalance)
          && Objects.equals(empDoj, emp.empDoj)) {
        return true;
      }
      return false;
    }

    public final int getEmpId() {
      return empId;
    }

    public final String getEmpName() {
      return empName;
    }

    public final long getEmpPhone() {
      return empPhone;
    }

    public final String getEmpEmail() {
      return empEmail;
    }

    public final String getEmpDept() {
      return empDept;
    }

    public final int getEmpManagerId() {
      return empManagerId;
    }

    public final int getEmpLeaveBalance() {
      return empLeaveBalance;
    }

    public final Date getEmpDoj() {
      return empDoj;
    }

    public final void setEmpId(final int argEmpId) {
      this.empId = argEmpId;
    }

    public final void setEmpName(final String argEmpName) {
      this.empName = argEmpName;
    }

    public final void setEmpPhone(final long argEmpPhone) {
      this.empPhone = argEmpPhone;
    }

    public final void setEmpEmail(final String argEmpEmail) {
      this.empEmail = argEmpEmail;
    }

    public final void setEmpDept(final String argEmpDept) {
      this.empDept = argEmpDept;
    }

    public final void setEmpManagerId(final int argEmpManagerId) {
      this.empManagerId = argEmpManagerId;
    }

    public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
      this.empLeaveBalance = argEmpLeaveBalance;
    }

    public final void setEmpDoj(final Date argEmpDoj) {
      this.empDoj = argEmpDoj;
    }
    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

class LeaveDetails {
    public int empId;
    public int leaveId;
    public Date startDate;
    public Date endDate;
    public int noOfDays;
    public LeaveStatus leaveStatus;
    public LeaveType leaveType;
    public String leaveReason;
    public Date leaveAppliedOn;
    public String managerComments;

    public LeaveDetails() {
    }

    public LeaveDetails(final int empId) {
      this.empId = empId;
    }

    public LeaveDetails(final int argLeaveId,
      final LeaveType argLeaveType,
      final Date argStartDate,
      final Date argEndDate, final int argNoOfDays,
      final LeaveStatus argLeaveStatus,
      final String argLeaveReason,
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

    public final int getLeaveId() {
      return leaveId;
    }
    public final Date getStartDate() {
      return startDate;
    }
    public final Date getEndDate() {
      return endDate;
    }
    public final int getNoOfDays() {
      return noOfDays;
    }
    public final LeaveStatus getLeaveStatus() {
      return leaveStatus;
    }
    public final String getLeaveReason() {
      return leaveReason;
    }
    public final Date getLeaveAppliedOn() {
      return leaveAppliedOn;
    }
    public final String getManagerComments() {
      return managerComments;
    }
    public final int getEmpId() {
      return empId;
    }
    public final LeaveType getLeaveType() {
      return leaveType;
    }
    public final void setLeaveId(final int argLeaveId) {
      this.leaveId = argLeaveId;
    }
    public final void setLeaveType(final LeaveType argLeaveType) {
      this.leaveType = argLeaveType;
    }
    public final void setStartDate(final Date argStartDate) {
      this.startDate = argStartDate;
    }
    public final void setEndDate(final Date argEndDate) {
      this.endDate = argEndDate;
    }
    public final void setNoOfDays(final int argNoOfDays) {
      this.noOfDays = argNoOfDays;
    }
    public final void setLeaveReason(final String argLeaveReason) {
      this.leaveReason = argLeaveReason;
    }
    public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
      this.leaveAppliedOn = argLeaveAppliedOn;
    }
    public final void setManagerComments(final String argManagerComments) {
      this.managerComments = argManagerComments;
    }
    public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
      this.leaveStatus = argLeaveStatus;
    }
    public final void setEmpId(final int argEmpId) {
      this.empId = argEmpId;
    }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}
enum LeaveStatus {
/**.
 *  Leave status is pending
*/
        PENDING,
/**.
 *  Leave status is approved
*/
        APPROVED,
/**.
 *  Leave status is denied
*/
        DENIED;
}

enum LeaveType {
/**.
 * Leave type of EL
*/
     EL;
}


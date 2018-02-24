package com.hexaware.ftp12.model;

import com.hexaware.ftp12.persistence.DbConnection;
import com.hexaware.ftp12.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   */
  private int empId;
  private String empName;
  private long empPhone;
  private String empEmail;
  private String empDept;
  private int empManagerId;
  private int empLeaveBalance;
  private Date empDoj;

  @Override
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

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empPhone, empEmail, empDept, empManagerId, empLeaveBalance, empDoj);
  }

  /**
   * @param argEmpId to initialize employee id.
  */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpPhone to initialize employee phone.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpDept to initialize employee dept.
   * @param argEmpManagerId to initialize employee manager id.
   * @param argEmpLeaveBalance to initialize employee leave balance.
   * @param argEmpDoj to initialize employee doj.
   */
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

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone.
   */
  public final long getEmpPhone() {
    return empPhone;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   * Gets the EmployeeDept.
   * @return this Employee's Dept.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's Manager ID.
   */
  public final int getEmpManagerId() {
    return empManagerId;
  }

  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's Leave Balance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }

  /**
   * Gets the EmployeeDOJ.
   * @return this Employee's Date of Joining.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   *
   * @param argEmpPhone to set employee phone.
   */
  public final void setEmpPhone(final long argEmpPhone) {
    this.empPhone = argEmpPhone;
  }

  /**
   *
   * @param argEmpEmail to set employee email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   *
   * @param argEmpDept to set employee dept.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   *
   * @param argEmpManagerId to set employee manager id.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.empManagerId = argEmpManagerId;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee leave balance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   *
   * @param argEmpDoj to set employee date of joining.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  @Override
  public final String toString() {
    return "Emp_Id " + empId + " Emp_Name " + empName + " Emp_Phone " + empPhone + " Emp_Email "
      + empEmail + " Emp_Dept " + empDept + " Emp_Manager_Id " + empManagerId + " Emp_Leave_Balance "
      + empLeaveBalance + " Emp_Doj " + empDoj;
  }

}

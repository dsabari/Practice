package com.hexaware.ftp12.model;

import com.hexaware.ftp12.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    Employee e1 = new Employee(2000, "Seetha", 9107130, "seetha@gmail.com", "Developer", 1000, 10,
        new java.util.Date(1996, 05, 22));
    Employee e2 = new Employee(2000, "Seetha", 9107130, "seetha@gmail.com", "Developer", 1000, 10,
        new java.util.Date(1996, 05, 22));
    Employee e3 = new Employee(1000, "nisha", 9107137, "nisha@gmail.com", "Manager", 2000, 15,
        new java.util.Date(1996, 04, 14));

    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
    assertNotEquals(e1, null);
    assertEquals(e1, e2);
    assertNotEquals(e1, e3);
    e3.setEmpName("Seetha");
    assertEquals(e1.getEmpName(), e3.getEmpName());
    e2.setEmpPhone(87654);
    assertNotEquals(e1.getEmpPhone(), e2.getEmpPhone());
    e2.setEmpEmail("aaaa@gmail.com");
    assertNotEquals(e1.getEmpEmail(), e2.getEmpEmail());
    e2.setEmpDept("Programmer");
    assertNotEquals(e1.getEmpDept(), e2.getEmpDept());
    e3.setEmpManagerId(1000);
    assertEquals(e1.getEmpManagerId(), e3.getEmpManagerId());
    e3.setEmpLeaveBalance(10);
    assertEquals(e1.getEmpLeaveBalance(), e3.getEmpLeaveBalance());
    e3.setEmpDoj(new java.util.Date(1996, 04, 22));
    assertNotEquals(e1.getEmpDoj(), e3.getEmpDoj());
    assertEquals("Emp_Id 2000 Emp_Name Seetha Emp_Phone 9107130 Emp_Email seetha@gmail.com Emp_Dept Developer"
        + " Emp_Manager_Id 1000 Emp_Leave_Balance 10 Emp_Doj Mon Jun 22 00:00:00 IST 3896", e1.toString());
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
}


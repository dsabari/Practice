package com.hexaware.ftp12.model;

import com.hexaware.ftp12.persistence.LeaveDetailsDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

/**
 * Test class for LeaveDetails.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {

  /**
   * Tests the equals/hashcode methods of the leavedetails class.
   */
  @Test
  public final void testLeaveDetails() {
    LeaveDetails l100 = new LeaveDetails(100);
    LeaveDetails l101 = new LeaveDetails(101);
    assertNotEquals(l100, null);
    assertNotEquals(l100, new Integer(100));
    assertEquals(l100, new LeaveDetails(100));
    assertEquals(l101, new LeaveDetails(101));
    assertNotEquals(l101, new LeaveDetails(100));
    assertEquals(l100.hashCode(), new LeaveDetails(100).hashCode());
    assertEquals(l100.getEmpId(), new LeaveDetails(100).getEmpId());
    l101.setEmpId(100);
    assertEquals(l101, new LeaveDetails(100));
    l100.setEmpId(101);
    assertEquals(l100, new LeaveDetails(101));
    LeaveDetails ld1 = new LeaveDetails(100, LeaveType.valueOf("EL"), new java.util.Date(2018, 01, 03),
                       new java.util.Date(2018, 01, 04), 1, LeaveStatus.valueOf("PENDING"), "SICK",
                       new java.util.Date(2018, 01, 02), null, 2000);
    assertEquals(ld1.hashCode(), new LeaveDetails(100, LeaveType.valueOf("EL"), new java.util.Date(2018, 01, 03),
                       new java.util.Date(2018, 01, 04), 1, LeaveStatus.valueOf("PENDING"), "SICK",
                       new java.util.Date(2018, 01, 02), null, 2000).hashCode());
    LeaveDetails ld = new LeaveDetails();
    LeaveDetails ld2 = new LeaveDetails(100, LeaveStatus.valueOf("PENDING"), 2000);
    assertEquals(ld2.hashCode(), new LeaveDetails(100, LeaveStatus.valueOf("PENDING"), 2000).hashCode());
    assertNotEquals(ld2, null);
    ld.setEmpId(1000);
    assertEquals(1000, ld.getEmpId());

    ld1.setLeaveType(LeaveType.EL);
    assertEquals(LeaveType.valueOf("EL"), ld1.getLeaveType());

    ld1.setLeaveId(200);
    assertEquals(200, ld1.getLeaveId());

    ld.setStartDate(new java.util.Date(2018, 02, 01));
    assertNotEquals("2018-02-01", ld.getStartDate());

    ld.setEndDate(new java.util.Date(2018, 02, 03));
    assertNotEquals("2018-02-03", ld.getEndDate());

    ld.setNoOfDays(5);
    assertEquals(5, ld.getNoOfDays());

    ld.setLeaveReason("sick");
    assertEquals("sick", ld.getLeaveReason());

    ld.setLeaveReason("sick");
    assertNotEquals("Holiday trip", ld.getLeaveReason());

    ld.setLeaveAppliedOn(new java.util.Date(2018, 02, 01));
    assertNotEquals("2018-02-01", ld.getLeaveAppliedOn());

    ld.setLeaveStatus(LeaveStatus.APPROVED);
    assertEquals(LeaveStatus.APPROVED, ld.getLeaveStatus());

    ld.setLeaveStatus(LeaveStatus.APPROVED);
    assertNotEquals(LeaveStatus.DENIED, ld.getLeaveStatus());

    ld.setManagerComments("ok");
    assertEquals("ok", ld.getManagerComments());

    ld.setManagerComments("done");
    assertNotEquals("not done", ld.getManagerComments());
    assertEquals("Leave_Id: 200 Leave_Type: EL Start_Date: Sun Feb 03 00:00:00 IST 3918 "
        + "End_Date: Mon Feb 04 00:00:00 IST 3918 No_Of_Days: 1 Leave_Status: PENDING "
        + "Leave_Reason: SICK Leave_Applied_On: Sat Feb 02 00:00:00 IST 3918 Manager_Comments: null "
        + "Emp_Id: 2000", ld1.toString());
  }

/**
   * tests leaveApply.
   * @param dao mocking the dao class
   */
  @Test
  public final void testLeaveApply(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        Employee emp = new Employee(1000, "nisha", 9107137, "nisha@gmail.com", "Manager", 2000, 15,
                new java.util.Date(1996, 04, 14));
        dao.getLeaveBal(1000); result = emp;
        dao.decLeaveBal(1000, 12); result = 1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date();
        String leaveApplied = sdf.format(todayDate);
        String stDate = "2018-03-03";
        String edDate = "2018-03-05";

        Date startDate = null;
        Date endDate = null;
        Date laDate = null;

        try {
          startDate = (Date) sdf.parse(stDate);
          endDate = (Date) sdf.parse(edDate);
          laDate = (Date) sdf.parse(leaveApplied);
        } catch (Exception e) {
          System.out.println(e);
        }

        dao.insertRecord(LeaveType.valueOf("EL"), startDate, endDate, 3, LeaveStatus.valueOf("PENDING"),
            "Sick", laDate, 1000);
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    String res1 = LeaveDetails.leaveApply(1000, "2018-03-03", "2018-03-05", "Sick");
    String res2 = LeaveDetails.leaveApply(1000, "2018-01-30", "2018-02-30", "Sick");
    String res3 = LeaveDetails.leaveApply(1000, "2016-01-05", "2016-01-03", "Sick");
    String res4;
    try {
      res4 = LeaveDetails.leaveApply(1000, "02/asdfas55/20", "20-00-30", "Sick");
    } catch (Exception e) {
      res4 = e.getMessage();
    }
    assertEquals("Leave applied successfully", res1);
    assertNotEquals("Insufficient Leave balance", res2);
    assertEquals("Failed to apply leave", res3);
    assertEquals("Leave applied successfully", res1);
    assertEquals(null, res4);
  }

  /**
   * tests that leaveDetails Class is listing LeaveDetails correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> ls = new ArrayList<LeaveDetails>();
        ls.add(new LeaveDetails(300));
        ls.add(new LeaveDetails(200));
        ls.add(new LeaveDetails(300));
        dao.findEmpId(300); result = ls;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ds = LeaveDetails.listById(300);
    assertEquals(3, ds.length);
    assertEquals(new LeaveDetails(300), ds[0]);
    assertNotEquals(new LeaveDetails(300), ds[1]);
    assertEquals(new LeaveDetails(300), ds[2]);

  }
  /**
   * tests that leaveDetails Class is listing LeaveDetails correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListByEmpId(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        ArrayList<LeaveDetails> ls = new ArrayList<LeaveDetails>();
        ls.add(new LeaveDetails(300));
        ls.add(new LeaveDetails(200));
        dao.list(300); result = ls;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ds = LeaveDetails.listByEmpId(300);
    assertEquals(2, ds.length);
    assertEquals(new LeaveDetails(300), ds[0]);
    assertNotEquals(new LeaveDetails(100), ds[1]);
  }

/**
 * Test the compareDate method of LeaveDetails class.
 */
  @Test
    public final void testCompareDate() {
    LeaveDetails ld = new LeaveDetails();
    int res = ld.compareDate(new java.util.Date(2018, 02, 03), new java.util.Date(2018, 02, 05),
        new java.util.Date(2018, 02, 03));
    int res1 = ld.compareDate(new java.util.Date(2018, 02, 01), new java.util.Date(2018, 02, 05),
        new java.util.Date(2018, 02, 03));
    int res2 = ld.compareDate(new java.util.Date(2018, 02, 06), new java.util.Date(2018, 02, 05),
        new java.util.Date(2018, 02, 03));
    int res3 = ld.compareDate(new java.util.Date(2018, 02, 02), new java.util.Date(2018, 02, 06),
        new java.util.Date(2018, 02, 07));
    assertEquals(1, res);
    assertEquals(0, res3);
    assertEquals(0, res1);
    assertEquals(0, res2);
  }
/**
 * Test the listByManagerId method of LeaveDetails class.
 * @param dao mocking the dao class
 */
  @Test
    public final void testListByMngrId(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
        {
          ArrayList<Employee> ld = new ArrayList<Employee>();
          ld.add(new Employee(1));
          ld.add(new Employee(10));
          ld.add(new Employee(100));
          dao.find(100); result = ld;
        }
      };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
          return dao;
        }
      };
    Employee[] emp = LeaveDetails.listByMngrId(100);
    assertEquals(3, emp.length);
    assertEquals(new Employee(1), emp[0]);
    assertEquals(new Employee(10), emp[1]);
    assertEquals(new Employee(100), emp[2]);
  }
/**
 * Test the compareDate method of LeaveDetails class.
 * @param dao mocking the dao class
 */
  @Test
    public final void testApproveOrDeny(@Mocked final LeaveDetailsDAO dao) {
    final LeaveStatus ls1 = LeaveStatus.APPROVED;
    final LeaveStatus ls2 = LeaveStatus.DENIED;
    final LeaveStatus ls3 = LeaveStatus.PENDING;
    new Expectations() {
        {
          dao.leaveApproveDeny(100, ls1, "ok");
          result = 0;
        }
      };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
          return dao;
        }
      };
    String res = LeaveDetails.approveOrDeny(100, ls1, "ok");
    assertNotEquals("Updated the status successfully", res);
    String res1 = LeaveDetails.approveOrDeny(100, ls2, "ok");
    assertEquals("Failed to update the status", res);
    assertEquals("Failed to update the status", res1);
  }
/**
 * Test the compareDate method of LeaveDetails class.
 * @param dao mocking the dao class
 */
  @Test
    public final void testChangeStatus(@Mocked final LeaveDetailsDAO dao) {
    final LeaveStatus ls1 = LeaveStatus.APPROVED;
    final LeaveStatus ls2 = LeaveStatus.DENIED;
    final LeaveStatus ls3 = LeaveStatus.PENDING;
    new Expectations() {
        {
          LeaveDetails ld = new LeaveDetails(10, LeaveType.valueOf("EL"), new java.util.Date(2018, 01, 03),
                       new java.util.Date(2018, 01, 04), 1, LeaveStatus.valueOf("PENDING"), "SICK",
                       new java.util.Date(2018, 01, 02), null, 2000);
          dao.leaveApproveDeny(10, ls1, "ok"); result = 1;
          dao.incLeaveBalance(10); result = 0;
        }
      };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
          return dao;
        }
      };
    String res = LeaveDetails.changeStatus(10, "APPROVED", "ok");
    assertEquals("Updated the status successfully", res);
    String res1 = LeaveDetails.changeStatus(10, "DENIED", "ok");
    assertEquals("Failed to update the status", res1);
    String res2 = LeaveDetails.changeStatus(10, "PENDING", "ok");
    assertEquals("Enter correct status", res2);
    String res3 = LeaveDetails.changeStatus(10, "APPROVE", "ok");
    assertEquals("Enter correct status", res3);
  }

   /**
   * tests whether the given leave balance and fetched leave balance is same or not.
   * @param dao mocking the dao class
   */
  @Test
   public final void testDecLeave(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        Employee emp = new Employee(1000, "sneha", 1223456789, "snehanandimandalam@gmail.com", "HR", 2, 10,
            new java.util.Date(2018, 02, 22));
        dao.getLeaveBal(1000); result = emp;
        dao.decLeaveBal(1000, 5);
        result = 1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    int balance = LeaveDetails.decLeave(5, 1000);
    assertEquals(1, balance);
    assertNotEquals(20, balance);
  }
}


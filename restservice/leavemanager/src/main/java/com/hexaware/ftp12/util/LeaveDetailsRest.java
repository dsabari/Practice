package com.hexaware.ftp12.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

import com.hexaware.ftp12.model.LeaveDetails;
import com.hexaware.ftp12.model.Employee;
/**
 * This class provides a REST interface for the leave details entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @param startDate the id of the employee
   * @param endDate the id of the employee
   * @param leaveReason the id of the employee
   * @return the Message
   */
  @POST
  @Path("/applyleave/{id}/{startDate}/{endDate}/{leaveReason}")
  @Produces(MediaType.TEXT_PLAIN)
  public final String applyLeave(@PathParam("id") final int id, @PathParam("startDate") final String startDate,
        @PathParam("endDate") final String endDate, @PathParam("leaveReason") final String leaveReason) {
    Employee emp = Employee.listById(id);
    if (emp == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    } else {
      final String result = LeaveDetails.leaveApply(id, startDate, endDate, leaveReason);
      return result;
    }
  }

  /**
   * Returns a specific employee's details.
   * @param id the leave id of the employee
   * @param status the leave status of the employee
   * @param mgrcmts the manager comments about leave.
   * @return the employee details
   */
  @POST
  @Path("/approveordeny/{id}/{status}/{mgrcmts}")
  @Produces(MediaType.TEXT_PLAIN)
  public final String leaveDetailsApproveOrDeny(@PathParam("id") final int id,
      @PathParam("status") final String status, @PathParam("mgrcmts") final String mgrcmts) {
    String statusChange = LeaveDetails.changeStatus(id, status, mgrcmts);
    return statusChange;
  }
   /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/listleavehistory/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveHistory(@PathParam("id") final int id) {
    final LeaveDetails[] leaveDetails = LeaveDetails.listById(id);
    if (leaveDetails.length == 0) {
      Employee employee = Employee.listById(id);
      if (employee == null) {
        throw new NotFoundException("No such Employee ID: " + id);
      } else {
        throw new NotFoundException("Sorry, Leave has not been applied");
      }
    } else {
      return leaveDetails;
    }
  }

  /**
   * Returns a specific employee's details.
   * @param mngrId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/listpending/{mngrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] listPending(@PathParam("mngrId") final int mngrId) {
    final Employee[] employee = LeaveDetails.listByMngrId(mngrId);
    List<LeaveDetails> leavedetails = new ArrayList();
    if (employee == null) {
      Employee emp = Employee.listById(mngrId);
      if (emp == null) {
        throw new NotFoundException("No such Employee");
      } else {
        throw new NotFoundException("Your'e not a Manager");
      }
    } else {
      for (Employee ee : employee) {
        LeaveDetails[] ld = LeaveDetails.listByEmpId(ee.getEmpId());
        if (ld.length == 0) {
          throw new NotFoundException("No pending records available");
        } else {
          for (LeaveDetails l : ld) {
            leavedetails.add(l);
          }
        }
      }
    }
    return leavedetails.toArray(new LeaveDetails[leavedetails.size()]);
  }
}

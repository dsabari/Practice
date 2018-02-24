package com.hexaware.ftp12.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {
    
	@Test
	public void testApproveOrDeny() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when().get(CommonUtil.getURI("/api/leavedetails/approveordeny/1/approved/ok")).getBody().asString();
		assertNotEquals("Updated the status successfully", res);
	}

    @Test
	public void testApproveOrDeny404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.TEXT).when()
				.get(CommonUtil.getURI("/api/leavedetails/approve/999/improved/ok")).then().assertThat().statusCode(404);
	}

	 @Test
    public void testLeaveHistory() throws AssertionError, URISyntaxException {
        LeaveDetails[] ld = given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/leavedetails/listleavehistory/3000")).getBody().as(LeaveDetails[].class);
		LeaveDetails l = ld[0];
		assertEquals(3000, l.getEmpId());
    }
 
    @Test
	public void testLeaveHistory404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/listleavehistory/9999")).then().assertThat().statusCode(404);
	}

   @Test
   public void testApplyLeave() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when()
				.get(CommonUtil.getURI("/api/leavedetails/applyleave/3000/2018-02-14/2018-02-15/sick")).
                getBody().asString();
        assertNotEquals("Leave applied successfully",res);        
    }

     @Test
	public void testApplyLeave404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.TEXT).when()
		.get(CommonUtil.getURI("/api/leavedetails/leave/9999/2018-02-14/2018-02-15/sick")).
				then().assertThat().statusCode(404);
	}
	
    @Test
    public void testListPending() throws AssertionError, URISyntaxException {
        LeaveDetails[] leave = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/listpending/1000")).getBody().as(LeaveDetails[].class);
        LeaveDetails ld = leave[0];
        assertNotEquals(1, leave.length);
        assertNotEquals(2001, ld.getEmpId());
        assertNotEquals("OK", ld.getManagerComments());
        assertNotEquals(4, ld.getLeaveId());
        assertNotEquals("LL", ld.getLeaveReason());
        assertNotEquals(3000, ld.getEmpId());
        assertNotEquals(2001, ld.getEmpId());
    }

     @Test
	public void testListPending404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.TEXT).when()
		.get(CommonUtil.getURI("/api/leavedetails/pending/100")).
				then().assertThat().statusCode(404);
	}

}

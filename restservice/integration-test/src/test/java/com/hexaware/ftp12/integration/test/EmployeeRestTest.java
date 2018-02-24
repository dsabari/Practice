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

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		for (Employee e: res) {
			switch (e.empId) {
				case 1000:
					assertNotEquals(new Employee(100,"GRESHMA",9944425297L,"GRESHMAC@HEXAWARE.COM","CEO",0,1,new java.util.Date(789955200000L)) , e);
					assertEquals( 9944425297L, e.getEmpPhone());
					break;
				case 2000:
					assertNotEquals(new Employee(200,"SABARIRAJAN",9836425297L,"SABARIR@HEXAWARE.COM","MANAGER",1000,8,new java.util.Date(816307200000L)), e);
					assertEquals(2000, e.getEmpId());
					break;
				case 2001:
					assertNotEquals(new Employee(200,"KRANTHI",9187525294L,"KRANTHIB@HEXAWARE.COM","MANAGER",1000,4,new java.util.Date(842659200000L)), e);
					assertEquals(2001, e.getEmpId());
					break;				
				case 3000:
					assertNotEquals(new Employee(300,"MONISHA",7941825293L,"MONISHAR@HEXAWARE.COM","EMPLOYEE",2000,6,new java.util.Date(835401600000L)), e);
					assertEquals(3000, e.getEmpId());
					break;				
				case 3001:
					assertNotEquals(new Employee(300,"SNEHA",9123759597L,"SNEHAN@HEXAWARE.COM","EMPLOYEE",2001,14,new java.util.Date(821318400000L)), e);
					assertEquals(3001, e.getEmpId());
					break;			
				default:
					fail("Unknown employee with id:" + e.getEmpId());	
			}
		}
	}
     
	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException {
		Employee res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		assertNotEquals(new Employee(100,"GRESHMA",9944425297L,"GRESHMAC@HEXAWARE.COM","CEO",0,1,new java.util.Date(789955200000L)) , res);
		assertEquals("GRESHMA",res.getEmpName());

  }
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}
}

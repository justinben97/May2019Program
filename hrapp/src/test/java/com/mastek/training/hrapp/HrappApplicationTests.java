package com.mastek.training.hrapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.entities.Department;

//Initialize the JUnit Test with Spring Boot Application Environment
// Spring Boot Test: used to test Spring ApplicationContext
//with all the test cases identified
@RunWith(SpringRunner.class)
@SpringBootTest
public class HrappApplicationTests {
	
	
	//Scan in memory all the components and provide the
	//best match object in the component
	
//	@Autowired
//	EmployeeService empService;
//	
//	@Autowired
//	DepartmentService deptService;
//	
//	@Autowired
//	ProjectService projectService;
//	
//	@Autowired
//	Employee emp;
	
	
	
	@Autowired
	Department dep;
	
	@Test
	public void addDepartmentUsingService() {
		Department emp = new Department();
		emp.setDeptno(4);
		emp.setDeptName("HR");
		emp.setDeptLocation("Aberdeen");
		emp = departmentService.registerOrUpdateDepartment(emp);
		
		
		assertNotNull(emp);
		
		
	}
//	
//	
//	@Test
//	public void addEmployeeUsingService() {
////		Employee emp = new Employee();
//		emp.setEmpno(5);
//		emp.setName("New Employee 6");
//		emp.setSalary(886);
//		emp = empService.registerOrUpdateEmployee(emp);
//		
//		
//		assertNotNull(emp);
//		
//		
//	}
//	@Test
//	public void addDepartmentUsingService() {
//		Department emp = new Department();
//		emp.setDepNo(5);
//		emp.setName("New Employee 6");
//		emp.setLocation("Aberdeen");
//		//emp = empService.registerOrUpdateEmployee(emp);
//		
//		
//		//assertNotNull(emp);
//		
//		
//	}
//	@Test
//	public void findByEmpnousingService() 
//	{
//		int empno=1;
//		assertNotNull(empService.findByEmpno(empno));
//		
//		
//	}
////	
////	@Test
////	public void deleteByEmpnoUsingService() {
////		int empno=2;
////		empService.deleteByEmpno(empno);
////		assertNull(empService.findByEmpno(empno));
////	}
////	
//	@Test
//	public void checkFetchBySalary() {
//		List<Employee> emps = empService
//				.fetchEmployeesBySalaryRange(0,1000);
//		for(Employee employee : emps) {
//			System.out.println(employee);
//		}
//		assertEquals(emps.size(),1);
//	}
//	
//	@Test
//	public void manageAssociations() {
//		
//		Department d1 = new Department();
//		d1.setName("Admin");
//		d1.setLocation("UK");
//		
//		Employee emp1 = new Employee();
//		emp1.setName("Admin Emp 1");
//		emp1.setSalary(34456);
//		
//		Employee emp2 = new Employee();
//		emp2.setName("Admin Emp 2");
//		emp2.setSalary(32456);
//		
//		Project p1 = new Project();
//		p1.setName("UK Project");
//		p1.setCustomerName("UK Customer");
//		
//		Project p2 = new Project();
//		p2.setName("US Project");
//		p2.setCustomerName("US Customer");
//		
//		
//		//one to Many : one Department has many Employees
//		d1.getMembers().add(emp1);
//		d1.getMembers().add(emp2);
//		
//		emp1.setCurrentDepartment(d1);
//		emp2.setCurrentDepartment(d1);
//		
//		//many to Many
//		emp1.getAssignments().add(p1);
//		emp2.getAssignments().add(p2);
//		
//		deptService.registerOrUpdatedepartment(d1);
//		
//	}
//	

	@Test
	public void contextLoads() {
		System.out.println("System Test Executed");
	}
	
	


}

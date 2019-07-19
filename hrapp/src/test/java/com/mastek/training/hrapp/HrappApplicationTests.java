
    
package com.mastek.training.hrapp;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.mastek.training.hrapp.apis.DepartmentService;
import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;


// Initialize the JUnit test with Spring Boot application Environment
// Spring Boot test is used to test Spring ApplicationContext with all the test cases identified
@RunWith(SpringRunner.class)
@SpringBootTest
public class HrappApplicationTests {


    // Scan in memory all the components and provide the best matching object in the component
    @Autowired
    EmployeeService empService;
    
  //  @Autowired
  //  Employee emp;


    @Autowired
    DepartmentService deptService;
    
    @Autowired
    ProjectService projService;
    
//    @Test
//    public void assignDepartmentToEmployee() {
//    	
//    	int emono=29;
//    	int deptno=17;
//    	Employee emp = empService.assignDepartment();
//    	assertNotNUll(emp.getCurrentDepartment());
//    }
//    
//   @Test
//    public void addOEmployeeUsingService() {
//	   Employee emp = new Employee();
//	   
//        //emp.setEmpno(0);
//        emp.setName("Emp1loyee");
//        emp.setSalary(1123.33);
//        emp = empService.registerOrUpdateEmployee(emp);
//        assertNotNull(emp);
//    }
   /*     
    @Test
    public void findByEmpnoUsingService() {
        int empno = 1;
        assertNotNull(empService.findByEmpno(empno));
    }
    
    @Test
    public void deleteByEmpnoUsingService() {
        int empno = 29;
        empService.deleteByEmpno(empno);
        assertNull(empService.findByEmpno(empno));
    }
    
    
    @Test
    public void checkFetchBySalary() {
        List<Employee> emps = empService.fetchEmployeesBySalaryRange(0, 99);
        for (Employee employee : emps) {
            System.out.println(employee);
        }
        assertEquals(emps.size(),2);
    }*/
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/*    @Test
    public void addOrUpdateDepartmentUsingService() {
        dept.setDeptno(0);
        dept.setDeptName("Finance");
        dept.setDeptLocation("Manchester");
        dept = deptService.registerOrUpdateDepartment(dept);
        assertNotNull(dept);
    }*/
    
/*    @Test
    public void checkFetchByDeptLocation() {
        List<Department> depts = deptService.fetchDepartmentsByLocation("Manchester");
        for (Department department : depts) {
            System.out.println(department);
        }
        assertEquals(depts.size(),2);
    }*/
    
/*    @Test
    public void findByEmpnoUsingService() {
        int deptno = 31;
        assertNotNull(deptService.findByDeptno(deptno));
    }
    
    @Test
    public void deleteByEmpnoUsingService() {
        int deptno = 31;
        deptService.deletebyDeptno(deptno);
        assertNull(deptService.findByDeptno(deptno));
    } */
    
////////////////////////////////////////////////////
    
/*    @Test
    public void addOrUpdateProjectUsingService() {
        proj.setProjId(0);
        proj.setProjName("Project X");
        proj.setCustName("Mick");
        proj = projService.registerOrUpdateProject(proj);
        assertNotNull(proj);
    }*/
/*    
    @Test
    public void findByProjIdUsingService() {
        int projId = 32;
        assertNotNull(projService.findByProjId(projId));
    }
    
    @Test
    public void deleteByProjIdUsingService() {
        int projId = 32;
        projService.deleteByProjId(projId);
        assertNull(projService.findByProjId(projId));
    }*/
    
/*    @Test
    public void checkFetchByDeptLocation() {
        List<Department> depts = deptService.fetchDepartmentsByLocation("Manchester");
        for (Department department : depts) {
            System.out.println(department);
        }
        assertEquals(depts.size(),2);
    }*/
    
/*    @Test
    public void checkFetchByProjCustomer() {
        List<Project> projs = projService.fetchProjectsByCustomer("Mick");
        for (Project project : projs) {
            System.out.println(project);
        }
        assertEquals(projs.size(),2);
    }*/


//    @Test
//    public void manageAssociations() {
//        Department dept1 = new Department();
//        dept1.setDeptName("Admin");
//        dept1.setDeptLocation("UK");
//        
//        Employee emp1 = new Employee();
//        emp1.setName("Admin Emp1");
//        emp1.setSalary(213);
//        
//        Employee emp2 = new Employee();
//        emp2.setName("Admin Emp2");
//        emp2.setSalary(215);
//        
//        Project proj1 = new Project();
//        proj1.setProjName("Project X");
//        proj1.setCustName("Morrisons");
//        
//        Project proj2 = new Project();
//        proj2.setProjName("Project Z");
//        proj2.setCustName("Home Office");
//        
//        // One to Many
//        dept1.getMembers().add(emp1);
//        dept1.getMembers().add(emp2);
//        
//        // Many to One
//        emp1.setCurrentDepartment(dept1);
//        emp2.setCurrentDepartment(dept1);
//        
//        // Many to Many
//        // emp1 works on two projects and emp2 only works on one. proj1 has two employees working on it.
//        emp1.getAssignments().add(proj1);
//        emp1.getAssignments().add(proj2);
//        emp2.getAssignments().add(proj1);
//        
//        deptService.registerOrUpdateDepartment(dept1);
//    }
    @Test
    public void assignDepartmentToEmployee() {
        int empno = 12;
        int deptno = 18;
        Employee emp = empService.assignDepartment(empno, deptno);
        assertNotNull(emp.getCurrentDepartment());
    }
    
    
    @Test
    public void assignProjectToEmployee() {
        int empno = 1;
        int projectid = 20;
        //
        Set<Project> projects= empService.assignProject(empno, projectid);
        		
        assertNotNull(projects);		
        //assertThat(emp.getAssignments().size()>0);
     //   assertNotNull(emp.getAssignments());
    }
    
}
 












//package com.mastek.training.hrapp;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.mastek.training.hrapp.apis.DepartmentService;
//import com.mastek.training.hrapp.apis.EmployeeService;
//import com.mastek.training.hrapp.apis.ProjectService;
//import com.mastek.training.hrapp.entities.Employee;
//import com.mastek.training.hrapp.entities.Project;
//import com.mastek.training.hrapp.entities.Department;
//
////Initialize the JUnit Test with Spring Boot Application Environment
//// Spring Boot Test: used to test Spring ApplicationContext
////with all the test cases identified
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HrappApplicationTests {
//	
//	
//	//Scan in memory all the components and provide the
//	//best match object in the component
//	
////	@Autowired
////	EmployeeService empService;
////	
////	@Autowired
////	DepartmentService deptService;
////	
////	@Autowired
////	ProjectService projectService;
////	
////	@Autowired
////	Employee emp;
//	
//	
//	
//	@Autowired
//	Department dep;
////	
////	@Test
////	public void addDepartmentUsingService() {
////		Department emp = new Department();
////		emp.setDeptno(4);
////		emp.setDeptName("HR");
////		emp.setDeptLocation("Aberdeen");
////		emp = DepartmentService.;		
////		
////		assertNotNull(emp);
////		
////		
////	}
//	
//	
////	@Test
////	public void addEmployeeUsingService() {
//////		Employee emp = new Employee();
////		emp.setEmpno(5);
////		emp.setName("New Employee 6");
////		emp.setSalary(886);
////		emp = empService.registerOrUpdateEmployee(emp);
////		
////		
////		assertNotNull(emp);
////		
////		
////	}
//	@Test
//	public void addDepartmentUsingService() {
//		Department emp = new Department();
//		emp.setDeptno(5);
//		emp.setDeptName("New Employee 6");
//		emp.setDeptLocation("Aberdeen");
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
//		d1.setDeptName("Admin");
//		d1.setDeptLocation("UK");
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
//		p1.setProjName("UK Project");
//		p1.setCustName("UK Customer");
//		
//		Project p2 = new Project();
//		p2.setProjName("US Project");
//		p2.setCustName("US Customer");
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
//		DepartmentService.registerOrUpdateDepartment(d1);
//		
//	}
//	
//
//	@Test
//	public void contextLoads() {
//		System.out.println("System Test Executed");
//	}
//	
//	
//
//
//}

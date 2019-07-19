package com.mastek.training.hrapp.apis;

import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Media;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.DepartmentRepository;
import com.mastek.training.hrapp.repositories.EmployeeRepository;
// Indicate to Spring to create an object of this class as component
import com.mastek.training.hrapp.repositories.ProjectRepository;

//Components will be initialised for you
//@Scope: singleton: one object for application [default]
		 //prototype: one object copy for each usage


@Component 
@Scope("prototype")//
@Path("/employees/") //map the URL pattern with the class as service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProjectService projectService;
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
		
	}
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee registerOrUpdateEmployee(
			@BeanParam Employee emp) {
			
		emp = employeeRepository.save(emp);
		System.out.println("Employee Registered"+emp);
		// TODO Auto-generated method stub
		return emp;
		
	}
	//Use find method using PathParam
	// /find/1122 : 1122->empno to pass as param to this method
	@Path("/find/{empno}")
	@GET //HTTP Method used to call the api
	@Produces({ // declares all possible content types of return value
		MediaType.APPLICATION_JSON, //object to be given in JSON
		MediaType.APPLICATION_XML //object to be given in XML
		
	})
	public Employee findByEmpno(
			//Use the pathe parameter as the argument for the method
			@PathParam(value = "empno") int empno) {
		// fetches the Employee details from DB by empno
		try {
			return employeeRepository.findById(empno).get();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	@DELETE //delete 
	@Path("/delete/{empno}")
	public void deleteByEmpno(@PathParam("empno")int empno) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(empno);
			
		
	}

	
	@GET //http method
	@Path("/fetchBySalary")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> fetchEmployeesBySalaryRange(//double min, double max)
		@QueryParam("min") double min,
		@QueryParam("max") double max){
        return employeeRepository.findBySalary(min, max);
    }
	//Spring ensures that database session 
	@Transactional
	@POST
	@Path("/assign/department")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
    public Employee assignDepartment(@FormParam("empno") int empno, @FormParam("deptno") int deptno) { 
        try {
            // Fetch the entities to be associated
            Employee emp = findByEmpno(empno);
            Department dept = departmentService.findByDeptno(deptno);
            // Manage the association
            dept.getMembers().add(emp);    // One assigned with many
            emp.setCurrentDepartment(dept);    // Many assigned with one
            // Update the entity to save the association
            emp = registerOrUpdateEmployee(emp);
            return emp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	@Transactional
	@POST
	@Path("/assign/project")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Project> assignProject(@FormParam("empno")int empno,@FormParam("projectid") int projectid) {
		try {
			Employee emp= findByEmpno(empno);
			Project prj = projectService.findByProjId(projectid);
			emp.getAssignments().add(prj);
			emp= registerOrUpdateEmployee(emp);
			
			return emp.getAssignments();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		
		
	}
		
	
	

}

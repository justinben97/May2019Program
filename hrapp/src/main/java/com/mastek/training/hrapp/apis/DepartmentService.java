package com.mastek.training.hrapp.apis;



import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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



import com.mastek.training.hrapp.entities.Department;

import com.mastek.training.hrapp.entities.Employee;

import com.mastek.training.hrapp.repositories.DepartmentRepository;



@Component

@Scope("singleton")
@Path("/departments/")
public class DepartmentService {

	

	@Autowired

	private DepartmentRepository departmentRepository;

	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerOrUpdateDepartment( @BeanParam Department dept) {

		dept = departmentRepository.save(dept);

		System.out.println("Department Registered" + dept);

		return dept;

	}
	
	
	
	@Path("/find/{deptno}")
	@GET //HTTP Method used to call the api
	@Produces({ // declares all possible content types of return value
		MediaType.APPLICATION_JSON, //object to be given in JSON
		MediaType.APPLICATION_XML //object to be given in XML
		
	})
	
	public Department findByDeptno(
			@PathParam("deptno")int deptno) {

		try {

			return departmentRepository.findById(deptno).get();

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}

		
	@DELETE
	@Path("/delete/{deptno}")
	public void deletebyDeptno(@PathParam("deptno")int deptno) {
	
		departmentRepository.deleteById(deptno);

	}

	
	@GET
	@Path("/fetchDepartmentsByLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> fetchDepartmentsByLocation(@QueryParam("deptLocation") String deptLocation){

        return departmentRepository.findByDeptLocation(deptLocation);

    }

}
//package com.mastek.training.hrapp.apis;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.mastek.training.hrapp.entities.Department;
//import com.mastek.training.hrapp.repositories.DepartmentRepository;
//
//public class DepartmentService {
//	@Autowired
//	private DepartmentRepository DepartmentRepository;
//	
//	public DepartmentService() {
//		System.out.println("department Service Created");
//		
//	}
//
//	public Department registerOrUpdatedepartment(Department emp) {
//		emp = DepartmentRepository.save(emp); 
//				
//		
//		System.out.println("department Registered"+emp);
//		// TODO Auto-generated method stub
//		return emp;
//		
//	}
//
//	public Department findByDeptNo(int empno) {
//		// TODO Auto-generated method stub
//		try {
//			return DepartmentRepository.findById(empno).get();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//
//	public void deleteByDeptNo(int empno) {
//		// TODO Auto-generated method stub
//		DepartmentRepository.deleteById(empno);
//			
//		
//	}
//
//	public List<Department> fetchdepartmentsBySalaryRange(String location){
//        return DepartmentRepository.findByLocation(location);
//    }
//	
//
//}

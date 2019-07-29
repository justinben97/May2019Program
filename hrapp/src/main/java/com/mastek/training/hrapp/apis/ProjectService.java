package com.mastek.training.hrapp.apis;



import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;



import com.mastek.training.hrapp.entities.Department;

import com.mastek.training.hrapp.entities.Project;

import com.mastek.training.hrapp.repositories.ProjectRepository;



@Component

@Scope("singleton")

@Path("/projects/")
public class ProjectService {

	

	@Autowired

	private ProjectRepository projectRepository;

	

	public ProjectService() {

		System.out.println("Project Service Created");

	}
	@GET
	@Path("/list/")
	@Produces({MediaType.APPLICATION_JSON})
	public Iterable<Project> getAllProjects(){
		return projectRepository.findAll();
		
	}
	

	public Project registerOrUpdateProject(Project proj) {

		proj = projectRepository.save(proj);

		System.out.println("Employee Registered" + proj);

		return proj;

	}



	public Project findByProjId(int projId) {

		try {

			return projectRepository.findById(projId).get();

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}



	public void deleteByProjId(int projId) {

		projectRepository.deleteById(projId);

	}

	

	public List<Project> fetchProjectsByCustomer(String customer){

        return projectRepository.findByProjCustomer(customer);

    }

}

//package com.mastek.training.hrapp.apis;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import com.mastek.training.hrapp.entities.Project;
//import com.mastek.training.hrapp.repositories.ProjectRepository;
//// Indicate to Spring to create an object of this class as component
//
////Components will be initialised for you
////@Scope: singleton: one object for application [default]
//		 //prototype: one object copy for each usage
//
//
//@Component 
//@Scope("prototype")
//public class ProjectService {
//	@Autowired
//	private ProjectRepository ProjectRepository;
//	
//	public ProjectService() {
//		System.out.println("Employee Service Created");
//		
//	}
//
//	public Project registerOrUpdateEmployee(Project emp) {
//		emp = ProjectRepository.save(emp); 
//				
//		
//		System.out.println("Employee Registered"+emp);
//		// TODO Auto-generated method stub
//		return emp;
//		
//	}
//
//	public Project findByprojectId(int projectId) {
//		// TODO Auto-generated method stub
//		try {
//			return ProjectRepository.findById(projectId).get();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//
//	public void deleteByprojectId(int projectId) {
//		// TODO Auto-generated method stub
//		ProjectRepository.deleteById(projectId);
//			
//		
//	}
//
//	public List<Project> fetchProjectsByName(String name){
//        return ProjectRepository.findByName(name);
//    }
//	
//
//}
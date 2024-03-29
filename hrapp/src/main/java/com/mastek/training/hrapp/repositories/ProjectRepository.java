package com.mastek.training.hrapp.repositories;



import java.util.List;



import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Component;



import com.mastek.training.hrapp.entities.Project;



@Component

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	List<Project> findByProjCustomer(@Param("customer") String customer);

}
//package com.mastek.training.hrapp.repositories;
//
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Component;
//
//import com.mastek.training.hrapp.entities.Project;
//
//@Component
//public interface ProjectRepository extends CrudRepository<Project, Integer > {
//	public List	<Project> findByName(@Param("name") String Name);
////	@Param("max") Double max);
//
//}
//
//
//

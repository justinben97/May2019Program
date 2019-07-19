package com.mastek.training.hrapp.entities;



import java.util.HashSet;

import java.util.Set;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.NamedQueries;

import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;



@Component

@Scope("prototype")

@Entity

@Table(name="JPA_PROJECT")

@NamedQueries({

	@NamedQuery(name="Project.findByProjCustomer",query="select p from Project p where p.custName = :customer")

})

public class Project {

	@Value("-1")

	private int projId;

	@Value("Default Project")

	private String projName;

	@Value("Default Customer")

	private String custName;

	

	private Set<Employee> team=new HashSet<>();

	

	// mappedBy => Check the config for Many to Many association in Employee class (getAssignments mwthod)

	@ManyToMany(mappedBy="assignments")
	@XmlTransient
	public Set<Employee> getTeam() {

		return team;

	}

	public void setTeam(Set<Employee> team) {

		this.team = team;

	}

	@Id

	@Column(name="project_id")

	@GeneratedValue(strategy=GenerationType.AUTO)

	public int getProjId() {

		return projId;

	}

	public void setProjId(int projId) {

		this.projId = projId;

	}

	@Column(name="project_name",nullable=false,length=60)

	public String getProjName() {

		return projName;

	}

	public void setProjName(String projName) {

		this.projName = projName;

	}

	

	@Column(name="customer_name",nullable=false,length=60)

	public String getCustName() {

		return custName;

	}

	public void setCustName(String custName) {

		this.custName = custName;

	}

}

//package com.mastek.training.hrapp.entities;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//@Component
//@Scope("prototype")// one copy for each test case
//@Entity // declares the class as an Entity
//@Table(name ="JPA_PROJECT") //declaring the table name for the class
//public class Project {
//	private int projectId;
//	
//	private String name;
//	private String customerName;
//	
//	private Set<Employee> team= new HashSet<>();
//
//	/**
//	 * @return the team
//	 */
//	public Set<Employee> getTeam() {
//	return team;
//}
///**
// * @param team the team to set
// */
//public void setTeam(Set<Employee> team) {
//	this.team = team;
//}
//
//	//mappedBy: check the configuration for Many to Many association
//	//In Employee class
//	@ManyToMany(mappedBy="assignments")
//	/**
//	 * @return the projectId
//	 */
//	public int getProjectId() {
//		return projectId;
//	}
//	/**
//	 * @param projectId the projectId to set
//	 */
//	public void setProjectId(int projectId) {
//		this.projectId = projectId;
//	}
//	/**
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//	/**
//	 * @return the customerName
//	 */
//	public String getCustomerName() {
//		return customerName;
//	}
//	/**
//	 * @param customerName the customerName to set
//	 */
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//
//	}
//}

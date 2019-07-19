package com.mastek.training.hrapp.entities;



import java.util.HashSet;

import java.util.Set;



import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.NamedQueries;

import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;



//@Component : disable for form parameter processing


@Scope("prototype")
@Entity
@Table(name="JPA_DEPARTMENT")
@NamedQueries({
	@NamedQuery(name="Department.findByDeptLocation",query="select d from Department d where d.deptLocation = :location")
})
@XmlRootElement
public class Department {

	@Value("-1")

	private int deptno;

	@Value("Default Department")
	@FormParam("deptName")
	private String deptName;

	@Value("Default Location")
	@FormParam("deptLocation")
	private String deptLocation;

	// One to many - One department has many Employees

	private Set<Employee> members = new HashSet<>();

	

	// @OneToMany is used on the get method to configure the association

	// FetchType.LAZY => delay the initialization until the get method is called using additional select query [default value]

	// FetchType.EAGER => Initialize the collection on the entity find (post load event)

	// CascadeType.ALL => Entity operations made on Department would be performed on each associated employee object

	// ALL = [Persist, Merge, Delete, Refresh]

	// mappedBy => Identifies the property name in the Child class where the Join Column config is present

	// Join Column = Foreign Key

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="currentDepartment")
	@XmlTransient
	public Set<Employee> getMembers() {

		return members;

	}



	public void setMembers(Set<Employee> members) {

		this.members = members;

	}



	@Id

	@Column(name="department_number")

	@GeneratedValue(strategy=GenerationType.AUTO)

	public int getDeptno() {

		return deptno;

	}



	public void setDeptno(int deptno) {

		this.deptno = deptno;

	}



	@Column(name="department_name",nullable=false,length=60)

	public String getDeptName() {

		return deptName;

	}



	public void setDeptName(String deptName) {

		this.deptName = deptName;

	}

	

	@Column(name="department_location",nullable=false,length=60)

	public String getDeptLocation() {

		return deptLocation;

	}



	public void setDeptLocation(String deptLocation) {

		this.deptLocation = deptLocation;

	}



}

//package com.mastek.training.hrapp.entities;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//
//@Component
//@Scope("prototype")// one copy for each test case
//@Entity // declares the class as an Entity
//@Table(name ="JPA_DEPARTMENT") //declaring the table name for the class
//@EntityListeners({EmployeeLifecycleListener.class})
//@NamedQueries({
//	@NamedQuery(name="Department.findByLocation",query="select e from Department e where e.location between :min and :max")
//})
//
//public class Department implements Serializable {
//	
//	@Value("-1")
//	private int deptNo;
//	
//	@Value("Default department")
//	private String name;
//	
//	@Value("Default locatiion")
//	private String location;
//	
//	
//	//OneToMany: One Departmenthas many Employees
//	private Set<Employee> members = new HashSet<>();
//
//	//OneToMany: used on the get method of set to configure association
//	//fetch=LAZY:delay the initialization until method getMembers() is called
//	//until method getMembers() is called 
//	// EAGER: Initialize the collection on entity find
//	// 		post load event
//	// cascade = ALL the entity operation done on Department
//	// would be performed on each associated emmployee object
//	// ALL:  [Persist, Merge, Delete, Refresh]
//	// mappedBy: identifies the propertyname in Child class
//	//	where the JoinColumn configuration is present
//	//	JoinColumn::ForeignKey
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,
//			mappedBy="currentDepartment")
//	public Set<Employee> getMembers() {
//		return members;
//	}
//	/**
//	 * @param members the members to set
//	 */
//	public void setMembers(Set<Employee> members) {
//		this.members = members;
//	}
//	
//	
//	
//	
//	/**
//	 * @return the deptNo
//	 */
//	public int getdeptNo() {
//		return deptNo;
//	}
//	/**
//	 * @param deptNo the deptNo to set
//	 */
//	public void setdeptNo(int deptNo) {
//		this.deptNo = deptNo;
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
//	 * @return the location
//	 */
//	public String getLocation() {
//		return location;
//	}
//	/**
//	 * @param location the location to set
//	 */
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	/**
//	 * @return the members
//	 */
//
//
//}

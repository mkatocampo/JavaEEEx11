/**
 * 
 */
package edu.nbcc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

/**
 * @author Maria Ocampo
 *
 */
public class Employee {
private int id;

@NonNull
@Size(min=6, message="Name must be at least 6 characters")
private String name;

@NonNull
@Min(value=2000, message="Salary must have a minimum value of $2000")
@Max(value=20000, message="Salary must have a minimum value of $20000")
private float salary;

@NonNull
@Size(min=6, message="Designation must be at least 6 characters")
private String designation;
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the salary
 */
public float getSalary() {
	return salary;
}
/**
 * @param salary the salary to set
 */
public void setSalary(float salary) {
	this.salary = salary;
}
/**
 * @return the designation
 */
public String getDesignation() {
	return designation;
}
/**
 * @param designation the designation to set
 */
public void setDesignation(String designation) {
	this.designation = designation;
}


}

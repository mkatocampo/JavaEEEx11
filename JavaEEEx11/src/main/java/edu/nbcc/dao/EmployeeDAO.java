/**
 * 
 */
package edu.nbcc.dao;

import java.util.List;

import edu.nbcc.model.Employee;

/**
 * @author Maria Ocampo
 * Interface to handle CRUD operations
 */

public interface EmployeeDAO {
	
	/**
	 * delete a book
	 * @param d
	 * @return
	 */
	public int delete(int d);
	
	/**
	 * insert a book
	 * @param book
	 * @return
	 */
	public int insert (Employee employee);
	
	/**
	 * update a book
	 * @param book
	 * @return
	 */
	public int update (Employee employee);
	
	/**
	 * find all books
	 * @return
	 */
	public List<Employee> findAll();
	
	/**
	 * get book by name
	 * @param name
	 * @return
	 */
	public Employee findByName(String name);
	
	public Employee findById(int id);
	
}

/**
 * 
 */
package edu.nbcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.nbcc.model.Employee;

/**
 * @author Maria Ocampo
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	@Override
	public int delete(int id) {
		String sql="DELETE from javaee.employee where id = " + id;
		return template.update(sql);
	}

	@Override
	public int insert(Employee employee) {
		String sql="INSERT into javaee.employee(name,salary,designation) VALUES ('" + employee.getName()+ "', '" + employee.getSalary()+ "','" + employee.getDesignation() + "')";
		return template.update(sql);
	}

	@Override
	public int update(Employee employee) {
		String sql="UPDATE javaee.employee SET "
						+ "name = '" + employee.getName() + "'," 
						+ "salary = '" + employee.getSalary() + "',"
						+ "designation = '" + employee.getDesignation() + "' " 
						+ "where id =" + employee.getId();
		return template.update(sql);
	}

	@Override
	public List<Employee> findAll() {
		String sql = "SELECT * from javaee.employee";
		RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		};
		return template.query(sql, rowMapper);
	}

	@Override
	public Employee findByName(String name) {
		String sql = "SELECT * from javaee.employee where name = " + name;
		return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee findById(int id) {
		String sql = "SELECT * from javaee.employee where id = " + id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}

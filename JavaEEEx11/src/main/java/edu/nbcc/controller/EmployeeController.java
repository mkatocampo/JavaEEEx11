/**
 * 
 */
package edu.nbcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nbcc.dao.EmployeeDAO;
import edu.nbcc.model.Employee;

/**
 * @author Maria Ocampo
 * Controller to handle employee operations
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public String showform(Model m) {
		m.addAttribute("employee", new Employee());
		return "employeeform";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "employeeform";
		}
		//if exists, update
		if (emp.getId() > 0) {
			employeeDAO.update(emp);
		}else {
			employeeDAO.insert(emp);
		}
		return "redirect:/getEmployee";
	}
	
	@GetMapping("/getEmployee")
	public String viewEmployees(Model m) {
		List<Employee> list = employeeDAO.findAll();
		m.addAttribute("list",list);
		return "viewEmployee";
	}
	
	@RequestMapping(value = "/deleteemp/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		employeeDAO.delete(id);
		return "redirect:/getEmployee";
	}
	
	@RequestMapping(value = "/editeemp/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable int id, Model m) {
		Employee e = employeeDAO.findById(id); //retrieve employee
		m.addAttribute("employee", e);
		return "employee";
	}
}

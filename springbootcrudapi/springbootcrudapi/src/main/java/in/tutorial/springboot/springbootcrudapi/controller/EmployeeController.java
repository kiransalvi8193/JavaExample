package in.tutorial.springboot.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tutorial.springboot.springbootcrudapi.model.Employee;
import in.tutorial.springboot.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeesrvice;
	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeesrvice.get();
		
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeobj) {
		
		 employeesrvice.save(employeeobj);
		 return employeeobj;
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		
		Employee employeeobj =  employeesrvice.get(id);
		if(employeeobj == null)
		{
			throw new RuntimeException("Employee with"+id+"is not found");
		}
		return employeeobj;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeesrvice.delete(id);
		return "Employee has been deleted"+id;
		
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeobj) {
		
		employeesrvice.save(employeeobj);
		return employeeobj;
		
	}
}

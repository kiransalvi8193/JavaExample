package in.resttutorial.springboot.springbootcrudrestful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.resttutorial.springboot.springbootcrudrestful.exception.ResourceNotFoundException;
import in.resttutorial.springboot.springbootcrudrestful.model.Employee;
import in.resttutorial.springboot.springbootcrudrestful.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeerepository;

	// create get all employees api
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {

		return employeerepository.findAll();

	}

	// create employee
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeerepository.save(employee);
	}

	// get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeerepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	// update employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {

		Employee employee = employeerepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());
		employee.setEmailid(employeeDetails.getEmailid());
		employeerepository.save(employee);
		return ResponseEntity.ok().body(employee);

	}

	// delete employee by id
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {

		employeerepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employeerepository.deleteById(employeeId);
		return ResponseEntity.ok().build();
	}
}

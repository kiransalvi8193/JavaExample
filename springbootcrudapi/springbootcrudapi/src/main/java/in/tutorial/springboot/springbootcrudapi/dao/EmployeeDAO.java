package in.tutorial.springboot.springbootcrudapi.dao;

import java.util.List;

import in.tutorial.springboot.springbootcrudapi.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);

}

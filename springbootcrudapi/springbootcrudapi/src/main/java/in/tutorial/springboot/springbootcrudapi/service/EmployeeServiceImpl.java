package in.tutorial.springboot.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.tutorial.springboot.springbootcrudapi.dao.EmployeeDAO;
import in.tutorial.springboot.springbootcrudapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeedao;

	@Transactional
	@Override
	public List<Employee> get() {
		return employeedao.get();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeedao.get(id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeedao.save(employee);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeedao.delete(id);
		
	}

}

package in.resttutorial.springboot.springbootcrudrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.resttutorial.springboot.springbootcrudrestful.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

package net.springmvc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired CustomerRepository repo;

	public List<Customer> listAll(){
		return (List<Customer>) repo.findAll();
	}
	
	public void save(Customer customer) {
		repo.save(customer);
	}
}

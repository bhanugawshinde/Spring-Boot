package in.ashokit.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.dao.EmployeeRepository;
import in.ashokit.entity.Employee;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public void saveEmployee(String name, String address, LocalDate dob, Double salary) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setDob(dob);
		employee.setSalary(salary);
		employeeRepository.save(employee);
		
	}
	
	public void getAllEmployee() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		System.out.println("---Employee---");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println();
	}
}

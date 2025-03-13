package in.ashokit.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
	
	public void saveImage(String imagePath, String id) {
		File file = new File(imagePath);
		long size = file.length();
		byte[] b = new byte[(int)size];
		try {
			FileInputStream fin = new FileInputStream(file);
			fin.read(b);
			fin.close();
			Optional<Employee> optional = employeeRepository.findById(id);
			if(optional.isPresent()) {
				Employee emp = optional.get();
				emp.setId(id);
				emp.setProfileImage(b);
				employeeRepository.save(emp);
				System.out.println("Image saved ... ");
			}else {
				System.out.println("Employee Not Found ...");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {

	@Id
	@GeneratedValue(generator = "emp-id")
	@GenericGenerator(name = "emp-id", strategy = "in.ashokit.generators.EmployeeIdGenerator")
	@Column(name = "id", unique = true, nullable = false)
	private String id; // ✅ Corrected field name

	private String name;

	private String address;

	private LocalDate dob;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate joinigDate;

	private Double salary;

}

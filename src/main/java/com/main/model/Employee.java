package com.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}", message = "Please enter valid First Name")
	@Column(name = "firstName")
	private String firstName;

	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}", message = "Please enter valid Last Name")
	@Column(name = "lastName")
	private String lastName;

	@NotNull
	@Pattern(regexp ="^(.+)@(\\S+)$", message = "Please enter valid email")
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}", message = "Please enter valid Password")
	@Column(name = "password")
	private String password;

	public Employee() {

	}

	public Employee(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

}

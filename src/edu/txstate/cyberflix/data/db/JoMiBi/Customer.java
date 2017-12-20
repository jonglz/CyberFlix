package edu.txstate.cyberflix.data.db.JoMiBi;

public class Customer {
	private int    id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;

	Customer() {}
	
	public Customer(int id, String firstName, String lastName, String emailAddress, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
	}
		
	public int getCustomerId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return emailAddress;
	}
	public String getPassword() {
		return password;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailAddress=" + emailAddress + ", password="
				+ password + "]";
	}
}

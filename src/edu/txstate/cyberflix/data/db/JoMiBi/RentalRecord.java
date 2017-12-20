package edu.txstate.cyberflix.data.db.JoMiBi;

import java.sql.Date;

public class RentalRecord {
	private int id;
	private Date rentalDate;
	private int filmID;
	private int customerID;
	private Date returnDate;

	public RentalRecord() {}
	
	public RentalRecord(int id, Date rentalDate, int filmID, int customerID, Date returnDate) {
		this.id = id;
		this.rentalDate = rentalDate;
		this.filmID = filmID;
		this.customerID = customerID;
		this.returnDate = returnDate;
	}
		
	public int getRentalID() {
		return filmID;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public int getfilmID() {
		return filmID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "RentalRecord [id=" + id + ", rentalDate=" + rentalDate + ", filmID="
				+ filmID + ", customerID=" + customerID + ", returnDate="
				+ returnDate + "]";
	}
}

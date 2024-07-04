package com.routemasterapi.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ayush_customer")
public class customerentity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "CustomerID")
	    private int customerId;

	    @Column(name = "FirstName", nullable = false)
	    private String firstName;

	    @Column(name = "LastName", nullable = false)
	    private String lastName;

	    @Column(name = "Phone", nullable = false)
	    private String phone;

	    @Column(name = "Email", nullable = false)
	    private String email;

	    @Column(name = "Address", nullable = false)
	    private String address;

	    public customerentity() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param customerId
		 * @param firstName
		 * @param lastName
		 * @param phone
		 * @param email
		 * @param address
		 */
		public customerentity(int customerId, String firstName, String lastName, String phone, String email,
				String address) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.address = address;
		}
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

}

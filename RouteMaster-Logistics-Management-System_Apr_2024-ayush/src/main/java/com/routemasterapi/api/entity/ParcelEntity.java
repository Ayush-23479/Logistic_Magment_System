package com.routemasterapi.api.entity;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ayush1_parcel")
public class ParcelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parcelId", nullable = false)
	private int parcelId;
	
	@Column(name = "senderName", nullable = false) 
	private String  senderName;
	
	@Column(name = "destinationAddress", nullable = false) 
	private String  destinationAddress;
	
	@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "CustomerID", nullable = false)
	    private customerentity customer;

	@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "RouteID", nullable = false)
	    private RouterEntity route;
	
	@Column(name = "totalPayment") 
   private double totalPayment; 

	

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public customerentity getCustomer() {
			return customer;
		}

		public void setCustomer(customerentity customer) {
			this.customer = customer;
		}

		public RouterEntity getRoute() {
			return route;
		}

		public void setRoute(RouterEntity route) {
			this.route = route;
		}

		public String getCreatedDate() {
			return createdDate;
		}

	@Column(name = "destinationPincode", nullable = false) 
	private String  destinationPincode;
	
	@Column(name = "receiverName", nullable = false) 
	private String  receiverName;
	
	@Column(name = "parcelStatus", nullable = false) 
	private String  parcelStatus;
	
	@Column(name = "createdDate", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
   private String createdDate;

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationPincode() {
		return destinationPincode;
	}

	public void setDestinationPincode(String destinationPincode) {
		this.destinationPincode = destinationPincode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getParcelStatus() {
		return parcelStatus;
	}

	public void setParcelStatus(String parcelStatus) {
		this.parcelStatus = parcelStatus;
	}
	

}

package com.routemasterapi.api.model;

import javax.persistence.Column;

public class RouterRequestBody {
	    private int routeId; 
	    private String pincode;	  
	    private String name;	   
	    private String description;
	    private Double totalDistance;

	    public int getRouteId() {
			return routeId;
		}

		public void setRouteId(int routeId) {
			this.routeId = routeId;
		}

		public String getName() {
			return name;
		}

		public void setName(String Name) {
			this.name = Name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String Description) {
			this.description = Description;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String Pincode) {
			this.pincode = Pincode;
		}

		public Double getTotalDistance() {
			return totalDistance;
		}

		public void setTotalDistance(Double TotalDistance) {
			this.totalDistance = TotalDistance;
		}

		
}

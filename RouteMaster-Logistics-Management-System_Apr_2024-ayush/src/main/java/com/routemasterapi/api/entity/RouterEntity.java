package com.routemasterapi.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ayush_routes")
public class RouterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RouteID", nullable = false)
    private int routeId;

    @Column(name = "Pincode", nullable = false)
    private String pincode;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "TotalDistance", nullable = false, precision = 10, scale = 2)
    private double totalDistance;
    
    public RouterEntity() {
		super();
		
	}


	public RouterEntity(int routeId, String pincode, String name, String description, double totalDistance) {
		super();
		this.routeId = routeId;
		this.pincode = pincode;
		this.name =name;
		this.description = description;
		this.totalDistance = totalDistance;
	}

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }
}

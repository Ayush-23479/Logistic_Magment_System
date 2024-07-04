package com.routemasterapi.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ayush1_trackparcel")
public class TrackParcelEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "TrackID")
	    private int trackId;

	 @OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "parcelId", unique = true, nullable = false)
	    private ParcelEntity parcel;

	    @OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "employeeId", unique = true, nullable = false)
	    private EmployeeEntity employee;

	    @Column(name = "ApprovalStatus")
	    private String approvalStatus;

		public int getTrackId() {
			return trackId;
		}

		

		public TrackParcelEntity(int trackId, ParcelEntity parcel,  EmployeeEntity employee, String approvalStatus) {
			// TODO Auto-generated constructor stub
			super();
			this.trackId = trackId;
	        this.parcel = parcel;
	        this.employee = employee;
	        this.approvalStatus = approvalStatus;
		}

		public TrackParcelEntity() {
			super();
			// TODO Auto-generated constructor stub
		}



		public void setTrackId(int trackId) {
			this.trackId = trackId;
		}

		public ParcelEntity getParcel() {
			return parcel;
		}

		public void setParcel(ParcelEntity parcel) {
			this.parcel = parcel;
		}

		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}

		public String getApprovalStatus() {
			return approvalStatus;
		}

		public void setApprovalStatus(String approvalStatus) {
			this.approvalStatus = approvalStatus;
		}

		@Override
		public String toString() {
			return "TrackParcelEntity [trackId=" + trackId + ", parcel=" + parcel + ", employee=" + employee
					+ ", approvalStatus=" + approvalStatus + "]";
		}

		
	    
}

package com.routemasterapi.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.routemasterapi.api.entity.EmployeeEntity;
import com.routemasterapi.api.entity.ParcelEntity;
import com.routemasterapi.api.entity.TrackParcelEntity;
import com.routemasterapi.api.model.TrackParcelIdRequest;
import com.routemasterapi.api.model.TrackParcelRequestBody;
import com.routemasterapi.api.repositories.EmployeeRepositories;
import com.routemasterapi.api.repositories.ParcelRepository;
import com.routemasterapi.api.repositories.TrackParcelRepository;


@Service
public class TrackParcelService {
	@Autowired
	private TrackParcelRepository trackParcelrepository;
	@Autowired
	private ParcelRepository  ParcelRepository;
	@Autowired
	private EmployeeRepositories EmployeeRepository;



	public TrackParcelEntity createParcel(TrackParcelRequestBody trackParcelReqBody) {

		Optional<ParcelEntity> optionalParcel = ParcelRepository.findById(trackParcelReqBody.getParcelId());
		ParcelEntity parcel = optionalParcel.orElseThrow(() -> new Error("No parcel with this id") );
		//newTrackParcel.setEmployee(trackParcelReqBody.getEmployee());
				Optional<EmployeeEntity> optionalEmployee = EmployeeRepository.findById(trackParcelReqBody.getEmpId());
				EmployeeEntity employee = optionalEmployee.orElseThrow(() -> new Error("No employee with this id"));
		TrackParcelEntity newTrackParcel = new TrackParcelEntity();
		newTrackParcel.setParcel(parcel);
		newTrackParcel.setEmployee(employee);
				
		//newTrackParcel.setEmployee(trackParcelReqBody.getEmployee());	
		newTrackParcel.setApprovalStatus(trackParcelReqBody.getApprovalStatus());
		
		return trackParcelrepository.save(newTrackParcel);	 		 
	}

	public TrackParcelEntity updateParcel(TrackParcelRequestBody trackParcelReqBody) {
		Optional<ParcelEntity> optionalParcel = ParcelRepository.findById(trackParcelReqBody.getParcelId());
		ParcelEntity parcel = optionalParcel.orElseThrow(() -> new Error("No parcel with this id") );
		//newTrackParcel.setEmployee(trackParcelReqBody.getEmployee());
				Optional<EmployeeEntity> optionalEmployee = EmployeeRepository.findById(trackParcelReqBody.getEmpId());
				EmployeeEntity employee = optionalEmployee.orElseThrow(() -> new Error("No employee with this id"));
		TrackParcelEntity newTrackParcel = new TrackParcelEntity();
		newTrackParcel.setTrackId(trackParcelReqBody.getTrackId());
		newTrackParcel.setParcel(parcel);
		newTrackParcel.setEmployee(employee);
		
		
		//newTrackParcel.setEmployee(trackParcelReqBody.getEmployee());
		
		
		
		
		newTrackParcel.setApprovalStatus(trackParcelReqBody.getApprovalStatus());
		
		return trackParcelrepository.save(newTrackParcel);	
	}

	public Page<TrackParcelEntity> listAllparcelfromdb(int pageNumber, int size) {
	    Pageable pageable = PageRequest.of(pageNumber, size);
	    return trackParcelrepository.listalltrackparcelsfromdb(pageable);
	}
 
	public String deleteparcel(TrackParcelIdRequest RouterIdReq) {
		int TrackId= RouterIdReq.getTrackId();
		trackParcelrepository.deleteById(TrackId);
		return "Record Deleted";
	}

}

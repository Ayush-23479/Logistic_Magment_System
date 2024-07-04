package com.routemasterapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routemasterapi.api.model.ParcelRequestBody;
import com.routemasterapi.api.model.ParcelIdRequest;
import com.routemasterapi.api.service.ParcelService;
  
@RestController
@CrossOrigin
public class ParcelController {
	
	@Autowired
	private ParcelService ParcelService;	
	
	@RequestMapping(value = "/createParcel", method = RequestMethod.POST)
	public ResponseEntity<?> createParcel(@RequestBody ParcelRequestBody ParcelReqBody) throws Exception {
		return ResponseEntity.ok(ParcelService.createParcel(ParcelReqBody));
	}
	
	@RequestMapping(value = "/updateParcel", method = RequestMethod.PUT)
	public ResponseEntity<?> updateParcel(@RequestBody ParcelRequestBody ParcelReqBody) throws Exception {
		return ResponseEntity.ok(ParcelService.updateParcel(ParcelReqBody));
	}		
	
	@RequestMapping(value = "/listAllParcels", method = RequestMethod.GET)
	public ResponseEntity<?> listAllParcels(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(ParcelService.listallparcelsfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteParcel", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteParcel(@RequestBody ParcelIdRequest parcelIdRequest) throws Exception {
		return ResponseEntity.ok(ParcelService.deleteParcel(parcelIdRequest));
	}		
	@RequestMapping(value = "/listCustomerParcelStatus", method = RequestMethod.GET)
	public ResponseEntity<?> listCustomerParcelStatus(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size,
			@RequestParam("customerId") int customerId) throws Exception {
		return ResponseEntity.ok(ParcelService.listcustomerparcelstatusfromdb(pageNumber, size, customerId));
	}	
	
	@RequestMapping(value = "/listOneMonthParcels", method = RequestMethod.GET)
	public ResponseEntity<?> listOneMonthParcels(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(ParcelService.listonemonthparcelsfromdb(pageNumber, size));
	}	
	
	@RequestMapping(value = "/listOneMonthDelayedParcels", method = RequestMethod.GET)
	public ResponseEntity<?> listOneMonthDelayedParcels(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(ParcelService.listonemonthdelayedparcelsfromdb(pageNumber, size));
	}	
	
}
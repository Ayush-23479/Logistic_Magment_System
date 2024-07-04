package com.routemasterapi.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.routemasterapi.api.model.CustomerRequestBody;
import com.routemasterapi.api.model.CustomerIdRequest;
import com.routemasterapi.api.service.CustomerService;
@RestController
@CrossOrigin
public class customercontroller {
	 @Autowired
	    private CustomerService customerService;    
	    
	    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequestBody customerReqBody) throws Exception {
	        return ResponseEntity.ok(customerService.createCustomer(customerReqBody));
	    }
	    
	    @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequestBody customerReqBody) throws Exception {
	        return ResponseEntity.ok(customerService.updateCustomer(customerReqBody));
	    }        
	    
	    @RequestMapping(value = "/listAllCustomers", method = RequestMethod.GET)
	    public ResponseEntity<?> listAllCustomers(@RequestParam(defaultValue = "0") final Integer pageNumber,
	            @RequestParam(defaultValue = "10") final Integer size) throws Exception {
	        return ResponseEntity.ok(customerService.listAllCustomersFromDb(pageNumber, size));
	    }         
	    
	    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerIdRequest customerIdReq) throws Exception {
	        return ResponseEntity.ok(customerService.deleteCustomer(customerIdReq));
	    }        

}

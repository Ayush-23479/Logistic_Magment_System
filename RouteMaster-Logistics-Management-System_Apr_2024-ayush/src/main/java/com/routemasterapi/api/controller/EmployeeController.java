package com.routemasterapi.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.routemasterapi.api.model.EmployeeIdRequest;
import com.routemasterapi.api.model.EmployeeRequestBody;
import com.routemasterapi.api.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	 @Autowired
	    private EmployeeService employeeService;

	    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestBody employeeReqBody) throws Exception {
	        return ResponseEntity.ok(employeeService.createEmployee(employeeReqBody));
	    }

	    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequestBody employeeReqBody) throws Exception {
	        return ResponseEntity.ok(employeeService.updateEmployee(employeeReqBody));
	    }

	    @RequestMapping(value = "/listAllEmployees", method = RequestMethod.GET)
	    public ResponseEntity<?> listAllEmployees(@RequestParam(defaultValue = "0") final Integer pageNumber,
	            @RequestParam(defaultValue = "10") final Integer size) throws Exception {
	        return ResponseEntity.ok(employeeService.listAllEmployeesFromDb(pageNumber, size));
	    }

	    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteEmployee(@RequestBody EmployeeIdRequest employeeIdRequest) throws Exception {
	        return ResponseEntity.ok(employeeService.deleteEmployee(employeeIdRequest));
	    }
}

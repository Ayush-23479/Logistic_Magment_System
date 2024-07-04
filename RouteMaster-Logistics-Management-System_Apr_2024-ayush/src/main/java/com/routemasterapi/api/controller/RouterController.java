package com.routemasterapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routemasterapi.api.entity.RouterEntity;
import com.routemasterapi.api.model.ParcelIdRequest;
import com.routemasterapi.api.model.ParcelRequestBody;
import com.routemasterapi.api.model.RouterIdRequest;
import com.routemasterapi.api.model.RouterRequestBody;
import com.routemasterapi.api.service.ParcelService;
import com.routemasterapi.api.service.RouterService;

@RestController
@CrossOrigin
public class RouterController {
	@Autowired
	private RouterService Routerservice;	
	
	@RequestMapping(value = "/createRouter", method = RequestMethod.POST)
	public ResponseEntity<?> createRouter(@RequestBody RouterRequestBody RouterReqBody) throws Exception {
		return ResponseEntity.ok(Routerservice.createRouter(RouterReqBody));
	}
	
	@RequestMapping(value = "/updateRouter", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRouter(@RequestBody RouterRequestBody RouterReqBody) throws Exception {
		return ResponseEntity.ok(Routerservice.updateRouter(RouterReqBody));
	}		
	
	@RequestMapping(value = "/listAllRouter", method = RequestMethod.GET)
	public ResponseEntity<?> listAllrouter(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(Routerservice.listAllrouterfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteRouter", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRouter(@RequestBody RouterIdRequest RouterIdReq) throws Exception {
		return ResponseEntity.ok(Routerservice.deleteRouter(RouterIdReq));
	}		
}

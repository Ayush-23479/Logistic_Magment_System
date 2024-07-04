package com.routemasterapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routemasterapi.api.model.TrackParcelIdRequest;
import com.routemasterapi.api.model.TrackParcelRequestBody;
import com.routemasterapi.api.service.TrackParcelService;


@RestController
@CrossOrigin
public class TrackParcelController {
	@Autowired
    private TrackParcelService TrackparcelService;    
    
    @RequestMapping(value = "/createTrackParcel", method = RequestMethod.POST)
    public ResponseEntity<?> createParcel(@RequestBody TrackParcelRequestBody TrackReqBody) throws Exception {
        return ResponseEntity.ok(TrackparcelService.createParcel(TrackReqBody));
    }
    
    @RequestMapping(value = "/updateTrackParcel", method = RequestMethod.PUT)
    public ResponseEntity<?> updateParcel(@RequestBody TrackParcelRequestBody TrackReqBody) throws Exception {
        return ResponseEntity.ok(TrackparcelService.updateParcel(TrackReqBody));
    }        
    
    @RequestMapping(value = "/listAllTrackParcel", method = RequestMethod.GET)
    public ResponseEntity<?> listAllParcel(@RequestParam(defaultValue = "0") final Integer pageNumber,
            @RequestParam(defaultValue = "10") final Integer size) throws Exception {
        return ResponseEntity.ok(TrackparcelService.listAllparcelfromdb(pageNumber, size));
    }         
    
    @RequestMapping(value = "/deleteTrackParcel", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteParcel(@RequestBody TrackParcelIdRequest trackIdRequest) throws Exception {
        return ResponseEntity.ok(TrackparcelService.deleteparcel(trackIdRequest));
    }        
}

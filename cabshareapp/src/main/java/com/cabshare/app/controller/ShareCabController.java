package com.cabshare.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabshare.app.model.request.CabShareRequestModel;

@RestController
public class ShareCabController {
	@Autowired
	private CabShareService cabShareService;
	
@GetMapping("/getMatched/{id}")	
public List<CabShareRequestModel> getMatchesForRequest(@PathVariable Long id){
	return cabShareService.getMatches(id);
}
	 
@PostMapping("/newrequest")
public List<CabShareRequestModel> addNewRequest(@RequestBody CabShareRequestModel cabRequest ) {
	
		return cabShareService.newRequestProcessing(cabRequest);
} 
}

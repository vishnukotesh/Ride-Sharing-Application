package com.cabshare.app.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabshare.app.model.request.CabShareRequestModel;

import ch.hsr.geohash.GeoHash;

@Service
public class CabShareService {
    @Autowired
	private CabShareRepository cabShareRepository;
	
 
	
	
	public List<CabShareRequestModel> newRequestProcessing(CabShareRequestModel cabRequest) {
		
		String geoHashCode = geoHash(cabRequest.getFromLocationLat(),cabRequest.getFromLocationLong(),6);
		cabRequest.setGeoHashCode(geoHashCode);
		cabShareRepository.save(cabRequest);
		
		return getMatches(cabRequest.getId()) ;
		
	} 

   //this method is called in get matches request for a (id)
	public List<CabShareRequestModel> getMatches(Long id) {
		
		Optional<CabShareRequestModel> existingRequest = cabShareRepository.findById(id);
		CabShareRequestModel req= existingRequest.get();
		String geoHash = req.getGeoHashCode();
		
		ArrayList<String> matchedCodeStrings = this.getAllmatchedGeoHashCodes(geoHash);
		
		List<CabShareRequestModel> resultList = new ArrayList<CabShareRequestModel>(); 
		
		for(String codeString:matchedCodeStrings) {
		resultList.addAll(cabShareRepository.findAllByGeoHashCode(codeString));
		}
		
		
		return resultList;
		//return cabShareRepository.findAllByGeoHashCode(geoHash);
	}
	
	public String geoHash(double latitude, double longitude, int numberOfCharacters) {
		return GeoHash.geoHashStringWithCharacterPrecision(latitude, longitude,numberOfCharacters);
	} 
	
	
	public ArrayList<String> getAllmatchedGeoHashCodes(String geoHashString) {
		
		GeoHash geoHash = GeoHash.fromGeohashString(geoHashString);
		
		//below code converts all GeoHash codes into list of strings and adds geoHashString to them.
		GeoHash[] adjacentCodes= geoHash.getAdjacent();
		ArrayList<String> matchedCodeStrings = new ArrayList<>();
		for(GeoHash code:adjacentCodes) {
			String codeString = code.toBase32();
			matchedCodeStrings.add(codeString);
		}
		matchedCodeStrings.add(geoHashString);
		
		
		return matchedCodeStrings;
	}
	
	
}

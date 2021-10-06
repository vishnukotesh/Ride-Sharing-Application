package com.cabshare.app.controller;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabshare.app.model.request.CabShareRequestModel;

@Repository
public interface CabShareRepository 
		extends JpaRepository<CabShareRequestModel,Long> {

	List<CabShareRequestModel> findAllByGeoHashCode(String geoHashCode);
}

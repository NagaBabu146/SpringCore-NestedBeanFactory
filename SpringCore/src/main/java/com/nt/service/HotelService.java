package com.nt.service;

import java.util.List;

import com.nt.dto.HotelDTO;

public interface HotelService {
	
	public List<HotelDTO>  fetchDetails(String f1,String f2)throws Exception;

}

package com.nt.dao;

import java.util.List;

import com.nt.bo.HotelBO;

public interface HotelDAO {
	
	public  List<HotelBO> getDetails(String f1,String f2) throws Exception;

}

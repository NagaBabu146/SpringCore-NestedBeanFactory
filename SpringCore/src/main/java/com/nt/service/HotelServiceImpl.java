package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.stereotype.Service;

import com.nt.bo.HotelBO;
import com.nt.dao.HotelDAO;
import com.nt.dto.HotelDTO;

//@Service("hotelService")
public class HotelServiceImpl implements HotelService {

//	@Autowired
	private HotelDAO dao;

	public HotelServiceImpl(HotelDAO dao) {
		this.dao = dao;
	}

	HotelDTO dto = null;
	List<HotelDTO> listdto = null;
	List<HotelBO> listbo = null;

	@Override
	public List<HotelDTO> fetchDetails(String f1, String f2) throws Exception {
		int count = 0;

		// use dao
		listbo = dao.getDetails(f1, f2);
		listdto = new ArrayList<>();

		for (HotelBO bo : listbo) {
			dto = new HotelDTO();
			BeanUtils.copyProperties(bo, dto);
			count++;
			dto.setSno(count);
			listdto.add(dto);
		}

		return listdto;
	}

}

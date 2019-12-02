package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.HotelDTO;
import com.nt.service.HotelService;
import com.nt.vo.HotelVO;

//@Controller("controller")
public class MainController {

	//@Autowired
	private HotelService service;

	public MainController(HotelService service) {
		this.service = service;
	}

	public List<HotelVO> getData(String f1, String f2) throws Exception {

		List<HotelDTO> listdto = null;
		HotelVO vo = null;
		List<HotelVO> listvo = null;
		// use service
		listdto = service.fetchDetails(f1, f2);
		listvo = new ArrayList<>();
		for (HotelDTO dto : listdto) {
			vo = new HotelVO();
			vo.setSno(String.valueOf(dto.getSno()));
			vo.setName(dto.getName());
			vo.setFood(dto.getFood());
			vo.setCity(dto.getCity());
			listvo.add(vo);
		}
		return listvo;

	}
}

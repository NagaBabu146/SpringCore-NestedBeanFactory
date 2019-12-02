package com.nt.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelBO {

	private int id;
	private String name;
	private String food;
	private String city;
}

package com.nt.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.HotelBO;

//@Repository("hotelDAO")
public class HotelDAOImpl implements HotelDAO {
	private static final String GET_HOTELS_DETAILS = "SELECT ID,NAME,FOOD,CITY FROM RESTAURANTS WHERE FOOD IN(?,?)";

	//@Autowired
	public DataSource ds;

	public HotelDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<HotelBO> getDetails(String f1, String f2) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		HotelBO bo = null;
		List<HotelBO> listbo = null;

		try {
			// get JDBC coonection
			con = ds.getConnection();
			// create prepare statement object
			ps = con.prepareStatement(GET_HOTELS_DETAILS);
			// set query param
			ps.setString(1, f1);
			ps.setString(2, f2);
			rs = ps.executeQuery();
			// process the result
			listbo = new ArrayList<>();
			while (rs.next()) {
				bo = new HotelBO();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setFood(rs.getString(3));
				bo.setCity(rs.getString(4));
				listbo.add(bo);
			} // while
		} // try
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} // catch
		finally {
			// close jdbc connections
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
		return listbo;
	}// method

}// class

package team.Dproject.main.hotel.service;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.hotel.model.HotelDTO;

@Service
public class HotelMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<HotelDTO> listHotel(){
		return sqlSession.selectList("listHotel"); 
	}
	
	public int insertHotel(HotelDTO dto){
		return sqlSession.insert("insertHotel", dto);
	}
	
	public HotelDTO getHotel(int hotel_no){
		return  sqlSession.selectOne("getHotel", hotel_no);
	}
	
	public List<HotelDTO> listHotel1(String address){
		return sqlSession.selectList("listHotel1",address);
	}
	public List<String> getRoomno(String address,String sleep){
		java.util.Map<String, Object> map=new java.util.Hashtable<String, Object>();
		
		int sleeps =  Integer.parseInt(sleep);
		
		if(sleeps <= 2){
			sleeps = 2;
		}
		
		map.put("address", address);
		map.put("sleeps", sleeps);
		return sqlSession.selectList("getRoomno",map);
	}

	
	public int deletetHotel(String no) {
		return sqlSession.delete("deleteHotel", no);
	}
	
	public int updateHotel(HotelDTO dto) {
		return sqlSession.update("updateHotel", dto);
	} 
}

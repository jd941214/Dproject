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
	
	public int insertBoard(HotelDTO dto){
		return sqlSession.insert("insertHotel", dto);
	}
	
	public HotelDTO getHotel(int hotel_no){
		return  sqlSession.selectOne("getHotel", hotel_no);
	}
	
}

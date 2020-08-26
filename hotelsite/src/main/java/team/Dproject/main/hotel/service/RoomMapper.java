package team.Dproject.main.hotel.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import team.Dproject.main.hotel.model.RoomDTO;

@Service
public class RoomMapper {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertRoom(RoomDTO dto,int hotel_no){
		dto.setHotel_no(hotel_no);
		return sqlSession.insert("insertRoom", dto);
	}
	
	public List<RoomDTO> listRoom(){
		return sqlSession.selectList("listRoom"); 
	}
	public List<RoomDTO> listRoom2(int hotel_no){
		return sqlSession.selectList("listRoom2",hotel_no); 
	}
	
	public RoomDTO getRoom(int room_no){
		return sqlSession.selectOne("getRoom", room_no);
	}
	
}

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
	
	public int insertRoom(RoomDTO dto){
		
		return sqlSession.insert("insertRoom", dto);
	}
	
	public List<RoomDTO> listRoom(){
		return sqlSession.selectList("listRoom"); 
	}
	// 호텔별 룸 리스트 불러오기
	public List<RoomDTO> listRoom2(int hotel_no){
		return sqlSession.selectList("listRoom2",hotel_no); 
	}
	
	public RoomDTO getRoom(String room_no){
		return sqlSession.selectOne("getRoom", room_no);
	}
	
	public List<RoomDTO> getRoom1(String room_name){
		return sqlSession.selectList("getRoom1", room_name);
	}
	
	public RoomDTO getRoom2(int hotel_no, int grade){
		java.util.Map<String,Object> map = new java.util.Hashtable<String,Object>();
		
		map.put("hotel_no", hotel_no);
		map.put("grade", grade);
		return sqlSession.selectOne("getRoom2",map);
	}
	
	public int deletetRoom(String no) {
		return sqlSession.insert("deleteRoom", no);
	}
	
	public int updateRoom(RoomDTO dto) {
		return sqlSession.insert("updateRoom", dto);
	}
	
	public int seqUP(){
		return sqlSession.insert("seqUP");
	}
	public int seqGET(){
		return sqlSession.selectOne("seqGET");
	}
}

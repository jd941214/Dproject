package team.Dproject.main.hotel.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import team.Dproject.main.hotel.model.RoomDTO;

@Service
public class RoomMapper_sks {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertRoom_sks(RoomDTO dto){
		
		return sqlSession.insert("insertRoom_sks", dto);
	}
	
	public List<RoomDTO> listRoom_sks(){
		return sqlSession.selectList("listRoom_sks"); 
	}
	// 호텔별 룸 리스트 불러오기
	public List<RoomDTO> listRoom2_sks(int hotel_no){
		return sqlSession.selectList("listRoom2_sks",hotel_no); 
	}
	
	public RoomDTO getRoom_sks(String room_no){
		return sqlSession.selectOne("getRoom_sks", room_no);
	}
	
	public List<RoomDTO> getRoom1_sks(String room_name){
		return sqlSession.selectList("getRoom1_sks", room_name);
	}
	
	public RoomDTO getRoom2_sks(int hotel_no, int grade){
		java.util.Map<String,Object> map = new java.util.Hashtable<String,Object>();
		
		map.put("hotel_no", hotel_no);
		map.put("grade", grade);
		return sqlSession.selectOne("getRoom2_sks",map);
	}
	
	public int deletetRoom_sks(String no) {
		return sqlSession.insert("deleteRoom_sks", no);
	}
	
	public int updateRoom_sks(RoomDTO dto) {
		return sqlSession.insert("updateRoom_sks", dto);
	}
	
	public int seqUP_sks(){
		return sqlSession.insert("seqUP_sks");
	}
	public int seqGET_sks(){
		return sqlSession.selectOne("seqGET_sks");
	}
}

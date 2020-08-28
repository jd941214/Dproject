package team.Dproject.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.model.roomDTO;



@Service
public class RoomMapper {
	@Autowired
	private SqlSession sqlSession;

	public List<roomDTO> listRoom(int hnum) {
		return sqlSession.selectList("listRoom",hnum);
	}

	public int insertRoom(roomDTO dto) {
		return sqlSession.insert("insertRoom", dto);
	}

	public int deletetRoom(String no) {
		return sqlSession.insert("deleteRoom", no);
	}

	public roomDTO getRoom(String no) {
		return sqlSession.selectOne("getRoom", no);
	}

	public int updateRoom(roomDTO dto) {
		return sqlSession.insert("updateRoom", dto);
	}
}
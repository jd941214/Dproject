package team.Dproject.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.model.MainBoardDTO;

@Service
public class BoardMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<MainBoardDTO> listBoard(){
		return sqlSession.selectList("listBoard");
	}
	
	public int insertBoard(MainBoardDTO dto) {
		return sqlSession.insert("insertBoard", dto);
	}
}

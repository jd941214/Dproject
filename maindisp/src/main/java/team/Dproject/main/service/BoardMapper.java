package team.Dproject.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.model.BoardDTO;

@Service
public class BoardMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> board_list(){
		return sqlSession.selectList("board_list");
	}
	
	public int board_insert(BoardDTO dto) {
		return sqlSession.insert("board_insert", dto);
	}
}

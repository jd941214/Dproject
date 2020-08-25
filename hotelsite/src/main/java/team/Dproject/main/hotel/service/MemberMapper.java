package team.Dproject.main.hotel.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import team.Dproject.main.hotel.model.MemberDTO;

@Service
public class MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean checkMember(String ssn1, String ssn2){
		java.util.Map<String,String> map = new java.util.Hashtable<String,String>();
		map.put("ssn1", ssn1);
		map.put("ssn2", ssn2);
		MemberDTO dto = sqlSession.selectOne("checkMember",map);
		if(dto==null)return false;
		return true;
		
	}
	
	public int insertMember(MemberDTO dto, int sex){
		dto.setPosition(0);
		dto.setPoint(0);
		dto.setSex(sex);
		int res = sqlSession.insert("insertMember",dto);
		//sqlSession.commit();
		//db에 추가,삭제,수정을 할 때 session.commit을 해줘야 한다.
		//만약 예를 들어 승인 후 가입이면 승인처리 한 후 commit을 써줘야한다. 단 session.close를 하면 commit이 안된다.
		return res;
    }
	public List<MemberDTO> listMember(){
		return sqlSession.selectList("listMember");
	}
	
	public MemberDTO getMember(int member_no){
		return sqlSession.selectOne("getMember",member_no);
	}
	
}

























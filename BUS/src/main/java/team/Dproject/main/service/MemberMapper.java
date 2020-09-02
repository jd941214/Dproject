package team.Dproject.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import team.Dproject.main.model.MemberDTO;

@Service
public class MemberMapper {
	@Autowired
	private SqlSession sqlSession;

	public int insertMember(MemberDTO dto) {
		int res = sqlSession.insert("insertMember", dto);
		return res;

	}

	public boolean checkMember(MemberDTO dto) {
		java.util.Map<String, String> map = new java.util.Hashtable<String, String>();
		map.put("ssn1", dto.getSsn1());
		map.put("ssn2", dto.getSsn2());
		int res = sqlSession.selectOne("checkMember", map);
		if (res < 3){
			return true;
			
		}else{
			return false;
			
		}
		
	}

	public boolean checkId(MemberDTO dto) {
		int res = sqlSession.selectOne("checkId", dto.getId());
		if(res == 0){
			return true;
			
		}else{
			return false;
			
		}
		
	}

	public List<MemberDTO> memberList() {
		List<MemberDTO> list = sqlSession.selectList("memberList");
		return list;
		
	}

	public List<MemberDTO> findMember(String search, String searchString) {
		List<MemberDTO> list = null;
		if(search.equals("id")){
			list = sqlSession.selectList("findMemberId", searchString);
			
		}
		if(search.equals("name")){
			list = sqlSession.selectList("findMemberName", searchString);
			
		}
		return list;
		
	}

	public int editMember(MemberDTO dto) {
		int res = sqlSession.update("editMember", dto);
		return res;
		
	}

	public int memberLogin(String id, String passwd) {
		String dbPasswd = sqlSession.selectOne("getMemberPasswd", id);
		if(dbPasswd == null){
			return 2; //해당하는 아이디가 없음
			
		}else{
			if(dbPasswd.trim().equals(passwd)){
				return 0; // 로그인 성공
				
			}else{
				return 1; // 비밀번호가 틀림
				
			}
			
		}
		
	}

	public MemberDTO getMember(String id) {
		MemberDTO dto = sqlSession.selectOne("getMember", id);
		return dto;
		
	}



	public int deleteMember(int member_no) {
		int res = sqlSession.delete("deleteMember", member_no);
		return res;
	}

	public List<MemberDTO> searchMemberId(String searchString, String ssn1, String ssn2) {
		java.util.Map<String, String> map = new java.util.Hashtable<String, String>();
		map.put("searchString", searchString);
		map.put("ssn1", ssn1);
		map.put("ssn2", ssn2);
		List<MemberDTO> list = sqlSession.selectList("searchMemberId", map);
		return list;
		
	}

	public List<MemberDTO> searchMemberPasswd(String searchString, String ssn1, String ssn2) {
		java.util.Map<String, String> map = new java.util.Hashtable<String, String>();
		map.put("searchString", searchString);
		map.put("ssn1", ssn1);
		map.put("ssn2", ssn2);
		List<MemberDTO> list = sqlSession.selectList("searchMemberPasswd", map);
		return list;
		
	}


	
}
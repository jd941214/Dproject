package team.Dproject.main.service;

import java.util.ArrayList;
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
		java.util.Map<String, Integer> map = new java.util.Hashtable<String, Integer>();
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
		java.util.Map<String, String> map = new java.util.Hashtable<String, String>();
		if(search == null){
			search = "";
			
		}
		if(searchString == null){
			searchString = "id";
			
		}
		map.put("search", search);
		map.put("searchString", searchString);
		List<MemberDTO> list = sqlSession.selectList("findMember", map);
		return list;
		
	}

	public int editMember(MemberDTO dto) {
		int res = sqlSession.update("editMember", dto);
		return res;
		
	}

	public int memberLogin(String id, String passwd) {
		String dbPasswd = sqlSession.selectOne("getMemberPasswd", id);
		if(dbPasswd == null){
			return 2; //�ش��ϴ� ���̵� ����
			
		}else{
			if(dbPasswd.trim().equals(passwd)){
				return 0; // �α��� ����
				
			}else{
				return 1; // ��й�ȣ�� Ʋ��
				
			}
			
		}
		
	}

	public MemberDTO getMember(String id) {
		MemberDTO dto = sqlSession.selectOne("getMember", id);
		return dto;
		
	}
	
	public MemberDTO getMember2(String member_no) {
		MemberDTO dto = sqlSession.selectOne("getMember2", member_no);
		return dto;	
	}
	
	public List<MemberDTO> getPosition(String posistion) {
		List<MemberDTO> list = sqlSession.selectList("getPosition",posistion);
		return list;	
	}

	public List<MemberDTO> searchMember(String mode, String searchString, String ssn1, String ssn2) {
		java.util.Map<String, String> map = new java.util.Hashtable<String, String>();
		map.put("search", mode);
		map.put("searchString", searchString.trim());
		map.put("ssn1", ssn1);
		map.put("ssn2", ssn2);
		List<MemberDTO> list = sqlSession.selectList("searchMember", map);
		return list;
	}
	
}

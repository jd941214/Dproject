package team.Dproject.main;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.Dproject.main.model.HotelDTO;
import team.Dproject.main.model.MemberDTO;
import team.Dproject.main.service.MemberMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	@Autowired
	private MemberMapper memberMapper;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
		
	}
	@RequestMapping(value = "/main.do")
	public String main(){
		return "main";
		
	}
	@RequestMapping(value = "/member_login.do")
	public String MemberLogin(HttpServletRequest req){
		Cookie[] cks = req.getCookies();
		String value = null;
		if (cks != null && cks.length != 0){
			for(int i=0; i<cks.length; ++i){
				String name = cks[i].getName();
				if (name.equals("id")){
					value = cks[i].getValue();
					break;
					
				}
				
			}
			
		}
		req.setAttribute("value", value);
		return "member_login";
		
	}
	@RequestMapping(value = "/member_login_ok.do")
	public String MemberLoginOk(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String saveId = req.getParameter("saveId");
		int res = memberMapper.memberLogin(id, passwd);
		String msg = null, url = null;
		switch(res){
		case 0 :
			MemberDTO dto = memberMapper.getMember(id);
			HttpSession session = req.getSession();
			Cookie ck = new Cookie("id", id);
			if(saveId != null){
				ck.setMaxAge(10*60);
				
			}else{
				ck.setMaxAge(0);
				
			}
			resp.addCookie(ck);
			session.setAttribute("sedto", dto);
			msg = dto.getName() + "�� ȯ���մϴ�. ������������ �̵��մϴ�.";
			url = "main.do";
			break;
			
		case 1 :
			msg = "��й�ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���";
			url = "member_login.do";
			break;
			
		case 2 :
			msg = "���� ���̵� �Դϴ�. �ٽ� Ȯ���Ͻð� �Է��� �ּ���";
			url = "member_login.do";
			break;
		
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
		
	}
	@RequestMapping(value = "/member_logout.do")
	public String MemberLogout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute("sedto");
		req.setAttribute("msg", "�α׾ƿ� �Ǿ����ϴ�. ������������ �̵��մϴ�.");
		req.setAttribute("url", "main.do");
		return "message";
		
	}
	@RequestMapping(value = "/member_input.do")
	public String MemberInput(){
		return "member_input";
		
	}
	@RequestMapping(value = "/member_input_ok.do")
	public String MemberInputOk(HttpServletRequest req, MemberDTO dto){
		boolean checkMember = memberMapper.checkMember(dto);
		boolean isId;
		String msg = null, url = null;
		if(checkMember){
			isId = memberMapper.checkId(dto);
			if(isId){
				int res = memberMapper.insertMember(dto);
				if(res > 0){
					msg = "ȸ�����Լ���! �α��� �������� �̵��մϴ�.";
					url = "member_login.do";
					
				}else{
					msg = "ȸ�����Խ���! ������������ �̵��մϴ�.";
					url = "main.do";
					
				}
				
			}else{
				msg = "�ߺ��� ���̵� �ֽ��ϴ�. �ٸ� ���̵�� ������ �ּ���";
				url = "member_input.do";
				
			}
			
			
		}else{
			msg = "���̵� �ʹ� �����ϴ�. �α��� ���ּ���.";
			url = "member_login.do";
			
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
	}
	@RequestMapping(value = "/member_list.do")
	public String MemberList(HttpServletRequest req){
		String mode = req.getParameter("mode");
		List<MemberDTO> list = null;
		if(mode == null){
			mode = "all";
			
		}
		if(mode.equals("all")){
			list = memberMapper.memberList();
			
		}else{
			String search = req.getParameter("search");
			String searchString = req.getParameter("searchString");
			if(search == null){
				search = "id";
				
			}
			if(searchString == null){
				searchString = "";
				
			}
			list = memberMapper.findMember(search, searchString);
			
		}
		req.setAttribute("memberList", list);
		req.setAttribute("mode", mode);
		return "member_list";
		
	}
	@RequestMapping(value = "/member_edit.do")
	public String MemberEdit(HttpServletRequest req){
		String id = req.getParameter("id");
		MemberDTO dto = memberMapper.getMember(id);
		req.setAttribute("dto", dto);
		return "member_edit";
		
	}
	@RequestMapping(value = "/member_edit_ok.do")
	public String MemberEditOk(HttpServletRequest req, MemberDTO dto){
		String msg = null, url = null, mode = req.getParameter("mode");
		if(mode == null){
			mode = "";
			
		}
		HttpSession session = req.getSession();
		int res = memberMapper.editMember(dto);
		if(res > 0){
			session.removeAttribute("sedto");
			session.setAttribute("sedto", dto);
			if(mode.equals("mypage")){
				msg = "ȸ����������! ������������ �̵��մϴ�.";
				url = "member_mypage.do";
				
			}else{
				msg = "ȸ����������! ȸ��������� �̵��մϴ�.";
				url = "member_list.do";
				
			}
			
		}else{
			if(mode.equals("mypage")){
				msg = "ȸ����������! ������������ �̵��մϴ�.";
				url = "member_mypage.do";
				
			}else{
				msg = "ȸ����������! ȸ�������������� �̵��մϴ�.";
				url = "member_edit.do?id=" + dto.getId();
				
			}
			
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
	}
	@RequestMapping(value = "/member_mypage.do")
	public String MemberMypage(HttpServletRequest req){
		return "mypage";
		
	}
	@RequestMapping(value = "/member_search.do")
	public String MemberSearch(HttpServletRequest req){
		String mode = req.getParameter("mode");
		req.setAttribute("mode", mode);
		return "member_search";
		
	}
	@RequestMapping(value = "/member_search_ok.do")
	public String MemberSearchOk(HttpServletRequest req){
		String mode = req.getParameter("mode");
		String searchString = req.getParameter("searchString");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		List<MemberDTO> list = null;
		if(mode.equals("id")){
			list = memberMapper.searchMemberId(searchString, ssn1, ssn2);
			
		}
		if(mode.equals("passwd")){
			list = memberMapper.searchMemberPasswd(searchString, ssn1, ssn2);
			
		}
		req.setAttribute("searchList", list);
		req.setAttribute("mode", mode);
		return "searchResult";
		
	}
	@RequestMapping(value = "/member_withdraw.do")
	public String MemberWithdraw(HttpServletRequest req){
		HttpSession session = req.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("sedto");
		int res = memberMapper.deleteMember(dto.getMember_no());
		String msg = null, url = null;
		if(res > 0){
			session.removeAttribute("sedto");
			msg = "ȸ��Ż�𼺰�! ������������ �̵��մϴ�.";
			url = "main.do";
			
		}else{
			msg = "ȸ��Ż�����! ������������ �̵��մϴ�.";
			url = "main.do";
			
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
	}
	@RequestMapping(value = "/member_reserve.do")
	public String MemberReserve(HttpServletRequest req){
		HttpSession session = req.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("sedto");
		List<HotelDTO> hotelList = memberMapper.getHotelReserve(dto.getMember_no());
		//List<BusDTO> busList = memberMapper.getReserve(dto.getMember_no());
		req.setAttribute("hotelList", hotelList);
		//req.setAttribute("busList", busList);
		return "member_reserve";
		
		
	}
	
}
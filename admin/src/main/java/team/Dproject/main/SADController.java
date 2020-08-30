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
import org.springframework.web.servlet.ModelAndView;

import team.Dproject.main.model.MemberDTO;
import team.Dproject.main.service.MemberMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SADController {
   @Autowired
   private MemberMapper memberMapper;
   
   @RequestMapping(value = "/ADmember_list.do")
   public ModelAndView MemberList(HttpServletRequest req){
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
         list = memberMapper.findMember(search, searchString);        
      }
      ModelAndView mav = new ModelAndView();
      mav.setViewName("SuperAD/member/member_list");
      mav.addObject("memberList", list);
      mav.addObject("mode", mode);
      return mav;      
   }
   
   @RequestMapping(value = "/ADmember_edit.do")
   public String MemberEdit(HttpServletRequest req){
      String id = req.getParameter("id");
      MemberDTO dto = memberMapper.getMember(id);
      req.setAttribute("dto", dto);
      return "SuperAD/member/member_edit";
      
   }
   @RequestMapping(value = "/ADmember_edit_ok.do")
   public String MemberEditOk(HttpServletRequest req, MemberDTO dto){
      String msg = null, url = null;
      String mode = req.getParameter("mode");
      if(mode == null){
         mode = "";
         
      }
      HttpSession session = req.getSession();
      int res = memberMapper.editMember(dto);
      if(res > 0){
         if(mode.equals("mypage")){
            session.removeAttribute("sedto");
            session.setAttribute("sedto", dto);
            msg = "회원수정성공! 마이페이지로 이동합니다.";
            url = "SuperAD/member/ADmember_mypage.do";
            
         }else{
            msg = "회원수정성공! 회원목록으로 이동합니다.";
            url = "SuperAD/member/ADmember_list.do";            
         }        
      }else{
         if(mode.equals("mypage")){
            msg = "회원수정실패! 마이페이지로 이동합니다.";
            url = "SuperAD/member/ADmember_mypage.do";
            
         }else{
            msg = "회원수정실패! 회원수정페이지로 이동합니다.";
            url = "SuperAD/member/ADmember_edit.do?id=" + dto.getId();
            
         }
         
      }
      req.setAttribute("msg", msg);
      req.setAttribute("url", url);
      return "message";      
   }
  
   @RequestMapping(value = "/ADmember_input.do")
   public String MemberInput(){
      return "SuperAD/member/member_input";
      
   }
   @RequestMapping(value = "/ADmember_input_ok.do")
   public String MemberInputOk(HttpServletRequest req, MemberDTO dto){
      boolean checkMember = memberMapper.checkMember(dto);
      boolean isId;
      String msg = null, url = null;
      if(checkMember){
         isId = memberMapper.checkId(dto);
         if(isId){
            int res = memberMapper.insertMember(dto);
            if(res > 0){
               msg = "회원가입성공! 로그인 페이지로 이동합니다.";
               url = "ADmember_login.do";
               
            }else{
               msg = "회원가입실패! 메인페이지로 이동합니다.";
               url = "ADmain.do";
               
            }
            
         }else{
            msg = "중복된 아이디가 있습니다. 다른 아이디로 가입해 주세요";
            url = "ADmember_input.do";
            
         }
         
         
      }else{
         msg = "아이디가 너무 많습니다. 로그인 해주세요.";
         url = "ADmember_login.do";
         
      }
      req.setAttribute("msg", msg);
      req.setAttribute("url", url);
      return "message";
      
   }
   
   
   @RequestMapping(value = "/ADmember_show.do")
   public ModelAndView Member_show(HttpServletRequest req){
	  MemberDTO dto=memberMapper.getMember2(req.getParameter("no"));
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("SuperAD/member/member_show");
      mav.addObject("dto", dto);
      return mav;      
   }
 //---------------------------------------------------------------------------
 //---------------------------------------------------------------------------
 //---------------------------------------------------------------------------
   @RequestMapping(value = "/ADBAD_list.do")
   public ModelAndView Member_ADBAD(HttpServletRequest req){
	  List<MemberDTO> list=memberMapper.getPosition(req.getParameter("pos"));
      ModelAndView mav = new ModelAndView();
      mav.setViewName("SuperAD/BAD/BAD_list");
      mav.addObject("list", list);
      return mav;      
   }
   @RequestMapping(value = "/ADHAD_list.do")
   public ModelAndView Member_ADHAD(HttpServletRequest req){
	  List<MemberDTO> list=memberMapper.getPosition(req.getParameter("pos"));
      ModelAndView mav = new ModelAndView();
      mav.setViewName("SuperAD/HAD/HAD_list");
      mav.addObject("list", list);
      return mav;      
   }
   
   
}
  package team.Dproject.main.hotel;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import team.Dproject.main.hotel.model.HotelDTO;
import team.Dproject.main.hotel.model.MemberDTO;
import team.Dproject.main.hotel.model.RFileDTO;
import team.Dproject.main.hotel.model.RoomDTO;
import team.Dproject.main.hotel.service.HotelMapper;
import team.Dproject.main.hotel.service.HotelResvMapper;
import team.Dproject.main.hotel.service.MemberMapper;
import team.Dproject.main.hotel.service.RoomMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HotelController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private HotelMapper hotelMapper;
	
	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private HotelResvMapper hotelResvMapper;
	
	@Resource(name="upLoadPath")
	private String upLoadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/CSS")
	public String css(){
		return "CSS";
	}
	
	@RequestMapping("/main")
	public String main(){
		return "home";
	}
	
	@RequestMapping(value="/membercheck", method=RequestMethod.GET)
	public ModelAndView member(){
		String msg="회원 체크 페이지로 갑니다.";
		String url="membercheckpage";
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("url",url);
		mv.setViewName("message");
		return mv;
	}
	
	@RequestMapping("/membercheckpage")
	public String chekpage(){
		return "member/membercheck";
	}
	
	@RequestMapping(value="/membercheck", method=RequestMethod.POST)
	public String chekMember(HttpServletRequest req){
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		
		boolean chek = memberMapper.checkMember(ssn1, ssn2);
		
		String msg = null,url=null;
		if (chek){
			msg = "현재 회원이십니다. 로그인을 해 주세요";
			url = "memberlist";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}else {
			msg="회원가입 페이지로 갑니다.";
			req.setAttribute("msg", msg);		
			req.setAttribute("name",name);
			req.setAttribute("ssn1",ssn1);
			req.setAttribute("ssn2",ssn2);
	
	        return "member/member";
		}
	}
	
	@RequestMapping("/memberok")
	public String memberInputOk(HttpServletRequest req, MemberDTO dto) {
		int sex=Integer.parseInt(req.getParameter("sex"));
		int res = memberMapper.insertMember(dto,sex);
		String msg = null, url = null;
		if (res > 0) {
			msg = "회원가입성공!! 회원목록페이지로 이동합니다.";
			url = "memberlist";
		} else {
			msg = "회원가입실패!! 회원가입페이지로 이동합니다.";
			url = "membercheck";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@RequestMapping("/memberlist")
	public String memberlist(HttpServletRequest req){
		List<MemberDTO> list = memberMapper.listMember();
		req.setAttribute("memberlist", list);
		return "member/memberlist";
	}
	
	@RequestMapping("/memberlogin")
	public String memberlogin(HttpServletRequest req){
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
		return "member/login";
	}
	
	@RequestMapping(value = "/loginok")
	public String MemberLoginOk(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String saveId = req.getParameter("saveId");
		int res = memberMapper.memberLogin(id, passwd);
		String msg = null, url = null;
		switch(res){
		case 0 :
			MemberDTO dto = memberMapper.getMember1(id);
			HttpSession session = req.getSession();
			Cookie ck = new Cookie("id", id);
			if(saveId != null){
				ck.setMaxAge(10*60);
				
			}else{
				ck.setMaxAge(0);
				
			}
			resp.addCookie(ck);
			session.setAttribute("sedto", dto);
			msg = dto.getName() + "님 환영합니다. 메인페이지로 이동합니다.";
			url = "main";
			break;
			
		case 1 :
			msg = "비밀번호를 잘못 입력하셨습니다. 다시 입력해 주세요";
			url = "member/login";
			break;
			
		case 2 :
			msg = "없는 아이디 입니다. 다시 확인하시고 입력해 주세요";
			url = "member/login";
			break;
		
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
		
	}
	@RequestMapping(value = "/memberlogout")
	public String MemberLogout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute("sedto");
		req.setAttribute("msg", "로그아웃 되었습니다. 메인페이지로 이동합니다.");
		req.setAttribute("url", "main");
		return "message";
		
	}
	
	@RequestMapping("/hotelcheck")
	public String hotelcheck(){
		return "hotel/hotelmain";
	}
	
	@RequestMapping("/hoteladmin")
	public String hoteladmin(){
		return "hotel/hotelinsert";
	}
	
	@RequestMapping("/hotelinsertok")
	public String hotelinsertok(HttpServletRequest req, 
			@ModelAttribute HotelDTO dto, BindingResult rs) {
		if (rs.hasErrors()){
			dto.setHotel_no(0);
		}
		
		String filename = "";
		int filesize = 0;
		MultipartHttpServletRequest mr = 
									(MultipartHttpServletRequest)req;
		MultipartFile file = mr.getFile("filename");
		File target = new File(upLoadPath, file.getOriginalFilename());
		if (file.getSize() > 0){
			try{
				file.transferTo(target);
			}catch(IOException e){}
			filename = file.getOriginalFilename();
			filesize = (int)file.getSize();
		}
		dto.setFilename(filename);
		dto.setFilesize(filesize);
		
		int res = hotelMapper.insertBoard(dto);
		return "redirect:hotelmember";
	}
	
	@RequestMapping("/hotelmember")
	public String hotelmember(HttpServletRequest req){
		List<HotelDTO> list = hotelMapper.listHotel();
		req.setAttribute("hotelList", list);
		return "hotel/hotellist";
	}
	
	@RequestMapping("/hotelupdate")
	public String hotelupdate(HttpServletRequest req){
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		HotelDTO dto = hotelMapper.getHotel(hotel_no);
		req.setAttribute("dto", dto);
		return "hotel/hotelupdate";
	}
	
	@RequestMapping("/hotelupdateok")
	public String hotelupdateok(HttpServletRequest req, @ModelAttribute HotelDTO dto,BindingResult result){
		String filename = "";
		int filesize = 0;
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile file = mr.getFile("filename");
		File target = new File(upLoadPath, file.getOriginalFilename());
		if (file.getSize() > 0){
			try{
				file.transferTo(target);
			}catch(IOException e){}
			filename = file.getOriginalFilename();
			filesize = (int)file.getSize();
		}
		dto.setFilename(filename);
		dto.setFilesize(filesize);
		dto.setMember_num(Integer.parseInt(req.getParameter("member_num")));
		int res = hotelMapper.updateHotel(dto);
		String msg=null,url=null;
		if (res > 0) {
			msg = "호텔수정성공!! 호텔목록페이지로 이동합니다.";
			url = "hotellist";
		} else {
			msg = "호텔수정실패!! 호텔목록페이지로 이동합니다.";
			url = "hotellist";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
	@RequestMapping("/hotel_resv")
	public String hotel_resvselect(){
		return "hotel_resv/hotel_resv";
	}
	
	@RequestMapping("/hotelcontent")
	public String hotelcontent(HttpServletRequest req){
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		HotelDTO dto = hotelMapper.getHotel(hotel_no);
		int member_num = dto.getMember_num();
		MemberDTO mdto = memberMapper.getMember(member_num);
		String name = mdto.getName();
		req.setAttribute("hoteloner", name);
		req.setAttribute("getHotel", dto);
		return "hotel/hotelcontent";
	}
	
	@RequestMapping("/hotellist")
	public String hotellist(HttpServletRequest req){
		List<HotelDTO> list = hotelMapper.listHotel();
		req.setAttribute("hotelList", list);
		return "hotel/hotellist";
	}
	
	@RequestMapping("/hoteldelete")
	public String hoteldelete(){
		return "hotel/hoteldelete";
	}
	
	@RequestMapping("/roominsert")
	public String roominsert(HttpServletRequest req){
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		req.setAttribute("hotel_no", hotel_no);
		return "room/roominsert";
	}
	
	@RequestMapping("/roominsertok")
	public String roominsertok(MultipartHttpServletRequest mtreq,HttpServletRequest req,
			@ModelAttribute RoomDTO dto, BindingResult rs,@ModelAttribute RFileDTO rdto){
		if(rs.hasErrors()){
			dto.setHotel_no(0);
			dto.setRoom_no(0);
		}
		/*List<MultipartFile> fileList = mtreq.getFiles("file");
		String filename = mtreq.getParameter("filename");
		int filesize = 0;
		
		for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            filesize = (int) mf.getSize(); // 파일 사이즈

            String safeFile = upLoadPath + System.currentTimeMillis() + originFileName;
            
            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }*/
		
		/*String filename = "";
		
		MultipartFile file = mtreq.getFile("filename");
		File target = new File(upLoadPath, file.getOriginalFilename());
		if (file.getSize() > 0){
			try{
				file.transferTo(target);
			}catch(IOException e){}
			filename = file.getOriginalFilename();
			filesize = (int)file.getSize();
		}*/
		
		int filesize = 0;
		dto.setFilename(req.getParameter("filename"));
		dto.setFilesize(filesize);
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		int res = roomMapper.insertRoom(dto, hotel_no);
		
		List<MultipartFile> files = mtreq.getFiles("rfile");
		rdto.setRfile(files);
		rdto.setRoom_no(dto.getRoom_no());
		
		
		
		if(dto.getHotel_no()==hotel_no){
			List<RoomDTO> list = roomMapper.listRoom2(hotel_no);
			req.setAttribute("roomList", list);
			req.setAttribute("rfile", rdto);
		}
		

		return "room/roomlist";
	}
	
	@RequestMapping("/roomlist")
	public String roomlist(HttpServletRequest req, RoomDTO dto){
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		if(dto.getHotel_no()==hotel_no){
			List<RoomDTO> list = roomMapper.listRoom2(hotel_no);
			req.setAttribute("roomList", list);	
		}
		
		return "room/roomlist";
	}
	
	@RequestMapping("/roomcontent")
	public String roomcontent(HttpServletRequest req,@ModelAttribute RFileDTO rdto){
		int room_no = Integer.parseInt(req.getParameter("room_no"));
		RoomDTO dto = roomMapper.getRoom(room_no);
		List<MultipartFile> files = null;
		if(room_no==rdto.getRoom_no()){
			files = rdto.getRfile();
		}
		req.setAttribute("Rfiles", files);
		req.setAttribute("getRoom", dto);
		
		return "room/roomcontent";
	}
	
	@RequestMapping("/hotel_resvlist")
	public String hotel_resvlist(HttpServletRequest req, HotelDTO dto){
		String address = req.getParameter("address");
		List<HotelDTO> list = hotelMapper.listHotel1(address);
		req.setAttribute("hotelList", list);
		return "hotel_resv/hotel_resvlist";
	}
}






















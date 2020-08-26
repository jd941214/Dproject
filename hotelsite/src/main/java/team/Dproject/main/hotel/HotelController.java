  package team.Dproject.main.hotel;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public String memberlogin(){
		return "member/login";
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
	
	@RequestMapping("/hotelupdate")
	public String hotelupdate(){
		return "hotel/hotelupdate";
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
	public String roominsertok(/*MultipartHttpServletRequest mtreq,*/HttpServletRequest req,
			@ModelAttribute RoomDTO dto, BindingResult rs){
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
		int hotel_no = Integer.parseInt(req.getParameter("hotel_no"));
		int res = roomMapper.insertRoom(dto, hotel_no);
		
		if(dto.getHotel_no()==hotel_no){
			List<RoomDTO> list = roomMapper.listRoom2(hotel_no);
			req.setAttribute("roomList", list);	
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
	public String roomcontent(HttpServletRequest req){
		int room_no = Integer.parseInt(req.getParameter("room_no"));
		RoomDTO dto = roomMapper.getRoom(room_no);
		req.setAttribute("getRoom", dto);
		
		return "room/roomcontent";
	}
}






















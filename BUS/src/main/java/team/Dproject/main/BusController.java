package team.Dproject.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import team.Dproject.main.model.BusDTO;
import team.Dproject.main.model.BusResvDTO;
import team.Dproject.main.model.BusRoadDTO;
import team.Dproject.main.model.BusStationDTO;
import team.Dproject.main.model.Bus_BusRoadDTO;
import team.Dproject.main.model.MemberDTO;
import team.Dproject.main.model.Member_BusRoadDTO;
import team.Dproject.main.service.BusMapper;
import team.Dproject.main.service.BusResvMapper;
import team.Dproject.main.service.BusRoadMapper;
import team.Dproject.main.service.BusStaionMapper;
import team.Dproject.main.service.MemberMapper;

@Controller
public class BusController {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private BusMapper busMapper;
	@Autowired
	private BusStaionMapper busStationMapper;
	@Autowired
	private BusRoadMapper busRoadMapper;
	@Autowired
	private BusResvMapper busResvMapper;
	@Resource(name="upLoadPath")
	private String upLoadPath;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public String Main(){
		
		return "bus_main";
	
	}
	
	//로그인,회원가입----------------------------------------------------------------------------------
	@RequestMapping(value = "/member_login.do") //로그인 페이지 이동 후 쿠키값 저장
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
		return "/member/member_login";
		
	}
	
	@RequestMapping(value = "/member_login_ok.do")//로그인 완료
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
			msg = dto.getName() + "님 환영합니다. 메인페이지로 이동합니다.";
			url = "bus_main.do";
			break;
			
		case 1 :
			msg = "비밀번호를 잘못 입력하셨습니다. 다시 입력해 주세요";
			url = "member_login.do";
			break;
			
		case 2 :
			msg = "없는 아이디 입니다. 다시 확인하시고 입력해 주세요";
			url = "member_login.do";
			break;
		
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
		
	}
	
	@RequestMapping(value = "/member_logout.do") //로그아웃 페이지
	public String MemberLogout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute("sedto");
		req.setAttribute("msg", "로그아웃 되었습니다. 메인페이지로 이동합니다.");
		req.setAttribute("url", "bus_main.do");
		return "message";
		
	}
	
	
	@RequestMapping(value = "/member_input.do")//회원 가입 페이지 이동
	public String MemberInput(){
		return "/member/member_input";
		
	}
	@RequestMapping(value = "/member_input_ok.do")//회원 가입 완료
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
					url = "member_login.do";
					
				}else{
					msg = "회원가입실패! 메인페이지로 이동합니다.";
					url = "bus_main.do";
					
				}
				
			}else{
				msg = "중복된 아이디가 있습니다. 다른 아이디로 가입해 주세요";
				url = "member_input.do";
				
			}
			
			
		}else{
			msg = "아이디가 너무 많습니다. 로그인 해주세요.";
			url = "member_login.do";
			
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
	}
	
	@RequestMapping(value = "/member_search.do")//아이디 비밀번호 찾기 페이지 이동
	public String MemberSearch(HttpServletRequest req){
		String mode = req.getParameter("mode");
		req.setAttribute("mode", mode);
		return "/member/member_search";
		
	}
	@RequestMapping(value = "/member_search_ok.do")//아이디 비밀번호 찾기 완료
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
		return "/member/searchResult";
		
	}
	
	@RequestMapping(value = "/member_mypage.do") //마이페이지     
	public String MemberMypage(HttpServletRequest req){
		return "/member/mypage";
		
	}
	
	@RequestMapping(value = "/member_edit_ok.do")//수정완료
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
				msg = "회원수정성공! 마이페이지로 이동합니다.";
				url = "member_mypage.do";
				
			}else{
				msg = "회원수정성공! 회원목록으로 이동합니다.";
				url = "member_list.do";
				
			}
			
		}else{
			if(mode.equals("mypage")){
				msg = "회원수정실패! 마이페이지로 이동합니다.";
				url = "member_mypage.do";
				
			}else{
				msg = "회원수정실패! 회원수정페이지로 이동합니다.";
				url = "member_edit.do?id=" + dto.getId();
				
			}
			
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
		
	}
	
	@RequestMapping(value = "/bus_main.do")
	public String busMain(){
		
		return "bus_main";
	
	}
	
	
	
	//버스관련---------------------------------------------------------------
		
		
		//버스---------------------------------------------------------------
		@RequestMapping(value="/bus_list.do" )
		public ModelAndView bus_list(HttpServletRequest req) {
			int pageSize=5;
			String pageNum=req.getParameter("pageNum");
			if(pageNum==null){
				pageNum="1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = currentPage * pageSize - (pageSize-1);
			int endRow = currentPage * pageSize;
			int count = 0;
			count=busMapper.bus_count();
			if(endRow>count){
				endRow=count;
			}
			List<BusDTO> bus_list = busMapper.bus_list_count(startRow, endRow);//노선만든사람 한글로 표시위해 member 테이블 bus_road테이블 조인 후 행의 출력범위 지정
			int startNum = count-((currentPage-1)*pageSize);
			int pageCount = count/pageSize + (count%pageSize == 0 ? 0 : 1);
			int pageBlock = 5;
			int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage>pageCount) endPage = pageCount;
			//List<BusDTO> list = busMapper.listBus();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus/bus_list");
			mav.addObject("bus_list", bus_list);
			mav.addObject("count",count);
			mav.addObject("startNum",startNum);
			mav.addObject("pageCount",pageCount);
			mav.addObject("pageBlock",pageBlock);
			mav.addObject("startPage",startPage);
			mav.addObject("endPage",endPage);
			return mav;
		}
		@RequestMapping(value="/bus_insert.do",method = RequestMethod.GET)
		public ModelAndView bus_insert() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus/bus_insert");
			
			return mav;
		}
		@RequestMapping(value="/bus_insert.do",method = RequestMethod.POST)
		public String bus_insertOK(HttpServletRequest req, BusDTO dto)  {
			int res=busMapper.insertBus(dto);
			String msg = null, url = null;
			if (res > 0) {
				msg = "버스등록 성공";
				url = "bus_list.do";
			} else {
				msg = "버스등록 실패";
				url = "bus_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping("bus_delete.do")
		public String bus_delete(HttpServletRequest req) {
			int res=busMapper.deletetBus(Integer.parseInt(req.getParameter("no")));
			String msg = null, url = null;
			if (res > 0) {
				msg = "버스삭제 성공";
				url = "bus_list.do";
			} else {
				msg = "버스삭제 실패";
				url = "bus_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping(value="/bus_update.do",method = RequestMethod.GET)
		public ModelAndView bus_update(HttpServletRequest req) {
			BusDTO dto = busMapper.getBus(Integer.parseInt(req.getParameter("no")));
			ModelAndView mav = new ModelAndView("bus/bus_update", "bus", dto);
			return mav;
		}
		@RequestMapping(value="/bus_update.do",method = RequestMethod.POST)
		public String bus_updateOK(HttpServletRequest req, BusDTO dto)  {
			int res=busMapper.updateBus(dto); 
			String msg = null, url = null;
			if (res > 0) {
				msg = "버스수정 성공";
				url = "bus_list.do";
			} else {
				msg = "버스수정 실패";
				url = "bus_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		
		@RequestMapping(value = "/member_withdraw.do")//회원 탈퇴
		public String MemberWithdraw(HttpServletRequest req){
			HttpSession session = req.getSession();
			MemberDTO dto = (MemberDTO)session.getAttribute("sedto");
			int res = memberMapper.deleteMember(dto.getMember_no());
			String msg = null, url = null;
			if(res > 0){
				session.removeAttribute("sedto");
				msg = "회원탈퇴성공! 메인페이지로 이동합니다.";
				url = "bus_main.do";
				
			}else{
				msg = "회원탈퇴실패! 메인페이지로 이동합니다.";
				url = "bus_main.do";
				
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
			
		}
		
		//터미널---------------------------------------------------------------
		@RequestMapping("/bus_station_list.do")
		public ModelAndView bus_station_list() {
			List<BusStationDTO> list = busStationMapper.listBus_station();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_station/bus_station_list");
			mav.addObject("bus_station_list", list);
			return mav;
		}
		@RequestMapping(value="/bus_station_insert.do",method = RequestMethod.GET)
		public String bus_station_insert() {
			return "bus_station/bus_station_insert";
		}
		@RequestMapping(value="/bus_station_insert.do",method = RequestMethod.POST)
		public String bus_station_insertOK(HttpServletRequest req,@ModelAttribute BusStationDTO dto,BindingResult result)  {
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
			
			int res=busStationMapper.insertBus_station(dto);
			
			String msg = null, url = null;
			if (res > 0) {
				msg = "버스정류소 성공";
				url = "bus_station_list.do";
			} else {
				msg = "버스정류소 실패";
				url = "bus_station_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
			
		}
		@RequestMapping("bus_station_delete.do")
		public String bus_station_delete(HttpServletRequest req) {
			int res=busStationMapper.deletetBus_station((req.getParameter("no")));
			String msg = null, url = null;
			if (res > 0) {
				msg = "터미널삭제 성공";
				url = "bus_station_list.do";
			} else {
				msg = "터미널삭제 실패";
				url = "bus_station_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping(value="/bus_station_update.do",method = RequestMethod.GET)
		public ModelAndView bus_station_update(HttpServletRequest req) {
			BusStationDTO dto = busStationMapper.getBus_station(req.getParameter("no"));
			ModelAndView mav = new ModelAndView("bus_station/bus_station_update", "station", dto);
			return mav;
		}
		@RequestMapping(value="/bus_station_update.do",method = RequestMethod.POST)
		public String bus_station_updateOK(HttpServletRequest req,@ModelAttribute  BusStationDTO dto,BindingResult result)  {
			
			
			
			String filename = dto.getFilename();
			int filesize =dto.getFilesize();
			
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
			MultipartFile file = mr.getFile("filename");
			File target = new File(upLoadPath, file.getOriginalFilename());
			if (file.getSize() > 0){
				try{
					file.transferTo(target);
				}catch(IOException e){}
				filename = file.getOriginalFilename();
				filesize = (int)file.getSize();
				dto.setFilename(filename);
				dto.setFilesize(filesize);
			}else{
				dto.setFilename("파일없음");
				dto.setFilesize(0);
			}
			
			
			
			
			int res=busStationMapper.updateBus_station(dto); 
			String msg = null, url = null;
			if (res > 0) {
				msg = "터미널수정 성공";
				url = "bus_station_list.do";
			} else {
				msg = "터미널수정 실패";
				url = "bus_station_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		
		//노선---------------------------------------------------------------
		@RequestMapping(value="/bus_road_list.do" )
		public ModelAndView bus_road_list(HttpServletRequest req) {
			//List<Member_BusRoadDTO> listBus_road=busRoadMapper.bus_road_member_list();//노선만든사람 한글로 표시위해 member 테이블 bus_road테이블 조인
			//page 나누기
			int pageSize=5;
			String pageNum=req.getParameter("pageNum");
			if(pageNum==null){
				pageNum="1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = currentPage * pageSize - (pageSize-1);
			int endRow = currentPage * pageSize;
			int count = 0;
			count=busRoadMapper.bus_road_member_count();
			if(endRow>count){
				endRow=count;
			}
			List<Member_BusRoadDTO> listBus_road = busRoadMapper.bus_road_member_list_count(startRow, endRow);//노선만든사람 한글로 표시위해 member 테이블 bus_road테이블 조인 후 행의 출력범위 지정
			int startNum = count-((currentPage-1)*pageSize);
			int pageCount = count/pageSize + (count%pageSize == 0 ? 0 : 1);
			int pageBlock = 5;
			int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;
			if (endPage>pageCount) endPage = pageCount;
			
			for(Member_BusRoadDTO mdto : listBus_road){ //출발지 도착지 한글로 표시하는 작업
				BusStationDTO to=busStationMapper.getBus_station(String.valueOf(mdto.getArrival()));
				mdto.setArrival(to.getStation_name());
				BusStationDTO to1=busStationMapper.getBus_station(String.valueOf(mdto.getDeparture()));
				mdto.setDeparture(to1.getStation_name());
				
			}
			
		
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_road/bus_road_list");
			mav.addObject("listBus_road",listBus_road);
			mav.addObject("count",count);
			mav.addObject("startNum",startNum);
			mav.addObject("pageCount",pageCount);
			mav.addObject("pageBlock",pageBlock);
			mav.addObject("startPage",startPage);
			mav.addObject("endPage",endPage);
		
			return mav;
		}
		@RequestMapping(value="/bus_road_insert.do",method = RequestMethod.GET)
		public ModelAndView bus_road_insert(HttpServletRequest req) {
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station(); //station_no 받아오기
			List<Bus_BusRoadDTO> bus_no_list = busRoadMapper.bus_no_list_null(); // 사용중인 bus_no 제외하고 출력
			
			
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("bus_no_list",bus_no_list);
			mav.addObject("bus_station_list",bus_station_list);
			mav.setViewName("bus_road/bus_road_insert");
			
			return mav;
		}
		@RequestMapping(value="/bus_road_insert.do",method = RequestMethod.POST)
		public String bus_road_insertOK(HttpServletRequest req, BusRoadDTO dto,@RequestParam String plus,@RequestParam int bus_no,@RequestParam int tot_time,@RequestParam String arrival,@RequestParam String departure)  {
			BusDTO bdto = busMapper.getBus(bus_no);
			
			
			HttpSession session = req.getSession();
			MemberDTO mdto = (MemberDTO)session.getAttribute("sedto");//로그인되어있는 회원 정보 불러오기
			
			
			dto.setArrival(String.valueOf(busStationMapper.getBus_number(arrival).getStation_no()));//int 형값 을 string 형으로 변경 작업(출발지 한글로 표시하기위해)
			dto.setDeparture(String.valueOf(busStationMapper.getBus_number(departure).getStation_no()));//int 형값 을 string 형으로 변경 작업(도착지 한글로 표시위해)
			dto.setMember_no(mdto.getMember_no());
			if(bdto.getGrade().equals("일반")){//일반버스일때 가격
				int price=5000;
				dto.setPrice(price*tot_time);
			}else if(bdto.getGrade().equals("우등")){//우등버스일때 가격
				int price=8000;
				dto.setPrice(price*tot_time);	
			}
			int res;
			if(plus.equals("plural")){//복수 노선 만들시
				int dip_time=Integer.parseInt(req.getParameter("dip_time"));//배차시간 가져오기 
				 res=busRoadMapper.insertBus_road(dto);//기본적으로 선택된 bus노선 만들어주기
				 int a_time=dto.getArr_time();
				 int bus_count=0; //버스갯수
				
				 for(int i=a_time; i<=22; i++){//필요한 버스 갯수 
					a_time=dto.getTot_time()+dip_time;
					 if(a_time>=22){//jsp페이지에 출발시간이 22시이후로는 설정못하게 되있어서 출발시간이 22시간 까지만 노선만들기위해
						 break;
					 }
					 bus_count++;

				 }
					 int count=busRoadMapper.bus_no_list_null_count();//사용중이지않은 버스 갯수
					 
					 if(count<bus_count){//버스갯수가 부족할떄(만들노선보다 노선에사용중인 버스가 많을떄)
						 //버스추가후 노선생성
						for(int j=0; j<bus_count; j++){
							 res=busMapper.insertBus_normal();//일반 버스 생성(버스가 노선갯수보다 하나더 만들어지게 설계됨)
							 Bus_BusRoadDTO bbdto1=busRoadMapper.bus_no_null_rownum();//bus_no 값 하나씩 출력하기 위해서
							 dto.setBus_no(bbdto1.getBus_no());//bus_no 값을 bbdto1 객체에서 받아와 하나씩 넣어줌
							 dto.setArr_time(dto.getArr_time()+dto.getTot_time()+dip_time);//출발시간 지속적으로 변경
							
							 if(dto.getArr_time()>22){
								 break;
							 }
							 res=busRoadMapper.insertBus_road(dto);

						 }
					 }else if(count>=bus_count){//버스갯수가 충분할때
						 for(int j=0; j<bus_count; j++){
							 Bus_BusRoadDTO bbdto2=busRoadMapper.bus_no_null_rownum();//bus_no 값 하나씩 출력하기 위해서
							 dto.setBus_no(bbdto2.getBus_no());
							 dto.setArr_time(dto.getArr_time()+dto.getTot_time()+dip_time);
							 if(dto.getArr_time()>22){
								 break;
							 }
							 res=busRoadMapper.insertBus_road(dto);
							
						 }
					 }
				 
			}else{
				 res=busRoadMapper.insertBus_road(dto);
			}
			String msg = null, url = null;
			if (res > 0) {
				msg = "노선등록 성공";
				url = "bus_road_list.do";
			} else {
				msg = "노선등록 실패";
				url = "bus_road_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping("bus_road_delete.do")
		public String bus_road_delete(HttpServletRequest req) {
			int res=busRoadMapper.deletetBus_road(Integer.parseInt(req.getParameter("no")));
			String msg = null, url = null;
			if (res > 0) {
				msg = "노선삭제 성공";
				url = "bus_road_list.do";
			} else {
				msg = "노선삭제 실패";
				url = "bus_road_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping(value="/bus_road_update.do",method = RequestMethod.GET)
		public ModelAndView bus_road_update(HttpServletRequest req) {
			BusRoadDTO dto = busRoadMapper.getBus_road(Integer.parseInt(req.getParameter("no")));//특정 bus_no 값을가지고 있는 항목 
			BusStationDTO arr_dto=busStationMapper.getBus_station(dto.getArrival());//넘어온 bus_no 값에대한 station 테이블에 station_no 값에 따른 station_name 찾기
			BusStationDTO dep_dto=busStationMapper.getBus_station(dto.getDeparture());//넘어온 bus_no 값에대한 station 테이블에 station_no 값에 따른 station_name 찾기
			dto.setArrival(arr_dto.getStation_name());//넘어온 bus_no 값을 출발지  숫자->한글
			dto.setDeparture(dep_dto.getStation_name());//넘어온 bus_no 에 대한 도착지 숫자->한글
			
			List<Bus_BusRoadDTO> bus_no_list = busRoadMapper.bus_no_list_null(); // 사용중인 bus_no 제외하고 출력
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station(); //station_no 받아오기
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_road/bus_road_update");
			mav.addObject("bus_road_getBoard",dto);
			mav.addObject("bus_no_list",bus_no_list);
			mav.addObject("bus_station_list",bus_station_list);
			mav.addObject("add_dto",arr_dto);//jsp 창에서 조건문 쓰기위해 저장
			mav.addObject("dep_dto",dep_dto);//jsp 창에서 조건문 쓰기위해 저장
			
			return mav;
		}
		@RequestMapping(value="/bus_road_update.do",method = RequestMethod.POST)
		public ModelAndView bus_road_updateOK(HttpServletRequest req, BusRoadDTO dto,@RequestParam String arrival,@RequestParam String departure)  {
			
			dto.setArrival(String.valueOf(busStationMapper.getBus_number(arrival).getStation_no()));
			dto.setDeparture(String.valueOf(busStationMapper.getBus_number(departure).getStation_no()));
			
			int res=busRoadMapper.updateBus_road(dto); 
			String msg = null, url = null;
			if (res > 0) {
				msg = "노선수정 성공";
				url = "bus_road_list.do";
			} else {
				msg = "노선수정 실패";
				url = "bus_road_list.do";
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("message");
			mav.addObject("msg",msg);
			mav.addObject("url",url);
			return mav;
		}
		//예약---------------------------------------------------------------
		@RequestMapping(value="/bus_resv_list.do" )
		public ModelAndView bus_resv_list() {
			List<BusResvDTO> list = busResvMapper.listBus_resv();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_resv/bus_resv_list");
			mav.addObject("list", list);
			return mav;
		}
		@RequestMapping(value="/bus_resv_insert.do",method = RequestMethod.GET)
		public String bus_resv_insert() {
			return "bus_resv/bus_resv_insert";
		}
		@RequestMapping(value="/bus_resv_insert.do",method = RequestMethod.POST)
		public String bus_resv_insertOK(HttpServletRequest req, BusResvDTO dto)  {
			int res=busResvMapper.insertBus_resv(dto);
			String msg = null, url = null;
			if (res > 0) {
				msg = "예약등록 성공";
				url = "bus_resv_list.do";
			} else {
				msg = "예약등록 실패";
				url = "bus_resv_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping("bus_resv_delete.do")
		public String bus_resv_delete(HttpServletRequest req) {
			int res=busResvMapper.deletetBus_resv(req.getParameter("no"));
			String msg = null, url = null;
			if (res > 0) {
				msg = "예약삭제 성공";
				url = "bus_resv_list.do";
			} else {
				msg = "예약삭제 실패";
				url = "bus_resv_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		@RequestMapping(value="/bus_resv_update.do",method = RequestMethod.GET)
		public ModelAndView bus_resv_update(HttpServletRequest req) {
			BusResvDTO dto = busResvMapper.getBus_resv(req.getParameter("no"));
			ModelAndView mav = new ModelAndView("bus_resv/bus_resv_update", "bus", dto);
			return mav;
		}
		@RequestMapping(value="/bus_resv_update.do",method = RequestMethod.POST)
		public String bus_resv_updateOK(HttpServletRequest req, BusResvDTO dto)  {
			int res=busResvMapper.updateBus_resv(dto); 
			String msg = null, url = null;
			if (res > 0) {
				msg = "예약수정 성공";
				url = "bus_resv_list.do";
			} else {
				msg = "예약수정 실패";
				url = "bus_resv_list.do";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message";
		}
		
		//버스 유저 페이지--------------------------------------------------
		
		//버스 터미널 정보
		
		@RequestMapping(value="/bus_station_info.do")
		public ModelAndView bus_station_info(){
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station();
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_station_user/bus_station_info");
			mav.addObject("bus_station_list",bus_station_list);
			
			return mav;
		}
		
		@RequestMapping(value="bus_station_info_detail.do") //버스정류소 디테일 페이지
		public ModelAndView bus_station_info_detail(@RequestParam String station_no){
			BusStationDTO dto =busStationMapper.getBus_station(station_no);
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("bus_station_user/bus_station_info_detail");
			mav.addObject("get_busstation",dto);
			
			return mav;
		}
		
		@RequestMapping(value="bus_station_info_map.do") //지도 확대 페이지
		public ModelAndView bus_station_info_map(){
			ModelAndView mav =new ModelAndView();
			
			mav.setViewName("bus_station_user/bus_station_info_map");
			
			return mav;
		}
		
		//버스 노선 조회 및 예약
		@RequestMapping(value="bus_user_resv_lookup.do") //버스 조회 및 예약 메인
		public ModelAndView bus_user_resv_list(){
			
			
			ModelAndView mav= new ModelAndView();
			mav.setViewName("bus_resv_user/bus_user_resv_lookup");
			
			return mav;
			
		}
		
		@RequestMapping(value="bus_resv_user_arrival.do", method=RequestMethod.GET) //출발지 선택 페이지
		public ModelAndView bus_resv_user_arrival(){
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station();
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_resv_user/bus_resv_user_arrival");
			mav.addObject("bus_station_list",bus_station_list);
			return mav;
		}
		@RequestMapping(value="bus_resv_user_arrival_select.do")//출발지 선택 하기
		public ModelAndView bus_resv_user_arrival_select(BusStationDTO dto,@RequestParam String arrival) {
		
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station();
		
			ModelAndView mav = new ModelAndView();
					if(arrival != null){
						dto =busStationMapper.getBus_station(arrival);
						mav.addObject("arr_dto",dto);
						mav.addObject("bus_station_list",bus_station_list);
						mav.setViewName("bus_resv_user/bus_resv_user_arrival");
						return mav;
					}
					else  {
						mav.setViewName("bus_resv_user_arrival.do");
						return mav;
					}	
				
				}
		@RequestMapping(value="bus_resv_user_arrival.do" ,method =RequestMethod.POST)//출발지 선택후 원래페이지
		public ModelAndView bus_Resv_user_arrivalOk(HttpServletRequest req,@RequestParam String arrival){
			ModelAndView mav = new ModelAndView();
			
			BusStationDTO dto = busStationMapper.getBus_station_name(arrival);
			HttpSession session=req.getSession();
			
			session.setAttribute("arrDTO", dto);
			BusStationDTO arr_no_dto =busStationMapper.getBus_number(arrival);
			session.setAttribute("arrnoDTO",arr_no_dto);
			
			if(session.getAttribute("depDTO")!=null){
				BusStationDTO depdto=(BusStationDTO) session.getAttribute("depDTO");
				mav.addObject("dep_dto",depdto);
				BusStationDTO dep_no_dto=(BusStationDTO) session.getAttribute("depnoDTO");
				mav.addObject("depnoDTO",dep_no_dto);
			}
			
			mav.addObject("arr_dto",dto);
			mav.setViewName("bus_resv_user/bus_user_resv_lookup");
			
			return mav;
		}
		
	
		
		@RequestMapping(value="bus_resv_user_departure.do",method=RequestMethod.GET)//도착지 페이지
		public ModelAndView bus_resv_user_departure_select() {
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station();
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_resv_user/bus_resv_user_departure");
			mav.addObject("bus_station_list",bus_station_list);
			return mav;
				
				}
		
		@RequestMapping(value="bus_resv_user_departure_select.do")//도착지 선택 하기
		public ModelAndView bus_resv_user_departure_select(BusStationDTO dto,@RequestParam String departure) {
		
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station();
			
			ModelAndView mav = new ModelAndView();
					if(departure != null){
						dto =busStationMapper.getBus_station(departure);
						mav.addObject("dep_dto",dto);
						mav.addObject("bus_station_list",bus_station_list);
						mav.setViewName("bus_resv_user/bus_resv_user_departure");
						return mav;
					}
					else  {
						mav.setViewName("bus_resv_user_departure.do");
						return mav;
					}	
					
				
				}
		
		@RequestMapping(value="bus_resv_user_departure.do",method=RequestMethod.POST)
		public ModelAndView bus_rsev_user_departureOk(HttpServletRequest req ,@RequestParam String departure){
			ModelAndView mav = new ModelAndView();
			BusStationDTO dto = busStationMapper.getBus_station_name(departure);
			HttpSession session=req.getSession();
			session.setAttribute("depDTO", dto);
			
			BusStationDTO dep_no_dto =busStationMapper.getBus_number(departure);
			session.setAttribute("depnoDTO",dep_no_dto);
			
			if(session.getAttribute("arrDTO")!=null){
				BusStationDTO arrdto=(BusStationDTO) session.getAttribute("arrDTO");
				mav.addObject("arr_dto",arrdto);
				BusStationDTO arr_no_dto=(BusStationDTO) session.getAttribute("arrnoDTO");
				mav.addObject("arrnoDTO",arr_no_dto);
			}
			
			mav.addObject("dep_dto",dto);
			mav.setViewName("bus_resv_user/bus_user_resv_lookup");
			
			return mav;
		}
				
		@RequestMapping(value="resv_user_arrival_find.do")//출발지 검색
		public ModelAndView bus_resv_arrival_find(@RequestParam String searchString){
			ModelAndView mav = new ModelAndView();
			
			List<BusStationDTO> list = busStationMapper.find_station(searchString);
			mav.addObject("find_station",list);
			mav.setViewName("/bus_resv_user/bus_resv_user_arrival");
			return mav;
		}
		@RequestMapping(value="resv_user_departure_find.do")//도착지 검색
		public ModelAndView bus_resv_departure_find(@RequestParam String searchString){
			ModelAndView mav= new ModelAndView();
			
			List<BusStationDTO> list = busStationMapper.find_station(searchString);
			mav.addObject("find_station",list);
			mav.setViewName("/bus_resv_user/bus_resv_user_departure");
			return mav;
		}
		
		//배차조회 list
		@RequestMapping(value="bus_resv_user_dispatch.do")
		public ModelAndView bus_user_dispatch(
				HttpServletRequest req,BusRoadDTO dto,@RequestParam String mode,@RequestParam int arrival,@RequestParam int departure,@RequestParam String grade,@RequestParam String one_date,@RequestParam String arr_date,@RequestParam String dep_date){
			ModelAndView mav = new ModelAndView();
			if(mode.equals("oneway")){//편도 선택 했을떄
				int pageSize=5;
				String pageNum=req.getParameter("pageNum");
				if(pageNum==null){
					pageNum="1";
				}
				int currentPage = Integer.parseInt(pageNum);
				int startRow = currentPage * pageSize - (pageSize-1);
				int endRow = currentPage * pageSize;
				int count = 0;
				count=busResvMapper.bus_busroad_resv_count(arrival,departure,grade);//bus테이블과 bus_road 테이블 조인 시 출발지,도착지,등급과 일치하는 행들 카운트
				if(endRow>count){
					endRow=count;
				}
				List<Bus_BusRoadDTO> dispatch_list=busResvMapper.listdispatch_resv_count(arrival,departure,grade,startRow,endRow);//출발지,도착지,버스등급에 맞는 리스트를 5개씩출력
				
				if(grade.equals("전체")){//grade 가 전체 일때
					currentPage = Integer.parseInt(pageNum);
					startRow = currentPage * pageSize - (pageSize-1);
					endRow = currentPage * pageSize;
					count = 0;
					dispatch_list=busResvMapper.listdispatch_resv_all_count(arrival, departure, startRow, endRow);//출발지,도착지 에 맞는 리스트를 5개씩 출력
					count=busResvMapper.bus_busroad_resv_all_count(arrival,departure);//bus테이블과 bus_road 테이블 조인 시 출발지,도착지와 일치하는 행들 카운트
						if(endRow>count){
							endRow=count;
						}
					}
				int startNum = count-((currentPage-1)*pageSize);
				int pageCount = count/pageSize + (count%pageSize == 0 ? 0 : 1);
				int pageBlock = 5;
				int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
				int endPage = startPage + pageBlock - 1;
				if (endPage>pageCount) endPage = pageCount;
				
			
				
			for(Bus_BusRoadDTO roadDTO : dispatch_list){//숫자화 된 출발지 도착지를 한글로 변환
				String arr=roadDTO.getArrival(); //숫자화된 출발지를 저장(dto arrival 이 string 으로 되어있음)
				BusStationDTO BDTO=busStationMapper.getBus_station(arr);//station_no 값을 이용해 해당하는 station_name 찾기
				roadDTO.setArrival(BDTO.getStation_name());//dto에 출발지 한글로저장
				String dep=roadDTO.getDeparture();
				BusStationDTO BDTO2=busStationMapper.getBus_station(dep);
				roadDTO.setDeparture(BDTO2.getStation_name());
			}
			mav.addObject("mode",mode);
			mav.addObject("arrival",arrival);//페이지이동을위해 넘겨줌
			mav.addObject("departure",departure);//페이지이동을위해 넘겨줌
			mav.addObject("grade",grade);//페이지이동을위해 넘겨줌
			mav.addObject("one_date",one_date);
			mav.addObject("dispatch_list",dispatch_list);
			mav.addObject("count",count);
			mav.addObject("startNum",startNum);
			mav.addObject("pageCount",pageCount);
			mav.addObject("pageBlock",pageBlock);
			mav.addObject("startPage",startPage);
			mav.addObject("endPage",endPage);
			mav.setViewName("/bus_resv_user/bus_resv_user_dispatch");
		
			}
				if(mode.equals("twoway")){
					List<Bus_BusRoadDTO> arr_dispatch_list=busResvMapper.listdispatch_resv(arrival, departure, grade);
					List<Bus_BusRoadDTO> dep_dispatch_list=busResvMapper.listDispatch_resv_reverse(arrival, departure, grade);
					if(grade.equals("전체")){//grade 가 전체 일
						arr_dispatch_list=busResvMapper.listDispatch_resv_all(arrival, departure);
						dep_dispatch_list=busResvMapper.listDispatch_resv_all_reverse(arrival, departure);
						}
					
					for(Bus_BusRoadDTO arrDTO : arr_dispatch_list){
						String arr=arrDTO.getArrival();
						BusStationDTO BDTO=busStationMapper.getBus_station(arr);
						arrDTO.setArrival(BDTO.getStation_name());
						String dep=arrDTO.getDeparture();
						BusStationDTO BDTO2=busStationMapper.getBus_station(dep);
						arrDTO.setDeparture(BDTO2.getStation_name());
					}
					for(Bus_BusRoadDTO depDTO : dep_dispatch_list){
						String arr=depDTO.getArrival();
						BusStationDTO BDTO=busStationMapper.getBus_station(arr);
						depDTO.setArrival(BDTO.getStation_name());
						String dep=depDTO.getDeparture();
						BusStationDTO BDTO2=busStationMapper.getBus_station(dep);
						depDTO.setDeparture(BDTO2.getStation_name());
					}
					mav.addObject("arr_date",arr_date);
					mav.addObject("dep_date",dep_date);
					mav.addObject("mode",mode);
					mav.addObject("arr_dispatch_list",arr_dispatch_list);
					mav.addObject("dep_dispatch_list",dep_dispatch_list);
					mav.setViewName("/bus_resv_user/bus_resv_user_dispatch");
					
				}
				return mav;
		}
		
		//좌석 선택
		@RequestMapping(value="bus_resv_user_seat.do")
		public  ModelAndView bus_resv_user_seat(HttpServletRequest req,Bus_BusRoadDTO dto,@RequestParam String one_date,@RequestParam int road_no,@RequestParam String arrival,@RequestParam String departure){
			ModelAndView mav = new ModelAndView();
			Bus_BusRoadDTO seat_dto= busResvMapper.resv_user_seat_select(road_no);
			List<BusResvDTO> resv_list=busResvMapper.list_seat_resv_user(one_date,road_no);//예약된 좌석 체크위한 리스트
			String seats="";
			if(resv_list !=null){
			for(BusResvDTO rdto:resv_list){
				seats +=rdto.getSeat()+"/";
				
				}
			}else{
				seats="0";
			}
			dto.setArrival(arrival);
			dto.setDeparture(departure);
			
			 mav.addObject("seat_dto",seat_dto);//자리
	         mav.addObject("one_date",one_date);
	         mav.addObject("dto",dto);
	         mav.addObject("resv",seats);//예약
	
	         mav.setViewName("bus_resv_user/bus_resv_user_seat");
			return mav;
		}
		
		//결제 페이지
		@RequestMapping(value="bus_resv_user_pay.do")
		public ModelAndView bus_resv_user_pay(HttpServletRequest req,Bus_BusRoadDTO dto,@RequestParam String one_date,@RequestParam int road_no,@RequestParam String arrival,@RequestParam String departure){
			ModelAndView mav = new ModelAndView();
			Bus_BusRoadDTO resv_dto= busResvMapper.resv_user_seat_select(road_no);
			dto.setArrival(arrival);
			dto.setDeparture(departure);
			
			String[] seat = req.getParameterValues("seat");//좌석수 배열에 저장
		
			int seat_no=seat.length;//좌석수 저장,티켓총가격 구하기위해
			
			mav.addObject("resv_dto",resv_dto);
			mav.addObject("one_date",one_date);
			mav.addObject("seat_no",seat_no);
			mav.addObject("seat",seat);
			mav.addObject("seatlist",seat);
			mav.addObject("dto",dto);
			mav.setViewName("bus_resv_user/bus_resv_user_pay");
			return mav;
		}
		
		//결제완료 (bus_resv 테이블에 저장)
		@RequestMapping(value="bus_resv_user_payok.do")
		public ModelAndView bus_resv_user_payok(BusResvDTO dto,HttpServletRequest req,@RequestParam String one_date,@RequestParam int road_no,@RequestParam int use_point,@RequestParam int save_point,@RequestParam int price){
			ModelAndView mav=new ModelAndView();
			Bus_BusRoadDTO rdto=busResvMapper.resv_user_seat_select(road_no);
			HttpSession session = req.getSession();
			MemberDTO mdto = (MemberDTO)session.getAttribute("sedto");//로그인되어있는 회원 정보 불러오기
			String[] seat = req.getParameterValues("seat");//좌석수 배열에 저장
			String[] seats=new String[seat.length];//좌석수를 for문 돌릴 setter 메소드 저장 용도
			int seat_no=seat.length;//좌석수 저장,티켓총가격 구하기위해
			
			//좌석번호 구하기
			for(int i=0; i<seat.length; i++){
				dto.setSeat(seat[i]);
				seats[i]=dto.getSeat();
			}
			String result_seat = String.join("/",seats); //seats 배열의 자리 번호를 '/' 기준으로 나누어서 저장
			
			
			int res=0;
			if(use_point ==0){ // 포인트를 사용하지 않았을떄
				dto.setUse_point(0);
				dto.setSave_point(save_point);
				dto.setPrice(price);
				mdto.setPoint(mdto.getPoint()+dto.getSave_point());
				res=memberMapper.Member_buspoint_update(mdto); //포인트 사용내역 meber 테이블에 업데이트
			}else{ //포인트를 사용했을떄(포인트적립x)
				dto.setUse_point(use_point);
				dto.setSave_point(0);
				dto.setPrice(price-dto.getUse_point());
				mdto.setPoint(mdto.getPoint()-dto.getUse_point());
				res=memberMapper.Member_buspoint_update(mdto);//포인트 사용내역 meber 테이블에 업데이트
			}
			
			dto.setBus_no(rdto.getBus_no());
			dto.setResv_date(one_date);
			dto.setRoad_no(road_no);
			dto.setSeat(result_seat);
			dto.setMember_no(mdto.getMember_no());
			
			res =busResvMapper.insertBus_resv_user(dto);
			
			mav.setViewName("bus_resv_user/bus_resv_user_payok");
			mav.addObject("rdto",rdto);
			mav.addObject("seat_no",seat_no);
			mav.addObject("use_point",use_point);
			return mav;
		}
		
	}
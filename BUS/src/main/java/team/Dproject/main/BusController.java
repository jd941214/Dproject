package team.Dproject.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import team.Dproject.main.service.BusMapper;
import team.Dproject.main.service.BusResvMapper;
import team.Dproject.main.service.BusRoadMapper;
import team.Dproject.main.service.BusStaionMapper;

@Controller
public class BusController {
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
	
	@RequestMapping(value = "/bus_main.do")
	public String busMain(){
		
		return "bus_main";
	
	}
	//버스관련---------------------------------------------------------------
		
		
		//버스---------------------------------------------------------------
		@RequestMapping(value="/bus_list.do" )
		public ModelAndView bus_list() {
			List<BusDTO> list = busMapper.listBus();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus/bus_list");
			mav.addObject("bus_list", list);
			return mav;
		}
		@RequestMapping(value="/bus_insert.do",method = RequestMethod.GET)
		public String bus_insert() {
			return "bus/bus_insert";
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
			}
			dto.setFilename(filename);
			dto.setFilesize(filesize);
			
			
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
		public ModelAndView bus_road_list() {
			List<BusRoadDTO> list = busRoadMapper.listBus_road();
			for(BusRoadDTO dto : list){
				BusStationDTO to=busStationMapper.getBus_station(String.valueOf((dto.getArrival())));
				dto.setArrival(to.getStation_name());
				BusStationDTO to1=busStationMapper.getBus_station(String.valueOf((dto.getDeparture())));
				dto.setDeparture((to1.getStation_name()));
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_road/bus_road_list");
			mav.addObject("listBus_road", list);
			return mav;
		}
		@RequestMapping(value="/bus_road_insert.do",method = RequestMethod.GET)
		public ModelAndView bus_road_insert(HttpServletRequest req) {
			List<BusDTO> bus_list = busMapper.listBus(); //bus_no 받아오기
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station(); //station_no 받아오기
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_road/bus_road_insert");
			mav.addObject("bus_list",bus_list);
			mav.addObject("bus_station_list",bus_station_list);
		
			return mav;
		}
		@RequestMapping(value="/bus_road_insert.do",method = RequestMethod.POST)
		public String bus_road_insertOK(HttpServletRequest req, BusRoadDTO dto,@RequestParam String arrival,@RequestParam String departure)  {
			
			dto.setArrival(String.valueOf(busStationMapper.getBus_number(arrival).getStation_no()));
			dto.setDeparture(String.valueOf(busStationMapper.getBus_number(departure).getStation_no()));
			int res=busRoadMapper.insertBus_road(dto);
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
			BusRoadDTO dto = busRoadMapper.getBus_road(Integer.parseInt(req.getParameter("no")));
	
			List<BusDTO> bus_list = busMapper.listBus(); //bus_no 받아오기
			List<BusStationDTO> bus_station_list = busStationMapper.listBus_station(); //station_no 받아오기
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bus_road/bus_road_update");
			mav.addObject("bus_road_getBoard",dto);
			
			mav.addObject("bus_list",bus_list);
			mav.addObject("bus_station_list",bus_station_list);
			
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
				BusRoadDTO dto,@RequestParam String mode,@RequestParam int arrival,@RequestParam int departure,@RequestParam String grade,@RequestParam String one_date,@RequestParam String arr_date,@RequestParam String dep_date){
			ModelAndView mav = new ModelAndView();
				if(mode.equals("oneway")){
					List<Bus_BusRoadDTO> dispatch_list=busResvMapper.listdispatch_resv(arrival,departure,grade);
					
					if(grade.equals("전체")){//grade 가 전체 일떄
					dispatch_list=busResvMapper.listDispatch_resv_all(arrival, departure);
					}
					
				for(Bus_BusRoadDTO roadDTO : dispatch_list){
					String arr=roadDTO.getArrival();
					BusStationDTO BDTO=busStationMapper.getBus_station(arr);
					roadDTO.setArrival(BDTO.getStation_name());
					String dep=roadDTO.getDeparture();
					BusStationDTO BDTO2=busStationMapper.getBus_station(dep);
					roadDTO.setDeparture(BDTO2.getStation_name());
				}
				mav.addObject("one_date",one_date);
				mav.addObject("mode",mode);
				mav.addObject("dispatch_list",dispatch_list);
				mav.setViewName("/bus_resv_user/bus_resv_user_dispatch");
			
				}
				if(mode.equals("twoway")){
					List<Bus_BusRoadDTO> arr_dispatch_list=busResvMapper.listdispatch_resv(arrival, departure, grade);
					List<Bus_BusRoadDTO> dep_dispatch_list=busResvMapper.listDispatch_resv_reverse(arrival, departure, grade);
					if(grade.equals("전체")){//grade 가 전체 일떄
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
		public  ModelAndView bus_resv_user_seat(Bus_BusRoadDTO dto,@RequestParam String one_date,@RequestParam int road_no,@RequestParam String arrival,@RequestParam String departure){
			ModelAndView mav = new ModelAndView();
			Bus_BusRoadDTO seat_dto= busResvMapper.resv_user_seat_select(road_no);
			dto.setArrival(arrival);
			dto.setDeparture(departure);
			
			mav.addObject("seat_dto",seat_dto);
			mav.addObject("one_date",one_date);
			mav.addObject("dto",dto);
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
			for(String seats : seat){ //좌석숫 자 구하기
				
			}
			int seat_no=seat.length;//좌석수 저장
			mav.addObject("resv_dto",resv_dto);
			mav.addObject("one_date",one_date);
			mav.addObject("seat_no",seat_no);
			mav.addObject("dto",dto);
			mav.setViewName("bus_resv_user/bus_resv_user_pay");
			return mav;
		}
		
	}
			
	
	


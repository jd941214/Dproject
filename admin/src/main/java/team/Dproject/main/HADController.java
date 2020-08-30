package team.Dproject.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import team.Dproject.main.model.MemberDTO;
import team.Dproject.main.model.hotelDTO;
import team.Dproject.main.model.resvDTO;
import team.Dproject.main.model.roomDTO;
import team.Dproject.main.service.HotelMapper;
import team.Dproject.main.service.MemberMapper;
import team.Dproject.main.service.ResvMapper;
import team.Dproject.main.service.RoomMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HADController {

	@Autowired
	private HotelMapper hotelMapper;
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private ResvMapper resvMapper;
	@Autowired
	private MemberMapper memberMapper;

	private int memNUM;

	@Resource(name = "upLoadPath")
	private String upLoadPath;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping("/ADhotelAD.do")
	public String busAD() {
		return "hotelAD/HAD_main";
	}

	@RequestMapping("/ADhotel_list.do")
	public ModelAndView hotel_list(HttpServletRequest req) {
		List<hotelDTO> list = hotelMapper.listHotel(req.getParameter("member_num"));
		ModelAndView mav = new ModelAndView();
		memNUM = Integer.parseInt(req.getParameter("member_num"));
		mav.setViewName("hotelAD/hotel/hotel_list");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/ADhotel_insert.do", method = RequestMethod.GET)
	public String hotel_insert() {
		return "hotelAD/hotel/hotel_insert";
	}

	@RequestMapping(value = "/ADhotel_insert.do", method = RequestMethod.POST)
	public String hotel_insertOK(HttpServletRequest req, @ModelAttribute hotelDTO dto, BindingResult result) {
		String filename = "";
		int filesize = 0;
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		MultipartFile file = mr.getFile("filename");
		File target = new File(upLoadPath, file.getOriginalFilename());
		if (file.getSize() > 0) {
			try {
				file.transferTo(target);
			} catch (IOException e) {
			}
			filename = file.getOriginalFilename();
			filesize = (int) file.getSize();
		}
		dto.setFilename(filename);
		dto.setFilesize(filesize);

		int res = hotelMapper.insertHotel(dto);
		String msg = null, url = null;
		if (res > 0) {
			msg = "호텔추가 성공";
			url = "ADhotel_list.do" + "?member_num=" + memNUM;
		} else {
			msg = "호텔추가 실패";
			url = "ADhotel_list.do" + "?member_num=" + memNUM;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}

	@RequestMapping("ADhotel_delete.do")
	public String bus_delete(HttpServletRequest req) {
		int res = hotelMapper.deletetHotel(req.getParameter("hnum"));
		String msg = null, url = null;
		if (res > 0) {
			msg = "호텔삭제 성공";
			url = "ADhotel_list.do" + "?member_num=" + memNUM;
		} else {
			msg = "호텔삭제 실패";
			url = "ADhotel_list.do" + "?member_num=" + memNUM;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}

	@RequestMapping(value = "/ADhotel_update.do", method = RequestMethod.GET)
	public ModelAndView bus_update(HttpServletRequest req) {
		hotelDTO dto = hotelMapper.getHotel(req.getParameter("hnum"));
		ModelAndView mav = new ModelAndView("hotelAD/hotel/hotel_update", "dto", dto);
		return mav;
	}

	@RequestMapping(value = "/ADhotel_update.do", method = RequestMethod.POST)
	public String bus_updateOK(HttpServletRequest req, @ModelAttribute hotelDTO dto, BindingResult result) {
		String filename = "";
		int filesize = 0;
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		MultipartFile file = mr.getFile("filename");
		File target = new File(upLoadPath, file.getOriginalFilename());
		if (file.getSize() > 0) {
			try {
				file.transferTo(target);
			} catch (IOException e) {
			}
			filename = file.getOriginalFilename();
			filesize = (int) file.getSize();
		}
		dto.setFilename(filename);
		dto.setFilesize(filesize);

		int res = hotelMapper.updateHotel(dto);
		return "redirect:ADhotel_list.do" + "?member_num=" + memNUM;
	}

	// --------------------------------------------------------------------------
	// -----------------------방관련----------------------------------------
	// --------------------------------------------------------------------------

	private String hnum;

	@RequestMapping("/ADroom_list.do")
	public ModelAndView room_list(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (req.getParameter("hnum") != null) {
			hnum = req.getParameter("hnum");
			session.setAttribute("hnum", req.getParameter("hnum"));
		}
		hnum = (String) session.getAttribute("hnum");
		List<roomDTO> list = roomMapper.listRoom(Integer.parseInt(hnum));

		mav.setViewName("hotelAD/room/room_list");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/ADroom_insert.do", method = RequestMethod.GET)
	public String room_insert() {
		return "hotelAD/room/room_insert";
	}

	@RequestMapping(value = "/ADroom_insert.do", method = RequestMethod.POST)
	public String room_insertOK(MultipartHttpServletRequest mtfRequest, HttpSession session, @ModelAttribute roomDTO dto) {
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		String hnum = (String) session.getAttribute("hnum");
		dto.setHotel_no(Integer.parseInt(hnum));
		roomMapper.seqUP();
		String seq = String.valueOf(roomMapper.seqGET());

		String filename = "";
		int filesize = 0; 	
		for (MultipartFile mf : fileList) {
			String tempname = mf.getOriginalFilename();
			long tempsize = mf.getSize(); 	
			try {
				mf.transferTo(new File(upLoadPath, mf.getOriginalFilename()));
				filename+=tempname+"/";
				filesize+=tempsize;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 1; i <= dto.getRooms(); i++) {
			dto.setFilename(filename);
			dto.setFilesize(filesize);
			dto.setRoom_no(seq + "-" + i);
			dto.setHotel_no(Integer.parseInt(hnum));
			int res = roomMapper.insertRoom(dto);
		}
		return "redirect:ADroom_list.do?hnum=" + hnum;
	}

	@RequestMapping("ADroom_delete.do")
	public String room_delete(HttpServletRequest req) {
		int res = roomMapper.deletetRoom(req.getParameter("no"));
		String msg = null, url = null;
		if (res > 0) {
			msg = "호텔삭제 성공";
			url = "ADroom_list.do";
		} else {
			msg = "호텔삭제 실패";
			url = "ADroom_list.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}

	@RequestMapping("ADroom_alldelete.do")
	public String room_alldelete(HttpServletRequest req) {
		int res = roomMapper.deletetallRoom(req.getParameter("no")+"%");
		String msg = null, url = null;
		if (res > 0) {
			msg = "호텔삭제 성공";
			url = "ADroom_list.do";
		} else {
			msg = "호텔삭제 실패";
			url = "ADroom_list.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}

	@RequestMapping(value = "/ADroom_update.do", method = RequestMethod.GET)
	public ModelAndView room_update(HttpServletRequest req) {
		roomDTO dto = roomMapper.getRoom(req.getParameter("no"));
		ModelAndView mav = new ModelAndView("hotelAD/room/room_update", "dto", dto);
		return mav;
	}

	@RequestMapping(value = "/ADroom_update.do", method = RequestMethod.POST)
	public String room_updateOK(MultipartHttpServletRequest mtfRequest, HttpSession session,
			@ModelAttribute roomDTO dto) {
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		String hnum = (String) session.getAttribute("hnum");
		roomMapper.seqUP();
		String seq = String.valueOf(roomMapper.seqGET());

		String filename = "";
		int filesize = 0;
		for (MultipartFile mf : fileList) {
			String tempname = mf.getOriginalFilename();
			long tempsize = mf.getSize();
			try {
				mf.transferTo(new File(upLoadPath, mf.getOriginalFilename()));
				filename += tempname + "/";
				filesize += tempsize;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		dto.setFilename(filename);
		dto.setFilesize(filesize);
		int res = roomMapper.updateRoom(dto);

		return "redirect:ADroom_list.do";
	}
	
	@RequestMapping(value = "/ADroom_show.do", method = RequestMethod.GET)
	public ModelAndView room_show(HttpServletRequest req) {
		roomDTO dto = roomMapper.getRoom(req.getParameter("no"));
		ModelAndView mav = new ModelAndView("hotelAD/room/room_show", "dto", dto);
		return mav;
	}

	// --------------------------------------------------------------------------
	// -----------------------예약--------------------------------
	// --------------------------------------------------------------------------

	@RequestMapping("/ADresv_list.do")
	public ModelAndView resv_list(HttpServletRequest req) {

		ModelAndView mav = new ModelAndView();
		if (req.getParameter("hnum") != null) {
			hnum = req.getParameter("hnum");
		}

		List<resvDTO> resvlist = resvMapper.listResv(Integer.parseInt(hnum));
		List<roomDTO> roomlist = roomMapper.listRoom(Integer.parseInt(hnum));
		List<resvDTO> list = new ArrayList<resvDTO>();
		for (resvDTO dto : resvlist) {
			int resv = Integer.parseInt(dto.getStart_resv_date());
			int a = Integer.parseInt(dto.getEnd_resv_date());
			for (int i = 0; i < a - 1; i++) {
				resvDTO Tdto = new resvDTO();
				Tdto.setEnd_resv_date(dto.getEnd_resv_date());
				Tdto.setHotel_no(dto.getHotel_no());
				Tdto.setHotel_resv_no(dto.getHotel_resv_no());
				Tdto.setMember_no(dto.getMember_no());
				Tdto.setRoom_no(dto.getRoom_no());
				Tdto.setSave_point(dto.getSave_point());
				Tdto.setUse_point(dto.getUse_point());

				Tdto.setStart_resv_date(resv_petch(resv, i));
				list.add(Tdto);
			}
		}

		for (resvDTO dto : list) {
			resvlist.add(dto);
		}

		mav.setViewName("hotelAD/hotel_resv/resv_list");

		if (roomlist != null) {
			mav.addObject("resvlist", resvlist);
			mav.addObject("roomlist", roomlist);
			mav.addObject("hnum", hnum);
		}
		return mav;
	}

	public String resv_petch(int resv, int i) {
		Calendar cal = Calendar.getInstance();
		String re;
		int month = resv % 10000;
		int year = cal.get(Calendar.YEAR);
		month /= 100;
		cal.set(year, month - 1, 1);
		int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

		int sum = resv + i;
		sum %= 100;
		if (sum > endDay) {
			re = "2020";
			int re1 = month + 1;
			if (re1 > 9)
				re += "1";
			else
				re += "0";
			sum -= endDay;
			sum += re1 * 100;
			re += sum;
		} else {
			int temp = resv + i;
			re = String.valueOf(temp);
		}
		return re;
	}

	@RequestMapping("/ADresv_show.do")
	public ModelAndView resv_show(HttpServletRequest req) {

		ModelAndView mav = new ModelAndView();
		resvDTO dto = resvMapper.getResv(req.getParameter("hotel_resv_no"));
		int HNO = dto.getHotel_no();
		int MNO = dto.getMember_no();
		String RNO = dto.getRoom_no();

		MemberDTO MDTO = memberMapper.getMember2(String.valueOf(MNO));
		hotelDTO HDTO = hotelMapper.getHotel(String.valueOf(HNO));
		roomDTO RDTO = roomMapper.getRoom(RNO);

		mav.setViewName("hotelAD/hotel_resv/resv_show");
		mav.addObject("dto", dto);
		mav.addObject("MDTO", MDTO);
		mav.addObject("HDTO", HDTO);
		mav.addObject("RDTO", RDTO);

		return mav;
	}
}

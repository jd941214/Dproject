package team.Dproject.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
 
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.Dproject.main.model.MainBoardDTO;
import team.Dproject.main.service.BoardMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardMapper boardMapper;
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
		
		return "index";
	}
	
	@RequestMapping(value="/board_list.do")
	public String listBoard(HttpServletRequest req) {
		List<MainBoardDTO> list = boardMapper.listBoard();
		req.setAttribute("listBoard", list);
		return "list";
	}
	
	@RequestMapping(value="/board_wirte.do", method=RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
//	@RequestMapping(value="/board_wirte.do", method=RequestMethod.POST)
//	public String insertBoard(HttpServletRequest req, MainBoardDTO dto) {
//		dto.setIp(req.getRemoteAddr());
//		return "";
//		
//	}
	
}

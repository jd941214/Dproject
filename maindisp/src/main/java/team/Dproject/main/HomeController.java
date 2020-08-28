package team.Dproject.main;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.Dproject.main.model.BoardDTO;
import team.Dproject.main.service.BoardMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardMapper boardMapper;

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	@RequestMapping(value = "/index")
	public String home2() {
		return "index";
	}
	
	@RequestMapping(value="/board_list.do")
	public String listBoard(HttpServletRequest req) {
		List<BoardDTO> list = boardMapper.board_list();
		req.setAttribute("listBoard", list);
		return "list";

	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String writeForm() {
		return "writeform";
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.POST)
	public String insertBoard(HttpServletRequest req, BoardDTO dto) {
		dto.setIp(req.getRemoteAddr());
		int res = boardMapper.board_insert(dto);
		String msg = null, url = null;
		if(res>0) {
			msg = "새 글 작성이 완료되었습니다. 게시글 목록으로 이동합니다.";
			url = "board_list.do";
		}else {
			msg = "새 글 작성이 완료되지 않았습니다. 다시 작성해주세요.";
			url = "board_list.do";
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
	
}

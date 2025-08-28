package com.kkuk.board.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkuk.board.dao.BoardDao;

@Controller
public class BoardContorller {

	
	
	@RequestMapping(value = "/write_form") // 글쓰기 양식을 출력하는 요청
	public String write_form() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/write") // 유저가 쓴 글을 DB에 삽입하는 요청
	public String write(HttpServletRequest request, Model model) {
		
		BoardDao boardDao = new BoardDao();
		boardDao.write(request.getParameter("bname"), request.getParameter("btitle"), request.getParameter("bcontent"));
		
		
		return "direct:boardlist";
	}
}

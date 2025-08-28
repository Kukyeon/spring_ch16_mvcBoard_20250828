package com.kkuk.board.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkuk.board.command.BCommand;
import com.kkuk.board.command.BContentView;
import com.kkuk.board.command.BListCommand;
import com.kkuk.board.command.BWriteCommand;
import com.kkuk.board.dao.BoardDao;
import com.kkuk.board.dto.BoardDto;

@Controller
public class BoardContorller {

	BCommand command = null;
	
	@RequestMapping(value = "/write_form") // 글쓰기 양식을 출력하는 요청
	public String write_form() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/write") // 유저가 쓴 글을 DB에 삽입하는 요청
	public String write(HttpServletRequest request, Model model) {
//		BoardDao boardDao = new BoardDao();
//		boardDao.write(request.getParameter("bname"), request.getParameter("btitle"), request.getParameter("bcontent"));
		command = new BWriteCommand();
		command.execute(model, request);
		
		return "redirect:boardlist";
	}
	
	@RequestMapping(value = "/boardlist") // 글 목록보기 요청처리
	public String boardlist(HttpServletRequest request, Model model) { 		
//		BoardDao boardDao = new BoardDao();
//		List<BoardDto> bDtos = boardDao.boardlist();
//		model.addAttribute("bDtos", bDtos);
		
		// command 사용하여 코드 줄이기
		command = new BListCommand();
		command.execute(model, request);
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/content_view") // 게시판 글 목록에서 보고싶은 글 클릭시 요청처리
	public String content_view(HttpServletRequest request, Model model) {
		
//		String bnum = request.getParameter("bnum"); // 유저가 클릭한 글의 번호
//		BoardDao boardDao = new BoardDao();
//		BoardDto bDto = boardDao.contentview(bnum);
//		model.addAttribute("bDto", bDto);
		
		command = new BContentView();
		command.execute(model, request);
		
		return "contentview";
	}
}

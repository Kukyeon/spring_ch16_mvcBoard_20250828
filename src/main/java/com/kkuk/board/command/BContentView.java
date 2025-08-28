package com.kkuk.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kkuk.board.dao.BoardDao;
import com.kkuk.board.dto.BoardDto;

public class BContentView implements BCommand {

	@Override
	public void execute(Model model, HttpServletRequest request) {
		
		String bnum = request.getParameter("bnum"); // 유저가 클릭한 글의 번호
		BoardDao boardDao = new BoardDao();
		BoardDto bDto = boardDao.contentview(bnum);
		
		model.addAttribute("bDto", bDto);

	}

}

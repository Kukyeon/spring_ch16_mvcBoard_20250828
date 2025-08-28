package com.kkuk.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kkuk.board.dao.BoardDao;
import com.kkuk.board.dto.BoardDto;

public class BListCommand implements BCommand{

	public void execute(Model model, HttpServletRequest request) {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> bDtos = boardDao.boardlist();
		model.addAttribute("bDtos", bDtos);
	}
	
	
}

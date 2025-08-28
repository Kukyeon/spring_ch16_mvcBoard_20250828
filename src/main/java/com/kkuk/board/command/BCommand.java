package com.kkuk.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BCommand {

	public void execute(Model model, HttpServletRequest request);
}

package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.BoardVO;

@WebServlet("/v2/boardDetail")
public class SerBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Integer.parseInt(request.getParameter("i_board"));

		BoardDAO2 dao = BoardDAO2.getInstatance();
		BoardDTO dto = dao.selBoard(i_board);
		
		request.setAttribute("item", dto);
		
		Utils.forward("boardRead", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

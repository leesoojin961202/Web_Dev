package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v2/SerBoardMod")
public class SerBoardMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int i_board = Utils.getIntParam(request, "i_board");
//		if(i_board == 0) {
//			response.sendRedirect("/v2/SerBoardList");
//		}
//		System.out.println(i_board);
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		BoardDAO2 dao = BoardDAO2.getInstatance();
		BoardDTO dto = dao.selBoard(i_board);
		
		request.setAttribute("item", dto);
		
		Utils.forward("boardMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String r_dt = request.getParameter("r_dt");
		
		BoardDTO dto = new BoardDTO();
		dto.setI_board(i_board);
		dto.setTitle(title);
		dto.setCtnt(ctnt);
		dto.setR_dt(r_dt);
		
		BoardDAO2 dao = BoardDAO2.getInstatance();
		dao.upBoard(dto);
		
		response.sendRedirect("/v2/boardDetail?i_board="+i_board);
	}

}

package kh.test.jdbckh.board.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.board.model.dto.BoardDto;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert doGet()");
		
		//답글작성시 참조글번호
		String bnoStr = request.getParameter("bno");
		request.setAttribute("bno", bnoStr);
		request.getRequestDispatcher("/WEB-INF/view/board/insert.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("/board/insert POST!!!!!");
			String btitle = request.getParameter("btitle");
			String bcontent = request.getParameter("bcontent");
			String mid = "biz1"; //TODO :임시작성자 - 로그인한 ID 로 변경
			
			
			
			int result = service.insert(new BoardDto(btitle, bcontent, mid));
			
			response.sendRedirect(request.getContextPath()+"/board/list");
	}

}

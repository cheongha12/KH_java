package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/student/list")
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/student/list doGet() 진입" );
		//1.전달받은 parameter  읽어내기
		String searchWord= request.getParameter("searchWord");
		
		StudentDao dao = new StudentDao();
		List<StudentVo> result = null;
		if(searchWord != null) {
		//	System.out.println("[ejkim]:"+searchWord);
			result = dao.selectListStudent(searchWord);
		}else {
			result = dao.selectListStudent();
		}
//		List<StudentVo> result = dao.selectListStudent();
		//3. DB로부터 전달받은 데이터를 JSP에 전달함
		request.setAttribute("studentList", result);
		if(searchWord != null) {
			request.setAttribute(searchWord, searchWord);
		}
		request.setAttribute("aaa", "그냥속성값테스트해봄");
		request.setAttribute("bbb", "그냥속성값테스트해봄");
		request.setAttribute("ccc", 333);
		//4. JSP 파일 forward로 열기
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

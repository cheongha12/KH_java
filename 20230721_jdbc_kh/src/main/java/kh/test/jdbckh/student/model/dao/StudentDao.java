package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao {

//	DB에서 tb_student 테이블의 전달받은 학번을 통해 학생1명의 상세정보를 읽어옴
	public StudentVo selectOneStudent(String studentNo) {
		System.out.println("DAO selectOneStudent() arg:" + studentNo);

		StudentVo result = null;
		String query = "select * from tb_student join tb_department using (department_No) where student_no = " + "'"
				+ studentNo + "'";

//		db연결 작성사용하던 클래스이름 다 작성하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 외워
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
//				if(conn == null) {
//					System.out.println("연결실패");
//				}else {
//					System.out.println("연결 성공");
//				}
			pstmt = conn.prepareStatement(query);
			// pstmt 생된 후 execute실행 전

			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new StudentVo();
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getDate("Entrance_Date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("Student_Name"));
				result.setStudentNo(rset.getString("Student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setDepartmentName(rset.getString("Department_Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
//		System.out.println(result);
		return result;
	}

	// DB에서 tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent() {	//페이징 처리
		List<StudentVo> result = null;
		Connection conn = null;
		Statement stmt = null; // 부모
		PreparedStatement pstmt = null; // 자식 (PreparedStatement을 더 많이 씀)
		try {
			// 1. driver 있다면 로딩함.// 없다면 ClassNotFoundException e 오류발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성 (dbms와 연결)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "KH", "kh");

			if (conn != null) {
				System.out.println("DB연결 성공!!!!!!!!");
			} else {
				System.out.println("-----DB연결 실패-----");
			}
//			3. Statement /PrepareStatement 객체 생성 -conn 객체로부터 -query 문을 실어보냄
//			 stmt = conn.createStatement();
			String query = "select *from tb_student";
			pstmt = conn.prepareStatement(query);
//			 4. query 문을 실행해달라고 함. - 그 결과값을 return 받음
//			 select query 문이면 ResultSet 모양
//			 insert/update/delete 문이면 int 모양
			ResultSet rs = pstmt.executeQuery();

			// 5. ResultSet 에서 row(record) =한줄 읽어오기 위해 cursor(포인트)를 이동함.

			if (rs.next()) {
				result = new ArrayList<StudentVo>();
				do {
					// 한줄 row / record 를 읽을 준비 완료
					// System.out.println(rs.getString("STUDENT_NAME"));
					StudentVo vo = new StudentVo();
					vo.setStudentNo(rs.getString("Student_No"));
					vo.setDepartmentNo(rs.getString("Department_No"));
					vo.setStudentName(rs.getString("Student_Name"));
					vo.setStudentSsn(rs.getString("Student_Ssn"));
					vo.setStudentAddress(rs.getNString("Student_Address"));
					vo.setEntranceDate(rs.getDate("Entrance_Date"));
					vo.setAbsenceYn(rs.getString("Absence_Yn"));
					vo.setCoachProfessorNo(rs.getString("Coach_Professor_No"));

					result.add(vo);

				} while (rs.next() == true);
			}
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dmbs 에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();

				if (stmt != null)
					stmt.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

//확인용		System.out.println(result);
		return result;
	}

//DB에서 tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent(String searchWord) {
		List<StudentVo> result = null;
//	String query ="select *from tb_student where tb_student where student_name like '%?% ' or student_address like '%?%'";
		String query = "select * from tb_student where student_name like ? or student_address like ? ";
//		String query ="select *from tb_student where tb_student where student_name like '% "+searchWord+"% ' or student_address like '%"+searchWord+"%'";

		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null; // 부모
		PreparedStatement pstmt = null; // 자식 (PreparedStatement을 더 많이 씀)
		try {
			// 1. driver 있다면 로딩함.// 없다면 ClassNotFoundException e 오류발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성 (dbms와 연결)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "KH", "kh");

			if (conn != null) {
				System.out.println("DB연결 성공!!!!!!!!");
			} else {
				System.out.println("-----DB연결 실패-----");
			}
//			3. Statement /PrepareStatement 객체 생성 -conn 객체로부터 -query 문을 실어보냄
//			 stmt = conn.createStatement();

			pstmt = conn.prepareStatement(query);
			// 3-4사이에 위치홀더 ? 에 값 설정
			searchWord = "%" + searchWord + "%";
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
//			 4. query 문을 실행해달라고 함. - 그 결과값을 return 받음
//			 select query 문이면 ResultSet 모양
//			 insert/update/delete 문이면 int 모양
			rs = pstmt.executeQuery();
			// 5. ResultSet 에서 row(record) =한줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<StudentVo>();
			while (rs.next() == true) {
				// 한줄 row / record 를 읽을 준비 완료
				// System.out.println(rs.getString("STUDENT_NAME"));
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				;
				vo.setDepartmentNo(rs.getString("Department_No"));
				vo.setStudentName(rs.getString("Student_Name"));
				vo.setStudentSsn(rs.getString("Student_Ssn"));
				vo.setStudentAddress(rs.getNString("Student_Address"));
				vo.setEntranceDate(rs.getDate("Entrance_Date"));
				vo.setAbsenceYn(rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo(rs.getString("Coach_Professor_No"));

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dmbs 에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//확인용		System.out.println(result);
		return result;
	}

}

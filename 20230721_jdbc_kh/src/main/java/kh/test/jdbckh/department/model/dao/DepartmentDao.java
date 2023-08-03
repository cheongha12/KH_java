package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import kh.test.jdbckh.department.model.dto.DepartmentDto;
import static kh.test.jdbc.common.jdbc.JdbcTemplate.close;
public class DepartmentDao {
	
	//기본 5개
	//모든행 읽기
	
	public List<DepartmentDto> selectList(Connection conn){
		System.out.println("[Dept Dao selectList]");
		String query="select DEPARTMENT_NO, DEPARTMENT_NAME,CATEGORY,OPEN_YN,CAPACITY from tb_department";
		List<DepartmentDto> result = null;
		PreparedStatement pstmt = null;
		System.out.println("[Dept Dao selectList] return");
		return result;
		
		
	}
	//한행읽기 selectone pk로 where 조건
	
	public DepartmentDto selectOne(Connection conn, String departmentNo) {
		System.out.println("[Dept Dao selectOne] depatrmentNo: "+departmentNo);
		DepartmentDto result = null;
		String query = "select DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY from tb_Department"
						+"where Department_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,departmentNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentDto(rs.getString("DEPARTMENT_NO"),
								rs.getString("DEPARTMENT_NAME"),
								rs.getString("CATEGORY"),
								rs.getString("OPNE_YN"),
								rs.getInt("CAPACITY"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(rs);
			close(pstmt);
		}
		System.out.println("[Dept Dao selecOne] return :"+result);
		return result;
	}
//	한행 삽입
	public int insert (Connection conn, DepartmentDto dto) {
		System.out.println("[Dept Dao insert]dto:"+dto);
		int result=0;
		System.out.println("[Dept Dao insert]return:"+result);
		return result;
	}
	//한행 수정
	public int update(Connection conn,DepartmentDto dto) {
		System.out.println("[Dept Dao update] dto :" +dto);
		int result=0;
		//TODO
		System.out.println("[Dept dao update]dto:"+dto);
		return result;
	}
	//한생 삭제 - 주로 PK로 where 조건
	public int delete(Connection conn, DepartmentDto dto) {
		System.out.println("[Dept Dao delete] dto:" +dto);
		int result =0;
		//TODO
		System.out.println("[Dept Dao delete] dto"+dto);
		return result;
	}
}

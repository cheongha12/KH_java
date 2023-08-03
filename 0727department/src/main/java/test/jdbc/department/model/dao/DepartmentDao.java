package test.jdbc.department.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import test.jdbc.department.model.vo.DepartmentVo;

public class DepartmentDao {
	
	
	//모든행 읽기
	
	public List<DepartmentVo>selectList(Connection conn){
		System.out.println("[Dept Dao selectList]");
		List<DepartmentVo> result = null;
		//TODO
		
		System.out.println("[Dept Dao selectList] return :" +result);
		return result;
	}
	//한행읽기- pk로 where 조건
	public DepartmentVo selectOne(Connection conn, String departmentNo) {
		System.out.println("[Dept Dao selectOne] departmentNo:"+ departmentNo);
		DepartmentVo result= null;
		//TODO
		System.out.println("[Dept Dao selectOne] return:"+result);
		return result;
		
	}
	//한행 삽입- DepartmentVo 자료형을 받아와야함.
	public int insert(Connection conn, DepartmentVo vo) {
		System.out.println("[Dept Dao insert]vo:" +vo);
		int result=0;
		//TODO
		System.out.println("Dept Dao update] return:"+result);
		return result;
	}
	//한행삭제 - 주로 pk로 where 조건
	public int delete(Connection conn, String departmentNo) {
		System.out.println("[Dept Dao delete] departmentNo:"+departmentNo);
		int result= 0;
		//TODO
		System.out.println("[Dept Dao delete] return:"+result);
		return result;
	}
	
	//추가
	//페이징 처리 (pagesize!=0아닐때)+검색(있다면 where처리)
	public int getTotalCount(Connection conn, String searchWord) {
		System.out.println("[Dept Dao getTotalCount] searchWord:"+searchWord);
		int result=0;
		String query = "select count(*)cnt from tb_student";
		if(searchWord != null) {//검색(있다면 where 처리)
			query += " where DEPARTMENT_NAME like ? or DEPARTMENT_NAME like? or CATEGORY like ?";
			searchWord = "%"+searchWord+"%";
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			if(searchWord != null) {//검색 (있다면 where 처리)
				pstmt.setString(1,  searchWord);
				pstmt.setString(2,  searchWord);
				pstmt.setString(3,  searchWord);								
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result= rs.getInt("cnt");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[Dept Dao getTotalCount] return:"+ result);
		return result;
	}
//	public List<DepartmentVo> selectList(Connection conn, int currentPage, int pageSize, int totalCount, String searchWord){
//		System.out.println("[Dept Dao selectList] currentPage: "+ currentPage+", pageSize: "+pageSize+",totalCount: "+totalCount+", searchWord: "+searchWord);
//	}
}

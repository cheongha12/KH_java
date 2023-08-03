package kh.test.jdbckh.department.service;

import java.sql.Connection;
import java.util.List;

import static kh.test.jdbc.common.jdbc.JdbcTemplate.*;

import kh.test.jdbckh.department.model.dao.DepartmentDao;
import kh.test.jdbckh.department.model.dto.DepartmentDto;

public class DepartmentService {
	private DepartmentDao dao = new DepartmentDao();
	
	public List<DepartmentDto> selectList(){
		   List<DepartmentDto> result = null;
		   Connection conn = getConnection();
		   result= dao.selectList(conn);
		   close(conn);
		   return result;
	}
	public DepartmentDto selectOne(String deaprtmentNo) {
		DepartmentDto result = null;
		Connection conn = getConnection();
		result= dao.selectOne(conn, deaprtmentNo);
		close(conn);
		return result;
	}
	public int update (DepartmentDto dto) {
		int result=0;
		Connection conn = getConnection();
		result= dao.update(conn,dto);
		close(conn);
		return result;
	}
	public int delete(String departmentNo) {
		int result=0;
		Connection conn = getConnection();
		result = dao.delete(conn,departmentNo);
		close(conn);
		return result;
	}
	//페이징 처리
	public int getTotalCount(String searchWord) {
		int result =0;
		Connection conn = getConnection();
		result = dao.getTotalCount(conn,searchWord);
		close(conn);
		return result;
	}
	public List<DepartmentDto> selectList(int currentPage,int pageSize,String searchWord){
		List<DepartmentDto> result= null;
		Connection conn = getConnection();
		int totalCount = getTotalCount(searchWord);
		result= dao.selecetList(conn, currentPage, pageSize, totalCount,searchWord);
		close(conn);
		return result;
	
	}
}

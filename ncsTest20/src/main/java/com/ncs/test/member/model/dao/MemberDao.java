package com.ncs.test.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	public Member loginMember(Member vo) {
		return sqlSession.selectOne("member.loginMember", vo);
	}
	public List<Member> loginMember(){
		return sqlSession.selectList("member.loginMember");
	}
	public int insert(Member vo) {
		return sqlSession.insert("member.loginMember",vo);
	}
	public int update(Member vo) {
		return sqlSession.update("member.loginMember", vo);
	}
	public int delete(String memberPwd) {
		return sqlSession.delete("member.loginMmeber", memberPwd);
	}
}

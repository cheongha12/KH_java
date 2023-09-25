package com.ncs.test.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDao;
import com.ncs.test.member.model.vo.Member;

@Service("memberServiceImpl")
public class MemberServiceImpl implements  MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member loginMember(Member vo) {
		return memberDao.loginMember(vo);
	}
	@Override
	public List<Member> loginMember(){
		return memberDao.loginMember();
	}
	@Override
	public int insert(Member vo) {
		return memberDao.insert(vo);
	}
	@Override
	public int update(Member vo) {
		return memberDao.update(vo);
	}
	@Override
	public int delete(String memberPwd) {
		return memberDao.delete(memberPwd);
	}

}

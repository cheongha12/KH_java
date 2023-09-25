package com.ncs.test.member.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.test.member.model.vo.Member;


public interface MemberService {

	public Member loginMember(Member vo);
	public List<Member> loginMember();
	public int insert(Member vo);
	public int update(Member vo);
	public int delete(String memberPwd);
}

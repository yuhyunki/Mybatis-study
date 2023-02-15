package com.greedy.member.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.greedy.common.Template.getSqlSession;

import java.util.List;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;

public class MemberService {
	
	private final MemberDAO memberDAO;
	
	public MemberService() {
		this.memberDAO = new MemberDAO();
	}

	public boolean registNewMember(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		
		int result = memberDAO.insertNewMember(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	public List<MemberDTO> findAllMembers() {

		SqlSession sqlSession = getSqlSession();
		
		List<MemberDTO> memberList = memberDAO.selectMemberList(sqlSession);
		
		sqlSession.close();
		
		return memberList;
	}

}

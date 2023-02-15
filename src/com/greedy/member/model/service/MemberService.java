package com.greedy.member.model.service;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import static com.greedy.common.Template.getSqlSession;

import java.util.List;
import java.util.Map;

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

	public MemberDTO findMemberById(String id) {

		SqlSession sqlSession = getSqlSession();

		MemberDTO member = memberDAO.selectMemberById(sqlSession, id);

		return member;
	}

	public List<MemberDTO> findMemberByGender(String gender) {

		SqlSession sqlSession = getSqlSession();

		List<MemberDTO> memberList = memberDAO.selectMemberByGender(sqlSession, gender);

		return memberList;
	}

	public boolean modifyPassword(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();

		int result = memberDAO.updatePassword(sqlSession, member);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0? true: false;
	}

	public boolean modifyEmail(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();

		int result = memberDAO.updateEmail(sqlSession, member);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0? true: false;
	}

	public boolean modifyPhone(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();

		int result = memberDAO.updatePhone(sqlSession, member);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0? true: false;
	}

	public boolean modifyAddress(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();

		int result = memberDAO.updateAddress(sqlSession, member);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0? true: false;
	}

	public boolean deleteMember(String memberId) {

		SqlSession sqlSession = getSqlSession();

		int result = memberDAO.deleteMember(sqlSession, memberId);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0? true: false;
	}

}

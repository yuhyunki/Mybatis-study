package com.greedy.section02.member.service;

import org.apache.ibatis.session.SqlSession;

import com.greedy.section02.member.model.MemberDTO;
import com.greedy.section02.member.model.MemberMapper;

import static com.greedy.section02.common.Template.getSqlSession;

import java.util.List;

public class MemberService {

	public boolean registNewMember(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int result = memberMapper.insertMember(member);

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

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

		List<MemberDTO> memberList = memberMapper.selectAllMember();

		sqlSession.close();

		return memberList;
	}

	public MemberDTO findMemberById(String id) {

		SqlSession sqlSession = getSqlSession();

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

		MemberDTO member = memberMapper.selectMemberById(id);

		sqlSession.close();

		return member;
	}

	public List<MemberDTO> findMemberByGender(String gender) {

		SqlSession sqlSession = getSqlSession();

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

		List<MemberDTO> memberList = memberMapper.selectMemberByGender(gender);

		sqlSession.close();

		return memberList;
	}

	public boolean modifyPassword(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int result = memberMapper.updatePassword(member);

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

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int result = memberMapper.updateEmail(member);

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

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int result = memberMapper.updatePhone(member);

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

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int result = memberMapper.updateAddress(member);

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

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int result = memberMapper.deleteMember(memberId);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result > 0? true: false;
	}

}

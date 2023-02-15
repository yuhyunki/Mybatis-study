package com.greedy.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {

	public int insertNewMember(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.insert("MemberMapper.insertMember", member);
	}

	public List<MemberDTO> selectMemberList(SqlSession sqlSession) {

		return sqlSession.selectList("MemberMapper.selectAllMember");
	}

	public MemberDTO selectMemberById(SqlSession sqlSession, String id) {

		return sqlSession.selectOne("MemberMapper.selectMemberById", id);
	}

	public List<MemberDTO> selectMemberByGender(SqlSession sqlSession, String gender) {

		return sqlSession.selectList("MemberMapper.selectMemberByGender", gender);
	}

	public int updatePassword(SqlSession sqlSession, MemberDTO member) {
		
		return sqlSession.update("MemberMapper.updatePassword", member);
	}

	public int updateEmail(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.update("MemberMapper.updateEmail", member);
	}

	public int updatePhone(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.update("MemberMapper.updatePhone", member);
	}

	public int updateAddress(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.update("MemberMapper.updateAddress", member);
	}

	public int deleteMember(SqlSession sqlSession, String memberId) {
		
		return sqlSession.delete("MemberMapper.deleteMember", memberId);
	}

}

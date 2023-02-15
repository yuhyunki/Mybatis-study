package com.greedy.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {

	public int insertNewMember(SqlSession sqlSession, MemberDTO member) {

		return sqlSession.insert("MemberMapper.insertMember", member);
	}

}

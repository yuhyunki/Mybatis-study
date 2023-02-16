package com.greedy.section02.member.model;

import java.util.List;

public interface MemberMapper {

	int insertMember(MemberDTO member);

	List<MemberDTO> selectAllMember();

	MemberDTO selectMemberById(String id);

	List<MemberDTO> selectMemberByGender(String gender);

	int updatePassword(MemberDTO member);

	int updateEmail(MemberDTO member);

	int updatePhone(MemberDTO member);

	int updateAddress(MemberDTO member);

	int deleteMember(String memberId);

}

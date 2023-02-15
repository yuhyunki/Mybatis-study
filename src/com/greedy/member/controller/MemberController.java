package com.greedy.member.controller;

import java.util.Map;

import com.greedy.member.model.dto.MemberDTO;
import com.greedy.member.model.service.MemberService;
import com.greedy.member.views.MemberResultView;

public class MemberController {
	
	private MemberResultView memberResultView = new MemberResultView();
	private MemberService memberService = new MemberService();

	public void registNewMember(Map<String, String> parameter) {

		MemberDTO member = new MemberDTO();
		member.setMemberId(parameter.get("memberId"));
		member.setMemberPwd(parameter.get("memberPwd"));
		member.setMemberName(parameter.get("memberName"));
		member.setGender(parameter.get("gender"));
		member.setEmail(parameter.get("email"));
		member.setPhone(parameter.get("phone"));
		member.setAddress(parameter.get("address"));
		member.setAge(Integer.parseInt(parameter.get("age")));
		member.setMemberId(parameter.get("memberId"));
		
		if(memberService.registNewMember(member)) {
			memberResultView.displayDmlResult("insertSuccess");
		} else {
			memberResultView.displayDmlResult("insertFailed");
		}
		
	}

}

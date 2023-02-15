package com.greedy.member.controller;

import java.util.List;
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

	public void selectAllMembers() {

		List<MemberDTO> memberList = memberService.findAllMembers();

		if(memberList != null) {
			memberResultView.display(memberList);
		} else {
			memberResultView.displayDmlResult("selectFailed");
		}

	}

	public void searchMemberById(Map<String, String> parameter) {

		String id = parameter.get("memberId");

		MemberDTO member = memberService.findMemberById(id);

		if(member != null) {
			memberResultView.display(member);
		} else {
			memberResultView.displayDmlResult("selectFailed");
		}

	}

	public void searchMemberByGender(Map<String, String> parameter) {

		String gender = parameter.get("gender");

		List<MemberDTO> memberList = memberService.findMemberByGender(gender);

		if(memberList != null) {
			memberResultView.display(memberList);
		} else {
			memberResultView.displayDmlResult("selectFailed");
		}

	}

	public void modifyPassword(Map<String, String> parameterId, Map<String, String> parameterPwd) {

		String memberId = parameterId.get("memberId");
		String memberPwd = parameterPwd.get("memberPwd");
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		
		if(memberService.modifyPassword(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}

	public void modifyEmail(Map<String, String> inputMemberId, Map<String, String> inputEmail) {

		String memberId = inputMemberId.get("memberId");
		String email = inputEmail.get("email");
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setEmail(email);
		
		if(memberService.modifyEmail(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}

	public void modifyPhone(Map<String, String> inputMemberId, Map<String, String> inputPhone) {

		String memberId = inputMemberId.get("memberId");
		String phone = inputPhone.get("phone");
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setPhone(phone);
		
		if(memberService.modifyPhone(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}

	public void modifyAddress(Map<String, String> inputMemberId, Map<String, String> inputAddress) {

		String memberId = inputMemberId.get("memberId");
		String address = inputAddress.get("address");
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setPhone(address);
		
		if(memberService.modifyAddress(member)) {
			memberResultView.displayDmlResult("updateSuccess");
		} else {
			memberResultView.displayDmlResult("updateFailed");
		}
		
	}

	public void deleteMember(Map<String, String> inputMemberId) {

		String memberId = inputMemberId.get("memberId");
		
		if(memberService.deleteMember(memberId)) {
			memberResultView.displayDmlResult("deleteSuccess");
		} else {
			memberResultView.displayDmlResult("deleteFailed");
		}
		
	}

}

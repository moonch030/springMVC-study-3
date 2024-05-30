package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;

//	@RequestMapping("/createAccountForm")	
//	@RequestMapping(value="/createAccountForm",method=RequestMethod.GET)
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("--- AdminMemberController의 createAccountForm() 호출 ---");
		String nextPage = "admin/member/create_account_form";
		return nextPage;
	}
	
//	@RequestMapping(value="/createAccountConfirm",method=RequestMethod.POST)
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("--- AdminMemberController의 createAccountConfirm() 호출 ---");
		String nextPage = "admin/member/create_account_ok";
		adminMemberService.createAccountConfirm(adminMemberVo);
		return nextPage;
	}
}

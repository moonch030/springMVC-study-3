package com.office.library.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

//	@RequestMapping("/createAccountForm")	
//	@RequestMapping(value="/createAccountForm",method=RequestMethod.GET)
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("--- AdminMemberController의 createAccountForm() 호출 ---");
		String nextPage = "admin/member/create_account_form";
		return nextPage;
	}
	
	@RequestMapping(value="/createAccountConfirm",method=RequestMethod.POST)
	public String createAccountConfirm() {
		System.out.println("--- AdminMemberController의 createAccountConfirm() 호출 ---");
		String nextPage = "admin/member/create_account_ok";
		return nextPage;
	}
}

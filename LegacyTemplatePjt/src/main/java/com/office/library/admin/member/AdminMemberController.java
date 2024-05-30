package com.office.library.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@RequestMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("--- AdminMemberController의 createAccountForm메서드 ---");
		String nextPage = "admin/member/create_account_form";
		return nextPage;
	}
}

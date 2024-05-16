package com.company.hello.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		System.out.println("MemberController의 home()메서드");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/signUp")
	public String signup() {
		return "sign_up";
	}
	
	@RequestMapping("/signIn")
	public String signin() {
		return "sign_in";
	}
	
	@RequestMapping("/signUpConfirm")
	public String signUpConfirm(MemberVo memberVo) {
		System.out.println("signUpConfirm() 메서드 호출");
		System.out.println("입력한 id = "+memberVo.getM_id());
		System.out.println("입력한 pw = "+memberVo.getM_pw());
		System.out.println("입력한 mail = "+memberVo.getM_mail());
		System.out.println("입력한 phone = "+memberVo.getM_phone());
		return "result";
	}

}

package com.company.hello.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("MemberController의 home()메서드");
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

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

	//MemberService 객체 생성
//	MemberService memberService = new MemberService();
	
	
	//MemberService 자바 빈 객체(servlet-context.xml에서 <beans:bean id="memberService" class="com.company.hello.member.MemberService"/> 설정 해줌)
	@Autowired //의존관계 자동 주입
	MemberService memberService;
	
	 // MemberVo 객체 사용 
	 @RequestMapping("/signUpConfirm") public String signUpConfirm(MemberVo memberVo) { 
		 System.out.println("--MemberController signUpConfirm() 메서드 호출--");
		 
		 System.out.println("입력한 id = "+memberVo.getM_id());
		 System.out.println("입력한 pw = "+memberVo.getM_pw());
		 System.out.println("입력한 mail = "+memberVo.getM_mail());
		 System.out.println("입력한 phone = "+memberVo.getM_phone());
		 
		 memberService.signUpConfirm(memberVo);
		 
		 return "result"; 
	}
	 

//	// RequestParam 사용 MemberVo를 안거침
//	@RequestMapping("/signUpConfirm")
//	public String signUpConfirm(@RequestParam String m_id, @RequestParam String m_pw, @RequestParam String m_mail,
//			@RequestParam String m_phone) {
//		System.out.println("signUpConfirm() 메서드 호출");
//		System.out.println("입력한 id = " + m_id);
//		System.out.println("입력한 pw = " + m_pw);
//		System.out.println("입력한 mail = " + m_mail);
//		System.out.println("입력한 phone = " + m_phone);
//		return "result";
//	}

}

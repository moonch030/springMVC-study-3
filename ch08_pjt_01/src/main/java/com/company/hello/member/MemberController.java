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
	
	
	@RequestMapping("/signup")
	public String signup() {
		return "sign_up";
	}
	
	@RequestMapping("/signin")
	public String signin() {
		return "sign_in";
	}

}

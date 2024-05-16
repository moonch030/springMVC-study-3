package com.company.hello.member;

public class MemberService {
	
	
	public int signUpConfirm(MemberVo memberVo) {
		 System.out.println("--MemberService signUpConfirm() 메서드 호출--");
		 System.out.println("inserted 아이디=" +
	               memberVo.getM_id() );
	      System.out.println("inserted 암호=" +
	               memberVo.getM_pw() ) ;
	      System.out.println("inserted 메일주소=" +
	               memberVo.getM_mail() );
	      System.out.println("inserted 전화번호=" +
	               memberVo.getM_phone() );
		return 0;
	}

}

package com.company.hello.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //얘 대신에 아래 @Component, @Repository사용 가능! 얘를 사용하면 xml에 빈객체 생성 안해도됨. 얘랑 Autowired만 사용 하면 됨.
//@Component
//@Repository
public class MemberService {
	
	@Autowired //servlet-context.xml 스프링 컨테이너에 등록 해 자동 주입	
	MemberDao memberDao;
	
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
	      
	      memberDao.insertMember(memberVo);
	      
		return 0;
	}//end of signUpConfirm()
	
	
	
	public MemberVo signInConfirm(MemberVo memberVo) {		
		System.out.println("-- MemberService의 signInConfirm() 메서드 호출 --");
		
		System.out.println("전송된 id = "+memberVo.getM_id());
		System.out.println("전송된 pw = "+memberVo.getM_pw());
		
		MemberVo loginedMem = memberDao.selectMember(memberVo);
		
		return loginedMem;
	}
}

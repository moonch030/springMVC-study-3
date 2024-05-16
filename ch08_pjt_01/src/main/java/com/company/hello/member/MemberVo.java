package com.company.hello.member;

public class MemberVo {

	public String m_id;
	public String m_pw;
	public String m_mail;
	public String m_phone;
	
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
		System.out.println("--MemberVo set메서드들 호출 시작~--");
		System.out.println("setM_id 메서드 호출");
	}
	
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
		System.out.println("setM_pw 메서드 호출");
	}
	
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
		System.out.println("setM_mail 메서드 호출");
	}
	
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
		System.out.println("setM_phone 메서드 호출");
	}
}

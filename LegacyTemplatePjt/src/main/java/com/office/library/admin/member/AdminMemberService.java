package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberService {
	
	@Autowired
	AdminMemberDao adminMemberDao;
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;
	
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("--- AdminMemberService의 createAccountConfirm() 호출 ---");
		adminMemberDao.isAdminMember(adminMemberVo.getA_m_id());
		return null;
	}
}

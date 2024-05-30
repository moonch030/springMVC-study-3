package com.office.library.admin.member;

import org.springframework.stereotype.Component;

@Component //@Repository도 가능
public class AdminMemberDao {
	
	public boolean isAdminMember(String a_m_id) {
		System.out.println("--- AdminMemberDao의 isAdminMember() 호출됨 ---");
		return true;
	}
}

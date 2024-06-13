package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component //@Repository도 가능
public class AdminMemberDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean isAdminMember(String a_m_id) {
		System.out.println("--- AdminMemberDao의 isAdminMember() 호출됨 ---");
		//중복 아이디 check
		String sql = "select count(*) from tbl_admin_member "
					 + "where a_m_id = ?";
		int result = jdbcTemplate.queryForObject(sql,Integer.class,a_m_id);
		
		return true;
	}
}

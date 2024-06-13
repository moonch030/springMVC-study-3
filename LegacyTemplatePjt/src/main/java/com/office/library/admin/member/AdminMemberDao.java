package com.office.library.admin.member;

import java.util.ArrayList;
import java.util.List;

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
		
		//sql : SQL문 , Integer.class : 쿼리 실행후 반환되는 데이터 타입,
	    //a_m_id : 관리자가 입력한 아이디로서 매개변수에 있는 String a_m_id를 가져옴.
	    //queryForObject()가 1을 반환한다면 관리자가 입력한 아이디는 이미 사용중인
	    //아이디로 회원가입을 할 수 없고, 0이면 사용중인 아이디가 아니므로 회원가입이 가능합니다.
		
		/*
		 * if(result>0) { return true; } else { return false; }
		 */
		
		return result > 0? true : false;
	}
	
	public int insertAdminAccount(AdminMemberVo adminMemberVo) {
		System.out.println(
				   "[AdminMemberDao] insertAdminAccount()");
				      
				      List<String> args = new ArrayList<String>();
				      
				      String sql =  "INSERT INTO tbl_admin_member(";
				      
				            if (adminMemberVo.getA_m_id().equals(
				                  "super admin")) {
				               sql += "a_m_approval, ";
				               args.add("1");
				            }
				            
				            sql += "a_m_id, ";
				            args.add(adminMemberVo.getA_m_id());
				            
				            sql += "a_m_pw, ";
				            args.add(adminMemberVo.getA_m_pw() );
//				            args.add(passwordEncoder.encode(
//				                  adminMemberVo.getA_m_pw()));
			            
				            sql += "a_m_name, ";
				            args.add(adminMemberVo.getA_m_name());
				            
				            sql += "a_m_gender, ";
				            args.add(adminMemberVo.getA_m_gender());
				            
				            sql += "a_m_part, ";
				            args.add(adminMemberVo.getA_m_part());
				            
				            sql += "a_m_position, ";
				            args.add(adminMemberVo.getA_m_position());
				            
				            sql += "a_m_mail, ";
				            args.add(adminMemberVo.getA_m_mail());
				            
				            sql += "a_m_phone, ";
				            args.add(adminMemberVo.getA_m_phone());
				            
				            sql += "a_m_reg_date, a_m_mod_date) ";
				            
				            if (adminMemberVo.getA_m_id().equals("super admin")) 
				               sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
				            else 
				               sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
				            
				      int result = -1;
				      
				      try {
				         
				         result = jdbcTemplate.update(sql, args.toArray());
				         
				      } catch (Exception e) {
				         e.printStackTrace();
				         
				      }
				      
				      return result;
	}
}

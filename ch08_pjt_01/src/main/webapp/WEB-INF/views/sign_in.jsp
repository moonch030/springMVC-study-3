<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>sign in</title>
</head>
<body>
<h1>sign_in.jsp</h1>
	<form action="/member/signInConfirm">
      ID : <input type="text" name="m_id" ><br/>  
      PW : <input type="password" name="m_pw" ><br/>  
      <input type="submit" value="SIGN IN">  
      <input type="reset" value="CANCEL">  
   </form>
</body>
</html>
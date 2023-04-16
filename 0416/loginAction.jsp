<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO"%>
<%@ page import="user.UserDTO"%>
<%
	String userId=request.getParameter("user_id");
	String userPw=request.getParameter("user_pw");
	
	String oracleDriver=application.getInitParameter("OracleDriver");
	String oracleUrl=application.getInitParameter("OracleUrl");
	String oracleId=application.getInitParameter("OracleId");
	String oraclePw=application.getInitParameter("OraclePw");
	UserDAO dao = new UserDAO(oracleDriver, oracleUrl, oracleId, oraclePw);
	UserDTO UserDTO = dao.getUser(userId, userPw);
	dao.close();
	
	if(UserDTO.getUserID()!=null){
		session.setAttribute("UserID", UserDTO.getUserID());
		session.setAttribute("UserName", UserDTO.getUserName());
		response.sendRedirect("login.jsp");
	}else{
		request.setAttribute("loginErrMsg", "로그인 오류입니다.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

%>